.class public Lcom/amazon/searchapp/retailsearch/entity/ProductSectionSetEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "ProductSectionSetEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/ProductSectionSet;


# instance fields
.field private sections:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/ProductSection;",
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
.method public getSections()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/ProductSection;",
            ">;"
        }
    .end annotation

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionSetEntity;->sections:Ljava/util/List;

    return-object v0
.end method

.method public setSections(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/ProductSection;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 33
    .local p1, "sections":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/ProductSection;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionSetEntity;->sections:Ljava/util/List;

    .line 34
    return-void
.end method
