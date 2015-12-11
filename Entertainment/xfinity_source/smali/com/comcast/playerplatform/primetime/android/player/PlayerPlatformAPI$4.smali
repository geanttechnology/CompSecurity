.class Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$4;
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
    .line 1389
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$4;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTick(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 1392
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$4;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->sendHeartbeatMessage()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$1900(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V

    .line 1393
    return-void
.end method
