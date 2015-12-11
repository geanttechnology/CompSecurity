.class final Ltv/freewheel/hybrid/utils/http/SimpleHttpClient$1;
.super Ljava/lang/Object;
.source "SimpleHttpClient.java"

# interfaces
.implements Lorg/apache/http/HttpRequestInterceptor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/hybrid/utils/http/SimpleHttpClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public process(Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)V
    .locals 2
    .param p1, "request"    # Lorg/apache/http/HttpRequest;
    .param p2, "context"    # Lorg/apache/http/protocol/HttpContext;

    .prologue
    .line 57
    # getter for: Ltv/freewheel/hybrid/utils/http/SimpleHttpClient;->sThreadBlocked:Ljava/lang/ThreadLocal;
    invoke-static {}, Ltv/freewheel/hybrid/utils/http/SimpleHttpClient;->access$000()Ljava/lang/ThreadLocal;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    # getter for: Ltv/freewheel/hybrid/utils/http/SimpleHttpClient;->sThreadBlocked:Ljava/lang/ThreadLocal;
    invoke-static {}, Ltv/freewheel/hybrid/utils/http/SimpleHttpClient;->access$000()Ljava/lang/ThreadLocal;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 58
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "This thread forbids HTTP requests"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 60
    :cond_0
    return-void
.end method
