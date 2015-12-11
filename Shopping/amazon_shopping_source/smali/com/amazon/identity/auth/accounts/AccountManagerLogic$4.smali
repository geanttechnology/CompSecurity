.class Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;
.super Ljava/lang/Object;
.source "AccountManagerLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

.field final synthetic val$callback:Lcom/amazon/identity/auth/device/api/Callback;

.field final synthetic val$regData:Landroid/os/Bundle;

.field final synthetic val$regType:Lcom/amazon/identity/auth/device/api/RegistrationType;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 0

    .prologue
    .line 767
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;->val$regType:Lcom/amazon/identity/auth/device/api/RegistrationType;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;->val$regData:Landroid/os/Bundle;

    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public accountAlreadyExists(Ljava/lang/String;)V
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 792
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onAccountAlreadyExistsError(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    .line 793
    return-void
.end method

.method public failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V
    .locals 2
    .param p1, "error"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .param p2, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 786
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    # invokes: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->onRegistrationError(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V
    invoke-static {v0, p1, v1, p2}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$600(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V

    .line 787
    return-void
.end method

.method public success(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 1
    .param p1, "accountType"    # Ljava/lang/String;
    .param p2, "accountName"    # Ljava/lang/String;
    .param p3, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 771
    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4$1;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4$1;-><init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    .line 781
    return-void
.end method
