.class public final Lcom/amazon/dcp/framework/StringUtils;
.super Ljava/lang/Object;
.source "StringUtils.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    return-void
.end method

.method public static varargs equalsAny(Ljava/lang/String;[Ljava/lang/String;)Z
    .locals 5
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "candidates"    # [Ljava/lang/String;

    .prologue
    .line 83
    move-object v0, p1

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_3

    aget-object v1, v0, v2

    .line 85
    .local v1, "candidate":Ljava/lang/String;
    if-eqz p0, :cond_0

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    :cond_0
    if-nez p0, :cond_2

    if-nez v1, :cond_2

    .line 87
    :cond_1
    const/4 v4, 0x1

    .line 91
    .end local v1    # "candidate":Ljava/lang/String;
    :goto_1
    return v4

    .line 83
    .restart local v1    # "candidate":Ljava/lang/String;
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 91
    .end local v1    # "candidate":Ljava/lang/String;
    :cond_3
    const/4 v4, 0x0

    goto :goto_1
.end method
