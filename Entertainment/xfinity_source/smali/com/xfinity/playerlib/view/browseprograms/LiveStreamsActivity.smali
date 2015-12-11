.class public Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsActivity;
.super Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;
.source "LiveStreamsActivity.java"

# interfaces
.implements Lcom/comcast/cim/android/view/flow/FilterRequestObserver;
.implements Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamOnClickListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 24
    sget v0, Lcom/xfinity/playerlib/R$layout;->flyin_live_streams_browse:I

    return v0
.end method

.method public getSearchBackIcon()I
    .locals 1

    .prologue
    .line 15
    sget v0, Lcom/xfinity/playerlib/R$drawable;->ico_back_live:I

    return v0
.end method

.method protected getSpeechRecognizerClass()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 41
    const-class v0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    return-object v0
.end method

.method public onLiveEventClick(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Ljava/lang/String;)V
    .locals 2
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .param p2, "eventId"    # Ljava/lang/String;

    .prologue
    .line 35
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 36
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsActivity;->startActivity(Landroid/content/Intent;)V

    .line 37
    return-void
.end method

.method public onLiveStreamClick(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 2
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 29
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 30
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsActivity;->startActivity(Landroid/content/Intent;)V

    .line 31
    return-void
.end method

.method public showFilter(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "filterBundle"    # Landroid/os/Bundle;

    .prologue
    .line 20
    return-void
.end method
