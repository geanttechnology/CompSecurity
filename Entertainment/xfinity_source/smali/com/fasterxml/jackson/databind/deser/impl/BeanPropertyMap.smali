.class public final Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;
.super Ljava/lang/Object;
.source "BeanPropertyMap.java"

# interfaces
.implements Ljava/io/Serializable;
.implements Ljava/lang/Iterable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$IteratorImpl;,
        Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/io/Serializable;",
        "Ljava/lang/Iterable",
        "<",
        "Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;",
        ">;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private final _buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

.field private final _hashMask:I

.field private _nextBucketIndex:I

.field private final _size:I


# direct methods
.method public constructor <init>(Ljava/util/Collection;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 42
    .local p1, "properties":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    const/4 v6, 0x0

    iput v6, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_nextBucketIndex:I

    .line 43
    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v6

    iput v6, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_size:I

    .line 44
    iget v6, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_size:I

    invoke-static {v6}, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->findSize(I)I

    move-result v0

    .line 45
    .local v0, "bucketCount":I
    add-int/lit8 v6, v0, -0x1

    iput v6, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_hashMask:I

    .line 46
    new-array v1, v0, [Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    .line 47
    .local v1, "buckets":[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    .line 48
    .local v5, "property":Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;->getName()Ljava/lang/String;

    move-result-object v4

    .line 49
    .local v4, "key":Ljava/lang/String;
    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I

    move-result v6

    iget v7, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_hashMask:I

    and-int v3, v6, v7

    .line 50
    .local v3, "index":I
    new-instance v6, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    aget-object v7, v1, v3

    iget v8, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_nextBucketIndex:I

    add-int/lit8 v9, v8, 0x1

    iput v9, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_nextBucketIndex:I

    invoke-direct {v6, v7, v4, v5, v8}, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;-><init>(Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;Ljava/lang/String;Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;I)V

    aput-object v6, v1, v3

    goto :goto_0

    .line 52
    .end local v3    # "index":I
    .end local v4    # "key":Ljava/lang/String;
    .end local v5    # "property":Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    :cond_0
    iput-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    .line 53
    return-void
.end method

.method private constructor <init>([Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;II)V
    .locals 1
    .param p1, "buckets"    # [Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    .param p2, "size"    # I
    .param p3, "index"    # I

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    const/4 v0, 0x0

    iput v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_nextBucketIndex:I

    .line 57
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    .line 58
    iput p2, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_size:I

    .line 59
    array-length v0, p1

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_hashMask:I

    .line 60
    iput p3, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_nextBucketIndex:I

    .line 61
    return-void
.end method

.method private _findWithEquals(Ljava/lang/String;I)Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "index"    # I

    .prologue
    .line 281
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    aget-object v0, v1, p2

    .line 282
    .local v0, "bucket":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    :goto_0
    if-eqz v0, :cond_1

    .line 283
    iget-object v1, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->key:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 284
    iget-object v1, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->value:Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    .line 288
    :goto_1
    return-object v1

    .line 286
    :cond_0
    iget-object v0, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->next:Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    goto :goto_0

    .line 288
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method private static final findSize(I)I
    .locals 3
    .param p0, "size"    # I

    .prologue
    .line 142
    const/16 v2, 0x20

    if-gt p0, v2, :cond_0

    add-int v0, p0, p0

    .line 143
    .local v0, "needed":I
    :goto_0
    const/4 v1, 0x2

    .line 144
    .local v1, "result":I
    :goto_1
    if-ge v1, v0, :cond_1

    .line 145
    add-int/2addr v1, v1

    goto :goto_1

    .line 142
    .end local v0    # "needed":I
    .end local v1    # "result":I
    :cond_0
    shr-int/lit8 v2, p0, 0x2

    add-int v0, p0, v2

    goto :goto_0

    .line 147
    .restart local v0    # "needed":I
    .restart local v1    # "result":I
    :cond_1
    return v1
.end method


# virtual methods
.method public assignIndexes()Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;
    .locals 7

    .prologue
    .line 129
    const/4 v3, 0x0

    .line 130
    .local v3, "index":I
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    .local v0, "arr$":[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v5, :cond_1

    aget-object v1, v0, v2

    .local v1, "bucket":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    move v4, v3

    .line 131
    .end local v3    # "index":I
    .local v4, "index":I
    :goto_1
    if-eqz v1, :cond_0

    .line 132
    iget-object v6, v1, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->value:Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    add-int/lit8 v3, v4, 0x1

    .end local v4    # "index":I
    .restart local v3    # "index":I
    invoke-virtual {v6, v4}, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;->assignIndex(I)V

    .line 133
    iget-object v1, v1, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->next:Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    move v4, v3

    .end local v3    # "index":I
    .restart local v4    # "index":I
    goto :goto_1

    .line 130
    :cond_0
    add-int/lit8 v2, v2, 0x1

    move v3, v4

    .end local v4    # "index":I
    .restart local v3    # "index":I
    goto :goto_0

    .line 136
    .end local v1    # "bucket":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    :cond_1
    return-object p0
.end method

.method public find(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 194
    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v2

    iget v3, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_hashMask:I

    and-int v1, v2, v3

    .line 195
    .local v1, "index":I
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    aget-object v0, v2, v1

    .line 197
    .local v0, "bucket":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    if-nez v0, :cond_0

    .line 198
    const/4 v2, 0x0

    .line 210
    :goto_0
    return-object v2

    .line 201
    :cond_0
    iget-object v2, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->key:Ljava/lang/String;

    if-ne v2, p1, :cond_1

    .line 202
    iget-object v2, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->value:Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    goto :goto_0

    .line 204
    :cond_1
    iget-object v0, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->next:Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    if-eqz v0, :cond_2

    .line 205
    iget-object v2, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->key:Ljava/lang/String;

    if-ne v2, p1, :cond_1

    .line 206
    iget-object v2, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->value:Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    goto :goto_0

    .line 210
    :cond_2
    invoke-direct {p0, p1, v1}, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_findWithEquals(Ljava/lang/String;I)Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    move-result-object v2

    goto :goto_0
.end method

.method public getPropertiesInInsertionOrder()[Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    .locals 9

    .prologue
    .line 174
    iget v3, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_nextBucketIndex:I

    .line 175
    .local v3, "len":I
    new-array v5, v3, [Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    .line 176
    .local v5, "result":[Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    .local v0, "arr$":[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v4, :cond_1

    aget-object v6, v0, v2

    .line 177
    .local v6, "root":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    move-object v1, v6

    .local v1, "bucket":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    :goto_1
    if-eqz v1, :cond_0

    .line 178
    iget v7, v1, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->index:I

    iget-object v8, v1, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->value:Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    aput-object v8, v5, v7

    .line 177
    iget-object v1, v1, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->next:Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    goto :goto_1

    .line 176
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 181
    .end local v1    # "bucket":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    .end local v6    # "root":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    :cond_1
    return-object v5
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;",
            ">;"
        }
    .end annotation

    .prologue
    .line 161
    new-instance v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$IteratorImpl;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$IteratorImpl;-><init>([Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;)V

    return-object v0
.end method

.method public remove(Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;)V
    .locals 9
    .param p1, "property"    # Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    .prologue
    .line 254
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;->getName()Ljava/lang/String;

    move-result-object v3

    .line 255
    .local v3, "name":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v6

    iget-object v7, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    array-length v7, v7

    add-int/lit8 v7, v7, -0x1

    and-int v2, v6, v7

    .line 256
    .local v2, "index":I
    const/4 v4, 0x0

    .line 257
    .local v4, "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    const/4 v1, 0x0

    .line 259
    .local v1, "found":Z
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    aget-object v0, v6, v2

    .local v0, "bucket":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    move-object v5, v4

    .end local v4    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    .local v5, "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    :goto_0
    if-eqz v0, :cond_1

    .line 261
    if-nez v1, :cond_0

    iget-object v6, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->key:Ljava/lang/String;

    invoke-virtual {v6, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 262
    const/4 v1, 0x1

    move-object v4, v5

    .line 259
    .end local v5    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    .restart local v4    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    :goto_1
    iget-object v0, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->next:Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    move-object v5, v4

    .end local v4    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    .restart local v5    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    goto :goto_0

    .line 264
    :cond_0
    new-instance v4, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    iget-object v6, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->key:Ljava/lang/String;

    iget-object v7, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->value:Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    iget v8, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->index:I

    invoke-direct {v4, v5, v6, v7, v8}, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;-><init>(Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;Ljava/lang/String;Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;I)V

    .end local v5    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    .restart local v4    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    goto :goto_1

    .line 267
    .end local v4    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    .restart local v5    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    :cond_1
    if-nez v1, :cond_2

    .line 268
    new-instance v6, Ljava/util/NoSuchElementException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "No entry \'"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "\' found, can\'t remove"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/util/NoSuchElementException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 270
    :cond_2
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    aput-object v5, v6, v2

    .line 271
    return-void
.end method

.method public renameAll(Lcom/fasterxml/jackson/databind/util/NameTransformer;)Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;
    .locals 7
    .param p1, "transformer"    # Lcom/fasterxml/jackson/databind/util/NameTransformer;

    .prologue
    .line 102
    if-eqz p1, :cond_0

    sget-object v6, Lcom/fasterxml/jackson/databind/util/NameTransformer;->NOP:Lcom/fasterxml/jackson/databind/util/NameTransformer;

    if-ne p1, v6, :cond_1

    .line 123
    .end local p0    # "this":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;
    :cond_0
    :goto_0
    return-object p0

    .line 105
    .restart local p0    # "this":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;
    :cond_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 106
    .local v1, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;>;"
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 107
    .local v4, "newProps":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;>;"
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 108
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    .line 109
    .local v5, "prop":Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v6}, Lcom/fasterxml/jackson/databind/util/NameTransformer;->transform(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 110
    .local v3, "newName":Ljava/lang/String;
    invoke-virtual {v5, v3}, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;->withName(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    move-result-object v5

    .line 111
    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;->getValueDeserializer()Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v0

    .line 112
    .local v0, "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz v0, :cond_2

    .line 114
    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/JsonDeserializer;->unwrappingDeserializer(Lcom/fasterxml/jackson/databind/util/NameTransformer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v2

    .line 116
    .local v2, "newDeser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;"
    if-eq v2, v0, :cond_2

    .line 117
    invoke-virtual {v5, v2}, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;->withValueDeserializer(Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    move-result-object v5

    .line 120
    .end local v2    # "newDeser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<Ljava/lang/Object;>;"
    :cond_2
    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 123
    .end local v0    # "deser":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    .end local v3    # "newName":Ljava/lang/String;
    .end local v5    # "prop":Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    :cond_3
    new-instance p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;

    .end local p0    # "this":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;
    invoke-direct {p0, v4}, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;-><init>(Ljava/util/Collection;)V

    goto :goto_0
.end method

.method public replace(Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;)V
    .locals 9
    .param p1, "property"    # Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    .prologue
    .line 220
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;->getName()Ljava/lang/String;

    move-result-object v3

    .line 221
    .local v3, "name":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v6

    iget-object v7, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    array-length v7, v7

    add-int/lit8 v7, v7, -0x1

    and-int v2, v6, v7

    .line 226
    .local v2, "index":I
    const/4 v4, 0x0

    .line 227
    .local v4, "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    const/4 v1, -0x1

    .line 229
    .local v1, "foundIndex":I
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    aget-object v0, v6, v2

    .local v0, "bucket":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    move-object v5, v4

    .end local v4    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    .local v5, "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    :goto_0
    if-eqz v0, :cond_1

    .line 231
    if-gez v1, :cond_0

    iget-object v6, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->key:Ljava/lang/String;

    invoke-virtual {v6, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 232
    iget v1, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->index:I

    move-object v4, v5

    .line 229
    .end local v5    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    .restart local v4    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    :goto_1
    iget-object v0, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->next:Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    move-object v5, v4

    .end local v4    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    .restart local v5    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    goto :goto_0

    .line 234
    :cond_0
    new-instance v4, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    iget-object v6, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->key:Ljava/lang/String;

    iget-object v7, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->value:Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    iget v8, v0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;->index:I

    invoke-direct {v4, v5, v6, v7, v8}, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;-><init>(Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;Ljava/lang/String;Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;I)V

    .end local v5    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    .restart local v4    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    goto :goto_1

    .line 238
    .end local v4    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    .restart local v5    # "tail":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    :cond_1
    if-gez v1, :cond_2

    .line 239
    new-instance v6, Ljava/util/NoSuchElementException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "No entry \'"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "\' found, can\'t replace"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/util/NoSuchElementException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 244
    :cond_2
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    new-instance v7, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    invoke-direct {v7, v5, v3, p1, v1}, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;-><init>(Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;Ljava/lang/String;Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;I)V

    aput-object v7, v6, v2

    .line 245
    return-void
.end method

.method public size()I
    .locals 1

    .prologue
    .line 190
    iget v0, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_size:I

    return v0
.end method

.method public withProperty(Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;)Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;
    .locals 10
    .param p1, "newProperty"    # Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    .prologue
    const/4 v7, 0x0

    .line 75
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    array-length v0, v6

    .line 76
    .local v0, "bcount":I
    new-array v2, v0, [Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    .line 77
    .local v2, "newBuckets":[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_buckets:[Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    invoke-static {v6, v7, v2, v7, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 78
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;->getName()Ljava/lang/String;

    move-result-object v5

    .line 80
    .local v5, "propName":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v6}, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->find(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;

    move-result-object v4

    .line 81
    .local v4, "oldProp":Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;
    if-nez v4, :cond_0

    .line 85
    invoke-virtual {v5}, Ljava/lang/String;->hashCode()I

    move-result v6

    iget v7, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_hashMask:I

    and-int v1, v6, v7

    .line 86
    .local v1, "index":I
    new-instance v6, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;

    aget-object v7, v2, v1

    iget v8, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_nextBucketIndex:I

    add-int/lit8 v9, v8, 0x1

    iput v9, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_nextBucketIndex:I

    invoke-direct {v6, v7, v5, p1, v8}, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;-><init>(Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;Ljava/lang/String;Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;I)V

    aput-object v6, v2, v1

    .line 88
    new-instance v3, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;

    iget v6, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_size:I

    add-int/lit8 v6, v6, 0x1

    iget v7, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_nextBucketIndex:I

    invoke-direct {v3, v2, v6, v7}, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;-><init>([Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;II)V

    .line 93
    .end local v1    # "index":I
    :goto_0
    return-object v3

    .line 91
    :cond_0
    new-instance v3, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;

    iget v6, p0, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->_nextBucketIndex:I

    invoke-direct {v3, v2, v0, v6}, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;-><init>([Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap$Bucket;II)V

    .line 92
    .local v3, "newMap":Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;
    invoke-virtual {v3, p1}, Lcom/fasterxml/jackson/databind/deser/impl/BeanPropertyMap;->replace(Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;)V

    goto :goto_0
.end method
