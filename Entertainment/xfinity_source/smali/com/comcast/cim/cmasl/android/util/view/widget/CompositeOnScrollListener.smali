.class public Lcom/comcast/cim/cmasl/android/util/view/widget/CompositeOnScrollListener;
.super Ljava/lang/Object;
.source "CompositeOnScrollListener.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# instance fields
.field private listeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/widget/AbsListView$OnScrollListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/CompositeOnScrollListener;->listeners:Ljava/util/List;

    .line 13
    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 3
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "i"    # I
    .param p3, "i1"    # I
    .param p4, "i2"    # I

    .prologue
    .line 26
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/CompositeOnScrollListener;->listeners:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/widget/AbsListView$OnScrollListener;

    .line 27
    .local v1, "listener":Landroid/widget/AbsListView$OnScrollListener;
    invoke-interface {v1, p1, p2, p3, p4}, Landroid/widget/AbsListView$OnScrollListener;->onScroll(Landroid/widget/AbsListView;III)V

    goto :goto_0

    .line 29
    .end local v1    # "listener":Landroid/widget/AbsListView$OnScrollListener;
    :cond_0
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 3
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "i"    # I

    .prologue
    .line 20
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/CompositeOnScrollListener;->listeners:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/widget/AbsListView$OnScrollListener;

    .line 21
    .local v1, "listener":Landroid/widget/AbsListView$OnScrollListener;
    invoke-interface {v1, p1, p2}, Landroid/widget/AbsListView$OnScrollListener;->onScrollStateChanged(Landroid/widget/AbsListView;I)V

    goto :goto_0

    .line 23
    .end local v1    # "listener":Landroid/widget/AbsListView$OnScrollListener;
    :cond_0
    return-void
.end method
