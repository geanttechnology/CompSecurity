.class public Lcom/amazon/identity/auth/device/DeviceDataCommunication;
.super Ljava/lang/Object;
.source "DeviceDataCommunication.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/DeviceDataStoreDefinition;


# static fields
.field public static final COLUMNS:[Ljava/lang/String;

.field public static final COLUMN_EXCEPTION:Ljava/lang/String; = "exception"

.field public static final COLUMN_IS_PERSISTENT:Ljava/lang/String; = "isPersistent"

.field public static final COLUMN_VALUE:Ljava/lang/String; = "value"

.field public static final DEVICE_DATA_STORE_URI:Landroid/net/Uri;

.field public static final ERROR_COLUMNS:[Ljava/lang/String;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mDeviceDataLogic:Lcom/amazon/identity/auth/device/DeviceDataLogic;

.field private final mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

.field private final mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 22
    const-string/jumbo v0, "content://com.amazon.sso.device.data"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->DEVICE_DATA_STORE_URI:Landroid/net/Uri;

    .line 28
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const-string/jumbo v1, "value"

    aput-object v1, v0, v2

    const-string/jumbo v1, "isPersistent"

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->COLUMNS:[Ljava/lang/String;

    .line 29
    new-array v0, v3, [Ljava/lang/String;

    const-string/jumbo v1, "exception"

    aput-object v1, v0, v2

    sput-object v0, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->ERROR_COLUMNS:[Ljava/lang/String;

    .line 31
    const-class v0, Lcom/amazon/identity/auth/device/DeviceDataCommunication;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;Lcom/amazon/identity/auth/device/framework/SecureContentResolver;Lcom/amazon/identity/auth/device/DeviceDataLogic;)V
    .locals 0
    .param p1, "platform"    # Lcom/amazon/identity/auth/device/framework/PlatformWrapper;
    .param p2, "secureContentResolver"    # Lcom/amazon/identity/auth/device/framework/SecureContentResolver;
    .param p3, "deviceDataLogic"    # Lcom/amazon/identity/auth/device/DeviceDataLogic;

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-object p2, p0, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    .line 49
    iput-object p1, p0, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 50
    iput-object p3, p0, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->mDeviceDataLogic:Lcom/amazon/identity/auth/device/DeviceDataLogic;

    .line 51
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V
    .locals 3
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .prologue
    .line 39
    const-string/jumbo v0, "sso_platform"

    invoke-virtual {p1, v0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    new-instance v1, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    invoke-direct {v1, p1}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;-><init>(Landroid/content/Context;)V

    invoke-static {p1}, Lcom/amazon/identity/auth/device/DeviceDataLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/DeviceDataLogic;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/identity/auth/device/DeviceDataCommunication;-><init>(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;Lcom/amazon/identity/auth/device/framework/SecureContentResolver;Lcom/amazon/identity/auth/device/DeviceDataLogic;)V

    .line 42
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/DeviceDataCommunication;)Lcom/amazon/identity/auth/device/framework/SecureContentResolver;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/DeviceDataCommunication;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    sget-object v0, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/device/DeviceDataCommunication;Landroid/database/Cursor;)V
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/DeviceDataCommunication;
    .param p1, "x1"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
        }
    .end annotation

    .prologue
    .line 20
    const-string/jumbo v0, "exception"

    invoke-static {p1, v0}, Lcom/amazon/identity/auth/device/utils/DBUtils;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->deserialize(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    if-eqz v0, :cond_0

    instance-of v1, v0, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;

    if-eqz v1, :cond_0

    check-cast v0, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;

    throw v0

    :cond_0
    return-void
.end method

.method private retriveValueFromCentralStore(Ljava/lang/String;)Lcom/amazon/identity/auth/device/DeviceDataInfo;
    .locals 4
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
        }
    .end annotation

    .prologue
    .line 70
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    sget-object v2, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->DEVICE_DATA_STORE_URI:Landroid/net/Uri;

    new-instance v3, Lcom/amazon/identity/auth/device/DeviceDataCommunication$1;

    invoke-direct {v3, p0, p1}, Lcom/amazon/identity/auth/device/DeviceDataCommunication$1;-><init>(Lcom/amazon/identity/auth/device/DeviceDataCommunication;Ljava/lang/String;)V

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->acquireContentProviderClient(Landroid/net/Uri;Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/DeviceDataInfo;
    :try_end_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 127
    :catch_0
    move-exception v0

    .line 129
    .local v0, "e":Ljava/util/concurrent/ExecutionException;
    invoke-virtual {v0}, Ljava/util/concurrent/ExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    instance-of v1, v1, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;

    if-eqz v1, :cond_0

    .line 131
    invoke-virtual {v0}, Ljava/util/concurrent/ExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;

    throw v1

    .line 135
    :cond_0
    new-instance v1, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Failed to query device data store: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;-><init>(Ljava/lang/String;)V

    throw v1
.end method


# virtual methods
.method public getValue(Ljava/lang/String;)Lcom/amazon/identity/auth/device/DeviceDataInfo;
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x1

    .line 56
    iget-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    sget-object v2, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->DEVICE_DATA_STORE_URI:Landroid/net/Uri;

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->unSecureCheckHasContentProviderWithAuthority(Landroid/net/Uri;)Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isNewIdentiyMobilePlatformSSO()Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    :goto_0
    if-eqz v0, :cond_3

    .line 58
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->retriveValueFromCentralStore(Ljava/lang/String;)Lcom/amazon/identity/auth/device/DeviceDataInfo;

    move-result-object v0

    .line 62
    :goto_1
    return-object v0

    .line 56
    :cond_1
    const-string/jumbo v1, "Default COR"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "Default PFM"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0

    .line 62
    :cond_3
    iget-object v0, p0, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->mDeviceDataLogic:Lcom/amazon/identity/auth/device/DeviceDataLogic;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/DeviceDataLogic;->getValue(Ljava/lang/String;)Lcom/amazon/identity/auth/device/DeviceDataInfo;

    move-result-object v0

    goto :goto_1
.end method
