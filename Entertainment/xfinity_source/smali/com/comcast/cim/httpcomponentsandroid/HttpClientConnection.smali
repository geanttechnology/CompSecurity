.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/HttpClientConnection;
.super Ljava/lang/Object;
.source "HttpClientConnection.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpConnection;


# virtual methods
.method public abstract flush()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract isResponseAvailable(I)Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract receiveResponseEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract receiveResponseHeader()Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract sendRequestEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract sendRequestHeader(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation
.end method
