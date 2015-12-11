.class public Lco/vine/android/recorder/RecordConfigUtils;
.super Ljava/lang/Object;
.source "RecordConfigUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    }
.end annotation


# static fields
.field public static final AUDIO_BIT_RATE:I

.field public static final AUDIO_BUFFER_SIZE:I

.field public static final AUDIO_FORMAT:I = 0x10

.field public static final AUDIO_RUNNABLE_SAMPLE_SIZE:I

.field public static final AUDIO_SAMPLE_PER_MS_MAX:I = 0x30

.field public static final AUDIO_SAMPLE_PER_NS_EXACT:D = 0.0441

.field public static final AUDIO_SAMPLE_RATE_HZ:I = 0xac44

.field private static DCIM:Ljava/lang/String; = null

.field public static final DEFAULT_BITMAP_CONFIG:Landroid/graphics/Bitmap$Config;

.field public static final DEFAULT_TARGET_SIZE:I = 0x1e0

.field public static final FOLDER_ROOT_DIRECT_UPLOAD:Ljava/io/File;

.field public static final FOLDER_ROOT_PROCESS:Ljava/lang/String; = "process"

.field private static final FOLDER_ROOT_PROCESS_DEBUG:Ljava/io/File;

.field private static final FOLDER_ROOT_SAVE:Ljava/lang/String;

.field public static final FOLDER_ROOT_TO_UPLOAD:Ljava/lang/String; = "upload"

.field public static final HIGHEST_PROFILE:I = 0x4

.field public static final HW_ENABLED:Z

.field public static final MAX_DRAFTS:I = 0x9

.field public static final N_AUDIO_CHANNELS:I = 0x1

.field public static final N_IMAGE_CHANNELS:I = 0x4

.field public static final PREF_CAN_LOAD:Ljava/lang/String; = "canLoad"

.field public static final PROGRESS_THRESHOLD_MESSAGING:I = 0x42

.field public static final PROGRESS_THRESHOLD_REGULAR:I = 0x3e8

.field public static final PROGRESS_TIMER_SLEEP:I = 0x23

.field public static final SW_ENABLED:Z

.field public static final THUMBNAIL_MODE_MEDIA_UTILS:Z = false

.field public static final THUMBNAIL_MODE_OPENCV:Z = true

.field private static final UPLOAD_IMAGE_EXTENSION:Ljava/lang/String; = "_image"

.field public static final VIDEO_BIT_RATE:I

.field public static final VIDEO_CONTAINER_EXT:Ljava/lang/String;

.field private static sEncoderConfig:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

.field private static sGenericConfig:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 33
    const-string v1, "sw"

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    const-string v2, "hw"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    sput-boolean v1, Lco/vine/android/recorder/RecordConfigUtils;->HW_ENABLED:Z

    .line 34
    const-string v1, "sw"

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    const-string v2, "sw"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    sput-boolean v1, Lco/vine/android/recorder/RecordConfigUtils;->SW_ENABLED:Z

    .line 250
    sget-object v1, Lco/vine/android/recorder/RecordSessionManager;->DEFAULT_VERSION:Lco/vine/android/recorder/RecordSessionVersion;

    iget-boolean v1, v1, Lco/vine/android/recorder/RecordSessionVersion;->willEventuallyTranscoded:Z

    if-eqz v1, :cond_1

    const v1, 0x1e8480

    :goto_0
    sput v1, Lco/vine/android/recorder/RecordConfigUtils;->VIDEO_BIT_RATE:I

    .line 251
    sget-object v1, Lco/vine/android/recorder/RecordSessionManager;->DEFAULT_VERSION:Lco/vine/android/recorder/RecordSessionVersion;

    iget-boolean v1, v1, Lco/vine/android/recorder/RecordSessionVersion;->willEventuallyTranscoded:Z

    if-eqz v1, :cond_2

    const v1, 0x1f400

    :goto_1
    sput v1, Lco/vine/android/recorder/RecordConfigUtils;->AUDIO_BIT_RATE:I

    .line 263
    const v1, 0xac44

    const/16 v2, 0x10

    const/4 v3, 0x2

    invoke-static {v1, v2, v3}, Landroid/media/AudioRecord;->getMinBufferSize(III)I

    move-result v1

    sput v1, Lco/vine/android/recorder/RecordConfigUtils;->AUDIO_BUFFER_SIZE:I

    .line 265
    sget v1, Lco/vine/android/recorder/RecordConfigUtils;->AUDIO_BUFFER_SIZE:I

    if-lez v1, :cond_3

    sget v1, Lco/vine/android/recorder/RecordConfigUtils;->AUDIO_BUFFER_SIZE:I

    :goto_2
    sput v1, Lco/vine/android/recorder/RecordConfigUtils;->AUDIO_RUNNABLE_SAMPLE_SIZE:I

    .line 267
    sget-object v1, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    sput-object v1, Lco/vine/android/recorder/RecordConfigUtils;->DEFAULT_BITMAP_CONFIG:Landroid/graphics/Bitmap$Config;

    .line 269
    sget-object v1, Lco/vine/android/recorder/RecordSessionManager;->DEFAULT_VERSION:Lco/vine/android/recorder/RecordSessionVersion;

    iget-object v1, v1, Lco/vine/android/recorder/RecordSessionVersion;->videoOutputExtension:Ljava/lang/String;

    sput-object v1, Lco/vine/android/recorder/RecordConfigUtils;->VIDEO_CONTAINER_EXT:Ljava/lang/String;

    .line 279
    :try_start_0
    sget-object v1, Landroid/os/Environment;->DIRECTORY_DCIM:Ljava/lang/String;

    sput-object v1, Lco/vine/android/recorder/RecordConfigUtils;->DCIM:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 286
    .local v0, "e":Ljava/lang/Exception;
    :goto_3
    new-instance v1, Ljava/io/File;

    sget-object v2, Lco/vine/android/recorder/RecordConfigUtils;->DCIM:Ljava/lang/String;

    invoke-static {v2}, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    const-string v3, "Vine"

    invoke-direct {v1, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lco/vine/android/recorder/RecordConfigUtils;->FOLDER_ROOT_SAVE:Ljava/lang/String;

    .line 288
    new-instance v1, Ljava/io/File;

    sget-object v2, Lco/vine/android/recorder/RecordConfigUtils;->DCIM:Ljava/lang/String;

    invoke-static {v2}, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    const-string v3, "vine_capture"

    invoke-direct {v1, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    sput-object v1, Lco/vine/android/recorder/RecordConfigUtils;->FOLDER_ROOT_PROCESS_DEBUG:Ljava/io/File;

    .line 290
    new-instance v1, Ljava/io/File;

    sget-object v2, Lco/vine/android/recorder/RecordConfigUtils;->DCIM:Ljava/lang/String;

    invoke-static {v2}, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    const-string v3, "vine_upload"

    invoke-direct {v1, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    sput-object v1, Lco/vine/android/recorder/RecordConfigUtils;->FOLDER_ROOT_DIRECT_UPLOAD:Ljava/io/File;

    .line 294
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 295
    sget-object v1, Lco/vine/android/recorder/RecordConfigUtils;->FOLDER_ROOT_DIRECT_UPLOAD:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->mkdirs()Z

    .line 297
    :cond_0
    return-void

    .line 250
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    const v1, 0xf4240

    goto :goto_0

    .line 251
    :cond_2
    const v1, 0xfa00

    goto :goto_1

    .line 265
    :cond_3
    const/16 v1, 0x1e00

    goto :goto_2

    .line 280
    :catch_0
    move-exception v0

    .line 281
    .restart local v0    # "e":Ljava/lang/Exception;
    const-string v1, "DCIM"

    sput-object v1, Lco/vine/android/recorder/RecordConfigUtils;->DCIM:Ljava/lang/String;

    goto :goto_3
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    return-void
.end method

.method static synthetic access$000()Ljava/io/File;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lco/vine/android/recorder/RecordConfigUtils;->FOLDER_ROOT_PROCESS_DEBUG:Ljava/io/File;

    return-object v0
.end method

.method public static copyForUpload(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    .locals 2
    .param p0, "dir"    # Ljava/io/File;
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "fileName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 402
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 403
    .local v0, "actualFile":Ljava/io/File;
    invoke-static {p0, p2}, Lco/vine/android/recorder/RecordConfigUtils;->getUploadFile(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    .line 404
    .local v1, "finalName":Ljava/io/File;
    invoke-static {v0, v1}, Lorg/apache/commons/io/FileUtils;->copyFile(Ljava/io/File;Ljava/io/File;)V

    .line 405
    return-object v1
.end method

.method public static copySilently(Ljava/io/File;Ljava/io/File;)Z
    .locals 2
    .param p0, "from"    # Ljava/io/File;
    .param p1, "to"    # Ljava/io/File;

    .prologue
    .line 371
    :try_start_0
    invoke-static {p0, p1}, Lorg/apache/commons/io/FileUtils;->copyFile(Ljava/io/File;Ljava/io/File;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 376
    const/4 v1, 0x1

    :goto_0
    return v1

    .line 372
    :catch_0
    move-exception v0

    .line 373
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Failed to copy"

    invoke-static {v1, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 374
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static createAudioArray(Lco/vine/android/recorder/AudioArray$AudioArrayType;)Lco/vine/android/recorder/AudioArray;
    .locals 2
    .param p0, "type"    # Lco/vine/android/recorder/AudioArray$AudioArrayType;

    .prologue
    .line 56
    new-instance v0, Lco/vine/android/recorder/AudioArray;

    sget v1, Lco/vine/android/recorder/RecordConfigUtils;->AUDIO_RUNNABLE_SAMPLE_SIZE:I

    invoke-direct {v0, v1, p0}, Lco/vine/android/recorder/AudioArray;-><init>(ILco/vine/android/recorder/AudioArray$AudioArrayType;)V

    return-object v0
.end method

.method public static createDefaultSizeBitmap()Landroid/graphics/Bitmap;
    .locals 2

    .prologue
    const/16 v1, 0x1e0

    .line 452
    sget-object v0, Lco/vine/android/recorder/RecordConfigUtils;->DEFAULT_BITMAP_CONFIG:Landroid/graphics/Bitmap$Config;

    invoke-static {v1, v1, v0}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public static deleteNonFolders(Ljava/io/File;)V
    .locals 5
    .param p0, "f"    # Ljava/io/File;

    .prologue
    .line 351
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 352
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v0

    .local v0, "arr$":[Ljava/io/File;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 353
    .local v1, "c":Ljava/io/File;
    invoke-static {v1}, Lco/vine/android/recorder/RecordConfigUtils;->deleteNonFolders(Ljava/io/File;)V

    .line 352
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 356
    .end local v0    # "arr$":[Ljava/io/File;
    .end local v1    # "c":Ljava/io/File;
    .end local v2    # "i$":I
    .end local v3    # "len$":I
    :cond_0
    return-void
.end method

.method public static deletePreProcess(Ljava/io/File;)V
    .locals 2
    .param p0, "root"    # Ljava/io/File;

    .prologue
    .line 347
    new-instance v0, Ljava/io/File;

    const-string v1, "process"

    invoke-direct {v0, p0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-static {v0}, Lco/vine/android/recorder/RecordConfigUtils;->deleteNonFolders(Ljava/io/File;)V

    .line 348
    return-void
.end method

.method public static declared-synchronized getCameraRollFile(Landroid/content/Context;JLjava/lang/String;)Ljava/io/File;
    .locals 12
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "startTime"    # J
    .param p3, "extension"    # Ljava/lang/String;

    .prologue
    .line 420
    const-class v11, Lco/vine/android/recorder/RecordConfigUtils;

    monitor-enter v11

    const/4 v9, 0x0

    .line 421
    .local v9, "mediaStorageDir":Ljava/io/File;
    :try_start_0
    const-string v0, "mounted"

    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 422
    new-instance v10, Ljava/io/File;

    sget-object v0, Lco/vine/android/recorder/RecordConfigUtils;->FOLDER_ROOT_SAVE:Ljava/lang/String;

    invoke-direct {v10, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .end local v9    # "mediaStorageDir":Ljava/io/File;
    .local v10, "mediaStorageDir":Ljava/io/File;
    move-object v9, v10

    .line 435
    .end local v10    # "mediaStorageDir":Ljava/io/File;
    .restart local v9    # "mediaStorageDir":Ljava/io/File;
    :cond_0
    :goto_0
    if-nez v9, :cond_2

    .line 436
    const/4 v0, 0x0

    .line 447
    :goto_1
    monitor-exit v11

    return-object v0

    .line 425
    :cond_1
    const/4 v0, 0x3

    :try_start_1
    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "_id"

    aput-object v1, v2, v0

    const/4 v0, 0x1

    const-string v1, "_data"

    aput-object v1, v2, v0

    const/4 v0, 0x2

    const-string v1, "datetaken"

    aput-object v1, v2, v0

    .line 426
    .local v2, "projection":[Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Landroid/provider/MediaStore$Images$Media;->INTERNAL_CONTENT_URI:Landroid/net/Uri;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const-string v5, "datetaken DESC"

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 427
    .local v6, "cursor":Landroid/database/Cursor;
    if-eqz v6, :cond_0

    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 428
    new-instance v10, Ljava/io/File;

    new-instance v0, Ljava/io/File;

    const-string v1, "_data"

    invoke-interface {v6, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v6, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v0

    const-string v1, "Vine"

    invoke-direct {v10, v0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .end local v9    # "mediaStorageDir":Ljava/io/File;
    .restart local v10    # "mediaStorageDir":Ljava/io/File;
    move-object v9, v10

    .end local v10    # "mediaStorageDir":Ljava/io/File;
    .restart local v9    # "mediaStorageDir":Ljava/io/File;
    goto :goto_0

    .line 430
    .end local v2    # "projection":[Ljava/lang/String;
    .end local v6    # "cursor":Landroid/database/Cursor;
    :catch_0
    move-exception v7

    .line 431
    .local v7, "e":Ljava/lang/Exception;
    :try_start_2
    const-string v0, "Failed to get internal path"

    invoke-static {v0, v7}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 420
    .end local v7    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    monitor-exit v11

    throw v0

    .line 439
    :cond_2
    :try_start_3
    invoke-virtual {v9}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_3

    .line 440
    invoke-virtual {v9}, Ljava/io/File;->mkdirs()Z

    move-result v0

    if-nez v0, :cond_3

    .line 441
    const-string v0, "Failed to make dirs."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 442
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Failed to make directories. You will be doomed."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 443
    const/4 v0, 0x0

    goto :goto_1

    .line 446
    :cond_3
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy_MM_dd_HH_mm_sss"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    .line 447
    .local v8, "fileName":Ljava/lang/String;
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "."

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_1
.end method

.method public static getEncoderConfiguration()Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;
    .locals 1

    .prologue
    .line 60
    sget-object v0, Lco/vine/android/recorder/RecordConfigUtils;->sEncoderConfig:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    if-nez v0, :cond_0

    .line 61
    new-instance v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    invoke-direct {v0}, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;-><init>()V

    sput-object v0, Lco/vine/android/recorder/RecordConfigUtils;->sEncoderConfig:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    .line 67
    :cond_0
    sget-object v0, Lco/vine/android/recorder/RecordConfigUtils;->sEncoderConfig:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    return-object v0
.end method

.method public static getFrameInfoPath(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "path"    # Ljava/lang/String;

    .prologue
    .line 397
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".info"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getGenericConfig(Landroid/content/Context;)Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 49
    sget-object v0, Lco/vine/android/recorder/RecordConfigUtils;->sGenericConfig:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    if-nez v0, :cond_0

    .line 50
    new-instance v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    invoke-direct {v0, p0}, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;-><init>(Landroid/content/Context;)V

    sput-object v0, Lco/vine/android/recorder/RecordConfigUtils;->sGenericConfig:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    .line 52
    :cond_0
    sget-object v0, Lco/vine/android/recorder/RecordConfigUtils;->sGenericConfig:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    return-object v0
.end method

.method public static getMaxAudioBufferSize(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;)I
    .locals 4
    .param p0, "config"    # Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    .prologue
    .line 307
    iget v0, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->maxDuration:I

    mul-int/lit8 v0, v0, 0x30

    int-to-double v0, v0

    const-wide v2, 0x3ff199999999999aL    # 1.1

    mul-double/2addr v0, v2

    double-to-int v0, v0

    return v0
.end method

.method public static declared-synchronized getPreProcessFile(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    .locals 2
    .param p0, "config"    # Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .param p1, "folder"    # Ljava/lang/String;
    .param p2, "id"    # Ljava/lang/String;
    .param p3, "extension"    # Ljava/lang/String;

    .prologue
    .line 468
    const-class v1, Lco/vine/android/recorder/RecordConfigUtils;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->processDir:Ljava/io/File;

    invoke-static {v0, p1, p2, p3}, Lco/vine/android/recorder/RecordConfigUtils;->getPreProcessFile(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized getPreProcessFile(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    .locals 6
    .param p0, "dir"    # Ljava/io/File;
    .param p1, "folder"    # Ljava/lang/String;
    .param p2, "id"    # Ljava/lang/String;
    .param p3, "extension"    # Ljava/lang/String;

    .prologue
    .line 456
    const-class v2, Lco/vine/android/recorder/RecordConfigUtils;

    monitor-enter v2

    :try_start_0
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/io/File;

    const-string v3, "process"

    invoke-direct {v1, p0, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-direct {v0, v1, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 457
    .local v0, "mediaStorageDir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_0

    .line 458
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    move-result v1

    if-nez v1, :cond_0

    .line 459
    const-string v1, "Failed to make dirs."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 460
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v3, "Failed to make directories. You will be doomed."

    invoke-direct {v1, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 456
    .end local v0    # "mediaStorageDir":Ljava/io/File;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1

    .line 463
    .restart local v0    # "mediaStorageDir":Ljava/io/File;
    :cond_0
    :try_start_1
    new-instance v3, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v4, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    if-eqz p3, :cond_1

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "."

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_0
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v3, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit v2

    return-object v3

    :cond_1
    :try_start_2
    const-string v1, ""
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method public static getThumbnailPath(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "path"    # Ljava/lang/String;

    .prologue
    .line 393
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "_image"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getTimeStampInNsFromSampleCounted(I)I
    .locals 4
    .param p0, "currentCount"    # I

    .prologue
    .line 311
    int-to-double v0, p0

    const-wide v2, 0x3fa694467381d7dcL    # 0.0441

    div-double/2addr v0, v2

    double-to-int v0, v0

    return v0
.end method

.method private static declared-synchronized getUploadFile(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    .locals 4
    .param p0, "root"    # Ljava/io/File;
    .param p1, "fileName"    # Ljava/lang/String;

    .prologue
    .line 409
    const-class v2, Lco/vine/android/recorder/RecordConfigUtils;

    monitor-enter v2

    :try_start_0
    new-instance v0, Ljava/io/File;

    const-string v1, "upload"

    invoke-direct {v0, p0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 410
    .local v0, "mediaStorageDir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_0

    .line 411
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    move-result v1

    if-nez v1, :cond_0

    .line 412
    const-string v1, "Failed to make dirs: {},"

    invoke-static {v1, p1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 413
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v3, "Failed to make directories. You will be doomed."

    invoke-direct {v1, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 409
    .end local v0    # "mediaStorageDir":Ljava/io/File;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1

    .line 416
    .restart local v0    # "mediaStorageDir":Ljava/io/File;
    :cond_0
    :try_start_1
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v0, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit v2

    return-object v1
.end method

.method public static getVideoBufferMax(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;)I
    .locals 4
    .param p0, "config"    # Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    .prologue
    .line 315
    sget v0, Lco/vine/android/recorder/RecordConfigUtils;->VIDEO_BIT_RATE:I

    int-to-double v0, v0

    const-wide v2, 0x3ff199999999999aL    # 1.1

    mul-double/2addr v0, v2

    iget v2, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->maxDuration:I

    int-to-double v2, v2

    mul-double/2addr v0, v2

    const-wide v2, 0x408f400000000000L    # 1000.0

    div-double/2addr v0, v2

    double-to-int v0, v0

    return v0
.end method

.method public static isDefaultFrontFacing()Z
    .locals 1

    .prologue
    .line 359
    invoke-static {}, Lco/vine/android/recorder/CameraManager;->hasBackFacingCamera()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isFastEncoding(Z)Z
    .locals 2
    .param p0, "hardwareEncoding"    # Z

    .prologue
    .line 71
    if-eqz p0, :cond_0

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static loadWasEverSuccessful(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v3, 0x0

    .line 380
    const-class v2, Lco/vine/android/recorder/SwVineFrameRecorder;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    .line 381
    .local v0, "name":Ljava/lang/String;
    invoke-virtual {p0, v0, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 382
    .local v1, "prefs":Landroid/content/SharedPreferences;
    const-string v2, "canLoad"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    return v2
.end method

.method public static newVideoRecorder(Landroid/content/Context;Ljava/lang/String;I)Lco/vine/android/recorder/HwVineFrameRecorder;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "output"    # Ljava/lang/String;
    .param p2, "frameRate"    # I

    .prologue
    .line 339
    new-instance v0, Lco/vine/android/recorder/HwVineFrameRecorder;

    invoke-direct {v0, p0, p1, p2}, Lco/vine/android/recorder/HwVineFrameRecorder;-><init>(Landroid/content/Context;Ljava/lang/String;I)V

    return-object v0
.end method

.method public static newVideoRecorder(Ljava/lang/String;IILcom/googlecode/javacv/cpp/avcodec$AVPacket;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;Z)Lco/vine/android/recorder/SwVineFrameRecorder;
    .locals 7
    .param p0, "output"    # Ljava/lang/String;
    .param p1, "frameRate"    # I
    .param p2, "targetSize"    # I
    .param p3, "videoPacket"    # Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    .param p4, "audioPacket"    # Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    .param p5, "useMp4"    # Z

    .prologue
    .line 320
    new-instance v0, Lco/vine/android/recorder/SwVineFrameRecorder;

    const/4 v4, 0x1

    move-object v1, p0

    move v2, p2

    move v3, p2

    move-object v5, p3

    move-object v6, p4

    invoke-direct/range {v0 .. v6}, Lco/vine/android/recorder/SwVineFrameRecorder;-><init>(Ljava/lang/String;IIILcom/googlecode/javacv/cpp/avcodec$AVPacket;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)V

    .line 321
    .local v0, "recorder":Lco/vine/android/recorder/SwVineFrameRecorder;
    const-string v1, "libvorbis"

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/SwVineFrameRecorder;->setAudioCodecName(Ljava/lang/String;)V

    .line 322
    const-string v1, "libvpx"

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/SwVineFrameRecorder;->setVideoCodecName(Ljava/lang/String;)V

    .line 323
    const-string v1, "webm"

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/SwVineFrameRecorder;->setFormat(Ljava/lang/String;)V

    .line 324
    const v1, 0xac44

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/SwVineFrameRecorder;->setSampleRate(I)V

    .line 325
    int-to-double v1, p1

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/SwVineFrameRecorder;->setFrameRate(D)V

    .line 326
    return-object v0
.end method

.method public static newVideoRecorder(Ljava/lang/String;IIZ)Lco/vine/android/recorder/SwVineFrameRecorder;
    .locals 6
    .param p0, "output"    # Ljava/lang/String;
    .param p1, "frameRate"    # I
    .param p2, "targetSize"    # I
    .param p3, "useMp4"    # Z

    .prologue
    const/4 v3, 0x0

    .line 343
    move-object v0, p0

    move v1, p1

    move v2, p2

    move-object v4, v3

    move v5, p3

    invoke-static/range {v0 .. v5}, Lco/vine/android/recorder/RecordConfigUtils;->newVideoRecorder(Ljava/lang/String;IILcom/googlecode/javacv/cpp/avcodec$AVPacket;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;Z)Lco/vine/android/recorder/SwVineFrameRecorder;

    move-result-object v0

    return-object v0
.end method

.method public static setLoadWasEverSuccessful(Landroid/content/Context;Z)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "canLoad"    # Z

    .prologue
    .line 386
    if-nez p0, :cond_0

    .line 390
    :goto_0
    return-void

    .line 389
    :cond_0
    const-class v0, Lco/vine/android/recorder/SwVineFrameRecorder;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "canLoad"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0
.end method
