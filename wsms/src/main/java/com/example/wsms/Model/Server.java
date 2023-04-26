package com.example.wsms.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Server {

    private String name;
    private String ipAddress;
    private int port;
    private int n_open;
    private int n_close;
    private String rand_token;
    private String machine;
    private String version;
    private String platform;
    private String uname;
    private String system;
    private String proc;

    public Server(@JsonProperty("name") String name,@JsonProperty("ipAddress") String ipAddress,@JsonProperty("port") int port,@JsonProperty("n_open") int n_open,@JsonProperty("n_close") int n_close,@JsonProperty("rand_token") String rand_token,@JsonProperty("machine") String machine,@JsonProperty("version") String version,@JsonProperty("platform") String platform,@JsonProperty("uname") String uname,@JsonProperty("system") String system,@JsonProperty("proc") String proc) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.port = port;
        this.n_open = n_open;
        this.n_close = n_close;
        this.rand_token = rand_token;
        this.machine = machine;
        this.version = version;
        this.platform = platform;
        this.uname = uname;
        this.system = system;
        this.proc = proc;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getN_open() {
        return n_open;
    }

    public void setN_open(int n_open) {
        this.n_open = n_open;
    }

    public int getN_close() {
        return n_close;
    }

    public void setN_close(int n_close) {
        this.n_close = n_close;
    }

    public String getRand_token() {
        return rand_token;
    }

    public void setRand_token(String rand_token) {
        this.rand_token = rand_token;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getProc() {
        return proc;
    }

    public void setProc(String proc) {
        this.proc = proc;
    }
}

