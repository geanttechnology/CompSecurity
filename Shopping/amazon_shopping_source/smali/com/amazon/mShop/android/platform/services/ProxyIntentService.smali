.class public abstract Lcom/amazon/mShop/android/platform/services/ProxyIntentService;
.super Landroid/app/IntentService;
.source "ProxyIntentService.java"

# interfaces
.implements Lcom/amazon/mShop/android/platform/services/api/IAndroidIntentServiceProxy;


# instance fields
.field private mDelegate:Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase",
            "<",
            "Lcom/amazon/mShop/android/platform/services/ProxyIntentService;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 20
    invoke-direct {p0, p1}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 21
    return-void
.end method


# virtual methods
.method public dump(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .locals 1
    .param p1, "fd"    # Ljava/io/FileDescriptor;
    .param p2, "writer"    # Ljava/io/PrintWriter;
    .param p3, "args"    # [Ljava/lang/String;

    .prologue
    .line 111
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->getDelegate()Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;->dump_impl(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    .line 112
    return-void
.end method

.method public getClassLoader()Ljava/lang/ClassLoader;
    .locals 1

    .prologue
    .line 183
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getDelegate()Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase",
            "<",
            "Lcom/amazon/mShop/android/platform/services/ProxyIntentService;",
            ">;"
        }
    .end annotation

    .prologue
    .line 26
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->mDelegate:Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v1, :cond_0

    .line 28
    :try_start_1
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->createServiceDelegate(Landroid/app/Service;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    iput-object v1, p0, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->mDelegate:Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 42
    :cond_0
    :goto_0
    :try_start_2
    iget-object v1, p0, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->mDelegate:Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    monitor-exit p0

    return-object v1

    .line 29
    :catch_0
    move-exception v0

    .line 30
    .local v0, "e":Ljava/lang/Exception;
    :try_start_3
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/amazon/mShop/android/platform/dex/ExceptionUtil;->reportExceptions(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 34
    new-instance v1, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;-><init>(Landroid/app/IntentService;)V

    iput-object v1, p0, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->mDelegate:Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    .line 39
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->stopSelf()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 26
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method protected getDexEntry()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;
    .locals 1

    .prologue
    .line 46
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v0

    return-object v0
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 86
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->getDelegate()Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;->onBind_impl(Landroid/content/Intent;)Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 71
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->getDelegate()Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;->onConfigurationChanged_impl(Landroid/content/res/Configuration;)V

    .line 72
    return-void
.end method

.method public onCreate()V
    .locals 1

    .prologue
    .line 51
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->getDelegate()Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;->onCreate_impl()V

    .line 52
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 66
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->getDelegate()Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;->onDestroy_impl()V

    .line 67
    return-void
.end method

.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 1
    .param p1, "paramIntent"    # Landroid/content/Intent;

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->getDelegate()Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;->onHandleIntent_impl(Landroid/content/Intent;)V

    .line 107
    return-void
.end method

.method public onLowMemory()V
    .locals 1

    .prologue
    .line 76
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->getDelegate()Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;->onLowMemory_impl()V

    .line 77
    return-void
.end method

.method public onRebind(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 96
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->getDelegate()Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;->onRebind_impl(Landroid/content/Intent;)V

    .line 97
    return-void
.end method

.method public onStart(Landroid/content/Intent;I)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "startId"    # I

    .prologue
    .line 56
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->getDelegate()Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;->onStart_impl(Landroid/content/Intent;I)V

    .line 57
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 61
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->getDelegate()Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;->onStartCommand_impl(Landroid/content/Intent;II)I

    move-result v0

    return v0
.end method

.method public onTaskRemoved(Landroid/content/Intent;)V
    .locals 1
    .param p1, "rootIntent"    # Landroid/content/Intent;

    .prologue
    .line 101
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->getDelegate()Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;->onTaskRemoved_impl(Landroid/content/Intent;)V

    .line 102
    return-void
.end method

.method public onTrimMemory(I)V
    .locals 1
    .param p1, "level"    # I

    .prologue
    .line 81
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->getDelegate()Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;->onTrimMemory_impl(I)V

    .line 82
    return-void
.end method

.method public onUnbind(Landroid/content/Intent;)Z
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 91
    invoke-virtual {p0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;->getDelegate()Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/services/IntentServiceDelegateBase;->onUnbind_impl(Landroid/content/Intent;)Z

    move-result v0

    return v0
.end method

.method public superDump(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .locals 0
    .param p1, "fd"    # Ljava/io/FileDescriptor;
    .param p2, "writer"    # Ljava/io/PrintWriter;
    .param p3, "args"    # [Ljava/lang/String;

    .prologue
    .line 173
    invoke-super {p0, p1, p2, p3}, Landroid/app/IntentService;->dump(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    .line 174
    return-void
.end method

.method public superOnBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 152
    invoke-super {p0, p1}, Landroid/app/IntentService;->onBind(Landroid/content/Intent;)Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public superOnConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 136
    invoke-super {p0, p1}, Landroid/app/IntentService;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 137
    return-void
.end method

.method public superOnCreate()V
    .locals 0

    .prologue
    .line 116
    invoke-super {p0}, Landroid/app/IntentService;->onCreate()V

    .line 117
    return-void
.end method

.method public superOnDestroy()V
    .locals 0

    .prologue
    .line 131
    invoke-super {p0}, Landroid/app/IntentService;->onDestroy()V

    .line 132
    return-void
.end method

.method public superOnLowMemory()V
    .locals 0

    .prologue
    .line 141
    invoke-super {p0}, Landroid/app/IntentService;->onLowMemory()V

    .line 142
    return-void
.end method

.method public superOnRebind(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 162
    invoke-super {p0, p1}, Landroid/app/IntentService;->onRebind(Landroid/content/Intent;)V

    .line 163
    return-void
.end method

.method public superOnStart(Landroid/content/Intent;I)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "startId"    # I

    .prologue
    .line 121
    invoke-super {p0, p1, p2}, Landroid/app/IntentService;->onStart(Landroid/content/Intent;I)V

    .line 122
    return-void
.end method

.method public superOnStartCommand(Landroid/content/Intent;II)I
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 126
    invoke-super {p0, p1, p2, p3}, Landroid/app/IntentService;->onStartCommand(Landroid/content/Intent;II)I

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
    .line 168
    invoke-super {p0, p1}, Landroid/app/IntentService;->onTaskRemoved(Landroid/content/Intent;)V

    .line 169
    return-void
.end method

.method public superOnTrimMemory(I)V
    .locals 0
    .param p1, "level"    # I
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 147
    invoke-super {p0, p1}, Landroid/app/IntentService;->onTrimMemory(I)V

    .line 148
    return-void
.end method

.method public superOnUnbind(Landroid/content/Intent;)Z
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 157
    invoke-super {p0, p1}, Landroid/app/IntentService;->onUnbind(Landroid/content/Intent;)Z

    move-result v0

    return v0
.end method

.method public superSetIntentRedelivery(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 178
    invoke-super {p0, p1}, Landroid/app/IntentService;->setIntentRedelivery(Z)V

    .line 179
    return-void
.end method
