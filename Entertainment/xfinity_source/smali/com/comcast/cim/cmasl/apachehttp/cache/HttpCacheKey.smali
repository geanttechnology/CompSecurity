.class public Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
.super Ljava/lang/Object;
.source "HttpCacheKey.java"

# interfaces
.implements Ljava/io/Serializable;


# instance fields
.field private final digest:Ljava/lang/String;

.field private final key:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;->key:Ljava/lang/String;

    .line 17
    new-instance v0, Ljava/lang/String;

    invoke-static {p1}, Lorg/apache/commons/codec/digest/DigestUtils;->sha(Ljava/lang/String;)[B

    move-result-object v1

    invoke-static {v1}, Lorg/apache/commons/codec/binary/Hex;->encodeHex([B)[C

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>([C)V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;->digest:Ljava/lang/String;

    .line 18
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 3
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 35
    if-ne p0, p1, :cond_0

    .line 36
    const/4 v1, 0x1

    .line 42
    :goto_0
    return v1

    .line 38
    :cond_0
    if-eqz p1, :cond_1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    if-eq v1, v2, :cond_2

    .line 39
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    :cond_2
    move-object v0, p1

    .line 41
    check-cast v0, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;

    .line 42
    .local v0, "that":Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;->key:Ljava/lang/String;

    iget-object v2, v0, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;->key:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;->key:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;->key:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public toDigest()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;->digest:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 30
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "{key="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;->key:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",digest="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;->toDigest()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
