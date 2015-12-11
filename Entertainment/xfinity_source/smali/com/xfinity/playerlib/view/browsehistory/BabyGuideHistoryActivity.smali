.class public Lcom/xfinity/playerlib/view/browsehistory/BabyGuideHistoryActivity;
.super Lcom/xfinity/playerlib/view/browsehistory/HistoryActivity;
.source "BabyGuideHistoryActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    const/4 v1, 0x0

    .line 21
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    .line 23
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/BabyGuideHistoryActivity;->searchMenuItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/BabyGuideHistoryActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 26
    :cond_0
    return v1
.end method

.method public onLiveStreamPlayOrResumePressed(Ljava/lang/String;)V
    .locals 2
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 71
    invoke-static {p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 72
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "reset"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 73
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 74
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browsehistory/BabyGuideHistoryActivity;->startActivity(Landroid/content/Intent;)V

    .line 75
    return-void
.end method

.method public onPlayOrResumePressed(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 2
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 63
    invoke-static {p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Landroid/content/Intent;

    move-result-object v0

    .line 64
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "reset"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 65
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 66
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browsehistory/BabyGuideHistoryActivity;->startActivity(Landroid/content/Intent;)V

    .line 67
    return-void
.end method

.method public onVideoPlayOrResumePressed(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 2
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 55
    invoke-static {p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)Landroid/content/Intent;

    move-result-object v0

    .line 56
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "reset"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 57
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 58
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browsehistory/BabyGuideHistoryActivity;->startActivity(Landroid/content/Intent;)V

    .line 59
    return-void
.end method

.method public showDetail(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Ljava/lang/Long;)V
    .locals 5
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .param p2, "currentlyPlayingVideoId"    # Ljava/lang/Long;

    .prologue
    const/4 v3, 0x0

    .line 31
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v2, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 32
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    .line 33
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showPanelFittedLayout(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    const/4 v3, 0x1

    .line 34
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->loadAsActivity(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    .line 35
    invoke-virtual {v2, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideo(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v3

    .line 37
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v2

    sget-object v4, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v2, v4}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    sget-object v2, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .line 36
    :goto_0
    invoke-virtual {v3, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->overrideNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    .line 39
    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v0

    .line 43
    .local v0, "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    if-ne v2, v3, :cond_1

    .line 44
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/xfinity/playerlib/view/programdetails/BabyGuideMovieActivity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 49
    .local v1, "intent":Landroid/content/Intent;
    :goto_1
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getBundle()Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 50
    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/browsehistory/BabyGuideHistoryActivity;->startActivity(Landroid/content/Intent;)V

    .line 51
    return-void

    .line 37
    .end local v0    # "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_0
    sget-object v2, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvSeries:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    goto :goto_0

    .line 46
    .restart local v0    # "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    :cond_1
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/xfinity/playerlib/view/programdetails/BabyGuideSeriesEntityActivity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .restart local v1    # "intent":Landroid/content/Intent;
    goto :goto_1
.end method
