.class public Lco/vine/android/util/MediaUtil;
.super Ljava/lang/Object;
.source "MediaUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;,
        Lco/vine/android/util/MediaUtil$MediaConnectionClient;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 97
    return-void
.end method

.method public static generateThumbnails(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p0, "duration"    # J
    .param p2, "videoPath"    # Ljava/lang/String;
    .param p3, "thumbnailPath"    # Ljava/lang/String;
    .param p4, "lastFramePath"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .prologue
    .line 122
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 124
    .local v2, "start":J
    const-string v4, "Use duration: {}."

    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 126
    if-eqz p4, :cond_4

    const/4 v4, 0x2

    new-array v4, v4, [J

    const/4 v5, 0x0

    const-wide/16 v6, 0x0

    aput-wide v6, v4, v5

    const/4 v5, 0x1

    aput-wide p0, v4, v5

    :goto_0
    invoke-static {p2, v4}, Lco/vine/android/util/MediaUtil;->getVideoFrames(Ljava/lang/String;[J)[Landroid/graphics/Bitmap;

    move-result-object v0

    .line 131
    .local v0, "bitmaps":[Landroid/graphics/Bitmap;
    const-string v4, "Grabbing using MediaUtil took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    sub-long/2addr v5, v2

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;)V

    .line 133
    if-eqz v0, :cond_2

    .line 134
    array-length v4, v0

    if-eqz v4, :cond_0

    const/4 v4, 0x0

    aget-object v4, v0, v4

    if-nez v4, :cond_1

    .line 135
    :cond_0
    const-string v4, "Mayday, mayday! Failed to get thumbnails, this will fail and crash: {}."

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object p2, v5, v6

    invoke-static {v4, v5}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 137
    :cond_1
    const/4 v4, 0x0

    aget-object v4, v0, v4

    sget-object v5, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v6, 0x4b

    new-instance v7, Ljava/io/FileOutputStream;

    invoke-direct {v7, p3}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v5, v6, v7}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 138
    if-eqz p4, :cond_2

    .line 139
    const/4 v4, 0x1

    aget-object v4, v0, v4

    if-eqz v4, :cond_5

    .line 140
    const/4 v4, 0x1

    aget-object v4, v0, v4

    sget-object v5, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v6, 0x4b

    new-instance v7, Ljava/io/FileOutputStream;

    invoke-direct {v7, p4}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v5, v6, v7}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 147
    :cond_2
    :goto_1
    :try_start_0
    new-instance v4, Ljava/io/File;

    invoke-direct {v4, p3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_3

    .line 148
    const-string v4, "Retry generating thumbnail."

    invoke-static {v4}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 149
    const/4 v4, 0x1

    new-array v4, v4, [J

    const/4 v5, 0x0

    const-wide/16 v6, 0x0

    aput-wide v6, v4, v5

    invoke-static {p2, v4}, Lco/vine/android/util/MediaUtil;->getVideoFrames(Ljava/lang/String;[J)[Landroid/graphics/Bitmap;

    move-result-object v0

    .line 150
    if-eqz v0, :cond_6

    array-length v4, v0

    const/4 v5, 0x1

    if-ne v4, v5, :cond_6

    .line 151
    const/4 v4, 0x0

    aget-object v4, v0, v4

    sget-object v5, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v6, 0x4b

    new-instance v7, Ljava/io/FileOutputStream;

    invoke-direct {v7, p3}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v5, v6, v7}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 152
    const-string v4, "First Thumbnail generated."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 160
    :cond_3
    :goto_2
    return-void

    .line 126
    .end local v0    # "bitmaps":[Landroid/graphics/Bitmap;
    :cond_4
    const/4 v4, 0x1

    new-array v4, v4, [J

    const/4 v5, 0x0

    const-wide/16 v6, 0x0

    aput-wide v6, v4, v5

    goto/16 :goto_0

    .line 142
    .restart local v0    # "bitmaps":[Landroid/graphics/Bitmap;
    :cond_5
    new-instance v4, Lco/vine/android/VineLoggingException;

    const-string v5, "FAILED TO GENERATE GHOST IMAGE"

    invoke-direct {v4, v5}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-static {v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 154
    :cond_6
    :try_start_1
    new-instance v4, Ljava/lang/IllegalStateException;

    invoke-direct {v4}, Ljava/lang/IllegalStateException;-><init>()V

    throw v4
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 157
    :catch_0
    move-exception v1

    .line 158
    .local v1, "e":Ljava/lang/Exception;
    const-string v4, "Failed to generate thumbnail."

    invoke-static {v4}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_2
.end method

.method public static getVideoFrames(Ljava/lang/String;[J)[Landroid/graphics/Bitmap;
    .locals 14
    .param p0, "videoPath"    # Ljava/lang/String;
    .param p1, "frameTime"    # [J

    .prologue
    .line 30
    new-instance v9, Landroid/media/MediaMetadataRetriever;

    invoke-direct {v9}, Landroid/media/MediaMetadataRetriever;-><init>()V

    .line 32
    .local v9, "retriever":Landroid/media/MediaMetadataRetriever;
    :try_start_0
    invoke-virtual {v9, p0}, Landroid/media/MediaMetadataRetriever;->setDataSource(Ljava/lang/String;)V

    .line 33
    array-length v12, p1

    new-array v8, v12, [Landroid/graphics/Bitmap;

    .line 34
    .local v8, "r":[Landroid/graphics/Bitmap;
    const/4 v5, 0x0

    .line 35
    .local v5, "i":I
    const-wide/16 v1, -0x1

    .line 36
    .local v1, "duration":J
    move-object v0, p1

    .local v0, "arr$":[J
    array-length v7, v0

    .local v7, "len$":I
    const/4 v6, 0x0

    .local v6, "i$":I
    :goto_0
    if-ge v6, v7, :cond_3

    aget-wide v10, v0, v6

    .line 37
    .local v10, "time":J
    const-wide/16 v12, -0x1

    cmp-long v12, v10, v12

    if-nez v12, :cond_1

    .line 38
    const-wide/16 v12, -0x1

    cmp-long v12, v1, v12

    if-nez v12, :cond_0

    .line 39
    const/16 v12, 0x9

    invoke-virtual {v9, v12}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v3

    .line 40
    .local v3, "durationString":Ljava/lang/String;
    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v1

    .line 41
    const-string v12, "Got duration: {}."

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    invoke-static {v12, v13}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 43
    .end local v3    # "durationString":Ljava/lang/String;
    :cond_0
    const-wide/16 v12, 0x3e8

    mul-long v10, v1, v12

    .line 45
    :cond_1
    const/4 v12, 0x1

    invoke-virtual {v9, v10, v11, v12}, Landroid/media/MediaMetadataRetriever;->getFrameAtTime(JI)Landroid/graphics/Bitmap;

    move-result-object v12

    aput-object v12, v8, v5

    .line 46
    aget-object v12, v8, v5

    if-nez v12, :cond_2

    .line 47
    const/4 v12, 0x3

    invoke-virtual {v9, v10, v11, v12}, Landroid/media/MediaMetadataRetriever;->getFrameAtTime(JI)Landroid/graphics/Bitmap;

    move-result-object v12

    aput-object v12, v8, v5

    .line 50
    :cond_2
    add-int/lit8 v5, v5, 0x1

    .line 51
    const-string v12, "Got frame at {}ms."

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    invoke-static {v12, v13}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 36
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 58
    .end local v10    # "time":J
    :cond_3
    :try_start_1
    invoke-virtual {v9}, Landroid/media/MediaMetadataRetriever;->release()V
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_0

    .line 63
    .end local v0    # "arr$":[J
    .end local v1    # "duration":J
    .end local v5    # "i":I
    .end local v6    # "i$":I
    .end local v7    # "len$":I
    .end local v8    # "r":[Landroid/graphics/Bitmap;
    :goto_1
    return-object v8

    .line 59
    .restart local v0    # "arr$":[J
    .restart local v1    # "duration":J
    .restart local v5    # "i":I
    .restart local v6    # "i$":I
    .restart local v7    # "len$":I
    .restart local v8    # "r":[Landroid/graphics/Bitmap;
    :catch_0
    move-exception v4

    .line 60
    .local v4, "e":Ljava/lang/RuntimeException;
    const-string v12, "Failed to release."

    invoke-static {v12, v4}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 54
    .end local v0    # "arr$":[J
    .end local v1    # "duration":J
    .end local v4    # "e":Ljava/lang/RuntimeException;
    .end local v5    # "i":I
    .end local v6    # "i$":I
    .end local v7    # "len$":I
    .end local v8    # "r":[Landroid/graphics/Bitmap;
    :catch_1
    move-exception v4

    .line 55
    .restart local v4    # "e":Ljava/lang/RuntimeException;
    :try_start_2
    const-string v12, "Failed to get frame."

    invoke-static {v12, v4}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 58
    :try_start_3
    invoke-virtual {v9}, Landroid/media/MediaMetadataRetriever;->release()V
    :try_end_3
    .catch Ljava/lang/RuntimeException; {:try_start_3 .. :try_end_3} :catch_2

    .line 63
    :goto_2
    const/4 v8, 0x0

    goto :goto_1

    .line 59
    :catch_2
    move-exception v4

    .line 60
    const-string v12, "Failed to release."

    invoke-static {v12, v4}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_2

    .line 57
    .end local v4    # "e":Ljava/lang/RuntimeException;
    :catchall_0
    move-exception v12

    .line 58
    :try_start_4
    invoke-virtual {v9}, Landroid/media/MediaMetadataRetriever;->release()V
    :try_end_4
    .catch Ljava/lang/RuntimeException; {:try_start_4 .. :try_end_4} :catch_3

    .line 61
    :goto_3
    throw v12

    .line 59
    :catch_3
    move-exception v4

    .line 60
    .restart local v4    # "e":Ljava/lang/RuntimeException;
    const-string v13, "Failed to release."

    invoke-static {v13, v4}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_3
.end method

.method public static scanFile(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "file"    # Ljava/io/File;
    .param p2, "mimeType"    # Ljava/lang/String;

    .prologue
    .line 67
    new-instance v0, Lco/vine/android/util/MediaUtil$MediaConnectionClient;

    invoke-virtual {p1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2, p2}, Lco/vine/android/util/MediaUtil$MediaConnectionClient;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 68
    .local v0, "client":Lco/vine/android/util/MediaUtil$MediaConnectionClient;
    new-instance v1, Landroid/media/MediaScannerConnection;

    invoke-direct {v1, p0, v0}, Landroid/media/MediaScannerConnection;-><init>(Landroid/content/Context;Landroid/media/MediaScannerConnection$MediaScannerConnectionClient;)V

    .line 69
    .local v1, "connection":Landroid/media/MediaScannerConnection;
    iput-object v1, v0, Lco/vine/android/util/MediaUtil$MediaConnectionClient;->connection:Landroid/media/MediaScannerConnection;

    .line 70
    invoke-virtual {v1}, Landroid/media/MediaScannerConnection;->connect()V

    .line 71
    return-void
.end method
