.class public Lcom/poshmark/data_model/models/ListingSummary;
.super Ljava/lang/Object;
.source "ListingSummary.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE;
    }
.end annotation


# instance fields
.field aggregates:Lcom/poshmark/data_model/models/inner_models/ListingAggregates;

.field brand:Ljava/lang/String;

.field caller_has_liked:Z

.field category_features:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field

.field category_v2:Lcom/poshmark/data_model/models/MetaItem;

.field colors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;"
        }
    .end annotation
.end field

.field condition:Ljava/lang/String;

.field cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

.field created_at:Ljava/lang/String;

.field creator_display_handle:Ljava/lang/String;

.field creator_fb_id:Ljava/lang/String;

.field creator_full_name:Ljava/lang/String;

.field creator_id:Ljava/lang/String;

.field creator_picture_url:Ljava/lang/String;

.field creator_username:Ljava/lang/String;

.field description:Ljava/lang/String;

.field has_offer:Z

.field id:Ljava/lang/String;

.field inventory:Lcom/poshmark/data_model/models/inner_models/Inventory;

.field original_price:Ljava/math/BigDecimal;

.field picture_url:Ljava/lang/String;

.field posters:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Poster;",
            ">;"
        }
    .end annotation
.end field

.field price:Ljava/math/BigDecimal;

.field publish_count:I

.field short_url:Ljava/lang/String;

.field size:Ljava/lang/String;

.field status:Ljava/lang/String;

.field status_changed_at:Ljava/lang/String;

.field title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    return-void
.end method


# virtual methods
.method public copy(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 2
    .param p1, "listing"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 213
    iget v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->publish_count:I

    iput v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->publish_count:I

    .line 214
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->original_price:Ljava/math/BigDecimal;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->original_price:Ljava/math/BigDecimal;

    .line 215
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->id:Ljava/lang/String;

    .line 216
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->creator_username:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->creator_username:Ljava/lang/String;

    .line 217
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->title:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->title:Ljava/lang/String;

    .line 218
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->description:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->description:Ljava/lang/String;

    .line 219
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->created_at:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->created_at:Ljava/lang/String;

    .line 220
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->creator_full_name:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->creator_full_name:Ljava/lang/String;

    .line 221
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->picture_url:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->picture_url:Ljava/lang/String;

    .line 222
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->creator_picture_url:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->creator_picture_url:Ljava/lang/String;

    .line 223
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->status:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->status:Ljava/lang/String;

    .line 224
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->condition:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->condition:Ljava/lang/String;

    .line 225
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->creator_fb_id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->creator_fb_id:Ljava/lang/String;

    .line 226
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->creator_id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->creator_id:Ljava/lang/String;

    .line 227
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->size:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->size:Ljava/lang/String;

    .line 228
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->price:Ljava/math/BigDecimal;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->price:Ljava/math/BigDecimal;

    .line 229
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->short_url:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->short_url:Ljava/lang/String;

    .line 230
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->brand:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->brand:Ljava/lang/String;

    .line 231
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->status_changed_at:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->status_changed_at:Ljava/lang/String;

    .line 232
    iget-object v0, p1, Lcom/poshmark/data_model/models/ListingDetails;->creator_display_handle:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->creator_display_handle:Ljava/lang/String;

    .line 233
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->inventory:Lcom/poshmark/data_model/models/inner_models/Inventory;

    iget-object v1, p1, Lcom/poshmark/data_model/models/ListingDetails;->inventory:Lcom/poshmark/data_model/models/inner_models/Inventory;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Inventory;->copy(Lcom/poshmark/data_model/models/inner_models/Inventory;)V

    .line 234
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v1, p1, Lcom/poshmark/data_model/models/ListingDetails;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/CoverShot;->copy(Lcom/poshmark/data_model/models/inner_models/CoverShot;)V

    .line 236
    return-void
.end method

.method public getAvataar()Ljava/lang/String;
    .locals 4

    .prologue
    .line 123
    const/4 v0, 0x0

    .line 124
    .local v0, "url":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/data_model/models/ListingSummary;->creator_picture_url:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 125
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->creator_picture_url:Ljava/lang/String;

    .line 130
    :cond_0
    :goto_0
    return-object v0

    .line 126
    :cond_1
    iget-object v1, p0, Lcom/poshmark/data_model/models/ListingSummary;->creator_fb_id:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 127
    const-string v0, "https://graph.facebook.com/%s/picture?width=100&height=100"

    .line 128
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/poshmark/data_model/models/ListingSummary;->creator_fb_id:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getBrand()Ljava/lang/String;
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->brand:Ljava/lang/String;

    return-object v0
.end method

.method public getCategory()Lcom/poshmark/data_model/models/MetaItem;
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->category_v2:Lcom/poshmark/data_model/models/MetaItem;

    return-object v0
.end method

.method public getCategoryId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 251
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->category_v2:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCategoryLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 247
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->category_v2:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getColorList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 116
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->colors:Ljava/util/List;

    return-object v0
.end method

.method public getCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 259
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->condition:Ljava/lang/String;

    return-object v0
.end method

.method public getCovershot()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getCovershotId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getCreatorFbId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->creator_fb_id:Ljava/lang/String;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getIdAsLong()J
    .locals 2

    .prologue
    .line 79
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->id:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    return-wide v0
.end method

.method public getIdAsString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getInventory()Lcom/poshmark/data_model/models/inner_models/Inventory;
    .locals 1

    .prologue
    .line 263
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->inventory:Lcom/poshmark/data_model/models/inner_models/Inventory;

    return-object v0
.end method

.method public getListingDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->created_at:Ljava/lang/String;

    return-object v0
.end method

.method public getListingLikeStatus()Z
    .locals 1

    .prologue
    .line 243
    iget-boolean v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->caller_has_liked:Z

    return v0
.end method

.method public getListingStatus()Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->inventory:Lcom/poshmark/data_model/models/inner_models/Inventory;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Inventory;->getInventoryStatus()Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-result-object v0

    return-object v0
.end method

.method public getMediumCovershot()Ljava/lang/String;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getNameIdPair()Lcom/poshmark/utils/NameIdPair;
    .locals 3

    .prologue
    .line 88
    new-instance v0, Lcom/poshmark/utils/NameIdPair;

    iget-object v1, p0, Lcom/poshmark/data_model/models/ListingSummary;->creator_username:Ljava/lang/String;

    iget-object v2, p0, Lcom/poshmark/data_model/models/ListingSummary;->id:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/NameIdPair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public getOriginalPrice()Ljava/math/BigDecimal;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->original_price:Ljava/math/BigDecimal;

    return-object v0
.end method

.method public getOriginalPriceString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 183
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/ListingSummary;->original_price:Ljava/math/BigDecimal;

    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsWholeNumber(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPrice()Ljava/math/BigDecimal;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->price:Ljava/math/BigDecimal;

    return-object v0
.end method

.method public getPriceString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 175
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/ListingSummary;->price:Ljava/math/BigDecimal;

    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPriceStringAsWholeNumber()Ljava/lang/String;
    .locals 2

    .prologue
    .line 179
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/ListingSummary;->price:Ljava/math/BigDecimal;

    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsWholeNumber(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPublishCount()I
    .locals 1

    .prologue
    .line 159
    iget v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->publish_count:I

    return v0
.end method

.method public getShortURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->short_url:Ljava/lang/String;

    return-object v0
.end method

.method public getSize()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->size:Ljava/lang/String;

    return-object v0
.end method

.method public getSmallCovershot()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    return-object v0
.end method

.method public getSubCategoryList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 112
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->category_features:Ljava/util/List;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getTotalComments()I
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->aggregates:Lcom/poshmark/data_model/models/inner_models/ListingAggregates;

    if-eqz v0, :cond_0

    .line 67
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->aggregates:Lcom/poshmark/data_model/models/inner_models/ListingAggregates;

    iget v0, v0, Lcom/poshmark/data_model/models/inner_models/ListingAggregates;->comments:I

    .line 69
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getTotalLikes()I
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->aggregates:Lcom/poshmark/data_model/models/inner_models/ListingAggregates;

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->aggregates:Lcom/poshmark/data_model/models/inner_models/ListingAggregates;

    iget v0, v0, Lcom/poshmark/data_model/models/inner_models/ListingAggregates;->likes:I

    .line 61
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getUserDisplyName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->creator_display_handle:Ljava/lang/String;

    return-object v0
.end method

.method public getUserId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->creator_id:Ljava/lang/String;

    return-object v0
.end method

.method public getUserName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->creator_username:Ljava/lang/String;

    return-object v0
.end method

.method public isAvailableForPurchase()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 287
    iget-object v1, p0, Lcom/poshmark/data_model/models/ListingSummary;->inventory:Lcom/poshmark/data_model/models/inner_models/Inventory;

    if-eqz v1, :cond_1

    .line 288
    iget-object v1, p0, Lcom/poshmark/data_model/models/ListingSummary;->inventory:Lcom/poshmark/data_model/models/inner_models/Inventory;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Inventory;->getInventoryStatus()Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-result-object v1

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->AVAILABLE:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    if-eq v1, v2, :cond_0

    iget-object v1, p0, Lcom/poshmark/data_model/models/ListingSummary;->inventory:Lcom/poshmark/data_model/models/inner_models/Inventory;

    iget-object v1, v1, Lcom/poshmark/data_model/models/inner_models/Inventory;->caller_has_reserved:Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    .line 290
    :cond_1
    return v0
.end method

.method public isNWT()Z
    .locals 2

    .prologue
    .line 267
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->condition:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->condition:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "nwt"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 268
    const/4 v0, 0x1

    .line 269
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPriceValidForOffer()Z
    .locals 4

    .prologue
    .line 188
    new-instance v2, Ljava/math/BigDecimal;

    const/4 v3, 0x3

    invoke-direct {v2, v3}, Ljava/math/BigDecimal;-><init>(I)V

    .line 189
    .local v2, "minPriceVal":Ljava/math/BigDecimal;
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/FeatureManager;->getListingFeature()Lcom/poshmark/data_model/models/inner_models/ListingFeature;

    move-result-object v1

    .line 190
    .local v1, "listingFeature":Lcom/poshmark/data_model/models/inner_models/ListingFeature;
    if-eqz v1, :cond_0

    .line 191
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->getMinimumSellingPrice()Ljava/math/BigDecimal;

    move-result-object v2

    .line 194
    :cond_0
    iget-object v3, p0, Lcom/poshmark/data_model/models/ListingSummary;->price:Ljava/math/BigDecimal;

    invoke-virtual {v3, v2}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v0

    .line 196
    .local v0, "comparisonResult":I
    const/4 v3, -0x1

    if-eq v0, v3, :cond_1

    if-nez v0, :cond_2

    .line 197
    :cond_1
    const/4 v3, 0x0

    .line 199
    :goto_0
    return v3

    :cond_2
    const/4 v3, 0x1

    goto :goto_0
.end method

.method public isRetail()Z
    .locals 2

    .prologue
    .line 273
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->condition:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->condition:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "ret"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 274
    const/4 v0, 0x1

    .line 275
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setListingLikeStatus(Z)V
    .locals 0
    .param p1, "status"    # Z

    .prologue
    .line 239
    iput-boolean p1, p0, Lcom/poshmark/data_model/models/ListingSummary;->caller_has_liked:Z

    .line 240
    return-void
.end method

.method public setShortURL(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 283
    iput-object p1, p0, Lcom/poshmark/data_model/models/ListingSummary;->short_url:Ljava/lang/String;

    .line 284
    return-void
.end method

.method public statusChangedAt()Ljava/lang/String;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/poshmark/data_model/models/ListingSummary;->status_changed_at:Ljava/lang/String;

    return-object v0
.end method
