.class public Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;
.super Ljava/lang/Object;
.source "PriceModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

.field private shippingInfo:Lcom/amazon/searchapp/retailsearch/model/Shipping;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 251
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private buildSponsoredPriceMsg()Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 369
    const-string/jumbo v2, ""

    .line 371
    .local v2, "sponsoredPriceMsg":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v4

    if-eqz v4, :cond_3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_3

    const/4 v1, 0x1

    .line 372
    .local v1, "hasLinkText":Z
    :goto_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getPreLinkText()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 375
    if-eqz v1, :cond_4

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getPreLinkText()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v0

    .line 378
    .local v0, "chopIndex":I
    :goto_1
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getPreLinkText()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v3, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 381
    .end local v0    # "chopIndex":I
    :cond_0
    if-eqz v1, :cond_2

    .line 383
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 385
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 387
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 389
    :cond_2
    return-object v2

    .end local v1    # "hasLinkText":Z
    :cond_3
    move v1, v3

    .line 371
    goto :goto_0

    .line 375
    .restart local v1    # "hasLinkText":Z
    :cond_4
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getPreLinkText()Ljava/lang/String;

    move-result-object v4

    const/16 v5, 0x3a

    invoke-virtual {v4, v5}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v0

    goto :goto_1
.end method

.method private getAddonBadgeAssetId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 352
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->shippingInfo:Lcom/amazon/searchapp/retailsearch/model/Shipping;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->shippingInfo:Lcom/amazon/searchapp/retailsearch/model/Shipping;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getAddOn()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 354
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->shippingInfo:Lcom/amazon/searchapp/retailsearch/model/Shipping;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getAddOn()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;->getBadgeAssetId()Ljava/lang/String;

    move-result-object v0

    .line 361
    :goto_0
    return-object v0

    .line 356
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getShipping()Lcom/amazon/searchapp/retailsearch/model/Shipping;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getShipping()Lcom/amazon/searchapp/retailsearch/model/Shipping;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getAddOn()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 359
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getShipping()Lcom/amazon/searchapp/retailsearch/model/Shipping;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getAddOn()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;->getBadgeAssetId()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 361
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/Prices;Lcom/amazon/searchapp/retailsearch/model/PriceInfo;Lcom/amazon/searchapp/retailsearch/model/Shipping;ZZZZ)Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;
    .locals 11
    .param p1, "prices"    # Lcom/amazon/searchapp/retailsearch/model/Prices;
    .param p2, "mainPrice"    # Lcom/amazon/searchapp/retailsearch/model/PriceInfo;
    .param p3, "shippingInfo"    # Lcom/amazon/searchapp/retailsearch/model/Shipping;
    .param p4, "useEditions"    # Z
    .param p5, "isSponsoredPrice"    # Z
    .param p6, "showListPrice"    # Z
    .param p7, "showSomePrime"    # Z

    .prologue
    .line 265
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->mainPrice:Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    .line 266
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->shippingInfo:Lcom/amazon/searchapp/retailsearch/model/Shipping;

    .line 267
    if-nez p2, :cond_1

    .line 269
    const/4 v4, 0x0

    .line 343
    :cond_0
    :goto_0
    return-object v4

    .line 272
    :cond_1
    new-instance v4, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    invoke-direct {v4}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;-><init>()V

    .line 275
    .local v4, "model":Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;
    if-eqz p6, :cond_2

    .line 277
    invoke-interface {p2}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getListPrice()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->setListPrice(Ljava/lang/String;)V

    .line 281
    :cond_2
    if-eqz p5, :cond_7

    invoke-interface {p2}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getPostLinkText()Ljava/lang/String;

    move-result-object v6

    .line 282
    .local v6, "priceText":Ljava/lang/String;
    :goto_1
    invoke-virtual {v4, v6}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->setPrice(Ljava/lang/String;)V

    .line 285
    invoke-interface {p2}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getMap()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v10

    if-eqz v10, :cond_3

    .line 287
    sget v10, Lcom/amazon/retailsearch/R$string;->item_map_instructions:I

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v4, v10}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->setMapTextId(Ljava/lang/Integer;)V

    .line 291
    :cond_3
    invoke-interface {p2}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getUnitPrice()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_8

    .line 293
    invoke-interface {p2}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getUnitPrice()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->setUnitOrIssuePrice(Ljava/lang/String;)V

    .line 301
    :cond_4
    :goto_2
    invoke-static {p1, p3}, Lcom/amazon/retailsearch/android/ui/results/ProductUtil;->getShipping(Lcom/amazon/searchapp/retailsearch/model/Prices;Lcom/amazon/searchapp/retailsearch/model/Shipping;)Lcom/amazon/searchapp/retailsearch/model/Shipping;

    move-result-object v1

    .line 302
    .local v1, "defaultShipping":Lcom/amazon/searchapp/retailsearch/model/Shipping;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/ProductUtil;->getPrimeProgramBadgeId(Lcom/amazon/searchapp/retailsearch/model/Shipping;)Ljava/lang/String;

    move-result-object v7

    .line 303
    .local v7, "primeProgramBadgeAssetId":Ljava/lang/String;
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->getAddonBadgeAssetId()Ljava/lang/String;

    move-result-object v0

    .line 304
    .local v0, "addOnBadgeAssetId":Ljava/lang/String;
    if-eqz v0, :cond_9

    .line 306
    invoke-virtual {v4, v0}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->setBadgeId(Ljava/lang/String;)V

    .line 313
    :cond_5
    :goto_3
    invoke-virtual {v4, p4}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->setUseEditions(Z)V

    .line 315
    if-eqz p1, :cond_b

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getEditions()Ljava/util/List;

    move-result-object v10

    if-eqz v10, :cond_b

    .line 317
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Prices;->getEditions()Ljava/util/List;

    move-result-object v2

    .line 318
    .local v2, "editions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;>;"
    new-instance v9, Ljava/util/ArrayList;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v10

    invoke-direct {v9, v10}, Ljava/util/ArrayList;-><init>(I)V

    .line 319
    .local v9, "uiEditions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_6
    :goto_4
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_a

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;

    .line 321
    .local v5, "priceInfo":Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;
    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getPrice()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_6

    .line 323
    new-instance v8, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;

    invoke-direct {v8}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;-><init>()V

    .line 324
    .local v8, "simplePriceInfo":Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;
    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getPrice()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v10}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;->setPrice(Ljava/lang/String;)V

    .line 325
    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v10

    invoke-interface {v10}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v10}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;->setLabel(Ljava/lang/String;)V

    .line 326
    invoke-interface {v9, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 281
    .end local v0    # "addOnBadgeAssetId":Ljava/lang/String;
    .end local v1    # "defaultShipping":Lcom/amazon/searchapp/retailsearch/model/Shipping;
    .end local v2    # "editions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v5    # "priceInfo":Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;
    .end local v6    # "priceText":Ljava/lang/String;
    .end local v7    # "primeProgramBadgeAssetId":Ljava/lang/String;
    .end local v8    # "simplePriceInfo":Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;
    .end local v9    # "uiEditions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;>;"
    :cond_7
    invoke-interface {p2}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getPrice()Ljava/lang/String;

    move-result-object v6

    goto/16 :goto_1

    .line 295
    .restart local v6    # "priceText":Ljava/lang/String;
    :cond_8
    invoke-interface {p2}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getIssuePrice()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_4

    .line 297
    invoke-interface {p2}, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;->getIssuePrice()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->setUnitOrIssuePrice(Ljava/lang/String;)V

    goto :goto_2

    .line 308
    .restart local v0    # "addOnBadgeAssetId":Ljava/lang/String;
    .restart local v1    # "defaultShipping":Lcom/amazon/searchapp/retailsearch/model/Shipping;
    .restart local v7    # "primeProgramBadgeAssetId":Ljava/lang/String;
    :cond_9
    if-eqz v7, :cond_5

    .line 310
    invoke-virtual {v4, v7}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->setBadgeId(Ljava/lang/String;)V

    goto :goto_3

    .line 329
    .restart local v2    # "editions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;>;"
    .restart local v3    # "i$":Ljava/util/Iterator;
    .restart local v9    # "uiEditions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;>;"
    :cond_a
    invoke-virtual {v4, v9}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->setEditions(Ljava/util/List;)V

    .line 333
    .end local v2    # "editions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v9    # "uiEditions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;>;"
    :cond_b
    if-eqz p7, :cond_c

    if-eqz p3, :cond_c

    invoke-interface {p3}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getPrime()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    move-result-object v10

    if-eqz v10, :cond_c

    .line 335
    invoke-interface {p3}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getPrime()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    move-result-object v10

    invoke-interface {v10}, Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;->getMessage()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->setSomePrimeMsg(Ljava/lang/String;)V

    .line 338
    :cond_c
    if-eqz p5, :cond_0

    .line 340
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;->buildSponsoredPriceMsg()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->setSponsoredPriceMsg(Ljava/lang/String;)V

    goto/16 :goto_0
.end method
