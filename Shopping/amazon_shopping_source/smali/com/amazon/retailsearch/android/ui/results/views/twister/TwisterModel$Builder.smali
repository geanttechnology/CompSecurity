.class public Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Builder;
.super Ljava/lang/Object;
.source "TwisterModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# static fields
.field private static final AIV_EDITION_TYPE:Ljava/lang/String; = "digital_video"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 115
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;Ljava/util/List;Ljava/lang/String;Landroid/content/Context;)Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;
    .locals 10
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "editionsType"    # Ljava/lang/String;
    .param p3, "editionsMetadata"    # Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;
    .param p5, "productGroup"    # Ljava/lang/String;
    .param p6, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;",
            ">;",
            "Ljava/lang/String;",
            "Landroid/content/Context;",
            ")",
            "Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;"
        }
    .end annotation

    .prologue
    .line 129
    .local p4, "editions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;>;"
    if-eqz p2, :cond_0

    if-eqz p4, :cond_0

    invoke-interface {p4}, Ljava/util/List;->size()I

    move-result v0

    const/4 v9, 0x1

    if-le v0, v9, :cond_0

    const-string/jumbo v0, "digital_video"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 131
    :cond_0
    const/4 v1, 0x0

    .line 170
    :cond_1
    return-object v1

    .line 133
    :cond_2
    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;

    invoke-direct {v1}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;-><init>()V

    .line 134
    .local v1, "model":Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;
    invoke-virtual {v1, p1}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->setProductTitle(Ljava/lang/String;)V

    .line 135
    invoke-virtual {v1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->setEditionType(Ljava/lang/String;)V

    .line 136
    invoke-interface {p4}, Ljava/util/List;->size()I

    move-result v0

    new-array v0, v0, [Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    # setter for: Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->editions:[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;
    invoke-static {v1, v0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->access$002(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;)[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    .line 137
    invoke-virtual {v1, p3}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->setEditionsMetadata(Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;)V

    .line 138
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_0
    invoke-interface {p4}, Ljava/util/List;->size()I

    move-result v0

    if-ge v6, v0, :cond_1

    .line 140
    invoke-interface {p4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;

    .line 141
    .local v7, "priceInfo":Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;
    if-eqz v7, :cond_3

    invoke-interface {v7}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v0

    if-nez v0, :cond_4

    .line 138
    :cond_3
    :goto_1
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 145
    :cond_4
    invoke-interface {v7}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v2

    .line 146
    .local v2, "text":Ljava/lang/String;
    invoke-interface {v7}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v8

    .line 147
    .local v8, "url":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 153
    invoke-interface {v7}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getPrice()Ljava/lang/String;

    move-result-object v3

    .line 154
    .local v3, "price":Ljava/lang/String;
    invoke-interface {v7}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getShipping()Lcom/amazon/searchapp/retailsearch/model/Shipping;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/ProductUtil;->getPrimeProgramBadgeId(Lcom/amazon/searchapp/retailsearch/model/Shipping;)Ljava/lang/String;

    move-result-object v4

    .line 156
    .local v4, "srdsBadgeId":Ljava/lang/String;
    new-instance v0, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem$Builder;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem$Builder;-><init>()V

    invoke-interface {v7}, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;->getAsin()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9, v8, p5, p2}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem$Builder;->build(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    move-result-object v5

    .line 163
    .local v5, "resultItem":Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;
    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->editions:[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->access$000(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;)[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    move-result-object v9

    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-direct/range {v0 .. v5}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;-><init>(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;)V

    aput-object v0, v9, v6

    goto :goto_1
.end method
