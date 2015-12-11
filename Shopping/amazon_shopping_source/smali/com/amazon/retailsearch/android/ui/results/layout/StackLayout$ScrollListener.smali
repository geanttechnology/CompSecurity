.class Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;
.super Ljava/lang/Object;
.source "StackLayout.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ScrollListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)V
    .locals 0

    .prologue
    .line 1245
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$1;

    .prologue
    .line 1245
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 1
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    .line 1250
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->loaderScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;

    if-eqz v0, :cond_0

    .line 1251
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->loaderScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;->onScroll(Landroid/widget/AbsListView;III)V

    .line 1253
    :cond_0
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 3
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 1258
    if-eqz p1, :cond_0

    .line 1259
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {p1}, Landroid/widget/AbsListView;->getFirstVisiblePosition()I

    move-result v1

    invoke-virtual {p1}, Landroid/widget/AbsListView;->getLastVisiblePosition()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->loadAtBottom(II)V

    .line 1262
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->loaderScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;

    if-eqz v0, :cond_1

    .line 1263
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->loaderScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;->onScrollStateChanged(Landroid/widget/AbsListView;I)V

    .line 1265
    :cond_1
    return-void
.end method
