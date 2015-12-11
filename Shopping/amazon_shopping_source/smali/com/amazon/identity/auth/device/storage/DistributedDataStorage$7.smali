.class Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$7;
.super Ljava/lang/Object;
.source "DistributedDataStorage.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->setTokens(Ljava/lang/String;Ljava/util/Map;)V
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


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Ljava/util/Map;Ljava/lang/String;Ljava/util/Date;)V
    .locals 0

    .prologue
    .line 497
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$7;->this$0:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$7;->val$tokens:Ljava/util/Map;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$7;->val$directedId:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$7;->val$timestamp:Ljava/util/Date;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 525
    const-string/jumbo v0, "SetToken"

    return-object v0
.end method

.method public performAction(Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;)Z
    .locals 6
    .param p1, "remoteDataStorage"    # Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;

    .prologue
    .line 502
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$7;->val$tokens:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 504
    .local v1, "token":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$7;->val$directedId:Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$7;->val$timestamp:Ljava/util/Date;

    invoke-virtual {p1, v4, v2, v3, v5}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 506
    const/4 v2, 0x0

    .line 509
    .end local v1    # "token":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x1

    goto :goto_0
.end method

.method public setActionPerformed()V
    .locals 5

    .prologue
    .line 516
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$7;->val$tokens:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 518
    .local v1, "key":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$7;->this$0:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    # getter for: Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;
    invoke-static {v2}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->access$000(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;)Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$7;->val$directedId:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$7;->val$timestamp:Ljava/util/Date;

    invoke-virtual {v2, v3, v1, v4}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setNotDirtySetToken(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    goto :goto_0

    .line 520
    .end local v1    # "key":Ljava/lang/String;
    :cond_0
    return-void
.end method
