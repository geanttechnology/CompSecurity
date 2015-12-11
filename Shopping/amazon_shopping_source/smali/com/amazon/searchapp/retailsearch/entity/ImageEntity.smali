.class public Lcom/amazon/searchapp/retailsearch/entity/ImageEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "ImageEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Image;


# instance fields
.field private altText:Ljava/lang/String;

.field private hiresUrl:Ljava/lang/String;

.field private url:Ljava/lang/String;

.field private videoUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getAltText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageEntity;->altText:Ljava/lang/String;

    return-object v0
.end method

.method public getHiresUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageEntity;->hiresUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageEntity;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getVideoUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageEntity;->videoUrl:Ljava/lang/String;

    return-object v0
.end method

.method public setAltText(Ljava/lang/String;)V
    .locals 0
    .param p1, "altText"    # Ljava/lang/String;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageEntity;->altText:Ljava/lang/String;

    .line 81
    return-void
.end method

.method public setHiresUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "hiresUrl"    # Ljava/lang/String;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageEntity;->hiresUrl:Ljava/lang/String;

    .line 61
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageEntity;->url:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setVideoUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "videoUrl"    # Ljava/lang/String;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageEntity;->videoUrl:Ljava/lang/String;

    .line 101
    return-void
.end method
