.class Lcom/amazon/mShop/startup/StartupSequenceMediator$17;
.super Ljava/lang/Object;
.source "StartupSequenceMediator.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/startup/StartupSequenceMediator;->requestFeatureStates(Lcom/amazon/mShop/startup/StartupTask;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

.field final synthetic val$task:Lcom/amazon/mShop/startup/StartupTask;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/startup/StartupTask;)V
    .locals 0

    .prologue
    .line 497
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$17;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    iput-object p2, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$17;->val$task:Lcom/amazon/mShop/startup/StartupTask;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 502
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$17;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    iget-object v1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$17;->val$task:Lcom/amazon/mShop/startup/StartupTask;

    invoke-virtual {v1}, Lcom/amazon/mShop/startup/StartupTask;->getId()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "taskResultFail"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->endTask(Ljava/lang/String;Ljava/lang/String;)V

    .line 503
    return-void
.end method
