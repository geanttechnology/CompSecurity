.class public Lcom/comcast/cim/commonscodecandroid/binary/Hex;
.super Ljava/lang/Object;
.source "Hex.java"

# interfaces
.implements Lcom/comcast/cim/commonscodecandroid/BinaryDecoder;
.implements Lcom/comcast/cim/commonscodecandroid/BinaryEncoder;


# static fields
.field private static final DIGITS_LOWER:[C

.field private static final DIGITS_UPPER:[C


# instance fields
.field private final charsetName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/16 v1, 0x10

    .line 46
    new-array v0, v1, [C

    fill-array-data v0, :array_0

    sput-object v0, Lcom/comcast/cim/commonscodecandroid/binary/Hex;->DIGITS_LOWER:[C

    .line 51
    new-array v0, v1, [C

    fill-array-data v0, :array_1

    sput-object v0, Lcom/comcast/cim/commonscodecandroid/binary/Hex;->DIGITS_UPPER:[C

    return-void

    .line 46
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

    .line 51
    :array_1
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
        0x41s
        0x42s
        0x43s
        0x44s
        0x45s
        0x46s
    .end array-data
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 175
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 177
    const-string v0, "UTF-8"

    iput-object v0, p0, Lcom/comcast/cim/commonscodecandroid/binary/Hex;->charsetName:Ljava/lang/String;

    .line 178
    return-void
.end method

.method public static encodeHex([B)[C
    .locals 1
    .param p0, "data"    # [B

    .prologue
    .line 96
    const/4 v0, 0x1

    invoke-static {p0, v0}, Lcom/comcast/cim/commonscodecandroid/binary/Hex;->encodeHex([BZ)[C

    move-result-object v0

    return-object v0
.end method

.method public static encodeHex([BZ)[C
    .locals 1
    .param p0, "data"    # [B
    .param p1, "toLowerCase"    # Z

    .prologue
    .line 112
    if-eqz p1, :cond_0

    sget-object v0, Lcom/comcast/cim/commonscodecandroid/binary/Hex;->DIGITS_LOWER:[C

    :goto_0
    invoke-static {p0, v0}, Lcom/comcast/cim/commonscodecandroid/binary/Hex;->encodeHex([B[C)[C

    move-result-object v0

    return-object v0

    :cond_0
    sget-object v0, Lcom/comcast/cim/commonscodecandroid/binary/Hex;->DIGITS_UPPER:[C

    goto :goto_0
.end method

.method protected static encodeHex([B[C)[C
    .locals 6
    .param p0, "data"    # [B
    .param p1, "toDigits"    # [C

    .prologue
    .line 128
    array-length v3, p0

    .line 129
    .local v3, "l":I
    shl-int/lit8 v5, v3, 0x1

    new-array v4, v5, [C

    .line 131
    .local v4, "out":[C
    const/4 v0, 0x0

    .local v0, "i":I
    const/4 v1, 0x0

    .local v1, "j":I
    move v2, v1

    .end local v1    # "j":I
    .local v2, "j":I
    :goto_0
    if-ge v0, v3, :cond_0

    .line 132
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "j":I
    .restart local v1    # "j":I
    aget-byte v5, p0, v0

    and-int/lit16 v5, v5, 0xf0

    ushr-int/lit8 v5, v5, 0x4

    aget-char v5, p1, v5

    aput-char v5, v4, v2

    .line 133
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "j":I
    .restart local v2    # "j":I
    aget-byte v5, p0, v0

    and-int/lit8 v5, v5, 0xf

    aget-char v5, p1, v5

    aput-char v5, v4, v1

    .line 131
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 135
    :cond_0
    return-object v4
.end method


# virtual methods
.method public encode(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .param p1, "object"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/commonscodecandroid/EncoderException;
        }
    .end annotation

    .prologue
    .line 272
    :try_start_0
    instance-of v2, p1, Ljava/lang/String;

    if-eqz v2, :cond_0

    check-cast p1, Ljava/lang/String;

    .end local p1    # "object":Ljava/lang/Object;
    invoke-virtual {p0}, Lcom/comcast/cim/commonscodecandroid/binary/Hex;->getCharsetName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    .line 273
    .local v0, "byteArray":[B
    :goto_0
    invoke-static {v0}, Lcom/comcast/cim/commonscodecandroid/binary/Hex;->encodeHex([B)[C

    move-result-object v2

    return-object v2

    .line 272
    .end local v0    # "byteArray":[B
    .restart local p1    # "object":Ljava/lang/Object;
    :cond_0
    check-cast p1, [B

    .end local p1    # "object":Ljava/lang/Object;
    check-cast p1, [B
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_1

    move-object v0, p1

    goto :goto_0

    .line 274
    :catch_0
    move-exception v1

    .line 275
    .local v1, "e":Ljava/lang/ClassCastException;
    new-instance v2, Lcom/comcast/cim/commonscodecandroid/EncoderException;

    invoke-virtual {v1}, Ljava/lang/ClassCastException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v1}, Lcom/comcast/cim/commonscodecandroid/EncoderException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 276
    .end local v1    # "e":Ljava/lang/ClassCastException;
    :catch_1
    move-exception v1

    .line 277
    .local v1, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Lcom/comcast/cim/commonscodecandroid/EncoderException;

    invoke-virtual {v1}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v1}, Lcom/comcast/cim/commonscodecandroid/EncoderException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method

.method public getCharsetName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 288
    iget-object v0, p0, Lcom/comcast/cim/commonscodecandroid/binary/Hex;->charsetName:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 297
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, "[charsetName="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/commonscodecandroid/binary/Hex;->charsetName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
