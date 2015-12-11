.class public Lcom/fasterxml/jackson/databind/util/ByteBufferBackedInputStream;
.super Ljava/io/InputStream;
.source "ByteBufferBackedInputStream.java"


# instance fields
.field protected final _buffer:Ljava/nio/ByteBuffer;


# direct methods
.method public constructor <init>(Ljava/nio/ByteBuffer;)V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/util/ByteBufferBackedInputStream;->_buffer:Ljava/nio/ByteBuffer;

    .line 17
    return-void
.end method


# virtual methods
.method public available()I
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/ByteBufferBackedInputStream;->_buffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v0

    return v0
.end method

.method public read()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 26
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/ByteBufferBackedInputStream;->_buffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->hasRemaining()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/ByteBufferBackedInputStream;->_buffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->get()B

    move-result v0

    and-int/lit16 v0, v0, 0xff

    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public read([BII)I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 32
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/ByteBufferBackedInputStream;->_buffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->hasRemaining()Z

    move-result v0

    if-nez v0, :cond_0

    .line 33
    const/4 v0, -0x1

    .line 37
    :goto_0
    return v0

    .line 35
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/util/ByteBufferBackedInputStream;->_buffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v0

    invoke-static {p3, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 36
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/util/ByteBufferBackedInputStream;->_buffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v1, p1, p2, v0}, Ljava/nio/ByteBuffer;->get([BII)Ljava/nio/ByteBuffer;

    goto :goto_0
.end method
