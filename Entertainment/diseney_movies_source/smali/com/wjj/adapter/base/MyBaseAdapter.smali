.class public abstract Lcom/wjj/adapter/base/MyBaseAdapter;
.super Landroid/widget/BaseAdapter;
.source "MyBaseAdapter.java"


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
.field protected inflater:Landroid/view/LayoutInflater;

.field protected list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 15
    .local p0, "this":Lcom/wjj/adapter/base/MyBaseAdapter;, "Lcom/wjj/adapter/base/MyBaseAdapter<TT;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 16
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/wjj/adapter/base/MyBaseAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 17
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wjj/adapter/base/MyBaseAdapter;->list:Ljava/util/List;

    .line 18
    return-void
.end method


# virtual methods
.method public abstract MygetView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end method

.method public addData(Ljava/util/List;Z)V
    .locals 1
    .param p2, "isClearOld"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TT;>;Z)V"
        }
    .end annotation

    .prologue
    .line 21
    .local p0, "this":Lcom/wjj/adapter/base/MyBaseAdapter;, "Lcom/wjj/adapter/base/MyBaseAdapter<TT;>;"
    .local p1, "data":Ljava/util/List;, "Ljava/util/List<TT;>;"
    if-eqz p2, :cond_0

    .line 22
    iget-object v0, p0, Lcom/wjj/adapter/base/MyBaseAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 24
    :cond_0
    iget-object v0, p0, Lcom/wjj/adapter/base/MyBaseAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 25
    return-void
.end method

.method public addDataToTop(Ljava/util/List;Z)V
    .locals 2
    .param p2, "isClearOld"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TT;>;Z)V"
        }
    .end annotation

    .prologue
    .line 28
    .local p0, "this":Lcom/wjj/adapter/base/MyBaseAdapter;, "Lcom/wjj/adapter/base/MyBaseAdapter<TT;>;"
    .local p1, "data":Ljava/util/List;, "Ljava/util/List<TT;>;"
    if-eqz p2, :cond_0

    .line 29
    iget-object v0, p0, Lcom/wjj/adapter/base/MyBaseAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 31
    :cond_0
    iget-object v0, p0, Lcom/wjj/adapter/base/MyBaseAdapter;->list:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1, p1}, Ljava/util/List;->addAll(ILjava/util/Collection;)Z

    .line 32
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 39
    .local p0, "this":Lcom/wjj/adapter/base/MyBaseAdapter;, "Lcom/wjj/adapter/base/MyBaseAdapter<TT;>;"
    iget-object v0, p0, Lcom/wjj/adapter/base/MyBaseAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getData()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 35
    .local p0, "this":Lcom/wjj/adapter/base/MyBaseAdapter;, "Lcom/wjj/adapter/base/MyBaseAdapter<TT;>;"
    iget-object v0, p0, Lcom/wjj/adapter/base/MyBaseAdapter;->list:Ljava/util/List;

    return-object v0
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
    .line 44
    .local p0, "this":Lcom/wjj/adapter/base/MyBaseAdapter;, "Lcom/wjj/adapter/base/MyBaseAdapter<TT;>;"
    iget-object v0, p0, Lcom/wjj/adapter/base/MyBaseAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 49
    .local p0, "this":Lcom/wjj/adapter/base/MyBaseAdapter;, "Lcom/wjj/adapter/base/MyBaseAdapter<TT;>;"
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 54
    .local p0, "this":Lcom/wjj/adapter/base/MyBaseAdapter;, "Lcom/wjj/adapter/base/MyBaseAdapter<TT;>;"
    invoke-virtual {p0, p1, p2, p3}, Lcom/wjj/adapter/base/MyBaseAdapter;->MygetView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method
