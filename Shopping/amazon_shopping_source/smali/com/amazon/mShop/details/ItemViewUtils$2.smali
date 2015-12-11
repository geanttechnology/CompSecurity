.class final Lcom/amazon/mShop/details/ItemViewUtils$2;
.super Ljava/lang/Object;
.source "ItemViewUtils.java"

# interfaces
.implements Lcom/amazon/mShop/net/HttpFetcher$Subscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/details/ItemViewUtils;->getBadgeFromBackground(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Landroid/widget/TextView;Landroid/text/SpannableStringBuilder;Ljava/lang/String;II)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
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
.field final synthetic val$badgeDefaultHyperTextStart:I

.field final synthetic val$fallbackText:Ljava/lang/String;

.field final synthetic val$imageSpanVerticalAlignment:I

.field final synthetic val$price:Landroid/widget/TextView;

.field final synthetic val$spanned:Landroid/text/SpannableStringBuilder;


# direct methods
.method constructor <init>(Landroid/text/SpannableStringBuilder;Ljava/lang/String;ILandroid/widget/TextView;I)V
    .locals 0

    .prologue
    .line 430
    iput-object p1, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$spanned:Landroid/text/SpannableStringBuilder;

    iput-object p2, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$fallbackText:Ljava/lang/String;

    iput p3, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$badgeDefaultHyperTextStart:I

    iput-object p4, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$price:Landroid/widget/TextView;

    iput p5, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$imageSpanVerticalAlignment:I

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
    .line 462
    .local p1, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    iget-object v0, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$price:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 463
    return-void
.end method

.method public onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 5
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
    .line 433
    .local p2, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    if-eqz p1, :cond_0

    .line 435
    check-cast p2, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    .end local p2    # "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    invoke-virtual {p2}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getBaseUrl()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, p1}, Lcom/amazon/mShop/util/BadgeUtils;->addBadgeBitampToCache(Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 440
    iget-object v3, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$spanned:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v3}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    .line 441
    .local v2, "start":I
    iget-object v3, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$fallbackText:Ljava/lang/String;

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 445
    iget v3, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$badgeDefaultHyperTextStart:I

    add-int/lit8 v2, v3, 0x1

    .line 449
    :goto_0
    iget-object v3, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$spanned:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v3}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v0

    .line 451
    .local v0, "end":I
    new-instance v1, Landroid/text/style/ImageSpan;

    iget-object v3, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$price:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v3

    iget v4, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$imageSpanVerticalAlignment:I

    invoke-direct {v1, v3, p1, v4}, Landroid/text/style/ImageSpan;-><init>(Landroid/content/Context;Landroid/graphics/Bitmap;I)V

    .line 452
    .local v1, "imageSpan":Landroid/text/style/ImageSpan;
    iget-object v3, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$spanned:Landroid/text/SpannableStringBuilder;

    const/16 v4, 0x21

    invoke-virtual {v3, v1, v2, v0, v4}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 455
    iget-object v3, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$price:Landroid/widget/TextView;

    iget-object v4, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$spanned:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 456
    iget-object v3, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$price:Landroid/widget/TextView;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 458
    .end local v0    # "end":I
    .end local v1    # "imageSpan":Landroid/text/style/ImageSpan;
    .end local v2    # "start":I
    :cond_0
    return-void

    .line 447
    .restart local v2    # "start":I
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/details/ItemViewUtils$2;->val$spanned:Landroid/text/SpannableStringBuilder;

    const-string/jumbo v4, " "

    invoke-virtual {v3, v4}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_0
.end method

.method public bridge synthetic onHttpResponseReceived(Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/mShop/net/HttpFetcher$Params;

    .prologue
    .line 430
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/details/ItemViewUtils$2;->onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    return-void
.end method
