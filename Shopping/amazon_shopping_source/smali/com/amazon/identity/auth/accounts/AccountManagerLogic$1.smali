.class Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;
.super Ljava/lang/Object;
.source "AccountManagerLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->updateAccountWithKey(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

.field final synthetic val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$key:Lcom/amazon/identity/auth/device/utils/KeyInfo;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V
    .locals 0

    .prologue
    .line 571
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;->val$directedId:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;->val$key:Lcom/amazon/identity/auth/device/utils/KeyInfo;

    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public accountAlreadyExists(Ljava/lang/String;)V
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 593
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onAccountAlreadyExistsError(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    .line 594
    return-void
.end method

.method public failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V
    .locals 3
    .param p1, "error"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .param p2, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 586
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 587
    .local v0, "result":Landroid/os/Bundle;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-virtual {v1, v0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onError(Landroid/os/Bundle;)V

    .line 588
    return-void
.end method

.method public success(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 5
    .param p1, "accountType"    # Ljava/lang/String;
    .param p2, "accountName"    # Ljava/lang/String;
    .param p3, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 575
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;->val$directedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;->val$key:Lcom/amazon/identity/auth/device/utils/KeyInfo;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v3

    # invokes: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->updateAccountCredentials(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    invoke-static {v1, v2, v3, p3}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$000(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 577
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 578
    .local v0, "result":Landroid/os/Bundle;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$100(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;->val$directedId:Ljava/lang/String;

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->addAccountManagerSuccessInformation(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    .line 579
    const-string/jumbo v1, "authtoken"

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;
    invoke-static {v2}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$200(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;->val$directedId:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;->val$key:Lcom/amazon/identity/auth/device/utils/KeyInfo;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 580
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-virtual {v1, v0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onSuccess(Landroid/os/Bundle;)V

    .line 581
    return-void
.end method
