.class Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage$1;
.super Ljava/lang/Object;
.source "PromoSlotView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;)V
    .locals 0

    .prologue
    .line 420
    iput-object p1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage$1;->this$1:Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 425
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    .line 426
    .local v0, "o":Ljava/lang/Object;
    instance-of v1, v0, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    if-eqz v1, :cond_0

    .line 427
    iget-object v1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage$1;->this$1:Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

    iget-object v1, v1, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    iget-object v2, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage$1;->this$1:Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

    iget-object v2, v2, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # getter for: Lcom/amazon/mShop/home/PromoSlotView;->mPromoSlotValue:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    invoke-static {v2}, Lcom/amazon/mShop/home/PromoSlotView;->access$200(Lcom/amazon/mShop/home/PromoSlotView;)Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    move-result-object v2

    # invokes: Lcom/amazon/mShop/home/PromoSlotView;->navigateToAction(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V
    invoke-static {v1, v2}, Lcom/amazon/mShop/home/PromoSlotView;->access$300(Lcom/amazon/mShop/home/PromoSlotView;Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V

    .line 431
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage$1;->this$1:Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

    iget-object v1, v1, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # getter for: Lcom/amazon/mShop/home/PromoSlotView;->mRefMarker:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/home/PromoSlotView;->access$400(Lcom/amazon/mShop/home/PromoSlotView;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 432
    iget-object v1, p0, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage$1;->this$1:Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

    iget-object v1, v1, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->this$0:Lcom/amazon/mShop/home/PromoSlotView;

    # getter for: Lcom/amazon/mShop/home/PromoSlotView;->mRefMarker:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/home/PromoSlotView;->access$400(Lcom/amazon/mShop/home/PromoSlotView;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 435
    :cond_1
    return-void
.end method
