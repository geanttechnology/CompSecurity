.class public Lcom/xfinity/playerlib/view/browseprograms/BabyGuideLiveStreamsActivity;
.super Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsActivity;
.source "BabyGuideLiveStreamsActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    const/4 v1, 0x0

    .line 11
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    .line 13
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BabyGuideLiveStreamsActivity;->searchMenuItem:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 14
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BabyGuideLiveStreamsActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 16
    :cond_0
    return v1
.end method

.method public onLiveStreamClick(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 2
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 21
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 22
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "reset"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 23
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 24
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/BabyGuideLiveStreamsActivity;->startActivity(Landroid/content/Intent;)V

    .line 25
    return-void
.end method
