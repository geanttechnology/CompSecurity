.class Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;
.super Ljava/lang/Object;
.source "AlertAnimationManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->restartMainContent()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V
    .locals 0

    .prologue
    .line 193
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 196
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$500(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;->getView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 197
    .local v0, "parentView":Landroid/widget/FrameLayout;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertPlayer:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$400(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v1

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->getView()Lcom/adobe/mediacore/MediaPlayerView;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 198
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->savedView:Landroid/view/View;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$600(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 199
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->savedView:Landroid/view/View;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$600(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->bringToFront()V

    .line 200
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # setter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->savedView:Landroid/view/View;
    invoke-static {v1, v3}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$602(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;Landroid/view/View;)Landroid/view/View;

    .line 202
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertPlayer:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$400(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v1

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->reset()V

    .line 203
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # setter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertPlayer:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v1, v3}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$402(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;Lcom/adobe/mediacore/MediaPlayer;)Lcom/adobe/mediacore/MediaPlayer;

    .line 204
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->savedPlayerStatus:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$700(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v1

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v1, v2, :cond_0

    .line 205
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$500(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;->play()V

    .line 207
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # setter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->savedPlayerStatus:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    invoke-static {v1, v3}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$702(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 208
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$500(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;->getVideoType()Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    move-result-object v1

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->LINEAR:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 209
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$500(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;->seekToLive()V

    .line 211
    :cond_1
    return-void
.end method
