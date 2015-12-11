.class public Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;
.super Ljava/lang/Object;
.source "EPCatalogManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;,
        Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;
    }
.end annotation


# static fields
.field static final channelEventsByLeague:I = 0x14

.field static final channelsKey:I = 0x1

.field static final configKey:I = 0x2

.field private static epCatalogManager:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager; = null

.field static final espn3NetworkId:Ljava/lang/String; = "n360"

.field static final eventByChannelKey:I = 0x3

.field static final eventBySportsKey:I = 0x6

.field static final liveEventsKey:I = 0x9

.field static final loadMoreChannelEventsByLeague:I = 0x15

.field static final loadMoreEventByChannelKey:I = 0x4

.field static final loadMoreSportEventsByLeague:I = 0x16

.field static final loadMoreeventBySportsKey:I = 0x7

.field static final sportEventsByLeague:I = 0x0

.field static final sportsKey:I = 0x5


# instance fields
.field private mChannelListLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

.field private mEventsByChannelLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

.field private mEventsBySportLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

.field private mLiveEventsLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

.field private mSportListLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    const/4 v0, 0x0

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->epCatalogManager:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    invoke-direct {v0, p0}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;)V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mLiveEventsLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 42
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    invoke-direct {v0, p0}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;)V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mEventsByChannelLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 43
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    invoke-direct {v0, p0}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;)V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mEventsBySportLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 44
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    invoke-direct {v0, p0}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;)V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mChannelListLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 45
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    invoke-direct {v0, p0}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;)V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mSportListLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    .line 21
    return-void
.end method

.method private getEvents(Landroid/database/Cursor;)Ljava/util/ArrayList;
    .locals 5
    .param p1, "eventsCursor"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/Cursor;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/espn/androidplayersdk/datamanager/EPEvents;",
            ">;"
        }
    .end annotation

    .prologue
    .line 459
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 463
    .local v1, "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :cond_0
    :try_start_0
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 464
    .local v2, "items":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v3, "eventName"

    const-string v4, "eventName"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 465
    const-string v3, "eventId"

    const-string v4, "eventId"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 466
    const-string v3, "simulcastAiringId"

    const-string v4, "simulcastAiringId"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 467
    const-string v3, "eventType"

    const-string v4, "eventType"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 468
    const-string v3, "showName"

    const-string v4, "showName"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 469
    const-string v3, "broadcastStartTime"

    const-string v4, "broadcastStartTime"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 470
    const-string v3, "startTime"

    const-string v4, "startTime"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 471
    const-string v3, "endTime"

    const-string v4, "endTime"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 472
    const-string v3, "imageLarge"

    const-string v4, "imageLarge"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 473
    const-string v3, "imageMed"

    const-string v4, "imageMed"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 474
    const-string v3, "imageSmall"

    const-string v4, "imageSmall"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 475
    const-string v3, "parentalRating"

    const-string v4, "parentalRating"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 476
    const-string v3, "seekInSeconds"

    const-string v4, "seekInSeconds"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 477
    const-string v3, "networkCode"

    const-string v4, "networkCode"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 478
    const-string v3, "description"

    const-string v4, "description"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 479
    const-string v3, "networkName"

    const-string v4, "networkName"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 480
    const-string v3, "league"

    const-string v4, "league"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 481
    const-string v3, "leagueName"

    const-string v4, "leagueName"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 482
    const-string v3, "SPORT"

    const-string v4, "SPORT"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 483
    const-string v3, "sportCode"

    const-string v4, "sportCode"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 484
    const-string v3, "programingCode"

    const-string v4, "programingCode"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 485
    const-string v3, "coverageType"

    const-string v4, "coverageType"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 486
    const-string v3, "networkResourceId"

    const-string v4, "networkResourceId"

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 487
    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-direct {v3, v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;-><init>(Ljava/util/HashMap;)V

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 491
    .end local v2    # "items":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_0
    invoke-interface {p1}, Landroid/database/Cursor;->moveToNext()Z

    .line 492
    invoke-interface {p1}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 493
    return-object v1

    .line 488
    :catch_0
    move-exception v0

    .line 489
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "CatalogManger:"

    const/4 v4, 0x5

    invoke-static {v3, v4, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public static instantiate()Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;
    .locals 1

    .prologue
    .line 50
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->epCatalogManager:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;

    if-nez v0, :cond_0

    .line 51
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;-><init>()V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->epCatalogManager:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;

    .line 52
    :cond_0
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->epCatalogManager:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;

    return-object v0
.end method

.method private loadMoreEventsForChannelByLeague(Lcom/espn/androidplayersdk/objects/EPChannels;Lcom/espn/androidplayersdk/utilities/EPEventType;I)V
    .locals 8
    .param p1, "epChannel"    # Lcom/espn/androidplayersdk/objects/EPChannels;
    .param p2, "epEventType"    # Lcom/espn/androidplayersdk/utilities/EPEventType;
    .param p3, "eventCount"    # I

    .prologue
    .line 64
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 71
    :cond_0
    :goto_0
    return-void

    .line 66
    :cond_1
    :try_start_0
    invoke-virtual {p2}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v4

    .line 67
    .local v4, "event":Ljava/lang/String;
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mEventsByChannelLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    const/16 v2, 0x15

    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    move-object v3, p1

    invoke-direct/range {v0 .. v6}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;ILcom/espn/androidplayersdk/objects/EPChannels;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 68
    .end local v4    # "event":Ljava/lang/String;
    :catch_0
    move-exception v7

    .line 69
    .local v7, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    const/4 v1, 0x5

    invoke-static {v0, v1, v7}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method private loadMoreEventsForSportByLeague(Lcom/espn/androidplayersdk/datamanager/EPSport;Lcom/espn/androidplayersdk/utilities/EPEventType;I)V
    .locals 10
    .param p1, "epSport"    # Lcom/espn/androidplayersdk/datamanager/EPSport;
    .param p2, "epEventType"    # Lcom/espn/androidplayersdk/utilities/EPEventType;
    .param p3, "eventCount"    # I

    .prologue
    .line 118
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 128
    :cond_0
    :goto_0
    return-void

    .line 120
    :cond_1
    :try_start_0
    invoke-virtual {p2}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v5

    .line 121
    .local v5, "event":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getId()Ljava/lang/String;

    move-result-object v4

    .line 122
    .local v4, "sportId":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getName()Ljava/lang/String;

    move-result-object v3

    .line 123
    .local v3, "sport":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getName()Ljava/lang/String;

    move-result-object v8

    .line 124
    .local v8, "abbr":Ljava/lang/String;
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mEventsBySportLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    const/16 v2, 0x16

    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    invoke-direct/range {v0 .. v8}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 125
    .end local v3    # "sport":Ljava/lang/String;
    .end local v4    # "sportId":Ljava/lang/String;
    .end local v5    # "event":Ljava/lang/String;
    .end local v8    # "abbr":Ljava/lang/String;
    :catch_0
    move-exception v9

    .line 126
    .local v9, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    const/4 v1, 0x5

    invoke-static {v0, v1, v9}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method


# virtual methods
.method public getChannelsList()Ljava/util/ArrayList;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/espn/androidplayersdk/objects/EPChannels;",
            ">;"
        }
    .end annotation

    .prologue
    .line 335
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .line 336
    .local v10, "channels":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/objects/EPChannels;>;"
    const/4 v11, 0x0

    .line 338
    .local v11, "channelsCursor":Landroid/database/Cursor;
    :try_start_0
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getAllChannels()Landroid/database/Cursor;

    move-result-object v11

    .line 339
    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_1

    invoke-interface {v11}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 343
    :cond_0
    new-instance v0, Lcom/espn/androidplayersdk/objects/EPChannels;

    const-string v1, "channelName"

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 344
    const-string v2, "type"

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 345
    const-string v3, "id"

    invoke-interface {v11, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    .line 344
    invoke-interface {v11, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 345
    const-string v4, "code"

    invoke-interface {v11, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v11, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 346
    const-string v5, "ImageSmall"

    invoke-interface {v11, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v11, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 347
    const-string v6, "slateImageSmall"

    invoke-interface {v11, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 346
    invoke-interface {v11, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 348
    const-string v7, "slateImageMedium"

    invoke-interface {v11, v7}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .line 347
    invoke-interface {v11, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 349
    const-string v8, "slateImageLarge"

    invoke-interface {v11, v8}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    .line 348
    invoke-interface {v11, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 350
    const-string v9, "resourceId"

    invoke-interface {v11, v9}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v9

    .line 349
    invoke-interface {v11, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-direct/range {v0 .. v9}, Lcom/espn/androidplayersdk/objects/EPChannels;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 343
    invoke-virtual {v10, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 352
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z

    .line 354
    invoke-interface {v11}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 356
    :cond_1
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mChannelListLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;I)V

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 361
    if-eqz v11, :cond_2

    .line 362
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 364
    :cond_2
    :goto_0
    return-object v10

    .line 358
    :catch_0
    move-exception v12

    .line 359
    .local v12, "e":Ljava/lang/Exception;
    :try_start_1
    const-string v0, "DataManager:"

    const/4 v1, 0x5

    invoke-static {v0, v1, v12}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 361
    if-eqz v11, :cond_2

    .line 362
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 360
    .end local v12    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    .line 361
    if-eqz v11, :cond_3

    .line 362
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 363
    :cond_3
    throw v0
.end method

.method public getEventByID(Ljava/lang/String;Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;)V
    .locals 6
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;

    .prologue
    .line 397
    const/4 v2, 0x0

    .line 399
    .local v2, "eventsCursor":Landroid/database/Cursor;
    :try_start_0
    sget-object v4, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v4, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getEventById(Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 400
    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v4

    if-lez v4, :cond_1

    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v4

    if-eqz v4, :cond_1

    .line 403
    :try_start_1
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 404
    .local v3, "items":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v4, "eventName"

    const-string v5, "eventName"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 405
    const-string v4, "eventId"

    const-string v5, "eventId"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 406
    const-string v4, "simulcastAiringId"

    const-string v5, "simulcastAiringId"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 407
    const-string v4, "eventType"

    const-string v5, "eventType"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 408
    const-string v4, "showName"

    const-string v5, "showName"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 409
    const-string v4, "broadcastStartTime"

    const-string v5, "broadcastStartTime"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 410
    const-string v4, "startTime"

    const-string v5, "startTime"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 411
    const-string v4, "endTime"

    const-string v5, "endTime"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 412
    const-string v4, "imageLarge"

    const-string v5, "imageLarge"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 413
    const-string v4, "imageMed"

    const-string v5, "imageMed"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 414
    const-string v4, "imageSmall"

    const-string v5, "imageSmall"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 415
    const-string v4, "parentalRating"

    const-string v5, "parentalRating"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 416
    const-string v4, "seekInSeconds"

    const-string v5, "seekInSeconds"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 417
    const-string v4, "networkCode"

    const-string v5, "networkCode"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 418
    const-string v4, "description"

    const-string v5, "description"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 419
    const-string v4, "networkName"

    const-string v5, "networkName"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 420
    const-string v4, "league"

    const-string v5, "league"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 421
    const-string v4, "leagueName"

    const-string v5, "leagueName"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 422
    const-string v4, "SPORT"

    const-string v5, "SPORT"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 423
    const-string v4, "leagueName"

    const-string v5, "leagueName"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 424
    const-string v4, "SPORT"

    const-string v5, "SPORT"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 425
    const-string v4, "coverageType"

    const-string v5, "coverageType"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 426
    const-string v4, "networkResourceId"

    const-string v5, "networkResourceId"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 428
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-direct {v1, v3}, Lcom/espn/androidplayersdk/datamanager/EPEvents;-><init>(Ljava/util/HashMap;)V

    .line 429
    .local v1, "events":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    invoke-interface {p2, v1}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;->onEventUpdate(Lcom/espn/androidplayersdk/datamanager/EPEvents;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 440
    .end local v1    # "events":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    .end local v3    # "items":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_0
    if-eqz v2, :cond_0

    .line 441
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 444
    :cond_0
    :goto_1
    return-void

    .line 430
    :catch_0
    move-exception v0

    .line 431
    .local v0, "e":Ljava/lang/Exception;
    :try_start_2
    const-string v4, "DataManager:"

    const/4 v5, 0x5

    invoke-static {v4, v5, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 436
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v0

    .line 437
    .restart local v0    # "e":Ljava/lang/Exception;
    :try_start_3
    const-string v4, "DataManager: "

    const/4 v5, 0x5

    invoke-static {v4, v5, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 438
    const/4 v4, 0x7

    invoke-interface {p2, v4}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;->onEventRetrivalError(I)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 440
    if-eqz v2, :cond_0

    .line 441
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 434
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    :try_start_4
    new-instance v4, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;

    invoke-direct {v4, p1, p2}, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;-><init>(Ljava/lang/String;Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;)V

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;->start()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0

    .line 439
    :catchall_0
    move-exception v4

    .line 440
    if-eqz v2, :cond_2

    .line 441
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 442
    :cond_2
    throw v4
.end method

.method public getEventForGameID(Ljava/lang/String;Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;)V
    .locals 1
    .param p1, "gameID"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;

    .prologue
    .line 522
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EventByGameIdRequest;

    invoke-direct {v0, p2}, Lcom/espn/androidplayersdk/datamanager/EventByGameIdRequest;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;)V

    invoke-virtual {v0, p1}, Lcom/espn/androidplayersdk/datamanager/EventByGameIdRequest;->getEvent(Ljava/lang/String;)V

    .line 523
    return-void
.end method

.method public getEventsForChannel(Lcom/espn/androidplayersdk/objects/EPChannels;Lcom/espn/androidplayersdk/utilities/EPEventType;)Ljava/util/ArrayList;
    .locals 1
    .param p1, "epChannel"    # Lcom/espn/androidplayersdk/objects/EPChannels;
    .param p2, "epEventType"    # Lcom/espn/androidplayersdk/utilities/EPEventType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/espn/androidplayersdk/objects/EPChannels;",
            "Lcom/espn/androidplayersdk/utilities/EPEventType;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/espn/androidplayersdk/datamanager/EPEvents;",
            ">;"
        }
    .end annotation

    .prologue
    .line 206
    const/16 v0, 0xa

    invoke-virtual {p0, p1, p2, v0}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->getEventsForChannel(Lcom/espn/androidplayersdk/objects/EPChannels;Lcom/espn/androidplayersdk/utilities/EPEventType;I)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public getEventsForChannel(Lcom/espn/androidplayersdk/objects/EPChannels;Lcom/espn/androidplayersdk/utilities/EPEventType;I)Ljava/util/ArrayList;
    .locals 12
    .param p1, "epChannel"    # Lcom/espn/androidplayersdk/objects/EPChannels;
    .param p2, "epEventType"    # Lcom/espn/androidplayersdk/utilities/EPEventType;
    .param p3, "eventCount"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/espn/androidplayersdk/objects/EPChannels;",
            "Lcom/espn/androidplayersdk/utilities/EPEventType;",
            "I)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/espn/androidplayersdk/datamanager/EPEvents;",
            ">;"
        }
    .end annotation

    .prologue
    .line 216
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 217
    .local v8, "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    const/4 v10, 0x0

    .line 220
    .local v10, "eventsCursor":Landroid/database/Cursor;
    if-eqz p1, :cond_0

    if-nez p2, :cond_2

    .line 235
    :cond_0
    if-eqz v10, :cond_1

    .line 236
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    :cond_1
    move-object v9, v8

    .line 238
    .end local v8    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .local v9, "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :goto_0
    return-object v9

    .line 223
    .end local v9    # "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .restart local v8    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :cond_2
    :try_start_0
    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    .line 224
    .local v5, "limit":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/objects/EPChannels;->getNetworkId()Ljava/lang/String;

    move-result-object v11

    .line 225
    .local v11, "networkId":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v4

    .line 226
    .local v4, "eventType":Ljava/lang/String;
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v0, v11, v4}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getEventsForChannel(Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 227
    invoke-interface {v10}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_3

    invoke-interface {v10}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 228
    invoke-direct {p0, v10}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->getEvents(Landroid/database/Cursor;)Ljava/util/ArrayList;

    move-result-object v8

    .line 230
    :cond_3
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mEventsByChannelLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    const/4 v2, 0x3

    const/4 v6, 0x0

    move-object v3, p1

    invoke-direct/range {v0 .. v6}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;ILcom/espn/androidplayersdk/objects/EPChannels;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 235
    if-eqz v10, :cond_4

    .line 236
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .end local v4    # "eventType":Ljava/lang/String;
    .end local v5    # "limit":Ljava/lang/String;
    .end local v11    # "networkId":Ljava/lang/String;
    :cond_4
    :goto_1
    move-object v9, v8

    .line 238
    .restart local v9    # "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    goto :goto_0

    .line 232
    .end local v9    # "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :catch_0
    move-exception v7

    .line 233
    .local v7, "e":Ljava/lang/Exception;
    :try_start_1
    const-string v0, "Error: "

    const/4 v1, 0x5

    invoke-static {v0, v1, v7}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 235
    if-eqz v10, :cond_4

    .line 236
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 234
    .end local v7    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    .line 235
    if-eqz v10, :cond_5

    .line 236
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 237
    :cond_5
    throw v0
.end method

.method public getEventsForChannelByLeague(Lcom/espn/androidplayersdk/objects/EPChannels;Lcom/espn/androidplayersdk/utilities/EPEventType;I)Ljava/util/ArrayList;
    .locals 13
    .param p1, "epChannel"    # Lcom/espn/androidplayersdk/objects/EPChannels;
    .param p2, "epEventType"    # Lcom/espn/androidplayersdk/utilities/EPEventType;
    .param p3, "eventCount"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/espn/androidplayersdk/objects/EPChannels;",
            "Lcom/espn/androidplayersdk/utilities/EPEventType;",
            "I)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/espn/androidplayersdk/datamanager/EPEvents;",
            ">;"
        }
    .end annotation

    .prologue
    .line 86
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 87
    .local v9, "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    invoke-static/range {p3 .. p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    .line 88
    .local v5, "limit":Ljava/lang/String;
    const/4 v11, 0x0

    .line 90
    .local v11, "eventsCursor":Landroid/database/Cursor;
    if-eqz p1, :cond_0

    if-nez p2, :cond_2

    .line 103
    :cond_0
    if-eqz v11, :cond_1

    .line 104
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    :cond_1
    move-object v10, v9

    .line 106
    .end local v9    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .local v10, "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :goto_0
    return-object v10

    .line 92
    .end local v10    # "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .restart local v9    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :cond_2
    :try_start_0
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/objects/EPChannels;->getNetworkCode()Ljava/lang/String;

    move-result-object v12

    .line 93
    .local v12, "networkId":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v8

    .line 94
    .local v8, "event":Ljava/lang/String;
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v0, v12, v8}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getEventsForChannelByLeague(Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 95
    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_3

    invoke-interface {v11}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 96
    invoke-direct {p0, v11}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->getEvents(Landroid/database/Cursor;)Ljava/util/ArrayList;

    move-result-object v9

    .line 98
    :cond_3
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mEventsByChannelLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    const/16 v2, 0x14

    invoke-virtual {p2}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v4

    const/4 v6, 0x0

    move-object v3, p1

    invoke-direct/range {v0 .. v6}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;ILcom/espn/androidplayersdk/objects/EPChannels;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 103
    if-eqz v11, :cond_4

    .line 104
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .end local v8    # "event":Ljava/lang/String;
    .end local v12    # "networkId":Ljava/lang/String;
    :cond_4
    :goto_1
    move-object v10, v9

    .line 106
    .restart local v10    # "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    goto :goto_0

    .line 100
    .end local v10    # "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :catch_0
    move-exception v7

    .line 101
    .local v7, "e":Ljava/lang/Exception;
    :try_start_1
    const-string v0, "DataManager:"

    const/4 v1, 0x5

    invoke-static {v0, v1, v7}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 103
    if-eqz v11, :cond_4

    .line 104
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 102
    .end local v7    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    .line 103
    if-eqz v11, :cond_5

    .line 104
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 105
    :cond_5
    throw v0
.end method

.method public getEventsForSport(Lcom/espn/androidplayersdk/datamanager/EPSport;Lcom/espn/androidplayersdk/utilities/EPEventType;)Ljava/util/ArrayList;
    .locals 1
    .param p1, "sports"    # Lcom/espn/androidplayersdk/datamanager/EPSport;
    .param p2, "epEventType"    # Lcom/espn/androidplayersdk/utilities/EPEventType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/espn/androidplayersdk/datamanager/EPSport;",
            "Lcom/espn/androidplayersdk/utilities/EPEventType;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/espn/androidplayersdk/datamanager/EPEvents;",
            ">;"
        }
    .end annotation

    .prologue
    .line 276
    const/16 v0, 0xa

    invoke-virtual {p0, p1, p2, v0}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->getEventsForSport(Lcom/espn/androidplayersdk/datamanager/EPSport;Lcom/espn/androidplayersdk/utilities/EPEventType;I)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public getEventsForSport(Lcom/espn/androidplayersdk/datamanager/EPSport;Lcom/espn/androidplayersdk/utilities/EPEventType;I)Ljava/util/ArrayList;
    .locals 13
    .param p1, "epSport"    # Lcom/espn/androidplayersdk/datamanager/EPSport;
    .param p2, "epEventType"    # Lcom/espn/androidplayersdk/utilities/EPEventType;
    .param p3, "eventCount"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/espn/androidplayersdk/datamanager/EPSport;",
            "Lcom/espn/androidplayersdk/utilities/EPEventType;",
            "I)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/espn/androidplayersdk/datamanager/EPEvents;",
            ">;"
        }
    .end annotation

    .prologue
    .line 285
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .line 286
    .local v10, "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    invoke-static/range {p3 .. p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    .line 287
    .local v6, "limit":Ljava/lang/String;
    const/4 v12, 0x0

    .line 289
    .local v12, "eventsCursor":Landroid/database/Cursor;
    if-eqz p1, :cond_0

    if-nez p2, :cond_2

    .line 304
    :cond_0
    if-eqz v12, :cond_1

    .line 305
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    :cond_1
    move-object v11, v10

    .line 307
    .end local v10    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .local v11, "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :goto_0
    return-object v11

    .line 292
    .end local v11    # "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .restart local v10    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :cond_2
    :try_start_0
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getId()Ljava/lang/String;

    move-result-object v4

    .line 293
    .local v4, "sportId":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getName()Ljava/lang/String;

    move-result-object v3

    .line 294
    .local v3, "sport":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v5

    .line 295
    .local v5, "event":Ljava/lang/String;
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v0, v4, v5}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getEventsForSport(Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v12

    .line 296
    invoke-interface {v12}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_3

    invoke-interface {v12}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 297
    invoke-direct {p0, v12}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->getEvents(Landroid/database/Cursor;)Ljava/util/ArrayList;

    move-result-object v10

    .line 299
    :cond_3
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mEventsBySportLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    const/4 v2, 0x6

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-direct/range {v0 .. v8}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 304
    if-eqz v12, :cond_4

    .line 305
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    .end local v3    # "sport":Ljava/lang/String;
    .end local v4    # "sportId":Ljava/lang/String;
    .end local v5    # "event":Ljava/lang/String;
    :cond_4
    :goto_1
    move-object v11, v10

    .line 307
    .restart local v11    # "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    goto :goto_0

    .line 301
    .end local v11    # "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :catch_0
    move-exception v9

    .line 302
    .local v9, "e":Ljava/lang/Exception;
    :try_start_1
    const-string v0, "DataManager:"

    const/4 v1, 0x5

    invoke-static {v0, v1, v9}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 304
    if-eqz v12, :cond_4

    .line 305
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 303
    .end local v9    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    .line 304
    if-eqz v12, :cond_5

    .line 305
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    .line 306
    :cond_5
    throw v0
.end method

.method public getEventsForSportByLeague(Lcom/espn/androidplayersdk/datamanager/EPSport;Lcom/espn/androidplayersdk/utilities/EPEventType;I)Ljava/util/ArrayList;
    .locals 13
    .param p1, "epSport"    # Lcom/espn/androidplayersdk/datamanager/EPSport;
    .param p2, "epEventType"    # Lcom/espn/androidplayersdk/utilities/EPEventType;
    .param p3, "eventCount"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/espn/androidplayersdk/datamanager/EPSport;",
            "Lcom/espn/androidplayersdk/utilities/EPEventType;",
            "I)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/espn/androidplayersdk/datamanager/EPEvents;",
            ">;"
        }
    .end annotation

    .prologue
    .line 143
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .line 144
    .local v10, "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    invoke-static/range {p3 .. p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    .line 145
    .local v6, "limit":Ljava/lang/String;
    const/4 v12, 0x0

    .line 147
    .local v12, "eventsCursor":Landroid/database/Cursor;
    if-eqz p1, :cond_0

    if-nez p2, :cond_2

    .line 161
    :cond_0
    if-eqz v12, :cond_1

    .line 162
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    :cond_1
    move-object v11, v10

    .line 164
    .end local v10    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .local v11, "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :goto_0
    return-object v11

    .line 149
    .end local v11    # "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    .restart local v10    # "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :cond_2
    :try_start_0
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getId()Ljava/lang/String;

    move-result-object v4

    .line 150
    .local v4, "sportId":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getAbbreviation()Ljava/lang/String;

    move-result-object v8

    .line 151
    .local v8, "abrre":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v5

    .line 152
    .local v5, "event":Ljava/lang/String;
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v0, v4, v5}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getEventsForSportByLeague(Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v12

    .line 153
    invoke-interface {v12}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_3

    invoke-interface {v12}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 154
    invoke-direct {p0, v12}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->getEvents(Landroid/database/Cursor;)Ljava/util/ArrayList;

    move-result-object v10

    .line 156
    :cond_3
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mEventsBySportLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v7, 0x0

    invoke-direct/range {v0 .. v8}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 161
    if-eqz v12, :cond_4

    .line 162
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    .end local v4    # "sportId":Ljava/lang/String;
    .end local v5    # "event":Ljava/lang/String;
    .end local v8    # "abrre":Ljava/lang/String;
    :cond_4
    :goto_1
    move-object v11, v10

    .line 164
    .restart local v11    # "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    goto :goto_0

    .line 158
    .end local v11    # "events":Ljava/lang/Object;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    :catch_0
    move-exception v9

    .line 159
    .local v9, "e":Ljava/lang/Exception;
    :try_start_1
    const-string v0, "DataManager:"

    const/4 v1, 0x5

    invoke-static {v0, v1, v9}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 161
    if-eqz v12, :cond_4

    .line 162
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 160
    .end local v9    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    .line 161
    if-eqz v12, :cond_5

    .line 162
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    .line 163
    :cond_5
    throw v0
.end method

.method public getFreshEventByID(Ljava/lang/String;Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;)V
    .locals 3
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;

    .prologue
    .line 449
    :try_start_0
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;

    invoke-direct {v1, p1, p2}, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;-><init>(Ljava/lang/String;Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;)V

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 455
    :goto_0
    return-void

    .line 450
    :catch_0
    move-exception v0

    .line 451
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "DataManager: "

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 452
    const/4 v1, 0x7

    invoke-interface {p2, v1}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;->onEventRetrivalError(I)V

    goto :goto_0
.end method

.method public getLiveEventForNetwork(Ljava/lang/String;Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;)V
    .locals 1
    .param p1, "networkId"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;

    .prologue
    .line 529
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EventByNetworkIdRequest;

    invoke-direct {v0, p2}, Lcom/espn/androidplayersdk/datamanager/EventByNetworkIdRequest;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;)V

    invoke-virtual {v0, p1}, Lcom/espn/androidplayersdk/datamanager/EventByNetworkIdRequest;->getEvent(Ljava/lang/String;)V

    .line 530
    return-void
.end method

.method public getLiveEvents()Ljava/util/ArrayList;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/espn/androidplayersdk/datamanager/EPEvents;",
            ">;"
        }
    .end annotation

    .prologue
    .line 312
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 314
    .local v1, "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    const/4 v2, 0x0

    .line 317
    .local v2, "eventsCursor":Landroid/database/Cursor;
    :try_start_0
    sget-object v3, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    invoke-virtual {v3}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getLiveEvents()Landroid/database/Cursor;

    move-result-object v2

    .line 318
    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v3

    if-lez v3, :cond_0

    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 319
    invoke-direct {p0, v2}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->getEvents(Landroid/database/Cursor;)Ljava/util/ArrayList;

    move-result-object v1

    .line 321
    :cond_0
    new-instance v3, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mLiveEventsLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    const/16 v5, 0x9

    invoke-direct {v3, v4, v5}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;I)V

    invoke-virtual {v3}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 326
    if-eqz v2, :cond_1

    .line 327
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 329
    :cond_1
    :goto_0
    return-object v1

    .line 323
    :catch_0
    move-exception v0

    .line 324
    .local v0, "e":Ljava/lang/Exception;
    :try_start_1
    const-string v3, "DataManager"

    const/4 v4, 0x5

    invoke-static {v3, v4, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 326
    if-eqz v2, :cond_1

    .line 327
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 325
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v3

    .line 326
    if-eqz v2, :cond_2

    .line 327
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 328
    :cond_2
    throw v3
.end method

.method public getSportsList()Ljava/util/ArrayList;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/espn/androidplayersdk/datamanager/EPSport;",
            ">;"
        }
    .end annotation

    .prologue
    .line 370
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 371
    .local v1, "sports":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPSport;>;"
    const/4 v2, 0x0

    .line 373
    .local v2, "sportsCursor":Landroid/database/Cursor;
    :try_start_0
    sget-object v3, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v4, "101"

    invoke-virtual {v3, v4}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getAllSports(Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 374
    invoke-interface {v2}, Landroid/database/Cursor;->getCount()I

    move-result v3

    if-lez v3, :cond_1

    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 377
    :cond_0
    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPSport;

    const-string v4, "sportName"

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 378
    const-string v5, "soprtId"

    invoke-interface {v2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    .line 377
    invoke-interface {v2, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 378
    const-string v6, "sportAbbre"

    invoke-interface {v2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v2, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v3, v4, v5, v6}, Lcom/espn/androidplayersdk/datamanager/EPSport;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 377
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 379
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    .line 381
    invoke-interface {v2}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 383
    :cond_1
    new-instance v3, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mSportListLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    const/4 v5, 0x5

    const-string v6, "101"

    invoke-static {v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v6

    const/4 v7, 0x0

    invoke-direct {v3, v4, v5, v6, v7}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;IILcom/espn/androidplayersdk/datamanager/EPSport;)V

    invoke-virtual {v3}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 388
    if-eqz v2, :cond_2

    .line 389
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 391
    :cond_2
    :goto_0
    return-object v1

    .line 385
    :catch_0
    move-exception v0

    .line 386
    .local v0, "e":Ljava/lang/Exception;
    :try_start_1
    const-string v3, "DataManager: "

    const/4 v4, 0x5

    invoke-static {v3, v4, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 388
    if-eqz v2, :cond_2

    .line 389
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 387
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v3

    .line 388
    if-eqz v2, :cond_3

    .line 389
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 390
    :cond_3
    throw v3
.end method

.method public loadMoreEventsForChannel(Lcom/espn/androidplayersdk/objects/EPChannels;Lcom/espn/androidplayersdk/utilities/EPEventType;)V
    .locals 8
    .param p1, "epChannel"    # Lcom/espn/androidplayersdk/objects/EPChannels;
    .param p2, "epEventType"    # Lcom/espn/androidplayersdk/utilities/EPEventType;

    .prologue
    .line 174
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 181
    :cond_0
    :goto_0
    return-void

    .line 176
    :cond_1
    :try_start_0
    invoke-virtual {p2}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v4

    .line 177
    .local v4, "event":Ljava/lang/String;
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mEventsByChannelLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    const/4 v2, 0x4

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v3, p1

    invoke-direct/range {v0 .. v6}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;ILcom/espn/androidplayersdk/objects/EPChannels;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 178
    .end local v4    # "event":Ljava/lang/String;
    :catch_0
    move-exception v7

    .line 179
    .local v7, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    const/4 v1, 0x5

    invoke-static {v0, v1, v7}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public loadMoreEventsForChannel(Lcom/espn/androidplayersdk/objects/EPChannels;Lcom/espn/androidplayersdk/utilities/EPEventType;I)V
    .locals 8
    .param p1, "epChannel"    # Lcom/espn/androidplayersdk/objects/EPChannels;
    .param p2, "epEventType"    # Lcom/espn/androidplayersdk/utilities/EPEventType;
    .param p3, "eventCount"    # I

    .prologue
    .line 191
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 198
    :cond_0
    :goto_0
    return-void

    .line 193
    :cond_1
    :try_start_0
    invoke-virtual {p2}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v4

    .line 194
    .local v4, "event":Ljava/lang/String;
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mEventsByChannelLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    const/4 v2, 0x4

    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    move-object v3, p1

    invoke-direct/range {v0 .. v6}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;ILcom/espn/androidplayersdk/objects/EPChannels;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 195
    .end local v4    # "event":Ljava/lang/String;
    :catch_0
    move-exception v7

    .line 196
    .local v7, "e":Ljava/lang/Exception;
    const-string v0, "Error: "

    const/4 v1, 0x5

    invoke-static {v0, v1, v7}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public loadMoreEventsForSport(Lcom/espn/androidplayersdk/datamanager/EPSport;Lcom/espn/androidplayersdk/utilities/EPEventType;)V
    .locals 1
    .param p1, "epSport"    # Lcom/espn/androidplayersdk/datamanager/EPSport;
    .param p2, "epEventType"    # Lcom/espn/androidplayersdk/utilities/EPEventType;

    .prologue
    .line 246
    const/16 v0, 0xa

    invoke-virtual {p0, p1, p2, v0}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->loadMoreEventsForSport(Lcom/espn/androidplayersdk/datamanager/EPSport;Lcom/espn/androidplayersdk/utilities/EPEventType;I)V

    .line 247
    return-void
.end method

.method public loadMoreEventsForSport(Lcom/espn/androidplayersdk/datamanager/EPSport;Lcom/espn/androidplayersdk/utilities/EPEventType;I)V
    .locals 10
    .param p1, "epSport"    # Lcom/espn/androidplayersdk/datamanager/EPSport;
    .param p2, "epEventType"    # Lcom/espn/androidplayersdk/utilities/EPEventType;
    .param p3, "eventCount"    # I

    .prologue
    .line 257
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 269
    :cond_0
    :goto_0
    return-void

    .line 260
    :cond_1
    :try_start_0
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getId()Ljava/lang/String;

    move-result-object v4

    .line 261
    .local v4, "sportId":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getName()Ljava/lang/String;

    move-result-object v3

    .line 262
    .local v3, "sport":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v5

    .line 263
    .local v5, "event":Ljava/lang/String;
    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    .line 265
    .local v6, "limit":Ljava/lang/String;
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->mEventsBySportLock:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;

    const/4 v2, 0x7

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-direct/range {v0 .. v8}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;-><init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/RefreshFeedsThread;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 266
    .end local v3    # "sport":Ljava/lang/String;
    .end local v4    # "sportId":Ljava/lang/String;
    .end local v5    # "event":Ljava/lang/String;
    .end local v6    # "limit":Ljava/lang/String;
    :catch_0
    move-exception v9

    .line 267
    .local v9, "e":Ljava/lang/Exception;
    const-string v0, "DataManager: "

    const/4 v1, 0x5

    invoke-static {v0, v1, v9}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public search(Ljava/lang/String;Lcom/espn/androidplayersdk/utilities/EPEventType;IILcom/espn/androidplayersdk/listenerinterface/SearchCallback;)V
    .locals 2
    .param p1, "keywords"    # Ljava/lang/String;
    .param p2, "type"    # Lcom/espn/androidplayersdk/utilities/EPEventType;
    .param p3, "countStart"    # I
    .param p4, "eventCount"    # I
    .param p5, "callback"    # Lcom/espn/androidplayersdk/listenerinterface/SearchCallback;

    .prologue
    .line 513
    if-eqz p5, :cond_0

    if-eqz p2, :cond_0

    if-nez p1, :cond_1

    .line 516
    :cond_0
    :goto_0
    return-void

    .line 515
    :cond_1
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/SearchAPI;

    invoke-direct {v0, p5}, Lcom/espn/androidplayersdk/datamanager/SearchAPI;-><init>(Lcom/espn/androidplayersdk/listenerinterface/SearchCallback;)V

    invoke-virtual {p2}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1, p4, p3}, Lcom/espn/androidplayersdk/datamanager/SearchAPI;->search(Ljava/lang/String;Ljava/lang/String;II)V

    goto :goto_0
.end method
