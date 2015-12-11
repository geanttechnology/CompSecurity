.class public Lcom/amazon/searchapp/retailsearch/entity/PaginationEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "PaginationEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Pagination;


# instance fields
.field private numPages:I

.field private pages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Page;",
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
.method public getNumPages()I
    .locals 1

    .prologue
    .line 26
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PaginationEntity;->numPages:I

    return v0
.end method

.method public getPages()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Page;",
            ">;"
        }
    .end annotation

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PaginationEntity;->pages:Ljava/util/List;

    return-object v0
.end method

.method public setNumPages(I)V
    .locals 0
    .param p1, "numPages"    # I

    .prologue
    .line 36
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PaginationEntity;->numPages:I

    .line 37
    return-void
.end method

.method public setPages(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Page;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 56
    .local p1, "pages":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Page;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PaginationEntity;->pages:Ljava/util/List;

    .line 57
    return-void
.end method
