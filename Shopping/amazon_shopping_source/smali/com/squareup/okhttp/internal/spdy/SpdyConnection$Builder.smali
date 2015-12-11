.class public Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;
.super Ljava/lang/Object;
.source "SpdyConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private client:Z

.field private handler:Lcom/squareup/okhttp/internal/spdy/IncomingStreamHandler;

.field private hostName:Ljava/lang/String;

.field private protocol:Lcom/squareup/okhttp/Protocol;

.field private pushObserver:Lcom/squareup/okhttp/internal/spdy/PushObserver;

.field private sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;

.field private source:Lcom/squareup/okhttp/internal/okio/BufferedSource;


# direct methods
.method public constructor <init>(Ljava/lang/String;ZLcom/squareup/okhttp/internal/okio/BufferedSource;Lcom/squareup/okhttp/internal/okio/BufferedSink;)V
    .locals 1
    .param p1, "hostName"    # Ljava/lang/String;
    .param p2, "client"    # Z
    .param p3, "source"    # Lcom/squareup/okhttp/internal/okio/BufferedSource;
    .param p4, "sink"    # Lcom/squareup/okhttp/internal/okio/BufferedSink;

    .prologue
    .line 510
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 496
    sget-object v0, Lcom/squareup/okhttp/internal/spdy/IncomingStreamHandler;->REFUSE_INCOMING_STREAMS:Lcom/squareup/okhttp/internal/spdy/IncomingStreamHandler;

    iput-object v0, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->handler:Lcom/squareup/okhttp/internal/spdy/IncomingStreamHandler;

    .line 497
    sget-object v0, Lcom/squareup/okhttp/Protocol;->SPDY_3:Lcom/squareup/okhttp/Protocol;

    iput-object v0, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->protocol:Lcom/squareup/okhttp/Protocol;

    .line 498
    sget-object v0, Lcom/squareup/okhttp/internal/spdy/PushObserver;->CANCEL:Lcom/squareup/okhttp/internal/spdy/PushObserver;

    iput-object v0, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->pushObserver:Lcom/squareup/okhttp/internal/spdy/PushObserver;

    .line 511
    iput-object p1, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->hostName:Ljava/lang/String;

    .line 512
    iput-boolean p2, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->client:Z

    .line 513
    iput-object p3, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    .line 514
    iput-object p4, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    .line 515
    return-void
.end method

.method public constructor <init>(ZLjava/net/Socket;)V
    .locals 3
    .param p1, "client"    # Z
    .param p2, "socket"    # Ljava/net/Socket;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 502
    const-string/jumbo v0, ""

    invoke-virtual {p2}, Ljava/net/Socket;->getInputStream()Ljava/io/InputStream;

    move-result-object v1

    invoke-static {v1}, Lcom/squareup/okhttp/internal/okio/Okio;->source(Ljava/io/InputStream;)Lcom/squareup/okhttp/internal/okio/Source;

    move-result-object v1

    invoke-static {v1}, Lcom/squareup/okhttp/internal/okio/Okio;->buffer(Lcom/squareup/okhttp/internal/okio/Source;)Lcom/squareup/okhttp/internal/okio/BufferedSource;

    move-result-object v1

    invoke-virtual {p2}, Ljava/net/Socket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v2

    invoke-static {v2}, Lcom/squareup/okhttp/internal/okio/Okio;->sink(Ljava/io/OutputStream;)Lcom/squareup/okhttp/internal/okio/Sink;

    move-result-object v2

    invoke-static {v2}, Lcom/squareup/okhttp/internal/okio/Okio;->buffer(Lcom/squareup/okhttp/internal/okio/Sink;)Lcom/squareup/okhttp/internal/okio/BufferedSink;

    move-result-object v2

    invoke-direct {p0, v0, p1, v1, v2}, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;-><init>(Ljava/lang/String;ZLcom/squareup/okhttp/internal/okio/BufferedSource;Lcom/squareup/okhttp/internal/okio/BufferedSink;)V

    .line 504
    return-void
.end method

.method static synthetic access$000(Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;)Lcom/squareup/okhttp/Protocol;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;

    .prologue
    .line 492
    iget-object v0, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->protocol:Lcom/squareup/okhttp/Protocol;

    return-object v0
.end method

.method static synthetic access$100(Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;)Lcom/squareup/okhttp/internal/spdy/PushObserver;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;

    .prologue
    .line 492
    iget-object v0, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->pushObserver:Lcom/squareup/okhttp/internal/spdy/PushObserver;

    return-object v0
.end method

.method static synthetic access$200(Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;

    .prologue
    .line 492
    iget-boolean v0, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->client:Z

    return v0
.end method

.method static synthetic access$300(Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;)Lcom/squareup/okhttp/internal/spdy/IncomingStreamHandler;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;

    .prologue
    .line 492
    iget-object v0, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->handler:Lcom/squareup/okhttp/internal/spdy/IncomingStreamHandler;

    return-object v0
.end method

.method static synthetic access$400(Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;

    .prologue
    .line 492
    iget-object v0, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->hostName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500(Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;)Lcom/squareup/okhttp/internal/okio/BufferedSource;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;

    .prologue
    .line 492
    iget-object v0, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    return-object v0
.end method

.method static synthetic access$600(Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;

    .prologue
    .line 492
    iget-object v0, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    return-object v0
.end method


# virtual methods
.method public build()Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
    .locals 2

    .prologue
    .line 533
    new-instance v0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/squareup/okhttp/internal/spdy/SpdyConnection;-><init>(Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;Lcom/squareup/okhttp/internal/spdy/SpdyConnection$1;)V

    return-object v0
.end method

.method public handler(Lcom/squareup/okhttp/internal/spdy/IncomingStreamHandler;)Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;
    .locals 0
    .param p1, "handler"    # Lcom/squareup/okhttp/internal/spdy/IncomingStreamHandler;

    .prologue
    .line 518
    iput-object p1, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->handler:Lcom/squareup/okhttp/internal/spdy/IncomingStreamHandler;

    .line 519
    return-object p0
.end method

.method public protocol(Lcom/squareup/okhttp/Protocol;)Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;
    .locals 0
    .param p1, "protocol"    # Lcom/squareup/okhttp/Protocol;

    .prologue
    .line 523
    iput-object p1, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->protocol:Lcom/squareup/okhttp/Protocol;

    .line 524
    return-object p0
.end method

.method public pushObserver(Lcom/squareup/okhttp/internal/spdy/PushObserver;)Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;
    .locals 0
    .param p1, "pushObserver"    # Lcom/squareup/okhttp/internal/spdy/PushObserver;

    .prologue
    .line 528
    iput-object p1, p0, Lcom/squareup/okhttp/internal/spdy/SpdyConnection$Builder;->pushObserver:Lcom/squareup/okhttp/internal/spdy/PushObserver;

    .line 529
    return-object p0
.end method
