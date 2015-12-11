.class public Lcom/amazon/searchapp/retailsearch/entity/FeaturedPromotionEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "FeaturedPromotionEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/FeaturedPromotion;


# instance fields
.field private actionUrl:Ljava/lang/String;

.field private description:Ljava/lang/String;

.field private image:Lcom/amazon/searchapp/retailsearch/model/Image;

.field private price:Ljava/lang/String;

.field private ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getActionUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedPromotionEntity;->actionUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedPromotionEntity;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getImage()Lcom/amazon/searchapp/retailsearch/model/Image;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedPromotionEntity;->image:Lcom/amazon/searchapp/retailsearch/model/Image;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedPromotionEntity;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getRatings()Lcom/amazon/searchapp/retailsearch/model/Ratings;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedPromotionEntity;->ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedPromotionEntity;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setActionUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "actionUrl"    # Ljava/lang/String;

    .prologue
    .line 108
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedPromotionEntity;->actionUrl:Ljava/lang/String;

    .line 109
    return-void
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "description"    # Ljava/lang/String;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedPromotionEntity;->description:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setImage(Lcom/amazon/searchapp/retailsearch/model/Image;)V
    .locals 0
    .param p1, "image"    # Lcom/amazon/searchapp/retailsearch/model/Image;

    .prologue
    .line 148
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedPromotionEntity;->image:Lcom/amazon/searchapp/retailsearch/model/Image;

    .line 149
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    .line 128
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedPromotionEntity;->price:Ljava/lang/String;

    .line 129
    return-void
.end method

.method public setRatings(Lcom/amazon/searchapp/retailsearch/model/Ratings;)V
    .locals 0
    .param p1, "ratings"    # Lcom/amazon/searchapp/retailsearch/model/Ratings;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedPromotionEntity;->ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

    .line 49
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 88
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedPromotionEntity;->title:Ljava/lang/String;

    .line 89
    return-void
.end method
