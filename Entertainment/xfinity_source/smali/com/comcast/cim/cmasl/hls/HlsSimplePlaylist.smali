.class public Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;
.super Lcom/comcast/cim/cmasl/hls/HlsPlaylist;
.source "HlsSimplePlaylist.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
    }
.end annotation


# instance fields
.field mediaSequence:Ljava/lang/Integer;

.field sequencePaths:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/hls/HlsPlaylist;-><init>()V

    .line 12
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->mediaSequence:Ljava/lang/Integer;

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->sequencePaths:Ljava/util/List;

    .line 15
    return-void
.end method


# virtual methods
.method public addSequenceSegment(Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;)V
    .locals 1
    .param p1, "segment"    # Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->sequencePaths:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 53
    return-void
.end method

.method public getMediaSequence()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->mediaSequence:Ljava/lang/Integer;

    return-object v0
.end method

.method public getRelativeSequencePaths()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 65
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->sequencePaths:Ljava/util/List;

    return-object v0
.end method

.method public setMediaSequence(Ljava/lang/Integer;)V
    .locals 1
    .param p1, "mediaSequence"    # Ljava/lang/Integer;

    .prologue
    .line 48
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->mediaSequence:Ljava/lang/Integer;

    .line 49
    return-void
.end method

.method public setSequencePaths(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 60
    .local p1, "sequencePaths":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;>;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->sequencePaths:Ljava/util/List;

    .line 61
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 107
    const-string v1, ""

    .line 110
    .local v1, "playlistString":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->getStartAndVersionString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 111
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 114
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->getAllUnknownTags()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 115
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 118
    iget-object v3, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->mediaSequence:Ljava/lang/Integer;

    if-eqz v3, :cond_0

    .line 119
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#EXT-X-MEDIA-SEQUENCE:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->mediaSequence:Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 123
    :goto_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 126
    iget-object v3, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->sequencePaths:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;

    .line 127
    .local v2, "segment":Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#EXTINF:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    # getter for: Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->sequenceInfo:Ljava/lang/String;
    invoke-static {v2}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->access$000(Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 128
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 129
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    # getter for: Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->path:Ljava/lang/String;
    invoke-static {v2}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->access$100(Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 130
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 121
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v2    # "segment":Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#EXT-X-MEDIA-SEQUENCE:0"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_0

    .line 134
    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#EXT-X-ENDLIST\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 136
    return-object v1
.end method

.method public writeToFile(Ljava/io/File;)V
    .locals 5
    .param p1, "file"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 69
    new-instance v0, Ljava/io/BufferedWriter;

    new-instance v3, Ljava/io/FileWriter;

    invoke-direct {v3, p1}, Ljava/io/FileWriter;-><init>(Ljava/io/File;)V

    const v4, 0x8000

    invoke-direct {v0, v3, v4}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;I)V

    .line 72
    .local v0, "fileWriter":Ljava/io/BufferedWriter;
    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->getStartAndVersionString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 73
    const-string v3, "\n"

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 76
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->getAllUnknownTags()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 77
    const-string v3, "\n"

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 80
    iget-object v3, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->mediaSequence:Ljava/lang/Integer;

    if-eqz v3, :cond_0

    .line 81
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "#EXT-X-MEDIA-SEQUENCE:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->mediaSequence:Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 85
    :goto_0
    const-string v3, "\n"

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 88
    iget-object v3, p0, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->sequencePaths:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;

    .line 89
    .local v2, "segment":Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "#EXTINF:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    # getter for: Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->sequenceInfo:Ljava/lang/String;
    invoke-static {v2}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->access$000(Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 90
    const-string v3, "\n"

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 91
    # getter for: Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->path:Ljava/lang/String;
    invoke-static {v2}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->access$100(Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 92
    const-string v3, "\n"

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 100
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "segment":Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
    :catchall_0
    move-exception v3

    invoke-virtual {v0}, Ljava/io/BufferedWriter;->close()V

    throw v3

    .line 83
    :cond_0
    :try_start_1
    const-string v3, "#EXT-X-MEDIA-SEQUENCE:0"

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    goto :goto_0

    .line 96
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    const-string v3, "#EXT-X-ENDLIST\n"

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 98
    invoke-virtual {v0}, Ljava/io/BufferedWriter;->flush()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 100
    invoke-virtual {v0}, Ljava/io/BufferedWriter;->close()V

    .line 102
    return-void
.end method
