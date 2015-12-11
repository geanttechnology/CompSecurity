.class Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$3;
.super Ljava/lang/Object;
.source "PrimeTimePlayer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V
    .locals 0

    .prologue
    .line 938
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 941
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    const/4 v1, 0x0

    # setter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->pendingRetry:Z
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1602(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Z)Z

    .line 942
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # ++operator for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryCount:I
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1104(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)I

    .line 944
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 945
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->getCurrentChannel()Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentPosition:J
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1700(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)J

    move-result-wide v2

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    invoke-static {v4}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$900(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v4

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;JLcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V

    .line 947
    :cond_0
    return-void
.end method
