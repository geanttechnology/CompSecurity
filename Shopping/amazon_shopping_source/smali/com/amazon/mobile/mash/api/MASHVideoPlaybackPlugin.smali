.class public Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHVideoPlaybackPlugin.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->logInfoLevel(Ljava/lang/String;)V

    return-void
.end method

.method private canPlayHTML5Video(Lorg/apache/cordova/CallbackContext;)V
    .locals 2
    .param p1, "callbackContext"    # Lorg/apache/cordova/CallbackContext;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 63
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-ge v0, v1, :cond_0

    .line 64
    sget-object v0, Lcom/amazon/mobile/mash/error/MASHError;->NOT_SUPPORTED:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {p1, v0}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 72
    :goto_0
    return-void

    .line 67
    :cond_0
    iget-object v0, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    invoke-virtual {v0}, Lorg/apache/cordova/CordovaWebView;->isHardwareAccelerated()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 68
    invoke-virtual {p1}, Lorg/apache/cordova/CallbackContext;->success()V

    goto :goto_0

    .line 70
    :cond_1
    sget-object v0, Lcom/amazon/mobile/mash/error/MASHError;->NOT_SUPPORTED:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {p1, v0}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0
.end method

.method private logInfoLevel(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 152
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 153
    sget-object v0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->TAG:Ljava/lang/String;

    invoke-static {v0, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 155
    :cond_0
    return-void
.end method

.method private playVideo(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callbackContext"    # Lorg/apache/cordova/CallbackContext;

    .prologue
    .line 89
    new-instance v0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;-><init>(Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 146
    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/String;Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)Z
    .locals 1
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "args"    # Lorg/json/JSONArray;
    .param p3, "callbackContext"    # Lorg/apache/cordova/CallbackContext;

    .prologue
    .line 45
    const-string/jumbo v0, "video.PlayVideo"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 46
    invoke-direct {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->playVideo(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 53
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0

    .line 47
    :cond_0
    const-string/jumbo v0, "video.CanPlayHTML5Video"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 48
    invoke-direct {p0, p3}, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->canPlayHTML5Video(Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 50
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method
