.class Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;
.super Ljava/lang/Object;
.source "AnalyticsHandler.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->heartBeat(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;

.field final synthetic val$asset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

.field final synthetic val$bitrate:Ljava/lang/Long;

.field final synthetic val$cc:Ljava/lang/String;

.field final synthetic val$currentPosition:Ljava/lang/Long;

.field final synthetic val$fps:Ljava/lang/Integer;

.field final synthetic val$fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

.field final synthetic val$millisecondsBuffered:Ljava/lang/Long;

.field final synthetic val$sap:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;Ljava/lang/Long;Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 0

    .prologue
    .line 85
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->this$0:Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$millisecondsBuffered:Ljava/lang/Long;

    iput-object p3, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    iput-object p4, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$currentPosition:Ljava/lang/Long;

    iput-object p5, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$bitrate:Ljava/lang/Long;

    iput-object p6, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$fps:Ljava/lang/Integer;

    iput-object p7, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$cc:Ljava/lang/String;

    iput-object p8, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$sap:Ljava/lang/String;

    iput-object p9, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$asset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 19

    .prologue
    .line 88
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v18

    .line 89
    .local v18, "runtime":Ljava/lang/Runtime;
    invoke-virtual/range {v18 .. v18}, Ljava/lang/Runtime;->totalMemory()J

    move-result-wide v6

    invoke-virtual/range {v18 .. v18}, Ljava/lang/Runtime;->freeMemory()J

    move-result-wide v8

    sub-long/2addr v6, v8

    invoke-virtual/range {v18 .. v18}, Ljava/lang/Runtime;->totalMemory()J

    move-result-wide v8

    div-long/2addr v6, v8

    long-to-float v0, v6

    move/from16 v17, v0

    .line 92
    .local v17, "memUsage":F
    new-instance v2, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-static/range {v17 .. v17}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$millisecondsBuffered:Ljava/lang/Long;

    invoke-direct/range {v2 .. v7}, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;-><init>(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Long;)V

    .line 93
    .local v2, "environment":Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;
    const/16 v16, 0x0

    .line 95
    .local v16, "fragment":Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    if-eqz v4, :cond_0

    .line 96
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    monitor-enter v9

    .line 97
    :try_start_0
    new-instance v3, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->getNumberOfFragments()I

    move-result v4

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    invoke-virtual {v6}, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->getFragmentSize()J

    move-result-wide v6

    long-to-int v5, v6

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    invoke-virtual {v6}, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->getDownloadLatency()J

    move-result-wide v6

    long-to-int v6, v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    invoke-virtual {v7}, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->getDownloadDuration()J

    move-result-wide v10

    long-to-int v7, v10

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    invoke-virtual {v8}, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->getFragmentDuration()J

    move-result-wide v10

    long-to-int v8, v10

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-direct/range {v3 .. v8}, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;-><init>(IIIILjava/lang/Integer;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 105
    .end local v16    # "fragment":Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;
    .local v3, "fragment":Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;
    :try_start_1
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->reset()V

    .line 106
    monitor-exit v9
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 109
    :goto_0
    new-instance v5, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->this$0:Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;

    # invokes: Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J
    invoke-static {v4}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->access$100(Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;)J

    move-result-wide v6

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$currentPosition:Ljava/lang/Long;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$bitrate:Ljava/lang/Long;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$fps:Ljava/lang/Integer;

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$cc:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$sap:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->val$asset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-object v14, v2

    move-object v15, v3

    invoke-direct/range {v5 .. v15}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;-><init>(JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;)V

    .line 121
    .local v5, "message":Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;->this$0:Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;

    # invokes: Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V
    invoke-static {v4, v5}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->access$200(Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 122
    return-void

    .line 106
    .end local v3    # "fragment":Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;
    .end local v5    # "message":Lcom/comcast/playerplatform/analytics/java/xmessage/messages/HeartbeatMessage;
    .restart local v16    # "fragment":Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;
    :catchall_0
    move-exception v4

    move-object/from16 v3, v16

    .end local v16    # "fragment":Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;
    .restart local v3    # "fragment":Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;
    :goto_1
    :try_start_2
    monitor-exit v9
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v4

    :catchall_1
    move-exception v4

    goto :goto_1

    .end local v3    # "fragment":Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;
    .restart local v16    # "fragment":Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;
    :cond_0
    move-object/from16 v3, v16

    .end local v16    # "fragment":Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;
    .restart local v3    # "fragment":Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;
    goto :goto_0
.end method
