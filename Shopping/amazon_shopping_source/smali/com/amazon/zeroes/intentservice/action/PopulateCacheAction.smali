.class public Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;
.super Ljava/lang/Object;
.source "PopulateCacheAction.java"

# interfaces
.implements Lcom/amazon/zeroes/intentservice/action/ZeroesAction;


# static fields
.field public static final ACTION_REQUEST:Ljava/lang/String;

.field public static final EXTRA_ITEMS:Ljava/lang/String;


# instance fields
.field private final cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

.field private final items:Lorg/json/JSONObject;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 19
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".PopulateCache"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->ACTION_REQUEST:Ljava/lang/String;

    .line 22
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".items"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->EXTRA_ITEMS:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Intent;Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "cache"    # Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object p2, p0, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    .line 51
    sget-object v1, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->EXTRA_ITEMS:Ljava/lang/String;

    invoke-virtual {p1, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 52
    .local v0, "itemString":Ljava/lang/String;
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->items:Lorg/json/JSONObject;

    .line 53
    return-void
.end method


# virtual methods
.method public act(Lcom/amazon/zeroes/intentservice/ZeroesService;)V
    .locals 10
    .param p1, "service"    # Lcom/amazon/zeroes/intentservice/ZeroesService;

    .prologue
    .line 60
    iget-object v5, p0, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    if-nez v5, :cond_0

    .line 61
    new-instance v5, Ljava/lang/NullPointerException;

    const-string/jumbo v6, "The cache can\'t be null"

    invoke-direct {v5, v6}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 64
    :cond_0
    iget-object v5, p0, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->items:Lorg/json/JSONObject;

    const-string/jumbo v6, "balance"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 66
    :try_start_0
    iget-object v5, p0, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->items:Lorg/json/JSONObject;

    const-string/jumbo v6, "balance"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    .line 67
    .local v0, "balance":J
    iget-object v5, p0, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    const-string/jumbo v6, "balance"

    invoke-static {v0, v1}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v7

    const-wide/32 v8, 0x1b7740

    invoke-interface {v5, v6, v7, v8, v9}, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;->put(Ljava/lang/String;Ljava/lang/String;J)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 76
    .end local v0    # "balance":J
    :cond_1
    :goto_0
    iget-object v5, p0, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->items:Lorg/json/JSONObject;

    const-string/jumbo v6, "bundles"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 78
    :try_start_1
    iget-object v5, p0, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->items:Lorg/json/JSONObject;

    const-string/jumbo v6, "bundles"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 79
    .local v2, "bundles":Lorg/json/JSONArray;
    iget-object v5, p0, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    const-string/jumbo v6, "bundles"

    invoke-virtual {v2}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v7

    const-wide/32 v8, 0x5265c00

    invoke-interface {v5, v6, v7, v8, v9}, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;->put(Ljava/lang/String;Ljava/lang/String;J)Z
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 88
    .end local v2    # "bundles":Lorg/json/JSONArray;
    :cond_2
    :goto_1
    iget-object v5, p0, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->items:Lorg/json/JSONObject;

    const-string/jumbo v6, "preferences"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 90
    :try_start_2
    iget-object v5, p0, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->items:Lorg/json/JSONObject;

    const-string/jumbo v6, "preferences"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 91
    .local v4, "preferences":Lorg/json/JSONObject;
    iget-object v5, p0, Lcom/amazon/zeroes/intentservice/action/PopulateCacheAction;->cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    const-string/jumbo v6, "preferences"

    invoke-virtual {v4}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v7

    const-wide/32 v8, 0x5265c00

    invoke-interface {v5, v6, v7, v8, v9}, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;->put(Ljava/lang/String;Ljava/lang/String;J)Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    .line 99
    .end local v4    # "preferences":Lorg/json/JSONObject;
    :cond_3
    :goto_2
    return-void

    .line 71
    :catch_0
    move-exception v3

    .line 72
    .local v3, "e":Lorg/json/JSONException;
    invoke-static {v3}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->fromThrowable(Ljava/lang/Throwable;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    goto :goto_0

    .line 83
    .end local v3    # "e":Lorg/json/JSONException;
    :catch_1
    move-exception v3

    .line 84
    .restart local v3    # "e":Lorg/json/JSONException;
    invoke-static {v3}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->fromThrowable(Ljava/lang/Throwable;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    goto :goto_1

    .line 95
    .end local v3    # "e":Lorg/json/JSONException;
    :catch_2
    move-exception v3

    .line 96
    .restart local v3    # "e":Lorg/json/JSONException;
    invoke-static {v3}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->fromThrowable(Ljava/lang/Throwable;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    goto :goto_2
.end method
