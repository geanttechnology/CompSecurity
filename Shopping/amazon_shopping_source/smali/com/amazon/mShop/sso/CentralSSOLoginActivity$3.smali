.class Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;
.super Ljava/lang/Object;
.source "CentralSSOLoginActivity.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->forceRegistration()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;)V
    .locals 0

    .prologue
    .line 250
    iput-object p1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    .line 253
    const-string/jumbo v1, "com.amazon.dcp.sso.ErrorCode"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 255
    .local v0, "errorCode":I
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    if-ne v0, v1, :cond_1

    const-string/jumbo v1, "errorCode"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    const/4 v2, 0x4

    if-ne v1, v2, :cond_1

    .line 257
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 261
    invoke-static {v3}, Lcom/amazon/mShop/sso/SSOUtil;->setLoginTriggeredFromApplication(Z)V

    .line 262
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v1, v3}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->setResult(I)V

    .line 263
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    # invokes: Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->clearKeepTopActivityFlag()V
    invoke-static {v1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->access$300(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;)V

    .line 264
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->finish()V

    .line 284
    :goto_0
    return-void

    .line 271
    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->onSuccess(Landroid/os/Bundle;)V

    goto :goto_0

    .line 273
    :cond_1
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ACCOUNT_ALREADY_EXISTS:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    if-ne v0, v1, :cond_2

    .line 274
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->onSuccess(Landroid/os/Bundle;)V

    goto :goto_0

    .line 277
    :cond_2
    invoke-static {v3}, Lcom/amazon/mShop/sso/SSOUtil;->setLoginTriggeredFromApplication(Z)V

    .line 279
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    # invokes: Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->showErrorToast(Landroid/content/Context;I)V
    invoke-static {v1, v0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->access$100(Landroid/content/Context;I)V

    .line 280
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v1, v3}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->setResult(I)V

    .line 281
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    # invokes: Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->clearKeepTopActivityFlag()V
    invoke-static {v1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->access$400(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;)V

    .line 282
    iget-object v1, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->finish()V

    goto :goto_0
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 20
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 300
    new-instance v17, Lcom/amazon/mShop/net/ServiceCallIdentifier;

    const-string/jumbo v3, "MobileAuthenticationPlatform"

    const-string/jumbo v5, "centralSSO_signin_onSuccess"

    move-object/from16 v0, v17

    invoke-direct {v0, v3, v5}, Lcom/amazon/mShop/net/ServiceCallIdentifier;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 301
    .local v17, "serviceCallIdentifier":Lcom/amazon/mShop/net/ServiceCallIdentifier;
    invoke-static/range {v17 .. v17}, Lcom/amazon/mShop/net/CallObserver;->start(Lcom/amazon/mShop/net/ServiceCallIdentifier;)Lcom/amazon/mShop/net/CallObserver;

    move-result-object v11

    .line 302
    .local v11, "callObserver":Lcom/amazon/mShop/net/CallObserver;
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v18

    .line 303
    .local v18, "startTime":J
    sget-boolean v3, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v3, :cond_0

    .line 304
    # getter for: Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->access$500()Ljava/lang/String;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/os/Bundle;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 305
    # getter for: Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->access$500()Ljava/lang/String;

    move-result-object v3

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "In onSuccess:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-wide/from16 v0, v18

    invoke-virtual {v5, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 309
    :cond_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v15

    .line 312
    .local v15, "newAccount":Ljava/lang/String;
    invoke-static {v15}, Lcom/amazon/mShop/sso/SSOUtil;->getFullNameFromCustomerAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 313
    .local v4, "fullName":Ljava/lang/String;
    new-instance v2, Lcom/amazon/mShop/model/auth/User;

    const-string/jumbo v3, ""

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    const/4 v9, 0x0

    invoke-direct/range {v2 .. v9}, Lcom/amazon/mShop/model/auth/User;-><init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/lang/Boolean;Ljava/lang/String;)V

    .line 314
    .local v2, "newUser":Lcom/amazon/mShop/model/auth/User;
    invoke-static {v2}, Lcom/amazon/mShop/model/auth/User;->saveUser(Lcom/amazon/mShop/model/auth/User;)V

    .line 317
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v15}, Lcom/amazon/mShop/sso/SSOUtil;->setPreviouslySeenAmazonAccount(Landroid/content/Context;Ljava/lang/String;)V

    .line 320
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const/4 v5, 0x1

    const/4 v6, 0x0

    invoke-static {v3, v5, v6, v15}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->syncAndWait(Landroid/content/Context;ZZLjava/lang/String;)V

    .line 322
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->ignoreOptOutSSOIfneeded()V

    .line 324
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getIntent()Landroid/content/Intent;

    move-result-object v14

    .line 325
    .local v14, "intent":Landroid/content/Intent;
    const-string/jumbo v3, "LOGIN_ORIGIN_KEY"

    invoke-virtual {v14, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 326
    .local v16, "origin":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    .line 329
    .local v10, "actvity":Lcom/amazon/mShop/AmazonActivity;
    new-instance v3, Lcom/amazon/mShop/sso/MShopCheckLogin;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v5}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    # getter for: Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->mUserInitiatedLogin:Z
    invoke-static {v6}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->access$600(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;)Z

    move-result v6

    new-instance v7, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3$1;

    move-object/from16 v0, p0

    invoke-direct {v7, v0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3$1;-><init>(Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;)V

    const/4 v8, 0x0

    invoke-direct {v3, v5, v6, v7, v8}, Lcom/amazon/mShop/sso/MShopCheckLogin;-><init>(Landroid/content/Context;ZLcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;Z)V

    invoke-virtual {v3}, Lcom/amazon/mShop/sso/MShopCheckLogin;->checkLogin()V

    .line 349
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    const/4 v5, -0x1

    invoke-virtual {v3, v5}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->setResult(I)V

    .line 350
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    # invokes: Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->clearKeepTopActivityFlag()V
    invoke-static {v3}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->access$700(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;)V

    .line 351
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->finish()V

    .line 352
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    # invokes: Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->notifyUserSignin(Lcom/amazon/mShop/model/auth/User;)V
    invoke-static {v3, v2}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->access$800(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;Lcom/amazon/mShop/model/auth/User;)V

    .line 354
    invoke-virtual {v11}, Lcom/amazon/mShop/net/CallObserver;->onComplete()V

    .line 355
    sget-boolean v3, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v3, :cond_1

    .line 356
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v12

    .line 357
    .local v12, "endTime":J
    # getter for: Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->access$500()Ljava/lang/String;

    move-result-object v3

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Out of onSuccess at:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v12, v13}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 358
    # getter for: Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->access$500()Ljava/lang/String;

    move-result-object v3

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "onSuccess duration = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sub-long v6, v12, v18

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 360
    .end local v12    # "endTime":J
    :cond_1
    return-void
.end method
