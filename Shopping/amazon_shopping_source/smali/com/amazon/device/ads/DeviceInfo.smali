.class Lcom/amazon/device/ads/DeviceInfo;
.super Ljava/lang/Object;
.source "DeviceInfo.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String; = "DeviceInfo"

.field public static final ORIENTATION_LANDSCAPE:Ljava/lang/String; = "landscape"

.field public static final ORIENTATION_PORTRAIT:Ljava/lang/String; = "portrait"

.field public static final ORIENTATION_UNKNOWN:Ljava/lang/String; = "unknown"

.field public static final WIFI_NAME:Ljava/lang/String; = "Wifi"

.field private static final dt:Ljava/lang/String; = "android"

.field private static final make:Ljava/lang/String;

.field private static final model:Ljava/lang/String;

.field private static final os:Ljava/lang/String; = "Android"

.field private static final osVersion:Ljava/lang/String;

.field private static userAgent:Ljava/lang/String;


# instance fields
.field private bad_mac:Z

.field private bad_serial:Z

.field private bad_udid:Z

.field private carrier:Ljava/lang/String;

.field private country:Ljava/lang/String;

.field private landscapeScreenSize:Lcom/amazon/device/ads/Size;

.field private language:Ljava/lang/String;

.field private macFetched:Z

.field private md5_mac:Ljava/lang/String;

.field private md5_serial:Ljava/lang/String;

.field private md5_udid:Ljava/lang/String;

.field private portraitScreenSize:Lcom/amazon/device/ads/Size;

.field private scalingFactor:F

.field private scalingFactorAsString:Ljava/lang/String;

.field private serialFetched:Z

.field private sha1_mac:Ljava/lang/String;

.field private sha1_serial:Ljava/lang/String;

.field private sha1_udid:Ljava/lang/String;

.field private udid:Ljava/lang/String;

.field private udidFetched:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    sput-object v0, Lcom/amazon/device/ads/DeviceInfo;->make:Ljava/lang/String;

    .line 38
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    sput-object v0, Lcom/amazon/device/ads/DeviceInfo;->model:Ljava/lang/String;

    .line 40
    sget-object v0, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    sput-object v0, Lcom/amazon/device/ads/DeviceInfo;->osVersion:Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 81
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    invoke-direct {p0}, Lcom/amazon/device/ads/DeviceInfo;->setCountry()V

    .line 76
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/DeviceInfo;->setCarrier(Landroid/content/Context;)V

    .line 77
    invoke-direct {p0}, Lcom/amazon/device/ads/DeviceInfo;->setLanguage()V

    .line 78
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/DeviceInfo;->setScalingFactor(Landroid/content/Context;)V

    .line 79
    return-void
.end method

.method public static getDeviceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 266
    const-string/jumbo v0, "android"

    return-object v0
.end method

.method public static getMake()Ljava/lang/String;
    .locals 1

    .prologue
    .line 270
    sget-object v0, Lcom/amazon/device/ads/DeviceInfo;->make:Ljava/lang/String;

    return-object v0
.end method

.method public static getModel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 274
    sget-object v0, Lcom/amazon/device/ads/DeviceInfo;->model:Ljava/lang/String;

    return-object v0
.end method

.method public static getOS()Ljava/lang/String;
    .locals 1

    .prologue
    .line 278
    const-string/jumbo v0, "Android"

    return-object v0
.end method

.method public static getOSVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 282
    sget-object v0, Lcom/amazon/device/ads/DeviceInfo;->osVersion:Ljava/lang/String;

    return-object v0
.end method

.method public static getUserAgentString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 405
    sget-object v0, Lcom/amazon/device/ads/DeviceInfo;->userAgent:Ljava/lang/String;

    return-object v0
.end method

.method private setCarrier(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 235
    const-string/jumbo v2, "phone"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/telephony/TelephonyManager;

    .line 236
    .local v1, "tManager":Landroid/telephony/TelephonyManager;
    if-eqz v1, :cond_0

    .line 238
    invoke-virtual {v1}, Landroid/telephony/TelephonyManager;->getNetworkOperatorName()Ljava/lang/String;

    move-result-object v0

    .line 239
    .local v0, "carrier":Ljava/lang/String;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_1

    .end local v0    # "carrier":Ljava/lang/String;
    :goto_0
    iput-object v0, p0, Lcom/amazon/device/ads/DeviceInfo;->carrier:Ljava/lang/String;

    .line 241
    :cond_0
    return-void

    .line 239
    .restart local v0    # "carrier":Ljava/lang/String;
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setCountry()V
    .locals 2

    .prologue
    .line 224
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v0

    .line 225
    .local v0, "country":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .end local v0    # "country":Ljava/lang/String;
    :goto_0
    iput-object v0, p0, Lcom/amazon/device/ads/DeviceInfo;->country:Ljava/lang/String;

    .line 226
    return-void

    .line 225
    .restart local v0    # "country":Ljava/lang/String;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setLanguage()V
    .locals 2

    .prologue
    .line 214
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v0

    .line 215
    .local v0, "language":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .end local v0    # "language":Ljava/lang/String;
    :goto_0
    iput-object v0, p0, Lcom/amazon/device/ads/DeviceInfo;->language:Ljava/lang/String;

    .line 216
    return-void

    .line 215
    .restart local v0    # "language":Ljava/lang/String;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setMacAddressIfNotFetched()V
    .locals 1

    .prologue
    .line 85
    iget-boolean v0, p0, Lcom/amazon/device/ads/DeviceInfo;->macFetched:Z

    if-nez v0, :cond_0

    .line 87
    invoke-virtual {p0}, Lcom/amazon/device/ads/DeviceInfo;->setMacAddress()V

    .line 89
    :cond_0
    return-void
.end method

.method private setScalingFactor(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 247
    sget-object v2, Lcom/amazon/device/ads/DeviceInfo;->make:Ljava/lang/String;

    const-string/jumbo v3, "motorola"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    sget-object v2, Lcom/amazon/device/ads/DeviceInfo;->model:Ljava/lang/String;

    const-string/jumbo v3, "MB502"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 249
    const/high16 v2, 0x3f800000    # 1.0f

    iput v2, p0, Lcom/amazon/device/ads/DeviceInfo;->scalingFactor:F

    .line 261
    :goto_0
    iget v2, p0, Lcom/amazon/device/ads/DeviceInfo;->scalingFactor:F

    invoke-static {v2}, Ljava/lang/Float;->toString(F)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/device/ads/DeviceInfo;->scalingFactorAsString:Ljava/lang/String;

    .line 262
    return-void

    .line 255
    :cond_0
    const-string/jumbo v2, "window"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/WindowManager;

    .line 256
    .local v1, "windowManager":Landroid/view/WindowManager;
    new-instance v0, Landroid/util/DisplayMetrics;

    invoke-direct {v0}, Landroid/util/DisplayMetrics;-><init>()V

    .line 257
    .local v0, "metrics":Landroid/util/DisplayMetrics;
    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 258
    iget v2, v0, Landroid/util/DisplayMetrics;->scaledDensity:F

    iput v2, p0, Lcom/amazon/device/ads/DeviceInfo;->scalingFactor:F

    goto :goto_0
.end method

.method private setSerial()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 152
    const/4 v2, 0x0

    .line 155
    .local v2, "serial":Ljava/lang/String;
    :try_start_0
    const-class v3, Landroid/os/Build;

    const-string/jumbo v4, "SERIAL"

    invoke-virtual {v3, v4}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    .line 156
    .local v1, "f":Ljava/lang/reflect/Field;
    const-class v3, Landroid/os/Build;

    invoke-virtual {v1, v3}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    move-object v0, v3

    check-cast v0, Ljava/lang/String;

    move-object v2, v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 171
    .end local v1    # "f":Ljava/lang/reflect/Field;
    :goto_0
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    if-eqz v3, :cond_0

    const-string/jumbo v3, "unknown"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 173
    :cond_0
    iput-boolean v5, p0, Lcom/amazon/device/ads/DeviceInfo;->bad_serial:Z

    .line 179
    :goto_1
    iput-boolean v5, p0, Lcom/amazon/device/ads/DeviceInfo;->serialFetched:Z

    .line 180
    return-void

    .line 177
    :cond_1
    invoke-static {v2}, Lcom/amazon/device/ads/Utils;->sha1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/device/ads/Utils;->getURLEncodedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/device/ads/DeviceInfo;->sha1_serial:Ljava/lang/String;

    goto :goto_1

    .line 158
    :catch_0
    move-exception v3

    goto :goto_0
.end method

.method private setSerialIfNotFetched()V
    .locals 1

    .prologue
    .line 145
    iget-boolean v0, p0, Lcom/amazon/device/ads/DeviceInfo;->serialFetched:Z

    if-nez v0, :cond_0

    .line 147
    invoke-direct {p0}, Lcom/amazon/device/ads/DeviceInfo;->setSerial()V

    .line 149
    :cond_0
    return-void
.end method

.method private setUdid()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 190
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/device/ads/IInternalAdRegistration;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 192
    .local v0, "context":Landroid/content/Context;
    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    const-string/jumbo v3, "android_id"

    invoke-static {v2, v3}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 193
    .local v1, "udid":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/device/ads/Utils;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string/jumbo v2, "9774d56d682e549c"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 195
    :cond_0
    iput-object v5, p0, Lcom/amazon/device/ads/DeviceInfo;->udid:Ljava/lang/String;

    .line 196
    iput-object v5, p0, Lcom/amazon/device/ads/DeviceInfo;->sha1_udid:Ljava/lang/String;

    .line 197
    iput-boolean v4, p0, Lcom/amazon/device/ads/DeviceInfo;->bad_udid:Z

    .line 204
    :goto_0
    iput-boolean v4, p0, Lcom/amazon/device/ads/DeviceInfo;->udidFetched:Z

    .line 205
    return-void

    .line 201
    :cond_1
    invoke-static {v1}, Lcom/amazon/device/ads/Utils;->getURLEncodedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/device/ads/DeviceInfo;->udid:Ljava/lang/String;

    .line 202
    invoke-static {v1}, Lcom/amazon/device/ads/Utils;->sha1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/device/ads/Utils;->getURLEncodedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/device/ads/DeviceInfo;->sha1_udid:Ljava/lang/String;

    goto :goto_0
.end method

.method private setUdidIfNotFetched()V
    .locals 1

    .prologue
    .line 183
    iget-boolean v0, p0, Lcom/amazon/device/ads/DeviceInfo;->udidFetched:Z

    if-nez v0, :cond_0

    .line 185
    invoke-direct {p0}, Lcom/amazon/device/ads/DeviceInfo;->setUdid()V

    .line 187
    :cond_0
    return-void
.end method

.method public static setUserAgentString(Ljava/lang/String;)V
    .locals 1
    .param p0, "ua"    # Ljava/lang/String;

    .prologue
    .line 409
    if-eqz p0, :cond_0

    sget-object v0, Lcom/amazon/device/ads/DeviceInfo;->userAgent:Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 411
    sput-object p0, Lcom/amazon/device/ads/DeviceInfo;->userAgent:Ljava/lang/String;

    .line 413
    :cond_0
    return-void
.end method


# virtual methods
.method public getCarrier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 384
    iget-object v0, p0, Lcom/amazon/device/ads/DeviceInfo;->carrier:Ljava/lang/String;

    return-object v0
.end method

.method public getConnectionType()Ljava/lang/String;
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 342
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/device/ads/IInternalAdRegistration;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 343
    .local v2, "context":Landroid/content/Context;
    const-string/jumbo v5, "connectivity"

    invoke-virtual {v2, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 344
    .local v0, "cManager":Landroid/net/ConnectivityManager;
    const/4 v4, 0x0

    .line 345
    .local v4, "networkInfo":Landroid/net/NetworkInfo;
    const/4 v1, 0x0

    .line 348
    .local v1, "connectionType":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 350
    :try_start_0
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 358
    :cond_0
    :goto_0
    if-eqz v4, :cond_2

    .line 360
    invoke-virtual {v4}, Landroid/net/NetworkInfo;->getType()I

    move-result v5

    if-ne v5, v9, :cond_1

    .line 362
    const-string/jumbo v1, "Wifi"

    .line 376
    :goto_1
    return-object v1

    .line 353
    :catch_0
    move-exception v3

    .line 355
    .local v3, "e":Ljava/lang/SecurityException;
    const-string/jumbo v5, "DeviceInfo"

    const-string/jumbo v6, "Unable to get active network information: %s"

    new-array v7, v9, [Ljava/lang/Object;

    aput-object v3, v7, v8

    invoke-static {v5, v6, v7}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 368
    .end local v3    # "e":Ljava/lang/SecurityException;
    :cond_1
    invoke-virtual {v4}, Landroid/net/NetworkInfo;->getSubtype()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 373
    :cond_2
    invoke-static {v8}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method

.method public getCountry()Ljava/lang/String;
    .locals 1

    .prologue
    .line 388
    iget-object v0, p0, Lcom/amazon/device/ads/DeviceInfo;->country:Ljava/lang/String;

    return-object v0
.end method

.method public getDInfoProperty()Lorg/json/JSONObject;
    .locals 3

    .prologue
    .line 476
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 478
    .local v0, "json":Lorg/json/JSONObject;
    const-string/jumbo v1, "make"

    invoke-static {}, Lcom/amazon/device/ads/DeviceInfo;->getMake()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 479
    const-string/jumbo v1, "model"

    invoke-static {}, Lcom/amazon/device/ads/DeviceInfo;->getModel()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 480
    const-string/jumbo v1, "os"

    invoke-static {}, Lcom/amazon/device/ads/DeviceInfo;->getOS()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 481
    const-string/jumbo v1, "osVersion"

    invoke-static {}, Lcom/amazon/device/ads/DeviceInfo;->getOSVersion()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 482
    const-string/jumbo v1, "scalingFactor"

    invoke-virtual {p0}, Lcom/amazon/device/ads/DeviceInfo;->getScalingFactorAsString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 483
    const-string/jumbo v1, "language"

    invoke-virtual {p0}, Lcom/amazon/device/ads/DeviceInfo;->getLanguage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 484
    const-string/jumbo v1, "country"

    invoke-virtual {p0}, Lcom/amazon/device/ads/DeviceInfo;->getCountry()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 485
    const-string/jumbo v1, "carrier"

    invoke-virtual {p0}, Lcom/amazon/device/ads/DeviceInfo;->getCarrier()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 487
    return-object v0
.end method

.method public getLanguage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 392
    iget-object v0, p0, Lcom/amazon/device/ads/DeviceInfo;->language:Ljava/lang/String;

    return-object v0
.end method

.method public getMacMd5()Ljava/lang/String;
    .locals 1

    .prologue
    .line 292
    invoke-direct {p0}, Lcom/amazon/device/ads/DeviceInfo;->setMacAddressIfNotFetched()V

    .line 293
    iget-object v0, p0, Lcom/amazon/device/ads/DeviceInfo;->md5_mac:Ljava/lang/String;

    return-object v0
.end method

.method public getMacSha1()Ljava/lang/String;
    .locals 1

    .prologue
    .line 287
    invoke-direct {p0}, Lcom/amazon/device/ads/DeviceInfo;->setMacAddressIfNotFetched()V

    .line 288
    iget-object v0, p0, Lcom/amazon/device/ads/DeviceInfo;->sha1_mac:Ljava/lang/String;

    return-object v0
.end method

.method public getOrientation()Ljava/lang/String;
    .locals 2

    .prologue
    .line 417
    const/4 v1, 0x0

    .line 418
    .local v1, "orientation":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/Utils;->determineCanonicalScreenOrientation()I

    move-result v0

    .line 419
    .local v0, "canonicalOrientation":I
    sparse-switch v0, :sswitch_data_0

    .line 432
    const-string/jumbo v1, "unknown"

    .line 434
    :goto_0
    return-object v1

    .line 423
    :sswitch_0
    const-string/jumbo v1, "portrait"

    .line 424
    goto :goto_0

    .line 428
    :sswitch_1
    const-string/jumbo v1, "landscape"

    .line 429
    goto :goto_0

    .line 419
    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_1
        0x1 -> :sswitch_0
        0x8 -> :sswitch_1
        0x9 -> :sswitch_0
    .end sparse-switch
.end method

.method public getScalingFactorAsFloat()F
    .locals 1

    .prologue
    .line 400
    iget v0, p0, Lcom/amazon/device/ads/DeviceInfo;->scalingFactor:F

    return v0
.end method

.method public getScalingFactorAsString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 396
    iget-object v0, p0, Lcom/amazon/device/ads/DeviceInfo;->scalingFactorAsString:Ljava/lang/String;

    return-object v0
.end method

.method public getScreenSize(Ljava/lang/String;)Lcom/amazon/device/ads/Size;
    .locals 6
    .param p1, "orientation"    # Ljava/lang/String;

    .prologue
    .line 439
    const-string/jumbo v4, "portrait"

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/amazon/device/ads/DeviceInfo;->portraitScreenSize:Lcom/amazon/device/ads/Size;

    if-eqz v4, :cond_0

    .line 441
    iget-object v4, p0, Lcom/amazon/device/ads/DeviceInfo;->portraitScreenSize:Lcom/amazon/device/ads/Size;

    .line 466
    :goto_0
    return-object v4

    .line 443
    :cond_0
    const-string/jumbo v4, "landscape"

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/amazon/device/ads/DeviceInfo;->landscapeScreenSize:Lcom/amazon/device/ads/Size;

    if-eqz v4, :cond_1

    .line 445
    iget-object v4, p0, Lcom/amazon/device/ads/DeviceInfo;->landscapeScreenSize:Lcom/amazon/device/ads/Size;

    goto :goto_0

    .line 448
    :cond_1
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/device/ads/IInternalAdRegistration;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 449
    .local v0, "context":Landroid/content/Context;
    const-string/jumbo v4, "window"

    invoke-virtual {v0, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/WindowManager;

    .line 450
    .local v3, "wm":Landroid/view/WindowManager;
    new-instance v1, Landroid/util/DisplayMetrics;

    invoke-direct {v1}, Landroid/util/DisplayMetrics;-><init>()V

    .line 451
    .local v1, "metrics":Landroid/util/DisplayMetrics;
    invoke-interface {v3}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v4

    invoke-virtual {v4, v1}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 452
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget v5, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "x"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget v5, v1, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 454
    .local v2, "screenSize":Ljava/lang/String;
    const-string/jumbo v4, "portrait"

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 456
    new-instance v4, Lcom/amazon/device/ads/Size;

    invoke-direct {v4, v2}, Lcom/amazon/device/ads/Size;-><init>(Ljava/lang/String;)V

    iput-object v4, p0, Lcom/amazon/device/ads/DeviceInfo;->portraitScreenSize:Lcom/amazon/device/ads/Size;

    .line 457
    iget-object v4, p0, Lcom/amazon/device/ads/DeviceInfo;->portraitScreenSize:Lcom/amazon/device/ads/Size;

    goto :goto_0

    .line 459
    :cond_2
    const-string/jumbo v4, "landscape"

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 461
    new-instance v4, Lcom/amazon/device/ads/Size;

    invoke-direct {v4, v2}, Lcom/amazon/device/ads/Size;-><init>(Ljava/lang/String;)V

    iput-object v4, p0, Lcom/amazon/device/ads/DeviceInfo;->landscapeScreenSize:Lcom/amazon/device/ads/Size;

    .line 462
    iget-object v4, p0, Lcom/amazon/device/ads/DeviceInfo;->landscapeScreenSize:Lcom/amazon/device/ads/Size;

    goto :goto_0

    .line 466
    :cond_3
    new-instance v4, Lcom/amazon/device/ads/Size;

    invoke-direct {v4, v2}, Lcom/amazon/device/ads/Size;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getSerialMd5()Ljava/lang/String;
    .locals 1

    .prologue
    .line 307
    invoke-direct {p0}, Lcom/amazon/device/ads/DeviceInfo;->setSerialIfNotFetched()V

    .line 308
    iget-object v0, p0, Lcom/amazon/device/ads/DeviceInfo;->md5_serial:Ljava/lang/String;

    return-object v0
.end method

.method public getSerialSha1()Ljava/lang/String;
    .locals 1

    .prologue
    .line 302
    invoke-direct {p0}, Lcom/amazon/device/ads/DeviceInfo;->setSerialIfNotFetched()V

    .line 303
    iget-object v0, p0, Lcom/amazon/device/ads/DeviceInfo;->sha1_serial:Ljava/lang/String;

    return-object v0
.end method

.method public getUdid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 317
    invoke-direct {p0}, Lcom/amazon/device/ads/DeviceInfo;->setUdidIfNotFetched()V

    .line 318
    iget-object v0, p0, Lcom/amazon/device/ads/DeviceInfo;->udid:Ljava/lang/String;

    return-object v0
.end method

.method public getUdidMd5()Ljava/lang/String;
    .locals 1

    .prologue
    .line 327
    invoke-direct {p0}, Lcom/amazon/device/ads/DeviceInfo;->setUdidIfNotFetched()V

    .line 328
    iget-object v0, p0, Lcom/amazon/device/ads/DeviceInfo;->md5_udid:Ljava/lang/String;

    return-object v0
.end method

.method public getUdidSha1()Ljava/lang/String;
    .locals 1

    .prologue
    .line 322
    invoke-direct {p0}, Lcom/amazon/device/ads/DeviceInfo;->setUdidIfNotFetched()V

    .line 323
    iget-object v0, p0, Lcom/amazon/device/ads/DeviceInfo;->sha1_udid:Ljava/lang/String;

    return-object v0
.end method

.method public isMacBad()Z
    .locals 1

    .prologue
    .line 297
    invoke-direct {p0}, Lcom/amazon/device/ads/DeviceInfo;->setMacAddressIfNotFetched()V

    .line 298
    iget-boolean v0, p0, Lcom/amazon/device/ads/DeviceInfo;->bad_mac:Z

    return v0
.end method

.method public isSerialBad()Z
    .locals 1

    .prologue
    .line 312
    invoke-direct {p0}, Lcom/amazon/device/ads/DeviceInfo;->setSerialIfNotFetched()V

    .line 313
    iget-boolean v0, p0, Lcom/amazon/device/ads/DeviceInfo;->bad_serial:Z

    return v0
.end method

.method public isUdidBad()Z
    .locals 1

    .prologue
    .line 332
    invoke-direct {p0}, Lcom/amazon/device/ads/DeviceInfo;->setUdidIfNotFetched()V

    .line 333
    iget-boolean v0, p0, Lcom/amazon/device/ads/DeviceInfo;->bad_udid:Z

    return v0
.end method

.method protected setMacAddress()V
    .locals 13

    .prologue
    const/4 v12, 0x0

    const/4 v11, 0x0

    const/4 v10, 0x1

    .line 92
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v7

    invoke-interface {v7}, Lcom/amazon/device/ads/IInternalAdRegistration;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 93
    .local v0, "context":Landroid/content/Context;
    const-string/jumbo v7, "wifi"

    invoke-virtual {v0, v7}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/net/wifi/WifiManager;

    .line 95
    .local v6, "wifiManager":Landroid/net/wifi/WifiManager;
    const/4 v5, 0x0

    .line 96
    .local v5, "wifiInfo":Landroid/net/wifi/WifiInfo;
    if-eqz v6, :cond_0

    .line 100
    :try_start_0
    invoke-virtual {v6}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/ExceptionInInitializerError; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v5

    .line 112
    :cond_0
    :goto_0
    if-nez v5, :cond_1

    .line 114
    iput-object v11, p0, Lcom/amazon/device/ads/DeviceInfo;->sha1_mac:Ljava/lang/String;

    .line 141
    :goto_1
    iput-boolean v10, p0, Lcom/amazon/device/ads/DeviceInfo;->macFetched:Z

    .line 142
    return-void

    .line 102
    :catch_0
    move-exception v1

    .line 104
    .local v1, "e":Ljava/lang/SecurityException;
    const-string/jumbo v7, "DeviceInfo"

    const-string/jumbo v8, "Unable to get Wifi connection information: %s"

    new-array v9, v10, [Ljava/lang/Object;

    aput-object v1, v9, v12

    invoke-static {v7, v8, v9}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 106
    .end local v1    # "e":Ljava/lang/SecurityException;
    :catch_1
    move-exception v1

    .line 108
    .local v1, "e":Ljava/lang/ExceptionInInitializerError;
    const-string/jumbo v7, "DeviceInfo"

    const-string/jumbo v8, "Unable to get Wifi connection information: %s"

    new-array v9, v10, [Ljava/lang/Object;

    aput-object v1, v9, v12

    invoke-static {v7, v8, v9}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 119
    .end local v1    # "e":Ljava/lang/ExceptionInInitializerError;
    :cond_1
    invoke-virtual {v5}, Landroid/net/wifi/WifiInfo;->getMacAddress()Ljava/lang/String;

    move-result-object v2

    .line 120
    .local v2, "macAddress":Ljava/lang/String;
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v7

    if-nez v7, :cond_3

    .line 122
    :cond_2
    iput-object v11, p0, Lcom/amazon/device/ads/DeviceInfo;->sha1_mac:Ljava/lang/String;

    .line 123
    iput-boolean v10, p0, Lcom/amazon/device/ads/DeviceInfo;->bad_mac:Z

    goto :goto_1

    .line 127
    :cond_3
    const-string/jumbo v7, "((([0-9a-fA-F]){1,2}[-:]){5}([0-9a-fA-F]){1,2})"

    invoke-static {v7}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v3

    .line 128
    .local v3, "macAddressPattern":Ljava/util/regex/Pattern;
    invoke-virtual {v3, v2}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v4

    .line 129
    .local v4, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v4}, Ljava/util/regex/Matcher;->find()Z

    move-result v7

    if-nez v7, :cond_4

    .line 132
    iput-object v11, p0, Lcom/amazon/device/ads/DeviceInfo;->sha1_mac:Ljava/lang/String;

    .line 133
    iput-boolean v10, p0, Lcom/amazon/device/ads/DeviceInfo;->bad_mac:Z

    goto :goto_1

    .line 137
    :cond_4
    invoke-static {v2}, Lcom/amazon/device/ads/Utils;->sha1(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/amazon/device/ads/Utils;->getURLEncodedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/amazon/device/ads/DeviceInfo;->sha1_mac:Ljava/lang/String;

    goto :goto_1
.end method

.method toJsonObject(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 3
    .param p1, "orientation"    # Ljava/lang/String;

    .prologue
    .line 507
    invoke-virtual {p0}, Lcom/amazon/device/ads/DeviceInfo;->getDInfoProperty()Lorg/json/JSONObject;

    move-result-object v0

    .line 508
    .local v0, "json":Lorg/json/JSONObject;
    const-string/jumbo v1, "orientation"

    invoke-static {v0, v1, p1}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 511
    const-string/jumbo v1, "screenSize"

    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/DeviceInfo;->getScreenSize(Ljava/lang/String;)Lcom/amazon/device/ads/Size;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/Size;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 512
    const-string/jumbo v1, "connectionType"

    invoke-virtual {p0}, Lcom/amazon/device/ads/DeviceInfo;->getConnectionType()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->put(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 514
    return-object v0
.end method

.method public toJsonString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 496
    invoke-virtual {p0}, Lcom/amazon/device/ads/DeviceInfo;->getOrientation()Ljava/lang/String;

    move-result-object v0

    .line 497
    .local v0, "orientation":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/DeviceInfo;->toJsonObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
