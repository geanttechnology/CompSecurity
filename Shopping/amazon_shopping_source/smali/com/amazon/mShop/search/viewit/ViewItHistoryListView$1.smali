.class Lcom/amazon/mShop/search/viewit/ViewItHistoryListView$1;
.super Ljava/lang/Object;
.source "ViewItHistoryListView.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;)V
    .locals 0

    .prologue
    .line 17
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 1
    .param p1, "arg0"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "arg2"    # I
    .param p4, "arg3"    # I

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;

    # setter for: Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->mFirstItemIndex:I
    invoke-static {v0, p2}, Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;->access$002(Lcom/amazon/mShop/search/viewit/ViewItHistoryListView;I)I

    .line 22
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 27
    return-void
.end method
