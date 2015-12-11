.class public Lcom/poshmark/http/httpCore/PMApiExecutor;
.super Lcom/poshmark/http/httpCore/PMHttpExecutor;
.source "PMApiExecutor.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/poshmark/http/httpCore/PMHttpExecutor;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lcom/poshmark/http/api/PMApiRequest;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiRequest",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 21
    .local p0, "this":Lcom/poshmark/http/httpCore/PMApiExecutor;, "Lcom/poshmark/http/httpCore/PMApiExecutor<TT;>;"
    .local p1, "pmApiRequest":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<TT;>;"
    invoke-direct {p0, p1}, Lcom/poshmark/http/httpCore/PMHttpExecutor;-><init>(Lcom/poshmark/http/PMHttpRequest;)V

    .line 22
    return-void
.end method


# virtual methods
.method protected callResponseHandler(Lcom/poshmark/http/PMHttpResponse;)V
    .locals 3
    .param p1, "pmHttpResponse"    # Lcom/poshmark/http/PMHttpResponse;

    .prologue
    .line 62
    .local p0, "this":Lcom/poshmark/http/httpCore/PMApiExecutor;, "Lcom/poshmark/http/httpCore/PMApiExecutor<TT;>;"
    move-object v0, p1

    check-cast v0, Lcom/poshmark/http/api/PMApiResponse;

    .line 63
    .local v0, "pmApiResponse":Lcom/poshmark/http/api/PMApiResponse;
    iget-object v2, p1, Lcom/poshmark/http/PMHttpResponse;->httpRequest:Lcom/poshmark/http/PMHttpRequest;

    check-cast v2, Lcom/poshmark/http/api/PMApiRequest;

    iget-object v1, v2, Lcom/poshmark/http/api/PMApiRequest;->responseHandler:Lcom/poshmark/http/PMBaseHttpResponseHandler;

    check-cast v1, Lcom/poshmark/http/api/PMApiResponseHandler;

    .line 64
    .local v1, "pmApiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;
    if-eqz v1, :cond_0

    .line 65
    invoke-interface {v1, v0}, Lcom/poshmark/http/api/PMApiResponseHandler;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V

    .line 67
    :cond_0
    return-void
.end method

.method protected prepareResponse(I[Lorg/apache/http/Header;Ljava/lang/String;Ljava/lang/Throwable;)Lcom/poshmark/http/PMHttpResponse;
    .locals 11
    .param p1, "httpCode"    # I
    .param p2, "headerArray"    # [Lorg/apache/http/Header;
    .param p3, "responseString"    # Ljava/lang/String;
    .param p4, "exception"    # Ljava/lang/Throwable;

    .prologue
    .local p0, "this":Lcom/poshmark/http/httpCore/PMApiExecutor;, "Lcom/poshmark/http/httpCore/PMApiExecutor<TT;>;"
    const/16 v4, 0xc8

    .line 27
    const/4 v5, 0x0

    .line 28
    .local v5, "data":Ljava/lang/Object;, "TT;"
    const/4 v7, 0x0

    .line 29
    .local v7, "pmApiError":Lcom/poshmark/http/api/PMApiError;
    const/4 v9, 0x0

    .line 30
    .local v9, "pmError":Lcom/poshmark/data_model/models/PMError;
    sget-object v10, Lcom/poshmark/data_model/models/PMErrorType;->UNKNOWN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 32
    .local v10, "pmErrorType":Lcom/poshmark/data_model/models/PMErrorType;
    if-nez p4, :cond_4

    if-ne p1, v4, :cond_4

    .line 35
    :try_start_0
    invoke-static {}, Lcom/poshmark/http/JSON/PMJson;->getInstance()Lcom/poshmark/http/JSON/PMJson;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/http/JSON/PMJson;->gson()Lcom/google/gson/Gson;

    move-result-object v2

    iget-object v1, p0, Lcom/poshmark/http/httpCore/PMApiExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    check-cast v1, Lcom/poshmark/http/api/PMApiRequest;

    iget-object v3, v1, Lcom/poshmark/http/api/PMApiRequest;->dataClass:Ljava/lang/Class;

    instance-of v1, v2, Lcom/google/gson/Gson;

    if-nez v1, :cond_3

    invoke-virtual {v2, p3, v3}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 51
    .end local v5    # "data":Ljava/lang/Object;, "TT;"
    :cond_0
    :goto_0
    if-nez p4, :cond_1

    if-nez v9, :cond_1

    if-eq p1, v4, :cond_2

    .line 53
    :cond_1
    new-instance v7, Lcom/poshmark/http/api/PMApiError;

    .end local v7    # "pmApiError":Lcom/poshmark/http/api/PMApiError;
    invoke-direct {v7, v9, p4, p1, v10}, Lcom/poshmark/http/api/PMApiError;-><init>(Lcom/poshmark/data_model/models/PMError;Ljava/lang/Throwable;ILcom/poshmark/data_model/models/PMErrorType;)V

    .line 56
    .restart local v7    # "pmApiError":Lcom/poshmark/http/api/PMApiError;
    :cond_2
    new-instance v1, Lcom/poshmark/http/api/PMApiResponse;

    iget-object v6, p0, Lcom/poshmark/http/httpCore/PMApiExecutor;->pmHttpRequest:Lcom/poshmark/http/PMHttpRequest;

    check-cast v6, Lcom/poshmark/http/api/PMApiRequest;

    move v2, p1

    move-object v3, p2

    move-object v4, p3

    invoke-direct/range {v1 .. v7}, Lcom/poshmark/http/api/PMApiResponse;-><init>(I[Lorg/apache/http/Header;Ljava/lang/String;Ljava/lang/Object;Lcom/poshmark/http/api/PMApiRequest;Lcom/poshmark/http/api/PMApiError;)V

    return-object v1

    .line 35
    .restart local v5    # "data":Ljava/lang/Object;, "TT;"
    :cond_3
    :try_start_1
    move-object v0, v2

    check-cast v0, Lcom/google/gson/Gson;

    move-object v1, v0

    invoke-static {v1, p3, v3}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v5

    goto :goto_0

    .line 36
    :catch_0
    move-exception v8

    .line 37
    .local v8, "e":Ljava/lang/Throwable;
    sget-object v10, Lcom/poshmark/data_model/models/PMErrorType;->JSON_PARSING_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 38
    invoke-virtual {v8}, Ljava/lang/Throwable;->printStackTrace()V

    .line 39
    move-object p4, v8

    .line 40
    goto :goto_0

    .line 41
    .end local v8    # "e":Ljava/lang/Throwable;
    :cond_4
    if-nez p4, :cond_0

    .line 44
    :try_start_2
    invoke-static {}, Lcom/poshmark/http/JSON/PMJson;->getInstance()Lcom/poshmark/http/JSON/PMJson;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/http/JSON/PMJson;->gson()Lcom/google/gson/Gson;

    move-result-object v1

    const-class v2, Lcom/poshmark/data_model/models/PMError;

    instance-of v3, v1, Lcom/google/gson/Gson;

    if-nez v3, :cond_5

    invoke-virtual {v1, p3, v2}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    :goto_1
    move-object v0, v1

    check-cast v0, Lcom/poshmark/data_model/models/PMError;

    move-object v9, v0

    goto :goto_0

    :cond_5
    check-cast v1, Lcom/google/gson/Gson;

    invoke-static {v1, p3, v2}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_1

    move-result-object v1

    goto :goto_1

    .line 45
    :catch_1
    move-exception v8

    .line 46
    .restart local v8    # "e":Ljava/lang/Throwable;
    invoke-virtual {v8}, Ljava/lang/Throwable;->printStackTrace()V

    .line 47
    move-object p4, v8

    goto :goto_0
.end method
