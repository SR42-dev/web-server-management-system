package com.example.wsms.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import com.example.wsms.Model.Server;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*")
@RequestMapping("/server")
public class Controller {

    String baseURL="http://10.30.200.207:8080";

    @GetMapping("/lsa")
    public ResponseEntity<String> listServers()
    {
        /*RestTemplate restTemplate = new RestTemplate();
        String url = baseURL+"/lsa";
        String response=restTemplate.getForObject(url,String.class);*/
        String response = "{\"Command\":\"\\\"uvicorn main:app --…\\\"\",\"CreatedAt\":\"2023-04-26 14:59:07 +0530 IST\",\"ID\":\"dcc430bbb439\",\"Image\":\"server\",\"Labels\":\"\",\"LocalVolumes\":\"0\",\"Mounts\":\"\",\"Names\":\"rao\",\"Networks\":\"bridge\",\"Ports\":\"0.0.0.0:7060-\\u003e80/tcp, :::7060-\\u003e80/tcp\",\"RunningFor\":\"43 seconds ago\",\"Size\":\"0B\",\"State\":\"running\",\"Status\":\"Up 42 seconds\"}\n{\"Command\":\"\\\"uvicorn main:app --…\\\"\",\"CreatedAt\":\"2023-04-26 14:41:23 +0530 IST\",\"ID\":\"daf8ee7f9720\",\"Image\":\"server\",\"Labels\":\"\",\"LocalVolumes\":\"0\",\"Mounts\":\"\",\"Names\":\"ksjbvkfjbvkdf\",\"Networks\":\"bridge\",\"Ports\":\"0.0.0.0:8098-\\u003e80/tcp, :::8098-\\u003e80/tcp\",\"RunningFor\":\"18 minutes ago\",\"Size\":\"0B\",\"State\":\"running\",\"Status\":\"Up 18 minutes\"}\n";
        return ResponseEntity.ok(response);
    }

    //@GetMapping("/ls/{id}")
    //ResponseEntity<?>
    @GetMapping("/get/{name}")
    public ResponseEntity<String> serverConfig(@PathVariable String name)
    {
        /*RestTemplate restTemplate = new RestTemplate();
        String url = baseURL+"/get/"+name;
        String response = restTemplate.getForObject(url, String.class);*/
        //System.out.println(response);
        String response="";
        if(name=="rao")
            response="{\"ip\":\"172.17.0.3\",\"hostname\":\"dcc430bbb439\",\"number_open_conns\":1,\"number_closed_conns\":0,\"token\":\"7f1e6f64-cfa0-46bc-8567-a107709350be\",\"machine\":\"x86_64\",\"version\":\"#76~20.04.1-Ubuntu SMP Mon Mar 20 15:54:19 UTC 2023\",\"platform\":\"Linux-5.15.0-69-generic-x86_64-with-glibc2.2.5\",\"uname\":[\"Linux\",\"dcc430bbb439\",\"5.15.0-69-generic\",\"#76~20.04.1-Ubuntu SMP Mon Mar 20 15:54:19 UTC 2023\",\"x86_64\",\"\"],\"system\":\"Linux\",\"processor\":\"\"}";
        else {
            response="{\"ip\":\"172.17.0.2\",\"hostname\":\"daf8ee7f9720\",\"number_open_conns\":1,\"number_closed_conns\":0,\"token\":\"21f1871c-3163-4916-b840-929da9e212d3\",\"machine\":\"x86_64\",\"version\":\"#76~20.04.1-Ubuntu SMP Mon Mar 20 15:54:19 UTC 2023\",\"platform\":\"Linux-5.15.0-69-generic-x86_64-with-glibc2.2.5\",\"uname\":[\"Linux\",\"daf8ee7f9720\",\"5.15.0-69-generic\",\"#76~20.04.1-Ubuntu SMP Mon Mar 20 15:54:19 UTC 2023\",\"x86_64\",\"\"],\"system\":\"Linux\",\"processor\":\"\"}";
        }
        /*Server server=new Server("my server",
        "192.168.1.100",
        8080,1,0,
        "token123","server123",
        "1.0","Linux",
        "Linux server123 4.4.0-18362-Microsoft #1-Microsoft Wed Mar 06 19:16:00 PST 2021 x86_64 x86_64 x86_64 GNU/Linux",
        "Linux",
        "x86_64");*/
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create/{name}/{port}")
    public ResponseEntity<String> serverCreate(@PathVariable String name,@PathVariable int port)
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseURL+"/create/"+name+"/"+port;
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/start/{id}")
    public ResponseEntity<String> serverStart(@PathVariable String id)
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseURL+"/start/"+id;
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/stop/{id}")
    public ResponseEntity<String> serverStop(@PathVariable String id)
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseURL+"/stop/"+id;
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/kill/{id}")
    public ResponseEntity<String> serverKill(@PathVariable String id)
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseURL+"/kill/"+id;
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/change/{id}")
    public ResponseEntity<Server> serverChangeConfig(@PathVariable String id,@RequestBody Server server)
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseURL+"/change/{id}";
        Server response = restTemplate.postForObject(url,server, Server.class);
        System.out.println(response);
        return ResponseEntity.ok(response);
    }
}
