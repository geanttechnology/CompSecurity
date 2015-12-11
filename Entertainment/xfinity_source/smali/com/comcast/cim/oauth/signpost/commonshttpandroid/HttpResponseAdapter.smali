.class public Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpResponseAdapter;
.super Ljava/lang/Object;
.source "HttpResponseAdapter.java"


# instance fields
.field private response:Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;


# virtual methods
.method public getContent()Ljava/io/InputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 17
    iget-object v0, p0, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpResponseAdapter;->response:Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getReasonPhrase()Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 25
    iget-object v0, p0, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpResponseAdapter;->response:Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getReasonPhrase()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getStatusCode()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 21
    iget-object v0, p0, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpResponseAdapter;->response:Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v0

    return v0
.end method
