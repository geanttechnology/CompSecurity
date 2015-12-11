.class Lcom/amazon/mShop/startup/StartupSequenceMediator$9;
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
    .line 247
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$9;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    iput-object p4, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$9;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/startup/StartupTask;-><init>(Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public start()V
    .locals 4

    .prologue
    .line 250
    const-string/jumbo v1, "StartupSequenceMediator"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "start"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$9;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 254
    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectHelper;->passesPreLaunchCheck()Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$9;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    const-string/jumbo v2, "msc_start"

    const-string/jumbo v3, "taskSocialConnect"

    invoke-static {v1, v2, v3}, Lcom/amazon/mShop/social/SocialConnectHelper;->launchSocialConnect(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    const/4 v0, 0x1

    .line 258
    .local v0, "isSocialConnectStarted":Z
    :goto_0
    if-nez v0, :cond_0

    .line 259
    const-string/jumbo v1, "taskResultSucceed"

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/startup/StartupSequenceMediator$9;->end(Ljava/lang/String;)V

    .line 261
    :cond_0
    return-void

    .line 254
    .end local v0    # "isSocialConnectStarted":Z
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
