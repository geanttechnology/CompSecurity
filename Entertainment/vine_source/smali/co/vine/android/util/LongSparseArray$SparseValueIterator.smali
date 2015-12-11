.class public Lco/vine/android/util/LongSparseArray$SparseValueIterator;
.super Ljava/lang/Object;
.source "LongSparseArray.java"

# interfaces
.implements Ljava/util/Iterator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/LongSparseArray;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "SparseValueIterator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Iterator",
        "<TT;>;"
    }
.end annotation


# instance fields
.field public index:I

.field final synthetic this$0:Lco/vine/android/util/LongSparseArray;


# direct methods
.method public constructor <init>(Lco/vine/android/util/LongSparseArray;)V
    .locals 0

    .prologue
    .line 52
    .local p0, "this":Lco/vine/android/util/LongSparseArray$SparseValueIterator;, "Lco/vine/android/util/LongSparseArray<TT;>.SparseValueIterator;"
    iput-object p1, p0, Lco/vine/android/util/LongSparseArray$SparseValueIterator;->this$0:Lco/vine/android/util/LongSparseArray;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public hasNext()Z
    .locals 2

    .prologue
    .line 58
    .local p0, "this":Lco/vine/android/util/LongSparseArray$SparseValueIterator;, "Lco/vine/android/util/LongSparseArray<TT;>.SparseValueIterator;"
    iget v0, p0, Lco/vine/android/util/LongSparseArray$SparseValueIterator;->index:I

    iget-object v1, p0, Lco/vine/android/util/LongSparseArray$SparseValueIterator;->this$0:Lco/vine/android/util/LongSparseArray;

    invoke-virtual {v1}, Lco/vine/android/util/LongSparseArray;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public next()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 63
    .local p0, "this":Lco/vine/android/util/LongSparseArray$SparseValueIterator;, "Lco/vine/android/util/LongSparseArray<TT;>.SparseValueIterator;"
    iget v0, p0, Lco/vine/android/util/LongSparseArray$SparseValueIterator;->index:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lco/vine/android/util/LongSparseArray$SparseValueIterator;->index:I

    .line 64
    iget-object v0, p0, Lco/vine/android/util/LongSparseArray$SparseValueIterator;->this$0:Lco/vine/android/util/LongSparseArray;

    iget v1, p0, Lco/vine/android/util/LongSparseArray$SparseValueIterator;->index:I

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1}, Lco/vine/android/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public remove()V
    .locals 1

    .prologue
    .line 69
    .local p0, "this":Lco/vine/android/util/LongSparseArray$SparseValueIterator;, "Lco/vine/android/util/LongSparseArray<TT;>.SparseValueIterator;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method
