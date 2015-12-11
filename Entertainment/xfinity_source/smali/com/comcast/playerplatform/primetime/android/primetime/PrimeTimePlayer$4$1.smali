.class Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;
.super Ljava/lang/Object;
.source "PrimeTimePlayer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->onLoadInfo(Lcom/adobe/mediacore/qos/LoadInfo;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;

.field final synthetic val$loadInfo:Lcom/adobe/mediacore/qos/LoadInfo;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;Lcom/adobe/mediacore/qos/LoadInfo;)V
    .locals 0

    .prologue
    .line 1036
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->this$1:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->val$loadInfo:Lcom/adobe/mediacore/qos/LoadInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    .line 1039
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->val$loadInfo:Lcom/adobe/mediacore/qos/LoadInfo;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/LoadInfo;->getSize()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 1040
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->this$1:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$2000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    move-result-object v8

    monitor-enter v8

    .line 1041
    :try_start_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->this$1:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$2000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    move-result-object v1

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->val$loadInfo:Lcom/adobe/mediacore/qos/LoadInfo;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/LoadInfo;->getDownloadDuration()J

    move-result-wide v2

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->val$loadInfo:Lcom/adobe/mediacore/qos/LoadInfo;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/LoadInfo;->getMediaDuration()J

    move-result-wide v4

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->val$loadInfo:Lcom/adobe/mediacore/qos/LoadInfo;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/LoadInfo;->getSize()J

    move-result-wide v6

    invoke-virtual/range {v1 .. v7}, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->addFragment(JJJ)V

    .line 1044
    monitor-exit v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1045
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->val$loadInfo:Lcom/adobe/mediacore/qos/LoadInfo;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/LoadInfo;->getDownloadDuration()J

    move-result-wide v0

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->val$loadInfo:Lcom/adobe/mediacore/qos/LoadInfo;

    invoke-virtual {v2}, Lcom/adobe/mediacore/qos/LoadInfo;->getMediaDuration()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->this$1:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1046
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->this$1:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v1

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->val$loadInfo:Lcom/adobe/mediacore/qos/LoadInfo;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/LoadInfo;->getDownloadDuration()J

    move-result-wide v2

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->val$loadInfo:Lcom/adobe/mediacore/qos/LoadInfo;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/LoadInfo;->getMediaDuration()J

    move-result-wide v4

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->val$loadInfo:Lcom/adobe/mediacore/qos/LoadInfo;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/LoadInfo;->getSize()J

    move-result-wide v6

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;->val$loadInfo:Lcom/adobe/mediacore/qos/LoadInfo;

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/LoadInfo;->getUrl()Ljava/lang/String;

    move-result-object v8

    invoke-virtual/range {v1 .. v8}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->fragmentWarning(JJJLjava/lang/String;)V

    .line 1052
    :cond_0
    return-void

    .line 1044
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v8
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method
