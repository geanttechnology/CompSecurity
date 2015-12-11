.class public Lcom/amazon/searchapp/retailsearch/entity/SearchResourcesEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "SearchResourcesEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/SearchResources;


# instance fields
.field private items:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/ResourceSet;",
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
.method public getItems()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/ResourceSet;",
            ">;"
        }
    .end annotation

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResourcesEntity;->items:Ljava/util/List;

    return-object v0
.end method

.method public setItems(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/ResourceSet;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 33
    .local p1, "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/ResourceSet;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResourcesEntity;->items:Ljava/util/List;

    .line 34
    return-void
.end method
