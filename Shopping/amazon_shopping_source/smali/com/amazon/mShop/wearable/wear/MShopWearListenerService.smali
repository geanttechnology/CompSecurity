.class public Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
.super Lcom/google/android/gms/wearable/WearableListenerService;
.source "MShopWearListenerService.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xb
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$25;,
        Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;,
        Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SpeechResultHandler;,
        Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;,
        Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleResultListener;,
        Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;,
        Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;,
        Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MyHomeResponseListener;,
        Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$OneClickBasicInfoResponseListener;,
        Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MessageHandler;
    }
.end annotation


# static fields
.field private static final DEBUG:Z

.field private static final HANDLER_MAP:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MessageHandler;",
            ">;"
        }
    .end annotation
.end field

.field private static final MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

.field private static final UTF_8:Ljava/nio/charset/Charset;

.field private static sGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

.field private static sImageFetcherThread:Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;

.field private static sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

.field private static sOneClickListener:Lcom/amazon/mShop/control/account/OneClickListener;

.field private static sUserListener:Lcom/amazon/mShop/model/auth/UserListener;

.field private static sWearableNode:Ljava/lang/String;


# instance fields
.field private mWearableService:Lcom/amazon/mShop/wearable/WearableService;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 96
    new-instance v1, Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {v1}, Lcom/fasterxml/jackson/databind/ObjectMapper;-><init>()V

    sput-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 98
    sget-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/databind/ObjectMapper;->getSerializationConfig()Lcom/fasterxml/jackson/databind/SerializationConfig;

    move-result-object v2

    invoke-virtual {v2}, Lcom/fasterxml/jackson/databind/SerializationConfig;->getDefaultVisibilityChecker()Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;

    move-result-object v2

    sget-object v3, Lcom/fasterxml/jackson/annotation/JsonAutoDetect$Visibility;->ANY:Lcom/fasterxml/jackson/annotation/JsonAutoDetect$Visibility;

    invoke-interface {v2, v3}, Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;->withFieldVisibility(Lcom/fasterxml/jackson/annotation/JsonAutoDetect$Visibility;)Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;

    move-result-object v2

    sget-object v3, Lcom/fasterxml/jackson/annotation/JsonAutoDetect$Visibility;->NONE:Lcom/fasterxml/jackson/annotation/JsonAutoDetect$Visibility;

    invoke-interface {v2, v3}, Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;->withGetterVisibility(Lcom/fasterxml/jackson/annotation/JsonAutoDetect$Visibility;)Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;

    move-result-object v2

    sget-object v3, Lcom/fasterxml/jackson/annotation/JsonAutoDetect$Visibility;->NONE:Lcom/fasterxml/jackson/annotation/JsonAutoDetect$Visibility;

    invoke-interface {v2, v3}, Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;->withSetterVisibility(Lcom/fasterxml/jackson/annotation/JsonAutoDetect$Visibility;)Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;

    move-result-object v2

    sget-object v3, Lcom/fasterxml/jackson/annotation/JsonAutoDetect$Visibility;->NONE:Lcom/fasterxml/jackson/annotation/JsonAutoDetect$Visibility;

    invoke-interface {v2, v3}, Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;->withCreatorVisibility(Lcom/fasterxml/jackson/annotation/JsonAutoDetect$Visibility;)Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/fasterxml/jackson/databind/ObjectMapper;->setVisibilityChecker(Lcom/fasterxml/jackson/databind/introspect/VisibilityChecker;)V

    .line 104
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    sput-boolean v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->DEBUG:Z

    .line 106
    const-string/jumbo v1, "UTF-8"

    invoke-static {v1}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v1

    sput-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->UTF_8:Ljava/nio/charset/Charset;

    .line 136
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 137
    .local v0, "builder":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MessageHandler;>;"
    const-string/jumbo v1, "/query/mobileState"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$1;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$1;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 143
    const-string/jumbo v1, "/speech/recognize"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$2;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$2;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 149
    const-string/jumbo v1, "/image"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$3;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$3;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 155
    const-string/jumbo v1, "/search/text"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$4;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$4;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 161
    const-string/jumbo v1, "/open/asin"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$5;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$5;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 167
    const-string/jumbo v1, "/open/search"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$6;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$6;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 173
    const-string/jumbo v1, "/wishlist/asin"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$7;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$7;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 179
    const-string/jumbo v1, "/wishlist/text"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$8;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$8;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 185
    const-string/jumbo v1, "/buy/asin"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$9;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$9;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 191
    const-string/jumbo v1, "/open/settings/locale"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$10;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$10;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 197
    const-string/jumbo v1, "/open/settings/login"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$11;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$11;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 203
    const-string/jumbo v1, "/open/settings/one_click"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$12;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$12;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 209
    const-string/jumbo v1, "/metric/pmet"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$13;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$13;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 215
    const-string/jumbo v1, "/metric/latency"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$14;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$14;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 221
    const-string/jumbo v1, "/metric/clickstream"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$15;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$15;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 227
    const-string/jumbo v1, "/metric/refmarker"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$16;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$16;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 233
    const-string/jumbo v1, "/openMShop"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$17;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$17;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 239
    const-string/jumbo v1, "/report/crash"

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$18;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$18;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 246
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    sput-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->HANDLER_MAP:Ljava/util/Map;

    .line 249
    new-instance v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$19;

    invoke-direct {v1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$19;-><init>()V

    sput-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sUserListener:Lcom/amazon/mShop/model/auth/UserListener;

    .line 266
    new-instance v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$20;

    invoke-direct {v1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$20;-><init>()V

    sput-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sOneClickListener:Lcom/amazon/mShop/control/account/OneClickListener;

    .line 275
    sput-object v4, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    .line 277
    sput-object v4, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sWearableNode:Ljava/lang/String;

    .line 278
    new-instance v1, Lcom/amazon/mShop/wearable/model/MobileState;

    invoke-direct {v1}, Lcom/amazon/mShop/wearable/model/MobileState;-><init>()V

    sput-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 95
    invoke-direct {p0}, Lcom/google/android/gms/wearable/WearableListenerService;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
    .param p1, "x1"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 95
    invoke-direct {p0, p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->onSpeechReconition(Lcom/google/android/gms/wearable/MessageEvent;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
    .param p1, "x1"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 95
    invoke-direct {p0, p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->onRetailSearch(Lcom/google/android/gms/wearable/MessageEvent;)V

    return-void
.end method

.method static synthetic access$1000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    sget-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sWearableNode:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1100(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V
    .locals 0
    .param p0, "x0"    # Ljava/lang/String;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # [B

    .prologue
    .line 95
    invoke-static {p0, p1, p2, p3}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V

    return-void
.end method

.method static synthetic access$1200()V
    .locals 0

    .prologue
    .line 95
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sendMobileState()V

    return-void
.end method

.method static synthetic access$1300()Lcom/google/android/gms/common/api/GoogleApiClient;
    .locals 1

    .prologue
    .line 95
    sget-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    return-object v0
.end method

.method static synthetic access$1400(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Ljava/lang/String;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Ljava/lang/String;

    .prologue
    .line 95
    invoke-static {p0, p1, p2, p3}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->reply(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$1500(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;)Lcom/amazon/mShop/wearable/WearableService;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;

    .prologue
    .line 95
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    return-object v0
.end method

.method static synthetic access$1600()Lcom/fasterxml/jackson/databind/ObjectMapper;
    .locals 1

    .prologue
    .line 95
    sget-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
    .param p1, "x1"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 95
    invoke-direct {p0, p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->onOpenAsin(Lcom/google/android/gms/wearable/MessageEvent;)V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
    .param p1, "x1"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 95
    invoke-direct {p0, p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->onOpenSearch(Lcom/google/android/gms/wearable/MessageEvent;)V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
    .param p1, "x1"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 95
    invoke-direct {p0, p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->onWishlistAsin(Lcom/google/android/gms/wearable/MessageEvent;)V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
    .param p1, "x1"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 95
    invoke-direct {p0, p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->onWishlistText(Lcom/google/android/gms/wearable/MessageEvent;)V

    return-void
.end method

.method static synthetic access$600()V
    .locals 0

    .prologue
    .line 95
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->updateMobileState()V

    return-void
.end method

.method static synthetic access$700()Lcom/amazon/mShop/wearable/model/MobileState;
    .locals 1

    .prologue
    .line 95
    sget-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    return-object v0
.end method

.method private static fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    .locals 8
    .param p0, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 114
    new-instance v2, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    invoke-direct {v2}, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;-><init>()V

    .line 115
    .local v2, "result":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    if-eqz p0, :cond_0

    invoke-interface {p0}, Lcom/google/android/gms/wearable/MessageEvent;->getData()[B

    move-result-object v3

    if-eqz v3, :cond_0

    .line 117
    :try_start_0
    sget-object v3, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-interface {p0}, Lcom/google/android/gms/wearable/MessageEvent;->getData()[B

    move-result-object v4

    const-class v5, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    invoke-virtual {v3, v4, v5}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue([BLjava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    move-object v0, v3

    check-cast v0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-object v2, v0
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 122
    :cond_0
    :goto_0
    return-object v2

    .line 118
    :catch_0
    move-exception v1

    .line 119
    .local v1, "e":Ljava/io/IOException;
    const-string/jumbo v3, "WearListenerService"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Unable to parse incoming message: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    new-instance v5, Ljava/lang/String;

    invoke-interface {p0}, Lcom/google/android/gms/wearable/MessageEvent;->getData()[B

    move-result-object v6

    sget-object v7, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v5, v6, v7}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private final varargs meetsConditions(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;)Z
    .locals 7
    .param p1, "node"    # Ljava/lang/String;
    .param p2, "messageId"    # Ljava/lang/String;
    .param p3, "requirements"    # [Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    .prologue
    const/4 v4, 0x0

    .line 588
    move-object v0, p3

    .local v0, "arr$":[Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 589
    .local v3, "requirement":Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;
    sget-object v5, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$25;->$SwitchMap$com$amazon$mShop$wearable$wear$MShopWearListenerService$Requirement:[I

    invoke-virtual {v3}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_0

    .line 588
    :cond_0
    :pswitch_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 591
    :pswitch_1
    const-string/jumbo v5, "en_US"

    invoke-static {v5}, Lcom/amazon/mShop/util/LocaleUtils;->isCurrentLocale(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 592
    const-string/jumbo v5, "/error/locale"

    invoke-static {p1, p2, v5}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->reply(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 608
    .end local v3    # "requirement":Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;
    :goto_1
    return v4

    .line 601
    .restart local v3    # "requirement":Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;
    :pswitch_2
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->hasAmazonAccount()Z

    move-result v5

    if-nez v5, :cond_0

    .line 602
    const-string/jumbo v5, "/error/auth"

    invoke-static {p1, p2, v5}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->reply(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 608
    .end local v3    # "requirement":Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;
    :cond_1
    const/4 v4, 0x1

    goto :goto_1

    .line 589
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method private onOpenAsin(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 10
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 718
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v7

    .line 719
    .local v7, "node":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v6

    .line 720
    .local v6, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    iget-object v0, v6, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    const/4 v1, 0x1

    new-array v1, v1, [Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    const/4 v2, 0x0

    sget-object v3, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->US_LOCALE:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    aput-object v3, v1, v2

    invoke-direct {p0, v7, v0, v1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->meetsConditions(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 728
    :goto_0
    return-void

    .line 723
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    invoke-virtual {v6}, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->dataAsString()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "offerId"

    const-string/jumbo v3, ""

    sget-object v4, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_WEARABLES_WEAR:Lcom/amazon/mShop/control/item/ClickStreamTag;

    new-instance v5, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;

    iget-object v8, v6, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    const-string/jumbo v9, "/open/asin"

    invoke-direct {v5, p0, v7, v8, v9}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface/range {v0 .. v5}, Lcom/amazon/mShop/wearable/WearableService;->openProductPage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;Lcom/amazon/mShop/wearable/ResultListener;)V

    goto :goto_0
.end method

.method private onOpenSearch(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 7
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 706
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v1

    .line 707
    .local v1, "node":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v0

    .line 708
    .local v0, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    iget-object v2, v0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    const/4 v3, 0x1

    new-array v3, v3, [Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    const/4 v4, 0x0

    sget-object v5, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->US_LOCALE:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    aput-object v5, v3, v4

    invoke-direct {p0, v1, v2, v3}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->meetsConditions(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 715
    :goto_0
    return-void

    .line 711
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    invoke-virtual {v0}, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->dataAsString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;

    iget-object v5, v0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    const-string/jumbo v6, "/search/text"

    invoke-direct {v4, p0, v1, v5, v6}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3, v4}, Lcom/amazon/mShop/wearable/WearableService;->openTextSearchResults(Ljava/lang/String;Lcom/amazon/mShop/wearable/ResultListener;)V

    goto :goto_0
.end method

.method private onRetailSearch(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 7
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 731
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->updateMobileState()V

    .line 732
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v1

    .line 733
    .local v1, "node":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v0

    .line 734
    .local v0, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    iget-object v3, v0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    const/4 v4, 0x1

    new-array v4, v4, [Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    const/4 v5, 0x0

    sget-object v6, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->US_LOCALE:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    aput-object v6, v4, v5

    invoke-direct {p0, v1, v3, v4}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->meetsConditions(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 761
    :goto_0
    return-void

    .line 737
    :cond_0
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 738
    .local v2, "results":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/wearable/model/WearableSearchResult;>;"
    iget-object v3, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    invoke-virtual {v0}, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->dataAsString()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$24;

    iget-object v6, v0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    invoke-direct {v5, p0, v1, v6, v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$24;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    invoke-interface {v3, v4, v5}, Lcom/amazon/mShop/wearable/WearableService;->searchByText(Ljava/lang/String;Lcom/amazon/mShop/wearable/SearchResultListener;)V

    goto :goto_0
.end method

.method private onSpeechReconition(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 10
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    const/4 v7, 0x1

    const/4 v9, 0x0

    .line 801
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v4

    .line 802
    .local v4, "node":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v3

    .line 803
    .local v3, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    iget-object v6, v3, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    new-array v7, v7, [Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    sget-object v8, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->US_LOCALE:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    aput-object v8, v7, v9

    invoke-direct {p0, v4, v6, v7}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->meetsConditions(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 818
    :goto_0
    return-void

    .line 807
    :cond_0
    invoke-static {}, Lamazon/android/dexload/SupplementalDexLoader;->getInstance()Lamazon/android/dexload/SupplementalDexLoader;

    move-result-object v6

    invoke-virtual {v6}, Lamazon/android/dexload/SupplementalDexLoader;->waitForLoad()V

    .line 808
    new-instance v5, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;

    iget-object v6, v3, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    invoke-direct {v5, p0, v4, v6}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;)V

    .line 810
    .local v5, "resultHandler":Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SpeechResultHandler;
    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v6

    const-string/jumbo v7, "com.amazon.mShop.wearable.wear.speech.SpeechRequestHandler"

    invoke-virtual {v6, v7}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 811
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v0}, Ljava/lang/Class;->getDeclaredConstructors()[Ljava/lang/reflect/Constructor;

    move-result-object v6

    const/4 v7, 0x0

    aget-object v1, v6, v7

    .line 813
    .local v1, "ctor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p0, v6, v7

    const/4 v7, 0x1

    iget-object v8, v3, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mData:[B

    aput-object v8, v6, v7

    const/4 v7, 0x2

    aput-object v5, v6, v7

    invoke-virtual {v1, v6}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Runnable;

    check-cast v6, Ljava/lang/Runnable;

    invoke-interface {v6}, Ljava/lang/Runnable;->run()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 814
    .end local v0    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v1    # "ctor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    :catch_0
    move-exception v2

    .line 815
    .local v2, "e":Ljava/lang/Exception;
    const-string/jumbo v6, "WearListenerService"

    const-string/jumbo v7, "Failed to load speech recognition module"

    invoke-static {v6, v7, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 816
    invoke-interface {v5}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SpeechResultHandler;->onError()V

    goto :goto_0
.end method

.method private onWishlistAsin(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 10
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 669
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v2

    .line 670
    .local v2, "node":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v7

    .line 671
    .local v7, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    iget-object v0, v7, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    const/4 v1, 0x2

    new-array v1, v1, [Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    const/4 v3, 0x0

    sget-object v4, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->US_LOCALE:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    aput-object v4, v1, v3

    const/4 v3, 0x1

    sget-object v4, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->AUTH:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    aput-object v4, v1, v3

    invoke-direct {p0, v2, v0, v1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->meetsConditions(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 681
    :goto_0
    return-void

    .line 675
    :cond_0
    iget-object v8, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    invoke-virtual {v7}, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->dataAsString()Ljava/lang/String;

    move-result-object v9

    new-instance v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;

    iget-object v3, v7, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    const-string/jumbo v4, "/wishlist/asin"

    const-string/jumbo v5, "WearAddtoWLCount"

    const-string/jumbo v6, "WearAddtoWLError"

    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v9, v0}, Lcom/amazon/mShop/wearable/WearableService;->addProductToWishList(Ljava/lang/String;Lcom/amazon/mShop/wearable/ResultListener;)V

    goto :goto_0
.end method

.method private onWishlistText(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 10
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 655
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v2

    .line 656
    .local v2, "node":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v7

    .line 657
    .local v7, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    iget-object v0, v7, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    const/4 v1, 0x2

    new-array v1, v1, [Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    const/4 v3, 0x0

    sget-object v4, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->US_LOCALE:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    aput-object v4, v1, v3

    const/4 v3, 0x1

    sget-object v4, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->AUTH:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    aput-object v4, v1, v3

    invoke-direct {p0, v2, v0, v1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->meetsConditions(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 666
    :goto_0
    return-void

    .line 660
    :cond_0
    iget-object v8, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    invoke-virtual {v7}, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->dataAsString()Ljava/lang/String;

    move-result-object v9

    new-instance v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;

    iget-object v3, v7, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    const-string/jumbo v4, "/wishlist/text"

    const-string/jumbo v5, "WearSaveTextIdeatoWLCount"

    const-string/jumbo v6, "WearSaveTextIdeatoWLError"

    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v9, v0}, Lcom/amazon/mShop/wearable/WearableService;->addTextToWishlist(Ljava/lang/String;Lcom/amazon/mShop/wearable/ResultListener;)V

    goto :goto_0
.end method

.method private static reply(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "node"    # Ljava/lang/String;
    .param p1, "messageId"    # Ljava/lang/String;
    .param p2, "path"    # Ljava/lang/String;

    .prologue
    .line 502
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V

    .line 503
    return-void
.end method

.method private static reply(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "node"    # Ljava/lang/String;
    .param p1, "messageId"    # Ljava/lang/String;
    .param p2, "path"    # Ljava/lang/String;
    .param p3, "data"    # Ljava/lang/String;

    .prologue
    .line 510
    if-nez p3, :cond_0

    .line 511
    const/4 v0, 0x0

    check-cast v0, [B

    invoke-static {p0, p1, p2, v0}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->reply(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V

    .line 515
    :goto_0
    return-void

    .line 513
    :cond_0
    sget-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {p3, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->reply(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V

    goto :goto_0
.end method

.method private static reply(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V
    .locals 0
    .param p0, "node"    # Ljava/lang/String;
    .param p1, "messageId"    # Ljava/lang/String;
    .param p2, "path"    # Ljava/lang/String;
    .param p3, "data"    # [B

    .prologue
    .line 506
    invoke-static {p0, p1, p2, p3}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V

    .line 507
    return-void
.end method

.method private static sendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V
    .locals 5
    .param p0, "node"    # Ljava/lang/String;
    .param p1, "messageId"    # Ljava/lang/String;
    .param p2, "replyPath"    # Ljava/lang/String;
    .param p3, "data"    # [B

    .prologue
    .line 478
    sget-boolean v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 479
    const-string/jumbo v1, "WearListenerService"

    const-string/jumbo v2, "Sending reply to wearable node %s on path %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    const/4 v4, 0x1

    aput-object p2, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 481
    :cond_0
    sget-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-interface {v1}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v1

    if-nez v1, :cond_1

    .line 482
    sget-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-interface {v1}, Lcom/google/android/gms/common/api/GoogleApiClient;->blockingConnect()Lcom/google/android/gms/common/ConnectionResult;

    .line 484
    :cond_1
    new-instance v1, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    invoke-direct {v1, p1, p3}, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;-><init>(Ljava/lang/String;[B)V

    invoke-static {v1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->toBytes(Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;)[B

    move-result-object v0

    .line 485
    .local v0, "stampedData":[B
    if-eqz p0, :cond_2

    .line 486
    sget-object v1, Lcom/google/android/gms/wearable/Wearable;->MessageApi:Lcom/google/android/gms/wearable/MessageApi;

    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-interface {v1, v2, p0, p2, v0}, Lcom/google/android/gms/wearable/MessageApi;->sendMessage(Lcom/google/android/gms/common/api/GoogleApiClient;Ljava/lang/String;Ljava/lang/String;[B)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v1

    invoke-interface {v1}, Lcom/google/android/gms/common/api/PendingResult;->await()Lcom/google/android/gms/common/api/Result;

    .line 499
    :goto_0
    return-void

    .line 488
    :cond_2
    sget-object v1, Lcom/google/android/gms/wearable/Wearable;->NodeApi:Lcom/google/android/gms/wearable/NodeApi;

    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-interface {v1, v2}, Lcom/google/android/gms/wearable/NodeApi;->getConnectedNodes(Lcom/google/android/gms/common/api/GoogleApiClient;)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$23;

    invoke-direct {v2, p2, v0}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$23;-><init>(Ljava/lang/String;[B)V

    invoke-interface {v1, v2}, Lcom/google/android/gms/common/api/PendingResult;->setResultCallback(Lcom/google/android/gms/common/api/ResultCallback;)V

    goto :goto_0
.end method

.method private static declared-synchronized sendMobileState()V
    .locals 11

    .prologue
    .line 347
    const-class v6, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;

    monitor-enter v6

    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 349
    .local v2, "now":J
    sget-object v5, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    iget-wide v7, v5, Lcom/amazon/mShop/wearable/model/MobileState;->updateTime:J

    cmp-long v5, v2, v7

    if-gtz v5, :cond_1

    .line 350
    sget-object v5, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    iget-wide v7, v5, Lcom/amazon/mShop/wearable/model/MobileState;->updateTime:J

    const-wide/16 v9, 0x1

    add-long/2addr v7, v9

    iput-wide v7, v5, Lcom/amazon/mShop/wearable/model/MobileState;->updateTime:J

    .line 355
    :goto_0
    sget-object v5, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/ObjectMapper;->writerWithDefaultPrettyPrinter()Lcom/fasterxml/jackson/databind/ObjectWriter;

    move-result-object v5

    sget-object v7, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    invoke-virtual {v5, v7}, Lcom/fasterxml/jackson/databind/ObjectWriter;->writeValueAsString(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 356
    .local v1, "json":Ljava/lang/String;
    sget-boolean v5, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->DEBUG:Z

    if-eqz v5, :cond_0

    .line 357
    const-string/jumbo v5, "WearListenerService"

    invoke-static {v5, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 359
    :cond_0
    sget-object v5, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {v1, v5}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B
    :try_end_0
    .catch Lcom/fasterxml/jackson/core/JsonProcessingException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v4

    .line 363
    .local v4, "responseJson":[B
    :try_start_1
    new-instance v5, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$21;

    invoke-direct {v5, v4}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$21;-><init>([B)V

    sget-object v7, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    const/4 v8, 0x0

    new-array v8, v8, [Ljava/lang/Void;

    invoke-virtual {v5, v7, v8}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$21;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 370
    monitor-exit v6

    return-void

    .line 352
    .end local v1    # "json":Ljava/lang/String;
    .end local v4    # "responseJson":[B
    :cond_1
    :try_start_2
    sget-object v5, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    iput-wide v2, v5, Lcom/amazon/mShop/wearable/model/MobileState;->updateTime:J
    :try_end_2
    .catch Lcom/fasterxml/jackson/core/JsonProcessingException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 360
    :catch_0
    move-exception v0

    .line 361
    .local v0, "e":Lcom/fasterxml/jackson/core/JsonProcessingException;
    :try_start_3
    new-instance v5, Ljava/lang/IllegalStateException;

    invoke-direct {v5, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v5
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 347
    .end local v0    # "e":Lcom/fasterxml/jackson/core/JsonProcessingException;
    :catchall_0
    move-exception v5

    monitor-exit v6

    throw v5
.end method

.method public static toBytes(Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;)[B
    .locals 2
    .param p0, "message"    # Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    .prologue
    .line 127
    :try_start_0
    sget-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v1, p0}, Lcom/fasterxml/jackson/databind/ObjectMapper;->writeValueAsBytes(Ljava/lang/Object;)[B
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 129
    :goto_0
    return-object v1

    .line 128
    :catch_0
    move-exception v0

    .line 129
    .local v0, "e":Ljava/io/IOException;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private static updateMobileState()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 302
    sget-boolean v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->DEBUG:Z

    if-eqz v2, :cond_0

    .line 303
    const-string/jumbo v2, "WearListenerService"

    const-string/jumbo v3, "Update mobile state called"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 305
    :cond_0
    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    const-string/jumbo v3, "en_US"

    invoke-static {v3}, Lcom/amazon/mShop/util/LocaleUtils;->isCurrentLocale(Ljava/lang/String;)Z

    move-result v3

    iput-boolean v3, v2, Lcom/amazon/mShop/wearable/model/MobileState;->supportedLocale:Z

    .line 306
    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->hasNetworkConnection()Z

    move-result v3

    iput-boolean v3, v2, Lcom/amazon/mShop/wearable/model/MobileState;->networkAvailable:Z

    .line 307
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v1

    .line 308
    .local v1, "user":Lcom/amazon/mShop/model/auth/User;
    if-eqz v1, :cond_2

    .line 309
    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    const/4 v3, 0x1

    iput-boolean v3, v2, Lcom/amazon/mShop/wearable/model/MobileState;->loggedIn:Z

    .line 310
    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    invoke-virtual {v1}, Lcom/amazon/mShop/model/auth/User;->isPrime()Z

    move-result v3

    iput-boolean v3, v2, Lcom/amazon/mShop/wearable/model/MobileState;->prime:Z

    .line 319
    :goto_0
    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v3

    const-string/jumbo v4, "Android_Wear_OneClick_Buy"

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/feature/Features;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v3

    iput-boolean v3, v2, Lcom/amazon/mShop/wearable/model/MobileState;->weblabOneClickDisabled:Z

    .line 322
    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v3

    const-string/jumbo v4, "WearableDevicesDisabled"

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/feature/Features;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v3

    iput-boolean v3, v2, Lcom/amazon/mShop/wearable/model/MobileState;->weblabWearableDeviceDisabled:Z

    .line 325
    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    iget-boolean v2, v2, Lcom/amazon/mShop/wearable/model/MobileState;->loggedIn:Z

    if-eqz v2, :cond_1

    .line 327
    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v2

    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;-><init>()V

    new-instance v4, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MyHomeResponseListener;

    const/4 v5, 0x0

    invoke-direct {v4, v5}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MyHomeResponseListener;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$1;)V

    invoke-interface {v2, v3, v4}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->home(Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;Lcom/amazon/rio/j2me/client/services/mShop/HomeResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 334
    :goto_1
    :try_start_1
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v2

    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoRequest;

    invoke-direct {v3}, Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoRequest;-><init>()V

    new-instance v4, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$OneClickBasicInfoResponseListener;

    const/4 v5, 0x0

    invoke-direct {v4, v5}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$OneClickBasicInfoResponseListener;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$1;)V

    invoke-interface {v2, v3, v4}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->getOneClickBasicInfo(Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 341
    :cond_1
    :goto_2
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sendMobileState()V

    .line 342
    return-void

    .line 312
    :cond_2
    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    iput-boolean v5, v2, Lcom/amazon/mShop/wearable/model/MobileState;->oneClickEnabled:Z

    .line 313
    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    iput-boolean v5, v2, Lcom/amazon/mShop/wearable/model/MobileState;->loggedIn:Z

    .line 314
    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    iput-boolean v5, v2, Lcom/amazon/mShop/wearable/model/MobileState;->prime:Z

    .line 315
    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    iput-object v4, v2, Lcom/amazon/mShop/wearable/model/MobileState;->oneClickCity:Ljava/lang/String;

    .line 316
    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;

    iput-object v4, v2, Lcom/amazon/mShop/wearable/model/MobileState;->oneClickName:Ljava/lang/String;

    goto :goto_0

    .line 329
    :catch_0
    move-exception v0

    .line 330
    .local v0, "ex":Ljava/lang/Exception;
    const-string/jumbo v2, "WearListenerService"

    const-string/jumbo v3, "Error while trying to get one click basic info"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1

    .line 336
    .end local v0    # "ex":Ljava/lang/Exception;
    :catch_1
    move-exception v0

    .line 337
    .restart local v0    # "ex":Ljava/lang/Exception;
    const-string/jumbo v2, "WearListenerService"

    const-string/jumbo v3, "Error while trying to get one click basic info"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_2
.end method


# virtual methods
.method protected onAddLatencyMetrics(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 11
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 842
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v4

    .line 843
    .local v4, "node":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v1

    .line 845
    .local v1, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    :try_start_0
    sget-object v8, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v9, v1, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mData:[B

    invoke-virtual {v8, v9}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readTree([B)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v2

    .line 846
    .local v2, "messageNode":Lcom/fasterxml/jackson/databind/JsonNode;
    const-string/jumbo v8, "source"

    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v8

    invoke-virtual {v8}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v5

    .line 847
    .local v5, "source":Ljava/lang/String;
    const-string/jumbo v8, "timerName"

    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v8

    invoke-virtual {v8}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v3

    .line 848
    .local v3, "metric":Ljava/lang/String;
    const-string/jumbo v8, "timerValue"

    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v8

    const-wide/16 v9, 0x0

    invoke-virtual {v8, v9, v10}, Lcom/fasterxml/jackson/databind/JsonNode;->asDouble(D)D

    move-result-wide v6

    .line 849
    .local v6, "value":D
    iget-object v8, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    invoke-interface {v8, v5, v3, v6, v7}, Lcom/amazon/mShop/wearable/WearableService;->addTimer(Ljava/lang/String;Ljava/lang/String;D)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 853
    .end local v2    # "messageNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v3    # "metric":Ljava/lang/String;
    .end local v5    # "source":Ljava/lang/String;
    .end local v6    # "value":D
    :goto_0
    return-void

    .line 850
    :catch_0
    move-exception v0

    .line 851
    .local v0, "e":Ljava/io/IOException;
    const-string/jumbo v8, "WearListenerService"

    const-string/jumbo v9, "Unable to parse message from wearable device for latency metrics"

    invoke-static {v8, v9, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public onCreate()V
    .locals 2

    .prologue
    .line 282
    invoke-super {p0}, Lcom/google/android/gms/wearable/WearableListenerService;->onCreate()V

    .line 283
    sget-boolean v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 284
    const-string/jumbo v0, "WearListenerService"

    const-string/jumbo v1, "Started MShop wear listener service"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 286
    :cond_0
    new-instance v0, Lcom/amazon/mShop/wearable/WearableServiceImpl;

    sget-object v1, Lcom/amazon/mShop/wearable/WearableDeviceType;->AndroidWear:Lcom/amazon/mShop/wearable/WearableDeviceType;

    invoke-direct {v0, p0, v1}, Lcom/amazon/mShop/wearable/WearableServiceImpl;-><init>(Landroid/content/Context;Lcom/amazon/mShop/wearable/WearableDeviceType;)V

    iput-object v0, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    .line 287
    sget-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    if-nez v0, :cond_1

    .line 288
    new-instance v0, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    invoke-virtual {p0}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;-><init>(Landroid/content/Context;)V

    sget-object v1, Lcom/google/android/gms/wearable/Wearable;->API:Lcom/google/android/gms/common/api/Api;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->addApi(Lcom/google/android/gms/common/api/Api;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/GoogleApiClient$Builder;->build()Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    .line 289
    new-instance v0, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;

    sget-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-direct {v0, v1}, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;-><init>(Lcom/google/android/gms/common/api/GoogleApiClient;)V

    sput-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sImageFetcherThread:Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;

    .line 290
    sget-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sUserListener:Lcom/amazon/mShop/model/auth/UserListener;

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 292
    :cond_1
    return-void
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 296
    sget-boolean v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 297
    const-string/jumbo v0, "WearListenerService"

    const-string/jumbo v1, "Stopped MShop wear listener service"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 299
    :cond_0
    return-void
.end method

.method protected onEmitClickStream(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 15
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 856
    invoke-interface/range {p1 .. p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v13

    .line 857
    .local v13, "node":Ljava/lang/String;
    invoke-static/range {p1 .. p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v11

    .line 859
    .local v11, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    :try_start_0
    sget-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v14, v11, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mData:[B

    invoke-virtual {v0, v14}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readTree([B)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v12

    .line 860
    .local v12, "messageNode":Lcom/fasterxml/jackson/databind/JsonNode;
    const-string/jumbo v0, "source"

    invoke-virtual {v12, v0}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v1

    .line 861
    .local v1, "source":Ljava/lang/String;
    const-string/jumbo v0, "pageType"

    invoke-virtual {v12, v0}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v2

    .line 862
    .local v2, "pageType":Ljava/lang/String;
    const-string/jumbo v0, "pageTypeId"

    invoke-virtual {v12, v0}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v3

    .line 863
    .local v3, "pageTypeId":Ljava/lang/String;
    const-string/jumbo v0, "subPageType"

    invoke-virtual {v12, v0}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v4

    .line 864
    .local v4, "subPageType":Ljava/lang/String;
    const-string/jumbo v0, "hitType"

    invoke-virtual {v12, v0}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v5

    .line 865
    .local v5, "hitType":Ljava/lang/String;
    const-string/jumbo v0, "pageAction"

    invoke-virtual {v12, v0}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v6

    .line 866
    .local v6, "pageAction":Ljava/lang/String;
    const-string/jumbo v0, "counterName"

    invoke-virtual {v12, v0}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v7

    .line 867
    .local v7, "counterName":Ljava/lang/String;
    const-string/jumbo v0, "refTag"

    invoke-virtual {v12, v0}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v8

    .line 868
    .local v8, "reftag":Ljava/lang/String;
    const-string/jumbo v0, "count"

    invoke-virtual {v12, v0}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    const/4 v14, 0x0

    invoke-virtual {v0, v14}, Lcom/fasterxml/jackson/databind/JsonNode;->asInt(I)I

    move-result v9

    .line 869
    .local v9, "count":I
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    invoke-interface/range {v0 .. v9}, Lcom/amazon/mShop/wearable/WearableService;->emitClickStream(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 874
    .end local v1    # "source":Ljava/lang/String;
    .end local v2    # "pageType":Ljava/lang/String;
    .end local v3    # "pageTypeId":Ljava/lang/String;
    .end local v4    # "subPageType":Ljava/lang/String;
    .end local v5    # "hitType":Ljava/lang/String;
    .end local v6    # "pageAction":Ljava/lang/String;
    .end local v7    # "counterName":Ljava/lang/String;
    .end local v8    # "reftag":Ljava/lang/String;
    .end local v9    # "count":I
    .end local v12    # "messageNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :goto_0
    return-void

    .line 871
    :catch_0
    move-exception v10

    .line 872
    .local v10, "e":Ljava/io/IOException;
    const-string/jumbo v0, "WearListenerService"

    const-string/jumbo v14, "Unable to parse message from wearable device for clickstream counter"

    invoke-static {v0, v14, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method protected onIncrementPMETCounter(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 10
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 821
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v5

    .line 822
    .local v5, "node":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v2

    .line 828
    .local v2, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    :try_start_0
    sget-boolean v7, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->DEBUG:Z

    if-eqz v7, :cond_0

    .line 829
    const-string/jumbo v7, "WearListenerService"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "Received PMET metric :data : "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v2}, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->dataAsString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 831
    :cond_0
    sget-object v7, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v8, v2, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mData:[B

    invoke-virtual {v7, v8}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readTree([B)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v3

    .line 832
    .local v3, "messageNode":Lcom/fasterxml/jackson/databind/JsonNode;
    const-string/jumbo v7, "source"

    invoke-virtual {v3, v7}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v7

    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v6

    .line 833
    .local v6, "source":Ljava/lang/String;
    const-string/jumbo v7, "counterName"

    invoke-virtual {v3, v7}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v7

    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v4

    .line 834
    .local v4, "metric":Ljava/lang/String;
    const-string/jumbo v7, "count"

    invoke-virtual {v3, v7}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v7, v8}, Lcom/fasterxml/jackson/databind/JsonNode;->asInt(I)I

    move-result v0

    .line 835
    .local v0, "count":I
    iget-object v7, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    invoke-interface {v7, v6, v4, v0}, Lcom/amazon/mShop/wearable/WearableService;->incrementMetricCounter(Ljava/lang/String;Ljava/lang/String;I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 839
    .end local v0    # "count":I
    .end local v3    # "messageNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v4    # "metric":Ljava/lang/String;
    .end local v6    # "source":Ljava/lang/String;
    :goto_0
    return-void

    .line 836
    :catch_0
    move-exception v1

    .line 837
    .local v1, "e":Ljava/io/IOException;
    const-string/jumbo v7, "WearListenerService"

    const-string/jumbo v8, "Unable to parse message from wearable device for PMET counter"

    invoke-static {v7, v8, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method protected onLoadImage(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 4
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 614
    invoke-static {p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v0

    .line 615
    .local v0, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    sget-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sImageFetcherThread:Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;

    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->dataAsString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->fetchImage(Ljava/lang/String;Ljava/lang/String;)V

    .line 616
    return-void
.end method

.method protected onLogRefmarker(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 4
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 877
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v1

    .line 878
    .local v1, "node":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v0

    .line 879
    .local v0, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    iget-object v2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    invoke-virtual {v0}, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->dataAsString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/amazon/mShop/wearable/WearableService;->logRefMarker(Ljava/lang/String;)V

    .line 880
    return-void
.end method

.method public onMessageReceived(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 6
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x13
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 456
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getPath()Ljava/lang/String;

    move-result-object v1

    .line 457
    .local v1, "path":Ljava/lang/String;
    sget-boolean v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->DEBUG:Z

    if-eqz v2, :cond_0

    .line 458
    const-string/jumbo v2, "WearListenerService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "got message for path "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 461
    :cond_0
    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->HANDLER_MAP:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 462
    const-string/jumbo v2, "WearListenerService"

    const-string/jumbo v3, "Unknown message for path %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    aput-object v1, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 474
    :goto_0
    return-void

    .line 466
    :cond_1
    sget-object v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->HANDLER_MAP:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MessageHandler;

    .line 467
    .local v0, "handler":Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MessageHandler;
    new-instance v2, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$22;

    invoke-direct {v2, p0, v0, p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$22;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MessageHandler;Lcom/google/android/gms/wearable/MessageEvent;)V

    sget-object v3, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    new-array v4, v5, [Ljava/lang/Void;

    invoke-virtual {v2, v3, v4}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$22;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method protected onOpenMShop(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 3
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 619
    invoke-static {p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v0

    .line 620
    .local v0, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    iget-object v1, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    invoke-virtual {v0}, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->dataAsString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/amazon/mShop/wearable/WearableService;->openMShopHome(Ljava/lang/String;)V

    .line 621
    return-void
.end method

.method protected onOpenSettingsLocale(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 6
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 629
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v1

    .line 630
    .local v1, "node":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v0

    .line 631
    .local v0, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    iget-object v2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    new-instance v3, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;

    iget-object v4, v0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    const-string/jumbo v5, "/open/settings/locale"

    invoke-direct {v3, p0, v1, v4, v5}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Lcom/amazon/mShop/wearable/WearableService;->openLocaleSettings(Lcom/amazon/mShop/wearable/ResultListener;)V

    .line 634
    return-void
.end method

.method protected onOpenSettingsLogin(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 6
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 637
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v1

    .line 638
    .local v1, "node":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v0

    .line 639
    .local v0, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    iget-object v2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    new-instance v3, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;

    iget-object v4, v0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    const-string/jumbo v5, "/open/settings/login"

    invoke-direct {v3, p0, v1, v4, v5}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Lcom/amazon/mShop/wearable/WearableService;->openLoginUi(Lcom/amazon/mShop/wearable/ResultListener;)V

    .line 642
    return-void
.end method

.method protected onOpenSettingsOneClick(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 6
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 645
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v1

    .line 646
    .local v1, "node":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v0

    .line 647
    .local v0, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    iget-object v2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    new-instance v3, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;

    iget-object v4, v0, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    const-string/jumbo v5, "/open/settings/one_click"

    invoke-direct {v3, p0, v1, v4, v5}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Lcom/amazon/mShop/wearable/WearableService;->openOneClickSettings(Lcom/amazon/mShop/wearable/ResultListener;)V

    .line 650
    return-void
.end method

.method public onPeerConnected(Lcom/google/android/gms/wearable/Node;)V
    .locals 3
    .param p1, "peer"    # Lcom/google/android/gms/wearable/Node;

    .prologue
    .line 900
    sget-boolean v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 901
    const-string/jumbo v0, "WearListenerService"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "got peer connected "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 903
    :cond_0
    return-void
.end method

.method public onPeerDisconnected(Lcom/google/android/gms/wearable/Node;)V
    .locals 3
    .param p1, "peer"    # Lcom/google/android/gms/wearable/Node;

    .prologue
    .line 907
    sget-boolean v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 908
    const-string/jumbo v0, "WearListenerService"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "got peer disconnected "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 910
    :cond_0
    return-void
.end method

.method protected onPurchaseAsin(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 12
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 684
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v2

    .line 685
    .local v2, "node":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->fromMessageEvent(Lcom/google/android/gms/wearable/MessageEvent;)Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    move-result-object v9

    .line 686
    .local v9, "envelope":Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;
    iget-object v1, v9, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    const/4 v3, 0x2

    new-array v3, v3, [Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    const/4 v4, 0x0

    sget-object v5, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->US_LOCALE:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    sget-object v5, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->AUTH:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    aput-object v5, v3, v4

    invoke-direct {p0, v2, v1, v3}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->meetsConditions(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 703
    :goto_0
    return-void

    .line 690
    :cond_0
    new-instance v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;

    iget-object v3, v9, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mId:Ljava/lang/String;

    const-string/jumbo v4, "/buy/asin"

    const-string/jumbo v5, "WearBuyCount"

    const-string/jumbo v6, "WearBuyError"

    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 696
    .local v0, "listener":Lcom/amazon/mShop/wearable/ResultListener;
    :try_start_0
    sget-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->MAPPER:Lcom/fasterxml/jackson/databind/ObjectMapper;

    iget-object v3, v9, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;->mData:[B

    invoke-virtual {v1, v3}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readTree([B)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v10

    .line 697
    .local v10, "messageNode":Lcom/fasterxml/jackson/databind/JsonNode;
    const-string/jumbo v1, "asin"

    invoke-virtual {v10, v1}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v1

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v7

    .line 698
    .local v7, "asin":Ljava/lang/String;
    const-string/jumbo v1, "offerId"

    invoke-virtual {v10, v1}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v1

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v11

    .line 699
    .local v11, "offerId":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;

    sget-object v3, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_WEARABLES_WEAR:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-interface {v1, v7, v11, v3, v0}, Lcom/amazon/mShop/wearable/WearableService;->purchaseProduct(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;Lcom/amazon/mShop/wearable/ResultListener;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 700
    .end local v7    # "asin":Ljava/lang/String;
    .end local v10    # "messageNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v11    # "offerId":Ljava/lang/String;
    :catch_0
    move-exception v8

    .line 701
    .local v8, "e":Ljava/io/IOException;
    const-string/jumbo v1, "Unable to parse message from wearable device"

    invoke-interface {v0, v1, v8}, Lcom/amazon/mShop/wearable/ResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method protected onQueryMobileState(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 1
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 624
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getSourceNodeId()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sWearableNode:Ljava/lang/String;

    .line 625
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->updateMobileState()V

    .line 626
    return-void
.end method

.method protected onReportWearCrash(Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 7
    .param p1, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 884
    :try_start_0
    invoke-interface {p1}, Lcom/google/android/gms/wearable/MessageEvent;->getData()[B

    move-result-object v5

    invoke-static {v5}, Lcom/google/android/gms/wearable/DataMap;->fromByteArray([B)Lcom/google/android/gms/wearable/DataMap;

    move-result-object v3

    .line 885
    .local v3, "map":Lcom/google/android/gms/wearable/DataMap;
    new-instance v0, Ljava/io/ByteArrayInputStream;

    const-string/jumbo v5, "CrashExceptionKey"

    invoke-virtual {v3, v5}, Lcom/google/android/gms/wearable/DataMap;->getByteArray(Ljava/lang/String;)[B

    move-result-object v5

    invoke-direct {v0, v5}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 887
    .local v0, "bis":Ljava/io/ByteArrayInputStream;
    new-instance v4, Ljava/io/ObjectInputStream;

    invoke-direct {v4, v0}, Ljava/io/ObjectInputStream;-><init>(Ljava/io/InputStream;)V

    .line 888
    .local v4, "ois":Ljava/io/ObjectInputStream;
    invoke-virtual {v4}, Ljava/io/ObjectInputStream;->readObject()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Throwable;

    .line 889
    .local v2, "ex":Ljava/lang/Throwable;
    const-string/jumbo v5, "CrashExceptionKey"

    invoke-virtual {v3, v5}, Lcom/google/android/gms/wearable/DataMap;->remove(Ljava/lang/String;)Ljava/lang/Object;

    .line 890
    invoke-static {}, Lcom/amazon/mShop/wearable/WearableCrashDetails;->getInstance()Lcom/amazon/mShop/wearable/WearableCrashDetails;

    move-result-object v5

    invoke-virtual {v5, v3}, Lcom/amazon/mShop/wearable/WearableCrashDetails;->setCrashDetails(Lcom/google/android/gms/wearable/DataMap;)V

    .line 892
    invoke-static {}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->getInstance()Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    move-result-object v5

    invoke-virtual {v5, v2}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->reportCrash(Ljava/lang/Throwable;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 896
    .end local v0    # "bis":Ljava/io/ByteArrayInputStream;
    .end local v2    # "ex":Ljava/lang/Throwable;
    .end local v3    # "map":Lcom/google/android/gms/wearable/DataMap;
    .end local v4    # "ois":Ljava/io/ObjectInputStream;
    :goto_0
    return-void

    .line 893
    :catch_0
    move-exception v1

    .line 894
    .local v1, "e":Ljava/lang/Throwable;
    const-string/jumbo v5, "WearListenerService"

    const-string/jumbo v6, "onReportWearCrash"

    invoke-static {v5, v6, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
