.class public final Lcom/amazon/identity/auth/device/features/FeatureSetCache;
.super Lcom/amazon/identity/auth/device/features/FeatureSet;
.source "FeatureSetCache.java"


# static fields
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

.field private final mDelegateFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/amazon/identity/auth/device/features/FeatureCache;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/features/FeatureSetCache;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/features/FeatureSet;)V
    .locals 2
    .param p1, "delegateFeatureSet"    # Lcom/amazon/identity/auth/device/features/FeatureSet;

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/features/FeatureSet;-><init>()V

    .line 14
    new-instance v0, Ljava/util/EnumMap;

    const-class v1, Lcom/amazon/identity/auth/device/features/Feature;

    invoke-direct {v0, v1}, Ljava/util/EnumMap;-><init>(Ljava/lang/Class;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/features/FeatureSetCache;->mCache:Ljava/util/EnumMap;

    .line 18
    if-nez p1, :cond_0

    .line 20
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "delegateFeatureSet is null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 23
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/auth/device/features/FeatureSetCache;->mDelegateFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    .line 24
    return-void
.end method


# virtual methods
.method public declared-synchronized hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z
    .locals 7
    .param p1, "feature"    # Lcom/amazon/identity/auth/device/features/Feature;

    .prologue
    .line 29
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/features/FeatureSetCache;->mCache:Ljava/util/EnumMap;

    invoke-virtual {v2, p1}, Ljava/util/EnumMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 30
    .local v0, "cachedValue":Ljava/lang/Boolean;
    if-eqz v0, :cond_0

    .line 32
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    .line 39
    :goto_0
    monitor-exit p0

    return v1

    .line 35
    :cond_0
    :try_start_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/features/FeatureSetCache;->mDelegateFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    invoke-virtual {v2, p1}, Lcom/amazon/identity/auth/device/features/FeatureSet;->hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v1

    .line 36
    .local v1, "delegateValue":Z
    iget-object v2, p0, Lcom/amazon/identity/auth/device/features/FeatureSetCache;->mCache:Ljava/util/EnumMap;

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v2, p1, v3}, Ljava/util/EnumMap;->put(Ljava/lang/Enum;Ljava/lang/Object;)Ljava/lang/Object;

    .line 37
    sget-object v2, Lcom/amazon/identity/auth/device/features/FeatureSetCache;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v3, "Caching feature %s as %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/features/Feature;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 29
    .end local v0    # "cachedValue":Ljava/lang/Boolean;
    .end local v1    # "delegateValue":Z
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method
