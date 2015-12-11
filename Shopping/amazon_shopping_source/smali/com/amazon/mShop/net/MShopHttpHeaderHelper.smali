.class public Lcom/amazon/mShop/net/MShopHttpHeaderHelper;
.super Ljava/lang/Object;
.source "MShopHttpHeaderHelper.java"


# static fields
.field private static final DEBUG:Z

.field private static final HEX_DIGITS:[C

.field static final STANDARD_DATE_FORMAT:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal",
            "<",
            "Ljava/text/DateFormat;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    .line 37
    const/16 v0, 0x10

    new-array v0, v0, [C

    fill-array-data v0, :array_0

    sput-object v0, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->HEX_DIGITS:[C

    .line 289
    new-instance v0, Lcom/amazon/mShop/net/MShopHttpHeaderHelper$1;

    invoke-direct {v0}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->STANDARD_DATE_FORMAT:Ljava/lang/ThreadLocal;

    return-void

    .line 37
    nop

    :array_0
    .array-data 2
        0x30s
        0x31s
        0x32s
        0x33s
        0x34s
        0x35s
        0x36s
        0x37s
        0x38s
        0x39s
        0x61s
        0x62s
        0x63s
        0x64s
        0x65s
        0x66s
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static appendSavedHeader(Ljava/util/Map;Ljava/io/Writer;Ljava/util/Map;Ljava/lang/StringBuilder;)V
    .locals 6
    .param p1, "infWriter"    # Ljava/io/Writer;
    .param p3, "strBuilder"    # Ljava/lang/StringBuilder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;",
            "Ljava/io/Writer;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/StringBuilder;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 184
    .local p0, "header":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .local p2, "headerSaved":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    .line 185
    .local v0, "headerOld":Ljava/util/Set;, "Ljava/util/Set<Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 186
    .local v2, "itemOld":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 187
    .local v3, "key":Ljava/lang/String;
    const-string/jumbo v4, "mshop-cache-sent-time"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    const-string/jumbo v4, "mshop-cache-received-time"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 192
    invoke-interface {p0, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 193
    const/4 v4, 0x0

    invoke-virtual {p3, v4}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 194
    invoke-virtual {p3, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 195
    const-string/jumbo v4, ": "

    invoke-virtual {p3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 196
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 197
    invoke-virtual {p3}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    const/16 v5, 0xa

    invoke-virtual {p3, v4, v5}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    .line 198
    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    goto :goto_0

    .line 201
    .end local v2    # "itemOld":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "key":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method public static convertBytesToHexString([B)Ljava/lang/String;
    .locals 9
    .param p0, "bytes"    # [B

    .prologue
    .line 47
    new-instance v6, Ljava/lang/StringBuilder;

    array-length v7, p0

    mul-int/lit8 v7, v7, 0x2

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 48
    .local v6, "sb":Ljava/lang/StringBuilder;
    move-object v0, p0

    .local v0, "arr$":[B
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_0

    aget-byte v1, v0, v4

    .line 49
    .local v1, "b":B
    sget-object v7, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->HEX_DIGITS:[C

    shr-int/lit8 v8, v1, 0x4

    and-int/lit8 v8, v8, 0xf

    aget-char v2, v7, v8

    .line 50
    .local v2, "c0":C
    sget-object v7, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->HEX_DIGITS:[C

    and-int/lit8 v8, v1, 0xf

    aget-char v3, v7, v8

    .line 51
    .local v3, "c1":C
    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 52
    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 48
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 54
    .end local v1    # "b":B
    .end local v2    # "c0":C
    .end local v3    # "c1":C
    :cond_0
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    return-object v7
.end method

.method public static getLastModifiedDate(Ljava/util/Map;)J
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)J"
        }
    .end annotation

    .prologue
    .local p0, "headerFields":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-wide/16 v3, -0x1

    .line 368
    const-string/jumbo v2, "last-modified"

    invoke-static {p0, v2}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->parseHeaderDate(Ljava/util/Map;Ljava/lang/String;)J

    move-result-wide v0

    .line 369
    .local v0, "lastModifiedDate":J
    cmp-long v2, v0, v3

    if-nez v2, :cond_0

    .line 370
    const-string/jumbo v2, "date"

    invoke-static {p0, v2}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->parseHeaderDate(Ljava/util/Map;Ljava/lang/String;)J

    move-result-wide v0

    .line 371
    cmp-long v2, v0, v3

    if-nez v2, :cond_0

    .line 372
    const-string/jumbo v2, "mshop-cache-sent-time"

    invoke-static {p0, v2}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->parseHeaderDate(Ljava/util/Map;Ljava/lang/String;)J

    move-result-wide v0

    .line 375
    :cond_0
    return-wide v0
.end method

.method public static parseHeaderDate(Ljava/util/Map;Ljava/lang/String;)J
    .locals 7
    .param p1, "fieldKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")J"
        }
    .end annotation

    .prologue
    .line 335
    .local p0, "headerFields":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {p0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 336
    .local v4, "fieldValue":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 337
    const-wide/16 v1, -0x1

    .line 350
    :cond_0
    :goto_0
    return-wide v1

    .line 339
    :cond_1
    const-wide/16 v1, -0x1

    .line 341
    .local v1, "date":J
    :try_start_0
    sget-object v5, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->STANDARD_DATE_FORMAT:Ljava/lang/ThreadLocal;

    invoke-virtual {v5}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/text/DateFormat;

    invoke-virtual {v4}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 342
    .local v0, "d":Ljava/util/Date;
    if-eqz v0, :cond_0

    .line 343
    invoke-virtual {v0}, Ljava/util/Date;->getTime()J
    :try_end_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v1

    goto :goto_0

    .line 345
    .end local v0    # "d":Ljava/util/Date;
    :catch_0
    move-exception v3

    .line 346
    .local v3, "e":Ljava/text/ParseException;
    sget-boolean v5, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    if-eqz v5, :cond_0

    .line 347
    const-string/jumbo v5, "MShopHttpHeaderHelper"

    invoke-virtual {v3}, Ljava/text/ParseException;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static parseHeaderDirectiveValue(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 8
    .param p1, "fieldKey"    # Ljava/lang/String;
    .param p2, "directiveName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .local p0, "headerFields":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v5, 0x0

    .line 311
    invoke-interface {p0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 312
    .local v4, "value":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 325
    :cond_0
    :goto_0
    return-object v5

    .line 315
    :cond_1
    const-string/jumbo v6, ","

    invoke-virtual {v4, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 316
    .local v1, "directiveArray":[Ljava/lang/String;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    array-length v6, v1

    if-ge v2, v6, :cond_0

    .line 317
    aget-object v0, v1, v2

    .line 318
    .local v0, "d":Ljava/lang/String;
    const-string/jumbo v6, "="

    invoke-virtual {v0, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 319
    .local v3, "tokens":[Ljava/lang/String;
    array-length v6, v3

    const/4 v7, 0x2

    if-ne v6, v7, :cond_2

    .line 320
    const/4 v6, 0x0

    aget-object v6, v3, v6

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 321
    const/4 v5, 0x1

    aget-object v5, v3, v5

    goto :goto_0

    .line 316
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method

.method public static parseLong(Ljava/util/Map;Ljava/lang/String;)J
    .locals 7
    .param p1, "fieldKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")J"
        }
    .end annotation

    .prologue
    .local p0, "headerFields":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-wide/16 v4, -0x1

    .line 354
    invoke-interface {p0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 355
    .local v1, "fieldValue":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    move-wide v2, v4

    .line 364
    :goto_0
    return-wide v2

    .line 358
    :cond_0
    const-wide/16 v2, -0x1

    .line 360
    .local v2, "longValue":J
    :try_start_0
    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v2

    goto :goto_0

    .line 361
    :catch_0
    move-exception v0

    .local v0, "e":Ljava/lang/NumberFormatException;
    move-wide v2, v4

    .line 362
    goto :goto_0
.end method

.method static readHeaderInf(Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/util/Map;
    .locals 13
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "residencePriority"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v9, 0x0

    .line 245
    invoke-static {p0, p1}, Lcom/amazon/mShop/net/MShopDiskCache;->newInfFile(Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/io/File;

    move-result-object v6

    .line 246
    .local v6, "infFile":Ljava/io/File;
    if-nez v6, :cond_1

    move-object v4, v9

    .line 284
    :cond_0
    :goto_0
    return-object v4

    .line 249
    :cond_1
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 250
    .local v4, "headerInf":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v0, 0x0

    .line 252
    .local v0, "br":Ljava/io/BufferedReader;
    :try_start_0
    new-instance v3, Ljava/io/FileInputStream;

    invoke-direct {v3, v6}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 253
    .local v3, "fis":Ljava/io/FileInputStream;
    new-instance v1, Ljava/io/BufferedReader;

    new-instance v10, Ljava/io/InputStreamReader;

    invoke-direct {v10, v3}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v1, v10}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 255
    .end local v0    # "br":Ljava/io/BufferedReader;
    .local v1, "br":Ljava/io/BufferedReader;
    :try_start_1
    invoke-virtual {v1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v8

    .line 256
    .local v8, "line":Ljava/lang/String;
    :goto_1
    if-eqz v8, :cond_3

    .line 257
    const-string/jumbo v10, ":"

    invoke-virtual {v8, v10}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v5

    .line 258
    .local v5, "i":I
    const/4 v10, -0x1

    if-eq v5, v10, :cond_2

    .line 259
    const/4 v10, 0x0

    invoke-virtual {v8, v10, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v10

    add-int/lit8 v11, v5, 0x1

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v12

    invoke-virtual {v8, v11, v12}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v4, v10, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 261
    :cond_2
    invoke-virtual {v1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_7
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_6
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v8

    .line 262
    goto :goto_1

    .line 275
    .end local v5    # "i":I
    :cond_3
    if-eqz v1, :cond_0

    .line 276
    :try_start_2
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    .line 278
    :catch_0
    move-exception v7

    .line 279
    .local v7, "ioException":Ljava/io/IOException;
    sget-boolean v9, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    if-eqz v9, :cond_0

    .line 280
    const-string/jumbo v9, "MShopHttpHeaderHelper"

    invoke-virtual {v7}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 263
    .end local v1    # "br":Ljava/io/BufferedReader;
    .end local v3    # "fis":Ljava/io/FileInputStream;
    .end local v7    # "ioException":Ljava/io/IOException;
    .end local v8    # "line":Ljava/lang/String;
    .restart local v0    # "br":Ljava/io/BufferedReader;
    :catch_1
    move-exception v2

    .line 264
    .local v2, "e":Ljava/io/FileNotFoundException;
    :goto_2
    :try_start_3
    sget-boolean v10, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    if-eqz v10, :cond_4

    .line 265
    const-string/jumbo v10, "MShopHttpHeaderHelper"

    invoke-virtual {v2}, Ljava/io/FileNotFoundException;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 275
    :cond_4
    if-eqz v0, :cond_5

    .line 276
    :try_start_4
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    :cond_5
    :goto_3
    move-object v4, v9

    .line 282
    goto :goto_0

    .line 278
    :catch_2
    move-exception v7

    .line 279
    .restart local v7    # "ioException":Ljava/io/IOException;
    sget-boolean v10, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    if-eqz v10, :cond_5

    .line 280
    const-string/jumbo v10, "MShopHttpHeaderHelper"

    invoke-virtual {v7}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_3

    .line 268
    .end local v2    # "e":Ljava/io/FileNotFoundException;
    .end local v7    # "ioException":Ljava/io/IOException;
    :catch_3
    move-exception v2

    .line 269
    .local v2, "e":Ljava/io/IOException;
    :goto_4
    :try_start_5
    sget-boolean v10, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    if-eqz v10, :cond_6

    .line 270
    const-string/jumbo v10, "MShopHttpHeaderHelper"

    invoke-virtual {v2}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 275
    :cond_6
    if-eqz v0, :cond_7

    .line 276
    :try_start_6
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4

    :cond_7
    :goto_5
    move-object v4, v9

    .line 282
    goto/16 :goto_0

    .line 278
    :catch_4
    move-exception v7

    .line 279
    .restart local v7    # "ioException":Ljava/io/IOException;
    sget-boolean v10, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    if-eqz v10, :cond_7

    .line 280
    const-string/jumbo v10, "MShopHttpHeaderHelper"

    invoke-virtual {v7}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_5

    .line 274
    .end local v2    # "e":Ljava/io/IOException;
    .end local v7    # "ioException":Ljava/io/IOException;
    :catchall_0
    move-exception v9

    .line 275
    :goto_6
    if-eqz v0, :cond_8

    .line 276
    :try_start_7
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_5

    .line 282
    :cond_8
    :goto_7
    throw v9

    .line 278
    :catch_5
    move-exception v7

    .line 279
    .restart local v7    # "ioException":Ljava/io/IOException;
    sget-boolean v10, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    if-eqz v10, :cond_8

    .line 280
    const-string/jumbo v10, "MShopHttpHeaderHelper"

    invoke-virtual {v7}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_7

    .line 274
    .end local v0    # "br":Ljava/io/BufferedReader;
    .end local v7    # "ioException":Ljava/io/IOException;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    .restart local v3    # "fis":Ljava/io/FileInputStream;
    :catchall_1
    move-exception v9

    move-object v0, v1

    .end local v1    # "br":Ljava/io/BufferedReader;
    .restart local v0    # "br":Ljava/io/BufferedReader;
    goto :goto_6

    .line 268
    .end local v0    # "br":Ljava/io/BufferedReader;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    :catch_6
    move-exception v2

    move-object v0, v1

    .end local v1    # "br":Ljava/io/BufferedReader;
    .restart local v0    # "br":Ljava/io/BufferedReader;
    goto :goto_4

    .line 263
    .end local v0    # "br":Ljava/io/BufferedReader;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    :catch_7
    move-exception v2

    move-object v0, v1

    .end local v1    # "br":Ljava/io/BufferedReader;
    .restart local v0    # "br":Ljava/io/BufferedReader;
    goto :goto_2
.end method

.method private static writeHeader(Ljava/util/Map;Ljava/io/Writer;Ljava/lang/StringBuilder;)V
    .locals 8
    .param p1, "infWriter"    # Ljava/io/Writer;
    .param p2, "strBuilder"    # Ljava/lang/StringBuilder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;",
            "Ljava/io/Writer;",
            "Ljava/lang/StringBuilder;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 212
    .local p0, "header":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface {p0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    .line 213
    .local v2, "headerFields":Ljava/util/Set;, "Ljava/util/Set<Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;>;"
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 214
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    const/4 v6, 0x0

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 215
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 216
    const-string/jumbo v6, ": "

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 217
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 218
    .local v1, "fieldValueList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 219
    .local v5, "value":Ljava/lang/String;
    invoke-virtual {p2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 220
    const-string/jumbo v6, ","

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 222
    .end local v5    # "value":Ljava/lang/String;
    :cond_0
    invoke-virtual {p2}, Ljava/lang/StringBuilder;->length()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    const/16 v7, 0xa

    invoke-virtual {p2, v6, v7}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    .line 223
    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v6}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    goto :goto_0

    .line 225
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v1    # "fieldValueList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v4    # "i$":Ljava/util/Iterator;
    :cond_1
    return-void
.end method

.method private static writeHeaderField(Ljava/lang/StringBuilder;Ljava/io/Writer;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "buf"    # Ljava/lang/StringBuilder;
    .param p1, "writer"    # Ljava/io/Writer;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 228
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 229
    invoke-virtual {p0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 230
    const-string/jumbo v0, ": "

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 231
    invoke-virtual {p0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 232
    const/16 v0, 0xa

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 233
    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 234
    return-void
.end method

.method public static writeHeaderInf(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJ)Z
    .locals 8
    .param p0, "key"    # Ljava/lang/String;
    .param p2, "residencePriority"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;
    .param p3, "sendTimeMillis"    # J
    .param p5, "receiveTimeMillis"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;",
            "Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;",
            "JJ)Z"
        }
    .end annotation

    .prologue
    .line 75
    .local p1, "header":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    const/4 v7, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-wide v3, p3

    move-wide v5, p5

    invoke-static/range {v0 .. v7}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->writeHeaderInf(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJZ)Z

    move-result v0

    return v0
.end method

.method public static writeHeaderInf(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJZ)Z
    .locals 12
    .param p0, "key"    # Ljava/lang/String;
    .param p2, "residencePriority"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;
    .param p3, "sendTimeMillis"    # J
    .param p5, "receiveTimeMillis"    # J
    .param p7, "needCreateNewInfFile"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;",
            "Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;",
            "JJZ)Z"
        }
    .end annotation

    .prologue
    .line 98
    .local p1, "header":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    if-nez p1, :cond_1

    .line 99
    const/4 v1, 0x0

    .line 164
    :cond_0
    :goto_0
    return v1

    .line 101
    :cond_1
    const/4 v1, 0x1

    .line 102
    .local v1, "flagSuccess":Z
    const/4 v6, 0x0

    .line 103
    .local v6, "infWriter":Ljava/io/Writer;
    const/4 v2, 0x0

    .line 104
    .local v2, "headerSaved":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p7, :cond_2

    .line 105
    invoke-static {p0, p2}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->readHeaderInf(Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/util/Map;

    move-result-object v2

    .line 107
    :cond_2
    invoke-static {p0, p2}, Lcom/amazon/mShop/net/MShopDiskCache;->newInfFile(Ljava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/io/File;

    move-result-object v5

    .line 108
    .local v5, "infFile":Ljava/io/File;
    const/4 v3, 0x0

    .line 110
    .local v3, "inf":Ljava/io/FileOutputStream;
    if-eqz p7, :cond_3

    .line 111
    :try_start_0
    invoke-virtual {v5}, Ljava/io/File;->createNewFile()Z

    .line 115
    :cond_3
    new-instance v4, Ljava/io/FileOutputStream;

    invoke-direct {v4, v5}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_5
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 116
    .end local v3    # "inf":Ljava/io/FileOutputStream;
    .local v4, "inf":Ljava/io/FileOutputStream;
    :try_start_1
    new-instance v7, Ljava/io/BufferedWriter;

    new-instance v9, Ljava/io/OutputStreamWriter;

    const-string/jumbo v10, "UTF-8"

    invoke-direct {v9, v4, v10}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;Ljava/lang/String;)V

    invoke-direct {v7, v9}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_c
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_a
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_8
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 117
    .end local v6    # "infWriter":Ljava/io/Writer;
    .local v7, "infWriter":Ljava/io/Writer;
    :try_start_2
    new-instance v8, Ljava/lang/StringBuilder;

    const/16 v9, 0x80

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 118
    .local v8, "strBuilder":Ljava/lang/StringBuilder;
    invoke-static {p1, v7, v8}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->writeHeader(Ljava/util/Map;Ljava/io/Writer;Ljava/lang/StringBuilder;)V

    .line 120
    if-nez p7, :cond_4

    .line 122
    invoke-static {p1, v7, v2, v8}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->appendSavedHeader(Ljava/util/Map;Ljava/io/Writer;Ljava/util/Map;Ljava/lang/StringBuilder;)V

    .line 125
    :cond_4
    const-string/jumbo v9, "mshop-cache-sent-time"

    invoke-static/range {p3 .. p4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v10

    invoke-static {v8, v7, v9, v10}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->writeHeaderField(Ljava/lang/StringBuilder;Ljava/io/Writer;Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    const-string/jumbo v9, "mshop-cache-received-time"

    invoke-static/range {p5 .. p6}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v10

    invoke-static {v8, v7, v9, v10}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->writeHeaderField(Ljava/lang/StringBuilder;Ljava/io/Writer;Ljava/lang/String;Ljava/lang/String;)V

    .line 128
    invoke-virtual {v7}, Ljava/io/Writer;->flush()V
    :try_end_2
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_2} :catch_d
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_2 .. :try_end_2} :catch_b
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_9
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 147
    if-eqz v7, :cond_5

    .line 148
    :try_start_3
    invoke-virtual {v7}, Ljava/io/Writer;->close()V

    .line 150
    :cond_5
    if-eqz v4, :cond_6

    .line 151
    invoke-virtual {v4}, Ljava/io/FileOutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    .line 158
    :cond_6
    :goto_1
    if-nez v1, :cond_13

    .line 159
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v9

    if-eqz v9, :cond_13

    .line 160
    invoke-virtual {v5}, Ljava/io/File;->delete()Z

    move-object v3, v4

    .end local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v3    # "inf":Ljava/io/FileOutputStream;
    move-object v6, v7

    .end local v7    # "infWriter":Ljava/io/Writer;
    .restart local v6    # "infWriter":Ljava/io/Writer;
    goto :goto_0

    .line 153
    .end local v3    # "inf":Ljava/io/FileOutputStream;
    .end local v6    # "infWriter":Ljava/io/Writer;
    .restart local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v7    # "infWriter":Ljava/io/Writer;
    :catch_0
    move-exception v0

    .line 154
    .local v0, "e":Ljava/io/IOException;
    sget-boolean v9, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    if-eqz v9, :cond_6

    .line 155
    const-string/jumbo v9, "MShopHttpHeaderHelper"

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 129
    .end local v0    # "e":Ljava/io/IOException;
    .end local v4    # "inf":Ljava/io/FileOutputStream;
    .end local v7    # "infWriter":Ljava/io/Writer;
    .end local v8    # "strBuilder":Ljava/lang/StringBuilder;
    .restart local v3    # "inf":Ljava/io/FileOutputStream;
    .restart local v6    # "infWriter":Ljava/io/Writer;
    :catch_1
    move-exception v0

    .line 130
    .local v0, "e":Ljava/io/FileNotFoundException;
    :goto_2
    :try_start_4
    sget-boolean v9, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    if-eqz v9, :cond_7

    .line 131
    const-string/jumbo v9, "MShopHttpHeaderHelper"

    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 133
    :cond_7
    const/4 v1, 0x0

    .line 147
    if-eqz v6, :cond_8

    .line 148
    :try_start_5
    invoke-virtual {v6}, Ljava/io/Writer;->close()V

    .line 150
    :cond_8
    if-eqz v3, :cond_9

    .line 151
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_2

    .line 158
    .end local v0    # "e":Ljava/io/FileNotFoundException;
    :cond_9
    :goto_3
    if-nez v1, :cond_0

    .line 159
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v9

    if-eqz v9, :cond_0

    .line 160
    invoke-virtual {v5}, Ljava/io/File;->delete()Z

    goto/16 :goto_0

    .line 153
    .restart local v0    # "e":Ljava/io/FileNotFoundException;
    :catch_2
    move-exception v0

    .line 154
    .local v0, "e":Ljava/io/IOException;
    sget-boolean v9, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    if-eqz v9, :cond_9

    .line 155
    const-string/jumbo v9, "MShopHttpHeaderHelper"

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_3

    .line 134
    .end local v0    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v0

    .line 135
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    :goto_4
    :try_start_6
    sget-boolean v9, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    if-eqz v9, :cond_a

    .line 136
    const-string/jumbo v9, "MShopHttpHeaderHelper"

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 138
    :cond_a
    const/4 v1, 0x0

    .line 147
    if-eqz v6, :cond_b

    .line 148
    :try_start_7
    invoke-virtual {v6}, Ljava/io/Writer;->close()V

    .line 150
    :cond_b
    if-eqz v3, :cond_c

    .line 151
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_4

    .line 158
    .end local v0    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_c
    :goto_5
    if-nez v1, :cond_0

    .line 159
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v9

    if-eqz v9, :cond_0

    .line 160
    invoke-virtual {v5}, Ljava/io/File;->delete()Z

    goto/16 :goto_0

    .line 153
    .restart local v0    # "e":Ljava/io/UnsupportedEncodingException;
    :catch_4
    move-exception v0

    .line 154
    .local v0, "e":Ljava/io/IOException;
    sget-boolean v9, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    if-eqz v9, :cond_c

    .line 155
    const-string/jumbo v9, "MShopHttpHeaderHelper"

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_5

    .line 139
    .end local v0    # "e":Ljava/io/IOException;
    :catch_5
    move-exception v0

    .line 140
    .restart local v0    # "e":Ljava/io/IOException;
    :goto_6
    :try_start_8
    sget-boolean v9, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    if-eqz v9, :cond_d

    .line 141
    const-string/jumbo v9, "MShopHttpHeaderHelper"

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 143
    :cond_d
    const/4 v1, 0x0

    .line 147
    if-eqz v6, :cond_e

    .line 148
    :try_start_9
    invoke-virtual {v6}, Ljava/io/Writer;->close()V

    .line 150
    :cond_e
    if-eqz v3, :cond_f

    .line 151
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_6

    .line 158
    :cond_f
    :goto_7
    if-nez v1, :cond_0

    .line 159
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v9

    if-eqz v9, :cond_0

    .line 160
    invoke-virtual {v5}, Ljava/io/File;->delete()Z

    goto/16 :goto_0

    .line 153
    :catch_6
    move-exception v0

    .line 154
    sget-boolean v9, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    if-eqz v9, :cond_f

    .line 155
    const-string/jumbo v9, "MShopHttpHeaderHelper"

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_7

    .line 146
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v9

    .line 147
    :goto_8
    if-eqz v6, :cond_10

    .line 148
    :try_start_a
    invoke-virtual {v6}, Ljava/io/Writer;->close()V

    .line 150
    :cond_10
    if-eqz v3, :cond_11

    .line 151
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_7

    .line 158
    :cond_11
    :goto_9
    if-nez v1, :cond_12

    .line 159
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v10

    if-eqz v10, :cond_12

    .line 160
    invoke-virtual {v5}, Ljava/io/File;->delete()Z

    :cond_12
    throw v9

    .line 153
    :catch_7
    move-exception v0

    .line 154
    .restart local v0    # "e":Ljava/io/IOException;
    sget-boolean v10, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->DEBUG:Z

    if-eqz v10, :cond_11

    .line 155
    const-string/jumbo v10, "MShopHttpHeaderHelper"

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_9

    .line 146
    .end local v0    # "e":Ljava/io/IOException;
    .end local v3    # "inf":Ljava/io/FileOutputStream;
    .restart local v4    # "inf":Ljava/io/FileOutputStream;
    :catchall_1
    move-exception v9

    move-object v3, v4

    .end local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v3    # "inf":Ljava/io/FileOutputStream;
    goto :goto_8

    .end local v3    # "inf":Ljava/io/FileOutputStream;
    .end local v6    # "infWriter":Ljava/io/Writer;
    .restart local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v7    # "infWriter":Ljava/io/Writer;
    :catchall_2
    move-exception v9

    move-object v3, v4

    .end local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v3    # "inf":Ljava/io/FileOutputStream;
    move-object v6, v7

    .end local v7    # "infWriter":Ljava/io/Writer;
    .restart local v6    # "infWriter":Ljava/io/Writer;
    goto :goto_8

    .line 139
    .end local v3    # "inf":Ljava/io/FileOutputStream;
    .restart local v4    # "inf":Ljava/io/FileOutputStream;
    :catch_8
    move-exception v0

    move-object v3, v4

    .end local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v3    # "inf":Ljava/io/FileOutputStream;
    goto :goto_6

    .end local v3    # "inf":Ljava/io/FileOutputStream;
    .end local v6    # "infWriter":Ljava/io/Writer;
    .restart local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v7    # "infWriter":Ljava/io/Writer;
    :catch_9
    move-exception v0

    move-object v3, v4

    .end local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v3    # "inf":Ljava/io/FileOutputStream;
    move-object v6, v7

    .end local v7    # "infWriter":Ljava/io/Writer;
    .restart local v6    # "infWriter":Ljava/io/Writer;
    goto :goto_6

    .line 134
    .end local v3    # "inf":Ljava/io/FileOutputStream;
    .restart local v4    # "inf":Ljava/io/FileOutputStream;
    :catch_a
    move-exception v0

    move-object v3, v4

    .end local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v3    # "inf":Ljava/io/FileOutputStream;
    goto/16 :goto_4

    .end local v3    # "inf":Ljava/io/FileOutputStream;
    .end local v6    # "infWriter":Ljava/io/Writer;
    .restart local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v7    # "infWriter":Ljava/io/Writer;
    :catch_b
    move-exception v0

    move-object v3, v4

    .end local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v3    # "inf":Ljava/io/FileOutputStream;
    move-object v6, v7

    .end local v7    # "infWriter":Ljava/io/Writer;
    .restart local v6    # "infWriter":Ljava/io/Writer;
    goto/16 :goto_4

    .line 129
    .end local v3    # "inf":Ljava/io/FileOutputStream;
    .restart local v4    # "inf":Ljava/io/FileOutputStream;
    :catch_c
    move-exception v0

    move-object v3, v4

    .end local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v3    # "inf":Ljava/io/FileOutputStream;
    goto/16 :goto_2

    .end local v3    # "inf":Ljava/io/FileOutputStream;
    .end local v6    # "infWriter":Ljava/io/Writer;
    .restart local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v7    # "infWriter":Ljava/io/Writer;
    :catch_d
    move-exception v0

    move-object v3, v4

    .end local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v3    # "inf":Ljava/io/FileOutputStream;
    move-object v6, v7

    .end local v7    # "infWriter":Ljava/io/Writer;
    .restart local v6    # "infWriter":Ljava/io/Writer;
    goto/16 :goto_2

    .end local v3    # "inf":Ljava/io/FileOutputStream;
    .end local v6    # "infWriter":Ljava/io/Writer;
    .restart local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v7    # "infWriter":Ljava/io/Writer;
    .restart local v8    # "strBuilder":Ljava/lang/StringBuilder;
    :cond_13
    move-object v3, v4

    .end local v4    # "inf":Ljava/io/FileOutputStream;
    .restart local v3    # "inf":Ljava/io/FileOutputStream;
    move-object v6, v7

    .end local v7    # "infWriter":Ljava/io/Writer;
    .restart local v6    # "infWriter":Ljava/io/Writer;
    goto/16 :goto_0
.end method
