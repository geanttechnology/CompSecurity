.class public Lco/vine/android/util/BuildUtil;
.super Ljava/lang/Object;
.source "BuildUtil.java"


# static fields
.field public static final APP_TYPE_EXPLORE:I = 0x2

.field public static final APP_TYPE_REGULAR:I = 0x1

.field public static final ENVIRONMENT_DEV:I = 0x2

.field public static final ENVIRONMENT_PRODUCTION:I = 0x1

.field public static final EPHEMERAL_ENABLED:Z = false

.field public static final MARKET_AMAZON:I = 0x2

.field public static final MARKET_ASTAR:I = 0x3

.field public static final MARKET_GOOGLE:I = 0x1

.field private static isOldDeviceOrLowEndDevice:Ljava/lang/Boolean;

.field private static sAppType:I

.field private static sAuthority:Ljava/lang/String;

.field private static sEnvironment:I

.field private static final sIsHwEncodingEnabled:Z

.field private static final sIsSwEncodingEnabled:Z

.field private static sLogsOn:Z

.field private static sMarket:I


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v4, 0x0

    .line 30
    const-string v0, "co.vine.android"

    sput-object v0, Lco/vine/android/util/BuildUtil;->sAuthority:Ljava/lang/String;

    .line 36
    const/4 v0, 0x0

    sput-object v0, Lco/vine/android/util/BuildUtil;->isOldDeviceOrLowEndDevice:Ljava/lang/Boolean;

    .line 37
    sget-boolean v0, Lco/vine/android/recorder/RecordConfigUtils;->HW_ENABLED:Z

    sput-boolean v0, Lco/vine/android/util/BuildUtil;->sIsHwEncodingEnabled:Z

    .line 38
    sget-boolean v0, Lco/vine/android/recorder/RecordConfigUtils;->SW_ENABLED:Z

    sput-boolean v0, Lco/vine/android/util/BuildUtil;->sIsSwEncodingEnabled:Z

    .line 41
    const-string v0, "google"

    const-string v1, "regular"

    const-string v2, "co.vine.android"

    const-string v3, "production"

    const-string v5, "sw"

    invoke-static/range {v0 .. v5}, Lco/vine/android/util/BuildUtil;->setup(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V

    .line 43
    invoke-static {v4}, Lco/vine/android/util/CrashUtil;->setup(Z)V

    .line 44
    const-string v0, "co.vine.android"

    invoke-static {v0}, Lco/vine/android/util/PlayerUtil;->setup(Ljava/lang/String;)V

    .line 45
    const-string v0, "amazon"

    const-string v1, "google"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    const-string v1, "co.vine.android"

    invoke-static {v4, v0, v1}, Lcom/edisonwang/android/slog/SLog;->setup(ZZLjava/lang/String;)V

    .line 46
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getAmazonBucket(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 149
    const v0, 0x7f0e004a

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getAuthority()Ljava/lang/String;
    .locals 1

    .prologue
    .line 129
    const-string v0, ""

    invoke-static {v0}, Lco/vine/android/util/BuildUtil;->getAuthority(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getAuthority(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "suffix"    # Ljava/lang/String;

    .prologue
    .line 133
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lco/vine/android/util/BuildUtil;->sAuthority:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getBaseUrl(Landroid/content/res/Resources;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/res/Resources;

    .prologue
    .line 137
    const v0, 0x7f0e0272

    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getConfigUrl(Landroid/content/res/Resources;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/res/Resources;

    .prologue
    .line 161
    const v0, 0x7f0e0274

    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getExplorePath(Landroid/content/res/Resources;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/res/Resources;

    .prologue
    .line 157
    const v0, 0x7f0e00d4

    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getExploreUrl(Landroid/content/res/Resources;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/res/Resources;

    .prologue
    .line 153
    const v0, 0x7f0e00d3

    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getMarket()I
    .locals 1

    .prologue
    .line 121
    sget v0, Lco/vine/android/util/BuildUtil;->sMarket:I

    return v0
.end method

.method public static getMediaUrl(Landroid/content/res/Resources;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/res/Resources;

    .prologue
    .line 145
    const v0, 0x7f0e0275

    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getRtcUrl(Landroid/content/res/Resources;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/res/Resources;

    .prologue
    .line 169
    const v0, 0x7f0e01b4

    invoke-virtual {p0, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getSenderId(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 173
    const v0, 0x7f0e01c1

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getStatusUrl(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 165
    const v0, 0x7f0e022f

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getWebsiteUrl(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 141
    const v0, 0x7f0e0276

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static isAStar()Z
    .locals 2

    .prologue
    .line 94
    sget v0, Lco/vine/android/util/BuildUtil;->sMarket:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isAmazon()Z
    .locals 2

    .prologue
    .line 86
    sget v0, Lco/vine/android/util/BuildUtil;->sMarket:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isExplore()Z
    .locals 2

    .prologue
    .line 106
    sget v0, Lco/vine/android/util/BuildUtil;->sAppType:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isGoogle()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 90
    sget v1, Lco/vine/android/util/BuildUtil;->sMarket:I

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isI18nOn()Z
    .locals 1

    .prologue
    .line 125
    sget-boolean v0, Lco/vine/android/util/BuildUtil;->sLogsOn:Z

    return v0
.end method

.method public static isIsHwEncodingEnabled()Z
    .locals 1

    .prologue
    .line 82
    sget-boolean v0, Lco/vine/android/util/BuildUtil;->sIsHwEncodingEnabled:Z

    return v0
.end method

.method public static isLogsOn()Z
    .locals 1

    .prologue
    .line 117
    sget-boolean v0, Lco/vine/android/util/BuildUtil;->sLogsOn:Z

    return v0
.end method

.method public static isOldDeviceOrLowEndDevice(Landroid/content/Context;)Z
    .locals 7
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 110
    sget-object v0, Lco/vine/android/util/BuildUtil;->isOldDeviceOrLowEndDevice:Ljava/lang/Boolean;

    if-nez v0, :cond_2

    .line 111
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v0

    if-nez v0, :cond_3

    move v0, v1

    :goto_0
    invoke-static {p0, v0}, Lco/vine/android/util/SystemUtil;->getMemoryRatio(Landroid/content/Context;Z)D

    move-result-wide v3

    const-wide/high16 v5, 0x3ff0000000000000L    # 1.0

    cmpg-double v0, v3, v5

    if-gez v0, :cond_1

    :cond_0
    move v2, v1

    :cond_1
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lco/vine/android/util/BuildUtil;->isOldDeviceOrLowEndDevice:Ljava/lang/Boolean;

    .line 113
    :cond_2
    sget-object v0, Lco/vine/android/util/BuildUtil;->isOldDeviceOrLowEndDevice:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0

    :cond_3
    move v0, v2

    .line 111
    goto :goto_0
.end method

.method public static isProduction()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 98
    sget v1, Lco/vine/android/util/BuildUtil;->sEnvironment:I

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isRegular()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 102
    sget v1, Lco/vine/android/util/BuildUtil;->sAppType:I

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static setup(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    .locals 4
    .param p0, "market"    # Ljava/lang/String;
    .param p1, "appType"    # Ljava/lang/String;
    .param p2, "authority"    # Ljava/lang/String;
    .param p3, "environment"    # Ljava/lang/String;
    .param p4, "logsOn"    # Z
    .param p5, "encoding"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x2

    const/4 v1, 0x1

    .line 50
    const/4 v0, -0x1

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v2

    sparse-switch v2, :sswitch_data_0

    :cond_0
    :goto_0
    packed-switch v0, :pswitch_data_0

    .line 58
    sput v1, Lco/vine/android/util/BuildUtil;->sMarket:I

    .line 62
    :goto_1
    const-string v0, "production"

    invoke-virtual {v0, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 63
    sput v1, Lco/vine/android/util/BuildUtil;->sEnvironment:I

    .line 68
    :goto_2
    const-string v0, "explore"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 69
    sput v3, Lco/vine/android/util/BuildUtil;->sAppType:I

    .line 74
    :goto_3
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 75
    sput-object p2, Lco/vine/android/util/BuildUtil;->sAuthority:Ljava/lang/String;

    .line 78
    :cond_1
    sput-boolean p4, Lco/vine/android/util/BuildUtil;->sLogsOn:Z

    .line 79
    return-void

    .line 50
    :sswitch_0
    const-string v2, "amazon"

    invoke-virtual {p0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :sswitch_1
    const-string v2, "astar"

    invoke-virtual {p0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    move v0, v1

    goto :goto_0

    .line 52
    :pswitch_0
    sput v3, Lco/vine/android/util/BuildUtil;->sMarket:I

    goto :goto_1

    .line 55
    :pswitch_1
    const/4 v0, 0x3

    sput v0, Lco/vine/android/util/BuildUtil;->sMarket:I

    goto :goto_1

    .line 65
    :cond_2
    sput v3, Lco/vine/android/util/BuildUtil;->sEnvironment:I

    goto :goto_2

    .line 71
    :cond_3
    sput v1, Lco/vine/android/util/BuildUtil;->sAppType:I

    goto :goto_3

    .line 50
    nop

    :sswitch_data_0
    .sparse-switch
        -0x544bf9fc -> :sswitch_0
        0x58cee33 -> :sswitch_1
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
