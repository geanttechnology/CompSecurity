.class public final Lcom/amazon/retailsearch/util/Utils;
.super Ljava/lang/Object;
.source "Utils.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    return-void
.end method

.method public static final isEmpty(Ljava/util/Collection;)Z
    .locals 1
    .param p0, "collection"    # Ljava/util/Collection;

    .prologue
    .line 31
    if-eqz p0, :cond_0

    invoke-interface {p0}, Ljava/util/Collection;->size()I

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isEqual(Ljava/lang/Object;Ljava/lang/Object;)Z
    .locals 1
    .param p0, "a"    # Ljava/lang/Object;
    .param p1, "b"    # Ljava/lang/Object;

    .prologue
    .line 43
    if-eq p0, p1, :cond_0

    if-eqz p0, :cond_1

    invoke-virtual {p0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static final varargs isEqual([J)Z
    .locals 6
    .param p0, "longs"    # [J

    .prologue
    const/4 v1, 0x1

    .line 74
    if-eqz p0, :cond_0

    array-length v2, p0

    if-ge v2, v1, :cond_1

    .line 85
    :cond_0
    :goto_0
    return v1

    .line 78
    :cond_1
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    array-length v2, p0

    if-ge v0, v2, :cond_0

    .line 80
    add-int/lit8 v2, v0, -0x1

    aget-wide v2, p0, v2

    aget-wide v4, p0, v0

    cmp-long v2, v2, v4

    if-eqz v2, :cond_2

    .line 82
    const/4 v1, 0x0

    goto :goto_0

    .line 78
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static final varargs isEqual([Ljava/lang/String;)Z
    .locals 4
    .param p0, "strings"    # [Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    .line 53
    if-eqz p0, :cond_0

    array-length v2, p0

    if-ge v2, v1, :cond_1

    .line 64
    :cond_0
    :goto_0
    return v1

    .line 57
    :cond_1
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    array-length v2, p0

    if-ge v0, v2, :cond_0

    .line 59
    add-int/lit8 v2, v0, -0x1

    aget-object v2, p0, v2

    if-nez v2, :cond_3

    aget-object v2, p0, v0

    if-eqz v2, :cond_4

    .line 61
    :cond_2
    const/4 v1, 0x0

    goto :goto_0

    .line 59
    :cond_3
    add-int/lit8 v2, v0, -0x1

    aget-object v2, p0, v2

    aget-object v3, p0, v0

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 57
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method
