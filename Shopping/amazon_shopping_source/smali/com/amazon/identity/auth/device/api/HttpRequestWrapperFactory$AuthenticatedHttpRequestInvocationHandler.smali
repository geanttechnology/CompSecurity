.class Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler;
.super Ljava/lang/Object;
.source "HttpRequestWrapperFactory.java"

# interfaces
.implements Ljava/lang/reflect/InvocationHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AuthenticatedHttpRequestInvocationHandler"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/lang/reflect/InvocationHandler;"
    }
.end annotation


# instance fields
.field private final mDummyAuthHttpRequest:Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$DummyAuthenticatedHttpRequest;

.field private final mHttpRequestToWrap:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/Object;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V
    .locals 1
    .param p2, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Lcom/amazon/identity/auth/device/api/AuthenticationMethod;",
            ")V"
        }
    .end annotation

    .prologue
    .line 46
    .local p0, "this":Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler;, "Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler<TT;>;"
    .local p1, "httpRequestToWrap":Ljava/lang/Object;, "TT;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler;->mHttpRequestToWrap:Ljava/lang/Object;

    .line 48
    new-instance v0, Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$DummyAuthenticatedHttpRequest;

    invoke-direct {v0, p2}, Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$DummyAuthenticatedHttpRequest;-><init>(Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler;->mDummyAuthHttpRequest:Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$DummyAuthenticatedHttpRequest;

    .line 49
    return-void
.end method

.method private containsMethod(Ljava/lang/Class;Ljava/lang/reflect/Method;)Z
    .locals 3
    .param p2, "method"    # Ljava/lang/reflect/Method;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/reflect/Method;",
            ")Z"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler;, "Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler<TT;>;"
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v0, 0x0

    .line 68
    :try_start_0
    invoke-virtual {p2}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2}, Ljava/lang/reflect/Method;->getParameterTypes()[Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    .line 76
    :cond_0
    :goto_0
    return v0

    :catch_0
    move-exception v1

    goto :goto_0

    .line 72
    :catch_1
    move-exception v1

    goto :goto_0
.end method


# virtual methods
.method public invoke(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "proxy"    # Ljava/lang/Object;
    .param p2, "method"    # Ljava/lang/reflect/Method;
    .param p3, "args"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 54
    .local p0, "this":Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler;, "Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler;->mHttpRequestToWrap:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler;->containsMethod(Ljava/lang/Class;Ljava/lang/reflect/Method;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler;->mHttpRequestToWrap:Ljava/lang/Object;

    invoke-virtual {p2, v0, p3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 60
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$AuthenticatedHttpRequestInvocationHandler;->mDummyAuthHttpRequest:Lcom/amazon/identity/auth/device/api/HttpRequestWrapperFactory$DummyAuthenticatedHttpRequest;

    invoke-virtual {p2, v0, p3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method
