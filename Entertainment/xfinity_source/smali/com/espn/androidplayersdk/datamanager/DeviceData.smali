.class Lcom/espn/androidplayersdk/datamanager/DeviceData;
.super Ljava/lang/Object;
.source "DeviceData.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;
    }
.end annotation


# static fields
.field static final HANDHELD:Ljava/lang/String; = "handset"

.field static final TABLET:Ljava/lang/String; = "tablet"


# instance fields
.field private final AUTH_URL:Ljava/lang/String;

.field private final BASE_URL:Ljava/lang/String;

.field private final CLIENT_ID:Ljava/lang/String;

.field private final CLIENT_SCOPE:Ljava/lang/String;

.field private final CLIENT_SECRET:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    const-string v0, "https://authorization.go.com/token"

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData;->AUTH_URL:Ljava/lang/String;

    .line 28
    const-string v0, "DTSS-DEVICE.DATA.WATCH.ESPN.ANDROID-PROD"

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData;->CLIENT_ID:Ljava/lang/String;

    .line 29
    const-string v0, "859517d7b6f33154bd9b5b74ca528a9a"

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData;->CLIENT_SECRET:Ljava/lang/String;

    .line 30
    const-string v0, "mcon-devicedata-oneshot"

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData;->CLIENT_SCOPE:Ljava/lang/String;

    .line 31
    const-string v0, "http://api.devicedata.go.com/deviceDataWS/rs/composite-views/deviceatlas/devices/oneshot?oauth_token="

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData;->BASE_URL:Ljava/lang/String;

    .line 21
    return-void
.end method

.method private static checkModelSupported()Z
    .locals 1

    .prologue
    .line 62
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/DeviceData;->isAmazonSTB()Z

    move-result v0

    return v0
.end method

.method protected static getDeviceType()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x2

    const/4 v3, 0x0

    .line 34
    const-string v0, "Device Data requested"

    invoke-static {v0, v4, v5}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 35
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "isDeviceIdentified"

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getBooleanField(Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result v0

    if-nez v0, :cond_1

    .line 36
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/DeviceData;->checkModelSupported()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 37
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "isDeviceIdentified"

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putBooleanField(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 38
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "deviceType"

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/DeviceData;->getDeviceTypeByModel()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    :goto_0
    return-void

    .line 40
    :cond_0
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;

    new-instance v1, Lcom/espn/androidplayersdk/datamanager/DeviceData;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/DeviceData;-><init>()V

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-direct {v0, v1}, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;-><init>(Lcom/espn/androidplayersdk/datamanager/DeviceData;)V

    new-array v1, v3, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 43
    :cond_1
    const-string v0, "Device already identified"

    invoke-static {v0, v4, v5}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method private static getDeviceTypeByModel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/DeviceData;->isAmazonSTB()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 67
    const-string v0, "tablet"

    .line 70
    :goto_0
    return-object v0

    :cond_0
    const-string v0, "handset"

    goto :goto_0
.end method

.method private static isAmazonSTB()Z
    .locals 2

    .prologue
    .line 75
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "aftb"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method protected static overrideDeviceType(Ljava/lang/String;)V
    .locals 4
    .param p0, "deviceType"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x1

    .line 47
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Overriding Device Type As: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 49
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "isDeviceIdentified"

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putBooleanField(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 52
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "deviceOverride"

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putBooleanField(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 55
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "deviceType"

    invoke-virtual {v0, v1, v2, p0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    return-void
.end method
