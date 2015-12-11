.class Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;
.super Ljava/lang/Object;
.source "HistoryFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 133
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 12
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 136
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .line 142
    .local v1, "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->isMovie()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 143
    iget-object v7, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;
    invoke-static {v7}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$500(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-result-object v7

    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v8

    invoke-interface {v7, v8}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v3

    .line 148
    .local v3, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :goto_0
    iget-object v7, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    iget-object v7, v7, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-virtual {v7, v3}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 149
    iget-object v7, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 150
    .local v0, "activity":Landroid/app/Activity;
    iget-object v7, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    iget-object v7, v7, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getVideoId()J

    move-result-wide v8

    invoke-virtual {v7, v8, v9}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->findFileWithVideoId(J)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v2

    .line 151
    .local v2, "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    if-eqz v2, :cond_3

    .line 152
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v6

    .line 153
    .local v6, "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-interface {v6}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getVideos()Ljava/util/Set;

    move-result-object v5

    .line 154
    .local v5, "videos":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 155
    .local v4, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v8

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideoId()J

    move-result-wide v10

    cmp-long v8, v8, v10

    if-nez v8, :cond_0

    .line 156
    check-cast v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;

    .end local v0    # "activity":Landroid/app/Activity;
    invoke-interface {v0, v4, v6}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;->onPlayOrResumePressed(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 172
    .end local v2    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .end local v4    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .end local v5    # "videos":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    .end local v6    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    :cond_1
    :goto_1
    return-void

    .line 145
    .end local v3    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_2
    iget-object v7, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;
    invoke-static {v7}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$500(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-result-object v7

    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v8

    invoke-interface {v7, v8}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v3

    .restart local v3    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    goto :goto_0

    .line 161
    .restart local v0    # "activity":Landroid/app/Activity;
    .restart local v2    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :cond_3
    iget-object v7, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    iget-object v7, v7, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v8

    new-instance v9, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3$1;

    invoke-direct {v9, p0, v0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3$1;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;Landroid/app/Activity;Landroid/view/View;)V

    invoke-virtual {v7, v8, v9}, Lcom/comcast/cim/utils/UIUtil;->ensureConnectivityBeforeExecuting(Landroid/content/Context;Ljava/lang/Runnable;)V

    goto :goto_1

    .line 170
    .end local v0    # "activity":Landroid/app/Activity;
    .end local v2    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :cond_4
    iget-object v7, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    # invokes: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->showUpsellDialogForProgram(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    invoke-static {v7, v3}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$600(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    goto :goto_1
.end method
