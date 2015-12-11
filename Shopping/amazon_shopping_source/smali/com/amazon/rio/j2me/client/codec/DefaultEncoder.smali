.class public Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;
.super Ljava/lang/Object;
.source "DefaultEncoder.java"


# static fields
.field private static final booleanEncoder:Lcom/amazon/rio/j2me/client/codec/Encoder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/rio/j2me/client/codec/Encoder",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private static final octetArrayEncoder:Lcom/amazon/rio/j2me/client/codec/Encoder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/rio/j2me/client/codec/Encoder",
            "<[B>;"
        }
    .end annotation
.end field

.field private static final octetEncoder:Lcom/amazon/rio/j2me/client/codec/Encoder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/rio/j2me/client/codec/Encoder",
            "<",
            "Ljava/lang/Byte;",
            ">;"
        }
    .end annotation
.end field

.field private static final stringEncoder:Lcom/amazon/rio/j2me/client/codec/Encoder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/rio/j2me/client/codec/Encoder",
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
    .line 17
    new-instance v0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$1;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$1;-><init>()V

    sput-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->stringEncoder:Lcom/amazon/rio/j2me/client/codec/Encoder;

    .line 32
    new-instance v0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$2;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$2;-><init>()V

    sput-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->booleanEncoder:Lcom/amazon/rio/j2me/client/codec/Encoder;

    .line 47
    new-instance v0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$3;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$3;-><init>()V

    sput-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->octetEncoder:Lcom/amazon/rio/j2me/client/codec/Encoder;

    .line 128
    new-instance v0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$6;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$6;-><init>()V

    sput-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->octetArrayEncoder:Lcom/amazon/rio/j2me/client/codec/Encoder;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(JJJLjava/io/DataOutputStream;)V
    .locals 0
    .param p0, "x0"    # J
    .param p2, "x1"    # J
    .param p4, "x2"    # J
    .param p6, "x3"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 15
    invoke-static/range {p0 .. p6}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->encodeIntegerInRange(JJJLjava/io/DataOutputStream;)V

    return-void
.end method

.method private static encodeIntegerInRange(JJJLjava/io/DataOutputStream;)V
    .locals 4
    .param p0, "value"    # J
    .param p2, "lowerBound"    # J
    .param p4, "upperBound"    # J
    .param p6, "dos"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 80
    invoke-static {p2, p3, p4, p5}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->numBytesPerValueInRange(JJ)I

    move-result v0

    .line 81
    .local v0, "bytes":I
    sub-long v2, p0, p2

    long-to-int v1, v2

    .line 83
    .local v1, "normalizedValue":I
    const/4 v2, 0x1

    if-ne v0, v2, :cond_0

    .line 84
    invoke-virtual {p6, v1}, Ljava/io/DataOutputStream;->writeByte(I)V

    .line 91
    :goto_0
    return-void

    .line 85
    :cond_0
    const/4 v2, 0x2

    if-ne v0, v2, :cond_1

    .line 86
    invoke-virtual {p6, v1}, Ljava/io/DataOutputStream;->writeShort(I)V

    goto :goto_0

    .line 87
    :cond_1
    const/4 v2, 0x4

    if-ne v0, v2, :cond_2

    .line 88
    invoke-virtual {p6, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    goto :goto_0

    .line 90
    :cond_2
    invoke-virtual {p6, p0, p1}, Ljava/io/DataOutputStream;->writeLong(J)V

    goto :goto_0
.end method

.method public static getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Encoder;)Lcom/amazon/rio/j2me/client/codec/Encoder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/amazon/rio/j2me/client/codec/Encoder",
            "<TT;>;)",
            "Lcom/amazon/rio/j2me/client/codec/Encoder",
            "<",
            "Ljava/util/List",
            "<TT;>;>;"
        }
    .end annotation

    .prologue
    .line 146
    .local p0, "elementEncoder":Lcom/amazon/rio/j2me/client/codec/Encoder;, "Lcom/amazon/rio/j2me/client/codec/Encoder<TT;>;"
    new-instance v0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$7;

    invoke-direct {v0, p0}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$7;-><init>(Lcom/amazon/rio/j2me/client/codec/Encoder;)V

    return-object v0
.end method

.method public static getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/rio/j2me/client/codec/Encoder",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .prologue
    .line 44
    sget-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->booleanEncoder:Lcom/amazon/rio/j2me/client/codec/Encoder;

    return-object v0
.end method

.method public static getEnumInstance(I)Lcom/amazon/rio/j2me/client/codec/Encoder;
    .locals 4
    .param p0, "numSymbols"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/amazon/rio/j2me/client/codec/Encoder",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 125
    const-wide/16 v0, 0x0

    add-int/lit8 v2, p0, -0x1

    int-to-long v2, v2

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v0

    return-object v0
.end method

.method public static getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;
    .locals 1
    .param p0, "lowerBound"    # J
    .param p2, "upperBound"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJ)",
            "Lcom/amazon/rio/j2me/client/codec/Encoder",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 98
    new-instance v0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$4;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$4;-><init>(JJ)V

    return-object v0
.end method

.method public static getOctetArrayInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/rio/j2me/client/codec/Encoder",
            "<[B>;"
        }
    .end annotation

    .prologue
    .line 141
    sget-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->octetArrayEncoder:Lcom/amazon/rio/j2me/client/codec/Encoder;

    return-object v0
.end method

.method public static getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/rio/j2me/client/codec/Encoder",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 29
    sget-object v0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->stringEncoder:Lcom/amazon/rio/j2me/client/codec/Encoder;

    return-object v0
.end method

.method public static numBytesPerValueInRange(JJ)I
    .locals 7
    .param p0, "lowerBound"    # J
    .param p2, "upperBound"    # J

    .prologue
    const/16 v2, 0x8

    .line 64
    sub-long v3, p2, p0

    const-wide/16 v5, 0x1

    add-long v0, v3, v5

    .line 66
    .local v0, "numDifferentValues":J
    const-wide/16 v3, 0x0

    cmp-long v3, v0, v3

    if-gtz v3, :cond_1

    .line 75
    :cond_0
    :goto_0
    return v2

    .line 68
    :cond_1
    const-wide/16 v3, 0x100

    cmp-long v3, v0, v3

    if-gtz v3, :cond_2

    .line 69
    const/4 v2, 0x1

    goto :goto_0

    .line 70
    :cond_2
    const-wide/32 v3, 0x10000

    cmp-long v3, v0, v3

    if-gtz v3, :cond_3

    .line 71
    const/4 v2, 0x2

    goto :goto_0

    .line 72
    :cond_3
    const-wide v3, 0x100000000L

    cmp-long v3, v0, v3

    if-gtz v3, :cond_0

    .line 73
    const/4 v2, 0x4

    goto :goto_0
.end method
