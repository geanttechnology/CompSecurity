.class Lcom/squareup/okhttp/internal/Platform$JdkWithJettyNpnPlatform;
.super Lcom/squareup/okhttp/internal/Platform;
.source "Platform.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/squareup/okhttp/internal/Platform;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "JdkWithJettyNpnPlatform"
.end annotation


# instance fields
.field private final clientProviderClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field private final getMethod:Ljava/lang/reflect/Method;

.field private final putMethod:Ljava/lang/reflect/Method;

.field private final serverProviderClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    .locals 0
    .param p1, "putMethod"    # Ljava/lang/reflect/Method;
    .param p2, "getMethod"    # Ljava/lang/reflect/Method;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/reflect/Method;",
            "Ljava/lang/reflect/Method;",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 295
    .local p3, "clientProviderClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local p4, "serverProviderClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/Platform;-><init>()V

    .line 296
    iput-object p1, p0, Lcom/squareup/okhttp/internal/Platform$JdkWithJettyNpnPlatform;->putMethod:Ljava/lang/reflect/Method;

    .line 297
    iput-object p2, p0, Lcom/squareup/okhttp/internal/Platform$JdkWithJettyNpnPlatform;->getMethod:Ljava/lang/reflect/Method;

    .line 298
    iput-object p3, p0, Lcom/squareup/okhttp/internal/Platform$JdkWithJettyNpnPlatform;->clientProviderClass:Ljava/lang/Class;

    .line 299
    iput-object p4, p0, Lcom/squareup/okhttp/internal/Platform$JdkWithJettyNpnPlatform;->serverProviderClass:Ljava/lang/Class;

    .line 300
    return-void
.end method


# virtual methods
.method public getNpnSelectedProtocol(Ljavax/net/ssl/SSLSocket;)Lcom/squareup/okhttp/internal/okio/ByteString;
    .locals 8
    .param p1, "socket"    # Ljavax/net/ssl/SSLSocket;

    .prologue
    const/4 v3, 0x0

    .line 320
    :try_start_0
    iget-object v4, p0, Lcom/squareup/okhttp/internal/Platform$JdkWithJettyNpnPlatform;->getMethod:Ljava/lang/reflect/Method;

    const/4 v5, 0x0

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    invoke-virtual {v4, v5, v6}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/reflect/Proxy;->getInvocationHandler(Ljava/lang/Object;)Ljava/lang/reflect/InvocationHandler;

    move-result-object v2

    check-cast v2, Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;

    .line 322
    .local v2, "provider":Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;
    # getter for: Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;->unsupported:Z
    invoke-static {v2}, Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;->access$100(Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;)Z

    move-result v4

    if-nez v4, :cond_1

    # getter for: Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;->selected:Ljava/lang/String;
    invoke-static {v2}, Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;->access$200(Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;)Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_1

    .line 323
    const-string/jumbo v4, "com.squareup.okhttp.OkHttpClient"

    invoke-static {v4}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v1

    .line 324
    .local v1, "logger":Ljava/util/logging/Logger;
    sget-object v4, Ljava/util/logging/Level;->INFO:Ljava/util/logging/Level;

    const-string/jumbo v5, "NPN callback dropped so SPDY is disabled. Is npn-boot on the boot class path?"

    invoke-virtual {v1, v4, v5}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;)V

    .line 328
    .end local v1    # "logger":Ljava/util/logging/Logger;
    :cond_0
    :goto_0
    return-object v3

    :cond_1
    # getter for: Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;->unsupported:Z
    invoke-static {v2}, Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;->access$100(Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;)Z

    move-result v4

    if-nez v4, :cond_0

    # getter for: Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;->selected:Ljava/lang/String;
    invoke-static {v2}, Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;->access$200(Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/squareup/okhttp/internal/okio/ByteString;->encodeUtf8(Ljava/lang/String;)Lcom/squareup/okhttp/internal/okio/ByteString;
    :try_end_0
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v3

    goto :goto_0

    .line 329
    .end local v2    # "provider":Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;
    :catch_0
    move-exception v0

    .line 330
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    new-instance v3, Ljava/lang/AssertionError;

    invoke-direct {v3}, Ljava/lang/AssertionError;-><init>()V

    throw v3

    .line 331
    .end local v0    # "e":Ljava/lang/reflect/InvocationTargetException;
    :catch_1
    move-exception v0

    .line 332
    .local v0, "e":Ljava/lang/IllegalAccessException;
    new-instance v3, Ljava/lang/AssertionError;

    invoke-direct {v3}, Ljava/lang/AssertionError;-><init>()V

    throw v3
.end method

.method public setNpnProtocols(Ljavax/net/ssl/SSLSocket;Ljava/util/List;)V
    .locals 9
    .param p1, "socket"    # Ljavax/net/ssl/SSLSocket;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljavax/net/ssl/SSLSocket;",
            "Ljava/util/List",
            "<",
            "Lcom/squareup/okhttp/Protocol;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 304
    .local p2, "npnProtocols":Ljava/util/List;, "Ljava/util/List<Lcom/squareup/okhttp/Protocol;>;"
    :try_start_0
    new-instance v2, Ljava/util/ArrayList;

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v5

    invoke-direct {v2, v5}, Ljava/util/ArrayList;-><init>(I)V

    .line 305
    .local v2, "names":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v4

    .local v4, "size":I
    :goto_0
    if-ge v1, v4, :cond_0

    .line 306
    invoke-interface {p2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/squareup/okhttp/Protocol;

    iget-object v5, v5, Lcom/squareup/okhttp/Protocol;->name:Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/okio/ByteString;->utf8()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 305
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 308
    :cond_0
    const-class v5, Lcom/squareup/okhttp/internal/Platform;

    invoke-virtual {v5}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v5

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Class;

    const/4 v7, 0x0

    iget-object v8, p0, Lcom/squareup/okhttp/internal/Platform$JdkWithJettyNpnPlatform;->clientProviderClass:Ljava/lang/Class;

    aput-object v8, v6, v7

    const/4 v7, 0x1

    iget-object v8, p0, Lcom/squareup/okhttp/internal/Platform$JdkWithJettyNpnPlatform;->serverProviderClass:Ljava/lang/Class;

    aput-object v8, v6, v7

    new-instance v7, Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;

    invoke-direct {v7, v2}, Lcom/squareup/okhttp/internal/Platform$JettyNpnProvider;-><init>(Ljava/util/List;)V

    invoke-static {v5, v6, v7}, Ljava/lang/reflect/Proxy;->newProxyInstance(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;

    move-result-object v3

    .line 310
    .local v3, "provider":Ljava/lang/Object;
    iget-object v5, p0, Lcom/squareup/okhttp/internal/Platform$JdkWithJettyNpnPlatform;->putMethod:Ljava/lang/reflect/Method;

    const/4 v6, 0x0

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object p1, v7, v8

    const/4 v8, 0x1

    aput-object v3, v7, v8

    invoke-virtual {v5, v6, v7}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    .line 316
    return-void

    .line 311
    .end local v1    # "i":I
    .end local v2    # "names":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v3    # "provider":Ljava/lang/Object;
    .end local v4    # "size":I
    :catch_0
    move-exception v0

    .line 312
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    new-instance v5, Ljava/lang/AssertionError;

    invoke-direct {v5, v0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v5

    .line 313
    .end local v0    # "e":Ljava/lang/reflect/InvocationTargetException;
    :catch_1
    move-exception v0

    .line 314
    .local v0, "e":Ljava/lang/IllegalAccessException;
    new-instance v5, Ljava/lang/AssertionError;

    invoke-direct {v5, v0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v5
.end method
