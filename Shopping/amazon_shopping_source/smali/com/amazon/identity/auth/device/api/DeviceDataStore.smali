.class public final Lcom/amazon/identity/auth/device/api/DeviceDataStore;
.super Ljava/lang/Object;
.source "DeviceDataStore.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/api/DeviceDataStore;


# instance fields
.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private final mDeviceDataCache:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mDeviceDataCommunication:Lcom/amazon/identity/auth/device/DeviceDataCommunication;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/identity/auth/device/api/DeviceDataStore;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 36
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->mDeviceDataCache:Ljava/util/concurrent/ConcurrentHashMap;

    .line 38
    new-instance v0, Lcom/amazon/identity/auth/device/DeviceDataCommunication;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/DeviceDataCommunication;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->mDeviceDataCommunication:Lcom/amazon/identity/auth/device/DeviceDataCommunication;

    .line 39
    return-void
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/DeviceDataStore;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 49
    const-class v1, Lcom/amazon/identity/auth/device/api/DeviceDataStore;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/api/DeviceDataStore;

    if-nez v0, :cond_0

    .line 51
    new-instance v0, Lcom/amazon/identity/auth/device/api/DeviceDataStore;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/api/DeviceDataStore;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/api/DeviceDataStore;

    .line 54
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/api/DeviceDataStore;
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


# virtual methods
.method public getValue(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 77
    if-nez p1, :cond_0

    .line 79
    const-string/jumbo v3, "Key passed in is null"

    new-array v4, v6, [Ljava/lang/Object;

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 80
    .local v0, "errorMsg":Ljava/lang/String;
    sget-object v3, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->TAG:Ljava/lang/String;

    invoke-static {v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    new-instance v3, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;

    invoke-direct {v3, v0}, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 84
    .end local v0    # "errorMsg":Ljava/lang/String;
    :cond_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->mDeviceDataCache:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v3, p1}, Ljava/util/concurrent/ConcurrentHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 86
    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->mDeviceDataCache:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v3, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 114
    :goto_0
    return-object v3

    .line 89
    :cond_1
    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->mDeviceDataCommunication:Lcom/amazon/identity/auth/device/DeviceDataCommunication;

    invoke-virtual {v3, p1}, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->getValue(Ljava/lang/String;)Lcom/amazon/identity/auth/device/DeviceDataInfo;

    move-result-object v1

    .line 91
    .local v1, "retrivedInfo":Lcom/amazon/identity/auth/device/DeviceDataInfo;
    if-nez v1, :cond_2

    .line 93
    const-string/jumbo v3, "Key %s was not found in the device data store"

    new-array v4, v5, [Ljava/lang/Object;

    aput-object p1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 94
    .restart local v0    # "errorMsg":Ljava/lang/String;
    sget-object v3, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->TAG:Ljava/lang/String;

    invoke-static {v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    new-instance v3, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;

    invoke-direct {v3, v0}, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 98
    .end local v0    # "errorMsg":Ljava/lang/String;
    :cond_2
    iget-object v2, v1, Lcom/amazon/identity/auth/device/DeviceDataInfo;->value:Ljava/lang/String;

    .line 102
    .local v2, "value":Ljava/lang/String;
    if-eqz v2, :cond_4

    .line 104
    iget-boolean v3, v1, Lcom/amazon/identity/auth/device/DeviceDataInfo;->isPersistent:Z

    if-eqz v3, :cond_3

    .line 106
    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->mDeviceDataCache:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v3, p1, v2}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_3
    :goto_1
    move-object v3, v2

    .line 114
    goto :goto_0

    .line 111
    :cond_4
    sget-object v3, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Getting null value for key %s "

    new-array v5, v5, [Ljava/lang/Object;

    aput-object p1, v5, v6

    invoke-static {v3, v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method
