.class public final Lcom/amazon/identity/auth/device/DeviceDataLogic;
.super Ljava/lang/Object;
.source "DeviceDataLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/DeviceDataStoreDefinition;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/DeviceDataLogic$DeviceDataCreator;
    }
.end annotation


# static fields
.field public static final DEVICE_INFO_NAMESPACE:Ljava/lang/String; = "device.metadata"

.field private static final TAG:Ljava/lang/String;

.field private static sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/DeviceDataLogic;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

.field private final mDeviceDataLookup:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/DeviceDataLogic$DeviceDataCreator;",
            ">;"
        }
    .end annotation
.end field

.field private final mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/amazon/identity/auth/device/DeviceDataLogic;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mContext:Landroid/content/Context;

    .line 57
    new-instance v1, Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    .line 58
    iget-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_device_info"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    iput-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    .line 60
    iget-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_data_storage_factory"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 62
    .local v0, "dataStorageFactory":Lcom/amazon/identity/auth/device/storage/DataStorageFactory;
    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 64
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mDeviceDataLookup:Ljava/util/Map;

    .line 65
    iget-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mDeviceDataLookup:Ljava/util/Map;

    const-string/jumbo v2, "Default COR"

    new-instance v3, Lcom/amazon/identity/auth/device/DeviceDataLogic$1;

    invoke-direct {v3, p0}, Lcom/amazon/identity/auth/device/DeviceDataLogic$1;-><init>(Lcom/amazon/identity/auth/device/DeviceDataLogic;)V

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 74
    iget-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mDeviceDataLookup:Ljava/util/Map;

    const-string/jumbo v2, "Default PFM"

    new-instance v3, Lcom/amazon/identity/auth/device/DeviceDataLogic$2;

    invoke-direct {v3, p0}, Lcom/amazon/identity/auth/device/DeviceDataLogic$2;-><init>(Lcom/amazon/identity/auth/device/DeviceDataLogic;)V

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    iget-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mDeviceDataLookup:Ljava/util/Map;

    const-string/jumbo v2, "Client Id"

    new-instance v3, Lcom/amazon/identity/auth/device/DeviceDataLogic$3;

    invoke-direct {v3, p0}, Lcom/amazon/identity/auth/device/DeviceDataLogic$3;-><init>(Lcom/amazon/identity/auth/device/DeviceDataLogic;)V

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 100
    iget-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mDeviceDataLookup:Ljava/util/Map;

    const-string/jumbo v2, "Device Serial Number"

    new-instance v3, Lcom/amazon/identity/auth/device/DeviceDataLogic$4;

    invoke-direct {v3, p0}, Lcom/amazon/identity/auth/device/DeviceDataLogic$4;-><init>(Lcom/amazon/identity/auth/device/DeviceDataLogic;)V

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 109
    iget-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mDeviceDataLookup:Ljava/util/Map;

    const-string/jumbo v2, "DeviceType"

    new-instance v3, Lcom/amazon/identity/auth/device/DeviceDataLogic$5;

    invoke-direct {v3, p0}, Lcom/amazon/identity/auth/device/DeviceDataLogic$5;-><init>(Lcom/amazon/identity/auth/device/DeviceDataLogic;)V

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 134
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/DeviceDataLogic;)Lcom/amazon/identity/auth/attributes/CorPfmInfo;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/DeviceDataLogic;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/device/DeviceDataLogic;)Ljava/lang/String;
    .locals 3
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/DeviceDataLogic;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
        }
    .end annotation

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->isRunningInCentralAPK(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isNonAmazonDeviceWithCentralSSO(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    if-eqz v0, :cond_2

    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getPrimaryAccount()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    sget-object v0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Cannot return DSN on this platform (Grover or Canary V1). We can only return it while the device is registered"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;

    const-string/jumbo v1, "Cannot return DSN on this platform (Grover or Canary V1). We can only return it while the device is registered"

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    new-instance v1, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;-><init>(Landroid/content/Context;)V

    const-string/jumbo v2, "com.amazon.dcp.sso.token.device.deviceserialname"

    invoke-virtual {v1, v0, v2}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_1
    return-object v0

    :cond_2
    iget-object v0, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/device/DeviceDataLogic;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/DeviceDataLogic;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/device/DeviceDataLogic;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/DeviceDataLogic;
    .param p1, "x1"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
        }
    .end annotation

    .prologue
    .line 32
    if-nez p1, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mContext:Landroid/content/Context;

    sget-object v1, Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;->CentralDeviceType:Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/Platform;->getDeviceAttribute(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getAppInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    move-result-object v0

    if-nez v0, :cond_1

    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method static synthetic access$400(Lcom/amazon/identity/auth/device/DeviceDataLogic;Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/DeviceDataLogic;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 32
    const/4 v0, 0x0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/platform/util/PlatformUtils;->isPostMergeDevice(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v1, "device.metadata"

    invoke-virtual {v0, v1, p1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    sget-object v1, Lcom/amazon/identity/auth/device/DeviceDataLogic;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "device attribute "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " not found in datastore"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    return-object v0
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/DeviceDataLogic;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 138
    const-class v1, Lcom/amazon/identity/auth/device/DeviceDataLogic;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/DeviceDataLogic;

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 140
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/DeviceDataLogic;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/DeviceDataLogic;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/DeviceDataLogic;

    .line 143
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/DeviceDataLogic;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 138
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public getValue(Ljava/lang/String;)Lcom/amazon/identity/auth/device/DeviceDataInfo;
    .locals 4
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
        }
    .end annotation

    .prologue
    .line 149
    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->parseKey(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v1

    .line 151
    .local v1, "keyInfo":Lcom/amazon/identity/auth/device/utils/KeyInfo;
    iget-object v2, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic;->mDeviceDataLookup:Ljava/util/Map;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/DeviceDataLogic$DeviceDataCreator;

    .line 152
    .local v0, "deviceDataCreator":Lcom/amazon/identity/auth/device/DeviceDataLogic$DeviceDataCreator;
    if-nez v0, :cond_0

    .line 155
    new-instance v0, Lcom/amazon/identity/auth/device/DeviceDataLogic$6;

    .end local v0    # "deviceDataCreator":Lcom/amazon/identity/auth/device/DeviceDataLogic$DeviceDataCreator;
    invoke-direct {v0, p0, p1}, Lcom/amazon/identity/auth/device/DeviceDataLogic$6;-><init>(Lcom/amazon/identity/auth/device/DeviceDataLogic;Ljava/lang/String;)V

    .line 157
    .restart local v0    # "deviceDataCreator":Lcom/amazon/identity/auth/device/DeviceDataLogic$DeviceDataCreator;
    :cond_0
    if-nez v0, :cond_1

    .line 159
    const/4 v2, 0x0

    .line 162
    :goto_0
    return-object v2

    :cond_1
    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/device/DeviceDataLogic$DeviceDataCreator;->makeDeviceDataInfo(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Lcom/amazon/identity/auth/device/DeviceDataInfo;

    move-result-object v2

    goto :goto_0
.end method
