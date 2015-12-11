.class public final Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;
.super Ljava/lang/Object;
.source "ObjectPair.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "U:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final first:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field private final second:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TU;"
        }
    .end annotation
.end field


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;, "Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair<TT;TU;>;"
    const/4 v3, 0x0

    .line 53
    instance-of v4, p1, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;

    if-nez v4, :cond_1

    .line 65
    :cond_0
    :goto_0
    return v3

    :cond_1
    move-object v0, p1

    .line 57
    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;

    .line 58
    .local v0, "pair":Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;, "Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair<**>;"
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->getFirst()Ljava/lang/Object;

    move-result-object v1

    .line 60
    .local v1, "x":Ljava/lang/Object;
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->first:Ljava/lang/Object;

    if-nez v4, :cond_2

    if-eqz v1, :cond_3

    :cond_2
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->first:Ljava/lang/Object;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->first:Ljava/lang/Object;

    invoke-virtual {v4, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 61
    :cond_3
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->getSecond()Ljava/lang/Object;

    move-result-object v2

    .line 62
    .local v2, "y":Ljava/lang/Object;
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->second:Ljava/lang/Object;

    if-nez v4, :cond_4

    if-eqz v2, :cond_5

    :cond_4
    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->second:Ljava/lang/Object;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->second:Ljava/lang/Object;

    invoke-virtual {v4, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    :cond_5
    const/4 v3, 0x1

    goto :goto_0
.end method

.method public getFirst()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 34
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;, "Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair<TT;TU;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->first:Ljava/lang/Object;

    return-object v0
.end method

.method public getSecond()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TU;"
        }
    .end annotation

    .prologue
    .line 42
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;, "Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair<TT;TU;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->second:Ljava/lang/Object;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;, "Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair<TT;TU;>;"
    const/4 v1, 0x0

    .line 75
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->first:Ljava/lang/Object;

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->second:Ljava/lang/Object;

    if-nez v2, :cond_1

    :goto_1
    xor-int/2addr v0, v1

    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->first:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->second:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    goto :goto_1
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 85
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;, "Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair<TT;TU;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->first:Ljava/lang/Object;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/util/ObjectPair;->second:Ljava/lang/Object;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
