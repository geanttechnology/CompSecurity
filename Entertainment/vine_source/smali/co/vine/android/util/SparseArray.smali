.class public Lco/vine/android/util/SparseArray;
.super Landroid/util/SparseArray;
.source "SparseArray.java"

# interfaces
.implements Ljava/lang/Iterable;
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/util/SparseArray$SparseKeyIterator;,
        Lco/vine/android/util/SparseArray$SparseValueIterator;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/util/SparseArray",
        "<TT;>;",
        "Ljava/lang/Iterable",
        "<",
        "Ljava/lang/Integer;",
        ">;",
        "Ljava/io/Serializable;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    .local p0, "this":Lco/vine/android/util/SparseArray;, "Lco/vine/android/util/SparseArray<TT;>;"
    invoke-direct {p0}, Landroid/util/SparseArray;-><init>()V

    .line 49
    return-void
.end method


# virtual methods
.method public iterator()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 15
    .local p0, "this":Lco/vine/android/util/SparseArray;, "Lco/vine/android/util/SparseArray<TT;>;"
    new-instance v0, Lco/vine/android/util/SparseArray$SparseKeyIterator;

    invoke-direct {v0, p0}, Lco/vine/android/util/SparseArray$SparseKeyIterator;-><init>(Lco/vine/android/util/SparseArray;)V

    return-object v0
.end method

.method public removeAll(Ljava/util/Collection;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 23
    .local p0, "this":Lco/vine/android/util/SparseArray;, "Lco/vine/android/util/SparseArray<TT;>;"
    .local p1, "keysToRemove":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/Integer;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    .line 24
    .local v1, "key":Ljava/lang/Integer;
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {p0, v2}, Lco/vine/android/util/SparseArray;->delete(I)V

    goto :goto_0

    .line 26
    .end local v1    # "key":Ljava/lang/Integer;
    :cond_0
    return-void
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
    .line 19
    .local p0, "this":Lco/vine/android/util/SparseArray;, "Lco/vine/android/util/SparseArray<TT;>;"
    new-instance v0, Lco/vine/android/util/SparseArray$SparseValueIterator;

    invoke-direct {v0, p0}, Lco/vine/android/util/SparseArray$SparseValueIterator;-><init>(Lco/vine/android/util/SparseArray;)V

    return-object v0
.end method
