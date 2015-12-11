.class Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$1;
.super Ljava/lang/Object;
.source "MarketPlaceOfferDetailView.java"

# interfaces
.implements Lcom/amazon/mShop/net/HttpFetcher$Subscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->updateImage(Landroid/widget/ImageView;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;

.field final synthetic val$imageView:Landroid/widget/ImageView;

.field final synthetic val$thumbnail:[B


# direct methods
.method constructor <init>(Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;Landroid/widget/ImageView;[B)V
    .locals 0

    .prologue
    .line 127
    iput-object p1, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$1;->this$0:Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;

    iput-object p2, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$1;->val$imageView:Landroid/widget/ImageView;

    iput-object p3, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$1;->val$thumbnail:[B

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onHttpRequestFailed(Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 137
    .local p1, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    iget-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$1;->val$thumbnail:[B

    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$1;->val$imageView:Landroid/widget/ImageView;

    invoke-static {v0, v1}, Lcom/amazon/mShop/details/ItemViewUtils;->updateImage([BLandroid/widget/ImageView;)V

    .line 138
    return-void
.end method

.method public onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 3
    .param p1, "response"    # Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/Bitmap;",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 130
    .local p2, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$1;->this$0:Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;

    invoke-virtual {v2}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-interface {v1, v2, p1, p2}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 131
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$1;->val$imageView:Landroid/widget/ImageView;

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 132
    return-void
.end method

.method public bridge synthetic onHttpResponseReceived(Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/mShop/net/HttpFetcher$Params;

    .prologue
    .line 127
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$1;->onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    return-void
.end method
