.class Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;
.super Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
.source "DefaultLiveStreamBookmarkDAO.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SQLiteBookmark"
.end annotation


# instance fields
.field private dbId:J

.field final synthetic this$0:Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;

.field private userKey:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;Landroid/database/Cursor;)V
    .locals 12
    .param p2, "cursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    const-wide/16 v10, 0x0

    .line 385
    iput-object p1, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->this$0:Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;

    .line 386
    invoke-direct {p0}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;-><init>()V

    .line 382
    const-wide/16 v8, -0x1

    iput-wide v8, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->dbId:J

    .line 383
    const/4 v4, 0x0

    iput-object v4, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->userKey:Ljava/lang/String;

    .line 387
    const-string v4, "_id"

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    iput-wide v8, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->dbId:J

    .line 388
    const-string v4, "user_key"

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->userKey:Ljava/lang/String;

    .line 389
    const-string v4, "stream_id"

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->streamId:Ljava/lang/String;

    .line 390
    const-string v4, "artwork_url"

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->artworkUrl:Ljava/lang/String;

    .line 391
    const-string v4, "title"

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->title:Ljava/lang/String;

    .line 392
    const-string v4, "position"

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    iput v4, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->position:I

    .line 393
    const-string v4, "duration"

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    iput v4, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->duration:I

    .line 394
    const-string v4, "network_id"

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    int-to-long v8, v4

    iput-wide v8, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->companyId:J

    .line 395
    const-string v4, "is_adult_content"

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    if-lez v4, :cond_3

    move v4, v5

    :goto_0
    iput-boolean v4, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->isAdultContent:Z

    .line 396
    const-string v4, "is_favorite"

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    if-lez v4, :cond_4

    :goto_1
    iput-boolean v5, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->isFavorite:Z

    .line 399
    :try_start_0
    const-string v4, "expiration_date"

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    .line 400
    .local v2, "millis":J
    cmp-long v4, v2, v10

    if-lez v4, :cond_0

    .line 401
    new-instance v4, Ljava/util/Date;

    invoke-direct {v4, v2, v3}, Ljava/util/Date;-><init>(J)V

    iput-object v4, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->expirationDate:Ljava/util/Date;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 406
    .end local v2    # "millis":J
    :cond_0
    :goto_2
    const-string v4, "timestamp"

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    .line 407
    .restart local v2    # "millis":J
    cmp-long v4, v2, v10

    if-lez v4, :cond_1

    .line 408
    new-instance v4, Ljava/util/Date;

    invoke-direct {v4, v2, v3}, Ljava/util/Date;-><init>(J)V

    iput-object v4, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->timestamp:Ljava/util/Date;

    .line 411
    :cond_1
    const-string v4, "created"

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    invoke-interface {p2, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    .line 412
    .local v0, "created":J
    cmp-long v4, v0, v10

    if-lez v4, :cond_2

    .line 413
    new-instance v4, Ljava/util/Date;

    invoke-direct {v4, v0, v1}, Ljava/util/Date;-><init>(J)V

    iput-object v4, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->createdTime:Ljava/util/Date;

    .line 416
    :cond_2
    return-void

    .end local v0    # "created":J
    .end local v2    # "millis":J
    :cond_3
    move v4, v6

    .line 395
    goto :goto_0

    :cond_4
    move v5, v6

    .line 396
    goto :goto_1

    .line 403
    :catch_0
    move-exception v4

    goto :goto_2
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 2
    .param p2, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 418
    iput-object p1, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->this$0:Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;

    .line 419
    invoke-direct {p0}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;-><init>()V

    .line 382
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->dbId:J

    .line 383
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->userKey:Ljava/lang/String;

    .line 421
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->getUserKey()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->userKey:Ljava/lang/String;

    .line 422
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->streamId:Ljava/lang/String;

    .line 423
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getArtworkLink()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->artworkUrl:Ljava/lang/String;

    .line 424
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getTitle()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->title:Ljava/lang/String;

    .line 425
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->isAdultContent()Z

    move-result v0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->isAdultContent:Z

    .line 426
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->createdTime:Ljava/util/Date;

    .line 427
    return-void
.end method


# virtual methods
.method public getDbId()J
    .locals 2

    .prologue
    .line 434
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->dbId:J

    return-wide v0
.end method

.method public getUserKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 438
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->userKey:Ljava/lang/String;

    return-object v0
.end method

.method public setDbId(J)V
    .locals 1
    .param p1, "id"    # J

    .prologue
    .line 430
    iput-wide p1, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->dbId:J

    .line 431
    return-void
.end method

.method public setUserKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "userKey"    # Ljava/lang/String;

    .prologue
    .line 442
    iput-object p1, p0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO$SQLiteBookmark;->userKey:Ljava/lang/String;

    .line 443
    return-void
.end method
