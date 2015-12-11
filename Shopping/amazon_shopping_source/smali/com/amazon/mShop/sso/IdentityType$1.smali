.class final enum Lcom/amazon/mShop/sso/IdentityType$1;
.super Lcom/amazon/mShop/sso/IdentityType;
.source "IdentityType.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/sso/IdentityType;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4008
    name = null
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 48
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/mShop/sso/IdentityType;-><init>(Ljava/lang/String;ILcom/amazon/mShop/sso/IdentityType$1;)V

    return-void
.end method

.method private ignoreNewAddedAccount(Ljava/lang/String;)Z
    .locals 6
    .param p1, "newAddedAccount"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 416
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->isLoginTriggeredFromApplication()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 419
    const/4 v3, 0x0

    invoke-static {v3}, Lcom/amazon/mShop/sso/SSOUtil;->setLoginTriggeredFromApplication(Z)V

    .line 437
    :cond_0
    :goto_0
    return v2

    .line 422
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getAuthPoolForCurrentLocale()Ljava/lang/String;

    move-result-object v1

    .line 423
    .local v1, "currentAuthPool":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/sso/SSOUtil;->getAuthPoolFromAccount(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 425
    .local v0, "accountAuthPool":Ljava/lang/String;
    sget-boolean v3, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v3, :cond_2

    .line 426
    const-string/jumbo v3, "Amazon.SSOUtil"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "IdentityType: currentAuthPool: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "the auth pool of account "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " is "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 430
    :cond_2
    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 435
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v2

    goto :goto_0
.end method

.method private silentUpgradeAccount(Landroid/content/Context;)Z
    .locals 25
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 249
    invoke-static/range {p1 .. p1}, Lcom/amazon/mShop/net/CookieBridge;->getAtMainCookie(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v12

    .line 250
    .local v12, "atCookie":Ljava/lang/String;
    invoke-static/range {p1 .. p1}, Lcom/amazon/mShop/net/CookieBridge;->getUbidCookie(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v24

    .line 252
    .local v24, "ubid":Ljava/lang/String;
    invoke-static {v12}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static/range {v24 .. v24}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 253
    :cond_0
    const/16 v23, 0x0

    .line 361
    :goto_0
    return v23

    .line 256
    :cond_1
    invoke-static/range {p1 .. p1}, Lcom/amazon/mShop/sso/SSOUtil;->getMAPAccountManager(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-result-object v11

    .line 257
    .local v11, "accountManager":Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    new-instance v18, Ljava/util/HashSet;

    invoke-direct/range {v18 .. v18}, Ljava/util/HashSet;-><init>()V

    .line 258
    .local v18, "previousAccounts":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    invoke-virtual {v11}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccounts()Ljava/util/Set;

    move-result-object v2

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Ljava/util/HashSet;->addAll(Ljava/util/Collection;)Z

    .line 259
    new-instance v20, Landroid/os/Bundle;

    invoke-direct/range {v20 .. v20}, Landroid/os/Bundle;-><init>()V

    .line 261
    .local v20, "regData":Landroid/os/Bundle;
    const/4 v2, 0x1

    move-object/from16 v0, p1

    invoke-static {v0, v2}, Lcom/amazon/mShop/net/CookieBridge;->getCookieDomain(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v14

    .line 262
    .local v14, "domain":Ljava/lang/String;
    const-string/jumbo v2, "com.amazon.identity.ap.domain"

    const/4 v3, 0x1

    invoke-virtual {v14, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v20

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 268
    const-string/jumbo v2, "com.amazon.dcp.sso.AddAccount.options.AuthToken"

    move-object/from16 v0, v20

    invoke-virtual {v0, v2, v12}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 269
    const-string/jumbo v2, "com.amazon.dcp.sso.AddAccount.options.AuthTokenClientContext"

    move-object/from16 v0, v20

    move-object/from16 v1, v24

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 270
    const-string/jumbo v2, "com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"

    const/4 v3, 0x1

    move-object/from16 v0, v20

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 272
    new-instance v22, Lcom/amazon/mShop/net/ServiceCallIdentifier;

    const-string/jumbo v2, "MobileAuthenticationPlatform"

    const-string/jumbo v3, "silentUpgrade"

    move-object/from16 v0, v22

    invoke-direct {v0, v2, v3}, Lcom/amazon/mShop/net/ServiceCallIdentifier;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 273
    .local v22, "serviceCallIdentifier":Lcom/amazon/mShop/net/ServiceCallIdentifier;
    invoke-static/range {v22 .. v22}, Lcom/amazon/mShop/net/CallObserver;->start(Lcom/amazon/mShop/net/ServiceCallIdentifier;)Lcom/amazon/mShop/net/CallObserver;

    move-result-object v13

    .line 276
    .local v13, "callObserver":Lcom/amazon/mShop/net/CallObserver;
    const/16 v23, 0x0

    .line 280
    .local v23, "successful":Z
    const/4 v2, 0x1

    invoke-static {v2}, Lcom/amazon/mShop/sso/SSOUtil;->setLoginTriggeredFromApplication(Z)V

    .line 282
    sget-object v2, Lcom/amazon/identity/auth/device/api/RegistrationType;->FROM_AUTH_TOKEN:Lcom/amazon/identity/auth/device/api/RegistrationType;

    const/4 v3, 0x0

    move-object/from16 v0, v20

    invoke-virtual {v11, v2, v0, v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->registerAccount(Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v17

    .line 283
    .local v17, "future":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    const/4 v10, 0x0

    .line 285
    .local v10, "account":Ljava/lang/String;
    :try_start_0
    invoke-interface/range {v17 .. v17}, Lcom/amazon/identity/auth/device/api/MAPFuture;->get()Ljava/lang/Object;

    move-result-object v21

    check-cast v21, Landroid/os/Bundle;

    .line 286
    .local v21, "result":Landroid/os/Bundle;
    if-eqz v21, :cond_5

    const-string/jumbo v2, "com.amazon.dcp.sso.property.account.acctId"

    move-object/from16 v0, v21

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_5

    .line 288
    const/16 v23, 0x1

    .line 289
    const-string/jumbo v2, "com.amazon.dcp.sso.property.account.acctId"

    move-object/from16 v0, v21

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 290
    invoke-virtual {v13}, Lcom/amazon/mShop/net/CallObserver;->onComplete()V
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_2

    .line 325
    .end local v21    # "result":Landroid/os/Bundle;
    :cond_2
    :goto_1
    invoke-virtual {v13}, Lcom/amazon/mShop/net/CallObserver;->isFinished()Z

    move-result v2

    if-nez v2, :cond_3

    .line 326
    const-string/jumbo v2, "failed"

    invoke-virtual {v13, v2}, Lcom/amazon/mShop/net/CallObserver;->onFailed(Ljava/lang/String;)V

    .line 330
    :cond_3
    if-eqz v23, :cond_a

    .line 331
    invoke-static {v10}, Lcom/amazon/mShop/sso/SSOUtil;->getFullNameFromCustomerAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 332
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

    invoke-static {v2}, Lcom/amazon/mShop/model/auth/User;->saveUser(Lcom/amazon/mShop/model/auth/User;)V

    .line 335
    move-object/from16 v0, p1

    invoke-static {v0, v10}, Lcom/amazon/mShop/sso/SSOUtil;->setPreviouslySeenAmazonAccount(Landroid/content/Context;Ljava/lang/String;)V

    .line 338
    invoke-static {v10}, Lcom/amazon/mShop/sso/SSOUtil;->addAccountCustomKeyMapping(Ljava/lang/String;)V

    .line 341
    new-instance v2, Lcom/amazon/mShop/sso/MShopCheckLogin;

    const/4 v3, 0x1

    const/4 v5, 0x0

    move-object/from16 v0, p1

    invoke-direct {v2, v0, v3, v5}, Lcom/amazon/mShop/sso/MShopCheckLogin;-><init>(Landroid/content/Context;ZLcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;)V

    invoke-virtual {v2}, Lcom/amazon/mShop/sso/MShopCheckLogin;->checkLogin()V

    .line 344
    move-object/from16 v0, v18

    invoke-virtual {v0, v10}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 345
    const-string/jumbo v19, "sso_silent_primary"

    .line 350
    .local v19, "refMarker":Ljava/lang/String;
    :goto_2
    invoke-static/range {p1 .. p1}, Lcom/amazon/mShop/sso/SSOUtil;->isAppstoreInstalledWithSpecificVersion(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 351
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v19

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "_wappstore"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    .line 354
    :cond_4
    invoke-static/range {v19 .. v19}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 292
    .end local v4    # "fullName":Ljava/lang/String;
    .end local v19    # "refMarker":Ljava/lang/String;
    .restart local v21    # "result":Landroid/os/Bundle;
    :cond_5
    :try_start_1
    const-string/jumbo v2, "registerAccount result is null or has No directedID"

    invoke-virtual {v13, v2}, Lcom/amazon/mShop/net/CallObserver;->onFailed(Ljava/lang/String;)V
    :try_end_1
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_1 .. :try_end_1} :catch_2

    goto :goto_1

    .line 294
    .end local v21    # "result":Landroid/os/Bundle;
    :catch_0
    move-exception v15

    .line 295
    .local v15, "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    invoke-virtual {v15}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getErrorBundle()Landroid/os/Bundle;

    move-result-object v16

    .line 297
    .local v16, "errorBundle":Landroid/os/Bundle;
    const-string/jumbo v2, "com.amazon.dcp.sso.ErrorCode"

    move-object/from16 v0, v16

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ACCOUNT_ALREADY_EXISTS:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v3

    if-ne v2, v3, :cond_6

    const-string/jumbo v2, "com.amazon.dcp.sso.property.account.acctId"

    move-object/from16 v0, v16

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_6

    .line 299
    const-string/jumbo v2, "com.amazon.dcp.sso.property.account.acctId"

    move-object/from16 v0, v16

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 300
    const/16 v23, 0x1

    .line 301
    invoke-virtual {v13}, Lcom/amazon/mShop/net/CallObserver;->onComplete()V

    .line 306
    :goto_3
    const/4 v2, 0x0

    invoke-static {v2}, Lcom/amazon/mShop/sso/SSOUtil;->setLoginTriggeredFromApplication(Z)V

    .line 307
    sget-boolean v2, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v2, :cond_2

    .line 308
    const-string/jumbo v2, "Amazon.SSOUtil"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "silentUpgradeAccount: "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v15}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_1

    .line 303
    :cond_6
    invoke-virtual {v15}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v13, v2}, Lcom/amazon/mShop/net/CallObserver;->onFailed(Ljava/lang/String;)V

    goto :goto_3

    .line 310
    .end local v15    # "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    .end local v16    # "errorBundle":Landroid/os/Bundle;
    :catch_1
    move-exception v15

    .line 311
    .local v15, "e":Ljava/lang/InterruptedException;
    const/4 v2, 0x0

    invoke-static {v2}, Lcom/amazon/mShop/sso/SSOUtil;->setLoginTriggeredFromApplication(Z)V

    .line 312
    sget-boolean v2, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v2, :cond_7

    .line 313
    const-string/jumbo v2, "Amazon.SSOUtil"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "silentUpgradeAccount: "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v15}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 315
    :cond_7
    invoke-virtual {v15}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v13, v2}, Lcom/amazon/mShop/net/CallObserver;->onFailed(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 316
    .end local v15    # "e":Ljava/lang/InterruptedException;
    :catch_2
    move-exception v15

    .line 317
    .local v15, "e":Ljava/util/concurrent/ExecutionException;
    const/4 v2, 0x0

    invoke-static {v2}, Lcom/amazon/mShop/sso/SSOUtil;->setLoginTriggeredFromApplication(Z)V

    .line 318
    sget-boolean v2, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v2, :cond_8

    .line 319
    const-string/jumbo v2, "Amazon.SSOUtil"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "silentUpgradeAccount: "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v15}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 321
    :cond_8
    invoke-virtual {v15}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v13, v2}, Lcom/amazon/mShop/net/CallObserver;->onFailed(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 347
    .end local v15    # "e":Ljava/util/concurrent/ExecutionException;
    .restart local v4    # "fullName":Ljava/lang/String;
    :cond_9
    const-string/jumbo v19, "sso_silent_local"

    .restart local v19    # "refMarker":Ljava/lang/String;
    goto/16 :goto_2

    .line 356
    .end local v4    # "fullName":Ljava/lang/String;
    .end local v19    # "refMarker":Ljava/lang/String;
    :cond_a
    const/4 v2, 0x0

    invoke-static {v2}, Lcom/amazon/mShop/sso/SSOUtil;->setLoginTriggeredFromApplication(Z)V

    .line 357
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->clearUserInfoOfCurrentLocale()V

    .line 358
    const-string/jumbo v2, ""

    move-object/from16 v0, p1

    invoke-static {v0, v2}, Lcom/amazon/mShop/sso/SSOUtil;->setPreviouslySeenAmazonAccount(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_0
.end method


# virtual methods
.method public handleBackgroundService(Lcom/amazon/mShop/sso/SSOBackgroundAccountService;Landroid/content/Intent;)V
    .locals 12
    .param p1, "ssoBackGroundAccountService"    # Lcom/amazon/mShop/sso/SSOBackgroundAccountService;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v7, 0x1

    const/4 v8, 0x0

    .line 53
    invoke-virtual {p1}, Lcom/amazon/mShop/sso/SSOBackgroundAccountService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 54
    .local v1, "applicationContext":Landroid/content/Context;
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 55
    .local v0, "actionName":Ljava/lang/String;
    const-string/jumbo v9, "com.amazon.dcp.sso.extra.account.directed_id"

    invoke-virtual {p2, v9}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 57
    .local v5, "newAccount":Ljava/lang/String;
    sget-boolean v9, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v9, :cond_0

    .line 58
    const-string/jumbo v9, "Amazon.SSOUtil"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v11, "DistributedSSOServiceHandler#handleBackgroundService getAllAccounts: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getAllAccounts()Ljava/util/Set;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string/jumbo v11, "actionName = "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 63
    :cond_0
    const-string/jumbo v9, "com.amazon.dcp.sso.action.account.added"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_6

    .line 64
    invoke-direct {p0, v5}, Lcom/amazon/mShop/sso/IdentityType$1;->ignoreNewAddedAccount(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 135
    :cond_1
    :goto_0
    return-void

    .line 68
    :cond_2
    sget-boolean v9, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v9, :cond_3

    .line 69
    const-string/jumbo v9, "Amazon.SSOUtil"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v11, "Handle account registration in BackgroundService for account: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 73
    :cond_3
    invoke-static {v5}, Lcom/amazon/mShop/sso/SSOUtil;->addAccountCustomKeyMapping(Ljava/lang/String;)V

    .line 79
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v9

    invoke-interface {v9}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    .line 80
    .local v2, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v9, "hasFetchedNonauthCookies"

    invoke-interface {v2, v9}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;)Z

    move-result v3

    .line 82
    .local v3, "hasFetchedNonAuthCookies":Z
    invoke-static {}, Lcom/amazon/mShop/net/CookieBridge;->getCurrentSessionId()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_4

    move v4, v7

    .line 84
    .local v4, "hasSessionID":Z
    :goto_1
    if-eqz v4, :cond_5

    if-nez v3, :cond_5

    move v6, v7

    .line 85
    .local v6, "xMainOnly":Z
    :goto_2
    invoke-static {v1, v8, v7, v5, v6}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->syncAndWait(Landroid/content/Context;ZZLjava/lang/String;Z)V

    .line 87
    invoke-static {}, Lcom/amazon/mShop/kiang/KiangController;->getInstance()Lcom/amazon/mShop/kiang/KiangController;

    move-result-object v7

    invoke-virtual {v7, v1}, Lcom/amazon/mShop/kiang/KiangController;->kiangUpdate(Landroid/content/Context;)V

    .line 89
    invoke-static {v1}, Lcom/amazon/mShop/ActivityTerminationReceiver;->sendTerminationBroadcast(Landroid/content/Context;)V

    goto :goto_0

    .end local v4    # "hasSessionID":Z
    .end local v6    # "xMainOnly":Z
    :cond_4
    move v4, v8

    .line 82
    goto :goto_1

    .restart local v4    # "hasSessionID":Z
    :cond_5
    move v6, v8

    .line 84
    goto :goto_2

    .line 93
    .end local v2    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .end local v3    # "hasFetchedNonAuthCookies":Z
    .end local v4    # "hasSessionID":Z
    :cond_6
    const-string/jumbo v7, "com.amazon.dcp.sso.action.account.removed"

    invoke-virtual {v7, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getPreviouslySeenAmazonAccount()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 101
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->isLogoutTriggeredFromApplication()Z

    move-result v7

    if-nez v7, :cond_8

    .line 103
    sget-boolean v7, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v7, :cond_7

    .line 104
    const-string/jumbo v7, "Amazon.SSOUtil"

    const-string/jumbo v9, "Handle account Deregistration in BackgroundService "

    invoke-static {v7, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 105
    const-string/jumbo v7, "Amazon.SSOUtil"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "current Account : "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v7, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 108
    :cond_7
    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->clearMapSSOUserDataInAllLocales(Landroid/content/Context;)V

    .line 111
    invoke-static {v1}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->fetchNonAuthCookies(Landroid/content/Context;)V

    .line 113
    const-string/jumbo v7, ""

    invoke-static {v1, v7}, Lcom/amazon/mShop/sso/SSOUtil;->setPreviouslySeenAmazonAccount(Landroid/content/Context;Ljava/lang/String;)V

    .line 115
    invoke-static {}, Lcom/amazon/mShop/kiang/KiangController;->getInstance()Lcom/amazon/mShop/kiang/KiangController;

    move-result-object v7

    invoke-virtual {v7, v1}, Lcom/amazon/mShop/kiang/KiangController;->kiangUpdate(Landroid/content/Context;)V

    .line 117
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v7

    new-instance v9, Lcom/amazon/mShop/sso/IdentityType$1$1;

    invoke-direct {v9, p0, v1}, Lcom/amazon/mShop/sso/IdentityType$1$1;-><init>(Lcom/amazon/mShop/sso/IdentityType$1;Landroid/content/Context;)V

    invoke-interface {v7, v9}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 132
    :cond_8
    invoke-static {v8}, Lcom/amazon/mShop/sso/SSOUtil;->setLogoutTriggeredFromApplication(Z)V

    goto/16 :goto_0
.end method

.method public handleSSOInit(Landroid/content/Context;)V
    .locals 9
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 142
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 143
    .local v0, "applicationContext":Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/mShop/net/CookieBridge;->init(Landroid/content/Context;)V

    .line 145
    sget-boolean v6, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v6, :cond_0

    .line 146
    const-string/jumbo v6, "Amazon.SSOUtil"

    const-string/jumbo v7, "SSO.init"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 147
    invoke-static {}, Lcom/amazon/mShop/sso/DebugListener;->init()V

    .line 150
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v6

    invoke-interface {v6}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    .line 151
    .local v2, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getPreviouslySeenAmazonAccount()Ljava/lang/String;

    move-result-object v4

    .line 152
    .local v4, "previousAccount":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 153
    .local v1, "currentAccount":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->selectMatchedAccount()Ljava/lang/String;

    move-result-object v5

    .line 155
    .local v5, "selectedAccount":Ljava/lang/String;
    sget-boolean v6, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v6, :cond_1

    .line 156
    const-string/jumbo v6, "Amazon.SSOUtil"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "previousAccount = "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, "currentAccount = "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, " selectedAccount = "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 159
    :cond_1
    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_7

    .line 166
    if-nez v4, :cond_6

    .line 168
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 170
    invoke-direct {p0, p1}, Lcom/amazon/mShop/sso/IdentityType$1;->silentUpgradeAccount(Landroid/content/Context;)Z

    .line 229
    :cond_2
    :goto_0
    return-void

    .line 175
    :cond_3
    invoke-static {}, Lcom/amazon/mShop/net/CookieBridge;->getCurrentSessionId()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_5

    const/4 v3, 0x1

    .line 176
    .local v3, "hasSessionID":Z
    :goto_1
    if-nez v3, :cond_4

    .line 179
    invoke-static {v0}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->fetchNonAuthCookies(Landroid/content/Context;)V

    .line 181
    :cond_4
    const-string/jumbo v6, ""

    invoke-static {p1, v6}, Lcom/amazon/mShop/sso/SSOUtil;->setPreviouslySeenAmazonAccount(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 175
    .end local v3    # "hasSessionID":Z
    :cond_5
    const/4 v3, 0x0

    goto :goto_1

    .line 184
    :cond_6
    const-string/jumbo v6, ""

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 188
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->clearUserInfoOfCurrentLocale()V

    .line 191
    invoke-static {v0}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->fetchNonAuthCookies(Landroid/content/Context;)V

    .line 192
    const-string/jumbo v6, ""

    invoke-static {p1, v6}, Lcom/amazon/mShop/sso/SSOUtil;->setPreviouslySeenAmazonAccount(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 195
    :cond_7
    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 197
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_8

    .line 198
    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->clearCurrentLocaleCookieAndCookieJar(Landroid/content/Context;)V

    .line 199
    invoke-static {v0, v5}, Lcom/amazon/mShop/sso/SSOUtil;->handleSSOAccount(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 202
    :cond_8
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v6

    if-eqz v6, :cond_a

    .line 204
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_9

    .line 207
    invoke-direct {p0, p1}, Lcom/amazon/mShop/sso/IdentityType$1;->silentUpgradeAccount(Landroid/content/Context;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 208
    invoke-static {v0, v5}, Lcom/amazon/mShop/sso/SSOUtil;->handleSSOAccount(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 215
    :cond_9
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->clearUserInfoOfCurrentLocale()V

    .line 217
    invoke-static {v0, v5}, Lcom/amazon/mShop/sso/SSOUtil;->handleSSOAccount(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 221
    :cond_a
    invoke-static {v0, v5}, Lcom/amazon/mShop/sso/SSOUtil;->handleSSOAccount(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public handleSSOLogin(Landroid/app/Activity;)V
    .locals 6
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v2, 0x0

    .line 371
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move v3, v2

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/sso/IdentityType$1;->handleSSOLogin(Landroid/app/Activity;ZZZLjava/lang/String;)V

    .line 372
    return-void
.end method

.method public handleSSOLogin(Landroid/app/Activity;ZZZLjava/lang/String;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "userInitiatedLogin"    # Z
    .param p3, "forceSignIn"    # Z
    .param p4, "isCreateNewAccount"    # Z
    .param p5, "origin"    # Ljava/lang/String;

    .prologue
    .line 376
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 377
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "USER_INITIATED_LOGIN"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 378
    const-string/jumbo v1, "FORCE_SIGN_IN"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 379
    const-string/jumbo v1, "LOGIN_ORIGIN_KEY"

    invoke-virtual {v0, v1, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 380
    const-string/jumbo v1, "CREATE_NEW_ACCOUNT"

    invoke-virtual {v0, v1, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 381
    const-class v1, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-virtual {v0, p1, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 382
    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 383
    return-void
.end method

.method public handleSSOLogin(Landroid/content/Context;Ljava/lang/String;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "origin"    # Ljava/lang/String;
    .param p3, "flag"    # I

    .prologue
    const/4 v2, 0x0

    .line 387
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 388
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "USER_INITIATED_LOGIN"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 389
    const-string/jumbo v1, "FORCE_SIGN_IN"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 390
    const-string/jumbo v1, "LOGIN_ORIGIN_KEY"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 391
    invoke-virtual {v0, p3}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 392
    const-class v1, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-virtual {v0, p1, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 393
    invoke-virtual {p1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 394
    return-void
.end method

.method public handleSSOLogout(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 2
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 398
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 399
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p1, v0}, Lcom/amazon/mShop/AmazonActivity;->startActivity(Landroid/content/Intent;)V

    .line 400
    return-void
.end method
