.class public Lcom/comcast/cim/downloads/DownloadFile;
.super Ljava/lang/Object;
.source "DownloadFile.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/comcast/cim/downloads/DownloadMetaData;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field protected volatile asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

.field protected final metaData:Lcom/comcast/cim/downloads/DownloadMetaData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;Lcom/comcast/cim/downloads/DownloadMetaData;)V
    .locals 0
    .param p1, "asset"    # Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/penthera/virtuososdk/client/IVirtuosoAsset;",
            "TT;)V"
        }
    .end annotation

    .prologue
    .line 21
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    .local p2, "metadata":Lcom/comcast/cim/downloads/DownloadMetaData;, "TT;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 23
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 24
    iput-object p2, p0, Lcom/comcast/cim/downloads/DownloadFile;->metaData:Lcom/comcast/cim/downloads/DownloadMetaData;

    .line 25
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 3
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 51
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    instance-of v1, p1, Lcom/comcast/cim/downloads/DownloadFile;

    if-eqz v1, :cond_0

    move-object v0, p1

    .line 52
    check-cast v0, Lcom/comcast/cim/downloads/DownloadFile;

    .line 53
    .local v0, "otherFile":Lcom/comcast/cim/downloads/DownloadFile;
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v1}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/comcast/cim/downloads/DownloadFile;->getAsset()Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-result-object v2

    invoke-interface {v2}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 54
    const/4 v1, 0x1

    .line 58
    .end local v0    # "otherFile":Lcom/comcast/cim/downloads/DownloadFile;
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getAsset()Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .locals 1

    .prologue
    .line 32
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    return-object v0
.end method

.method public getCurrentFileSizeInMb()I
    .locals 4

    .prologue
    .line 62
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->currentSize()D

    move-result-wide v0

    const-wide/high16 v2, 0x4130000000000000L    # 1048576.0

    div-double/2addr v0, v2

    double-to-int v0, v0

    return v0
.end method

.method public getDownloadMetaData()Lcom/comcast/cim/downloads/DownloadMetaData;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 41
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->metaData:Lcom/comcast/cim/downloads/DownloadMetaData;

    return-object v0
.end method

.method public getExpectedFileSizeInMb()I
    .locals 4

    .prologue
    .line 66
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->expectedSize()D

    move-result-wide v0

    const-wide/high16 v2, 0x4130000000000000L    # 1048576.0

    div-double/2addr v0, v2

    double-to-int v0, v0

    return v0
.end method

.method public getFileDirectory()Ljava/lang/String;
    .locals 3

    .prologue
    .line 140
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    instance-of v1, v1, Lcom/penthera/virtuososdk/client/IVirtuosoFile;

    if-eqz v1, :cond_0

    .line 141
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    check-cast v1, Lcom/penthera/virtuososdk/client/IVirtuosoFile;

    invoke-interface {v1}, Lcom/penthera/virtuososdk/client/IVirtuosoFile;->filePath()Ljava/lang/String;

    move-result-object v0

    .line 142
    .local v0, "path":Ljava/lang/String;
    const/4 v1, 0x0

    const-string v2, "/"

    invoke-virtual {v0, v2}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 147
    :goto_0
    return-object v0

    .line 144
    .end local v0    # "path":Ljava/lang/String;
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    check-cast v1, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    invoke-interface {v1}, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;->localBaseDir()Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "path":Ljava/lang/String;
    goto :goto_0
.end method

.method public getFileURI()Ljava/lang/String;
    .locals 2

    .prologue
    .line 102
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    instance-of v0, v0, Lcom/penthera/virtuososdk/client/IVirtuosoFile;

    if-eqz v0, :cond_0

    .line 103
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "file://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoFile;

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoFile;->filePath()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 105
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getFileURIList()Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 126
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    instance-of v3, v3, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    if-eqz v3, :cond_0

    .line 127
    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    check-cast v3, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    invoke-interface {v3}, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;->fragments()Ljava/util/List;

    move-result-object v2

    .line 128
    .local v2, "fragments":Ljava/util/List;, "Ljava/util/List<Lcom/penthera/virtuososdk/client/IFileFragment;>;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    invoke-direct {v0, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 129
    .local v0, "fileList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/penthera/virtuososdk/client/IFileFragment;

    .line 130
    .local v1, "fragment":Lcom/penthera/virtuososdk/client/IFileFragment;
    invoke-interface {v1}, Lcom/penthera/virtuososdk/client/IFileFragment;->filePath()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 134
    .end local v0    # "fileList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v1    # "fragment":Lcom/penthera/virtuososdk/client/IFileFragment;
    .end local v2    # "fragments":Ljava/util/List;, "Ljava/util/List<Lcom/penthera/virtuososdk/client/IFileFragment;>;"
    :cond_0
    const/4 v0, 0x0

    :cond_1
    return-object v0
.end method

.method public getFractionComplete()D
    .locals 2

    .prologue
    .line 70
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->fractionComplete()D

    move-result-wide v0

    return-wide v0
.end method

.method public getPercentComplete()I
    .locals 4

    .prologue
    .line 74
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->fractionComplete()D

    move-result-wide v0

    const-wide/high16 v2, 0x4059000000000000L    # 100.0

    mul-double/2addr v0, v2

    double-to-int v0, v0

    return v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 46
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public isDownloadComplete()Z
    .locals 2

    .prologue
    .line 79
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->KvDE_Download_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Expired:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isDownloadInError()Z
    .locals 2

    .prologue
    .line 92
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Reachability_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 93
    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Copy_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 94
    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Corrupt:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 95
    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Mime_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 96
    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Size_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 97
    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_HLS_Fragment_Copy_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 98
    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Network_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isDownloadInProgress()Z
    .locals 2

    .prologue
    .line 84
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isDownloadPending()Z
    .locals 2

    .prologue
    .line 88
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFileURICurrentlyAccessible()Z
    .locals 4

    .prologue
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    const/4 v2, 0x0

    .line 110
    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    instance-of v3, v3, Lcom/penthera/virtuososdk/client/IVirtuosoFile;

    if-eqz v3, :cond_1

    .line 111
    new-instance v0, Ljava/io/File;

    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    check-cast v2, Lcom/penthera/virtuososdk/client/IVirtuosoFile;

    invoke-interface {v2}, Lcom/penthera/virtuososdk/client/IVirtuosoFile;->filePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 112
    .local v0, "diskFile":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->canRead()Z

    move-result v2

    .line 122
    .end local v0    # "diskFile":Ljava/io/File;
    :cond_0
    :goto_0
    return v2

    .line 113
    :cond_1
    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    instance-of v3, v3, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    if-eqz v3, :cond_0

    .line 114
    invoke-virtual {p0}, Lcom/comcast/cim/downloads/DownloadFile;->getFileURIList()Ljava/util/List;

    move-result-object v1

    .line 116
    .local v1, "strings":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 117
    new-instance v0, Ljava/io/File;

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 118
    .restart local v0    # "diskFile":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->canRead()Z

    move-result v2

    goto :goto_0
.end method

.method public setAsset(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V
    .locals 0
    .param p1, "asset"    # Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .prologue
    .line 28
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadFile;, "Lcom/comcast/cim/downloads/DownloadFile<TT;>;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadFile;->asset:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 29
    return-void
.end method
