.class public Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;
.super Landroid/support/v4/app/Fragment;
.source "SourceFile"


# instance fields
.field arrayAlbum:Ljava/util/ArrayList;

.field arrayArtist:Ljava/util/ArrayList;

.field arrayPlaylist:Ljava/util/ArrayList;

.field arraySong:Ljava/util/ArrayList;

.field public lvAlbum:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

.field public lvArtist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

.field public lvPlaylist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

.field public lvSong:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

.field public q:Ljava/lang/String;

.field tabAlbums:Landroid/widget/TabHost$TabSpec;

.field tabArtists:Landroid/widget/TabHost$TabSpec;

.field public tabHost:Landroid/widget/TabHost;

.field tabPlaylists:Landroid/widget/TabHost$TabSpec;

.field tabSongs:Landroid/widget/TabHost$TabSpec;

.field v:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    return-void
.end method

.method private getCoverOfArtist(Ljava/lang/String;)Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v3, 0x0

    const/4 v6, 0x0

    .line 256
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 258
    const/4 v1, 0x1

    new-array v2, v1, [Ljava/lang/String;

    const-string v1, "album_art"

    aput-object v1, v2, v6

    .line 261
    const-string v1, "external"

    invoke-static {p1}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v1, v4, v5}, Landroid/provider/MediaStore$Audio$Artists$Albums;->getContentUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v1

    move-object v4, v3

    move-object v5, v3

    .line 262
    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 263
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v2

    .line 264
    if-lez v2, :cond_1

    .line 265
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move v0, v6

    .line 266
    :goto_0
    if-ge v0, v2, :cond_1

    .line 267
    invoke-interface {v1, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 268
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "file://"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-interface {v1, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 269
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 276
    :goto_1
    return-object v0

    .line 272
    :cond_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    .line 266
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 275
    :cond_1
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 276
    const-string v0, ""

    goto :goto_1
.end method

.method private getCoverOfPlaylist(Ljava/lang/String;)Ljava/lang/String;
    .locals 8

    .prologue
    const/4 v6, 0x0

    const/4 v7, 0x0

    .line 197
    const-string v3, "is_music != 0 "

    .line 198
    const-string v0, "external"

    invoke-static {p1}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    invoke-static {v0, v1, v2}, Landroid/provider/MediaStore$Audio$Playlists$Members;->getContentUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v1

    .line 202
    const/4 v0, 0x1

    :try_start_0
    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v4, "album_id"

    aput-object v4, v2, v0

    .line 205
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 206
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v3

    .line 207
    if-lez v3, :cond_2

    .line 208
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move v2, v7

    .line 209
    :goto_0
    if-ge v2, v3, :cond_2

    .line 210
    const-string v0, "content://media/external/audio/albumart"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 211
    const/4 v4, 0x0

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {v0, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v4

    .line 212
    invoke-virtual {v4}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    .line 213
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-virtual {v5}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    const-string v6, "r"

    invoke-virtual {v5, v4, v6}, Landroid/content/ContentResolver;->openFileDescriptor(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;

    move-result-object v4

    .line 214
    if-eqz v4, :cond_1

    .line 215
    invoke-interface {v1}, Landroid/database/Cursor;->close()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 222
    if-eqz v1, :cond_0

    .line 223
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 227
    :cond_0
    :goto_1
    return-object v0

    .line 218
    :cond_1
    :try_start_2
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 209
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    .line 222
    :cond_2
    if-eqz v1, :cond_3

    .line 223
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 227
    :cond_3
    :goto_2
    const-string v0, ""

    goto :goto_1

    .line 222
    :catch_0
    move-exception v0

    move-object v0, v6

    :goto_3
    if-eqz v0, :cond_3

    .line 223
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_2

    .line 222
    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_4
    if-eqz v1, :cond_4

    .line 223
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 224
    :cond_4
    throw v0

    .line 222
    :catchall_1
    move-exception v0

    goto :goto_4

    :catch_1
    move-exception v0

    move-object v0, v1

    goto :goto_3
.end method

.method private loadAlbum()V
    .locals 14

    .prologue
    .line 280
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arrayAlbum:Ljava/util/ArrayList;

    .line 281
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 283
    const/4 v1, 0x5

    new-array v2, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v3, "_id"

    aput-object v3, v2, v1

    const/4 v1, 0x1

    const-string v3, "album"

    aput-object v3, v2, v1

    const/4 v1, 0x2

    const-string v3, "album_art"

    aput-object v3, v2, v1

    const/4 v1, 0x3

    const-string v3, "artist"

    aput-object v3, v2, v1

    const/4 v1, 0x4

    const-string v3, "numsongs"

    aput-object v3, v2, v1

    .line 290
    sget-object v1, Landroid/provider/MediaStore$Audio$Albums;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    .line 291
    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 292
    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v12

    .line 293
    if-lez v12, :cond_0

    .line 294
    invoke-interface {v11}, Landroid/database/Cursor;->moveToFirst()Z

    .line 295
    const/4 v0, 0x0

    move v10, v0

    :goto_0
    if-ge v10, v12, :cond_0

    .line 296
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "file://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/4 v1, 0x2

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 297
    iget-object v13, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arrayAlbum:Ljava/util/ArrayList;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v1, "PLAYLISTMP3ALBUMID"

    const/4 v2, 0x1

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v11, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x3

    invoke-interface {v11, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x4

    invoke-interface {v11, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    const-string v6, "0"

    const/16 v8, 0x8

    const/4 v9, 0x0

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    invoke-virtual {v13, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 298
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z

    .line 295
    add-int/lit8 v0, v10, 0x1

    move v10, v0

    goto :goto_0

    .line 301
    :cond_0
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 302
    new-instance v0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arrayAlbum:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;)V

    .line 303
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvAlbum:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v1, v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 304
    return-void
.end method

.method private loadArtist()V
    .locals 14

    .prologue
    .line 231
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arrayArtist:Ljava/util/ArrayList;

    .line 232
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 234
    const/4 v1, 0x3

    new-array v2, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v3, "_id"

    aput-object v3, v2, v1

    const/4 v1, 0x1

    const-string v3, "artist"

    aput-object v3, v2, v1

    const/4 v1, 0x2

    const-string v3, "number_of_tracks"

    aput-object v3, v2, v1

    .line 239
    sget-object v1, Landroid/provider/MediaStore$Audio$Artists;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    .line 240
    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 241
    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v12

    .line 242
    if-lez v12, :cond_0

    .line 243
    invoke-interface {v11}, Landroid/database/Cursor;->moveToFirst()Z

    .line 244
    const/4 v0, 0x0

    move v10, v0

    :goto_0
    if-ge v10, v12, :cond_0

    .line 245
    const/4 v0, 0x0

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getCoverOfArtist(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 246
    iget-object v13, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arrayArtist:Ljava/util/ArrayList;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v1, "PLAYLISTMP3ARTISTID"

    const/4 v2, 0x1

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v11, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    const-string v4, ""

    const/4 v5, 0x2

    invoke-interface {v11, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    const-string v6, "0"

    const/16 v8, 0x8

    const/4 v9, 0x0

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    invoke-virtual {v13, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 247
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z

    .line 244
    add-int/lit8 v0, v10, 0x1

    move v10, v0

    goto :goto_0

    .line 250
    :cond_0
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 251
    new-instance v0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arrayArtist:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;)V

    .line 252
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvArtist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v1, v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 253
    return-void
.end method

.method private loadPlaylist()V
    .locals 15

    .prologue
    const/4 v14, 0x1

    const/4 v3, 0x0

    const/4 v9, 0x0

    .line 171
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arrayPlaylist:Ljava/util/ArrayList;

    .line 172
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 174
    const/4 v1, 0x3

    new-array v2, v1, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v2, v9

    const-string v1, "name"

    aput-object v1, v2, v14

    const/4 v1, 0x2

    const-string v4, "_data"

    aput-object v4, v2, v1

    .line 179
    sget-object v1, Landroid/provider/MediaStore$Audio$Playlists;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    move-object v4, v3

    move-object v5, v3

    .line 180
    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 181
    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v12

    .line 182
    if-lez v12, :cond_0

    .line 183
    invoke-interface {v11}, Landroid/database/Cursor;->moveToFirst()Z

    move v10, v9

    .line 184
    :goto_0
    if-ge v10, v12, :cond_0

    .line 185
    invoke-interface {v11, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getCoverOfPlaylist(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 186
    iget-object v13, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arrayPlaylist:Ljava/util/ArrayList;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v1, "PLAYLISTMP3PLAYLISTID"

    invoke-interface {v11, v14}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v11, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    const-string v4, ""

    const-string v5, ""

    const-string v6, "0"

    const/16 v8, 0x8

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    invoke-virtual {v13, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 187
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z

    .line 184
    add-int/lit8 v0, v10, 0x1

    move v10, v0

    goto :goto_0

    .line 190
    :cond_0
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 191
    new-instance v0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arrayPlaylist:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;)V

    .line 192
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvPlaylist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v1, v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 193
    return-void
.end method

.method private loadSong()V
    .locals 11

    .prologue
    const/4 v6, 0x0

    const/4 v7, 0x0

    .line 307
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arraySong:Ljava/util/ArrayList;

    .line 310
    const/4 v0, 0x5

    :try_start_0
    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "album_id"

    aput-object v1, v2, v0

    const/4 v0, 0x1

    const-string v1, "title"

    aput-object v1, v2, v0

    const/4 v0, 0x2

    const-string v1, "duration"

    aput-object v1, v2, v0

    const/4 v0, 0x3

    const-string v1, "_data"

    aput-object v1, v2, v0

    const/4 v0, 0x4

    const-string v1, "artist"

    aput-object v1, v2, v0

    .line 317
    const-string v3, "is_music != 0"

    .line 318
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Landroid/provider/MediaStore$Audio$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v8

    .line 319
    :try_start_1
    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v9

    .line 320
    if-lez v9, :cond_0

    .line 321
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move v5, v7

    .line 322
    :goto_0
    if-ge v5, v9, :cond_0

    .line 323
    iget-object v10, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arraySong:Ljava/util/ArrayList;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    const/4 v1, 0x0

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v3, 0x4

    invoke-interface {v8, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/4 v3, 0x1

    invoke-interface {v8, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x2

    invoke-interface {v8, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    div-int/lit16 v3, v3, 0x3e8

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x3

    invoke-interface {v8, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    const/4 v6, 0x2

    const-string v7, ""

    invoke-direct/range {v0 .. v7}, Lcom/mixerbox/mixerbox3b/classes/SongItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    invoke-virtual {v10, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 325
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 322
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 329
    :cond_0
    if-eqz v8, :cond_1

    .line 330
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 334
    :cond_1
    :goto_1
    new-instance v0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arraySong:Ljava/util/ArrayList;

    const-string v3, "PLAYLISTMP3ID"

    invoke-direct {v0, v1, v2, v3}, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)V

    .line 335
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvSong:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v1, v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 336
    return-void

    .line 329
    :catch_0
    move-exception v0

    move-object v0, v6

    :goto_2
    if-eqz v0, :cond_1

    .line 330
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 329
    :catchall_0
    move-exception v0

    move-object v8, v6

    :goto_3
    if-eqz v8, :cond_2

    .line 330
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 331
    :cond_2
    throw v0

    .line 329
    :catchall_1
    move-exception v0

    goto :goto_3

    :catch_1
    move-exception v0

    move-object v0, v8

    goto :goto_2
.end method


# virtual methods
.method public loadContent()V
    .locals 2

    .prologue
    .line 151
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->loadPlaylist()V

    .line 152
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->loadArtist()V

    .line 153
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->loadAlbum()V

    .line 154
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->loadSong()V

    .line 155
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arrayPlaylist:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 156
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arrayAlbum:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_2

    .line 157
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->arrayArtist:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_1

    .line 158
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->tabHost:Landroid/widget/TabHost;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/widget/TabHost;->setCurrentTab(I)V

    .line 168
    :cond_0
    :goto_0
    return-void

    .line 161
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->tabHost:Landroid/widget/TabHost;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/widget/TabHost;->setCurrentTab(I)V

    goto :goto_0

    .line 165
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->tabHost:Landroid/widget/TabHost;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/TabHost;->setCurrentTab(I)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 52
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 53
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 7

    .prologue
    const v6, 0x7f080085

    const/4 v5, -0x1

    const v4, 0x7f0800dd

    const v3, 0x7f0800b6

    const v2, 0x7f080074

    .line 57
    const v0, 0x7f03002e

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->v:Landroid/view/View;

    .line 59
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->v:Landroid/view/View;

    const v1, 0x7f07006a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvPlaylist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    .line 60
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->v:Landroid/view/View;

    const v1, 0x7f07006c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvArtist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    .line 61
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->v:Landroid/view/View;

    const v1, 0x7f07006e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvAlbum:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    .line 62
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->v:Landroid/view/View;

    const v1, 0x7f070070

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvSong:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    .line 64
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvPlaylist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setPullLabel(Ljava/lang/CharSequence;)V

    .line 65
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvPlaylist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setReleaseLabel(Ljava/lang/CharSequence;)V

    .line 66
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvPlaylist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setRefreshingLabel(Ljava/lang/CharSequence;)V

    .line 67
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvArtist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setPullLabel(Ljava/lang/CharSequence;)V

    .line 68
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvArtist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setReleaseLabel(Ljava/lang/CharSequence;)V

    .line 69
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvArtist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setRefreshingLabel(Ljava/lang/CharSequence;)V

    .line 70
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvAlbum:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setPullLabel(Ljava/lang/CharSequence;)V

    .line 71
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvAlbum:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setReleaseLabel(Ljava/lang/CharSequence;)V

    .line 72
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvAlbum:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setRefreshingLabel(Ljava/lang/CharSequence;)V

    .line 73
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvSong:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setPullLabel(Ljava/lang/CharSequence;)V

    .line 74
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvSong:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setReleaseLabel(Ljava/lang/CharSequence;)V

    .line 75
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvSong:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setRefreshingLabel(Ljava/lang/CharSequence;)V

    .line 77
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->v:Landroid/view/View;

    const v1, 0x7f070068

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TabHost;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->tabHost:Landroid/widget/TabHost;

    .line 78
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->tabHost:Landroid/widget/TabHost;

    invoke-virtual {v0}, Landroid/widget/TabHost;->setup()V

    .line 79
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->tabHost:Landroid/widget/TabHost;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->tabHost:Landroid/widget/TabHost;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v1

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TabHost$TabSpec;->setIndicator(Ljava/lang/CharSequence;)Landroid/widget/TabHost$TabSpec;

    move-result-object v1

    const v2, 0x7f070069

    invoke-virtual {v1, v2}, Landroid/widget/TabHost$TabSpec;->setContent(I)Landroid/widget/TabHost$TabSpec;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TabHost;->addTab(Landroid/widget/TabHost$TabSpec;)V

    .line 82
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->tabHost:Landroid/widget/TabHost;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->tabHost:Landroid/widget/TabHost;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080126

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v1

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080126

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TabHost$TabSpec;->setIndicator(Ljava/lang/CharSequence;)Landroid/widget/TabHost$TabSpec;

    move-result-object v1

    const v2, 0x7f07006d

    invoke-virtual {v1, v2}, Landroid/widget/TabHost$TabSpec;->setContent(I)Landroid/widget/TabHost$TabSpec;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TabHost;->addTab(Landroid/widget/TabHost$TabSpec;)V

    .line 85
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->tabHost:Landroid/widget/TabHost;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->tabHost:Landroid/widget/TabHost;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080127

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v1

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080127

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TabHost$TabSpec;->setIndicator(Ljava/lang/CharSequence;)Landroid/widget/TabHost$TabSpec;

    move-result-object v1

    const v2, 0x7f07006b

    invoke-virtual {v1, v2}, Landroid/widget/TabHost$TabSpec;->setContent(I)Landroid/widget/TabHost$TabSpec;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TabHost;->addTab(Landroid/widget/TabHost$TabSpec;)V

    .line 88
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->tabHost:Landroid/widget/TabHost;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->tabHost:Landroid/widget/TabHost;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080097

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v1

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080097

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TabHost$TabSpec;->setIndicator(Ljava/lang/CharSequence;)Landroid/widget/TabHost$TabSpec;

    move-result-object v1

    const v2, 0x7f07006f

    invoke-virtual {v1, v2}, Landroid/widget/TabHost$TabSpec;->setContent(I)Landroid/widget/TabHost$TabSpec;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TabHost;->addTab(Landroid/widget/TabHost$TabSpec;)V

    .line 92
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->tabHost:Landroid/widget/TabHost;

    const v1, 0x7f020128

    invoke-virtual {v0, v1}, Landroid/widget/TabHost;->setBackgroundResource(I)V

    .line 94
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvSong:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$1;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;)V

    invoke-virtual {v0, v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 106
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvAlbum:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$2;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$2;-><init>(Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;)V

    invoke-virtual {v0, v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 117
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvArtist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$3;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$3;-><init>(Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;)V

    invoke-virtual {v0, v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 128
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvPlaylist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$4;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment$4;-><init>(Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;)V

    invoke-virtual {v0, v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 141
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v0, v5, v5}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 142
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvPlaylist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v1, v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 143
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvArtist:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v1, v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 144
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvAlbum:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v1, v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 145
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->lvSong:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v1, v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 147
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->v:Landroid/view/View;

    return-object v0
.end method
