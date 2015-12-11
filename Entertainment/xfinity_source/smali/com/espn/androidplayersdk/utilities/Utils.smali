.class public Lcom/espn/androidplayersdk/utilities/Utils;
.super Ljava/lang/Object;
.source "Utils.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "SimpleDateFormat"
    }
.end annotation


# static fields
.field private static final DATE_TIME_FORMAT:Ljava/lang/String; = "MM/dd/yyyy hh:mm:ss a"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static DateTimeFormatter(Ljava/util/Date;)Ljava/lang/String;
    .locals 6
    .param p0, "date"    # Ljava/util/Date;

    .prologue
    .line 47
    const/4 v1, 0x0

    .line 49
    .local v1, "rtnStr":Ljava/lang/String;
    :try_start_0
    new-instance v2, Ljava/text/SimpleDateFormat;

    const-string v3, "MM/dd/yyyy hh:mm:ss a"

    invoke-direct {v2, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 50
    .local v2, "sdf":Ljava/text/DateFormat;
    invoke-virtual {v2, p0}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 54
    .end local v2    # "sdf":Ljava/text/DateFormat;
    :goto_0
    return-object v1

    .line 51
    :catch_0
    move-exception v0

    .line 52
    .local v0, "e":Ljava/lang/Exception;
    sget-object v3, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->SDKTAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "String format failed"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ljava/util/Date;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static getConnectionType()Ljava/lang/String;
    .locals 5

    .prologue
    .line 210
    :try_start_0
    sget-object v3, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->mCtx:Landroid/content/Context;

    const-string v4, "connectivity"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 211
    .local v0, "cm":Landroid/net/ConnectivityManager;
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v2

    .line 213
    .local v2, "info":Landroid/net/NetworkInfo;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-virtual {v2}, Landroid/net/NetworkInfo;->getType()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    if-nez v3, :cond_0

    .line 214
    const-string v3, "MOBILE"

    .line 220
    .end local v2    # "info":Landroid/net/NetworkInfo;
    :goto_0
    return-object v3

    .line 215
    .restart local v2    # "info":Landroid/net/NetworkInfo;
    :cond_0
    if-eqz v2, :cond_1

    :try_start_1
    invoke-virtual {v2}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-virtual {v2}, Landroid/net/NetworkInfo;->getType()I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_1

    .line 216
    const-string v3, "WiFi"

    goto :goto_0

    .line 217
    .end local v2    # "info":Landroid/net/NetworkInfo;
    :catch_0
    move-exception v1

    .line 218
    .local v1, "e":Ljava/lang/Exception;
    const-string v3, "unable to determin network state"

    const/4 v4, 0x3

    invoke-static {v3, v4, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 220
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_1
    const-string v3, ""

    goto :goto_0
.end method

.method public static getExpiryTime(I)Ljava/lang/String;
    .locals 6
    .param p0, "ttl"    # I
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SimpleDateFormat"
        }
    .end annotation

    .prologue
    .line 66
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "MM/dd/yyyy hh:mm:ss a"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    new-instance v1, Ljava/util/Date;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    mul-int/lit16 v4, p0, 0x3e8

    int-to-long v4, v4

    add-long/2addr v2, v4

    invoke-direct {v1, v2, v3}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static isEmpty(Ljava/lang/String;)Z
    .locals 1
    .param p0, "input"    # Ljava/lang/String;

    .prologue
    .line 102
    invoke-virtual {p0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 103
    const/4 v0, 0x1

    .line 104
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isExpired(Ljava/lang/String;)Z
    .locals 7
    .param p0, "time"    # Ljava/lang/String;

    .prologue
    .line 80
    :try_start_0
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v4, "MM/dd/yyyy hh:mm:ss a"

    invoke-direct {v1, v4}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 82
    .local v1, "dateFormat":Ljava/text/DateFormat;
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 83
    .local v0, "currentDateTime":Ljava/util/Date;
    invoke-virtual {v1, p0}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v3

    .line 85
    .local v3, "expiryTime":Ljava/util/Date;
    invoke-virtual {v3, v0}, Ljava/util/Date;->before(Ljava/util/Date;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    .line 89
    .end local v0    # "currentDateTime":Ljava/util/Date;
    .end local v1    # "dateFormat":Ljava/text/DateFormat;
    .end local v3    # "expiryTime":Ljava/util/Date;
    :goto_0
    return v4

    .line 87
    :catch_0
    move-exception v2

    .line 88
    .local v2, "e":Ljava/lang/Exception;
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->SDKTAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Date comparison failed "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 89
    const/4 v4, 0x1

    goto :goto_0
.end method

.method public static isTablet(Landroid/content/Context;)Ljava/lang/Boolean;
    .locals 14
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const-wide/high16 v12, 0x4000000000000000L    # 2.0

    const/4 v11, 0x1

    .line 183
    sget-object v5, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->mCtx:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    .line 185
    .local v0, "config":Landroid/content/res/Configuration;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    const-string v10, "com.google.android.tv"

    invoke-virtual {v5, v10}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 186
    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    .line 202
    :goto_0
    return-object v5

    .line 187
    :cond_0
    iget v5, v0, Landroid/content/res/Configuration;->screenLayout:I

    and-int/lit8 v5, v5, 0xf

    const/4 v10, 0x4

    if-eq v5, v10, :cond_1

    iget v5, v0, Landroid/content/res/Configuration;->screenLayout:I

    and-int/lit8 v5, v5, 0xf

    const/4 v10, 0x3

    if-ne v5, v10, :cond_2

    .line 188
    :cond_1
    iget v5, v0, Landroid/content/res/Configuration;->touchscreen:I

    if-ne v5, v11, :cond_2

    .line 189
    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    goto :goto_0

    .line 191
    :cond_2
    const-string v5, "window"

    invoke-virtual {p0, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/WindowManager;

    .line 192
    .local v4, "wm":Landroid/view/WindowManager;
    new-instance v1, Landroid/util/DisplayMetrics;

    invoke-direct {v1}, Landroid/util/DisplayMetrics;-><init>()V

    .line 193
    .local v1, "dm":Landroid/util/DisplayMetrics;
    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v5

    invoke-virtual {v5, v1}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 194
    iget v5, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    int-to-float v5, v5

    iget v10, v1, Landroid/util/DisplayMetrics;->xdpi:F

    div-float/2addr v5, v10

    float-to-double v10, v5

    invoke-static {v10, v11, v12, v13}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v6

    .line 195
    .local v6, "x":D
    iget v5, v1, Landroid/util/DisplayMetrics;->heightPixels:I

    int-to-float v5, v5

    iget v10, v1, Landroid/util/DisplayMetrics;->ydpi:F

    div-float/2addr v5, v10

    float-to-double v10, v5

    invoke-static {v10, v11, v12, v13}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v8

    .line 196
    .local v8, "y":D
    add-double v10, v6, v8

    invoke-static {v10, v11}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v2

    .line 199
    .local v2, "screenInches":D
    const-wide/high16 v10, 0x4018000000000000L    # 6.0

    cmpg-double v5, v2, v10

    if-gez v5, :cond_3

    .line 200
    const/4 v5, 0x0

    goto :goto_0

    .line 202
    :cond_3
    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    goto :goto_0
.end method

.method public static isTablet()Z
    .locals 5

    .prologue
    const/4 v3, 0x1

    .line 162
    :try_start_0
    sget-object v2, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->mCtx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    .line 163
    .local v0, "config":Landroid/content/res/Configuration;
    iget v2, v0, Landroid/content/res/Configuration;->screenLayout:I

    and-int/lit8 v2, v2, 0xf

    const/4 v4, 0x3

    if-eq v2, v4, :cond_0

    .line 164
    iget v2, v0, Landroid/content/res/Configuration;->screenLayout:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    and-int/lit8 v2, v2, 0xf

    const/4 v4, 0x4

    if-ne v2, v4, :cond_1

    :cond_0
    move v2, v3

    .line 172
    :goto_0
    return v2

    .line 167
    :cond_1
    const/4 v2, 0x0

    goto :goto_0

    .line 169
    :catch_0
    move-exception v1

    .line 170
    .local v1, "e":Ljava/lang/Exception;
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v4, "Utils.isTablet(); Error: "

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    :goto_1
    const/4 v4, 0x5

    invoke-static {v2, v4, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    move v2, v3

    .line 172
    goto :goto_0

    .line 170
    :cond_2
    const-string v2, ""

    goto :goto_1
.end method

.method public static sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    .locals 2
    .param p0, "msg"    # Ljava/lang/String;
    .param p1, "level"    # I
    .param p2, "e"    # Ljava/lang/Exception;

    .prologue
    .line 121
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getLoggingLevel()I

    move-result v0

    .line 123
    .local v0, "sdkLoggingLevel":I
    const/4 v1, 0x1

    if-ne p1, v1, :cond_1

    if-lt p1, v0, :cond_1

    .line 124
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->SDKTAG:Ljava/lang/String;

    invoke-static {v1, p0, p2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 133
    :cond_0
    :goto_0
    return-void

    .line 125
    :cond_1
    const/4 v1, 0x2

    if-ne p1, v1, :cond_2

    if-lt p1, v0, :cond_2

    .line 126
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->SDKTAG:Ljava/lang/String;

    invoke-static {v1, p0, p2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 127
    :cond_2
    const/4 v1, 0x3

    if-ne p1, v1, :cond_3

    if-lt p1, v0, :cond_3

    .line 128
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->SDKTAG:Ljava/lang/String;

    invoke-static {v1, p0, p2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 129
    :cond_3
    const/4 v1, 0x4

    if-ne p1, v1, :cond_4

    if-lt p1, v0, :cond_4

    .line 130
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->SDKTAG:Ljava/lang/String;

    invoke-static {v1, p0, p2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 131
    :cond_4
    const/4 v1, 0x5

    if-ne p1, v1, :cond_0

    if-lt p1, v0, :cond_0

    .line 132
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->SDKTAG:Ljava/lang/String;

    invoke-static {v1, p0, p2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public static toBase64fromString(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "text"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 141
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    .line 142
    .local v0, "bytes":[B
    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v1

    const-string v2, "UTF-8"

    invoke-static {v1, v2}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static url(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "text"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 151
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    .line 152
    .local v0, "bytes":[B
    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v1

    const-string v2, "UTF-8"

    invoke-static {v1, v2}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
