.class public Lcom/aio/downloader/activity/VideoViewActivity;
.super Landroid/app/Activity;
.source "VideoViewActivity.java"


# instance fields
.field private fullscreen:Z

.field private mController:Landroid/widget/MediaController;

.field private videoView:Landroid/widget/VideoView;

.field private video_item_url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 20
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/activity/VideoViewActivity;->fullscreen:Z

    .line 17
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, -0x1

    const/4 v5, -0x2

    .line 26
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 28
    const v3, 0x7f0300bf

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/VideoViewActivity;->setContentView(I)V

    .line 29
    const v3, 0x7f070406

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/VideoViewActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/VideoView;

    iput-object v3, p0, Lcom/aio/downloader/activity/VideoViewActivity;->videoView:Landroid/widget/VideoView;

    .line 30
    new-instance v3, Landroid/widget/MediaController;

    invoke-direct {v3, p0}, Landroid/widget/MediaController;-><init>(Landroid/content/Context;)V

    iput-object v3, p0, Lcom/aio/downloader/activity/VideoViewActivity;->mController:Landroid/widget/MediaController;

    .line 31
    invoke-virtual {p0}, Lcom/aio/downloader/activity/VideoViewActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string v4, "playurl"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/aio/downloader/activity/VideoViewActivity;->video_item_url:Ljava/lang/String;

    .line 32
    new-instance v2, Ljava/io/File;

    iget-object v3, p0, Lcom/aio/downloader/activity/VideoViewActivity;->video_item_url:Ljava/lang/String;

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 34
    .local v2, "video":Ljava/io/File;
    iget-boolean v3, p0, Lcom/aio/downloader/activity/VideoViewActivity;->fullscreen:Z

    if-nez v3, :cond_1

    .line 35
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v6, v6}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 38
    .local v0, "layoutParams":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v3, 0xc

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 39
    const/16 v3, 0xa

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 40
    const/16 v3, 0x9

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 41
    const/16 v3, 0xb

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 42
    iget-object v3, p0, Lcom/aio/downloader/activity/VideoViewActivity;->videoView:Landroid/widget/VideoView;

    invoke-virtual {v3, v0}, Landroid/widget/VideoView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 43
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/aio/downloader/activity/VideoViewActivity;->fullscreen:Z

    .line 51
    .end local v0    # "layoutParams":Landroid/widget/RelativeLayout$LayoutParams;
    :goto_0
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 52
    iget-object v3, p0, Lcom/aio/downloader/activity/VideoViewActivity;->videoView:Landroid/widget/VideoView;

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/VideoView;->setVideoPath(Ljava/lang/String;)V

    .line 53
    iget-object v3, p0, Lcom/aio/downloader/activity/VideoViewActivity;->videoView:Landroid/widget/VideoView;

    iget-object v4, p0, Lcom/aio/downloader/activity/VideoViewActivity;->mController:Landroid/widget/MediaController;

    invoke-virtual {v3, v4}, Landroid/widget/VideoView;->setMediaController(Landroid/widget/MediaController;)V

    .line 54
    iget-object v3, p0, Lcom/aio/downloader/activity/VideoViewActivity;->mController:Landroid/widget/MediaController;

    iget-object v4, p0, Lcom/aio/downloader/activity/VideoViewActivity;->videoView:Landroid/widget/VideoView;

    invoke-virtual {v3, v4}, Landroid/widget/MediaController;->setMediaPlayer(Landroid/widget/MediaController$MediaPlayerControl;)V

    .line 55
    iget-object v3, p0, Lcom/aio/downloader/activity/VideoViewActivity;->videoView:Landroid/widget/VideoView;

    invoke-virtual {v3}, Landroid/widget/VideoView;->requestFocus()Z

    .line 56
    iget-object v3, p0, Lcom/aio/downloader/activity/VideoViewActivity;->videoView:Landroid/widget/VideoView;

    invoke-virtual {v3}, Landroid/widget/VideoView;->start()V

    .line 59
    :cond_0
    iget-object v3, p0, Lcom/aio/downloader/activity/VideoViewActivity;->videoView:Landroid/widget/VideoView;

    new-instance v4, Lcom/aio/downloader/activity/VideoViewActivity$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/VideoViewActivity$1;-><init>(Lcom/aio/downloader/activity/VideoViewActivity;)V

    invoke-virtual {v3, v4}, Landroid/widget/VideoView;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 68
    return-void

    .line 45
    :cond_1
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v1, v5, v5}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 47
    .local v1, "lp":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v3, 0xd

    invoke-virtual {v1, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 48
    iget-object v3, p0, Lcom/aio/downloader/activity/VideoViewActivity;->videoView:Landroid/widget/VideoView;

    invoke-virtual {v3, v1}, Landroid/widget/VideoView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 49
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/aio/downloader/activity/VideoViewActivity;->fullscreen:Z

    goto :goto_0
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 78
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 79
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 80
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 72
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 73
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 74
    return-void
.end method
