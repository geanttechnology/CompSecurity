.class public Lcom/amazon/identity/auth/device/CommonInfoGenerator;
.super Ljava/lang/Object;
.source "CommonInfoGenerator.java"


# static fields
.field public static final CURRENT_INFO_VERSIONS:I = 0x1

.field public static final INITIAL_INFO_VERSIONS:I = 0x1

.field public static final SSO_ONLY_ENCRYPTION_KEY:Ljava/lang/String; = "dcp.only.encrypt.key"

.field public static final SSO_ONLY_PROTECTED_STORE_NAME:Ljava/lang/String; = "dcp.only.protected.store"

.field private static final TAG:Ljava/lang/String;

.field private static sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/CommonInfoGenerator;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->mContext:Landroid/content/Context;

    .line 42
    iget-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_data_storage_factory"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 44
    .local v0, "factory":Lcom/amazon/identity/auth/device/storage/DataStorageFactory;
    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 45
    return-void
.end method

.method public static getCommonInfoVersion(Lcom/amazon/identity/auth/device/storage/DataStorage;)I
    .locals 2
    .param p0, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;

    .prologue
    .line 127
    const-string/jumbo v0, "dcp.third.party.device.state"

    const-string/jumbo v1, "info.version"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 128
    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public static getDsn(Lcom/amazon/identity/auth/device/storage/DataStorage;)Ljava/lang/String;
    .locals 2
    .param p0, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;

    .prologue
    .line 115
    const-string/jumbo v0, "dcp.third.party.device.state"

    const-string/jumbo v1, "serial.number"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/CommonInfoGenerator;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 49
    const-class v1, Lcom/amazon/identity/auth/device/CommonInfoGenerator;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/CommonInfoGenerator;

    if-nez v0, :cond_0

    .line 51
    new-instance v0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/CommonInfoGenerator;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/CommonInfoGenerator;

    .line 54
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/CommonInfoGenerator;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 49
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static getTokenKey(Lcom/amazon/identity/auth/device/storage/DataStorage;)Ljava/lang/String;
    .locals 2
    .param p0, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;

    .prologue
    .line 88
    const-string/jumbo v0, "dcp.only.protected.store"

    const-string/jumbo v1, "dcp.only.encrypt.key"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public declared-synchronized generateCommonInfo()I
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 59
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Generating common info for version %d"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    iget-object v0, p0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->getTokenKey(Lcom/amazon/identity/auth/device/storage/DataStorage;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->TAG:Ljava/lang/String;

    iget-object v0, p0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/DeviceInfoHolder;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/AESCipher;->generateAesSecureStorageKeyForDevice(Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v2, "dcp.only.protected.store"

    const-string/jumbo v3, "dcp.only.encrypt.key"

    invoke-virtual {v1, v2, v3, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->TAG:Ljava/lang/String;

    .line 62
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->getDsn(Lcom/amazon/identity/auth/device/storage/DataStorage;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "-"

    const-string/jumbo v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v2, "dcp.third.party.device.state"

    const-string/jumbo v3, "serial.number"

    invoke-virtual {v1, v2, v3, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "DCP generated third party serial number is "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 65
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->syncDirtyData()V

    .line 67
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v2, "dcp.third.party.device.state"

    const-string/jumbo v3, "info.version"

    invoke-virtual {v1, v2, v3, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 69
    monitor-exit p0

    return v5

    .line 59
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
