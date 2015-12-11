.class public abstract Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;
.super Ljava/lang/Object;
.source "ServiceClient.java"


# static fields
.field private static final WEB_CLIENT_CLASS:Ljava/lang/String;


# instance fields
.field private final baseUrl:Ljava/lang/String;

.field private final cookies:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private volatile defaultObjectParser:Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

.field private final headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final method:Ljava/lang/String;

.field private final objectParser:Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

.field private final parameters:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private secure:Z

.field private final serviceCallInterceptor:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

.field private final userAgent:Ljava/lang/String;

.field private final webClientFactory:Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 46
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;

    invoke-virtual {v1}, Ljava/lang/Class;->getPackage()Ljava/lang/Package;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Package;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".jnet.NetWebClient"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->WEB_CLIENT_CLASS:Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>(Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;ZLjava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;)V
    .locals 1
    .param p1, "webClientFactory"    # Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;
    .param p2, "secure"    # Z
    .param p3, "method"    # Ljava/lang/String;
    .param p4, "baseUrl"    # Ljava/lang/String;
    .param p7, "userAgent"    # Ljava/lang/String;
    .param p9, "serviceCallInterceptor"    # Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;
    .param p10, "objectParser"    # Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;",
            "Z",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;",
            "Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;",
            ")V"
        }
    .end annotation

    .prologue
    .line 67
    .local p5, "parameters":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p6, "headers":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p8, "cookies":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    if-nez p1, :cond_0

    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->createWebClientFactory()Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    move-result-object p1

    .end local p1    # "webClientFactory":Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;
    :cond_0
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->webClientFactory:Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    .line 69
    iput-boolean p2, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->secure:Z

    .line 70
    if-nez p3, :cond_1

    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->GET:Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object p3

    .end local p3    # "method":Ljava/lang/String;
    :cond_1
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->method:Ljava/lang/String;

    .line 71
    iput-object p4, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->baseUrl:Ljava/lang/String;

    .line 72
    iput-object p5, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->parameters:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    .line 73
    iput-object p6, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    .line 74
    if-nez p7, :cond_2

    const-string/jumbo v0, "http.agent"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p7

    .end local p7    # "userAgent":Ljava/lang/String;
    :cond_2
    iput-object p7, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->userAgent:Ljava/lang/String;

    .line 75
    iput-object p8, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->cookies:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    .line 76
    iput-object p9, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->serviceCallInterceptor:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

    .line 77
    iput-object p10, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->objectParser:Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

    .line 78
    return-void
.end method

.method public static createWebClient()Lcom/amazon/searchapp/retailsearch/client/web/WebClient;
    .locals 4

    .prologue
    .line 201
    const/4 v1, 0x0

    .line 204
    .local v1, "error":Ljava/lang/Exception;
    :try_start_0
    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->WEB_CLIENT_CLASS:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Class;

    invoke-virtual {v2, v3}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v2

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v2, v3}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/searchapp/retailsearch/client/web/WebClient;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_5

    .line 219
    :goto_0
    return-object v2

    .line 205
    :catch_0
    move-exception v0

    .line 206
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    move-object v1, v0

    .line 219
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :goto_1
    const/4 v2, 0x0

    goto :goto_0

    .line 207
    :catch_1
    move-exception v0

    .line 208
    .local v0, "e":Ljava/lang/InstantiationException;
    move-object v1, v0

    .line 217
    goto :goto_1

    .line 209
    .end local v0    # "e":Ljava/lang/InstantiationException;
    :catch_2
    move-exception v0

    .line 210
    .local v0, "e":Ljava/lang/IllegalAccessException;
    move-object v1, v0

    .line 217
    goto :goto_1

    .line 211
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_3
    move-exception v0

    .line 212
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    move-object v1, v0

    .line 217
    goto :goto_1

    .line 213
    .end local v0    # "e":Ljava/lang/reflect/InvocationTargetException;
    :catch_4
    move-exception v0

    .line 214
    .local v0, "e":Ljava/lang/NoSuchMethodException;
    move-object v1, v0

    .line 217
    goto :goto_1

    .line 215
    .end local v0    # "e":Ljava/lang/NoSuchMethodException;
    :catch_5
    move-exception v0

    .line 216
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    move-object v1, v0

    goto :goto_1
.end method

.method public static createWebClientFactory()Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;
    .locals 1

    .prologue
    .line 176
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->createWebClient()Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->createWebClientFactory(Lcom/amazon/searchapp/retailsearch/client/web/WebClient;)Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    move-result-object v0

    return-object v0
.end method

.method public static createWebClientFactory(Lcom/amazon/searchapp/retailsearch/client/web/WebClient;)Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;
    .locals 1
    .param p0, "webClient"    # Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

    .prologue
    .line 186
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient$1;

    invoke-direct {v0, p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient$1;-><init>(Lcom/amazon/searchapp/retailsearch/client/web/WebClient;)V

    return-object v0
.end method


# virtual methods
.method protected buildDefaultObjectParser()Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;
    .locals 2

    .prologue
    .line 167
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "No default object parser defined"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public final getBaseUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->baseUrl:Ljava/lang/String;

    return-object v0
.end method

.method public final getCookies()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 133
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->cookies:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    return-object v0
.end method

.method protected declared-synchronized getDefaultObjectParser()Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;
    .locals 1

    .prologue
    .line 154
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->defaultObjectParser:Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

    if-nez v0, :cond_0

    .line 155
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->buildDefaultObjectParser()Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->defaultObjectParser:Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

    .line 158
    :cond_0
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->defaultObjectParser:Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 154
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final getHeaders()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 119
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->headers:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    return-object v0
.end method

.method public final getObjectParser()Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->objectParser:Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->objectParser:Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->getDefaultObjectParser()Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;

    move-result-object v0

    goto :goto_0
.end method

.method public final getParameters()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 112
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->parameters:Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    return-object v0
.end method

.method public final getSecure()Z
    .locals 1

    .prologue
    .line 91
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->secure:Z

    return v0
.end method

.method public final getServiceCallInterceptor()Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->serviceCallInterceptor:Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;

    return-object v0
.end method

.method public final getUserAgent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->userAgent:Ljava/lang/String;

    return-object v0
.end method

.method public final getWebClient()Lcom/amazon/searchapp/retailsearch/client/web/WebClient;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/ServiceClient;->webClientFactory:Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/client/web/WebClientFactory;->getWebClient()Lcom/amazon/searchapp/retailsearch/client/web/WebClient;

    move-result-object v0

    return-object v0
.end method
