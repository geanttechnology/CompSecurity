.class Lcom/poshmark/ui/customviews/PMListView$1;
.super Ljava/lang/Object;
.source "PMListView.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/PMListView;->setupScrollHandler()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMListView;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMListView;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMListView$1;->this$0:Lcom/poshmark/ui/customviews/PMListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 5
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 80
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView$1;->this$0:Lcom/poshmark/ui/customviews/PMListView;

    # getter for: Lcom/poshmark/ui/customviews/PMListView;->fetchingMoreItemsOnScroll:Z
    invoke-static {v1}, Lcom/poshmark/ui/customviews/PMListView;->access$000(Lcom/poshmark/ui/customviews/PMListView;)Z

    move-result v1

    if-nez v1, :cond_0

    if-le p4, v3, :cond_0

    add-int v1, p2, p3

    if-lt v1, p4, :cond_0

    .line 81
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView$1;->this$0:Lcom/poshmark/ui/customviews/PMListView;

    # setter for: Lcom/poshmark/ui/customviews/PMListView;->fetchingMoreItemsOnScroll:Z
    invoke-static {v1, v3}, Lcom/poshmark/ui/customviews/PMListView;->access$002(Lcom/poshmark/ui/customviews/PMListView;Z)Z

    .line 82
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView$1;->this$0:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/PMListView;->listData:Lcom/poshmark/data_model/models/PMData;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView$1;->this$0:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/PMListView;->listData:Lcom/poshmark/data_model/models/PMData;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMData;->getNextPageMaxValue()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 83
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView$1;->this$0:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMListView;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMListView$1;->this$0:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v2, v2, Lcom/poshmark/ui/customviews/PMListView;->footerView:Landroid/view/View;

    invoke-static {v1, v2}, Lcom/poshmark/utils/ViewUtils;->showLoadingProgress(Landroid/content/Context;Landroid/view/View;)V

    .line 85
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView$1;->this$0:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/PMListView;->loadMoreItemsListener:Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;

    if-eqz v1, :cond_0

    .line 86
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView$1;->this$0:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/PMListView;->loadMoreItemsListener:Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;

    invoke-interface {v1, v3}, Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;->loadItems(Z)V

    .line 96
    :cond_0
    :goto_0
    return-void

    .line 90
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView$1;->this$0:Lcom/poshmark/ui/customviews/PMListView;

    # setter for: Lcom/poshmark/ui/customviews/PMListView;->fetchingMoreItemsOnScroll:Z
    invoke-static {v1, v4}, Lcom/poshmark/ui/customviews/PMListView;->access$002(Lcom/poshmark/ui/customviews/PMListView;Z)Z

    .line 91
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView$1;->this$0:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/PMListView;->footerView:Landroid/view/View;

    const v2, 0x7f0c012d

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 92
    .local v0, "footerLayout":Landroid/widget/LinearLayout;
    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 93
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMListView$1;->this$0:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMListView;->getContext()Landroid/content/Context;

    move-result-object v1

    const/16 v2, 0xf

    invoke-static {v1, v0, v2, v4}, Lcom/poshmark/utils/ViewUtils;->addEmptyView(Landroid/content/Context;Landroid/view/ViewGroup;IZ)V

    goto :goto_0
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "i"    # I

    .prologue
    .line 103
    return-void
.end method
