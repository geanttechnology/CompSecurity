.class public Lcom/amazon/identity/auth/device/callback/CallbackFuture;
.super Ljava/lang/Object;
.source "CallbackFuture.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;
.implements Lcom/amazon/identity/auth/device/api/MAPFuture;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/identity/auth/device/api/Callback;",
        "Lcom/amazon/identity/auth/device/api/MAPFuture",
        "<",
        "Landroid/os/Bundle;",
        ">;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mCallback:Lcom/amazon/identity/auth/device/api/Callback;

.field private mError:Landroid/os/Bundle;

.field private final mLatch:Ljava/util/concurrent/CountDownLatch;

.field private mSuccessResult:Landroid/os/Bundle;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 30
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 31
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 2
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    if-nez p1, :cond_0

    new-instance p1, Lcom/amazon/identity/auth/device/api/DefaultCallback;

    .end local p1    # "callback":Lcom/amazon/identity/auth/device/api/Callback;
    invoke-direct {p1}, Lcom/amazon/identity/auth/device/api/DefaultCallback;-><init>()V

    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    .line 36
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->mLatch:Ljava/util/concurrent/CountDownLatch;

    .line 37
    return-void
.end method

.method public static create(Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    .locals 1
    .param p0, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 41
    instance-of v0, p0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    if-eqz v0, :cond_0

    .line 43
    check-cast p0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    .line 47
    .end local p0    # "callback":Lcom/amazon/identity/auth/device/api/Callback;
    :goto_0
    return-object p0

    .restart local p0    # "callback":Lcom/amazon/identity/auth/device/api/Callback;
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    move-object p0, v0

    goto :goto_0
.end method

.method private getResultHelper()Landroid/os/Bundle;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
        }
    .end annotation

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->mError:Landroid/os/Bundle;

    if-eqz v0, :cond_0

    .line 100
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->mError:Landroid/os/Bundle;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;-><init>(Landroid/os/Bundle;)V

    throw v0

    .line 103
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->mSuccessResult:Landroid/os/Bundle;

    return-object v0
.end method

.method private throwOnMainThread()V
    .locals 2

    .prologue
    .line 108
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->isRunningOnMainThread()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 110
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "Cannot call get on the main thread, unless you want ANRs"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 113
    :cond_0
    return-void
.end method


# virtual methods
.method public get()Landroid/os/Bundle;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;,
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;
        }
    .end annotation

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->throwOnMainThread()V

    .line 56
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->mLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->await()V

    .line 57
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->getResultHelper()Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public get(JLjava/util/concurrent/TimeUnit;)Landroid/os/Bundle;
    .locals 2
    .param p1, "timeout"    # J
    .param p3, "unit"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;,
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 64
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->throwOnMainThread()V

    .line 66
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->mLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0, p1, p2, p3}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 68
    sget-object v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Timed out waiting for result!"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    new-instance v0, Ljava/util/concurrent/TimeoutException;

    const-string/jumbo v1, "Timed out waiting for result!"

    invoke-direct {v0, v1}, Ljava/util/concurrent/TimeoutException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 73
    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->getResultHelper()Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;,
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;
        }
    .end annotation

    .prologue
    .line 18
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->get()Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # J
    .param p3, "x1"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;,
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 18
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->get(JLjava/util/concurrent/TimeUnit;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public onError(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 89
    sget-object v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->TAG:Ljava/lang/String;

    .line 90
    iput-object p1, p0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->mError:Landroid/os/Bundle;

    .line 92
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->mLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 93
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v0, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 94
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 79
    sget-object v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->TAG:Ljava/lang/String;

    .line 80
    iput-object p1, p0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->mSuccessResult:Landroid/os/Bundle;

    .line 82
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->mLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v0, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    .line 84
    return-void
.end method
