.class public Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "EditionsPriceInfoEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;


# instance fields
.field private asin:Ljava/lang/String;

.field private audienceRating:Lcom/amazon/searchapp/retailsearch/model/AudienceRating;

.field private availability:Lcom/amazon/searchapp/retailsearch/model/Availability;

.field private issuePrice:Ljava/lang/String;

.field private kindleUnlimited:Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;

.field private link:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private listPrice:Ljava/lang/String;

.field private map:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private marketplaceAnyPriceLink:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private marketplaceCollectiblePriceLink:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private marketplaceLabel:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field

.field private marketplaceNewPriceLink:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private marketplaceRefurbishedPriceLink:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private marketplaceUsedPriceLink:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private offerCount:J

.field private postLinkText:Ljava/lang/String;

.field private preLinkText:Ljava/lang/String;

.field private price:Ljava/lang/String;

.field private ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

.field private shipping:Lcom/amazon/searchapp/retailsearch/model/Shipping;

.field private unitPrice:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 349
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getAudienceRating()Lcom/amazon/searchapp/retailsearch/model/AudienceRating;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->audienceRating:Lcom/amazon/searchapp/retailsearch/model/AudienceRating;

    return-object v0
.end method

.method public getAvailability()Lcom/amazon/searchapp/retailsearch/model/Availability;
    .locals 1

    .prologue
    .line 449
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->availability:Lcom/amazon/searchapp/retailsearch/model/Availability;

    return-object v0
.end method

.method public getIssuePrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 369
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->issuePrice:Ljava/lang/String;

    return-object v0
.end method

.method public getKindleUnlimited()Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;
    .locals 1

    .prologue
    .line 469
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->kindleUnlimited:Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;

    return-object v0
.end method

.method public getLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 269
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getListPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 489
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->listPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getMap()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->map:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getMarketplaceAnyPriceLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 409
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->marketplaceAnyPriceLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getMarketplaceCollectiblePriceLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 249
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->marketplaceCollectiblePriceLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getMarketplaceLabel()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 229
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->marketplaceLabel:Ljava/util/List;

    return-object v0
.end method

.method public getMarketplaceNewPriceLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->marketplaceNewPriceLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getMarketplaceRefurbishedPriceLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 389
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->marketplaceRefurbishedPriceLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getMarketplaceUsedPriceLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 329
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->marketplaceUsedPriceLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getOfferCount()J
    .locals 2

    .prologue
    .line 189
    iget-wide v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->offerCount:J

    return-wide v0
.end method

.method public getPostLinkText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 209
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->postLinkText:Ljava/lang/String;

    return-object v0
.end method

.method public getPreLinkText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 289
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->preLinkText:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getRatings()Lcom/amazon/searchapp/retailsearch/model/Ratings;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

    return-object v0
.end method

.method public getShipping()Lcom/amazon/searchapp/retailsearch/model/Shipping;
    .locals 1

    .prologue
    .line 429
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->shipping:Lcom/amazon/searchapp/retailsearch/model/Shipping;

    return-object v0
.end method

.method public getUnitPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 309
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->unitPrice:Ljava/lang/String;

    return-object v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 359
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->asin:Ljava/lang/String;

    .line 360
    return-void
.end method

.method public setAudienceRating(Lcom/amazon/searchapp/retailsearch/model/AudienceRating;)V
    .locals 0
    .param p1, "audienceRating"    # Lcom/amazon/searchapp/retailsearch/model/AudienceRating;

    .prologue
    .line 119
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->audienceRating:Lcom/amazon/searchapp/retailsearch/model/AudienceRating;

    .line 120
    return-void
.end method

.method public setAvailability(Lcom/amazon/searchapp/retailsearch/model/Availability;)V
    .locals 0
    .param p1, "availability"    # Lcom/amazon/searchapp/retailsearch/model/Availability;

    .prologue
    .line 459
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->availability:Lcom/amazon/searchapp/retailsearch/model/Availability;

    .line 460
    return-void
.end method

.method public setIssuePrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "issuePrice"    # Ljava/lang/String;

    .prologue
    .line 379
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->issuePrice:Ljava/lang/String;

    .line 380
    return-void
.end method

.method public setKindleUnlimited(Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;)V
    .locals 0
    .param p1, "kindleUnlimited"    # Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;

    .prologue
    .line 479
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->kindleUnlimited:Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;

    .line 480
    return-void
.end method

.method public setLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "link"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 279
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 280
    return-void
.end method

.method public setListPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "listPrice"    # Ljava/lang/String;

    .prologue
    .line 499
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->listPrice:Ljava/lang/String;

    .line 500
    return-void
.end method

.method public setMap(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "map"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 99
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->map:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 100
    return-void
.end method

.method public setMarketplaceAnyPriceLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "marketplaceAnyPriceLink"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 419
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->marketplaceAnyPriceLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 420
    return-void
.end method

.method public setMarketplaceCollectiblePriceLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "marketplaceCollectiblePriceLink"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 259
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->marketplaceCollectiblePriceLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 260
    return-void
.end method

.method public setMarketplaceLabel(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 239
    .local p1, "marketplaceLabel":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->marketplaceLabel:Ljava/util/List;

    .line 240
    return-void
.end method

.method public setMarketplaceNewPriceLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "marketplaceNewPriceLink"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 179
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->marketplaceNewPriceLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 180
    return-void
.end method

.method public setMarketplaceRefurbishedPriceLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "marketplaceRefurbishedPriceLink"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 399
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->marketplaceRefurbishedPriceLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 400
    return-void
.end method

.method public setMarketplaceUsedPriceLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "marketplaceUsedPriceLink"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 339
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->marketplaceUsedPriceLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 340
    return-void
.end method

.method public setOfferCount(J)V
    .locals 0
    .param p1, "offerCount"    # J

    .prologue
    .line 199
    iput-wide p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->offerCount:J

    .line 200
    return-void
.end method

.method public setPostLinkText(Ljava/lang/String;)V
    .locals 0
    .param p1, "postLinkText"    # Ljava/lang/String;

    .prologue
    .line 219
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->postLinkText:Ljava/lang/String;

    .line 220
    return-void
.end method

.method public setPreLinkText(Ljava/lang/String;)V
    .locals 0
    .param p1, "preLinkText"    # Ljava/lang/String;

    .prologue
    .line 299
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->preLinkText:Ljava/lang/String;

    .line 300
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    .line 159
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->price:Ljava/lang/String;

    .line 160
    return-void
.end method

.method public setRatings(Lcom/amazon/searchapp/retailsearch/model/Ratings;)V
    .locals 0
    .param p1, "ratings"    # Lcom/amazon/searchapp/retailsearch/model/Ratings;

    .prologue
    .line 139
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

    .line 140
    return-void
.end method

.method public setShipping(Lcom/amazon/searchapp/retailsearch/model/Shipping;)V
    .locals 0
    .param p1, "shipping"    # Lcom/amazon/searchapp/retailsearch/model/Shipping;

    .prologue
    .line 439
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->shipping:Lcom/amazon/searchapp/retailsearch/model/Shipping;

    .line 440
    return-void
.end method

.method public setUnitPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "unitPrice"    # Ljava/lang/String;

    .prologue
    .line 319
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;->unitPrice:Ljava/lang/String;

    .line 320
    return-void
.end method
