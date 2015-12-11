.class public abstract Lcom/amazon/mShop/android/platform/services/ProxyService;
.super Landroid/app/Service;
.source "ProxyService.java"

# interfaces
.implements Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;


# instance fields
.field private mDelegate:Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase",
            "<",
            "Lcom/amazon/mShop/android/platform/services/ProxyService;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    return-void
.end method


# virtual methods
.method public dump(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .locals 1
    .param p1, "fd"    # Ljava/io/FileDescriptor;
    .param p2, "writer"    # Ljava/io/PrintWriter;
    .param p3, "args"    # [Ljava/lang/String;

    .prologue
    .line 96
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyService;->getDelegate()Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->dump_impl(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    .line 97
    return-void
.end method

.method public getClassLoader()Ljava/lang/ClassLoader;
    .locals 1

    .prologue
    .line 158
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getDelegate()Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase",
            "<",
            "Lcom/amazon/mShop/android/platform/services/ProxyService;",
            ">;"
        }
    .end annotation

    .prologue
    .line 21
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/android/platform/services/ProxyService;->mDelegate:Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v1, :cond_0

    .line 23
    :try_start_1
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->createServiceDelegate(Landroid/app/Service;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;

    iput-object v1, p0, Lcom/amazon/mShop/android/platform/services/ProxyService;->mDelegate:Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 37
    :cond_0
    :goto_0
    :try_start_2
    iget-object v1, p0, Lcom/amazon/mShop/android/platform/services/ProxyService;->mDelegate:Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    monitor-exit p0

    return-object v1

    .line 24
    :catch_0
    move-exception v0

    .line 25
    .local v0, "e":Ljava/lang/Exception;
    :try_start_3
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/amazon/mShop/android/platform/dex/ExceptionUtil;->reportExceptions(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 29
    new-instance v1, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;-><init>(Landroid/app/Service;)V

    iput-object v1, p0, Lcom/amazon/mShop/android/platform/services/ProxyService;->mDelegate:Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;

    .line 34
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyService;->stopSelf()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 21
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method protected getDexEntry()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;
    .locals 1

    .prologue
    .line 41
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v0

    return-object v0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 66
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyService;->getDelegate()Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->onConfigurationChanged_impl(Landroid/content/res/Configuration;)V

    .line 67
    return-void
.end method

.method public onCreate()V
    .locals 1

    .prologue
    .line 46
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyService;->getDelegate()Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->onCreate_impl()V

    .line 47
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 61
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyService;->getDelegate()Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->onDestroy_impl()V

    .line 62
    return-void
.end method

.method public onLowMemory()V
    .locals 1

    .prologue
    .line 71
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyService;->getDelegate()Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->onLowMemory_impl()V

    .line 72
    return-void
.end method

.method public onRebind(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 86
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyService;->getDelegate()Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->onRebind_impl(Landroid/content/Intent;)V

    .line 87
    return-void
.end method

.method public onStart(Landroid/content/Intent;I)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "startId"    # I

    .prologue
    .line 51
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyService;->getDelegate()Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->onStart_impl(Landroid/content/Intent;I)V

    .line 52
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 56
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyService;->getDelegate()Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->onStartCommand_impl(Landroid/content/Intent;II)I

    move-result v0

    return v0
.end method

.method public onTaskRemoved(Landroid/content/Intent;)V
    .locals 1
    .param p1, "rootIntent"    # Landroid/content/Intent;

    .prologue
    .line 91
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyService;->getDelegate()Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->onTaskRemoved_impl(Landroid/content/Intent;)V

    .line 92
    return-void
.end method

.method public onTrimMemory(I)V
    .locals 1
    .param p1, "level"    # I

    .prologue
    .line 76
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyService;->getDelegate()Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->onTrimMemory_impl(I)V

    .line 77
    return-void
.end method

.method public onUnbind(Landroid/content/Intent;)Z
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 81
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyService;->getDelegate()Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/services/ServiceDelegateBase;->onUnbind_impl(Landroid/content/Intent;)Z

    move-result v0

    return v0
.end method

.method public superDump(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .locals 0
    .param p1, "fd"    # Ljava/io/FileDescriptor;
    .param p2, "writer"    # Ljava/io/PrintWriter;
    .param p3, "args"    # [Ljava/lang/String;

    .prologue
    .line 153
    invoke-super {p0, p1, p2, p3}, Landroid/app/Service;->dump(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    .line 154
    return-void
.end method

.method public superOnConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 121
    invoke-super {p0, p1}, Landroid/app/Service;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 122
    return-void
.end method

.method public superOnCreate()V
    .locals 0

    .prologue
    .line 101
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 102
    return-void
.end method

.method public superOnDestroy()V
    .locals 0

    .prologue
    .line 116
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 117
    return-void
.end method

.method public superOnLowMemory()V
    .locals 0

    .prologue
    .line 126
    invoke-super {p0}, Landroid/app/Service;->onLowMemory()V

    .line 127
    return-void
.end method

.method public superOnRebind(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 142
    invoke-super {p0, p1}, Landroid/app/Service;->onRebind(Landroid/content/Intent;)V

    .line 143
    return-void
.end method

.method public superOnStart(Landroid/content/Intent;I)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "startId"    # I

    .prologue
    .line 106
    invoke-super {p0, p1, p2}, Landroid/app/Service;->onStart(Landroid/content/Intent;I)V

    .line 107
    return-void
.end method

.method public superOnStartCommand(Landroid/content/Intent;II)I
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 111
    invoke-super {p0, p1, p2, p3}, Landroid/app/Service;->onStartCommand(Landroid/content/Intent;II)I

    move-result v0

    return v0
.end method

.method public superOnTaskRemoved(Landroid/content/Intent;)V
    .locals 0
    .param p1, "rootIntent"    # Landroid/content/Intent;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 148
    invoke-super {p0, p1}, Landroid/app/Service;->onTaskRemoved(Landroid/content/Intent;)V

    .line 149
    return-void
.end method

.method public superOnTrimMemory(I)V
    .locals 0
    .param p1, "level"    # I
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 132
    invoke-super {p0, p1}, Landroid/app/Service;->onTrimMemory(I)V

    .line 133
    return-void
.end method

.method public superOnUnbind(Landroid/content/Intent;)Z
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 137
    invoke-super {p0, p1}, Landroid/app/Service;->onUnbind(Landroid/content/Intent;)Z

    move-result v0

    return v0
.end method
