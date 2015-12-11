.class public Lcom/amazon/searchapp/retailsearch/entity/PreloadImagesEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "PreloadImagesEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/PreloadImages;


# instance fields
.field private images:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getImages()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            ">;"
        }
    .end annotation

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PreloadImagesEntity;->images:Ljava/util/List;

    return-object v0
.end method

.method public setImages(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 33
    .local p1, "images":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Image;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PreloadImagesEntity;->images:Ljava/util/List;

    .line 34
    return-void
.end method
