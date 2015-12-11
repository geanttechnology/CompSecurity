.class final Lcom/squareup/okhttp/internal/http/CacheStrategy$1;
.super Lcom/squareup/okhttp/internal/http/Response$Body;
.source "CacheStrategy.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/squareup/okhttp/internal/http/CacheStrategy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/Response$Body;-><init>()V

    return-void
.end method


# virtual methods
.method public byteStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 34
    sget-object v0, Lcom/squareup/okhttp/internal/Util;->EMPTY_INPUT_STREAM:Ljava/io/InputStream;

    return-object v0
.end method

.method public contentLength()J
    .locals 2

    .prologue
    .line 31
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public contentType()Lcom/squareup/okhttp/MediaType;
    .locals 1

    .prologue
    .line 28
    const/4 v0, 0x0

    return-object v0
.end method

.method public ready()Z
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 25
    const/4 v0, 0x1

    return v0
.end method
