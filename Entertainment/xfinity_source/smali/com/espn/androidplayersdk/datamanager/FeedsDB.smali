.class Lcom/espn/androidplayersdk/datamanager/FeedsDB;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "FeedsDB.java"


# static fields
.field public static final CHANNELS_CODE:Ljava/lang/String; = "code"

.field public static final CHANNELS_ID:Ljava/lang/String; = "id"

.field public static final CHANNELS_IMAGE_SMALL:Ljava/lang/String; = "ImageSmall"

.field public static final CHANNELS_ISACTIVE:Ljava/lang/String; = "isActive"

.field public static final CHANNELS_NAME:Ljava/lang/String; = "channelName"

.field public static final CHANNELS_RESOURCEID:Ljava/lang/String; = "resourceId"

.field public static final CHANNELS_SLATE_LARGE:Ljava/lang/String; = "slateImageLarge"

.field public static final CHANNELS_SLATE_MED:Ljava/lang/String; = "slateImageMedium"

.field public static final CHANNELS_SLATE_SMALL:Ljava/lang/String; = "slateImageSmall"

.field public static final CHANNELS_TABLE:Ljava/lang/String; = "channel"

.field public static final CHANNELS_TYPE:Ljava/lang/String; = "type"

.field public static final CONFIG_ABOUT_URL:Ljava/lang/String; = "aboutUrl"

.field public static final CONFIG_AFFILIATE_IMG_URL:Ljava/lang/String; = "affiliateImgUrl"

.field public static final CONFIG_AUTH_POST_SIGNIN_URL:Ljava/lang/String; = "authPostSignInURL"

.field public static final CONFIG_BASE_URL:Ljava/lang/String; = "baseURL"

.field public static final CONFIG_CHANNEL_IMAGE_URL:Ljava/lang/String; = "channelImgUrl"

.field public static final CONFIG_EVENT_IMAGE_URLL:Ljava/lang/String; = "eventImgUrl"

.field public static final CONFIG_EVENT_POLING_INTERVAL:Ljava/lang/String; = "eventPollingInterval"

.field public static final CONFIG_EVENT_POLLING_URL:Ljava/lang/String; = "eventPollingUrl"

.field public static final CONFIG_FAQ_URL:Ljava/lang/String; = "faqURL"

.field public static final CONFIG_GRACE_PERIOD:Ljava/lang/String; = "gracePeriod"

.field public static final CONFIG_OMNITURE_JSON:Ljava/lang/String; = "omnitureJson"

.field public static final CONFIG_PLAYER_URL:Ljava/lang/String; = "playerURL"

.field public static final CONFIG_PRIVACY_POLICY:Ljava/lang/String; = "privacyPolicy"

.field public static final CONFIG_SEND_FEEDBACK_URL:Ljava/lang/String; = "sendFeedbackURL"

.field public static final CONFIG_SETINGS_URL:Ljava/lang/String; = "settingsURL"

.field public static final CONFIG_SETUP_URL:Ljava/lang/String; = "setupURL"

.field public static final CONFIG_SIGNIN_URL:Ljava/lang/String; = "signInURL"

.field public static final CONFIG_TABLE:Ljava/lang/String; = "config"

.field public static final CONFIG_TERMS_OF_USE:Ljava/lang/String; = "termsOfUse"

.field public static final CONFIG_TTL:Ljava/lang/String; = "TTL"

.field public static final CONFIG_WELCOME_URL:Ljava/lang/String; = "welcomeURL"

.field private static final DB_NAME:Ljava/lang/String; = "feeds.db"

.field private static final DB_VERSION:I = 0x9

.field public static final EVENTS_BLACKOUT_JSON:Ljava/lang/String; = "blackoutsJason"

.field public static final EVENTS_BROADCAST_START_TIME:Ljava/lang/String; = "broadcastStartTime"

.field public static final EVENTS_COVERAGETYPE:Ljava/lang/String; = "coverageType"

.field public static final EVENTS_DESCRIPTION:Ljava/lang/String; = "description"

.field public static final EVENTS_END_TIME:Ljava/lang/String; = "endTime"

.field public static final EVENTS_EVENTID:Ljava/lang/String; = "eventId"

.field public static final EVENTS_EVENT_NAME:Ljava/lang/String; = "eventName"

.field public static final EVENTS_EVENT_TYPE:Ljava/lang/String; = "eventType"

.field public static final EVENTS_GUID:Ljava/lang/String; = "guid"

.field public static final EVENTS_IMAGE_LARGE:Ljava/lang/String; = "imageLarge"

.field public static final EVENTS_IMAGE_MED:Ljava/lang/String; = "imageMed"

.field public static final EVENTS_IMAGE_SMALL:Ljava/lang/String; = "imageSmall"

.field public static final EVENTS_LEAGUE:Ljava/lang/String; = "league"

.field public static final EVENTS_LEAGUE_NAME:Ljava/lang/String; = "leagueName"

.field public static final EVENTS_METAEVENT_RELATION_ID:Ljava/lang/String; = "metaEventRelationId"

.field public static final EVENTS_NETWORKID:Ljava/lang/String; = "networkId"

.field public static final EVENTS_NETWORKRESOURCEID:Ljava/lang/String; = "networkResourceId"

.field public static final EVENTS_NETWORK_CODE:Ljava/lang/String; = "networkCode"

.field public static final EVENTS_NETWORK_NAME:Ljava/lang/String; = "networkName"

.field public static final EVENTS_OMNITURE_JSON:Ljava/lang/String; = "omnitureJson"

.field public static final EVENTS_PARENTAL_RATING:Ljava/lang/String; = "parentalRating"

.field public static final EVENTS_PROGRAMMINGCODE:Ljava/lang/String; = "programingCode"

.field public static final EVENTS_SEEKINSEC:Ljava/lang/String; = "seekInSeconds"

.field public static final EVENTS_SHOW_NAME:Ljava/lang/String; = "showName"

.field public static final EVENTS_SIMULCASTAIRINGID:Ljava/lang/String; = "simulcastAiringId"

.field public static final EVENTS_SPORT:Ljava/lang/String; = "SPORT"

.field public static final EVENTS_SPORTCODE:Ljava/lang/String; = "sportCode"

.field public static final EVENTS_SPORTID:Ljava/lang/String; = "sportId"

.field public static final EVENTS_START_TIME:Ljava/lang/String; = "startTime"

.field public static final EVENTS_TABLE:Ljava/lang/String; = "events"

.field public static final EVENTS_VIDEOURLDEFAULT:Ljava/lang/String; = "videoURLDefault"

.field public static final EVENTS_VIDEOURLHD:Ljava/lang/String; = "videoURLHD"

.field public static final EVENTS_VIDEOURLLARGE:Ljava/lang/String; = "videoURLLarge"

.field public static final EVENTS_VIDEOURLMED:Ljava/lang/String; = "videoURLMed"

.field public static final EVENTS_VIDEOURLSMALL:Ljava/lang/String; = "videoURLSmall"

.field public static final EVENT_RELATION_EVENTBYID:Ljava/lang/String; = "6"

.field public static final EVENT_RELATION_EVENTSBYCHANNEL:Ljava/lang/String; = "3"

.field public static final EVENT_RELATION_EVENTSBYCHANNELLEAGUE:Ljava/lang/String; = "8"

.field public static final EVENT_RELATION_EVENTSBYSPORTLEAGUE:Ljava/lang/String; = "7"

.field public static final EVENT_RELATION_EVENTSBYSPORTS:Ljava/lang/String; = "4"

.field public static final EVENT_RELATION_LIVEEVENTS:Ljava/lang/String; = "1"

.field public static final EVENT_RELATION_SEARCH:Ljava/lang/String; = "5"

.field public static final FEATURED_CATEGORIES_ABBRE:Ljava/lang/String; = "abbre"

.field public static final FEATURED_CATEGORIES_CATEGORYID:Ljava/lang/String; = "categoryId"

.field public static final FEATURED_CATEGORIES_IMAGEURL:Ljava/lang/String; = "imageUrl"

.field public static final FEATURED_CATEGORIES_LISTINGSURL:Ljava/lang/String; = "listingUrl"

.field public static final FEATURED_CATEGORIES_NAME:Ljava/lang/String; = "name"

.field public static final FEATURED_CATEGORIES_SHORTNAME:Ljava/lang/String; = "shortName"

.field public static final FEATURED_CATEGORIES_TABLE:Ljava/lang/String; = "featuredCategories"

.field public static final FEATURED_CATEGORIES_TYPE:Ljava/lang/String; = "type"

.field public static final FEATURED_CATEGORIES_VODURL:Ljava/lang/String; = "vodUrl"

.field public static final FEATURED_EVENTS_TABLE:Ljava/lang/String; = "featuredEvents"

.field public static final METACHANNELS_OMNITURE_JSON:Ljava/lang/String; = "omnitureJason"

.field public static final METACHANNELS_TTL:Ljava/lang/String; = "TTL"

.field public static final METACHANNEL_TABLE:Ljava/lang/String; = "metaChannel"

.field public static final METAEVENTS_COUNT:Ljava/lang/String; = "count"

.field public static final METAEVENTS_EVENTTYPE:Ljava/lang/String; = "eventsType"

.field public static final METAEVENTS_EVENT_RELATION_ID:Ljava/lang/String; = "eventRelationId"

.field public static final METAEVENTS_NETWORKID:Ljava/lang/String; = "networkId"

.field public static final METAEVENTS_OMNITUREJSON:Ljava/lang/String; = "omnitureJson"

.field public static final METAEVENTS_SPORTID:Ljava/lang/String; = "sportId"

.field public static final METAEVENTS_TABLE:Ljava/lang/String; = "metaEvents"

.field public static final METAEVENTS_TTL:Ljava/lang/String; = "ttl"

.field public static final METASPORTS_OMNITURE_JSON:Ljava/lang/String; = "omnitureJason"

.field public static final METASPORTS_SPORT_RELATION_ID:Ljava/lang/String; = "sportrelationId"

.field public static final METASPORTS_TABLE:Ljava/lang/String; = "metaSport"

.field public static final METASPORTS_TTL:Ljava/lang/String; = "TTL"

.field public static final SPORTS_ABBRE:Ljava/lang/String; = "sportAbbre"

.field public static final SPORTS_ID:Ljava/lang/String; = "soprtId"

.field public static final SPORTS_LEAGUEID:Ljava/lang/String; = "sportLeagueId"

.field public static final SPORTS_LISTINGURL:Ljava/lang/String; = "sportListingUrl"

.field public static final SPORTS_METASPORT_RELATION_ID:Ljava/lang/String; = "sportMetaSportRelation"

.field public static final SPORTS_NAME:Ljava/lang/String; = "sportName"

.field public static final SPORTS_SHORTNAME:Ljava/lang/String; = "sportShortName"

.field public static final SPORTS_TABLE:Ljava/lang/String; = "sport"

.field public static final SPORTS_TOPLISTINGURL:Ljava/lang/String; = "sportListingtop"

.field public static final SPORTS_TYPE:Ljava/lang/String; = "sportType"

.field public static final SPORTS_VODURL:Ljava/lang/String; = "sportVodUrl"

.field public static final SPORT_METASPORT_RELATION:Ljava/lang/String; = "101"

.field public static final TOPSPORT_METASPORT_RELATION:Ljava/lang/String; = "102"

.field public static final USER_DATA_AFFILIATE_NAME:Ljava/lang/String; = "affiliateName"

.field public static final USER_DATA_AUTHENTICATED:Ljava/lang/String; = "authenticated"

.field public static final USER_DATA_GRACE_TIME_LEFT:Ljava/lang/String; = "graceTimeLeft"

.field public static final USER_DATA_IMAGE:Ljava/lang/String; = "image"

.field public static final USER_DATA_ISLOGGEDIN:Ljava/lang/String; = "isLoggedIn"

.field public static final USER_DATA_NAME:Ljava/lang/String; = "name"

.field public static final USER_DATA_OMNISWID:Ljava/lang/String; = "omniSwid"

.field public static final USER_DATA_SWID:Ljava/lang/String; = "swid"

.field public static final USER_DATA_TABLE:Ljava/lang/String; = "userdata"

.field public static final USER_DATA_UDID:Ljava/lang/String; = "udid"

.field public static final USER_DATA_USER_NAME:Ljava/lang/String; = "username"


# instance fields
.field db:Landroid/database/sqlite/SQLiteDatabase;


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 197
    const-string v0, "feeds.db"

    const/4 v1, 0x0

    const/16 v2, 0x9

    invoke-direct {p0, p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 198
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v0

    if-nez v0, :cond_0

    .line 199
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 200
    :cond_0
    return-void
.end method


# virtual methods
.method protected cleanEventsTable()V
    .locals 6

    .prologue
    .line 499
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "events"

    const-string v2, "metaEventRelationId=?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "6"

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 500
    return-void
.end method

.method public declared-synchronized close()V
    .locals 1

    .prologue
    .line 455
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v0, :cond_0

    .line 456
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->releaseMemory()V

    .line 457
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 458
    invoke-super {p0}, Landroid/database/sqlite/SQLiteOpenHelper;->close()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 460
    :cond_0
    monitor-exit p0

    return-void

    .line 455
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected closeConnection()V
    .locals 1

    .prologue
    .line 481
    :try_start_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 485
    :goto_0
    return-void

    .line 482
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected delAllRows(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 3
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "where"    # Ljava/lang/String;
    .param p3, "whereArg"    # [Ljava/lang/String;

    .prologue
    .line 753
    :try_start_0
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v1

    if-nez v1, :cond_0

    .line 754
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 755
    :cond_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1, p1, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 760
    :goto_0
    return-void

    .line 757
    :catch_0
    move-exception v0

    .line 758
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Error"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected getAllChannels()Landroid/database/Cursor;
    .locals 11

    .prologue
    const/4 v3, 0x0

    .line 765
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v0

    if-nez v0, :cond_0

    .line 766
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 768
    :cond_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v1, 0x1

    const-string v2, "channel"

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    move-object v8, v3

    move-object v9, v3

    invoke-virtual/range {v0 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 769
    .local v10, "channels":Landroid/database/Cursor;
    return-object v10
.end method

.method protected getAllSports(Ljava/lang/String;)Landroid/database/Cursor;
    .locals 11
    .param p1, "relationID"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    const/4 v3, 0x0

    .line 775
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v0

    if-nez v0, :cond_0

    .line 776
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 778
    :cond_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "sport"

    const-string v4, "sportMetaSportRelation= ?"

    new-array v5, v1, [Ljava/lang/String;

    const/4 v6, 0x0

    aput-object p1, v5, v6

    move-object v6, v3

    move-object v7, v3

    move-object v8, v3

    move-object v9, v3

    invoke-virtual/range {v0 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 780
    .local v10, "sports":Landroid/database/Cursor;
    return-object v10
.end method

.method protected getConfig()Landroid/database/Cursor;
    .locals 11

    .prologue
    const/4 v3, 0x0

    .line 797
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v0

    if-nez v0, :cond_0

    .line 798
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 800
    :cond_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v1, 0x1

    const-string v2, "config"

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    move-object v8, v3

    move-object v9, v3

    invoke-virtual/range {v0 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 801
    .local v10, "channels":Landroid/database/Cursor;
    return-object v10
.end method

.method protected getEventById(Ljava/lang/String;)Landroid/database/Cursor;
    .locals 4
    .param p1, "eventId"    # Ljava/lang/String;

    .prologue
    .line 944
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v2

    if-nez v2, :cond_0

    .line 945
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 947
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Select * from events where eventId="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 949
    .local v1, "sql":Ljava/lang/String;
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 950
    .local v0, "events":Landroid/database/Cursor;
    return-object v0
.end method

.method protected getEventsForChannel(Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 4
    .param p1, "networkId"    # Ljava/lang/String;
    .param p2, "event"    # Ljava/lang/String;

    .prologue
    .line 808
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v2

    if-nez v2, :cond_0

    .line 809
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 811
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Select * from events where metaEventRelationId = \'3\' and networkId = \'"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 812
    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 811
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 814
    .local v1, "sql":Ljava/lang/String;
    if-eqz p2, :cond_1

    .line 815
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " and eventType = \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 817
    :cond_1
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 818
    .local v0, "events":Landroid/database/Cursor;
    return-object v0
.end method

.method protected getEventsForChannelByLeague(Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 4
    .param p1, "networkCode"    # Ljava/lang/String;
    .param p2, "event"    # Ljava/lang/String;

    .prologue
    .line 861
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v2

    if-nez v2, :cond_0

    .line 862
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 864
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Select * from events where metaEventRelationId = \'8\' and networkCode = \'"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 865
    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 864
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 867
    .local v1, "sql":Ljava/lang/String;
    if-eqz p2, :cond_1

    .line 868
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " and eventType = \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 870
    :cond_1
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 871
    .local v0, "events":Landroid/database/Cursor;
    return-object v0
.end method

.method protected getEventsForFeaturedCategories(ILjava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 4
    .param p1, "featuredEventsRelationID"    # I
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "sportid"    # Ljava/lang/String;

    .prologue
    .line 929
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v2

    if-nez v2, :cond_0

    .line 930
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 931
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Select * from featuredEvents where metaEventRelationId = \'"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 933
    .local v1, "sql":Ljava/lang/String;
    if-eqz p2, :cond_1

    .line 934
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "\' and eventType= \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 935
    :cond_1
    if-eqz p3, :cond_2

    .line 936
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " and sportId = \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 937
    :cond_2
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 938
    .local v0, "events":Landroid/database/Cursor;
    return-object v0
.end method

.method protected getEventsForSport(Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 4
    .param p1, "sportId"    # Ljava/lang/String;
    .param p2, "event"    # Ljava/lang/String;

    .prologue
    .line 825
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v2

    if-nez v2, :cond_0

    .line 826
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 828
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Select * from events where metaEventRelationId = \'4\' and sportId = \'"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 829
    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 828
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 831
    .local v1, "sql":Ljava/lang/String;
    if-eqz p2, :cond_1

    .line 832
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " and eventType = \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 834
    :cond_1
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 835
    .local v0, "events":Landroid/database/Cursor;
    return-object v0
.end method

.method protected getEventsForSportByLeague(Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 4
    .param p1, "sportId"    # Ljava/lang/String;
    .param p2, "event"    # Ljava/lang/String;

    .prologue
    .line 843
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v2

    if-nez v2, :cond_0

    .line 844
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 846
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Select * from events where metaEventRelationId = \'7\' and sportId = \'"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 847
    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 846
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 849
    .local v1, "sql":Ljava/lang/String;
    if-eqz p2, :cond_1

    .line 850
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " and eventType = \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 852
    :cond_1
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 853
    .local v0, "events":Landroid/database/Cursor;
    return-object v0
.end method

.method protected getFeaturedCategories()Landroid/database/Cursor;
    .locals 4

    .prologue
    .line 891
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v2

    if-nez v2, :cond_0

    .line 892
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 894
    :cond_0
    const-string v1, "Select * from featuredCategories"

    .line 895
    .local v1, "sql":Ljava/lang/String;
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 896
    .local v0, "events":Landroid/database/Cursor;
    return-object v0
.end method

.method protected getFeaturedEventById(Ljava/lang/String;)Landroid/database/Cursor;
    .locals 4
    .param p1, "eventId"    # Ljava/lang/String;

    .prologue
    .line 955
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v2

    if-nez v2, :cond_0

    .line 956
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 958
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Select * from featuredEvents where eventId="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 960
    .local v1, "sql":Ljava/lang/String;
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 961
    .local v0, "events":Landroid/database/Cursor;
    return-object v0
.end method

.method protected getFeaturedEvents(ILcom/espn/androidplayersdk/datamanager/EPSport;)Landroid/database/Cursor;
    .locals 4
    .param p1, "featuredEventsRelationID"    # I
    .param p2, "sport"    # Lcom/espn/androidplayersdk/datamanager/EPSport;

    .prologue
    .line 877
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v2

    if-nez v2, :cond_0

    .line 878
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 880
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Select * from featuredEvents where metaEventRelationId = \'"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 882
    .local v1, "sql":Ljava/lang/String;
    if-eqz p2, :cond_1

    .line 883
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " and sportId = \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p2}, Lcom/espn/androidplayersdk/datamanager/EPSport;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 884
    :cond_1
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 885
    .local v0, "events":Landroid/database/Cursor;
    return-object v0
.end method

.method protected getLiveEvents()Landroid/database/Cursor;
    .locals 4

    .prologue
    .line 918
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v2

    if-nez v2, :cond_0

    .line 919
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 921
    :cond_0
    const-string v1, "Select * from events where metaEventRelationId = \'1\'"

    .line 923
    .local v1, "sql":Ljava/lang/String;
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 924
    .local v0, "events":Landroid/database/Cursor;
    return-object v0
.end method

.method protected getMeta(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 11
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "where"    # Ljava/lang/String;
    .param p3, "whereArg"    # [Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 787
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v0

    if-nez v0, :cond_0

    .line 788
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 790
    :cond_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v1, 0x1

    move-object v2, p1

    move-object v4, p2

    move-object v5, p3

    move-object v6, v3

    move-object v7, v3

    move-object v8, v3

    move-object v9, v3

    invoke-virtual/range {v0 .. v9}, Landroid/database/sqlite/SQLiteDatabase;->query(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 791
    .local v10, "meta":Landroid/database/Cursor;
    return-object v10
.end method

.method protected getTableRows(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 4
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "limit"    # Ljava/lang/String;
    .param p3, "whereClause"    # Ljava/lang/String;

    .prologue
    .line 902
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v2

    if-nez v2, :cond_0

    .line 903
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 905
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Select * from "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 906
    .local v1, "sql":Ljava/lang/String;
    if-eqz p3, :cond_1

    .line 907
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " where "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 908
    :cond_1
    if-eqz p2, :cond_2

    .line 909
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " limit "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 911
    :cond_2
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 912
    .local v0, "events":Landroid/database/Cursor;
    return-object v0
.end method

.method public getVODUrl(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p1, "eventId"    # Ljava/lang/String;
    .param p2, "urlType"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 1004
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v3

    if-nez v3, :cond_0

    .line 1005
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 1007
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Select "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " from "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "featuredEvents"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " where "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "eventId"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1008
    .local v1, "sql":Ljava/lang/String;
    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 1009
    .local v0, "events":Landroid/database/Cursor;
    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v3

    if-lez v3, :cond_1

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1010
    const/4 v2, 0x0

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1012
    :cond_1
    return-object v2
.end method

.method public getVideoInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    .locals 10
    .param p1, "eventId"    # Ljava/lang/String;
    .param p2, "urlType"    # Ljava/lang/String;
    .param p3, "eventTable"    # Ljava/lang/String;

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 967
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v3

    if-nez v3, :cond_0

    .line 968
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 969
    :cond_0
    const/4 v0, 0x0

    .line 970
    .local v0, "eventInfo":[Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Select "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "eventType"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "type"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " from "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "channel"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 971
    const-string v4, " where "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "eventId"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " and "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "networkCode"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "code"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 970
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 972
    .local v2, "sql":Ljava/lang/String;
    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3, v2, v9}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 973
    .local v1, "events":Landroid/database/Cursor;
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v3

    if-lez v3, :cond_5

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 976
    :cond_1
    invoke-interface {v1, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    const-string v4, "live"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 979
    :goto_0
    invoke-interface {v1}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 980
    invoke-interface {v1}, Landroid/database/Cursor;->moveToPrevious()Z

    .line 982
    :cond_2
    new-array v0, v8, [Ljava/lang/String;

    .line 983
    invoke-interface {v1, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v0, v6

    .line 984
    invoke-interface {v1, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v0, v5

    .line 985
    invoke-interface {v1, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v0, v7

    .line 998
    :cond_3
    :goto_1
    return-object v0

    .line 978
    :cond_4
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-nez v3, :cond_1

    goto :goto_0

    .line 989
    :cond_5
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Select "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "eventType"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " from "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " where "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "eventId"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ";"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 990
    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3, v2, v9}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 991
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v3

    if-lez v3, :cond_3

    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 992
    new-array v0, v8, [Ljava/lang/String;

    .line 993
    invoke-interface {v1, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v0, v6

    .line 994
    invoke-interface {v1, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v0, v5

    .line 995
    const-string v3, ""

    aput-object v3, v0, v7

    goto :goto_1
.end method

.method protected insertIntoChannelsTable(Landroid/content/ContentValues;)V
    .locals 5
    .param p1, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 531
    :try_start_0
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v1

    if-nez v1, :cond_0

    .line 532
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 534
    :cond_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "channel"

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-virtual {v1, v2, v3, p1, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 539
    :goto_0
    return-void

    .line 536
    :catch_0
    move-exception v0

    .line 537
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Error"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected insertIntoConfigsTable(Landroid/content/ContentValues;)V
    .locals 5
    .param p1, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 505
    :try_start_0
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v1

    if-nez v1, :cond_0

    .line 506
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 508
    :cond_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "config"

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-virtual {v1, v2, v3, p1, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 513
    :goto_0
    return-void

    .line 510
    :catch_0
    move-exception v0

    .line 511
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Error"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected insertIntoEventsTable(Landroid/content/ContentValues;)V
    .locals 5
    .param p1, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 586
    :try_start_0
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v1

    if-nez v1, :cond_0

    .line 587
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 588
    :cond_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "events"

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-virtual {v1, v2, v3, p1, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 593
    :goto_0
    return-void

    .line 590
    :catch_0
    move-exception v0

    .line 591
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Error"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected insertIntoFeaturedCategoriesTable(Landroid/content/ContentValues;)V
    .locals 5
    .param p1, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 610
    :try_start_0
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v1

    if-nez v1, :cond_0

    .line 611
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 612
    :cond_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "featuredCategories"

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-virtual {v1, v2, v3, p1, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 617
    :goto_0
    return-void

    .line 614
    :catch_0
    move-exception v0

    .line 615
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Error"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected insertIntoFeaturedEventsTable(Landroid/content/ContentValues;)V
    .locals 5
    .param p1, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 598
    :try_start_0
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v1

    if-nez v1, :cond_0

    .line 599
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 600
    :cond_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "featuredEvents"

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-virtual {v1, v2, v3, p1, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 605
    :goto_0
    return-void

    .line 602
    :catch_0
    move-exception v0

    .line 603
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Error"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected insertIntoMetaEventsTable(Landroid/content/ContentValues;)V
    .locals 5
    .param p1, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 625
    :try_start_0
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v1

    if-nez v1, :cond_0

    .line 626
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 628
    :cond_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "metaEvents"

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-virtual {v1, v2, v3, p1, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 633
    :goto_0
    return-void

    .line 630
    :catch_0
    move-exception v0

    .line 631
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Error"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected insertIntoSportsTable(Landroid/content/ContentValues;)V
    .locals 5
    .param p1, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 559
    :try_start_0
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v1

    if-nez v1, :cond_0

    .line 560
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 562
    :cond_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "sport"

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-virtual {v1, v2, v3, p1, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 567
    :goto_0
    return-void

    .line 564
    :catch_0
    move-exception v0

    .line 565
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Error"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected insertIntoUserDataTable(Landroid/content/ContentValues;)V
    .locals 5
    .param p1, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 518
    :try_start_0
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v1

    if-nez v1, :cond_0

    .line 519
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 521
    :cond_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "userdata"

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-virtual {v1, v2, v3, p1, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 526
    :goto_0
    return-void

    .line 523
    :catch_0
    move-exception v0

    .line 524
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Error"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected insertOrUpdateMetaChannelTable(Landroid/content/ContentValues;)V
    .locals 9
    .param p1, "values"    # Landroid/content/ContentValues;

    .prologue
    const/4 v8, 0x1

    .line 544
    :try_start_0
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v0

    if-nez v0, :cond_0

    .line 545
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 547
    :cond_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "metaChannel"

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x1

    move-object v2, p1

    invoke-virtual/range {v0 .. v5}, Landroid/database/sqlite/SQLiteDatabase;->updateWithOnConflict(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)I

    move-result v7

    .line 548
    .local v7, "update":I
    if-ge v7, v8, :cond_1

    .line 549
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "metaChannel"

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v2, p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 554
    .end local v7    # "update":I
    :cond_1
    :goto_0
    return-void

    .line 551
    :catch_0
    move-exception v6

    .line 552
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error"

    const/4 v1, 0x5

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected insertOrUpdateMetaEventsTable(Landroid/content/ContentValues;)V
    .locals 10
    .param p1, "values"    # Landroid/content/ContentValues;

    .prologue
    const/4 v9, 0x1

    .line 638
    :try_start_0
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v0

    if-nez v0, :cond_0

    .line 639
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 640
    :cond_0
    const-string v3, "eventRelationId = ?"

    .line 643
    .local v3, "where":Ljava/lang/String;
    const-string v0, "eventRelationId"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->getAsInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v7

    .line 645
    .local v7, "relationId":I
    if-eq v7, v9, :cond_2

    const/16 v0, 0xa

    if-le v7, v0, :cond_1

    const/16 v0, 0x12

    if-lt v7, v0, :cond_2

    :cond_1
    const/16 v0, 0x1e

    if-ne v7, v0, :cond_6

    .line 647
    :cond_2
    const/16 v0, 0x10

    if-ne v7, v0, :cond_5

    .line 648
    const/4 v0, 0x2

    new-array v4, v0, [Ljava/lang/String;

    .line 649
    .local v4, "whereArg":[Ljava/lang/String;
    const/4 v0, 0x1

    const-string v1, "sportId"

    invoke-virtual {p1, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v0

    .line 650
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, " and sportId = ? "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 661
    :goto_0
    const/4 v0, 0x0

    const-string v1, "eventRelationId"

    invoke-virtual {p1, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v0

    .line 685
    :cond_3
    :goto_1
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "metaEvents"

    const/4 v5, 0x1

    move-object v2, p1

    invoke-virtual/range {v0 .. v5}, Landroid/database/sqlite/SQLiteDatabase;->updateWithOnConflict(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)I

    move-result v8

    .line 686
    .local v8, "update":I
    if-ge v8, v9, :cond_4

    .line 687
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "metaEvents"

    const/4 v2, 0x0

    const/4 v5, 0x1

    invoke-virtual {v0, v1, v2, p1, v5}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    .line 692
    .end local v3    # "where":Ljava/lang/String;
    .end local v4    # "whereArg":[Ljava/lang/String;
    .end local v7    # "relationId":I
    .end local v8    # "update":I
    :cond_4
    :goto_2
    return-void

    .line 660
    .restart local v3    # "where":Ljava/lang/String;
    .restart local v7    # "relationId":I
    :cond_5
    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    .restart local v4    # "whereArg":[Ljava/lang/String;
    goto :goto_0

    .line 663
    .end local v4    # "whereArg":[Ljava/lang/String;
    :cond_6
    const-string v0, "eventsType"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7

    const-string v0, "eventsType"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_7

    .line 664
    const/4 v0, 0x3

    new-array v4, v0, [Ljava/lang/String;

    .line 665
    .restart local v4    # "whereArg":[Ljava/lang/String;
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, " and eventsType = ?"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 666
    const/4 v0, 0x1

    const-string v1, "eventsType"

    invoke-virtual {p1, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v0

    .line 670
    :goto_3
    const/4 v0, 0x0

    const-string v1, "eventRelationId"

    invoke-virtual {p1, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v0

    .line 672
    const-string v0, "sportId"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    const-string v0, "sportId"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 674
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, " and sportId = ?"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 675
    const/4 v0, 0x2

    const-string v1, "sportId"

    invoke-virtual {p1, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_1

    .line 689
    .end local v3    # "where":Ljava/lang/String;
    .end local v4    # "whereArg":[Ljava/lang/String;
    .end local v7    # "relationId":I
    :catch_0
    move-exception v6

    .line 690
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error"

    const/4 v1, 0x5

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_2

    .line 668
    .end local v6    # "e":Ljava/lang/Exception;
    .restart local v3    # "where":Ljava/lang/String;
    .restart local v7    # "relationId":I
    :cond_7
    const/4 v0, 0x2

    :try_start_1
    new-array v4, v0, [Ljava/lang/String;

    .restart local v4    # "whereArg":[Ljava/lang/String;
    goto :goto_3

    .line 677
    :cond_8
    const-string v0, "networkId"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "networkId"

    invoke-virtual {p1, v0}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/espn/androidplayersdk/utilities/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 679
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, " and networkId = ?"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 680
    const/4 v0, 0x2

    const-string v1, "networkId"

    invoke-virtual {p1, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v0
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1
.end method

.method protected insertOrUpdateMetaSportTable(Landroid/content/ContentValues;)V
    .locals 9
    .param p1, "values"    # Landroid/content/ContentValues;

    .prologue
    const/4 v8, 0x1

    .line 572
    :try_start_0
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v0

    if-nez v0, :cond_0

    .line 573
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 574
    :cond_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "metaSport"

    const-string v3, "sportrelationId= ?"

    .line 575
    const/4 v2, 0x1

    new-array v4, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v5, "sportrelationId"

    invoke-virtual {p1, v5}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v2

    const/4 v5, 0x1

    move-object v2, p1

    .line 574
    invoke-virtual/range {v0 .. v5}, Landroid/database/sqlite/SQLiteDatabase;->updateWithOnConflict(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)I

    move-result v7

    .line 576
    .local v7, "update":I
    if-ge v7, v8, :cond_1

    .line 577
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "metaSport"

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v2, p1, v3}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 581
    .end local v7    # "update":I
    :cond_1
    :goto_0
    return-void

    .line 578
    :catch_0
    move-exception v6

    .line 579
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error"

    const/4 v1, 0x5

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected isConnectionOpen()Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 471
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    if-nez v1, :cond_1

    .line 475
    :cond_0
    :goto_0
    return v0

    .line 473
    :cond_1
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->isOpen()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 474
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 5
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 206
    :try_start_0
    const-string v1, "CREATE TABLE IF NOT EXISTS config(_id integer PRIMARY KEY AUTOINCREMENT,aboutUrl text,affiliateImgUrl text,authPostSignInURL text,baseURL text,termsOfUse text,privacyPolicy text,channelImgUrl text, eventImgUrl text, eventPollingInterval text, eventPollingUrl text, faqURL text, gracePeriod text, playerURL text, sendFeedbackURL text, settingsURL text, setupURL text, TTL text, welcomeURL text, signInURL text, omnitureJson text)"

    .line 213
    .local v1, "sql":Ljava/lang/String;
    const-string v2, "FeedsDB- onCreate(): Config"

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 214
    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 216
    const-string v1, "CREATE TABLE IF NOT EXISTS userdata(_id integer PRIMARY KEY AUTOINCREMENT,udid text,username text,affiliateName text,swid text,omniSwid text,isLoggedIn text,name text, image text, graceTimeLeft text, authenticated text)"

    .line 220
    const-string v2, "FeedsDB- onCreate(): UserData"

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 221
    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 223
    const-string v1, "CREATE TABLE IF NOT EXISTS channel(_id integer PRIMARY KEY AUTOINCREMENT,channelName text,ImageSmall text,slateImageSmall text,slateImageMedium text,slateImageLarge text,resourceId text,isActive text,type text,id text,code text)"

    .line 227
    const-string v2, "FeedsDB- onCreate(): Channel"

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 228
    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 230
    const-string v1, "CREATE TABLE IF NOT EXISTS metaChannel(_id integer PRIMARY KEY AUTOINCREMENT,TTL text,omnitureJason text)"

    .line 232
    const-string v2, "FeedsDB- onCreate(): MetaChannel"

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 233
    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 235
    const-string v1, "CREATE TABLE IF NOT EXISTS sport(_id integer PRIMARY KEY AUTOINCREMENT,soprtId text,sportAbbre text,sportLeagueId text,sportShortName text,sportType text,sportVodUrl text,sportListingUrl text,sportListingtop text,sportName text, text,sportMetaSportRelation text)"

    .line 239
    const-string v2, "FeedsDB- onCreate(): Sport"

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 240
    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 242
    const-string v1, "CREATE TABLE IF NOT EXISTS metaSport(_id integer PRIMARY KEY AUTOINCREMENT,TTL text,sportrelationId text,omnitureJason text)"

    .line 244
    const-string v2, "FeedsDB- onCreate(): MetaSport"

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 245
    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 247
    const-string v1, "CREATE TABLE IF NOT EXISTS events(_id integer PRIMARY KEY AUTOINCREMENT,broadcastStartTime text,blackoutsJason text,SPORT text,sportId text,eventType text,endTime text,league text,leagueName text,networkCode text, networkName text, networkId text, guid text, startTime text, eventId text, showName text, simulcastAiringId text, seekInSeconds text, parentalRating text, omnitureJson text, imageSmall text, imageMed text, imageLarge text, eventName text, videoURLDefault text, videoURLSmall text, videoURLMed text, videoURLLarge text, videoURLHD text, description text, programingCode text, sportCode text, coverageType text, networkResourceId text, metaEventRelationId text)"

    .line 257
    const-string v2, "FeedsDB- onCreate(): Events"

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 258
    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 260
    const-string v1, "CREATE TABLE IF NOT EXISTS featuredEvents(_id integer PRIMARY KEY AUTOINCREMENT,broadcastStartTime text,blackoutsJason text,SPORT text,sportId text,eventType text,endTime text,league text,leagueName text,networkCode text, networkName text, networkId text, guid text, startTime text, eventId text, showName text, simulcastAiringId text, seekInSeconds text, parentalRating text, omnitureJson text, imageSmall text, imageMed text, imageLarge text, eventName text, videoURLDefault text, videoURLSmall text, videoURLMed text, videoURLLarge text, videoURLHD text, description text, programingCode text, coverageType text, networkResourceId text, sportCode text, metaEventRelationId text)"

    .line 270
    const-string v2, "FeedsDB- onCreate(): Events"

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 271
    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 273
    const-string v1, "CREATE TABLE IF NOT EXISTS metaEvents(_id integer PRIMARY KEY AUTOINCREMENT,count text,omnitureJson text,eventsType text,ttl text,sportId text,networkId text,eventRelationId text)"

    .line 276
    const-string v2, "FeedsDB- onCreate(): MetaEvents"

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 277
    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 279
    const-string v1, "CREATE TABLE IF NOT EXISTS featuredCategories(_id integer PRIMARY KEY AUTOINCREMENT,categoryId text,name text,abbre text,shortName text,type text,imageUrl text,vodUrl text,listingUrl text )"

    .line 283
    const-string v2, "FeedsDB- onCreate(): FeaturedCategoryEvents"

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 284
    invoke-virtual {p1, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 289
    .end local v1    # "sql":Ljava/lang/String;
    :goto_0
    return-void

    .line 286
    :catch_0
    move-exception v0

    .line 287
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "FeedsDB- onCreate():"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 4
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    const/16 v3, 0x9

    const/4 v2, 0x5

    .line 293
    const/4 v1, 0x1

    if-ne p2, v1, :cond_1

    if-ne p3, v3, :cond_1

    .line 295
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV1toV2(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 296
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV2toV3(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 297
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV3toV4(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 298
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV4toV5(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 299
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV5toV6(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 300
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV6toV7(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 301
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV7toV8(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 302
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV8toV9(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 370
    :cond_0
    :goto_0
    return-void

    .line 303
    :catch_0
    move-exception v0

    .line 304
    .local v0, "e":Landroid/database/SQLException;
    const-string v1, "FeedsDB- onUpgrade():"

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    .line 306
    .end local v0    # "e":Landroid/database/SQLException;
    :cond_1
    const/4 v1, 0x2

    if-ne p2, v1, :cond_2

    if-ne p3, v3, :cond_2

    .line 308
    :try_start_1
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV2toV3(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 309
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV3toV4(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 310
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV4toV5(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 311
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV5toV6(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 312
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV6toV7(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 313
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV7toV8(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 314
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV8toV9(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_1
    .catch Landroid/database/SQLException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 315
    :catch_1
    move-exception v0

    .line 316
    .restart local v0    # "e":Landroid/database/SQLException;
    const-string v1, "FeedsDB- onUpgrade():"

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    .line 318
    .end local v0    # "e":Landroid/database/SQLException;
    :cond_2
    const/4 v1, 0x3

    if-ne p2, v1, :cond_3

    if-ne p3, v3, :cond_3

    .line 320
    :try_start_2
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV3toV4(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 321
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV4toV5(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 322
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV5toV6(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 323
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV6toV7(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 324
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV7toV8(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 325
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV8toV9(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_2
    .catch Landroid/database/SQLException; {:try_start_2 .. :try_end_2} :catch_2

    goto :goto_0

    .line 326
    :catch_2
    move-exception v0

    .line 327
    .restart local v0    # "e":Landroid/database/SQLException;
    const-string v1, "FeedsDB- onUpgrade():"

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    .line 329
    .end local v0    # "e":Landroid/database/SQLException;
    :cond_3
    const/4 v1, 0x4

    if-ne p2, v1, :cond_4

    if-ne p3, v3, :cond_4

    .line 331
    :try_start_3
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV4toV5(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 332
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV5toV6(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 333
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV6toV7(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 334
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV7toV8(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 335
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV8toV9(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_3
    .catch Landroid/database/SQLException; {:try_start_3 .. :try_end_3} :catch_3

    goto :goto_0

    .line 336
    :catch_3
    move-exception v0

    .line 337
    .restart local v0    # "e":Landroid/database/SQLException;
    const-string v1, "FeedsDB- onUpgrade():"

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    .line 339
    .end local v0    # "e":Landroid/database/SQLException;
    :cond_4
    if-ne p2, v2, :cond_5

    if-ne p3, v3, :cond_5

    .line 341
    :try_start_4
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV5toV6(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 342
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV6toV7(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 343
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV7toV8(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 344
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV8toV9(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_4
    .catch Landroid/database/SQLException; {:try_start_4 .. :try_end_4} :catch_4

    goto :goto_0

    .line 345
    :catch_4
    move-exception v0

    .line 346
    .restart local v0    # "e":Landroid/database/SQLException;
    const-string v1, "FeedsDB- onUpgrade():"

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    .line 348
    .end local v0    # "e":Landroid/database/SQLException;
    :cond_5
    const/4 v1, 0x6

    if-ne p2, v1, :cond_6

    if-ne p3, v3, :cond_6

    .line 350
    :try_start_5
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV6toV7(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 351
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV7toV8(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 352
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV8toV9(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_5
    .catch Landroid/database/SQLException; {:try_start_5 .. :try_end_5} :catch_5

    goto/16 :goto_0

    .line 353
    :catch_5
    move-exception v0

    .line 354
    .restart local v0    # "e":Landroid/database/SQLException;
    const-string v1, "FeedsDB- onUpgrade():"

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto/16 :goto_0

    .line 356
    .end local v0    # "e":Landroid/database/SQLException;
    :cond_6
    const/4 v1, 0x7

    if-ne p2, v1, :cond_7

    if-ne p3, v3, :cond_7

    .line 358
    :try_start_6
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV7toV8(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 359
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV8toV9(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_6
    .catch Landroid/database/SQLException; {:try_start_6 .. :try_end_6} :catch_6

    goto/16 :goto_0

    .line 360
    :catch_6
    move-exception v0

    .line 361
    .restart local v0    # "e":Landroid/database/SQLException;
    const-string v1, "FeedsDB- onUpgrade():"

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto/16 :goto_0

    .line 363
    .end local v0    # "e":Landroid/database/SQLException;
    :cond_7
    const/16 v1, 0x8

    if-ne p2, v1, :cond_0

    if-ne p3, v3, :cond_0

    .line 365
    :try_start_7
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->upgradeV8toV9(Landroid/database/sqlite/SQLiteDatabase;)V
    :try_end_7
    .catch Landroid/database/SQLException; {:try_start_7 .. :try_end_7} :catch_7

    goto/16 :goto_0

    .line 366
    :catch_7
    move-exception v0

    .line 367
    .restart local v0    # "e":Landroid/database/SQLException;
    const-string v1, "FeedsDB- onUpgrade():"

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto/16 :goto_0
.end method

.method protected openConnection()V
    .locals 1

    .prologue
    .line 466
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    .line 467
    return-void
.end method

.method public releaseMemory()V
    .locals 1

    .prologue
    .line 490
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 491
    invoke-static {}, Landroid/database/sqlite/SQLiteDatabase;->releaseMemory()I

    .line 492
    :cond_0
    return-void
.end method

.method protected tempUpdateExpTimeForEvents(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)V
    .locals 10
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "where"    # Ljava/lang/String;
    .param p3, "whereArg"    # [Ljava/lang/String;
    .param p4, "values"    # Landroid/content/ContentValues;

    .prologue
    const/4 v9, 0x1

    .line 701
    if-nez p4, :cond_0

    .line 702
    :try_start_0
    new-instance v8, Landroid/content/ContentValues;

    invoke-direct {v8}, Landroid/content/ContentValues;-><init>()V

    .end local p4    # "values":Landroid/content/ContentValues;
    .local v8, "values":Landroid/content/ContentValues;
    move-object p4, v8

    .line 704
    .end local v8    # "values":Landroid/content/ContentValues;
    .restart local p4    # "values":Landroid/content/ContentValues;
    :cond_0
    const-string v0, "ttl"

    const/16 v1, 0x3c

    invoke-static {v1}, Lcom/espn/androidplayersdk/utilities/Utils;->getExpiryTime(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p4, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 706
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v0

    if-nez v0, :cond_1

    .line 707
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 708
    :cond_1
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v5, 0x1

    move-object v1, p1

    move-object v2, p4

    move-object v3, p2

    move-object v4, p3

    invoke-virtual/range {v0 .. v5}, Landroid/database/sqlite/SQLiteDatabase;->updateWithOnConflict(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)I

    move-result v7

    .line 709
    .local v7, "update":I
    if-ge v7, v9, :cond_2

    .line 710
    const-string v0, "eventRelationId"

    const/4 v1, 0x0

    aget-object v1, p3, v1

    invoke-virtual {p4, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 712
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, p1, v1, p4, v2}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 718
    .end local v7    # "update":I
    :cond_2
    :goto_0
    return-void

    .line 715
    :catch_0
    move-exception v6

    .line 716
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error"

    const/4 v1, 0x5

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method protected varargs tempUpdateExpTimeForMisc(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V
    .locals 9
    .param p1, "tableName"    # Ljava/lang/String;
    .param p2, "where"    # Ljava/lang/String;
    .param p3, "whereArg"    # [Ljava/lang/String;
    .param p4, "columnNames"    # [Ljava/lang/String;

    .prologue
    const/4 v8, 0x1

    .line 732
    :try_start_0
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 733
    .local v2, "values":Landroid/content/ContentValues;
    const/4 v0, 0x0

    aget-object v0, p4, v0

    const/16 v1, 0x3c

    invoke-static {v1}, Lcom/espn/androidplayersdk/utilities/Utils;->getExpiryTime(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 734
    array-length v0, p4

    if-le v0, v8, :cond_0

    .line 735
    const/4 v0, 0x1

    aget-object v0, p4, v0

    const/4 v1, 0x0

    aget-object v1, p3, v1

    invoke-virtual {v2, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 737
    :cond_0
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->isConnectionOpen()Z

    move-result v0

    if-nez v0, :cond_1

    .line 738
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->openConnection()V

    .line 739
    :cond_1
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v5, 0x1

    move-object v1, p1

    move-object v3, p2

    move-object v4, p3

    invoke-virtual/range {v0 .. v5}, Landroid/database/sqlite/SQLiteDatabase;->updateWithOnConflict(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)I

    move-result v7

    .line 740
    .local v7, "update":I
    if-ge v7, v8, :cond_2

    .line 741
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->db:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v1, 0x0

    const/4 v3, 0x1

    invoke-virtual {v0, p1, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 746
    .end local v2    # "values":Landroid/content/ContentValues;
    .end local v7    # "update":I
    :cond_2
    :goto_0
    return-void

    .line 743
    :catch_0
    move-exception v6

    .line 744
    .local v6, "e":Ljava/lang/Exception;
    const-string v0, "Error"

    const/4 v1, 0x5

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method upgradeV1toV2(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 373
    const/4 v0, 0x0

    .line 374
    .local v0, "sql":Ljava/lang/String;
    const-string v0, "ALTER TABLE events Add programingCode text"

    .line 375
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 376
    const-string v0, "ALTER TABLE events Add sportCode text"

    .line 377
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 378
    const-string v0, "ALTER TABLE featuredEvents Add programingCode text"

    .line 379
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 380
    const-string v0, "ALTER TABLE featuredEvents Add sportCode text"

    .line 381
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 382
    return-void
.end method

.method upgradeV2toV3(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 4
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 385
    const/4 v0, 0x0

    .line 386
    .local v0, "sql":Ljava/lang/String;
    const-string v0, "CREATE TABLE IF NOT EXISTS featuredCategories(_id integer PRIMARY KEY AUTOINCREMENT,categoryId text,name text,abbre text,shortName text,type text,imageUrl text,vodUrl text,listingUrl text )"

    .line 390
    const-string v1, "FeedsDB- onUpgrade(): FeaturedCategoryEvents"

    const/4 v2, 0x2

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 391
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 392
    return-void
.end method

.method upgradeV3toV4(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 395
    const/4 v0, 0x0

    .line 396
    .local v0, "sql":Ljava/lang/String;
    const-string v0, "ALTER TABLE sport Add sportLeagueId text"

    .line 397
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 398
    const-string v0, "ALTER TABLE sport Add sportListingUrl text"

    .line 399
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 400
    const-string v0, "ALTER TABLE sport Add sportShortName text"

    .line 401
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 402
    const-string v0, "ALTER TABLE sport Add sportType text"

    .line 403
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 404
    const-string v0, "ALTER TABLE sport Add sportVodUrl text"

    .line 405
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 406
    const-string v0, "ALTER TABLE sport Add sportMetaSportRelation text"

    .line 407
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 408
    const-string v0, "ALTER TABLE metaSport Add sportrelationId text"

    .line 409
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 410
    return-void
.end method

.method upgradeV4toV5(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 413
    const/4 v0, 0x0

    .line 414
    .local v0, "sql":Ljava/lang/String;
    const-string v0, "ALTER TABLE events Add coverageType text"

    .line 415
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 416
    const-string v0, "ALTER TABLE featuredEvents Add coverageType text"

    .line 417
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 419
    return-void
.end method

.method upgradeV5toV6(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 422
    const/4 v0, 0x0

    .line 423
    .local v0, "sql":Ljava/lang/String;
    const-string v0, "ALTER TABLE sport Add sportListingtop text"

    .line 424
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 425
    return-void
.end method

.method upgradeV6toV7(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 428
    const/4 v0, 0x0

    .line 429
    .local v0, "sql":Ljava/lang/String;
    const-string v0, "ALTER TABLE events Add videoURLHD text"

    .line 430
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 431
    const-string v0, "ALTER TABLE featuredEvents Add videoURLHD text"

    .line 432
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 433
    return-void
.end method

.method upgradeV7toV8(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 436
    const/4 v0, 0x0

    .line 437
    .local v0, "sql":Ljava/lang/String;
    const-string v0, "ALTER TABLE events Add videoURLDefault text"

    .line 438
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 439
    const-string v0, "ALTER TABLE featuredEvents Add videoURLDefault text"

    .line 440
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 441
    return-void
.end method

.method upgradeV8toV9(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 444
    const/4 v0, 0x0

    .line 445
    .local v0, "sql":Ljava/lang/String;
    const-string v0, "ALTER TABLE channel Add resourceId text"

    .line 446
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 447
    const-string v0, "ALTER TABLE events Add networkResourceId text"

    .line 448
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 449
    const-string v0, "ALTER TABLE featuredEvents Add networkResourceId text"

    .line 450
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 451
    return-void
.end method
