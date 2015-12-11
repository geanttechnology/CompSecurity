.class interface abstract Lcom/amazon/identity/auth/device/storage/DistributedDataStorage$RemoteDataStorageAction;
.super Ljava/lang/Object;
.source "DistributedDataStorage.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x60a
    name = "RemoteDataStorageAction"
.end annotation


# virtual methods
.method public abstract getName()Ljava/lang/String;
.end method

.method public abstract performAction(Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;)Z
.end method

.method public abstract setActionPerformed()V
.end method
