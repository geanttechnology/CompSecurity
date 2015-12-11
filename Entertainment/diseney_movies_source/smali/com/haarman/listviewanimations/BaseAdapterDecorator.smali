.class public abstract Lcom/haarman/listviewanimations/BaseAdapterDecorator;
.super Landroid/widget/BaseAdapter;
.source "BaseAdapterDecorator.java"


# instance fields
.field protected final mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

.field private mListView:Landroid/widget/ListView;


# direct methods
.method public constructor <init>(Landroid/widget/BaseAdapter;)V
    .locals 0
    .param p1, "baseAdapter"    # Landroid/widget/BaseAdapter;

    .prologue
    .line 37
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 38
    iput-object p1, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    .line 39
    return-void
.end method


# virtual methods
.method public areAllItemsEnabled()Z
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->areAllItemsEnabled()Z

    move-result v0

    return v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->getCount()I

    move-result v0

    return v0
.end method

.method public getDecoratedBaseAdapter()Landroid/widget/BaseAdapter;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    return-object v0
.end method

.method public getDropDownView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0, p1, p2, p3}, Landroid/widget/BaseAdapter;->getDropDownView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 60
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0, p1}, Landroid/widget/BaseAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 65
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0, p1}, Landroid/widget/BaseAdapter;->getItemId(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getItemViewType(I)I
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 85
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0, p1}, Landroid/widget/BaseAdapter;->getItemViewType(I)I

    move-result v0

    return v0
.end method

.method public getListView()Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mListView:Landroid/widget/ListView;

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0, p1, p2, p3}, Landroid/widget/BaseAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->getViewTypeCount()I

    move-result v0

    return v0
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->hasStableIds()Z

    move-result v0

    return v0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public isEnabled(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 105
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0, p1}, Landroid/widget/BaseAdapter;->isEnabled(I)Z

    move-result v0

    return v0
.end method

.method public notifyDataSetChanged()V
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    .line 111
    return-void
.end method

.method public notifyDataSetInvalidated()V
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->notifyDataSetInvalidated()V

    .line 116
    return-void
.end method

.method public registerDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 120
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0, p1}, Landroid/widget/BaseAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 121
    return-void
.end method

.method public setListView(Landroid/widget/ListView;)V
    .locals 1
    .param p1, "listView"    # Landroid/widget/ListView;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mListView:Landroid/widget/ListView;

    .line 44
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    instance-of v0, v0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    check-cast v0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;

    invoke-virtual {v0, p1}, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->setListView(Landroid/widget/ListView;)V

    .line 47
    :cond_0
    return-void
.end method

.method public unregisterDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 125
    iget-object v0, p0, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->mDecoratedBaseAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v0, p1}, Landroid/widget/BaseAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 126
    return-void
.end method
