.class Lcom/poshmark/http/httpCore/PMHttpExecutor$MakeRequestTask;
.super Landroid/os/AsyncTask;
.source "PMHttpExecutor.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/http/httpCore/PMHttpExecutor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MakeRequestTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field public _nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

.field final synthetic this$0:Lcom/poshmark/http/httpCore/PMHttpExecutor;


# direct methods
.method private constructor <init>(Lcom/poshmark/http/httpCore/PMHttpExecutor;)V
    .locals 0

    .prologue
    .line 123
    iput-object p1, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor$MakeRequestTask;->this$0:Lcom/poshmark/http/httpCore/PMHttpExecutor;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/poshmark/http/httpCore/PMHttpExecutor;Lcom/poshmark/http/httpCore/PMHttpExecutor$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/poshmark/http/httpCore/PMHttpExecutor;
    .param p2, "x1"    # Lcom/poshmark/http/httpCore/PMHttpExecutor$1;

    .prologue
    .line 123
    invoke-direct {p0, p1}, Lcom/poshmark/http/httpCore/PMHttpExecutor$MakeRequestTask;-><init>(Lcom/poshmark/http/httpCore/PMHttpExecutor;)V

    return-void
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor$MakeRequestTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor$MakeRequestTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "PMHttpExecutor$MakeRequestTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 123
    :goto_0
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/poshmark/http/httpCore/PMHttpExecutor$MakeRequestTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "PMHttpExecutor$MakeRequestTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 10
    .param p1, "Voids"    # [Ljava/lang/Void;

    .prologue
    .line 128
    const/4 v5, 0x0

    .line 129
    .local v5, "response":Lorg/apache/http/HttpResponse;
    const/4 v2, 0x0

    .line 130
    .local v2, "headerArray":[Lorg/apache/http/Header;
    const/4 v1, 0x0

    .line 131
    .local v1, "exception":Ljava/lang/Throwable;
    const/4 v6, 0x0

    .line 132
    .local v6, "responseString":Ljava/lang/String;
    const/4 v3, 0x0

    .line 135
    .local v3, "httpCode":I
    :try_start_0
    invoke-static {}, Lcom/poshmark/http/httpCore/PMHttpClient;->getInstance()Lcom/poshmark/http/httpCore/PMHttpClient;

    move-result-object v7

    iget-object v7, v7, Lcom/poshmark/http/httpCore/PMHttpClient;->httpClient:Lorg/apache/http/client/HttpClient;

    iget-object v8, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor$MakeRequestTask;->this$0:Lcom/poshmark/http/httpCore/PMHttpExecutor;

    iget-object v8, v8, Lcom/poshmark/http/httpCore/PMHttpExecutor;->httpRequest:Lorg/apache/http/client/methods/HttpUriRequest;

    instance-of v9, v7, Lorg/apache/http/client/HttpClient;

    if-nez v9, :cond_0

    invoke-interface {v7, v8}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v5

    .line 136
    :goto_0
    invoke-interface {v5}, Lorg/apache/http/HttpResponse;->getAllHeaders()[Lorg/apache/http/Header;

    move-result-object v2

    .line 137
    invoke-interface {v5}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v7

    invoke-interface {v7}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v3

    .line 138
    invoke-static {v5}, Lcom/poshmark/http/httpUtils/PMHttpUtils;->getResponseString(Lorg/apache/http/HttpResponse;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 144
    :goto_1
    iget-object v7, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor$MakeRequestTask;->this$0:Lcom/poshmark/http/httpCore/PMHttpExecutor;

    invoke-virtual {v7, v3, v2, v6, v1}, Lcom/poshmark/http/httpCore/PMHttpExecutor;->prepareResponse(I[Lorg/apache/http/Header;Ljava/lang/String;Ljava/lang/Throwable;)Lcom/poshmark/http/PMHttpResponse;

    move-result-object v4

    .line 145
    .local v4, "pmHttpResponse":Lcom/poshmark/http/PMHttpResponse;
    iget-object v7, p0, Lcom/poshmark/http/httpCore/PMHttpExecutor$MakeRequestTask;->this$0:Lcom/poshmark/http/httpCore/PMHttpExecutor;

    # invokes: Lcom/poshmark/http/httpCore/PMHttpExecutor;->sendResponseMessage(Lcom/poshmark/http/PMHttpResponse;)V
    invoke-static {v7, v4}, Lcom/poshmark/http/httpCore/PMHttpExecutor;->access$100(Lcom/poshmark/http/httpCore/PMHttpExecutor;Lcom/poshmark/http/PMHttpResponse;)V

    .line 147
    const/4 v7, 0x0

    return-object v7

    .line 135
    .end local v4    # "pmHttpResponse":Lcom/poshmark/http/PMHttpResponse;
    :cond_0
    :try_start_1
    check-cast v7, Lorg/apache/http/client/HttpClient;

    invoke-static {v7, v8}, Lcom/newrelic/agent/android/instrumentation/HttpInstrumentation;->execute(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v5

    goto :goto_0

    .line 139
    :catch_0
    move-exception v0

    .line 140
    .local v0, "e":Ljava/lang/Throwable;
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 141
    move-object v1, v0

    goto :goto_1
.end method
