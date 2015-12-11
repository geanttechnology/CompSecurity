.class public Lcom/amazon/device/analytics/events/UniqueIdService;
.super Ljava/lang/Object;
.source "UniqueIdService.java"


# static fields
.field private static chain:Lcom/amazon/device/analytics/events/UniqueIdResolver;

.field private static uniqueId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 13
    sput-object v0, Lcom/amazon/device/analytics/events/UniqueIdService;->chain:Lcom/amazon/device/analytics/events/UniqueIdResolver;

    .line 14
    sput-object v0, Lcom/amazon/device/analytics/events/UniqueIdService;->uniqueId:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static buildResolverChain(Landroid/content/Context;)Lcom/amazon/device/analytics/events/UniqueIdResolver;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 32
    new-instance v3, Lcom/amazon/device/analytics/events/RandomUniqueIdResolver;

    invoke-direct {v3}, Lcom/amazon/device/analytics/events/RandomUniqueIdResolver;-><init>()V

    .line 33
    .local v3, "randomResolver":Lcom/amazon/device/analytics/events/UniqueIdResolver;
    new-instance v1, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;

    invoke-direct {v1, p0, v3}, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;-><init>(Landroid/content/Context;Lcom/amazon/device/analytics/events/UniqueIdResolver;)V

    .line 34
    .local v1, "internalResolver":Lcom/amazon/device/analytics/events/UniqueIdResolver;
    new-instance v0, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;

    invoke-static {}, Lcom/amazon/device/analytics/util/FileManager;->getInstance()Lcom/amazon/device/analytics/util/FileManager;

    move-result-object v4

    invoke-direct {v0, v4, v1}, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;-><init>(Lcom/amazon/device/analytics/util/FileManager;Lcom/amazon/device/analytics/events/UniqueIdResolver;)V

    .line 35
    .local v0, "externalResolver":Lcom/amazon/device/analytics/events/UniqueIdResolver;
    new-instance v2, Lcom/amazon/device/analytics/events/MASUniqueIdResolver;

    invoke-static {}, Lcom/amazon/device/analytics/util/FileManager;->getInstance()Lcom/amazon/device/analytics/util/FileManager;

    move-result-object v4

    invoke-direct {v2, v4, p0, v0}, Lcom/amazon/device/analytics/events/MASUniqueIdResolver;-><init>(Lcom/amazon/device/analytics/util/FileManager;Landroid/content/Context;Lcom/amazon/device/analytics/events/UniqueIdResolver;)V

    .line 37
    .local v2, "masResolver":Lcom/amazon/device/analytics/events/UniqueIdResolver;
    return-object v2
.end method

.method public static getUniqueId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    sget-object v0, Lcom/amazon/device/analytics/events/UniqueIdService;->uniqueId:Ljava/lang/String;

    return-object v0
.end method

.method public static declared-synchronized initialize(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 17
    const-class v1, Lcom/amazon/device/analytics/events/UniqueIdService;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/device/analytics/events/UniqueIdService;->chain:Lcom/amazon/device/analytics/events/UniqueIdResolver;

    if-nez v0, :cond_0

    .line 18
    invoke-static {p0}, Lcom/amazon/device/analytics/events/UniqueIdService;->buildResolverChain(Landroid/content/Context;)Lcom/amazon/device/analytics/events/UniqueIdResolver;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/events/UniqueIdService;->chain:Lcom/amazon/device/analytics/events/UniqueIdResolver;

    .line 19
    sget-object v0, Lcom/amazon/device/analytics/events/UniqueIdService;->chain:Lcom/amazon/device/analytics/events/UniqueIdResolver;

    invoke-interface {v0}, Lcom/amazon/device/analytics/events/UniqueIdResolver;->resolveUniqueId()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/events/UniqueIdService;->uniqueId:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 21
    :cond_0
    monitor-exit v1

    return-void

    .line 17
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
