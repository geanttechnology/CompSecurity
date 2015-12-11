.class public final Lcom/nostra13/universalimageloader/utils/L;
.super Ljava/lang/Object;
.source "L.java"


# static fields
.field private static final LOG_FORMAT:Ljava/lang/String; = "%1$s\n%2$s"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    return-void
.end method

.method public static varargs d(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 0
    .param p0, "message"    # Ljava/lang/String;
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 37
    return-void
.end method

.method public static varargs e(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 0
    .param p0, "message"    # Ljava/lang/String;
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 53
    return-void
.end method

.method public static e(Ljava/lang/Throwable;)V
    .locals 0
    .param p0, "ex"    # Ljava/lang/Throwable;

    .prologue
    .line 49
    return-void
.end method

.method public static varargs e(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 0
    .param p0, "ex"    # Ljava/lang/Throwable;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "args"    # [Ljava/lang/Object;

    .prologue
    .line 57
    return-void
.end method

.method public static varargs i(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 0
    .param p0, "message"    # Ljava/lang/String;
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 41
    return-void
.end method

.method private static varargs log(ILjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 6
    .param p0, "priority"    # I
    .param p1, "ex"    # Ljava/lang/Throwable;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "args"    # [Ljava/lang/Object;

    .prologue
    .line 60
    array-length v3, p3

    if-lez v3, :cond_0

    .line 61
    invoke-static {p2, p3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    .line 65
    :cond_0
    if-nez p1, :cond_1

    .line 66
    move-object v0, p2

    .line 73
    .local v0, "log":Ljava/lang/String;
    :goto_0
    return-void

    .line 68
    .end local v0    # "log":Ljava/lang/String;
    :cond_1
    if-nez p2, :cond_2

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v2

    .line 69
    .local v2, "logMessage":Ljava/lang/String;
    :goto_1
    invoke-static {p1}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v1

    .line 70
    .local v1, "logBody":Ljava/lang/String;
    const-string v3, "%1$s\n%2$s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v2, v4, v5

    const/4 v5, 0x1

    aput-object v1, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "log":Ljava/lang/String;
    goto :goto_0

    .end local v0    # "log":Ljava/lang/String;
    .end local v1    # "logBody":Ljava/lang/String;
    .end local v2    # "logMessage":Ljava/lang/String;
    :cond_2
    move-object v2, p2

    .line 68
    goto :goto_1
.end method

.method public static varargs w(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 0
    .param p0, "message"    # Ljava/lang/String;
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 45
    return-void
.end method
