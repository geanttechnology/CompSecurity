.class public Lcom/amazon/mShop/wearable/WearableCrashDetails;
.super Ljava/lang/Object;
.source "WearableCrashDetails.java"

# interfaces
.implements Lcom/amazon/device/crashmanager/CrashDetailsCollectable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/wearable/WearableCrashDetails$SingletonHolder;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mCrashDetails:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/amazon/mShop/wearable/WearableCrashDetails;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/wearable/WearableCrashDetails;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/wearable/WearableCrashDetails;->mCrashDetails:Ljava/util/Map;

    .line 18
    return-void
.end method

.method private declared-synchronized getCrashDetails()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 55
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableCrashDetails;->mCrashDetails:Ljava/util/Map;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public static getInstance()Lcom/amazon/mShop/wearable/WearableCrashDetails;
    .locals 1

    .prologue
    .line 23
    # getter for: Lcom/amazon/mShop/wearable/WearableCrashDetails$SingletonHolder;->INSTANCE:Lcom/amazon/mShop/wearable/WearableCrashDetails;
    invoke-static {}, Lcom/amazon/mShop/wearable/WearableCrashDetails$SingletonHolder;->access$000()Lcom/amazon/mShop/wearable/WearableCrashDetails;

    move-result-object v0

    return-object v0
.end method

.method private declared-synchronized setCrashDetails(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 49
    .local p1, "details":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    monitor-enter p0

    if-eqz p1, :cond_0

    .line 50
    :try_start_0
    iput-object p1, p0, Lcom/amazon/mShop/wearable/WearableCrashDetails;->mCrashDetails:Ljava/util/Map;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 52
    :cond_0
    monitor-exit p0

    return-void

    .line 49
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public collect(Ljava/lang/Throwable;)Ljava/util/Map;
    .locals 4
    .param p1, "ex"    # Ljava/lang/Throwable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 61
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/mShop/wearable/WearableCrashDetails;->getCrashDetails()Ljava/util/Map;

    move-result-object v0

    .line 62
    .local v0, "crashDetails":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    invoke-direct {p0, v2}, Lcom/amazon/mShop/wearable/WearableCrashDetails;->setCrashDetails(Ljava/util/Map;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 67
    .end local v0    # "crashDetails":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_0
    return-object v0

    .line 65
    :catch_0
    move-exception v1

    .line 66
    .local v1, "e":Ljava/lang/Throwable;
    sget-object v2, Lcom/amazon/mShop/wearable/WearableCrashDetails;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Error"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 67
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    goto :goto_0
.end method

.method public setCrashDetails(Lcom/google/android/gms/wearable/DataMap;)V
    .locals 8
    .param p1, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;

    .prologue
    .line 28
    :try_start_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 29
    .local v0, "crashDetails":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p1, :cond_1

    .line 31
    invoke-virtual {p1}, Lcom/google/android/gms/wearable/DataMap;->keySet()Ljava/util/Set;

    move-result-object v4

    .line 32
    .local v4, "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 33
    .local v3, "key":Ljava/lang/String;
    invoke-virtual {p1, v3}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 34
    .local v5, "value":Ljava/lang/String;
    if-nez v5, :cond_0

    .line 35
    const-string/jumbo v5, ""

    .line 37
    :cond_0
    invoke-interface {v0, v3, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 43
    .end local v0    # "crashDetails":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "key":Ljava/lang/String;
    .end local v4    # "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v5    # "value":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 44
    .local v1, "e":Ljava/lang/Throwable;
    sget-object v6, Lcom/amazon/mShop/wearable/WearableCrashDetails;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Error"

    invoke-static {v6, v7, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 46
    .end local v1    # "e":Ljava/lang/Throwable;
    :goto_1
    return-void

    .line 41
    .restart local v0    # "crashDetails":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    :try_start_1
    invoke-direct {p0, v0}, Lcom/amazon/mShop/wearable/WearableCrashDetails;->setCrashDetails(Ljava/util/Map;)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method
