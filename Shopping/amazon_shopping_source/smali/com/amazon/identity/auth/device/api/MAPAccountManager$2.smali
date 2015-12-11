.class Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;
.super Ljava/lang/Object;
.source "MAPAccountManager.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/api/MAPAccountManager;->authenticateAccount(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

.field final synthetic val$activity:Landroid/app/Activity;

.field final synthetic val$authData:Landroid/os/Bundle;

.field final synthetic val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

.field final synthetic val$options:Landroid/os/Bundle;

.field final synthetic val$signinOption:Lcom/amazon/identity/auth/device/api/SigninOption;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/api/MAPAccountManager;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Landroid/os/Bundle;Landroid/os/Bundle;Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;)V
    .locals 0

    .prologue
    .line 1431
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->this$0:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->val$options:Landroid/os/Bundle;

    iput-object p4, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->val$authData:Landroid/os/Bundle;

    iput-object p5, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->val$activity:Landroid/app/Activity;

    iput-object p6, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->val$signinOption:Lcom/amazon/identity/auth/device/api/SigninOption;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 1444
    const-string/jumbo v2, "com.amazon.dcp.sso.ErrorCode"

    const/4 v3, -0x1

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v2

    .line 1445
    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->AUTHENTICATION_CHALLENGED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v3

    if-ne v2, v3, :cond_2

    .line 1448
    const-string/jumbo v2, "com.amazon.identity.auth.ChallengeException"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 1449
    .local v1, "challenge":Landroid/os/Bundle;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 1450
    .local v0, "authChallengeOptions":Landroid/os/Bundle;
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->val$options:Landroid/os/Bundle;

    if-eqz v2, :cond_0

    .line 1452
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->val$options:Landroid/os/Bundle;

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 1458
    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->val$authData:Landroid/os/Bundle;

    const-string/jumbo v3, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    const-string/jumbo v2, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 1460
    const-string/jumbo v2, "com.amazon.dcp.sso.property.account.acctId"

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->val$authData:Landroid/os/Bundle;

    const-string/jumbo v4, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1463
    :cond_1
    const-string/jumbo v2, "com.amazon.identity.auth.ChallengeException"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 1465
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->this$0:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->val$activity:Landroid/app/Activity;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->val$signinOption:Lcom/amazon/identity/auth/device/api/SigninOption;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-virtual {v2, v3, v4, v0, v5}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->authenticateAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 1472
    .end local v0    # "authChallengeOptions":Landroid/os/Bundle;
    .end local v1    # "challenge":Landroid/os/Bundle;
    :goto_0
    return-void

    .line 1469
    :cond_2
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-virtual {v2, p1}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onError(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 1436
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onSuccess(Landroid/os/Bundle;)V

    .line 1438
    return-void
.end method
