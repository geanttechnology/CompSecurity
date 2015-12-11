.class public Lcom/poshmark/data_model/models/inner_models/ListingFeature;
.super Lcom/poshmark/data_model/models/inner_models/Feature;
.source "ListingFeature.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;
    }
.end annotation


# instance fields
.field fee:Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;

.field minimum_listing_price:Ljava/math/BigDecimal;

.field minimum_selling_price:Ljava/math/BigDecimal;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/poshmark/data_model/models/inner_models/Feature;-><init>()V

    .line 68
    return-void
.end method


# virtual methods
.method public getFeeForListingPrice(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    .locals 5
    .param p1, "listingPrice"    # Ljava/math/BigDecimal;

    .prologue
    .line 16
    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->fee:Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;

    if-nez v2, :cond_0

    .line 17
    new-instance v2, Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;

    invoke-direct {v2, p0}, Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;-><init>(Lcom/poshmark/data_model/models/inner_models/ListingFeature;)V

    iput-object v2, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->fee:Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;

    .line 19
    :cond_0
    if-nez p1, :cond_2

    .line 20
    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->fee:Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;->getMinimumFee()Ljava/math/BigDecimal;

    move-result-object v0

    .line 28
    :cond_1
    :goto_0
    return-object v0

    .line 22
    :cond_2
    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->fee:Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;->getCommission()Ljava/math/BigDecimal;

    move-result-object v2

    new-instance v3, Ljava/math/BigDecimal;

    const/16 v4, 0x64

    invoke-direct {v3, v4}, Ljava/math/BigDecimal;-><init>(I)V

    invoke-virtual {v2, v3}, Ljava/math/BigDecimal;->divide(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/math/BigDecimal;->multiply(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v0

    .line 23
    .local v0, "actualFee":Ljava/math/BigDecimal;
    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->fee:Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/ListingFeature$Fee;->getMinimumFee()Ljava/math/BigDecimal;

    move-result-object v1

    .line 25
    .local v1, "minimumFee":Ljava/math/BigDecimal;
    invoke-virtual {v0, v1}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v2

    const/4 v3, 0x1

    if-eq v2, v3, :cond_1

    move-object v0, v1

    .line 28
    goto :goto_0
.end method

.method public getFormattedMinimumSellingPrice()Ljava/lang/String;
    .locals 3

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->getMinimumSellingPrice()Ljava/math/BigDecimal;

    move-result-object v0

    .line 45
    .local v0, "price":Ljava/math/BigDecimal;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Ljava/math/BigDecimal;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getMinimumListingPrice()Ljava/math/BigDecimal;
    .locals 2

    .prologue
    .line 32
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->minimum_listing_price:Ljava/math/BigDecimal;

    if-nez v0, :cond_0

    .line 33
    new-instance v0, Ljava/math/BigDecimal;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/math/BigDecimal;-><init>(I)V

    .line 34
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->minimum_listing_price:Ljava/math/BigDecimal;

    goto :goto_0
.end method

.method public getMinimumSellingPrice()Ljava/math/BigDecimal;
    .locals 2

    .prologue
    .line 38
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->minimum_selling_price:Ljava/math/BigDecimal;

    if-nez v0, :cond_0

    .line 39
    new-instance v0, Ljava/math/BigDecimal;

    const/4 v1, 0x3

    invoke-direct {v0, v1}, Ljava/math/BigDecimal;-><init>(I)V

    .line 40
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->minimum_selling_price:Ljava/math/BigDecimal;

    goto :goto_0
.end method

.method public isEnabled()Z
    .locals 1

    .prologue
    .line 65
    const/4 v0, 0x1

    return v0
.end method

.method public isValidListingPrice(Ljava/lang/String;)Z
    .locals 3
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    .line 57
    new-instance v0, Ljava/math/BigDecimal;

    invoke-direct {v0, p1}, Ljava/math/BigDecimal;-><init>(Ljava/lang/String;)V

    .line 58
    .local v0, "listingPrice":Ljava/math/BigDecimal;
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->minimum_listing_price:Ljava/math/BigDecimal;

    invoke-virtual {v0, v1}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v1

    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    .line 59
    const/4 v1, 0x0

    .line 61
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public isValidSellingPrice(Ljava/lang/String;)Z
    .locals 3
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    .line 49
    new-instance v0, Ljava/math/BigDecimal;

    invoke-direct {v0, p1}, Ljava/math/BigDecimal;-><init>(Ljava/lang/String;)V

    .line 50
    .local v0, "listingPrice":Ljava/math/BigDecimal;
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->minimum_selling_price:Ljava/math/BigDecimal;

    invoke-virtual {v0, v1}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v1

    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    .line 51
    const/4 v1, 0x0

    .line 53
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x1

    goto :goto_0
.end method
