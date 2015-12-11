.class public Lcom/amazon/searchapp/retailsearch/entity/BreadcrumbEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "BreadcrumbEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;


# instance fields
.field private crumbs:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Link;",
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
.method public getCrumbs()Ljava/util/List;
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
    .line 23
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/BreadcrumbEntity;->crumbs:Ljava/util/List;

    return-object v0
.end method

.method public setCrumbs(Ljava/util/List;)V
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
    .line 33
    .local p1, "crumbs":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Link;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/BreadcrumbEntity;->crumbs:Ljava/util/List;

    .line 34
    return-void
.end method
