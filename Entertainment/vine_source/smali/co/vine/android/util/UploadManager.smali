.class public Lco/vine/android/util/UploadManager;
.super Ljava/lang/Object;
.source "UploadManager.java"


# static fields
.field public static final BC_INVALIDATE_CACHE:Ljava/lang/String; = "co.vine.android.invalidateCache"

.field public static final EXPIRE_TIME:J = 0x5265c00L

.field private static final SHARED_LOCK:[I

.field public static final STATUS_FAILED:I = 0x2

.field public static final STATUS_INVALID:I = -0x1

.field public static final STATUS_NEED_POST:I = 0x1

.field public static final STATUS_NEED_UPLOAD:I = 0x0

.field private static final SUB_PREF_HASH:Ljava/lang/String; = "_hash.sub"

.field private static final SUB_PREF_POST:Ljava/lang/String; = "_post.sub"

.field private static final SUB_PREF_THUMBNAIL:Ljava/lang/String; = "_thumbnail_url.sub"

.field private static final SUB_PREF_VIDEO:Ljava/lang/String; = "_video_url.sub"

.field private static final SUB_UPLOAD_TIME:Ljava/lang/String; = "_upload_time.sub"

.field public static final TAG:Ljava/lang/String; = "UploadManager"

.field private static mUploadPref:Landroid/content/SharedPreferences;


# instance fields
.field private final mMediaUtility:Lco/vine/android/util/MediaUtility;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 410
    const/4 v0, 0x0

    new-array v0, v0, [I

    sput-object v0, Lco/vine/android/util/UploadManager;->SHARED_LOCK:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    new-instance v0, Lco/vine/android/util/MediaUtility;

    invoke-direct {v0, p1}, Lco/vine/android/util/MediaUtility;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lco/vine/android/util/UploadManager;->mMediaUtility:Lco/vine/android/util/MediaUtility;

    .line 72
    return-void
.end method

.method public static addOrUpdateUpload(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJ)V
    .locals 14
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "hash"    # Ljava/lang/String;
    .param p3, "reference"    # Ljava/lang/String;
    .param p4, "isPrivate"    # Z
    .param p5, "conversationObjectId"    # J
    .param p7, "messageRowId"    # J

    .prologue
    .line 133
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSessionReadOnly()Lco/vine/android/client/Session;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v8

    .line 134
    .local v8, "ownerId":J
    invoke-static {}, Lco/vine/android/util/UploadManager;->getBaseUriBuilder()Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v3, "uploads/upload"

    invoke-virtual {v1, v3}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    invoke-static {v8, v9}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v3, "path"

    invoke-virtual {v1, v3, p1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    .line 140
    .local v2, "contentUri":Landroid/net/Uri;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v3, Lco/vine/android/provider/VineUploadsDatabaseSQL$UploadsQuery;->PROJECTION:[Ljava/lang/String;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual/range {v1 .. v6}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 143
    .local v7, "c":Landroid/database/Cursor;
    new-instance v13, Landroid/content/ContentValues;

    invoke-direct {v13}, Landroid/content/ContentValues;-><init>()V

    .line 144
    .local v13, "values":Landroid/content/ContentValues;
    if-eqz v7, :cond_0

    invoke-interface {v7}, Landroid/database/Cursor;->getCount()I

    move-result v1

    const/4 v3, 0x1

    if-ge v1, v3, :cond_5

    .line 145
    :cond_0
    invoke-static {p1}, Lco/vine/android/recorder/RecordConfigUtils;->getThumbnailPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 146
    .local v12, "thumbnailPath":Ljava/lang/String;
    const-string v1, "path"

    invoke-virtual {v13, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 147
    const-string v1, "thumbnail_path"

    invoke-virtual {v13, v1, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 148
    const-string v1, "hash"

    move-object/from16 v0, p2

    invoke-virtual {v13, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    const-string v1, "status"

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v13, v1, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 150
    const-string v3, "is_private"

    if-eqz p4, :cond_4

    const-string v1, "1"

    :goto_0
    invoke-virtual {v13, v3, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 151
    const-string v1, "reference"

    move-object/from16 v0, p3

    invoke-virtual {v13, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    const-string v1, "owner_id"

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v13, v1, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 153
    const-wide/16 v3, 0x0

    cmp-long v1, p7, v3

    if-lez v1, :cond_1

    .line 154
    const-string v1, "message_row"

    invoke-static/range {p7 .. p8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v13, v1, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 156
    :cond_1
    const-wide/16 v3, 0x0

    cmp-long v1, p5, v3

    if-lez v1, :cond_2

    .line 157
    const-string v1, "conversation_row_id"

    invoke-static/range {p5 .. p6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v13, v1, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 160
    :cond_2
    invoke-static {}, Lco/vine/android/util/UploadManager;->getBaseUriBuilder()Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v3, "uploads/put_new_upload"

    invoke-virtual {v1, v3}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    .line 163
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-virtual {v1, v2, v13}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    .line 177
    .end local v12    # "thumbnailPath":Ljava/lang/String;
    :goto_1
    if-eqz v7, :cond_3

    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 178
    :cond_3
    return-void

    .line 150
    .restart local v12    # "thumbnailPath":Ljava/lang/String;
    :cond_4
    const-string v1, "0"

    goto :goto_0

    .line 165
    .end local v12    # "thumbnailPath":Ljava/lang/String;
    :cond_5
    const-string v10, "path=?"

    .line 166
    .local v10, "selection":Ljava/lang/String;
    const/4 v1, 0x1

    new-array v11, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p1, v11, v1

    .line 167
    .local v11, "selectionArgs":[Ljava/lang/String;
    invoke-static/range {p2 .. p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_6

    .line 168
    const-string v1, "hash"

    move-object/from16 v0, p2

    invoke-virtual {v13, v1, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 170
    :cond_6
    const-string v1, "status"

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v13, v1, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 172
    invoke-static {}, Lco/vine/android/util/UploadManager;->getBaseUriBuilder()Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v3, "uploads/put_values"

    invoke-virtual {v1, v3}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    .line 175
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v3, "path=?"

    invoke-virtual {v1, v2, v13, v3, v11}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_1
.end method

.method public static addToUploadQueue(Landroid/content/Context;Lco/vine/android/recorder/RecordingFile;Ljava/lang/String;Ljava/lang/String;ZJ)Ljava/lang/String;
    .locals 9
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "file"    # Lco/vine/android/recorder/RecordingFile;
    .param p2, "thumbnail"    # Ljava/lang/String;
    .param p3, "reference"    # Ljava/lang/String;
    .param p4, "isMessaging"    # Z
    .param p5, "conversationId"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 107
    :try_start_0
    new-instance v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    invoke-direct {v0, p0}, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;-><init>(Landroid/content/Context;)V

    iget-object v1, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->processDir:Ljava/io/File;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .local v1, "processDir":Ljava/io/File;
    :goto_0
    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move v5, p4

    move-wide v6, p5

    .line 111
    invoke-static/range {v0 .. v7}, Lco/vine/android/util/UploadManager;->addToUploadQueue(Landroid/content/Context;Ljava/io/File;Lco/vine/android/recorder/RecordingFile;Ljava/lang/String;Ljava/lang/String;ZJ)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 108
    .end local v1    # "processDir":Ljava/io/File;
    :catch_0
    move-exception v8

    .line 109
    .local v8, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v1

    .restart local v1    # "processDir":Ljava/io/File;
    goto :goto_0
.end method

.method private static addToUploadQueue(Landroid/content/Context;Ljava/io/File;Lco/vine/android/recorder/RecordingFile;Ljava/lang/String;Ljava/lang/String;ZJ)Ljava/lang/String;
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "dir"    # Ljava/io/File;
    .param p2, "file"    # Lco/vine/android/recorder/RecordingFile;
    .param p3, "thumbnail"    # Ljava/lang/String;
    .param p4, "reference"    # Ljava/lang/String;
    .param p5, "isMessaging"    # Z
    .param p6, "conversationId"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 81
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p2, Lco/vine/android/recorder/RecordingFile;->version:Lco/vine/android/recorder/RecordSessionVersion;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordSessionVersion;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "_"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 82
    .local v8, "fileName":Ljava/lang/String;
    invoke-virtual {p2}, Lco/vine/android/recorder/RecordingFile;->getVideoPath()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0, v8}, Lco/vine/android/recorder/RecordConfigUtils;->copyForUpload(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;

    move-result-object v9

    .line 83
    .local v9, "videoFile":Ljava/io/File;
    invoke-virtual {v9}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v1

    .line 84
    .local v1, "path":Ljava/lang/String;
    invoke-static {v8}, Lco/vine/android/recorder/RecordConfigUtils;->getThumbnailPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, p3, v0}, Lco/vine/android/recorder/RecordConfigUtils;->copyForUpload(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object p3

    .line 86
    invoke-virtual {p2}, Lco/vine/android/recorder/RecordingFile;->getHash()Ljava/lang/String;

    move-result-object v2

    move-object v0, p0

    move-object v3, p3

    move-object v4, p4

    move v5, p5

    move-wide/from16 v6, p6

    invoke-static/range {v0 .. v7}, Lco/vine/android/service/VineUploadService;->getUploadIntent(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJ)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 88
    return-object v1
.end method

.method public static clearSp()V
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 525
    sget-object v1, Lco/vine/android/util/UploadManager;->SHARED_LOCK:[I

    monitor-enter v1

    .line 526
    :try_start_0
    sget-object v0, Lco/vine/android/util/UploadManager;->mUploadPref:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 527
    monitor-exit v1

    .line 528
    return-void

    .line 527
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static clearUploadCaptchas(Landroid/content/Context;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 400
    invoke-static {}, Lco/vine/android/util/UploadManager;->getBaseUriBuilder()Landroid/net/Uri$Builder;

    move-result-object v2

    const-string v3, "uploads/put_values"

    invoke-virtual {v2, v3}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    .line 401
    .local v0, "uri":Landroid/net/Uri$Builder;
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 402
    .local v1, "values":Landroid/content/ContentValues;
    const-string v2, "captcha_url"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 403
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v3

    const-string v4, "1"

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v1, v4, v5}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 404
    return-void
.end method

.method public static deleteUploadRecord(Landroid/content/Context;Ljava/lang/String;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 212
    invoke-static {}, Lco/vine/android/util/UploadManager;->getBaseUriBuilder()Landroid/net/Uri$Builder;

    move-result-object v3

    const-string v4, "uploads/delete_upload"

    invoke-virtual {v3, v4}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    .line 215
    .local v0, "contentUri":Landroid/net/Uri;
    const-string v2, "path=?"

    .line 216
    .local v2, "whereClause":Ljava/lang/String;
    const/4 v3, 0x1

    new-array v1, v3, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object p1, v1, v3

    .line 217
    .local v1, "whereArgs":[Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    const-string v4, "path=?"

    invoke-virtual {v3, v0, v4, v1}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 218
    return-void
.end method

.method public static generateFileName(Landroid/content/Context;)Ljava/lang/String;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/pm/PackageManager$NameNotFoundException;
        }
    .end annotation

    .prologue
    .line 227
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy/MM/dd/"

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 228
    .local v0, "formatter":Ljava/text/SimpleDateFormat;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0, v2}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    iget v2, v2, Landroid/content/pm/PackageInfo;->versionCode:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static getAllPaths(Landroid/content/Context;)Ljava/util/LinkedHashMap;
    .locals 12
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 308
    new-instance v10, Ljava/util/LinkedHashMap;

    invoke-direct {v10}, Ljava/util/LinkedHashMap;-><init>()V

    .line 309
    .local v10, "paths":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/String;Ljava/lang/Integer;>;"
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->getActiveSessionReadOnly()Lco/vine/android/client/Session;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v7

    .line 310
    .local v7, "ownerId":J
    sget-object v0, Lco/vine/android/provider/VineUploads$Uploads;->CONTENT_URI:Landroid/net/Uri;

    invoke-static {v0, v7, v8}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    .line 311
    .local v1, "contentUri":Landroid/net/Uri;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v2, Lco/vine/android/provider/VineUploadsDatabaseSQL$UploadsQuery;->PROJECTION:[Ljava/lang/String;

    const-string v5, "_id ASC"

    move-object v4, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 313
    .local v6, "c":Landroid/database/Cursor;
    if-eqz v6, :cond_1

    .line 314
    :goto_0
    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 315
    const/4 v0, 0x1

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 316
    .local v9, "path":Ljava/lang/String;
    const/4 v0, 0x3

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v11

    .line 317
    .local v11, "status":I
    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v10, v9, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 319
    .end local v9    # "path":Ljava/lang/String;
    .end local v11    # "status":I
    :cond_0
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 321
    :cond_1
    return-object v10
.end method

.method private static getBaseUriBuilder()Landroid/net/Uri$Builder;
    .locals 2

    .prologue
    .line 221
    new-instance v0, Landroid/net/Uri$Builder;

    invoke-direct {v0}, Landroid/net/Uri$Builder;-><init>()V

    const-string v1, "content"

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    sget-object v1, Lco/vine/android/provider/VineUploadProvider;->AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->authority(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    return-object v0
.end method

.method public static getHashSp(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "path"    # Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 484
    sget-object v1, Lco/vine/android/util/UploadManager;->SHARED_LOCK:[I

    monitor-enter v1

    .line 485
    :try_start_0
    sget-object v0, Lco/vine/android/util/UploadManager;->mUploadPref:Landroid/content/SharedPreferences;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_hash.sub"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 486
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static getPendingPaths(Landroid/content/Context;)Ljava/util/LinkedList;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/LinkedList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 328
    new-instance v3, Ljava/util/LinkedList;

    invoke-direct {v3}, Ljava/util/LinkedList;-><init>()V

    .line 329
    .local v3, "pendingPaths":Ljava/util/LinkedList;, "Ljava/util/LinkedList<Ljava/lang/String;>;"
    invoke-static {p0}, Lco/vine/android/util/UploadManager;->getAllPaths(Landroid/content/Context;)Ljava/util/LinkedHashMap;

    move-result-object v0

    .line 330
    .local v0, "allPaths":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/String;Ljava/lang/Integer;>;"
    invoke-virtual {v0}, Ljava/util/LinkedHashMap;->keySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 331
    .local v2, "path":Ljava/lang/String;
    invoke-virtual {v0, v2}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v4

    .line 332
    .local v4, "status":I
    const/4 v5, 0x2

    if-eq v4, v5, :cond_0

    const/4 v5, -0x1

    if-eq v4, v5, :cond_0

    .line 333
    invoke-virtual {v3, v2}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 336
    .end local v2    # "path":Ljava/lang/String;
    .end local v4    # "status":I
    :cond_1
    return-object v3
.end method

.method public static getPendingPathsSp()Ljava/util/HashMap;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 447
    sget-object v6, Lco/vine/android/util/UploadManager;->SHARED_LOCK:[I

    monitor-enter v6

    .line 449
    :try_start_0
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 450
    .local v3, "pendingPaths":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    sget-object v5, Lco/vine/android/util/UploadManager;->mUploadPref:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->getAll()Ljava/util/Map;

    move-result-object v0

    .line 451
    .local v0, "all":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;*>;"
    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 452
    .local v2, "key":Ljava/lang/String;
    invoke-static {v2}, Lco/vine/android/util/UploadManager;->isKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 453
    const-string v5, "Key: {}"

    invoke-static {v5, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 454
    invoke-static {v2}, Lco/vine/android/util/UploadManager;->getStatusSp(Ljava/lang/String;)I

    move-result v4

    .line 455
    .local v4, "status":I
    invoke-static {v2}, Lco/vine/android/util/UploadManager;->isUploadExpiredSp(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 456
    packed-switch v4, :pswitch_data_0

    goto :goto_0

    .line 461
    :pswitch_0
    const-string v5, "cNotify"

    invoke-virtual {v3, v2, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 479
    .end local v0    # "all":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;*>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "key":Ljava/lang/String;
    .end local v4    # "status":I
    :catchall_0
    move-exception v5

    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v5

    .line 458
    .restart local v0    # "all":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;*>;"
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v2    # "key":Ljava/lang/String;
    .restart local v4    # "status":I
    :pswitch_1
    :try_start_1
    const-string v5, "aUpload"

    invoke-virtual {v3, v2, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 465
    :cond_1
    packed-switch v4, :pswitch_data_1

    goto :goto_0

    .line 471
    :pswitch_2
    const-string v5, "cNotify"

    invoke-virtual {v3, v2, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 467
    :pswitch_3
    const-string v5, "File does not exist any more (uploaded)."

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 468
    const-string v5, "bPost"

    invoke-virtual {v3, v2, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 478
    .end local v2    # "key":Ljava/lang/String;
    .end local v4    # "status":I
    :cond_2
    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-object v3

    .line 456
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch

    .line 465
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public static getPostInfoSp(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "path"    # Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 505
    sget-object v1, Lco/vine/android/util/UploadManager;->SHARED_LOCK:[I

    monitor-enter v1

    .line 506
    :try_start_0
    sget-object v0, Lco/vine/android/util/UploadManager;->mUploadPref:Landroid/content/SharedPreferences;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_post.sub"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 507
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static getReferenceCursor(Landroid/content/Context;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "reference"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 116
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 125
    :goto_0
    return-object v3

    .line 119
    :cond_0
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->getActiveSessionReadOnly()Lco/vine/android/client/Session;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v6

    .line 120
    .local v6, "ownerId":J
    invoke-static {}, Lco/vine/android/util/UploadManager;->getBaseUriBuilder()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v2, "uploads/reference"

    invoke-virtual {v0, v2}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v2, "reference"

    invoke-virtual {v0, v2, p1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    .line 125
    .local v1, "contentUri":Landroid/net/Uri;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v2, Lco/vine/android/provider/VineUploadsDatabaseSQL$UploadsQuery;->PROJECTION:[Ljava/lang/String;

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v3

    goto :goto_0
.end method

.method public static getStatusSp(Ljava/lang/String;)I
    .locals 3
    .param p0, "path"    # Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 498
    sget-object v1, Lco/vine/android/util/UploadManager;->SHARED_LOCK:[I

    monitor-enter v1

    .line 499
    :try_start_0
    sget-object v0, Lco/vine/android/util/UploadManager;->mUploadPref:Landroid/content/SharedPreferences;

    const/4 v2, -0x1

    invoke-interface {v0, p0, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    monitor-exit v1

    return v0

    .line 500
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static getUpload(Landroid/content/Context;Ljava/lang/String;)Lco/vine/android/api/VineUpload;
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 192
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->getActiveSessionReadOnly()Lco/vine/android/client/Session;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v7

    .line 193
    .local v7, "ownerId":J
    const/4 v9, 0x0

    .line 194
    .local v9, "ret":Lco/vine/android/api/VineUpload;
    invoke-static {}, Lco/vine/android/util/UploadManager;->getBaseUriBuilder()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v2, "uploads/upload"

    invoke-virtual {v0, v2}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-static {v7, v8}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v2, "path"

    invoke-virtual {v0, v2, p1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    .line 200
    .local v1, "contentUri":Landroid/net/Uri;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v2, Lco/vine/android/provider/VineUploadsDatabaseSQL$UploadsQuery;->PROJECTION:[Ljava/lang/String;

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 202
    .local v6, "c":Landroid/database/Cursor;
    if-eqz v6, :cond_1

    .line 203
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 204
    invoke-static {p1, v6}, Lco/vine/android/api/VineUpload;->fromCursor(Ljava/lang/String;Landroid/database/Cursor;)Lco/vine/android/api/VineUpload;

    move-result-object v9

    .line 206
    :cond_0
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 208
    :cond_1
    return-object v9
.end method

.method public static getUploadTimeSp(Ljava/lang/String;)J
    .locals 5
    .param p0, "path"    # Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 491
    sget-object v1, Lco/vine/android/util/UploadManager;->SHARED_LOCK:[I

    monitor-enter v1

    .line 492
    :try_start_0
    sget-object v0, Lco/vine/android/util/UploadManager;->mUploadPref:Landroid/content/SharedPreferences;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_upload_time.sub"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-wide/16 v3, 0x0

    invoke-interface {v0, v2, v3, v4}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v2

    monitor-exit v1

    return-wide v2

    .line 493
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static getUrisSp(Ljava/lang/String;)[Ljava/lang/String;
    .locals 6
    .param p0, "path"    # Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 512
    sget-object v1, Lco/vine/android/util/UploadManager;->SHARED_LOCK:[I

    monitor-enter v1

    .line 513
    const/4 v0, 0x2

    :try_start_0
    new-array v0, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    sget-object v3, Lco/vine/android/util/UploadManager;->mUploadPref:Landroid/content/SharedPreferences;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "_video_url.sub"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v0, v2

    const/4 v2, 0x1

    sget-object v3, Lco/vine/android/util/UploadManager;->mUploadPref:Landroid/content/SharedPreferences;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "_thumbnail_url.sub"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v0, v2

    monitor-exit v1

    return-object v0

    .line 515
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static getVersionFromPath(Ljava/lang/String;)Lco/vine/android/recorder/RecordSessionVersion;
    .locals 3
    .param p0, "path"    # Ljava/lang/String;

    .prologue
    .line 92
    sget-object v1, Lco/vine/android/recorder/RecordSessionVersion;->SW_MP4:Lco/vine/android/recorder/RecordSessionVersion;

    .line 93
    .local v1, "version":Lco/vine/android/recorder/RecordSessionVersion;
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v0

    .line 94
    .local v0, "fn":Ljava/lang/String;
    sget-object v2, Lco/vine/android/recorder/RecordSessionVersion;->HW:Lco/vine/android/recorder/RecordSessionVersion;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordSessionVersion;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 95
    sget-object v1, Lco/vine/android/recorder/RecordSessionVersion;->HW:Lco/vine/android/recorder/RecordSessionVersion;

    .line 99
    :cond_0
    :goto_0
    return-object v1

    .line 96
    :cond_1
    sget-object v2, Lco/vine/android/recorder/RecordSessionVersion;->SW_WEBM:Lco/vine/android/recorder/RecordSessionVersion;

    invoke-virtual {v2}, Lco/vine/android/recorder/RecordSessionVersion;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 97
    sget-object v1, Lco/vine/android/recorder/RecordSessionVersion;->SW_WEBM:Lco/vine/android/recorder/RecordSessionVersion;

    goto :goto_0
.end method

.method public static initUploadPref(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 420
    const-string v0, "upload"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    sput-object v0, Lco/vine/android/util/UploadManager;->mUploadPref:Landroid/content/SharedPreferences;

    .line 421
    return-void
.end method

.method public static isEmptySp()Z
    .locals 6
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v3, 0x1

    .line 430
    sget-object v4, Lco/vine/android/util/UploadManager;->SHARED_LOCK:[I

    monitor-enter v4

    .line 431
    :try_start_0
    sget-object v5, Lco/vine/android/util/UploadManager;->mUploadPref:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->getAll()Ljava/util/Map;

    move-result-object v0

    .line 432
    .local v0, "all":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;*>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 433
    :cond_0
    monitor-exit v4

    .line 440
    :goto_0
    return v3

    .line 435
    :cond_1
    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 436
    .local v2, "key":Ljava/lang/String;
    invoke-static {v2}, Lco/vine/android/util/UploadManager;->isKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 437
    const/4 v3, 0x0

    monitor-exit v4

    goto :goto_0

    .line 442
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "key":Ljava/lang/String;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .line 440
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_3
    :try_start_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public static isKey(Ljava/lang/String;)Z
    .locals 1
    .param p0, "path"    # Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 425
    const-string v0, ".sub"

    invoke-virtual {p0, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isUploadExpiredSp(Ljava/lang/String;)Z
    .locals 6
    .param p0, "path"    # Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 520
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sget-object v2, Lco/vine/android/util/UploadManager;->mUploadPref:Landroid/content/SharedPreferences;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "_upload_time.sub"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-wide/16 v4, 0x0

    invoke-interface {v2, v3, v4, v5}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v2

    sub-long/2addr v0, v2

    const-wide/32 v2, 0x5265c00

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static prepopulateCache(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "videoUrl"    # Ljava/lang/String;
    .param p3, "thumbnailUrl"    # Ljava/lang/String;

    .prologue
    .line 540
    const-string v0, "Prepopulating cache. Video url: {} | Thumbnail url: {}"

    invoke-static {v0, p2, p3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 541
    if-eqz p2, :cond_0

    .line 542
    invoke-static {p0, p1, p2}, Lco/vine/android/util/UploadManager;->prepopulateVideoCache(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 544
    :cond_0
    if-eqz p3, :cond_1

    .line 545
    invoke-static {p1}, Lco/vine/android/recorder/RecordConfigUtils;->getThumbnailPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0, p3}, Lco/vine/android/util/UploadManager;->prepopulateImageCache(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 548
    :cond_1
    new-instance v0, Landroid/content/Intent;

    const-string v1, "co.vine.android.invalidateCache"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v1, "co.vine.android.BROADCAST"

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 549
    return-void
.end method

.method private static prepopulateImageCache(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 9
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "thumbnailPath"    # Ljava/lang/String;
    .param p2, "thumbnailUrl"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 567
    invoke-static {p0}, Lco/vine/android/util/SystemUtil;->getDisplaySize(Landroid/content/Context;)Landroid/graphics/Point;

    move-result-object v8

    .line 568
    .local v8, "p":Landroid/graphics/Point;
    iget v1, v8, Landroid/graphics/Point;->x:I

    iget v2, v8, Landroid/graphics/Point;->y:I

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 570
    .local v7, "maxImageSize":I
    new-instance v0, Lco/vine/android/util/image/PhotoImagesCache;

    invoke-direct {v0, p0, v7, v3}, Lco/vine/android/util/image/PhotoImagesCache;-><init>(Landroid/content/Context;II)V

    .line 573
    .local v0, "imgCache":Lco/vine/android/util/image/PhotoImagesCache;
    :try_start_0
    new-instance v5, Ljava/io/FileInputStream;

    invoke-direct {v5, p1}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 578
    .local v5, "fis":Ljava/io/FileInputStream;
    const/4 v1, 0x1

    invoke-static {p0, v1}, Lco/vine/android/client/VineAccountHelper;->getActiveSession(Landroid/content/Context;Z)Lco/vine/android/client/Session;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v1

    new-instance v3, Lco/vine/android/util/image/ImageKey;

    invoke-direct {v3, p2}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;)V

    move-object v4, p2

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/util/image/PhotoImagesCache;->prepopulateThumbnailCacheForUrl(JLco/vine/android/util/image/ImageKey;Ljava/lang/String;Ljava/io/FileInputStream;)V

    .line 581
    .end local v5    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-void

    .line 574
    :catch_0
    move-exception v6

    .line 575
    .local v6, "e":Ljava/io/FileNotFoundException;
    const-string v1, "Error prepopulating the cache"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v6, v1, v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private static prepopulateVideoCache(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "videoPath"    # Ljava/lang/String;
    .param p2, "videoUrl"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 552
    new-instance v0, Lco/vine/android/util/video/VideoCache;

    invoke-direct {v0, p0, v2}, Lco/vine/android/util/video/VideoCache;-><init>(Landroid/content/Context;I)V

    .line 555
    .local v0, "videoCache":Lco/vine/android/util/video/VideoCache;
    :try_start_0
    new-instance v5, Ljava/io/FileInputStream;

    invoke-direct {v5, p1}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 560
    .local v5, "fis":Ljava/io/FileInputStream;
    const/4 v1, 0x1

    invoke-static {p0, v1}, Lco/vine/android/client/VineAccountHelper;->getActiveSession(Landroid/content/Context;Z)Lco/vine/android/client/Session;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v1

    new-instance v3, Lco/vine/android/util/video/VideoKey;

    invoke-direct {v3, p2}, Lco/vine/android/util/video/VideoKey;-><init>(Ljava/lang/String;)V

    move-object v4, p2

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/util/video/VideoCache;->prepopulateVideoCacheForUrl(JLco/vine/android/util/video/VideoKey;Ljava/lang/String;Ljava/io/InputStream;)V

    .line 563
    .end local v5    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-void

    .line 556
    :catch_0
    move-exception v6

    .line 557
    .local v6, "e":Ljava/io/FileNotFoundException;
    const-string v1, "Error prepopulating the cache"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v6, v1, v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public static removeFromUploadQueue(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 75
    invoke-static {p0, p1}, Lco/vine/android/service/VineUploadService;->getDiscardIntent(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 76
    return-void
.end method

.method public static setHash(Landroid/content/Context;Lco/vine/android/api/VineUpload;Ljava/lang/String;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "upload"    # Lco/vine/android/api/VineUpload;
    .param p2, "hash"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 340
    iput-object p2, p1, Lco/vine/android/api/VineUpload;->hash:Ljava/lang/String;

    .line 341
    invoke-static {}, Lco/vine/android/util/UploadManager;->getBaseUriBuilder()Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "uploads/put_hash"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "path"

    iget-object v3, p1, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "hash"

    invoke-virtual {v1, v2, p2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    .line 346
    .local v0, "contentUri":Landroid/net/Uri;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-virtual {v1, v0, v4, v4, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 347
    return-void
.end method

.method public static setPostInfo(Landroid/content/Context;Lco/vine/android/api/VineUpload;Lco/vine/android/api/VineUpload$PostInfo;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "upload"    # Lco/vine/android/api/VineUpload;
    .param p2, "info"    # Lco/vine/android/api/VineUpload$PostInfo;

    .prologue
    const/4 v4, 0x0

    .line 350
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Setting post info for path="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p1, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " with caption="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p2, Lco/vine/android/api/VineUpload$PostInfo;->caption:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", twitter="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p2, Lco/vine/android/api/VineUpload$PostInfo;->postToTwitter:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", facebook="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p2, Lco/vine/android/api/VineUpload$PostInfo;->postToFacebook:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 352
    invoke-virtual {p2}, Lco/vine/android/api/VineUpload$PostInfo;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p1, Lco/vine/android/api/VineUpload;->postInfo:Ljava/lang/String;

    .line 353
    invoke-static {}, Lco/vine/android/util/UploadManager;->getBaseUriBuilder()Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "uploads/put_post_info"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "path"

    iget-object v3, p1, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "post_info"

    invoke-virtual {p2}, Lco/vine/android/api/VineUpload$PostInfo;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    .line 358
    .local v0, "contentUri":Landroid/net/Uri;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-virtual {v1, v0, v4, v4, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 359
    return-void
.end method

.method public static setStatus(Landroid/content/Context;Lco/vine/android/api/VineUpload;I)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "upload"    # Lco/vine/android/api/VineUpload;
    .param p2, "status"    # I

    .prologue
    .line 362
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lco/vine/android/util/UploadManager;->setStatus(Landroid/content/Context;Lco/vine/android/api/VineUpload;ILjava/lang/String;)V

    .line 363
    return-void
.end method

.method public static setStatus(Landroid/content/Context;Lco/vine/android/api/VineUpload;ILjava/lang/String;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "upload"    # Lco/vine/android/api/VineUpload;
    .param p2, "status"    # I
    .param p3, "captcha"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 366
    iput p2, p1, Lco/vine/android/api/VineUpload;->status:I

    .line 367
    invoke-static {}, Lco/vine/android/util/UploadManager;->getBaseUriBuilder()Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "uploads/put_status"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "path"

    iget-object v3, p1, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "status"

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    .line 371
    .local v0, "contentUri":Landroid/net/Uri$Builder;
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 372
    const-string v1, "captcha_url"

    invoke-virtual {v0, v1, p3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 374
    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v1, v2, v4, v4, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 375
    return-void
.end method

.method public static setUploadMessageRowId(Landroid/content/Context;Ljava/lang/String;J)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "uploadPath"    # Ljava/lang/String;
    .param p2, "messageId"    # J

    .prologue
    const/4 v4, 0x0

    .line 531
    invoke-static {}, Lco/vine/android/util/UploadManager;->getBaseUriBuilder()Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "uploads/put_message_row_id"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "path"

    invoke-virtual {v1, v2, p1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "message_row_id"

    invoke-static {p2, p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    .line 536
    .local v0, "contentUri":Landroid/net/Uri;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-virtual {v1, v0, v4, v4, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 537
    return-void
.end method

.method public static setUploadTime(Landroid/content/Context;Lco/vine/android/api/VineUpload;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "upload"    # Lco/vine/android/api/VineUpload;

    .prologue
    const/4 v5, 0x0

    .line 378
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iput-wide v2, p1, Lco/vine/android/api/VineUpload;->uploadTime:J

    .line 379
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    .line 380
    .local v1, "currentTime":Ljava/lang/String;
    invoke-static {}, Lco/vine/android/util/UploadManager;->getBaseUriBuilder()Landroid/net/Uri$Builder;

    move-result-object v2

    const-string v3, "uploads/put_upload_time"

    invoke-virtual {v2, v3}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v2

    const-string v3, "path"

    iget-object v4, p1, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v2

    const-string v3, "upload_time"

    invoke-virtual {v2, v3, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    .line 385
    .local v0, "contentUri":Landroid/net/Uri;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, v0, v5, v5, v5}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 386
    return-void
.end method

.method public static setUris(Landroid/content/Context;Lco/vine/android/api/VineUpload;[Ljava/lang/String;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "upload"    # Lco/vine/android/api/VineUpload;
    .param p2, "uris"    # [Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 389
    invoke-virtual {p1, p2}, Lco/vine/android/api/VineUpload;->setUris([Ljava/lang/String;)V

    .line 390
    invoke-static {}, Lco/vine/android/util/UploadManager;->getBaseUriBuilder()Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "uploads/put_uris"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "path"

    iget-object v3, p1, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "video_url"

    const/4 v3, 0x0

    aget-object v3, p2, v3

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "thumbnail_url"

    const/4 v3, 0x1

    aget-object v3, p2, v3

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    .line 396
    .local v0, "contentUri":Landroid/net/Uri;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-virtual {v1, v0, v4, v4, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 397
    return-void
.end method

.method public static uploadListIsEmpty(Landroid/content/Context;)Z
    .locals 8
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v3, 0x0

    const/4 v7, 0x1

    .line 181
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lco/vine/android/provider/VineUploads$Uploads;->CONTENT_URI:Landroid/net/Uri;

    sget-object v2, Lco/vine/android/provider/VineUploadsDatabaseSQL$UploadsQuery;->PROJECTION:[Ljava/lang/String;

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 183
    .local v6, "c":Landroid/database/Cursor;
    if-eqz v6, :cond_0

    .line 184
    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-ge v0, v7, :cond_1

    .line 185
    .local v7, "cursorIsEmpty":Z
    :goto_0
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 188
    .end local v7    # "cursorIsEmpty":Z
    :cond_0
    return v7

    .line 184
    :cond_1
    const/4 v7, 0x0

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized upload(Lco/vine/android/service/VineUploadService$ServiceAsyncTask;Lco/vine/android/service/UploadProgressListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLco/vine/android/recorder/RecordSessionVersion;)[Ljava/lang/String;
    .locals 13
    .param p1, "serviceAsyncTask"    # Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    .param p2, "listener"    # Lco/vine/android/service/UploadProgressListener;
    .param p3, "encoded"    # Ljava/lang/String;
    .param p4, "thumbnail"    # Ljava/lang/String;
    .param p5, "path"    # Ljava/lang/String;
    .param p6, "isPrivate"    # Z
    .param p7, "version"    # Lco/vine/android/recorder/RecordSessionVersion;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 237
    monitor-enter p0

    :try_start_0
    new-instance v3, Ljava/io/File;

    move-object/from16 v0, p3

    invoke-direct {v3, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 238
    .local v3, "file":Ljava/io/File;
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_0

    .line 239
    const-string v1, "Files does not exist: {}"

    move-object/from16 v0, p3

    invoke-static {v1, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 240
    const/4 v1, 0x0

    .line 289
    :goto_0
    monitor-exit p0

    return-object v1

    .line 243
    :cond_0
    :try_start_1
    invoke-virtual {p1}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->getContext()Landroid/content/Context;

    move-result-object v1

    move-object/from16 v0, p5

    invoke-static {v1, v0}, Lco/vine/android/util/UploadManager;->getUpload(Landroid/content/Context;Ljava/lang/String;)Lco/vine/android/api/VineUpload;

    move-result-object v11

    .line 244
    .local v11, "upload":Lco/vine/android/api/VineUpload;
    if-nez v11, :cond_1

    .line 245
    new-instance v1, Ljava/lang/Exception;

    const-string v2, "Upload record was null"

    invoke-direct {v1, v2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 287
    .end local v11    # "upload":Lco/vine/android/api/VineUpload;
    :catch_0
    move-exception v7

    .line 288
    .local v7, "e":Ljava/lang/Exception;
    :try_start_2
    const-string v1, "Upload failed: {}"

    move-object/from16 v0, p5

    invoke-static {v1, v0, v7}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 289
    const/4 v1, 0x0

    goto :goto_0

    .line 248
    .end local v7    # "e":Ljava/lang/Exception;
    .restart local v11    # "upload":Lco/vine/android/api/VineUpload;
    :cond_1
    :try_start_3
    invoke-static/range {p3 .. p3}, Lco/vine/android/recorder/HashAsyncTask;->getMD5Checksum(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 249
    .local v9, "hash":Ljava/lang/String;
    iget-object v8, v11, Lco/vine/android/api/VineUpload;->hash:Ljava/lang/String;

    .line 250
    .local v8, "expected":Ljava/lang/String;
    invoke-virtual {v9, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 251
    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 252
    const-string v1, "Invalid hash: actual {}, expected {}."

    invoke-static {v1, v9, v8}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 253
    const/4 v1, 0x0

    goto :goto_0

    .line 255
    :cond_2
    new-instance v1, Lco/vine/android/VineLoggingException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Expected hash was invalid: "

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 259
    :cond_3
    invoke-virtual {p1}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->isCancelled()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 260
    const-string v1, "Task is already cancelled."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 261
    const/4 v1, 0x0

    goto :goto_0

    .line 264
    :cond_4
    invoke-virtual {p1}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->getContext()Landroid/content/Context;

    move-result-object v4

    .line 265
    .local v4, "context":Landroid/content/Context;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v4}, Lco/vine/android/util/UploadManager;->generateFileName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object/from16 v0, p7

    iget-object v2, v0, Lco/vine/android/recorder/RecordSessionVersion;->videoOutputExtension:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .local v5, "fileName":Ljava/lang/String;
    move-object v1, p0

    move-object v2, p2

    move/from16 v6, p6

    .line 267
    invoke-virtual/range {v1 .. v6}, Lco/vine/android/util/UploadManager;->uploadVideo(Lco/vine/android/util/VineProgressListener;Ljava/io/File;Landroid/content/Context;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v12

    .line 270
    .local v12, "videoUri":Ljava/lang/String;
    if-nez v12, :cond_5

    .line 271
    new-instance v1, Ljava/lang/Exception;

    const-string v2, "Failed to upload video."

    invoke-direct {v1, v2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 237
    .end local v3    # "file":Ljava/io/File;
    .end local v4    # "context":Landroid/content/Context;
    .end local v5    # "fileName":Ljava/lang/String;
    .end local v8    # "expected":Ljava/lang/String;
    .end local v9    # "hash":Ljava/lang/String;
    .end local v11    # "upload":Lco/vine/android/api/VineUpload;
    .end local v12    # "videoUri":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 274
    .restart local v3    # "file":Ljava/io/File;
    .restart local v4    # "context":Landroid/content/Context;
    .restart local v5    # "fileName":Ljava/lang/String;
    .restart local v8    # "expected":Ljava/lang/String;
    .restart local v9    # "hash":Ljava/lang/String;
    .restart local v11    # "upload":Lco/vine/android/api/VineUpload;
    .restart local v12    # "videoUri":Ljava/lang/String;
    :cond_5
    :try_start_4
    invoke-virtual {p1}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->isCancelled()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 275
    const-string v1, "Task is already cancelled."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 276
    const/4 v1, 0x0

    goto/16 :goto_0

    .line 279
    :cond_6
    new-instance v1, Ljava/io/File;

    move-object/from16 v0, p4

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {p0, p2, v1, v2, v5}, Lco/vine/android/util/UploadManager;->uploadThumbnail(Lco/vine/android/util/VineProgressListener;Ljava/io/File;Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 282
    .local v10, "thumbnailUrl":Ljava/lang/String;
    if-nez v10, :cond_7

    .line 283
    new-instance v1, Ljava/lang/Exception;

    const-string v2, "Failed to upload thumbnail."

    invoke-direct {v1, v2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v1

    .line 286
    :cond_7
    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object v12, v1, v2

    const/4 v2, 0x1

    aput-object v10, v1, v2
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_0
.end method

.method public uploadThumbnail(Lco/vine/android/util/VineProgressListener;Ljava/io/File;Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "listener"    # Lco/vine/android/util/VineProgressListener;
    .param p2, "file"    # Ljava/io/File;
    .param p3, "context"    # Landroid/content/Context;
    .param p4, "fileName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 300
    iget-object v0, p0, Lco/vine/android/util/UploadManager;->mMediaUtility:Lco/vine/android/util/MediaUtility;

    invoke-virtual {v0, p1, p4, p2, p3}, Lco/vine/android/util/MediaUtility;->getThumbnailUri(Lco/vine/android/util/VineProgressListener;Ljava/lang/String;Ljava/io/File;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public uploadVideo(Lco/vine/android/util/VineProgressListener;Ljava/io/File;Landroid/content/Context;Ljava/lang/String;Z)Ljava/lang/String;
    .locals 6
    .param p1, "listener"    # Lco/vine/android/util/VineProgressListener;
    .param p2, "file"    # Ljava/io/File;
    .param p3, "context"    # Landroid/content/Context;
    .param p4, "fileName"    # Ljava/lang/String;
    .param p5, "isPrivate"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 294
    iget-object v0, p0, Lco/vine/android/util/UploadManager;->mMediaUtility:Lco/vine/android/util/MediaUtility;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move v5, p5

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/util/MediaUtility;->getVideoUri(Lco/vine/android/util/VineProgressListener;Ljava/io/File;Landroid/content/Context;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
