.class Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;
.super Ljava/lang/Object;
.source "DistributedDataStorage.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

.field final synthetic val$key:Ljava/lang/String;

.field final synthetic val$namespace:Ljava/lang/String;

.field final synthetic val$timestamp:Ljava/util/Date;

.field final synthetic val$value:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V
    .locals 0

    .prologue
    .line 676
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;->this$0:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;->val$namespace:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;->val$key:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;->val$value:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;->val$timestamp:Ljava/util/Date;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 693
    const-string/jumbo v0, "SetDeviceData"

    return-object v0
.end method

.method public performAction(Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;)Z
    .locals 4
    .param p1, "remoteDataStorage"    # Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;

    .prologue
    .line 681
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;->val$namespace:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;->val$key:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;->val$value:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;->val$timestamp:Ljava/util/Date;

    invoke-virtual {p1, v0, v1, v2, v3}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Z

    move-result v0

    return v0
.end method

.method public setActionPerformed()V
    .locals 4

    .prologue
    .line 687
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;->this$0:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    # getter for: Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorage;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->access$000(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;)Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;->val$namespace:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;->val$key:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$10;->val$timestamp:Ljava/util/Date;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->setNotDirtySetDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V

    .line 688
    return-void
.end method
