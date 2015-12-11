.class public Lcom/amazon/searchapp/retailsearch/entity/BestSellerEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "BestSellerEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/BestSeller;


# instance fields
.field private badgeAssetId:Ljava/lang/String;

.field private label:Ljava/lang/String;

.field private link:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private node:Ljava/lang/String;

.field private rank:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getBadgeAssetId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/BestSellerEntity;->badgeAssetId:Ljava/lang/String;

    return-object v0
.end method

.method public getLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/BestSellerEntity;->label:Ljava/lang/String;

    return-object v0
.end method

.method public getLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/BestSellerEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getNode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/BestSellerEntity;->node:Ljava/lang/String;

    return-object v0
.end method

.method public getRank()I
    .locals 1

    .prologue
    .line 94
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/BestSellerEntity;->rank:I

    return v0
.end method

.method public setBadgeAssetId(Ljava/lang/String;)V
    .locals 0
    .param p1, "badgeAssetId"    # Ljava/lang/String;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/BestSellerEntity;->badgeAssetId:Ljava/lang/String;

    .line 65
    return-void
.end method

.method public setLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 124
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/BestSellerEntity;->label:Ljava/lang/String;

    .line 125
    return-void
.end method

.method public setLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "link"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 84
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/BestSellerEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 85
    return-void
.end method

.method public setNode(Ljava/lang/String;)V
    .locals 0
    .param p1, "node"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/BestSellerEntity;->node:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public setRank(I)V
    .locals 0
    .param p1, "rank"    # I

    .prologue
    .line 104
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/BestSellerEntity;->rank:I

    .line 105
    return-void
.end method
