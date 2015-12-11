.class Lcom/amazon/mShop/mash/OfferListingView$1$1;
.super Ljava/lang/Object;
.source "OfferListingView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/OfferListingView$1;->onActionButtonClick(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/mash/OfferListingView$1;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mash/OfferListingView$1;)V
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Lcom/amazon/mShop/mash/OfferListingView$1$1;->this$1:Lcom/amazon/mShop/mash/OfferListingView$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/amazon/mShop/mash/OfferListingView$1$1;->this$1:Lcom/amazon/mShop/mash/OfferListingView$1;

    iget-object v0, v0, Lcom/amazon/mShop/mash/OfferListingView$1;->this$0:Lcom/amazon/mShop/mash/OfferListingView;

    # getter for: Lcom/amazon/mShop/mash/OfferListingView;->mProductController:Lcom/amazon/mShop/control/item/ProductController;
    invoke-static {v0}, Lcom/amazon/mShop/mash/OfferListingView;->access$000(Lcom/amazon/mShop/mash/OfferListingView;)Lcom/amazon/mShop/control/item/ProductController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ProductController;->replayProductRequest()V

    .line 110
    return-void
.end method
