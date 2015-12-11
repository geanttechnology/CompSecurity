.class public Lcom/amazon/ansel/fetch/ImageRequest;
.super Ljava/lang/Object;
.source "ImageRequest.java"


# instance fields
.field private final bitmapDensity:I

.field private final uriRequest:Lcom/amazon/ansel/fetch/UriRequest;


# direct methods
.method public constructor <init>(Lcom/amazon/ansel/fetch/UriRequest;)V
    .locals 1
    .param p1, "uriRequest"    # Lcom/amazon/ansel/fetch/UriRequest;

    .prologue
    .line 18
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/ansel/fetch/ImageRequest;-><init>(Lcom/amazon/ansel/fetch/UriRequest;I)V

    .line 19
    return-void
.end method

.method public constructor <init>(Lcom/amazon/ansel/fetch/UriRequest;I)V
    .locals 0
    .param p1, "uriRequest"    # Lcom/amazon/ansel/fetch/UriRequest;
    .param p2, "bitmapDensity"    # I

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/amazon/ansel/fetch/ImageRequest;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    .line 14
    iput p2, p0, Lcom/amazon/ansel/fetch/ImageRequest;->bitmapDensity:I

    .line 15
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "uri"    # Ljava/lang/String;

    .prologue
    .line 22
    new-instance v0, Lcom/amazon/ansel/fetch/UriRequest;

    invoke-direct {v0, p1}, Lcom/amazon/ansel/fetch/UriRequest;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/amazon/ansel/fetch/ImageRequest;-><init>(Lcom/amazon/ansel/fetch/UriRequest;)V

    .line 23
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 50
    if-ne p0, p1, :cond_1

    .line 64
    :cond_0
    :goto_0
    return v1

    .line 52
    :cond_1
    if-nez p1, :cond_2

    move v1, v2

    .line 53
    goto :goto_0

    .line 54
    :cond_2
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    move v1, v2

    .line 55
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 56
    check-cast v0, Lcom/amazon/ansel/fetch/ImageRequest;

    .line 57
    .local v0, "other":Lcom/amazon/ansel/fetch/ImageRequest;
    iget v3, p0, Lcom/amazon/ansel/fetch/ImageRequest;->bitmapDensity:I

    iget v4, v0, Lcom/amazon/ansel/fetch/ImageRequest;->bitmapDensity:I

    if-eq v3, v4, :cond_4

    move v1, v2

    .line 58
    goto :goto_0

    .line 59
    :cond_4
    iget-object v3, p0, Lcom/amazon/ansel/fetch/ImageRequest;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    if-nez v3, :cond_5

    .line 60
    iget-object v3, v0, Lcom/amazon/ansel/fetch/ImageRequest;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    if-eqz v3, :cond_0

    move v1, v2

    .line 61
    goto :goto_0

    .line 62
    :cond_5
    iget-object v3, p0, Lcom/amazon/ansel/fetch/ImageRequest;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    iget-object v4, v0, Lcom/amazon/ansel/fetch/ImageRequest;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    invoke-virtual {v3, v4}, Lcom/amazon/ansel/fetch/UriRequest;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 63
    goto :goto_0
.end method

.method public getBitmapDensity()I
    .locals 1

    .prologue
    .line 30
    iget v0, p0, Lcom/amazon/ansel/fetch/ImageRequest;->bitmapDensity:I

    return v0
.end method

.method public getUriRequest()Lcom/amazon/ansel/fetch/UriRequest;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ImageRequest;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    .line 40
    const/16 v0, 0x1f

    .line 41
    .local v0, "prime":I
    const/4 v1, 0x1

    .line 42
    .local v1, "result":I
    iget v2, p0, Lcom/amazon/ansel/fetch/ImageRequest;->bitmapDensity:I

    add-int/lit8 v1, v2, 0x1f

    .line 43
    mul-int/lit8 v3, v1, 0x1f

    iget-object v2, p0, Lcom/amazon/ansel/fetch/ImageRequest;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    add-int v1, v3, v2

    .line 45
    return v1

    .line 43
    :cond_0
    iget-object v2, p0, Lcom/amazon/ansel/fetch/ImageRequest;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    invoke-virtual {v2}, Lcom/amazon/ansel/fetch/UriRequest;->hashCode()I

    move-result v2

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ImageRequest;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/ansel/fetch/ImageRequest;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/UriRequest;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, ""

    goto :goto_0
.end method
