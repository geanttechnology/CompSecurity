.class Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;
.super Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
.source "DefaultVideoBookmarkDAO.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SQLiteBookmark"
.end annotation


# instance fields
.field private dbId:J

.field final synthetic this$0:Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;

.field private userKey:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;Landroid/database/Cursor;)V
    .locals 10
    .param p2, "cursor"    # Landroid/database/Cursor;

    .prologue
    const-wide/16 v8, 0x0

    .line 449
    iput-object p1, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->this$0:Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;

    .line 450
    invoke-direct {p0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;-><init>()V

    .line 442
    const-wide/16 v6, -0x1

    iput-wide v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->dbId:J

    .line 443
    const/4 v6, 0x0

    iput-object v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->userKey:Ljava/lang/String;

    .line 451
    const-string v6, "_id"

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    iput-wide v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->dbId:J

    .line 452
    const-string v6, "user_key"

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->userKey:Ljava/lang/String;

    .line 453
    const-string v6, "parent_merlin_id"

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 454
    .local v3, "parentMerlinIdString":Ljava/lang/String;
    if-eqz v3, :cond_0

    .line 455
    new-instance v6, Lcom/xfinity/playerlib/model/MerlinId;

    invoke-direct {v6, v3}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Ljava/lang/String;)V

    iput-object v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 457
    :cond_0
    const-string v6, "merlin_id"

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 458
    .local v2, "merlinIdString":Ljava/lang/String;
    if-eqz v2, :cond_1

    .line 459
    new-instance v6, Lcom/xfinity/playerlib/model/MerlinId;

    const-string v7, "merlin_id"

    invoke-interface {p2, v7}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    invoke-interface {p2, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Ljava/lang/String;)V

    iput-object v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 461
    :cond_1
    const-string v6, "video_id"

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    iput-wide v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->videoId:J

    .line 462
    const-string v6, "title"

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->title:Ljava/lang/String;

    .line 463
    const-string v6, "position"

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    iput v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->position:I

    .line 464
    const-string v6, "duration"

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    iput v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->duration:I

    .line 465
    const-string v6, "network_id"

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    iput-wide v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->networkId:J

    .line 466
    const-string v6, "company_id"

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    iput-wide v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->companyId:J

    .line 467
    const-string v6, "season_info"

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    iput v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->seasonNumber:I

    .line 468
    const-string v6, "episode_info"

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    iput v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->episodeNumber:I

    .line 469
    const-string v6, "last_tracked_milestone"

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    invoke-static {v6}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->fromInt(I)Lcom/xfinity/playerlib/tracking/VideoMilestone;

    move-result-object v6

    iput-object v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->lastTrackedMilestone:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .line 472
    iget-wide v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->dbId:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    # invokes: Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->getCategoriesForBookmark(Ljava/lang/Long;)Ljava/util/List;
    invoke-static {p1, v6}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->access$000(Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;Ljava/lang/Long;)Ljava/util/List;

    move-result-object v1

    .line 473
    .local v1, "cats":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;

    .line 474
    .local v0, "cat":Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->addCategory(Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;)V

    goto :goto_0

    .line 477
    .end local v0    # "cat":Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;
    :cond_2
    :try_start_0
    const-string v6, "expiration_date"

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    .line 478
    .local v4, "millis":J
    cmp-long v6, v4, v8

    if-lez v6, :cond_3

    .line 479
    new-instance v6, Ljava/util/Date;

    invoke-direct {v6, v4, v5}, Ljava/util/Date;-><init>(J)V

    iput-object v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->expirationDate:Ljava/util/Date;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 484
    .end local v4    # "millis":J
    :cond_3
    :goto_1
    const-string v6, "timestamp"

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {p2, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    .line 485
    .restart local v4    # "millis":J
    cmp-long v6, v4, v8

    if-lez v6, :cond_4

    .line 486
    new-instance v6, Ljava/util/Date;

    invoke-direct {v6, v4, v5}, Ljava/util/Date;-><init>(J)V

    iput-object v6, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->timestamp:Ljava/util/Date;

    .line 488
    :cond_4
    return-void

    .line 481
    .end local v4    # "millis":J
    :catch_0
    move-exception v6

    goto :goto_1
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 6
    .param p2, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p3, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 490
    iput-object p1, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->this$0:Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;

    .line 492
    invoke-direct {p0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;-><init>()V

    .line 442
    const-wide/16 v2, -0x1

    iput-wide v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->dbId:J

    .line 443
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->userKey:Ljava/lang/String;

    .line 494
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->getUserKey()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->userKey:Ljava/lang/String;

    .line 495
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProgramId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 496
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 497
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->videoId:J

    .line 498
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->companyId:J

    .line 499
    invoke-interface {p3}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getTitle()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->title:Ljava/lang/String;

    .line 500
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getExpirationDate()Ljava/util/Date;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->expirationDate:Ljava/util/Date;

    .line 501
    # getter for: Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->videoTracker:Lcom/xfinity/playerlib/view/videoplay/VideoTracker;
    invoke-static {p1}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;->access$100(Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;)Lcom/xfinity/playerlib/view/videoplay/VideoTracker;

    move-result-object v2

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lcom/xfinity/playerlib/view/videoplay/VideoTracker;->getPosition(J)I

    move-result v0

    .line 502
    .local v0, "pos":I
    iput v0, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->position:I

    .line 503
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDurationInSeconds()I

    move-result v2

    mul-int/lit16 v2, v2, 0x3e8

    iput v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->duration:I

    .line 504
    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    iput-object v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->timestamp:Ljava/util/Date;

    .line 505
    sget-object v2, Lcom/xfinity/playerlib/tracking/VideoMilestone;->NOT_STARTED:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    iput-object v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->lastTrackedMilestone:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .line 507
    sget-object v2, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;->CATEGORY_RESUMEPOINT:Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;

    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->addCategory(Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;)V

    .line 509
    invoke-interface {p3}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSeriesInfoIfApplicable()Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;

    move-result-object v1

    .line 510
    .local v1, "seriesInfo":Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;
    if-eqz v1, :cond_0

    .line 512
    invoke-interface {v1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    :goto_0
    iput v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->seasonNumber:I

    .line 513
    invoke-interface {v1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v2

    if-eqz v2, :cond_2

    invoke-interface {v1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    :goto_1
    iput v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->episodeNumber:I

    .line 515
    :cond_0
    return-void

    .line 512
    :cond_1
    iget v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->seasonNumber:I

    goto :goto_0

    .line 513
    :cond_2
    iget v2, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->episodeNumber:I

    goto :goto_1
.end method


# virtual methods
.method public getDbId()J
    .locals 2

    .prologue
    .line 522
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->dbId:J

    return-wide v0
.end method

.method public getUserKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 526
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->userKey:Ljava/lang/String;

    return-object v0
.end method

.method public setDbId(J)V
    .locals 1
    .param p1, "id"    # J

    .prologue
    .line 518
    iput-wide p1, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->dbId:J

    .line 519
    return-void
.end method

.method public setUserKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "userKey"    # Ljava/lang/String;

    .prologue
    .line 530
    iput-object p1, p0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO$SQLiteBookmark;->userKey:Ljava/lang/String;

    .line 531
    return-void
.end method
