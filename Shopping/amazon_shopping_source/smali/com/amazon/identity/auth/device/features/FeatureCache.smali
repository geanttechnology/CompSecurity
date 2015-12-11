.class public final Lcom/amazon/identity/auth/device/features/FeatureCache;
.super Ljava/lang/Object;
.source "FeatureCache.java"


# static fields
.field private static final INSTANCE:Lcom/amazon/identity/auth/device/features/FeatureCache;

.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final mCache:Ljava/util/EnumMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/EnumMap",
            "<",
            "Lcom/amazon/identity/auth/device/features/Feature;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/amazon/identity/auth/device/features/FeatureCache;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/features/FeatureCache;->LOG_TAG:Ljava/lang/String;

    .line 17
    new-instance v0, Lcom/amazon/identity/auth/device/features/FeatureCache;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/features/FeatureCache;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/features/FeatureCache;->INSTANCE:Lcom/amazon/identity/auth/device/features/FeatureCache;

    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    new-instance v0, Ljava/util/EnumMap;

    const-class v1, Lcom/amazon/identity/auth/device/features/Feature;

    invoke-direct {v0, v1}, Ljava/util/EnumMap;-><init>(Ljava/lang/Class;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/features/FeatureCache;->mCache:Ljava/util/EnumMap;

    .line 22
    return-void
.end method

.method private declared-synchronized fetchAndSetFeature(Landroid/content/Context;Lcom/amazon/identity/auth/device/features/Feature;)Z
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "feature"    # Lcom/amazon/identity/auth/device/features/Feature;

    .prologue
    .line 50
    monitor-enter p0

    :try_start_0
    invoke-virtual {p2, p1}, Lcom/amazon/identity/auth/device/features/Feature;->fetchValue(Landroid/content/Context;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 51
    .local v0, "value":Ljava/lang/Boolean;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/features/FeatureCache;->mCache:Ljava/util/EnumMap;

    invoke-virtual {v1, p2, v0}, Ljava/util/EnumMap;->put(Ljava/lang/Enum;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    sget-object v1, Lcom/amazon/identity/auth/device/features/FeatureCache;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "Setting feature %s to %s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/features/Feature;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object v0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 54
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    monitor-exit p0

    return v1

    .line 50
    .end local v0    # "value":Ljava/lang/Boolean;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public static getInstance()Lcom/amazon/identity/auth/device/features/FeatureCache;
    .locals 1

    .prologue
    .line 26
    sget-object v0, Lcom/amazon/identity/auth/device/features/FeatureCache;->INSTANCE:Lcom/amazon/identity/auth/device/features/FeatureCache;

    return-object v0
.end method


# virtual methods
.method public declared-synchronized get(Landroid/content/Context;Lcom/amazon/identity/auth/device/features/Feature;)Z
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "feature"    # Lcom/amazon/identity/auth/device/features/Feature;

    .prologue
    .line 35
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/features/FeatureCache;->mCache:Ljava/util/EnumMap;

    invoke-virtual {v1, p2}, Ljava/util/EnumMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 37
    .local v0, "value":Ljava/lang/Boolean;
    if-eqz v0, :cond_0

    .line 39
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    .line 42
    :goto_0
    monitor-exit p0

    return v1

    :cond_0
    :try_start_1
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/features/FeatureCache;->fetchAndSetFeature(Landroid/content/Context;Lcom/amazon/identity/auth/device/features/Feature;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v1

    goto :goto_0

    .line 35
    .end local v0    # "value":Ljava/lang/Boolean;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method
