.class public Lcom/amazon/searchapp/retailsearch/entity/RatingsEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "RatingsEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Ratings;


# instance fields
.field private count:I

.field private link:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private rating:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 28
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RatingsEntity;->count:I

    return v0
.end method

.method public getLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RatingsEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getRating()D
    .locals 2

    .prologue
    .line 48
    iget-wide v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RatingsEntity;->rating:D

    return-wide v0
.end method

.method public setCount(I)V
    .locals 0
    .param p1, "count"    # I

    .prologue
    .line 38
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RatingsEntity;->count:I

    .line 39
    return-void
.end method

.method public setLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "link"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RatingsEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 79
    return-void
.end method

.method public setRating(D)V
    .locals 0
    .param p1, "rating"    # D

    .prologue
    .line 58
    iput-wide p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RatingsEntity;->rating:D

    .line 59
    return-void
.end method
