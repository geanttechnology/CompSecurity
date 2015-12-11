.class public Lcom/poshmark/config/EnvConfig;
.super Ljava/lang/Object;
.source "EnvConfig.java"


# static fields
.field public static final API_SERVER_NAME:Ljava/lang/String; = "https://api.poshmark.com"

.field public static final APSALAR_KEY:Ljava/lang/String; = "PoshmarkProd"

.field public static final APSALAR_SECRET:Ljava/lang/String; = "92GmnhY9"

.field public static final DATABASE_NAME:Ljava/lang/String; = "poshmark_app_Database.db"

.field public static final ENV:Lcom/poshmark/config/Env;

.field public static GCM_PROJECT_ID:Ljava/lang/String; = null

.field public static final GOOGLE_ANALYTICS_ID:Ljava/lang/String;

.field public static final HASOFFERS_ADVERTISER_ID:Ljava/lang/String; = "9056"

.field public static final HASOFFERS_CONVERSION_KEY:Ljava/lang/String; = "026e1400a6bc5a185b79446a9d6620e8"

.field public static final HOCKEY_APPID:Ljava/lang/String; = "01486de8725142766a044552d92ef77f"

.field public static final KOCHAVA_APP_ID:Ljava/lang/String; = "koposhmarkandroid3476533b1c455ecb8"

.field public static final NEWRELIC_APP_ID:Ljava/lang/String; = "AAa319871d49ffd4ff9af36e15b2c6c6ed2d34ad2c"

.field public static final PINTEREST_APP_ID:Ljava/lang/String; = "4794312476046927699"

.field public static final TR_SERVER_NAME:Ljava/lang/String; = "https://tr.poshmark.com"

.field public static final UPLOAD_SERVER_NAME:Ljava/lang/String; = "https://up.poshmark.com"

.field public static USER_STATE_SUMMARY_INTERVAL:I = 0x0

.field public static final WEB_SERVER_NAME:Ljava/lang/String; = "https://www.poshmark.com"


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 8
    sget-object v0, Lcom/poshmark/config/Env;->PRODUCTION:Lcom/poshmark/config/Env;

    sput-object v0, Lcom/poshmark/config/EnvConfig;->ENV:Lcom/poshmark/config/Env;

    .line 20
    const-string v0, "917058316614"

    sput-object v0, Lcom/poshmark/config/EnvConfig;->GCM_PROJECT_ID:Ljava/lang/String;

    .line 22
    const v0, 0x36ee80

    sput v0, Lcom/poshmark/config/EnvConfig;->USER_STATE_SUMMARY_INTERVAL:I

    .line 24
    sget-object v0, Lcom/poshmark/config/BuildTypeConfig;->BUILD_TYPE:Lcom/poshmark/config/BuildType;

    sget-object v1, Lcom/poshmark/config/BuildType;->DEBUG:Lcom/poshmark/config/BuildType;

    if-ne v0, v1, :cond_0

    const-string v0, "UA-24801737-7"

    :goto_0
    sput-object v0, Lcom/poshmark/config/EnvConfig;->GOOGLE_ANALYTICS_ID:Ljava/lang/String;

    return-void

    :cond_0
    const-string v0, "UA-24801737-8"

    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static setupDevIP(Ljava/lang/String;)V
    .locals 0
    .param p0, "ip"    # Ljava/lang/String;

    .prologue
    .line 43
    return-void
.end method
