.class interface abstract Lcom/amazon/identity/auth/device/DeviceDataLogic$DeviceDataCreator;
.super Ljava/lang/Object;
.source "DeviceDataLogic.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/DeviceDataLogic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x60a
    name = "DeviceDataCreator"
.end annotation


# virtual methods
.method public abstract makeDeviceDataInfo(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Lcom/amazon/identity/auth/device/DeviceDataInfo;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
        }
    .end annotation
.end method
