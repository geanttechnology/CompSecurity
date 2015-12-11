.class public Lcom/kochava/android/tracker/Feature;
.super Ljava/lang/Object;
.source "Feature.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/kochava/android/tracker/Feature$CURRENCIES;,
        Lcom/kochava/android/tracker/Feature$INPUTITEMS;,
        Lcom/kochava/android/tracker/Feature$PARAMS;,
        Lcom/kochava/android/tracker/Feature$TrackTask;
    }
.end annotation


# static fields
.field protected static final ADLOGTAG:Ljava/lang/String; = "KochavaAds"

.field private static final AD_CLICK_RESET_TIME:I = 0x9c4

.field private static final AD_UNAVAILABLE_CLICK_RESET_TIME:I = 0x9c4

.field public static final ATTRIBUTION_DATA:Ljava/lang/String; = "attributionData"

.field private static final ATTRIBUTION_ID_COLUMN_NAME:Ljava/lang/String; = "aid"

.field private static final ATTRIBUTION_ID_CONTENT_URI:Landroid/net/Uri;

.field protected static final ATTRIBUTION_PREF_DATA:Ljava/lang/String; = "attributionData"

.field protected static final ATTRIBUTION_PREF_NAME:Ljava/lang/String; = "attributionPref"

.field private static final BIDDER_DEFAULT_HOST:Ljava/lang/String; = "bidder.kochava.com"

.field private static final BIDDER_ENDPOINT:Ljava/lang/String; = "/adserver/request/"

.field private static final BULK_UPLOAD_LIMIT:I = 0x28

.field private static final CONTROL_DEFAULT_HOST:Ljava/lang/String; = "control.kochava.com"

.field private static final DATA_EXPIRATION:I = 0x240c8400

.field private static final FLUSH_RATE:I = 0xea60

.field private static final HTML_FORMAT:Ljava/lang/String; = "<html><body style=\"text-align: center; background-color: black; vertical-align: center;\"><img src = \"%s\" /></body></html>"

.field private static final HTTPS_STRING:Ljava/lang/String; = "https://"

.field private static final HTTP_STRING:Ljava/lang/String; = "http://"

.field private static final INIT_ENDPOINT:Ljava/lang/String; = "/track/kvinit"

.field private static final INIT_FORCE_TIME:I = 0x927c0

.field public static final LINKIDENTITYBOOL:Ljava/lang/String; = "linkIdentityBool"

.field protected static final LOGTAG:Ljava/lang/String; = "KochavaTracker"

.field private static final OPTIONS_ENDPOINT:Ljava/lang/String; = "/track/kv_options.php"

.field protected static final PREF_APPDATA:Ljava/lang/String; = "kochavaappdata"

.field protected static final PREF_CUR:Ljava/lang/String; = "currency"

.field protected static final PREF_INIT:Ljava/lang/String; = "initBool"

.field protected static final PREF_INIT_DATA:Ljava/lang/String; = "initData"

.field protected static final PREF_LAT:Ljava/lang/String; = "mylat"

.field protected static final PREF_LONG:Ljava/lang/String; = "mylong"

.field protected static final PREF_NAME:Ljava/lang/String; = "initPrefs"

.field protected static final PREF_TIMESTOPPED:Ljava/lang/String; = "timeStampStopped"

.field protected static final REQLOGTAG:Ljava/lang/String; = "KochavaRequirements"

.field private static final SENDONSTART:Ljava/lang/String; = "sendonstart"

.field private static final STRING_FALSE:Ljava/lang/String; = "false"

.field private static final STRING_TRUE:Ljava/lang/String; = "true"

.field private static final TRACKER_ENDPOINT:Ljava/lang/String; = "/track/kvTracker.php"

.field private static advertisingID:Ljava/lang/String;

.field protected static appContext:Landroid/content/Context;

.field private static attributionDataHandler:Landroid/os/Handler;

.field private static first_run:I

.field private static hostBidder:Ljava/lang/String;

.field private static hostControl:Ljava/lang/String;

.field private static identityLinkMap:Ljava/util/Map;
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

.field private static identityLinkMapJSON:Lorg/json/JSONObject;

.field private static paramRestrictions:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private static requestAttributionData:Z

.field public static webStates:Ljava/util/Hashtable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Hashtable",
            "<",
            "Ljava/lang/Integer;",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation
.end field

.field public static webViews:Ljava/util/Hashtable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Hashtable",
            "<",
            "Ljava/lang/Integer;",
            "Landroid/webkit/WebView;",
            ">;"
        }
    .end annotation
.end field

.field private static final worker:Ljava/util/concurrent/ScheduledExecutorService;


# instance fields
.field private adTimer:Ljava/util/Timer;

.field private attributionDataPrefs:Landroid/content/SharedPreferences;

.field private badInit:Z

.field private canSendSession:Z

.field private final executor:Ljava/util/concurrent/ExecutorService;

.field private initHandler:Landroid/os/Handler;

.field private initTimer:Ljava/util/Timer;

.field private initTimerRepeat:Ljava/util/Timer;

.field private initialObject:Lorg/json/JSONObject;

.field private initialPropertiesObject:Lorg/json/JSONObject;

.field private kDbAdapter:Lcom/kochava/android/tracker/KochavaDbAdapter;

.field protected kvinitdata:Lorg/json/JSONObject;

.field protected kvinitdataholder:Lorg/json/JSONObject;

.field protected kvinitorigdata:Lorg/json/JSONObject;

.field private lastCallTime:J

.field private mAndroidID:Ljava/lang/String;

.field private mAppId:Ljava/lang/String;

.field private mAppName:Ljava/lang/String;

.field private mAppPackageName:Ljava/lang/String;

.field private mAppVersionCode:Ljava/lang/String;

.field private mAppVersionName:Ljava/lang/String;

.field private mCarrier:Ljava/lang/String;

.field private mContext:Landroid/content/Context;

.field private mDeviceId:Ljava/lang/String;

.field private mDisplayHeight:I

.field private mDisplayWidth:I

.field private mEnvDeviceID:Ljava/lang/String;

.field private mFbId:Ljava/lang/String;

.field private mIMEI:Ljava/lang/String;

.field private mIsStartOfLife:Z

.field private mKochDevIDStrategy:Ljava/lang/String;

.field private mMacAddr:Ljava/lang/String;

.field private mModel:Ljava/lang/String;

.field private mOSVersion:Ljava/lang/String;

.field private mSuperProperties:Ljava/util/Map;
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

.field private mTestMode:Z

.field private mTimer:Ljava/util/Timer;

.field private mTimerSendOnBegin:Ljava/util/Timer;

.field private mUserAgent:Ljava/lang/String;

.field private prefs:Landroid/content/SharedPreferences;

.field private startTime:J


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 132
    const-string v0, ""

    sput-object v0, Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;

    .line 133
    const-string v0, ""

    sput-object v0, Lcom/kochava/android/tracker/Feature;->hostBidder:Ljava/lang/String;

    .line 165
    sput v1, Lcom/kochava/android/tracker/Feature;->first_run:I

    .line 210
    sput-boolean v1, Lcom/kochava/android/tracker/Feature;->requestAttributionData:Z

    .line 224
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadScheduledExecutor()Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    .line 223
    sput-object v0, Lcom/kochava/android/tracker/Feature;->worker:Ljava/util/concurrent/ScheduledExecutorService;

    .line 229
    const-string v0, "content://com.facebook.katana.provider.AttributionIdProvider"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 228
    sput-object v0, Lcom/kochava/android/tracker/Feature;->ATTRIBUTION_ID_CONTENT_URI:Landroid/net/Uri;

    .line 233
    new-instance v0, Lcom/kochava/android/tracker/Feature$1;

    invoke-direct {v0}, Lcom/kochava/android/tracker/Feature$1;-><init>()V

    sput-object v0, Lcom/kochava/android/tracker/Feature;->paramRestrictions:Ljava/util/HashMap;

    .line 241
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "kochavaAppID"    # Ljava/lang/String;

    .prologue
    const-wide/16 v4, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 282
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 189
    iput-wide v4, p0, Lcom/kochava/android/tracker/Feature;->lastCallTime:J

    .line 190
    iput-wide v4, p0, Lcom/kochava/android/tracker/Feature;->startTime:J

    .line 201
    iput-boolean v1, p0, Lcom/kochava/android/tracker/Feature;->mTestMode:Z

    .line 202
    iput-boolean v2, p0, Lcom/kochava/android/tracker/Feature;->mIsStartOfLife:Z

    .line 206
    iput-boolean v1, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    .line 208
    iput-boolean v2, p0, Lcom/kochava/android/tracker/Feature;->canSendSession:Z

    .line 218
    invoke-static {v2}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    iput-object v1, p0, Lcom/kochava/android/tracker/Feature;->executor:Ljava/util/concurrent/ExecutorService;

    .line 1028
    new-instance v1, Lcom/kochava/android/tracker/Feature$2;

    invoke-direct {v1, p0}, Lcom/kochava/android/tracker/Feature$2;-><init>(Lcom/kochava/android/tracker/Feature;)V

    iput-object v1, p0, Lcom/kochava/android/tracker/Feature;->initHandler:Landroid/os/Handler;

    .line 284
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 286
    .local v0, "datamap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_0

    .line 287
    const-string v1, "kochava_app_id"

    invoke-virtual {v0, v1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 289
    :cond_0
    invoke-direct {p0, p1, v2, v0}, Lcom/kochava/android/tracker/Feature;->init(Landroid/content/Context;ZLjava/util/HashMap;)V

    .line 290
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "kochavaAppID"    # Ljava/lang/String;
    .param p3, "currency"    # Ljava/lang/String;

    .prologue
    const-wide/16 v4, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 268
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 189
    iput-wide v4, p0, Lcom/kochava/android/tracker/Feature;->lastCallTime:J

    .line 190
    iput-wide v4, p0, Lcom/kochava/android/tracker/Feature;->startTime:J

    .line 201
    iput-boolean v1, p0, Lcom/kochava/android/tracker/Feature;->mTestMode:Z

    .line 202
    iput-boolean v2, p0, Lcom/kochava/android/tracker/Feature;->mIsStartOfLife:Z

    .line 206
    iput-boolean v1, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    .line 208
    iput-boolean v2, p0, Lcom/kochava/android/tracker/Feature;->canSendSession:Z

    .line 218
    invoke-static {v2}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    iput-object v1, p0, Lcom/kochava/android/tracker/Feature;->executor:Ljava/util/concurrent/ExecutorService;

    .line 1028
    new-instance v1, Lcom/kochava/android/tracker/Feature$2;

    invoke-direct {v1, p0}, Lcom/kochava/android/tracker/Feature$2;-><init>(Lcom/kochava/android/tracker/Feature;)V

    iput-object v1, p0, Lcom/kochava/android/tracker/Feature;->initHandler:Landroid/os/Handler;

    .line 270
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 272
    .local v0, "datamap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_0

    .line 273
    const-string v1, "kochava_app_id"

    invoke-virtual {v0, v1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 275
    :cond_0
    if-eqz p3, :cond_1

    invoke-virtual {p3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_1

    .line 276
    const-string v1, "currency"

    invoke-virtual {v0, v1, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 278
    :cond_1
    invoke-direct {p0, p1, v2, v0}, Lcom/kochava/android/tracker/Feature;->init(Landroid/content/Context;ZLjava/util/HashMap;)V

    .line 279
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Z)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "kochavaAppID"    # Ljava/lang/String;
    .param p3, "sendOnStart"    # Z

    .prologue
    const-wide/16 v4, 0x0

    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 257
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 189
    iput-wide v4, p0, Lcom/kochava/android/tracker/Feature;->lastCallTime:J

    .line 190
    iput-wide v4, p0, Lcom/kochava/android/tracker/Feature;->startTime:J

    .line 201
    iput-boolean v2, p0, Lcom/kochava/android/tracker/Feature;->mTestMode:Z

    .line 202
    iput-boolean v1, p0, Lcom/kochava/android/tracker/Feature;->mIsStartOfLife:Z

    .line 206
    iput-boolean v2, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    .line 208
    iput-boolean v1, p0, Lcom/kochava/android/tracker/Feature;->canSendSession:Z

    .line 218
    invoke-static {v1}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    iput-object v1, p0, Lcom/kochava/android/tracker/Feature;->executor:Ljava/util/concurrent/ExecutorService;

    .line 1028
    new-instance v1, Lcom/kochava/android/tracker/Feature$2;

    invoke-direct {v1, p0}, Lcom/kochava/android/tracker/Feature$2;-><init>(Lcom/kochava/android/tracker/Feature;)V

    iput-object v1, p0, Lcom/kochava/android/tracker/Feature;->initHandler:Landroid/os/Handler;

    .line 259
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 261
    .local v0, "datamap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_0

    .line 262
    const-string v1, "kochava_app_id"

    invoke-virtual {v0, v1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 264
    :cond_0
    invoke-direct {p0, p1, p3, v0}, Lcom/kochava/android/tracker/Feature;->init(Landroid/content/Context;ZLjava/util/HashMap;)V

    .line 265
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "kochavaAppID"    # Ljava/lang/String;
    .param p3, "sendOnStart"    # Z
    .param p4, "currency"    # Ljava/lang/String;

    .prologue
    const-wide/16 v4, 0x0

    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 244
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 189
    iput-wide v4, p0, Lcom/kochava/android/tracker/Feature;->lastCallTime:J

    .line 190
    iput-wide v4, p0, Lcom/kochava/android/tracker/Feature;->startTime:J

    .line 201
    iput-boolean v2, p0, Lcom/kochava/android/tracker/Feature;->mTestMode:Z

    .line 202
    iput-boolean v1, p0, Lcom/kochava/android/tracker/Feature;->mIsStartOfLife:Z

    .line 206
    iput-boolean v2, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    .line 208
    iput-boolean v1, p0, Lcom/kochava/android/tracker/Feature;->canSendSession:Z

    .line 218
    invoke-static {v1}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    iput-object v1, p0, Lcom/kochava/android/tracker/Feature;->executor:Ljava/util/concurrent/ExecutorService;

    .line 1028
    new-instance v1, Lcom/kochava/android/tracker/Feature$2;

    invoke-direct {v1, p0}, Lcom/kochava/android/tracker/Feature$2;-><init>(Lcom/kochava/android/tracker/Feature;)V

    iput-object v1, p0, Lcom/kochava/android/tracker/Feature;->initHandler:Landroid/os/Handler;

    .line 246
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 248
    .local v0, "datamap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_0

    .line 249
    const-string v1, "kochava_app_id"

    invoke-virtual {v0, v1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 251
    :cond_0
    if-eqz p4, :cond_1

    invoke-virtual {p4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_1

    .line 252
    const-string v1, "currency"

    invoke-virtual {v0, v1, p4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 254
    :cond_1
    invoke-direct {p0, p1, p3, v0}, Lcom/kochava/android/tracker/Feature;->init(Landroid/content/Context;ZLjava/util/HashMap;)V

    .line 255
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/util/HashMap;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, "datamap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-wide/16 v4, 0x0

    const/4 v0, 0x0

    const/4 v3, 0x1

    .line 299
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 189
    iput-wide v4, p0, Lcom/kochava/android/tracker/Feature;->lastCallTime:J

    .line 190
    iput-wide v4, p0, Lcom/kochava/android/tracker/Feature;->startTime:J

    .line 201
    iput-boolean v0, p0, Lcom/kochava/android/tracker/Feature;->mTestMode:Z

    .line 202
    iput-boolean v3, p0, Lcom/kochava/android/tracker/Feature;->mIsStartOfLife:Z

    .line 206
    iput-boolean v0, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    .line 208
    iput-boolean v3, p0, Lcom/kochava/android/tracker/Feature;->canSendSession:Z

    .line 218
    invoke-static {v3}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/kochava/android/tracker/Feature;->executor:Ljava/util/concurrent/ExecutorService;

    .line 1028
    new-instance v0, Lcom/kochava/android/tracker/Feature$2;

    invoke-direct {v0, p0}, Lcom/kochava/android/tracker/Feature$2;-><init>(Lcom/kochava/android/tracker/Feature;)V

    iput-object v0, p0, Lcom/kochava/android/tracker/Feature;->initHandler:Landroid/os/Handler;

    .line 301
    const-string v0, "KochavaTracker"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "is datamap null? "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 302
    invoke-direct {p0, p1, v3, p2}, Lcom/kochava/android/tracker/Feature;->init(Landroid/content/Context;ZLjava/util/HashMap;)V

    .line 303
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;ZLjava/util/HashMap;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "sendOnStart"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Z",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p3, "datamap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-wide/16 v2, 0x0

    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 293
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 189
    iput-wide v2, p0, Lcom/kochava/android/tracker/Feature;->lastCallTime:J

    .line 190
    iput-wide v2, p0, Lcom/kochava/android/tracker/Feature;->startTime:J

    .line 201
    iput-boolean v1, p0, Lcom/kochava/android/tracker/Feature;->mTestMode:Z

    .line 202
    iput-boolean v0, p0, Lcom/kochava/android/tracker/Feature;->mIsStartOfLife:Z

    .line 206
    iput-boolean v1, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    .line 208
    iput-boolean v0, p0, Lcom/kochava/android/tracker/Feature;->canSendSession:Z

    .line 218
    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/kochava/android/tracker/Feature;->executor:Ljava/util/concurrent/ExecutorService;

    .line 1028
    new-instance v0, Lcom/kochava/android/tracker/Feature$2;

    invoke-direct {v0, p0}, Lcom/kochava/android/tracker/Feature$2;-><init>(Lcom/kochava/android/tracker/Feature;)V

    iput-object v0, p0, Lcom/kochava/android/tracker/Feature;->initHandler:Landroid/os/Handler;

    .line 295
    invoke-direct {p0, p1, p2, p3}, Lcom/kochava/android/tracker/Feature;->init(Landroid/content/Context;ZLjava/util/HashMap;)V

    .line 296
    return-void
.end method

.method static synthetic access$0(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 2380
    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getUserAgent()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1(Lcom/kochava/android/tracker/Feature;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 182
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature;->mUserAgent:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$10(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 172
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->mAppName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$11(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 173
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->mAppVersionCode:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$12(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->mAppVersionName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$13(Lcom/kochava/android/tracker/Feature;I)V
    .locals 0

    .prologue
    .line 184
    iput p1, p0, Lcom/kochava/android/tracker/Feature;->mDisplayHeight:I

    return-void
.end method

.method static synthetic access$14(Lcom/kochava/android/tracker/Feature;I)V
    .locals 0

    .prologue
    .line 185
    iput p1, p0, Lcom/kochava/android/tracker/Feature;->mDisplayWidth:I

    return-void
.end method

.method static synthetic access$15(Lcom/kochava/android/tracker/Feature;)I
    .locals 1

    .prologue
    .line 184
    iget v0, p0, Lcom/kochava/android/tracker/Feature;->mDisplayHeight:I

    return v0
.end method

.method static synthetic access$16(Lcom/kochava/android/tracker/Feature;)I
    .locals 1

    .prologue
    .line 185
    iget v0, p0, Lcom/kochava/android/tracker/Feature;->mDisplayWidth:I

    return v0
.end method

.method static synthetic access$17(Lcom/kochava/android/tracker/Feature;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 179
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature;->mAndroidID:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$18(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1786
    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$19(Lcom/kochava/android/tracker/Feature;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 176
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature;->mDeviceId:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$2(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1721
    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getCarrier()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$20(Lcom/kochava/android/tracker/Feature;Landroid/content/SharedPreferences;)V
    .locals 0

    .prologue
    .line 214
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    return-void
.end method

.method static synthetic access$21(Lcom/kochava/android/tracker/Feature;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$22(Lcom/kochava/android/tracker/Feature;)Lcom/kochava/android/tracker/KochavaDbAdapter;
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->kDbAdapter:Lcom/kochava/android/tracker/KochavaDbAdapter;

    return-object v0
.end method

.method static synthetic access$23(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1249
    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->createAppData()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$24(I)V
    .locals 0

    .prologue
    .line 165
    sput p0, Lcom/kochava/android/tracker/Feature;->first_run:I

    return-void
.end method

.method static synthetic access$25(Lcom/kochava/android/tracker/Feature;Z)V
    .locals 0

    .prologue
    .line 202
    iput-boolean p1, p0, Lcom/kochava/android/tracker/Feature;->mIsStartOfLife:Z

    return-void
.end method

.method static synthetic access$26(Lcom/kochava/android/tracker/Feature;)Z
    .locals 1

    .prologue
    .line 202
    iget-boolean v0, p0, Lcom/kochava/android/tracker/Feature;->mIsStartOfLife:Z

    return v0
.end method

.method static synthetic access$27(Lcom/kochava/android/tracker/Feature;Ljava/lang/String;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 1570
    invoke-direct {p0, p1, p2}, Lcom/kochava/android/tracker/Feature;->fireEvent(Ljava/lang/String;Ljava/util/Map;)V

    return-void
.end method

.method static synthetic access$28(Lcom/kochava/android/tracker/Feature;Ljava/util/Timer;)V
    .locals 0

    .prologue
    .line 204
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature;->mTimer:Ljava/util/Timer;

    return-void
.end method

.method static synthetic access$29(Lcom/kochava/android/tracker/Feature;)Ljava/util/Timer;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->mTimer:Ljava/util/Timer;

    return-object v0
.end method

.method static synthetic access$3(Lcom/kochava/android/tracker/Feature;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 170
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature;->mCarrier:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$30(Lcom/kochava/android/tracker/Feature;Ljava/util/Timer;)V
    .locals 0

    .prologue
    .line 204
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature;->initTimer:Ljava/util/Timer;

    return-void
.end method

.method static synthetic access$31(Lcom/kochava/android/tracker/Feature;)Ljava/util/Timer;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->initTimer:Ljava/util/Timer;

    return-object v0
.end method

.method static synthetic access$32(Lcom/kochava/android/tracker/Feature;Z)V
    .locals 0

    .prologue
    .line 2011
    invoke-direct {p0, p1}, Lcom/kochava/android/tracker/Feature;->queInitial(Z)V

    return-void
.end method

.method static synthetic access$33(Lcom/kochava/android/tracker/Feature;Ljava/util/Timer;)V
    .locals 0

    .prologue
    .line 204
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature;->mTimerSendOnBegin:Ljava/util/Timer;

    return-void
.end method

.method static synthetic access$34(Lcom/kochava/android/tracker/Feature;)Ljava/util/Timer;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->mTimerSendOnBegin:Ljava/util/Timer;

    return-object v0
.end method

.method static synthetic access$35(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1886
    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->postEvent()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$36(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 2467
    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getAdvertisingId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$37(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 186
    sput-object p0, Lcom/kochava/android/tracker/Feature;->advertisingID:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$38(Lcom/kochava/android/tracker/Feature;Z)Lorg/apache/http/client/HttpClient;
    .locals 1

    .prologue
    .line 2274
    invoke-direct {p0, p1}, Lcom/kochava/android/tracker/Feature;->createHttpClient(Z)Lorg/apache/http/client/HttpClient;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$39(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->mUserAgent:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$4(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1729
    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getModel()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$40()Ljava/lang/String;
    .locals 1

    .prologue
    .line 132
    sget-object v0, Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$41(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 132
    sput-object p0, Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$42(Lcom/kochava/android/tracker/Feature;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->attributionDataPrefs:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$43()Landroid/os/Handler;
    .locals 1

    .prologue
    .line 220
    sget-object v0, Lcom/kochava/android/tracker/Feature;->attributionDataHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$44(Lcom/kochava/android/tracker/Feature;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 177
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature;->mAppId:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$45(Lcom/kochava/android/tracker/Feature;Z)V
    .locals 0

    .prologue
    .line 208
    iput-boolean p1, p0, Lcom/kochava/android/tracker/Feature;->canSendSession:Z

    return-void
.end method

.method static synthetic access$46(Lcom/kochava/android/tracker/Feature;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1347
    invoke-direct {p0, p1}, Lcom/kochava/android/tracker/Feature;->setCurrency(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$47()Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 233
    sget-object v0, Lcom/kochava/android/tracker/Feature;->paramRestrictions:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$48(Lcom/kochava/android/tracker/Feature;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 1028
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->initHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$49(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->mAppId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$5(Lcom/kochava/android/tracker/Feature;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 171
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature;->mModel:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$50(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1762
    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getAppPackageName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$51()Ljava/lang/String;
    .locals 1

    .prologue
    .line 133
    sget-object v0, Lcom/kochava/android/tracker/Feature;->hostBidder:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$52(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 133
    sput-object p0, Lcom/kochava/android/tracker/Feature;->hostBidder:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$53(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 1845
    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getOdin()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$6(Lcom/kochava/android/tracker/Feature;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 172
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature;->mAppName:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$7(Lcom/kochava/android/tracker/Feature;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 173
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature;->mAppVersionCode:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$8(Lcom/kochava/android/tracker/Feature;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 174
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature;->mAppVersionName:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$9(Lcom/kochava/android/tracker/Feature;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method private addGlobalProperties(Lorg/json/JSONObject;)Lorg/json/JSONObject;
    .locals 8
    .param p1, "map"    # Lorg/json/JSONObject;

    .prologue
    .line 1265
    if-eqz p1, :cond_0

    .line 1270
    :try_start_0
    const-string v1, "usertime"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    div-long/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1273
    const-string v1, "uptime"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    div-long/2addr v4, v6

    iget-wide v6, p0, Lcom/kochava/android/tracker/Feature;->startTime:J

    sub-long/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1276
    iget-wide v2, p0, Lcom/kochava/android/tracker/Feature;->lastCallTime:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-eqz v1, :cond_1

    .line 1277
    const-string v1, "updelta"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    div-long/2addr v4, v6

    iget-wide v6, p0, Lcom/kochava/android/tracker/Feature;->lastCallTime:J

    sub-long/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1281
    :goto_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    div-long/2addr v2, v4

    iput-wide v2, p0, Lcom/kochava/android/tracker/Feature;->lastCallTime:J

    .line 1284
    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    const-string v2, "initPrefs"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    iput-object v1, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    .line 1287
    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    const-string v2, "mylat"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1289
    const-string v1, "geo_lat"

    iget-object v2, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    const-string v3, "mylat"

    const-string v4, ""

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1290
    const-string v1, "geo_lon"

    iget-object v2, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    const-string v3, "mylong"

    const-string v4, ""

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1301
    :cond_0
    :goto_1
    return-object p1

    .line 1279
    :cond_1
    const-string v1, "updelta"

    const-string v2, "0"

    invoke-virtual {p1, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1295
    :catch_0
    move-exception v0

    .line 1297
    .local v0, "e":Ljava/lang/Exception;
    sget-boolean v1, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v1, :cond_0

    const-string v1, "KochavaTracker"

    const-string v2, "Error adding time properties to a JSON object"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method

.method private createAppData()Ljava/lang/String;
    .locals 3

    .prologue
    .line 1251
    const-string v0, ""

    .line 1252
    .local v0, "data":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getDeviceId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":::"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1253
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getModel()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":::"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1254
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getCarrier()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":::"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1255
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getIMEI()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":::"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1256
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getAppVersion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":::"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1257
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getOSVersion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1258
    return-object v0
.end method

.method private createHttpClient(Z)Lorg/apache/http/client/HttpClient;
    .locals 9
    .param p1, "setTimeOut"    # Z

    .prologue
    .line 2276
    sget-boolean v5, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v5, :cond_0

    const-string v5, "KochavaTracker"

    const-string v6, "Creating https client."

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2278
    :cond_0
    sget-object v1, Lorg/apache/http/conn/ssl/SSLSocketFactory;->ALLOW_ALL_HOSTNAME_VERIFIER:Lorg/apache/http/conn/ssl/X509HostnameVerifier;

    .line 2280
    .local v1, "hostnameVerifier":Ljavax/net/ssl/HostnameVerifier;
    new-instance v2, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v2}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 2281
    .local v2, "params":Lorg/apache/http/params/HttpParams;
    sget-object v5, Lorg/apache/http/HttpVersion;->HTTP_1_1:Lorg/apache/http/HttpVersion;

    invoke-static {v2, v5}, Lorg/apache/http/params/HttpProtocolParams;->setVersion(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V

    .line 2282
    const-string v5, "ISO-8859-1"

    invoke-static {v2, v5}, Lorg/apache/http/params/HttpProtocolParams;->setContentCharset(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V

    .line 2283
    const/4 v5, 0x1

    invoke-static {v2, v5}, Lorg/apache/http/params/HttpProtocolParams;->setUseExpectContinue(Lorg/apache/http/params/HttpParams;Z)V

    .line 2285
    if-eqz p1, :cond_1

    .line 2286
    const/16 v5, 0x2710

    invoke-static {v2, v5}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 2288
    :cond_1
    invoke-static {}, Lorg/apache/http/conn/ssl/SSLSocketFactory;->getSocketFactory()Lorg/apache/http/conn/ssl/SSLSocketFactory;

    move-result-object v4

    .local v4, "socketFactory":Lorg/apache/http/conn/ssl/SSLSocketFactory;
    move-object v5, v1

    .line 2289
    check-cast v5, Lorg/apache/http/conn/ssl/X509HostnameVerifier;

    invoke-virtual {v4, v5}, Lorg/apache/http/conn/ssl/SSLSocketFactory;->setHostnameVerifier(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V

    .line 2291
    new-instance v3, Lorg/apache/http/conn/scheme/SchemeRegistry;

    invoke-direct {v3}, Lorg/apache/http/conn/scheme/SchemeRegistry;-><init>()V

    .line 2292
    .local v3, "schReg":Lorg/apache/http/conn/scheme/SchemeRegistry;
    new-instance v5, Lorg/apache/http/conn/scheme/Scheme;

    const-string v6, "http"

    invoke-static {}, Lorg/apache/http/conn/scheme/PlainSocketFactory;->getSocketFactory()Lorg/apache/http/conn/scheme/PlainSocketFactory;

    move-result-object v7

    const/16 v8, 0x50

    invoke-direct {v5, v6, v7, v8}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v3, v5}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 2293
    new-instance v5, Lorg/apache/http/conn/scheme/Scheme;

    const-string v6, "https"

    const/16 v7, 0x1bb

    invoke-direct {v5, v6, v4, v7}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v3, v5}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 2294
    new-instance v0, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;

    invoke-direct {v0, v2, v3}, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;-><init>(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V

    .line 2296
    .local v0, "conMgr":Lorg/apache/http/conn/ClientConnectionManager;
    invoke-static {v1}, Ljavax/net/ssl/HttpsURLConnection;->setDefaultHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V

    .line 2298
    new-instance v5, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v5, v0, v2}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V

    return-object v5
.end method

.method public static enableDebug(Z)V
    .locals 0
    .param p0, "flag"    # Z

    .prologue
    .line 2303
    sput-boolean p0, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    .line 2304
    return-void
.end method

.method private eventSession(Ljava/lang/String;)V
    .locals 4
    .param p1, "state"    # Ljava/lang/String;

    .prologue
    .line 1550
    sget-boolean v1, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 1551
    const-string v1, "KochavaTracker"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Got event "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1554
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1555
    .local v0, "properties":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "state"

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1558
    const-string v1, "session"

    invoke-direct {p0, v1, v0}, Lcom/kochava/android/tracker/Feature;->fireEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 1559
    return-void
.end method

.method private fireEvent(Ljava/lang/String;Ljava/util/Map;)V
    .locals 11
    .param p1, "eventAction"    # Ljava/lang/String;
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
    .line 1573
    .local p2, "properties":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    sget-boolean v7, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v7, :cond_0

    const-string v7, "KochavaTracker"

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "FIRE EVENT*** action:"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1574
    :cond_0
    sget-boolean v7, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v7, :cond_1

    const-string v7, "KochavaTracker"

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "FIRE EVENT*** properties:"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1575
    :cond_1
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 1578
    .local v1, "dataObj":Lorg/json/JSONObject;
    :try_start_0
    const-string v7, "kochava_app_id"

    iget-object v8, p0, Lcom/kochava/android/tracker/Feature;->mAppId:Ljava/lang/String;

    invoke-virtual {v1, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1579
    const-string v7, "kochava_device_id"

    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getDeviceId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v1, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1580
    const-string v7, "action"

    invoke-virtual {v1, v7, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1581
    const-string v7, "dev_id_strategy"

    iget-object v8, p0, Lcom/kochava/android/tracker/Feature;->mKochDevIDStrategy:Ljava/lang/String;

    invoke-virtual {v1, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1582
    const-string v7, "last_post_time"

    const/4 v8, 0x0

    invoke-virtual {v1, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 1583
    iget-object v7, p0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    const-string v8, "initPrefs"

    const/4 v9, 0x0

    invoke-virtual {v7, v8, v9}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v7

    iput-object v7, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    .line 1584
    const-string v7, "currency"

    iget-object v8, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    const-string v9, "currency"

    const-string v10, "USD"

    invoke-interface {v8, v9, v10}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v1, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1585
    new-instance v7, Lorg/json/JSONObject;

    invoke-direct {v7}, Lorg/json/JSONObject;-><init>()V

    invoke-direct {p0, v7}, Lcom/kochava/android/tracker/Feature;->addGlobalProperties(Lorg/json/JSONObject;)Lorg/json/JSONObject;

    move-result-object v5

    .line 1587
    .local v5, "propertiesObj":Lorg/json/JSONObject;
    sget-boolean v7, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v7, :cond_2

    const-string v7, "KochavaTracker"

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "fireEvent with properties: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1589
    :cond_2
    const-string v7, "initial"

    invoke-virtual {p1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_e

    .line 1591
    sget-boolean v7, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v7, :cond_3

    const-string v7, "KochavaTracker"

    const-string v8, "Event is initial, or initial did not get que\'d on first load"

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    .line 1595
    :cond_3
    :try_start_1
    const-string v7, "sdk_version"

    const-string v8, "Android20140428"

    invoke-virtual {v1, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1596
    const-string v7, "ifdg"

    sget-object v8, Lcom/kochava/android/tracker/Feature;->advertisingID:Ljava/lang/String;

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1597
    const-string v7, "geid"

    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getGmailAccounts()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1598
    const-string v7, "first_run"

    new-instance v8, Ljava/lang/StringBuilder;

    sget v9, Lcom/kochava/android/tracker/Feature;->first_run:I

    invoke-static {v9}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1599
    const-string v7, "device"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getModel()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v9, "-"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getCarrier()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1600
    sget-object v7, Lcom/kochava/android/tracker/Feature;->paramRestrictions:Ljava/util/HashMap;

    const-string v8, "imei"

    invoke-virtual {v7, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Boolean;

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-eqz v7, :cond_4

    const-string v7, "imei"

    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getIMEI()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1601
    :cond_4
    const-string v7, "disp_h"

    iget v8, p0, Lcom/kochava/android/tracker/Feature;->mDisplayHeight:I

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 1602
    const-string v7, "disp_w"

    iget v8, p0, Lcom/kochava/android/tracker/Feature;->mDisplayWidth:I

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 1603
    const-string v7, "package_name"

    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getAppPackageName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1604
    const-string v7, "app_version"

    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getAppVersion()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1605
    iget-object v7, p0, Lcom/kochava/android/tracker/Feature;->mAppVersionName:Ljava/lang/String;

    const-string v8, ""

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_5

    const-string v7, "app_short_string"

    iget-object v8, p0, Lcom/kochava/android/tracker/Feature;->mAppVersionName:Ljava/lang/String;

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1606
    :cond_5
    sget-object v7, Lcom/kochava/android/tracker/Feature;->paramRestrictions:Ljava/util/HashMap;

    const-string v8, "android_id"

    invoke-virtual {v7, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Boolean;

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-eqz v7, :cond_6

    const-string v7, "android_id"

    iget-object v8, p0, Lcom/kochava/android/tracker/Feature;->mAndroidID:Ljava/lang/String;

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1607
    :cond_6
    const-string v7, "env_hash"

    iget-object v8, p0, Lcom/kochava/android/tracker/Feature;->mEnvDeviceID:Ljava/lang/String;

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1608
    const-string v7, "os_version"

    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getOSVersion()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1610
    sget-object v7, Lcom/kochava/android/tracker/Feature;->identityLinkMapJSON:Lorg/json/JSONObject;

    if-eqz v7, :cond_7

    .line 1612
    const-string v7, "identity_link"

    sget-object v8, Lcom/kochava/android/tracker/Feature;->identityLinkMapJSON:Lorg/json/JSONObject;

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1615
    :cond_7
    sget-object v7, Lcom/kochava/android/tracker/Feature;->paramRestrictions:Ljava/util/HashMap;

    const-string v8, "odin"

    invoke-virtual {v7, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Boolean;

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-eqz v7, :cond_8

    const-string v7, "odin"

    invoke-direct {p0}, Lcom/kochava/android/tracker/Feature;->getOdin()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1616
    :cond_8
    sget-object v7, Lcom/kochava/android/tracker/Feature;->paramRestrictions:Ljava/util/HashMap;

    const-string v8, "mac"

    invoke-virtual {v7, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Boolean;

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-eqz v7, :cond_9

    const-string v7, "mac"

    iget-object v8, p0, Lcom/kochava/android/tracker/Feature;->mMacAddr:Ljava/lang/String;

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1618
    :cond_9
    sget-object v7, Lcom/kochava/android/tracker/Feature;->paramRestrictions:Ljava/util/HashMap;

    const-string v8, "fb_attribution_id"

    invoke-virtual {v7, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Boolean;

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-eqz v7, :cond_a

    .line 1620
    iget-object v7, p0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v7

    invoke-static {v7}, Lcom/kochava/android/tracker/Feature;->getAttributionId(Landroid/content/ContentResolver;)Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/kochava/android/tracker/Feature;->mFbId:Ljava/lang/String;

    .line 1621
    iget-object v7, p0, Lcom/kochava/android/tracker/Feature;->mFbId:Ljava/lang/String;

    if-nez v7, :cond_c

    .line 1622
    const-string v7, "fb_attribution_id"

    const-string v8, ""

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1627
    :cond_a
    :goto_0
    iget-object v7, p0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    const-string v8, "window"

    invoke-virtual {v7, v8}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/view/WindowManager;

    .line 1628
    .local v6, "wm":Landroid/view/WindowManager;
    new-instance v4, Landroid/util/DisplayMetrics;

    invoke-direct {v4}, Landroid/util/DisplayMetrics;-><init>()V

    .line 1629
    .local v4, "metrics":Landroid/util/DisplayMetrics;
    invoke-interface {v6}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v7

    invoke-virtual {v7, v4}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 1631
    iput-object v5, p0, Lcom/kochava/android/tracker/Feature;->initialPropertiesObject:Lorg/json/JSONObject;

    .line 1632
    iput-object v1, p0, Lcom/kochava/android/tracker/Feature;->initialObject:Lorg/json/JSONObject;

    .line 1634
    sget-boolean v7, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v7, :cond_b

    const-string v7, "KochavaTracker"

    const-string v8, "Initial Event, saving until next event. "

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1687
    .end local v4    # "metrics":Landroid/util/DisplayMetrics;
    .end local v5    # "propertiesObj":Lorg/json/JSONObject;
    .end local v6    # "wm":Landroid/view/WindowManager;
    :cond_b
    :goto_1
    return-void

    .line 1624
    .restart local v5    # "propertiesObj":Lorg/json/JSONObject;
    :cond_c
    const-string v7, "fb_attribution_id"

    iget-object v8, p0, Lcom/kochava/android/tracker/Feature;->mFbId:Ljava/lang/String;

    invoke-virtual {v5, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    goto :goto_0

    .line 1638
    :catch_0
    move-exception v2

    .line 1640
    .local v2, "e":Lorg/json/JSONException;
    :try_start_2
    invoke-virtual {v2}, Lorg/json/JSONException;->printStackTrace()V

    .line 1641
    sget-boolean v7, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v7, :cond_b

    const-string v7, "KochavaTracker"

    const-string v8, "event"

    invoke-static {v7, v8, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1

    .line 1669
    .end local v2    # "e":Lorg/json/JSONException;
    .end local v5    # "propertiesObj":Lorg/json/JSONObject;
    :catch_1
    move-exception v2

    .line 1671
    .restart local v2    # "e":Lorg/json/JSONException;
    invoke-virtual {v2}, Lorg/json/JSONException;->printStackTrace()V

    .line 1672
    sget-boolean v7, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v7, :cond_b

    const-string v7, "KochavaTracker"

    const-string v8, "event"

    invoke-static {v7, v8, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1

    .line 1646
    .end local v2    # "e":Lorg/json/JSONException;
    .restart local v5    # "propertiesObj":Lorg/json/JSONObject;
    :catch_2
    move-exception v2

    .line 1648
    .local v2, "e":Ljava/lang/Exception;
    :try_start_3
    sget-boolean v7, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v7, :cond_d

    const-string v7, "KochavaTracker"

    const-string v8, "Error during fireEvent - Please review stack trace"

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1649
    :cond_d
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    .line 1652
    .end local v2    # "e":Ljava/lang/Exception;
    :cond_e
    :goto_2
    iget-object v7, p0, Lcom/kochava/android/tracker/Feature;->mSuperProperties:Ljava/util/Map;

    if-eqz v7, :cond_f

    .line 1654
    iget-object v7, p0, Lcom/kochava/android/tracker/Feature;->mSuperProperties:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_3
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_13

    .line 1660
    :cond_f
    if-eqz p2, :cond_10

    .line 1662
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_4
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_14

    .line 1667
    :cond_10
    const-string v7, "data"

    invoke-virtual {v1, v7, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_1

    .line 1677
    const/4 v7, 0x1

    invoke-direct {p0, v7}, Lcom/kochava/android/tracker/Feature;->queInitial(Z)V

    .line 1680
    iget-object v7, p0, Lcom/kochava/android/tracker/Feature;->kDbAdapter:Lcom/kochava/android/tracker/KochavaDbAdapter;

    invoke-virtual {v7, v1}, Lcom/kochava/android/tracker/KochavaDbAdapter;->addEvent(Lorg/json/JSONObject;)I

    move-result v0

    .line 1682
    .local v0, "count":I
    sget-boolean v7, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v7, :cond_11

    .line 1683
    const-string v7, "KochavaTracker"

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "@@@@@ mTestMode = "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-boolean v9, p0, Lcom/kochava/android/tracker/Feature;->mTestMode:Z

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1685
    :cond_11
    iget-boolean v7, p0, Lcom/kochava/android/tracker/Feature;->mTestMode:Z

    if-nez v7, :cond_12

    const/16 v7, 0x28

    if-lt v0, v7, :cond_b

    .line 1686
    :cond_12
    invoke-virtual {p0}, Lcom/kochava/android/tracker/Feature;->flush()V

    goto/16 :goto_1

    .line 1654
    .end local v0    # "count":I
    :cond_13
    :try_start_4
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 1656
    .local v3, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v5, v7, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_3

    .line 1662
    .end local v3    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_14
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 1664
    .restart local v3    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v5, v7, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_4

    .line 1645
    .end local v3    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :catch_3
    move-exception v7

    goto/16 :goto_2

    .line 1644
    :catch_4
    move-exception v7

    goto/16 :goto_2
.end method

.method private getAd(Landroid/webkit/WebView;Landroid/app/Activity;II)V
    .locals 9
    .param p1, "adWebview"    # Landroid/webkit/WebView;
    .param p2, "context"    # Landroid/app/Activity;
    .param p3, "height"    # I
    .param p4, "width"    # I

    .prologue
    .line 2049
    iget-boolean v1, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    if-eqz v1, :cond_1

    .line 2051
    sget-boolean v1, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v1, :cond_0

    const-string v1, "KochavaTracker"

    const-string v2, "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2272
    :cond_0
    :goto_0
    return-void

    .line 2055
    :cond_1
    new-instance v7, Landroid/content/ComponentName;

    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    const-class v2, Lcom/kochava/android/tracker/KochavaWebAdView;

    invoke-direct {v7, v1, v2}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2058
    .local v7, "cn":Landroid/content/ComponentName;
    :try_start_0
    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v7, v2}, Landroid/content/pm/PackageManager;->getActivityInfo(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;

    move-result-object v6

    .line 2059
    .local v6, "ai":Landroid/content/pm/ActivityInfo;
    sget-boolean v1, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v1, :cond_2

    const-string v1, "KochavaTracker"

    const-string v2, "Ad activity registered."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 2072
    .end local v6    # "ai":Landroid/content/pm/ActivityInfo;
    :cond_2
    :goto_1
    new-instance v0, Lcom/kochava/android/tracker/Feature$6;

    move-object v1, p0

    move-object v2, p2

    move v3, p4

    move v4, p3

    move-object v5, p1

    invoke-direct/range {v0 .. v5}, Lcom/kochava/android/tracker/Feature$6;-><init>(Lcom/kochava/android/tracker/Feature;Landroid/app/Activity;IILandroid/webkit/WebView;)V

    .line 2269
    .local v0, "getResponse":Ljava/lang/Thread;
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    goto :goto_0

    .line 2061
    .end local v0    # "getResponse":Ljava/lang/Thread;
    :catch_0
    move-exception v8

    .line 2064
    .local v8, "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    sget-boolean v1, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v1, :cond_3

    const-string v1, "KochavaRequirements"

    const-string v2, "KOCHAVAWEBADVIEW ACTIVITY REGISTRATION MISSING: com.kochava.android.tracker.KochavaWebAdView"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2065
    :cond_3
    sget-boolean v1, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v1, :cond_2

    const-string v1, "KochavaRequirements"

    const-string v2, "**NOTICE** It appears you are trying to use Kochava ads but have not registered our ad view activity. Please refer to the Kochava documentation for instructions on how to do this."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method

.method private getAdvertisingId()Ljava/lang/String;
    .locals 6

    .prologue
    .line 2471
    :try_start_0
    iget-object v3, p0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->isGooglePlayServicesAvailable(Landroid/content/Context;)I

    move-result v1

    .line 2472
    .local v1, "availableCode":I
    if-eqz v1, :cond_1

    .line 2474
    sget-boolean v3, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v3, :cond_0

    const-string v3, "KochavaTracker"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Problem getting Advertising ID "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->getErrorString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 2475
    :cond_0
    const-string v3, "not_available"

    .line 2498
    .end local v1    # "availableCode":I
    :goto_0
    return-object v3

    .line 2478
    .restart local v1    # "availableCode":I
    :cond_1
    const/4 v0, 0x0

    .line 2481
    .local v0, "adInfo":Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    :try_start_1
    iget-object v3, p0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/google/android/gms/ads/identifier/AdvertisingIdClient;->getAdvertisingIdInfo(Landroid/content/Context;)Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;

    move-result-object v0

    .line 2482
    invoke-virtual {v0}, Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;->isLimitAdTrackingEnabled()Z

    move-result v3

    if-nez v3, :cond_2

    .line 2484
    invoke-virtual {v0}, Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;->getId()Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 2488
    :cond_2
    sget-boolean v3, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v3, :cond_3

    const-string v3, "KochavaTracker"

    const-string v4, "User has Google ID disabled."

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 2489
    :cond_3
    const-string v3, "user_disabled"

    goto :goto_0

    .line 2493
    .end local v0    # "adInfo":Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    .end local v1    # "availableCode":I
    :catch_0
    move-exception v2

    .line 2495
    .local v2, "e":Ljava/lang/Exception;
    sget-boolean v3, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v3, :cond_4

    const-string v3, "KochavaTracker"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Problem getting Advertising ID "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2498
    :cond_4
    const-string v3, "not_available"

    goto :goto_0
.end method

.method private getAppPackageName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1764
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->mAppPackageName:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 1766
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->mAppPackageName:Ljava/lang/String;

    .line 1768
    :goto_0
    return-object v0

    :cond_0
    const-string v0, "Unknown"

    goto :goto_0
.end method

.method private getAppVersion()Ljava/lang/String;
    .locals 2

    .prologue
    .line 1777
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->mAppName:Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->mAppVersionCode:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected static getAttributionId(Landroid/content/ContentResolver;)Ljava/lang/String;
    .locals 10
    .param p0, "contentResolver"    # Landroid/content/ContentResolver;

    .prologue
    const/4 v9, 0x0

    .line 2448
    const/4 v6, 0x0

    .line 2451
    .local v6, "attributionId":Ljava/lang/String;
    const/4 v0, 0x1

    :try_start_0
    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "aid"

    aput-object v1, v2, v0

    .line 2452
    .local v2, "projection":[Ljava/lang/String;
    sget-object v1, Lcom/kochava/android/tracker/Feature;->ATTRIBUTION_ID_CONTENT_URI:Landroid/net/Uri;

    const/4 v3, 0x0

    const/4 v4, 0x0

    .line 2453
    const/4 v5, 0x0

    move-object v0, p0

    .line 2452
    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 2454
    .local v7, "c":Landroid/database/Cursor;
    if-eqz v7, :cond_0

    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    move-object v0, v9

    .line 2464
    .end local v2    # "projection":[Ljava/lang/String;
    .end local v7    # "c":Landroid/database/Cursor;
    :goto_0
    return-object v0

    .line 2457
    .restart local v2    # "projection":[Ljava/lang/String;
    .restart local v7    # "c":Landroid/database/Cursor;
    :cond_1
    const-string v0, "aid"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .end local v2    # "projection":[Ljava/lang/String;
    .end local v7    # "c":Landroid/database/Cursor;
    :cond_2
    :goto_1
    move-object v0, v6

    .line 2464
    goto :goto_0

    .line 2459
    :catch_0
    move-exception v8

    .line 2461
    .local v8, "e":Ljava/lang/Exception;
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v0, :cond_2

    const-string v0, "KochavaTracker"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "Problem getting FB attribution ID "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method

.method private getCarrier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1722
    sget-object v0, Landroid/os/Build;->BRAND:Ljava/lang/String;

    return-object v0
.end method

.method private getDeviceId()Ljava/lang/String;
    .locals 6

    .prologue
    .line 1789
    iget-object v4, p0, Lcom/kochava/android/tracker/Feature;->mMacAddr:Ljava/lang/String;

    if-eqz v4, :cond_1

    const-string v4, ""

    iget-object v5, p0, Lcom/kochava/android/tracker/Feature;->mMacAddr:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 1793
    const-string v4, "1"

    iput-object v4, p0, Lcom/kochava/android/tracker/Feature;->mKochDevIDStrategy:Ljava/lang/String;

    .line 1800
    :try_start_0
    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->mMacAddr:Ljava/lang/String;

    .line 1802
    .local v1, "mMacAddrHashed":Ljava/lang/String;
    const-string v4, ":"

    const-string v5, "k"

    invoke-virtual {v1, v4, v5}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1803
    const-string v4, ":"

    const-string v5, "o"

    invoke-virtual {v1, v4, v5}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1804
    const-string v4, ":"

    const-string v5, "c"

    invoke-virtual {v1, v4, v5}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1805
    const-string v4, ":"

    const-string v5, "h"

    invoke-virtual {v1, v4, v5}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1806
    const-string v4, ":"

    const-string v5, "a"

    invoke-virtual {v1, v4, v5}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1810
    const-string v4, "MD5"

    invoke-static {v4}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v2

    .line 1811
    .local v2, "md5":Ljava/security/MessageDigest;
    invoke-virtual {v2}, Ljava/security/MessageDigest;->reset()V

    .line 1812
    invoke-virtual {v1}, Ljava/lang/String;->getBytes()[B

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/security/MessageDigest;->update([B)V

    .line 1813
    new-instance v0, Ljava/math/BigInteger;

    const/4 v4, 0x1

    invoke-virtual {v2}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v5

    invoke-direct {v0, v4, v5}, Ljava/math/BigInteger;-><init>(I[B)V

    .line 1814
    .local v0, "hash":Ljava/math/BigInteger;
    const/16 v4, 0x10

    invoke-virtual {v0, v4}, Ljava/math/BigInteger;->toString(I)Ljava/lang/String;

    move-result-object v1

    .line 1816
    :goto_0
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    const/16 v5, 0x20

    if-lt v4, v5, :cond_0

    .line 1820
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "KV"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 1840
    .end local v0    # "hash":Ljava/math/BigInteger;
    .end local v1    # "mMacAddrHashed":Ljava/lang/String;
    .end local v2    # "md5":Ljava/security/MessageDigest;
    :goto_1
    return-object v4

    .line 1817
    .restart local v0    # "hash":Ljava/math/BigInteger;
    .restart local v1    # "mMacAddrHashed":Ljava/lang/String;
    .restart local v2    # "md5":Ljava/security/MessageDigest;
    :cond_0
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "0"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 1822
    .end local v0    # "hash":Ljava/math/BigInteger;
    .end local v1    # "mMacAddrHashed":Ljava/lang/String;
    .end local v2    # "md5":Ljava/security/MessageDigest;
    :catch_0
    move-exception v3

    .line 1824
    .local v3, "nsae":Ljava/security/NoSuchAlgorithmException;
    iget-object v4, p0, Lcom/kochava/android/tracker/Feature;->mMacAddr:Ljava/lang/String;

    goto :goto_1

    .line 1829
    .end local v3    # "nsae":Ljava/security/NoSuchAlgorithmException;
    :cond_1
    iget-object v4, p0, Lcom/kochava/android/tracker/Feature;->mIMEI:Ljava/lang/String;

    if-eqz v4, :cond_3

    const-string v4, ""

    iget-object v5, p0, Lcom/kochava/android/tracker/Feature;->mIMEI:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 1831
    const-string v4, "2"

    iput-object v4, p0, Lcom/kochava/android/tracker/Feature;->mKochDevIDStrategy:Ljava/lang/String;

    .line 1832
    const-string v4, "000000000000000"

    iget-object v5, p0, Lcom/kochava/android/tracker/Feature;->mIMEI:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 1834
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "00"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/kochava/android/tracker/Feature;->mIMEI:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    .line 1836
    :cond_2
    iget-object v4, p0, Lcom/kochava/android/tracker/Feature;->mIMEI:Ljava/lang/String;

    goto :goto_1

    .line 1839
    :cond_3
    const-string v4, "3"

    iput-object v4, p0, Lcom/kochava/android/tracker/Feature;->mKochDevIDStrategy:Ljava/lang/String;

    .line 1840
    iget-object v4, p0, Lcom/kochava/android/tracker/Feature;->mEnvDeviceID:Ljava/lang/String;

    goto :goto_1
.end method

.method private getGmailAccounts()Ljava/lang/String;
    .locals 13

    .prologue
    const/4 v9, 0x0

    .line 2322
    const-string v5, ""

    .line 2324
    .local v5, "email":Ljava/lang/String;
    iget-object v8, p0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    const-string v10, "android.permission.GET_ACCOUNTS"

    invoke-virtual {v8, v10}, Landroid/content/Context;->checkCallingOrSelfPermission(Ljava/lang/String;)I

    move-result v3

    .line 2326
    .local v3, "check":I
    const-string v1, ""

    .line 2329
    .local v1, "accountHolder":Ljava/lang/String;
    if-nez v3, :cond_4

    .line 2331
    iget-object v8, p0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    invoke-static {v8}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v8

    invoke-virtual {v8}, Landroid/accounts/AccountManager;->getAccounts()[Landroid/accounts/Account;

    move-result-object v2

    .line 2332
    .local v2, "accounts":[Landroid/accounts/Account;
    array-length v10, v2

    move v8, v9

    :goto_0
    if-lt v8, v10, :cond_1

    .line 2374
    .end local v2    # "accounts":[Landroid/accounts/Account;
    :goto_1
    invoke-virtual {v5}, Ljava/lang/String;->isEmpty()Z

    move-result v8

    if-eqz v8, :cond_0

    .line 2375
    const-string v5, "not_available"

    .line 2376
    :cond_0
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "["

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "]"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 2377
    return-object v5

    .line 2332
    .restart local v2    # "accounts":[Landroid/accounts/Account;
    :cond_1
    aget-object v0, v2, v8

    .line 2334
    .local v0, "account":Landroid/accounts/Account;
    iget-object v11, v0, Landroid/accounts/Account;->type:Ljava/lang/String;

    const-string v12, "com.google"

    invoke-virtual {v11, v12}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_2

    .line 2339
    iget-object v11, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v11}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    .line 2344
    :try_start_0
    const-string v11, "MD5"

    invoke-static {v11}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v7

    .line 2345
    .local v7, "md5":Ljava/security/MessageDigest;
    invoke-virtual {v7}, Ljava/security/MessageDigest;->reset()V

    .line 2346
    invoke-virtual {v1}, Ljava/lang/String;->getBytes()[B

    move-result-object v11

    invoke-virtual {v7, v11}, Ljava/security/MessageDigest;->update([B)V

    .line 2347
    new-instance v6, Ljava/math/BigInteger;

    const/4 v11, 0x1

    invoke-virtual {v7}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v12

    invoke-direct {v6, v11, v12}, Ljava/math/BigInteger;-><init>(I[B)V

    .line 2348
    .local v6, "hash":Ljava/math/BigInteger;
    const/16 v11, 0x10

    invoke-virtual {v6, v11}, Ljava/math/BigInteger;->toString(I)Ljava/lang/String;

    move-result-object v1

    .line 2350
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, ","

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 2361
    .end local v6    # "hash":Ljava/math/BigInteger;
    .end local v7    # "md5":Ljava/security/MessageDigest;
    :cond_2
    :goto_2
    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/String;->length()I

    move-result v11

    if-lez v11, :cond_3

    .line 2362
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v11

    add-int/lit8 v11, v11, -0x1

    invoke-virtual {v5, v9, v11}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    .line 2332
    :goto_3
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 2353
    :catch_0
    move-exception v4

    .line 2356
    .local v4, "e":Ljava/security/NoSuchAlgorithmException;
    sget-boolean v11, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v11, :cond_2

    const-string v11, "KochavaTracker"

    invoke-virtual {v4}, Ljava/security/NoSuchAlgorithmException;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2

    .line 2364
    .end local v4    # "e":Ljava/security/NoSuchAlgorithmException;
    :cond_3
    const-string v5, "empty"

    goto :goto_3

    .line 2371
    .end local v0    # "account":Landroid/accounts/Account;
    .end local v2    # "accounts":[Landroid/accounts/Account;
    :cond_4
    const-string v5, "permission_missing"

    goto/16 :goto_1
.end method

.method private getIMEI()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1782
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->mIMEI:Ljava/lang/String;

    return-object v0
.end method

.method private getModel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1731
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    return-object v0
.end method

.method private getOSVersion()Ljava/lang/String;
    .locals 2

    .prologue
    .line 1740
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Android "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v1, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getOdin()Ljava/lang/String;
    .locals 11
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 1847
    iget-object v8, p0, Lcom/kochava/android/tracker/Feature;->mMacAddr:Ljava/lang/String;

    if-eqz v8, :cond_2

    const-string v8, ""

    iget-object v9, p0, Lcom/kochava/android/tracker/Feature;->mMacAddr:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_2

    .line 1849
    const-string v4, ""

    .line 1853
    .local v4, "odin":Ljava/lang/String;
    const-string v8, "SHA-1"

    invoke-static {v8}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v3

    .line 1854
    .local v3, "md":Ljava/security/MessageDigest;
    const/16 v8, 0x28

    new-array v5, v8, [B

    .line 1855
    .local v5, "sha1hash":[B
    iget-object v8, p0, Lcom/kochava/android/tracker/Feature;->mMacAddr:Ljava/lang/String;

    const-string v9, "iso-8859-1"

    invoke-virtual {v8, v9}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v8

    const/4 v9, 0x0

    iget-object v10, p0, Lcom/kochava/android/tracker/Feature;->mMacAddr:Ljava/lang/String;

    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v10

    invoke-virtual {v3, v8, v9, v10}, Ljava/security/MessageDigest;->update([BII)V

    .line 1856
    invoke-virtual {v3}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v5

    .line 1860
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 1861
    .local v0, "buf":Ljava/lang/StringBuffer;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v8, v5

    if-lt v2, v8, :cond_0

    .line 1876
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    .line 1882
    .end local v0    # "buf":Ljava/lang/StringBuffer;
    .end local v2    # "i":I
    .end local v3    # "md":Ljava/security/MessageDigest;
    .end local v4    # "odin":Ljava/lang/String;
    .end local v5    # "sha1hash":[B
    :goto_1
    return-object v4

    .line 1863
    .restart local v0    # "buf":Ljava/lang/StringBuffer;
    .restart local v2    # "i":I
    .restart local v3    # "md":Ljava/security/MessageDigest;
    .restart local v4    # "odin":Ljava/lang/String;
    .restart local v5    # "sha1hash":[B
    :cond_0
    aget-byte v8, v5, v2

    ushr-int/lit8 v8, v8, 0x4

    and-int/lit8 v1, v8, 0xf

    .line 1864
    .local v1, "halfbyte":I
    const/4 v6, 0x0

    .local v6, "two_halfs":I
    move v7, v6

    .line 1867
    .end local v6    # "two_halfs":I
    .local v7, "two_halfs":I
    :goto_2
    if-ltz v1, :cond_1

    const/16 v8, 0x9

    if-gt v1, v8, :cond_1

    .line 1868
    add-int/lit8 v8, v1, 0x30

    int-to-char v8, v8

    invoke-virtual {v0, v8}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 1872
    :goto_3
    aget-byte v8, v5, v2

    and-int/lit8 v1, v8, 0xf

    .line 1873
    add-int/lit8 v6, v7, 0x1

    .end local v7    # "two_halfs":I
    .restart local v6    # "two_halfs":I
    const/4 v8, 0x1

    .line 1865
    if-lt v7, v8, :cond_3

    .line 1861
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 1870
    .end local v6    # "two_halfs":I
    .restart local v7    # "two_halfs":I
    :cond_1
    add-int/lit8 v8, v1, -0xa

    add-int/lit8 v8, v8, 0x61

    int-to-char v8, v8

    invoke-virtual {v0, v8}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_3

    .line 1882
    .end local v0    # "buf":Ljava/lang/StringBuffer;
    .end local v1    # "halfbyte":I
    .end local v2    # "i":I
    .end local v3    # "md":Ljava/security/MessageDigest;
    .end local v4    # "odin":Ljava/lang/String;
    .end local v5    # "sha1hash":[B
    .end local v7    # "two_halfs":I
    :cond_2
    const-string v4, ""

    goto :goto_1

    .restart local v0    # "buf":Ljava/lang/StringBuffer;
    .restart local v1    # "halfbyte":I
    .restart local v2    # "i":I
    .restart local v3    # "md":Ljava/security/MessageDigest;
    .restart local v4    # "odin":Ljava/lang/String;
    .restart local v5    # "sha1hash":[B
    .restart local v6    # "two_halfs":I
    :cond_3
    move v7, v6

    .end local v6    # "two_halfs":I
    .restart local v7    # "two_halfs":I
    goto :goto_2
.end method

.method private getUserAgent()Ljava/lang/String;
    .locals 15

    .prologue
    const/4 v14, 0x0

    .line 2382
    const-string v8, ""

    .line 2383
    .local v8, "userAgent":Ljava/lang/String;
    const-string v9, ""

    .line 2387
    .local v9, "userAgentResult":Ljava/lang/String;
    :try_start_0
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v11, "\nTrying user agent method 1"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 2388
    const-string v10, "http.agent"

    invoke-static {v10}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v8

    .line 2439
    :cond_0
    :goto_0
    invoke-virtual {v8}, Ljava/lang/String;->isEmpty()Z

    move-result v10

    if-eqz v10, :cond_1

    const-string v8, "error"

    .line 2440
    :cond_1
    sget-boolean v10, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v10, :cond_2

    const-string v10, "KochavaTracker"

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "user agent result: "

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 2442
    :cond_2
    return-object v8

    .line 2390
    :catch_0
    move-exception v1

    .line 2393
    .local v1, "e":Ljava/lang/Exception;
    new-instance v5, Ljava/io/StringWriter;

    invoke-direct {v5}, Ljava/io/StringWriter;-><init>()V

    .line 2394
    .local v5, "sw":Ljava/io/StringWriter;
    new-instance v10, Ljava/io/PrintWriter;

    invoke-direct {v10, v5}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V

    invoke-virtual {v1, v10}, Ljava/lang/Exception;->printStackTrace(Ljava/io/PrintWriter;)V

    .line 2395
    sget-boolean v10, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v10, :cond_3

    const-string v10, "KochavaTracker"

    invoke-virtual {v5}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2396
    :cond_3
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v11, "\nError with user agent first method: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "\n"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v5}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 2400
    :try_start_1
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v11, "\nTrying user agent method 2"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 2401
    new-instance v10, Landroid/webkit/WebView;

    iget-object v11, p0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    invoke-direct {v10, v11}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    invoke-virtual {v10}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v10

    invoke-virtual {v10}, Landroid/webkit/WebSettings;->getUserAgentString()Ljava/lang/String;

    move-result-object v8

    .line 2402
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v11, "\nMethod 2 successful"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v9

    goto/16 :goto_0

    .line 2404
    :catch_1
    move-exception v2

    .line 2407
    .local v2, "ex":Ljava/lang/Exception;
    new-instance v6, Ljava/io/StringWriter;

    invoke-direct {v6}, Ljava/io/StringWriter;-><init>()V

    .line 2408
    .local v6, "sw2":Ljava/io/StringWriter;
    new-instance v10, Ljava/io/PrintWriter;

    invoke-direct {v10, v6}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V

    invoke-virtual {v2, v10}, Ljava/lang/Exception;->printStackTrace(Ljava/io/PrintWriter;)V

    .line 2409
    sget-boolean v10, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v10, :cond_4

    const-string v10, "KochavaTracker"

    invoke-virtual {v6}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2410
    :cond_4
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v11, "\nError with user agent second method: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "\n"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v6}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "\n userAgent = error."

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 2412
    const/4 v0, 0x0

    .line 2415
    .local v0, "constructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<Landroid/webkit/WebSettings;>;"
    :try_start_2
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v11, "\nTrying user agent method 3"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 2416
    const-class v10, Landroid/webkit/WebSettings;

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Class;

    const/4 v12, 0x0

    const-class v13, Landroid/content/Context;

    aput-object v13, v11, v12

    const/4 v12, 0x1

    const-class v13, Landroid/webkit/WebView;

    aput-object v13, v11, v12

    invoke-virtual {v10, v11}, Ljava/lang/Class;->getDeclaredConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v0

    .line 2417
    const/4 v10, 0x1

    invoke-virtual {v0, v10}, Ljava/lang/reflect/Constructor;->setAccessible(Z)V

    .line 2418
    const/4 v10, 0x2

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    iget-object v12, p0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    aput-object v12, v10, v11

    const/4 v11, 0x1

    const/4 v12, 0x0

    aput-object v12, v10, v11

    invoke-virtual {v0, v10}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/webkit/WebSettings;

    .line 2419
    .local v4, "settings":Landroid/webkit/WebSettings;
    invoke-virtual {v4}, Landroid/webkit/WebSettings;->getUserAgentString()Ljava/lang/String;

    move-result-object v8

    .line 2420
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v11, "\nMethod 3 successful."

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v9

    .line 2431
    if-eqz v0, :cond_0

    .line 2432
    invoke-virtual {v0, v14}, Ljava/lang/reflect/Constructor;->setAccessible(Z)V

    goto/16 :goto_0

    .line 2422
    .end local v4    # "settings":Landroid/webkit/WebSettings;
    :catch_2
    move-exception v3

    .line 2424
    .local v3, "ex2":Ljava/lang/Exception;
    :try_start_3
    new-instance v7, Ljava/io/StringWriter;

    invoke-direct {v7}, Ljava/io/StringWriter;-><init>()V

    .line 2425
    .local v7, "sw3":Ljava/io/StringWriter;
    new-instance v10, Ljava/io/PrintWriter;

    invoke-direct {v10, v7}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V

    invoke-virtual {v3, v10}, Ljava/lang/Exception;->printStackTrace(Ljava/io/PrintWriter;)V

    .line 2426
    sget-boolean v10, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v10, :cond_5

    const-string v10, "KochavaTracker"

    invoke-virtual {v7}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2427
    :cond_5
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v11, "\nError with user agent third method: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v3}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "\n"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v7}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "\n userAgent = error."

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v9

    .line 2431
    if-eqz v0, :cond_0

    .line 2432
    invoke-virtual {v0, v14}, Ljava/lang/reflect/Constructor;->setAccessible(Z)V

    goto/16 :goto_0

    .line 2430
    .end local v3    # "ex2":Ljava/lang/Exception;
    .end local v7    # "sw3":Ljava/io/StringWriter;
    :catchall_0
    move-exception v10

    .line 2431
    if-eqz v0, :cond_6

    .line 2432
    invoke-virtual {v0, v14}, Ljava/lang/reflect/Constructor;->setAccessible(Z)V

    .line 2433
    :cond_6
    throw v10
.end method

.method private haveAttributionData()Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 1745
    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->attributionDataPrefs:Landroid/content/SharedPreferences;

    if-eqz v1, :cond_0

    .line 1747
    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->attributionDataPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->getAll()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Map;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1750
    :cond_0
    :goto_0
    return v0

    .line 1747
    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private init(Landroid/content/Context;ZLjava/util/HashMap;)V
    .locals 29
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "sendOnStart"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Z",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 308
    .local p3, "datamap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    sget-boolean v24, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v24, :cond_0

    const-string v24, "KochavaTracker"

    const-string v25, "Feature initialization"

    invoke-static/range {v24 .. v25}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 311
    :cond_0
    if-eqz p1, :cond_11

    .line 312
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    .line 326
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v24

    invoke-static/range {v24 .. v24}, Lcom/kochava/android/tracker/Feature;->getAttributionId(Landroid/content/ContentResolver;)Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v24

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/kochava/android/tracker/Feature;->mFbId:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_7

    .line 333
    :goto_0
    new-instance v21, Lcom/kochava/android/tracker/Feature$3;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/kochava/android/tracker/Feature$3;-><init>(Lcom/kochava/android/tracker/Feature;)V

    .line 351
    .local v21, "task":Landroid/os/AsyncTask;, "Landroid/os/AsyncTask<Ljava/lang/Void;Ljava/lang/Void;Ljava/lang/String;>;"
    const/16 v24, 0x0

    move/from16 v0, v24

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v24, v0

    move-object/from16 v0, v21

    instance-of v0, v0, Landroid/os/AsyncTask;

    move/from16 v25, v0

    if-nez v25, :cond_12

    move-object/from16 v0, v21

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/os/AsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 355
    .end local v21    # "task":Landroid/os/AsyncTask;, "Landroid/os/AsyncTask<Ljava/lang/Void;Ljava/lang/Void;Ljava/lang/String;>;"
    :goto_1
    new-instance v24, Lcom/kochava/android/tracker/KochavaDbAdapter;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v25, v0

    invoke-direct/range {v24 .. v25}, Lcom/kochava/android/tracker/KochavaDbAdapter;-><init>(Landroid/content/Context;)V

    move-object/from16 v0, v24

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/kochava/android/tracker/Feature;->kDbAdapter:Lcom/kochava/android/tracker/KochavaDbAdapter;

    .line 359
    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v24

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v25

    const/16 v26, 0x0

    invoke-virtual/range {v24 .. v26}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v24

    move-object/from16 v0, v24

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/kochava/android/tracker/Feature;->mAppPackageName:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_6

    .line 363
    :goto_2
    new-instance v24, Lorg/json/JSONObject;

    invoke-direct/range {v24 .. v24}, Lorg/json/JSONObject;-><init>()V

    move-object/from16 v0, v24

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/kochava/android/tracker/Feature;->kvinitdata:Lorg/json/JSONObject;

    .line 364
    new-instance v24, Lorg/json/JSONObject;

    invoke-direct/range {v24 .. v24}, Lorg/json/JSONObject;-><init>()V

    move-object/from16 v0, v24

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/kochava/android/tracker/Feature;->kvinitdataholder:Lorg/json/JSONObject;

    .line 365
    new-instance v24, Lorg/json/JSONObject;

    invoke-direct/range {v24 .. v24}, Lorg/json/JSONObject;-><init>()V

    move-object/from16 v0, v24

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/kochava/android/tracker/Feature;->kvinitorigdata:Lorg/json/JSONObject;

    .line 367
    const/16 v19, 0x0

    .line 368
    .local v19, "partner_id":Ljava/lang/String;
    const/16 v20, 0x0

    .line 369
    .local v20, "partner_name":Ljava/lang/String;
    const/4 v5, 0x0

    .line 370
    .local v5, "app_id":Ljava/lang/String;
    const/4 v10, 0x0

    .line 371
    .local v10, "currency":Ljava/lang/String;
    const/4 v6, 0x0

    .line 372
    .local v6, "attributionBool":Ljava/lang/String;
    const/4 v7, 0x0

    .line 373
    .local v7, "bidder_host":Ljava/lang/String;
    const/4 v9, 0x0

    .line 375
    .local v9, "control_host":Ljava/lang/String;
    if-eqz p3, :cond_8

    .line 378
    const-string v24, "partner_id"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    if-eqz v24, :cond_1

    const-string v24, "partner_id"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v24

    const-class v25, Ljava/lang/String;

    invoke-virtual/range {v24 .. v25}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v24

    if-eqz v24, :cond_1

    .line 379
    const-string v24, "partner_id"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    .end local v19    # "partner_id":Ljava/lang/String;
    check-cast v19, Ljava/lang/String;

    .line 382
    .restart local v19    # "partner_id":Ljava/lang/String;
    :cond_1
    const-string v24, "partner_name"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    if-eqz v24, :cond_2

    const-string v24, "partner_name"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v24

    const-class v25, Ljava/lang/String;

    invoke-virtual/range {v24 .. v25}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v24

    if-eqz v24, :cond_2

    .line 383
    const-string v24, "partner_name"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    .end local v20    # "partner_name":Ljava/lang/String;
    check-cast v20, Ljava/lang/String;

    .line 386
    .restart local v20    # "partner_name":Ljava/lang/String;
    :cond_2
    const-string v24, "kochava_app_id"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    if-eqz v24, :cond_3

    const-string v24, "kochava_app_id"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v24

    const-class v25, Ljava/lang/String;

    invoke-virtual/range {v24 .. v25}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v24

    if-eqz v24, :cond_3

    .line 387
    const-string v24, "kochava_app_id"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .end local v5    # "app_id":Ljava/lang/String;
    check-cast v5, Ljava/lang/String;

    .line 390
    .restart local v5    # "app_id":Ljava/lang/String;
    :cond_3
    const-string v24, "currency"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    if-eqz v24, :cond_4

    const-string v24, "currency"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v24

    const-class v25, Ljava/lang/String;

    invoke-virtual/range {v24 .. v25}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v24

    if-eqz v24, :cond_4

    .line 391
    const-string v24, "currency"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    .end local v10    # "currency":Ljava/lang/String;
    check-cast v10, Ljava/lang/String;

    .line 394
    .restart local v10    # "currency":Ljava/lang/String;
    :cond_4
    const-string v24, "request_attribution"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    if-eqz v24, :cond_5

    const-string v24, "request_attribution"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v24

    const-class v25, Ljava/lang/String;

    invoke-virtual/range {v24 .. v25}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v24

    if-eqz v24, :cond_5

    .line 395
    const-string v24, "request_attribution"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    .end local v6    # "attributionBool":Ljava/lang/String;
    check-cast v6, Ljava/lang/String;

    .line 398
    .restart local v6    # "attributionBool":Ljava/lang/String;
    :cond_5
    const-string v24, "bidder_host"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    if-eqz v24, :cond_6

    const-string v24, "bidder_host"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v24

    const-class v25, Ljava/lang/String;

    invoke-virtual/range {v24 .. v25}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v24

    if-eqz v24, :cond_6

    .line 399
    const-string v24, "bidder_host"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    .end local v7    # "bidder_host":Ljava/lang/String;
    check-cast v7, Ljava/lang/String;

    .line 402
    .restart local v7    # "bidder_host":Ljava/lang/String;
    :cond_6
    const-string v24, "control_host"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    if-eqz v24, :cond_7

    const-string v24, "control_host"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v24

    const-class v25, Ljava/lang/String;

    invoke-virtual/range {v24 .. v25}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v24

    if-eqz v24, :cond_7

    .line 403
    const-string v24, "control_host"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    .end local v9    # "control_host":Ljava/lang/String;
    check-cast v9, Ljava/lang/String;

    .line 405
    .restart local v9    # "control_host":Ljava/lang/String;
    :cond_7
    const-string v24, "identity_link"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    if-eqz v24, :cond_8

    const-string v24, "identity_link"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    move-object/from16 v0, v24

    instance-of v0, v0, Ljava/util/HashMap;

    move/from16 v24, v0

    if-eqz v24, :cond_8

    .line 409
    :try_start_2
    const-string v24, "identity_link"

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Ljava/util/HashMap;

    sput-object v24, Lcom/kochava/android/tracker/Feature;->identityLinkMap:Ljava/util/Map;

    .line 410
    new-instance v24, Lorg/json/JSONObject;

    invoke-direct/range {v24 .. v24}, Lorg/json/JSONObject;-><init>()V

    sput-object v24, Lcom/kochava/android/tracker/Feature;->identityLinkMapJSON:Lorg/json/JSONObject;

    .line 412
    sget-object v24, Lcom/kochava/android/tracker/Feature;->identityLinkMap:Ljava/util/Map;

    invoke-interface/range {v24 .. v24}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v24

    invoke-interface/range {v24 .. v24}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v15

    .line 413
    .local v15, "it":Ljava/util/Iterator;
    :goto_3
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    move-result v24

    if-nez v24, :cond_13

    .line 427
    .end local v15    # "it":Ljava/util/Iterator;
    :cond_8
    :goto_4
    if-eqz v9, :cond_9

    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v24

    if-eqz v24, :cond_9

    .line 429
    sput-object v9, Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;

    .line 432
    :cond_9
    if-eqz v7, :cond_a

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v24

    if-eqz v24, :cond_a

    .line 434
    sput-object v7, Lcom/kochava/android/tracker/Feature;->hostBidder:Ljava/lang/String;

    .line 441
    :cond_a
    if-eqz v10, :cond_b

    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v24

    if-eqz v24, :cond_b

    .line 442
    move-object/from16 v0, p0

    invoke-direct {v0, v10}, Lcom/kochava/android/tracker/Feature;->setCurrency(Ljava/lang/String;)V

    .line 444
    :cond_b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v24, v0

    const-string v25, "initPrefs"

    const/16 v26, 0x0

    invoke-virtual/range {v24 .. v26}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v24

    move-object/from16 v0, v24

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    .line 446
    if-eqz v6, :cond_c

    const-string v24, "true"

    move-object/from16 v0, v24

    invoke-virtual {v6, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v24

    if-eqz v24, :cond_c

    .line 448
    const/16 v24, 0x1

    invoke-static/range {v24 .. v24}, Lcom/kochava/android/tracker/Feature;->setRequestAttributionData(Z)V

    .line 451
    :cond_c
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v24, v0

    const-string v25, "attributionPref"

    const/16 v26, 0x0

    invoke-virtual/range {v24 .. v26}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v24

    move-object/from16 v0, v24

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/kochava/android/tracker/Feature;->attributionDataPrefs:Landroid/content/SharedPreferences;

    .line 456
    if-eqz v19, :cond_d

    :try_start_3
    invoke-virtual/range {v19 .. v19}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v24

    if-nez v24, :cond_23

    :cond_d
    if-eqz v20, :cond_e

    invoke-virtual/range {v20 .. v20}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v24

    if-nez v24, :cond_23

    .line 461
    :cond_e
    if-eqz v5, :cond_f

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v24

    if-nez v24, :cond_14

    .line 465
    :cond_f
    sget-boolean v24, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v24, :cond_10

    const-string v24, "KochavaTracker"

    const-string v25, "Kochava requires that you pass either a kochava app id, or a partner id and a partner name into the datamap during initialization."

    invoke-static/range {v24 .. v25}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_1

    .line 940
    .end local v5    # "app_id":Ljava/lang/String;
    .end local v6    # "attributionBool":Ljava/lang/String;
    .end local v7    # "bidder_host":Ljava/lang/String;
    .end local v9    # "control_host":Ljava/lang/String;
    .end local v10    # "currency":Ljava/lang/String;
    .end local v19    # "partner_id":Ljava/lang/String;
    .end local v20    # "partner_name":Ljava/lang/String;
    :cond_10
    :goto_5
    return-void

    .line 315
    :cond_11
    sget-boolean v24, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v24, :cond_10

    const-string v24, "KochavaTracker"

    const-string v25, "Context you passed was null, cannot initialize."

    invoke-static/range {v24 .. v25}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_5

    .line 351
    .restart local v21    # "task":Landroid/os/AsyncTask;, "Landroid/os/AsyncTask<Ljava/lang/Void;Ljava/lang/Void;Ljava/lang/String;>;"
    :cond_12
    check-cast v21, Landroid/os/AsyncTask;

    .end local v21    # "task":Landroid/os/AsyncTask;, "Landroid/os/AsyncTask<Ljava/lang/Void;Ljava/lang/Void;Ljava/lang/String;>;"
    move-object/from16 v0, v21

    move-object/from16 v1, v24

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_1

    .line 415
    .restart local v5    # "app_id":Ljava/lang/String;
    .restart local v6    # "attributionBool":Ljava/lang/String;
    .restart local v7    # "bidder_host":Ljava/lang/String;
    .restart local v9    # "control_host":Ljava/lang/String;
    .restart local v10    # "currency":Ljava/lang/String;
    .restart local v15    # "it":Ljava/util/Iterator;
    .restart local v19    # "partner_id":Ljava/lang/String;
    .restart local v20    # "partner_name":Ljava/lang/String;
    :cond_13
    :try_start_4
    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Ljava/util/Map$Entry;

    .line 416
    .local v18, "pairs":Ljava/util/Map$Entry;
    sget-object v26, Lcom/kochava/android/tracker/Feature;->identityLinkMapJSON:Lorg/json/JSONObject;

    invoke-interface/range {v18 .. v18}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Ljava/lang/String;

    invoke-interface/range {v18 .. v18}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v25

    check-cast v25, Ljava/lang/String;

    move-object/from16 v0, v26

    move-object/from16 v1, v24

    move-object/from16 v2, v25

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 417
    invoke-interface {v15}, Ljava/util/Iterator;->remove()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    goto/16 :goto_3

    .line 420
    .end local v15    # "it":Ljava/util/Iterator;
    .end local v18    # "pairs":Ljava/util/Map$Entry;
    :catch_0
    move-exception v24

    goto/16 :goto_4

    .line 470
    :cond_14
    :try_start_5
    move-object/from16 v0, p0

    iput-object v5, v0, Lcom/kochava/android/tracker/Feature;->mAppId:Ljava/lang/String;

    .line 471
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdataholder:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "kochava_app_id"

    move-object/from16 v0, v24

    move-object/from16 v1, v25

    invoke-virtual {v0, v1, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 472
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitorigdata:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "kochava_app_id"

    move-object/from16 v0, v24

    move-object/from16 v1, v25

    invoke-virtual {v0, v1, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 476
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    move-object/from16 v24, v0

    const-string v25, "kochavaappdata"

    const-string v26, ""

    invoke-interface/range {v24 .. v26}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    const-string v25, ""

    invoke-virtual/range {v24 .. v25}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v24

    if-eqz v24, :cond_15

    .line 478
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    move-object/from16 v24, v0

    invoke-interface/range {v24 .. v24}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v24

    const-string v25, "kochavaappdata"

    move-object/from16 v0, v24

    move-object/from16 v1, v25

    invoke-interface {v0, v1, v5}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v24

    invoke-interface/range {v24 .. v24}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 516
    :cond_15
    :goto_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdata:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "package"

    invoke-direct/range {p0 .. p0}, Lcom/kochava/android/tracker/Feature;->getAppPackageName()Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 517
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdata:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "platform"

    const-string v26, "android"

    invoke-virtual/range {v24 .. v26}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 518
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdata:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "session_tracking"

    const-string v26, "full"

    invoke-virtual/range {v24 .. v26}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 519
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdata:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "currency"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    move-object/from16 v26, v0

    const-string v27, "currency"

    const-string v28, "USD"

    invoke-interface/range {v26 .. v28}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 522
    sget-boolean v24, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v24, :cond_16

    const-string v24, "KochavaTracker"

    new-instance v25, Ljava/lang/StringBuilder;

    const-string v26, "Do we have attribution data? "

    invoke-direct/range {v25 .. v26}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct/range {p0 .. p0}, Lcom/kochava/android/tracker/Feature;->haveAttributionData()Z

    move-result v26

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-static/range {v24 .. v25}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 523
    :cond_16
    sget-boolean v24, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v24, :cond_17

    const-string v24, "KochavaTracker"

    new-instance v25, Ljava/lang/StringBuilder;

    const-string v26, "Did we request attribution data? "

    invoke-direct/range {v25 .. v26}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-boolean v26, Lcom/kochava/android/tracker/Feature;->requestAttributionData:Z

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-static/range {v24 .. v25}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 525
    :cond_17
    invoke-direct/range {p0 .. p0}, Lcom/kochava/android/tracker/Feature;->haveAttributionData()Z

    move-result v24

    if-nez v24, :cond_19

    sget-boolean v24, Lcom/kochava/android/tracker/Feature;->requestAttributionData:Z

    if-eqz v24, :cond_19

    .line 527
    sget-boolean v24, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v24, :cond_18

    const-string v24, "KochavaTracker"

    const-string v25, "Requesting attribution data..."

    invoke-static/range {v24 .. v25}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 528
    :cond_18
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdata:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "request_attribution"

    const-string v26, "true"

    invoke-virtual/range {v24 .. v26}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 532
    :cond_19
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitorigdata:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "currency"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    move-object/from16 v26, v0

    const-string v27, "currency"

    const-string v28, "USD"

    invoke-interface/range {v26 .. v28}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 533
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitorigdata:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "session_tracking"

    const-string v26, "full"

    invoke-virtual/range {v24 .. v26}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 535
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitorigdata:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "currency"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    move-object/from16 v26, v0

    const-string v27, "currency"

    const-string v28, "USD"

    invoke-interface/range {v26 .. v28}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 537
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdataholder:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "sdk_version"

    const-string v26, "Android20140428"

    invoke-virtual/range {v24 .. v26}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 538
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdataholder:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "sdk_protocol"

    const-string v26, "3"

    invoke-virtual/range {v24 .. v26}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 541
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdataholder:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "data"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdata:Lorg/json/JSONObject;

    move-object/from16 v26, v0

    invoke-virtual/range {v24 .. v26}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 543
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdataholder:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "data_orig"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitorigdata:Lorg/json/JSONObject;

    move-object/from16 v26, v0

    invoke-virtual/range {v24 .. v26}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_5
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_5} :catch_1

    .line 553
    :cond_1a
    :goto_7
    sget-object v24, Lcom/kochava/android/tracker/Feature;->appContext:Landroid/content/Context;

    if-nez v24, :cond_1b

    .line 554
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v24

    sput-object v24, Lcom/kochava/android/tracker/Feature;->appContext:Landroid/content/Context;

    .line 556
    :cond_1b
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v24

    const-wide/16 v26, 0x3e8

    div-long v24, v24, v26

    move-wide/from16 v0, v24

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/kochava/android/tracker/Feature;->startTime:J

    .line 560
    const/16 v16, 0x0

    .line 561
    .local v16, "missing":Z
    const-string v17, ""

    .line 563
    .local v17, "missingItems":Ljava/lang/String;
    new-instance v8, Landroid/content/ComponentName;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v24, v0

    const-class v25, Lcom/kochava/android/tracker/ReferralCapture;

    move-object/from16 v0, v24

    move-object/from16 v1, v25

    invoke-direct {v8, v0, v1}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 566
    .local v8, "cn":Landroid/content/ComponentName;
    :try_start_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v24

    const/16 v25, 0x0

    move-object/from16 v0, v24

    move/from16 v1, v25

    invoke-virtual {v0, v8, v1}, Landroid/content/pm/PackageManager;->getReceiverInfo(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;

    move-result-object v4

    .line 567
    .local v4, "ai":Landroid/content/pm/ActivityInfo;
    sget-boolean v24, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v24, :cond_1c

    const-string v24, "KochavaTracker"

    const-string v25, "Receiver registered."

    invoke-static/range {v24 .. v25}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_6
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_6 .. :try_end_6} :catch_2

    .line 590
    .end local v4    # "ai":Landroid/content/pm/ActivityInfo;
    :cond_1c
    :goto_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v24

    const-string v25, "android.permission.ACCESS_NETWORK_STATE"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v26, v0

    invoke-virtual/range {v26 .. v26}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Landroid/content/pm/PackageManager;->checkPermission(Ljava/lang/String;Ljava/lang/String;)I

    move-result v24

    if-gez v24, :cond_1d

    .line 592
    const/16 v16, 0x1

    .line 593
    new-instance v24, Ljava/lang/StringBuilder;

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v25

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v25, "\n    PERMMISION MISSING: android.permission.ACCESS_NETWORK_STATE"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 597
    :cond_1d
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v24

    const-string v25, "android.permission.INTERNET"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v26, v0

    invoke-virtual/range {v26 .. v26}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Landroid/content/pm/PackageManager;->checkPermission(Ljava/lang/String;Ljava/lang/String;)I

    move-result v24

    if-gez v24, :cond_1e

    .line 599
    const/16 v16, 0x1

    .line 600
    new-instance v24, Ljava/lang/StringBuilder;

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v25

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v25, "\n    PERMMISION MISSING: android.permission.INTERNET"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 604
    :cond_1e
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v24

    const-string v25, "android.permission.ACCESS_WIFI_STATE"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v26, v0

    invoke-virtual/range {v26 .. v26}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Landroid/content/pm/PackageManager;->checkPermission(Ljava/lang/String;Ljava/lang/String;)I

    move-result v24

    if-gez v24, :cond_1f

    .line 606
    const/16 v16, 0x1

    .line 607
    new-instance v24, Ljava/lang/StringBuilder;

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v25

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v25, "\n    PERMMISION MISSING: android.permission.ACCESS_WIFI_STATE"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 611
    :cond_1f
    if-eqz v16, :cond_21

    .line 613
    sget-boolean v24, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v24, :cond_20

    const-string v24, "KochavaRequirements"

    const-string v25, "**NOTICE** The following items may not have been implemented correctly. Please refer to the Kochava SDK documentation to resolve these issues:"

    invoke-static/range {v24 .. v25}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 614
    :cond_20
    sget-boolean v24, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v24, :cond_21

    const-string v24, "KochavaRequirements"

    move-object/from16 v0, v24

    move-object/from16 v1, v17

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 621
    :cond_21
    :try_start_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v24, v0

    const-string v25, "phone"

    invoke-virtual/range {v24 .. v25}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v22

    check-cast v22, Landroid/telephony/TelephonyManager;

    .line 622
    .local v22, "telephonyManager":Landroid/telephony/TelephonyManager;
    invoke-virtual/range {v22 .. v22}, Landroid/telephony/TelephonyManager;->getDeviceId()Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v24

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/kochava/android/tracker/Feature;->mIMEI:Ljava/lang/String;
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_3

    .line 638
    .end local v22    # "telephonyManager":Landroid/telephony/TelephonyManager;
    :cond_22
    :goto_9
    :try_start_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    move-object/from16 v24, v0

    const-string v25, "wifi"

    invoke-virtual/range {v24 .. v25}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v23

    check-cast v23, Landroid/net/wifi/WifiManager;

    .line 639
    .local v23, "wimanager":Landroid/net/wifi/WifiManager;
    invoke-virtual/range {v23 .. v23}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Landroid/net/wifi/WifiInfo;->getMacAddress()Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v24

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/kochava/android/tracker/Feature;->mMacAddr:Ljava/lang/String;
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    .line 652
    .end local v23    # "wimanager":Landroid/net/wifi/WifiManager;
    :goto_a
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v24

    const-string v25, "-"

    const-string v26, ""

    invoke-virtual/range {v24 .. v26}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v24

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/kochava/android/tracker/Feature;->mEnvDeviceID:Ljava/lang/String;

    .line 657
    :try_start_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdataholder:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "kochava_device_id"

    invoke-direct/range {p0 .. p0}, Lcom/kochava/android/tracker/Feature;->getDeviceId()Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v24 .. v26}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_9
    .catch Lorg/json/JSONException; {:try_start_9 .. :try_end_9} :catch_4

    .line 667
    :goto_b
    new-instance v14, Lcom/kochava/android/tracker/Feature$4;

    move-object/from16 v0, p0

    move/from16 v1, p2

    invoke-direct {v14, v0, v1}, Lcom/kochava/android/tracker/Feature$4;-><init>(Lcom/kochava/android/tracker/Feature;Z)V

    .line 937
    .local v14, "getKVinit":Ljava/lang/Runnable;
    sget-object v24, Lcom/kochava/android/tracker/Feature;->worker:Ljava/util/concurrent/ScheduledExecutorService;

    const-wide/16 v26, 0x5

    sget-object v25, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    move-object/from16 v0, v24

    move-wide/from16 v1, v26

    move-object/from16 v3, v25

    invoke-interface {v0, v14, v1, v2, v3}, Ljava/util/concurrent/ScheduledExecutorService;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    goto/16 :goto_5

    .line 483
    .end local v8    # "cn":Landroid/content/ComponentName;
    .end local v14    # "getKVinit":Ljava/lang/Runnable;
    .end local v16    # "missing":Z
    .end local v17    # "missingItems":Ljava/lang/String;
    :cond_23
    if-eqz v19, :cond_24

    :try_start_a
    invoke-virtual/range {v19 .. v19}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v24

    if-eqz v24, :cond_24

    if-eqz v20, :cond_24

    invoke-virtual/range {v20 .. v20}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v24

    if-nez v24, :cond_25

    .line 486
    :cond_24
    sget-boolean v24, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v24, :cond_10

    const-string v24, "KochavaTracker"

    const-string v25, "Please make sure that you have passed both a partner id and a partner name."

    invoke-static/range {v24 .. v25}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_a
    .catch Lorg/json/JSONException; {:try_start_a .. :try_end_a} :catch_1

    goto/16 :goto_5

    .line 546
    :catch_1
    move-exception v11

    .line 548
    .local v11, "e":Lorg/json/JSONException;
    sget-boolean v24, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v24, :cond_1a

    .line 549
    const-string v24, "KochavaTracker"

    new-instance v25, Ljava/lang/StringBuilder;

    const-string v26, "Error building KVinit json object: "

    invoke-direct/range {v25 .. v26}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11}, Lorg/json/JSONException;->toString()Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-static/range {v24 .. v25}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_7

    .line 492
    .end local v11    # "e":Lorg/json/JSONException;
    :cond_25
    :try_start_b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdata:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "partner_id"

    move-object/from16 v0, v24

    move-object/from16 v1, v25

    move-object/from16 v2, v19

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 493
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdata:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "partner_name"

    move-object/from16 v0, v24

    move-object/from16 v1, v25

    move-object/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 498
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    move-object/from16 v24, v0

    const-string v25, "kochavaappdata"

    const-string v26, ""

    invoke-interface/range {v24 .. v26}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    const-string v25, ""

    invoke-virtual/range {v24 .. v25}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v24

    if-eqz v24, :cond_26

    .line 500
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    move-object/from16 v24, v0

    invoke-interface/range {v24 .. v24}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v24

    const-string v25, "kochavaappdata"

    new-instance v26, Ljava/lang/StringBuilder;

    invoke-static/range {v19 .. v19}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v27

    invoke-direct/range {v26 .. v27}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v26

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v26

    invoke-interface/range {v24 .. v26}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v24

    invoke-interface/range {v24 .. v24}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 504
    :cond_26
    if-eqz v5, :cond_27

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v24

    if-eqz v24, :cond_27

    .line 506
    move-object/from16 v0, p0

    iput-object v5, v0, Lcom/kochava/android/tracker/Feature;->mAppId:Ljava/lang/String;

    .line 507
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitdataholder:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "kochava_app_id"

    move-object/from16 v0, v24

    move-object/from16 v1, v25

    invoke-virtual {v0, v1, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 508
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->kvinitorigdata:Lorg/json/JSONObject;

    move-object/from16 v24, v0

    const-string v25, "kochava_app_id"

    move-object/from16 v0, v24

    move-object/from16 v1, v25

    invoke-virtual {v0, v1, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_6

    .line 512
    :cond_27
    new-instance v24, Ljava/lang/StringBuilder;

    const-string v25, "_p:"

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v24

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    const-string v25, ":"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    move-object/from16 v0, v24

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v24

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/kochava/android/tracker/Feature;->mAppId:Ljava/lang/String;
    :try_end_b
    .catch Lorg/json/JSONException; {:try_start_b .. :try_end_b} :catch_1

    goto/16 :goto_6

    .line 569
    .restart local v8    # "cn":Landroid/content/ComponentName;
    .restart local v16    # "missing":Z
    .restart local v17    # "missingItems":Ljava/lang/String;
    :catch_2
    move-exception v12

    .line 571
    .local v12, "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/16 v16, 0x1

    .line 572
    new-instance v24, Ljava/lang/StringBuilder;

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v25

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v25, "\n    BROADCAST RECEIVER REGISTRATION MISSING: com.android.kochava.tracker.ReferralCapture"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    goto/16 :goto_8

    .line 631
    .end local v12    # "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    :catch_3
    move-exception v13

    .line 633
    .local v13, "exc":Ljava/lang/Exception;
    sget-boolean v24, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v24, :cond_22

    const-string v24, "KochavaTracker"

    new-instance v25, Ljava/lang/StringBuilder;

    const-string v26, "Couldn\'t gather IMEI: "

    invoke-direct/range {v25 .. v26}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v13}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-static/range {v24 .. v25}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_9

    .line 659
    .end local v13    # "exc":Ljava/lang/Exception;
    :catch_4
    move-exception v12

    .line 661
    .local v12, "e1":Lorg/json/JSONException;
    invoke-virtual {v12}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_b

    .line 640
    .end local v12    # "e1":Lorg/json/JSONException;
    :catch_5
    move-exception v24

    goto/16 :goto_a

    .line 361
    .end local v5    # "app_id":Ljava/lang/String;
    .end local v6    # "attributionBool":Ljava/lang/String;
    .end local v7    # "bidder_host":Ljava/lang/String;
    .end local v8    # "cn":Landroid/content/ComponentName;
    .end local v9    # "control_host":Ljava/lang/String;
    .end local v10    # "currency":Ljava/lang/String;
    .end local v16    # "missing":Z
    .end local v17    # "missingItems":Ljava/lang/String;
    .end local v19    # "partner_id":Ljava/lang/String;
    .end local v20    # "partner_name":Ljava/lang/String;
    :catch_6
    move-exception v24

    goto/16 :goto_2

    .line 328
    :catch_7
    move-exception v24

    goto/16 :goto_0
.end method

.method private postEvent()Ljava/lang/String;
    .locals 18

    .prologue
    .line 1888
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/kochava/android/tracker/Feature;->kDbAdapter:Lcom/kochava/android/tracker/KochavaDbAdapter;

    invoke-virtual {v15}, Lcom/kochava/android/tracker/KochavaDbAdapter;->generateDataString()Ljava/lang/String;

    move-result-object v3

    .line 1890
    .local v3, "data":Ljava/lang/String;
    if-nez v3, :cond_1

    .line 1893
    const-string v10, ""

    .line 2005
    :cond_0
    :goto_0
    return-object v10

    .line 1895
    :cond_1
    new-instance v14, Ljava/util/StringTokenizer;

    const-string v15, "="

    invoke-direct {v14, v3, v15}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 1896
    .local v14, "tok":Ljava/util/StringTokenizer;
    invoke-virtual {v14}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v15

    invoke-static {v15}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v12

    .line 1898
    .local v12, "timestamp":J
    invoke-virtual {v14}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v3

    .line 1901
    const-string v15, "["

    invoke-virtual {v3, v15}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v15

    if-eqz v15, :cond_2

    .line 1903
    const/4 v15, 0x1

    invoke-virtual {v3, v15}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    .line 1905
    :cond_2
    const-string v15, "]"

    invoke-virtual {v3, v15}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v15

    if-eqz v15, :cond_3

    .line 1907
    const/4 v15, 0x0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v16

    add-int/lit8 v16, v16, -0x1

    move/from16 v0, v16

    invoke-virtual {v3, v15, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 1913
    :cond_3
    sget-boolean v15, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v15, :cond_4

    .line 1914
    const-string v15, "KochavaTracker"

    new-instance v16, Ljava/lang/StringBuilder;

    const-string v17, "Post The Data 3>>>>>>"

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1916
    :cond_4
    const/4 v8, 0x0

    .line 1918
    .local v8, "isInitial":Z
    const-string v15, "\"action\":\"initial\""

    invoke-virtual {v3, v15}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v15

    if-eqz v15, :cond_6

    .line 1920
    sget-boolean v15, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v15, :cond_5

    const-string v15, "KochavaTracker"

    const-string v16, "Post Data: Event is initial, look at response"

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1921
    :cond_5
    const/4 v8, 0x1

    .line 1924
    :cond_6
    const/4 v15, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v15}, Lcom/kochava/android/tracker/Feature;->createHttpClient(Z)Lorg/apache/http/client/HttpClient;

    move-result-object v6

    .line 1929
    .local v6, "httpclient":Lorg/apache/http/client/HttpClient;
    invoke-interface {v6}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/kochava/android/tracker/Feature;->mUserAgent:Ljava/lang/String;

    move-object/from16 v16, v0

    invoke-static/range {v15 .. v16}, Lorg/apache/http/params/HttpProtocolParams;->setUserAgent(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V

    .line 1931
    sget-object v15, Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;

    if-eqz v15, :cond_7

    sget-object v15, Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;

    invoke-virtual {v15}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/String;->isEmpty()Z

    move-result v15

    if-eqz v15, :cond_9

    .line 1933
    :cond_7
    sget-boolean v15, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v15, :cond_8

    const-string v15, "KochavaTracker"

    const-string v16, "postEvent - hostControl was empty, using default"

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1934
    :cond_8
    const-string v15, "control.kochava.com"

    sput-object v15, Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;

    .line 1937
    :cond_9
    sget-boolean v15, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v15, :cond_a

    const-string v15, "KochavaTracker"

    new-instance v16, Ljava/lang/StringBuilder;

    const-string v17, "postEvent - posting to "

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v17, "https://"

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    sget-object v17, Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, "/track/kvTracker.php"

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1938
    :cond_a
    new-instance v7, Lorg/apache/http/client/methods/HttpPost;

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "https://"

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v16, Lcom/kochava/android/tracker/Feature;->hostControl:Ljava/lang/String;

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "/track/kvTracker.php"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-direct {v7, v15}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 1946
    .local v7, "httppost":Lorg/apache/http/client/methods/HttpPost;
    :try_start_0
    new-instance v11, Lorg/apache/http/entity/StringEntity;

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "["

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v15, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "]"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    const-string v16, "UTF-8"

    move-object/from16 v0, v16

    invoke-direct {v11, v15, v0}, Lorg/apache/http/entity/StringEntity;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 1947
    .local v11, "sentity":Lorg/apache/http/entity/StringEntity;
    new-instance v2, Lorg/apache/http/message/BasicHeader;

    const-string v15, "Content-Type"

    const-string v16, "application/xml"

    move-object/from16 v0, v16

    invoke-direct {v2, v15, v0}, Lorg/apache/http/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 1948
    .local v2, "basicHeader":Lorg/apache/http/message/BasicHeader;
    invoke-virtual {v7}, Lorg/apache/http/client/methods/HttpPost;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v15

    const-string v16, "http.protocol.expect-continue"

    const/16 v17, 0x0

    invoke-interface/range {v15 .. v17}, Lorg/apache/http/params/HttpParams;->setBooleanParameter(Ljava/lang/String;Z)Lorg/apache/http/params/HttpParams;

    .line 1949
    invoke-virtual {v11, v2}, Lorg/apache/http/entity/StringEntity;->setContentType(Lorg/apache/http/Header;)V

    .line 1950
    invoke-virtual {v7, v11}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 1951
    sget-boolean v15, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v15, :cond_b

    const-string v15, "KochavaTracker"

    const-string v16, "Trying to post an event."

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1952
    :cond_b
    instance-of v15, v6, Lorg/apache/http/client/HttpClient;

    if-nez v15, :cond_c

    invoke-interface {v6, v7}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v9

    .line 1953
    .end local v6    # "httpclient":Lorg/apache/http/client/HttpClient;
    .local v9, "response":Lorg/apache/http/HttpResponse;
    :goto_1
    invoke-interface {v9}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;
    :try_end_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3

    move-result-object v5

    .line 1954
    .local v5, "entity":Lorg/apache/http/HttpEntity;
    if-nez v5, :cond_d

    .line 1955
    const-string v10, ""

    goto/16 :goto_0

    .line 1952
    .end local v5    # "entity":Lorg/apache/http/HttpEntity;
    .end local v9    # "response":Lorg/apache/http/HttpResponse;
    .restart local v6    # "httpclient":Lorg/apache/http/client/HttpClient;
    :cond_c
    :try_start_1
    check-cast v6, Lorg/apache/http/client/HttpClient;

    .end local v6    # "httpclient":Lorg/apache/http/client/HttpClient;
    invoke-static {v6, v7}, Lcom/newrelic/agent/android/instrumentation/HttpInstrumentation;->execute(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_1
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3

    move-result-object v9

    goto :goto_1

    .line 1959
    .restart local v5    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v9    # "response":Lorg/apache/http/HttpResponse;
    :cond_d
    :try_start_2
    sget-boolean v15, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v15, :cond_e

    const-string v15, "KochavaTracker"

    const-string v16, "Grabbing Result..."

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1960
    :cond_e
    invoke-interface {v5}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v15

    invoke-static {v15}, Lcom/kochava/android/util/StringUtils;->inputStreamToString(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v10

    .line 1961
    .local v10, "result":Ljava/lang/String;
    sget-boolean v15, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v15, :cond_f

    const-string v15, "KochavaTracker"

    new-instance v16, Ljava/lang/StringBuilder;

    const-string v17, "Result: "

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v16

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1964
    :cond_f
    if-eqz v8, :cond_12

    .line 1966
    const-string v15, "\"success\":\"1\""

    invoke-virtual {v10, v15}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v15

    if-eqz v15, :cond_0

    .line 1969
    sget-boolean v15, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v15, :cond_10

    const-string v15, "KochavaTracker"

    const-string v16, "Got success response, cleaning database."

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1970
    :cond_10
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/kochava/android/tracker/Feature;->kDbAdapter:Lcom/kochava/android/tracker/KochavaDbAdapter;

    invoke-virtual {v15, v12, v13}, Lcom/kochava/android/tracker/KochavaDbAdapter;->cleanupEvents(J)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_2 .. :try_end_2} :catch_1
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_2 .. :try_end_2} :catch_2

    goto/16 :goto_0

    .line 1984
    .end local v10    # "result":Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 1986
    .local v4, "e":Ljava/io/IOException;
    :try_start_3
    sget-boolean v15, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v15, :cond_11

    const-string v15, "KochavaTracker"

    const-string v16, "TrackTask"

    move-object/from16 v0, v16

    invoke-static {v15, v0, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_3
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_3

    .line 1987
    :cond_11
    const-string v10, ""

    goto/16 :goto_0

    .line 1978
    .end local v4    # "e":Ljava/io/IOException;
    .restart local v10    # "result":Ljava/lang/String;
    :cond_12
    :try_start_4
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/kochava/android/tracker/Feature;->kDbAdapter:Lcom/kochava/android/tracker/KochavaDbAdapter;

    invoke-virtual {v15, v12, v13}, Lcom/kochava/android/tracker/KochavaDbAdapter;->cleanupEvents(J)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_4 .. :try_end_4} :catch_1
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_4 .. :try_end_4} :catch_2

    goto/16 :goto_0

    .line 1989
    .end local v10    # "result":Ljava/lang/String;
    :catch_1
    move-exception v4

    .line 1991
    .local v4, "e":Ljava/lang/OutOfMemoryError;
    :try_start_5
    sget-boolean v15, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v15, :cond_13

    const-string v15, "KochavaTracker"

    const-string v16, "TrackTask"

    move-object/from16 v0, v16

    invoke-static {v15, v0, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_5
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_5 .. :try_end_5} :catch_2
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 1992
    :cond_13
    const-string v10, ""

    goto/16 :goto_0

    .line 1996
    .end local v2    # "basicHeader":Lorg/apache/http/message/BasicHeader;
    .end local v4    # "e":Ljava/lang/OutOfMemoryError;
    .end local v5    # "entity":Lorg/apache/http/HttpEntity;
    .end local v9    # "response":Lorg/apache/http/HttpResponse;
    .end local v11    # "sentity":Lorg/apache/http/entity/StringEntity;
    :catch_2
    move-exception v4

    .line 1998
    .local v4, "e":Lorg/apache/http/client/ClientProtocolException;
    sget-boolean v15, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v15, :cond_14

    const-string v15, "KochavaTracker"

    const-string v16, "TrackTask"

    move-object/from16 v0, v16

    invoke-static {v15, v0, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1999
    :cond_14
    const-string v10, ""

    goto/16 :goto_0

    .line 2001
    .end local v4    # "e":Lorg/apache/http/client/ClientProtocolException;
    :catch_3
    move-exception v4

    .line 2004
    .local v4, "e":Ljava/io/IOException;
    sget-boolean v15, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v15, :cond_15

    const-string v15, "KochavaTracker"

    const-string v16, "TrackTask"

    move-object/from16 v0, v16

    invoke-static {v15, v0, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 2005
    :cond_15
    const-string v10, ""

    goto/16 :goto_0
.end method

.method private queInitial(Z)V
    .locals 6
    .param p1, "cancelTimer"    # Z

    .prologue
    .line 2013
    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    const-string v2, "initBool"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "false"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->initialPropertiesObject:Lorg/json/JSONObject;

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->initialObject:Lorg/json/JSONObject;

    if-eqz v1, :cond_4

    .line 2017
    :try_start_0
    sget-boolean v1, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v1, :cond_0

    const-string v1, "KochavaTracker"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Initial properties: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/kochava/android/tracker/Feature;->initialPropertiesObject:Lorg/json/JSONObject;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2018
    :cond_0
    sget-boolean v1, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v1, :cond_1

    const-string v1, "KochavaTracker"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Initital Oject: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/kochava/android/tracker/Feature;->initialObject:Lorg/json/JSONObject;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2019
    :cond_1
    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    const-string v2, "initData"

    const-string v3, "noData"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "noData"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_5

    .line 2021
    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->initialPropertiesObject:Lorg/json/JSONObject;

    const-string v2, "conversion_type"

    const-string v3, "gplay"

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2022
    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->initialPropertiesObject:Lorg/json/JSONObject;

    const-string v2, "conversion_data"

    iget-object v3, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    const-string v4, "initData"

    const-string v5, ""

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2023
    sget-boolean v1, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v1, :cond_2

    const-string v1, "KochavaTracker"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Got referral, attaching: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    const-string v4, "initData"

    const-string v5, ""

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2029
    :cond_2
    :goto_0
    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->initialObject:Lorg/json/JSONObject;

    const-string v2, "data"

    iget-object v3, p0, Lcom/kochava/android/tracker/Feature;->initialPropertiesObject:Lorg/json/JSONObject;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2030
    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->kDbAdapter:Lcom/kochava/android/tracker/KochavaDbAdapter;

    iget-object v2, p0, Lcom/kochava/android/tracker/Feature;->initialObject:Lorg/json/JSONObject;

    invoke-virtual {v1, v2}, Lcom/kochava/android/tracker/KochavaDbAdapter;->addEvent(Lorg/json/JSONObject;)I

    .line 2031
    sget-boolean v1, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v1, :cond_3

    const-string v1, "KochavaTracker"

    const-string v2, "Sending Initial"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2032
    :cond_3
    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "initBool"

    const-string v3, "true"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 2033
    if-eqz p1, :cond_4

    .line 2034
    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->initTimer:Ljava/util/Timer;

    invoke-virtual {v1}, Ljava/util/Timer;->cancel()V

    .line 2042
    :cond_4
    :goto_1
    return-void

    .line 2027
    :cond_5
    sget-boolean v1, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v1, :cond_2

    const-string v1, "KochavaTracker"

    const-string v2, "Did not get referral data."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 2036
    :catch_0
    move-exception v0

    .line 2038
    .local v0, "e":Lorg/json/JSONException;
    sget-boolean v1, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v1, :cond_6

    const-string v1, "KochavaTracker"

    const-string v2, "An error occured during que initial."

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 2039
    :cond_6
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1
.end method

.method public static setAttributionHandler(Landroid/os/Handler;)V
    .locals 0
    .param p0, "delegate"    # Landroid/os/Handler;

    .prologue
    .line 1461
    sput-object p0, Lcom/kochava/android/tracker/Feature;->attributionDataHandler:Landroid/os/Handler;

    .line 1462
    return-void
.end method

.method private setCurrency(Ljava/lang/String;)V
    .locals 3
    .param p1, "cur"    # Ljava/lang/String;

    .prologue
    .line 1349
    if-eqz p1, :cond_1

    sget-object v0, Lcom/kochava/android/tracker/Global;->CURRENCYLIST:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1351
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    const-string v1, "initPrefs"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    .line 1353
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "currency"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1359
    :cond_0
    :goto_0
    return-void

    .line 1357
    :cond_1
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v0, :cond_0

    const-string v0, "KochavaTracker"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Trying to set currency, but "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " is not a valid currency."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static setErrorDebug(Z)V
    .locals 0
    .param p0, "flag"    # Z

    .prologue
    .line 2308
    sput-boolean p0, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    .line 2309
    return-void
.end method

.method public static setRequestAttributionData(Z)V
    .locals 0
    .param p0, "receive"    # Z

    .prologue
    .line 1376
    sput-boolean p0, Lcom/kochava/android/tracker/Feature;->requestAttributionData:Z

    .line 1377
    return-void
.end method


# virtual methods
.method public clearSuperProperties()V
    .locals 2

    .prologue
    .line 1338
    iget-boolean v0, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    if-eqz v0, :cond_1

    .line 1340
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v0, :cond_0

    const-string v0, "KochavaTracker"

    const-string v1, "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1345
    :cond_0
    :goto_0
    return-void

    .line 1343
    :cond_1
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v0, :cond_2

    const-string v0, "KochavaTracker"

    const-string v1, "clearSuperProperties"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1344
    :cond_2
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/kochava/android/tracker/Feature;->mSuperProperties:Ljava/util/Map;

    goto :goto_0
.end method

.method public enableTestMode()V
    .locals 2

    .prologue
    .line 1708
    iget-boolean v0, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    if-eqz v0, :cond_1

    .line 1710
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v0, :cond_0

    const-string v0, "KochavaTracker"

    const-string v1, "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1715
    :cond_0
    :goto_0
    return-void

    .line 1713
    :cond_1
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v0, :cond_2

    const-string v0, "KochavaTracker"

    const-string v1, "enableTestMode"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1714
    :cond_2
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/kochava/android/tracker/Feature;->mTestMode:Z

    goto :goto_0
.end method

.method public endSession()V
    .locals 2

    .prologue
    .line 1409
    iget-boolean v0, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    if-eqz v0, :cond_1

    .line 1411
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v0, :cond_0

    const-string v0, "KochavaTracker"

    const-string v1, "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1433
    :cond_0
    :goto_0
    return-void

    .line 1415
    :cond_1
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v0, :cond_2

    const-string v0, "KochavaTracker"

    const-string v1, "Called End"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1424
    :cond_2
    iget-boolean v0, p0, Lcom/kochava/android/tracker/Feature;->canSendSession:Z

    if-eqz v0, :cond_3

    .line 1426
    const-string v0, "exit"

    invoke-direct {p0, v0}, Lcom/kochava/android/tracker/Feature;->eventSession(Ljava/lang/String;)V

    goto :goto_0

    .line 1430
    :cond_3
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v0, :cond_0

    const-string v0, "KochavaTracker"

    const-string v1, "Session events disabled by server."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public event(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "eventName"    # Ljava/lang/String;
    .param p2, "eventData"    # Ljava/lang/String;

    .prologue
    .line 1486
    iget-boolean v2, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    if-eqz v2, :cond_1

    .line 1488
    sget-boolean v2, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v2, :cond_0

    const-string v2, "KochavaTracker"

    const-string v3, "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used."

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1512
    :cond_0
    :goto_0
    return-void

    .line 1494
    :cond_1
    :try_start_0
    sget-boolean v2, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v2, :cond_2

    .line 1496
    const-string v2, "KochavaTracker"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Got event "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1499
    :cond_2
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 1500
    .local v1, "properties":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "event_name"

    invoke-virtual {v1, v2, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1501
    const-string v2, "event_data"

    invoke-virtual {v1, v2, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1503
    const-string v2, "event"

    invoke-direct {p0, v2, v1}, Lcom/kochava/android/tracker/Feature;->fireEvent(Ljava/lang/String;Ljava/util/Map;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1505
    .end local v1    # "properties":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :catch_0
    move-exception v0

    .line 1507
    .local v0, "e":Ljava/lang/Exception;
    sget-boolean v2, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v2, :cond_0

    .line 1508
    const-string v2, "KochavaTracker"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Error in event call: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public eventSpatial(Ljava/lang/String;DDDLjava/lang/String;)V
    .locals 6
    .param p1, "eventName"    # Ljava/lang/String;
    .param p2, "x"    # D
    .param p4, "y"    # D
    .param p6, "z"    # D
    .param p8, "eventData"    # Ljava/lang/String;

    .prologue
    .line 1516
    iget-boolean v3, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    if-eqz v3, :cond_1

    .line 1518
    sget-boolean v3, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v3, :cond_0

    const-string v3, "KochavaTracker"

    const-string v4, "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used."

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1546
    :cond_0
    :goto_0
    return-void

    .line 1524
    :cond_1
    :try_start_0
    sget-boolean v3, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v3, :cond_2

    .line 1525
    const-string v3, "KochavaTracker"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Got event "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1528
    :cond_2
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 1529
    .local v1, "properties":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v3, "event_name"

    invoke-virtual {v1, v3, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1531
    new-instance v2, Ljava/text/DecimalFormat;

    const-string v3, "#.##"

    invoke-direct {v2, v3}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 1532
    .local v2, "twoDForm":Ljava/text/DecimalFormat;
    const-string v3, "x"

    invoke-virtual {v2, p2, p3}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Double;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1533
    const-string v3, "y"

    invoke-virtual {v2, p4, p5}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Double;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1534
    const-string v3, "z"

    invoke-virtual {v2, p6, p7}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Double;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1535
    const-string v3, "event_data"

    invoke-virtual {v1, v3, p8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1537
    const-string v3, "spatial"

    invoke-direct {p0, v3, v1}, Lcom/kochava/android/tracker/Feature;->fireEvent(Ljava/lang/String;Ljava/util/Map;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1539
    .end local v1    # "properties":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v2    # "twoDForm":Ljava/text/DecimalFormat;
    :catch_0
    move-exception v0

    .line 1541
    .local v0, "e":Ljava/lang/Exception;
    sget-boolean v3, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v3, :cond_0

    .line 1542
    const-string v3, "KochavaTracker"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Error in event call: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0
.end method

.method public flush()V
    .locals 3

    .prologue
    .line 1691
    iget-boolean v0, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    if-eqz v0, :cond_1

    .line 1693
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v0, :cond_0

    const-string v0, "KochavaTracker"

    const-string v1, "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1699
    :cond_0
    :goto_0
    return-void

    .line 1696
    :cond_1
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v0, :cond_2

    const-string v0, "KochavaTracker"

    const-string v1, "flush"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1698
    :cond_2
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->executor:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/kochava/android/tracker/Feature$TrackTask;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/kochava/android/tracker/Feature$TrackTask;-><init>(Lcom/kochava/android/tracker/Feature;Lcom/kochava/android/tracker/Feature$TrackTask;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    goto :goto_0
.end method

.method public getAttributionData()Ljava/lang/String;
    .locals 3

    .prologue
    .line 1236
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->attributionDataPrefs:Landroid/content/SharedPreferences;

    if-eqz v0, :cond_0

    .line 1237
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->attributionDataPrefs:Landroid/content/SharedPreferences;

    const-string v1, "attributionData"

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1239
    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public linkIdentity(Ljava/util/Map;)V
    .locals 2
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
    .line 1446
    .local p1, "identityMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-boolean v0, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    if-eqz v0, :cond_1

    .line 1448
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v0, :cond_0

    const-string v0, "KochavaTracker"

    const-string v1, "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1457
    :cond_0
    :goto_0
    return-void

    .line 1452
    :cond_1
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v0, :cond_2

    .line 1453
    const-string v0, "KochavaTracker"

    const-string v1, "Mapping identity"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1455
    :cond_2
    const-string v0, "identityLink"

    invoke-direct {p0, v0, p1}, Lcom/kochava/android/tracker/Feature;->fireEvent(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0
.end method

.method public registerSuperProperties(Ljava/util/Map;)V
    .locals 5
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
    .line 1314
    .local p1, "superProperties":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-boolean v1, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    if-eqz v1, :cond_1

    .line 1316
    sget-boolean v1, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v1, :cond_0

    const-string v1, "KochavaTracker"

    const-string v2, "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1329
    :cond_0
    :goto_0
    return-void

    .line 1320
    :cond_1
    sget-boolean v1, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v1, :cond_2

    const-string v1, "KochavaTracker"

    const-string v2, "registerSuperProperties"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1322
    :cond_2
    iget-object v1, p0, Lcom/kochava/android/tracker/Feature;->mSuperProperties:Ljava/util/Map;

    if-nez v1, :cond_3

    .line 1323
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature;->mSuperProperties:Ljava/util/Map;

    goto :goto_0

    .line 1325
    :cond_3
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 1326
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v4, p0, Lcom/kochava/android/tracker/Feature;->mSuperProperties:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v4, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1
.end method

.method public setAppLimitTracking(Z)V
    .locals 1
    .param p1, "shouldLimit"    # Z

    .prologue
    .line 944
    new-instance v0, Lcom/kochava/android/tracker/Feature$5;

    invoke-direct {v0, p0, p1}, Lcom/kochava/android/tracker/Feature$5;-><init>(Lcom/kochava/android/tracker/Feature;Z)V

    .line 1024
    .local v0, "changeAppLimitTracking":Ljava/lang/Thread;
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1025
    return-void
.end method

.method public setLatlong(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "lat"    # Ljava/lang/String;
    .param p2, "lon"    # Ljava/lang/String;

    .prologue
    .line 1363
    if-eqz p1, :cond_0

    if-nez p2, :cond_2

    .line 1365
    :cond_0
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v0, :cond_1

    const-string v0, "KochavaTracker"

    const-string v1, "Trying to set lat/long, but one/both of the parameters where null."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1372
    :cond_1
    :goto_0
    return-void

    .line 1368
    :cond_2
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->mContext:Landroid/content/Context;

    const-string v1, "initPrefs"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    .line 1369
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "mylat"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1370
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "mylong"

    invoke-interface {v0, v1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "ver"    # Ljava/lang/String;

    .prologue
    .line 1755
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature;->mAppVersionName:Ljava/lang/String;

    .line 1756
    return-void
.end method

.method public startSession()V
    .locals 4

    .prologue
    .line 1381
    iget-boolean v0, p0, Lcom/kochava/android/tracker/Feature;->badInit:Z

    if-eqz v0, :cond_1

    .line 1383
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUGERROR:Z

    if-eqz v0, :cond_0

    const-string v0, "KochavaTracker"

    const-string v1, "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1405
    :cond_0
    :goto_0
    return-void

    .line 1387
    :cond_1
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v0, :cond_2

    const-string v0, "KochavaTracker"

    const-string v1, "Called Start"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1390
    :cond_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v2, 0x3e8

    div-long/2addr v0, v2

    iput-wide v0, p0, Lcom/kochava/android/tracker/Feature;->startTime:J

    .line 1393
    iget-boolean v0, p0, Lcom/kochava/android/tracker/Feature;->canSendSession:Z

    if-eqz v0, :cond_3

    .line 1395
    const-string v0, "launch"

    invoke-direct {p0, v0}, Lcom/kochava/android/tracker/Feature;->eventSession(Ljava/lang/String;)V

    goto :goto_0

    .line 1399
    :cond_3
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v0, :cond_0

    const-string v0, "KochavaTracker"

    const-string v1, "Session events disabled by server."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
