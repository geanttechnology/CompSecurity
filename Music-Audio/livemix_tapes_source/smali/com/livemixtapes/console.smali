.class public final Lcom/livemixtapes/console;
.super Ljava/lang/Object;
.source "console.java"


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    new-instance v0, Ljava/lang/RuntimeException;

    invoke-direct {v0}, Ljava/lang/RuntimeException;-><init>()V

    throw v0
.end method

.method public static log()V
    .locals 4

    .prologue
    .line 12
    const-string v0, "console"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "null"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/livemixtapes/console;->v(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 13
    return-void
.end method

.method public static varargs log([Ljava/lang/Object;)V
    .locals 1
    .param p0, "object"    # [Ljava/lang/Object;

    .prologue
    .line 16
    const-string v0, "console"

    invoke-static {v0, p0}, Lcom/livemixtapes/console;->v(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 17
    return-void
.end method

.method public static varargs v(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 6
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "object"    # [Ljava/lang/Object;

    .prologue
    const/4 v5, 0x1

    .line 20
    const-string v2, ""

    .line 22
    .local v2, "print":Ljava/lang/String;
    if-nez p0, :cond_0

    .line 23
    const-string p0, "console"

    .line 26
    :cond_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v3, p1

    if-lt v0, v3, :cond_2

    .line 41
    const-string v3, "console"

    invoke-virtual {v2, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 43
    const-string v3, "console"

    invoke-virtual {p0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 44
    invoke-virtual {v2, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {p0, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 46
    :cond_1
    return-void

    .line 27
    :cond_2
    aget-object v3, p1, v0

    if-eqz v3, :cond_4

    .line 28
    aget-object v3, p1, v0

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 30
    .local v1, "msg":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    if-nez v3, :cond_3

    .line 31
    const-string v1, " "

    .line 38
    :cond_3
    :goto_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 26
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 35
    .end local v1    # "msg":Ljava/lang/String;
    :cond_4
    const-string v1, "null"

    .restart local v1    # "msg":Ljava/lang/String;
    goto :goto_1
.end method
