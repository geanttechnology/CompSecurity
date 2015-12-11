.class final Lcom/amazon/identity/auth/device/framework/GenericIPCSender$SimpleCallbackFuture;
.super Ljava/lang/Object;
.source "GenericIPCSender.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/framework/GenericIPCSender;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "SimpleCallbackFuture"
.end annotation


# instance fields
.field private final mLatch:Ljava/util/concurrent/CountDownLatch;

.field private mResult:Landroid/os/Bundle;


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 167
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 169
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$SimpleCallbackFuture;->mLatch:Ljava/util/concurrent/CountDownLatch;

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;

    .prologue
    .line 167
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$SimpleCallbackFuture;-><init>()V

    return-void
.end method

.method private setResult(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 198
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$SimpleCallbackFuture;->mResult:Landroid/os/Bundle;

    .line 199
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$SimpleCallbackFuture;->mLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 200
    return-void
.end method


# virtual methods
.method public get(JLjava/util/concurrent/TimeUnit;)Landroid/os/Bundle;
    .locals 1
    .param p1, "timeout"    # J
    .param p3, "unit"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 186
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$SimpleCallbackFuture;->mLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0, p1, p2, p3}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 188
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$SimpleCallbackFuture;->mResult:Landroid/os/Bundle;

    return-object v0

    .line 192
    :cond_0
    new-instance v0, Ljava/util/concurrent/TimeoutException;

    invoke-direct {v0}, Ljava/util/concurrent/TimeoutException;-><init>()V

    throw v0
.end method

.method public onError(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 181
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$SimpleCallbackFuture;->setResult(Landroid/os/Bundle;)V

    .line 182
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 175
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$SimpleCallbackFuture;->setResult(Landroid/os/Bundle;)V

    .line 176
    return-void
.end method
