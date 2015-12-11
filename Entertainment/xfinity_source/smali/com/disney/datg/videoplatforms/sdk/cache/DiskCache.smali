.class public abstract Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache;
.super Lcom/disney/datg/videoplatforms/sdk/cache/Cache;
.source "DiskCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/disney/datg/videoplatforms/sdk/cache/Cache",
        "<TK;TV;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache;, "Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache<TK;TV;>;"
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/cache/Cache;-><init>()V

    return-void
.end method

.method private static bytesToHexString([B)Ljava/lang/String;
    .locals 5
    .param p0, "bytes"    # [B

    .prologue
    .line 135
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 136
    .local v2, "sb":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v3, p0

    if-ge v1, v3, :cond_1

    .line 137
    aget-byte v3, p0, v1

    and-int/lit16 v3, v3, 0xff

    invoke-static {v3}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    .line 138
    .local v0, "hex":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 139
    const/16 v3, 0x30

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 141
    :cond_0
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 136
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 143
    .end local v0    # "hex":Ljava/lang/String;
    :cond_1
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method public static getDiskCacheDir(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "uniqueName"    # Ljava/lang/String;

    .prologue
    .line 203
    invoke-virtual {p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v0

    .line 209
    .local v0, "cachePath":Ljava/lang/String;
    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    return-object v1
.end method

.method public static getUsableSpace(Ljava/io/File;)J
    .locals 2
    .param p0, "path"    # Ljava/io/File;

    .prologue
    .line 219
    invoke-virtual {p0}, Ljava/io/File;->getUsableSpace()J

    move-result-wide v0

    return-wide v0
.end method

.method private static hashKeyForDisk(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "key"    # Ljava/lang/String;

    .prologue
    .line 123
    :try_start_0
    const-string v3, "MD5"

    invoke-static {v3}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v2

    .line 124
    .local v2, "mDigest":Ljava/security/MessageDigest;
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/security/MessageDigest;->update([B)V

    .line 125
    invoke-virtual {v2}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v3

    invoke-static {v3}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache;->bytesToHexString([B)Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 130
    .end local v2    # "mDigest":Ljava/security/MessageDigest;
    .local v0, "cacheKey":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 126
    .end local v0    # "cacheKey":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 127
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    invoke-static {v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    .line 128
    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "cacheKey":Ljava/lang/String;
    goto :goto_0
.end method


# virtual methods
.method public get(Ljava/lang/Object;)Lcom/disney/datg/videoplatforms/sdk/cache/Data;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)",
            "Lcom/disney/datg/videoplatforms/sdk/cache/Data",
            "<TK;TV;>;"
        }
    .end annotation

    .prologue
    .line 37
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache;, "Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache;->readFromFile(Ljava/lang/Object;)Lcom/disney/datg/videoplatforms/sdk/cache/Data;
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 42
    :goto_0
    return-object v1

    .line 38
    :catch_0
    move-exception v0

    .line 39
    .local v0, "e":Ljava/io/FileNotFoundException;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    .line 40
    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->printStackTrace()V

    .line 42
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public processKey(Ljava/lang/Object;)Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 110
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache;, "Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    instance-of v0, p1, Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 111
    check-cast p1, Ljava/lang/String;

    .end local p1    # "key":Ljava/lang/Object;, "TK;"
    invoke-static {p1}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache;->hashKeyForDisk(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 113
    :goto_0
    return-object v0

    .restart local p1    # "key":Ljava/lang/Object;, "TK;"
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public put(Ljava/lang/Object;Ljava/lang/Object;I)V
    .locals 1
    .param p3, "ttl"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;I)V"
        }
    .end annotation

    .prologue
    .line 61
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache;, "Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/lang/Object;, "TV;"
    :try_start_0
    invoke-virtual {p0, p1, p2, p3}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskCache;->writeToFile(Ljava/lang/Object;Ljava/lang/Object;I)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 69
    :goto_0
    return-void

    .line 62
    :catch_0
    move-exception v0

    .line 63
    .local v0, "e":Ljava/io/FileNotFoundException;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    .line 64
    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 65
    .end local v0    # "e":Ljava/io/FileNotFoundException;
    :catch_1
    move-exception v0

    .line 66
    .local v0, "e":Ljava/io/IOException;
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->logException(Ljava/lang/Exception;)V

    .line 67
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method public abstract readFromFile(Ljava/lang/Object;)Lcom/disney/datg/videoplatforms/sdk/cache/Data;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)",
            "Lcom/disney/datg/videoplatforms/sdk/cache/Data",
            "<TK;TV;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation
.end method

.method public abstract writeToFile(Ljava/lang/Object;Ljava/lang/Object;I)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;I)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/io/FileNotFoundException;
        }
    .end annotation
.end method
