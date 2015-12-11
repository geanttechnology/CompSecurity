.class Lcom/espn/androidplayersdk/datamanager/DataManager;
.super Ljava/lang/Object;
.source "DataManager.java"


# static fields
.field protected static feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

.field protected static mCtx:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 10
    const/4 v0, 0x0

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    .line 11
    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected deinitializeDataFactory()V
    .locals 4

    .prologue
    .line 30
    :try_start_0
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->cleanEventsTable()V

    .line 31
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->close()V

    .line 35
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->clearConfigData()V

    .line 36
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->clearStartSessionData()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 40
    :goto_0
    return-void

    .line 37
    :catch_0
    move-exception v0

    .line 38
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Error deintializing data factory: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    :goto_1
    const/4 v2, 0x5

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    :cond_0
    const-string v1, ""

    goto :goto_1
.end method

.method protected getDbInstance()Lcom/espn/androidplayersdk/datamanager/FeedsDB;
    .locals 1

    .prologue
    .line 43
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    return-object v0
.end method

.method protected initializeDataFactory(Landroid/content/Context;)V
    .locals 4
    .param p1, "pCtx"    # Landroid/content/Context;

    .prologue
    .line 16
    :try_start_0
    sput-object p1, Lcom/espn/androidplayersdk/datamanager/DataManager;->mCtx:Landroid/content/Context;

    .line 17
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    if-nez v1, :cond_0

    .line 18
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-direct {v1, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;-><init>(Landroid/content/Context;)V

    sput-object v1, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    .line 20
    :cond_0
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;-><init>()V

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getConfigFeed()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 24
    :goto_0
    return-void

    .line 21
    :catch_0
    move-exception v0

    .line 22
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Error intializing data factory: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    :goto_1
    const/4 v2, 0x5

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    :cond_1
    const-string v1, ""

    goto :goto_1
.end method
