.class public Lcom/amazon/searchapp/retailsearch/entity/DepartmentEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "DepartmentEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Department;


# instance fields
.field private allLink:Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

.field private ancestry:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementLink;",
            ">;"
        }
    .end annotation
.end field

.field private categories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementLink;",
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
.method public getAllLink()Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/DepartmentEntity;->allLink:Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    return-object v0
.end method

.method public getAncestry()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementLink;",
            ">;"
        }
    .end annotation

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/DepartmentEntity;->ancestry:Ljava/util/List;

    return-object v0
.end method

.method public getCategories()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementLink;",
            ">;"
        }
    .end annotation

    .prologue
    .line 69
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/DepartmentEntity;->categories:Ljava/util/List;

    return-object v0
.end method

.method public setAllLink(Lcom/amazon/searchapp/retailsearch/model/RefinementLink;)V
    .locals 0
    .param p1, "allLink"    # Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/DepartmentEntity;->allLink:Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    .line 40
    return-void
.end method

.method public setAncestry(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementLink;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 59
    .local p1, "ancestry":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementLink;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/DepartmentEntity;->ancestry:Ljava/util/List;

    .line 60
    return-void
.end method

.method public setCategories(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementLink;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 79
    .local p1, "categories":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementLink;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/DepartmentEntity;->categories:Ljava/util/List;

    .line 80
    return-void
.end method
