.class public abstract Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;
.super Ljava/lang/Object;
.source "BoundServiceCaller.java"


# static fields
.field private static final CONNECTION_TIMEOUT:J

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mBindingFlags:I

.field private mConnection:Landroid/content/ServiceConnection;

.field private final mContext:Landroid/content/Context;

.field private final mLocker:[Ljava/lang/Object;

.field private mServiceConnectionWasEstablished:Z

.field private final mServiceIntent:Landroid/content/Intent;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 21
    const-class v0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->TAG:Ljava/lang/String;

    .line 22
    sget-object v0, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v1, 0x3

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->CONNECTION_TIMEOUT:J

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/content/Intent;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "serviceIntent"    # Landroid/content/Intent;
    .param p3, "bindingFlags"    # I

    .prologue
    const/4 v1, 0x0

    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-array v0, v1, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mLocker:[Ljava/lang/Object;

    .line 37
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 39
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 42
    :cond_1
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mContext:Landroid/content/Context;

    .line 43
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mServiceIntent:Landroid/content/Intent;

    .line 44
    iput-boolean v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mServiceConnectionWasEstablished:Z

    .line 46
    new-instance v0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$1;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$1;-><init>(Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mConnection:Landroid/content/ServiceConnection;

    .line 78
    or-int/lit8 v0, p3, 0x4

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xe

    if-lt v1, v2, :cond_2

    or-int/lit8 v0, v0, 0x10

    :cond_2
    iput v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mBindingFlags:I

    .line 79
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    .prologue
    .line 19
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mServiceConnectionWasEstablished:Z

    return v0
.end method

.method static synthetic access$102(Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;
    .param p1, "x1"    # Z

    .prologue
    .line 19
    iput-boolean p1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mServiceConnectionWasEstablished:Z

    return p1
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;)[Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mLocker:[Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$302(Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;Landroid/content/ServiceConnection;)Landroid/content/ServiceConnection;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;
    .param p1, "x1"    # Landroid/content/ServiceConnection;

    .prologue
    .line 19
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mConnection:Landroid/content/ServiceConnection;

    return-object p1
.end method

.method static synthetic access$400(Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;)Landroid/content/Intent;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mServiceIntent:Landroid/content/Intent;

    return-object v0
.end method


# virtual methods
.method public final call()Z
    .locals 6

    .prologue
    .line 95
    const/4 v0, 0x0

    .line 97
    .local v0, "retval":Z
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mLocker:[Ljava/lang/Object;

    monitor-enter v2

    .line 99
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mConnection:Landroid/content/ServiceConnection;

    if-nez v1, :cond_0

    .line 101
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v3, "Attempted to reuse a BoundServiceCaller.  Call method can only be executed once."

    invoke-direct {v1, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 106
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1

    .line 105
    :cond_0
    :try_start_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mServiceIntent:Landroid/content/Intent;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mConnection:Landroid/content/ServiceConnection;

    iget v5, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mBindingFlags:I

    invoke-virtual {v1, v3, v4, v5}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result v0

    .line 106
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 108
    if-nez v0, :cond_1

    .line 110
    sget-object v1, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Failed to bind to service."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 111
    const/4 v0, 0x0

    .line 136
    .end local v0    # "retval":Z
    :goto_0
    return v0

    .line 114
    .restart local v0    # "retval":Z
    :cond_1
    new-instance v1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 115
    new-instance v2, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$2;

    invoke-direct {v2, p0}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$2;-><init>(Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;)V

    sget-wide v3, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->CONNECTION_TIMEOUT:J

    invoke-virtual {v1, v2, v3, v4}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method

.method protected serviceDisconnected()V
    .locals 0

    .prologue
    .line 145
    return-void
.end method

.method protected serviceTimedOut()V
    .locals 0

    .prologue
    .line 141
    return-void
.end method

.method protected unbind()V
    .locals 6

    .prologue
    .line 149
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mLocker:[Ljava/lang/Object;

    monitor-enter v1

    .line 151
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mConnection:Landroid/content/ServiceConnection;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 153
    :try_start_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mConnection:Landroid/content/ServiceConnection;

    invoke-virtual {v0, v2}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 154
    :goto_0
    const/4 v0, 0x0

    :try_start_2
    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mConnection:Landroid/content/ServiceConnection;

    .line 156
    :cond_0
    monitor-exit v1

    return-void

    .line 153
    :catch_0
    move-exception v0

    sget-object v0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "IllegalArgumentException is received during unbinding from %s. Ignored."

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mServiceIntent:Landroid/content/Intent;

    invoke-virtual {v5}, Landroid/content/Intent;->getComponent()Landroid/content/ComponentName;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/ComponentName;->getPackageName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 156
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method protected useService(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 0
    .param p1, "name"    # Landroid/content/ComponentName;
    .param p2, "service"    # Landroid/os/IBinder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 182
    invoke-virtual {p0, p2}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->useService(Landroid/os/IBinder;)V

    .line 183
    return-void
.end method

.method protected useService(Landroid/os/IBinder;)V
    .locals 0
    .param p1, "service"    # Landroid/os/IBinder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 178
    return-void
.end method
