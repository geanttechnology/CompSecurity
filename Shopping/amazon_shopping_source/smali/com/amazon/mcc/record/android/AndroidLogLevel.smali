.class public final enum Lcom/amazon/mcc/record/android/AndroidLogLevel;
.super Ljava/lang/Enum;
.source "AndroidLogLevel.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mcc/record/android/AndroidLogLevel;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mcc/record/android/AndroidLogLevel;

.field public static final enum DEBUG:Lcom/amazon/mcc/record/android/AndroidLogLevel;

.field public static final enum DEBUG_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

.field public static final enum ERROR:Lcom/amazon/mcc/record/android/AndroidLogLevel;

.field public static final enum ERROR_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

.field public static final enum INFO:Lcom/amazon/mcc/record/android/AndroidLogLevel;

.field public static final enum INFO_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

.field public static final enum VERBOSE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

.field public static final enum VERBOSE_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

.field public static final enum WARNING:Lcom/amazon/mcc/record/android/AndroidLogLevel;

.field public static final enum WARNING_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

.field public static final enum WARNING_THROWABLE_NO_MESSAGE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

.field public static final enum WTF:Lcom/amazon/mcc/record/android/AndroidLogLevel;

.field public static final enum WTF_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

.field public static final enum WTF_THROWABLE_NO_MESSAGE:Lcom/amazon/mcc/record/android/AndroidLogLevel;


# instance fields
.field private final humanReadable:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 6
    new-instance v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    const-string/jumbo v1, "DEBUG"

    const-string/jumbo v2, "Debug"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/mcc/record/android/AndroidLogLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->DEBUG:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    .line 8
    new-instance v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    const-string/jumbo v1, "DEBUG_THROWABLE"

    const-string/jumbo v2, "Debug"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/mcc/record/android/AndroidLogLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->DEBUG_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    .line 10
    new-instance v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    const-string/jumbo v1, "ERROR"

    const-string/jumbo v2, "Error"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/mcc/record/android/AndroidLogLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->ERROR:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    .line 12
    new-instance v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    const-string/jumbo v1, "ERROR_THROWABLE"

    const-string/jumbo v2, "Error"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/mcc/record/android/AndroidLogLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->ERROR_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    .line 14
    new-instance v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    const-string/jumbo v1, "INFO"

    const-string/jumbo v2, "Info"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/mcc/record/android/AndroidLogLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->INFO:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    .line 16
    new-instance v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    const-string/jumbo v1, "INFO_THROWABLE"

    const/4 v2, 0x5

    const-string/jumbo v3, "Info"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mcc/record/android/AndroidLogLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->INFO_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    .line 18
    new-instance v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    const-string/jumbo v1, "VERBOSE"

    const/4 v2, 0x6

    const-string/jumbo v3, "Verbose"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mcc/record/android/AndroidLogLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->VERBOSE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    .line 20
    new-instance v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    const-string/jumbo v1, "VERBOSE_THROWABLE"

    const/4 v2, 0x7

    const-string/jumbo v3, "Verbose"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mcc/record/android/AndroidLogLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->VERBOSE_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    .line 22
    new-instance v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    const-string/jumbo v1, "WARNING"

    const/16 v2, 0x8

    const-string/jumbo v3, "Warning"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mcc/record/android/AndroidLogLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->WARNING:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    .line 24
    new-instance v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    const-string/jumbo v1, "WARNING_THROWABLE"

    const/16 v2, 0x9

    const-string/jumbo v3, "Warning"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mcc/record/android/AndroidLogLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->WARNING_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    .line 26
    new-instance v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    const-string/jumbo v1, "WARNING_THROWABLE_NO_MESSAGE"

    const/16 v2, 0xa

    const-string/jumbo v3, "Warning"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mcc/record/android/AndroidLogLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->WARNING_THROWABLE_NO_MESSAGE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    .line 28
    new-instance v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    const-string/jumbo v1, "WTF"

    const/16 v2, 0xb

    const-string/jumbo v3, "WTF?!"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mcc/record/android/AndroidLogLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->WTF:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    .line 30
    new-instance v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    const-string/jumbo v1, "WTF_THROWABLE"

    const/16 v2, 0xc

    const-string/jumbo v3, "WTF?!"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mcc/record/android/AndroidLogLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->WTF_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    .line 32
    new-instance v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    const-string/jumbo v1, "WTF_THROWABLE_NO_MESSAGE"

    const/16 v2, 0xd

    const-string/jumbo v3, "WTF?!"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mcc/record/android/AndroidLogLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->WTF_THROWABLE_NO_MESSAGE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    .line 4
    const/16 v0, 0xe

    new-array v0, v0, [Lcom/amazon/mcc/record/android/AndroidLogLevel;

    sget-object v1, Lcom/amazon/mcc/record/android/AndroidLogLevel;->DEBUG:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mcc/record/android/AndroidLogLevel;->DEBUG_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mcc/record/android/AndroidLogLevel;->ERROR:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/mcc/record/android/AndroidLogLevel;->ERROR_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/mcc/record/android/AndroidLogLevel;->INFO:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/mcc/record/android/AndroidLogLevel;->INFO_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/mcc/record/android/AndroidLogLevel;->VERBOSE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/mcc/record/android/AndroidLogLevel;->VERBOSE_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/mcc/record/android/AndroidLogLevel;->WARNING:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/mcc/record/android/AndroidLogLevel;->WARNING_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/mcc/record/android/AndroidLogLevel;->WARNING_THROWABLE_NO_MESSAGE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/mcc/record/android/AndroidLogLevel;->WTF:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/mcc/record/android/AndroidLogLevel;->WTF_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/mcc/record/android/AndroidLogLevel;->WTF_THROWABLE_NO_MESSAGE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->$VALUES:[Lcom/amazon/mcc/record/android/AndroidLogLevel;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "humanReadable"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 42
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 43
    iput-object p3, p0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->humanReadable:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mcc/record/android/AndroidLogLevel;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 4
    const-class v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mcc/record/android/AndroidLogLevel;
    .locals 1

    .prologue
    .line 4
    sget-object v0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->$VALUES:[Lcom/amazon/mcc/record/android/AndroidLogLevel;

    invoke-virtual {v0}, [Lcom/amazon/mcc/record/android/AndroidLogLevel;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mcc/record/android/AndroidLogLevel;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/mcc/record/android/AndroidLogLevel;->humanReadable:Ljava/lang/String;

    return-object v0
.end method
