.class public Lcom/comcast/cim/commonscodecandroid/net/URLCodec;
.super Ljava/lang/Object;
.source "URLCodec.java"

# interfaces
.implements Lcom/comcast/cim/commonscodecandroid/BinaryDecoder;
.implements Lcom/comcast/cim/commonscodecandroid/BinaryEncoder;
.implements Lcom/comcast/cim/commonscodecandroid/StringDecoder;
.implements Lcom/comcast/cim/commonscodecandroid/StringEncoder;


# static fields
.field protected static ESCAPE_CHAR:B

.field protected static final WWW_FORM_URL:Ljava/util/BitSet;


# instance fields
.field protected charset:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 69
    const/16 v1, 0x25

    sput-byte v1, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->ESCAPE_CHAR:B

    .line 73
    new-instance v1, Ljava/util/BitSet;

    const/16 v2, 0x100

    invoke-direct {v1, v2}, Ljava/util/BitSet;-><init>(I)V

    sput-object v1, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->WWW_FORM_URL:Ljava/util/BitSet;

    .line 78
    const/16 v0, 0x61

    .local v0, "i":I
    :goto_0
    const/16 v1, 0x7a

    if-gt v0, v1, :cond_0

    .line 79
    sget-object v1, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->WWW_FORM_URL:Ljava/util/BitSet;

    invoke-virtual {v1, v0}, Ljava/util/BitSet;->set(I)V

    .line 78
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 81
    :cond_0
    const/16 v0, 0x41

    :goto_1
    const/16 v1, 0x5a

    if-gt v0, v1, :cond_1

    .line 82
    sget-object v1, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->WWW_FORM_URL:Ljava/util/BitSet;

    invoke-virtual {v1, v0}, Ljava/util/BitSet;->set(I)V

    .line 81
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 85
    :cond_1
    const/16 v0, 0x30

    :goto_2
    const/16 v1, 0x39

    if-gt v0, v1, :cond_2

    .line 86
    sget-object v1, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->WWW_FORM_URL:Ljava/util/BitSet;

    invoke-virtual {v1, v0}, Ljava/util/BitSet;->set(I)V

    .line 85
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 89
    :cond_2
    sget-object v1, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->WWW_FORM_URL:Ljava/util/BitSet;

    const/16 v2, 0x2d

    invoke-virtual {v1, v2}, Ljava/util/BitSet;->set(I)V

    .line 90
    sget-object v1, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->WWW_FORM_URL:Ljava/util/BitSet;

    const/16 v2, 0x5f

    invoke-virtual {v1, v2}, Ljava/util/BitSet;->set(I)V

    .line 91
    sget-object v1, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->WWW_FORM_URL:Ljava/util/BitSet;

    const/16 v2, 0x2e

    invoke-virtual {v1, v2}, Ljava/util/BitSet;->set(I)V

    .line 92
    sget-object v1, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->WWW_FORM_URL:Ljava/util/BitSet;

    const/16 v2, 0x2a

    invoke-virtual {v1, v2}, Ljava/util/BitSet;->set(I)V

    .line 94
    sget-object v1, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->WWW_FORM_URL:Ljava/util/BitSet;

    const/16 v2, 0x20

    invoke-virtual {v1, v2}, Ljava/util/BitSet;->set(I)V

    .line 95
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 102
    const-string v0, "UTF-8"

    invoke-direct {p0, v0}, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;-><init>(Ljava/lang/String;)V

    .line 103
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "charset"    # Ljava/lang/String;

    .prologue
    .line 111
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 112
    iput-object p1, p0, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->charset:Ljava/lang/String;

    .line 113
    return-void
.end method

.method public static final encodeUrl(Ljava/util/BitSet;[B)[B
    .locals 7
    .param p0, "urlsafe"    # Ljava/util/BitSet;
    .param p1, "bytes"    # [B

    .prologue
    const/16 v6, 0x10

    .line 125
    if-nez p1, :cond_0

    .line 126
    const/4 v5, 0x0

    .line 151
    :goto_0
    return-object v5

    .line 128
    :cond_0
    if-nez p0, :cond_1

    .line 129
    sget-object p0, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->WWW_FORM_URL:Ljava/util/BitSet;

    .line 132
    :cond_1
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 133
    .local v1, "buffer":Ljava/io/ByteArrayOutputStream;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    array-length v5, p1

    if-ge v4, v5, :cond_5

    .line 134
    aget-byte v0, p1, v4

    .line 135
    .local v0, "b":I
    if-gez v0, :cond_2

    .line 136
    add-int/lit16 v0, v0, 0x100

    .line 138
    :cond_2
    invoke-virtual {p0, v0}, Ljava/util/BitSet;->get(I)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 139
    const/16 v5, 0x20

    if-ne v0, v5, :cond_3

    .line 140
    const/16 v0, 0x2b

    .line 142
    :cond_3
    invoke-virtual {v1, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 133
    :goto_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 144
    :cond_4
    sget-byte v5, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->ESCAPE_CHAR:B

    invoke-virtual {v1, v5}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 145
    shr-int/lit8 v5, v0, 0x4

    and-int/lit8 v5, v5, 0xf

    invoke-static {v5, v6}, Ljava/lang/Character;->forDigit(II)C

    move-result v5

    invoke-static {v5}, Ljava/lang/Character;->toUpperCase(C)C

    move-result v2

    .line 146
    .local v2, "hex1":C
    and-int/lit8 v5, v0, 0xf

    invoke-static {v5, v6}, Ljava/lang/Character;->forDigit(II)C

    move-result v5

    invoke-static {v5}, Ljava/lang/Character;->toUpperCase(C)C

    move-result v3

    .line 147
    .local v3, "hex2":C
    invoke-virtual {v1, v2}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 148
    invoke-virtual {v1, v3}, Ljava/io/ByteArrayOutputStream;->write(I)V

    goto :goto_2

    .line 151
    .end local v0    # "b":I
    .end local v2    # "hex1":C
    .end local v3    # "hex2":C
    :cond_5
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v5

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
    .line 304
    if-nez p1, :cond_0

    .line 305
    const/4 v0, 0x0

    .line 309
    .end local p1    # "pObject":Ljava/lang/Object;
    :goto_0
    return-object v0

    .line 306
    .restart local p1    # "pObject":Ljava/lang/Object;
    :cond_0
    instance-of v0, p1, [B

    if-eqz v0, :cond_1

    .line 307
    check-cast p1, [B

    .end local p1    # "pObject":Ljava/lang/Object;
    check-cast p1, [B

    invoke-virtual {p0, p1}, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->encode([B)[B

    move-result-object v0

    goto :goto_0

    .line 308
    .restart local p1    # "pObject":Ljava/lang/Object;
    :cond_1
    instance-of v0, p1, Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 309
    check-cast p1, Ljava/lang/String;

    .end local p1    # "pObject":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 311
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

    const-string v2, " cannot be URL encoded"

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
    .line 241
    if-nez p1, :cond_0

    .line 242
    const/4 v1, 0x0

    .line 245
    :goto_0
    return-object v1

    :cond_0
    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->getDefaultCharset()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, p1, v1}, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 246
    :catch_0
    move-exception v0

    .line 247
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
    .line 224
    if-nez p1, :cond_0

    .line 225
    const/4 v0, 0x0

    .line 227
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1, p2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->encode([B)[B

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/cim/commonscodecandroid/binary/StringUtils;->newStringUsAscii([B)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public encode([B)[B
    .locals 1
    .param p1, "bytes"    # [B

    .prologue
    .line 195
    sget-object v0, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->WWW_FORM_URL:Ljava/util/BitSet;

    invoke-static {v0, p1}, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->encodeUrl(Ljava/util/BitSet;[B)[B

    move-result-object v0

    return-object v0
.end method

.method public getDefaultCharset()Ljava/lang/String;
    .locals 1

    .prologue
    .line 358
    iget-object v0, p0, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->charset:Ljava/lang/String;

    return-object v0
.end method

.method public getEncoding()Ljava/lang/String;
    .locals 1

    .prologue
    .line 349
    iget-object v0, p0, Lcom/comcast/cim/commonscodecandroid/net/URLCodec;->charset:Ljava/lang/String;

    return-object v0
.end method
