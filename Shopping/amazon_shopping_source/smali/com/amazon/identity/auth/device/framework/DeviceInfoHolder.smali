.class public final Lcom/amazon/identity/auth/device/framework/DeviceInfoHolder;
.super Ljava/lang/Object;
.source "DeviceInfoHolder.java"


# static fields
.field private static sDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/DeviceInfoHolder;->sDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    return-void
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 18
    const-class v1, Lcom/amazon/identity/auth/device/framework/DeviceInfoHolder;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/DeviceInfoHolder;->sDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    if-nez v0, :cond_0

    .line 20
    new-instance v0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/DeviceInfoHolder;->sDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    .line 23
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/DeviceInfoHolder;->sDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 18
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
