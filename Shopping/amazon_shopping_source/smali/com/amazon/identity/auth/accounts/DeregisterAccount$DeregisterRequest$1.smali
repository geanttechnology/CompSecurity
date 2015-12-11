.class Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$1;
.super Ljava/lang/Object;
.source "DeregisterAccount.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;)V
    .locals 0

    .prologue
    .line 324
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$1;->this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public accountAlreadyExists(Ljava/lang/String;)V
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 350
    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Deregister Failure for Overriding DSN Child Device Type due to registration already existing.  This should not happen. DirectedId: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 353
    return-void
.end method

.method public failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V
    .locals 5
    .param p1, "error"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .param p2, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 340
    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Deregister Failure for Overriding DSN Child Device Type: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->name()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 343
    return-void
.end method

.method public success(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "uniqueUserName"    # Ljava/lang/String;
    .param p3, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 330
    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    const-string/jumbo v0, "Deregister Succeeded for Overriding DSN Child Device Type. directedId %s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 333
    return-void
.end method
