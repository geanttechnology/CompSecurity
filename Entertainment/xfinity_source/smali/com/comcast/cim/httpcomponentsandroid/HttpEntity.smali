.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
.super Ljava/lang/Object;
.source "HttpEntity.java"


# virtual methods
.method public abstract getContent()Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract getContentEncoding()Lcom/comcast/cim/httpcomponentsandroid/Header;
.end method

.method public abstract getContentLength()J
.end method

.method public abstract getContentType()Lcom/comcast/cim/httpcomponentsandroid/Header;
.end method

.method public abstract isChunked()Z
.end method

.method public abstract isRepeatable()Z
.end method

.method public abstract isStreaming()Z
.end method

.method public abstract writeTo(Ljava/io/OutputStream;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
