.class Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;
.super Ljava/lang/Object;
.source "DistributedSSOLoginActivity.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->forceRegistration()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

.field final synthetic val$nonSecureCookies:Ljava/lang/String;

.field final synthetic val$prevAtMain:Ljava/lang/String;

.field final synthetic val$secureCookies:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 249
    iput-object p1, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    iput-object p2, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->val$secureCookies:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->val$nonSecureCookies:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->val$prevAtMain:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 252
    const-string/jumbo v1, "com.amazon.dcp.sso.ErrorCode"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 253
    .local v0, "errorCode":I
    invoke-static {v4}, Lcom/amazon/mShop/sso/SSOUtil;->setLoginTriggeredFromApplication(Z)V

    .line 259
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ACCOUNT_ALREADY_EXISTS:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 260
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->onSuccess(Landroid/os/Bundle;)V

    .line 275
    :goto_0
    return-void

    .line 264
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->clearCurrentLocaleCookieAndCookieJar(Landroid/content/Context;)V

    .line 267
    iget-object v1, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->val$secureCookies:Ljava/lang/String;

    const/4 v3, 0x1

    invoke-static {v1, v2, v3}, Lcom/amazon/mShop/net/CookieBridge;->setCookies(Landroid/content/Context;Ljava/lang/String;Z)V

    .line 268
    iget-object v1, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->val$nonSecureCookies:Ljava/lang/String;

    invoke-static {v1, v2, v4}, Lcom/amazon/mShop/net/CookieBridge;->setCookies(Landroid/content/Context;Ljava/lang/String;Z)V

    .line 270
    iget-object v1, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    # invokes: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->showErrorToast(Landroid/content/Context;I)V
    invoke-static {v1, v0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$100(Landroid/content/Context;I)V

    .line 271
    iget-object v1, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->setResult(I)V

    .line 272
    iget-object v1, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    # invokes: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->clearKeepTopActivityFlag()V
    invoke-static {v1}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$300(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;)V

    .line 273
    iget-object v1, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->finish()V

    goto :goto_0
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 23
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 291
    new-instance v20, Lcom/amazon/mShop/net/ServiceCallIdentifier;

    const-string/jumbo v5, "MobileAuthenticationPlatform"

    const-string/jumbo v7, "distributedSSO_signin_onSuccess"

    move-object/from16 v0, v20

    invoke-direct {v0, v5, v7}, Lcom/amazon/mShop/net/ServiceCallIdentifier;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 292
    .local v20, "serviceCallIdentifier":Lcom/amazon/mShop/net/ServiceCallIdentifier;
    invoke-static/range {v20 .. v20}, Lcom/amazon/mShop/net/CallObserver;->start(Lcom/amazon/mShop/net/ServiceCallIdentifier;)Lcom/amazon/mShop/net/CallObserver;

    move-result-object v13

    .line 294
    .local v13, "callObserver":Lcom/amazon/mShop/net/CallObserver;
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v21

    .line 295
    .local v21, "startTime":J
    sget-boolean v5, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v5, :cond_0

    .line 296
    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$400()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "In onSuccess:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-wide/from16 v0, v21

    invoke-virtual {v7, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 297
    const-string/jumbo v5, "MAPSigninLatency"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "In onSuccess:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v8

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 300
    :cond_0
    const-string/jumbo v5, "com.amazon.dcp.sso.property.account.acctId"

    move-object/from16 v0, p1

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    .line 301
    .local v18, "newAccount":Ljava/lang/String;
    sget-boolean v5, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v5, :cond_1

    .line 302
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v15

    .line 303
    .local v15, "endTime":J
    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$400()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "after getCurrentAccount  "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sub-long v8, v15, v21

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 308
    .end local v15    # "endTime":J
    :cond_1
    invoke-static/range {v18 .. v18}, Lcom/amazon/mShop/sso/SSOUtil;->setTempAccountForCurrentLocale(Ljava/lang/String;)V

    .line 312
    invoke-static/range {v18 .. v18}, Lcom/amazon/mShop/sso/SSOUtil;->getFullNameFromCustomerAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 313
    .local v6, "fullName":Ljava/lang/String;
    new-instance v4, Lcom/amazon/mShop/model/auth/User;

    const-string/jumbo v5, ""

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    const/4 v11, 0x0

    invoke-direct/range {v4 .. v11}, Lcom/amazon/mShop/model/auth/User;-><init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/lang/Boolean;Ljava/lang/String;)V

    .line 314
    .local v4, "newUser":Lcom/amazon/mShop/model/auth/User;
    invoke-static {v4}, Lcom/amazon/mShop/model/auth/User;->saveUser(Lcom/amazon/mShop/model/auth/User;)V

    .line 320
    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->sExecutor:Ljava/util/concurrent/Executor;
    invoke-static {}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$700()Ljava/util/concurrent/Executor;

    move-result-object v5

    new-instance v7, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3$1;

    move-object/from16 v0, p0

    move-wide/from16 v1, v21

    move-object/from16 v3, v18

    invoke-direct {v7, v0, v1, v2, v3}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3$1;-><init>(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;JLjava/lang/String;)V

    invoke-interface {v5, v7}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 337
    sget-boolean v5, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v5, :cond_2

    .line 338
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v15

    .line 339
    .restart local v15    # "endTime":J
    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$400()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "after post run accountCustomKeyMapping  "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sub-long v8, v15, v21

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 343
    .end local v15    # "endTime":J
    :cond_2
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v5

    invoke-virtual {v5}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 346
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-virtual {v5}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/mShop/net/CookieBridge;->getAtMainCookie(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v14

    .line 350
    .local v14, "currAtMain":Ljava/lang/String;
    invoke-static {v14}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_3

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->val$prevAtMain:Ljava/lang/String;

    invoke-virtual {v14, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 351
    :cond_3
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-virtual {v5}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const/4 v7, 0x1

    const/4 v8, 0x0

    move-object/from16 v0, v18

    invoke-static {v5, v7, v8, v0}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->syncAndWait(Landroid/content/Context;ZZLjava/lang/String;)V

    .line 354
    :cond_4
    sget-boolean v5, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v5, :cond_5

    .line 355
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v15

    .line 356
    .restart local v15    # "endTime":J
    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$400()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "after compare atMain  "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sub-long v8, v15, v21

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 359
    .end local v15    # "endTime":J
    :cond_5
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-virtual {v5}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    move-object/from16 v0, v18

    invoke-static {v5, v0}, Lcom/amazon/mShop/sso/SSOUtil;->setPreviouslySeenAmazonAccount(Landroid/content/Context;Ljava/lang/String;)V

    .line 361
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->ignoreOptOutSSOIfneeded()V

    .line 363
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-virtual {v5}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getIntent()Landroid/content/Intent;

    move-result-object v17

    .line 364
    .local v17, "intent":Landroid/content/Intent;
    const-string/jumbo v5, "LOGIN_ORIGIN_KEY"

    move-object/from16 v0, v17

    invoke-virtual {v0, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 365
    .local v19, "origin":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    .line 368
    .local v12, "activity":Lcom/amazon/mShop/AmazonActivity;
    sget-boolean v5, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v5, :cond_6

    .line 369
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v15

    .line 370
    .restart local v15    # "endTime":J
    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$400()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "before issue async checkLogin  "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sub-long v8, v15, v21

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 373
    .end local v15    # "endTime":J
    :cond_6
    new-instance v5, Lcom/amazon/mShop/sso/MShopCheckLogin;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-virtual {v7}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->mUserInitiatedLogin:Z
    invoke-static {v8}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$800(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;)Z

    move-result v8

    new-instance v9, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3$2;

    move-object/from16 v0, p0

    invoke-direct {v9, v0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3$2;-><init>(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;)V

    const/4 v10, 0x0

    invoke-direct {v5, v7, v8, v9, v10}, Lcom/amazon/mShop/sso/MShopCheckLogin;-><init>(Landroid/content/Context;ZLcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;Z)V

    invoke-virtual {v5}, Lcom/amazon/mShop/sso/MShopCheckLogin;->checkLogin()V

    .line 393
    sget-boolean v5, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v5, :cond_7

    .line 394
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v15

    .line 395
    .restart local v15    # "endTime":J
    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$400()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "after issue async checkLogin  "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sub-long v8, v15, v21

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 398
    .end local v15    # "endTime":J
    :cond_7
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    const/4 v7, -0x1

    invoke-virtual {v5, v7}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->setResult(I)V

    .line 399
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    # invokes: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->clearKeepTopActivityFlag()V
    invoke-static {v5}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$900(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;)V

    .line 400
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-virtual {v5}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->finish()V

    .line 401
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    # invokes: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->notifyUserSignin(Lcom/amazon/mShop/model/auth/User;)V
    invoke-static {v5, v4}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$1000(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;Lcom/amazon/mShop/model/auth/User;)V

    .line 403
    invoke-virtual {v13}, Lcom/amazon/mShop/net/CallObserver;->onComplete()V

    .line 405
    sget-boolean v5, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v5, :cond_8

    .line 406
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v15

    .line 407
    .restart local v15    # "endTime":J
    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$400()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "Out of onSuccess at:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-wide v0, v15

    invoke-virtual {v7, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 408
    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$400()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "onSuccess duration = "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sub-long v8, v15, v21

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 409
    const-string/jumbo v5, "MAPSigninLatency"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "Out of onSuccess:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v8

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 412
    .end local v15    # "endTime":J
    :cond_8
    return-void
.end method
