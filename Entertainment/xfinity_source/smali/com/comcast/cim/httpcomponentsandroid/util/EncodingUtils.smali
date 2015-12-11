.class public final Lcom/comcast/cim/httpcomponentsandroid/util/EncodingUtils;
.super Ljava/lang/Object;
.source "EncodingUtils.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 176
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 177
    return-void
.end method

.method public static getAsciiBytes(Ljava/lang/String;)[B
    .locals 3
    .param p0, "data"    # Ljava/lang/String;

    .prologue
    .line 124
    if-nez p0, :cond_0

    .line 125
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Parameter may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 129
    :cond_0
    :try_start_0
    const-string v1, "US-ASCII"

    invoke-virtual {p0, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    .line 130
    :catch_0
    move-exception v0

    .line 131
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v1, Ljava/lang/Error;

    const-string v2, "HttpClient requires ASCII support"

    invoke-direct {v1, v2}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public static getAsciiString([B)Ljava/lang/String;
    .locals 2
    .param p0, "data"    # [B

    .prologue
    .line 167
    if-nez p0, :cond_0

    .line 168
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Parameter may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 170
    :cond_0
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/EncodingUtils;->getAsciiString([BII)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getAsciiString([BII)Ljava/lang/String;
    .locals 3
    .param p0, "data"    # [B
    .param p1, "offset"    # I
    .param p2, "length"    # I

    .prologue
    .line 147
    if-nez p0, :cond_0

    .line 148
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Parameter may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 152
    :cond_0
    :try_start_0
    new-instance v1, Ljava/lang/String;

    const-string v2, "US-ASCII"

    invoke-direct {v1, p0, p1, p2, v2}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 153
    :catch_0
    move-exception v0

    .line 154
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v1, Ljava/lang/Error;

    const-string v2, "HttpClient requires ASCII support"

    invoke-direct {v1, v2}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public static getBytes(Ljava/lang/String;Ljava/lang/String;)[B
    .locals 3
    .param p0, "data"    # Ljava/lang/String;
    .param p1, "charset"    # Ljava/lang/String;

    .prologue
    .line 101
    if-nez p0, :cond_0

    .line 102
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "data may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 105
    :cond_0
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_2

    .line 106
    :cond_1
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "charset may not be null or empty"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 110
    :cond_2
    :try_start_0
    invoke-virtual {p0, p1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 112
    :goto_0
    return-object v1

    .line 111
    :catch_0
    move-exception v0

    .line 112
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    goto :goto_0
.end method
