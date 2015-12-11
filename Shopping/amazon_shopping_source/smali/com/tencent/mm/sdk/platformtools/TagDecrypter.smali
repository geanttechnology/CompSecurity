.class public Lcom/tencent/mm/sdk/platformtools/TagDecrypter;
.super Ljava/lang/Object;
.source "TagDecrypter.java"


# instance fields
.field private final des:Lcom/tencent/mm/algorithm/DESUtil;

.field private tagLruCache:Lcom/tencent/mm/sdk/platformtools/LruCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/tencent/mm/sdk/platformtools/LruCache",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# virtual methods
.method public decryptTag(Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p1, "inTag"    # Ljava/lang/String;

    .prologue
    const/4 v9, 0x1

    .line 14
    move-object v7, p1

    .line 17
    .local v7, "tag":Ljava/lang/String;
    :try_start_0
    const-string/jumbo v8, "!"

    invoke-virtual {v7, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 18
    iget-object v8, p0, Lcom/tencent/mm/sdk/platformtools/TagDecrypter;->tagLruCache:Lcom/tencent/mm/sdk/platformtools/LruCache;

    invoke-virtual {v8, v7}, Lcom/tencent/mm/sdk/platformtools/LruCache;->check(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 19
    iget-object v8, p0, Lcom/tencent/mm/sdk/platformtools/TagDecrypter;->tagLruCache:Lcom/tencent/mm/sdk/platformtools/LruCache;

    invoke-virtual {v8, v7}, Lcom/tencent/mm/sdk/platformtools/LruCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 41
    :goto_0
    return-object v8

    .line 22
    :cond_0
    const/4 v8, 0x1

    invoke-virtual {v7, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v7

    .line 23
    const-string/jumbo v8, "@"

    invoke-virtual {v7, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    .line 25
    .local v6, "strings":[Ljava/lang/String;
    array-length v8, v6

    if-le v8, v9, :cond_1

    .line 26
    const/4 v8, 0x0

    aget-object v4, v6, v8

    .line 27
    .local v4, "lenStr":Ljava/lang/String;
    const/4 v8, 0x0

    aget-object v8, v6, v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 28
    .local v1, "encryptedLen":I
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v8

    add-int/lit8 v8, v8, 0x1

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v9

    add-int/lit8 v9, v9, 0x1

    add-int/2addr v9, v1

    invoke-virtual {v7, v8, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 29
    .local v2, "encryptedTag":Ljava/lang/String;
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v8

    add-int/lit8 v8, v8, 0x1

    add-int/2addr v8, v1

    invoke-virtual {v7, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    .line 31
    .local v3, "left":Ljava/lang/String;
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v9, p0, Lcom/tencent/mm/sdk/platformtools/TagDecrypter;->des:Lcom/tencent/mm/algorithm/DESUtil;

    invoke-virtual {v9, v2}, Lcom/tencent/mm/algorithm/DESUtil;->decryptStr(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 32
    .local v5, "originalTag":Ljava/lang/String;
    iget-object v8, p0, Lcom/tencent/mm/sdk/platformtools/TagDecrypter;->tagLruCache:Lcom/tencent/mm/sdk/platformtools/LruCache;

    invoke-virtual {v8, p1, v5}, Lcom/tencent/mm/sdk/platformtools/LruCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object v8, v5

    .line 34
    goto :goto_0

    .line 37
    .end local v1    # "encryptedLen":I
    .end local v2    # "encryptedTag":Ljava/lang/String;
    .end local v3    # "left":Ljava/lang/String;
    .end local v4    # "lenStr":Ljava/lang/String;
    .end local v5    # "originalTag":Ljava/lang/String;
    .end local v6    # "strings":[Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 38
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 39
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "[td]"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    move-object v8, v7

    .line 41
    goto :goto_0
.end method
