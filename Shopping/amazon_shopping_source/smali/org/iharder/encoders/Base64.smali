.class public Lorg/iharder/encoders/Base64;
.super Ljava/lang/Object;
.source "Base64.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/iharder/encoders/Base64$OutputStream;
    }
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z

.field private static final _ORDERED_ALPHABET:[B

.field private static final _ORDERED_DECODABET:[B

.field private static final _STANDARD_ALPHABET:[B

.field private static final _STANDARD_DECODABET:[B

.field private static final _URL_SAFE_ALPHABET:[B

.field private static final _URL_SAFE_DECODABET:[B


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/16 v2, 0x100

    const/16 v1, 0x40

    .line 149
    const-class v0, Lorg/iharder/encoders/Base64;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lorg/iharder/encoders/Base64;->$assertionsDisabled:Z

    .line 221
    new-array v0, v1, [B

    fill-array-data v0, :array_0

    sput-object v0, Lorg/iharder/encoders/Base64;->_STANDARD_ALPHABET:[B

    .line 239
    new-array v0, v2, [B

    fill-array-data v0, :array_1

    sput-object v0, Lorg/iharder/encoders/Base64;->_STANDARD_DECODABET:[B

    .line 281
    new-array v0, v1, [B

    fill-array-data v0, :array_2

    sput-object v0, Lorg/iharder/encoders/Base64;->_URL_SAFE_ALPHABET:[B

    .line 297
    new-array v0, v2, [B

    fill-array-data v0, :array_3

    sput-object v0, Lorg/iharder/encoders/Base64;->_URL_SAFE_DECODABET:[B

    .line 344
    new-array v0, v1, [B

    fill-array-data v0, :array_4

    sput-object v0, Lorg/iharder/encoders/Base64;->_ORDERED_ALPHABET:[B

    .line 362
    const/16 v0, 0x101

    new-array v0, v0, [B

    fill-array-data v0, :array_5

    sput-object v0, Lorg/iharder/encoders/Base64;->_ORDERED_DECODABET:[B

    return-void

    .line 149
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 221
    :array_0
    .array-data 1
        0x41t
        0x42t
        0x43t
        0x44t
        0x45t
        0x46t
        0x47t
        0x48t
        0x49t
        0x4at
        0x4bt
        0x4ct
        0x4dt
        0x4et
        0x4ft
        0x50t
        0x51t
        0x52t
        0x53t
        0x54t
        0x55t
        0x56t
        0x57t
        0x58t
        0x59t
        0x5at
        0x61t
        0x62t
        0x63t
        0x64t
        0x65t
        0x66t
        0x67t
        0x68t
        0x69t
        0x6at
        0x6bt
        0x6ct
        0x6dt
        0x6et
        0x6ft
        0x70t
        0x71t
        0x72t
        0x73t
        0x74t
        0x75t
        0x76t
        0x77t
        0x78t
        0x79t
        0x7at
        0x30t
        0x31t
        0x32t
        0x33t
        0x34t
        0x35t
        0x36t
        0x37t
        0x38t
        0x39t
        0x2bt
        0x2ft
    .end array-data

    .line 239
    :array_1
    .array-data 1
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x5t
        -0x5t
        -0x9t
        -0x9t
        -0x5t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x5t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        0x3et
        -0x9t
        -0x9t
        -0x9t
        0x3ft
        0x34t
        0x35t
        0x36t
        0x37t
        0x38t
        0x39t
        0x3at
        0x3bt
        0x3ct
        0x3dt
        -0x9t
        -0x9t
        -0x9t
        -0x1t
        -0x9t
        -0x9t
        -0x9t
        0x0t
        0x1t
        0x2t
        0x3t
        0x4t
        0x5t
        0x6t
        0x7t
        0x8t
        0x9t
        0xat
        0xbt
        0xct
        0xdt
        0xet
        0xft
        0x10t
        0x11t
        0x12t
        0x13t
        0x14t
        0x15t
        0x16t
        0x17t
        0x18t
        0x19t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        0x1at
        0x1bt
        0x1ct
        0x1dt
        0x1et
        0x1ft
        0x20t
        0x21t
        0x22t
        0x23t
        0x24t
        0x25t
        0x26t
        0x27t
        0x28t
        0x29t
        0x2at
        0x2bt
        0x2ct
        0x2dt
        0x2et
        0x2ft
        0x30t
        0x31t
        0x32t
        0x33t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
    .end array-data

    .line 281
    :array_2
    .array-data 1
        0x41t
        0x42t
        0x43t
        0x44t
        0x45t
        0x46t
        0x47t
        0x48t
        0x49t
        0x4at
        0x4bt
        0x4ct
        0x4dt
        0x4et
        0x4ft
        0x50t
        0x51t
        0x52t
        0x53t
        0x54t
        0x55t
        0x56t
        0x57t
        0x58t
        0x59t
        0x5at
        0x61t
        0x62t
        0x63t
        0x64t
        0x65t
        0x66t
        0x67t
        0x68t
        0x69t
        0x6at
        0x6bt
        0x6ct
        0x6dt
        0x6et
        0x6ft
        0x70t
        0x71t
        0x72t
        0x73t
        0x74t
        0x75t
        0x76t
        0x77t
        0x78t
        0x79t
        0x7at
        0x30t
        0x31t
        0x32t
        0x33t
        0x34t
        0x35t
        0x36t
        0x37t
        0x38t
        0x39t
        0x2dt
        0x5ft
    .end array-data

    .line 297
    :array_3
    .array-data 1
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x5t
        -0x5t
        -0x9t
        -0x9t
        -0x5t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x5t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        0x3et
        -0x9t
        -0x9t
        0x34t
        0x35t
        0x36t
        0x37t
        0x38t
        0x39t
        0x3at
        0x3bt
        0x3ct
        0x3dt
        -0x9t
        -0x9t
        -0x9t
        -0x1t
        -0x9t
        -0x9t
        -0x9t
        0x0t
        0x1t
        0x2t
        0x3t
        0x4t
        0x5t
        0x6t
        0x7t
        0x8t
        0x9t
        0xat
        0xbt
        0xct
        0xdt
        0xet
        0xft
        0x10t
        0x11t
        0x12t
        0x13t
        0x14t
        0x15t
        0x16t
        0x17t
        0x18t
        0x19t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        0x3ft
        -0x9t
        0x1at
        0x1bt
        0x1ct
        0x1dt
        0x1et
        0x1ft
        0x20t
        0x21t
        0x22t
        0x23t
        0x24t
        0x25t
        0x26t
        0x27t
        0x28t
        0x29t
        0x2at
        0x2bt
        0x2ct
        0x2dt
        0x2et
        0x2ft
        0x30t
        0x31t
        0x32t
        0x33t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
    .end array-data

    .line 344
    :array_4
    .array-data 1
        0x2dt
        0x30t
        0x31t
        0x32t
        0x33t
        0x34t
        0x35t
        0x36t
        0x37t
        0x38t
        0x39t
        0x41t
        0x42t
        0x43t
        0x44t
        0x45t
        0x46t
        0x47t
        0x48t
        0x49t
        0x4at
        0x4bt
        0x4ct
        0x4dt
        0x4et
        0x4ft
        0x50t
        0x51t
        0x52t
        0x53t
        0x54t
        0x55t
        0x56t
        0x57t
        0x58t
        0x59t
        0x5at
        0x5ft
        0x61t
        0x62t
        0x63t
        0x64t
        0x65t
        0x66t
        0x67t
        0x68t
        0x69t
        0x6at
        0x6bt
        0x6ct
        0x6dt
        0x6et
        0x6ft
        0x70t
        0x71t
        0x72t
        0x73t
        0x74t
        0x75t
        0x76t
        0x77t
        0x78t
        0x79t
        0x7at
    .end array-data

    .line 362
    :array_5
    .array-data 1
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x5t
        -0x5t
        -0x9t
        -0x9t
        -0x5t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x5t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        0x0t
        -0x9t
        -0x9t
        0x1t
        0x2t
        0x3t
        0x4t
        0x5t
        0x6t
        0x7t
        0x8t
        0x9t
        0xat
        -0x9t
        -0x9t
        -0x9t
        -0x1t
        -0x9t
        -0x9t
        -0x9t
        0xbt
        0xct
        0xdt
        0xet
        0xft
        0x10t
        0x11t
        0x12t
        0x13t
        0x14t
        0x15t
        0x16t
        0x17t
        0x18t
        0x19t
        0x1at
        0x1bt
        0x1ct
        0x1dt
        0x1et
        0x1ft
        0x20t
        0x21t
        0x22t
        0x23t
        0x24t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        0x25t
        -0x9t
        0x26t
        0x27t
        0x28t
        0x29t
        0x2at
        0x2bt
        0x2ct
        0x2dt
        0x2et
        0x2ft
        0x30t
        0x31t
        0x32t
        0x33t
        0x34t
        0x35t
        0x36t
        0x37t
        0x38t
        0x39t
        0x3at
        0x3bt
        0x3ct
        0x3dt
        0x3et
        0x3ft
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
        -0x9t
    .end array-data
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 442
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(I)[B
    .locals 1
    .param p0, "x0"    # I

    .prologue
    .line 149
    invoke-static {p0}, Lorg/iharder/encoders/Base64;->getDecodabet(I)[B

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200([BI[BII)I
    .locals 1
    .param p0, "x0"    # [B
    .param p1, "x1"    # I
    .param p2, "x2"    # [B
    .param p3, "x3"    # I
    .param p4, "x4"    # I

    .prologue
    .line 149
    invoke-static {p0, p1, p2, p3, p4}, Lorg/iharder/encoders/Base64;->decode4to3([BI[BII)I

    move-result v0

    return v0
.end method

.method static synthetic access$300([B[BII)[B
    .locals 1
    .param p0, "x0"    # [B
    .param p1, "x1"    # [B
    .param p2, "x2"    # I
    .param p3, "x3"    # I

    .prologue
    .line 149
    invoke-static {p0, p1, p2, p3}, Lorg/iharder/encoders/Base64;->encode3to4([B[BII)[B

    move-result-object v0

    return-object v0
.end method

.method public static decode(Ljava/lang/String;)[B
    .locals 1
    .param p0, "s"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1223
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lorg/iharder/encoders/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v0

    return-object v0
.end method

.method public static decode(Ljava/lang/String;I)[B
    .locals 17
    .param p0, "s"    # Ljava/lang/String;
    .param p1, "options"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1241
    if-nez p0, :cond_0

    .line 1242
    new-instance v14, Ljava/lang/NullPointerException;

    const-string/jumbo v15, "Input string was null."

    invoke-direct {v14, v15}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v14

    .line 1247
    :cond_0
    :try_start_0
    const-string/jumbo v14, "US-ASCII"

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v6

    .line 1255
    .local v6, "bytes":[B
    :goto_0
    const/4 v14, 0x0

    array-length v15, v6

    move/from16 v0, p1

    invoke-static {v6, v14, v15, v0}, Lorg/iharder/encoders/Base64;->decode([BIII)[B

    move-result-object v6

    .line 1259
    and-int/lit8 v14, p1, 0x4

    if-eqz v14, :cond_2

    const/4 v7, 0x1

    .line 1260
    .local v7, "dontGunzip":Z
    :goto_1
    if-eqz v6, :cond_1

    array-length v14, v6

    const/4 v15, 0x4

    if-lt v14, v15, :cond_1

    if-nez v7, :cond_1

    .line 1262
    const/4 v14, 0x0

    aget-byte v14, v6, v14

    and-int/lit16 v14, v14, 0xff

    const/4 v15, 0x1

    aget-byte v15, v6, v15

    shl-int/lit8 v15, v15, 0x8

    const v16, 0xff00

    and-int v15, v15, v16

    or-int v11, v14, v15

    .line 1263
    .local v11, "head":I
    const v14, 0x8b1f

    if-ne v14, v11, :cond_1

    .line 1264
    const/4 v1, 0x0

    .line 1265
    .local v1, "bais":Ljava/io/ByteArrayInputStream;
    const/4 v9, 0x0

    .line 1266
    .local v9, "gzis":Ljava/util/zip/GZIPInputStream;
    const/4 v3, 0x0

    .line 1267
    .local v3, "baos":Ljava/io/ByteArrayOutputStream;
    const/16 v14, 0x800

    new-array v5, v14, [B

    .line 1268
    .local v5, "buffer":[B
    const/4 v12, 0x0

    .line 1271
    .local v12, "length":I
    :try_start_1
    new-instance v4, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v4}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_b
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1272
    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .local v4, "baos":Ljava/io/ByteArrayOutputStream;
    :try_start_2
    new-instance v2, Ljava/io/ByteArrayInputStream;

    invoke-direct {v2, v6}, Ljava/io/ByteArrayInputStream;-><init>([B)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_c
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1273
    .end local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .local v2, "bais":Ljava/io/ByteArrayInputStream;
    :try_start_3
    new-instance v10, Ljava/util/zip/GZIPInputStream;

    invoke-direct {v10, v2}, Ljava/util/zip/GZIPInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_d
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 1275
    .end local v9    # "gzis":Ljava/util/zip/GZIPInputStream;
    .local v10, "gzis":Ljava/util/zip/GZIPInputStream;
    :goto_2
    :try_start_4
    invoke-virtual {v10, v5}, Ljava/util/zip/GZIPInputStream;->read([B)I

    move-result v12

    if-ltz v12, :cond_3

    .line 1276
    const/4 v14, 0x0

    invoke-virtual {v4, v5, v14, v12}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    goto :goto_2

    .line 1283
    :catch_0
    move-exception v8

    move-object v3, v4

    .end local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v9, v10

    .end local v10    # "gzis":Ljava/util/zip/GZIPInputStream;
    .restart local v9    # "gzis":Ljava/util/zip/GZIPInputStream;
    move-object v1, v2

    .line 1284
    .end local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .local v8, "e":Ljava/io/IOException;
    :goto_3
    :try_start_5
    invoke-virtual {v8}, Ljava/io/IOException;->printStackTrace()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 1288
    :try_start_6
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_5

    .line 1289
    :goto_4
    :try_start_7
    invoke-virtual {v9}, Ljava/util/zip/GZIPInputStream;->close()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_6

    .line 1290
    :goto_5
    :try_start_8
    invoke-virtual {v1}, Ljava/io/ByteArrayInputStream;->close()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_7

    .line 1296
    .end local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v5    # "buffer":[B
    .end local v8    # "e":Ljava/io/IOException;
    .end local v9    # "gzis":Ljava/util/zip/GZIPInputStream;
    .end local v11    # "head":I
    .end local v12    # "length":I
    :cond_1
    :goto_6
    return-object v6

    .line 1249
    .end local v6    # "bytes":[B
    .end local v7    # "dontGunzip":Z
    :catch_1
    move-exception v13

    .line 1250
    .local v13, "uee":Ljava/io/UnsupportedEncodingException;
    invoke-virtual/range {p0 .. p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v6

    .restart local v6    # "bytes":[B
    goto :goto_0

    .line 1259
    .end local v13    # "uee":Ljava/io/UnsupportedEncodingException;
    :cond_2
    const/4 v7, 0x0

    goto :goto_1

    .line 1280
    .restart local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v5    # "buffer":[B
    .restart local v7    # "dontGunzip":Z
    .restart local v10    # "gzis":Ljava/util/zip/GZIPInputStream;
    .restart local v11    # "head":I
    .restart local v12    # "length":I
    :cond_3
    :try_start_9
    invoke-virtual {v4}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_0
    .catchall {:try_start_9 .. :try_end_9} :catchall_3

    move-result-object v6

    .line 1288
    :try_start_a
    invoke-virtual {v4}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_3

    .line 1289
    :goto_7
    :try_start_b
    invoke-virtual {v10}, Ljava/util/zip/GZIPInputStream;->close()V
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_4

    .line 1290
    :goto_8
    :try_start_c
    invoke-virtual {v2}, Ljava/io/ByteArrayInputStream;->close()V
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_2

    goto :goto_6

    :catch_2
    move-exception v14

    goto :goto_6

    .line 1288
    .end local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .end local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v10    # "gzis":Ljava/util/zip/GZIPInputStream;
    .restart local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v9    # "gzis":Ljava/util/zip/GZIPInputStream;
    :catchall_0
    move-exception v14

    :goto_9
    :try_start_d
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_8

    .line 1289
    :goto_a
    :try_start_e
    invoke-virtual {v9}, Ljava/util/zip/GZIPInputStream;->close()V
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_9

    .line 1290
    :goto_b
    :try_start_f
    invoke-virtual {v1}, Ljava/io/ByteArrayInputStream;->close()V
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_a

    :goto_c
    throw v14

    .line 1288
    .end local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v9    # "gzis":Ljava/util/zip/GZIPInputStream;
    .restart local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v10    # "gzis":Ljava/util/zip/GZIPInputStream;
    :catch_3
    move-exception v14

    goto :goto_7

    .line 1289
    :catch_4
    move-exception v14

    goto :goto_8

    .line 1288
    .end local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .end local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v10    # "gzis":Ljava/util/zip/GZIPInputStream;
    .restart local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v8    # "e":Ljava/io/IOException;
    .restart local v9    # "gzis":Ljava/util/zip/GZIPInputStream;
    :catch_5
    move-exception v14

    goto :goto_4

    .line 1289
    :catch_6
    move-exception v14

    goto :goto_5

    .line 1290
    :catch_7
    move-exception v14

    goto :goto_6

    .line 1288
    .end local v8    # "e":Ljava/io/IOException;
    :catch_8
    move-exception v15

    goto :goto_a

    .line 1289
    :catch_9
    move-exception v15

    goto :goto_b

    .line 1290
    :catch_a
    move-exception v15

    goto :goto_c

    .line 1288
    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    :catchall_1
    move-exception v14

    move-object v3, v4

    .end local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_9

    .end local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    :catchall_2
    move-exception v14

    move-object v3, v4

    .end local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v1, v2

    .end local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "bais":Ljava/io/ByteArrayInputStream;
    goto :goto_9

    .end local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v9    # "gzis":Ljava/util/zip/GZIPInputStream;
    .restart local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v10    # "gzis":Ljava/util/zip/GZIPInputStream;
    :catchall_3
    move-exception v14

    move-object v3, v4

    .end local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v9, v10

    .end local v10    # "gzis":Ljava/util/zip/GZIPInputStream;
    .restart local v9    # "gzis":Ljava/util/zip/GZIPInputStream;
    move-object v1, v2

    .end local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "bais":Ljava/io/ByteArrayInputStream;
    goto :goto_9

    .line 1283
    :catch_b
    move-exception v8

    goto :goto_3

    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    :catch_c
    move-exception v8

    move-object v3, v4

    .end local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_3

    .end local v1    # "bais":Ljava/io/ByteArrayInputStream;
    .end local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    :catch_d
    move-exception v8

    move-object v3, v4

    .end local v4    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v1, v2

    .end local v2    # "bais":Ljava/io/ByteArrayInputStream;
    .restart local v1    # "bais":Ljava/io/ByteArrayInputStream;
    goto :goto_3
.end method

.method public static decode([B)[B
    .locals 3
    .param p0, "source"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 1119
    const/4 v0, 0x0

    .line 1121
    .local v0, "decoded":[B
    array-length v1, p0

    invoke-static {p0, v2, v1, v2}, Lorg/iharder/encoders/Base64;->decode([BIII)[B

    move-result-object v0

    .line 1125
    return-object v0
.end method

.method public static decode([BIII)[B
    .locals 16
    .param p0, "source"    # [B
    .param p1, "off"    # I
    .param p2, "len"    # I
    .param p3, "options"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1151
    if-nez p0, :cond_0

    .line 1152
    new-instance v11, Ljava/lang/NullPointerException;

    const-string/jumbo v12, "Cannot decode null source array."

    invoke-direct {v11, v12}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v11

    .line 1154
    :cond_0
    if-ltz p1, :cond_1

    add-int v11, p1, p2

    move-object/from16 v0, p0

    array-length v12, v0

    if-le v11, v12, :cond_2

    .line 1155
    :cond_1
    new-instance v11, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v12, "Source array with length %d cannot have offset of %d and process %d bytes."

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    move-object/from16 v0, p0

    array-length v15, v0

    invoke-static {v15}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v13, v14

    const/4 v14, 0x1

    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v13, v14

    const/4 v14, 0x2

    invoke-static/range {p2 .. p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v13, v14

    invoke-static {v12, v13}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v11

    .line 1159
    :cond_2
    if-nez p2, :cond_3

    .line 1160
    const/4 v11, 0x0

    new-array v7, v11, [B

    .line 1207
    :goto_0
    return-object v7

    .line 1161
    :cond_3
    const/4 v11, 0x4

    move/from16 v0, p2

    if-ge v0, v11, :cond_4

    .line 1162
    new-instance v11, Ljava/lang/IllegalArgumentException;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v13, "Base64-encoded string must have at least four characters, but length specified was "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    move/from16 v0, p2

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v11

    .line 1166
    :cond_4
    invoke-static/range {p3 .. p3}, Lorg/iharder/encoders/Base64;->getDecodabet(I)[B

    move-result-object v1

    .line 1168
    .local v1, "DECODABET":[B
    mul-int/lit8 v11, p2, 0x3

    div-int/lit8 v6, v11, 0x4

    .line 1169
    .local v6, "len34":I
    new-array v8, v6, [B

    .line 1170
    .local v8, "outBuff":[B
    const/4 v9, 0x0

    .line 1172
    .local v9, "outBuffPosn":I
    const/4 v11, 0x4

    new-array v2, v11, [B

    .line 1173
    .local v2, "b4":[B
    const/4 v3, 0x0

    .line 1174
    .local v3, "b4Posn":I
    const/4 v5, 0x0

    .line 1175
    .local v5, "i":I
    const/4 v10, 0x0

    .line 1177
    .local v10, "sbiDecode":B
    move/from16 v5, p1

    move v4, v3

    .end local v3    # "b4Posn":I
    .local v4, "b4Posn":I
    :goto_1
    add-int v11, p1, p2

    if-ge v5, v11, :cond_8

    .line 1179
    aget-byte v11, p0, v5

    and-int/lit16 v11, v11, 0xff

    aget-byte v10, v1, v11

    .line 1184
    const/4 v11, -0x5

    if-lt v10, v11, :cond_5

    .line 1185
    const/4 v11, -0x1

    if-lt v10, v11, :cond_6

    .line 1186
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "b4Posn":I
    .restart local v3    # "b4Posn":I
    aget-byte v11, p0, v5

    aput-byte v11, v2, v4

    .line 1187
    const/4 v11, 0x3

    if-le v3, v11, :cond_7

    .line 1188
    const/4 v11, 0x0

    move/from16 v0, p3

    invoke-static {v2, v11, v8, v9, v0}, Lorg/iharder/encoders/Base64;->decode4to3([BI[BII)I

    move-result v11

    add-int/2addr v9, v11

    .line 1189
    const/4 v3, 0x0

    .line 1192
    aget-byte v11, p0, v5

    const/16 v12, 0x3d

    if-ne v11, v12, :cond_7

    .line 1205
    :goto_2
    new-array v7, v9, [B

    .line 1206
    .local v7, "out":[B
    const/4 v11, 0x0

    const/4 v12, 0x0

    invoke-static {v8, v11, v7, v12, v9}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_0

    .line 1200
    .end local v3    # "b4Posn":I
    .end local v7    # "out":[B
    .restart local v4    # "b4Posn":I
    :cond_5
    new-instance v11, Ljava/io/IOException;

    const-string/jumbo v12, "Bad Base64 input character decimal %d in array position %d"

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    aget-byte v15, p0, v5

    and-int/lit16 v15, v15, 0xff

    invoke-static {v15}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v13, v14

    const/4 v14, 0x1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v13, v14

    invoke-static {v12, v13}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v11

    :cond_6
    move v3, v4

    .line 1177
    .end local v4    # "b4Posn":I
    .restart local v3    # "b4Posn":I
    :cond_7
    add-int/lit8 v5, v5, 0x1

    move v4, v3

    .end local v3    # "b4Posn":I
    .restart local v4    # "b4Posn":I
    goto :goto_1

    :cond_8
    move v3, v4

    .end local v4    # "b4Posn":I
    .restart local v3    # "b4Posn":I
    goto :goto_2
.end method

.method private static decode4to3([BI[BII)I
    .locals 8
    .param p0, "source"    # [B
    .param p1, "srcOffset"    # I
    .param p2, "destination"    # [B
    .param p3, "destOffset"    # I
    .param p4, "options"    # I

    .prologue
    const/16 v6, 0x3d

    const/4 v7, 0x0

    const/4 v3, 0x2

    const/4 v2, 0x1

    .line 1034
    if-nez p0, :cond_0

    .line 1035
    new-instance v2, Ljava/lang/NullPointerException;

    const-string/jumbo v3, "Source array was null."

    invoke-direct {v2, v3}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1037
    :cond_0
    if-nez p2, :cond_1

    .line 1038
    new-instance v2, Ljava/lang/NullPointerException;

    const-string/jumbo v3, "Destination array was null."

    invoke-direct {v2, v3}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1040
    :cond_1
    if-ltz p1, :cond_2

    add-int/lit8 v4, p1, 0x3

    array-length v5, p0

    if-lt v4, v5, :cond_3

    .line 1041
    :cond_2
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v5, "Source array with length %d cannot have offset of %d and still process four bytes."

    new-array v3, v3, [Ljava/lang/Object;

    array-length v6, p0

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v3, v7

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v3, v2

    invoke-static {v5, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v4, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 1044
    :cond_3
    if-ltz p3, :cond_4

    add-int/lit8 v4, p3, 0x2

    array-length v5, p2

    if-lt v4, v5, :cond_5

    .line 1045
    :cond_4
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v5, "Destination array with length %d cannot have offset of %d and still store three bytes."

    new-array v3, v3, [Ljava/lang/Object;

    array-length v6, p2

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v3, v7

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v3, v2

    invoke-static {v5, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v4, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 1050
    :cond_5
    invoke-static {p4}, Lorg/iharder/encoders/Base64;->getDecodabet(I)[B

    move-result-object v0

    .line 1053
    .local v0, "DECODABET":[B
    add-int/lit8 v4, p1, 0x2

    aget-byte v4, p0, v4

    if-ne v4, v6, :cond_6

    .line 1057
    aget-byte v3, p0, p1

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    shl-int/lit8 v3, v3, 0x12

    add-int/lit8 v4, p1, 0x1

    aget-byte v4, p0, v4

    aget-byte v4, v0, v4

    and-int/lit16 v4, v4, 0xff

    shl-int/lit8 v4, v4, 0xc

    or-int v1, v3, v4

    .line 1060
    .local v1, "outBuff":I
    ushr-int/lit8 v3, v1, 0x10

    int-to-byte v3, v3

    aput-byte v3, p2, p3

    .line 1096
    :goto_0
    return v2

    .line 1065
    .end local v1    # "outBuff":I
    :cond_6
    add-int/lit8 v2, p1, 0x3

    aget-byte v2, p0, v2

    if-ne v2, v6, :cond_7

    .line 1070
    aget-byte v2, p0, p1

    aget-byte v2, v0, v2

    and-int/lit16 v2, v2, 0xff

    shl-int/lit8 v2, v2, 0x12

    add-int/lit8 v4, p1, 0x1

    aget-byte v4, p0, v4

    aget-byte v4, v0, v4

    and-int/lit16 v4, v4, 0xff

    shl-int/lit8 v4, v4, 0xc

    or-int/2addr v2, v4

    add-int/lit8 v4, p1, 0x2

    aget-byte v4, p0, v4

    aget-byte v4, v0, v4

    and-int/lit16 v4, v4, 0xff

    shl-int/lit8 v4, v4, 0x6

    or-int v1, v2, v4

    .line 1074
    .restart local v1    # "outBuff":I
    ushr-int/lit8 v2, v1, 0x10

    int-to-byte v2, v2

    aput-byte v2, p2, p3

    .line 1075
    add-int/lit8 v2, p3, 0x1

    ushr-int/lit8 v4, v1, 0x8

    int-to-byte v4, v4

    aput-byte v4, p2, v2

    move v2, v3

    .line 1076
    goto :goto_0

    .line 1086
    .end local v1    # "outBuff":I
    :cond_7
    aget-byte v2, p0, p1

    aget-byte v2, v0, v2

    and-int/lit16 v2, v2, 0xff

    shl-int/lit8 v2, v2, 0x12

    add-int/lit8 v3, p1, 0x1

    aget-byte v3, p0, v3

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    shl-int/lit8 v3, v3, 0xc

    or-int/2addr v2, v3

    add-int/lit8 v3, p1, 0x2

    aget-byte v3, p0, v3

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    shl-int/lit8 v3, v3, 0x6

    or-int/2addr v2, v3

    add-int/lit8 v3, p1, 0x3

    aget-byte v3, p0, v3

    aget-byte v3, v0, v3

    and-int/lit16 v3, v3, 0xff

    or-int v1, v2, v3

    .line 1092
    .restart local v1    # "outBuff":I
    shr-int/lit8 v2, v1, 0x10

    int-to-byte v2, v2

    aput-byte v2, p2, p3

    .line 1093
    add-int/lit8 v2, p3, 0x1

    shr-int/lit8 v3, v1, 0x8

    int-to-byte v3, v3

    aput-byte v3, p2, v2

    .line 1094
    add-int/lit8 v2, p3, 0x2

    int-to-byte v3, v1

    aput-byte v3, p2, v2

    .line 1096
    const/4 v2, 0x3

    goto :goto_0
.end method

.method private static encode3to4([BII[BII)[B
    .locals 6
    .param p0, "source"    # [B
    .param p1, "srcOffset"    # I
    .param p2, "numSigBytes"    # I
    .param p3, "destination"    # [B
    .param p4, "destOffset"    # I
    .param p5, "options"    # I

    .prologue
    const/16 v5, 0x3d

    const/4 v2, 0x0

    .line 498
    invoke-static {p5}, Lorg/iharder/encoders/Base64;->getAlphabet(I)[B

    move-result-object v0

    .line 511
    .local v0, "ALPHABET":[B
    if-lez p2, :cond_1

    aget-byte v3, p0, p1

    shl-int/lit8 v3, v3, 0x18

    ushr-int/lit8 v3, v3, 0x8

    move v4, v3

    :goto_0
    const/4 v3, 0x1

    if-le p2, v3, :cond_2

    add-int/lit8 v3, p1, 0x1

    aget-byte v3, p0, v3

    shl-int/lit8 v3, v3, 0x18

    ushr-int/lit8 v3, v3, 0x10

    :goto_1
    or-int/2addr v3, v4

    const/4 v4, 0x2

    if-le p2, v4, :cond_0

    add-int/lit8 v2, p1, 0x2

    aget-byte v2, p0, v2

    shl-int/lit8 v2, v2, 0x18

    ushr-int/lit8 v2, v2, 0x18

    :cond_0
    or-int v1, v3, v2

    .line 515
    .local v1, "inBuff":I
    packed-switch p2, :pswitch_data_0

    .line 539
    :goto_2
    return-object p3

    .end local v1    # "inBuff":I
    :cond_1
    move v4, v2

    .line 511
    goto :goto_0

    :cond_2
    move v3, v2

    goto :goto_1

    .line 518
    .restart local v1    # "inBuff":I
    :pswitch_0
    ushr-int/lit8 v2, v1, 0x12

    aget-byte v2, v0, v2

    aput-byte v2, p3, p4

    .line 519
    add-int/lit8 v2, p4, 0x1

    ushr-int/lit8 v3, v1, 0xc

    and-int/lit8 v3, v3, 0x3f

    aget-byte v3, v0, v3

    aput-byte v3, p3, v2

    .line 520
    add-int/lit8 v2, p4, 0x2

    ushr-int/lit8 v3, v1, 0x6

    and-int/lit8 v3, v3, 0x3f

    aget-byte v3, v0, v3

    aput-byte v3, p3, v2

    .line 521
    add-int/lit8 v2, p4, 0x3

    and-int/lit8 v3, v1, 0x3f

    aget-byte v3, v0, v3

    aput-byte v3, p3, v2

    goto :goto_2

    .line 525
    :pswitch_1
    ushr-int/lit8 v2, v1, 0x12

    aget-byte v2, v0, v2

    aput-byte v2, p3, p4

    .line 526
    add-int/lit8 v2, p4, 0x1

    ushr-int/lit8 v3, v1, 0xc

    and-int/lit8 v3, v3, 0x3f

    aget-byte v3, v0, v3

    aput-byte v3, p3, v2

    .line 527
    add-int/lit8 v2, p4, 0x2

    ushr-int/lit8 v3, v1, 0x6

    and-int/lit8 v3, v3, 0x3f

    aget-byte v3, v0, v3

    aput-byte v3, p3, v2

    .line 528
    add-int/lit8 v2, p4, 0x3

    aput-byte v5, p3, v2

    goto :goto_2

    .line 532
    :pswitch_2
    ushr-int/lit8 v2, v1, 0x12

    aget-byte v2, v0, v2

    aput-byte v2, p3, p4

    .line 533
    add-int/lit8 v2, p4, 0x1

    ushr-int/lit8 v3, v1, 0xc

    and-int/lit8 v3, v3, 0x3f

    aget-byte v3, v0, v3

    aput-byte v3, p3, v2

    .line 534
    add-int/lit8 v2, p4, 0x2

    aput-byte v5, p3, v2

    .line 535
    add-int/lit8 v2, p4, 0x3

    aput-byte v5, p3, v2

    goto :goto_2

    .line 515
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static encode3to4([B[BII)[B
    .locals 6
    .param p0, "b4"    # [B
    .param p1, "threeBytes"    # [B
    .param p2, "numSigBytes"    # I
    .param p3, "options"    # I

    .prologue
    const/4 v1, 0x0

    .line 466
    move-object v0, p1

    move v2, p2

    move-object v3, p0

    move v4, v1

    move v5, p3

    invoke-static/range {v0 .. v5}, Lorg/iharder/encoders/Base64;->encode3to4([BII[BII)[B

    .line 467
    return-object p0
.end method

.method public static encodeBytes([B)Ljava/lang/String;
    .locals 5
    .param p0, "source"    # [B

    .prologue
    .line 717
    const/4 v0, 0x0

    .line 719
    .local v0, "encoded":Ljava/lang/String;
    const/4 v2, 0x0

    :try_start_0
    array-length v3, p0

    const/4 v4, 0x0

    invoke-static {p0, v2, v3, v4}, Lorg/iharder/encoders/Base64;->encodeBytes([BIII)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 723
    :cond_0
    sget-boolean v2, Lorg/iharder/encoders/Base64;->$assertionsDisabled:Z

    if-nez v2, :cond_1

    if-nez v0, :cond_1

    new-instance v2, Ljava/lang/AssertionError;

    invoke-direct {v2}, Ljava/lang/AssertionError;-><init>()V

    throw v2

    .line 720
    :catch_0
    move-exception v1

    .line 721
    .local v1, "ex":Ljava/io/IOException;
    sget-boolean v2, Lorg/iharder/encoders/Base64;->$assertionsDisabled:Z

    if-nez v2, :cond_0

    new-instance v2, Ljava/lang/AssertionError;

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v2

    .line 724
    .end local v1    # "ex":Ljava/io/IOException;
    :cond_1
    return-object v0
.end method

.method public static encodeBytes([BI)Ljava/lang/String;
    .locals 2
    .param p0, "source"    # [B
    .param p1, "options"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 759
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1, p1}, Lorg/iharder/encoders/Base64;->encodeBytes([BIII)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static encodeBytes([BIII)Ljava/lang/String;
    .locals 4
    .param p0, "source"    # [B
    .param p1, "off"    # I
    .param p2, "len"    # I
    .param p3, "options"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 830
    invoke-static {p0, p1, p2, p3}, Lorg/iharder/encoders/Base64;->encodeBytesToBytes([BIII)[B

    move-result-object v0

    .line 834
    .local v0, "encoded":[B
    :try_start_0
    new-instance v2, Ljava/lang/String;

    const-string/jumbo v3, "US-ASCII"

    invoke-direct {v2, v0, v3}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 837
    :goto_0
    return-object v2

    .line 836
    :catch_0
    move-exception v1

    .line 837
    .local v1, "uue":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v0}, Ljava/lang/String;-><init>([B)V

    goto :goto_0
.end method

.method public static encodeBytesToBytes([BIII)[B
    .locals 23
    .param p0, "source"    # [B
    .param p1, "off"    # I
    .param p2, "len"    # I
    .param p3, "options"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 887
    if-nez p0, :cond_0

    .line 888
    new-instance v4, Ljava/lang/NullPointerException;

    const-string/jumbo v5, "Cannot serialize a null array."

    invoke-direct {v4, v5}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 891
    :cond_0
    if-gez p1, :cond_1

    .line 892
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Cannot have negative offset: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move/from16 v0, p1

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 895
    :cond_1
    if-gez p2, :cond_2

    .line 896
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Cannot have length offset: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move/from16 v0, p2

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 899
    :cond_2
    add-int v4, p1, p2

    move-object/from16 v0, p0

    array-length v5, v0

    if-le v4, v5, :cond_3

    .line 900
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v5, "Cannot have offset of %d and length of %d with array of length %d"

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v22

    aput-object v22, v6, v9

    const/4 v9, 0x1

    invoke-static/range {p2 .. p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v22

    aput-object v22, v6, v9

    const/4 v9, 0x2

    move-object/from16 v0, p0

    array-length v0, v0

    move/from16 v22, v0

    invoke-static/range {v22 .. v22}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v22

    aput-object v22, v6, v9

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 907
    :cond_3
    and-int/lit8 v4, p3, 0x2

    if-eqz v4, :cond_4

    .line 908
    const/4 v12, 0x0

    .line 909
    .local v12, "baos":Ljava/io/ByteArrayOutputStream;
    const/16 v18, 0x0

    .line 910
    .local v18, "gzos":Ljava/util/zip/GZIPOutputStream;
    const/4 v10, 0x0

    .line 914
    .local v10, "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    :try_start_0
    new-instance v13, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v13}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 915
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .local v13, "baos":Ljava/io/ByteArrayOutputStream;
    :try_start_1
    new-instance v11, Lorg/iharder/encoders/Base64$OutputStream;

    or-int/lit8 v4, p3, 0x1

    invoke-direct {v11, v13, v4}, Lorg/iharder/encoders/Base64$OutputStream;-><init>(Ljava/io/OutputStream;I)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_7
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 916
    .end local v10    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .local v11, "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    :try_start_2
    new-instance v19, Ljava/util/zip/GZIPOutputStream;

    move-object/from16 v0, v19

    invoke-direct {v0, v11}, Ljava/util/zip/GZIPOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_8
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 918
    .end local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .local v19, "gzos":Ljava/util/zip/GZIPOutputStream;
    :try_start_3
    move-object/from16 v0, v19

    move-object/from16 v1, p0

    move/from16 v2, p1

    move/from16 v3, p2

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/zip/GZIPOutputStream;->write([BII)V

    .line 919
    invoke-virtual/range {v19 .. v19}, Ljava/util/zip/GZIPOutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_9
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    .line 927
    :try_start_4
    invoke-virtual/range {v19 .. v19}, Ljava/util/zip/GZIPOutputStream;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1

    .line 928
    :goto_0
    :try_start_5
    invoke-virtual {v11}, Lorg/iharder/encoders/Base64$OutputStream;->close()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_2

    .line 929
    :goto_1
    :try_start_6
    invoke-virtual {v13}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    .line 932
    :goto_2
    invoke-virtual {v13}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v17

    .line 987
    .end local v11    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .end local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v19    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :goto_3
    return-object v17

    .line 921
    .restart local v10    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :catch_0
    move-exception v8

    .line 924
    .local v8, "e":Ljava/io/IOException;
    :goto_4
    :try_start_7
    throw v8
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 927
    .end local v8    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v4

    :goto_5
    :try_start_8
    invoke-virtual/range {v18 .. v18}, Ljava/util/zip/GZIPOutputStream;->close()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_4

    .line 928
    :goto_6
    :try_start_9
    invoke-virtual {v10}, Lorg/iharder/encoders/Base64$OutputStream;->close()V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    .line 929
    :goto_7
    :try_start_a
    invoke-virtual {v12}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_6

    :goto_8
    throw v4

    .line 937
    .end local v10    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :cond_4
    and-int/lit8 v4, p3, 0x8

    if-eqz v4, :cond_7

    const/4 v14, 0x1

    .line 946
    .local v14, "breakLines":Z
    :goto_9
    div-int/lit8 v4, p2, 0x3

    mul-int/lit8 v5, v4, 0x4

    rem-int/lit8 v4, p2, 0x3

    if-lez v4, :cond_8

    const/4 v4, 0x4

    :goto_a
    add-int v16, v5, v4

    .line 947
    .local v16, "encLen":I
    if-eqz v14, :cond_5

    .line 948
    div-int/lit8 v4, v16, 0x4c

    add-int v16, v16, v4

    .line 950
    :cond_5
    move/from16 v0, v16

    new-array v7, v0, [B

    .line 953
    .local v7, "outBuff":[B
    const/4 v15, 0x0

    .line 954
    .local v15, "d":I
    const/4 v8, 0x0

    .line 955
    .local v8, "e":I
    add-int/lit8 v20, p2, -0x2

    .line 956
    .local v20, "len2":I
    const/16 v21, 0x0

    .line 957
    .local v21, "lineLength":I
    :goto_b
    move/from16 v0, v20

    if-ge v15, v0, :cond_9

    .line 958
    add-int v5, v15, p1

    const/4 v6, 0x3

    move-object/from16 v4, p0

    move/from16 v9, p3

    invoke-static/range {v4 .. v9}, Lorg/iharder/encoders/Base64;->encode3to4([BII[BII)[B

    .line 960
    add-int/lit8 v21, v21, 0x4

    .line 961
    if-eqz v14, :cond_6

    const/16 v4, 0x4c

    move/from16 v0, v21

    if-lt v0, v4, :cond_6

    .line 963
    add-int/lit8 v4, v8, 0x4

    const/16 v5, 0xa

    aput-byte v5, v7, v4

    .line 964
    add-int/lit8 v8, v8, 0x1

    .line 965
    const/16 v21, 0x0

    .line 957
    :cond_6
    add-int/lit8 v15, v15, 0x3

    add-int/lit8 v8, v8, 0x4

    goto :goto_b

    .line 937
    .end local v7    # "outBuff":[B
    .end local v8    # "e":I
    .end local v14    # "breakLines":Z
    .end local v15    # "d":I
    .end local v16    # "encLen":I
    .end local v20    # "len2":I
    .end local v21    # "lineLength":I
    :cond_7
    const/4 v14, 0x0

    goto :goto_9

    .line 946
    .restart local v14    # "breakLines":Z
    :cond_8
    const/4 v4, 0x0

    goto :goto_a

    .line 969
    .restart local v7    # "outBuff":[B
    .restart local v8    # "e":I
    .restart local v15    # "d":I
    .restart local v16    # "encLen":I
    .restart local v20    # "len2":I
    .restart local v21    # "lineLength":I
    :cond_9
    move/from16 v0, p2

    if-ge v15, v0, :cond_a

    .line 970
    add-int v5, v15, p1

    sub-int v6, p2, v15

    move-object/from16 v4, p0

    move/from16 v9, p3

    invoke-static/range {v4 .. v9}, Lorg/iharder/encoders/Base64;->encode3to4([BII[BII)[B

    .line 971
    add-int/lit8 v8, v8, 0x4

    .line 976
    :cond_a
    array-length v4, v7

    add-int/lit8 v4, v4, -0x1

    if-gt v8, v4, :cond_b

    .line 981
    new-array v0, v8, [B

    move-object/from16 v17, v0

    .line 982
    .local v17, "finalOut":[B
    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object/from16 v0, v17

    invoke-static {v7, v4, v0, v5, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_3

    .end local v17    # "finalOut":[B
    :cond_b
    move-object/from16 v17, v7

    .line 987
    goto :goto_3

    .line 927
    .end local v7    # "outBuff":[B
    .end local v8    # "e":I
    .end local v14    # "breakLines":Z
    .end local v15    # "d":I
    .end local v16    # "encLen":I
    .end local v20    # "len2":I
    .end local v21    # "lineLength":I
    .restart local v11    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .restart local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v19    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :catch_1
    move-exception v4

    goto/16 :goto_0

    .line 928
    :catch_2
    move-exception v4

    goto/16 :goto_1

    .line 929
    :catch_3
    move-exception v4

    goto/16 :goto_2

    .line 927
    .end local v11    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .end local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v19    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v10    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :catch_4
    move-exception v5

    goto/16 :goto_6

    .line 928
    :catch_5
    move-exception v5

    goto/16 :goto_7

    .line 929
    :catch_6
    move-exception v5

    goto/16 :goto_8

    .line 927
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    :catchall_1
    move-exception v4

    move-object v12, v13

    .end local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    goto/16 :goto_5

    .end local v10    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v11    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .restart local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    :catchall_2
    move-exception v4

    move-object v10, v11

    .end local v11    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .restart local v10    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    move-object v12, v13

    .end local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    goto/16 :goto_5

    .end local v10    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v11    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .restart local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v19    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :catchall_3
    move-exception v4

    move-object v10, v11

    .end local v11    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .restart local v10    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    move-object/from16 v18, v19

    .end local v19    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    move-object v12, v13

    .end local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    goto/16 :goto_5

    .line 921
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    :catch_7
    move-exception v8

    move-object v12, v13

    .end local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    goto/16 :goto_4

    .end local v10    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v11    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .restart local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    :catch_8
    move-exception v8

    move-object v10, v11

    .end local v11    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .restart local v10    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    move-object v12, v13

    .end local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    goto/16 :goto_4

    .end local v10    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .end local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v11    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .restart local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v19    # "gzos":Ljava/util/zip/GZIPOutputStream;
    :catch_9
    move-exception v8

    move-object v10, v11

    .end local v11    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    .restart local v10    # "b64os":Lorg/iharder/encoders/Base64$OutputStream;
    move-object/from16 v18, v19

    .end local v19    # "gzos":Ljava/util/zip/GZIPOutputStream;
    .restart local v18    # "gzos":Ljava/util/zip/GZIPOutputStream;
    move-object v12, v13

    .end local v13    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v12    # "baos":Ljava/io/ByteArrayOutputStream;
    goto/16 :goto_4
.end method

.method private static final getAlphabet(I)[B
    .locals 2
    .param p0, "options"    # I

    .prologue
    .line 412
    and-int/lit8 v0, p0, 0x10

    const/16 v1, 0x10

    if-ne v0, v1, :cond_0

    .line 413
    sget-object v0, Lorg/iharder/encoders/Base64;->_URL_SAFE_ALPHABET:[B

    .line 417
    :goto_0
    return-object v0

    .line 414
    :cond_0
    and-int/lit8 v0, p0, 0x20

    const/16 v1, 0x20

    if-ne v0, v1, :cond_1

    .line 415
    sget-object v0, Lorg/iharder/encoders/Base64;->_ORDERED_ALPHABET:[B

    goto :goto_0

    .line 417
    :cond_1
    sget-object v0, Lorg/iharder/encoders/Base64;->_STANDARD_ALPHABET:[B

    goto :goto_0
.end method

.method private static final getDecodabet(I)[B
    .locals 2
    .param p0, "options"    # I

    .prologue
    .line 430
    and-int/lit8 v0, p0, 0x10

    const/16 v1, 0x10

    if-ne v0, v1, :cond_0

    .line 431
    sget-object v0, Lorg/iharder/encoders/Base64;->_URL_SAFE_DECODABET:[B

    .line 435
    :goto_0
    return-object v0

    .line 432
    :cond_0
    and-int/lit8 v0, p0, 0x20

    const/16 v1, 0x20

    if-ne v0, v1, :cond_1

    .line 433
    sget-object v0, Lorg/iharder/encoders/Base64;->_ORDERED_DECODABET:[B

    goto :goto_0

    .line 435
    :cond_1
    sget-object v0, Lorg/iharder/encoders/Base64;->_STANDARD_DECODABET:[B

    goto :goto_0
.end method
