.class public Lcom/auditude/ads/util/TimeoutUtil;
.super Ljava/lang/Object;
.source "TimeoutUtil.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/auditude/ads/util/TimeoutUtil$TimeoutCompleteListener;
    }
.end annotation


# instance fields
.field private data:Ljava/lang/Object;

.field private inProgress:Z

.field private isCanceled:Z

.field private listener:Lcom/auditude/ads/util/TimeoutUtil$TimeoutCompleteListener;

.field private mHandler:Landroid/os/Handler;


# direct methods
.method public constructor <init>(Ljava/lang/Object;)V
    .locals 1
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x0

    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    iput-boolean v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->inProgress:Z

    .line 11
    iput-boolean v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->isCanceled:Z

    .line 15
    iput-object p1, p0, Lcom/auditude/ads/util/TimeoutUtil;->data:Ljava/lang/Object;

    .line 16
    return-void
.end method

.method private CleanupTimer()V
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->mHandler:Landroid/os/Handler;

    if-eqz v0, :cond_0

    .line 79
    iget-object v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0, p0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 80
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->mHandler:Landroid/os/Handler;

    .line 82
    :cond_0
    return-void
.end method


# virtual methods
.method public final Begin(J)V
    .locals 3
    .param p1, "delayInMillis"    # J

    .prologue
    .line 35
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->isCanceled:Z

    .line 37
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-lez v0, :cond_0

    .line 39
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->mHandler:Landroid/os/Handler;

    .line 40
    iget-object v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0, p0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 41
    iget-object v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0, p0, p1, p2}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 44
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->inProgress:Z

    .line 45
    return-void
.end method

.method public addTimeoutCompleteListener(Lcom/auditude/ads/util/TimeoutUtil$TimeoutCompleteListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/auditude/ads/util/TimeoutUtil$TimeoutCompleteListener;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/auditude/ads/util/TimeoutUtil;->listener:Lcom/auditude/ads/util/TimeoutUtil$TimeoutCompleteListener;

    .line 21
    return-void
.end method

.method public dispose()V
    .locals 1

    .prologue
    .line 91
    invoke-direct {p0}, Lcom/auditude/ads/util/TimeoutUtil;->CleanupTimer()V

    .line 92
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->listener:Lcom/auditude/ads/util/TimeoutUtil$TimeoutCompleteListener;

    .line 93
    return-void
.end method

.method public final getData()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->data:Ljava/lang/Object;

    return-object v0
.end method

.method public final getIsCanceled()Z
    .locals 1

    .prologue
    .line 30
    iget-boolean v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->isCanceled:Z

    return v0
.end method

.method public run()V
    .locals 1

    .prologue
    .line 50
    iget-boolean v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->inProgress:Z

    if-eqz v0, :cond_0

    .line 52
    invoke-direct {p0}, Lcom/auditude/ads/util/TimeoutUtil;->CleanupTimer()V

    .line 53
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->inProgress:Z

    .line 54
    iget-object v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->listener:Lcom/auditude/ads/util/TimeoutUtil$TimeoutCompleteListener;

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Lcom/auditude/ads/util/TimeoutUtil;->listener:Lcom/auditude/ads/util/TimeoutUtil$TimeoutCompleteListener;

    invoke-interface {v0, p0}, Lcom/auditude/ads/util/TimeoutUtil$TimeoutCompleteListener;->onTimeoutComplete(Lcom/auditude/ads/util/TimeoutUtil;)V

    .line 59
    :cond_0
    return-void
.end method
