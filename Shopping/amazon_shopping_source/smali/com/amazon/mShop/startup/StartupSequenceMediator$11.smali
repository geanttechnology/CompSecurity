.class Lcom/amazon/mShop/startup/StartupSequenceMediator$11;
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
    .line 286
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    iput-object p4, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/startup/StartupTask;-><init>(Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    return-void
.end method

.method private startRequestedEntry()V
    .locals 6

    .prologue
    const/4 v5, -0x1

    .line 319
    iget-object v3, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/splashscreen/StartupActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Intent;->getComponent()Landroid/content/ComponentName;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/ComponentName;->getClassName()Ljava/lang/String;

    move-result-object v1

    .line 320
    .local v1, "className":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->manifest_aiv_launcher_name:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/splashscreen/StartupActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 321
    .local v0, "aivLauncherName":Ljava/lang/String;
    invoke-virtual {v1, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 322
    iget-object v3, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    const/4 v4, 0x0

    invoke-static {v3, v4, v5}, Lcom/amazon/mShop/util/ActivityUtils;->startAIVGatewayActivity(Landroid/content/Context;Ljava/lang/String;I)Z

    .line 330
    :goto_0
    return-void

    .line 323
    :cond_0
    const-string/jumbo v3, "PublicUrlActivity"

    invoke-virtual {v1, v3}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 324
    iget-object v3, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    const-class v4, Lcom/amazon/mShop/publicurl/PublicURLActivity;

    invoke-static {v3, v4, v5}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v2

    .line 325
    .local v2, "intent":Landroid/content/Intent;
    iget-object v3, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/splashscreen/StartupActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 326
    iget-object v3, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-virtual {v3, v2}, Lcom/amazon/mShop/splashscreen/StartupActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 328
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-static {v3}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;)Z

    goto :goto_0
.end method


# virtual methods
.method public start()V
    .locals 3

    .prologue
    .line 291
    const-string/jumbo v0, "StartupSequenceMediator"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "start "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 292
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    # getter for: Lcom/amazon/mShop/startup/StartupSequenceMediator;->mFeatureStateubscriber:Lcom/amazon/mShop/feature/FeatureStateSubscriber;
    invoke-static {v1}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->access$500(Lcom/amazon/mShop/startup/StartupSequenceMediator;)Lcom/amazon/mShop/feature/FeatureStateSubscriber;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/feature/Features;->removeFeatureStateSubscriber(Lcom/amazon/mShop/feature/FeatureStateSubscriber;)V

    .line 293
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    # getter for: Lcom/amazon/mShop/startup/StartupSequenceMediator;->mPrimeFlagChecker:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;
    invoke-static {v0}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->access$600(Lcom/amazon/mShop/startup/StartupSequenceMediator;)Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 294
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    # getter for: Lcom/amazon/mShop/startup/StartupSequenceMediator;->mPrimeFlagChecker:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;
    invoke-static {v0}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->access$600(Lcom/amazon/mShop/startup/StartupSequenceMediator;)Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->setSubscriber(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;)V

    .line 296
    :cond_0
    const-string/jumbo v0, "taskResultSucceed"

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->end(Ljava/lang/String;)V

    .line 300
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x12

    if-ne v0, v1, :cond_1

    .line 304
    invoke-direct {p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->startRequestedEntry()V

    .line 305
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/splashscreen/StartupActivity;->finish()V

    .line 315
    :goto_0
    return-void

    .line 312
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/splashscreen/StartupActivity;->finish()V

    .line 313
    invoke-direct {p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;->startRequestedEntry()V

    goto :goto_0
.end method
