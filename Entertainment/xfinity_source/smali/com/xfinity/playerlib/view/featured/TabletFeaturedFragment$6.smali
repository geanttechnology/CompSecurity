.class Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "TabletFeaturedFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->showLastWatched(Lcom/xfinity/playerlib/bookmarks/Bookmark;Landroid/widget/ProgressBar;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

.field final synthetic val$bookmark:Lcom/xfinity/playerlib/bookmarks/Bookmark;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Lcom/xfinity/playerlib/bookmarks/Bookmark;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    .prologue
    .line 346
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;->val$bookmark:Lcom/xfinity/playerlib/bookmarks/Bookmark;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 369
    # getter for: Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->access$200()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Couldn\'t get title for last watched"

    invoke-interface {v0, v1, p1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 370
    return-void
.end method

.method public onPostExecute(Lcom/xfinity/playerlib/model/dibic/DibicResource;)V
    .locals 9
    .param p1, "resource"    # Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 350
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;->val$bookmark:Lcom/xfinity/playerlib/bookmarks/Bookmark;

    instance-of v1, v1, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    if-eqz v1, :cond_0

    .line 352
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;->val$bookmark:Lcom/xfinity/playerlib/bookmarks/Bookmark;

    check-cast v1, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-interface {p1, v1}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v0

    .line 354
    .local v0, "lastWatched":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;->val$bookmark:Lcom/xfinity/playerlib/bookmarks/Bookmark;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->isFinished()Z

    move-result v1

    if-nez v1, :cond_1

    .line 355
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedContainer:Landroid/view/View;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_last_watched_episode:I

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    .line 356
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    iget-object v5, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;->val$bookmark:Lcom/xfinity/playerlib/bookmarks/Bookmark;

    .line 357
    invoke-virtual {v5}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getTitle()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v7

    iget-object v5, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;->val$bookmark:Lcom/xfinity/playerlib/bookmarks/Bookmark;

    .line 358
    invoke-virtual {v5}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getPercentWatched()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v8

    .line 355
    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 365
    .end local v0    # "lastWatched":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_0
    :goto_0
    return-void

    .line 360
    .restart local v0    # "lastWatched":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedContainer:Landroid/view/View;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_last_watched_episode_finished:I

    new-array v4, v8, [Ljava/lang/Object;

    .line 361
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    iget-object v5, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;->val$bookmark:Lcom/xfinity/playerlib/bookmarks/Bookmark;

    .line 362
    invoke-virtual {v5}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getTitle()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v7

    .line 360
    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 346
    check-cast p1, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;->onPostExecute(Lcom/xfinity/playerlib/model/dibic/DibicResource;)V

    return-void
.end method
