.class final Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$23;
.super Ljava/lang/Object;
.source "MShopWearListenerService.java"

# interfaces
.implements Lcom/google/android/gms/common/api/ResultCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/common/api/ResultCallback",
        "<",
        "Lcom/google/android/gms/wearable/NodeApi$GetConnectedNodesResult;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic val$replyPath:Ljava/lang/String;

.field final synthetic val$stampedData:[B


# direct methods
.method constructor <init>(Ljava/lang/String;[B)V
    .locals 0

    .prologue
    .line 489
    iput-object p1, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$23;->val$replyPath:Ljava/lang/String;

    iput-object p2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$23;->val$stampedData:[B

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic onResult(Lcom/google/android/gms/common/api/Result;)V
    .locals 0
    .param p1, "x0"    # Lcom/google/android/gms/common/api/Result;

    .prologue
    .line 489
    check-cast p1, Lcom/google/android/gms/wearable/NodeApi$GetConnectedNodesResult;

    .end local p1    # "x0":Lcom/google/android/gms/common/api/Result;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$23;->onResult(Lcom/google/android/gms/wearable/NodeApi$GetConnectedNodesResult;)V

    return-void
.end method

.method public onResult(Lcom/google/android/gms/wearable/NodeApi$GetConnectedNodesResult;)V
    .locals 7
    .param p1, "getConnectedNodesResult"    # Lcom/google/android/gms/wearable/NodeApi$GetConnectedNodesResult;

    .prologue
    .line 492
    invoke-interface {p1}, Lcom/google/android/gms/wearable/NodeApi$GetConnectedNodesResult;->getNodes()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/wearable/Node;

    .line 493
    .local v1, "node":Lcom/google/android/gms/wearable/Node;
    sget-object v2, Lcom/google/android/gms/wearable/Wearable;->MessageApi:Lcom/google/android/gms/wearable/MessageApi;

    # getter for: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$1300()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v3

    invoke-interface {v1}, Lcom/google/android/gms/wearable/Node;->getId()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$23;->val$replyPath:Ljava/lang/String;

    iget-object v6, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$23;->val$stampedData:[B

    invoke-interface {v2, v3, v4, v5, v6}, Lcom/google/android/gms/wearable/MessageApi;->sendMessage(Lcom/google/android/gms/common/api/GoogleApiClient;Ljava/lang/String;Ljava/lang/String;[B)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v2

    invoke-interface {v2}, Lcom/google/android/gms/common/api/PendingResult;->await()Lcom/google/android/gms/common/api/Result;

    goto :goto_0

    .line 496
    .end local v1    # "node":Lcom/google/android/gms/wearable/Node;
    :cond_0
    return-void
.end method
