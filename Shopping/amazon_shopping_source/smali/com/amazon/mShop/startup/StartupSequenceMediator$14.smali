.class Lcom/amazon/mShop/startup/StartupSequenceMediator$14;
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
    .line 391
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$14;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    iput-object p4, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$14;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/startup/StartupTask;-><init>(Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public start()V
    .locals 3

    .prologue
    .line 394
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 395
    .local v1, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    iget-object v2, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$14;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/splashscreen/StartupActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 400
    .local v0, "context":Landroid/content/Context;
    const-string/jumbo v2, "applicationInstallId"

    invoke-interface {v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 401
    invoke-static {}, Lcom/amazon/mShop/kiang/KiangController;->getInstance()Lcom/amazon/mShop/kiang/KiangController;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/amazon/mShop/kiang/KiangController;->kiangRegister(Landroid/content/Context;)V

    .line 409
    :cond_0
    :goto_0
    const-string/jumbo v2, "taskResultSucceed"

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator$14;->end(Ljava/lang/String;)V

    .line 410
    return-void

    .line 402
    :cond_1
    invoke-static {v0}, Lcom/amazon/mShop/util/BuildUtils;->isKiangUpdateActivated(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 407
    invoke-static {}, Lcom/amazon/mShop/kiang/KiangController;->getInstance()Lcom/amazon/mShop/kiang/KiangController;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/amazon/mShop/kiang/KiangController;->kiangUpdate(Landroid/content/Context;)V

    goto :goto_0
.end method
