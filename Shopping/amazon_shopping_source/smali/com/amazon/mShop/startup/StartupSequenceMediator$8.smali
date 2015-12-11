.class Lcom/amazon/mShop/startup/StartupSequenceMediator$8;
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

.field final synthetic val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;Lcom/amazon/mShop/splashscreen/StartupActivity;)V
    .locals 0
    .param p2, "x0"    # Lcom/amazon/mShop/util/mediator/Mediator;
    .param p3, "x1"    # Ljava/lang/String;

    .prologue
    .line 223
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$8;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    iput-object p4, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$8;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/startup/StartupTask;-><init>(Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public start()V
    .locals 8

    .prologue
    .line 226
    const-string/jumbo v4, "StartupSequenceMediator"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "start "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$8;->getId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 227
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 228
    .local v1, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getAuthPoolForCurrentLocale()Ljava/lang/String;

    move-result-object v0

    .line 229
    .local v0, "currentAuthPool":Ljava/lang/String;
    const-string/jumbo v4, "ignoreOptOutFirstLaunch"

    invoke-interface {v1, v4, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    .line 230
    .local v2, "ignoreSSOOptOut":Z
    if-nez v2, :cond_1

    sget-object v4, Lcom/amazon/mShop/sso/IdentityType;->NON_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v5

    if-eq v4, v5, :cond_1

    .line 232
    const-string/jumbo v4, "taskResultSucceed"

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/startup/StartupSequenceMediator$8;->end(Ljava/lang/String;)V

    .line 242
    :cond_0
    :goto_0
    return-void

    .line 233
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->shouldCheckPrimeFlagStatus()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 234
    iget-object v4, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$8;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    iget-object v5, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$8;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    # invokes: Lcom/amazon/mShop/startup/StartupSequenceMediator;->checkPrimeFlag(Lcom/amazon/mShop/splashscreen/StartupActivity;Lcom/amazon/mShop/startup/StartupTask;)V
    invoke-static {v4, v5, p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->access$400(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/splashscreen/StartupActivity;Lcom/amazon/mShop/startup/StartupTask;)V

    goto :goto_0

    .line 237
    :cond_2
    iget-object v4, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$8;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    const/4 v5, 0x0

    const-string/jumbo v6, "prime_start"

    const-string/jumbo v7, "taskPrimeUpsell"

    invoke-static {v4, v5, v6, v7}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->showPrimeUpsell(Landroid/app/Activity;Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    .line 238
    .local v3, "isPrimeUpsellStarted":Z
    if-nez v3, :cond_0

    .line 239
    const-string/jumbo v4, "taskResultSucceed"

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/startup/StartupSequenceMediator$8;->end(Ljava/lang/String;)V

    goto :goto_0
.end method
