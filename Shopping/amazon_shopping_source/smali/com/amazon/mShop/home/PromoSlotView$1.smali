.class Lcom/amazon/mShop/home/PromoSlotView$1;
.super Ljava/lang/Object;
.source "PromoSlotView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/PromoSlotView;->setDefaultPromoSlot()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/home/PromoSlotView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/PromoSlotView;)V
    .locals 0

    .prologue
    .line 491
    iput-object p1, p0, Lcom/amazon/mShop/home/PromoSlotView$1;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 497
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/Action;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Action;-><init>()V

    .line 499
    .local v0, "action":Lcom/amazon/rio/j2me/client/services/mShop/Action;
    sget-object v4, Lcom/amazon/mShop/home/HomeView;->ACTION_TYPE_DICTIONARY:Ljava/util/Map;

    iget-object v5, p0, Lcom/amazon/mShop/home/PromoSlotView$1;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # getter for: Lcom/amazon/mShop/home/PromoSlotView;->mActionType:Ljava/lang/String;
    invoke-static {v5}, Lcom/amazon/mShop/home/PromoSlotView;->access$500(Lcom/amazon/mShop/home/PromoSlotView;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v3

    .line 500
    .local v3, "type":I
    invoke-virtual {v0, v3}, Lcom/amazon/rio/j2me/client/services/mShop/Action;->setType(I)V

    .line 501
    iget-object v4, p0, Lcom/amazon/mShop/home/PromoSlotView$1;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # getter for: Lcom/amazon/mShop/home/PromoSlotView;->mActionParam:Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/home/PromoSlotView;->access$600(Lcom/amazon/mShop/home/PromoSlotView;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/amazon/rio/j2me/client/services/mShop/Action;->setParams(Ljava/lang/String;)V

    .line 503
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;-><init>()V

    .line 504
    .local v1, "defaultSlot":Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    invoke-virtual {v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->setAction(Lcom/amazon/rio/j2me/client/services/mShop/Action;)V

    .line 506
    const/4 v4, 0x4

    if-ne v3, v4, :cond_0

    .line 507
    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;-><init>()V

    .line 508
    .local v2, "item":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Action;->getParams()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->setAsin(Ljava/lang/String;)V

    .line 509
    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->setProduct(Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;)V

    .line 513
    .end local v2    # "item":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/home/PromoSlotView$1;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Action;->getType()I

    move-result v5

    # invokes: Lcom/amazon/mShop/home/PromoSlotView;->setDefaultClickStreamOrigin(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;I)V
    invoke-static {v4, v1, v5}, Lcom/amazon/mShop/home/PromoSlotView;->access$700(Lcom/amazon/mShop/home/PromoSlotView;Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;I)V

    .line 515
    iget-object v4, p0, Lcom/amazon/mShop/home/PromoSlotView$1;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # invokes: Lcom/amazon/mShop/home/PromoSlotView;->navigateToAction(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V
    invoke-static {v4, v1}, Lcom/amazon/mShop/home/PromoSlotView;->access$300(Lcom/amazon/mShop/home/PromoSlotView;Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V

    .line 518
    iget-object v4, p0, Lcom/amazon/mShop/home/PromoSlotView$1;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # getter for: Lcom/amazon/mShop/home/PromoSlotView;->mRefMarker:Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/home/PromoSlotView;->access$400(Lcom/amazon/mShop/home/PromoSlotView;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 519
    iget-object v4, p0, Lcom/amazon/mShop/home/PromoSlotView$1;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # getter for: Lcom/amazon/mShop/home/PromoSlotView;->mRefMarker:Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/home/PromoSlotView;->access$400(Lcom/amazon/mShop/home/PromoSlotView;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 522
    :cond_1
    return-void
.end method
