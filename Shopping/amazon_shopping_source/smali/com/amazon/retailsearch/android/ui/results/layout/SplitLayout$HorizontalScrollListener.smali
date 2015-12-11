.class Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$HorizontalScrollListener;
.super Ljava/lang/Object;
.source "SplitLayout.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/HorizontalListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "HorizontalScrollListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;)V
    .locals 0

    .prologue
    .line 249
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$HorizontalScrollListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$1;

    .prologue
    .line 249
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$HorizontalScrollListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;)V

    return-void
.end method


# virtual methods
.method public onScroll(Lcom/amazon/retailsearch/android/ui/HorizontalListView;III)V
    .locals 1
    .param p1, "view"    # Lcom/amazon/retailsearch/android/ui/HorizontalListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    .line 254
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$HorizontalScrollListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->loaderScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;

    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    .line 255
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$HorizontalScrollListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->loaderScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;->onScroll(Landroid/widget/AdapterView;III)V

    .line 257
    :cond_0
    return-void
.end method

.method public onScrollStateChanged(Lcom/amazon/retailsearch/android/ui/HorizontalListView;I)V
    .locals 3
    .param p1, "view"    # Lcom/amazon/retailsearch/android/ui/HorizontalListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 262
    if-eqz p1, :cond_0

    .line 263
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$HorizontalScrollListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getFirstVisiblePosition()I

    move-result v1

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getLastVisiblePosition()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->loadAtBottom(II)V

    .line 265
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$HorizontalScrollListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->loaderScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;

    if-eqz v0, :cond_0

    .line 266
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$HorizontalScrollListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->loaderScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;->onScrollStateChanged(Landroid/widget/AdapterView;I)V

    .line 269
    :cond_0
    return-void
.end method
