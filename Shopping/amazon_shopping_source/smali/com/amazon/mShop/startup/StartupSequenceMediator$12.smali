.class Lcom/amazon/mShop/startup/StartupSequenceMediator$12;
.super Lcom/amazon/mShop/startup/StartupTask;
.source "StartupSequenceMediator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/startup/StartupSequenceMediator;-><init>(Lcom/amazon/mShop/splashscreen/StartupActivity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V
    .locals 0
    .param p2, "x0"    # Lcom/amazon/mShop/util/mediator/Mediator;
    .param p3, "x1"    # Ljava/lang/String;

    .prologue
    .line 336
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$12;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/startup/StartupTask;-><init>(Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public start()V
    .locals 8

    .prologue
    .line 339
    const-string/jumbo v5, "StartupSequenceMediator"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "start "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$12;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/mShop/util/DebugUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 340
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 344
    .local v1, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    iget-object v5, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$12;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    # invokes: Lcom/amazon/mShop/startup/StartupSequenceMediator;->isAppFirstStart()Z
    invoke-static {v5}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->access$700(Lcom/amazon/mShop/startup/StartupSequenceMediator;)Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->hasAmazonAccount()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 345
    const-string/jumbo v5, "fs_with_account"

    invoke-static {v5}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 348
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getAuthPoolForCurrentLocale()Ljava/lang/String;

    move-result-object v0

    .line 349
    .local v0, "currentAuthPool":Ljava/lang/String;
    const-string/jumbo v5, "ignoreOptOutFirstLaunch"

    invoke-interface {v1, v5, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    .line 351
    .local v2, "ignoreSSOOptOut":Z
    if-nez v2, :cond_1

    sget-object v5, Lcom/amazon/mShop/sso/IdentityType;->NON_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v6

    if-eq v5, v6, :cond_1

    .line 352
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->selectMatchedAccount()Ljava/lang/String;

    move-result-object v4

    .line 353
    .local v4, "selectedAccount":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 354
    const-string/jumbo v5, "ignoreOptOutFirstLaunch"

    const/4 v6, 0x1

    invoke-interface {v1, v5, v6, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;ZLjava/lang/String;)V

    .line 355
    new-instance v3, Landroid/content/Intent;

    invoke-direct {v3}, Landroid/content/Intent;-><init>()V

    .line 356
    .local v3, "intent":Landroid/content/Intent;
    iget-object v5, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$12;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    iget-object v5, v5, Lcom/amazon/mShop/startup/StartupSequenceMediator;->mStartupActivity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    const-class v6, Lcom/amazon/mShop/sso/SSOSplashScreenActivity;

    invoke-virtual {v3, v5, v6}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 357
    iget-object v5, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$12;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    iget-object v5, v5, Lcom/amazon/mShop/startup/StartupSequenceMediator;->mStartupActivity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-virtual {v5, v3}, Lcom/amazon/mShop/splashscreen/StartupActivity;->startActivity(Landroid/content/Intent;)V

    .line 361
    .end local v3    # "intent":Landroid/content/Intent;
    .end local v4    # "selectedAccount":Ljava/lang/String;
    :cond_1
    const-string/jumbo v5, "taskResultSucceed"

    invoke-virtual {p0, v5}, Lcom/amazon/mShop/startup/StartupSequenceMediator$12;->end(Ljava/lang/String;)V

    .line 362
    return-void
.end method
