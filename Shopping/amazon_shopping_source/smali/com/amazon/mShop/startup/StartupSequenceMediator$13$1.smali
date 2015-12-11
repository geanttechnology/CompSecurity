.class Lcom/amazon/mShop/startup/StartupSequenceMediator$13$1;
.super Ljava/lang/Object;
.source "StartupSequenceMediator.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/startup/StartupSequenceMediator$13;->start()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/startup/StartupSequenceMediator$13;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/startup/StartupSequenceMediator$13;)V
    .locals 0

    .prologue
    .line 372
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$13$1;->this$1:Lcom/amazon/mShop/startup/StartupSequenceMediator$13;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 376
    invoke-static {}, Lcom/amazon/mShop/smile/SmileUserListener;->registerUserListener()V

    .line 377
    invoke-static {}, Lcom/amazon/mShop/smile/SmileUserListener;->registerFeatureStateListener()V

    .line 379
    invoke-static {}, Lcom/amazon/mShop/smile/SmileHelper;->shouldSyncSmileInfo()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 380
    invoke-static {}, Lcom/amazon/mShop/control/smile/SmileController;->getInstance()Lcom/amazon/mShop/control/smile/SmileController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/smile/SmileController;->syncSmileInfo()V

    .line 382
    :cond_0
    return-void
.end method
