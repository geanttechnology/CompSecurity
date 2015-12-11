.class public Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;
.super Ljava/lang/Object;
.source "MShopUiOOMHandler.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/util/MShopUiOOMHandler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UiRunnable"
.end annotation


# instance fields
.field private mNeedRetry:Z

.field private mRetryCounter:I

.field private mRunnable:Ljava/lang/Runnable;


# direct methods
.method public constructor <init>(Ljava/lang/Runnable;Z)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;
    .param p2, "needRetry"    # Z

    .prologue
    .line 72
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;->mRetryCounter:I

    .line 73
    iput-object p1, p0, Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;->mRunnable:Ljava/lang/Runnable;

    .line 74
    iput-boolean p2, p0, Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;->mNeedRetry:Z

    .line 75
    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 80
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;->mRunnable:Ljava/lang/Runnable;

    invoke-interface {v1}, Ljava/lang/Runnable;->run()V
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    .line 90
    :cond_0
    :goto_0
    return-void

    .line 81
    :catch_0
    move-exception v0

    .line 82
    .local v0, "e":Ljava/lang/OutOfMemoryError;
    const/16 v1, 0x32

    invoke-static {v1}, Lcom/amazon/mShop/net/LRUCache;->reduceByPercent(I)V

    .line 83
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 84
    const-string/jumbo v2, "OutOfMemory"

    invoke-virtual {v0}, Ljava/lang/OutOfMemoryError;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string/jumbo v1, "OutOfMemory"

    :goto_1
    invoke-static {v2, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 86
    iget-boolean v1, p0, Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;->mNeedRetry:Z

    if-eqz v1, :cond_0

    iget v1, p0, Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;->mRetryCounter:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;->mRetryCounter:I

    const/4 v2, 0x3

    if-ge v1, v2, :cond_0

    .line 87
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    const-wide/16 v2, 0xe6

    invoke-interface {v1, p0, v2, v3}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    goto :goto_0

    .line 84
    :cond_1
    invoke-virtual {v0}, Ljava/lang/OutOfMemoryError;->getMessage()Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method
