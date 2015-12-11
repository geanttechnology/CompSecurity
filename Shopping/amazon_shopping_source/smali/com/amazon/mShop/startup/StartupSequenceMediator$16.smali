.class Lcom/amazon/mShop/startup/StartupSequenceMediator$16;
.super Ljava/lang/Object;
.source "StartupSequenceMediator.java"

# interfaces
.implements Lcom/amazon/mShop/feature/FeatureStateSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/startup/StartupSequenceMediator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;)V
    .locals 0

    .prologue
    .line 460
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$16;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel()V
    .locals 3

    .prologue
    .line 475
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$16;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    const-string/jumbo v1, "taskGetFeatureState"

    const-string/jumbo v2, "taskResultSucceed"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->endTask(Ljava/lang/String;Ljava/lang/String;)V

    .line 476
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 469
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$16;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    const-string/jumbo v1, "taskGetFeatureState"

    const-string/jumbo v2, "taskResultFail"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->endTask(Ljava/lang/String;Ljava/lang/String;)V

    .line 470
    return-void
.end method

.method public onFeatureStateReceived(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Feature;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 463
    .local p1, "features":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Feature;>;"
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$16;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    const-string/jumbo v1, "taskGetFeatureState"

    const-string/jumbo v2, "taskResultSucceed"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->endTask(Ljava/lang/String;Ljava/lang/String;)V

    .line 464
    return-void
.end method
