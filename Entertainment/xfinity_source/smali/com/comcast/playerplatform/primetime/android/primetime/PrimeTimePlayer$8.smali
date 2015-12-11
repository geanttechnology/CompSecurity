.class Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$8;
.super Ljava/lang/Object;
.source "PrimeTimePlayer.java"

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;


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
    .line 1196
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$8;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V
    .locals 2
    .param p1, "mediaErrorCode"    # Lcom/adobe/ave/MediaErrorCode;
    .param p2, "s"    # Ljava/lang/String;

    .prologue
    .line 1199
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$8;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$200(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    move-result-object v0

    const-string v1, "PrimetimePlayer"

    invoke-virtual {v0, v1, p2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1201
    return-void
.end method

.method public onLoadComplete(Lcom/adobe/mediacore/MediaPlayerItem;)V
    .locals 3
    .param p1, "mediaPlayerItem"    # Lcom/adobe/mediacore/MediaPlayerItem;

    .prologue
    .line 1205
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$8;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$200(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    move-result-object v0

    const-string v1, "PrimetimePlayer"

    const-string v2, "Success"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1207
    return-void
.end method
