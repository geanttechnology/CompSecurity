.class public Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
.super Ljava/lang/Object;
.source "SubAuthenticatorConnection.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;,
        Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;,
        Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;
    }
.end annotation


# static fields
.field private static final CONNECTION_TIMEOUT:J

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAppContext:Landroid/content/Context;

.field private mCallback:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;

.field private mConnection:Landroid/content/ServiceConnection;

.field private mCurrentState:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

.field private mLocker:Ljava/lang/Object;

.field private mService:Lcom/amazon/dcp/sso/ISubAuthenticator;

.field private mServiceConnectionWasEstablished:Z

.field private final mSubAuthDesc:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 26
    const-class v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->TAG:Ljava/lang/String;

    .line 27
    sget-object v0, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v1, 0x3

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->CONNECTION_TIMEOUT:J

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;Landroid/content/Context;)V
    .locals 2
    .param p1, "subAuthDesc"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    .param p2, "appContext"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 108
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    new-instance v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;-><init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mConnection:Landroid/content/ServiceConnection;

    .line 105
    new-array v0, v1, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mLocker:Ljava/lang/Object;

    .line 109
    if-nez p1, :cond_0

    .line 111
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "SubAuthenticatorDescription cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 114
    :cond_0
    if-nez p2, :cond_1

    .line 116
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Context cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 119
    :cond_1
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mSubAuthDesc:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    .line 120
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mAppContext:Landroid/content/Context;

    .line 121
    sget-object v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;->Unbound:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mCurrentState:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    .line 122
    iput-boolean v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mServiceConnectionWasEstablished:Z

    .line 123
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    .prologue
    .line 24
    iget-boolean v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mServiceConnectionWasEstablished:Z

    return v0
.end method

.method static synthetic access$002(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    .param p1, "x1"    # Z

    .prologue
    .line 24
    iput-boolean p1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mServiceConnectionWasEstablished:Z

    return p1
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mLocker:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$202(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    .param p1, "x1"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mCurrentState:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    return-object p1
.end method

.method static synthetic access$302(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Lcom/amazon/dcp/sso/ISubAuthenticator;)Lcom/amazon/dcp/sso/ISubAuthenticator;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    .param p1, "x1"    # Lcom/amazon/dcp/sso/ISubAuthenticator;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mService:Lcom/amazon/dcp/sso/ISubAuthenticator;

    return-object p1
.end method

.method static synthetic access$400(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mCallback:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;

    return-object v0
.end method

.method static synthetic access$500()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mSubAuthDesc:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    return-object v0
.end method

.method static synthetic access$702(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Landroid/content/ServiceConnection;)Landroid/content/ServiceConnection;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    .param p1, "x1"    # Landroid/content/ServiceConnection;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mConnection:Landroid/content/ServiceConnection;

    return-object p1
.end method

.method private callFailureCallback(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;)V
    .locals 5
    .param p1, "deregisterCallback"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;

    .prologue
    .line 308
    if-nez p1, :cond_0

    .line 319
    :goto_0
    return-void

    .line 315
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mAppContext:Landroid/content/Context;

    const-string/jumbo v2, "ErrorConnectingToSubAuth"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/ResourceHelper;->getString(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mSubAuthDesc:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    iget-object v4, v4, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 318
    .local v0, "failureStr":Ljava/lang/String;
    const/4 v1, -0x1

    invoke-interface {p1, p0, v1, v0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;->error(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;ILjava/lang/String;)V

    goto :goto_0
.end method

.method private safeBind$5b75c20b(Landroid/content/Intent;Landroid/content/ServiceConnection;)Z
    .locals 6
    .param p1, "serviceIntent"    # Landroid/content/Intent;
    .param p2, "connection"    # Landroid/content/ServiceConnection;

    .prologue
    const/4 v1, 0x0

    .line 203
    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mAppContext:Landroid/content/Context;

    const/4 v3, 0x5

    invoke-virtual {v2, p1, p2, v3}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 213
    :goto_0
    return v1

    .line 205
    :catch_0
    move-exception v0

    .line 207
    .local v0, "e":Ljava/lang/SecurityException;
    sget-object v2, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Unable to talk to package %s because of SecurityException"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->getPackageName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v1

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method public closeConnection()V
    .locals 6

    .prologue
    .line 218
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mLocker:Ljava/lang/Object;

    monitor-enter v1

    .line 220
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mCurrentState:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    sget-object v2, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;->Bound:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    if-eq v0, v2, :cond_0

    .line 222
    sget-object v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot close the connection because it was not connected"

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 223
    monitor-exit v1

    .line 232
    :goto_0
    return-void

    .line 226
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mConnection:Landroid/content/ServiceConnection;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_1

    .line 228
    :try_start_1
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mAppContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mConnection:Landroid/content/ServiceConnection;

    invoke-virtual {v0, v2}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 229
    :goto_1
    const/4 v0, 0x0

    :try_start_2
    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mConnection:Landroid/content/ServiceConnection;

    .line 231
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;->Unbound:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mCurrentState:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    .line 232
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0

    .line 228
    :catch_0
    move-exception v0

    :try_start_3
    sget-object v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "IllegalArgumentException is received during unbinding from %s. Ignored."

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mSubAuthDesc:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    iget-object v5, v5, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1
.end method

.method public deregister(Landroid/accounts/Account;Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;)V
    .locals 6
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "deregisterCallback"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;

    .prologue
    .line 254
    const/4 v0, 0x0

    .line 255
    .local v0, "curState":Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mLocker:Ljava/lang/Object;

    monitor-enter v4

    .line 257
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mCurrentState:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    .line 258
    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 260
    sget-object v3, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;->Bound:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    if-eq v0, v3, :cond_0

    .line 262
    sget-object v3, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Cannot deregister the Sub Authenticator until the connection has been opened"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 263
    const/16 v3, 0x8

    const-string/jumbo v4, "In bad state. Cannot deregister"

    invoke-interface {p2, p0, v3, v4}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;->error(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;ILjava/lang/String;)V

    .line 304
    :goto_0
    return-void

    .line 258
    :catchall_0
    move-exception v3

    monitor-exit v4

    throw v3

    .line 267
    :cond_0
    new-instance v1, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$3;

    invoke-direct {v1, p0, p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$3;-><init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;)V

    .line 290
    .local v1, "deregisterResponse":Lcom/amazon/dcp/sso/ISubAuthenticatorResponse$Stub;
    :try_start_1
    sget-object v3, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "Calling "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mSubAuthDesc:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    iget-object v5, v5, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " to start deregistration"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 291
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mService:Lcom/amazon/dcp/sso/ISubAuthenticator;

    iget-object v4, p1, Landroid/accounts/Account;->type:Ljava/lang/String;

    iget-object v5, p1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-interface {v3, v1, v4, v5}, Lcom/amazon/dcp/sso/ISubAuthenticator;->getAccountRemovalAllowed(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 293
    :catch_0
    move-exception v2

    .line 295
    .local v2, "e":Ljava/lang/RuntimeException;
    sget-object v3, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mSubAuthDesc:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    iget-object v5, v5, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " caused the following exception in it\'s getAccountRemovalAllowed implementation"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 298
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->callFailureCallback(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;)V

    goto :goto_0

    .line 302
    .end local v2    # "e":Ljava/lang/RuntimeException;
    :catch_1
    move-exception v3

    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->callFailureCallback(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;)V

    goto :goto_0
.end method

.method public getPackageName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mSubAuthDesc:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    iget-object v0, v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    return-object v0
.end method

.method public getSubAuthenticatorDescription()Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mSubAuthDesc:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    return-object v0
.end method

.method public openConnection(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;)Z
    .locals 9
    .param p1, "callback"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;

    .prologue
    const/4 v2, 0x0

    .line 137
    if-nez p1, :cond_0

    .line 139
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "Callback parameter cannot be null."

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 142
    :cond_0
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mLocker:Ljava/lang/Object;

    monitor-enter v3

    .line 144
    :try_start_0
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mCurrentState:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    sget-object v5, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;->Unbound:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    if-eq v4, v5, :cond_1

    .line 146
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string/jumbo v4, "Cannot open a connection to the service because we are currently connecting or have already connected to the service."

    invoke-direct {v2, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 196
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2

    .line 150
    :cond_1
    :try_start_1
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mConnection:Landroid/content/ServiceConnection;

    if-nez v4, :cond_2

    .line 152
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string/jumbo v4, "Attempted to reuse a SubAuthenticatorConnection.  openConnection can only be executed once."

    invoke-direct {v2, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 156
    :cond_2
    sget-object v4, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;->Binding:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    iput-object v4, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mCurrentState:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    .line 158
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mCallback:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;

    .line 161
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v4, "com.amazon.dcp.sso.AccountSubAuthenticator"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 162
    .local v0, "serviceIntent":Landroid/content/Intent;
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mSubAuthDesc:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getComponentName()Landroid/content/ComponentName;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 164
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mConnection:Landroid/content/ServiceConnection;

    invoke-direct {p0, v0, v4}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->safeBind$5b75c20b(Landroid/content/Intent;Landroid/content/ServiceConnection;)Z

    move-result v1

    .line 167
    .local v1, "success":Z
    if-nez v1, :cond_3

    .line 169
    sget-object v4, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;->Unbound:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    iput-object v4, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mCurrentState:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    .line 170
    sget-object v4, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Application tried to bind to SubAuthenticator Service %s and failed."

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mSubAuthDesc:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    iget-object v8, v8, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 173
    monitor-exit v3

    move v1, v2

    .line 195
    .end local v1    # "success":Z
    :goto_0
    return v1

    .line 176
    .restart local v1    # "success":Z
    :cond_3
    new-instance v2, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v4

    invoke-direct {v2, v4}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 177
    new-instance v4, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$2;

    invoke-direct {v4, p0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$2;-><init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)V

    sget-wide v5, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->CONNECTION_TIMEOUT:J

    invoke-virtual {v2, v4, v5, v6}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 195
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method
