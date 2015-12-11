.class Lcom/facebook/widget/ImageDownloader$RequestKey;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final HASH_MULTIPLIER:I = 0x25

.field private static final HASH_SEED:I = 0x1d


# instance fields
.field tag:Ljava/lang/Object;

.field url:Ljava/net/URL;


# direct methods
.method constructor <init>(Ljava/net/URL;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 277
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 278
    iput-object p1, p0, Lcom/facebook/widget/ImageDownloader$RequestKey;->url:Ljava/net/URL;

    .line 279
    iput-object p2, p0, Lcom/facebook/widget/ImageDownloader$RequestKey;->tag:Ljava/lang/Object;

    .line 280
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 294
    .line 296
    if-eqz p1, :cond_0

    instance-of v1, p1, Lcom/facebook/widget/ImageDownloader$RequestKey;

    if-eqz v1, :cond_0

    .line 297
    check-cast p1, Lcom/facebook/widget/ImageDownloader$RequestKey;

    .line 298
    iget-object v1, p1, Lcom/facebook/widget/ImageDownloader$RequestKey;->url:Ljava/net/URL;

    iget-object v2, p0, Lcom/facebook/widget/ImageDownloader$RequestKey;->url:Ljava/net/URL;

    if-ne v1, v2, :cond_0

    iget-object v1, p1, Lcom/facebook/widget/ImageDownloader$RequestKey;->tag:Ljava/lang/Object;

    iget-object v2, p0, Lcom/facebook/widget/ImageDownloader$RequestKey;->tag:Ljava/lang/Object;

    if-ne v1, v2, :cond_0

    const/4 v0, 0x1

    .line 301
    :cond_0
    return v0
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 284
    iget-object v0, p0, Lcom/facebook/widget/ImageDownloader$RequestKey;->url:Ljava/net/URL;

    invoke-virtual {v0}, Ljava/net/URL;->hashCode()I

    move-result v0

    add-int/lit16 v0, v0, 0x431

    .line 287
    mul-int/lit8 v0, v0, 0x25

    iget-object v1, p0, Lcom/facebook/widget/ImageDownloader$RequestKey;->tag:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    .line 289
    return v0
.end method
