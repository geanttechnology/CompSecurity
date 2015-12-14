.class public Lcom/livemixtapes/MusicRetriever;
.super Ljava/lang/Object;
.source "MusicRetriever.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/MusicRetriever$Item;
    }
.end annotation


# instance fields
.field final TAG:Ljava/lang/String;

.field mContentResolver:Landroid/content/ContentResolver;

.field mItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/livemixtapes/MusicRetriever$Item;",
            ">;"
        }
    .end annotation
.end field

.field mRandom:Ljava/util/Random;


# direct methods
.method public constructor <init>(Landroid/content/ContentResolver;)V
    .locals 1
    .param p1, "cr"    # Landroid/content/ContentResolver;

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const-string v0, "MusicRetriever"

    iput-object v0, p0, Lcom/livemixtapes/MusicRetriever;->TAG:Ljava/lang/String;

    .line 40
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/MusicRetriever;->mItems:Ljava/util/List;

    .line 41
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/MusicRetriever;->mRandom:Ljava/util/Random;

    .line 43
    iput-object p1, p0, Lcom/livemixtapes/MusicRetriever;->mContentResolver:Landroid/content/ContentResolver;

    .line 44
    return-void
.end method


# virtual methods
.method public getContentResolver()Landroid/content/ContentResolver;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/livemixtapes/MusicRetriever;->mContentResolver:Landroid/content/ContentResolver;

    return-object v0
.end method

.method public getRandomItem()Lcom/livemixtapes/MusicRetriever$Item;
    .locals 3

    .prologue
    .line 94
    iget-object v0, p0, Lcom/livemixtapes/MusicRetriever;->mItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-gtz v0, :cond_0

    const/4 v0, 0x0

    .line 95
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/MusicRetriever;->mItems:Ljava/util/List;

    iget-object v1, p0, Lcom/livemixtapes/MusicRetriever;->mRandom:Ljava/util/Random;

    iget-object v2, p0, Lcom/livemixtapes/MusicRetriever;->mItems:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/util/Random;->nextInt(I)I

    move-result v1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/MusicRetriever$Item;

    goto :goto_0
.end method

.method public prepare()V
    .locals 17

    .prologue
    .line 50
    sget-object v2, Landroid/provider/MediaStore$Audio$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    .line 51
    .local v2, "uri":Landroid/net/Uri;
    const-string v1, "MusicRetriever"

    const-string v3, "Querying media..."

    invoke-static {v1, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 52
    const-string v1, "MusicRetriever"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "URI: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 55
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/livemixtapes/MusicRetriever;->mContentResolver:Landroid/content/ContentResolver;

    const/4 v3, 0x0

    .line 56
    const-string v4, "is_music = 1"

    const/4 v5, 0x0

    const/4 v6, 0x0

    .line 55
    invoke-virtual/range {v1 .. v6}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v13

    .line 57
    .local v13, "cur":Landroid/database/Cursor;
    const-string v3, "MusicRetriever"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v1, "Query finished. "

    invoke-direct {v4, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    if-nez v13, :cond_0

    const-string v1, "Returned NULL."

    :goto_0
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 58
    if-nez v13, :cond_1

    .line 60
    const-string v1, "MusicRetriever"

    const-string v3, "Failed to retrieve music: cursor is null :-("

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 88
    :goto_1
    return-void

    .line 57
    :cond_0
    const-string v1, "Returned a cursor."

    goto :goto_0

    .line 63
    :cond_1
    invoke-interface {v13}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-nez v1, :cond_2

    .line 65
    const-string v1, "MusicRetriever"

    const-string v3, "Failed to move cursor to first row (no query results)."

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 68
    :cond_2
    const-string v1, "MusicRetriever"

    const-string v3, "Listing..."

    invoke-static {v1, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 70
    const-string v1, "artist"

    invoke-interface {v13, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v12

    .line 71
    .local v12, "artistColumn":I
    const-string v1, "title"

    invoke-interface {v13, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v16

    .line 72
    .local v16, "titleColumn":I
    const-string v1, "album"

    invoke-interface {v13, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v11

    .line 73
    .local v11, "albumColumn":I
    const-string v1, "duration"

    invoke-interface {v13, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v14

    .line 74
    .local v14, "durationColumn":I
    const-string v1, "_id"

    invoke-interface {v13, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v15

    .line 75
    .local v15, "idColumn":I
    const-string v1, "MusicRetriever"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Title column index: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 76
    const-string v1, "MusicRetriever"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "ID column index: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 79
    :cond_3
    const-string v1, "MusicRetriever"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "ID: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v13, v15}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " Title: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v0, v16

    invoke-interface {v13, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 80
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/livemixtapes/MusicRetriever;->mItems:Ljava/util/List;

    new-instance v3, Lcom/livemixtapes/MusicRetriever$Item;

    .line 81
    invoke-interface {v13, v15}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    .line 82
    invoke-interface {v13, v12}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 83
    move/from16 v0, v16

    invoke-interface {v13, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 84
    invoke-interface {v13, v11}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 85
    invoke-interface {v13, v14}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v9

    invoke-direct/range {v3 .. v10}, Lcom/livemixtapes/MusicRetriever$Item;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V

    .line 80
    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 86
    invoke-interface {v13}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-nez v1, :cond_3

    .line 87
    const-string v1, "MusicRetriever"

    const-string v3, "Done querying media. MusicRetriever is ready."

    invoke-static {v1, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_1
.end method
