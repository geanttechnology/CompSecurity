.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;

.field final synthetic val$dbPid:Ljava/lang/String;

.field final synthetic val$i1:I


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 369
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;->val$ctx:Landroid/content/Context;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;->val$dbPid:Ljava/lang/String;

    iput p4, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;->val$i1:I

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onSuccess(Ljava/lang/String;)V
    .locals 14

    .prologue
    const/4 v13, 0x4

    const/4 v10, 0x0

    const/4 v6, 0x3

    .line 372
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 373
    const-string v0, ""

    .line 375
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 376
    const-string v2, "mChangePlaylist"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    move-object v8, v0

    .line 381
    :goto_0
    const-string v9, ""

    .line 382
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;->val$ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;->val$dbPid:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getSong(Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 383
    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v12

    .line 384
    invoke-interface {v11}, Landroid/database/Cursor;->moveToFirst()Z

    move v5, v10

    .line 385
    :goto_1
    if-ge v5, v12, :cond_1

    .line 386
    const/4 v0, 0x6

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v6, :cond_0

    .line 387
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    const-string v1, ""

    const/4 v2, 0x2

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v11, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v11, v13}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    const/4 v7, 0x7

    invoke-interface {v11, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct/range {v0 .. v7}, Lcom/mixerbox/mixerbox3b/classes/SongItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    .line 389
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;->val$ctx:Landroid/content/Context;

    const-string v2, ""

    invoke-static {v1, v8, v0, v10, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addSong(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;ZLjava/lang/String;)V

    move-object v0, v9

    .line 393
    :goto_2
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z

    .line 385
    add-int/lit8 v5, v5, 0x1

    move-object v9, v0

    goto :goto_1

    .line 377
    :catch_0
    move-exception v1

    .line 378
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    move-object v8, v0

    goto :goto_0

    .line 391
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&list%5B"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "%5D="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-interface {v11, v13}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_2

    .line 395
    :cond_1
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 398
    iget v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;->val$i1:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 399
    invoke-static {v8, v9}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getBatchAddUrl(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 400
    const/4 v2, 0x0

    new-instance v3, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6$1;

    invoke-direct {v3, p0, v8, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6$1;-><init>(Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;Ljava/lang/String;I)V

    invoke-static {v1, v2, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 416
    return-void
.end method
