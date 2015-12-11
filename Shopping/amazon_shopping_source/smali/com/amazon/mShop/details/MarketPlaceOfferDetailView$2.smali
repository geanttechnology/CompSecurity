.class Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$2;
.super Landroid/text/style/ClickableSpan;
.source "MarketPlaceOfferDetailView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->updateAvailabilityBlock(Landroid/view/ViewGroup;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;)V
    .locals 0

    .prologue
    .line 277
    iput-object p1, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$2;->this$0:Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;

    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "widget"    # Landroid/view/View;

    .prologue
    .line 281
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->opl_review_order_legal_url_android:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 282
    .local v1, "url":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->opl_review_order_legal_title:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 283
    .local v0, "title":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$2;->this$0:Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;

    # getter for: Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v2}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->access$000(Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v2

    new-instance v3, Lcom/amazon/mShop/AmazonBrandedWebView;

    iget-object v4, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$2;->this$0:Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;

    # getter for: Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v4}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->access$000(Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v4

    invoke-direct {v3, v4, v1, v0}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 284
    return-void
.end method
