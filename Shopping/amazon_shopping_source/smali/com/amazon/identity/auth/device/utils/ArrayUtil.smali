.class public final Lcom/amazon/identity/auth/device/utils/ArrayUtil;
.super Ljava/lang/Object;
.source "ArrayUtil.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    return-void
.end method

.method public static varargs asSet([Ljava/lang/Object;)Ljava/util/Set;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;)",
            "Ljava/util/Set",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 30
    .local p0, "items":[Ljava/lang/Object;, "[TT;"
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 32
    .local v0, "set":Ljava/util/Set;, "Ljava/util/Set<TT;>;"
    invoke-static {p0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 34
    return-object v0
.end method

.method public static copyOf([II)[I
    .locals 4
    .param p0, "array"    # [I
    .param p1, "length"    # I

    .prologue
    .line 16
    new-array v2, p1, [I

    .line 18
    .local v2, "newArray":[I
    array-length v3, p0

    invoke-static {p1, v3}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 20
    .local v1, "itemsToCopy":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 22
    aget v3, p0, v0

    aput v3, v2, v0

    .line 20
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 25
    :cond_0
    return-object v2
.end method
