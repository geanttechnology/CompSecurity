.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
.super Ljava/lang/Object;
.source "HttpClient.java"


# virtual methods
.method public abstract execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;
        }
    .end annotation
.end method

.method public abstract execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;
        }
    .end annotation
.end method

.method public abstract execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;
        }
    .end annotation
.end method

.method public abstract getConnectionManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
.end method

.method public abstract getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
.end method
