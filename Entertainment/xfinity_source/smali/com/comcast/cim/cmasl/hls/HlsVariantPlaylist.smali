.class public Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;
.super Lcom/comcast/cim/cmasl/hls/HlsPlaylist;
.source "HlsVariantPlaylist.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;,
        Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
    }
.end annotation


# instance fields
.field private audioProfiles:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;",
            ">;"
        }
    .end annotation
.end field

.field private mediaProfiles:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;",
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
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->mediaProfiles:Ljava/util/List;

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->audioProfiles:Ljava/util/List;

    .line 74
    return-void
.end method


# virtual methods
.method public addMediaAudioProfile(Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;)V
    .locals 1
    .param p1, "profile"    # Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    .prologue
    .line 137
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->audioProfiles:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 138
    return-void
.end method

.method public addMediaProfile(Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;)V
    .locals 1
    .param p1, "profile"    # Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;

    .prologue
    .line 125
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->mediaProfiles:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 126
    return-void
.end method

.method public getAudioProfiles()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;",
            ">;"
        }
    .end annotation

    .prologue
    .line 145
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->audioProfiles:Ljava/util/List;

    return-object v0
.end method

.method public getMediaProfiles()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;",
            ">;"
        }
    .end annotation

    .prologue
    .line 133
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->mediaProfiles:Ljava/util/List;

    return-object v0
.end method

.method public setAudioProfiles(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 141
    .local p1, "audioProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;>;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->audioProfiles:Ljava/util/List;

    .line 142
    return-void
.end method

.method public setMediaProfiles(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 129
    .local p1, "mediaProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;>;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->mediaProfiles:Ljava/util/List;

    .line 130
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 184
    const-string v1, ""

    .line 187
    .local v1, "playlistString":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->getStartAndVersionString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 188
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 191
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->getAllUnknownTags()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 192
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 194
    iget-object v3, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->audioProfiles:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    .line 195
    .local v2, "profile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    if-eqz v2, :cond_0

    .line 196
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#EXT-X-MEDIA:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getMediaInfo()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 197
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 201
    .end local v2    # "profile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    :cond_1
    iget-object v3, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->mediaProfiles:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_2
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;

    .line 202
    .local v2, "profile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
    if-eqz v2, :cond_2

    .line 203
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#EXT-X-STREAM-INF:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->getStreamInfo()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 204
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 205
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->getRelativePath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 206
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

    .line 210
    .end local v2    # "profile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
    :cond_3
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
    .line 149
    new-instance v0, Ljava/io/BufferedWriter;

    new-instance v3, Ljava/io/FileWriter;

    invoke-direct {v3, p1}, Ljava/io/FileWriter;-><init>(Ljava/io/File;)V

    const v4, 0x8000

    invoke-direct {v0, v3, v4}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;I)V

    .line 152
    .local v0, "fileWriter":Ljava/io/BufferedWriter;
    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->getStartAndVersionString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 153
    const-string v3, "\n"

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 156
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->getAllUnknownTags()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 157
    const-string v3, "\n"

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 159
    iget-object v3, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->audioProfiles:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    .line 160
    .local v2, "profile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    if-eqz v2, :cond_0

    .line 161
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "#EXT-X-MEDIA:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getMediaInfo()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 162
    const-string v3, "\n"

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 177
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "profile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    :catchall_0
    move-exception v3

    invoke-virtual {v0}, Ljava/io/BufferedWriter;->close()V

    throw v3

    .line 167
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    :try_start_1
    iget-object v3, p0, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->mediaProfiles:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;

    .line 168
    .local v2, "profile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
    if-eqz v2, :cond_2

    .line 169
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "#EXT-X-STREAM-INF:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->getStreamInfo()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 170
    const-string v3, "\n"

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 171
    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->getRelativePath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    .line 172
    const-string v3, "\n"

    invoke-virtual {v0, v3}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V

    goto :goto_1

    .line 175
    .end local v2    # "profile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
    :cond_3
    invoke-virtual {v0}, Ljava/io/BufferedWriter;->flush()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 177
    invoke-virtual {v0}, Ljava/io/BufferedWriter;->close()V

    .line 179
    return-void
.end method
