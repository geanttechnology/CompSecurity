.class public Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;
.super Ljava/lang/Object;
.source "QuotedPrintableCodec.java"

# interfaces
.implements Lcom/comcast/cim/commonscodecandroid/BinaryDecoder;
.implements Lcom/comcast/cim/commonscodecandroid/BinaryEncoder;
.implements Lcom/comcast/cim/commonscodecandroid/StringDecoder;
.implements Lcom/comcast/cim/commonscodecandroid/StringEncoder;


# static fields
.field private static final PRINTABLE_CHARS:Ljava/util/BitSet;


# instance fields
.field private final charset:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 72
    new-instance v1, Ljava/util/BitSet;

    const/16 v2, 0x100

    invoke-direct {v1, v2}, Ljava/util/BitSet;-><init>(I)V

    sput-object v1, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->PRINTABLE_CHARS:Ljava/util/BitSet;

    .line 82
    const/16 v0, 0x21

    .local v0, "i":I
    :goto_0
    const/16 v1, 0x3c

    if-gt v0, v1, :cond_0

    .line 83
    sget-object v1, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->PRINTABLE_CHARS:Ljava/util/BitSet;

    invoke-virtual {v1, v0}, Ljava/util/BitSet;->set(I)V

    .line 82
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 85
    :cond_0
    const/16 v0, 0x3e

    :goto_1
    const/16 v1, 0x7e

    if-gt v0, v1, :cond_1

    .line 86
    sget-object v1, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->PRINTABLE_CHARS:Ljava/util/BitSet;

    invoke-virtual {v1, v0}, Ljava/util/BitSet;->set(I)V

    .line 85
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 88
    :cond_1
    sget-object v1, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->PRINTABLE_CHARS:Ljava/util/BitSet;

    const/16 v2, 0x9

    invoke-virtual {v1, v2}, Ljava/util/BitSet;->set(I)V

    .line 89
    sget-object v1, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->PRINTABLE_CHARS:Ljava/util/BitSet;

    const/16 v2, 0x20

    invoke-virtual {v1, v2}, Ljava/util/BitSet;->set(I)V

    .line 90
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 96
    const-string v0, "UTF-8"

    invoke-direct {p0, v0}, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;-><init>(Ljava/lang/String;)V

    .line 97
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "charset"    # Ljava/lang/String;

    .prologue
    .line 106
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 107
    iput-object p1, p0, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->charset:Ljava/lang/String;

    .line 108
    return-void
.end method

.method private static final encodeQuotedPrintable(ILjava/io/ByteArrayOutputStream;)V
    .locals 4
    .param p0, "b"    # I
    .param p1, "buffer"    # Ljava/io/ByteArrayOutputStream;

    .prologue
    const/16 v3, 0x10

    .line 119
    const/16 v2, 0x3d

    invoke-virtual {p1, v2}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 120
    shr-int/lit8 v2, p0, 0x4

    and-int/lit8 v2, v2, 0xf

    invoke-static {v2, v3}, Ljava/lang/Character;->forDigit(II)C

    move-result v2

    invoke-static {v2}, Ljava/lang/Character;->toUpperCase(C)C

    move-result v0

    .line 121
    .local v0, "hex1":C
    and-int/lit8 v2, p0, 0xf

    invoke-static {v2, v3}, Ljava/lang/Character;->forDigit(II)C

    move-result v2

    invoke-static {v2}, Ljava/lang/Character;->toUpperCase(C)C

    move-result v1

    .line 122
    .local v1, "hex2":C
    invoke-virtual {p1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 123
    invoke-virtual {p1, v1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 124
    return-void
.end method

.method public static final encodeQuotedPrintable(Ljava/util/BitSet;[B)[B
    .locals 4
    .param p0, "printable"    # Ljava/util/BitSet;
    .param p1, "bytes"    # [B

    .prologue
    .line 141
    if-nez p1, :cond_0

    .line 142
    const/4 v3, 0x0

    .line 159
    :goto_0
    return-object v3

    .line 144
    :cond_0
    if-nez p0, :cond_1

    .line 145
    sget-object p0, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->PRINTABLE_CHARS:Ljava/util/BitSet;

    .line 147
    :cond_1
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 148
    .local v1, "buffer":Ljava/io/ByteArrayOutputStream;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    array-length v3, p1

    if-ge v2, v3, :cond_4

    .line 149
    aget-byte v0, p1, v2

    .line 150
    .local v0, "b":I
    if-gez v0, :cond_2

    .line 151
    add-int/lit16 v0, v0, 0x100

    .line 153
    :cond_2
    invoke-virtual {p0, v0}, Ljava/util/BitSet;->get(I)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 154
    invoke-virtual {v1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 148
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 156
    :cond_3
    invoke-static {v0, v1}, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->encodeQuotedPrintable(ILjava/io/ByteArrayOutputStream;)V

    goto :goto_2

    .line 159
    .end local v0    # "b":I
    :cond_4
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v3

    goto :goto_0
.end method


# virtual methods
.method public encode(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .param p1, "pObject"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/commonscodecandroid/EncoderException;
        }
    .end annotation

    .prologue
    .line 317
    if-nez p1, :cond_0

    .line 318
    const/4 v0, 0x0

    .line 322
    .end local p1    # "pObject":Ljava/lang/Object;
    :goto_0
    return-object v0

    .line 319
    .restart local p1    # "pObject":Ljava/lang/Object;
    :cond_0
    instance-of v0, p1, [B

    if-eqz v0, :cond_1

    .line 320
    check-cast p1, [B

    .end local p1    # "pObject":Ljava/lang/Object;
    check-cast p1, [B

    invoke-virtual {p0, p1}, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->encode([B)[B

    move-result-object v0

    goto :goto_0

    .line 321
    .restart local p1    # "pObject":Ljava/lang/Object;
    :cond_1
    instance-of v0, p1, Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 322
    check-cast p1, Ljava/lang/String;

    .end local p1    # "pObject":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 324
    .restart local p1    # "pObject":Ljava/lang/Object;
    :cond_2
    new-instance v0, Lcom/comcast/cim/commonscodecandroid/EncoderException;

    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    const-string v2, "Objects of type "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, " cannot be quoted-printable encoded"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/commonscodecandroid/EncoderException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public encode(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "pString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/commonscodecandroid/EncoderException;
        }
    .end annotation

    .prologue
    .line 252
    if-nez p1, :cond_0

    .line 253
    const/4 v1, 0x0

    .line 256
    :goto_0
    return-object v1

    :cond_0
    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->getDefaultCharset()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, p1, v1}, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 257
    :catch_0
    move-exception v0

    .line 258
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v1, Lcom/comcast/cim/commonscodecandroid/EncoderException;

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lcom/comcast/cim/commonscodecandroid/EncoderException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "pString"    # Ljava/lang/String;
    .param p2, "charset"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 382
    if-nez p1, :cond_0

    .line 383
    const/4 v0, 0x0

    .line 385
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1, p2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->encode([B)[B

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/cim/commonscodecandroid/binary/StringUtils;->newStringUsAscii([B)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public encode([B)[B
    .locals 1
    .param p1, "bytes"    # [B

    .prologue
    .line 212
    sget-object v0, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->PRINTABLE_CHARS:Ljava/util/BitSet;

    invoke-static {v0, p1}, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->encodeQuotedPrintable(Ljava/util/BitSet;[B)[B

    move-result-object v0

    return-object v0
.end method

.method public getDefaultCharset()Ljava/lang/String;
    .locals 1

    .prologue
    .line 361
    iget-object v0, p0, Lcom/comcast/cim/commonscodecandroid/net/QuotedPrintableCodec;->charset:Ljava/lang/String;

    return-object v0
.end method
