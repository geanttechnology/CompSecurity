.class public Lcom/xfinity/playerlib/view/programdetails/BabyGuideEpisodeDetailActivity;
.super Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;
.source "BabyGuideEpisodeDetailActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 15
    sget v0, Lcom/xfinity/playerlib/R$layout;->babyguide_flyin_episode_detail:I

    return v0
.end method

.method public onPlayOrResumePressed(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 2
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 20
    invoke-static {p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Landroid/content/Intent;

    move-result-object v0

    .line 21
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "reset"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 22
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 23
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/BabyGuideEpisodeDetailActivity;->startActivity(Landroid/content/Intent;)V

    .line 24
    return-void
.end method
