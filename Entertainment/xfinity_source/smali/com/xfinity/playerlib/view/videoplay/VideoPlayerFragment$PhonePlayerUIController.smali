.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;
.super Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;
.source "VideoPlayerFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PhonePlayerUIController"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V
    .locals 0

    .prologue
    .line 2112
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;

    .prologue
    .line 2112
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    return-void
.end method


# virtual methods
.method public hideInfoPanel()V
    .locals 0

    .prologue
    .line 2116
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;->showActionBarMenus()V

    .line 2117
    return-void
.end method

.method public showCurrentVideoInfo(Ljava/lang/String;)Z
    .locals 2
    .param p1, "transactionTag"    # Ljava/lang/String;

    .prologue
    .line 2121
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;->hideActionBarMenus()V

    .line 2122
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getCurrentVideoIntent()Landroid/content/Intent;

    move-result-object v0

    .line 2123
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startActivity(Landroid/content/Intent;)V

    .line 2124
    const/4 v1, 0x1

    return v1
.end method

.method public showFavorite(Ljava/lang/String;)Z
    .locals 2
    .param p1, "transactionTag"    # Ljava/lang/String;

    .prologue
    .line 2136
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;->hideActionBarMenus()V

    .line 2137
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getFavoriteIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startActivity(Landroid/content/Intent;)V

    .line 2138
    const/4 v0, 0x1

    return v0
.end method

.method public showFavoriteDetail(Lcom/xfinity/playerlib/model/VideoFavorite;Ljava/lang/String;)V
    .locals 0
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;
    .param p2, "transactionTag"    # Ljava/lang/String;

    .prologue
    .line 2149
    return-void
.end method

.method public showHistory(Ljava/lang/String;)Z
    .locals 2
    .param p1, "transactionTag"    # Ljava/lang/String;

    .prologue
    .line 2129
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;->hideActionBarMenus()V

    .line 2130
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getHistoryIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startActivity(Landroid/content/Intent;)V

    .line 2131
    const/4 v0, 0x1

    return v0
.end method

.method public showHistoryItemDetail(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Ljava/lang/String;)V
    .locals 0
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .param p2, "transactionTag"    # Ljava/lang/String;

    .prologue
    .line 2154
    return-void
.end method

.method public showSeriesWatchableDetail(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Ljava/lang/String;)V
    .locals 0
    .param p1, "seriesWatchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .param p2, "transactionTag"    # Ljava/lang/String;

    .prologue
    .line 2144
    return-void
.end method
