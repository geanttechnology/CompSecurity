.class public Lcom/xfinity/playerlib/view/favorite/BabyGuideBookmarksActivity;
.super Lcom/xfinity/playerlib/view/favorite/BookmarksActivity;
.source "BabyGuideBookmarksActivity.java"


# instance fields
.field private currentlyPlayingVideoId:Ljava/lang/Long;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/favorite/BookmarksActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 20
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarksActivity;->onCreate(Landroid/os/Bundle;)V

    .line 22
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 24
    .local v0, "bundle":Landroid/os/Bundle;
    if-eqz p1, :cond_0

    .line 25
    invoke-virtual {v0, p1}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 28
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/BabyGuideBookmarksActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 29
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/BabyGuideBookmarksActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 32
    :cond_1
    const-string v1, "EXTRA_CURRENT_WATCH_VIDEO_ID"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/favorite/BabyGuideBookmarksActivity;->currentlyPlayingVideoId:Ljava/lang/Long;

    .line 34
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    const/4 v1, 0x0

    .line 38
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarksActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    .line 40
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BabyGuideBookmarksActivity;->searchMenuItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 41
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BabyGuideBookmarksActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 43
    :cond_0
    return v1
.end method

.method public playLiveStream(Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V
    .locals 2
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    .prologue
    .line 71
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/LiveStreamFavorite;->getStreamId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 72
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "reset"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 73
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 74
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/favorite/BabyGuideBookmarksActivity;->startActivity(Landroid/content/Intent;)V

    .line 75
    return-void
.end method

.method public showDetail(Lcom/xfinity/playerlib/model/VideoFavorite;)V
    .locals 4
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    const/4 v3, 0x0

    .line 49
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v2, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/VideoFavorite;)V

    .line 50
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    .line 51
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showPanelFittedLayout(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    const/4 v3, 0x1

    .line 52
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->loadAsActivity(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/favorite/BabyGuideBookmarksActivity;->currentlyPlayingVideoId:Ljava/lang/Long;

    .line 53
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideo(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    .line 54
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/VideoFavorite;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->overrideNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    .line 55
    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v0

    .line 59
    .local v0, "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/VideoFavorite;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    if-ne v2, v3, :cond_0

    .line 60
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/xfinity/playerlib/view/programdetails/BabyGuideMovieActivity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 65
    .local v1, "intent":Landroid/content/Intent;
    :goto_0
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getBundle()Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 66
    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/favorite/BabyGuideBookmarksActivity;->startActivity(Landroid/content/Intent;)V

    .line 67
    return-void

    .line 62
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_0
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/xfinity/playerlib/view/programdetails/BabyGuideSeriesEntityActivity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .restart local v1    # "intent":Landroid/content/Intent;
    goto :goto_0
.end method
