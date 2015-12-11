.class public Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylistParser;
.super Lcom/comcast/cim/cmasl/hls/HlsParser;
.source "HlsVariantPlaylistParser.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/hls/HlsParser",
        "<",
        "Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/hls/HlsParser;-><init>()V

    return-void
.end method

.method private getSubTagValueFromLine(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "line"    # Ljava/lang/String;
    .param p2, "subTag"    # Ljava/lang/String;

    .prologue
    .line 84
    invoke-virtual {p1, p2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 85
    invoke-virtual {p1, p2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v1, v2

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p1, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 86
    .local v0, "subTagValue":Ljava/lang/String;
    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 87
    const/4 v1, 0x0

    const-string v2, ","

    invoke-virtual {v0, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 92
    .end local v0    # "subTagValue":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public bridge synthetic parseStream(Ljava/io/InputStream;)Lcom/comcast/cim/cmasl/hls/HlsPlaylist;
    .locals 1
    .param p1, "x0"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 10
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylistParser;->parseStream(Ljava/io/InputStream;)Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    move-result-object v0

    return-object v0
.end method

.method public parseStream(Ljava/io/InputStream;)Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;
    .locals 24
    .param p1, "stream"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 13
    new-instance v15, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    invoke-direct {v15}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;-><init>()V

    .line 15
    .local v15, "newPlaylist":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;
    new-instance v16, Ljava/io/BufferedReader;

    new-instance v3, Ljava/io/InputStreamReader;

    move-object/from16 v0, p1

    invoke-direct {v3, v0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    move-object/from16 v0, v16

    invoke-direct {v0, v3}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 17
    .local v16, "reader":Ljava/io/BufferedReader;
    const/16 v19, 0x0

    .line 18
    .local v19, "startFound":Z
    :cond_0
    :goto_0
    invoke-virtual/range {v16 .. v16}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v13

    .local v13, "line":Ljava/lang/String;
    if-eqz v13, :cond_9

    .line 19
    invoke-virtual {v13}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 23
    const-string v3, "#EXT"

    invoke-virtual {v13, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 24
    if-nez v19, :cond_2

    .line 25
    const-string v3, "#EXTM3U"

    invoke-virtual {v13, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 26
    const/16 v19, 0x1

    goto :goto_0

    .line 29
    :cond_1
    new-instance v3, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    const-string v22, "Failed to properly parse the M3U8 File! No Start Tag!"

    move-object/from16 v0, v22

    invoke-direct {v3, v0}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 32
    :cond_2
    const-string v3, "#EXT-X-STREAM-INF:"

    invoke-virtual {v13, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 33
    const-string v3, "#EXT-X-STREAM-INF:"

    const-string v22, ""

    move-object/from16 v0, v22

    invoke-virtual {v13, v3, v0}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v4

    .line 34
    .local v4, "streamInfo":Ljava/lang/String;
    const-string v3, "BANDWIDTH"

    move-object/from16 v0, p0

    invoke-direct {v0, v13, v3}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylistParser;->getSubTagValueFromLine(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 35
    .local v10, "bandwidthString":Ljava/lang/String;
    invoke-static {v10}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    .line 36
    .local v9, "bandwidth":Ljava/lang/Integer;
    invoke-virtual/range {v16 .. v16}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    .line 38
    .local v2, "relativePath":Ljava/lang/String;
    const/4 v6, 0x0

    .local v6, "width":I
    const/4 v7, 0x0

    .line 39
    .local v7, "height":I
    const-string v3, "RESOLUTION"

    move-object/from16 v0, p0

    invoke-direct {v0, v13, v3}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylistParser;->getSubTagValueFromLine(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    .line 41
    .local v18, "resolutionString":Ljava/lang/String;
    if-eqz v18, :cond_3

    .line 42
    const-string v3, "x"

    move-object/from16 v0, v18

    invoke-virtual {v0, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v17

    .line 43
    .local v17, "resolutionSplit":[Ljava/lang/String;
    move-object/from16 v0, v17

    array-length v3, v0

    const/16 v22, 0x2

    move/from16 v0, v22

    if-ne v3, v0, :cond_3

    .line 44
    const/4 v3, 0x0

    aget-object v3, v17, v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v6

    .line 45
    const/4 v3, 0x1

    aget-object v3, v17, v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v7

    .line 49
    .end local v17    # "resolutionSplit":[Ljava/lang/String;
    :cond_3
    const-string v3, "AUDIO"

    move-object/from16 v0, p0

    invoke-direct {v0, v13, v3}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylistParser;->getSubTagValueFromLine(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 51
    .local v5, "audio":Ljava/lang/String;
    new-instance v1, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;

    invoke-virtual {v9}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-direct/range {v1 .. v7}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;II)V

    .line 52
    .local v1, "mediaProfile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
    invoke-virtual {v15, v1}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->addMediaProfile(Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;)V

    goto/16 :goto_0

    .line 53
    .end local v1    # "mediaProfile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
    .end local v2    # "relativePath":Ljava/lang/String;
    .end local v4    # "streamInfo":Ljava/lang/String;
    .end local v5    # "audio":Ljava/lang/String;
    .end local v6    # "width":I
    .end local v7    # "height":I
    .end local v9    # "bandwidth":Ljava/lang/Integer;
    .end local v10    # "bandwidthString":Ljava/lang/String;
    .end local v18    # "resolutionString":Ljava/lang/String;
    :cond_4
    const-string v3, "#EXT-X-MEDIA:"

    invoke-virtual {v13, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 54
    const-string v3, "#EXT-X-MEDIA:"

    const-string v22, ""

    move-object/from16 v0, v22

    invoke-virtual {v13, v3, v0}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v14

    .line 55
    .local v14, "mediaInfo":Ljava/lang/String;
    const-string v3, "TYPE"

    move-object/from16 v0, p0

    invoke-direct {v0, v13, v3}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylistParser;->getSubTagValueFromLine(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    .line 56
    .local v20, "typeString":Ljava/lang/String;
    const-string v3, "URI"

    move-object/from16 v0, p0

    invoke-direct {v0, v13, v3}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylistParser;->getSubTagValueFromLine(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    .line 57
    .local v21, "uriString":Ljava/lang/String;
    const-string v3, "LANGUAGE"

    move-object/from16 v0, p0

    invoke-direct {v0, v13, v3}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylistParser;->getSubTagValueFromLine(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 58
    .local v12, "languageString":Ljava/lang/String;
    if-eqz v12, :cond_5

    .line 59
    const-string v3, "\""

    const-string v22, ""

    move-object/from16 v0, v22

    invoke-virtual {v12, v3, v0}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    .line 61
    :cond_5
    const-string v3, "GROUP-ID"

    move-object/from16 v0, p0

    invoke-direct {v0, v13, v3}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylistParser;->getSubTagValueFromLine(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 64
    .local v11, "groupId":Ljava/lang/String;
    const-string v3, "AUDIO"

    move-object/from16 v0, v20

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 65
    new-instance v8, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    move-object/from16 v0, v21

    invoke-direct {v8, v0, v12, v11, v14}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    .local v8, "audioProfile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    invoke-virtual {v15, v8}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->addMediaAudioProfile(Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;)V

    goto/16 :goto_0

    .line 68
    .end local v8    # "audioProfile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    :cond_6
    move-object/from16 v0, p0

    invoke-virtual {v0, v15, v13}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylistParser;->processBaseItem(Lcom/comcast/cim/cmasl/hls/HlsPlaylist;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 71
    .end local v11    # "groupId":Ljava/lang/String;
    .end local v12    # "languageString":Ljava/lang/String;
    .end local v14    # "mediaInfo":Ljava/lang/String;
    .end local v20    # "typeString":Ljava/lang/String;
    .end local v21    # "uriString":Ljava/lang/String;
    :cond_7
    move-object/from16 v0, p0

    invoke-virtual {v0, v15, v13}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylistParser;->processBaseItem(Lcom/comcast/cim/cmasl/hls/HlsPlaylist;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 74
    :cond_8
    const-string v3, "#"

    invoke-virtual {v13, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 76
    new-instance v3, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "Failed to properly parse the M3U8 File! Unknown Line: "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-direct {v3, v0}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 80
    :cond_9
    return-object v15
.end method
