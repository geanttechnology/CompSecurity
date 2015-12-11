.class public Lcom/comcast/cim/utils/DebugUtil;
.super Ljava/lang/Object;
.source "DebugUtil.java"


# static fields
.field private static final CARP_LOG:Lorg/slf4j/Logger;

.field public static final DATE_FORMATTER:Lorg/apache/commons/lang3/time/FastDateFormat;

.field public static final DATE_FORMATTER_PRECISE:Lorg/apache/commons/lang3/time/FastDateFormat;

.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/comcast/cim/utils/DebugUtil;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/utils/DebugUtil;->LOG:Lorg/slf4j/Logger;

    .line 21
    const-string v0, "CARP"

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/String;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/utils/DebugUtil;->CARP_LOG:Lorg/slf4j/Logger;

    .line 23
    const-string v0, "MM-dd-yyyy hh:mm:ss a z"

    invoke-static {v0}, Lorg/apache/commons/lang3/time/FastDateFormat;->getInstance(Ljava/lang/String;)Lorg/apache/commons/lang3/time/FastDateFormat;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/utils/DebugUtil;->DATE_FORMATTER:Lorg/apache/commons/lang3/time/FastDateFormat;

    .line 24
    const-string v0, "MM-dd-yyyy hh:mm:ss.SSS a z"

    invoke-static {v0}, Lorg/apache/commons/lang3/time/FastDateFormat;->getInstance(Ljava/lang/String;)Lorg/apache/commons/lang3/time/FastDateFormat;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/utils/DebugUtil;->DATE_FORMATTER_PRECISE:Lorg/apache/commons/lang3/time/FastDateFormat;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static millisToDateString(J)Ljava/lang/String;
    .locals 2
    .param p0, "milliseconds"    # J

    .prologue
    .line 33
    sget-object v0, Lcom/comcast/cim/utils/DebugUtil;->DATE_FORMATTER:Lorg/apache/commons/lang3/time/FastDateFormat;

    invoke-static {p0, p1, v0}, Lcom/comcast/cim/utils/DebugUtil;->millisToDateString(JLorg/apache/commons/lang3/time/FastDateFormat;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static millisToDateString(JLorg/apache/commons/lang3/time/FastDateFormat;)Ljava/lang/String;
    .locals 2
    .param p0, "milliseconds"    # J
    .param p2, "dateFormat"    # Lorg/apache/commons/lang3/time/FastDateFormat;

    .prologue
    .line 44
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0, p0, p1}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {p2, v0}, Lorg/apache/commons/lang3/time/FastDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
