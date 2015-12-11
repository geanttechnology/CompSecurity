.class public Lcom/amazon/searchapp/retailsearch/entity/AudienceRatingEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "AudienceRatingEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/AudienceRating;


# instance fields
.field private org:Ljava/lang/String;

.field private rating:Ljava/lang/String;

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getOrg()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/AudienceRatingEntity;->org:Ljava/lang/String;

    return-object v0
.end method

.method public getRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/AudienceRatingEntity;->rating:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/AudienceRatingEntity;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setOrg(Ljava/lang/String;)V
    .locals 0
    .param p1, "org"    # Ljava/lang/String;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/AudienceRatingEntity;->org:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setRating(Ljava/lang/String;)V
    .locals 0
    .param p1, "rating"    # Ljava/lang/String;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/AudienceRatingEntity;->rating:Ljava/lang/String;

    .line 38
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/AudienceRatingEntity;->title:Ljava/lang/String;

    .line 78
    return-void
.end method
