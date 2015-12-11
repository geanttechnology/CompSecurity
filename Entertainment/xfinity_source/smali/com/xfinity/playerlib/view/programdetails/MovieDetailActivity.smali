.class public Lcom/xfinity/playerlib/view/programdetails/MovieDetailActivity;
.super Lcom/xfinity/playerlib/view/programdetails/DetailActivity;
.source "MovieDetailActivity.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 13
    sget v0, Lcom/xfinity/playerlib/R$layout;->movie_detail_shell:I

    return v0
.end method

.method public onPlayOrResumePressed(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 1
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 18
    invoke-static {p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Landroid/content/Intent;

    move-result-object v0

    .line 19
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailActivity;->startActivity(Landroid/content/Intent;)V

    .line 20
    return-void
.end method
