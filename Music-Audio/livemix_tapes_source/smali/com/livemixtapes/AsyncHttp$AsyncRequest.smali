.class abstract Lcom/livemixtapes/AsyncHttp$AsyncRequest;
.super Landroid/os/AsyncTask;
.source "AsyncHttp.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/AsyncHttp;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x40a
    name = "AsyncRequest"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Lcom/livemixtapes/AsyncHttp$HttpResponseData;",
        ">;"
    }
.end annotation


# instance fields
.field protected final callback:Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;

.field protected final json:Ljava/lang/Boolean;

.field protected final params:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected final url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
    .param p4, "json"    # Ljava/lang/Boolean;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;",
            "Ljava/lang/Boolean;",
            ")V"
        }
    .end annotation

    .prologue
    .line 59
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 60
    iput-object p1, p0, Lcom/livemixtapes/AsyncHttp$AsyncRequest;->url:Ljava/lang/String;

    .line 61
    iput-object p2, p0, Lcom/livemixtapes/AsyncHttp$AsyncRequest;->params:Ljava/util/Map;

    .line 62
    iput-object p3, p0, Lcom/livemixtapes/AsyncHttp$AsyncRequest;->callback:Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;

    .line 63
    iput-object p4, p0, Lcom/livemixtapes/AsyncHttp$AsyncRequest;->json:Ljava/lang/Boolean;

    .line 64
    return-void
.end method


# virtual methods
.method protected varargs abstract doInBackground([Ljava/lang/Void;)Lcom/livemixtapes/AsyncHttp$HttpResponseData;
.end method

.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/AsyncHttp$AsyncRequest;->doInBackground([Ljava/lang/Void;)Lcom/livemixtapes/AsyncHttp$HttpResponseData;

    move-result-object v0

    return-object v0
.end method

.method protected getDataResponse(Lorg/apache/http/HttpResponse;)Lcom/livemixtapes/AsyncHttp$HttpResponseData;
    .locals 3
    .param p1, "response"    # Lorg/apache/http/HttpResponse;

    .prologue
    .line 100
    new-instance v0, Lcom/livemixtapes/AsyncHttp$HttpResponseData;

    const/4 v2, 0x0

    invoke-direct {v0, v2}, Lcom/livemixtapes/AsyncHttp$HttpResponseData;-><init>(Lcom/livemixtapes/AsyncHttp$HttpResponseData;)V

    .line 102
    .local v0, "data":Lcom/livemixtapes/AsyncHttp$HttpResponseData;
    invoke-interface {p1}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v1

    .line 104
    .local v1, "statusLine":Lorg/apache/http/StatusLine;
    invoke-interface {p1}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/livemixtapes/AsyncHttp$AsyncRequest;->readEntity(Lorg/apache/http/HttpEntity;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/livemixtapes/AsyncHttp$HttpResponseData;->data:Ljava/lang/String;

    .line 105
    invoke-interface {v1}, Lorg/apache/http/StatusLine;->getReasonPhrase()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/livemixtapes/AsyncHttp$HttpResponseData;->reasonPhrase:Ljava/lang/String;

    .line 106
    invoke-interface {v1}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v2

    iput v2, v0, Lcom/livemixtapes/AsyncHttp$HttpResponseData;->statusCode:I

    .line 108
    return-object v0
.end method

.method protected getExceptionResponse(Ljava/lang/Exception;)Lcom/livemixtapes/AsyncHttp$HttpResponseData;
    .locals 2
    .param p1, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 94
    new-instance v0, Lcom/livemixtapes/AsyncHttp$HttpResponseData;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/livemixtapes/AsyncHttp$HttpResponseData;-><init>(Lcom/livemixtapes/AsyncHttp$HttpResponseData;)V

    .line 95
    .local v0, "response":Lcom/livemixtapes/AsyncHttp$HttpResponseData;
    iput-object p1, v0, Lcom/livemixtapes/AsyncHttp$HttpResponseData;->exception:Ljava/lang/Exception;

    .line 96
    return-object v0
.end method

.method protected onPostExecute(Lcom/livemixtapes/AsyncHttp$HttpResponseData;)V
    .locals 4
    .param p1, "response"    # Lcom/livemixtapes/AsyncHttp$HttpResponseData;

    .prologue
    .line 71
    iget-object v0, p0, Lcom/livemixtapes/AsyncHttp$AsyncRequest;->callback:Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;

    if-nez v0, :cond_0

    .line 82
    :goto_0
    return-void

    .line 74
    :cond_0
    iget-object v0, p1, Lcom/livemixtapes/AsyncHttp$HttpResponseData;->exception:Ljava/lang/Exception;

    if-eqz v0, :cond_1

    .line 75
    iget-object v0, p0, Lcom/livemixtapes/AsyncHttp$AsyncRequest;->callback:Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;

    iget-object v1, p1, Lcom/livemixtapes/AsyncHttp$HttpResponseData;->exception:Ljava/lang/Exception;

    invoke-virtual {v0, v1}, Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;->exception(Ljava/lang/Exception;)V

    .line 81
    :goto_1
    iget-object v0, p0, Lcom/livemixtapes/AsyncHttp$AsyncRequest;->callback:Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;

    invoke-virtual {v0}, Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;->always()V

    goto :goto_0

    .line 78
    :cond_1
    iget-object v0, p0, Lcom/livemixtapes/AsyncHttp$AsyncRequest;->callback:Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;

    iget-object v1, p1, Lcom/livemixtapes/AsyncHttp$HttpResponseData;->data:Ljava/lang/String;

    iget-object v2, p1, Lcom/livemixtapes/AsyncHttp$HttpResponseData;->reasonPhrase:Ljava/lang/String;

    iget v3, p1, Lcom/livemixtapes/AsyncHttp$HttpResponseData;->statusCode:I

    invoke-virtual {v0, v1, v2, v3}, Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;->success(Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Lcom/livemixtapes/AsyncHttp$HttpResponseData;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/AsyncHttp$AsyncRequest;->onPostExecute(Lcom/livemixtapes/AsyncHttp$HttpResponseData;)V

    return-void
.end method

.method protected readEntity(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    .locals 1
    .param p1, "entity"    # Lorg/apache/http/HttpEntity;

    .prologue
    .line 86
    :try_start_0
    invoke-static {p1}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 90
    :goto_0
    return-object v0

    .line 87
    :catch_0
    move-exception v0

    .line 90
    const-string v0, ""

    goto :goto_0
.end method
