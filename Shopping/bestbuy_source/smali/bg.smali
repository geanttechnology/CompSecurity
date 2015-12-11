.class final Lbg;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lap;


# static fields
.field private static final a:Ljava/util/regex/Pattern;


# instance fields
.field private final b:I

.field private final c:I

.field private final d:I

.field private final e:Ljava/util/Map;

.field private final f:Ljava/util/Map;

.field private g:Lag;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-string v0, "([a-zA-Z0-9]+\\s*)+"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lbg;->a:Ljava/util/regex/Pattern;

    return-void
.end method

.method constructor <init>()V
    .locals 3

    .prologue
    .line 47
    const/16 v0, 0x10

    const/16 v1, 0x64

    const/16 v2, 0x32

    invoke-direct {p0, v0, v1, v2}, Lbg;-><init>(III)V

    .line 48
    return-void
.end method

.method private constructor <init>(III)V
    .locals 2

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    iput-object v0, p0, Lbg;->e:Ljava/util/Map;

    .line 34
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lbg;->f:Ljava/util/Map;

    .line 35
    const/4 v0, 0x0

    iput-object v0, p0, Lbg;->g:Lag;

    .line 38
    const/16 v0, 0x10

    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v0

    const/4 v1, 0x2

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 41
    shr-int/lit8 v0, v0, 0x1

    shl-int/lit8 v0, v0, 0x1

    iput v0, p0, Lbg;->b:I

    .line 42
    const/4 v0, 0x1

    const/16 v1, 0x64

    invoke-static {v1}, Ljava/lang/Math;->abs(I)I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    iput v0, p0, Lbg;->c:I

    .line 43
    const/16 v0, 0x32

    iput v0, p0, Lbg;->d:I

    .line 44
    return-void
.end method


# virtual methods
.method final a(Lag;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lbg;->g:Lag;

    .line 52
    return-void
.end method

.method public final a(Lao;)V
    .locals 4

    .prologue
    .line 56
    iget-object v0, p0, Lbg;->g:Lag;

    if-nez v0, :cond_1

    .line 57
    const-string v0, "Could not generate beacons because beaconBuilder is not set"

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 90
    :cond_0
    :goto_0
    return-void

    .line 62
    :cond_1
    :try_start_0
    iget-object v1, p0, Lbg;->e:Ljava/util/Map;

    monitor-enter v1
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 64
    :try_start_1
    iget-object v0, p0, Lbg;->e:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    if-nez v0, :cond_2

    .line 65
    monitor-exit v1

    goto :goto_0

    .line 71
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v0
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    .line 87
    :catch_0
    move-exception v0

    .line 88
    const-string v1, "Error draining captured metric data to beacon queue"

    invoke-static {v1, v0}, Lbc;->b(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 68
    :cond_2
    :try_start_3
    const-string v0, "Draining collected beacons into beacon queue."

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 69
    new-instance v2, Ljava/util/ArrayList;

    iget-object v0, p0, Lbg;->e:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 70
    iget-object v0, p0, Lbg;->e:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 71
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 73
    :try_start_4
    const-string v0, "Adding #%d metrics to the beacon queue."

    invoke-interface {v2}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-static {v0, v1}, Lbc;->a(Ljava/lang/String;I)V

    .line 74
    const/4 v0, 0x0

    .line 75
    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move v1, v0

    :cond_3
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lbh;

    .line 76
    invoke-virtual {v0}, Lbh;->a()Lorg/json/JSONObject;

    move-result-object v0

    .line 78
    if-eqz v0, :cond_3

    .line 80
    invoke-virtual {p1, v0}, Lao;->a(Lorg/json/JSONObject;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 81
    const-string v0, "Beacon queue is full, dropping #%d metricKey observations."

    invoke-interface {v2}, Ljava/util/Collection;->size()I

    move-result v2

    sub-int v1, v2, v1

    invoke-static {v0, v1}, Lbc;->a(Ljava/lang/String;I)V
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_0

    goto :goto_0

    .line 85
    :cond_4
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    .line 86
    goto :goto_1
.end method

.method public final a()Z
    .locals 2

    .prologue
    .line 213
    iget-object v1, p0, Lbg;->e:Ljava/util/Map;

    monitor-enter v1

    .line 214
    :try_start_0
    iget-object v0, p0, Lbg;->e:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 215
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
