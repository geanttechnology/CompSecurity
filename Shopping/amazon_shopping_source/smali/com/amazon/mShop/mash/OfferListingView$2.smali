.class Lcom/amazon/mShop/mash/OfferListingView$2;
.super Lcom/amazon/mShop/details/ProductSubscriberBase;
.source "OfferListingView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/OfferListingView;->getProductSubscriber()Lcom/amazon/mShop/control/item/ProductSubscriber;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mash/OfferListingView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mash/OfferListingView;)V
    .locals 0

    .prologue
    .line 118
    iput-object p1, p0, Lcom/amazon/mShop/mash/OfferListingView$2;->this$0:Lcom/amazon/mShop/mash/OfferListingView;

    invoke-direct {p0}, Lcom/amazon/mShop/details/ProductSubscriberBase;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 125
    iget-object v0, p0, Lcom/amazon/mShop/mash/OfferListingView$2;->this$0:Lcom/amazon/mShop/mash/OfferListingView;

    # invokes: Lcom/amazon/mShop/mash/OfferListingView;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    invoke-static {v0, p1, p2}, Lcom/amazon/mShop/mash/OfferListingView;->access$200(Lcom/amazon/mShop/mash/OfferListingView;Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 126
    return-void
.end method

.method public onProductUpdated()V
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/amazon/mShop/mash/OfferListingView$2;->this$0:Lcom/amazon/mShop/mash/OfferListingView;

    # invokes: Lcom/amazon/mShop/mash/OfferListingView;->update()V
    invoke-static {v0}, Lcom/amazon/mShop/mash/OfferListingView;->access$100(Lcom/amazon/mShop/mash/OfferListingView;)V

    .line 122
    return-void
.end method
