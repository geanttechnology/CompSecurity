.class Lcom/amazon/mShop/details/MarketPlaceView$3;
.super Ljava/lang/Object;
.source "MarketPlaceView.java"

# interfaces
.implements Landroid/widget/TabHost$TabContentFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/details/MarketPlaceView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/details/MarketPlaceView;

.field final views:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/amazon/mShop/details/MarketPlaceView;)V
    .locals 2

    .prologue
    .line 111
    iput-object p1, p0, Lcom/amazon/mShop/details/MarketPlaceView$3;->this$0:Lcom/amazon/mShop/details/MarketPlaceView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 118
    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceView$3;->views:Ljava/util/Map;

    return-void
.end method


# virtual methods
.method public createTabContent(Ljava/lang/String;)Landroid/view/View;
    .locals 3
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 122
    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceView$3;->views:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 123
    .local v0, "view":Landroid/view/View;
    if-nez v0, :cond_0

    .line 124
    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceView$3;->this$0:Lcom/amazon/mShop/details/MarketPlaceView;

    # getter for: Lcom/amazon/mShop/details/MarketPlaceView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/details/MarketPlaceView;->access$000(Lcom/amazon/mShop/details/MarketPlaceView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceView$3;->this$0:Lcom/amazon/mShop/details/MarketPlaceView;

    # getter for: Lcom/amazon/mShop/details/MarketPlaceView;->productController:Lcom/amazon/mShop/control/item/ProductController;
    invoke-static {v2}, Lcom/amazon/mShop/details/MarketPlaceView;->access$100(Lcom/amazon/mShop/details/MarketPlaceView;)Lcom/amazon/mShop/control/item/ProductController;

    move-result-object v2

    invoke-static {v1, v2, p1}, Lcom/amazon/mShop/details/MarketPlaceOffersAdapter;->getMarketPlaceOffersView(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 125
    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceView$3;->views:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 127
    :cond_0
    return-object v0
.end method
