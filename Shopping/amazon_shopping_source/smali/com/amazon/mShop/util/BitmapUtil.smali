.class public Lcom/amazon/mShop/util/BitmapUtil;
.super Ljava/lang/Object;
.source "BitmapUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/util/BitmapUtil$DelayedRetryRunnable;
    }
.end annotation


# static fields
.field private static sScheduledExecSvc:Ljava/util/concurrent/ScheduledExecutorService;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const/4 v0, 0x3

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newScheduledThreadPool(I)Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/util/BitmapUtil;->sScheduledExecSvc:Ljava/util/concurrent/ScheduledExecutorService;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    return-void
.end method

.method static synthetic access$000()Ljava/util/concurrent/ScheduledExecutorService;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/amazon/mShop/util/BitmapUtil;->sScheduledExecSvc:Ljava/util/concurrent/ScheduledExecutorService;

    return-object v0
.end method

.method public static loadImage(Landroid/content/res/Resources;IZZZZ)Landroid/graphics/Bitmap;
    .locals 2
    .param p0, "res"    # Landroid/content/res/Resources;
    .param p1, "resId"    # I
    .param p2, "isOrigBitmap"    # Z
    .param p3, "isPurgeable"    # Z
    .param p4, "isInputShareable"    # Z
    .param p5, "isLowQuality"    # Z

    .prologue
    .line 146
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 151
    .local v0, "options":Landroid/graphics/BitmapFactory$Options;
    if-nez p2, :cond_1

    const/4 v1, 0x1

    :goto_0
    iput-boolean v1, v0, Landroid/graphics/BitmapFactory$Options;->inScaled:Z

    .line 156
    iput-boolean p3, v0, Landroid/graphics/BitmapFactory$Options;->inPurgeable:Z

    .line 160
    iput-boolean p4, v0, Landroid/graphics/BitmapFactory$Options;->inInputShareable:Z

    .line 162
    if-eqz p5, :cond_0

    .line 165
    sget-object v1, Landroid/graphics/Bitmap$Config;->ARGB_4444:Landroid/graphics/Bitmap$Config;

    iput-object v1, v0, Landroid/graphics/BitmapFactory$Options;->inPreferredConfig:Landroid/graphics/Bitmap$Config;

    .line 167
    :cond_0
    invoke-static {p0, p1, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v1

    return-object v1

    .line 151
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static setImageResource(Landroid/widget/ImageView;I)V
    .locals 2
    .param p0, "imgView"    # Landroid/widget/ImageView;
    .param p1, "resId"    # I

    .prologue
    .line 120
    if-lez p1, :cond_0

    if-eqz p0, :cond_0

    .line 122
    :try_start_0
    invoke-virtual {p0, p1}, Landroid/widget/ImageView;->setImageResource(I)V
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    .line 128
    :cond_0
    :goto_0
    return-void

    .line 123
    :catch_0
    move-exception v0

    .line 124
    .local v0, "oome":Ljava/lang/OutOfMemoryError;
    const/16 v1, 0x32

    invoke-static {v1}, Lcom/amazon/mShop/net/LRUCache;->reduceByPercent(I)V

    .line 125
    invoke-static {}, Ljava/lang/System;->gc()V

    goto :goto_0
.end method

.method public static tryInCaseOfOutOfMemory(Ljava/lang/Runnable;)V
    .locals 5
    .param p0, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 26
    sget-object v0, Lcom/amazon/mShop/util/BitmapUtil;->sScheduledExecSvc:Ljava/util/concurrent/ScheduledExecutorService;

    new-instance v1, Lcom/amazon/mShop/util/BitmapUtil$DelayedRetryRunnable;

    const/4 v2, 0x0

    invoke-direct {v1, v2, p0}, Lcom/amazon/mShop/util/BitmapUtil$DelayedRetryRunnable;-><init>(ILjava/lang/Runnable;)V

    const-wide/16 v2, 0x0

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v0, v1, v2, v3, v4}, Ljava/util/concurrent/ScheduledExecutorService;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 27
    return-void
.end method
