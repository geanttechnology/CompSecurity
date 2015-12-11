.class public Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;
.super Ljava/lang/Object;
.source "SimilarItemsResponse.java"


# instance fields
.field private datasetInfo:Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;

.field private items:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ">;"
        }
    .end annotation
.end field

.field private totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setDatasetInfo(Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;->datasetInfo:Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;

    .line 45
    return-void
.end method

.method public setItems(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 34
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;->items:Ljava/util/List;

    .line 35
    return-void
.end method

.method public setTotalCount(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 24
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;->totalCount:I

    .line 25
    return-void
.end method
