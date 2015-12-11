.class public Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "PricesEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Prices;


# instance fields
.field private buy:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

.field private collectible:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

.field private digital:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

.field private editions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;",
            ">;"
        }
    .end annotation
.end field

.field private editionsMetadata:Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;

.field private editionsType:Ljava/lang/String;

.field private kindleUnlimited:Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;

.field private newOffers:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

.field private override:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

.field private refurbished:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

.field private rental:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

.field private sponsored:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

.field private subscribeAndSave:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

.field private tradeIn:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

.field private usedAndNewOffers:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

.field private usedOffers:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

.field private watchInstantly:Lcom/amazon/searchapp/retailsearch/model/Link;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getBuy()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->buy:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    return-object v0
.end method

.method public getCollectible()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->collectible:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    return-object v0
.end method

.method public getDigital()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->digital:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    return-object v0
.end method

.method public getEditions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 355
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->editions:Ljava/util/List;

    return-object v0
.end method

.method public getEditionsMetadata()Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->editionsMetadata:Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;

    return-object v0
.end method

.method public getEditionsType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 395
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->editionsType:Ljava/lang/String;

    return-object v0
.end method

.method public getKindleUnlimited()Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;
    .locals 1

    .prologue
    .line 315
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->kindleUnlimited:Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;

    return-object v0
.end method

.method public getNewOffers()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->newOffers:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    return-object v0
.end method

.method public getOverride()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .locals 1

    .prologue
    .line 335
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->override:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    return-object v0
.end method

.method public getRefurbished()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .locals 1

    .prologue
    .line 275
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->refurbished:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    return-object v0
.end method

.method public getRental()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .locals 1

    .prologue
    .line 215
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->rental:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    return-object v0
.end method

.method public getSponsored()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->sponsored:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    return-object v0
.end method

.method public getSubscribeAndSave()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->subscribeAndSave:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    return-object v0
.end method

.method public getTradeIn()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->tradeIn:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    return-object v0
.end method

.method public getUsedAndNewOffers()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .locals 1

    .prologue
    .line 295
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->usedAndNewOffers:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    return-object v0
.end method

.method public getUsedOffers()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .locals 1

    .prologue
    .line 375
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->usedOffers:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    return-object v0
.end method

.method public getWatchInstantly()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->watchInstantly:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public setBuy(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;)V
    .locals 0
    .param p1, "buy"    # Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .prologue
    .line 125
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->buy:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 126
    return-void
.end method

.method public setCollectible(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;)V
    .locals 0
    .param p1, "collectible"    # Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .prologue
    .line 85
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->collectible:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 86
    return-void
.end method

.method public setDigital(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;)V
    .locals 0
    .param p1, "digital"    # Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .prologue
    .line 145
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->digital:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 146
    return-void
.end method

.method public setEditions(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 365
    .local p1, "editions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->editions:Ljava/util/List;

    .line 366
    return-void
.end method

.method public setEditionsMetadata(Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;)V
    .locals 0
    .param p1, "editionsMetadata"    # Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;

    .prologue
    .line 245
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->editionsMetadata:Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;

    .line 246
    return-void
.end method

.method public setEditionsType(Ljava/lang/String;)V
    .locals 0
    .param p1, "editionsType"    # Ljava/lang/String;

    .prologue
    .line 405
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->editionsType:Ljava/lang/String;

    .line 406
    return-void
.end method

.method public setKindleUnlimited(Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;)V
    .locals 0
    .param p1, "kindleUnlimited"    # Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;

    .prologue
    .line 325
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->kindleUnlimited:Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;

    .line 326
    return-void
.end method

.method public setNewOffers(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;)V
    .locals 0
    .param p1, "newOffers"    # Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->newOffers:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 106
    return-void
.end method

.method public setOverride(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;)V
    .locals 0
    .param p1, "override"    # Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .prologue
    .line 345
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->override:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 346
    return-void
.end method

.method public setRefurbished(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;)V
    .locals 0
    .param p1, "refurbished"    # Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .prologue
    .line 285
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->refurbished:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 286
    return-void
.end method

.method public setRental(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;)V
    .locals 0
    .param p1, "rental"    # Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .prologue
    .line 225
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->rental:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 226
    return-void
.end method

.method public setSponsored(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;)V
    .locals 0
    .param p1, "sponsored"    # Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .prologue
    .line 165
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->sponsored:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 166
    return-void
.end method

.method public setSubscribeAndSave(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;)V
    .locals 0
    .param p1, "subscribeAndSave"    # Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .prologue
    .line 205
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->subscribeAndSave:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 206
    return-void
.end method

.method public setTradeIn(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;)V
    .locals 0
    .param p1, "tradeIn"    # Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .prologue
    .line 265
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->tradeIn:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 266
    return-void
.end method

.method public setUsedAndNewOffers(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;)V
    .locals 0
    .param p1, "usedAndNewOffers"    # Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .prologue
    .line 305
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->usedAndNewOffers:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 306
    return-void
.end method

.method public setUsedOffers(Lcom/amazon/searchapp/retailsearch/model/PriceInfo;)V
    .locals 0
    .param p1, "usedOffers"    # Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .prologue
    .line 385
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->usedOffers:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 386
    return-void
.end method

.method public setWatchInstantly(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "watchInstantly"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 185
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;->watchInstantly:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 186
    return-void
.end method
