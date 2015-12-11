.class public Lcom/auditude/ads/loader/DataLoader;
.super Ljava/lang/Object;
.source "DataLoader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;
    }
.end annotation


# instance fields
.field private error:Ljava/lang/Throwable;

.field private httpClient:Lcom/auditude/ads/util/http/AsyncHttpConnection;

.field private listener:Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;

.field private postParams:Ljava/lang/String;

.field private requestURL:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    return-void
.end method

.method static synthetic access$0(Lcom/auditude/ads/loader/DataLoader;)Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/auditude/ads/loader/DataLoader;->listener:Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;

    return-object v0
.end method

.method static synthetic access$1(Lcom/auditude/ads/loader/DataLoader;Ljava/lang/Throwable;)V
    .locals 0

    .prologue
    .line 13
    iput-object p1, p0, Lcom/auditude/ads/loader/DataLoader;->error:Ljava/lang/Throwable;

    return-void
.end method

.method static synthetic access$2(Lcom/auditude/ads/loader/DataLoader;)Ljava/lang/Throwable;
    .locals 1

    .prologue
    .line 13
    iget-object v0, p0, Lcom/auditude/ads/loader/DataLoader;->error:Ljava/lang/Throwable;

    return-object v0
.end method

.method static synthetic access$3(Lcom/auditude/ads/loader/DataLoader;Ljava/lang/Throwable;)V
    .locals 0

    .prologue
    .line 95
    invoke-direct {p0, p1}, Lcom/auditude/ads/loader/DataLoader;->notifyRequestFailed(Ljava/lang/Throwable;)V

    return-void
.end method

.method private notifyRequestFailed(Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/auditude/ads/loader/DataLoader;->listener:Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;

    if-eqz v0, :cond_0

    .line 99
    iget-object v0, p0, Lcom/auditude/ads/loader/DataLoader;->listener:Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;

    invoke-interface {v0, p1}, Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;->onRequestFailed(Ljava/lang/Throwable;)V

    .line 101
    :cond_0
    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .prologue
    .line 85
    :try_start_0
    iget-object v0, p0, Lcom/auditude/ads/loader/DataLoader;->httpClient:Lcom/auditude/ads/util/http/AsyncHttpConnection;

    if-eqz v0, :cond_0

    .line 87
    iget-object v0, p0, Lcom/auditude/ads/loader/DataLoader;->httpClient:Lcom/auditude/ads/util/http/AsyncHttpConnection;

    invoke-virtual {v0}, Lcom/auditude/ads/util/http/AsyncHttpConnection;->cancel()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 93
    :cond_0
    :goto_0
    return-void

    .line 90
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public final load(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 1
    .param p1, "requestURL"    # Ljava/lang/String;
    .param p2, "postParams"    # Ljava/lang/String;
    .param p3, "timeout"    # I

    .prologue
    .line 26
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/auditude/ads/loader/DataLoader;->load(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;)V

    .line 27
    return-void
.end method

.method public final load(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;)V
    .locals 5
    .param p1, "requestURL"    # Ljava/lang/String;
    .param p2, "postParams"    # Ljava/lang/String;
    .param p3, "timeout"    # I
    .param p4, "isHeadRequest"    # Ljava/lang/Boolean;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/auditude/ads/loader/DataLoader;->requestURL:Ljava/lang/String;

    .line 32
    iput-object p2, p0, Lcom/auditude/ads/loader/DataLoader;->postParams:Ljava/lang/String;

    .line 34
    invoke-static {}, Lcom/auditude/ads/util/log/Log;->getLogger()Lcom/auditude/ads/util/log/ILogger;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Sending adserver request to: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/auditude/ads/loader/DataLoader;->requestURL:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V

    .line 36
    new-instance v0, Lcom/auditude/ads/loader/DataLoader$1;

    invoke-direct {v0, p0}, Lcom/auditude/ads/loader/DataLoader$1;-><init>(Lcom/auditude/ads/loader/DataLoader;)V

    .line 62
    .local v0, "handler":Landroid/os/Handler;
    new-instance v1, Lcom/auditude/ads/util/http/AsyncHttpConnection;

    invoke-direct {v1, v0}, Lcom/auditude/ads/util/http/AsyncHttpConnection;-><init>(Landroid/os/Handler;)V

    iput-object v1, p0, Lcom/auditude/ads/loader/DataLoader;->httpClient:Lcom/auditude/ads/util/http/AsyncHttpConnection;

    .line 63
    iget-object v1, p0, Lcom/auditude/ads/loader/DataLoader;->postParams:Ljava/lang/String;

    invoke-static {v1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 65
    invoke-virtual {p4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 67
    iget-object v1, p0, Lcom/auditude/ads/loader/DataLoader;->httpClient:Lcom/auditude/ads/util/http/AsyncHttpConnection;

    iget-object v2, p0, Lcom/auditude/ads/loader/DataLoader;->requestURL:Ljava/lang/String;

    mul-int/lit16 v3, p3, 0x3e8

    invoke-virtual {v1, v2, v3}, Lcom/auditude/ads/util/http/AsyncHttpConnection;->head(Ljava/lang/String;I)V

    .line 79
    :goto_0
    return-void

    .line 71
    :cond_0
    iget-object v1, p0, Lcom/auditude/ads/loader/DataLoader;->httpClient:Lcom/auditude/ads/util/http/AsyncHttpConnection;

    iget-object v2, p0, Lcom/auditude/ads/loader/DataLoader;->requestURL:Ljava/lang/String;

    mul-int/lit16 v3, p3, 0x3e8

    invoke-virtual {v1, v2, v3}, Lcom/auditude/ads/util/http/AsyncHttpConnection;->get(Ljava/lang/String;I)V

    goto :goto_0

    .line 76
    :cond_1
    iget-object v1, p0, Lcom/auditude/ads/loader/DataLoader;->httpClient:Lcom/auditude/ads/util/http/AsyncHttpConnection;

    iget-object v2, p0, Lcom/auditude/ads/loader/DataLoader;->requestURL:Ljava/lang/String;

    iget-object v3, p0, Lcom/auditude/ads/loader/DataLoader;->postParams:Ljava/lang/String;

    mul-int/lit16 v4, p3, 0x3e8

    invoke-virtual {v1, v2, v3, v4}, Lcom/auditude/ads/util/http/AsyncHttpConnection;->post(Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_0
.end method

.method public setDataLoaderListener(Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/auditude/ads/loader/DataLoader;->listener:Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;

    return-void
.end method
