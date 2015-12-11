.class public final enum Lcom/amazon/device/analytics/log/Logging$LogLevel;
.super Ljava/lang/Enum;
.source "Logging.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/analytics/log/Logging;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "LogLevel"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/device/analytics/log/Logging$LogLevel;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/device/analytics/log/Logging$LogLevel;

.field public static final enum DEBUG:Lcom/amazon/device/analytics/log/Logging$LogLevel;

.field public static final enum ERROR:Lcom/amazon/device/analytics/log/Logging$LogLevel;

.field public static final enum INFO:Lcom/amazon/device/analytics/log/Logging$LogLevel;

.field public static final enum OFF:Lcom/amazon/device/analytics/log/Logging$LogLevel;

.field public static final enum VERBOSE:Lcom/amazon/device/analytics/log/Logging$LogLevel;

.field public static final enum WARN:Lcom/amazon/device/analytics/log/Logging$LogLevel;

.field public static final enum WTF:Lcom/amazon/device/analytics/log/Logging$LogLevel;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 26
    new-instance v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;

    const-string/jumbo v1, "VERBOSE"

    invoke-direct {v0, v1, v3}, Lcom/amazon/device/analytics/log/Logging$LogLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;->VERBOSE:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .line 27
    new-instance v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;

    const-string/jumbo v1, "DEBUG"

    invoke-direct {v0, v1, v4}, Lcom/amazon/device/analytics/log/Logging$LogLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;->DEBUG:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .line 28
    new-instance v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;

    const-string/jumbo v1, "INFO"

    invoke-direct {v0, v1, v5}, Lcom/amazon/device/analytics/log/Logging$LogLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;->INFO:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .line 29
    new-instance v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;

    const-string/jumbo v1, "WARN"

    invoke-direct {v0, v1, v6}, Lcom/amazon/device/analytics/log/Logging$LogLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;->WARN:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .line 30
    new-instance v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;

    const-string/jumbo v1, "ERROR"

    invoke-direct {v0, v1, v7}, Lcom/amazon/device/analytics/log/Logging$LogLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;->ERROR:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .line 31
    new-instance v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;

    const-string/jumbo v1, "WTF"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/device/analytics/log/Logging$LogLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;->WTF:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .line 32
    new-instance v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;

    const-string/jumbo v1, "OFF"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/amazon/device/analytics/log/Logging$LogLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;->OFF:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .line 25
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/amazon/device/analytics/log/Logging$LogLevel;

    sget-object v1, Lcom/amazon/device/analytics/log/Logging$LogLevel;->VERBOSE:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/device/analytics/log/Logging$LogLevel;->DEBUG:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/device/analytics/log/Logging$LogLevel;->INFO:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/device/analytics/log/Logging$LogLevel;->WARN:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/device/analytics/log/Logging$LogLevel;->ERROR:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/device/analytics/log/Logging$LogLevel;->WTF:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/device/analytics/log/Logging$LogLevel;->OFF:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;->$VALUES:[Lcom/amazon/device/analytics/log/Logging$LogLevel;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/device/analytics/log/Logging$LogLevel;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 25
    const-class v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;

    return-object v0
.end method

.method public static values()[Lcom/amazon/device/analytics/log/Logging$LogLevel;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;->$VALUES:[Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {v0}, [Lcom/amazon/device/analytics/log/Logging$LogLevel;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/device/analytics/log/Logging$LogLevel;

    return-object v0
.end method
