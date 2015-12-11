.class Lcom/amazon/device/ads/VideoActionHandler;
.super Ljava/lang/Object;
.source "VideoActionHandler.java"

# interfaces
.implements Lcom/amazon/device/ads/IAdActivityAdapter;


# instance fields
.field private activity:Landroid/app/Activity;

.field private layout:Landroid/widget/RelativeLayout;

.field private player:Lcom/amazon/device/ads/AdVideoPlayer;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/ads/VideoActionHandler;)Landroid/app/Activity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/VideoActionHandler;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/device/ads/VideoActionHandler;->activity:Landroid/app/Activity;

    return-object v0
.end method

.method private initPlayer(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    const/4 v5, -0x1

    .line 63
    const-string/jumbo v3, "player_properties"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Lcom/amazon/device/ads/Controller$PlayerProperties;

    .line 64
    .local v2, "props":Lcom/amazon/device/ads/Controller$PlayerProperties;
    const-string/jumbo v3, "player_dimensions"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/Controller$Dimensions;

    .line 66
    .local v0, "dimensions":Lcom/amazon/device/ads/Controller$Dimensions;
    new-instance v3, Lcom/amazon/device/ads/AdVideoPlayer;

    iget-object v4, p0, Lcom/amazon/device/ads/VideoActionHandler;->activity:Landroid/app/Activity;

    invoke-direct {v3, v4}, Lcom/amazon/device/ads/AdVideoPlayer;-><init>(Landroid/content/Context;)V

    iput-object v3, p0, Lcom/amazon/device/ads/VideoActionHandler;->player:Lcom/amazon/device/ads/AdVideoPlayer;

    .line 67
    iget-object v3, p0, Lcom/amazon/device/ads/VideoActionHandler;->player:Lcom/amazon/device/ads/AdVideoPlayer;

    const-string/jumbo v4, "url"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Lcom/amazon/device/ads/AdVideoPlayer;->setPlayData(Lcom/amazon/device/ads/Controller$PlayerProperties;Ljava/lang/String;)V

    .line 70
    if-nez v0, :cond_0

    .line 72
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v1, v5, v5}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 73
    .local v1, "lp":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v3, 0xd

    invoke-virtual {v1, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 82
    :goto_0
    iget-object v3, p0, Lcom/amazon/device/ads/VideoActionHandler;->player:Lcom/amazon/device/ads/AdVideoPlayer;

    invoke-virtual {v3, v1}, Lcom/amazon/device/ads/AdVideoPlayer;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 83
    iget-object v3, p0, Lcom/amazon/device/ads/VideoActionHandler;->player:Lcom/amazon/device/ads/AdVideoPlayer;

    iget-object v4, p0, Lcom/amazon/device/ads/VideoActionHandler;->layout:Landroid/widget/RelativeLayout;

    invoke-virtual {v3, v4}, Lcom/amazon/device/ads/AdVideoPlayer;->setViewGroup(Landroid/view/ViewGroup;)V

    .line 84
    iget-object v3, p0, Lcom/amazon/device/ads/VideoActionHandler;->player:Lcom/amazon/device/ads/AdVideoPlayer;

    invoke-direct {p0, v3}, Lcom/amazon/device/ads/VideoActionHandler;->setPlayerListener(Lcom/amazon/device/ads/AdVideoPlayer;)V

    .line 85
    return-void

    .line 77
    .end local v1    # "lp":Landroid/widget/RelativeLayout$LayoutParams;
    :cond_0
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    iget v3, v0, Lcom/amazon/device/ads/Controller$Dimensions;->width:I

    iget v4, v0, Lcom/amazon/device/ads/Controller$Dimensions;->height:I

    invoke-direct {v1, v3, v4}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 78
    .restart local v1    # "lp":Landroid/widget/RelativeLayout$LayoutParams;
    iget v3, v0, Lcom/amazon/device/ads/Controller$Dimensions;->y:I

    iput v3, v1, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 79
    iget v3, v0, Lcom/amazon/device/ads/Controller$Dimensions;->x:I

    iput v3, v1, Landroid/widget/RelativeLayout$LayoutParams;->leftMargin:I

    goto :goto_0
.end method

.method private setPlayerListener(Lcom/amazon/device/ads/AdVideoPlayer;)V
    .locals 1
    .param p1, "player"    # Lcom/amazon/device/ads/AdVideoPlayer;

    .prologue
    .line 45
    new-instance v0, Lcom/amazon/device/ads/VideoActionHandler$1;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/VideoActionHandler$1;-><init>(Lcom/amazon/device/ads/VideoActionHandler;)V

    invoke-virtual {p1, v0}, Lcom/amazon/device/ads/AdVideoPlayer;->setListener(Lcom/amazon/device/ads/AdVideoPlayer$AdVideoPlayerListener;)V

    .line 59
    return-void
.end method


# virtual methods
.method public onCreate()V
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 34
    iget-object v1, p0, Lcom/amazon/device/ads/VideoActionHandler;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 35
    .local v0, "data":Landroid/os/Bundle;
    new-instance v1, Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/amazon/device/ads/VideoActionHandler;->activity:Landroid/app/Activity;

    invoke-direct {v1, v2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/device/ads/VideoActionHandler;->layout:Landroid/widget/RelativeLayout;

    .line 36
    iget-object v1, p0, Lcom/amazon/device/ads/VideoActionHandler;->layout:Landroid/widget/RelativeLayout;

    new-instance v2, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v2, v3, v3}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 38
    iget-object v1, p0, Lcom/amazon/device/ads/VideoActionHandler;->activity:Landroid/app/Activity;

    iget-object v2, p0, Lcom/amazon/device/ads/VideoActionHandler;->layout:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v2}, Landroid/app/Activity;->setContentView(Landroid/view/View;)V

    .line 39
    invoke-direct {p0, v0}, Lcom/amazon/device/ads/VideoActionHandler;->initPlayer(Landroid/os/Bundle;)V

    .line 40
    iget-object v1, p0, Lcom/amazon/device/ads/VideoActionHandler;->player:Lcom/amazon/device/ads/AdVideoPlayer;

    invoke-virtual {v1}, Lcom/amazon/device/ads/AdVideoPlayer;->playVideo()V

    .line 41
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 89
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 93
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/device/ads/VideoActionHandler;->player:Lcom/amazon/device/ads/AdVideoPlayer;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdVideoPlayer;->releasePlayer()V

    .line 99
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/device/ads/VideoActionHandler;->player:Lcom/amazon/device/ads/AdVideoPlayer;

    .line 100
    iget-object v0, p0, Lcom/amazon/device/ads/VideoActionHandler;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 101
    return-void
.end method

.method public preOnCreate()V
    .locals 0

    .prologue
    .line 105
    return-void
.end method

.method public setActivity(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/device/ads/VideoActionHandler;->activity:Landroid/app/Activity;

    .line 29
    return-void
.end method
