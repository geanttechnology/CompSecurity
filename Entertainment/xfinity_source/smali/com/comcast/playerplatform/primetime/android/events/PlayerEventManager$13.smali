.class Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;
.super Ljava/lang/Object;
.source "PlayerEventManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->mediaOpened(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;JJJDZ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

.field final synthetic val$availableAudioLanguages:Ljava/util/List;

.field final synthetic val$availableClosedCaptionTracks:Ljava/util/List;

.field final synthetic val$duration:J

.field final synthetic val$hasCC:Z

.field final synthetic val$height:J

.field final synthetic val$mediaType:Ljava/lang/String;

.field final synthetic val$openingLatency:D

.field final synthetic val$playbackSpeeds:Ljava/util/List;

.field final synthetic val$type:Ljava/lang/String;

.field final synthetic val$width:J


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;JJJDZ)V
    .locals 5

    .prologue
    .line 214
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$type:Ljava/lang/String;

    iput-object p3, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$mediaType:Ljava/lang/String;

    iput-object p4, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$playbackSpeeds:Ljava/util/List;

    iput-object p5, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$availableAudioLanguages:Ljava/util/List;

    iput-object p6, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$availableClosedCaptionTracks:Ljava/util/List;

    iput-wide p7, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$width:J

    iput-wide p9, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$height:J

    move-wide/from16 v0, p11

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$duration:J

    move-wide/from16 v0, p13

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$openingLatency:D

    move/from16 v0, p15

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$hasCC:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 19

    .prologue
    .line 217
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v0, v3, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    move-object/from16 v18, v0

    monitor-enter v18

    .line 218
    :try_start_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->this$0:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v3, v3, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v17

    .local v17, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .line 219
    .local v2, "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$type:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$mediaType:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$playbackSpeeds:Ljava/util/List;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$availableAudioLanguages:Ljava/util/List;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$availableClosedCaptionTracks:Ljava/util/List;

    move-object/from16 v0, p0

    iget-wide v8, v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$width:J

    move-object/from16 v0, p0

    iget-wide v10, v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$height:J

    move-object/from16 v0, p0

    iget-wide v12, v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$duration:J

    move-object/from16 v0, p0

    iget-wide v14, v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$openingLatency:D

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;->val$hasCC:Z

    move/from16 v16, v0

    invoke-virtual/range {v2 .. v16}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->mediaOpened(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;JJJDZ)V

    goto :goto_0

    .line 221
    .end local v2    # "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    .end local v17    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v3

    monitor-exit v18
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .restart local v17    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v18
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 222
    return-void
.end method
