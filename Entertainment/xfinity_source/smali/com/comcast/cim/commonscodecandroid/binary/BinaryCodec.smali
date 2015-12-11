.class public Lcom/comcast/cim/commonscodecandroid/binary/BinaryCodec;
.super Ljava/lang/Object;
.source "BinaryCodec.java"

# interfaces
.implements Lcom/comcast/cim/commonscodecandroid/BinaryDecoder;
.implements Lcom/comcast/cim/commonscodecandroid/BinaryEncoder;


# static fields
.field private static final BITS:[I

.field private static final EMPTY_BYTE_ARRAY:[B

.field private static final EMPTY_CHAR_ARRAY:[C


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 41
    new-array v0, v1, [C

    sput-object v0, Lcom/comcast/cim/commonscodecandroid/binary/BinaryCodec;->EMPTY_CHAR_ARRAY:[C

    .line 44
    new-array v0, v1, [B

    sput-object v0, Lcom/comcast/cim/commonscodecandroid/binary/BinaryCodec;->EMPTY_BYTE_ARRAY:[B

    .line 70
    const/16 v0, 0x8

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/comcast/cim/commonscodecandroid/binary/BinaryCodec;->BITS:[I

    return-void

    nop

    :array_0
    .array-data 4
        0x1
        0x2
        0x4
        0x8
        0x10
        0x20
        0x40
        0x80
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static isEmpty([B)Z
    .locals 1
    .param p0, "array"    # [B

    .prologue
    .line 221
    if-eqz p0, :cond_0

    array-length v0, p0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static toAsciiChars([B)[C
    .locals 6
    .param p0, "raw"    # [B

    .prologue
    .line 264
    invoke-static {p0}, Lcom/comcast/cim/commonscodecandroid/binary/BinaryCodec;->isEmpty([B)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 265
    sget-object v3, Lcom/comcast/cim/commonscodecandroid/binary/BinaryCodec;->EMPTY_CHAR_ARRAY:[C

    .line 282
    :cond_0
    return-object v3

    .line 268
    :cond_1
    array-length v4, p0

    shl-int/lit8 v4, v4, 0x3

    new-array v3, v4, [C

    .line 273
    .local v3, "l_ascii":[C
    const/4 v1, 0x0

    .local v1, "ii":I
    array-length v4, v3

    add-int/lit8 v2, v4, -0x1

    .local v2, "jj":I
    :goto_0
    array-length v4, p0

    if-ge v1, v4, :cond_0

    .line 274
    const/4 v0, 0x0

    .local v0, "bits":I
    :goto_1
    sget-object v4, Lcom/comcast/cim/commonscodecandroid/binary/BinaryCodec;->BITS:[I

    array-length v4, v4

    if-ge v0, v4, :cond_3

    .line 275
    aget-byte v4, p0, v1

    sget-object v5, Lcom/comcast/cim/commonscodecandroid/binary/BinaryCodec;->BITS:[I

    aget v5, v5, v0

    and-int/2addr v4, v5

    if-nez v4, :cond_2

    .line 276
    sub-int v4, v2, v0

    const/16 v5, 0x30

    aput-char v5, v3, v4

    .line 274
    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 278
    :cond_2
    sub-int v4, v2, v0

    const/16 v5, 0x31

    aput-char v5, v3, v4

    goto :goto_2

    .line 273
    :cond_3
    add-int/lit8 v1, v1, 0x1

    add-int/lit8 v2, v2, -0x8

    goto :goto_0
.end method


# virtual methods
.method public encode(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "raw"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/commonscodecandroid/EncoderException;
        }
    .end annotation

    .prologue
    .line 95
    instance-of v0, p1, [B

    if-nez v0, :cond_0

    .line 96
    new-instance v0, Lcom/comcast/cim/commonscodecandroid/EncoderException;

    const-string v1, "argument not a byte array"

    invoke-direct {v0, v1}, Lcom/comcast/cim/commonscodecandroid/EncoderException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 98
    :cond_0
    check-cast p1, [B

    .end local p1    # "raw":Ljava/lang/Object;
    check-cast p1, [B

    invoke-static {p1}, Lcom/comcast/cim/commonscodecandroid/binary/BinaryCodec;->toAsciiChars([B)[C

    move-result-object v0

    return-object v0
.end method
