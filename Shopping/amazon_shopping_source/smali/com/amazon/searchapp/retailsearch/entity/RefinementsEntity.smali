.class public Lcom/amazon/searchapp/retailsearch/entity/RefinementsEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "RefinementsEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Refinements;


# instance fields
.field private clearAllLink:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private departments:Lcom/amazon/searchapp/retailsearch/model/Department;

.field private filters:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;",
            ">;"
        }
    .end annotation
.end field

.field private prioritizedFilterIds:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getClearAllLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementsEntity;->clearAllLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getDepartments()Lcom/amazon/searchapp/retailsearch/model/Department;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementsEntity;->departments:Lcom/amazon/searchapp/retailsearch/model/Department;

    return-object v0
.end method

.method public getFilters()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;",
            ">;"
        }
    .end annotation

    .prologue
    .line 94
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementsEntity;->filters:Ljava/util/List;

    return-object v0
.end method

.method public getPrioritizedFilterIds()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementsEntity;->prioritizedFilterIds:Ljava/util/List;

    return-object v0
.end method

.method public setClearAllLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "clearAllLink"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementsEntity;->clearAllLink:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 45
    return-void
.end method

.method public setDepartments(Lcom/amazon/searchapp/retailsearch/model/Department;)V
    .locals 0
    .param p1, "departments"    # Lcom/amazon/searchapp/retailsearch/model/Department;

    .prologue
    .line 84
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementsEntity;->departments:Lcom/amazon/searchapp/retailsearch/model/Department;

    .line 85
    return-void
.end method

.method public setFilters(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 104
    .local p1, "filters":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementsEntity;->filters:Ljava/util/List;

    .line 105
    return-void
.end method

.method public setPrioritizedFilterIds(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 64
    .local p1, "prioritizedFilterIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementsEntity;->prioritizedFilterIds:Ljava/util/List;

    .line 65
    return-void
.end method
