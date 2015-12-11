.class public final Lcom/amazon/identity/auth/device/api/DeviceDataKeys;
.super Ljava/lang/Object;
.source "DeviceDataKeys.java"


# static fields
.field public static final KEY_DEVICE_SERIAL_NUMBER:Ljava/lang/String; = "Device Serial Number"

.field public static final KEY_DEVICE_TYPE:Ljava/lang/String; = "DeviceType"

.field public static final KEY_KE_DEVICE:Ljava/lang/String; = "ke_device"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    return-void
.end method

.method public static getDeviceTypeKeyForPackage(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 60
    const-string/jumbo v0, "DeviceType"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
