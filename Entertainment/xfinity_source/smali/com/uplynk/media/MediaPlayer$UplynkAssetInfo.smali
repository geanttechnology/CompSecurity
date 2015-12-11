.class public Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
.super Ljava/lang/Object;
.source "MediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "UplynkAssetInfo"
.end annotation


# instance fields
.field protected _assetID:Ljava/lang/String;

.field protected _audioOnly:Z

.field protected _desc:Ljava/lang/String;

.field protected _duration:D

.field protected _error:I

.field protected _isAd:Z

.field protected _isValid:Z

.field protected _maxSlice:I

.field protected _movieRating:I

.field protected _owner:Ljava/lang/String;

.field protected _ratingFlags:I

.field protected _sliceDuration:D

.field protected _thumbnailPrefix:Ljava/lang/String;

.field protected _tvRating:I

.field final synthetic this$0:Lcom/uplynk/media/MediaPlayer;


# direct methods
.method public constructor <init>(Lcom/uplynk/media/MediaPlayer;Ljava/lang/String;)V
    .locals 6
    .param p2, "jsonString"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 1196
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->this$0:Lcom/uplynk/media/MediaPlayer;

    .line 1195
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1162
    iput-boolean v3, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_isValid:Z

    .line 1199
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 1202
    .local v1, "json":Lorg/json/JSONObject;
    if-eqz v1, :cond_d

    .line 1204
    const-string v4, "asset"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1205
    const-string v4, "asset"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_assetID:Ljava/lang/String;

    .line 1206
    :cond_0
    const-string v4, "error"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1207
    const-string v4, "error"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v4

    iput v4, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_error:I

    .line 1209
    :cond_1
    iget v4, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_error:I

    if-nez v4, :cond_c

    .line 1211
    const-string v4, "audio_only"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 1212
    const-string v4, "audio_only"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v4

    if-ne v4, v2, :cond_e

    move v4, v2

    :goto_0
    iput-boolean v4, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_audioOnly:Z

    .line 1213
    :cond_2
    const-string v4, "duration"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 1214
    const-string v4, "duration"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_duration:D

    .line 1215
    :cond_3
    const-string v4, "max_slice"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 1216
    const-string v4, "max_slice"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v4

    iput v4, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_maxSlice:I

    .line 1217
    :cond_4
    const-string v4, "slice_dur"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 1218
    const-string v4, "slice_dur"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_sliceDuration:D

    .line 1220
    :cond_5
    const-string v4, "owner"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 1221
    const-string v4, "owner"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_owner:Ljava/lang/String;

    .line 1222
    :cond_6
    const-string v4, "thumb_prefix"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 1223
    const-string v4, "thumb_prefix"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_thumbnailPrefix:Ljava/lang/String;

    .line 1224
    :cond_7
    const-string v4, "desc"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_8

    .line 1225
    const-string v4, "desc"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_desc:Ljava/lang/String;

    .line 1226
    :cond_8
    const-string v4, "is_ad"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_9

    .line 1227
    const-string v4, "is_ad"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v4

    if-ne v4, v2, :cond_f

    :goto_1
    iput-boolean v2, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_isAd:Z

    .line 1229
    :cond_9
    const-string v2, "tv_rating"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 1230
    const-string v2, "tv_rating"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v2

    iput v2, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_tvRating:I

    .line 1231
    :cond_a
    const-string v2, "movie_rating"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 1232
    const-string v2, "movie_rating"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v2

    iput v2, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_movieRating:I

    .line 1233
    :cond_b
    const-string v2, "rating_flags"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_c

    .line 1234
    const-string v2, "rating_flags"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v2

    iput v2, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_ratingFlags:I

    .line 1237
    :cond_c
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_isValid:Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1245
    .end local v1    # "json":Lorg/json/JSONObject;
    :cond_d
    :goto_2
    return-void

    .restart local v1    # "json":Lorg/json/JSONObject;
    :cond_e
    move v4, v3

    .line 1212
    goto/16 :goto_0

    :cond_f
    move v2, v3

    .line 1227
    goto :goto_1

    .line 1240
    .end local v1    # "json":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 1242
    .local v0, "e":Lorg/json/JSONException;
    const-string v2, "upLynkMediaPlayer"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "AssetInfo Error: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lorg/json/JSONException;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2
.end method


# virtual methods
.method public getAssetID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1177
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_assetID:Ljava/lang/String;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1179
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_desc:Ljava/lang/String;

    return-object v0
.end method

.method public getDuration()D
    .locals 2

    .prologue
    .line 1190
    iget-wide v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_duration:D

    return-wide v0
.end method

.method public getMaxSlice()I
    .locals 1

    .prologue
    .line 1189
    iget v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_maxSlice:I

    return v0
.end method

.method public getMovieRating()I
    .locals 1

    .prologue
    .line 1186
    iget v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_movieRating:I

    return v0
.end method

.method public getOwner()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1178
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_owner:Ljava/lang/String;

    return-object v0
.end method

.method public getRatingFlags()I
    .locals 1

    .prologue
    .line 1187
    iget v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_ratingFlags:I

    return v0
.end method

.method public getSliceDuration()D
    .locals 2

    .prologue
    .line 1191
    iget-wide v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_sliceDuration:D

    return-wide v0
.end method

.method public getThumbnailPrefix()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1193
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_thumbnailPrefix:Ljava/lang/String;

    return-object v0
.end method

.method public getTvRating()I
    .locals 1

    .prologue
    .line 1185
    iget v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_tvRating:I

    return v0
.end method

.method public hasError()Z
    .locals 1

    .prologue
    .line 1183
    iget v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_error:I

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isAd()Z
    .locals 1

    .prologue
    .line 1182
    iget-boolean v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_isAd:Z

    return v0
.end method

.method public isAudioOnly()Z
    .locals 1

    .prologue
    .line 1181
    iget-boolean v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_audioOnly:Z

    return v0
.end method
