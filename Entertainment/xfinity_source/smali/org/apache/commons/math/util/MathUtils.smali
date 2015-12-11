.class public final Lorg/apache/commons/math/util/MathUtils;
.super Ljava/lang/Object;
.source "MathUtils.java"


# static fields
.field static final synthetic $assertionsDisabled:Z

.field private static final factorials:[J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lorg/apache/commons/math/util/MathUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lorg/apache/commons/math/util/MathUtils;->$assertionsDisabled:Z

    .line 473
    const/16 v0, 0x15

    new-array v0, v0, [J

    fill-array-data v0, :array_0

    sput-object v0, Lorg/apache/commons/math/util/MathUtils;->factorials:[J

    return-void

    .line 30
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 473
    nop

    :array_0
    .array-data 8
        0x1
        0x1
        0x2
        0x6
        0x18
        0x78
        0x2d0
        0x13b0
        0x9d80
        0x58980
        0x375f00
        0x2611500
        0x1c8cfc00
        0x17328cc00L
        0x144c3b2800L
        0x13077775800L
        0x130777758000L
        0x1437eeecd8000L
        0x16beecca730000L
        0x1b02b9306890000L
        0x21c3677c82b40000L
    .end array-data
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 72
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    return-void
.end method

.method public static pow(II)I
    .locals 6
    .param p0, "k"    # I
    .param p1, "e"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 1315
    if-gez p1, :cond_0

    .line 1316
    const-string v2, "cannot raise an integral value to a negative power ({0}^{1})"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Lorg/apache/commons/math/MathRuntimeException;->createIllegalArgumentException(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/IllegalArgumentException;

    move-result-object v2

    throw v2

    .line 1321
    :cond_0
    const/4 v1, 0x1

    .line 1322
    .local v1, "result":I
    move v0, p0

    .line 1323
    .local v0, "k2p":I
    :goto_0
    if-eqz p1, :cond_2

    .line 1324
    and-int/lit8 v2, p1, 0x1

    if-eqz v2, :cond_1

    .line 1325
    mul-int/2addr v1, v0

    .line 1327
    :cond_1
    mul-int/2addr v0, v0

    .line 1328
    shr-int/lit8 p1, p1, 0x1

    goto :goto_0

    .line 1331
    :cond_2
    return v1
.end method
