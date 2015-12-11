.class interface abstract Lcom/squareup/okhttp/internal/spdy/Variant;
.super Ljava/lang/Object;
.source "Variant.java"


# virtual methods
.method public abstract getProtocol()Lcom/squareup/okhttp/Protocol;
.end method

.method public abstract maxFrameSize()I
.end method

.method public abstract newReader(Lcom/squareup/okhttp/internal/okio/BufferedSource;Z)Lcom/squareup/okhttp/internal/spdy/FrameReader;
.end method

.method public abstract newWriter(Lcom/squareup/okhttp/internal/okio/BufferedSink;Z)Lcom/squareup/okhttp/internal/spdy/FrameWriter;
.end method
