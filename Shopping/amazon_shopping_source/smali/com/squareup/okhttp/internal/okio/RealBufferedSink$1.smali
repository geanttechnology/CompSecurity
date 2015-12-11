.class Lcom/squareup/okhttp/internal/okio/RealBufferedSink$1;
.super Ljava/io/OutputStream;
.source "RealBufferedSink.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->outputStream()Ljava/io/OutputStream;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/squareup/okhttp/internal/okio/RealBufferedSink;


# direct methods
.method constructor <init>(Lcom/squareup/okhttp/internal/okio/RealBufferedSink;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink$1;->this$0:Lcom/squareup/okhttp/internal/okio/RealBufferedSink;

    invoke-direct {p0}, Ljava/io/OutputStream;-><init>()V

    return-void
.end method

.method private checkNotClosed()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 127
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink$1;->this$0:Lcom/squareup/okhttp/internal/okio/RealBufferedSink;

    # getter for: Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->closed:Z
    invoke-static {v0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->access$000(Lcom/squareup/okhttp/internal/okio/RealBufferedSink;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 128
    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v1, "closed"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 130
    :cond_0
    return-void
.end method


# virtual methods
.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 118
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink$1;->this$0:Lcom/squareup/okhttp/internal/okio/RealBufferedSink;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->close()V

    .line 119
    return-void
.end method

.method public flush()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 112
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink$1;->this$0:Lcom/squareup/okhttp/internal/okio/RealBufferedSink;

    # getter for: Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->closed:Z
    invoke-static {v0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->access$000(Lcom/squareup/okhttp/internal/okio/RealBufferedSink;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 113
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink$1;->this$0:Lcom/squareup/okhttp/internal/okio/RealBufferedSink;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->flush()V

    .line 115
    :cond_0
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 122
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink$1;->this$0:Lcom/squareup/okhttp/internal/okio/RealBufferedSink;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".outputStream()"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public write(I)V
    .locals 2
    .param p1, "b"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 99
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink$1;->checkNotClosed()V

    .line 100
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink$1;->this$0:Lcom/squareup/okhttp/internal/okio/RealBufferedSink;

    iget-object v0, v0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    int-to-byte v1, p1

    invoke-virtual {v0, v1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writeByte(I)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .line 101
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink$1;->this$0:Lcom/squareup/okhttp/internal/okio/RealBufferedSink;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/BufferedSink;

    .line 102
    return-void
.end method

.method public write([BII)V
    .locals 1
    .param p1, "data"    # [B
    .param p2, "offset"    # I
    .param p3, "byteCount"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 105
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink$1;->checkNotClosed()V

    .line 106
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink$1;->this$0:Lcom/squareup/okhttp/internal/okio/RealBufferedSink;

    iget-object v0, v0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0, p1, p2, p3}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->write([BII)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .line 107
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink$1;->this$0:Lcom/squareup/okhttp/internal/okio/RealBufferedSink;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/BufferedSink;

    .line 108
    return-void
.end method
