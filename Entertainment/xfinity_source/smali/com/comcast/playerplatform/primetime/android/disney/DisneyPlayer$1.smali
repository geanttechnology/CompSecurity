.class Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$1;
.super Ljava/lang/Object;
.source "DisneyPlayer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playMedia(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

.field final synthetic val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
    .locals 0

    .prologue
    .line 221
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 230
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->activity:Landroid/app/Activity;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$000(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Landroid/app/Activity;

    move-result-object v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->activity:Landroid/app/Activity;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$000(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Landroid/app/Activity;

    move-result-object v1

    .line 231
    .local v1, "playerActivity":Landroid/app/Activity;
    :goto_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerManager:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$400(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$1;->val$media:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSurface:Landroid/view/SurfaceView;
    invoke-static {v4}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$200(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Landroid/view/SurfaceView;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/SurfaceView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v4

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->newPlayerHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;
    invoke-static {v5}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$300(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    move-result-object v5

    invoke-virtual {v2, v1, v3, v4, v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->getPlayer(Landroid/app/Activity;Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Landroid/view/SurfaceHolder;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 239
    .end local v1    # "playerActivity":Landroid/app/Activity;
    :cond_0
    :goto_1
    return-void

    .line 230
    :cond_1
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v2

    check-cast v2, Lcom/comcast/playerplatform/primetime/android/asset/DisneyAsset;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/asset/DisneyAsset;->getActivity()Landroid/app/Activity;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 232
    :catch_0
    move-exception v0

    .line 233
    .local v0, "ex":Ljava/lang/Exception;
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 234
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->onBufferComplete()V

    .line 235
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->handleDisneyException(Ljava/lang/Exception;)V
    invoke-static {v2, v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$600(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Ljava/lang/Exception;)V

    goto :goto_1
.end method
