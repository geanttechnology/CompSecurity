.class Lcom/amazon/mShop/startup/StartupSequenceMediator$19;
.super Ljava/lang/Object;
.source "StartupSequenceMediator.java"

# interfaces
.implements Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/startup/StartupSequenceMediator;->checkPrimeFlag(Lcom/amazon/mShop/splashscreen/StartupActivity;Lcom/amazon/mShop/startup/StartupTask;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

.field final synthetic val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/splashscreen/StartupActivity;)V
    .locals 0

    .prologue
    .line 571
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$19;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    iput-object p2, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$19;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancelled()V
    .locals 3

    .prologue
    .line 578
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$19;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    const-string/jumbo v1, "taskPrimeUpsell"

    const-string/jumbo v2, "taskResultFail"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->endTask(Ljava/lang/String;Ljava/lang/String;)V

    .line 579
    return-void
.end method

.method public onComplete()V
    .locals 4

    .prologue
    .line 582
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$19;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    const/4 v1, 0x0

    const-string/jumbo v2, "prime_start"

    const-string/jumbo v3, "taskPrimeUpsell"

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->showPrimeUpsell(Landroid/app/Activity;Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 583
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$19;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    const-string/jumbo v1, "taskPrimeUpsell"

    const-string/jumbo v2, "taskResultSucceed"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->endTask(Ljava/lang/String;Ljava/lang/String;)V

    .line 585
    :cond_0
    return-void
.end method

.method public onError()V
    .locals 3

    .prologue
    .line 574
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$19;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    const-string/jumbo v1, "taskPrimeUpsell"

    const-string/jumbo v2, "taskResultFail"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->endTask(Ljava/lang/String;Ljava/lang/String;)V

    .line 575
    return-void
.end method
