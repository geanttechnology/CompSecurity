.class public Lcom/xfinity/playerlib/view/browsehistory/HistoryActivity;
.super Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;
.source "HistoryActivity.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$HistoryListener;
.implements Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$LiveStreamPlayOrResumePressedListener;
.implements Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$VideoPlayOrResumePressedListener;
.implements Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 26
    sget v0, Lcom/xfinity/playerlib/R$layout;->flyin_history_browse:I

    return v0
.end method

.method public getSearchBackIcon()I
    .locals 1

    .prologue
    .line 21
    sget v0, Lcom/xfinity/playerlib/R$drawable;->ico_back_history:I

    return v0
.end method

.method protected getSpeechRecognizerClass()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 62
    const-class v0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    return-object v0
.end method

.method public onLiveStreamPlayOrResumePressed(Ljava/lang/String;)V
    .locals 1
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 56
    invoke-static {p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 57
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryActivity;->startActivity(Landroid/content/Intent;)V

    .line 58
    return-void
.end method

.method public onPlayOrResumePressed(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 1
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 50
    invoke-static {p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Landroid/content/Intent;

    move-result-object v0

    .line 51
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryActivity;->startActivity(Landroid/content/Intent;)V

    .line 52
    return-void
.end method

.method public onVideoPlayOrResumePressed(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 1
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 44
    invoke-static {p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)Landroid/content/Intent;

    move-result-object v0

    .line 45
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryActivity;->startActivity(Landroid/content/Intent;)V

    .line 46
    return-void
.end method

.method public showDetail(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Ljava/lang/Long;)V
    .locals 4
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .param p2, "currentlyPlayingVideoId"    # Ljava/lang/Long;

    .prologue
    const/4 v3, 0x1

    .line 31
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v2, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 33
    invoke-virtual {v2, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideo(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    .line 34
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->loadAsActivity(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    .line 35
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showDetail(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    .line 36
    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v0

    .line 38
    .local v0, "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    invoke-virtual {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v1

    .line 39
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryActivity;->startActivity(Landroid/content/Intent;)V

    .line 40
    return-void
.end method
