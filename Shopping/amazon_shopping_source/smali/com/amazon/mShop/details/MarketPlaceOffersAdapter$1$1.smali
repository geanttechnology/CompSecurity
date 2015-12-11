.class Lcom/amazon/mShop/details/MarketPlaceOffersAdapter$1$1;
.super Ljava/lang/Object;
.source "MarketPlaceOffersAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/details/MarketPlaceOffersAdapter$1;->onActionButtonClick(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/details/MarketPlaceOffersAdapter$1;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/details/MarketPlaceOffersAdapter$1;)V
    .locals 0

    .prologue
    .line 165
    iput-object p1, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter$1$1;->this$1:Lcom/amazon/mShop/details/MarketPlaceOffersAdapter$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 169
    iget-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter$1$1;->this$1:Lcom/amazon/mShop/details/MarketPlaceOffersAdapter$1;

    iget-object v0, v0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter$1;->this$0:Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;

    const/4 v1, 0x0

    # invokes: Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->setFooterVisibility(I)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->access$000(Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;I)V

    .line 170
    iget-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter$1$1;->this$1:Lcom/amazon/mShop/details/MarketPlaceOffersAdapter$1;

    iget-object v0, v0, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter$1;->this$0:Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;

    # getter for: Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;
    invoke-static {v0}, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->access$100(Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;)Lcom/amazon/mShop/control/PagedListingBrowser;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->replayPageRequest()V

    .line 171
    return-void
.end method
