.class public Lcom/poshmark/data_model/models/ListingDetails;
.super Lcom/poshmark/data_model/models/ListingSocial;
.source "ListingDetails.java"


# instance fields
.field caller_has_offered:Z

.field events:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Event;",
            ">;"
        }
    .end annotation
.end field

.field offer_data:Lcom/poshmark/data_model/models/inner_models/OfferHistory;

.field pictures:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Picture;",
            ">;"
        }
    .end annotation
.end field

.field price_drop:Lcom/poshmark/data_model/models/PriceDrop;

.field system_messages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/SystemMessage;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/poshmark/data_model/models/ListingSocial;-><init>()V

    .line 19
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/ListingDetails;->caller_has_offered:Z

    return-void
.end method


# virtual methods
.method public getOfferCount()I
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingDetails;->aggregates:Lcom/poshmark/data_model/models/inner_models/ListingAggregates;

    iget v0, v0, Lcom/poshmark/data_model/models/inner_models/ListingAggregates;->active_offers:I

    return v0
.end method

.method public getOffersUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingDetails;->offer_data:Lcom/poshmark/data_model/models/inner_models/OfferHistory;

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingDetails;->offer_data:Lcom/poshmark/data_model/models/inner_models/OfferHistory;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/OfferHistory;->target_url:Ljava/lang/String;

    .line 61
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPictures()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Picture;",
            ">;"
        }
    .end annotation

    .prologue
    .line 22
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingDetails;->pictures:Ljava/util/List;

    return-object v0
.end method

.method public getPriceDropPercentage()I
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingDetails;->price_drop:Lcom/poshmark/data_model/models/PriceDrop;

    if-eqz v0, :cond_0

    .line 67
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingDetails;->price_drop:Lcom/poshmark/data_model/models/PriceDrop;

    iget v0, v0, Lcom/poshmark/data_model/models/PriceDrop;->percentage:I

    .line 69
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSystemMessages()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/SystemMessage;",
            ">;"
        }
    .end annotation

    .prologue
    .line 26
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingDetails;->system_messages:Ljava/util/List;

    return-object v0
.end method

.method public hasOffers()Z
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingDetails;->aggregates:Lcom/poshmark/data_model/models/inner_models/ListingAggregates;

    iget v0, v0, Lcom/poshmark/data_model/models/inner_models/ListingAggregates;->active_offers:I

    if-lez v0, :cond_0

    .line 42
    const/4 v0, 0x1

    .line 45
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public haveIOffered()Z
    .locals 1

    .prologue
    .line 54
    iget-boolean v0, p0, Lcom/poshmark/data_model/models/ListingDetails;->caller_has_offered:Z

    return v0
.end method

.method public isListingAvailable()Z
    .locals 3

    .prologue
    .line 30
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/ListingDetails;->getInventory()Lcom/poshmark/data_model/models/inner_models/Inventory;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Inventory;->getInventoryStatus()Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->toString()Ljava/lang/String;

    move-result-object v0

    .line 31
    .local v0, "listingStatus":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v1

    const v2, 0x7f060187

    invoke-virtual {v1, v2}, Lcom/poshmark/application/PMApplication;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v1

    const v2, 0x7f060186

    invoke-virtual {v1, v2}, Lcom/poshmark/application/PMApplication;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v1

    const v2, 0x7f060185

    invoke-virtual {v1, v2}, Lcom/poshmark/application/PMApplication;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 34
    :cond_0
    const/4 v1, 0x0

    .line 36
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public isListingSold()Z
    .locals 3

    .prologue
    .line 75
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/ListingDetails;->getInventory()Lcom/poshmark/data_model/models/inner_models/Inventory;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Inventory;->getInventoryStatus()Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->toString()Ljava/lang/String;

    move-result-object v0

    .line 76
    .local v0, "listingStatus":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v1

    const v2, 0x7f060187

    invoke-virtual {v1, v2}, Lcom/poshmark/application/PMApplication;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 77
    const/4 v1, 0x1

    .line 79
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method
