.class Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;
.super Ljava/lang/Object;
.source "FeedsManagerAPI.java"


# static fields
.field private static BASE_CONFIG_URL:Ljava/lang/String; = null

.field private static BASE_ESPN_URL:Ljava/lang/String; = null

.field protected static final BASE_SUBCATEGORY_URL_EXT:Ljava/lang/String; = "/listings?subcategories="

.field private static BASE_VOD_URL:Ljava/lang/String; = null

.field protected static final SportId:Ljava/lang/String; = "sportId"

.field protected static final eventMetaRelationType:Ljava/lang/String; = "relationType"

.field protected static final eventType:Ljava/lang/String; = "eventType"

.field protected static final eventTypeVOD:Ljava/lang/String; = "VOD"

.field protected static final featuredCategoryEventType:Ljava/lang/String; = "featuredCatEventType"

.field protected static final featuredTopSportEventType:Ljava/lang/String; = "featuredTopSportEventType"

.field protected static final featuredType:Ljava/lang/String; = "featuredType"

.field protected static final network:Ljava/lang/String; = "network"


# instance fields
.field private final app:Ljava/lang/String;

.field private final format:Ljava/lang/String;

.field mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

.field private final platform:Ljava/lang/String;

.field serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-string v0, ""

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    .line 26
    const-string v0, ""

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_CONFIG_URL:Ljava/lang/String;

    .line 29
    const-string v0, ""

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_VOD_URL:Ljava/lang/String;

    .line 39
    return-void
.end method

.method protected constructor <init>()V
    .locals 2

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    const-string v0, "android"

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->platform:Ljava/lang/String;

    .line 45
    const-string v0, "ios_tablet"

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->app:Ljava/lang/String;

    .line 46
    const-string v0, "json"

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->format:Ljava/lang/String;

    .line 49
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;-><init>()V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    .line 50
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    .line 51
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getVODApiUrl()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_VOD_URL:Ljava/lang/String;

    .line 52
    sget-boolean v0, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->IS_QA:Z

    if-eqz v0, :cond_0

    .line 53
    const-string v0, "http://broadband-qa.espn.go.com/"

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_CONFIG_URL:Ljava/lang/String;

    .line 56
    :goto_0
    return-void

    .line 55
    :cond_0
    const-string v0, "http://espn.go.com/espn360/"

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_CONFIG_URL:Ljava/lang/String;

    goto :goto_0
.end method

.method protected constructor <init>(Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;)V
    .locals 0
    .param p1, "pListener"    # Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;-><init>()V

    .line 60
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    .line 61
    return-void
.end method


# virtual methods
.method protected getBestOfFeturedEvents(Ljava/util/HashMap;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v8, 0x5

    .line 211
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_VOD_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "best-of?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getDeviceTypeParam()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 212
    .local v1, "url":Ljava/lang/String;
    if-nez p1, :cond_0

    .line 213
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .end local p1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local v7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object p1, v7

    .line 214
    .end local v7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local p1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    const-string v0, "featuredType"

    const/16 v2, 0xe

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {p1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 215
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    move-object v5, p1

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 219
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 216
    :catch_0
    move-exception v6

    .line 217
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v8, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getChannelFeed()V
    .locals 8

    .prologue
    const/4 v7, 0x5

    .line 76
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "networks?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApinetworks()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 77
    .local v1, "url":Ljava/lang/String;
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 81
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 78
    :catch_0
    move-exception v6

    .line 79
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v7, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getConfigFeed()V
    .locals 8

    .prologue
    const/4 v7, 0x5

    .line 65
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_CONFIG_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "configs/sdk?version="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->SDK_VERSION_FOR_API:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&platform="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "android"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&partner="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 66
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiPartnerName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 65
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 67
    .local v1, "url":Ljava/lang/String;
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 71
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 68
    :catch_0
    move-exception v6

    .line 69
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v7, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getEventByGameId(Ljava/lang/String;)V
    .locals 8
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x5

    .line 489
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "listings?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 491
    .local v1, "url":Ljava/lang/String;
    if-eqz p1, :cond_0

    invoke-static {p1}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 501
    .end local v1    # "url":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 494
    .restart local v1    # "url":Ljava/lang/String;
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "eventId="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 495
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApinetworks()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 497
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 498
    .end local v1    # "url":Ljava/lang/String;
    :catch_0
    move-exception v6

    .line 499
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v7, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getEventById(Ljava/lang/String;)V
    .locals 8
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x5

    .line 455
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "listings?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 457
    .local v1, "url":Ljava/lang/String;
    if-eqz p1, :cond_0

    invoke-static {p1}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 467
    .end local v1    # "url":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 460
    .restart local v1    # "url":Ljava/lang/String;
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "id="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 461
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApinetworks()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 463
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 464
    .end local v1    # "url":Ljava/lang/String;
    :catch_0
    move-exception v6

    .line 465
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v7, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getEventsByChannelFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 8
    .param p1, "networkCode"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "limit"    # Ljava/lang/String;
    .param p4, "start"    # Ljava/lang/String;
    .param p5, "dateStart"    # Ljava/lang/String;
    .param p6, "dateLimit"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 399
    .local p7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "listings?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 400
    .local v1, "url":Ljava/lang/String;
    if-nez p7, :cond_0

    .line 401
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .end local p7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local v7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object p7, v7

    .line 403
    .end local v7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local p7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    if-eqz p1, :cond_1

    invoke-static {p1}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 404
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "networks="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 405
    const-string v0, "network"

    invoke-virtual {p7, v0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 407
    :cond_1
    if-eqz p2, :cond_2

    invoke-static {p2}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 408
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&types="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 409
    const-string v0, "eventType"

    invoke-virtual {p7, v0, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 411
    :cond_2
    if-eqz p3, :cond_3

    invoke-static {p3}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 412
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&limit="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 413
    :cond_3
    if-eqz p4, :cond_4

    invoke-static {p4}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 414
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&offset="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 415
    :cond_4
    if-eqz p5, :cond_5

    invoke-static {p5}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    if-eqz p6, :cond_5

    invoke-static {p6}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 416
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&dates="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "-"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 418
    :cond_5
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 419
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    move-object v5, p7

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 423
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 420
    :catch_0
    move-exception v6

    .line 421
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    const/4 v2, 0x5

    invoke-static {v0, v2, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getEventsByChannelSortedByLeagueFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 8
    .param p1, "networkCode"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "limit"    # Ljava/lang/String;
    .param p4, "start"    # Ljava/lang/String;
    .param p5, "dateStart"    # Ljava/lang/String;
    .param p6, "dateLimit"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 362
    .local p7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "categories/listings?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 363
    .local v1, "url":Ljava/lang/String;
    if-nez p7, :cond_0

    .line 364
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .end local p7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local v7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object p7, v7

    .line 366
    .end local v7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local p7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    if-eqz p1, :cond_1

    invoke-static {p1}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 367
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "networks="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 368
    const-string v0, "network"

    invoke-virtual {p7, v0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 370
    :cond_1
    if-eqz p2, :cond_2

    invoke-static {p2}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 371
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&types="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 372
    const-string v0, "eventType"

    invoke-virtual {p7, v0, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 374
    :cond_2
    if-eqz p3, :cond_3

    invoke-static {p3}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 375
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&limit="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 376
    :cond_3
    if-eqz p4, :cond_4

    invoke-static {p4}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 377
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&offset="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 379
    :cond_4
    if-eqz p5, :cond_5

    invoke-static {p5}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    if-eqz p6, :cond_5

    invoke-static {p6}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 380
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&dates="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "-"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 381
    :cond_5
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 383
    const-string v0, "relationType"

    const-string v2, "8"

    invoke-virtual {p7, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 385
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    move-object v5, p7

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 389
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 386
    :catch_0
    move-exception v6

    .line 387
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    const/4 v2, 0x5

    invoke-static {v0, v2, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getEventsBySportFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 8
    .param p1, "sportsId"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "limit"    # Ljava/lang/String;
    .param p4, "start"    # Ljava/lang/String;
    .param p5, "dateStart"    # Ljava/lang/String;
    .param p6, "dateLimit"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 293
    .local p7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "listings?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 294
    .local v1, "url":Ljava/lang/String;
    if-nez p7, :cond_0

    .line 295
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .end local p7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local v7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object p7, v7

    .line 297
    .end local v7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local p7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    if-eqz p1, :cond_1

    invoke-static {p1}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 298
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "categories="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 299
    :cond_1
    if-eqz p2, :cond_2

    invoke-static {p2}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 300
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&types="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 301
    const-string v0, "eventType"

    invoke-virtual {p7, v0, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 303
    :cond_2
    if-eqz p3, :cond_3

    invoke-static {p3}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 304
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&limit="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 305
    :cond_3
    if-eqz p4, :cond_4

    invoke-static {p4}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 306
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&offset="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 307
    :cond_4
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApinetworks()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 309
    if-eqz p5, :cond_5

    invoke-static {p5}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    if-eqz p6, :cond_5

    invoke-static {p6}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 310
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&dates="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "-"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 312
    :cond_5
    const-string v0, "sportId"

    invoke-virtual {p7, v0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 314
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    move-object v5, p7

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 318
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 315
    :catch_0
    move-exception v6

    .line 316
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    const/4 v2, 0x5

    invoke-static {v0, v2, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getEventsBySportSortedByLeagueFeed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 9
    .param p1, "sportsId"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "abbre"    # Ljava/lang/String;
    .param p4, "limit"    # Ljava/lang/String;
    .param p5, "start"    # Ljava/lang/String;
    .param p6, "dateStart"    # Ljava/lang/String;
    .param p7, "dateLimit"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 328
    .local p8, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :try_start_0
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "categories/"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "/listings?"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 329
    .local v2, "url":Ljava/lang/String;
    if-nez p8, :cond_0

    .line 330
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .end local p8    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local v8, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object/from16 p8, v8

    .line 332
    .end local v8    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local p8    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    if-eqz p2, :cond_1

    invoke-static {p2}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 333
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "&types="

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 334
    const-string v1, "eventType"

    move-object/from16 v0, p8

    invoke-virtual {v0, v1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 336
    :cond_1
    if-eqz p4, :cond_2

    invoke-static {p4}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 337
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "&limit="

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 338
    :cond_2
    if-eqz p5, :cond_3

    invoke-static {p5}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 339
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "&offset="

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 340
    :cond_3
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "&"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "&"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApinetworks()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 342
    if-eqz p6, :cond_4

    invoke-static {p6}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4

    if-eqz p7, :cond_4

    invoke-static/range {p7 .. p7}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4

    .line 343
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "&dates="

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "-"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object/from16 v0, p7

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 345
    :cond_4
    const-string v1, "sportId"

    move-object/from16 v0, p8

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 346
    const-string v1, "relationType"

    const-string v3, "7"

    move-object/from16 v0, p8

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 348
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v3, 0x1

    const/4 v4, 0x5

    iget-object v5, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    move-object/from16 v6, p8

    invoke-virtual/range {v1 .. v6}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 352
    .end local v2    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 349
    :catch_0
    move-exception v7

    .line 350
    .local v7, "e":Ljava/lang/Exception;
    const-string v1, "Error: "

    const/4 v3, 0x5

    invoke-static {v1, v3, v7}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getEventsForFeaturedCategory(Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "baseUrl"    # Ljava/lang/String;
    .param p3, "type"    # Ljava/lang/String;
    .param p4, "startDate"    # Ljava/lang/String;
    .param p5, "endDate"    # Ljava/lang/String;
    .param p6, "start"    # Ljava/lang/String;
    .param p7, "limit"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 112
    .local p2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApinetworks()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 113
    .local v1, "url":Ljava/lang/String;
    if-nez p2, :cond_0

    .line 114
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .end local p2    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local v7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object p2, v7

    .line 115
    .end local v7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local p2    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    const-string v0, "featuredType"

    const/16 v2, 0x1f

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {p2, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 117
    if-eqz p3, :cond_1

    invoke-static {p3}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 118
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&types="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 119
    const-string v0, "eventType"

    invoke-virtual {p2, v0, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 121
    :cond_1
    if-eqz p7, :cond_2

    invoke-static {p7}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 122
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&limit="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 123
    :cond_2
    if-eqz p6, :cond_3

    invoke-static {p6}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 124
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&offset="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 126
    :cond_3
    if-eqz p4, :cond_4

    invoke-static {p4}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    if-eqz p5, :cond_4

    invoke-static {p5}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 127
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&dates="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "-"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 129
    :cond_4
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    move-object v5, p2

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 133
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 130
    :catch_0
    move-exception v6

    .line 131
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    const/4 v2, 0x5

    invoke-static {v0, v2, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getEventsForTopSport(Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 8
    .param p1, "urlExt"    # Ljava/lang/String;
    .param p3, "type"    # Ljava/lang/String;
    .param p4, "startDate"    # Ljava/lang/String;
    .param p5, "endDate"    # Ljava/lang/String;
    .param p6, "start"    # Ljava/lang/String;
    .param p7, "limit"    # Ljava/lang/String;
    .param p8, "isVod"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 140
    .local p2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    if-nez p8, :cond_5

    .line 141
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApinetworks()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 145
    .local v1, "url":Ljava/lang/String;
    :goto_0
    if-nez p2, :cond_0

    .line 146
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .end local p2    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local v7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object p2, v7

    .line 147
    .end local v7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local p2    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    const-string v0, "featuredType"

    const/16 v2, 0x20

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {p2, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 149
    if-eqz p3, :cond_1

    invoke-static {p3}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 150
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&types="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 151
    const-string v0, "eventType"

    invoke-virtual {p2, v0, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 153
    :cond_1
    if-eqz p7, :cond_2

    invoke-static {p7}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 154
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&limit="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 155
    :cond_2
    if-eqz p6, :cond_3

    invoke-static {p6}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 156
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&offset="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 158
    :cond_3
    if-eqz p4, :cond_4

    invoke-static {p4}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    if-eqz p5, :cond_4

    invoke-static {p5}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 159
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&dates="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "-"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 161
    :cond_4
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    move-object v5, p2

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V

    .line 165
    .end local v1    # "url":Ljava/lang/String;
    :goto_1
    return-void

    .line 143
    :cond_5
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .restart local v1    # "url":Ljava/lang/String;
    goto/16 :goto_0

    .line 162
    .end local v1    # "url":Ljava/lang/String;
    :catch_0
    move-exception v6

    .line 163
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    const/4 v2, 0x5

    invoke-static {v0, v2, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_1
.end method

.method protected getFeturedCategories(Ljava/util/HashMap;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v8, 0x5

    .line 99
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "features?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 100
    .local v1, "url":Ljava/lang/String;
    if-nez p1, :cond_0

    .line 101
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .end local p1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local v7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object p1, v7

    .line 102
    .end local v7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local p1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    move-object v5, p1

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 106
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 103
    :catch_0
    move-exception v6

    .line 104
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v8, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getFeturedEventsFeed(Ljava/util/HashMap;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v8, 0x5

    .line 86
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "listings/top?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApinetworks()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 87
    .local v1, "url":Ljava/lang/String;
    if-nez p1, :cond_0

    .line 88
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .end local p1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local v7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object p1, v7

    .line 89
    .end local v7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local p1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    const-string v0, "featuredType"

    const/16 v2, 0xb

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {p1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    move-object v5, p1

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 94
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 91
    :catch_0
    move-exception v6

    .line 92
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v8, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getFeturedEventsForCatagoryFeed(Lcom/espn/androidplayersdk/datamanager/EPSport;Ljava/util/HashMap;)V
    .locals 9
    .param p1, "epSport"    # Lcom/espn/androidplayersdk/datamanager/EPSport;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/espn/androidplayersdk/datamanager/EPSport;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v8, 0x5

    .line 183
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/categories/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getAbbreviation()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/listings/top?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 184
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApinetworks()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 183
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 185
    .local v1, "url":Ljava/lang/String;
    if-nez p2, :cond_0

    .line 186
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .end local p2    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local v7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object p2, v7

    .line 187
    .end local v7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local p2    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    const-string v0, "featuredType"

    const/16 v2, 0x10

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {p2, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 188
    const-string v0, "sportId"

    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 189
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    move-object v5, p2

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 193
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 190
    :catch_0
    move-exception v6

    .line 191
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v8, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getFeturedEventsForE3Feed(ILjava/lang/String;Ljava/util/HashMap;)V
    .locals 9
    .param p1, "featkey"    # I
    .param p2, "subKeyMeta"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p3, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v8, 0x5

    .line 170
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "listings/top?networks="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 171
    .local v1, "url":Ljava/lang/String;
    if-nez p3, :cond_0

    .line 172
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .end local p3    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local v7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object p3, v7

    .line 173
    .end local v7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local p3    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    const-string v0, "featuredType"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {p3, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 174
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    move-object v5, p3

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 178
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 175
    :catch_0
    move-exception v6

    .line 176
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v8, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getLiveEventByNetworkId(Ljava/lang/String;)V
    .locals 8
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x5

    .line 506
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "listings?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 508
    .local v1, "url":Ljava/lang/String;
    if-eqz p1, :cond_0

    invoke-static {p1}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 519
    .end local v1    # "url":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 511
    .restart local v1    # "url":Ljava/lang/String;
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "networks="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 512
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&types=live"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 513
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 515
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 516
    .end local v1    # "url":Ljava/lang/String;
    :catch_0
    move-exception v6

    .line 517
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v7, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getLiveEventForLinearNetwork(Ljava/lang/String;)V
    .locals 8
    .param p1, "networkId"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x5

    .line 472
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "listings?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 474
    .local v1, "url":Ljava/lang/String;
    if-eqz p1, :cond_0

    invoke-static {p1}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 484
    .end local v1    # "url":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 477
    .restart local v1    # "url":Ljava/lang/String;
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "networks="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 478
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&types=live"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 479
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 480
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 481
    .end local v1    # "url":Ljava/lang/String;
    :catch_0
    move-exception v6

    .line 482
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v7, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getLiveEventsFeed(Ljava/util/HashMap;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v8, 0x5

    .line 253
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "listings?types=live&enable=networksort&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApinetworks()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 254
    .local v1, "url":Ljava/lang/String;
    if-nez p1, :cond_0

    .line 255
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .end local p1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local v7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object p1, v7

    .line 256
    .end local v7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local p1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    move-object v5, p1

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 260
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 257
    :catch_0
    move-exception v6

    .line 258
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v8, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getMaintianSessionResponse(Ljava/lang/String;)V
    .locals 8
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x5

    .line 535
    :try_start_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x2

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    const/4 v5, 0x0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 539
    :goto_0
    return-void

    .line 536
    :catch_0
    move-exception v6

    .line 537
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v7, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getMustSeeFeturedEvents(Ljava/util/HashMap;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v8, 0x5

    .line 198
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_VOD_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "must-see?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getDeviceTypeParam()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 199
    .local v1, "url":Ljava/lang/String;
    if-nez p1, :cond_0

    .line 200
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .end local p1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local v7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object p1, v7

    .line 201
    .end local v7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local p1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    const-string v0, "featuredType"

    const/16 v2, 0xd

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {p1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 202
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    move-object v5, p1

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 206
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 203
    :catch_0
    move-exception v6

    .line 204
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v8, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getProgramingChangeResponse(Ljava/lang/String;)V
    .locals 8
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x5

    .line 545
    :try_start_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x2

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    const/4 v5, 0x0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 549
    :goto_0
    return-void

    .line 546
    :catch_0
    move-exception v6

    .line 547
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v7, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getSportsFeed(Ljava/lang/String;)V
    .locals 8
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x5

    .line 265
    :try_start_0
    const-string v0, "101"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 266
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "categories?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 269
    .local v1, "url":Ljava/lang/String;
    :goto_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V

    .line 273
    .end local v1    # "url":Ljava/lang/String;
    :goto_1
    return-void

    .line 268
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "categories/top?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .restart local v1    # "url":Ljava/lang/String;
    goto :goto_0

    .line 270
    .end local v1    # "url":Ljava/lang/String;
    :catch_0
    move-exception v6

    .line 271
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v7, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_1
.end method

.method protected getStartSessionResponse(Ljava/lang/String;)V
    .locals 8
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x5

    .line 525
    :try_start_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x2

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    const/4 v5, 0x0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 529
    :goto_0
    return-void

    .line 526
    :catch_0
    move-exception v6

    .line 527
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v7, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getTopVODFeturedEvents(Ljava/util/HashMap;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v8, 0x5

    .line 224
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_VOD_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "top?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getDeviceTypeParam()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 225
    .local v1, "url":Ljava/lang/String;
    if-nez p1, :cond_0

    .line 226
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .end local p1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local v7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object p1, v7

    .line 227
    .end local v7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local p1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    const-string v0, "featuredType"

    const/16 v2, 0xf

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {p1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 228
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    move-object v5, p1

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 232
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 229
    :catch_0
    move-exception v6

    .line 230
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v8, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getTrendingFeturedEvents(Ljava/util/HashMap;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v8, 0x5

    .line 237
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "trending?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getDeviceTypeParam()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApinetworks()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 241
    .local v1, "url":Ljava/lang/String;
    if-nez p1, :cond_0

    .line 242
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .end local p1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local v7, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object p1, v7

    .line 243
    .end local v7    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local p1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    const-string v0, "featuredType"

    const/16 v2, 0x11

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {p1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 244
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    move-object v5, p1

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 248
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 245
    :catch_0
    move-exception v6

    .line 246
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v8, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getUserDataFeed(Ljava/lang/String;)V
    .locals 8
    .param p1, "udid"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x5

    .line 279
    :try_start_0
    const-string v1, "http://broadband.espn.go.com/espn3/auth/mobile/userData?app=ios_tablet&format=json"

    .line 281
    .local v1, "url":Ljava/lang/String;
    if-eqz p1, :cond_0

    invoke-static {p1}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 282
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&udid="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 283
    :cond_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 287
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 284
    :catch_0
    move-exception v6

    .line 285
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v7, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getXMLFeed(Ljava/lang/String;)V
    .locals 7
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 555
    :try_start_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x6

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    const/4 v5, 0x0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 559
    :goto_0
    return-void

    .line 556
    :catch_0
    move-exception v6

    .line 557
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    const/4 v1, 0x5

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected searchFeed(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V
    .locals 9
    .param p1, "keyword"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "limit"    # I
    .param p4, "start"    # I
    .param p5, "dateStart"    # Ljava/lang/String;
    .param p6, "dateLimit"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x5

    const/4 v7, 0x1

    .line 432
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->BASE_ESPN_URL:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "listings?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 434
    .local v1, "url":Ljava/lang/String;
    if-eqz p1, :cond_0

    invoke-static {p1}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 435
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "keywords="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 436
    :cond_0
    if-eqz p2, :cond_1

    invoke-static {p2}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 437
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&types="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 438
    :cond_1
    if-eqz p5, :cond_2

    invoke-static {p5}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    if-eqz p6, :cond_2

    invoke-static {p6}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 439
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&dates="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "-"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 441
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&limit="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 442
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&offset="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 443
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "&"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApinetworks()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 445
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->serverCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    const/4 v2, 0x1

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 450
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 446
    :catch_0
    move-exception v6

    .line 447
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    invoke-static {v0, v8, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 448
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    invoke-interface {v0, v7}, Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;->handleError(I)V

    goto :goto_0
.end method
