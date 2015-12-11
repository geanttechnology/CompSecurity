.class public Lcom/poshmark/utils/ObjectPickupDropOff;
.super Ljava/lang/Object;
.source "ObjectPickupDropOff.java"


# static fields
.field private static dataBin:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/util/UUID;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/poshmark/utils/ObjectPickupDropOff;->dataBin:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static declared-synchronized dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V
    .locals 2
    .param p0, "uuid"    # Ljava/util/UUID;
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 14
    const-class v1, Lcom/poshmark/utils/ObjectPickupDropOff;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/poshmark/utils/ObjectPickupDropOff;->dataBin:Ljava/util/Map;

    invoke-interface {v0, p0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 15
    monitor-exit v1

    return-void

    .line 14
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized getUniqueKey()Ljava/util/UUID;
    .locals 2

    .prologue
    .line 30
    const-class v0, Lcom/poshmark/utils/ObjectPickupDropOff;

    monitor-enter v0

    :try_start_0
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized pickupDataObject(Ljava/util/UUID;)Ljava/lang/Object;
    .locals 3
    .param p0, "uuid"    # Ljava/util/UUID;

    .prologue
    .line 18
    const-class v2, Lcom/poshmark/utils/ObjectPickupDropOff;

    monitor-enter v2

    :try_start_0
    sget-object v1, Lcom/poshmark/utils/ObjectPickupDropOff;->dataBin:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 19
    sget-object v1, Lcom/poshmark/utils/ObjectPickupDropOff;->dataBin:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 20
    .local v0, "data":Ljava/lang/Object;
    sget-object v1, Lcom/poshmark/utils/ObjectPickupDropOff;->dataBin:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 21
    if-eqz v0, :cond_0

    .line 26
    .end local v0    # "data":Ljava/lang/Object;
    :goto_0
    monitor-exit v2

    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 18
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method
