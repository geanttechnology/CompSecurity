.class Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$24;
.super Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleResultListener;
.source "MShopWearListenerService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->onRetailSearch(Lcom/google/android/gms/wearable/MessageEvent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;

.field final synthetic val$results:Ljava/util/List;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    .locals 0
    .param p2, "x0"    # Ljava/lang/String;
    .param p3, "x1"    # Ljava/lang/String;

    .prologue
    .line 739
    iput-object p1, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$24;->this$0:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;

    iput-object p4, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$24;->val$results:Ljava/util/List;

    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleResultListener;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public onFoundProduct(Lcom/amazon/mShop/wearable/model/WearableSearchResult;)V
    .locals 1
    .param p1, "result"    # Lcom/amazon/mShop/wearable/model/WearableSearchResult;

    .prologue
    .line 758
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$24;->val$results:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 759
    return-void
.end method

.method public onSuccess()V
    .locals 10

    .prologue
    .line 743
    :try_start_0
    # getter for: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$1600()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v7

    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/ObjectMapper;->createArrayNode()Lcom/fasterxml/jackson/databind/node/ArrayNode;

    move-result-object v4

    .line 744
    .local v4, "resultsJson":Lcom/fasterxml/jackson/databind/node/ArrayNode;
    # getter for: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$1600()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v7

    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/ObjectMapper;->writerWithDefaultPrettyPrinter()Lcom/fasterxml/jackson/databind/ObjectWriter;

    move-result-object v6

    .line 745
    .local v6, "writer":Lcom/fasterxml/jackson/databind/ObjectWriter;
    iget-object v7, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$24;->val$results:Ljava/util/List;

    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/wearable/model/WearableSearchResult;

    .line 746
    .local v3, "result":Lcom/amazon/mShop/wearable/model/WearableSearchResult;
    invoke-virtual {v6, v3}, Lcom/fasterxml/jackson/databind/ObjectWriter;->writeValueAsString(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 747
    .local v2, "json":Ljava/lang/String;
    # getter for: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$1600()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v7

    invoke-virtual {v7, v2}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readTree(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v7

    invoke-virtual {v4, v7}, Lcom/fasterxml/jackson/databind/node/ArrayNode;->add(Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/fasterxml/jackson/databind/node/ArrayNode;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 751
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "json":Ljava/lang/String;
    .end local v3    # "result":Lcom/amazon/mShop/wearable/model/WearableSearchResult;
    .end local v4    # "resultsJson":Lcom/fasterxml/jackson/databind/node/ArrayNode;
    .end local v6    # "writer":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :catch_0
    move-exception v0

    .line 752
    .local v0, "e":Ljava/io/IOException;
    const-string/jumbo v7, "Failed to serialize results to JSON"

    invoke-virtual {p0, v7, v0}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$24;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 754
    .end local v0    # "e":Ljava/io/IOException;
    :goto_1
    return-void

    .line 749
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v4    # "resultsJson":Lcom/fasterxml/jackson/databind/node/ArrayNode;
    .restart local v6    # "writer":Lcom/fasterxml/jackson/databind/ObjectWriter;
    :cond_0
    :try_start_1
    # getter for: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$1600()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v7

    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/ObjectMapper;->writerWithDefaultPrettyPrinter()Lcom/fasterxml/jackson/databind/ObjectWriter;

    move-result-object v7

    invoke-virtual {v7, v4}, Lcom/fasterxml/jackson/databind/ObjectWriter;->writeValueAsString(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 750
    .local v5, "searchResultsJson":Ljava/lang/String;
    iget-object v7, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$24;->mNode:Ljava/lang/String;

    iget-object v8, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$24;->mMessageId:Ljava/lang/String;

    const-string/jumbo v9, "/search/text/result"

    # invokes: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->reply(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v7, v8, v9, v5}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$1400(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method
