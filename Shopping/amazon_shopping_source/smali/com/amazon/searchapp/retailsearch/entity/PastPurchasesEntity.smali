.class public Lcom/amazon/searchapp/retailsearch/entity/PastPurchasesEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "PastPurchasesEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/PastPurchases;


# instance fields
.field private purchases:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Purchase;",
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
.method public getPurchases()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Purchase;",
            ">;"
        }
    .end annotation

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PastPurchasesEntity;->purchases:Ljava/util/List;

    return-object v0
.end method

.method public setPurchases(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Purchase;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 33
    .local p1, "purchases":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Purchase;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PastPurchasesEntity;->purchases:Ljava/util/List;

    .line 34
    return-void
.end method
