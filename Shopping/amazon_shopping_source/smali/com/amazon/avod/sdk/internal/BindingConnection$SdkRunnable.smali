.class abstract Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;
.super Ljava/lang/Object;
.source "BindingConnection.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/avod/sdk/internal/BindingConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x40a
    name = "SdkRunnable"
.end annotation


# instance fields
.field private final mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;


# direct methods
.method private constructor <init>(Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;)V
    .locals 0
    .param p1, "serviceConnection"    # Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

    .prologue
    .line 327
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 328
    iput-object p1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

    .line 329
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;Lcom/amazon/avod/sdk/internal/BindingConnection$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;
    .param p2, "x1"    # Lcom/amazon/avod/sdk/internal/BindingConnection$1;

    .prologue
    .line 324
    invoke-direct {p0, p1}, Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;-><init>(Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;)V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    .prologue
    .line 337
    :try_start_0
    iget-object v2, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

    invoke-virtual {v2}, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->isConnected()Z

    move-result v2

    if-nez v2, :cond_0

    .line 338
    iget-object v2, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

    invoke-virtual {v2}, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->bind()V

    .line 342
    :cond_0
    iget-object v2, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

    invoke-virtual {v2}, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->getService()Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;

    move-result-object v1

    .line 343
    .local v1, "playbackSdk":Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;
    invoke-virtual {p0, v1}, Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;->run(Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1

    .line 355
    .end local v1    # "playbackSdk":Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;
    :goto_0
    return-void

    .line 344
    :catch_0
    move-exception v0

    .line 351
    .local v0, "e":Landroid/os/RemoteException;
    const-string/jumbo v2, "AmazonInstantVideoSDK"

    const-string/jumbo v3, "RemoteException calling to the service"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 352
    .end local v0    # "e":Landroid/os/RemoteException;
    :catch_1
    move-exception v0

    .line 353
    .local v0, "e":Ljava/lang/InterruptedException;
    const-string/jumbo v2, "AmazonInstantVideoSDK"

    const-string/jumbo v3, "InterruptedException calling to the service"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method protected abstract run(Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method
