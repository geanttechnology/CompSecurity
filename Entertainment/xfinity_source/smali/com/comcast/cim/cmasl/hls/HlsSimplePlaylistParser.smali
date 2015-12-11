.class public Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylistParser;
.super Lcom/comcast/cim/cmasl/hls/HlsParser;
.source "HlsSimplePlaylistParser.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/hls/HlsParser",
        "<",
        "Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;",
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
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylistParser;->parseStream(Ljava/io/InputStream;)Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    move-result-object v0

    return-object v0
.end method

.method public parseStream(Ljava/io/InputStream;)Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;
    .locals 11
    .param p1, "stream"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 13
    new-instance v5, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    invoke-direct {v5}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;-><init>()V

    .line 15
    .local v5, "playlist":Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;
    new-instance v6, Ljava/io/BufferedReader;

    new-instance v9, Ljava/io/InputStreamReader;

    invoke-direct {v9, p1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v6, v9}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 17
    .local v6, "reader":Ljava/io/BufferedReader;
    const/4 v8, 0x0

    .line 18
    .local v8, "startFound":Z
    :cond_0
    :goto_0
    invoke-virtual {v6}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v1

    .local v1, "line":Ljava/lang/String;
    if-eqz v1, :cond_5

    .line 19
    const-string v9, "#EXT"

    invoke-virtual {v1, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 20
    if-nez v8, :cond_2

    .line 21
    const-string v9, "#EXTM3U"

    invoke-virtual {v1, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 22
    const/4 v8, 0x1

    goto :goto_0

    .line 25
    :cond_1
    new-instance v9, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    const-string v10, "Failed to properly parse the M3U8 File! No Start Tag!"

    invoke-direct {v9, v10}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 28
    :cond_2
    const-string v9, "#EXT-X-MEDIA-SEQUENCE:"

    invoke-virtual {v1, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 29
    const-string v9, "#EXT-X-MEDIA-SEQUENCE:"

    const-string v10, ""

    invoke-virtual {v1, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    iput-object v9, v5, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->mediaSequence:Ljava/lang/Integer;

    goto :goto_0

    .line 30
    :cond_3
    const-string v9, "#EXTINF:"

    invoke-virtual {v1, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 31
    const-string v9, "#EXTINF:"

    const-string v10, ""

    invoke-virtual {v1, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 32
    .local v0, "fileSequenceInfo":Ljava/lang/String;
    invoke-virtual {v6}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v4

    .line 33
    .local v4, "path":Ljava/lang/String;
    const/4 v9, 0x0

    const-string v10, ","

    invoke-virtual {v0, v10}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v10

    invoke-virtual {v0, v9, v10}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v2

    .line 34
    .local v2, "length":D
    new-instance v7, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;

    invoke-direct {v7, v4, v0, v2, v3}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;-><init>(Ljava/lang/String;Ljava/lang/String;D)V

    .line 35
    .local v7, "segment":Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
    invoke-virtual {v5, v7}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->addSequenceSegment(Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;)V

    goto :goto_0

    .line 38
    .end local v0    # "fileSequenceInfo":Ljava/lang/String;
    .end local v2    # "length":D
    .end local v4    # "path":Ljava/lang/String;
    .end local v7    # "segment":Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
    :cond_4
    const-string v9, "#EXT-X-ENDLIST"

    invoke-virtual {v1, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_0

    .line 39
    invoke-virtual {p0, v5, v1}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylistParser;->processBaseItem(Lcom/comcast/cim/cmasl/hls/HlsPlaylist;Ljava/lang/String;)V

    goto :goto_0

    .line 46
    :cond_5
    return-object v5
.end method
