.class public Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;
.super Ljava/lang/Object;
.source "DefaultDecoder.java"


# static fields
.field private static final EMPTY_PATH:[I

.field private static final booleanDecoder:Lcom/amazon/rio/j2me/client/codec/Decoder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/rio/j2me/client/codec/Decoder",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private static final octetArrayDecoder:Lcom/amazon/rio/j2me/client/codec/Decoder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/rio/j2me/client/codec/Decoder",
            "<[B>;"
        }
    .end annotation
.end field

.field private static final octetDecoder:Lcom/amazon/rio/j2me/client/codec/Decoder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/rio/j2me/client/codec/Decoder",
            "<",
            "Ljava/lang/Byte;",
            ">;"
        }
    .end annotation
.end field

.field private static final stringDecoder:Lcom/amazon/rio/j2me/client/codec/Decoder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/rio/j2me/client/codec/Decoder",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x0

    new-array v0, v0, [I

    sput-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->EMPTY_PATH:[I

    .line 34
    new-instance v0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$1;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$1;-><init>()V

    sput-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->stringDecoder:Lcom/amazon/rio/j2me/client/codec/Decoder;

    .line 48
    new-instance v0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$2;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$2;-><init>()V

    sput-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->booleanDecoder:Lcom/amazon/rio/j2me/client/codec/Decoder;

    .line 62
    new-instance v0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$3;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$3;-><init>()V

    sput-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->octetDecoder:Lcom/amazon/rio/j2me/client/codec/Decoder;

    .line 142
    new-instance v0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$6;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$6;-><init>()V

    sput-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->octetArrayDecoder:Lcom/amazon/rio/j2me/client/codec/Decoder;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(JJLjava/io/DataInputStream;)J
    .locals 2
    .param p0, "x0"    # J
    .param p2, "x1"    # J
    .param p4, "x2"    # Ljava/io/DataInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 18
    invoke-static {p0, p1, p2, p3, p4}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->decodeIntegerInRange(JJLjava/io/DataInputStream;)J

    move-result-wide v0

    return-wide v0
.end method

.method static synthetic access$100()[I
    .locals 1

    .prologue
    .line 18
    sget-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->EMPTY_PATH:[I

    return-object v0
.end method

.method public static decodeApplicationException(Ljava/io/DataInputStream;)Lcom/amazon/rio/j2me/client/services/ApplicationException;
    .locals 3
    .param p0, "dis"    # Ljava/io/DataInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 27
    invoke-virtual {p0}, Ljava/io/DataInputStream;->readUTF()Ljava/lang/String;

    move-result-object v0

    .line 28
    .local v0, "errorCode":Ljava/lang/String;
    invoke-virtual {p0}, Ljava/io/DataInputStream;->readUTF()Ljava/lang/String;

    move-result-object v1

    .line 29
    .local v1, "message":Ljava/lang/String;
    new-instance v2, Lcom/amazon/rio/j2me/client/services/ApplicationException;

    invoke-direct {v2, v0, v1}, Lcom/amazon/rio/j2me/client/services/ApplicationException;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v2
.end method

.method private static decodeIntegerInRange(JJLjava/io/DataInputStream;)J
    .locals 9
    .param p0, "lowerBound"    # J
    .param p2, "upperBound"    # J
    .param p4, "dis"    # Ljava/io/DataInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 80
    invoke-static {p0, p1, p2, p3}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->numBytesPerValueInRange(JJ)I

    move-result v0

    .line 81
    .local v0, "bytes":I
    const/4 v5, 0x1

    if-ne v0, v5, :cond_0

    .line 83
    invoke-virtual {p4}, Ljava/io/DataInputStream;->readUnsignedByte()I

    move-result v5

    int-to-long v3, v5

    .line 84
    .local v3, "value":J
    add-long v5, v3, p0

    .line 102
    .end local v3    # "value":J
    :goto_0
    return-wide v5

    .line 86
    :cond_0
    const/4 v5, 0x2

    if-ne v0, v5, :cond_1

    .line 88
    invoke-virtual {p4}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v5

    int-to-long v3, v5

    .line 89
    .restart local v3    # "value":J
    add-long v5, v3, p0

    goto :goto_0

    .line 91
    .end local v3    # "value":J
    :cond_1
    const/4 v5, 0x4

    if-ne v0, v5, :cond_3

    .line 93
    invoke-virtual {p4}, Ljava/io/DataInputStream;->readInt()I

    move-result v3

    .line 95
    .local v3, "value":I
    if-gez v3, :cond_2

    .line 96
    const-wide v5, 0x100000000L

    int-to-long v7, v3

    add-long v1, v5, v7

    .line 99
    .local v1, "normalized":J
    :goto_1
    add-long v5, v1, p0

    goto :goto_0

    .line 98
    .end local v1    # "normalized":J
    :cond_2
    int-to-long v1, v3

    .restart local v1    # "normalized":J
    goto :goto_1

    .line 102
    .end local v1    # "normalized":J
    .end local v3    # "value":I
    :cond_3
    invoke-virtual {p4}, Ljava/io/DataInputStream;->readLong()J

    move-result-wide v5

    goto :goto_0
.end method

.method public static getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/amazon/rio/j2me/client/codec/Decoder",
            "<TT;>;)",
            "Lcom/amazon/rio/j2me/client/codec/Decoder",
            "<",
            "Ljava/util/List",
            "<TT;>;>;"
        }
    .end annotation

    .prologue
    .line 161
    .local p0, "elementDecoder":Lcom/amazon/rio/j2me/client/codec/Decoder;, "Lcom/amazon/rio/j2me/client/codec/Decoder<TT;>;"
    new-instance v0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$7;

    invoke-direct {v0, p0}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$7;-><init>(Lcom/amazon/rio/j2me/client/codec/Decoder;)V

    return-object v0
.end method

.method public static getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/rio/j2me/client/codec/Decoder",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .prologue
    .line 59
    sget-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->booleanDecoder:Lcom/amazon/rio/j2me/client/codec/Decoder;

    return-object v0
.end method

.method public static getEnumInstance(I)Lcom/amazon/rio/j2me/client/codec/Decoder;
    .locals 4
    .param p0, "numSymbols"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/amazon/rio/j2me/client/codec/Decoder",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 139
    const-wide/16 v0, 0x0

    add-int/lit8 v2, p0, -0x1

    int-to-long v2, v2

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v0

    return-object v0
.end method

.method public static getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;
    .locals 1
    .param p0, "lowerBound"    # J
    .param p2, "upperBound"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJ)",
            "Lcom/amazon/rio/j2me/client/codec/Decoder",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 110
    new-instance v0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$4;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$4;-><init>(JJ)V

    return-object v0
.end method

.method public static getOctetArrayInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/rio/j2me/client/codec/Decoder",
            "<[B>;"
        }
    .end annotation

    .prologue
    .line 156
    sget-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->octetArrayDecoder:Lcom/amazon/rio/j2me/client/codec/Decoder;

    return-object v0
.end method

.method public static getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/rio/j2me/client/codec/Decoder",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 45
    sget-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->stringDecoder:Lcom/amazon/rio/j2me/client/codec/Decoder;

    return-object v0
.end method

.method public static isErrorResponse(Ljava/io/DataInputStream;)Z
    .locals 1
    .param p0, "dis"    # Ljava/io/DataInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 22
    invoke-virtual {p0}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
