.class Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;
.super Ljava/lang/Object;
.source "BlockingBindingConnection.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SdkServiceConnection"
.end annotation


# instance fields
.field private final mConnectionNotifier:Ljava/lang/Object;

.field private volatile mServiceHolder:Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 97
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 98
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;->mConnectionNotifier:Ljava/lang/Object;

    .line 100
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;->mServiceHolder:Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$1;

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;-><init>()V

    return-void
.end method


# virtual methods
.method getService()Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 143
    iget-object v2, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;->mConnectionNotifier:Ljava/lang/Object;

    monitor-enter v2

    .line 144
    :goto_0
    :try_start_0
    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;->mServiceHolder:Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;

    if-nez v1, :cond_0

    .line 145
    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;->mConnectionNotifier:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->wait()V

    goto :goto_0

    .line 149
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .line 148
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;->mServiceHolder:Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;

    .line 149
    .local v0, "sdk":Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 151
    return-object v0
.end method

.method isConnected()Z
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;->mServiceHolder:Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 2
    .param p1, "name"    # Landroid/content/ComponentName;
    .param p2, "service"    # Landroid/os/IBinder;

    .prologue
    .line 104
    const-string/jumbo v0, "AmazonVideo"

    const-string/jumbo v1, "SDK connected to AIV"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 106
    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;->mConnectionNotifier:Ljava/lang/Object;

    monitor-enter v1

    .line 107
    :try_start_0
    invoke-static {p2}, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;->mServiceHolder:Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;

    .line 108
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;->mConnectionNotifier:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    .line 109
    monitor-exit v1

    .line 110
    return-void

    .line 109
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 2
    .param p1, "name"    # Landroid/content/ComponentName;

    .prologue
    .line 114
    const-string/jumbo v0, "AmazonVideo"

    const-string/jumbo v1, "SDK disconnected from AIV"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 121
    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;->mConnectionNotifier:Ljava/lang/Object;

    monitor-enter v1

    .line 122
    const/4 v0, 0x0

    :try_start_0
    iput-object v0, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;->mServiceHolder:Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;

    .line 123
    monitor-exit v1

    .line 124
    return-void

    .line 123
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
