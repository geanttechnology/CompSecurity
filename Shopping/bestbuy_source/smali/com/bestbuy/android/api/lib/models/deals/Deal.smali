.class public Lcom/bestbuy/android/api/lib/models/deals/Deal;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private actualProduct:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field private altImage:Ljava/lang/String;

.field private altImage_hover:Ljava/lang/String;

.field private averageOverallRating:Ljava/lang/String;

.field private category:Ljava/lang/String;

.field private dealDetailLink:Ljava/lang/String;

.field private dealPrice:Ljava/lang/String;

.field private displaySku:Ljava/lang/String;

.field private dotcomReviewUrl:Ljava/lang/String;

.field private dotdStatus:Ljava/lang/String;

.field private freeShipping:Z

.field private getDealUrl:Ljava/lang/String;

.field private isLimitedQuantity:Z

.field private isOnlineOnly:Z

.field private isSavingsOverride:Z

.field private isSuppressed:Z

.field private isUnactivatedPrice:Z

.field private model:Ljava/lang/String;

.field private originalPrice:Ljava/lang/String;

.field private productDetails:Ljava/lang/String;

.field private productDetailsCopy:Ljava/lang/String;

.field private productTitle:Ljava/lang/String;

.field private savings:Ljava/lang/String;

.field private sku:Ljava/lang/String;

.field private subCategory:Ljava/lang/String;

.field private totalReviews:Ljava/lang/String;

.field private upc:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadDealData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/deals/Deal;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 154
    new-instance v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/deals/Deal;-><init>()V

    .line 155
    const-string v1, "sku"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->sku:Ljava/lang/String;

    .line 156
    const-string v1, "display_sku"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->displaySku:Ljava/lang/String;

    .line 157
    const-string v1, "product_title"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->productTitle:Ljava/lang/String;

    .line 158
    const-string v1, "deal_price"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->dealPrice:Ljava/lang/String;

    .line 159
    const-string v1, "original_price"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->originalPrice:Ljava/lang/String;

    .line 160
    const-string v1, "savings"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->savings:Ljava/lang/String;

    .line 161
    const-string v1, "product_details"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->productDetails:Ljava/lang/String;

    .line 162
    const-string v1, "product_details_copy"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->productDetailsCopy:Ljava/lang/String;

    .line 163
    const-string v1, "category"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->category:Ljava/lang/String;

    .line 164
    const-string v1, "sub_category"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->subCategory:Ljava/lang/String;

    .line 165
    const-string v1, "average_overall_rating"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->averageOverallRating:Ljava/lang/String;

    .line 166
    const-string v1, "model"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->model:Ljava/lang/String;

    .line 167
    const-string v1, "alt_image"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->altImage:Ljava/lang/String;

    .line 168
    const-string v1, "alt_image_hover"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->altImage_hover:Ljava/lang/String;

    .line 169
    const-string v1, "dotdStatus"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->dotdStatus:Ljava/lang/String;

    .line 170
    const-string v1, "deal_detail_link"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->dealDetailLink:Ljava/lang/String;

    .line 171
    const-string v1, "get_deal_url"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->getDealUrl:Ljava/lang/String;

    .line 172
    const-string v1, "upc"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->upc:Ljava/lang/String;

    .line 173
    const-string v1, "total_reviews"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->totalReviews:Ljava/lang/String;

    .line 174
    const-string v1, "product_details_copy"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->productDetailsCopy:Ljava/lang/String;

    .line 175
    const-string v1, "dotcom_review_url"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->dotcomReviewUrl:Ljava/lang/String;

    .line 176
    const-string v1, "free_shipping"

    invoke-virtual {p0, v1, v3}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->freeShipping:Z

    .line 177
    const-string v1, "is_limited_quantity"

    invoke-virtual {p0, v1, v3}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->isLimitedQuantity:Z

    .line 178
    const-string v1, "is_online_only"

    invoke-virtual {p0, v1, v3}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->isOnlineOnly:Z

    .line 179
    const-string v1, "is_unactivated_price"

    invoke-virtual {p0, v1, v3}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->isUnactivatedPrice:Z

    .line 180
    const-string v1, "is_suppressed"

    invoke-virtual {p0, v1, v3}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->isSuppressed:Z

    .line 181
    const-string v1, "is_savings_override"

    invoke-virtual {p0, v1, v3}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->isSavingsOverride:Z

    .line 182
    return-object v0
.end method


# virtual methods
.method public getActualProduct()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->actualProduct:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    return-object v0
.end method

.method public getAltImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->altImage:Ljava/lang/String;

    return-object v0
.end method

.method public getAltImage_hover()Ljava/lang/String;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->altImage_hover:Ljava/lang/String;

    return-object v0
.end method

.method public getAverageOverallRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->averageOverallRating:Ljava/lang/String;

    return-object v0
.end method

.method public getCategory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->category:Ljava/lang/String;

    return-object v0
.end method

.method public getDealDetailLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->dealDetailLink:Ljava/lang/String;

    return-object v0
.end method

.method public getDealPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->dealPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplaySku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->displaySku:Ljava/lang/String;

    return-object v0
.end method

.method public getDotcomReviewUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->dotcomReviewUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getDotdStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->dotdStatus:Ljava/lang/String;

    return-object v0
.end method

.method public getGetDealUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->getDealUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getModel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->model:Ljava/lang/String;

    return-object v0
.end method

.method public getOriginalPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->originalPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getProductDetails()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->productDetails:Ljava/lang/String;

    return-object v0
.end method

.method public getProductDetailsCopy()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->productDetailsCopy:Ljava/lang/String;

    return-object v0
.end method

.method public getProductTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->productTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getSavings()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->savings:Ljava/lang/String;

    return-object v0
.end method

.method public getSku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->sku:Ljava/lang/String;

    return-object v0
.end method

.method public getSubCategory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->subCategory:Ljava/lang/String;

    return-object v0
.end method

.method public getTotalReviews()Ljava/lang/String;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->totalReviews:Ljava/lang/String;

    return-object v0
.end method

.method public getUpc()Ljava/lang/String;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->upc:Ljava/lang/String;

    return-object v0
.end method

.method public isFreeShipping()Z
    .locals 1

    .prologue
    .line 106
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->freeShipping:Z

    return v0
.end method

.method public isLimitedQuantity()Z
    .locals 1

    .prologue
    .line 110
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->isLimitedQuantity:Z

    return v0
.end method

.method public isOnlineOnly()Z
    .locals 1

    .prologue
    .line 114
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->isOnlineOnly:Z

    return v0
.end method

.method public isSavingsOverride()Z
    .locals 1

    .prologue
    .line 150
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->isSavingsOverride:Z

    return v0
.end method

.method public isSuppressed()Z
    .locals 1

    .prologue
    .line 122
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->isSuppressed:Z

    return v0
.end method

.method public isUnactivatedPrice()Z
    .locals 1

    .prologue
    .line 118
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->isUnactivatedPrice:Z

    return v0
.end method

.method public setActualProduct(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V
    .locals 0

    .prologue
    .line 46
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/deals/Deal;->actualProduct:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 47
    return-void
.end method
