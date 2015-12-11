.class public interface abstract Lcom/amazon/ansel/fetch/tools/web/WebResponse;
.super Ljava/lang/Object;
.source "WebResponse.java"


# virtual methods
.method public abstract getContent()Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract getStatusCode()I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
