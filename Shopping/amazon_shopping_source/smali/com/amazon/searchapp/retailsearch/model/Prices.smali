.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/Prices;
.super Ljava/lang/Object;
.source "Prices.java"


# virtual methods
.method public abstract getBuy()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
.end method

.method public abstract getCollectible()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
.end method

.method public abstract getDigital()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
.end method

.method public abstract getEditions()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getEditionsMetadata()Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;
.end method

.method public abstract getEditionsType()Ljava/lang/String;
.end method

.method public abstract getKindleUnlimited()Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;
.end method

.method public abstract getNewOffers()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
.end method

.method public abstract getOverride()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
.end method

.method public abstract getRefurbished()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
.end method

.method public abstract getRental()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
.end method

.method public abstract getSponsored()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
.end method

.method public abstract getSubscribeAndSave()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
.end method

.method public abstract getTradeIn()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
.end method

.method public abstract getUsedAndNewOffers()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
.end method

.method public abstract getUsedOffers()Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
.end method

.method public abstract getWatchInstantly()Lcom/amazon/searchapp/retailsearch/model/Link;
.end method
