.class Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$5;
.super Ljava/lang/Object;
.source "DownloadsFragment.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    .prologue
    .line 334
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$5;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

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
    .line 343
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 1
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 337
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$5;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    # setter for: Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->scrollState:I
    invoke-static {v0, p2}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->access$802(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;I)I

    .line 338
    return-void
.end method
