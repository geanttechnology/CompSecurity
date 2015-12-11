.class public Lcom/poshmark/utils/PMTrie;
.super Ljava/lang/Object;
.source "PMTrie.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/PMTrie$TrieNode;
    }
.end annotation


# instance fields
.field ascii_start:I

.field root:Lcom/poshmark/utils/PMTrie$TrieNode;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    const/16 v0, 0x61

    iput v0, p0, Lcom/poshmark/utils/PMTrie;->ascii_start:I

    .line 22
    new-instance v0, Lcom/poshmark/utils/PMTrie$TrieNode;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/PMTrie$TrieNode;-><init>(Lcom/poshmark/utils/PMTrie;)V

    iput-object v0, p0, Lcom/poshmark/utils/PMTrie;->root:Lcom/poshmark/utils/PMTrie$TrieNode;

    .line 23
    return-void
.end method

.method private findAll(Lcom/poshmark/utils/PMTrie$TrieNode;)Ljava/util/List;
    .locals 5
    .param p1, "root"    # Lcom/poshmark/utils/PMTrie$TrieNode;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/utils/PMTrie$TrieNode;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 59
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 60
    .local v1, "finalResults":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    const/16 v4, 0x1a

    if-ge v2, v4, :cond_1

    .line 61
    iget-object v4, p1, Lcom/poshmark/utils/PMTrie$TrieNode;->list:[Lcom/poshmark/utils/PMTrie$TrieNode;

    aget-object v4, v4, v2

    if-eqz v4, :cond_0

    .line 62
    iget v4, p0, Lcom/poshmark/utils/PMTrie;->ascii_start:I

    add-int v0, v4, v2

    .line 63
    .local v0, "asciiVal":I
    int-to-char v4, v0

    invoke-static {v4}, Ljava/lang/Character;->toString(C)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 64
    iget-object v4, p1, Lcom/poshmark/utils/PMTrie$TrieNode;->list:[Lcom/poshmark/utils/PMTrie$TrieNode;

    aget-object v4, v4, v2

    invoke-direct {p0, v4}, Lcom/poshmark/utils/PMTrie;->findAll(Lcom/poshmark/utils/PMTrie$TrieNode;)Ljava/util/List;

    move-result-object v3

    .line 65
    .local v3, "results":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0, v1, v3}, Lcom/poshmark/utils/PMTrie;->mergeToMaster(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v1

    .line 60
    .end local v0    # "asciiVal":I
    .end local v3    # "results":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 68
    :cond_1
    return-object v1
.end method

.method private mergeToMaster(Ljava/util/List;Ljava/util/List;)Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 72
    .local p1, "finalResults":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p2, "results":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 73
    .local v2, "mergedList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 74
    .local v0, "itr1":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 75
    .local v1, "itr2":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 76
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 77
    .local v3, "str1":Ljava/lang/String;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 78
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 79
    .local v4, "str2":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 82
    .end local v3    # "str1":Ljava/lang/String;
    .end local v4    # "str2":Ljava/lang/String;
    :cond_1
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v5

    if-nez v5, :cond_2

    .line 83
    invoke-interface {v2, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 85
    :cond_2
    return-object v2
.end method

.method private recursiveAdd(Lcom/poshmark/utils/PMTrie$TrieNode;Ljava/lang/String;I)V
    .locals 4
    .param p1, "node"    # Lcom/poshmark/utils/PMTrie$TrieNode;
    .param p2, "val"    # Ljava/lang/String;
    .param p3, "charPos"    # I

    .prologue
    .line 30
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    if-gt v2, p3, :cond_0

    .line 42
    :goto_0
    return-void

    .line 33
    :cond_0
    invoke-virtual {p2, p3}, Ljava/lang/String;->charAt(I)C

    move-result v1

    .line 34
    .local v1, "singleChar":C
    move v0, v1

    .line 35
    .local v0, "index":I
    iget v2, p0, Lcom/poshmark/utils/PMTrie;->ascii_start:I

    sub-int/2addr v0, v2

    .line 37
    iget-object v2, p1, Lcom/poshmark/utils/PMTrie$TrieNode;->list:[Lcom/poshmark/utils/PMTrie$TrieNode;

    aget-object v2, v2, v0

    if-nez v2, :cond_1

    .line 38
    iget-object v2, p1, Lcom/poshmark/utils/PMTrie$TrieNode;->list:[Lcom/poshmark/utils/PMTrie$TrieNode;

    new-instance v3, Lcom/poshmark/utils/PMTrie$TrieNode;

    invoke-direct {v3, p0}, Lcom/poshmark/utils/PMTrie$TrieNode;-><init>(Lcom/poshmark/utils/PMTrie;)V

    aput-object v3, v2, v0

    .line 40
    :cond_1
    iget-object v2, p1, Lcom/poshmark/utils/PMTrie$TrieNode;->list:[Lcom/poshmark/utils/PMTrie$TrieNode;

    aget-object v2, v2, v0

    add-int/lit8 v3, p3, 0x1

    invoke-direct {p0, v2, p2, v3}, Lcom/poshmark/utils/PMTrie;->recursiveAdd(Lcom/poshmark/utils/PMTrie$TrieNode;Ljava/lang/String;I)V

    goto :goto_0
.end method


# virtual methods
.method public add(Ljava/lang/String;)V
    .locals 2
    .param p1, "val"    # Ljava/lang/String;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/poshmark/utils/PMTrie;->root:Lcom/poshmark/utils/PMTrie$TrieNode;

    const/4 v1, 0x0

    invoke-direct {p0, v0, p1, v1}, Lcom/poshmark/utils/PMTrie;->recursiveAdd(Lcom/poshmark/utils/PMTrie$TrieNode;Ljava/lang/String;I)V

    .line 27
    return-void
.end method

.method public getMatchList(Ljava/lang/String;)V
    .locals 5
    .param p1, "searchString"    # Ljava/lang/String;

    .prologue
    .line 45
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 46
    .local v0, "finalResults":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v4, 0x0

    invoke-virtual {p1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v1

    .line 47
    .local v1, "firstLetter":C
    move v2, v1

    .line 48
    .local v2, "index":I
    iget v4, p0, Lcom/poshmark/utils/PMTrie;->ascii_start:I

    sub-int/2addr v2, v4

    .line 49
    iget-object v4, p0, Lcom/poshmark/utils/PMTrie;->root:Lcom/poshmark/utils/PMTrie$TrieNode;

    iget-object v4, v4, Lcom/poshmark/utils/PMTrie$TrieNode;->list:[Lcom/poshmark/utils/PMTrie$TrieNode;

    aget-object v4, v4, v2

    if-nez v4, :cond_0

    .line 56
    :goto_0
    return-void

    .line 52
    :cond_0
    invoke-static {v1}, Ljava/lang/Character;->toString(C)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 53
    iget-object v4, p0, Lcom/poshmark/utils/PMTrie;->root:Lcom/poshmark/utils/PMTrie$TrieNode;

    iget-object v4, v4, Lcom/poshmark/utils/PMTrie$TrieNode;->list:[Lcom/poshmark/utils/PMTrie$TrieNode;

    aget-object v4, v4, v2

    invoke-direct {p0, v4}, Lcom/poshmark/utils/PMTrie;->findAll(Lcom/poshmark/utils/PMTrie$TrieNode;)Ljava/util/List;

    move-result-object v3

    .line 54
    .local v3, "results":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0, v0, v3}, Lcom/poshmark/utils/PMTrie;->mergeToMaster(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    goto :goto_0
.end method
