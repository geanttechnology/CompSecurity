.class public abstract Lcom/haarman/listviewanimations/ArrayAdapter;
.super Landroid/widget/BaseAdapter;
.source "ArrayAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/widget/BaseAdapter;"
    }
.end annotation


# instance fields
.field private mItems:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 35
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/haarman/listviewanimations/ArrayAdapter;-><init>(Ljava/util/ArrayList;)V

    .line 36
    return-void
.end method

.method public constructor <init>(Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 42
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    .local p1, "items":Ljava/util/ArrayList;, "Ljava/util/ArrayList<TT;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 43
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    .line 44
    if-eqz p1, :cond_0

    .line 45
    iget-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 47
    :cond_0
    return-void
.end method


# virtual methods
.method public add(ILjava/lang/Object;)V
    .locals 1
    .param p1, "position"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ITT;)V"
        }
    .end annotation

    .prologue
    .line 76
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    .local p2, "item":Ljava/lang/Object;, "TT;"
    iget-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v0, p1, p2}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 77
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/ArrayAdapter;->notifyDataSetChanged()V

    .line 78
    return-void
.end method

.method public add(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 68
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    .local p1, "item":Ljava/lang/Object;, "TT;"
    iget-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 69
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/ArrayAdapter;->notifyDataSetChanged()V

    .line 70
    return-void
.end method

.method public addAll(ILjava/util/Collection;)V
    .locals 1
    .param p1, "position"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection",
            "<+TT;>;)V"
        }
    .end annotation

    .prologue
    .line 104
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    .local p2, "items":Ljava/util/Collection;, "Ljava/util/Collection<+TT;>;"
    iget-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v0, p1, p2}, Ljava/util/ArrayList;->addAll(ILjava/util/Collection;)Z

    .line 105
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/ArrayAdapter;->notifyDataSetChanged()V

    .line 106
    return-void
.end method

.method public varargs addAll(I[Ljava/lang/Object;)V
    .locals 3
    .param p1, "position"    # I
    .param p2, "items"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I[TT;)V"
        }
    .end annotation

    .prologue
    .line 113
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    move v0, p1

    .local v0, "i":I
    :goto_0
    array-length v1, p2

    add-int/2addr v1, p1

    if-lt v0, v1, :cond_0

    .line 116
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/ArrayAdapter;->notifyDataSetChanged()V

    .line 117
    return-void

    .line 114
    :cond_0
    iget-object v1, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    aget-object v2, p2, v0

    invoke-virtual {v1, v0, v2}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 113
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public addAll(Ljava/util/Collection;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<+TT;>;)V"
        }
    .end annotation

    .prologue
    .line 86
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    .local p1, "items":Ljava/util/Collection;, "Ljava/util/Collection<+TT;>;"
    iget-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 87
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/ArrayAdapter;->notifyDataSetChanged()V

    .line 88
    return-void
.end method

.method public varargs addAll([Ljava/lang/Object;)V
    .locals 1
    .param p1, "items"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TT;)V"
        }
    .end annotation

    .prologue
    .line 95
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    iget-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-static {v0, p1}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    .line 96
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/ArrayAdapter;->notifyDataSetChanged()V

    .line 97
    return-void
.end method

.method public clear()V
    .locals 1

    .prologue
    .line 123
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    iget-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 124
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/ArrayAdapter;->notifyDataSetChanged()V

    .line 125
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 51
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    iget-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TT;"
        }
    .end annotation

    .prologue
    .line 56
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    iget-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 61
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    int-to-long v0, p1

    return-wide v0
.end method

.method public indexOf(Ljava/lang/Object;)I
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)I"
        }
    .end annotation

    .prologue
    .line 191
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    .local p1, "item":Ljava/lang/Object;, "TT;"
    iget-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public remove(I)V
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 148
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    iget-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 149
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/ArrayAdapter;->notifyDataSetChanged()V

    .line 150
    return-void
.end method

.method public remove(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 140
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    .local p1, "item":Ljava/lang/Object;, "TT;"
    iget-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 141
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/ArrayAdapter;->notifyDataSetChanged()V

    .line 142
    return-void
.end method

.method public removeAll(Ljava/util/Collection;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 170
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    .local p1, "items":Ljava/util/Collection;, "Ljava/util/Collection<TT;>;"
    iget-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->removeAll(Ljava/util/Collection;)Z

    .line 171
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/ArrayAdapter;->notifyDataSetChanged()V

    .line 172
    return-void
.end method

.method public removePositions(Ljava/util/Collection;)V
    .locals 4
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
    .line 156
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    .local p1, "positions":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/Integer;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 157
    .local v1, "positionsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    invoke-static {v1}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 158
    invoke-static {v1}, Ljava/util/Collections;->reverse(Ljava/util/List;)V

    .line 159
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_0

    .line 162
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/ArrayAdapter;->notifyDataSetChanged()V

    .line 163
    return-void

    .line 159
    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 160
    .local v0, "position":I
    iget-object v2, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    goto :goto_0
.end method

.method public retainAll(Ljava/util/Collection;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 179
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    .local p1, "items":Ljava/util/Collection;, "Ljava/util/Collection<TT;>;"
    iget-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->retainAll(Ljava/util/Collection;)Z

    .line 180
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/ArrayAdapter;->notifyDataSetChanged()V

    .line 181
    return-void
.end method

.method public set(ILjava/lang/Object;)V
    .locals 1
    .param p1, "position"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ITT;)V"
        }
    .end annotation

    .prologue
    .line 132
    .local p0, "this":Lcom/haarman/listviewanimations/ArrayAdapter;, "Lcom/haarman/listviewanimations/ArrayAdapter<TT;>;"
    .local p2, "item":Ljava/lang/Object;, "TT;"
    iget-object v0, p0, Lcom/haarman/listviewanimations/ArrayAdapter;->mItems:Ljava/util/ArrayList;

    invoke-virtual {v0, p1, p2}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 133
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/ArrayAdapter;->notifyDataSetChanged()V

    .line 134
    return-void
.end method
