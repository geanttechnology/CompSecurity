.class public final Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory;
.super Ljava/lang/Object;
.source "HttpRequestWrapperFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler;,
        Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$DummyAuthenticatedHttpRequest;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 82
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 83
    return-void
.end method

.method public static createAuthenticatedHttpRequestWrapper(Landroid/content/Context;Lorg/apache/http/HttpRequest;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Lorg/apache/http/HttpRequest;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "httpRequestToWrap"    # Lorg/apache/http/HttpRequest;
    .param p2, "method"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .prologue
    .line 108
    invoke-static {p0, p1, p2}, Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory;->createDynamicProxyForHttpRequestClass(Landroid/content/Context;Ljava/lang/Object;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/HttpRequest;

    return-object v0
.end method

.method public static createAuthenticatedHttpRequestWrapper(Landroid/content/Context;Lorg/apache/http/client/methods/HttpUriRequest;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Lorg/apache/http/client/methods/HttpUriRequest;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "httpRequestToWrap"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .param p2, "method"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .prologue
    .line 95
    invoke-static {p0, p1, p2}, Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory;->createDynamicProxyForHttpRequestClass(Landroid/content/Context;Ljava/lang/Object;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/client/methods/HttpUriRequest;

    return-object v0
.end method

.method private static createDynamicProxyForHttpRequestClass(Landroid/content/Context;Ljava/lang/Object;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/lang/Object;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p2, "method"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/content/Context;",
            "TT;",
            "Lcom/amazon/identity/auth/device/api/AuthenticationMethod;",
            ")",
            "Ljava/lang/Object;"
        }
    .end annotation

    .prologue
    .line 115
    .local p1, "request":Ljava/lang/Object;, "TT;"
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 116
    .local v1, "interfacesThisHttpRequestShouldImplement":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Class<*>;>;"
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory;->getAllInterfacesImplementedByClass(Ljava/lang/Class;)Ljava/util/Set;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 117
    const-class v2, Lcom/amazon/identity/auth/device/api/AuthenticatedHttpRequest;

    invoke-interface {v1, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 119
    new-instance v0, Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler;

    invoke-direct {v0, p1, p2}, Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler;-><init>(Ljava/lang/Object;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V

    .line 122
    .local v0, "httpRequestInvocationHandler":Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler;, "Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler<TT;>;"
    invoke-virtual {p0}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v3

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Class;

    invoke-interface {v1, v2}, Ljava/util/Set;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/Class;

    invoke-static {v3, v2, v0}, Ljava/lang/reflect/Proxy;->newProxyInstance(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;

    move-result-object v2

    return-object v2
.end method

.method private static getAllInterfacesImplementedByClass(Ljava/lang/Class;)Ljava/util/Set;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Class",
            "<*>;>;"
        }
    .end annotation

    .prologue
    .line 129
    .local p0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 130
    .local v0, "interfacesClassImplements":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Class<*>;>;"
    move-object v1, p0

    .line 132
    .local v1, "tempClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_0
    const-class v2, Ljava/lang/Object;

    invoke-virtual {v2, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 134
    invoke-virtual {v1}, Ljava/lang/Class;->getInterfaces()[Ljava/lang/Class;

    move-result-object v2

    invoke-static {v2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 136
    invoke-virtual {v1}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object v1

    goto :goto_0

    .line 139
    :cond_0
    return-object v0
.end method
