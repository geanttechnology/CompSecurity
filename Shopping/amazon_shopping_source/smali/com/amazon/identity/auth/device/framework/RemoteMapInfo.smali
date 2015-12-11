.class public Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
.super Ljava/lang/Object;
.source "RemoteMapInfo.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private mDeviceType:Ljava/lang/String;

.field private mForceQueryRemote:Z

.field private mHasFetchedData:Z

.field private mMAPInitVersion:Ljava/lang/Integer;

.field private mMajorVersion:Ljava/lang/Integer;

.field private mMinorVersion:Ljava/lang/Integer;

.field private mOverrideDSN:Ljava/lang/String;

.field private final mPackageName:Ljava/lang/String;

.field private mPackageVersion:Ljava/lang/Integer;

.field private final mProviderAuthority:Ljava/lang/String;

.field private mRemoteMapException:Lcom/amazon/identity/auth/device/framework/RemoteMAPException;

.field private mSWVersion:Ljava/lang/Integer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-class v0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/content/pm/ProviderInfo;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "remoteMapInfoProvider"    # Landroid/content/pm/ProviderInfo;

    .prologue
    const/4 v1, 0x0

    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-boolean v1, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mForceQueryRemote:Z

    .line 46
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mContext:Landroid/content/Context;

    .line 48
    iget-object v0, p2, Landroid/content/pm/ProviderInfo;->packageName:Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mPackageName:Ljava/lang/String;

    .line 49
    iget-object v0, p2, Landroid/content/pm/ProviderInfo;->authority:Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mProviderAuthority:Ljava/lang/String;

    .line 50
    iput-boolean v1, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mHasFetchedData:Z

    .line 51
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mPackageName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$202(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Ljava/lang/Integer;)Ljava/lang/Integer;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .param p1, "x1"    # Ljava/lang/Integer;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mMajorVersion:Ljava/lang/Integer;

    return-object p1
.end method

.method static synthetic access$302(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Ljava/lang/Integer;)Ljava/lang/Integer;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .param p1, "x1"    # Ljava/lang/Integer;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mMinorVersion:Ljava/lang/Integer;

    return-object p1
.end method

.method static synthetic access$402(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Ljava/lang/Integer;)Ljava/lang/Integer;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .param p1, "x1"    # Ljava/lang/Integer;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mSWVersion:Ljava/lang/Integer;

    return-object p1
.end method

.method static synthetic access$500(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mDeviceType:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$502(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mDeviceType:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$600(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$702(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mOverrideDSN:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$802(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Ljava/lang/Integer;)Ljava/lang/Integer;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .param p1, "x1"    # Ljava/lang/Integer;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mMAPInitVersion:Ljava/lang/Integer;

    return-object p1
.end method

.method private addToSbIfNotNull(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/Object;)V
    .locals 2
    .param p1, "sb"    # Ljava/lang/StringBuilder;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/Object;

    .prologue
    .line 347
    if-nez p3, :cond_0

    .line 353
    :goto_0
    return-void

    .line 352
    :cond_0
    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0
.end method

.method public static compare(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)I
    .locals 1
    .param p0, "info1"    # Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .param p1, "info2"    # Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .prologue
    .line 183
    if-nez p0, :cond_1

    .line 185
    if-eqz p1, :cond_0

    const/4 v0, -0x1

    .line 188
    :goto_0
    return v0

    .line 185
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 188
    :cond_1
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->compareLatest(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)I

    move-result v0

    goto :goto_0
.end method

.method private declared-synchronized fetchVersionInfo()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
        }
    .end annotation

    .prologue
    .line 229
    monitor-enter p0

    const/4 v3, 0x1

    :try_start_0
    iput-boolean v3, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mHasFetchedData:Z

    .line 231
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mProviderAuthority:Ljava/lang/String;

    invoke-static {v3}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getMapVersionInfoUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 232
    .local v1, "mapVersionInfoUri":Landroid/net/Uri;
    new-instance v2, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mContext:Landroid/content/Context;

    invoke-direct {v2, v3}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;-><init>(Landroid/content/Context;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 236
    .local v2, "secureContentResolver":Lcom/amazon/identity/auth/device/framework/SecureContentResolver;
    :try_start_1
    new-instance v3, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;

    invoke-direct {v3, p0, v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo$1;-><init>(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Landroid/net/Uri;)V

    invoke-virtual {v2, v1, v3}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->acquireContentProviderClient(Landroid/net/Uri;Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback;)Ljava/lang/Object;

    .line 311
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mRemoteMapException:Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 320
    monitor-exit p0

    return-void

    .line 314
    :catch_0
    move-exception v0

    .line 316
    .local v0, "e":Ljava/lang/Exception;
    :try_start_2
    sget-object v3, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "Failed to query "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 317
    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "RemoteMapInfoFailure:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 318
    new-instance v3, Lcom/amazon/identity/auth/device/framework/RemoteMAPException;

    invoke-direct {v3, v0}, Lcom/amazon/identity/auth/device/framework/RemoteMAPException;-><init>(Ljava/lang/Throwable;)V

    iput-object v3, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mRemoteMapException:Lcom/amazon/identity/auth/device/framework/RemoteMAPException;

    .line 319
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mRemoteMapException:Lcom/amazon/identity/auth/device/framework/RemoteMAPException;

    throw v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 229
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v1    # "mapVersionInfoUri":Landroid/net/Uri;
    .end local v2    # "secureContentResolver":Lcom/amazon/identity/auth/device/framework/SecureContentResolver;
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method private declared-synchronized populateVersionInfo()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
        }
    .end annotation

    .prologue
    .line 211
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mRemoteMapException:Lcom/amazon/identity/auth/device/framework/RemoteMAPException;

    if-eqz v0, :cond_0

    .line 213
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mRemoteMapException:Lcom/amazon/identity/auth/device/framework/RemoteMAPException;

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 211
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 216
    :cond_0
    :try_start_1
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mHasFetchedData:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-eqz v0, :cond_1

    .line 222
    :goto_0
    monitor-exit p0

    return-void

    .line 221
    :cond_1
    :try_start_2
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->fetchVersionInfo()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method private shouldQueryRemoteContentProvider()Z
    .locals 2

    .prologue
    .line 206
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mContext:Landroid/content/Context;

    sget-object v1, Lcom/amazon/identity/auth/device/features/Feature;->OverrideDeviceAttributes:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/Platform;->hasFeature(Landroid/content/Context;Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mForceQueryRemote:Z

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public compareLatest(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)I
    .locals 4
    .param p1, "otherInfo"    # Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .prologue
    .line 141
    if-nez p1, :cond_1

    .line 143
    const/4 v0, 0x1

    .line 178
    :cond_0
    :goto_0
    return v0

    .line 148
    :cond_1
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->populateVersionInfo()V
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/framework/RemoteMAPException; {:try_start_0 .. :try_end_0} :catch_0

    .line 158
    :goto_1
    :try_start_1
    invoke-direct {p1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->populateVersionInfo()V
    :try_end_1
    .catch Lcom/amazon/identity/auth/device/framework/RemoteMAPException; {:try_start_1 .. :try_end_1} :catch_1

    .line 166
    :goto_2
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mMajorVersion:Ljava/lang/Integer;

    iget-object v3, p1, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mMajorVersion:Ljava/lang/Integer;

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/IntegerHelpers;->compare(Ljava/lang/Integer;Ljava/lang/Integer;)I

    move-result v0

    .line 167
    .local v0, "majorCompare":I
    if-nez v0, :cond_0

    .line 172
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mMinorVersion:Ljava/lang/Integer;

    iget-object v3, p1, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mMinorVersion:Ljava/lang/Integer;

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/IntegerHelpers;->compare(Ljava/lang/Integer;Ljava/lang/Integer;)I

    move-result v1

    .line 173
    .local v1, "minorCompare":I
    if-eqz v1, :cond_2

    move v0, v1

    .line 175
    goto :goto_0

    .line 178
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/StringHelpers;->compareTo(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    .end local v0    # "majorCompare":I
    .end local v1    # "minorCompare":I
    :catch_0
    move-exception v2

    goto :goto_1

    :catch_1
    move-exception v2

    goto :goto_2
.end method

.method public fetchMAPInitVersion()Ljava/lang/Integer;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
        }
    .end annotation

    .prologue
    .line 130
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->fetchVersionInfo()V

    .line 131
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mMAPInitVersion:Ljava/lang/Integer;

    return-object v0
.end method

.method public getDeviceType()Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
        }
    .end annotation

    .prologue
    .line 80
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->shouldQueryRemoteContentProvider()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mContext:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->isOverridingDeviceAttributes(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 83
    monitor-enter p0

    .line 85
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->populateVersionInfo()V

    .line 86
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mDeviceType:Ljava/lang/String;

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 91
    :goto_0
    return-object v0

    .line 87
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 90
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->TAG:Ljava/lang/String;

    .line 91
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mContext:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getDeviceTypeForAPackageFromMetadata(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getMajorVersion()Ljava/lang/Integer;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
        }
    .end annotation

    .prologue
    .line 112
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->populateVersionInfo()V

    .line 113
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mMajorVersion:Ljava/lang/Integer;

    return-object v0
.end method

.method public getMinorVersion()Ljava/lang/Integer;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
        }
    .end annotation

    .prologue
    .line 118
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->populateVersionInfo()V

    .line 119
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mMinorVersion:Ljava/lang/Integer;

    return-object v0
.end method

.method public getOverrideDSN()Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
        }
    .end annotation

    .prologue
    .line 96
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->shouldQueryRemoteContentProvider()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mContext:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->isOverridingDeviceAttributes(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 99
    monitor-enter p0

    .line 101
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->populateVersionInfo()V

    .line 102
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mOverrideDSN:Ljava/lang/String;

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 107
    :goto_0
    return-object v0

    .line 103
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 106
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->TAG:Ljava/lang/String;

    .line 107
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPackageName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mPackageName:Ljava/lang/String;

    return-object v0
.end method

.method public declared-synchronized getPackageVersion()Ljava/lang/Integer;
    .locals 2

    .prologue
    .line 70
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mPackageVersion:Ljava/lang/Integer;

    if-nez v0, :cond_0

    .line 72
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mContext:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/PackageUtils;->getPackageVersion(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mPackageVersion:Ljava/lang/Integer;

    .line 75
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mPackageVersion:Ljava/lang/Integer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 70
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getProviderAuthority()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mProviderAuthority:Ljava/lang/String;

    return-object v0
.end method

.method public getSWVersion()Ljava/lang/Integer;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
        }
    .end annotation

    .prologue
    .line 124
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->populateVersionInfo()V

    .line 125
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mSWVersion:Ljava/lang/Integer;

    return-object v0
.end method

.method public isSelf()Z
    .locals 2

    .prologue
    .line 136
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public setForceQueryRemote(Z)V
    .locals 0
    .param p1, "forceQueryRemote"    # Z

    .prologue
    .line 55
    iput-boolean p1, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mForceQueryRemote:Z

    .line 56
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 326
    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "["

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 328
    .local v1, "sb":Ljava/lang/StringBuilder;
    const-string/jumbo v2, "PackageName"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v1, v2, v3}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->addToSbIfNotNull(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/Object;)V

    .line 331
    :try_start_0
    const-string/jumbo v2, "DeviceType"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v1, v2, v3}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->addToSbIfNotNull(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/Object;)V

    .line 332
    const-string/jumbo v2, "MajorVersion"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getMajorVersion()Ljava/lang/Integer;

    move-result-object v3

    invoke-direct {p0, v1, v2, v3}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->addToSbIfNotNull(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/Object;)V

    .line 333
    const-string/jumbo v2, "MinorVersion"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getMinorVersion()Ljava/lang/Integer;

    move-result-object v3

    invoke-direct {p0, v1, v2, v3}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->addToSbIfNotNull(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/Object;)V

    .line 334
    const-string/jumbo v2, "SWVersion"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getSWVersion()Ljava/lang/Integer;

    move-result-object v3

    invoke-direct {p0, v1, v2, v3}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->addToSbIfNotNull(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/framework/RemoteMAPException; {:try_start_0 .. :try_end_0} :catch_0

    .line 340
    :goto_0
    const-string/jumbo v2, "MAPInitVersion"

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->mMAPInitVersion:Ljava/lang/Integer;

    invoke-direct {p0, v1, v2, v3}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->addToSbIfNotNull(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/Object;)V

    .line 342
    const-string/jumbo v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 336
    :catch_0
    move-exception v0

    .line 338
    .local v0, "e":Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    sget-object v2, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Failed to query "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
