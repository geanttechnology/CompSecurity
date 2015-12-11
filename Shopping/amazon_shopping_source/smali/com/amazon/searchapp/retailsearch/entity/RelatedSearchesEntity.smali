.class public Lcom/amazon/searchapp/retailsearch/entity/RelatedSearchesEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "RelatedSearchesEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;


# instance fields
.field private altQueries:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Link;",
            ">;"
        }
    .end annotation
.end field

.field private label:Ljava/lang/String;

.field private secondaryResult:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getAltQueries()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Link;",
            ">;"
        }
    .end annotation

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RelatedSearchesEntity;->altQueries:Ljava/util/List;

    return-object v0
.end method

.method public getLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RelatedSearchesEntity;->label:Ljava/lang/String;

    return-object v0
.end method

.method public getSecondaryResult()Z
    .locals 1

    .prologue
    .line 49
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RelatedSearchesEntity;->secondaryResult:Z

    return v0
.end method

.method public setAltQueries(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Link;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 39
    .local p1, "altQueries":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Link;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RelatedSearchesEntity;->altQueries:Ljava/util/List;

    .line 40
    return-void
.end method

.method public setLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RelatedSearchesEntity;->label:Ljava/lang/String;

    .line 80
    return-void
.end method

.method public setSecondaryResult(Z)V
    .locals 0
    .param p1, "secondaryResult"    # Z

    .prologue
    .line 59
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RelatedSearchesEntity;->secondaryResult:Z

    .line 60
    return-void
.end method
