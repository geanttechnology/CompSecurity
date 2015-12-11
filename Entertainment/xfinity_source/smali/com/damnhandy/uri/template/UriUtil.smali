.class public final Lcom/damnhandy/uri/template/UriUtil;
.super Ljava/lang/Object;
.source "UriUtil.java"


# static fields
.field private static final FRAGMENT_ALLOWED_CHARS:Ljava/util/BitSet;

.field private static final GENERAL_ALLOWED_CHARS:Ljava/util/BitSet;

.field private static final RESERVED_ALLOWED_CHARS:Ljava/util/BitSet;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    .line 20
    new-instance v7, Ljava/util/BitSet;

    invoke-direct {v7}, Ljava/util/BitSet;-><init>()V

    sput-object v7, Lcom/damnhandy/uri/template/UriUtil;->GENERAL_ALLOWED_CHARS:Ljava/util/BitSet;

    .line 22
    new-instance v7, Ljava/util/BitSet;

    invoke-direct {v7}, Ljava/util/BitSet;-><init>()V

    sput-object v7, Lcom/damnhandy/uri/template/UriUtil;->FRAGMENT_ALLOWED_CHARS:Ljava/util/BitSet;

    .line 24
    new-instance v7, Ljava/util/BitSet;

    invoke-direct {v7}, Ljava/util/BitSet;-><init>()V

    sput-object v7, Lcom/damnhandy/uri/template/UriUtil;->RESERVED_ALLOWED_CHARS:Ljava/util/BitSet;

    .line 27
    const-string v0, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

    .line 28
    .local v0, "alpha":Ljava/lang/String;
    const-string v1, "0123456789"

    .line 35
    .local v1, "digit":Ljava/lang/String;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "-._~"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 42
    .local v6, "unreserved":Ljava/lang/String;
    const-string v3, ":/?#[]@"

    .line 49
    .local v3, "gendelims":Ljava/lang/String;
    const-string v5, "!$&\'()*+,;="

    .line 56
    .local v5, "subdelims":Ljava/lang/String;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 69
    .local v4, "reserved":Ljava/lang/String;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ":@/?"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 71
    .local v2, "fragment":Ljava/lang/String;
    sget-object v7, Lcom/damnhandy/uri/template/UriUtil;->GENERAL_ALLOWED_CHARS:Ljava/util/BitSet;

    invoke-static {v7, v6}, Lcom/damnhandy/uri/template/UriUtil;->add(Ljava/util/BitSet;Ljava/lang/String;)V

    .line 72
    sget-object v7, Lcom/damnhandy/uri/template/UriUtil;->FRAGMENT_ALLOWED_CHARS:Ljava/util/BitSet;

    invoke-static {v7, v2}, Lcom/damnhandy/uri/template/UriUtil;->add(Ljava/util/BitSet;Ljava/lang/String;)V

    .line 77
    sget-object v7, Lcom/damnhandy/uri/template/UriUtil;->RESERVED_ALLOWED_CHARS:Ljava/util/BitSet;

    invoke-static {v7, v6}, Lcom/damnhandy/uri/template/UriUtil;->add(Ljava/util/BitSet;Ljava/lang/String;)V

    .line 78
    sget-object v7, Lcom/damnhandy/uri/template/UriUtil;->RESERVED_ALLOWED_CHARS:Ljava/util/BitSet;

    invoke-static {v7, v4}, Lcom/damnhandy/uri/template/UriUtil;->add(Ljava/util/BitSet;Ljava/lang/String;)V

    .line 79
    return-void
.end method

.method private static add(Ljava/util/BitSet;Ljava/lang/String;)V
    .locals 6
    .param p0, "destination"    # Ljava/util/BitSet;
    .param p1, "toAdd"    # Ljava/lang/String;

    .prologue
    .line 83
    invoke-virtual {p1}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    .local v0, "arr$":[C
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-char v1, v0, v2

    .line 84
    .local v1, "character":C
    const/16 v4, 0x7f

    if-lt v1, v4, :cond_0

    .line 85
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Bitset only works correct with one byte"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 88
    :cond_0
    invoke-virtual {p0, v1}, Ljava/util/BitSet;->set(I)V

    .line 83
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 90
    .end local v1    # "character":C
    :cond_1
    return-void
.end method

.method public static encode(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "sourceValue"    # Ljava/lang/String;

    .prologue
    .line 127
    sget-object v0, Lcom/damnhandy/uri/template/UriUtil;->GENERAL_ALLOWED_CHARS:Ljava/util/BitSet;

    invoke-static {p0, v0}, Lcom/damnhandy/uri/template/UriUtil;->encode(Ljava/lang/String;Ljava/util/BitSet;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static encode(Ljava/lang/String;Ljava/util/BitSet;)Ljava/lang/String;
    .locals 9
    .param p0, "sourceValue"    # Ljava/lang/String;
    .param p1, "allowedCharacters"    # Ljava/util/BitSet;

    .prologue
    const/16 v8, 0x10

    .line 135
    new-instance v4, Ljava/io/ByteArrayOutputStream;

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v7

    invoke-direct {v4, v7}, Ljava/io/ByteArrayOutputStream;-><init>(I)V

    .line 136
    .local v4, "out":Ljava/io/ByteArrayOutputStream;
    const-string v7, "UTF-8"

    invoke-static {v7}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v6

    .line 137
    .local v6, "utf8":Ljava/nio/charset/Charset;
    invoke-virtual {p0, v6}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v5

    .line 138
    .local v5, "source":[B
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    array-length v7, v5

    if-ge v3, v7, :cond_1

    .line 139
    aget-byte v0, v5, v3

    .line 141
    .local v0, "c":B
    and-int/lit16 v7, v0, 0xff

    invoke-virtual {p1, v7}, Ljava/util/BitSet;->get(I)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 142
    invoke-virtual {v4, v0}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 138
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 145
    :cond_0
    const/16 v7, 0x25

    invoke-virtual {v4, v7}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 146
    shr-int/lit8 v7, v0, 0x4

    and-int/lit8 v7, v7, 0xf

    invoke-static {v7, v8}, Ljava/lang/Character;->forDigit(II)C

    move-result v7

    invoke-static {v7}, Ljava/lang/Character;->toUpperCase(C)C

    move-result v1

    .line 147
    .local v1, "hex1":C
    and-int/lit8 v7, v0, 0xf

    invoke-static {v7, v8}, Ljava/lang/Character;->forDigit(II)C

    move-result v7

    invoke-static {v7}, Ljava/lang/Character;->toUpperCase(C)C

    move-result v2

    .line 148
    .local v2, "hex2":C
    invoke-virtual {v4, v1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 149
    invoke-virtual {v4, v2}, Ljava/io/ByteArrayOutputStream;->write(I)V

    goto :goto_1

    .line 152
    .end local v0    # "c":B
    .end local v1    # "hex1":C
    .end local v2    # "hex2":C
    :cond_1
    new-instance v7, Ljava/lang/String;

    invoke-virtual {v4}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v8

    invoke-direct {v7, v8, v6}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    return-object v7
.end method

.method public static encodeFragment(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "sourceValue"    # Ljava/lang/String;

    .prologue
    .line 105
    sget-object v0, Lcom/damnhandy/uri/template/UriUtil;->FRAGMENT_ALLOWED_CHARS:Ljava/util/BitSet;

    invoke-static {p0, v0}, Lcom/damnhandy/uri/template/UriUtil;->encode(Ljava/lang/String;Ljava/util/BitSet;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static encodeReserved(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "sourceValue"    # Ljava/lang/String;

    .prologue
    .line 116
    sget-object v0, Lcom/damnhandy/uri/template/UriUtil;->RESERVED_ALLOWED_CHARS:Ljava/util/BitSet;

    invoke-static {p0, v0}, Lcom/damnhandy/uri/template/UriUtil;->encode(Ljava/lang/String;Ljava/util/BitSet;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
