.class public Lco/vine/android/widget/ConversationList;
.super Lco/vine/android/views/SdkListView;
.source "ConversationList.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/ConversationList$GetMoreListener;
    }
.end annotation


# instance fields
.field private mGetMoreHeaderProgressContainer:Landroid/view/View;

.field private mGetMoreListener:Lco/vine/android/widget/ConversationList$GetMoreListener;

.field private mProgressView:Landroid/view/View;

.field private mScrollListener:Landroid/widget/AbsListView$OnScrollListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lco/vine/android/views/SdkListView;-><init>(Landroid/content/Context;)V

    .line 20
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Lco/vine/android/views/SdkListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 24
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 27
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/views/SdkListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 28
    return-void
.end method


# virtual methods
.method public deactivateRefresh()V
    .locals 1

    .prologue
    .line 82
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/widget/ConversationList;->deactivateRefresh(Z)V

    .line 83
    return-void
.end method

.method public deactivateRefresh(Z)V
    .locals 2
    .param p1, "permanently"    # Z

    .prologue
    .line 75
    iget-object v0, p0, Lco/vine/android/widget/ConversationList;->mProgressView:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 76
    if-eqz p1, :cond_0

    .line 77
    iget-object v0, p0, Lco/vine/android/widget/ConversationList;->mGetMoreHeaderProgressContainer:Landroid/view/View;

    invoke-virtual {p0, v0}, Lco/vine/android/widget/ConversationList;->removeHeaderView(Landroid/view/View;)Z

    .line 79
    :cond_0
    return-void
.end method

.method public hideProgress()V
    .locals 2

    .prologue
    .line 100
    iget-object v0, p0, Lco/vine/android/widget/ConversationList;->mProgressView:Landroid/view/View;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 101
    return-void
.end method

.method protected onFinishInflate()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 32
    invoke-super {p0}, Lco/vine/android/views/SdkListView;->onFinishInflate()V

    .line 33
    invoke-super {p0, p0}, Lco/vine/android/views/SdkListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 35
    invoke-virtual {p0}, Lco/vine/android/widget/ConversationList;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 36
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v1, 0x7f03002d

    invoke-virtual {v0, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/widget/ConversationList;->mGetMoreHeaderProgressContainer:Landroid/view/View;

    .line 37
    iget-object v1, p0, Lco/vine/android/widget/ConversationList;->mGetMoreHeaderProgressContainer:Landroid/view/View;

    const v2, 0x7f0a00b0

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/widget/ConversationList;->mProgressView:Landroid/view/View;

    .line 38
    iget-object v1, p0, Lco/vine/android/widget/ConversationList;->mGetMoreHeaderProgressContainer:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v3, v2}, Lco/vine/android/widget/ConversationList;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 39
    return-void
.end method

.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 3
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    .line 55
    if-nez p3, :cond_1

    .line 68
    :cond_0
    :goto_0
    return-void

    .line 59
    :cond_1
    iget-object v1, p0, Lco/vine/android/widget/ConversationList;->mGetMoreListener:Lco/vine/android/widget/ConversationList$GetMoreListener;

    if-eqz v1, :cond_2

    if-nez p2, :cond_2

    iget-object v1, p0, Lco/vine/android/widget/ConversationList;->mProgressView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getVisibility()I

    move-result v1

    const/16 v2, 0x8

    if-eq v1, v2, :cond_2

    .line 60
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lco/vine/android/widget/ConversationList;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 61
    .local v0, "child":Landroid/view/View;
    iget-object v1, p0, Lco/vine/android/widget/ConversationList;->mGetMoreHeaderProgressContainer:Landroid/view/View;

    if-ne v0, v1, :cond_2

    .line 62
    iget-object v1, p0, Lco/vine/android/widget/ConversationList;->mGetMoreListener:Lco/vine/android/widget/ConversationList$GetMoreListener;

    invoke-interface {v1}, Lco/vine/android/widget/ConversationList$GetMoreListener;->getMore()V

    .line 65
    .end local v0    # "child":Landroid/view/View;
    :cond_2
    iget-object v1, p0, Lco/vine/android/widget/ConversationList;->mScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    if-eqz v1, :cond_0

    .line 66
    iget-object v1, p0, Lco/vine/android/widget/ConversationList;->mScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    invoke-interface {v1, p1, p2, p3, p4}, Landroid/widget/AbsListView$OnScrollListener;->onScroll(Landroid/widget/AbsListView;III)V

    goto :goto_0
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 1
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 48
    iget-object v0, p0, Lco/vine/android/widget/ConversationList;->mScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    if-eqz v0, :cond_0

    .line 49
    iget-object v0, p0, Lco/vine/android/widget/ConversationList;->mScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    invoke-interface {v0, p1, p2}, Landroid/widget/AbsListView$OnScrollListener;->onScrollStateChanged(Landroid/widget/AbsListView;I)V

    .line 51
    :cond_0
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 1
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldW"    # I
    .param p4, "oldH"    # I

    .prologue
    .line 105
    invoke-super {p0, p1, p2, p3, p4}, Lco/vine/android/views/SdkListView;->onSizeChanged(IIII)V

    .line 106
    invoke-virtual {p0}, Lco/vine/android/widget/ConversationList;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 107
    invoke-virtual {p0}, Lco/vine/android/widget/ConversationList;->getCount()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {p0, v0}, Lco/vine/android/widget/ConversationList;->setSelection(I)V

    .line 109
    :cond_0
    return-void
.end method

.method public reactivateRefresh()V
    .locals 2

    .prologue
    .line 86
    iget-object v0, p0, Lco/vine/android/widget/ConversationList;->mProgressView:Landroid/view/View;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 87
    return-void
.end method

.method public setGetMoreListener(Lco/vine/android/widget/ConversationList$GetMoreListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/widget/ConversationList$GetMoreListener;

    .prologue
    .line 71
    iput-object p1, p0, Lco/vine/android/widget/ConversationList;->mGetMoreListener:Lco/vine/android/widget/ConversationList$GetMoreListener;

    .line 72
    return-void
.end method

.method public setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V
    .locals 0
    .param p1, "l"    # Landroid/widget/AbsListView$OnScrollListener;

    .prologue
    .line 43
    iput-object p1, p0, Lco/vine/android/widget/ConversationList;->mScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    .line 44
    return-void
.end method

.method public showProgress()V
    .locals 2

    .prologue
    .line 94
    iget-object v0, p0, Lco/vine/android/widget/ConversationList;->mProgressView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-eq v0, v1, :cond_0

    .line 95
    iget-object v0, p0, Lco/vine/android/widget/ConversationList;->mProgressView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 97
    :cond_0
    return-void
.end method
