.class public Lcom/amazon/searchapp/retailsearch/entity/ResourceSetEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "ResourceSetEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/ResourceSet;


# instance fields
.field private id:Ljava/lang/String;

.field private images:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/ImageResource;",
            ">;"
        }
    .end annotation
.end field

.field private strings:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StringResource;",
            ">;"
        }
    .end annotation
.end field

.field private version:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ResourceSetEntity;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getImages()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/ImageResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ResourceSetEntity;->images:Ljava/util/List;

    return-object v0
.end method

.method public getStrings()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StringResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ResourceSetEntity;->strings:Ljava/util/List;

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ResourceSetEntity;->version:Ljava/lang/String;

    return-object v0
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ResourceSetEntity;->id:Ljava/lang/String;

    .line 84
    return-void
.end method

.method public setImages(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/ImageResource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 43
    .local p1, "images":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/ImageResource;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ResourceSetEntity;->images:Ljava/util/List;

    .line 44
    return-void
.end method

.method public setStrings(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StringResource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 103
    .local p1, "strings":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StringResource;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ResourceSetEntity;->strings:Ljava/util/List;

    .line 104
    return-void
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ResourceSetEntity;->version:Ljava/lang/String;

    .line 64
    return-void
.end method
