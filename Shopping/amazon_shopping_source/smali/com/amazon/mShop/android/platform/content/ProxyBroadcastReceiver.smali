.class public Lcom/amazon/mShop/android/platform/content/ProxyBroadcastReceiver;
.super Landroid/content/BroadcastReceiver;
.source "ProxyBroadcastReceiver.java"


# instance fields
.field private mDelegate:Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase",
            "<",
            "Lcom/amazon/mShop/android/platform/content/ProxyBroadcastReceiver;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public declared-synchronized getDelegate()Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase",
            "<",
            "Lcom/amazon/mShop/android/platform/content/ProxyBroadcastReceiver;",
            ">;"
        }
    .end annotation

    .prologue
    .line 24
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/android/platform/content/ProxyBroadcastReceiver;->mDelegate:Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v1, :cond_0

    .line 26
    :try_start_1
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->createBroadcastReceiveDelegate(Landroid/content/BroadcastReceiver;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase;

    iput-object v1, p0, Lcom/amazon/mShop/android/platform/content/ProxyBroadcastReceiver;->mDelegate:Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase;
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 33
    :cond_0
    :goto_0
    :try_start_2
    iget-object v1, p0, Lcom/amazon/mShop/android/platform/content/ProxyBroadcastReceiver;->mDelegate:Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    monitor-exit p0

    return-object v1

    .line 27
    :catch_0
    move-exception v0

    .line 30
    .local v0, "e":Ljava/lang/RuntimeException;
    :try_start_3
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/amazon/mShop/android/platform/dex/ExceptionUtil;->reportExceptions(Ljava/lang/String;Ljava/lang/Exception;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 24
    .end local v0    # "e":Ljava/lang/RuntimeException;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 17
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/content/ProxyBroadcastReceiver;->getDelegate()Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase;->onReceive_impl(Landroid/content/Context;Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    .line 21
    :goto_0
    return-void

    .line 18
    :catch_0
    move-exception v0

    goto :goto_0
.end method
