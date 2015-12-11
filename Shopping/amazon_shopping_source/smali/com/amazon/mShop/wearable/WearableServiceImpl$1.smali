.class Lcom/amazon/mShop/wearable/WearableServiceImpl$1;
.super Ljava/lang/Object;
.source "WearableServiceImpl.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/SearchResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/wearable/WearableServiceImpl;->searchByText(Ljava/lang/String;Lcom/amazon/mShop/wearable/SearchResultListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/wearable/WearableServiceImpl;

.field final synthetic val$listener:Lcom/amazon/mShop/wearable/SearchResultListener;

.field final synthetic val$resultTransformer:Lcom/amazon/mShop/wearable/RioSearchResultTransformer;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/wearable/WearableServiceImpl;Lcom/amazon/mShop/wearable/SearchResultListener;Lcom/amazon/mShop/wearable/RioSearchResultTransformer;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$1;->this$0:Lcom/amazon/mShop/wearable/WearableServiceImpl;

    iput-object p2, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$1;->val$listener:Lcom/amazon/mShop/wearable/SearchResultListener;

    iput-object p3, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$1;->val$resultTransformer:Lcom/amazon/mShop/wearable/RioSearchResultTransformer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public aboutToReceiveArrayOfSize(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "size"    # I
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 122
    return-void
.end method

.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$1;->val$listener:Lcom/amazon/mShop/wearable/SearchResultListener;

    const-string/jumbo v1, "Failed query"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/amazon/mShop/wearable/SearchResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 94
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 126
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$1;->val$listener:Lcom/amazon/mShop/wearable/SearchResultListener;

    invoke-interface {v0}, Lcom/amazon/mShop/wearable/SearchResultListener;->onSuccess()V

    .line 127
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 87
    # getter for: Lcom/amazon/mShop/wearable/WearableServiceImpl;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/wearable/WearableServiceImpl;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Failed to search"

    invoke-static {v0, v1, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 88
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$1;->val$listener:Lcom/amazon/mShop/wearable/SearchResultListener;

    const-string/jumbo v1, "Failed to query"

    invoke-interface {v0, v1, p1}, Lcom/amazon/mShop/wearable/SearchResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 89
    return-void
.end method

.method public receivedCategoryResult(Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 114
    return-void
.end method

.method public receivedCounts(Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 98
    return-void
.end method

.method public receivedImage([BILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # [B
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 110
    return-void
.end method

.method public receivedQueryDescriptor(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 118
    return-void
.end method

.method public receivedSearchResult(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 102
    iget-object v1, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$1;->val$resultTransformer:Lcom/amazon/mShop/wearable/RioSearchResultTransformer;

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/wearable/RioSearchResultTransformer;->apply(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)Lcom/amazon/mShop/wearable/model/WearableSearchResult;

    move-result-object v0

    .line 103
    .local v0, "result":Lcom/amazon/mShop/wearable/model/WearableSearchResult;
    if-eqz v0, :cond_0

    .line 104
    iget-object v1, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$1;->val$listener:Lcom/amazon/mShop/wearable/SearchResultListener;

    invoke-interface {v1, v0}, Lcom/amazon/mShop/wearable/SearchResultListener;->onFoundProduct(Lcom/amazon/mShop/wearable/model/WearableSearchResult;)V

    .line 106
    :cond_0
    return-void
.end method
