.class Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$2;
.super Ljava/lang/Object;
.source "SubAuthenticatorConnection.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->openConnection(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;)Z
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
    .line 178
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$2;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 182
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$2;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    # getter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mServiceConnectionWasEstablished:Z
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$000(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 192
    :goto_0
    return-void

    .line 187
    :cond_0
    # getter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$500()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Application tried to bind to SubAuthenticator Service %s timed out."

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$2;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    # getter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mSubAuthDesc:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    invoke-static {v4}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$600(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    move-result-object v4

    iget-object v4, v4, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$2;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    # getter for: Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->mCallback:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->access$400(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$2;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;->onConnectionTimeout(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)V

    .line 191
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$2;->this$0:Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->closeConnection()V

    goto :goto_0
.end method
