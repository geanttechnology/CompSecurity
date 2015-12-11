.class public Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;
.super Ljava/lang/Object;
.source "MAPApplicationInformationQueryer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer$MAPApplicationCacheInvalidator;
    }
.end annotation


# static fields
.field private static final NEWEST_REMOTE_MAP_INFO_COMPARATOR:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;",
            ">;"
        }
    .end annotation
.end field

.field private static final TAG:Ljava/lang/String;

.field private static sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;


# instance fields
.field private mCacheContainsPartialResults:Z

.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private mPackageNameToAppInfo:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;",
            ">;"
        }
    .end annotation
.end field

.field private final mTrustedPackageManager:Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 34
    const-class v0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->TAG:Ljava/lang/String;

    .line 92
    new-instance v0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer$1;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer$1;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->NEWEST_REMOTE_MAP_INFO_COMPARATOR:Ljava/util/Comparator;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 124
    new-instance v0, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-direct {v0, p1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;-><init>(Landroid/content/Context;)V

    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;)V

    .line 125
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "trustedPackageManager"    # Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    .prologue
    .line 129
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 130
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 131
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mTrustedPackageManager:Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    .line 132
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mPackageNameToAppInfo:Ljava/util/Map;

    .line 133
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mCacheContainsPartialResults:Z

    .line 134
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    sget-object v0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private declared-synchronized getAppInfos()Ljava/util/Map;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 251
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mPackageNameToAppInfo:Ljava/util/Map;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mCacheContainsPartialResults:Z

    if-eqz v0, :cond_2

    .line 253
    :cond_0
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer$MAPApplicationCacheInvalidator;->isRegistered()Z

    move-result v0

    if-nez v0, :cond_1

    .line 258
    sget-object v0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->TAG:Ljava/lang/String;

    .line 259
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer$MAPApplicationCacheInvalidator;->registerReceiver(Landroid/content/Context;)V

    .line 261
    :cond_1
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getMAPContentProviders()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_3

    const/4 v0, 0x0

    :goto_0
    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mPackageNameToAppInfo:Ljava/util/Map;

    .line 262
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mCacheContainsPartialResults:Z

    .line 265
    :cond_2
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mPackageNameToAppInfo:Ljava/util/Map;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 261
    :cond_3
    :try_start_1
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ProviderInfo;

    iget-object v3, v0, Landroid/content/pm/ProviderInfo;->packageName:Ljava/lang/String;

    new-instance v4, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v4, v5, v0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;-><init>(Landroid/content/Context;Landroid/content/pm/ProviderInfo;)V

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 251
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_4
    move-object v0, v1

    .line 261
    goto :goto_0
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 138
    const-class v1, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 140
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    .line 143
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;
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

.method private getMAPContentProviders()Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/ProviderInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 288
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 291
    .local v2, "mapContentProviderInfos":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ProviderInfo;>;"
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mTrustedPackageManager:Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->queryTrustedContentProviders()Ljava/util/List;

    move-result-object v4

    .line 293
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/pm/ProviderInfo;

    .line 295
    .local v3, "providerInfo":Landroid/content/pm/ProviderInfo;
    iget-object v0, v3, Landroid/content/pm/ProviderInfo;->authority:Ljava/lang/String;

    .line 296
    .local v0, "authority":Ljava/lang/String;
    if-eqz v0, :cond_0

    const-string/jumbo v4, "com.amazon.identity.auth.device.MapInfoProvider."

    invoke-virtual {v0, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 298
    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 304
    .end local v0    # "authority":Ljava/lang/String;
    .end local v3    # "providerInfo":Landroid/content/pm/ProviderInfo;
    :cond_1
    return-object v2
.end method

.method private declared-synchronized populateCacheForSinglePackage(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .locals 12
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x0

    .line 161
    monitor-enter p0

    :try_start_0
    iget-object v9, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mTrustedPackageManager:Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    const/16 v10, 0x8

    invoke-virtual {v9, p1, v10}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->getPackageInfoForTrustedPackage(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 163
    .local v5, "packageInfo":Landroid/content/pm/PackageInfo;
    iget-object v9, v5, Landroid/content/pm/PackageInfo;->providers:[Landroid/content/pm/ProviderInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v9, :cond_0

    move-object v7, v8

    .line 189
    .end local v5    # "packageInfo":Landroid/content/pm/PackageInfo;
    :goto_0
    monitor-exit p0

    return-object v7

    .line 167
    .restart local v5    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_0
    :try_start_1
    iget-object v0, v5, Landroid/content/pm/PackageInfo;->providers:[Landroid/content/pm/ProviderInfo;

    .local v0, "arr$":[Landroid/content/pm/ProviderInfo;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_1
    if-ge v3, v4, :cond_1

    aget-object v6, v0, v3

    .line 169
    .local v6, "providerInfo":Landroid/content/pm/ProviderInfo;
    iget-object v1, v6, Landroid/content/pm/ProviderInfo;->authority:Ljava/lang/String;

    .line 170
    .local v1, "authority":Ljava/lang/String;
    if-eqz v1, :cond_2

    const-string/jumbo v9, "com.amazon.identity.auth.device.MapInfoProvider."

    invoke-virtual {v1, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 172
    new-instance v7, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    iget-object v9, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v7, v9, v6}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;-><init>(Landroid/content/Context;Landroid/content/pm/ProviderInfo;)V

    .line 173
    .local v7, "remoteMapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    iget-object v9, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mPackageNameToAppInfo:Ljava/util/Map;

    invoke-interface {v9, p1, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 178
    .end local v0    # "arr$":[Landroid/content/pm/ProviderInfo;
    .end local v1    # "authority":Ljava/lang/String;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    .end local v5    # "packageInfo":Landroid/content/pm/PackageInfo;
    .end local v6    # "providerInfo":Landroid/content/pm/ProviderInfo;
    .end local v7    # "remoteMapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    :catch_0
    move-exception v2

    .line 180
    .local v2, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :try_start_2
    sget-object v9, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->TAG:Ljava/lang/String;

    const-string/jumbo v10, "Tried to get MAP info for non-existant package"

    invoke-static {v9, v10, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 181
    const-string/jumbo v9, "MAPPackageNameNotFound"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/String;

    const/4 v11, 0x0

    aput-object p1, v10, v11

    invoke-static {v9, v10}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .end local v2    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    :goto_2
    move-object v7, v8

    .line 189
    goto :goto_0

    .line 167
    .restart local v0    # "arr$":[Landroid/content/pm/ProviderInfo;
    .restart local v1    # "authority":Ljava/lang/String;
    .restart local v3    # "i$":I
    .restart local v4    # "len$":I
    .restart local v5    # "packageInfo":Landroid/content/pm/PackageInfo;
    .restart local v6    # "providerInfo":Landroid/content/pm/ProviderInfo;
    :cond_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 183
    .end local v0    # "arr$":[Landroid/content/pm/ProviderInfo;
    .end local v1    # "authority":Ljava/lang/String;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    .end local v5    # "packageInfo":Landroid/content/pm/PackageInfo;
    .end local v6    # "providerInfo":Landroid/content/pm/ProviderInfo;
    :catch_1
    move-exception v2

    .line 185
    .local v2, "e":Ljava/lang/SecurityException;
    sget-object v9, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->TAG:Ljava/lang/String;

    const-string/jumbo v10, "Tried to get MAP info for untrusted package"

    invoke-static {v9, v10, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 186
    const-string/jumbo v9, "MAPPackageIncorrectlySigned"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/String;

    const/4 v11, 0x0

    aput-object p1, v10, v11

    invoke-static {v9, v10}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    .line 161
    .end local v2    # "e":Ljava/lang/SecurityException;
    :catchall_0
    move-exception v8

    monitor-exit p0

    throw v8
.end method


# virtual methods
.method public declared-synchronized getAllMapApplication()Ljava/util/Collection;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 218
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getAppInfos()Ljava/util/Map;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 219
    .local v0, "appInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    if-nez v0, :cond_0

    .line 221
    const/4 v1, 0x0

    .line 224
    :goto_0
    monitor-exit p0

    return-object v1

    :cond_0
    :try_start_1
    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-static {v1}, Ljava/util/Collections;->unmodifiableCollection(Ljava/util/Collection;)Ljava/util/Collection;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v1

    goto :goto_0

    .line 218
    .end local v0    # "appInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getAppInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .locals 2
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 148
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mPackageNameToAppInfo:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .line 149
    .local v0, "result":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    if-nez v0, :cond_0

    iget-boolean v1, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mCacheContainsPartialResults:Z

    if-eqz v1, :cond_0

    .line 151
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->populateCacheForSinglePackage(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 154
    :cond_0
    monitor-exit p0

    return-object v0

    .line 148
    .end local v0    # "result":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getLatestMapApp()Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .locals 8

    .prologue
    .line 194
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getAppInfos()Ljava/util/Map;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 195
    .local v0, "appInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    if-nez v0, :cond_1

    .line 197
    const/4 v1, 0x0

    .line 213
    :cond_0
    monitor-exit p0

    return-object v1

    .line 200
    :cond_1
    const/4 v1, 0x0

    .line 201
    .local v1, "currentBestRemoteMapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    :try_start_1
    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .line 203
    .local v2, "currentRemoteMapVersion":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    invoke-virtual {v2, v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->compareLatest(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)I

    move-result v4

    if-lez v4, :cond_2

    .line 205
    sget-object v4, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "%s is newer than %s"

    const/4 v4, 0x2

    new-array v6, v4, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v4

    const/4 v7, 0x1

    if-eqz v1, :cond_3

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v4

    :goto_1
    aput-object v4, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 209
    move-object v1, v2

    goto :goto_0

    .line 205
    :cond_3
    const-string/jumbo v4, "<None>"
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 194
    .end local v0    # "appInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    .end local v1    # "currentBestRemoteMapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .end local v2    # "currentRemoteMapVersion":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .end local v3    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4
.end method

.method public declared-synchronized getSortedByLatestMapApplications()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 229
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getAppInfos()Ljava/util/Map;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 230
    .local v0, "appInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    if-nez v0, :cond_0

    .line 232
    const/4 v1, 0x0

    .line 240
    :goto_0
    monitor-exit p0

    return-object v1

    .line 235
    :cond_0
    :try_start_1
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 236
    .local v1, "sortedMapInfos":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 238
    sget-object v2, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->NEWEST_REMOTE_MAP_INFO_COMPARATOR:Ljava/util/Comparator;

    invoke-static {v1, v2}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 229
    .end local v0    # "appInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    .end local v1    # "sortedMapInfos":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized invalidateCache()V
    .locals 1

    .prologue
    .line 245
    monitor-enter p0

    :try_start_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mPackageNameToAppInfo:Ljava/util/Map;

    .line 246
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->mCacheContainsPartialResults:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 247
    monitor-exit p0

    return-void

    .line 245
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
