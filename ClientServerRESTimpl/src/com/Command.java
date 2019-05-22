package com;

public class Command {
    
    private RequestType typeRequest;
    
    private String clientName;
    private String url;
    private String info;
    
    public Command(RequestType type, String url, String info) {
        
        setTypeRequest( type );
        setUrl( url );
        setInfo( info );
    }
    
    public Command(String clientName, RequestType type, String url, String info) {
        
        this(type, url, info);
        this.clientName = clientName;
    }
    
    public RequestType getTypeRequest() {
        return typeRequest;
    }
    public void setTypeRequest(RequestType typeRequest) {
        this.typeRequest = typeRequest;
    }
    
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        
        Command command = (Command) obj;
        return typeRequest == command.typeRequest
            && url.equals( command.url );
    }

    @Override
    public int hashCode() {
        return (typeRequest == null ? 0 : typeRequest.hashCode())
             + (url == null ? 0 : url.hashCode() );
    }
    
}