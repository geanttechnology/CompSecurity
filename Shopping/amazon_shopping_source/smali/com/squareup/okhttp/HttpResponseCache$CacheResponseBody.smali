.class Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;
.super Lcom/squareup/okhttp/internal/http/Response$Body;
.source "HttpResponseCache.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/squareup/okhttp/HttpResponseCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "CacheResponseBody"
.end annotation


# instance fields
.field private final bodyIn:Ljava/io/InputStream;

.field private final contentLength:Ljava/lang/String;

.field private final contentType:Ljava/lang/String;

.field private final snapshot:Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;


# direct methods
.method public constructor <init>(Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "snapshot"    # Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    .param p2, "contentType"    # Ljava/lang/String;
    .param p3, "contentLength"    # Ljava/lang/String;

    .prologue
    .line 558
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/Response$Body;-><init>()V

    .line 559
    iput-object p1, p0, Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;->snapshot:Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;

    .line 560
    iput-object p2, p0, Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;->contentType:Ljava/lang/String;

    .line 561
    iput-object p3, p0, Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;->contentLength:Ljava/lang/String;

    .line 564
    new-instance v0, Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody$1;

    const/4 v1, 0x1

    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;->getInputStream(I)Ljava/io/InputStream;

    move-result-object v1

    invoke-direct {v0, p0, v1, p1}, Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody$1;-><init>(Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;Ljava/io/InputStream;Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;)V

    iput-object v0, p0, Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;->bodyIn:Ljava/io/InputStream;

    .line 570
    return-void
.end method

.method static synthetic access$000(Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;)Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;

    .prologue
    .line 551
    iget-object v0, p0, Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;->snapshot:Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;

    return-object v0
.end method


# virtual methods
.method public byteStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 589
    iget-object v0, p0, Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;->bodyIn:Ljava/io/InputStream;

    return-object v0
.end method

.method public contentLength()J
    .locals 4

    .prologue
    const-wide/16 v1, -0x1

    .line 582
    :try_start_0
    iget-object v3, p0, Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;->contentLength:Ljava/lang/String;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;->contentLength:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v1

    .line 584
    :cond_0
    :goto_0
    return-wide v1

    .line 583
    :catch_0
    move-exception v0

    .line 584
    .local v0, "e":Ljava/lang/NumberFormatException;
    goto :goto_0
.end method

.method public contentType()Lcom/squareup/okhttp/MediaType;
    .locals 1

    .prologue
    .line 577
    iget-object v0, p0, Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;->contentType:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/squareup/okhttp/HttpResponseCache$CacheResponseBody;->contentType:Ljava/lang/String;

    invoke-static {v0}, Lcom/squareup/okhttp/MediaType;->parse(Ljava/lang/String;)Lcom/squareup/okhttp/MediaType;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public ready()Z
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 573
    const/4 v0, 0x1

    return v0
.end method
