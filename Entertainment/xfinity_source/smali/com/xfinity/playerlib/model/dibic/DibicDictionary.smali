.class public Lcom/xfinity/playerlib/model/dibic/DibicDictionary;
.super Ljava/lang/Object;
.source "DibicDictionary.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final tokens:[I

.field private final words:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const-class v0, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>([I[Ljava/lang/String;)V
    .locals 0
    .param p1, "tokens"    # [I
    .param p2, "words"    # [Ljava/lang/String;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 26
    invoke-static {p2}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 27
    iput-object p1, p0, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->tokens:[I

    .line 28
    iput-object p2, p0, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->words:[Ljava/lang/String;

    .line 29
    return-void
.end method

.method private getStringsByRange(IZ)Ljava/util/List;
    .locals 12
    .param p1, "key"    # I
    .param p2, "excludeDelimiters"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(IZ)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 43
    if-gez p1, :cond_1

    .line 44
    sget-object v7, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->LOG:Lorg/slf4j/Logger;

    const-string v8, "Key {} is negative"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-interface {v7, v8, v9}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Object;)V

    .line 45
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 74
    :cond_0
    :goto_0
    return-object v3

    .line 49
    :cond_1
    shr-int/lit8 v7, p1, 0xa

    const v8, 0x3fffff

    and-int v0, v7, v8

    .line 50
    .local v0, "firstIndex":I
    and-int/lit16 v2, p1, 0x3ff

    .line 51
    .local v2, "length":I
    add-int v7, v0, v2

    add-int/lit8 v1, v7, -0x1

    .line 54
    .local v1, "lastIndex":I
    iget-object v7, p0, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->tokens:[I

    array-length v7, v7

    if-ge v0, v7, :cond_2

    iget-object v7, p0, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->tokens:[I

    array-length v7, v7

    if-lt v1, v7, :cond_3

    .line 55
    :cond_2
    sget-object v7, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->LOG:Lorg/slf4j/Logger;

    const-string v8, "Key {} (firstIndex {}, lastIndex {}) is out of range (tokens.length {})"

    const/4 v9, 0x4

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    .line 56
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x2

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x3

    iget-object v11, p0, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->tokens:[I

    array-length v11, v11

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    .line 55
    invoke-interface {v7, v8, v9}, Lorg/slf4j/Logger;->error(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 57
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    goto :goto_0

    .line 60
    :cond_3
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 62
    .local v3, "strings":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    move v4, v0

    .local v4, "tokenIndex":I
    :goto_1
    if-gt v4, v1, :cond_0

    .line 63
    iget-object v7, p0, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->tokens:[I

    aget v6, v7, v4

    .line 64
    .local v6, "wordIndex":I
    iget-object v7, p0, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->words:[Ljava/lang/String;

    array-length v7, v7

    if-lt v6, v7, :cond_5

    .line 65
    sget-object v7, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->LOG:Lorg/slf4j/Logger;

    const-string v8, "Word index {} is out of bounds (words.length is {})"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    iget-object v10, p0, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->words:[Ljava/lang/String;

    array-length v10, v10

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-interface {v7, v8, v9, v10}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 62
    :cond_4
    :goto_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 68
    :cond_5
    iget-object v7, p0, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->words:[Ljava/lang/String;

    aget-object v5, v7, v6

    .line 69
    .local v5, "word":Ljava/lang/String;
    if-eqz p2, :cond_6

    const-string v7, ","

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_4

    const-string v7, "|"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_4

    .line 70
    :cond_6
    invoke-interface {v3, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2
.end method


# virtual methods
.method public getStringByKey(I)Ljava/lang/String;
    .locals 5
    .param p1, "key"    # I

    .prologue
    .line 32
    const/4 v3, 0x0

    invoke-direct {p0, p1, v3}, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->getStringsByRange(IZ)Ljava/util/List;

    move-result-object v2

    .line 33
    .local v2, "strings":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 34
    .local v0, "sb":Ljava/lang/StringBuilder;
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 35
    .local v1, "string":Ljava/lang/String;
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 37
    .end local v1    # "string":Ljava/lang/String;
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method public getStringsByKey(I)Ljava/util/List;
    .locals 1
    .param p1, "key"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 78
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->getStringsByRange(IZ)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
