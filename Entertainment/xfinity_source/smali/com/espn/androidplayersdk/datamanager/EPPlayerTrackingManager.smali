.class public Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;
.super Ljava/lang/Object;
.source "EPPlayerTrackingManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$Milestoneping;,
        Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;,
        Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;
    }
.end annotation


# static fields
.field private static BASE_URL:Ljava/lang/String; = null

.field private static final TIME_FORMATT:Ljava/lang/String; = "d/M/yyyy H:mm:ss"

.field private static mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

.field private static mEPPlayerTrackingManager:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

.field private static srcApp:Ljava/lang/String;


# instance fields
.field private affiliateID:Ljava/lang/String;

.field private appVersion:Ljava/lang/String;

.field private beaconFiredTime:Ljava/util/Date;

.field private callback:Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;

.field private isAuthenticated:Z

.field private final noLeague:Ljava/lang/String;

.field private final partnerLocation:Ljava/lang/String;

.field private partnerName:Ljava/lang/String;

.field private pingTime:J

.field private platform:Ljava/lang/String;

.field private swid:Ljava/lang/String;

.field timer:Ljava/util/Timer;

.field private videoStartType:Ljava/lang/String;

.field private final watchEspn:Ljava/lang/String;

.field private final watchEspnPlayer:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 51
    sput-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPPlayerTrackingManager:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    .line 53
    const-string v0, ""

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->BASE_URL:Ljava/lang/String;

    .line 56
    sput-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->srcApp:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->isAuthenticated:Z

    .line 58
    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->videoStartType:Ljava/lang/String;

    .line 59
    const-string v0, ""

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->partnerName:Ljava/lang/String;

    .line 62
    const-string v0, ""

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->affiliateID:Ljava/lang/String;

    .line 63
    const-string v0, ""

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->swid:Ljava/lang/String;

    .line 64
    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->beaconFiredTime:Ljava/util/Date;

    .line 65
    const-string v0, "watchespn"

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->watchEspn:Ljava/lang/String;

    .line 66
    const-string v0, ""

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->platform:Ljava/lang/String;

    .line 67
    const-string v0, ""

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->appVersion:Ljava/lang/String;

    .line 68
    const-string v0, "watchespn Player"

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->watchEspnPlayer:Ljava/lang/String;

    .line 69
    const-string v0, "no league set"

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->noLeague:Ljava/lang/String;

    .line 70
    const-string v0, "na"

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->partnerLocation:Ljava/lang/String;

    .line 71
    const-wide/32 v0, 0x493e0

    iput-wide v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->pingTime:J

    .line 49
    return-void
.end method

.method static synthetic access$0(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->videoStartType:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->platform:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$10()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->BASE_URL:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$11(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 392
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->getTimeForOmniture()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$12(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 387
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->endOfUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$13(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)V
    .locals 0

    .prologue
    .line 205
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->milestone()V

    return-void
.end method

.method static synthetic access$2(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->swid:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$3(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->appVersion:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$4(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Z
    .locals 1

    .prologue
    .line 57
    iget-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->isAuthenticated:Z

    return v0
.end method

.method static synthetic access$5()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->srcApp:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$6(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Ljava/util/Date;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->beaconFiredTime:Ljava/util/Date;

    return-void
.end method

.method static synthetic access$7(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/util/Date;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->beaconFiredTime:Ljava/util/Date;

    return-object v0
.end method

.method static synthetic access$8(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->callback:Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;

    return-object v0
.end method

.method static synthetic access$9(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->partnerName:Ljava/lang/String;

    return-object v0
.end method

.method private final endOfUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 388
    const-string v0, "&AQE=1"

    return-object v0
.end method

.method public static getAffiliateUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 122
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "analytics"

    const-string v2, "affiliateUrl"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getInstance()Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;
    .locals 2

    .prologue
    .line 81
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPPlayerTrackingManager:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    if-nez v0, :cond_0

    .line 82
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;-><init>()V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPPlayerTrackingManager:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    .line 83
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiPartnerName()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPPlayerTrackingManager:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const-string v1, "watchespn"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 84
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPPlayerTrackingManager:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    const-string v1, "na"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->partnerName:Ljava/lang/String;

    .line 87
    :goto_0
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPPlayerTrackingManager:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->prepareURL()Ljava/lang/String;

    .line 89
    :cond_0
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPPlayerTrackingManager:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    return-object v0

    .line 86
    :cond_1
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPPlayerTrackingManager:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiPartnerName()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->partnerName:Ljava/lang/String;

    goto :goto_0
.end method

.method public static getStreamLimitingConfig()Ljava/lang/String;
    .locals 3

    .prologue
    .line 167
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "streamLimiting"

    invoke-virtual {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getTimeForOmniture()Ljava/lang/String;
    .locals 8

    .prologue
    .line 393
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    .line 394
    .local v1, "date":Ljava/util/Date;
    invoke-static {}, Ljava/util/GregorianCalendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 395
    .local v0, "calender":Ljava/util/Calendar;
    const/4 v5, 0x7

    invoke-virtual {v0, v5}, Ljava/util/Calendar;->get(I)I

    move-result v3

    .line 396
    .local v3, "day":I
    const/16 v5, 0xf

    invoke-virtual {v0, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    const/16 v6, 0x10

    invoke-virtual {v0, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    add-int/2addr v5, v6

    neg-int v5, v5

    const v6, 0xea60

    div-int v4, v5, v6

    .line 397
    .local v4, "min":I
    new-instance v5, Ljava/text/SimpleDateFormat;

    const-string v6, "d/M/yyyy H:mm:ss"

    sget-object v7, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v5, v6, v7}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    invoke-virtual {v5, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    .line 398
    .local v2, "dateStr":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 399
    return-object v2
.end method

.method public static getVID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 150
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getUUID()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private milestone()V
    .locals 5

    .prologue
    .line 207
    :try_start_0
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->MILESTONE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    const/4 v4, 0x0

    invoke-direct {v1, p0, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V

    .line 208
    .local v1, "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 212
    .end local v1    # "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    :goto_0
    return-void

    .line 209
    :catch_0
    move-exception v0

    .line 210
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Player tracking manager failed milestone ping"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method private final prepareURL()Ljava/lang/String;
    .locals 4

    .prologue
    .line 376
    new-instance v1, Ljava/util/Random;

    const-wide/32 v2, 0x12ac60b

    invoke-direct {v1, v2, v3}, Ljava/util/Random;-><init>(J)V

    .line 377
    .local v1, "rand":Ljava/util/Random;
    const-string v2, "http://"

    sput-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->BASE_URL:Ljava/lang/String;

    .line 379
    :try_start_0
    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->BASE_URL:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getOmnitureTrackingServer()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/b/ss/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getOmnitureSuiteID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/0/OIP-2.1/s"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Ljava/util/Random;->nextInt()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "?"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->BASE_URL:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 383
    :goto_0
    return-object v2

    .line 380
    :catch_0
    move-exception v0

    .line 381
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Tracking URL failed. Player Tracking wont be sent"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 383
    const-string v2, ""

    goto :goto_0
.end method

.method private sendBroadcast(Ljava/lang/String;)V
    .locals 4
    .param p1, "intentAction"    # Ljava/lang/String;

    .prologue
    .line 481
    :try_start_0
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 482
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {v1, p1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 483
    sget-object v2, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->mCtx:Landroid/content/Context;

    invoke-virtual {v2, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 487
    .end local v1    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 484
    :catch_0
    move-exception v0

    .line 485
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Error Sending Broadcast"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected static setEventObj(Lcom/espn/androidplayersdk/datamanager/EPEvents;)V
    .locals 0
    .param p0, "event"    # Lcom/espn/androidplayersdk/datamanager/EPEvents;

    .prologue
    .line 371
    sput-object p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    .line 372
    return-void
.end method

.method public static setReferringAppPram(Ljava/lang/String;)V
    .locals 0
    .param p0, "param"    # Ljava/lang/String;

    .prologue
    .line 159
    sput-object p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->srcApp:Ljava/lang/String;

    .line 160
    return-void
.end method


# virtual methods
.method protected cancelMilestoneping()V
    .locals 3

    .prologue
    .line 964
    :try_start_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->timer:Ljava/util/Timer;

    if-eqz v1, :cond_0

    .line 965
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->timer:Ljava/util/Timer;

    invoke-virtual {v1}, Ljava/util/Timer;->cancel()V

    .line 966
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->timer:Ljava/util/Timer;

    invoke-virtual {v1}, Ljava/util/Timer;->purge()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 971
    :cond_0
    :goto_0
    return-void

    .line 968
    :catch_0
    move-exception v0

    .line 969
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Video Milestone ping canceled : "

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

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    :cond_1
    const-string v1, ""

    goto :goto_1
.end method

.method public resetVODParam()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 364
    sput-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    .line 365
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->isAuthenticated:Z

    .line 366
    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->videoStartType:Ljava/lang/String;

    .line 367
    return-void
.end method

.method public setAffiliate(Ljava/lang/String;)V
    .locals 5
    .param p1, "adobeAffiliateId"    # Ljava/lang/String;

    .prologue
    .line 98
    if-nez p1, :cond_1

    .line 105
    :cond_0
    :goto_0
    return-void

    .line 100
    :cond_1
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->affiliateID:Ljava/lang/String;

    .line 101
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 102
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;

    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPPlayerTrackingManager:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->MAP_AFFILIATE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    const/4 v4, 0x0

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V

    .line 103
    .local v0, "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method setAffiliateCode()V
    .locals 23

    .prologue
    .line 407
    const-string v17, ""

    .line 408
    .local v17, "url":Ljava/lang/String;
    sget-boolean v19, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->IS_QA:Z

    if-eqz v19, :cond_5

    .line 409
    new-instance v19, Ljava/lang/StringBuilder;

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v20

    invoke-direct/range {v19 .. v20}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v20, " http://broadband-qa.espn.go.com/espn360/apis/v1/clients"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 412
    :goto_0
    new-instance v19, Ljava/lang/StringBuilder;

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v20

    invoke-direct/range {v19 .. v20}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v20, "/watchespn-android/providers/"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->affiliateID:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, "?"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 414
    const/4 v7, 0x0

    .line 415
    .local v7, "is":Ljava/io/InputStream;
    const/4 v5, 0x0

    .line 417
    .local v5, "conn":Ljava/net/HttpURLConnection;
    :try_start_0
    new-instance v10, Ljava/net/URL;

    move-object/from16 v0, v17

    invoke-direct {v10, v0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 418
    .local v10, "mURL":Ljava/net/URL;
    invoke-virtual {v10}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v19

    move-object/from16 v0, v19

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v5, v0

    .line 419
    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v7

    .line 420
    new-instance v14, Ljava/io/BufferedReader;

    new-instance v19, Ljava/io/InputStreamReader;

    move-object/from16 v0, v19

    invoke-direct {v0, v7}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    move-object/from16 v0, v19

    invoke-direct {v14, v0}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 421
    .local v14, "reader":Ljava/io/BufferedReader;
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    .line 422
    .local v15, "sb":Ljava/lang/StringBuilder;
    const/4 v8, 0x0

    .line 423
    .local v8, "line":Ljava/lang/String;
    :goto_1
    invoke-virtual {v14}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v8

    if-nez v8, :cond_6

    .line 426
    new-instance v11, Lorg/json/JSONObject;

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-direct {v11, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 427
    .local v11, "obj":Lorg/json/JSONObject;
    if-eqz v11, :cond_2

    const-string v19, "clients"

    move-object/from16 v0, v19

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_2

    .line 428
    const-string v19, "clients"

    move-object/from16 v0, v19

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 429
    .local v3, "clientArray":Lorg/json/JSONArray;
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v19

    if-lez v19, :cond_2

    .line 430
    const/16 v19, 0x0

    move/from16 v0, v19

    invoke-virtual {v3, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 431
    .local v4, "clientObj":Lorg/json/JSONObject;
    if-eqz v4, :cond_2

    const-string v19, "providers"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_2

    .line 432
    const-string v19, "providers"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v12

    .line 433
    .local v12, "providerArray":Lorg/json/JSONArray;
    invoke-virtual {v12}, Lorg/json/JSONArray;->length()I

    move-result v19

    if-lez v19, :cond_b

    .line 434
    const/16 v19, 0x0

    move/from16 v0, v19

    invoke-virtual {v12, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v13

    .line 435
    .local v13, "providerObj":Lorg/json/JSONObject;
    if-eqz v13, :cond_0

    const-string v19, "analytics"

    move-object/from16 v0, v19

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_0

    .line 436
    const-string v19, "analytics"

    move-object/from16 v0, v19

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 437
    .local v2, "analyticsObj":Lorg/json/JSONObject;
    if-eqz v2, :cond_0

    const-string v19, "id"

    move-object/from16 v0, v19

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_0

    .line 438
    new-instance v19, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct/range {v19 .. v19}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v20, "analytics"

    const-string v21, "affiliateId"

    const-string v22, "id"

    move-object/from16 v0, v22

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v19 .. v22}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 439
    new-instance v19, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct/range {v19 .. v19}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v20, "analytics"

    const-string v21, "overwriteaffiliateID"

    const/16 v22, 0x0

    invoke-virtual/range {v19 .. v22}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putBooleanField(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 442
    .end local v2    # "analyticsObj":Lorg/json/JSONObject;
    :cond_0
    if-eqz v13, :cond_1

    const-string v19, "links"

    move-object/from16 v0, v19

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_1

    .line 443
    const-string v19, "links"

    move-object/from16 v0, v19

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v9

    .line 444
    .local v9, "linksObj":Lorg/json/JSONObject;
    if-eqz v9, :cond_1

    const-string v19, "web"

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_1

    .line 445
    const-string v19, "web"

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v18

    .line 446
    .local v18, "webObj":Lorg/json/JSONObject;
    if-eqz v18, :cond_1

    const-string v19, "href"

    invoke-virtual/range {v18 .. v19}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_1

    .line 447
    new-instance v19, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct/range {v19 .. v19}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v20, "analytics"

    const-string v21, "affiliateUrl"

    const-string v22, "href"

    move-object/from16 v0, v18

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v19 .. v22}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 450
    .end local v9    # "linksObj":Lorg/json/JSONObject;
    .end local v18    # "webObj":Lorg/json/JSONObject;
    :cond_1
    if-eqz v13, :cond_8

    const-string v19, "streamLimiting"

    move-object/from16 v0, v19

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    if-eqz v19, :cond_8

    .line 451
    const-string v19, "streamLimiting"

    move-object/from16 v0, v19

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v16

    .line 452
    .local v16, "streamLimitingObj":Lorg/json/JSONObject;
    new-instance v19, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct/range {v19 .. v19}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v20, "config"

    const-string v21, "streamLimiting"

    invoke-virtual/range {v16 .. v16}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v19 .. v22}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 463
    .end local v3    # "clientArray":Lorg/json/JSONArray;
    .end local v4    # "clientObj":Lorg/json/JSONObject;
    .end local v12    # "providerArray":Lorg/json/JSONArray;
    .end local v13    # "providerObj":Lorg/json/JSONObject;
    .end local v16    # "streamLimitingObj":Lorg/json/JSONObject;
    :cond_2
    :goto_2
    const-string v19, "com.espn.action.CONFIG_AFFILIATE_UPDATE"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-direct {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->sendBroadcast(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 469
    if-eqz v7, :cond_3

    .line 470
    :try_start_1
    invoke-virtual {v7}, Ljava/io/InputStream;->close()V

    .line 471
    :cond_3
    if-eqz v5, :cond_4

    .line 472
    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3

    .line 477
    .end local v8    # "line":Ljava/lang/String;
    .end local v10    # "mURL":Ljava/net/URL;
    .end local v11    # "obj":Lorg/json/JSONObject;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .end local v15    # "sb":Ljava/lang/StringBuilder;
    :cond_4
    :goto_3
    return-void

    .line 411
    .end local v5    # "conn":Ljava/net/HttpURLConnection;
    .end local v7    # "is":Ljava/io/InputStream;
    :cond_5
    new-instance v19, Ljava/lang/StringBuilder;

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v20

    invoke-direct/range {v19 .. v20}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v20, "http://api.espn.com/v1/watch/clients"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    goto/16 :goto_0

    .line 424
    .restart local v5    # "conn":Ljava/net/HttpURLConnection;
    .restart local v7    # "is":Ljava/io/InputStream;
    .restart local v8    # "line":Ljava/lang/String;
    .restart local v10    # "mURL":Ljava/net/URL;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v15    # "sb":Ljava/lang/StringBuilder;
    :cond_6
    :try_start_2
    new-instance v19, Ljava/lang/StringBuilder;

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v20

    invoke-direct/range {v19 .. v20}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v20, "\n"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_1

    .line 464
    .end local v8    # "line":Ljava/lang/String;
    .end local v10    # "mURL":Ljava/net/URL;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .end local v15    # "sb":Ljava/lang/StringBuilder;
    :catch_0
    move-exception v6

    .line 465
    .local v6, "e":Ljava/lang/Exception;
    :try_start_3
    const-string v19, "unable to map affiliate code"

    const/16 v20, 0x5

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 466
    const-string v19, "com.espn.action.CONFIG_AFFILIATE_UPDATE_ERROR"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-direct {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->sendBroadcast(Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 469
    if-eqz v7, :cond_7

    .line 470
    :try_start_4
    invoke-virtual {v7}, Ljava/io/InputStream;->close()V

    .line 471
    :cond_7
    if-eqz v5, :cond_4

    .line 472
    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_3

    .line 473
    :catch_1
    move-exception v6

    .line 474
    .local v6, "e":Ljava/io/IOException;
    const-string v19, "unable to map affiliate code"

    const/16 v20, 0x5

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_3

    .line 454
    .end local v6    # "e":Ljava/io/IOException;
    .restart local v3    # "clientArray":Lorg/json/JSONArray;
    .restart local v4    # "clientObj":Lorg/json/JSONObject;
    .restart local v8    # "line":Ljava/lang/String;
    .restart local v10    # "mURL":Ljava/net/URL;
    .restart local v11    # "obj":Lorg/json/JSONObject;
    .restart local v12    # "providerArray":Lorg/json/JSONArray;
    .restart local v13    # "providerObj":Lorg/json/JSONObject;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v15    # "sb":Ljava/lang/StringBuilder;
    :cond_8
    :try_start_5
    new-instance v19, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct/range {v19 .. v19}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v20, "config"

    const-string v21, "streamLimiting"

    const-string v22, ""

    invoke-virtual/range {v19 .. v22}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_2

    .line 467
    .end local v3    # "clientArray":Lorg/json/JSONArray;
    .end local v4    # "clientObj":Lorg/json/JSONObject;
    .end local v8    # "line":Ljava/lang/String;
    .end local v10    # "mURL":Ljava/net/URL;
    .end local v11    # "obj":Lorg/json/JSONObject;
    .end local v12    # "providerArray":Lorg/json/JSONArray;
    .end local v13    # "providerObj":Lorg/json/JSONObject;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .end local v15    # "sb":Ljava/lang/StringBuilder;
    :catchall_0
    move-exception v19

    .line 469
    if-eqz v7, :cond_9

    .line 470
    :try_start_6
    invoke-virtual {v7}, Ljava/io/InputStream;->close()V

    .line 471
    :cond_9
    if-eqz v5, :cond_a

    .line 472
    invoke-virtual {v5}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_2

    .line 476
    :cond_a
    :goto_4
    throw v19

    .line 457
    .restart local v3    # "clientArray":Lorg/json/JSONArray;
    .restart local v4    # "clientObj":Lorg/json/JSONObject;
    .restart local v8    # "line":Ljava/lang/String;
    .restart local v10    # "mURL":Ljava/net/URL;
    .restart local v11    # "obj":Lorg/json/JSONObject;
    .restart local v12    # "providerArray":Lorg/json/JSONArray;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v15    # "sb":Ljava/lang/StringBuilder;
    :cond_b
    :try_start_7
    new-instance v19, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct/range {v19 .. v19}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v20, "analytics"

    const-string v21, "affiliateUrl"

    const-string v22, ""

    invoke-virtual/range {v19 .. v22}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_0
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_2

    .line 473
    .end local v3    # "clientArray":Lorg/json/JSONArray;
    .end local v4    # "clientObj":Lorg/json/JSONObject;
    .end local v8    # "line":Ljava/lang/String;
    .end local v10    # "mURL":Ljava/net/URL;
    .end local v11    # "obj":Lorg/json/JSONObject;
    .end local v12    # "providerArray":Lorg/json/JSONArray;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .end local v15    # "sb":Ljava/lang/StringBuilder;
    :catch_2
    move-exception v6

    .line 474
    .restart local v6    # "e":Ljava/io/IOException;
    const-string v20, "unable to map affiliate code"

    const/16 v21, 0x5

    move-object/from16 v0, v20

    move/from16 v1, v21

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_4

    .line 473
    .end local v6    # "e":Ljava/io/IOException;
    .restart local v8    # "line":Ljava/lang/String;
    .restart local v10    # "mURL":Ljava/net/URL;
    .restart local v11    # "obj":Lorg/json/JSONObject;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v15    # "sb":Ljava/lang/StringBuilder;
    :catch_3
    move-exception v6

    .line 474
    .restart local v6    # "e":Ljava/io/IOException;
    const-string v19, "unable to map affiliate code"

    const/16 v20, 0x5

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto/16 :goto_3
.end method

.method public setMyEspnSWID(Ljava/lang/String;)V
    .locals 0
    .param p1, "swid"    # Ljava/lang/String;

    .prologue
    .line 140
    if-nez p1, :cond_0

    .line 143
    :goto_0
    return-void

    .line 142
    :cond_0
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->swid:Ljava/lang/String;

    goto :goto_0
.end method

.method public setPlatformAndAppVersion(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "platform"    # Ljava/lang/String;
    .param p2, "appVersion"    # Ljava/lang/String;

    .prologue
    .line 131
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->platform:Ljava/lang/String;

    .line 132
    iput-object p2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->appVersion:Ljava/lang/String;

    .line 133
    return-void
.end method

.method public setPresspass(Ljava/lang/String;)V
    .locals 4
    .param p1, "presspass"    # Ljava/lang/String;

    .prologue
    .line 112
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "analytics"

    const-string v2, "affiliateId"

    invoke-virtual {v0, v1, v2, p1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "analytics"

    const-string v2, "overwriteaffiliateID"

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putBooleanField(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 114
    return-void
.end method

.method public trackAdComplete(Ljava/lang/String;)V
    .locals 6
    .param p1, "id3"    # Ljava/lang/String;

    .prologue
    .line 298
    :try_start_0
    const-string v3, "TIT2"

    invoke-virtual {p1, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 299
    const-string v3, "ID3"

    const-string v4, ""

    invoke-virtual {p1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p1

    .line 300
    const-string v3, "\r"

    invoke-virtual {p1, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 301
    .local v2, "valueArray":[Ljava/lang/String;
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->AD_COMPLETE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    const/4 v5, 0x0

    invoke-direct {v1, p0, v3, v4, v5}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V

    .line 302
    .local v1, "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const/4 v5, 0x1

    aget-object v5, v2, v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v3}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 307
    .end local v1    # "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    .end local v2    # "valueArray":[Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 304
    :catch_0
    move-exception v0

    .line 305
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "Player tracking manager failed on Ad complete"

    const/4 v4, 0x5

    invoke-static {v3, v4, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public trackAdStart([B)V
    .locals 6
    .param p1, "tag"    # [B

    .prologue
    .line 284
    :try_start_0
    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, p1}, Ljava/lang/String;-><init>([B)V

    .line 285
    .local v1, "id3":Ljava/lang/String;
    const-string v3, "TIT2"

    invoke-virtual {v1, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 286
    const-string v3, "TIT2"

    invoke-static {p1, v3}, Lcom/espn/androidplayersdk/datamanager/EPAdTrackingManager;->extractTIT2Frame([BLjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 287
    new-instance v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->AD_START:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v4, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    const/4 v5, 0x0

    invoke-direct {v2, p0, v3, v4, v5}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V

    .line 288
    .local v2, "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v1, v3, v4

    invoke-virtual {v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 293
    .end local v1    # "id3":Ljava/lang/String;
    .end local v2    # "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    :cond_0
    :goto_0
    return-void

    .line 290
    :catch_0
    move-exception v0

    .line 291
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "Player tracking manager failed on Ad start"

    const/4 v4, 0x5

    invoke-static {v3, v4, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected trackEventConcluded()V
    .locals 5

    .prologue
    .line 217
    :try_start_0
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->EVENT_CONCLUDED:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    const/4 v4, 0x0

    invoke-direct {v1, p0, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V

    .line 218
    .local v1, "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 219
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->cancelMilestoneping()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 223
    .end local v1    # "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    :goto_0
    return-void

    .line 220
    :catch_0
    move-exception v0

    .line 221
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Player tracking manager failed on event concluded"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public trackMuteUnmute(Z)V
    .locals 5
    .param p1, "mute"    # Z

    .prologue
    .line 271
    if-eqz p1, :cond_0

    .line 272
    :try_start_0
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->MUTE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    const/4 v4, 0x0

    invoke-direct {v1, p0, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V

    .line 275
    .local v1, "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    :goto_0
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 279
    .end local v1    # "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    :goto_1
    return-void

    .line 274
    :cond_0
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->UNMUTE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    const/4 v4, 0x0

    invoke-direct {v1, p0, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .restart local v1    # "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    goto :goto_0

    .line 276
    .end local v1    # "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    :catch_0
    move-exception v0

    .line 277
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Player tracking manager failed on mute toggle"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_1
.end method

.method public trackVideoPause()V
    .locals 5

    .prologue
    .line 239
    :try_start_0
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_PAUSE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    const/4 v4, 0x0

    invoke-direct {v1, p0, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V

    .line 240
    .local v1, "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 244
    .end local v1    # "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    :goto_0
    return-void

    .line 241
    :catch_0
    move-exception v0

    .line 242
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Player tracking manager failed on video pause"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public trackVideoPlayFromPause()V
    .locals 5

    .prologue
    .line 259
    :try_start_0
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_PLAY_FROM_PAUSE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    const/4 v4, 0x0

    invoke-direct {v1, p0, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V

    .line 260
    .local v1, "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 265
    .end local v1    # "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    :goto_0
    return-void

    .line 261
    :catch_0
    move-exception v0

    .line 262
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Player tracking manager failed on video play from pause"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public trackVideoScrubbed()V
    .locals 5

    .prologue
    .line 249
    :try_start_0
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_SCRUBBED:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    const/4 v4, 0x0

    invoke-direct {v1, p0, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V

    .line 250
    .local v1, "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 254
    .end local v1    # "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    :goto_0
    return-void

    .line 251
    :catch_0
    move-exception v0

    .line 252
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Player tracking manager failed on video scrubbed"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected trackVideoStart()V
    .locals 3

    .prologue
    .line 196
    :try_start_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->callback:Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;

    if-eqz v1, :cond_0

    .line 197
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->callback:Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;

    invoke-interface {v1}, Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;->trackingParam()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->trackVideoStart(Ljava/lang/String;Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 202
    :cond_0
    :goto_0
    return-void

    .line 198
    :catch_0
    move-exception v0

    .line 199
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Player tracking manager failed trackVideoStart ping on programing change"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public trackVideoStart(Ljava/lang/String;Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;)V
    .locals 8
    .param p1, "programingSegment"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;

    .prologue
    .line 182
    if-eqz p2, :cond_0

    .line 183
    :try_start_0
    iput-object p2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->callback:Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;

    .line 184
    :cond_0
    new-instance v7, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;

    sget-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_START:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    const/4 v2, 0x0

    invoke-direct {v7, p0, v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V

    .line 185
    .local v7, "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    invoke-virtual {v7, v0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 186
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPPlayerTrackingManager:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    new-instance v1, Ljava/util/Timer;

    invoke-direct {v1}, Ljava/util/Timer;-><init>()V

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->timer:Ljava/util/Timer;

    .line 187
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->timer:Ljava/util/Timer;

    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$Milestoneping;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$Milestoneping;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$Milestoneping;)V

    iget-wide v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->pingTime:J

    iget-wide v4, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->pingTime:J

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 191
    .end local v7    # "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    :goto_0
    return-void

    .line 188
    :catch_0
    move-exception v6

    .line 189
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Player tracking manager failed on video start"

    const/4 v1, 0x5

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public trackVideoStop(Ljava/lang/String;)V
    .locals 5
    .param p1, "programingSegment"    # Ljava/lang/String;

    .prologue
    .line 228
    :try_start_0
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_STOP:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    const/4 v4, 0x0

    invoke-direct {v1, p0, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V

    .line 229
    .local v1, "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-virtual {v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 230
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->cancelMilestoneping()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 234
    .end local v1    # "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    :goto_0
    return-void

    .line 231
    :catch_0
    move-exception v0

    .line 232
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Player tracking manager failed on video stop"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public trackVodEnd()V
    .locals 5

    .prologue
    .line 351
    :try_start_0
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VOD_END:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    const/4 v4, 0x0

    invoke-direct {v1, p0, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V

    .line 352
    .local v1, "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 356
    .end local v1    # "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    :goto_0
    return-void

    .line 353
    :catch_0
    move-exception v0

    .line 354
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Player tracking manager failed on VOD end"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public trackVodMid()V
    .locals 5

    .prologue
    .line 341
    :try_start_0
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VOD_MID:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    const/4 v4, 0x0

    invoke-direct {v1, p0, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V

    .line 342
    .local v1, "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 346
    .end local v1    # "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    :goto_0
    return-void

    .line 343
    :catch_0
    move-exception v0

    .line 344
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Player tracking manager failed on VOD end"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public trackVodStart(Lcom/espn/androidplayersdk/datamanager/EPEvents;ZLjava/lang/String;)V
    .locals 5
    .param p1, "epEvent"    # Lcom/espn/androidplayersdk/datamanager/EPEvents;
    .param p2, "isAuthenticated"    # Z
    .param p3, "playType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 321
    if-eqz p1, :cond_0

    if-eqz p3, :cond_0

    invoke-virtual {p3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 322
    :cond_0
    new-instance v2, Ljava/lang/RuntimeException;

    const-string v3, "Incorrect paramenter set"

    invoke-direct {v2, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 327
    :cond_1
    :try_start_0
    invoke-static {p1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->setEventObj(Lcom/espn/androidplayersdk/datamanager/EPEvents;)V

    .line 328
    iput-boolean p2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->isAuthenticated:Z

    .line 329
    iput-object p3, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->videoStartType:Ljava/lang/String;

    .line 331
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VOD_START:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->mEPEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    const/4 v4, 0x0

    invoke-direct {v1, p0, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V

    .line 332
    .local v1, "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 336
    .end local v1    # "mSendTrackingTask":Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
    :goto_0
    return-void

    .line 333
    :catch_0
    move-exception v0

    .line 334
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Player tracking manager failed on VOD start"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method
