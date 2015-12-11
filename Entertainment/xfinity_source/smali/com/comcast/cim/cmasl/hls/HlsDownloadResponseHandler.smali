.class public Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;
.super Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;
.source "HlsDownloadResponseHandler.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<P:",
        "Lcom/comcast/cim/cmasl/hls/HlsPlaylist;",
        ">",
        "Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private file:Lcom/comcast/cim/cmasl/hls/HlsPlaylist;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TP;"
        }
    .end annotation
.end field

.field private finalUrl:Ljava/lang/String;

.field private final parser:Lcom/comcast/cim/cmasl/hls/HlsParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/hls/HlsParser",
            "<TP;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/cmasl/hls/HlsParser;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/hls/HlsParser",
            "<TP;>;)V"
        }
    .end annotation

    .prologue
    .line 21
    .local p0, "this":Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;, "Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler<TP;>;"
    .local p1, "parser":Lcom/comcast/cim/cmasl/hls/HlsParser;, "Lcom/comcast/cim/cmasl/hls/HlsParser<TP;>;"
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;-><init>()V

    .line 22
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;->parser:Lcom/comcast/cim/cmasl/hls/HlsParser;

    .line 23
    new-instance v0, Lcom/comcast/cim/cmasl/http/response/StrictHttpStatusCodeHandler;

    invoke-direct {v0}, Lcom/comcast/cim/cmasl/http/response/StrictHttpStatusCodeHandler;-><init>()V

    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;->addDelegateHeadersHandler(Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;)V

    .line 24
    return-void
.end method


# virtual methods
.method public getFile()Lcom/comcast/cim/cmasl/hls/HlsPlaylist;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TP;"
        }
    .end annotation

    .prologue
    .line 44
    .local p0, "this":Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;, "Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler<TP;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;->file:Lcom/comcast/cim/cmasl/hls/HlsPlaylist;

    return-object v0
.end method

.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 6
    .param p1, "bodyStream"    # Ljava/io/InputStream;

    .prologue
    .line 35
    .local p0, "this":Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;, "Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler<TP;>;"
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;->parser:Lcom/comcast/cim/cmasl/hls/HlsParser;

    invoke-virtual {v2, p1}, Lcom/comcast/cim/cmasl/hls/HlsParser;->parseStream(Ljava/io/InputStream;)Lcom/comcast/cim/cmasl/hls/HlsPlaylist;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;->file:Lcom/comcast/cim/cmasl/hls/HlsPlaylist;

    .line 36
    iget-object v2, p0, Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;->finalUrl:Ljava/lang/String;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;->finalUrl:Ljava/lang/String;

    const/16 v5, 0x2f

    invoke-virtual {v4, v5}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 37
    .local v1, "urlPrefixPath":Ljava/lang/String;
    iget-object v2, p0, Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;->file:Lcom/comcast/cim/cmasl/hls/HlsPlaylist;

    invoke-virtual {v2, v1}, Lcom/comcast/cim/cmasl/hls/HlsPlaylist;->setUrlPathPrefix(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 41
    return-void

    .line 38
    .end local v1    # "urlPrefixPath":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 39
    .local v0, "e":Ljava/io/IOException;
    new-instance v2, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-direct {v2, v0}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/io/IOException;)V

    throw v2
.end method

.method public handleResponseHeaders(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Ljava/util/Map;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "detailedRequestStatus"    # Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 28
    .local p0, "this":Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;, "Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler<TP;>;"
    .local p3, "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;->handleResponseHeaders(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Ljava/util/Map;)V

    .line 29
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;->finalUrl:Ljava/lang/String;

    .line 31
    return-void
.end method
