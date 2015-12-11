.class Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;
.super Ljava/lang/Object;
.source "SubAuthenticatorConnection.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 7
    .param p1, "className"    # Landroid/content/ComponentName;
    .param p2, "service"    # Landroid/os/IBinder;

    .prologue
    const/4 v2, 0x1

    .line 59
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    # setter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mServiceConnectionWasEstablished:Z
    invoke-static {v1, v2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$002(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Z)Z

    .line 60
    const/4 v0, 0x0

    .line 61
    .local v0, "callback":Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    # getter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mLocker:Ljava/lang/Object;
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$100(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)Ljava/lang/Object;

    move-result-object v2

    monitor-enter v2

    .line 63
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    sget-object v3, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;->Bound:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    # setter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mCurrentState:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;
    invoke-static {v1, v3}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$202(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    .line 65
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    invoke-static {p2}, Lcom/amazon/dcp/sso/ISubAuthenticator$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/dcp/sso/ISubAuthenticator;

    move-result-object v3

    # setter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mService:Lcom/amazon/dcp/sso/ISubAuthenticator;
    invoke-static {v1, v3}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$302(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Lcom/amazon/dcp/sso/ISubAuthenticator;)Lcom/amazon/dcp/sso/ISubAuthenticator;

    .line 67
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    # getter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mCallback:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$400(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;

    move-result-object v0

    .line 69
    # getter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$500()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v3, "Connected to SubAuthenticator in package %s."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    # getter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mSubAuthDesc:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    invoke-static {v6}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$600(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    move-result-object v6

    iget-object v6, v6, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 72
    if-eqz v0, :cond_0

    .line 74
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;->onConnected(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)V

    .line 76
    :cond_0
    return-void

    .line 70
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 7
    .param p1, "className"    # Landroid/content/ComponentName;

    .prologue
    const/4 v2, 0x0

    .line 81
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    # setter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mConnection:Landroid/content/ServiceConnection;
    invoke-static {v1, v2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$702(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Landroid/content/ServiceConnection;)Landroid/content/ServiceConnection;

    .line 82
    const/4 v0, 0x0

    .line 83
    .local v0, "callback":Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    # getter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mLocker:Ljava/lang/Object;
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$100(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)Ljava/lang/Object;

    move-result-object v2

    monitor-enter v2

    .line 85
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    sget-object v3, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;->Unbound:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    # setter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mCurrentState:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;
    invoke-static {v1, v3}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$202(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState;

    .line 87
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    # getter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mCallback:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$400(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;

    move-result-object v0

    .line 88
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    const/4 v3, 0x0

    # setter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mService:Lcom/amazon/dcp/sso/ISubAuthenticator;
    invoke-static {v1, v3}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$302(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Lcom/amazon/dcp/sso/ISubAuthenticator;)Lcom/amazon/dcp/sso/ISubAuthenticator;

    .line 90
    # getter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$500()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v3, "Disconnected from SubAuthenticator in package %s."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    # getter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mSubAuthDesc:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    invoke-static {v6}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$600(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    move-result-object v6

    iget-object v6, v6, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 94
    if-eqz v0, :cond_0

    .line 96
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$1;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;->onDisconnected(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)V

    .line 98
    :cond_0
    return-void

    .line 92
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method
