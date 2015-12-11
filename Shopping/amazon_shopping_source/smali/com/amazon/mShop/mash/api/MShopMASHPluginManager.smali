.class public Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;
.super Lcom/amazon/mobile/mash/api/MASHPluginManager;
.source "MShopMASHPluginManager.java"


# static fields
.field private static final SERVICE_MAPPING:Ljava/util/Map;
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
    .line 25
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    .line 27
    invoke-static {}, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->initServiceMappingForApi14To16()V

    .line 28
    return-void
.end method

.method public constructor <init>(Lorg/apache/cordova/CordovaWebView;Lorg/apache/cordova/CordovaInterface;Ljava/util/List;)V
    .locals 0
    .param p1, "webView"    # Lorg/apache/cordova/CordovaWebView;
    .param p2, "cordova"    # Lorg/apache/cordova/CordovaInterface;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/apache/cordova/CordovaWebView;",
            "Lorg/apache/cordova/CordovaInterface;",
            "Ljava/util/List",
            "<",
            "Lorg/apache/cordova/PluginEntry;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 36
    .local p3, "pluginEntries":Ljava/util/List;, "Ljava/util/List<Lorg/apache/cordova/PluginEntry;>;"
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/api/MASHPluginManager;-><init>(Lorg/apache/cordova/CordovaWebView;Lorg/apache/cordova/CordovaInterface;Ljava/util/List;)V

    .line 37
    return-void
.end method

.method private static initServiceMappingForApi14To16()V
    .locals 3

    .prologue
    .line 68
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "LaunchIntentURL"

    const-string/jumbo v2, "MASHCore"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 69
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "CanLaunchIntentURL"

    const-string/jumbo v2, "MASHCore"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 70
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "ShowContactPicker"

    const-string/jumbo v2, "MASHContacts"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 71
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "AddEventListener"

    const-string/jumbo v2, "MASHEvent"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "RemoveEventListener"

    const-string/jumbo v2, "MASHEvent"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "DispatchEvent"

    const-string/jumbo v2, "MASHEvent"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 74
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "ShowEmbeddedBrowser"

    const-string/jumbo v2, "MASHEmbeddedBrowser"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 75
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "ExitEmbeddedBrowser"

    const-string/jumbo v2, "MASHEmbeddedBrowser"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 76
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "ShowOneClickSettings"

    const-string/jumbo v2, "MASHMShopYourAccount"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 77
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "ShowAdsPreferences"

    const-string/jumbo v2, "MASHMShopYourAccount"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "ShowAmazonPoints"

    const-string/jumbo v2, "MASHMShopYourAccount"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "ShowOfferListingPage"

    const-string/jumbo v2, "MASHMShopDetailPage"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 80
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "ShowBarcodeScanner"

    const-string/jumbo v2, "MASHMShopSearch"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 81
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "ShowDeliveryDestinationPicker"

    const-string/jumbo v2, "MASHMShopCheckout"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 82
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "CancelFullscreen"

    const-string/jumbo v2, "MASHAppUi"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "RequestFullscreen"

    const-string/jumbo v2, "MASHAppUi"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "FocusOnItem"

    const-string/jumbo v2, "MASHAppUi"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "Share"

    const-string/jumbo v2, "MASHSocial"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "aiv.IsPlaybackSustainable"

    const-string/jumbo v2, "MASHAiv"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "aiv.StartPlayback"

    const-string/jumbo v2, "MASHAiv"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 88
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "aiv.StartTrailer"

    const-string/jumbo v2, "MASHAiv"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    sget-object v0, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    const-string/jumbo v1, "aiv.WhisperCache"

    const-string/jumbo v2, "MASHAiv"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    return-void
.end method


# virtual methods
.method protected overrideServiceName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "service"    # Ljava/lang/String;
    .param p2, "action"    # Ljava/lang/String;

    .prologue
    .line 55
    const/4 v0, 0x0

    .line 56
    .local v0, "adjustedService":Ljava/lang/String;
    const-string/jumbo v1, "Mash"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 57
    sget-object v1, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;->SERVICE_MAPPING:Ljava/util/Map;

    invoke-interface {v1, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "adjustedService":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 59
    .restart local v0    # "adjustedService":Ljava/lang/String;
    :cond_0
    if-eqz v0, :cond_1

    .end local v0    # "adjustedService":Ljava/lang/String;
    :goto_0
    return-object v0

    .restart local v0    # "adjustedService":Ljava/lang/String;
    :cond_1
    move-object v0, p1

    goto :goto_0
.end method
