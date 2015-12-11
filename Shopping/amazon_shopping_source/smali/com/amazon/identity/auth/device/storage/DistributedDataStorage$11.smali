.class Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$11;
.super Ljava/lang/Object;
.source "DistributedDataStorage.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->propagateDataChangeInTheBackground(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

.field final synthetic val$action:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;

.field final synthetic val$callback:Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)V
    .locals 0

    .prologue
    .line 708
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$11;->this$0:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$11;->val$action:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$11;->val$callback:Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 712
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$11;->this$0:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$11;->val$action:Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;

    # invokes: Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->propagateDataChange(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;)Z
    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->access$100(Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;)Z

    .line 713
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$11;->val$callback:Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;

    if-eqz v0, :cond_0

    .line 715
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$11;->val$callback:Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;

    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;->onSuccess()V

    .line 717
    :cond_0
    return-void
.end method
