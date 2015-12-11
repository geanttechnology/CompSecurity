.class Lcom/amazon/mShop/feature/Features$2;
.super Ljava/util/TimerTask;
.source "Features.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/feature/Features;->scheduleFeatureStateCall(J)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/feature/Features;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/feature/Features;)V
    .locals 0

    .prologue
    .line 646
    iput-object p1, p0, Lcom/amazon/mShop/feature/Features$2;->this$0:Lcom/amazon/mShop/feature/Features;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 649
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features$2;->this$0:Lcom/amazon/mShop/feature/Features;

    # invokes: Lcom/amazon/mShop/feature/Features;->sendFeatureStateRequest()V
    invoke-static {v0}, Lcom/amazon/mShop/feature/Features;->access$400(Lcom/amazon/mShop/feature/Features;)V

    .line 651
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/feature/Features$2$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/feature/Features$2$1;-><init>(Lcom/amazon/mShop/feature/Features$2;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 657
    return-void
.end method
