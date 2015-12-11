.class Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$1;
.super Ljava/lang/Object;
.source "PlayerPlatformAPI.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;J)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

.field final synthetic val$adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

.field final synthetic val$asset:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

.field final synthetic val$startPosition:J


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;Lcom/comcast/playerplatform/primetime/android/asset/Asset;JLcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V
    .locals 1

    .prologue
    .line 345
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$1;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$1;->val$asset:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    iput-wide p3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$1;->val$startPosition:J

    iput-object p5, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$1;->val$adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 348
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$1;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->addPlayerView()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$000(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V

    .line 349
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$1;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->applyPlayerSettings()V

    .line 350
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$1;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$100(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$1;->val$asset:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$1;->val$startPosition:J

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$1;->val$adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    invoke-interface {v0, v1, v2, v3, v4}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;JLcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V

    .line 351
    return-void
.end method
