.class Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;
.super Ljava/lang/Object;
.source "BlockingBindingConnection.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$1;,
        Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;
    }
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;

.field private final mServiceIntent:Landroid/content/Intent;


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "serviceIntent"    # Landroid/content/Intent;

    .prologue
    .line 27
    new-instance v0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;-><init>(Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$1;)V

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;-><init>(Landroid/content/Context;Landroid/content/Intent;Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;)V

    .line 28
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Landroid/content/Intent;Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "serviceIntent"    # Landroid/content/Intent;
    .param p3, "serviceConnection"    # Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput-object p1, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mContext:Landroid/content/Context;

    .line 32
    iput-object p2, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mServiceIntent:Landroid/content/Intent;

    .line 33
    iput-object p3, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;

    .line 34
    return-void
.end method


# virtual methods
.method bind()V
    .locals 5

    .prologue
    .line 48
    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mServiceIntent:Landroid/content/Intent;

    invoke-virtual {v1, v2}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 55
    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mServiceIntent:Landroid/content/Intent;

    iget-object v3, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;

    const/4 v4, 0x5

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result v0

    .line 58
    .local v0, "isBound":Z
    if-nez v0, :cond_0

    .line 59
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "Could not bind to the service"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 61
    :cond_0
    return-void
.end method

.method canBind()Z
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 40
    iget-object v2, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 41
    .local v0, "packageManager":Landroid/content/pm/PackageManager;
    iget-object v2, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mServiceIntent:Landroid/content/Intent;

    invoke-virtual {v0, v2, v1}, Landroid/content/pm/PackageManager;->resolveService(Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;

    move-result-object v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    :cond_0
    return v1
.end method

.method getService()Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 84
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 85
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "Calling this from the main thread will cause a deadlock"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 88
    :cond_0
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;

    invoke-virtual {v0}, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;->getService()Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;

    move-result-object v0

    return-object v0
.end method

.method isConnected()Z
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;

    invoke-virtual {v0}, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;->isConnected()Z

    move-result v0

    return v0
.end method

.method unbind()V
    .locals 2

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection$SdkServiceConnection;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    .line 68
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->mServiceIntent:Landroid/content/Intent;

    invoke-virtual {v0, v1}, Landroid/content/Context;->stopService(Landroid/content/Intent;)Z

    .line 69
    return-void
.end method
