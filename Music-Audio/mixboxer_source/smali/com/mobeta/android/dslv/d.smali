.class public Lcom/mobeta/android/dslv/d;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:Landroid/util/SparseIntArray;

.field private b:Ljava/util/ArrayList;

.field private c:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Lcom/mobeta/android/dslv/DragSortListView;I)V
    .locals 2

    .prologue
    const/4 v1, 0x3

    .line 857
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 858
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0, v1}, Landroid/util/SparseIntArray;-><init>(I)V

    iput-object v0, p0, Lcom/mobeta/android/dslv/d;->a:Landroid/util/SparseIntArray;

    .line 859
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/mobeta/android/dslv/d;->b:Ljava/util/ArrayList;

    .line 860
    iput v1, p0, Lcom/mobeta/android/dslv/d;->c:I

    .line 861
    return-void
.end method


# virtual methods
.method public final a(I)I
    .locals 2

    .prologue
    .line 884
    iget-object v0, p0, Lcom/mobeta/android/dslv/d;->a:Landroid/util/SparseIntArray;

    const/4 v1, -0x1

    invoke-virtual {v0, p1, v1}, Landroid/util/SparseIntArray;->get(II)I

    move-result v0

    return v0
.end method

.method public final a()V
    .locals 1

    .prologue
    .line 888
    iget-object v0, p0, Lcom/mobeta/android/dslv/d;->a:Landroid/util/SparseIntArray;

    invoke-virtual {v0}, Landroid/util/SparseIntArray;->clear()V

    .line 889
    iget-object v0, p0, Lcom/mobeta/android/dslv/d;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 890
    return-void
.end method

.method public final a(II)V
    .locals 3

    .prologue
    const/4 v1, -0x1

    .line 867
    iget-object v0, p0, Lcom/mobeta/android/dslv/d;->a:Landroid/util/SparseIntArray;

    invoke-virtual {v0, p1, v1}, Landroid/util/SparseIntArray;->get(II)I

    move-result v0

    .line 868
    if-eq v0, p2, :cond_1

    .line 869
    if-ne v0, v1, :cond_2

    .line 870
    iget-object v0, p0, Lcom/mobeta/android/dslv/d;->a:Landroid/util/SparseIntArray;

    invoke-virtual {v0}, Landroid/util/SparseIntArray;->size()I

    move-result v0

    iget v1, p0, Lcom/mobeta/android/dslv/d;->c:I

    if-ne v0, v1, :cond_0

    .line 872
    iget-object v1, p0, Lcom/mobeta/android/dslv/d;->a:Landroid/util/SparseIntArray;

    iget-object v0, p0, Lcom/mobeta/android/dslv/d;->b:Ljava/util/ArrayList;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/util/SparseIntArray;->delete(I)V

    .line 878
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/mobeta/android/dslv/d;->a:Landroid/util/SparseIntArray;

    invoke-virtual {v0, p1, p2}, Landroid/util/SparseIntArray;->put(II)V

    .line 879
    iget-object v0, p0, Lcom/mobeta/android/dslv/d;->b:Ljava/util/ArrayList;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 881
    :cond_1
    return-void

    .line 876
    :cond_2
    iget-object v0, p0, Lcom/mobeta/android/dslv/d;->b:Ljava/util/ArrayList;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_0
.end method
