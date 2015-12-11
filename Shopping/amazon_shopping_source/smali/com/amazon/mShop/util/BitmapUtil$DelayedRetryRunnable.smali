.class Lcom/amazon/mShop/util/BitmapUtil$DelayedRetryRunnable;
.super Ljava/lang/Object;
.source "BitmapUtil.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/util/BitmapUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DelayedRetryRunnable"
.end annotation


# instance fields
.field private mRunnable:Ljava/lang/Runnable;

.field private mTrySeq:I


# direct methods
.method public constructor <init>(ILjava/lang/Runnable;)V
    .locals 1
    .param p1, "trySeq"    # I
    .param p2, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/util/BitmapUtil$DelayedRetryRunnable;->mTrySeq:I

    .line 63
    iput p1, p0, Lcom/amazon/mShop/util/BitmapUtil$DelayedRetryRunnable;->mTrySeq:I

    .line 64
    iput-object p2, p0, Lcom/amazon/mShop/util/BitmapUtil$DelayedRetryRunnable;->mRunnable:Ljava/lang/Runnable;

    .line 65
    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 70
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/util/BitmapUtil$DelayedRetryRunnable;->mRunnable:Ljava/lang/Runnable;

    invoke-interface {v1}, Ljava/lang/Runnable;->run()V
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    .line 83
    :goto_0
    return-void

    .line 71
    :catch_0
    move-exception v0

    .line 73
    .local v0, "oome":Ljava/lang/OutOfMemoryError;
    iget v1, p0, Lcom/amazon/mShop/util/BitmapUtil$DelayedRetryRunnable;->mTrySeq:I

    add-int/lit8 v1, v1, 0x1

    const/4 v2, 0x3

    if-ge v1, v2, :cond_0

    .line 75
    # getter for: Lcom/amazon/mShop/util/BitmapUtil;->sScheduledExecSvc:Ljava/util/concurrent/ScheduledExecutorService;
    invoke-static {}, Lcom/amazon/mShop/util/BitmapUtil;->access$000()Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/util/BitmapUtil$DelayedRetryRunnable;

    iget v3, p0, Lcom/amazon/mShop/util/BitmapUtil$DelayedRetryRunnable;->mTrySeq:I

    add-int/lit8 v3, v3, 0x1

    iget-object v4, p0, Lcom/amazon/mShop/util/BitmapUtil$DelayedRetryRunnable;->mRunnable:Ljava/lang/Runnable;

    invoke-direct {v2, v3, v4}, Lcom/amazon/mShop/util/BitmapUtil$DelayedRetryRunnable;-><init>(ILjava/lang/Runnable;)V

    const-wide/16 v3, 0xe6

    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v1, v2, v3, v4, v5}, Ljava/util/concurrent/ScheduledExecutorService;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 81
    :cond_0
    invoke-static {}, Ljava/lang/System;->gc()V

    goto :goto_0
.end method
