.class Lcom/livemixtapes/CommentsActivity$4;
.super Ljava/lang/Object;
.source "CommentsActivity.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/CommentsActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/CommentsActivity;


# direct methods
.method constructor <init>(Lcom/livemixtapes/CommentsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/CommentsActivity$4;->this$0:Lcom/livemixtapes/CommentsActivity;

    .line 146
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 4
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    const/4 v3, 0x1

    .line 154
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity$4;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-boolean v0, v0, Lcom/livemixtapes/CommentsActivity;->stop_loading:Z

    if-eqz v0, :cond_1

    .line 163
    :cond_0
    :goto_0
    return-void

    .line 156
    :cond_1
    add-int v0, p2, p3

    if-ne v0, p4, :cond_0

    .line 157
    if-eqz p4, :cond_0

    .line 158
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity$4;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-boolean v0, v0, Lcom/livemixtapes/CommentsActivity;->flag_loading:Z

    if-nez v0, :cond_0

    .line 159
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity$4;->this$0:Lcom/livemixtapes/CommentsActivity;

    iput-boolean v3, v0, Lcom/livemixtapes/CommentsActivity;->flag_loading:Z

    .line 160
    new-instance v0, Lcom/livemixtapes/CommentsActivity$JSONParse;

    iget-object v1, p0, Lcom/livemixtapes/CommentsActivity$4;->this$0:Lcom/livemixtapes/CommentsActivity;

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/livemixtapes/CommentsActivity$JSONParse;-><init>(Lcom/livemixtapes/CommentsActivity;Lcom/livemixtapes/CommentsActivity$JSONParse;)V

    new-array v1, v3, [Ljava/lang/String;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/livemixtapes/CommentsActivity$4;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-object v3, v3, Lcom/livemixtapes/CommentsActivity;->lastSavedCommentTimestamp:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/livemixtapes/CommentsActivity$JSONParse;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 149
    return-void
.end method
