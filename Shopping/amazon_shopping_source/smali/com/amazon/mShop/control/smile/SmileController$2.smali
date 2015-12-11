.class Lcom/amazon/mShop/control/smile/SmileController$2;
.super Ljava/lang/Object;
.source "SmileController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/smile/SmileController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/smile/SmileController;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponse;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/smile/SmileController;Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponse;)V
    .locals 0

    .prologue
    .line 49
    iput-object p1, p0, Lcom/amazon/mShop/control/smile/SmileController$2;->this$0:Lcom/amazon/mShop/control/smile/SmileController;

    iput-object p2, p0, Lcom/amazon/mShop/control/smile/SmileController$2;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/mShop/control/smile/SmileController$2;->this$0:Lcom/amazon/mShop/control/smile/SmileController;

    # invokes: Lcom/amazon/mShop/control/smile/SmileController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/smile/SmileController;->access$000(Lcom/amazon/mShop/control/smile/SmileController;)V

    .line 53
    iget-object v0, p0, Lcom/amazon/mShop/control/smile/SmileController$2;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponse;

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->userUpdated(Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponse;)V

    .line 54
    return-void
.end method
