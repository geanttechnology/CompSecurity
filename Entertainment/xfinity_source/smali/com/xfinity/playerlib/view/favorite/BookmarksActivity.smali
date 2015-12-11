.class public Lcom/xfinity/playerlib/view/favorite/BookmarksActivity;
.super Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;
.source "BookmarksActivity.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$FavoriteListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 22
    sget v0, Lcom/xfinity/playerlib/R$layout;->flyin_bookmarks:I

    return v0
.end method

.method public getSearchBackIcon()I
    .locals 1

    .prologue
    .line 17
    sget v0, Lcom/xfinity/playerlib/R$drawable;->ico_back_bookmarks:I

    return v0
.end method

.method protected getSpeechRecognizerClass()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 44
    const-class v0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    return-object v0
.end method

.method public playLiveStream(Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V
    .locals 2
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    .prologue
    .line 38
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/LiveStreamFavorite;->getStreamId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 39
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/favorite/BookmarksActivity;->startActivity(Landroid/content/Intent;)V

    .line 40
    return-void
.end method

.method public showDetail(Lcom/xfinity/playerlib/model/VideoFavorite;)V
    .locals 3
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 28
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v1, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/VideoFavorite;)V

    const/4 v2, 0x1

    .line 29
    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->loadAsActivity(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v1

    .line 30
    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v1

    .line 31
    invoke-virtual {v1, p0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 33
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/favorite/BookmarksActivity;->startActivity(Landroid/content/Intent;)V

    .line 34
    return-void
.end method
