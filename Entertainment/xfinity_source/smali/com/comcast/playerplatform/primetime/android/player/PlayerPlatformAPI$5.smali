.class Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$5;
.super Ljava/lang/Object;
.source "PlayerPlatformAPI.java"

# interfaces
.implements Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V
    .locals 0

    .prologue
    .line 1396
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$5;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTick(Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 1399
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$5;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$100(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$5;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$100(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_0

    .line 1400
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$5;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->requestMediaProgress()V

    .line 1402
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$5;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->updatePlaybackMetrics()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$2000(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V

    .line 1405
    :cond_0
    return-void
.end method
