.class public final Lcom/amazon/assertion/Assert;
.super Ljava/lang/Object;
.source "Assert.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 254
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 255
    return-void
.end method

.method public static varargs fail(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 3
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "formatArgs"    # [Ljava/lang/Object;

    .prologue
    .line 203
    new-instance v0, Lcom/amazon/assertion/AssertionException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ": "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/assertion/AssertionException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static isTrue(Ljava/lang/String;Z)V
    .locals 2
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "expression"    # Z

    .prologue
    .line 246
    if-nez p1, :cond_0

    .line 247
    const-string/jumbo v0, "not true"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {p0, v0, v1}, Lcom/amazon/assertion/Assert;->fail(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 249
    :cond_0
    return-void
.end method

.method public static notEmpty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 51
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 52
    :cond_0
    const-string/jumbo v0, "empty"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {p0, v0, v1}, Lcom/amazon/assertion/Assert;->fail(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 54
    :cond_1
    return-void
.end method

.method public static notEmpty(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 2
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "value"    # [Ljava/lang/Object;

    .prologue
    .line 216
    if-eqz p1, :cond_0

    array-length v0, p1

    if-nez v0, :cond_1

    .line 217
    :cond_0
    const-string/jumbo v0, "empty"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {p0, v0, v1}, Lcom/amazon/assertion/Assert;->fail(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 219
    :cond_1
    return-void
.end method

.method public static notNull(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 2
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 21
    if-nez p1, :cond_0

    .line 22
    const-string/jumbo v0, "null"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {p0, v0, v1}, Lcom/amazon/assertion/Assert;->fail(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 24
    :cond_0
    return-void
.end method
