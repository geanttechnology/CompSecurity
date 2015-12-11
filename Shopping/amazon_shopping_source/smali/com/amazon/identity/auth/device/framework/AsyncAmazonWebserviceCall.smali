.class public Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;
.super Ljava/lang/Object;
.source "AsyncAmazonWebserviceCall.java"

# interfaces
.implements Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private mHandler:Landroid/os/Handler;

.field private final mInner:Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;

.field private final mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "webRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p3, "callback"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;
    .param p4, "requestSigner"    # Lcom/amazon/identity/kcpsdk/auth/RequestSigner;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->mContext:Landroid/content/Context;

    .line 32
    iput-object p5, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    .line 33
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v6

    .line 35
    .local v6, "mainLooper":Landroid/os/Looper;
    if-eqz v6, :cond_0

    .line 37
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0, v6}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->mHandler:Landroid/os/Handler;

    .line 44
    :goto_0
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->mContext:Landroid/content/Context;

    if-nez p3, :cond_1

    const/4 v3, 0x0

    :goto_1
    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    move-object v2, p2

    move-object v4, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;-><init>(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->mInner:Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;

    .line 50
    return-void

    .line 41
    :cond_0
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->mHandler:Landroid/os/Handler;

    goto :goto_0

    .line 44
    :cond_1
    new-instance v3, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;

    invoke-direct {v3, p0, p3}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;-><init>(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;)V

    goto :goto_1
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;)Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->mInner:Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;

    return-object v0
.end method


# virtual methods
.method public call()V
    .locals 1

    .prologue
    .line 124
    new-instance v0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$2;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$2;-><init>(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    .line 132
    return-void
.end method
