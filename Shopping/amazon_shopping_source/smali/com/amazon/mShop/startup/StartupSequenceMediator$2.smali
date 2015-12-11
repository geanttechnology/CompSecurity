.class Lcom/amazon/mShop/startup/StartupSequenceMediator$2;
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
    .line 117
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$2;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    iput-object p4, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$2;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/startup/StartupTask;-><init>(Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public start()V
    .locals 4

    .prologue
    .line 120
    const-string/jumbo v1, "StartupSequenceMediator"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "start "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$2;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 121
    iget-object v1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$2;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-virtual {p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$2;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->startLocaleSwitchActivityWhenNecessary(Landroid/app/Activity;Ljava/lang/String;)Z

    move-result v0

    .line 122
    .local v0, "started":Z
    const/4 v1, 0x1

    if-eq v0, v1, :cond_0

    .line 123
    const-string/jumbo v1, "taskResultSucceed"

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/startup/StartupSequenceMediator$2;->end(Ljava/lang/String;)V

    .line 125
    :cond_0
    return-void
.end method
