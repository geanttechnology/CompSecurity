.class public final Lcom/tencent/mm/sdk/platformtools/Util;
.super Ljava/lang/Object;
.source "Util.java"


# static fields
.field private static final GMT:Ljava/util/TimeZone;

.field private static final INVALID:[C

.field private static final LIGHT_PATTERN:[J

.field private static final VALID:[Ljava/lang/String;

.field private static final VIRBRATOR_PATTERN:[J


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v1, 0x5

    const/4 v3, 0x4

    .line 489
    new-array v0, v3, [J

    fill-array-data v0, :array_0

    sput-object v0, Lcom/tencent/mm/sdk/platformtools/Util;->VIRBRATOR_PATTERN:[J

    .line 503
    new-array v0, v3, [J

    fill-array-data v0, :array_1

    sput-object v0, Lcom/tencent/mm/sdk/platformtools/Util;->LIGHT_PATTERN:[J

    .line 541
    const-string/jumbo v0, "GMT"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    sput-object v0, Lcom/tencent/mm/sdk/platformtools/Util;->GMT:Ljava/util/TimeZone;

    .line 1429
    new-array v0, v1, [C

    fill-array-data v0, :array_2

    sput-object v0, Lcom/tencent/mm/sdk/platformtools/Util;->INVALID:[C

    .line 1430
    new-array v0, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, "&lt;"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string/jumbo v2, "&gt;"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string/jumbo v2, "&quot;"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string/jumbo v2, "&apos;"

    aput-object v2, v0, v1

    const-string/jumbo v1, "&amp;"

    aput-object v1, v0, v3

    sput-object v0, Lcom/tencent/mm/sdk/platformtools/Util;->VALID:[Ljava/lang/String;

    return-void

    .line 489
    :array_0
    .array-data 8
        0x12c
        0xc8
        0x12c
        0xc8
    .end array-data

    .line 503
    :array_1
    .array-data 8
        0x12c
        0x32
        0x12c
        0x32
    .end array-data

    .line 1429
    :array_2
    .array-data 2
        0x3cs
        0x3es
        0x22s
        0x27s
        0x26s
    .end array-data
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 141
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 143
    return-void
.end method

.method public static isNullOrNil(Ljava/lang/String;)Z
    .locals 1
    .param p0, "object"    # Ljava/lang/String;

    .prologue
    .line 889
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-gtz v0, :cond_1

    .line 890
    :cond_0
    const/4 v0, 0x1

    .line 892
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
