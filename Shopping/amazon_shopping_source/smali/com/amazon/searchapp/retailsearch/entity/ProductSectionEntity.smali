.class public Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "ProductSectionEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/ProductSection;


# instance fields
.field private items:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ">;"
        }
    .end annotation
.end field

.field private numSections:I

.field private page:I

.field private section:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getItems()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ">;"
        }
    .end annotation

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;->items:Ljava/util/List;

    return-object v0
.end method

.method public getNumSections()I
    .locals 1

    .prologue
    .line 92
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;->numSections:I

    return v0
.end method

.method public getPage()I
    .locals 1

    .prologue
    .line 72
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;->page:I

    return v0
.end method

.method public getSection()I
    .locals 1

    .prologue
    .line 52
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;->section:I

    return v0
.end method

.method public setItems(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 42
    .local p1, "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Product;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;->items:Ljava/util/List;

    .line 43
    return-void
.end method

.method public setNumSections(I)V
    .locals 0
    .param p1, "numSections"    # I

    .prologue
    .line 102
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;->numSections:I

    .line 103
    return-void
.end method

.method public setPage(I)V
    .locals 0
    .param p1, "page"    # I

    .prologue
    .line 82
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;->page:I

    .line 83
    return-void
.end method

.method public setSection(I)V
    .locals 0
    .param p1, "section"    # I

    .prologue
    .line 62
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;->section:I

    .line 63
    return-void
.end method
