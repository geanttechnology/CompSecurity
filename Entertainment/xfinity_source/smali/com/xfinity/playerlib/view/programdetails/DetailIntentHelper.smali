.class public Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
.super Ljava/lang/Object;
.source "DetailIntentHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    }
.end annotation


# instance fields
.field infoClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end field

.field infoFragment:Landroid/app/Fragment;

.field instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)V
    .locals 6
    .param p1, "builder"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    const/4 v0, 0x1

    .line 290
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 292
    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$100(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v1

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->loadAsActivity:Z
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$200(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Z

    move-result v2

    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->getInstanceStateForNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Z)Lcom/xfinity/playerlib/view/BaseInstanceState;
    invoke-static {p1, v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$300(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;Lcom/xfinity/playerlib/model/MerlinId$Namespace;Z)Lcom/xfinity/playerlib/view/BaseInstanceState;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    .line 293
    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$100(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v1

    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->getFragmentForNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Landroid/app/Fragment;
    invoke-static {p1, v1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$400(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Landroid/app/Fragment;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->infoFragment:Landroid/app/Fragment;

    .line 294
    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$100(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v1

    .line 295
    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideoId:Ljava/lang/Long;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$500(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Ljava/lang/Long;

    move-result-object v2

    if-nez v2, :cond_0

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->inBabyGuide:Z
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$600(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Z

    move-result v2

    if-ne v2, v0, :cond_2

    .line 294
    :cond_0
    :goto_0
    # invokes: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->getDetailActivityClassForNameSpace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Z)Ljava/lang/Class;
    invoke-static {p1, v1, v0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$700(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;Lcom/xfinity/playerlib/model/MerlinId$Namespace;Z)Ljava/lang/Class;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->infoClass:Ljava/lang/Class;

    .line 297
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideoId:Ljava/lang/Long;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$500(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setCurrentlyPlayingVideoId(Ljava/lang/Long;)V

    .line 298
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle:Z
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$800(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setShouldHideSeriesTitle(Z)V

    .line 299
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showPanelFittedLayout:Z
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$900(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setShowPanelFittedLayout(Z)V

    .line 300
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->loadAsActivity:Z
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$200(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setLoadAsActivity(Ljava/lang/Boolean;)V

    .line 302
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->episodeId:Lcom/xfinity/playerlib/model/MerlinId;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1000(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setEpisodeId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 303
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1100(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setSeriesId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 304
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1200(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 305
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showSeriesArt:Z
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1300(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->showSeriesArt(Ljava/lang/Boolean;)V

    .line 307
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->companyId:Ljava/lang/Long;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1400(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setCompanyId(Ljava/lang/Long;)V

    .line 308
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->wantsSubscriptionOnly:Z
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1500(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setWantsSubscriptionOnly(Z)V

    .line 310
    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1600(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 312
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1600(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setWatchableKey(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V

    .line 313
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1600(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->getParentMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setSeriesId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 354
    :cond_1
    :goto_1
    return-void

    .line 295
    :cond_2
    const/4 v0, 0x0

    goto/16 :goto_0

    .line 315
    :cond_3
    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1700(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 317
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1700(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 318
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1700(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getCompanyId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setCompanyId(Ljava/lang/Long;)V

    .line 319
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1700(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setSeriesId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 320
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1700(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getVideoId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setVideoId(Ljava/lang/Long;)V

    .line 321
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1700(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setEpisodeId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 322
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1700(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getVideoId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setNonEpisodeVideoId(Ljava/lang/Long;)V

    .line 323
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1700(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v0

    iget-wide v2, v0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->companyId:J

    const-wide/16 v4, 0x0

    cmp-long v0, v2, v4

    if-eqz v0, :cond_4

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1700(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v0

    iget-wide v2, v0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->companyId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    :goto_2
    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setCompanyId(Ljava/lang/Long;)V

    goto :goto_1

    :cond_4
    const/4 v0, 0x0

    goto :goto_2

    .line 324
    :cond_5
    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1800(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v0

    if-eqz v0, :cond_6

    .line 326
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1800(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setSeriesId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 327
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1800(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setNonEpisodeVideoId(Ljava/lang/Long;)V

    .line 328
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1800(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProgramId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setEpisodeId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 329
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1800(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProgramId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)V

    goto/16 :goto_1

    .line 331
    :cond_6
    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->favorite:Lcom/xfinity/playerlib/model/VideoFavorite;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1900(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/VideoFavorite;

    move-result-object v0

    if-eqz v0, :cond_7

    .line 333
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->favorite:Lcom/xfinity/playerlib/model/VideoFavorite;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1900(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/VideoFavorite;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/VideoFavorite;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setSeriesId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 334
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->favorite:Lcom/xfinity/playerlib/model/VideoFavorite;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$1900(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/VideoFavorite;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/VideoFavorite;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)V

    goto/16 :goto_1

    .line 336
    :cond_7
    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->seriesWatchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$2000(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    move-result-object v0

    if-eqz v0, :cond_8

    .line 338
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->seriesWatchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$2000(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    move-result-object v1

    invoke-interface {v1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setSeriesId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 339
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->seriesWatchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$2000(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    move-result-object v1

    invoke-interface {v1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setEpisodeId(Lcom/xfinity/playerlib/model/MerlinId;)V

    goto/16 :goto_1

    .line 341
    :cond_8
    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$2100(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/view/BaseInstanceState;

    move-result-object v0

    if-eqz v0, :cond_9

    .line 343
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$2100(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/view/BaseInstanceState;

    move-result-object v1

    iget-object v1, v1, Lcom/xfinity/playerlib/view/BaseInstanceState;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setWatchableKey(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V

    .line 344
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$2100(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/view/BaseInstanceState;

    move-result-object v1

    iget-object v1, v1, Lcom/xfinity/playerlib/view/BaseInstanceState;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setSeriesId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 345
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$2100(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/view/BaseInstanceState;

    move-result-object v1

    iget-object v1, v1, Lcom/xfinity/playerlib/view/BaseInstanceState;->episodeId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setEpisodeId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 346
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$2100(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/view/BaseInstanceState;

    move-result-object v1

    iget-object v1, v1, Lcom/xfinity/playerlib/view/BaseInstanceState;->videoId:Ljava/lang/Long;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setVideoId(Ljava/lang/Long;)V

    goto/16 :goto_1

    .line 348
    :cond_9
    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->program:Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$2200(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 350
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->program:Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$2200(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 351
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->program:Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->access$2200(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->setSeriesId(Lcom/xfinity/playerlib/model/MerlinId;)V

    goto/16 :goto_1
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$1;

    .prologue
    .line 22
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;-><init>(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)V

    return-void
.end method


# virtual methods
.method public getBundle()Landroid/os/Bundle;
    .locals 2

    .prologue
    .line 358
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/BaseInstanceState;->addToBundle(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public getFragment()Landroid/app/Fragment;
    .locals 2

    .prologue
    .line 371
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->infoFragment:Landroid/app/Fragment;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getBundle()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 372
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->infoFragment:Landroid/app/Fragment;

    return-object v0
.end method

.method public getIntent(Landroid/content/Context;)Landroid/content/Intent;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 363
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->infoClass:Ljava/lang/Class;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 364
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getBundle()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 366
    return-object v0
.end method
