.class public Lco/vine/android/recorder/RecordingFile;
.super Ljava/lang/Object;
.source "RecordingFile.java"


# instance fields
.field public editedSegments:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/recorder/RecordSegment;",
            ">;"
        }
    .end annotation
.end field

.field public final folder:Ljava/io/File;

.field public isDirty:Z

.field public final isLastSession:Z

.field public isSavedSession:Z

.field private mHash:Ljava/lang/String;

.field private mSession:Lco/vine/android/recorder/RecordSession;

.field public final version:Lco/vine/android/recorder/RecordSessionVersion;


# direct methods
.method public constructor <init>(Ljava/io/File;Lco/vine/android/recorder/RecordSession;ZZZ)V
    .locals 3
    .param p1, "saveFolder"    # Ljava/io/File;
    .param p2, "session"    # Lco/vine/android/recorder/RecordSession;
    .param p3, "isSavedSession"    # Z
    .param p4, "isDirty"    # Z
    .param p5, "isLastSession"    # Z

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 29
    const-string v1, "[session] New file created: {}."

    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 31
    :cond_0
    iput-object p2, p0, Lco/vine/android/recorder/RecordingFile;->mSession:Lco/vine/android/recorder/RecordSession;

    .line 32
    iget-object v1, p0, Lco/vine/android/recorder/RecordingFile;->mSession:Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v1}, Lco/vine/android/recorder/RecordSession;->getVersion()Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/recorder/RecordingFile;->version:Lco/vine/android/recorder/RecordSessionVersion;

    .line 33
    iput-object p1, p0, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    .line 34
    iput-boolean p3, p0, Lco/vine/android/recorder/RecordingFile;->isSavedSession:Z

    .line 35
    iput-boolean p5, p0, Lco/vine/android/recorder/RecordingFile;->isLastSession:Z

    .line 36
    iput-boolean p4, p0, Lco/vine/android/recorder/RecordingFile;->isDirty:Z

    .line 38
    :try_start_0
    iget-object v1, p0, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-static {v1}, Lorg/apache/commons/io/FileUtils;->forceMkdir(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 42
    return-void

    .line 39
    :catch_0
    move-exception v0

    .line 40
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public static getLastFramePathThumbnailFromThumbnailPath(Ljava/lang/String;Z)Ljava/lang/String;
    .locals 2
    .param p0, "thumbnailPath"    # Ljava/lang/String;
    .param p1, "isPreview"    # Z

    .prologue
    .line 85
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".last."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p1}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".jpg"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public getHash()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lco/vine/android/recorder/RecordingFile;->mHash:Ljava/lang/String;

    return-object v0
.end method

.method public getLastFramePath()Ljava/lang/String;
    .locals 3

    .prologue
    .line 89
    invoke-virtual {p0}, Lco/vine/android/recorder/RecordingFile;->getThumbnailPath()Ljava/lang/String;

    move-result-object v1

    .line 90
    .local v1, "thumbnailPath":Ljava/lang/String;
    const/4 v2, 0x0

    invoke-static {v1, v2}, Lco/vine/android/recorder/RecordingFile;->getLastFramePathThumbnailFromThumbnailPath(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 91
    .local v0, "lastThumbnailPath":Ljava/lang/String;
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_0

    .line 94
    .end local v1    # "thumbnailPath":Ljava/lang/String;
    :goto_0
    return-object v1

    .restart local v1    # "thumbnailPath":Ljava/lang/String;
    :cond_0
    move-object v1, v0

    goto :goto_0
.end method

.method public getPreviewThumbnailPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-static {v0}, Lco/vine/android/recorder/RecordSessionManager;->getPreviewThumbnailPath(Ljava/io/File;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPreviewVideoPath()Ljava/lang/String;
    .locals 2

    .prologue
    .line 69
    iget-object v0, p0, Lco/vine/android/recorder/RecordingFile;->version:Lco/vine/android/recorder/RecordSessionVersion;

    iget-object v1, p0, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-static {v0, v1}, Lco/vine/android/recorder/RecordSessionManager;->getPreviewVideoPath(Lco/vine/android/recorder/RecordSessionVersion;Ljava/io/File;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSegmentThumbnailPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-static {v0}, Lco/vine/android/recorder/RecordSessionManager;->getSegmentThumbnailPath(Ljava/io/File;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSegmentVideoPath()Ljava/lang/String;
    .locals 2

    .prologue
    .line 61
    iget-object v0, p0, Lco/vine/android/recorder/RecordingFile;->version:Lco/vine/android/recorder/RecordSessionVersion;

    iget-object v1, p0, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-static {v0, v1}, Lco/vine/android/recorder/RecordSessionManager;->getSegmentVideoPath(Lco/vine/android/recorder/RecordSessionVersion;Ljava/io/File;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSession()Lco/vine/android/recorder/RecordSession;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lco/vine/android/recorder/RecordingFile;->mSession:Lco/vine/android/recorder/RecordSession;

    return-object v0
.end method

.method public getThumbnailPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-static {v0}, Lco/vine/android/recorder/RecordSessionManager;->getThumbnailPath(Ljava/io/File;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getVideoPath()Ljava/lang/String;
    .locals 2

    .prologue
    .line 77
    iget-object v0, p0, Lco/vine/android/recorder/RecordingFile;->version:Lco/vine/android/recorder/RecordSessionVersion;

    iget-object v1, p0, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-static {v0, v1}, Lco/vine/android/recorder/RecordSessionManager;->getVideoPath(Lco/vine/android/recorder/RecordSessionVersion;Ljava/io/File;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public hasData()Z
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lco/vine/android/recorder/RecordingFile;->mSession:Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordSession;->getSegments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public invalidateGhostThumbnail()V
    .locals 4

    .prologue
    .line 109
    new-instance v0, Ljava/io/File;

    invoke-virtual {p0}, Lco/vine/android/recorder/RecordingFile;->getPreviewThumbnailPath()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lco/vine/android/recorder/RecordingFile;->getLastFramePathThumbnailFromThumbnailPath(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 110
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 111
    new-instance v1, Ljava/io/File;

    invoke-virtual {p0}, Lco/vine/android/recorder/RecordingFile;->getThumbnailPath()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-static {v2, v3}, Lco/vine/android/recorder/RecordingFile;->getLastFramePathThumbnailFromThumbnailPath(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    .line 115
    :cond_0
    return-void
.end method

.method public isValid()Z
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lco/vine/android/recorder/RecordingFile;->mSession:Lco/vine/android/recorder/RecordSession;

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordSession;->getSegments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setHash(Ljava/lang/String;)V
    .locals 0
    .param p1, "hash"    # Ljava/lang/String;

    .prologue
    .line 57
    iput-object p1, p0, Lco/vine/android/recorder/RecordingFile;->mHash:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setSession(Lco/vine/android/recorder/RecordSession;)V
    .locals 0
    .param p1, "session"    # Lco/vine/android/recorder/RecordSession;

    .prologue
    .line 99
    iput-object p1, p0, Lco/vine/android/recorder/RecordingFile;->mSession:Lco/vine/android/recorder/RecordSession;

    .line 100
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 104
    const-string v0, "Folder: {}, isLastSession: {}, isDirty: {}, isSavedSession: {}, Session: {}"

    const/4 v1, 0x5

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-boolean v3, p0, Lco/vine/android/recorder/RecordingFile;->isLastSession:Z

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x2

    iget-boolean v3, p0, Lco/vine/android/recorder/RecordingFile;->isDirty:Z

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x3

    iget-boolean v3, p0, Lco/vine/android/recorder/RecordingFile;->isSavedSession:Z

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x4

    iget-object v3, p0, Lco/vine/android/recorder/RecordingFile;->mSession:Lco/vine/android/recorder/RecordSession;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
