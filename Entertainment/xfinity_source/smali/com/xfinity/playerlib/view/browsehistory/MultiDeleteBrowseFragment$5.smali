.class Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$5;
.super Ljava/lang/Object;
.source "MultiDeleteBrowseFragment.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->setupListView(Landroid/widget/AbsListView;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    .prologue
    .line 218
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$5;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$5;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$5;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 0
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    .line 227
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$5;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$5;"
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 1
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 221
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$5;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$5;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$5;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    # setter for: Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->scrollState:I
    invoke-static {v0, p2}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->access$1002(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;I)I

    .line 222
    return-void
.end method
