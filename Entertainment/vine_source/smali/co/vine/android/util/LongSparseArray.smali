.class public Lco/vine/android/util/LongSparseArray;
.super Landroid/support/v4/util/LongSparseArray;
.source "LongSparseArray.java"

# interfaces
.implements Ljava/lang/Iterable;
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/util/LongSparseArray$SparseKeyIterator;,
        Lco/vine/android/util/LongSparseArray$SparseValueIterator;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/support/v4/util/LongSparseArray",
        "<TT;>;",
        "Ljava/lang/Iterable",
        "<",
        "Ljava/lang/Long;",
        ">;",
        "Ljava/io/Serializable;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    .local p0, "this":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<TT;>;"
    invoke-direct {p0}, Landroid/support/v4/util/LongSparseArray;-><init>()V

    .line 16
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "initialCapacity"    # I

    .prologue
    .line 19
    .local p0, "this":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<TT;>;"
    invoke-direct {p0, p1}, Landroid/support/v4/util/LongSparseArray;-><init>(I)V

    .line 20
    return-void
.end method


# virtual methods
.method public isEmpty()Z
    .locals 1

    .prologue
    .line 23
    .local p0, "this":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<TT;>;"
    invoke-virtual {p0}, Lco/vine/android/util/LongSparseArray;->size()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .prologue
    .line 45
    .local p0, "this":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<TT;>;"
    new-instance v0, Lco/vine/android/util/LongSparseArray$SparseKeyIterator;

    invoke-direct {v0, p0}, Lco/vine/android/util/LongSparseArray$SparseKeyIterator;-><init>(Lco/vine/android/util/LongSparseArray;)V

    return-object v0
.end method

.method public removeAll(Ljava/util/Collection;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 38
    .local p0, "this":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<TT;>;"
    .local p1, "keysToRemove":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/Long;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    .line 39
    .local v1, "key":Ljava/lang/Long;
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {p0, v2, v3}, Lco/vine/android/util/LongSparseArray;->delete(J)V

    goto :goto_0

    .line 41
    .end local v1    # "key":Ljava/lang/Long;
    :cond_0
    return-void
.end method

.method public removeKey(J)Ljava/lang/Object;
    .locals 1
    .param p1, "key"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J)TT;"
        }
    .end annotation

    .prologue
    .line 28
    .local p0, "this":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<TT;>;"
    invoke-virtual {p0, p1, p2}, Lco/vine/android/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v0

    .line 30
    .local v0, "value":Ljava/lang/Object;, "TT;"
    if-eqz v0, :cond_0

    .line 31
    invoke-super {p0, p1, p2}, Landroid/support/v4/util/LongSparseArray;->remove(J)V

    .line 34
    :cond_0
    return-object v0
.end method

.method public valueIterator()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 49
    .local p0, "this":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<TT;>;"
    new-instance v0, Lco/vine/android/util/LongSparseArray$SparseValueIterator;

    invoke-direct {v0, p0}, Lco/vine/android/util/LongSparseArray$SparseValueIterator;-><init>(Lco/vine/android/util/LongSparseArray;)V

    return-object v0
.end method
