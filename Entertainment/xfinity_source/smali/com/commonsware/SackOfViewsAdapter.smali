.class public Lcom/commonsware/SackOfViewsAdapter;
.super Landroid/widget/BaseAdapter;
.source "SackOfViewsAdapter.java"


# instance fields
.field private views:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/view/View;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 76
    .local p1, "views":Ljava/util/List;, "Ljava/util/List<Landroid/view/View;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 50
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/commonsware/SackOfViewsAdapter;->views:Ljava/util/List;

    .line 78
    iput-object p1, p0, Lcom/commonsware/SackOfViewsAdapter;->views:Ljava/util/List;

    .line 79
    return-void
.end method


# virtual methods
.method public areAllItemsEnabled()Z
    .locals 1

    .prologue
    .line 125
    const/4 v0, 0x0

    return v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/commonsware/SackOfViewsAdapter;->views:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 88
    iget-object v0, p0, Lcom/commonsware/SackOfViewsAdapter;->views:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 166
    int-to-long v0, p1

    return-wide v0
.end method

.method public getItemViewType(I)I
    .locals 0
    .param p1, "position"    # I

    .prologue
    .line 116
    return p1
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 2
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 149
    iget-object v1, p0, Lcom/commonsware/SackOfViewsAdapter;->views:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 151
    .local v0, "result":Landroid/view/View;
    if-nez v0, :cond_0

    .line 152
    invoke-virtual {p0, p1, p3}, Lcom/commonsware/SackOfViewsAdapter;->newView(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 153
    iget-object v1, p0, Lcom/commonsware/SackOfViewsAdapter;->views:Ljava/util/List;

    invoke-interface {v1, p1, v0}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 156
    :cond_0
    return-object v0
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 105
    invoke-virtual {p0}, Lcom/commonsware/SackOfViewsAdapter;->getCount()I

    move-result v0

    return v0
.end method

.method public isEnabled(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 136
    const/4 v0, 0x0

    return v0
.end method

.method protected newView(ILandroid/view/ViewGroup;)Landroid/view/View;
    .locals 2
    .param p1, "position"    # I
    .param p2, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 178
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "You must override newView()!"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
