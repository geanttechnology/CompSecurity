.class public interface abstract Lcom/squareup/okhttp/internal/okio/BufferedSink;
.super Ljava/lang/Object;
.source "BufferedSink.java"

# interfaces
.implements Lcom/squareup/okhttp/internal/okio/Sink;


# virtual methods
.method public abstract buffer()Lcom/squareup/okhttp/internal/okio/OkBuffer;
.end method

.method public abstract emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract outputStream()Ljava/io/OutputStream;
.end method

.method public abstract write(Lcom/squareup/okhttp/internal/okio/ByteString;)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract write([B)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract write([BII)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract writeByte(I)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract writeInt(I)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract writeShort(I)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract writeUtf8(Ljava/lang/String;)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
