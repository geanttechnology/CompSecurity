.class public final Lcom/amazon/mobile/mash/appcontext/AppContextCookie;
.super Ljava/lang/Object;
.source "AppContextCookie.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const-class v0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/mobile/mash/appcontext/AppContext;)V
    .locals 0
    .param p1, "appContextManager"    # Lcom/amazon/mobile/mash/appcontext/AppContext;

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    .line 30
    return-void
.end method

.method private buildCookieValue(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p1, "ctx"    # Landroid/content/Context;

    .prologue
    .line 85
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 86
    .local v0, "builder":Ljava/lang/StringBuilder;
    iget-object v1, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v1}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getAppContextSchemaVersion()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 87
    const-string/jumbo v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 88
    invoke-direct {p0, p1}, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->getAppContextInfo(Landroid/content/Context;)Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 89
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private getAppContextInfo(Landroid/content/Context;)Lorg/json/JSONObject;
    .locals 8
    .param p1, "ctx"    # Landroid/content/Context;

    .prologue
    .line 99
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 102
    .local v0, "appCtxtInfo":Lorg/json/JSONObject;
    :try_start_0
    const-string/jumbo v5, "an"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getAppName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 103
    const-string/jumbo v5, "av"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getAppVersion()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 104
    const-string/jumbo v5, "xv"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getMASHApiVersion()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 105
    const-string/jumbo v5, "os"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getOSName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 106
    const-string/jumbo v5, "ov"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getOSVersion()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 107
    const-string/jumbo v5, "cp"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getCapability()J

    move-result-wide v6

    invoke-virtual {v0, v5, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 108
    const-string/jumbo v5, "uiv"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getMASHUrlIntercepterVersion()I

    move-result v6

    invoke-virtual {v0, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 110
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 111
    .local v3, "deviceInfo":Lorg/json/JSONObject;
    const-string/jumbo v5, "di"

    invoke-virtual {v0, v5, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 112
    const-string/jumbo v5, "pr"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDeviceProductLine()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 113
    const-string/jumbo v5, "md"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDeviceModal()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 114
    const-string/jumbo v5, "v"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDeviceModalVersion()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 115
    const-string/jumbo v5, "mf"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDeviceManufacturer()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 116
    const-string/jumbo v5, "dsn"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDeviceDmsSerialNumber()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 117
    const-string/jumbo v5, "dti"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDeviceDmsDeviceType()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 118
    const-string/jumbo v5, "ca"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6, p1}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDeviceCarrier(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 119
    const-string/jumbo v5, "ct"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6, p1}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDeviceConnectionType(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 121
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 122
    .local v2, "deviceDisplayMetrics":Lorg/json/JSONObject;
    const-string/jumbo v5, "dm"

    invoke-virtual {v0, v5, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 123
    const-string/jumbo v5, "w"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6, p1}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDeviceDisplayWidth(Landroid/content/Context;)I

    move-result v6

    invoke-virtual {v2, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 124
    const-string/jumbo v5, "h"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6, p1}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDeviceDisplayHeight(Landroid/content/Context;)I

    move-result v6

    invoke-virtual {v2, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 125
    const-string/jumbo v5, "ld"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6, p1}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDeviceLogicalDensity(Landroid/content/Context;)F

    move-result v6

    float-to-double v6, v6

    invoke-virtual {v2, v5, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    .line 126
    const-string/jumbo v5, "dx"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6, p1}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDevicePhysicalDensityX(Landroid/content/Context;)F

    move-result v6

    float-to-double v6, v6

    invoke-virtual {v2, v5, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    .line 127
    const-string/jumbo v5, "dy"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6, p1}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDevicePhysicalDensityY(Landroid/content/Context;)F

    move-result v6

    float-to-double v6, v6

    invoke-virtual {v2, v5, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    .line 129
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 130
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 131
    .local v1, "debugInfo":Lorg/json/JSONObject;
    const-string/jumbo v5, "dbg"

    invoke-virtual {v0, v5, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 132
    iget-object v5, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v5}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDebugWeinreServerSatus()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 133
    const-string/jumbo v5, "weinre_server_host"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDebugWeinreServerHost()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 134
    const-string/jumbo v5, "weinre_server_port"

    iget-object v6, p0, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->mAppContext:Lcom/amazon/mobile/mash/appcontext/AppContext;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/appcontext/AppContext;->getDebugWeinreServerPort()I

    move-result v6

    invoke-virtual {v1, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 143
    .end local v1    # "debugInfo":Lorg/json/JSONObject;
    .end local v2    # "deviceDisplayMetrics":Lorg/json/JSONObject;
    .end local v3    # "deviceInfo":Lorg/json/JSONObject;
    :cond_0
    :goto_0
    return-object v0

    .line 137
    :catch_0
    move-exception v4

    .line 138
    .local v4, "e":Lorg/json/JSONException;
    invoke-virtual {v4}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/mobile/mash/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 139
    sget-object v5, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->TAG:Ljava/lang/String;

    invoke-virtual {v4}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method


# virtual methods
.method public getCookieValue(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p1, "ctx"    # Landroid/content/Context;

    .prologue
    .line 76
    invoke-direct {p0, p1}, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->buildCookieValue(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
