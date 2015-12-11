.class Lco/vine/android/InboxFragment$2;
.super Ljava/lang/Object;
.source "InboxFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/InboxFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/InboxFragment;


# direct methods
.method constructor <init>(Lco/vine/android/InboxFragment;)V
    .locals 0

    .prologue
    .line 188
    iput-object p1, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 191
    iget-object v0, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mActiveAdapter:Landroid/widget/BaseAdapter;
    invoke-static {v0}, Lco/vine/android/InboxFragment;->access$100(Lco/vine/android/InboxFragment;)Landroid/widget/BaseAdapter;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;
    invoke-static {v1}, Lco/vine/android/InboxFragment;->access$200(Lco/vine/android/InboxFragment;)Lco/vine/android/widget/SectionAdapter;

    move-result-object v1

    if-ne v0, v1, :cond_2

    .line 192
    iget-object v0, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mInboxCursorCount:I
    invoke-static {v0}, Lco/vine/android/InboxFragment;->access$300(Lco/vine/android/InboxFragment;)I

    move-result v0

    if-nez v0, :cond_1

    .line 193
    iget-object v0, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mIsEmptyViewAdded:Z
    invoke-static {v0}, Lco/vine/android/InboxFragment;->access$400(Lco/vine/android/InboxFragment;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 194
    const-string v0, "Header change: Add."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 195
    iget-object v0, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # setter for: Lco/vine/android/InboxFragment;->mIsEmptyViewAdded:Z
    invoke-static {v0, v3}, Lco/vine/android/InboxFragment;->access$402(Lco/vine/android/InboxFragment;Z)Z

    .line 196
    iget-object v0, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    iget-object v0, v0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mEmptyView:Landroid/view/View;
    invoke-static {v1}, Lco/vine/android/InboxFragment;->access$500(Lco/vine/android/InboxFragment;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 220
    :cond_0
    :goto_0
    return-void

    .line 199
    :cond_1
    iget-object v0, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mIsEmptyViewAdded:Z
    invoke-static {v0}, Lco/vine/android/InboxFragment;->access$400(Lco/vine/android/InboxFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 200
    const-string v0, "Header change: Remove."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 201
    iget-object v0, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # setter for: Lco/vine/android/InboxFragment;->mIsEmptyViewAdded:Z
    invoke-static {v0, v2}, Lco/vine/android/InboxFragment;->access$402(Lco/vine/android/InboxFragment;Z)Z

    .line 202
    iget-object v0, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    iget-object v0, v0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mEmptyView:Landroid/view/View;
    invoke-static {v1}, Lco/vine/android/InboxFragment;->access$500(Lco/vine/android/InboxFragment;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeHeaderView(Landroid/view/View;)Z

    goto :goto_0

    .line 206
    :cond_2
    iget-object v0, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mOthersCursorCount:I
    invoke-static {v0}, Lco/vine/android/InboxFragment;->access$600(Lco/vine/android/InboxFragment;)I

    move-result v0

    if-nez v0, :cond_3

    .line 207
    iget-object v0, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mIsEmptyViewAdded:Z
    invoke-static {v0}, Lco/vine/android/InboxFragment;->access$400(Lco/vine/android/InboxFragment;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 208
    const-string v0, "Header change: Add."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 209
    iget-object v0, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # setter for: Lco/vine/android/InboxFragment;->mIsEmptyViewAdded:Z
    invoke-static {v0, v3}, Lco/vine/android/InboxFragment;->access$402(Lco/vine/android/InboxFragment;Z)Z

    .line 210
    iget-object v0, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    iget-object v0, v0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mEmptyView:Landroid/view/View;
    invoke-static {v1}, Lco/vine/android/InboxFragment;->access$500(Lco/vine/android/InboxFragment;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    goto :goto_0

    .line 213
    :cond_3
    iget-object v0, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mIsEmptyViewAdded:Z
    invoke-static {v0}, Lco/vine/android/InboxFragment;->access$400(Lco/vine/android/InboxFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 214
    const-string v0, "Header change: Remove."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 215
    iget-object v0, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # setter for: Lco/vine/android/InboxFragment;->mIsEmptyViewAdded:Z
    invoke-static {v0, v2}, Lco/vine/android/InboxFragment;->access$402(Lco/vine/android/InboxFragment;Z)Z

    .line 216
    iget-object v0, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    iget-object v0, v0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/InboxFragment$2;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mEmptyView:Landroid/view/View;
    invoke-static {v1}, Lco/vine/android/InboxFragment;->access$500(Lco/vine/android/InboxFragment;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeHeaderView(Landroid/view/View;)Z

    goto :goto_0
.end method
