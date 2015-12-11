.class public Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;
.super Ljava/lang/Object;
.source "EPSDKPrefs.java"


# static fields
.field static ctx:Landroid/content/Context; = null

.field static final fAnalyticsAffiliateID:Ljava/lang/String; = "affiliateId"

.field static final fAnalyticsAffiliateURL:Ljava/lang/String; = "affiliateUrl"

.field static final fAnalyticsOverwriteAffiliateID:Ljava/lang/String; = "overwriteaffiliateID"

.field static final fConfigApiKey:Ljava/lang/String; = "apiKey"

.field static final fConfigApiUrl:Ljava/lang/String; = "url"

.field static final fConfigConvivaCustomerKey:Ljava/lang/String; = "convivakey"

.field static final fConfigConvivaPlayerName:Ljava/lang/String; = "playerName"

.field static final fConfigDeviceOverride:Ljava/lang/String; = "deviceOverride"

.field static final fConfigDeviceType:Ljava/lang/String; = "deviceType"

.field static final fConfigIsDeviceIdentified:Ljava/lang/String; = "isDeviceIdentified"

.field static final fConfigNetworks:Ljava/lang/String; = "network"

.field static final fConfigOmnitureCurrencyCode:Ljava/lang/String; = "currencyCode"

.field static final fConfigOmnitureSuite:Ljava/lang/String; = "suite"

.field static final fConfigOmnitureTrackingServer:Ljava/lang/String; = "trackingServer"

.field static final fConfigOmnitureTrackingServerSecure:Ljava/lang/String; = "trackingServerSecure"

.field static final fConfigPoolingInterval:Ljava/lang/String; = "poolingInterval"

.field static final fConfigStreamLimiting:Ljava/lang/String; = "streamLimiting"

.field static final fConfigTTL:Ljava/lang/String; = "ttl"

.field static final fConfigUUID:Ljava/lang/String; = "uuid"

.field static final fConfigVODApiUrl:Ljava/lang/String; = "vodUrl"

.field static final fLoggingLevel:Ljava/lang/String; = "loggingLevel"

.field static final fStartSessionAdobePassId:Ljava/lang/String; = "adobepasscontentproviderid"

.field static final fStartSessionAdobePassresource:Ljava/lang/String; = "resource"

.field static final fStartSessionCookie:Ljava/lang/String; = "startsessioncookie"

.field static final fStartSessionInitType:Ljava/lang/String; = "inittype"

.field static final fStartSessionPartner:Ljava/lang/String; = "affiliate"

.field static final fStartSessionToken:Ljava/lang/String; = "token"

.field static final fStartSessionTokenType:Ljava/lang/String; = "tokenType"

.field static final fStartSessionUdid:Ljava/lang/String; = "udid"

.field static final fVideoSessionEventId:Ljava/lang/String; = "id"

.field static final fVideoSessionMaintainURL:Ljava/lang/String; = "maintainurl"

.field static final fVideoSessionProgramChangeURL:Ljava/lang/String; = "programchangeurl"

.field static final fVideoSessionTTL:Ljava/lang/String; = "ttl"

.field static final fVideoSessionToken:Ljava/lang/String; = "token"

.field static final kAnalytics:Ljava/lang/String; = "analytics"

.field static final kConfig:Ljava/lang/String; = "config"

.field static final kLogging:Ljava/lang/String; = "logging"

.field static final kStartSession:Ljava/lang/String; = "startSession"

.field static final kVideoSession:Ljava/lang/String; = "Session"


# instance fields
.field pref:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const/4 v0, 0x0

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->ctx:Landroid/content/Context;

    .line 66
    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    return-void
.end method

.method static clearConfigData()V
    .locals 4

    .prologue
    .line 127
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "url"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 128
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "vodUrl"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "ttl"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "poolingInterval"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "apiKey"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 133
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "convivakey"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "playerName"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 135
    return-void
.end method

.method static clearStartSessionData()V
    .locals 4

    .prologue
    .line 138
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "affiliate"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 139
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "udid"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "token"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 141
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "adobepasscontentproviderid"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 142
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "resource"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "tokenType"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 144
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "inittype"

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    return-void
.end method

.method static getAffiliateID()Ljava/lang/String;
    .locals 3

    .prologue
    .line 204
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "analytics"

    const-string v2, "affiliateId"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getApiConfigConvivPlayerName()Ljava/lang/String;
    .locals 3

    .prologue
    .line 164
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "playerName"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getApiConfigConvivaCustomerKey()Ljava/lang/String;
    .locals 3

    .prologue
    .line 160
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "convivakey"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getApiConfigPoolingInterval()Ljava/lang/String;
    .locals 3

    .prologue
    .line 168
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "poolingInterval"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getApiConfigTTL()Ljava/lang/String;
    .locals 3

    .prologue
    .line 156
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "ttl"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getApiKey()Ljava/lang/String;
    .locals 4

    .prologue
    .line 176
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "apikey="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v2, "config"

    const-string v3, "apiKey"

    invoke-virtual {v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getApiPartnerName()Ljava/lang/String;
    .locals 3

    .prologue
    .line 172
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "affiliate"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getApiUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 148
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "url"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getApinetworks()Ljava/lang/String;
    .locals 4

    .prologue
    .line 180
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "networks="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v2, "config"

    const-string v3, "network"

    invoke-virtual {v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getDeviceTypeParam()Ljava/lang/String;
    .locals 4

    .prologue
    .line 212
    const-string v0, ""

    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v2, "config"

    const-string v3, "deviceType"

    invoke-virtual {v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 213
    const-string v0, "device=handset"

    .line 215
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "device="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v2, "config"

    const-string v3, "deviceType"

    invoke-virtual {v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getLoggingLevel()I
    .locals 4

    .prologue
    .line 119
    :try_start_0
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v2, "logging"

    const-string v3, "loggingLevel"

    invoke-virtual {v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 122
    .local v0, "e":Ljava/lang/Exception;
    :goto_0
    return v1

    .line 120
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_0
    move-exception v0

    .line 121
    .restart local v0    # "e":Ljava/lang/Exception;
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->SDKTAG:Ljava/lang/String;

    const-string v2, "Logging level can\'t be determined. Defaulting to Verbose"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 122
    const/4 v1, 0x1

    goto :goto_0
.end method

.method static getOmnitureCurrencyCode()Ljava/lang/String;
    .locals 3

    .prologue
    .line 196
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "currencyCode"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getOmnitureSuiteID()Ljava/lang/String;
    .locals 3

    .prologue
    .line 200
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "suite"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getOmnitureTrackingServer()Ljava/lang/String;
    .locals 3

    .prologue
    .line 192
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "trackingServer"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getPlatformForStartSession()Ljava/lang/String;
    .locals 4

    .prologue
    .line 223
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "deviceOverride"

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getBooleanField(Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 224
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "deviceType"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 230
    :goto_0
    return-object v0

    .line 227
    :cond_0
    const-string v0, ""

    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v2, "config"

    const-string v3, "deviceType"

    invoke-virtual {v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 228
    const-string v0, "android_handset"

    goto :goto_0

    .line 230
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "android_"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v2, "config"

    const-string v3, "deviceType"

    invoke-virtual {v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method static getStartSessionCookie()Ljava/lang/String;
    .locals 3

    .prologue
    .line 184
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "startsessioncookie"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getUUID()Ljava/lang/String;
    .locals 3

    .prologue
    .line 188
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "uuid"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getVODApiUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 152
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "vodUrl"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private loadPrefs(Ljava/lang/String;)Landroid/content/SharedPreferences;
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 74
    const/4 v0, 0x0

    .line 75
    .local v0, "prefs":Landroid/content/SharedPreferences;
    const-string v1, "logging"

    if-ne p1, v1, :cond_0

    .line 76
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->ctx:Landroid/content/Context;

    const-string v2, "logging"

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 77
    :cond_0
    const-string v1, "config"

    if-ne p1, v1, :cond_1

    .line 78
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->ctx:Landroid/content/Context;

    const-string v2, "config"

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 79
    :cond_1
    const-string v1, "startSession"

    if-ne p1, v1, :cond_2

    .line 80
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->ctx:Landroid/content/Context;

    const-string v2, "startSession"

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 81
    :cond_2
    const-string v1, "Session"

    if-ne p1, v1, :cond_3

    .line 82
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->ctx:Landroid/content/Context;

    const-string v2, "Session"

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 83
    :cond_3
    const-string v1, "analytics"

    if-ne p1, v1, :cond_4

    .line 84
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->ctx:Landroid/content/Context;

    const-string v2, "analytics"

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 86
    :cond_4
    return-object v0
.end method

.method static shouldOverwriteAffiliateID()Z
    .locals 4

    .prologue
    .line 208
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "analytics"

    const-string v2, "overwriteaffiliateID"

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getBooleanField(Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method


# virtual methods
.method getBooleanField(Ljava/lang/String;Ljava/lang/String;Z)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "field"    # Ljava/lang/String;
    .param p3, "defaulValue"    # Z

    .prologue
    .line 111
    const/4 v0, 0x0

    .line 112
    .local v0, "fieldValue":Z
    invoke-direct {p0, p1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->loadPrefs(Ljava/lang/String;)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 113
    .local v1, "prefs":Landroid/content/SharedPreferences;
    invoke-interface {v1, p2, p3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 114
    return v0
.end method

.method getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "field"    # Ljava/lang/String;

    .prologue
    .line 90
    const/4 v0, 0x0

    .line 91
    .local v0, "fieldValue":Ljava/lang/String;
    invoke-direct {p0, p1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->loadPrefs(Ljava/lang/String;)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 92
    .local v1, "prefs":Landroid/content/SharedPreferences;
    const-string v2, ""

    invoke-interface {v1, p2, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 93
    return-object v0
.end method

.method putBooleanField(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "field"    # Ljava/lang/String;
    .param p3, "value"    # Z

    .prologue
    .line 104
    invoke-direct {p0, p1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->loadPrefs(Ljava/lang/String;)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 105
    .local v1, "prefs":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 106
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p2, p3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 107
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 108
    return-void
.end method

.method putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "field"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 97
    invoke-direct {p0, p1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->loadPrefs(Ljava/lang/String;)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 98
    .local v1, "prefs":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 99
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p2, p3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 100
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 101
    return-void
.end method
