.class public Lcom/amazon/mShop/customclientfields/RefmarkerClientField;
.super Ljava/lang/Object;
.source "RefmarkerClientField.java"


# static fields
.field private static final SERVICECALL_TO_REFMARKER:Ljava/util/Map;
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
    .line 32
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/customclientfields/RefmarkerClientField;->SERVICECALL_TO_REFMARKER:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final declared-synchronized getHttpHeaderForRefmarker(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "method"    # Ljava/lang/String;

    .prologue
    .line 55
    const-class v2, Lcom/amazon/mShop/customclientfields/RefmarkerClientField;

    monitor-enter v2

    :try_start_0
    sget-object v1, Lcom/amazon/mShop/customclientfields/RefmarkerClientField;->SERVICECALL_TO_REFMARKER:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 56
    .local v0, "refmarker":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-eqz v1, :cond_0

    .line 57
    const/4 v0, 0x0

    .line 61
    .end local v0    # "refmarker":Ljava/lang/String;
    :goto_0
    monitor-exit v2

    return-object v0

    .line 60
    .restart local v0    # "refmarker":Ljava/lang/String;
    :cond_0
    :try_start_1
    sget-object v1, Lcom/amazon/mShop/customclientfields/RefmarkerClientField;->SERVICECALL_TO_REFMARKER:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 55
    .end local v0    # "refmarker":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public static declared-synchronized logServiceMethodNameAndRefmarker(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p0, "method"    # Ljava/lang/String;
    .param p1, "refmarker"    # Ljava/lang/String;

    .prologue
    .line 41
    const-class v1, Lcom/amazon/mShop/customclientfields/RefmarkerClientField;

    monitor-enter v1

    :try_start_0
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 42
    sget-object v0, Lcom/amazon/mShop/customclientfields/RefmarkerClientField;->SERVICECALL_TO_REFMARKER:Ljava/util/Map;

    invoke-interface {v0, p0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 43
    const/4 v0, 0x1

    .line 45
    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 41
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
