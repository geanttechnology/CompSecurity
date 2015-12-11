.class public final enum Lcom/wishabi/flipp/b/a;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wishabi/flipp/b/a;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic D:[Lcom/wishabi/flipp/b/a;

.field public static final enum a:Lcom/wishabi/flipp/b/a;


# instance fields
.field private A:Landroid/graphics/RectF;

.field private B:Lcom/wishabi/flipp/content/Flyer$Model;

.field private C:F

.field public b:Landroid/content/Context;

.field public c:Landroid/location/Location;

.field public d:Z

.field public e:Lcom/google/analytics/tracking/android/ay;

.field public f:Lcom/facebook/AppEventsLogger;

.field public g:Ljava/util/Timer;

.field public h:Ljava/lang/String;

.field public i:Z

.field public j:Ljava/lang/String;

.field public k:Ljava/lang/String;

.field public final l:Landroid/graphics/Point;

.field public m:Landroid/content/ContentResolver;

.field public n:Ljava/lang/String;

.field public o:Ljava/lang/String;

.field public p:Ljava/lang/String;

.field public q:Ljava/lang/String;

.field public r:Z

.field public s:J

.field private t:Lcom/google/android/gms/location/e;

.field private u:Lcom/wishabi/flipp/b/ab;

.field private v:Ljava/lang/String;

.field private w:Ljava/util/UUID;

.field private x:Ljava/util/Timer;

.field private y:Ljava/util/Timer;

.field private z:J


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 70
    new-instance v0, Lcom/wishabi/flipp/b/a;

    const-string v1, "INSTANCE"

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/b/a;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    .line 69
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/wishabi/flipp/b/a;

    const/4 v1, 0x0

    sget-object v2, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    aput-object v2, v0, v1

    sput-object v0, Lcom/wishabi/flipp/b/a;->D:[Lcom/wishabi/flipp/b/a;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 262
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 243
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/b/a;->l:Landroid/graphics/Point;

    .line 263
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    new-instance v1, Lcom/wishabi/flipp/b/b;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/b/b;-><init>(Lcom/wishabi/flipp/b/a;)V

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0xfa

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->scheduleAtFixedRate(Ljava/util/TimerTask;JJ)V

    .line 272
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/b/a;)J
    .locals 2

    .prologue
    .line 69
    iget-wide v0, p0, Lcom/wishabi/flipp/b/a;->z:J

    return-wide v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/b/a;Landroid/location/Location;)Landroid/location/Location;
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/wishabi/flipp/b/a;->c:Landroid/location/Location;

    return-object p1
.end method

.method static synthetic a(Lcom/wishabi/flipp/b/a;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/wishabi/flipp/b/a;->k:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic a(Lcom/wishabi/flipp/b/a;Ljava/util/UUID;)Ljava/util/UUID;
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/wishabi/flipp/b/a;->w:Ljava/util/UUID;

    return-object p1
.end method

.method static synthetic a(Lcom/wishabi/flipp/b/a;Ljava/lang/String;Ljava/util/Map;)V
    .locals 1

    .prologue
    .line 69
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    return-void
.end method

.method private a(Ljava/lang/String;Landroid/os/Bundle;D)V
    .locals 1

    .prologue
    .line 1596
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->f:Lcom/facebook/AppEventsLogger;

    invoke-virtual {v0, p1, p3, p4, p2}, Lcom/facebook/AppEventsLogger;->logEvent(Ljava/lang/String;DLandroid/os/Bundle;)V

    .line 1597
    return-void
.end method

.method private a(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Z)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 957
    invoke-static {p3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v3

    .line 959
    const-string v0, "aid"

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 960
    const-string v0, "aid"

    const-string v4, "flipp"

    invoke-interface {p2, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 962
    :cond_0
    const-string v0, "t"

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 963
    const-string v0, "t"

    invoke-interface {p2, v0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 965
    :cond_1
    const-string v0, "rnd"

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 966
    const-string v0, "rnd"

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p2, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 968
    :cond_2
    const-string v0, "sid"

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 969
    const-string v0, "sid"

    invoke-virtual {p0}, Lcom/wishabi/flipp/b/a;->d()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p2, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 971
    :cond_3
    const-string v0, "app_version"

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 972
    const-string v0, "app_version"

    iget-object v4, p0, Lcom/wishabi/flipp/b/a;->j:Ljava/lang/String;

    invoke-interface {p2, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 974
    :cond_4
    const-string v0, "system_version"

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 975
    const-string v0, "system_version"

    sget-object v4, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-interface {p2, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 977
    :cond_5
    const-string v0, "system_model"

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 978
    const-string v0, "system_model"

    sget-object v4, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-interface {p2, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 980
    :cond_6
    const-string v0, "tracking_enabled"

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_7

    .line 981
    const-string v4, "tracking_enabled"

    iget-boolean v0, p0, Lcom/wishabi/flipp/b/a;->i:Z

    if-eqz v0, :cond_11

    const-string v0, "0"

    :goto_0
    invoke-interface {p2, v4, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 983
    :cond_7
    const-string v0, "last_listing"

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 984
    const-string v0, "last_listing"

    iget-object v4, p0, Lcom/wishabi/flipp/b/a;->v:Ljava/lang/String;

    invoke-interface {p2, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 986
    :cond_8
    const-string v0, "cross_browse"

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_9

    iget-boolean v0, p0, Lcom/wishabi/flipp/b/a;->r:Z

    if-eqz v0, :cond_9

    .line 987
    const-string v0, "cross_browse"

    const-string v4, "yes"

    invoke-interface {p2, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 989
    :cond_9
    const-string v0, "postal_code"

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_a

    .line 990
    const-string v0, "postal_code"

    iget-object v4, p0, Lcom/wishabi/flipp/b/a;->k:Ljava/lang/String;

    invoke-interface {p2, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 992
    :cond_a
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->k:Ljava/lang/String;

    if-eqz v0, :cond_b

    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->k:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_12

    :cond_b
    move v0, v2

    .line 993
    :goto_1
    const-string v4, "channel_id"

    invoke-interface {p2, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_c

    if-eqz v0, :cond_c

    .line 994
    const-string v4, "channel_id"

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {p2, v4, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 996
    :cond_c
    const-string v0, "device_platform"

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_d

    .line 997
    const-string v0, "device_platform"

    const-string v4, "Android"

    invoke-interface {p2, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 999
    :cond_d
    const-string v0, "allow_push"

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_e

    .line 1000
    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 1004
    if-eqz v0, :cond_1a

    .line 1005
    const-string v4, "allow_push"

    invoke-interface {v0, v4, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 1007
    :goto_2
    const-string v1, "allow_push"

    if-eqz v0, :cond_14

    const-string v0, "true"

    :goto_3
    invoke-interface {p2, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1010
    :cond_e
    const-string v0, "cached_lat"

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_f

    .line 1011
    const-string v1, "cached_lat"

    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->c:Landroid/location/Location;

    if-nez v0, :cond_15

    const-string v0, "0"

    :goto_4
    invoke-interface {p2, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1013
    :cond_f
    const-string v0, "cached_lon"

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    .line 1014
    const-string v1, "cached_lon"

    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->c:Landroid/location/Location;

    if-nez v0, :cond_16

    const-string v0, "0"

    :goto_5
    invoke-interface {p2, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1017
    :cond_10
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_6
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_17

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 1018
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v3, v1, v0}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    goto :goto_6

    .line 981
    :cond_11
    const-string v0, "1"

    goto/16 :goto_0

    .line 992
    :cond_12
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->k:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v4, 0x6

    if-ge v0, v4, :cond_13

    const/16 v0, 0xaf

    goto/16 :goto_1

    :cond_13
    const/16 v0, 0x77

    goto/16 :goto_1

    .line 1007
    :cond_14
    const-string v0, "false"

    goto :goto_3

    .line 1011
    :cond_15
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->c:Landroid/location/Location;

    invoke-virtual {v0}, Landroid/location/Location;->getLatitude()D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v0

    goto :goto_4

    .line 1014
    :cond_16
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->c:Landroid/location/Location;

    invoke-virtual {v0}, Landroid/location/Location;->getLongitude()D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v0

    goto :goto_5

    .line 1020
    :cond_17
    invoke-virtual {v3}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    .line 1021
    if-nez v0, :cond_18

    .line 1043
    :goto_7
    return-void

    .line 1026
    :cond_18
    :try_start_0
    new-instance v1, Ljava/net/URL;

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1032
    if-eqz p4, :cond_19

    .line 1033
    invoke-static {v1, p1}, Lcom/wishabi/flipp/b/a;->b(Ljava/net/URL;Ljava/lang/String;)V

    goto :goto_7

    .line 1027
    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/net/MalformedURLException;->toString()Ljava/lang/String;

    goto :goto_7

    .line 1035
    :cond_19
    new-instance v0, Lcom/wishabi/flipp/b/n;

    invoke-direct {v0, p0, v1, p1}, Lcom/wishabi/flipp/b/n;-><init>(Lcom/wishabi/flipp/b/a;Ljava/net/URL;Ljava/lang/String;)V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/n;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_7

    :cond_1a
    move v0, v1

    goto/16 :goto_2
.end method

.method static synthetic a(Ljava/net/URL;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 69
    invoke-static {p0, p1}, Lcom/wishabi/flipp/b/a;->b(Ljava/net/URL;Ljava/lang/String;)V

    return-void
.end method

.method public static a(Lorg/json/JSONObject;)V
    .locals 4

    .prologue
    .line 926
    if-nez p0, :cond_1

    .line 953
    :cond_0
    :goto_0
    return-void

    .line 934
    :cond_1
    :try_start_0
    const-string v0, "msa_id"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 935
    const/4 v0, 0x1

    new-array v0, v0, [J

    const/4 v1, 0x0

    const-string v2, "msa_id"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v2

    aput-wide v2, v0, v1

    .line 936
    const-string v1, "msa_id"

    sget-object v2, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-static {v1, v0, v2}, Lcom/localytics/android/Localytics;->addProfileAttributesToSet(Ljava/lang/String;[JLcom/localytics/android/Localytics$ProfileScope;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    .line 945
    :cond_2
    :goto_1
    :try_start_1
    const-string v0, "msa_name"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 946
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "msa_name"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    .line 947
    const-string v1, "msa_name"

    sget-object v2, Lcom/localytics/android/Localytics$ProfileScope;->APPLICATION:Lcom/localytics/android/Localytics$ProfileScope;

    invoke-static {v1, v0, v2}, Lcom/localytics/android/Localytics;->addProfileAttributesToSet(Ljava/lang/String;[Ljava/lang/String;Lcom/localytics/android/Localytics$ProfileScope;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 950
    :catch_0
    move-exception v0

    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0

    .line 939
    :catch_1
    move-exception v0

    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1
.end method

.method static synthetic a(Lcom/wishabi/flipp/b/a;Z)Z
    .locals 0

    .prologue
    .line 69
    iput-boolean p1, p0, Lcom/wishabi/flipp/b/a;->i:Z

    return p1
.end method

.method static synthetic b(Lcom/wishabi/flipp/b/a;)Lcom/wishabi/flipp/content/Flyer$Model;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->B:Lcom/wishabi/flipp/content/Flyer$Model;

    return-object v0
.end method

.method static synthetic b(Lcom/wishabi/flipp/b/a;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/wishabi/flipp/b/a;->h:Ljava/lang/String;

    return-object p1
.end method

.method public static b(Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1601
    :try_start_0
    invoke-static {p0, p1}, Lcom/localytics/android/Localytics;->tagEvent(Ljava/lang/String;Ljava/util/Map;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1614
    :goto_0
    return-void

    .line 1610
    :catch_0
    move-exception v0

    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p0, v0, v1

    const/4 v1, 0x1

    invoke-virtual {p1}, Ljava/util/HashMap;->toString()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    goto :goto_0
.end method

.method private static b(Ljava/net/URL;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 1047
    :try_start_0
    invoke-virtual {p0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 1049
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    .line 1050
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setUseCaches(Z)V

    .line 1051
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v0

    const/16 v1, 0xc8

    if-ne v0, v1, :cond_0

    .line 1052
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Beacon: ("

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ") "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1056
    :cond_0
    :goto_0
    return-void

    .line 1053
    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    goto :goto_0
.end method

.method static synthetic c(Lcom/wishabi/flipp/b/a;)Landroid/graphics/RectF;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->A:Landroid/graphics/RectF;

    return-object v0
.end method

.method static synthetic c(Lcom/wishabi/flipp/b/a;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/wishabi/flipp/b/a;->v:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic d(Lcom/wishabi/flipp/b/a;)F
    .locals 1

    .prologue
    .line 69
    iget v0, p0, Lcom/wishabi/flipp/b/a;->C:F

    return v0
.end method

.method static synthetic e(Lcom/wishabi/flipp/b/a;)J
    .locals 2

    .prologue
    .line 69
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/wishabi/flipp/b/a;->z:J

    return-wide v0
.end method

.method static synthetic f(Lcom/wishabi/flipp/b/a;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic g(Lcom/wishabi/flipp/b/a;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->h:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic h(Lcom/wishabi/flipp/b/a;)Z
    .locals 1

    .prologue
    .line 69
    iget-boolean v0, p0, Lcom/wishabi/flipp/b/a;->i:Z

    return v0
.end method

.method static synthetic i(Lcom/wishabi/flipp/b/a;)Ljava/util/UUID;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->w:Ljava/util/UUID;

    return-object v0
.end method

.method static synthetic j(Lcom/wishabi/flipp/b/a;)Lcom/google/analytics/tracking/android/ay;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->e:Lcom/google/analytics/tracking/android/ay;

    return-object v0
.end method

.method static synthetic k(Lcom/wishabi/flipp/b/a;)V
    .locals 3

    .prologue
    .line 69
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    const-string v1, "lat"

    const-string v2, "0"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "lon"

    const-string v2, "0"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "accuracy"

    const-string v2, "0.0"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "app_open"

    invoke-virtual {p0, v1, v0}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;)V

    return-void
.end method

.method static synthetic l(Lcom/wishabi/flipp/b/a;)Lcom/google/android/gms/location/e;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->t:Lcom/google/android/gms/location/e;

    return-object v0
.end method

.method static synthetic m(Lcom/wishabi/flipp/b/a;)Lcom/google/android/gms/location/e;
    .locals 1

    .prologue
    .line 69
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/b/a;->t:Lcom/google/android/gms/location/e;

    return-object v0
.end method

.method static synthetic n(Lcom/wishabi/flipp/b/a;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->k:Ljava/lang/String;

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/wishabi/flipp/b/a;
    .locals 1

    .prologue
    .line 69
    const-class v0, Lcom/wishabi/flipp/b/a;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/b/a;

    return-object v0
.end method

.method public static values()[Lcom/wishabi/flipp/b/a;
    .locals 1

    .prologue
    .line 69
    sget-object v0, Lcom/wishabi/flipp/b/a;->D:[Lcom/wishabi/flipp/b/a;

    invoke-virtual {v0}, [Lcom/wishabi/flipp/b/a;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wishabi/flipp/b/a;

    return-object v0
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 577
    invoke-virtual {p0}, Lcom/wishabi/flipp/b/a;->b()V

    .line 578
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/wishabi/flipp/b/a;->z:J

    .line 579
    return-void
.end method

.method public final a(Lcom/wishabi/flipp/content/Flyer$Model;)V
    .locals 1

    .prologue
    .line 662
    iget-boolean v0, p0, Lcom/wishabi/flipp/b/a;->d:Z

    if-nez v0, :cond_0

    .line 663
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/b/a;->b(Lcom/wishabi/flipp/content/Flyer$Model;)V

    .line 664
    :cond_0
    return-void
.end method

.method public final a(Lcom/wishabi/flipp/content/Flyer$Model;JLcom/wishabi/flipp/b/o;)V
    .locals 8

    .prologue
    .line 755
    const-wide/16 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    move-object v4, p4

    invoke-virtual/range {v0 .. v6}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;JLcom/wishabi/flipp/b/o;D)V

    .line 756
    return-void
.end method

.method public final a(Lcom/wishabi/flipp/content/Flyer$Model;JLcom/wishabi/flipp/b/o;D)V
    .locals 8

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 760
    if-nez p1, :cond_0

    .line 797
    :goto_0
    return-void

    .line 763
    :cond_0
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;)V

    .line 765
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 766
    const-string v0, "flyer_id"

    iget v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 767
    const-string v0, "analytics_payload"

    iget-object v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->o:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 768
    const-string v0, "flyer_item_id"

    invoke-static {p2, p3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 769
    const-string v0, "flyer_type_id"

    iget v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->c:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 770
    const-string v0, "flyer_run_id"

    iget v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->b:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 771
    const-string v0, "merchant_id"

    iget v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 772
    const-string v2, "flipp_premium_merchant"

    iget-boolean v0, p1, Lcom/wishabi/flipp/content/Flyer$Model;->e:Z

    if-eqz v0, :cond_2

    const-string v0, "1"

    :goto_1
    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 774
    const-string v0, "postal_code"

    iget-object v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->f:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 775
    const-string v0, "st"

    iget v2, p4, Lcom/wishabi/flipp/b/o;->m:I

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 777
    sget-object v0, Lcom/wishabi/flipp/b/o;->e:Lcom/wishabi/flipp/b/o;

    if-ne p4, v0, :cond_4

    .line 778
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 779
    const-string v0, "fb_content_id"

    invoke-virtual {v2, v0, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 780
    const-string v3, "fb_currency"

    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->k:Ljava/lang/String;

    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "CAD"

    :goto_2
    invoke-virtual {v2, v3, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 783
    const-string v0, "fb_mobile_add_to_wishlist"

    invoke-direct {p0, v0, v2, p5, p6}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Landroid/os/Bundle;D)V

    .line 785
    const-string v0, "Clipped Item"

    invoke-static {v0, v1}, Lcom/wishabi/flipp/b/a;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 790
    :cond_1
    :goto_3
    const-string v0, "item"

    invoke-virtual {p0, v0, v1, v5}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    .line 792
    const-string v0, "item"

    const-string v1, "item | %sitem"

    new-array v2, v6, [Ljava/lang/Object;

    iget-object v3, p4, Lcom/wishabi/flipp/b/o;->n:Ljava/lang/String;

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "item | %sitem | MER %s | MID %d | FID %d"

    const/4 v3, 0x4

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p4, Lcom/wishabi/flipp/b/o;->n:Ljava/lang/String;

    aput-object v4, v3, v5

    iget-object v4, p1, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    aput-object v4, v3, v6

    const/4 v4, 0x2

    iget v5, p1, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x3

    iget v5, p1, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v0, v1, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 772
    :cond_2
    const-string v0, "0"

    goto :goto_1

    .line 780
    :cond_3
    const-string v0, "USD"

    goto :goto_2

    .line 786
    :cond_4
    sget-object v0, Lcom/wishabi/flipp/b/o;->a:Lcom/wishabi/flipp/b/o;

    if-ne p4, v0, :cond_1

    .line 787
    const-string v0, "Item Details"

    invoke-static {v0, v1}, Lcom/wishabi/flipp/b/a;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_3
.end method

.method public final a(Lcom/wishabi/flipp/content/Flyer$Model;Landroid/graphics/RectF;F)V
    .locals 2

    .prologue
    .line 721
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/wishabi/flipp/b/a;->z:J

    .line 722
    if-nez p1, :cond_0

    .line 729
    :goto_0
    return-void

    .line 725
    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/wishabi/flipp/b/a;->z:J

    .line 726
    iput-object p2, p0, Lcom/wishabi/flipp/b/a;->A:Landroid/graphics/RectF;

    .line 727
    iput-object p1, p0, Lcom/wishabi/flipp/b/a;->B:Lcom/wishabi/flipp/content/Flyer$Model;

    .line 728
    iput p3, p0, Lcom/wishabi/flipp/b/a;->C:F

    goto :goto_0
.end method

.method public final a(Lcom/wishabi/flipp/content/Flyer$Model;Lcom/wishabi/flipp/b/r;)V
    .locals 3

    .prologue
    .line 1059
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1060
    const-string v1, "flyer_id"

    iget v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1061
    const-string v1, "valid_to"

    iget-object v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->m:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1062
    const-string v1, "analytic_type"

    iget v2, p2, Lcom/wishabi/flipp/b/r;->c:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1063
    iget-object v1, p0, Lcom/wishabi/flipp/b/a;->m:Landroid/content/ContentResolver;

    sget-object v2, Lcom/wishabi/flipp/content/i;->i:Landroid/net/Uri;

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 1064
    return-void
.end method

.method public final a(Lcom/wishabi/flipp/content/Flyer$Model;Ljava/lang/String;)V
    .locals 8

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 863
    if-nez p1, :cond_0

    .line 879
    :goto_0
    return-void

    .line 866
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 867
    const-string v1, "merchant"

    iget-object v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 868
    const-string v1, "flyer_id"

    iget v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 869
    const-string v1, "analytics_payload"

    iget-object v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->o:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 870
    const-string v1, "st"

    invoke-virtual {v0, v1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 871
    const-string v1, "noclip"

    invoke-virtual {p0, v1, v0, v5}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    .line 873
    const-string v0, "noclip"

    const-string v1, "noclip | MER %s | MID %d"

    new-array v2, v7, [Ljava/lang/Object;

    iget-object v3, p1, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    aput-object v3, v2, v5

    iget v3, p1, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "noclip | MER %s | MID %d | FID %d | TYPE %s"

    const/4 v3, 0x4

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p1, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    aput-object v4, v3, v5

    iget v4, p1, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v6

    iget v4, p1, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v7

    const/4 v4, 0x3

    aput-object p2, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v0, v1, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public final a(Lcom/wishabi/flipp/content/Flyer$Model;Ljava/lang/String;Lcom/wishabi/flipp/content/h;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 590
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 591
    const-string v0, "flyer_id"

    iget v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 592
    const-string v0, "analytics_payload"

    iget-object v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->o:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 593
    const-string v0, "flyer_run_id"

    iget v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->b:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 594
    const-string v0, "flyer_type_id"

    iget v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->c:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 595
    const-string v0, "merchant_id"

    iget v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 596
    const-string v2, "flipp_premium_merchant"

    iget-boolean v0, p1, Lcom/wishabi/flipp/content/Flyer$Model;->e:Z

    if-eqz v0, :cond_0

    const-string v0, "1"

    :goto_0
    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 598
    const-string v0, "source"

    invoke-virtual {v1, v0, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 599
    const-string v0, "postal_code"

    iget-object v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->f:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 602
    if-nez p3, :cond_1

    .line 603
    const-string v0, "featured_item_id"

    const-string v2, "<null>"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 604
    const-string v0, "brand_name"

    const-string v2, "<null>"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 605
    const-string v0, "brand_id"

    const-string v2, "<null>"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 606
    const-string v0, "featured_item_weight"

    const-string v2, "<null>"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 607
    const-string v0, "sales_story"

    const-string v2, "<null>"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 616
    :goto_1
    const-string v0, "impression"

    invoke-virtual {p0, v0, v1, v4}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    .line 618
    const-string v0, "impression"

    const-string v1, "impression | MER %s | MID %d"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p1, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    aput-object v3, v2, v4

    const/4 v3, 0x1

    iget v4, p1, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v1, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 622
    return-void

    .line 596
    :cond_0
    const-string v0, "0"

    goto :goto_0

    .line 609
    :cond_1
    const-string v0, "featured_item_id"

    iget-wide v2, p3, Lcom/wishabi/flipp/content/h;->a:J

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 610
    const-string v0, "brand_name"

    iget-object v2, p3, Lcom/wishabi/flipp/content/h;->g:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 611
    const-string v0, "brand_id"

    iget v2, p3, Lcom/wishabi/flipp/content/h;->f:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 612
    const-string v0, "featured_item_weight"

    iget v2, p3, Lcom/wishabi/flipp/content/h;->i:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 613
    const-string v0, "sales_story"

    iget-object v2, p3, Lcom/wishabi/flipp/content/h;->d:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1
.end method

.method public final a(Lcom/wishabi/flipp/content/Flyer$Model;Z)V
    .locals 8

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 800
    if-nez p1, :cond_0

    .line 822
    :goto_0
    return-void

    .line 803
    :cond_0
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 804
    const-string v0, "merchant_id"

    iget v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 806
    if-eqz p2, :cond_1

    .line 807
    const-string v0, "Added to Favorites"

    invoke-static {v0, v1}, Lcom/wishabi/flipp/b/a;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 811
    :goto_1
    const-string v0, "postal_code"

    iget-object v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->f:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 812
    const-string v2, "action"

    if-eqz p2, :cond_2

    const-string v0, "Favorited"

    :goto_2
    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 813
    const-string v0, "favorite"

    invoke-virtual {p0, v0, v1, v5}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    .line 815
    const-string v2, "Favorite"

    const-string v0, "Favorite | MER %s | MID %d"

    new-array v1, v7, [Ljava/lang/Object;

    iget-object v3, p1, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    aput-object v3, v1, v5

    iget v3, p1, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v6

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    const-string v1, "Favorite | MER %s | MID %d | ACTION %s"

    const/4 v0, 0x3

    new-array v4, v0, [Ljava/lang/Object;

    iget-object v0, p1, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    aput-object v0, v4, v5

    iget v0, p1, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v4, v6

    if-eqz p2, :cond_3

    const-string v0, "Favorited"

    :goto_3
    aput-object v0, v4, v7

    invoke-static {v1, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    if-eqz p2, :cond_4

    const-wide/16 v0, 0x1

    :goto_4
    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {p0, v2, v3, v4, v0}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V

    goto :goto_0

    .line 809
    :cond_1
    const-string v0, "Removed from Favorites"

    invoke-static {v0, v1}, Lcom/wishabi/flipp/b/a;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_1

    .line 812
    :cond_2
    const-string v0, "Unfavorited"

    goto :goto_2

    .line 815
    :cond_3
    const-string v0, "Unfavorited"

    goto :goto_3

    :cond_4
    const-wide/16 v0, -0x1

    goto :goto_4
.end method

.method public final a(Lcom/wishabi/flipp/content/c;Lcom/wishabi/flipp/b/q;Lcom/wishabi/flipp/b/p;)V
    .locals 8

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 1454
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    if-nez p3, :cond_1

    .line 1484
    :cond_0
    :goto_0
    return-void

    .line 1457
    :cond_1
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 1458
    iget-object v0, p1, Lcom/wishabi/flipp/content/c;->e:Ljava/lang/Integer;

    if-nez v0, :cond_2

    const-string v0, "<null>"

    .line 1461
    :goto_1
    const-string v1, "coupon_id"

    iget v3, p1, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1462
    const-string v3, "merchant_id"

    iget-object v1, p1, Lcom/wishabi/flipp/content/c;->b:Ljava/lang/Integer;

    if-nez v1, :cond_3

    const-string v1, "<null>"

    :goto_2
    invoke-virtual {v2, v3, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1464
    const-string v1, "coupon_vendor_id"

    invoke-virtual {v2, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1465
    const-string v1, "coupon_type"

    iget-object v0, p1, Lcom/wishabi/flipp/content/c;->f:Lcom/wishabi/flipp/content/f;

    if-nez v0, :cond_4

    const-string v0, "<null>"

    :goto_3
    invoke-virtual {v2, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1467
    const-string v1, "brand"

    iget-object v0, p1, Lcom/wishabi/flipp/content/c;->g:Ljava/lang/String;

    if-nez v0, :cond_5

    const-string v0, "<null>"

    :goto_4
    invoke-virtual {v2, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1469
    const-string v1, "redemption_method"

    iget-object v0, p1, Lcom/wishabi/flipp/content/c;->j:Lcom/wishabi/flipp/content/e;

    if-nez v0, :cond_6

    const-string v0, "<null>"

    :goto_5
    invoke-virtual {v2, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1471
    const-string v0, "click_source"

    iget-object v1, p3, Lcom/wishabi/flipp/b/p;->k:Ljava/lang/String;

    invoke-virtual {v2, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1472
    const-string v0, "st"

    iget v1, p2, Lcom/wishabi/flipp/b/q;->f:I

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1473
    const-string v0, "coupon"

    invoke-virtual {p0, v0, v2, v4}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    .line 1475
    const-string v1, "coupon"

    .line 1476
    const-string v0, "%s | %s"

    new-array v2, v6, [Ljava/lang/Object;

    aput-object v1, v2, v4

    iget-object v3, p2, Lcom/wishabi/flipp/b/q;->g:Ljava/lang/String;

    aput-object v3, v2, v5

    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 1477
    iget-object v0, p1, Lcom/wishabi/flipp/content/c;->e:Ljava/lang/Integer;

    if-eqz v0, :cond_7

    const-string v0, "%s | CVID %s | CID %d"

    new-array v3, v7, [Ljava/lang/Object;

    aput-object v2, v3, v4

    iget-object v4, p1, Lcom/wishabi/flipp/content/c;->e:Ljava/lang/Integer;

    aput-object v4, v3, v5

    iget v4, p1, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1483
    :goto_6
    invoke-virtual {p0, v1, v2, v0}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1458
    :cond_2
    iget-object v0, p1, Lcom/wishabi/flipp/content/c;->e:Ljava/lang/Integer;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 1462
    :cond_3
    iget-object v1, p1, Lcom/wishabi/flipp/content/c;->b:Ljava/lang/Integer;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_2

    .line 1465
    :cond_4
    iget-object v0, p1, Lcom/wishabi/flipp/content/c;->f:Lcom/wishabi/flipp/content/f;

    iget-object v0, v0, Lcom/wishabi/flipp/content/f;->d:Ljava/lang/String;

    goto :goto_3

    .line 1467
    :cond_5
    iget-object v0, p1, Lcom/wishabi/flipp/content/c;->g:Ljava/lang/String;

    goto :goto_4

    .line 1469
    :cond_6
    iget-object v0, p1, Lcom/wishabi/flipp/content/c;->j:Lcom/wishabi/flipp/content/e;

    iget-object v0, v0, Lcom/wishabi/flipp/content/e;->e:Ljava/lang/String;

    goto :goto_5

    .line 1477
    :cond_7
    const-string v0, "%s | MID %s | CID %d"

    new-array v3, v7, [Ljava/lang/Object;

    aput-object v2, v3, v4

    iget-object v4, p1, Lcom/wishabi/flipp/content/c;->b:Ljava/lang/Integer;

    aput-object v4, v3, v5

    iget v4, p1, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_6
.end method

.method public final a(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 388
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->e:Lcom/google/analytics/tracking/android/ay;

    if-nez v0, :cond_0

    .line 403
    :goto_0
    return-void

    .line 391
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->x:Ljava/util/Timer;

    if-eqz v0, :cond_1

    .line 392
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->x:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 394
    :cond_1
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/b/a;->x:Ljava/util/Timer;

    .line 395
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->x:Ljava/util/Timer;

    new-instance v1, Lcom/wishabi/flipp/b/i;

    invoke-direct {v1, p0, p1}, Lcom/wishabi/flipp/b/i;-><init>(Lcom/wishabi/flipp/b/a;Ljava/lang/String;)V

    const-wide/16 v2, 0x12c

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    goto :goto_0
.end method

.method public final a(Ljava/lang/String;II)V
    .locals 10

    .prologue
    .line 1284
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 1285
    const/4 v2, 0x0

    .line 1286
    const/4 v1, -0x1

    .line 1287
    const-string v7, "shopping list"

    .line 1289
    const/4 v0, 0x0

    .line 1290
    const/4 v3, -0x1

    if-ne p3, v3, :cond_2

    const/4 v3, 0x0

    move-object v5, v3

    .line 1292
    :goto_0
    if-eqz p1, :cond_1

    .line 1293
    const-string v3, " "

    const/4 v4, 0x2

    invoke-virtual {p1, v3, v4}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v3

    .line 1295
    array-length v4, v3

    const/4 v8, 0x1

    if-le v4, v8, :cond_0

    const/4 v4, 0x0

    aget-object v4, v3, v4

    invoke-static {v4}, Lcom/wishabi/flipp/util/q;->b(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1296
    const/4 v1, 0x1

    aget-object v2, v3, v1

    .line 1297
    const/4 v1, 0x0

    aget-object v1, v3, v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    .line 1300
    :cond_0
    if-nez v2, :cond_3

    .line 1301
    const-string v0, "qty"

    const-string v3, "null"

    invoke-virtual {v6, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1302
    const-string v0, "item"

    invoke-virtual {v6, v0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1303
    const-string v0, "%s | HASQTY 0"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1311
    :cond_1
    :goto_1
    sget-object v3, Lcom/wishabi/flipp/b/f;->a:[I

    add-int/lit8 v4, p2, -0x1

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 1403
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid shopping list analytic"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1290
    :cond_2
    int-to-long v4, p3

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object v5, v3

    goto :goto_0

    .line 1304
    :cond_3
    const/4 v3, -0x1

    if-eq v1, v3, :cond_1

    .line 1305
    const-string v0, "qty"

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v6, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1306
    const-string v0, "item"

    invoke-virtual {v6, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1307
    const-string v0, "%s | HASQTY 1"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v2, v3, v4

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 1313
    :pswitch_0
    const-string v3, "st"

    const-string v4, "add"

    invoke-virtual {v6, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1314
    const-string v3, "context"

    const-string v4, "list"

    invoke-virtual {v6, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1315
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " | add"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 1317
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 1318
    const-string v9, "item"

    if-eqz v2, :cond_5

    move-object v3, v2

    :goto_2
    invoke-virtual {v8, v9, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1319
    const-string v9, "hasQty"

    if-eqz v2, :cond_6

    const-string v3, "1"

    :goto_3
    invoke-virtual {v8, v9, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1320
    const-string v3, "context"

    const-string v9, "list"

    invoke-virtual {v8, v3, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1321
    const-string v3, "Shopping List Add"

    invoke-static {v3, v8}, Lcom/wishabi/flipp/b/a;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 1323
    new-instance v8, Landroid/os/Bundle;

    invoke-direct {v8}, Landroid/os/Bundle;-><init>()V

    .line 1324
    const-string v3, "fb_content_id"

    if-eqz v2, :cond_7

    :goto_4
    invoke-virtual {v8, v3, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1326
    const-string v2, "fb_content_type"

    const-string v3, "list"

    invoke-virtual {v8, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1327
    const-string v9, "fb_mobile_add_to_cart"

    const/4 v2, -0x1

    if-ne v1, v2, :cond_8

    const-wide/16 v2, 0x0

    :goto_5
    invoke-direct {p0, v9, v8, v2, v3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Landroid/os/Bundle;D)V

    move-object v1, v4

    .line 1406
    :goto_6
    if-eqz v0, :cond_4

    .line 1407
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " | "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1409
    :cond_4
    const-string v2, "shopping_list"

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v6, v3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    .line 1410
    invoke-virtual {p0, v7, v1, v0, v5}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V

    .line 1411
    return-void

    :cond_5
    move-object v3, p1

    .line 1318
    goto :goto_2

    .line 1319
    :cond_6
    const-string v3, "0"

    goto :goto_3

    :cond_7
    move-object v2, p1

    .line 1324
    goto :goto_4

    .line 1327
    :cond_8
    int-to-double v2, v1

    goto :goto_5

    .line 1331
    :pswitch_1
    const-string v3, "st"

    const-string v4, "add"

    invoke-virtual {v6, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1332
    const-string v3, "context"

    const-string v4, "flyer"

    invoke-virtual {v6, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1333
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " | add from flyer"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 1335
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 1336
    const-string v9, "item"

    if-eqz v2, :cond_9

    move-object v3, v2

    :goto_7
    invoke-virtual {v8, v9, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1337
    const-string v9, "hasQty"

    if-eqz v2, :cond_a

    const-string v3, "1"

    :goto_8
    invoke-virtual {v8, v9, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1338
    const-string v3, "context"

    const-string v9, "flyer"

    invoke-virtual {v8, v3, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1339
    const-string v3, "Shopping List Add"

    invoke-static {v3, v8}, Lcom/wishabi/flipp/b/a;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 1341
    new-instance v8, Landroid/os/Bundle;

    invoke-direct {v8}, Landroid/os/Bundle;-><init>()V

    .line 1342
    const-string v3, "fb_content_id"

    if-eqz v2, :cond_b

    :goto_9
    invoke-virtual {v8, v3, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1344
    const-string v2, "fb_content_type"

    const-string v3, "flyer"

    invoke-virtual {v8, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1346
    const-string v9, "fb_mobile_add_to_cart"

    const/4 v2, -0x1

    if-ne v1, v2, :cond_c

    const-wide/16 v2, 0x0

    :goto_a
    invoke-direct {p0, v9, v8, v2, v3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Landroid/os/Bundle;D)V

    move-object v1, v4

    .line 1348
    goto/16 :goto_6

    :cond_9
    move-object v3, p1

    .line 1336
    goto :goto_7

    .line 1337
    :cond_a
    const-string v3, "0"

    goto :goto_8

    :cond_b
    move-object v2, p1

    .line 1342
    goto :goto_9

    .line 1346
    :cond_c
    int-to-double v2, v1

    goto :goto_a

    .line 1350
    :pswitch_2
    const-string v3, "st"

    const-string v4, "add"

    invoke-virtual {v6, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1351
    const-string v3, "context"

    const-string v4, "search"

    invoke-virtual {v6, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1352
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " | add from search"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 1354
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 1355
    const-string v9, "item"

    if-eqz v2, :cond_d

    move-object v3, v2

    :goto_b
    invoke-virtual {v8, v9, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1356
    const-string v9, "hasQty"

    if-eqz v2, :cond_e

    const-string v3, "1"

    :goto_c
    invoke-virtual {v8, v9, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1357
    const-string v3, "context"

    const-string v9, "search"

    invoke-virtual {v8, v3, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1358
    const-string v3, "Shopping List Add"

    invoke-static {v3, v8}, Lcom/wishabi/flipp/b/a;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 1360
    new-instance v8, Landroid/os/Bundle;

    invoke-direct {v8}, Landroid/os/Bundle;-><init>()V

    .line 1361
    const-string v3, "fb_content_id"

    if-eqz v2, :cond_f

    :goto_d
    invoke-virtual {v8, v3, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1363
    const-string v2, "fb_content_type"

    const-string v3, "search"

    invoke-virtual {v8, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1365
    const-string v9, "fb_mobile_add_to_cart"

    const/4 v2, -0x1

    if-ne v1, v2, :cond_10

    const-wide/16 v2, 0x0

    :goto_e
    invoke-direct {p0, v9, v8, v2, v3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Landroid/os/Bundle;D)V

    move-object v1, v4

    .line 1367
    goto/16 :goto_6

    :cond_d
    move-object v3, p1

    .line 1355
    goto :goto_b

    .line 1356
    :cond_e
    const-string v3, "0"

    goto :goto_c

    :cond_f
    move-object v2, p1

    .line 1361
    goto :goto_d

    .line 1365
    :cond_10
    int-to-double v2, v1

    goto :goto_e

    .line 1369
    :pswitch_3
    const-string v1, "st"

    const-string v2, "edit"

    invoke-virtual {v6, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1370
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " | edit"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_6

    .line 1373
    :pswitch_4
    const-string v1, "st"

    const-string v2, "delete"

    invoke-virtual {v6, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1374
    const-string v1, "clip"

    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1375
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " | delete"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_6

    .line 1378
    :pswitch_5
    const-string v1, "st"

    const-string v2, "clearChecked"

    invoke-virtual {v6, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1379
    const-string v1, "clear"

    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1380
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " | clearChecked"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_6

    .line 1383
    :pswitch_6
    const-string v1, "st"

    const-string v2, "clearAll"

    invoke-virtual {v6, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1384
    const-string v1, "clear"

    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1385
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " | clearAll"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_6

    .line 1388
    :pswitch_7
    const-string v1, "st"

    const-string v2, "uncheckAll"

    invoke-virtual {v6, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1389
    const-string v1, "uncheck"

    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1390
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " | uncheckAll"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_6

    .line 1393
    :pswitch_8
    const-string v1, "st"

    const-string v2, "check"

    invoke-virtual {v6, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1394
    const-string v1, "clip"

    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1395
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " | check"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_6

    .line 1398
    :pswitch_9
    const-string v1, "st"

    const-string v2, "uncheck"

    invoke-virtual {v6, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1399
    const-string v1, "clip"

    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1400
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " | uncheck"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_6

    .line 1311
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
    .end packed-switch
.end method

.method public final a(Ljava/lang/String;Landroid/net/Uri;)V
    .locals 4

    .prologue
    .line 1091
    new-instance v0, Lcom/wishabi/flipp/b/c;

    iget-object v1, p0, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    invoke-direct {v0, p0, v1}, Lcom/wishabi/flipp/b/c;-><init>(Lcom/wishabi/flipp/b/a;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/b/a;->u:Lcom/wishabi/flipp/b/ab;

    .line 1120
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->u:Lcom/wishabi/flipp/b/ab;

    const-wide/32 v2, 0xea60

    invoke-virtual {v0, v2, v3}, Lcom/wishabi/flipp/b/ab;->a(J)V

    .line 1123
    const-string v0, "fb_mobile_activate_app"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 1127
    if-eqz p1, :cond_1

    .line 1128
    const-string v0, "Push Notification"

    .line 1134
    :goto_0
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 1135
    const-string v2, "mechanism"

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1136
    if-eqz p2, :cond_0

    .line 1137
    const-string v0, "url"

    invoke-virtual {p2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1138
    :cond_0
    const-string v0, "App Open"

    invoke-static {v0, v1}, Lcom/wishabi/flipp/b/a;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 1139
    return-void

    .line 1129
    :cond_1
    if-eqz p2, :cond_2

    .line 1130
    const-string v0, "Another App"

    goto :goto_0

    .line 1132
    :cond_2
    const-string v0, "Direct"

    goto :goto_0
.end method

.method public final a(Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 1588
    if-nez p2, :cond_0

    .line 1589
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->f:Lcom/facebook/AppEventsLogger;

    invoke-virtual {v0, p1}, Lcom/facebook/AppEventsLogger;->logEvent(Ljava/lang/String;)V

    .line 1592
    :goto_0
    return-void

    .line 1591
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->f:Lcom/facebook/AppEventsLogger;

    invoke-virtual {v0, p1, p2}, Lcom/facebook/AppEventsLogger;->logEvent(Ljava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public final a(Ljava/lang/String;Lcom/wishabi/flipp/b/t;)V
    .locals 6

    .prologue
    const/4 v4, 0x0

    .line 882
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 883
    const-string v1, "store"

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 884
    const-string v1, "postal_code"

    iget-object v2, p0, Lcom/wishabi/flipp/b/a;->k:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 885
    const-string v1, "view"

    iget-object v2, p2, Lcom/wishabi/flipp/b/t;->c:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 886
    const-string v1, "store_request"

    invoke-virtual {p0, v1, v0, v4}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    .line 888
    const-string v0, "Store Request"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Store Request | REQUESTED STORE "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Store Request | REQUESTED STORE %s | LOC %s | VIEW %s"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p1, v3, v4

    const/4 v4, 0x1

    iget-object v5, p0, Lcom/wishabi/flipp/b/a;->k:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x2

    iget-object v5, p2, Lcom/wishabi/flipp/b/t;->c:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v0, v1, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 891
    return-void
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;Landroid/database/Cursor;)V
    .locals 6

    .prologue
    .line 438
    if-nez p3, :cond_0

    .line 439
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/b/a;->b(Ljava/lang/String;)V

    .line 479
    :goto_0
    return-void

    .line 443
    :cond_0
    invoke-interface {p3}, Landroid/database/Cursor;->getPosition()I

    move-result v1

    .line 444
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 445
    const/4 v0, 0x0

    .line 446
    invoke-interface {p3}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 448
    :cond_1
    const/16 v3, 0x66

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "flyer_id"

    invoke-interface {p3, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p3, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x70

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "premium"

    invoke-interface {p3, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p3, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 453
    add-int/lit8 v0, v0, 0x1

    const/16 v3, 0x32

    if-ge v0, v3, :cond_2

    .line 454
    invoke-interface {p3}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-nez v3, :cond_1

    .line 457
    :cond_2
    invoke-interface {p3, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 459
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 460
    const-string v1, "screen_name"

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 461
    const-string v1, "flyer_ids"

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 462
    const-string v1, "postal_code"

    iget-object v2, p0, Lcom/wishabi/flipp/b/a;->k:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 463
    const-string v1, "count"

    invoke-interface {p3}, Landroid/database/Cursor;->getCount()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 465
    if-eqz p2, :cond_3

    .line 466
    const-string v1, "sort"

    invoke-virtual {v0, v1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 468
    :cond_3
    iget-object v1, p0, Lcom/wishabi/flipp/b/a;->y:Ljava/util/Timer;

    if-eqz v1, :cond_4

    .line 469
    iget-object v1, p0, Lcom/wishabi/flipp/b/a;->y:Ljava/util/Timer;

    invoke-virtual {v1}, Ljava/util/Timer;->cancel()V

    .line 471
    :cond_4
    new-instance v1, Ljava/util/Timer;

    invoke-direct {v1}, Ljava/util/Timer;-><init>()V

    iput-object v1, p0, Lcom/wishabi/flipp/b/a;->y:Ljava/util/Timer;

    .line 472
    iget-object v1, p0, Lcom/wishabi/flipp/b/a;->y:Ljava/util/Timer;

    new-instance v2, Lcom/wishabi/flipp/b/j;

    invoke-direct {v2, p0, v0, p1}, Lcom/wishabi/flipp/b/j;-><init>(Lcom/wishabi/flipp/b/a;Ljava/util/HashMap;Ljava/lang/String;)V

    const-wide/16 v4, 0x3e8

    invoke-virtual {v1, v2, v4, v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    goto/16 :goto_0
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 1575
    const-wide/16 v0, 0x0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V

    .line 1576
    return-void
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V
    .locals 6

    .prologue
    .line 1580
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->e:Lcom/google/analytics/tracking/android/ay;

    if-nez v0, :cond_0

    .line 1585
    :goto_0
    return-void

    .line 1583
    :cond_0
    iget-object v1, p0, Lcom/wishabi/flipp/b/a;->e:Lcom/google/analytics/tracking/android/ay;

    invoke-static {}, Lcom/google/analytics/tracking/android/ai;->a()Lcom/google/analytics/tracking/android/ai;

    move-result-object v0

    sget-object v2, Lcom/google/analytics/tracking/android/aj;->Y:Lcom/google/analytics/tracking/android/aj;

    invoke-virtual {v0, v2}, Lcom/google/analytics/tracking/android/ai;->a(Lcom/google/analytics/tracking/android/aj;)V

    new-instance v2, Lcom/google/analytics/tracking/android/aq;

    invoke-direct {v2}, Lcom/google/analytics/tracking/android/aq;-><init>()V

    const-string v0, "&t"

    const-string v3, "event"

    invoke-virtual {v2, v0, v3}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    const-string v0, "&ec"

    invoke-virtual {v2, v0, p1}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    const-string v0, "&ea"

    invoke-virtual {v2, v0, p2}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    const-string v0, "&el"

    invoke-virtual {v2, v0, p3}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    const-string v3, "&ev"

    if-nez p4, :cond_1

    const/4 v0, 0x0

    :goto_1
    invoke-virtual {v2, v3, v0}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    invoke-virtual {v2}, Lcom/google/analytics/tracking/android/aq;->a()Ljava/util/Map;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/google/analytics/tracking/android/ay;->a(Ljava/util/Map;)V

    goto :goto_0

    :cond_1
    invoke-virtual {p4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method public final a(Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 486
    .line 489
    const-string v0, "screen_name"

    invoke-virtual {p2, v0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 491
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->y:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 492
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->y:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 494
    :cond_0
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/b/a;->y:Ljava/util/Timer;

    .line 495
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->y:Ljava/util/Timer;

    new-instance v1, Lcom/wishabi/flipp/b/k;

    invoke-direct {v1, p0, p2, p1}, Lcom/wishabi/flipp/b/k;-><init>(Lcom/wishabi/flipp/b/a;Ljava/util/HashMap;Ljava/lang/String;)V

    const-wide/16 v2, 0x3e8

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 506
    return-void
.end method

.method public final a(Ljava/lang/String;Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1560
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    .line 1561
    return-void
.end method

.method public final a(Ljava/lang/String;Ljava/util/Map;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 1567
    const-string v0, "https://a.wishabi.com/track.gif"

    invoke-direct {p0, p1, p2, v0, p3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Z)V

    .line 1569
    const-string v0, "https://b.wishabi.com/track.gif"

    invoke-direct {p0, p1, p2, v0, p3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Z)V

    .line 1571
    return-void
.end method

.method public final a(Ljava/util/ArrayList;Lcom/wishabi/flipp/b/q;Lcom/wishabi/flipp/b/p;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;",
            "Lcom/wishabi/flipp/b/q;",
            "Lcom/wishabi/flipp/b/p;",
            ")V"
        }
    .end annotation

    .prologue
    .line 1445
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/c;

    .line 1449
    invoke-virtual {p0, v0, p2, p3}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/c;Lcom/wishabi/flipp/b/q;Lcom/wishabi/flipp/b/p;)V

    goto :goto_0

    .line 1450
    :cond_0
    return-void
.end method

.method public final b()V
    .locals 1

    .prologue
    .line 582
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->g:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 583
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->g:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 584
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/b/a;->g:Ljava/util/Timer;

    .line 585
    return-void
.end method

.method public final b(Lcom/wishabi/flipp/content/Flyer$Model;)V
    .locals 12

    .prologue
    const-wide/16 v10, 0x1f

    const/4 v9, 0x3

    const/4 v8, 0x2

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 667
    invoke-virtual {p0}, Lcom/wishabi/flipp/b/a;->b()V

    .line 669
    if-nez p1, :cond_0

    .line 717
    :goto_0
    return-void

    .line 672
    :cond_0
    sget-object v0, Lcom/wishabi/flipp/b/r;->b:Lcom/wishabi/flipp/b/r;

    invoke-virtual {p0, p1, v0}, Lcom/wishabi/flipp/b/a;->b(Lcom/wishabi/flipp/content/Flyer$Model;Lcom/wishabi/flipp/b/r;)Z

    move-result v4

    .line 673
    if-nez v4, :cond_2

    iget-boolean v0, p1, Lcom/wishabi/flipp/content/Flyer$Model;->e:Z

    if-eqz v0, :cond_2

    move v0, v1

    .line 675
    :goto_1
    iput-boolean v1, p0, Lcom/wishabi/flipp/b/a;->d:Z

    .line 676
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 677
    const-string v3, "flyer_id"

    iget v6, p1, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v3, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 678
    const-string v3, "analytics_payload"

    iget-object v6, p1, Lcom/wishabi/flipp/content/Flyer$Model;->o:Ljava/lang/String;

    invoke-virtual {v5, v3, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 679
    const-string v3, "flyer_run_id"

    iget v6, p1, Lcom/wishabi/flipp/content/Flyer$Model;->b:I

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v3, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 680
    const-string v3, "flyer_type_id"

    iget v6, p1, Lcom/wishabi/flipp/content/Flyer$Model;->c:I

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v3, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 681
    const-string v3, "merchant_id"

    iget v6, p1, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v3, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 682
    const-string v3, "merchant"

    iget-object v6, p1, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    invoke-virtual {v5, v3, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 683
    const-string v6, "flipp_premium_merchant"

    iget-boolean v3, p1, Lcom/wishabi/flipp/content/Flyer$Model;->e:Z

    if-eqz v3, :cond_3

    const-string v3, "1"

    :goto_2
    invoke-virtual {v5, v6, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 685
    const-string v3, "postal_code"

    iget-object v6, p1, Lcom/wishabi/flipp/content/Flyer$Model;->f:Ljava/lang/String;

    invoke-virtual {v5, v3, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 686
    const-string v6, "repeat"

    if-eqz v4, :cond_4

    const-string v3, "1"

    :goto_3
    invoke-virtual {v5, v6, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 688
    const-string v3, "Flyer Engagement"

    invoke-static {v3, v5}, Lcom/wishabi/flipp/b/a;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 689
    if-eqz v0, :cond_1

    .line 690
    const-string v3, "Billing Engagement"

    const-wide/16 v6, 0x1f

    :try_start_0
    invoke-static {v3, v5, v6, v7}, Lcom/localytics/android/Localytics;->tagEvent(Ljava/lang/String;Ljava/util/Map;J)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 692
    :cond_1
    :goto_4
    const-string v3, "ev"

    invoke-virtual {p0, v3, v5, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    .line 694
    if-eqz v4, :cond_5

    const-string v3, "repeat"

    .line 695
    :goto_5
    iget-boolean v4, p1, Lcom/wishabi/flipp/content/Flyer$Model;->e:Z

    if-eqz v4, :cond_6

    const-string v4, "promoted"

    .line 696
    :goto_6
    const-string v5, "EV %s %s"

    new-array v6, v8, [Ljava/lang/Object;

    aput-object v4, v6, v2

    aput-object v3, v6, v1

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 698
    const-string v5, "%s | MER %s | MID %d"

    new-array v6, v9, [Ljava/lang/Object;

    aput-object v3, v6, v2

    iget-object v7, p1, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    aput-object v7, v6, v1

    iget v7, p1, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "%s | MER %s | MID %d | FID %d"

    const/4 v7, 0x4

    new-array v7, v7, [Ljava/lang/Object;

    aput-object v3, v7, v2

    iget-object v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    aput-object v2, v7, v1

    iget v1, p1, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v7, v8

    iget v1, p1, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v7, v9

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v3, v5, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 705
    iget-object v1, p0, Lcom/wishabi/flipp/b/a;->k:Ljava/lang/String;

    invoke-static {v1}, Lcom/wishabi/flipp/util/k;->b(Ljava/lang/String;)Z

    move-result v2

    .line 706
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 707
    const-string v1, "fb_content_type"

    invoke-virtual {v3, v1, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 708
    const-string v1, "fb_content_id"

    iget v4, p1, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-virtual {v3, v1, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 710
    const-string v4, "fb_currency"

    if-eqz v2, :cond_7

    const-string v1, "CAD"

    :goto_7
    invoke-virtual {v3, v4, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 713
    const-string v4, "fb_mobile_content_view"

    if-eqz v0, :cond_9

    if-eqz v2, :cond_8

    const-wide v0, 0x3fd3d70a3d70a3d7L    # 0.31

    :goto_8
    invoke-direct {p0, v4, v3, v0, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Landroid/os/Bundle;D)V

    .line 716
    sget-object v0, Lcom/wishabi/flipp/b/r;->b:Lcom/wishabi/flipp/b/r;

    invoke-virtual {p0, p1, v0}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;Lcom/wishabi/flipp/b/r;)V

    goto/16 :goto_0

    :cond_2
    move v0, v2

    .line 673
    goto/16 :goto_1

    .line 683
    :cond_3
    const-string v3, "0"

    goto/16 :goto_2

    .line 686
    :cond_4
    const-string v3, "0"

    goto/16 :goto_3

    .line 690
    :catch_0
    move-exception v6

    new-array v6, v9, [Ljava/lang/Object;

    aput-object v3, v6, v2

    invoke-virtual {v5}, Ljava/util/HashMap;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v6, v1

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v6, v8

    goto/16 :goto_4

    .line 694
    :cond_5
    const-string v3, "unique"

    goto/16 :goto_5

    .line 695
    :cond_6
    const-string v4, "organic"

    goto/16 :goto_6

    .line 710
    :cond_7
    const-string v1, "USD"

    goto :goto_7

    .line 713
    :cond_8
    const-wide v0, 0x3fd28f5c28f5c28fL    # 0.29

    goto :goto_8

    :cond_9
    const-wide/16 v0, 0x0

    goto :goto_8
.end method

.method public final b(Lcom/wishabi/flipp/content/Flyer$Model;Ljava/lang/String;Lcom/wishabi/flipp/content/h;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 627
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 628
    const-string v0, "flyer_id"

    iget v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 629
    const-string v0, "analytics_payload"

    iget-object v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->o:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 630
    const-string v0, "flyer_run_id"

    iget v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->b:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 631
    const-string v0, "flyer_type_id"

    iget v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->c:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 632
    const-string v0, "merchant_id"

    iget v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 633
    const-string v2, "flipp_premium_merchant"

    iget-boolean v0, p1, Lcom/wishabi/flipp/content/Flyer$Model;->e:Z

    if-eqz v0, :cond_0

    const-string v0, "1"

    :goto_0
    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 635
    const-string v0, "source"

    invoke-virtual {v1, v0, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 636
    const-string v0, "postal_code"

    iget-object v2, p1, Lcom/wishabi/flipp/content/Flyer$Model;->f:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 639
    if-nez p3, :cond_1

    .line 640
    const-string v0, "featured_item_id"

    const-string v2, "<null>"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 641
    const-string v0, "brand_name"

    const-string v2, "<null>"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 642
    const-string v0, "brand_id"

    const-string v2, "<null>"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 643
    const-string v0, "featured_item_weight"

    const-string v2, "<null>"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 644
    const-string v0, "sales_story"

    const-string v2, "<null>"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 653
    :goto_1
    const-string v0, "featured_item_click"

    invoke-virtual {p0, v0, v1, v4}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    .line 655
    const-string v0, "featured item click"

    const-string v1, "featured item click | MER %s | MID %d"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p1, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    aput-object v3, v2, v4

    const/4 v3, 0x1

    iget v4, p1, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v1, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 659
    return-void

    .line 633
    :cond_0
    const-string v0, "0"

    goto :goto_0

    .line 646
    :cond_1
    const-string v0, "featured_item_id"

    iget-wide v2, p3, Lcom/wishabi/flipp/content/h;->a:J

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 647
    const-string v0, "brand_name"

    iget-object v2, p3, Lcom/wishabi/flipp/content/h;->g:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 648
    const-string v0, "brand_id"

    iget v2, p3, Lcom/wishabi/flipp/content/h;->f:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 649
    const-string v0, "featured_item_weight"

    iget v2, p3, Lcom/wishabi/flipp/content/h;->i:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 650
    const-string v0, "sales_story"

    iget-object v2, p3, Lcom/wishabi/flipp/content/h;->d:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1
.end method

.method public final b(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 432
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 433
    const-string v1, "count"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 434
    invoke-virtual {p0, p1, v0}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 435
    return-void
.end method

.method public final b(Lcom/wishabi/flipp/content/Flyer$Model;Lcom/wishabi/flipp/b/r;)Z
    .locals 10

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    const/4 v8, 0x0

    .line 1067
    .line 1069
    :try_start_0
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->m:Landroid/content/ContentResolver;

    sget-object v1, Lcom/wishabi/flipp/content/i;->i:Landroid/net/Uri;

    const/4 v2, 0x0

    const-string v3, "flyer_id = ? and analytic_type = ?"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    iget v9, p1, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v9}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v4, v5

    const/4 v5, 0x1

    iget v9, p2, Lcom/wishabi/flipp/b/r;->c:I

    invoke-static {v9}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1075
    if-eqz v1, :cond_1

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v0

    if-lez v0, :cond_1

    move v0, v6

    .line 1077
    :goto_0
    if-eqz v1, :cond_0

    .line 1078
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_0
    return v0

    :cond_1
    move v0, v7

    .line 1075
    goto :goto_0

    .line 1077
    :catchall_0
    move-exception v0

    move-object v1, v8

    :goto_1
    if-eqz v1, :cond_2

    .line 1078
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v0

    .line 1077
    :catchall_1
    move-exception v0

    goto :goto_1
.end method

.method public final c()V
    .locals 4

    .prologue
    .line 1181
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 1182
    iget-wide v2, p0, Lcom/wishabi/flipp/b/a;->s:J

    sub-long v2, v0, v2

    long-to-float v2, v2

    const v3, 0x48927c00    # 300000.0f

    cmpg-float v2, v2, v3

    if-ltz v2, :cond_0

    iget-object v2, p0, Lcom/wishabi/flipp/b/a;->t:Lcom/google/android/gms/location/e;

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    invoke-static {v2}, Lcom/google/android/gms/common/g;->a(Landroid/content/Context;)I

    move-result v2

    if-eqz v2, :cond_1

    .line 1224
    :cond_0
    :goto_0
    return-void

    .line 1188
    :cond_1
    iput-wide v0, p0, Lcom/wishabi/flipp/b/a;->s:J

    .line 1189
    new-instance v0, Lcom/google/android/gms/location/e;

    iget-object v1, p0, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    new-instance v2, Lcom/wishabi/flipp/b/d;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/b/d;-><init>(Lcom/wishabi/flipp/b/a;)V

    new-instance v3, Lcom/wishabi/flipp/b/e;

    invoke-direct {v3, p0}, Lcom/wishabi/flipp/b/e;-><init>(Lcom/wishabi/flipp/b/a;)V

    invoke-direct {v0, v1, v2, v3}, Lcom/google/android/gms/location/e;-><init>(Landroid/content/Context;Lcom/google/android/gms/common/c;Lcom/google/android/gms/common/d;)V

    iput-object v0, p0, Lcom/wishabi/flipp/b/a;->t:Lcom/google/android/gms/location/e;

    .line 1223
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->t:Lcom/google/android/gms/location/e;

    iget-object v0, v0, Lcom/google/android/gms/location/e;->a:Lcom/google/android/gms/internal/iu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/iu;->d()V

    goto :goto_0
.end method

.method public final c(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 1227
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1228
    const-string v1, "platform"

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1229
    const-string v1, "device_token"

    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/b/a;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1230
    const-string v1, "device_token"

    const/4 v2, 0x1

    invoke-virtual {p0, v1, v0, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    .line 1231
    return-void
.end method

.method public final d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1263
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->h:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->h:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->w:Ljava/util/UUID;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/b/a;->w:Ljava/util/UUID;

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    const-string v0, "unknown"

    goto :goto_0
.end method

.method public final d(Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 1250
    iget-object v1, p0, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    const-string v2, "com.wishabi.flipp.preferences"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 1253
    const-string v2, "gcm"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1254
    const-string v2, "gcm_registration_id"

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1259
    :cond_0
    :goto_0
    return-object v0

    .line 1255
    :cond_1
    const-string v2, "adm"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1256
    const-string v2, "adm_registration_id"

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
