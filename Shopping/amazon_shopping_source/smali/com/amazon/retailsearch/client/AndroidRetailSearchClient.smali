.class public Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;
.super Ljava/lang/Object;
.source "AndroidRetailSearchClient.java"


# static fields
.field private static appVersion:Ljava/lang/String;

.field private static client:Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

.field private static clientId:Ljava/lang/String;

.field private static serviceCallInterceptor:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

.field private static userAgent:Ljava/lang/String;

.field private static webClientFactory:Lcom/amazon/retailsearch/client/AndroidWebClientFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    new-instance v0, Lcom/amazon/retailsearch/client/AndroidWebClientFactory;

    invoke-direct {v0}, Lcom/amazon/retailsearch/client/AndroidWebClientFactory;-><init>()V

    sput-object v0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->webClientFactory:Lcom/amazon/retailsearch/client/AndroidWebClientFactory;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static createClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    .locals 3

    .prologue
    .line 40
    new-instance v1, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    invoke-direct {v1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;-><init>()V

    invoke-static {}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->getWebClientFactory()Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->setWebClientFactory(Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;)Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    move-result-object v1

    invoke-static {}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->getServiceCallInterceptor()Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->setServiceCallInterceptor(Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;)Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    move-result-object v1

    invoke-static {}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->getUserAgent()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->setUserAgent(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    move-result-object v0

    .line 45
    .local v0, "clientBuilder":Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;
    sget-object v1, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->clientId:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 46
    invoke-static {}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->getClientId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->setClientId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;

    .line 49
    :cond_0
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v1

    return-object v1
.end method

.method public static getAppVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    sget-object v0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->appVersion:Ljava/lang/String;

    return-object v0
.end method

.method public static declared-synchronized getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    .locals 2

    .prologue
    .line 31
    const-class v1, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->client:Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    if-nez v0, :cond_0

    .line 32
    invoke-static {}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->createClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->client:Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    .line 35
    :cond_0
    sget-object v0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->client:Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 31
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static getClientId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    sget-object v0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->clientId:Ljava/lang/String;

    return-object v0
.end method

.method public static declared-synchronized getServiceCallInterceptor()Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;
    .locals 2

    .prologue
    .line 122
    const-class v1, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->serviceCallInterceptor:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

    if-nez v0, :cond_0

    .line 124
    new-instance v0, Lcom/amazon/retailsearch/client/SearchCallInterceptor;

    invoke-direct {v0}, Lcom/amazon/retailsearch/client/SearchCallInterceptor;-><init>()V

    sput-object v0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->serviceCallInterceptor:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

    .line 127
    :cond_0
    sget-object v0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->serviceCallInterceptor:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 122
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static getUserAgent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    sget-object v0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->userAgent:Ljava/lang/String;

    return-object v0
.end method

.method public static getWebClientFactory()Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;
    .locals 1

    .prologue
    .line 114
    sget-object v0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->webClientFactory:Lcom/amazon/retailsearch/client/AndroidWebClientFactory;

    return-object v0
.end method

.method public static declared-synchronized resetClient()V
    .locals 2

    .prologue
    .line 57
    const-class v1, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;

    monitor-enter v1

    const/4 v0, 0x0

    :try_start_0
    sput-object v0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->client:Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    .line 58
    invoke-static {}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 59
    monitor-exit v1

    return-void

    .line 57
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static setAppVersion(Ljava/lang/String;)V
    .locals 0
    .param p0, "appVersion"    # Ljava/lang/String;

    .prologue
    .line 106
    sput-object p0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->appVersion:Ljava/lang/String;

    .line 107
    return-void
.end method

.method public static setClientId(Ljava/lang/String;)V
    .locals 0
    .param p0, "clientId"    # Ljava/lang/String;

    .prologue
    .line 74
    sput-object p0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->clientId:Ljava/lang/String;

    .line 75
    return-void
.end method

.method public static setUserAgent(Ljava/lang/String;)V
    .locals 0
    .param p0, "userAgent"    # Ljava/lang/String;

    .prologue
    .line 90
    sput-object p0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->userAgent:Ljava/lang/String;

    .line 91
    return-void
.end method
