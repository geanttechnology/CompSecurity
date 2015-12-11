.class Lcom/inc247/ChatSDKAgentAvailibilityHelper;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/inc247/ChatSDKAgentAvailibilityHelper;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 33
    const/4 v0, 0x0

    aget-object v1, p1, v0

    .line 35
    const/4 v0, 0x0

    .line 37
    :try_start_0
    new-instance v2, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v2}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>()V

    .line 38
    new-instance v3, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {v3, v1}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    invoke-static {v2, v3}, Lp;->a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v1

    .line 39
    invoke-interface {v1}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v2

    .line 40
    invoke-interface {v2}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v2

    const/16 v3, 0xc8

    if-ne v2, v3, :cond_0

    .line 41
    new-instance v2, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v2}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 42
    invoke-interface {v1}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v1

    invoke-interface {v1, v2}, Lorg/apache/http/HttpEntity;->writeTo(Ljava/io/OutputStream;)V

    .line 43
    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->close()V

    .line 44
    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->toString()Ljava/lang/String;

    move-result-object v0

    .line 60
    :goto_0
    return-object v0

    .line 47
    :cond_0
    invoke-interface {v1}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v1

    invoke-interface {v1}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/net/UnknownHostException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 49
    :catch_0
    move-exception v1

    .line 50
    invoke-static {}, Lcom/inc247/ChatSDKEventsCallback;->getInstance()Lcom/inc247/ChatSDKEventsCallback;

    move-result-object v1

    .line 51
    new-instance v2, Lcom/inc247/errors/ChatSDKError;

    sget-object v3, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKNetworkError:Lcom/inc247/errors/ChatSDKErrorCodes;

    invoke-direct {v2, v3}, Lcom/inc247/errors/ChatSDKError;-><init>(Lcom/inc247/errors/ChatSDKErrorCodes;)V

    .line 52
    invoke-virtual {v1, v2}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatErrorEvent(Lcom/inc247/errors/ChatSDKError;)V

    goto :goto_0

    .line 55
    :catch_1
    move-exception v1

    .line 56
    invoke-static {}, Lcom/inc247/ChatSDKEventsCallback;->getInstance()Lcom/inc247/ChatSDKEventsCallback;

    move-result-object v1

    .line 57
    new-instance v2, Lcom/inc247/errors/ChatSDKError;

    sget-object v3, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKUnknownError:Lcom/inc247/errors/ChatSDKErrorCodes;

    invoke-direct {v2, v3}, Lcom/inc247/errors/ChatSDKError;-><init>(Lcom/inc247/errors/ChatSDKErrorCodes;)V

    .line 58
    invoke-virtual {v1, v2}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatErrorEvent(Lcom/inc247/errors/ChatSDKError;)V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/inc247/ChatSDKAgentAvailibilityHelper;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 65
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 66
    invoke-static {}, Lcom/inc247/ChatSDKEventsCallback;->getInstance()Lcom/inc247/ChatSDKEventsCallback;

    move-result-object v1

    .line 68
    const-string v2, "data"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "caStatus"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "true"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 69
    const/4 v0, 0x1

    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatAgentAvailabilityEvent(Z)V

    .line 84
    :goto_0
    return-void

    .line 70
    :cond_0
    const-string v2, "data"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v2, "caStatus"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "false"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 71
    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatAgentAvailabilityEvent(Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 78
    :catch_0
    move-exception v0

    .line 79
    invoke-static {}, Lcom/inc247/ChatSDKEventsCallback;->getInstance()Lcom/inc247/ChatSDKEventsCallback;

    move-result-object v1

    .line 80
    new-instance v2, Lcom/inc247/errors/ChatSDKError;

    sget-object v3, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKUnknownError:Lcom/inc247/errors/ChatSDKErrorCodes;

    invoke-direct {v2, v3}, Lcom/inc247/errors/ChatSDKError;-><init>(Lcom/inc247/errors/ChatSDKErrorCodes;)V

    .line 81
    invoke-virtual {v1, v2}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatErrorEvent(Lcom/inc247/errors/ChatSDKError;)V

    .line 82
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "{\'Error\':\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0

    .line 74
    :cond_1
    :try_start_1
    new-instance v0, Lcom/inc247/errors/ChatSDKError;

    sget-object v2, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKUnknownError:Lcom/inc247/errors/ChatSDKErrorCodes;

    invoke-direct {v0, v2}, Lcom/inc247/errors/ChatSDKError;-><init>(Lcom/inc247/errors/ChatSDKErrorCodes;)V

    .line 75
    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatErrorEvent(Lcom/inc247/errors/ChatSDKError;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
