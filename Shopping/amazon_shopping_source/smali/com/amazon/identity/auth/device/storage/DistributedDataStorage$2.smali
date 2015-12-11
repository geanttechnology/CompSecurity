.class Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$2;
.super Ljava/lang/Object;
.source "DistributedDataStorage.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

.field final synthetic val$accountData:Lcom/amazon/identity/auth/device/storage/AccountTransaction;

.field final synthetic val$displayName:Ljava/lang/String;

.field final synthetic val$timestamp:Ljava/util/Date;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;)V
    .locals 0

    .prologue
    .line 272
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$2;->this$0:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$2;->val$displayName:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$2;->val$accountData:Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    iput-object p4, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$2;->val$timestamp:Ljava/util/Date;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 290
    const-string/jumbo v0, "AddAccount"

    return-object v0
.end method

.method public performAction(Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;)Z
    .locals 3
    .param p1, "remoteDataStorage"    # Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;

    .prologue
    .line 278
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$2;->val$displayName:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$2;->val$accountData:Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$2;->val$timestamp:Ljava/util/Date;

    invoke-virtual {p1, v0, v1, v2}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;)Z

    move-result v0

    return v0
.end method

.method public setActionPerformed()V
    .locals 3

    .prologue
    .line 284
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$2;->this$0:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    # getter for: Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->access$000(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;)Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$2;->val$accountData:Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$2;->val$timestamp:Ljava/util/Date;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setNotDirtyAddAccount(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;)V

    .line 285
    return-void
.end method
