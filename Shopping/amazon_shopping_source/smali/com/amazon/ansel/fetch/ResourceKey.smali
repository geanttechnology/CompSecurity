.class public Lcom/amazon/ansel/fetch/ResourceKey;
.super Ljava/lang/Object;
.source "ResourceKey.java"


# instance fields
.field private volatile hash:I

.field private volatile hashed:Z

.field private final operation:Ljava/lang/Object;

.field private final resourceRequest:Ljava/lang/Object;


# direct methods
.method public constructor <init>(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 1
    .param p1, "operation"    # Ljava/lang/Object;
    .param p2, "resourceRequest"    # Ljava/lang/Object;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/ansel/fetch/ResourceKey;->hash:I

    .line 20
    iput-object p1, p0, Lcom/amazon/ansel/fetch/ResourceKey;->operation:Ljava/lang/Object;

    .line 21
    iput-object p2, p0, Lcom/amazon/ansel/fetch/ResourceKey;->resourceRequest:Ljava/lang/Object;

    .line 22
    return-void
.end method

.method private hashCodeInternal()I
    .locals 5

    .prologue
    const/4 v3, 0x0

    .line 50
    const/16 v0, 0x1f

    .line 51
    .local v0, "prime":I
    const/4 v1, 0x1

    .line 52
    .local v1, "result":I
    iget-object v2, p0, Lcom/amazon/ansel/fetch/ResourceKey;->operation:Ljava/lang/Object;

    if-nez v2, :cond_0

    move v2, v3

    :goto_0
    add-int/lit8 v1, v2, 0x1f

    .line 54
    mul-int/lit8 v2, v1, 0x1f

    iget-object v4, p0, Lcom/amazon/ansel/fetch/ResourceKey;->resourceRequest:Ljava/lang/Object;

    if-nez v4, :cond_1

    :goto_1
    add-int v1, v2, v3

    .line 58
    return v1

    .line 52
    :cond_0
    iget-object v2, p0, Lcom/amazon/ansel/fetch/ResourceKey;->operation:Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    goto :goto_0

    .line 54
    :cond_1
    iget-object v3, p0, Lcom/amazon/ansel/fetch/ResourceKey;->resourceRequest:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v3

    goto :goto_1
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 63
    if-ne p0, p1, :cond_1

    .line 80
    :cond_0
    :goto_0
    return v1

    .line 65
    :cond_1
    if-nez p1, :cond_2

    move v1, v2

    .line 66
    goto :goto_0

    .line 67
    :cond_2
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    move v1, v2

    .line 68
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 69
    check-cast v0, Lcom/amazon/ansel/fetch/ResourceKey;

    .line 70
    .local v0, "other":Lcom/amazon/ansel/fetch/ResourceKey;
    iget-object v3, p0, Lcom/amazon/ansel/fetch/ResourceKey;->operation:Ljava/lang/Object;

    if-nez v3, :cond_4

    .line 71
    iget-object v3, v0, Lcom/amazon/ansel/fetch/ResourceKey;->operation:Ljava/lang/Object;

    if-eqz v3, :cond_5

    move v1, v2

    .line 72
    goto :goto_0

    .line 73
    :cond_4
    iget-object v3, p0, Lcom/amazon/ansel/fetch/ResourceKey;->operation:Ljava/lang/Object;

    iget-object v4, v0, Lcom/amazon/ansel/fetch/ResourceKey;->operation:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5

    move v1, v2

    .line 74
    goto :goto_0

    .line 75
    :cond_5
    iget-object v3, p0, Lcom/amazon/ansel/fetch/ResourceKey;->resourceRequest:Ljava/lang/Object;

    if-nez v3, :cond_6

    .line 76
    iget-object v3, v0, Lcom/amazon/ansel/fetch/ResourceKey;->resourceRequest:Ljava/lang/Object;

    if-eqz v3, :cond_0

    move v1, v2

    .line 77
    goto :goto_0

    .line 78
    :cond_6
    iget-object v3, p0, Lcom/amazon/ansel/fetch/ResourceKey;->resourceRequest:Ljava/lang/Object;

    iget-object v4, v0, Lcom/amazon/ansel/fetch/ResourceKey;->resourceRequest:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 79
    goto :goto_0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 39
    iget-boolean v0, p0, Lcom/amazon/ansel/fetch/ResourceKey;->hashed:Z

    if-eqz v0, :cond_0

    .line 40
    iget v0, p0, Lcom/amazon/ansel/fetch/ResourceKey;->hash:I

    .line 46
    :goto_0
    return v0

    .line 43
    :cond_0
    invoke-direct {p0}, Lcom/amazon/ansel/fetch/ResourceKey;->hashCodeInternal()I

    move-result v0

    iput v0, p0, Lcom/amazon/ansel/fetch/ResourceKey;->hash:I

    .line 44
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/ansel/fetch/ResourceKey;->hashed:Z

    .line 46
    iget v0, p0, Lcom/amazon/ansel/fetch/ResourceKey;->hash:I

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 34
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/ansel/fetch/ResourceKey;->operation:Ljava/lang/Object;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/ansel/fetch/ResourceKey;->resourceRequest:Ljava/lang/Object;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
