.class Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$5;
.super Ljava/lang/Object;
.source "EspnPlayer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)V
    .locals 0

    .prologue
    .line 501
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$5;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 504
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$5;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDisneyEspnTokenDelegate()Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

    move-result-object v0

    .line 505
    .local v0, "authDelegate":Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$5;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getChannelName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$5;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v3}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDrmKey()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;->onTokenExpired(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 506
    .local v1, "newToken":Ljava/lang/String;
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$5;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->setDrmKey(Ljava/lang/String;)V

    .line 507
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$5;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->playbackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$200(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->updateAffiliateToken(Ljava/lang/String;)V

    .line 508
    return-void
.end method
