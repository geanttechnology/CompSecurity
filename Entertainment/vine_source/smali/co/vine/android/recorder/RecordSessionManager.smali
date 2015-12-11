.class public Lco/vine/android/recorder/RecordSessionManager;
.super Ljava/lang/Object;
.source "RecordSessionManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;,
        Lco/vine/android/recorder/RecordSessionManager$NotEnoughSpaceException;
    }
.end annotation


# static fields
.field public static DEFAULT_VERSION:Lco/vine/android/recorder/RecordSessionVersion; = null

.field private static final REQUIRED_SPACE_LIMIT:I = 0x1400000

.field private static final sDeletedSessions:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mDir:Ljava/io/File;

.field private final mVersion:Lco/vine/android/recorder/RecordSessionVersion;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 41
    sget-object v0, Lco/vine/android/recorder/RecordSessionVersion;->SW_WEBM:Lco/vine/android/recorder/RecordSessionVersion;

    sput-object v0, Lco/vine/android/recorder/RecordSessionManager;->DEFAULT_VERSION:Lco/vine/android/recorder/RecordSessionVersion;

    .line 44
    sget-object v0, Lco/vine/android/recorder/RecordSessionManager;->DEFAULT_VERSION:Lco/vine/android/recorder/RecordSessionVersion;

    sget-object v1, Lco/vine/android/recorder/RecordSessionVersion;->HW:Lco/vine/android/recorder/RecordSessionVersion;

    if-ne v0, v1, :cond_0

    sget-boolean v0, Lco/vine/android/recorder/RecordConfigUtils;->HW_ENABLED:Z

    if-nez v0, :cond_0

    .line 45
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalidate version type, HW Encoding is off."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 47
    :cond_0
    sget-object v0, Lco/vine/android/recorder/RecordSessionManager;->DEFAULT_VERSION:Lco/vine/android/recorder/RecordSessionVersion;

    sget-object v1, Lco/vine/android/recorder/RecordSessionVersion;->HW:Lco/vine/android/recorder/RecordSessionVersion;

    if-eq v0, v1, :cond_1

    sget-boolean v0, Lco/vine/android/recorder/RecordConfigUtils;->SW_ENABLED:Z

    if-nez v0, :cond_1

    .line 48
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalidate version type, HW Encoding is on."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 56
    :cond_1
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lco/vine/android/recorder/RecordSessionManager;->sDeletedSessions:Ljava/util/HashSet;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lco/vine/android/recorder/RecordSessionVersion;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "version"    # Lco/vine/android/recorder/RecordSessionVersion;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    iput-object p2, p0, Lco/vine/android/recorder/RecordSessionManager;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    .line 69
    const/4 v2, 0x0

    .line 71
    .local v2, "root":Ljava/io/File;
    const/4 v3, 0x0

    :try_start_0
    invoke-virtual {p1, v3}, Landroid/content/Context;->getExternalFilesDir(Ljava/lang/String;)Ljava/io/File;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v2

    .line 75
    :goto_0
    if-nez v2, :cond_0

    .line 76
    const-string v3, "Failed to create drafts in external folder."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    .line 77
    invoke-virtual {p1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v2

    .line 79
    :cond_0
    new-instance v3, Ljava/io/File;

    iget-object v4, p2, Lco/vine/android/recorder/RecordSessionVersion;->folder:Ljava/lang/String;

    invoke-direct {v3, v2, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v3, p0, Lco/vine/android/recorder/RecordSessionManager;->mDir:Ljava/io/File;

    .line 80
    iget-object v3, p0, Lco/vine/android/recorder/RecordSessionManager;->mDir:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 81
    iget-object v3, p0, Lco/vine/android/recorder/RecordSessionManager;->mDir:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->isDirectory()Z

    move-result v3

    if-nez v3, :cond_1

    .line 82
    iget-object v3, p0, Lco/vine/android/recorder/RecordSessionManager;->mDir:Ljava/io/File;

    invoke-static {v3}, Lorg/apache/commons/io/FileUtils;->forceDelete(Ljava/io/File;)V

    .line 85
    :cond_1
    iget-object v3, p0, Lco/vine/android/recorder/RecordSessionManager;->mDir:Ljava/io/File;

    invoke-static {v3}, Lorg/apache/commons/io/FileUtils;->forceMkdir(Ljava/io/File;)V

    .line 87
    :try_start_1
    iget-object v3, p0, Lco/vine/android/recorder/RecordSessionManager;->mDir:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->getFreeSpace()J

    move-result-wide v0

    .line 88
    .local v0, "freeBytes":J
    const-wide/16 v3, 0x0

    cmp-long v3, v0, v3

    if-lez v3, :cond_2

    const-wide/32 v3, 0x1400000

    cmp-long v3, v0, v3

    if-gez v3, :cond_2

    .line 89
    new-instance v3, Lco/vine/android/recorder/RecordSessionManager$NotEnoughSpaceException;

    invoke-direct {v3}, Lco/vine/android/recorder/RecordSessionManager$NotEnoughSpaceException;-><init>()V

    throw v3

    .line 93
    .end local v0    # "freeBytes":J
    :catch_0
    move-exception v3

    .line 96
    :goto_1
    return-void

    .line 91
    .restart local v0    # "freeBytes":J
    :cond_2
    const-string v3, "free space left: {}."

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 72
    .end local v0    # "freeBytes":J
    :catch_1
    move-exception v3

    goto :goto_0
.end method

.method public static deleteSession(Ljava/io/File;Ljava/lang/String;)V
    .locals 3
    .param p0, "folder"    # Ljava/io/File;
    .param p1, "reason"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 290
    const-string v0, "Session deleted: {}, {}."

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    invoke-static {v0, v1}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 291
    sget-object v0, Lco/vine/android/recorder/RecordSessionManager;->sDeletedSessions:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->size()I

    move-result v0

    const/16 v1, 0xa

    if-le v0, v1, :cond_0

    .line 292
    sget-object v0, Lco/vine/android/recorder/RecordSessionManager;->sDeletedSessions:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->clear()V

    .line 294
    :cond_0
    sget-object v0, Lco/vine/android/recorder/RecordSessionManager;->sDeletedSessions:Ljava/util/HashSet;

    invoke-virtual {p0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 295
    invoke-static {p0}, Lorg/apache/commons/io/FileUtils;->deleteDirectory(Ljava/io/File;)V

    .line 296
    return-void
.end method

.method public static getCurrentVersion(Landroid/content/Context;)Lco/vine/android/recorder/RecordSessionVersion;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
        .annotation build Lorg/jetbrains/annotations/Nullable;
        .end annotation
    .end param

    .prologue
    .line 61
    sget-object v0, Lco/vine/android/recorder/RecordSessionManager;->DEFAULT_VERSION:Lco/vine/android/recorder/RecordSessionVersion;

    return-object v0
.end method

.method public static getDataFile(Ljava/io/File;Z)Ljava/io/File;
    .locals 2
    .param p0, "folder"    # Ljava/io/File;
    .param p1, "isFinal"    # Z

    .prologue
    .line 258
    new-instance v1, Ljava/io/File;

    if-eqz p1, :cond_0

    const-string v0, "data.bin"

    :goto_0
    invoke-direct {v1, p0, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    return-object v1

    :cond_0
    const-string v0, "data.temp"

    goto :goto_0
.end method

.method public static getFrameInfoFile(Ljava/io/File;)Ljava/io/File;
    .locals 2
    .param p0, "folder"    # Ljava/io/File;

    .prologue
    .line 254
    new-instance v0, Ljava/io/File;

    const-string v1, "frame.info"

    invoke-direct {v0, p0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    return-object v0
.end method

.method public static getMetaFile(Ljava/io/File;)Ljava/io/File;
    .locals 2
    .param p0, "folder"    # Ljava/io/File;

    .prologue
    .line 262
    new-instance v0, Ljava/io/File;

    const-string v1, "meta.bin"

    invoke-direct {v0, p0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    return-object v0
.end method

.method public static getNumberOfValidSessions(Landroid/content/Context;Lco/vine/android/recorder/RecordSessionVersion;)I
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "version"    # Lco/vine/android/recorder/RecordSessionVersion;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 202
    invoke-static {p0, p1}, Lco/vine/android/recorder/RecordSessionManager;->getValidSessions(Landroid/content/Context;Lco/vine/android/recorder/RecordSessionVersion;)Ljava/util/ArrayList;

    move-result-object v0

    .line 203
    .local v0, "info":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;>;"
    if-eqz v0, :cond_0

    .line 204
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 206
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static getPreviewThumbnailPath(Ljava/io/File;)Ljava/lang/String;
    .locals 2
    .param p0, "folder"    # Ljava/io/File;

    .prologue
    .line 286
    new-instance v0, Ljava/io/File;

    const-string v1, "preview.jpg"

    invoke-direct {v0, p0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getPreviewVideoPath(Lco/vine/android/recorder/RecordSessionVersion;Ljava/io/File;)Ljava/lang/String;
    .locals 3
    .param p0, "version"    # Lco/vine/android/recorder/RecordSessionVersion;
    .param p1, "folder"    # Ljava/io/File;

    .prologue
    .line 282
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "preview"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/recorder/RecordSessionVersion;->videoOutputExtension:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getSegmentThumbnailPath(Ljava/io/File;)Ljava/lang/String;
    .locals 2
    .param p0, "folder"    # Ljava/io/File;

    .prologue
    .line 278
    new-instance v0, Ljava/io/File;

    const-string v1, "segment.jpg"

    invoke-direct {v0, p0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getSegmentVideoPath(Lco/vine/android/recorder/RecordSessionVersion;Ljava/io/File;)Ljava/lang/String;
    .locals 4
    .param p0, "version"    # Lco/vine/android/recorder/RecordSessionVersion;
    .param p1, "folder"    # Ljava/io/File;

    .prologue
    .line 274
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "segment_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/recorder/RecordSessionVersion;->videoOutputExtension:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getThumbnailPath(Ljava/io/File;)Ljava/lang/String;
    .locals 2
    .param p0, "folder"    # Ljava/io/File;

    .prologue
    .line 270
    new-instance v0, Ljava/io/File;

    const-string v1, "thumbnail.jpg"

    invoke-direct {v0, p0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getValidSessions(Landroid/content/Context;Lco/vine/android/recorder/RecordSessionVersion;)Ljava/util/ArrayList;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "version"    # Lco/vine/android/recorder/RecordSessionVersion;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lco/vine/android/recorder/RecordSessionVersion;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 198
    invoke-virtual {p1, p0}, Lco/vine/android/recorder/RecordSessionVersion;->getManager(Landroid/content/Context;)Lco/vine/android/recorder/RecordSessionManager;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordSessionManager;->getValidSessions()Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static getVideoPath(Lco/vine/android/recorder/RecordSessionVersion;Ljava/io/File;)Ljava/lang/String;
    .locals 3
    .param p0, "version"    # Lco/vine/android/recorder/RecordSessionVersion;
    .param p1, "folder"    # Ljava/io/File;

    .prologue
    .line 266
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "video"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/recorder/RecordSessionVersion;->videoOutputExtension:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static isSessionSaved(Ljava/io/File;)Z
    .locals 2
    .param p0, "folder"    # Ljava/io/File;

    .prologue
    const/4 v0, 0x1

    .line 144
    invoke-static {p0}, Lco/vine/android/recorder/RecordSessionManager;->getMetaFile(Ljava/io/File;)Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p0, v0}, Lco/vine/android/recorder/RecordSessionManager;->getDataFile(Ljava/io/File;Z)Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static readDataObject(Ljava/io/File;)Lco/vine/android/recorder/RecordSession;
    .locals 1
    .param p0, "folder"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 365
    const/4 v0, 0x1

    invoke-static {p0, v0}, Lco/vine/android/recorder/RecordSessionManager;->getDataFile(Ljava/io/File;Z)Ljava/io/File;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/recorder/RecordSessionManager;->readObject(Ljava/io/File;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/recorder/RecordSession;

    return-object v0
.end method

.method public static readMetaObject(Ljava/io/File;)Lco/vine/android/recorder/RecordSessionMeta;
    .locals 1
    .param p0, "folder"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 369
    invoke-static {p0}, Lco/vine/android/recorder/RecordSessionManager;->getMetaFile(Ljava/io/File;)Ljava/io/File;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/recorder/RecordSessionManager;->readObject(Ljava/io/File;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/recorder/RecordSessionMeta;

    return-object v0
.end method

.method private static readObject(Ljava/io/File;)Ljava/lang/Object;
    .locals 8
    .param p0, "f"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 342
    :try_start_0
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v5

    if-nez v5, :cond_0

    .line 343
    new-instance v5, Ljava/io/FileNotFoundException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "File not found: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw v5
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 359
    :catch_0
    move-exception v2

    .line 360
    .local v2, "ex":Ljava/lang/ClassNotFoundException;
    new-instance v5, Ljava/io/IOException;

    const-string v6, "Invalid file found."

    invoke-direct {v5, v6, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5

    .line 345
    .end local v2    # "ex":Ljava/lang/ClassNotFoundException;
    :cond_0
    :try_start_1
    new-instance v3, Ljava/io/FileInputStream;

    invoke-direct {v3, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 346
    .local v3, "file":Ljava/io/InputStream;
    new-instance v0, Ljava/io/BufferedInputStream;

    invoke-direct {v0, v3}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_0

    .line 348
    .local v0, "buffer":Ljava/io/InputStream;
    :try_start_2
    new-instance v4, Ljava/io/ObjectInputStream;

    invoke-direct {v4, v0}, Ljava/io/ObjectInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_2
    .catch Ljava/io/EOFException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_2 .. :try_end_2} :catch_0

    .line 350
    .local v4, "input":Ljava/io/ObjectInput;
    :try_start_3
    invoke-interface {v4}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v5

    .line 352
    :try_start_4
    invoke-interface {v4}, Ljava/io/ObjectInput;->close()V

    return-object v5

    :catchall_0
    move-exception v5

    invoke-interface {v4}, Ljava/io/ObjectInput;->close()V

    throw v5
    :try_end_4
    .catch Ljava/io/EOFException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_4 .. :try_end_4} :catch_0

    .line 354
    .end local v4    # "input":Ljava/io/ObjectInput;
    :catch_1
    move-exception v1

    .line 355
    .local v1, "e":Ljava/io/EOFException;
    :try_start_5
    const-string v5, "Failed to read a corrupted file."

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    .line 356
    invoke-static {p0}, Lorg/apache/commons/io/FileUtils;->deleteQuietly(Ljava/io/File;)Z

    .line 357
    throw v1
    :try_end_5
    .catch Ljava/lang/ClassNotFoundException; {:try_start_5 .. :try_end_5} :catch_0
.end method

.method public static wasSessionJustDeleted(Ljava/io/File;)Z
    .locals 2
    .param p0, "folder"    # Ljava/io/File;

    .prologue
    .line 299
    sget-object v0, Lco/vine/android/recorder/RecordSessionManager;->sDeletedSessions:Ljava/util/HashSet;

    invoke-virtual {p0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private static writeData(Ljava/io/File;Lco/vine/android/recorder/RecordSession;Z)V
    .locals 1
    .param p0, "folder"    # Ljava/io/File;
    .param p1, "session"    # Lco/vine/android/recorder/RecordSession;
    .param p2, "isFinal"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 330
    invoke-static {p0, p2}, Lco/vine/android/recorder/RecordSessionManager;->getDataFile(Ljava/io/File;Z)Ljava/io/File;

    move-result-object v0

    invoke-static {v0, p1}, Lco/vine/android/recorder/RecordSessionManager;->writeObject(Ljava/io/File;Ljava/lang/Object;)V

    .line 331
    if-eqz p2, :cond_0

    .line 332
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lco/vine/android/recorder/RecordSessionManager;->getDataFile(Ljava/io/File;Z)Ljava/io/File;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/io/FileUtils;->deleteQuietly(Ljava/io/File;)Z

    .line 334
    :cond_0
    return-void
.end method

.method private static writeMeta(Ljava/io/File;Lco/vine/android/recorder/RecordSessionMeta;)V
    .locals 1
    .param p0, "folder"    # Ljava/io/File;
    .param p1, "meta"    # Lco/vine/android/recorder/RecordSessionMeta;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 337
    invoke-static {p0}, Lco/vine/android/recorder/RecordSessionManager;->getMetaFile(Ljava/io/File;)Ljava/io/File;

    move-result-object v0

    invoke-static {v0, p1}, Lco/vine/android/recorder/RecordSessionManager;->writeObject(Ljava/io/File;Ljava/lang/Object;)V

    .line 338
    return-void
.end method

.method private static writeObject(Ljava/io/File;Ljava/lang/Object;)V
    .locals 7
    .param p0, "f"    # Ljava/io/File;
    .param p1, "obj"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 303
    const-string v3, "Writing: {}."

    new-array v4, v5, [Ljava/lang/Object;

    aput-object p0, v4, v6

    invoke-static {v3, v4}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 304
    invoke-static {p0}, Lco/vine/android/util/SystemUtil;->quietlyEnsureParentExists(Ljava/io/File;)V

    .line 305
    new-instance v1, Ljava/io/FileOutputStream;

    invoke-direct {v1, p0}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 306
    .local v1, "file":Ljava/io/OutputStream;
    new-instance v0, Ljava/io/BufferedOutputStream;

    invoke-direct {v0, v1}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 307
    .local v0, "buffer":Ljava/io/OutputStream;
    new-instance v2, Ljava/io/ObjectOutputStream;

    invoke-direct {v2, v0}, Ljava/io/ObjectOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 309
    .local v2, "output":Ljava/io/ObjectOutput;
    :try_start_0
    invoke-interface {v2, p1}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 311
    invoke-interface {v2}, Ljava/io/ObjectOutput;->close()V

    .line 312
    const-string v3, "Closed: {}."

    new-array v4, v5, [Ljava/lang/Object;

    aput-object p0, v4, v6

    invoke-static {v3, v4}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 314
    return-void

    .line 311
    :catchall_0
    move-exception v3

    invoke-interface {v2}, Ljava/io/ObjectOutput;->close()V

    .line 312
    const-string v4, "Closed: {}."

    new-array v5, v5, [Ljava/lang/Object;

    aput-object p0, v5, v6

    invoke-static {v4, v5}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v3
.end method

.method public static writeRecordingFile(Lco/vine/android/recorder/RecordingFile;Z)V
    .locals 2
    .param p0, "file"    # Lco/vine/android/recorder/RecordingFile;
    .param p1, "isFinal"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 326
    iget-object v0, p0, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-virtual {p0}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v1

    invoke-static {v0, v1, p1}, Lco/vine/android/recorder/RecordSessionManager;->writeRecordingFile(Ljava/io/File;Lco/vine/android/recorder/RecordSession;Z)V

    .line 327
    return-void
.end method

.method public static writeRecordingFile(Ljava/io/File;Lco/vine/android/recorder/RecordSession;Z)V
    .locals 2
    .param p0, "folder"    # Ljava/io/File;
    .param p1, "session"    # Lco/vine/android/recorder/RecordSession;
    .param p2, "isFinal"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 317
    invoke-static {p0, p1, p2}, Lco/vine/android/recorder/RecordSessionManager;->writeData(Ljava/io/File;Lco/vine/android/recorder/RecordSession;Z)V

    .line 318
    if-eqz p2, :cond_0

    .line 319
    new-instance v0, Lco/vine/android/recorder/RecordSessionMeta;

    invoke-virtual {p1}, Lco/vine/android/recorder/RecordSession;->getAudioDataCount()I

    move-result v1

    invoke-static {v1}, Lco/vine/android/recorder/RecordConfigUtils;->getTimeStampInNsFromSampleCounted(I)I

    move-result v1

    div-int/lit16 v1, v1, 0x3e8

    invoke-direct {v0, v1}, Lco/vine/android/recorder/RecordSessionMeta;-><init>(I)V

    invoke-static {p0, v0}, Lco/vine/android/recorder/RecordSessionManager;->writeMeta(Ljava/io/File;Lco/vine/android/recorder/RecordSessionMeta;)V

    .line 321
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lco/vine/android/recorder/RecordSessionManager;->getDataFile(Ljava/io/File;Z)Ljava/io/File;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/io/FileUtils;->deleteQuietly(Ljava/io/File;)Z

    .line 323
    :cond_0
    return-void
.end method


# virtual methods
.method public cleanUnusedFolders()V
    .locals 14

    .prologue
    .line 149
    const/4 v4, 0x0

    .line 150
    .local v4, "i":I
    iget-object v12, p0, Lco/vine/android/recorder/RecordSessionManager;->mDir:Ljava/io/File;

    invoke-virtual {v12}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v10

    .line 151
    .local v10, "list":[Ljava/io/File;
    if-eqz v10, :cond_6

    .line 152
    move-object v0, v10

    .local v0, "arr$":[Ljava/io/File;
    array-length v8, v0

    .local v8, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    move v6, v5

    .end local v0    # "arr$":[Ljava/io/File;
    .end local v5    # "i$":I
    .end local v8    # "len$":I
    .local v6, "i$":I
    :goto_0
    if-ge v6, v8, :cond_6

    aget-object v3, v0, v6

    .line 153
    .local v3, "folder":Ljava/io/File;
    invoke-virtual {v3}, Ljava/io/File;->isDirectory()Z

    move-result v12

    if-eqz v12, :cond_0

    .line 154
    invoke-virtual {v3}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v11

    .line 155
    .local v11, "listFiles":[Ljava/io/File;
    if-eqz v11, :cond_0

    .line 156
    array-length v12, v11

    if-nez v12, :cond_1

    .line 157
    invoke-static {v3}, Lorg/apache/commons/io/FileUtils;->deleteQuietly(Ljava/io/File;)Z

    .line 158
    add-int/lit8 v4, v4, 0x1

    .line 152
    .end local v6    # "i$":I
    .end local v11    # "listFiles":[Ljava/io/File;
    :cond_0
    :goto_1
    add-int/lit8 v5, v6, 0x1

    .restart local v5    # "i$":I
    move v6, v5

    .end local v5    # "i$":I
    .restart local v6    # "i$":I
    goto :goto_0

    .line 160
    .restart local v11    # "listFiles":[Ljava/io/File;
    :cond_1
    array-length v7, v11

    .line 161
    .local v7, "j":I
    move-object v1, v11

    .local v1, "arr$":[Ljava/io/File;
    array-length v9, v1

    .local v9, "len$":I
    const/4 v5, 0x0

    .end local v6    # "i$":I
    .restart local v5    # "i$":I
    :goto_2
    if-ge v5, v9, :cond_4

    aget-object v2, v1, v5

    .line 162
    .local v2, "f":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v12

    const-string v13, ".mp4"

    invoke-virtual {v12, v13}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_2

    invoke-virtual {v2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v12

    const-string v13, ".mkv"

    invoke-virtual {v12, v13}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_3

    .line 163
    :cond_2
    add-int/lit8 v7, v7, -0x1

    .line 161
    :cond_3
    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    .line 166
    .end local v2    # "f":Ljava/io/File;
    :cond_4
    if-nez v7, :cond_5

    .line 167
    invoke-static {v3}, Lorg/apache/commons/io/FileUtils;->deleteQuietly(Ljava/io/File;)Z

    .line 169
    :cond_5
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 175
    .end local v1    # "arr$":[Ljava/io/File;
    .end local v3    # "folder":Ljava/io/File;
    .end local v5    # "i$":I
    .end local v7    # "j":I
    .end local v9    # "len$":I
    .end local v11    # "listFiles":[Ljava/io/File;
    :cond_6
    const-string v12, "{} empty folders deleted."

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    invoke-static {v12, v13}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 176
    return-void
.end method

.method public createFolderForSession()Ljava/io/File;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 107
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lco/vine/android/recorder/RecordSessionManager;->mDir:Ljava/io/File;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 108
    .local v0, "folder":Ljava/io/File;
    invoke-static {v0}, Lorg/apache/commons/io/FileUtils;->forceMkdir(Ljava/io/File;)V

    .line 109
    return-object v0
.end method

.method public getCrashedSession()Ljava/util/HashMap;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/recorder/RecordSession;",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 237
    invoke-virtual {p0}, Lco/vine/android/recorder/RecordSessionManager;->getFolders()Ljava/util/ArrayList;

    move-result-object v3

    .line 238
    .local v3, "folders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/io/File;>;"
    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/io/File;

    .line 239
    .local v2, "folder":Ljava/io/File;
    const/4 v6, 0x0

    invoke-static {v2, v6}, Lco/vine/android/recorder/RecordSessionManager;->getDataFile(Ljava/io/File;Z)Ljava/io/File;

    move-result-object v0

    .line 240
    .local v0, "dataFile":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 242
    :try_start_0
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 243
    .local v5, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/recorder/RecordSession;Ljava/io/File;>;"
    invoke-static {v0}, Lco/vine/android/recorder/RecordSessionManager;->readObject(Ljava/io/File;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v5, v6, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 250
    .end local v0    # "dataFile":Ljava/io/File;
    .end local v2    # "folder":Ljava/io/File;
    .end local v5    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/recorder/RecordSession;Ljava/io/File;>;"
    :goto_1
    return-object v5

    .line 245
    .restart local v0    # "dataFile":Ljava/io/File;
    .restart local v2    # "folder":Ljava/io/File;
    :catch_0
    move-exception v1

    .line 246
    .local v1, "e":Ljava/io/IOException;
    const-string v6, "Failed to read session object."

    invoke-static {v6, v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 250
    .end local v0    # "dataFile":Ljava/io/File;
    .end local v1    # "e":Ljava/io/IOException;
    .end local v2    # "folder":Ljava/io/File;
    :cond_1
    const/4 v5, 0x0

    goto :goto_1
.end method

.method public getFolderFromName(Ljava/lang/String;)Ljava/io/File;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 99
    if-eqz p1, :cond_0

    .line 100
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lco/vine/android/recorder/RecordSessionManager;->mDir:Ljava/io/File;

    invoke-direct {v0, v1, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 102
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getFolders()Ljava/util/ArrayList;
    .locals 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 116
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 117
    .local v5, "folders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/io/File;>;"
    iget-object v13, p0, Lco/vine/android/recorder/RecordSessionManager;->mDir:Ljava/io/File;

    invoke-virtual {v13}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v11

    .line 118
    .local v11, "list":[Ljava/io/File;
    if-nez v11, :cond_0

    .line 119
    new-instance v13, Ljava/io/IOException;

    const-string v14, "This should never happen."

    invoke-direct {v13, v14}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v13

    .line 121
    :cond_0
    move-object v0, v11

    .local v0, "arr$":[Ljava/io/File;
    array-length v9, v0

    .local v9, "len$":I
    const/4 v7, 0x0

    .local v7, "i$":I
    move v8, v7

    .end local v0    # "arr$":[Ljava/io/File;
    .end local v7    # "i$":I
    .end local v9    # "len$":I
    .local v8, "i$":I
    :goto_0
    if-ge v8, v9, :cond_4

    aget-object v4, v0, v8

    .line 122
    .local v4, "folder":Ljava/io/File;
    invoke-virtual {v4}, Ljava/io/File;->isDirectory()Z

    move-result v13

    if-eqz v13, :cond_2

    .line 123
    invoke-virtual {v4}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v3

    .line 124
    .local v3, "files":[Ljava/io/File;
    if-eqz v3, :cond_2

    .line 125
    const/4 v6, 0x0

    .line 126
    .local v6, "hasAdded":Z
    move-object v1, v3

    .local v1, "arr$":[Ljava/io/File;
    array-length v10, v1

    .local v10, "len$":I
    const/4 v7, 0x0

    .end local v8    # "i$":I
    .restart local v7    # "i$":I
    :goto_1
    if-ge v7, v10, :cond_1

    aget-object v2, v1, v7

    .line 127
    .local v2, "file":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v12

    .line 128
    .local v12, "name":Ljava/lang/String;
    iget-object v13, p0, Lco/vine/android/recorder/RecordSessionManager;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    iget-object v13, v13, Lco/vine/android/recorder/RecordSessionVersion;->videoOutputExtension:Ljava/lang/String;

    invoke-virtual {v12, v13}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v13

    if-eqz v13, :cond_3

    .line 129
    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 130
    const/4 v6, 0x1

    .line 134
    .end local v2    # "file":Ljava/io/File;
    .end local v12    # "name":Ljava/lang/String;
    :cond_1
    if-nez v6, :cond_2

    .line 135
    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 121
    .end local v1    # "arr$":[Ljava/io/File;
    .end local v3    # "files":[Ljava/io/File;
    .end local v6    # "hasAdded":Z
    .end local v7    # "i$":I
    .end local v10    # "len$":I
    :cond_2
    add-int/lit8 v7, v8, 0x1

    .restart local v7    # "i$":I
    move v8, v7

    .end local v7    # "i$":I
    .restart local v8    # "i$":I
    goto :goto_0

    .line 126
    .end local v8    # "i$":I
    .restart local v1    # "arr$":[Ljava/io/File;
    .restart local v2    # "file":Ljava/io/File;
    .restart local v3    # "files":[Ljava/io/File;
    .restart local v6    # "hasAdded":Z
    .restart local v7    # "i$":I
    .restart local v10    # "len$":I
    .restart local v12    # "name":Ljava/lang/String;
    :cond_3
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 140
    .end local v1    # "arr$":[Ljava/io/File;
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "files":[Ljava/io/File;
    .end local v4    # "folder":Ljava/io/File;
    .end local v6    # "hasAdded":Z
    .end local v7    # "i$":I
    .end local v10    # "len$":I
    .end local v12    # "name":Ljava/lang/String;
    .restart local v8    # "i$":I
    :cond_4
    return-object v5
.end method

.method public getValidSessions()Ljava/util/ArrayList;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 211
    invoke-virtual {p0}, Lco/vine/android/recorder/RecordSessionManager;->getFolders()Ljava/util/ArrayList;

    move-result-object v4

    .line 212
    .local v4, "folders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/io/File;>;"
    new-instance v7, Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v10

    invoke-direct {v7, v10}, Ljava/util/ArrayList;-><init>(I)V

    .line 213
    .local v7, "sessions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;>;"
    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/io/File;

    .line 215
    .local v3, "folder":Ljava/io/File;
    :try_start_0
    invoke-static {v3}, Lco/vine/android/recorder/RecordSessionManager;->getMetaFile(Ljava/io/File;)Ljava/io/File;

    move-result-object v10

    invoke-virtual {v10}, Ljava/io/File;->exists()Z

    move-result v10

    if-eqz v10, :cond_0

    .line 216
    new-instance v8, Ljava/io/File;

    invoke-static {v3}, Lco/vine/android/recorder/RecordSessionManager;->getThumbnailPath(Ljava/io/File;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v8, v10}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 217
    .local v8, "thumb":Ljava/io/File;
    new-instance v9, Ljava/io/File;

    iget-object v10, p0, Lco/vine/android/recorder/RecordSessionManager;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    invoke-static {v10, v3}, Lco/vine/android/recorder/RecordSessionManager;->getVideoPath(Lco/vine/android/recorder/RecordSessionVersion;Ljava/io/File;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 218
    .local v9, "video":Ljava/io/File;
    const/4 v10, 0x1

    invoke-static {v3, v10}, Lco/vine/android/recorder/RecordSessionManager;->getDataFile(Ljava/io/File;Z)Ljava/io/File;

    move-result-object v0

    .line 219
    .local v0, "data":Ljava/io/File;
    const/4 v10, 0x0

    invoke-static {v3, v10}, Lco/vine/android/recorder/RecordSessionManager;->getDataFile(Ljava/io/File;Z)Ljava/io/File;

    move-result-object v1

    .line 220
    .local v1, "data2":Ljava/io/File;
    invoke-static {v3}, Lco/vine/android/recorder/RecordSessionManager;->readMetaObject(Ljava/io/File;)Lco/vine/android/recorder/RecordSessionMeta;

    move-result-object v6

    .line 221
    .local v6, "meta":Lco/vine/android/recorder/RecordSessionMeta;
    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v10

    if-eqz v10, :cond_2

    invoke-virtual {v9}, Ljava/io/File;->exists()Z

    move-result v10

    if-eqz v10, :cond_2

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v10

    if-nez v10, :cond_1

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v10

    if-eqz v10, :cond_2

    .line 223
    :cond_1
    new-instance v10, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;

    invoke-direct {v10, v3, v8, v9, v6}, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;-><init>(Ljava/io/File;Ljava/io/File;Ljava/io/File;Lco/vine/android/recorder/RecordSessionMeta;)V

    invoke-virtual {v7, v10}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 228
    .end local v0    # "data":Ljava/io/File;
    .end local v1    # "data2":Ljava/io/File;
    .end local v6    # "meta":Lco/vine/android/recorder/RecordSessionMeta;
    .end local v8    # "thumb":Ljava/io/File;
    .end local v9    # "video":Ljava/io/File;
    :catch_0
    move-exception v2

    .line 229
    .local v2, "e":Ljava/lang/Exception;
    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 225
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v0    # "data":Ljava/io/File;
    .restart local v1    # "data2":Ljava/io/File;
    .restart local v6    # "meta":Lco/vine/android/recorder/RecordSessionMeta;
    .restart local v8    # "thumb":Ljava/io/File;
    .restart local v9    # "video":Ljava/io/File;
    :cond_2
    :try_start_1
    const-string v10, "Invalid session found: {}."

    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 232
    .end local v0    # "data":Ljava/io/File;
    .end local v1    # "data2":Ljava/io/File;
    .end local v3    # "folder":Ljava/io/File;
    .end local v6    # "meta":Lco/vine/android/recorder/RecordSessionMeta;
    .end local v8    # "thumb":Ljava/io/File;
    .end local v9    # "video":Ljava/io/File;
    :cond_3
    invoke-static {v7}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 233
    return-object v7
.end method
