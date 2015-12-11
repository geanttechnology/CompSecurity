.class Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;
.super Ljava/lang/Object;
.source "DistributedDataStorage.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$timestamp:Ljava/util/Date;

.field final synthetic val$tokens:Ljava/util/Map;

.field final synthetic val$userData:Ljava/util/Map;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Ljava/util/Map;Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 549
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->this$0:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$tokens:Ljava/util/Map;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$directedId:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$timestamp:Ljava/util/Date;

    iput-object p5, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$userData:Ljava/util/Map;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 608
    const-string/jumbo v0, "SetData"

    return-object v0
.end method

.method public performAction(Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;)Z
    .locals 8
    .param p1, "remoteDataStorage"    # Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;

    .prologue
    const/4 v5, 0x0

    .line 554
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$tokens:Ljava/util/Map;

    if-eqz v3, :cond_1

    .line 556
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$tokens:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 558
    .local v1, "tokenEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$directedId:Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$timestamp:Ljava/util/Date;

    invoke-virtual {p1, v6, v3, v4, v7}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Z

    move-result v3

    if-nez v3, :cond_0

    move v3, v5

    .line 581
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "tokenEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_0
    return v3

    .line 568
    :cond_1
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$userData:Ljava/util/Map;

    if-eqz v3, :cond_3

    .line 570
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$userData:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 572
    .local v2, "userDataEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$directedId:Ljava/lang/String;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$timestamp:Ljava/util/Date;

    invoke-virtual {p1, v6, v3, v4, v7}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Z

    move-result v3

    if-nez v3, :cond_2

    move v3, v5

    .line 577
    goto :goto_0

    .line 581
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v2    # "userDataEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_3
    const/4 v3, 0x1

    goto :goto_0
.end method

.method public setActionPerformed()V
    .locals 6

    .prologue
    .line 588
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$tokens:Ljava/util/Map;

    if-eqz v3, :cond_0

    .line 590
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$tokens:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 592
    .local v1, "tokenKey":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->this$0:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    # getter for: Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;
    invoke-static {v3}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->access$000(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;)Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$directedId:Ljava/lang/String;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$timestamp:Ljava/util/Date;

    invoke-virtual {v3, v4, v1, v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setNotDirtySetToken(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    goto :goto_0

    .line 596
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "tokenKey":Ljava/lang/String;
    :cond_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$userData:Ljava/util/Map;

    if-eqz v3, :cond_1

    .line 598
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$userData:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .restart local v0    # "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 600
    .local v2, "userDataKey":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->this$0:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    # getter for: Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;
    invoke-static {v3}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->access$000(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;)Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$directedId:Ljava/lang/String;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$8;->val$timestamp:Ljava/util/Date;

    invoke-virtual {v3, v4, v2, v5}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setNotDirtySetUserData(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    goto :goto_1

    .line 603
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v2    # "userDataKey":Ljava/lang/String;
    :cond_1
    return-void
.end method
