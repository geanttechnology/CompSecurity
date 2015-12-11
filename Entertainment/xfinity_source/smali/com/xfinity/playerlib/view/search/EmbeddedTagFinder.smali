.class public Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;
.super Ljava/lang/Object;
.source "EmbeddedTagFinder.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Lcom/xfinity/playerlib/model/tags/Tag;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field private static final DESCENDING_LENGTH_COMPARATOR:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final nameToTagMap:Ljava/util/SortedMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/SortedMap",
            "<",
            "Ljava/lang/String;",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    new-instance v0, Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder$1;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder$1;-><init>()V

    sput-object v0, Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;->DESCENDING_LENGTH_COMPARATOR:Ljava/util/Comparator;

    return-void
.end method

.method public constructor <init>(Ljava/util/Collection;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 35
    .local p0, "this":Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;, "Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder<TT;>;"
    .local p1, "tags":Ljava/util/Collection;, "Ljava/util/Collection<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 39
    new-instance v0, Ljava/util/TreeMap;

    sget-object v2, Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;->DESCENDING_LENGTH_COMPARATOR:Ljava/util/Comparator;

    invoke-direct {v0, v2}, Ljava/util/TreeMap;-><init>(Ljava/util/Comparator;)V

    .line 40
    .local v0, "canonicalizedMap":Ljava/util/SortedMap;, "Ljava/util/SortedMap<Ljava/lang/String;TT;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/tags/Tag;

    .line 41
    .local v1, "namedValue":Lcom/xfinity/playerlib/model/tags/Tag;, "TT;"
    invoke-interface {v1}, Lcom/xfinity/playerlib/model/tags/Tag;->getName()Ljava/lang/String;

    move-result-object v3

    sget-object v4, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v3, v4}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v3, v1}, Ljava/util/SortedMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 43
    .end local v1    # "namedValue":Lcom/xfinity/playerlib/model/tags/Tag;, "TT;"
    :cond_0
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableSortedMap(Ljava/util/SortedMap;)Ljava/util/SortedMap;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;->nameToTagMap:Ljava/util/SortedMap;

    .line 44
    return-void
.end method

.method private buildSubstringList([Ljava/lang/String;)Ljava/util/List;
    .locals 8
    .param p1, "words"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 89
    .local p0, "this":Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;, "Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder<TT;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v5

    .line 90
    .local v5, "substringsByLengthDesc":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    array-length v1, p1

    .line 91
    .local v1, "numTokens":I
    const/4 v2, 0x1

    .local v2, "numWordsInSubstring":I
    :goto_0
    if-gt v2, v1, :cond_1

    .line 93
    const/4 v3, 0x0

    .local v3, "startingOffset":I
    :goto_1
    add-int v0, v3, v2

    .local v0, "endingOffset":I
    array-length v6, p1

    if-gt v0, v6, :cond_0

    .line 94
    invoke-static {p1, v3, v0}, Lorg/apache/commons/lang3/ArrayUtils;->subarray([Ljava/lang/Object;II)[Ljava/lang/Object;

    move-result-object v6

    const/16 v7, 0x20

    invoke-static {v6, v7}, Lorg/apache/commons/lang3/StringUtils;->join([Ljava/lang/Object;C)Ljava/lang/String;

    move-result-object v4

    .line 95
    .local v4, "substring":Ljava/lang/String;
    invoke-interface {v5, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 93
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 91
    .end local v4    # "substring":Ljava/lang/String;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 98
    .end local v0    # "endingOffset":I
    .end local v3    # "startingOffset":I
    :cond_1
    sget-object v6, Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;->DESCENDING_LENGTH_COMPARATOR:Ljava/util/Comparator;

    invoke-static {v5, v6}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 99
    return-object v5
.end method


# virtual methods
.method public getResults(Ljava/lang/String;)Ljava/util/List;
    .locals 11
    .param p1, "rawQuery"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 48
    .local p0, "this":Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;, "Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder<TT;>;"
    sget-object v9, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v9}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    .line 49
    .local v0, "canonicalizedRawQuery":Ljava/lang/String;
    invoke-static {v0}, Lorg/apache/commons/lang3/StringUtils;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    .line 50
    .local v8, "tokens":[Ljava/lang/String;
    invoke-direct {p0, v8}, Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;->buildSubstringList([Ljava/lang/String;)Ljava/util/List;

    move-result-object v7

    .line 52
    .local v7, "substringsByLengthDesc":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v1

    .line 55
    .local v1, "embeddedTags":Ljava/util/List;, "Ljava/util/List<TT;>;"
    iget-object v9, p0, Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;->nameToTagMap:Ljava/util/SortedMap;

    invoke-interface {v9}, Ljava/util/SortedMap;->entrySet()Ljava/util/Set;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_0
    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_3

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map$Entry;

    .line 56
    .local v4, "nameToValueEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;TT;>;"
    invoke-interface {v4}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 57
    .local v5, "networkName":Ljava/lang/String;
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v3

    .line 59
    .local v3, "nameLength":I
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v10

    if-gt v3, v10, :cond_0

    .line 63
    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 64
    .local v2, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_1
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_0

    .line 65
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 66
    .local v6, "subString":Ljava/lang/String;
    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v10

    if-le v10, v3, :cond_2

    .line 68
    invoke-interface {v2}, Ljava/util/Iterator;->remove()V

    goto :goto_1

    .line 69
    :cond_2
    invoke-virtual {v6, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_1

    .line 70
    invoke-interface {v4}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v10

    invoke-interface {v1, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 71
    invoke-interface {v2}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 76
    .end local v2    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v3    # "nameLength":I
    .end local v4    # "nameToValueEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;TT;>;"
    .end local v5    # "networkName":Ljava/lang/String;
    .end local v6    # "subString":Ljava/lang/String;
    :cond_3
    return-object v1
.end method
