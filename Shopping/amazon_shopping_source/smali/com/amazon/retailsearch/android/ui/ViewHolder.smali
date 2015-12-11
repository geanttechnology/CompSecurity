.class public Lcom/amazon/retailsearch/android/ui/ViewHolder;
.super Ljava/lang/Object;
.source "ViewHolder.java"


# static fields
.field private static final INITIAL_SIZE:I = 0x4


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static get(Landroid/view/View;I)Landroid/view/View;
    .locals 3
    .param p0, "view"    # Landroid/view/View;
    .param p1, "id"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Landroid/view/View;",
            ">(",
            "Landroid/view/View;",
            "I)TT;"
        }
    .end annotation

    .prologue
    .line 29
    sget v2, Lcom/amazon/retailsearch/R$id;->view_holder_sub_view:I

    invoke-virtual {p0, v2}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/util/SparseArray;

    .line 31
    .local v1, "viewHolder":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/view/View;>;"
    if-nez v1, :cond_0

    .line 32
    new-instance v1, Landroid/util/SparseArray;

    .end local v1    # "viewHolder":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/view/View;>;"
    const/4 v2, 0x4

    invoke-direct {v1, v2}, Landroid/util/SparseArray;-><init>(I)V

    .line 33
    .restart local v1    # "viewHolder":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/view/View;>;"
    sget v2, Lcom/amazon/retailsearch/R$id;->view_holder_sub_view:I

    invoke-virtual {p0, v2, v1}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    .line 36
    :cond_0
    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 38
    .local v0, "childView":Landroid/view/View;
    if-nez v0, :cond_1

    .line 39
    invoke-virtual {p0, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 40
    invoke-virtual {v1, p1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 43
    :cond_1
    return-object v0
.end method
