.class public Lcom/amazon/ansel/fetch/UriRequest;
.super Ljava/lang/Object;
.source "UriRequest.java"


# instance fields
.field private final headers:Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final method:Ljava/lang/String;

.field private final uri:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "uri"    # Ljava/lang/String;

    .prologue
    .line 18
    sget-object v0, Lcom/amazon/ansel/fetch/tools/web/HttpMethod;->GET:Lcom/amazon/ansel/fetch/tools/web/HttpMethod;

    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/tools/web/HttpMethod;->getName()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, v0, p1, v1}, Lcom/amazon/ansel/fetch/UriRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;)V

    .line 19
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;)V
    .locals 0
    .param p1, "method"    # Ljava/lang/String;
    .param p2, "uri"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 11
    .local p3, "headers":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/amazon/ansel/fetch/UriRequest;->method:Ljava/lang/String;

    .line 13
    iput-object p2, p0, Lcom/amazon/ansel/fetch/UriRequest;->uri:Ljava/lang/String;

    .line 14
    iput-object p3, p0, Lcom/amazon/ansel/fetch/UriRequest;->headers:Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;

    .line 15
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

    .line 72
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
    check-cast v0, Lcom/amazon/ansel/fetch/UriRequest;

    .line 57
    .local v0, "other":Lcom/amazon/ansel/fetch/UriRequest;
    iget-object v3, p0, Lcom/amazon/ansel/fetch/UriRequest;->headers:Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;

    if-nez v3, :cond_4

    .line 58
    iget-object v3, v0, Lcom/amazon/ansel/fetch/UriRequest;->headers:Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;

    if-eqz v3, :cond_5

    move v1, v2

    .line 59
    goto :goto_0

    .line 60
    :cond_4
    iget-object v3, p0, Lcom/amazon/ansel/fetch/UriRequest;->headers:Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;

    iget-object v4, v0, Lcom/amazon/ansel/fetch/UriRequest;->headers:Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;

    invoke-virtual {v3, v4}, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5

    move v1, v2

    .line 61
    goto :goto_0

    .line 62
    :cond_5
    iget-object v3, p0, Lcom/amazon/ansel/fetch/UriRequest;->method:Ljava/lang/String;

    if-nez v3, :cond_6

    .line 63
    iget-object v3, v0, Lcom/amazon/ansel/fetch/UriRequest;->method:Ljava/lang/String;

    if-eqz v3, :cond_7

    move v1, v2

    .line 64
    goto :goto_0

    .line 65
    :cond_6
    iget-object v3, p0, Lcom/amazon/ansel/fetch/UriRequest;->method:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/ansel/fetch/UriRequest;->method:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_7

    move v1, v2

    .line 66
    goto :goto_0

    .line 67
    :cond_7
    iget-object v3, p0, Lcom/amazon/ansel/fetch/UriRequest;->uri:Ljava/lang/String;

    if-nez v3, :cond_8

    .line 68
    iget-object v3, v0, Lcom/amazon/ansel/fetch/UriRequest;->uri:Ljava/lang/String;

    if-eqz v3, :cond_0

    move v1, v2

    .line 69
    goto :goto_0

    .line 70
    :cond_8
    iget-object v3, p0, Lcom/amazon/ansel/fetch/UriRequest;->uri:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/ansel/fetch/UriRequest;->uri:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 71
    goto :goto_0
.end method

.method public getHeaders()Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/ansel/fetch/UriRequest;->headers:Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;

    return-object v0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/ansel/fetch/UriRequest;->method:Ljava/lang/String;

    return-object v0
.end method

.method public getUri()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/ansel/fetch/UriRequest;->uri:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 5

    .prologue
    const/4 v3, 0x0

    .line 40
    const/16 v0, 0x1f

    .line 41
    .local v0, "prime":I
    const/4 v1, 0x1

    .line 42
    .local v1, "result":I
    iget-object v2, p0, Lcom/amazon/ansel/fetch/UriRequest;->headers:Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;

    if-nez v2, :cond_0

    move v2, v3

    :goto_0
    add-int/lit8 v1, v2, 0x1f

    .line 43
    mul-int/lit8 v4, v1, 0x1f

    iget-object v2, p0, Lcom/amazon/ansel/fetch/UriRequest;->method:Ljava/lang/String;

    if-nez v2, :cond_1

    move v2, v3

    :goto_1
    add-int v1, v4, v2

    .line 44
    mul-int/lit8 v2, v1, 0x1f

    iget-object v4, p0, Lcom/amazon/ansel/fetch/UriRequest;->uri:Ljava/lang/String;

    if-nez v4, :cond_2

    :goto_2
    add-int v1, v2, v3

    .line 45
    return v1

    .line 42
    :cond_0
    iget-object v2, p0, Lcom/amazon/ansel/fetch/UriRequest;->headers:Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;

    invoke-virtual {v2}, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->hashCode()I

    move-result v2

    goto :goto_0

    .line 43
    :cond_1
    iget-object v2, p0, Lcom/amazon/ansel/fetch/UriRequest;->method:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    goto :goto_1

    .line 44
    :cond_2
    iget-object v3, p0, Lcom/amazon/ansel/fetch/UriRequest;->uri:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v3

    goto :goto_2
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/ansel/fetch/UriRequest;->uri:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/ansel/fetch/UriRequest;->uri:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, ""

    goto :goto_0
.end method
