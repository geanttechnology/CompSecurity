.class Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$6;
.super Ljava/lang/Object;
.source "EspnPlayer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->updatePrimetime(Lcom/espn/androidplayersdk/datamanager/EPStream;)V
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
    .line 520
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$6;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 523
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$6;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$700(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$6;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v1

    const-wide/16 v2, -0x1

    const/4 v4, 0x0

    invoke-interface {v0, v1, v2, v3, v4}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;JLcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V

    .line 524
    return-void
.end method
