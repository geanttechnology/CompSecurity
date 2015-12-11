.class public Lcom/poshmark/http/api/PMApiRequest;
.super Lcom/poshmark/http/PMHttpRequest;
.source "PMApiRequest.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/poshmark/http/PMHttpRequest;"
    }
.end annotation


# instance fields
.field public dataClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;)V
    .locals 2
    .param p1, "requestType"    # Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;
    .param p2, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 19
    .local p0, "this":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<TT;>;"
    .local p3, "dataClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "https://api.poshmark.com"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/poshmark/http/PMHttpRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;)V

    .line 20
    invoke-virtual {p0, p3}, Lcom/poshmark/http/api/PMApiRequest;->setupDefaults(Ljava/lang/Class;)V

    .line 43
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V
    .locals 1
    .param p1, "requestType"    # Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;
    .param p2, "url"    # Ljava/lang/String;
    .param p4, "server"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<TT;>;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 46
    .local p0, "this":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<TT;>;"
    .local p3, "dataClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/poshmark/http/PMHttpRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;)V

    .line 47
    invoke-virtual {p0, p3}, Lcom/poshmark/http/api/PMApiRequest;->setupDefaults(Ljava/lang/Class;)V

    .line 48
    return-void
.end method


# virtual methods
.method public callAPI(Lcom/poshmark/http/api/PMApiResponseHandler;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 76
    .local p0, "this":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<TT;>;"
    .local p1, "apiResponseHandler":Lcom/poshmark/http/api/PMApiResponseHandler;, "Lcom/poshmark/http/api/PMApiResponseHandler<TT;>;"
    iput-object p1, p0, Lcom/poshmark/http/api/PMApiRequest;->responseHandler:Lcom/poshmark/http/PMBaseHttpResponseHandler;

    .line 77
    new-instance v0, Lcom/poshmark/http/httpCore/PMApiExecutor;

    invoke-direct {v0, p0}, Lcom/poshmark/http/httpCore/PMApiExecutor;-><init>(Lcom/poshmark/http/api/PMApiRequest;)V

    invoke-virtual {v0}, Lcom/poshmark/http/httpCore/PMApiExecutor;->execute()V

    .line 78
    return-void
.end method

.method protected setupDefaults(Ljava/lang/Class;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 50
    .local p0, "this":Lcom/poshmark/http/api/PMApiRequest;, "Lcom/poshmark/http/api/PMApiRequest<TT;>;"
    .local p1, "dataClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    iput-object p1, p0, Lcom/poshmark/http/api/PMApiRequest;->dataClass:Ljava/lang/Class;

    .line 53
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    .line 54
    .local v1, "pmApplicationSession":Lcom/poshmark/application/PMApplicationSession;
    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getAccessToken()Ljava/lang/String;

    move-result-object v2

    .line 55
    .local v2, "token":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 56
    iget-object v3, p0, Lcom/poshmark/http/api/PMApiRequest;->headers:Ljava/util/Map;

    const-string v4, "X-HTTP_AUTHORIZATION"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "oauth "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    iget-object v3, p0, Lcom/poshmark/http/api/PMApiRequest;->headers:Ljava/util/Map;

    const-string v4, "X-HTTP_AUTHORIZATION"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "oauth "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    iget-object v3, p0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v4, "username"

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    :cond_0
    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v0

    .line 67
    .local v0, "appInfo":Lcom/poshmark/application/AppInfo;
    iget-object v3, p0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v4, "format"

    const-string v5, "json"

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    iget-object v3, p0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v4, "api_version"

    const-string v5, "0.2"

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 69
    iget-object v3, p0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v4, "app_version"

    iget-object v5, v0, Lcom/poshmark/application/AppInfo;->versionName:Ljava/lang/String;

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 70
    iget-object v3, p0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v4, "app_versionCode"

    iget-object v5, v0, Lcom/poshmark/application/AppInfo;->versionCodeString:Ljava/lang/String;

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 71
    iget-object v3, p0, Lcom/poshmark/http/api/PMApiRequest;->queryParams:Ljava/util/Map;

    const-string v4, "app_type"

    const-string v5, "android"

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    return-void
.end method
