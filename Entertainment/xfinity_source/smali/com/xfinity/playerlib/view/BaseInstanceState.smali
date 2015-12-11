.class public Lcom/xfinity/playerlib/view/BaseInstanceState;
.super Ljava/lang/Object;
.source "BaseInstanceState.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field public static final EXTRA_BUNDLE_PARAMS:Ljava/lang/String;


# instance fields
.field public companyId:Ljava/lang/Long;

.field public currentlyPlayingVideoId:Ljava/lang/Long;

.field public episodeId:Lcom/xfinity/playerlib/model/MerlinId;

.field public loadAsActivity:Ljava/lang/Boolean;

.field public merlinId:Lcom/xfinity/playerlib/model/MerlinId;

.field public nonEpisodeVideoId:Ljava/lang/Long;

.field public seriesId:Lcom/xfinity/playerlib/model/MerlinId;

.field public shouldHideSeriesTitle:Z

.field public showPanelFittedLayout:Z

.field public showSeriesArt:Ljava/lang/Boolean;

.field public videoId:Ljava/lang/Long;

.field public wantsSubscriptionOnly:Z

.field public watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/xfinity/playerlib/view/BaseInstanceState;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/BaseInstanceState;->EXTRA_BUNDLE_PARAMS:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->videoId:Ljava/lang/Long;

    .line 23
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->loadAsActivity:Ljava/lang/Boolean;

    .line 24
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->showSeriesArt:Ljava/lang/Boolean;

    .line 28
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->showPanelFittedLayout:Z

    return-void
.end method


# virtual methods
.method public addToBundle(Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 1
    .param p1, "out"    # Landroid/os/Bundle;

    .prologue
    .line 92
    sget-object v0, Lcom/xfinity/playerlib/view/BaseInstanceState;->EXTRA_BUNDLE_PARAMS:Ljava/lang/String;

    invoke-virtual {p1, v0, p0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 93
    return-object p1
.end method

.method public hasNonEpisodeID()Z
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->nonEpisodeVideoId:Ljava/lang/Long;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasOnlySeriesInfo()Z
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->episodeId:Lcom/xfinity/playerlib/model/MerlinId;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->nonEpisodeVideoId:Ljava/lang/Long;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasValidVideoId()Z
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->videoId:Ljava/lang/Long;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setCompanyId(Ljava/lang/Long;)V
    .locals 0
    .param p1, "companyId"    # Ljava/lang/Long;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->companyId:Ljava/lang/Long;

    .line 75
    return-void
.end method

.method public setCurrentlyPlayingVideoId(Ljava/lang/Long;)V
    .locals 0
    .param p1, "currentlyPlayingVideoId"    # Ljava/lang/Long;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->currentlyPlayingVideoId:Ljava/lang/Long;

    .line 55
    return-void
.end method

.method public setEpisodeId(Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 0
    .param p1, "episodeId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->episodeId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 39
    return-void
.end method

.method public setLoadAsActivity(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "loadAsActivity"    # Ljava/lang/Boolean;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->loadAsActivity:Ljava/lang/Boolean;

    .line 63
    return-void
.end method

.method public setMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 0
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 71
    return-void
.end method

.method public setNonEpisodeVideoId(Ljava/lang/Long;)V
    .locals 0
    .param p1, "nonEpisodeVideoId"    # Ljava/lang/Long;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->nonEpisodeVideoId:Ljava/lang/Long;

    .line 43
    return-void
.end method

.method public setSeriesId(Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 0
    .param p1, "seriesId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 35
    return-void
.end method

.method public setShouldHideSeriesTitle(Z)V
    .locals 0
    .param p1, "shouldHideSeriesTitle"    # Z

    .prologue
    .line 50
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->shouldHideSeriesTitle:Z

    .line 51
    return-void
.end method

.method public setShowPanelFittedLayout(Z)V
    .locals 0
    .param p1, "showPanelFittedLayout"    # Z

    .prologue
    .line 66
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->showPanelFittedLayout:Z

    .line 67
    return-void
.end method

.method public setVideoId(Ljava/lang/Long;)V
    .locals 0
    .param p1, "videoId"    # Ljava/lang/Long;

    .prologue
    .line 46
    iput-object p1, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->videoId:Ljava/lang/Long;

    .line 47
    return-void
.end method

.method public setWantsSubscriptionOnly(Z)V
    .locals 0
    .param p1, "wantsSubscriptionOnly"    # Z

    .prologue
    .line 78
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->wantsSubscriptionOnly:Z

    .line 79
    return-void
.end method

.method public setWatchableKey(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V
    .locals 0
    .param p1, "watchableKey"    # Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    .line 59
    return-void
.end method

.method public showSeriesArt(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "showSeriesArt"    # Ljava/lang/Boolean;

    .prologue
    .line 82
    iput-object p1, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->showSeriesArt:Ljava/lang/Boolean;

    .line 83
    return-void
.end method

.method public useDownloadAsSource()Z
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public useEpisodeId()Z
    .locals 2

    .prologue
    .line 109
    iget-object v0, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->episodeId:Lcom/xfinity/playerlib/model/MerlinId;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->episodeId:Lcom/xfinity/playerlib/model/MerlinId;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/BaseInstanceState;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/MerlinId;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
