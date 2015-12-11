.class public Lcom/amazon/ansel/fetch/log/AppLog;
.super Ljava/lang/Object;
.source "AppLog.java"


# static fields
.field private static logLevel:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    const/4 v0, 0x6

    sput v0, Lcom/amazon/ansel/fetch/log/AppLog;->logLevel:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static doLog(Ljava/lang/String;I)Z
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "level"    # I

    .prologue
    .line 80
    invoke-static {p0, p1}, Lcom/amazon/ansel/fetch/log/AppLog;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    return v0
.end method

.method public static isLoggable(Ljava/lang/String;I)Z
    .locals 2
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "level"    # I

    .prologue
    .line 76
    sget v0, Lcom/amazon/ansel/fetch/log/AppLog;->logLevel:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_1

    sget v0, Lcom/amazon/ansel/fetch/log/AppLog;->logLevel:I

    if-lt p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    invoke-static {p0, p1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    goto :goto_0
.end method

.method public static v(Ljava/lang/String;Ljava/lang/String;)I
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 20
    const/4 v0, 0x2

    invoke-static {p0, v0}, Lcom/amazon/ansel/fetch/log/AppLog;->doLog(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p0, p1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method
