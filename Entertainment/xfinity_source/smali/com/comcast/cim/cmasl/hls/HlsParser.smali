.class public abstract Lcom/comcast/cim/cmasl/hls/HlsParser;
.super Ljava/lang/Object;
.source "HlsParser.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/comcast/cim/cmasl/hls/HlsPlaylist;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    .local p0, "this":Lcom/comcast/cim/cmasl/hls/HlsParser;, "Lcom/comcast/cim/cmasl/hls/HlsParser<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract parseStream(Ljava/io/InputStream;)Lcom/comcast/cim/cmasl/hls/HlsPlaylist;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/InputStream;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method protected processBaseItem(Lcom/comcast/cim/cmasl/hls/HlsPlaylist;Ljava/lang/String;)V
    .locals 2
    .param p1, "playlist"    # Lcom/comcast/cim/cmasl/hls/HlsPlaylist;
    .param p2, "line"    # Ljava/lang/String;

    .prologue
    .line 10
    .local p0, "this":Lcom/comcast/cim/cmasl/hls/HlsParser;, "Lcom/comcast/cim/cmasl/hls/HlsParser<TT;>;"
    const-string v0, "#EXT-X-VERSION:"

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 11
    const-string v0, "#EXT-X-VERSION:"

    const-string v1, ""

    invoke-virtual {p2, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p1, Lcom/comcast/cim/cmasl/hls/HlsPlaylist;->version:Ljava/lang/String;

    .line 15
    :goto_0
    return-void

    .line 13
    :cond_0
    invoke-virtual {p1, p2}, Lcom/comcast/cim/cmasl/hls/HlsPlaylist;->addUnknownTag(Ljava/lang/String;)V

    goto :goto_0
.end method
