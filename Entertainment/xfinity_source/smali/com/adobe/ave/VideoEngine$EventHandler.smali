.class Lcom/adobe/ave/VideoEngine$EventHandler;
.super Landroid/os/Handler;
.source "VideoEngine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/ave/VideoEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "EventHandler"
.end annotation


# instance fields
.field private mVideoEngine:Lcom/adobe/ave/VideoEngine;

.field final synthetic this$0:Lcom/adobe/ave/VideoEngine;


# direct methods
.method public constructor <init>(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/VideoEngine;Landroid/os/Looper;)V
    .locals 0
    .param p2, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p3, "looper"    # Landroid/os/Looper;

    .prologue
    .line 1167
    iput-object p1, p0, Lcom/adobe/ave/VideoEngine$EventHandler;->this$0:Lcom/adobe/ave/VideoEngine;

    .line 1168
    invoke-direct {p0, p3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 1169
    iput-object p2, p0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    .line 1170
    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 30
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 1174
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mNativeContext:J
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$100(Lcom/adobe/ave/VideoEngine;)J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-nez v2, :cond_1

    .line 1478
    :cond_0
    :goto_0
    return-void

    .line 1179
    :cond_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 1182
    move-object/from16 v0, p1

    iget v2, v0, Landroid/os/Message;->what:I

    sparse-switch v2, :sswitch_data_0

    goto :goto_0

    .line 1186
    :sswitch_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->ERROR:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1188
    sget-object v15, Lcom/adobe/ave/MediaErrorCode;->GENERIC_ERROR:Lcom/adobe/ave/MediaErrorCode;

    .line 1189
    .local v15, "errorCode":Lcom/adobe/ave/MediaErrorCode;
    invoke-static {}, Lcom/adobe/ave/MediaErrorCode;->values()[Lcom/adobe/ave/MediaErrorCode;

    move-result-object v3

    array-length v4, v3

    const/4 v2, 0x0

    :goto_1
    if-ge v2, v4, :cond_2

    aget-object v25, v3, v2

    .line 1191
    .local v25, "m":Lcom/adobe/ave/MediaErrorCode;
    invoke-virtual/range {v25 .. v25}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v5

    move-object/from16 v0, p1

    iget v7, v0, Landroid/os/Message;->arg1:I

    if-ne v5, v7, :cond_3

    .line 1193
    move-object/from16 v15, v25

    .line 1198
    .end local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v3, v4, v15, v2}, Lcom/adobe/ave/VideoEngineListener;->onError(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V

    goto :goto_0

    .line 1189
    .restart local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 1206
    .end local v15    # "errorCode":Lcom/adobe/ave/MediaErrorCode;
    .end local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :sswitch_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->PLAY_STATE:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1208
    sget-object v27, Lcom/adobe/ave/PlayState;->UNINITIALIZED:Lcom/adobe/ave/PlayState;

    .line 1209
    .local v27, "playState":Lcom/adobe/ave/PlayState;
    invoke-static {}, Lcom/adobe/ave/PlayState;->values()[Lcom/adobe/ave/PlayState;

    move-result-object v3

    array-length v4, v3

    const/4 v2, 0x0

    :goto_2
    if-ge v2, v4, :cond_4

    aget-object v26, v3, v2

    .line 1211
    .local v26, "p":Lcom/adobe/ave/PlayState;
    invoke-virtual/range {v26 .. v26}, Lcom/adobe/ave/PlayState;->getValue()I

    move-result v5

    move-object/from16 v0, p1

    iget v7, v0, Landroid/os/Message;->arg1:I

    if-ne v5, v7, :cond_5

    .line 1213
    move-object/from16 v27, v26

    .line 1218
    .end local v26    # "p":Lcom/adobe/ave/PlayState;
    :cond_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    move-object/from16 v0, v27

    invoke-virtual {v2, v3, v0}, Lcom/adobe/ave/VideoEngineListener;->onPlayState(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/PlayState;)V

    goto/16 :goto_0

    .line 1209
    .restart local v26    # "p":Lcom/adobe/ave/PlayState;
    :cond_5
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 1226
    .end local v26    # "p":Lcom/adobe/ave/PlayState;
    .end local v27    # "playState":Lcom/adobe/ave/PlayState;
    :sswitch_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->STREAM_SWITCH:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1228
    move-object/from16 v0, p1

    iget-object v0, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    move-object/from16 v20, v0

    check-cast v20, Lcom/adobe/ave/VideoEngine$customMessage;

    .line 1230
    .local v20, "customMsg":Lcom/adobe/ave/VideoEngine$customMessage;
    sget-object v6, Lcom/adobe/ave/SwitchInfo;->ABR:Lcom/adobe/ave/SwitchInfo;

    .line 1231
    .local v6, "switchInfo":Lcom/adobe/ave/SwitchInfo;
    invoke-static {}, Lcom/adobe/ave/SwitchInfo;->values()[Lcom/adobe/ave/SwitchInfo;

    move-result-object v3

    array-length v4, v3

    const/4 v2, 0x0

    :goto_3
    if-ge v2, v4, :cond_6

    aget-object v28, v3, v2

    .line 1233
    .local v28, "s":Lcom/adobe/ave/SwitchInfo;
    invoke-virtual/range {v28 .. v28}, Lcom/adobe/ave/SwitchInfo;->getValue()I

    move-result v5

    move-object/from16 v0, v20

    iget v7, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_n1:I

    if-ne v5, v7, :cond_7

    .line 1235
    move-object/from16 v6, v28

    .line 1240
    .end local v28    # "s":Lcom/adobe/ave/SwitchInfo;
    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    move-object/from16 v0, v20

    iget-wide v4, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_l1:J

    move-object/from16 v0, v20

    iget v7, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_n2:I

    move-object/from16 v0, v20

    iget-wide v8, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_l2:J

    long-to-int v8, v8

    invoke-virtual/range {v2 .. v8}, Lcom/adobe/ave/VideoEngineListener;->onStreamSwitch(Lcom/adobe/ave/VideoEngine;JLcom/adobe/ave/SwitchInfo;II)V

    goto/16 :goto_0

    .line 1231
    .restart local v28    # "s":Lcom/adobe/ave/SwitchInfo;
    :cond_7
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .line 1248
    .end local v6    # "switchInfo":Lcom/adobe/ave/SwitchInfo;
    .end local v20    # "customMsg":Lcom/adobe/ave/VideoEngine$customMessage;
    .end local v28    # "s":Lcom/adobe/ave/SwitchInfo;
    :sswitch_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->STREAM_METADATA:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1250
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Lcom/adobe/ave/StreamMetadata;

    invoke-virtual {v3, v4, v2}, Lcom/adobe/ave/VideoEngineListener;->onStreamMetadata(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/StreamMetadata;)V

    goto/16 :goto_0

    .line 1258
    :sswitch_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->DRM_METADATA:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1261
    move-object/from16 v0, p1

    iget-object v0, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    move-object/from16 v20, v0

    check-cast v20, Lcom/adobe/ave/VideoEngine$customMessage;

    .line 1262
    .restart local v20    # "customMsg":Lcom/adobe/ave/VideoEngine$customMessage;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v8

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    move-object/from16 v0, v20

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_obj:Ljava/lang/Object;

    check-cast v2, [B

    move-object v10, v2

    check-cast v10, [B

    move-object/from16 v0, v20

    iget v11, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_n1:I

    move-object/from16 v0, v20

    iget-wide v12, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_l1:J

    invoke-virtual/range {v8 .. v13}, Lcom/adobe/ave/VideoEngineListener;->onDRMMetadata(Lcom/adobe/ave/VideoEngine;[BIJ)V

    goto/16 :goto_0

    .line 1270
    .end local v20    # "customMsg":Lcom/adobe/ave/VideoEngine$customMessage;
    :sswitch_5
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->TIMELINE:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1272
    sget-object v29, Lcom/adobe/ave/UpdateType;->INITIAL:Lcom/adobe/ave/UpdateType;

    .line 1273
    .local v29, "updateType":Lcom/adobe/ave/UpdateType;
    invoke-static {}, Lcom/adobe/ave/UpdateType;->values()[Lcom/adobe/ave/UpdateType;

    move-result-object v3

    array-length v4, v3

    const/4 v2, 0x0

    :goto_4
    if-ge v2, v4, :cond_8

    aget-object v23, v3, v2

    .line 1275
    .local v23, "e":Lcom/adobe/ave/UpdateType;
    invoke-virtual/range {v23 .. v23}, Lcom/adobe/ave/UpdateType;->getValue()I

    move-result v5

    move-object/from16 v0, p1

    iget v7, v0, Landroid/os/Message;->arg1:I

    if-ne v5, v7, :cond_9

    .line 1277
    move-object/from16 v29, v23

    .line 1282
    .end local v23    # "e":Lcom/adobe/ave/UpdateType;
    :cond_8
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    move-object/from16 v0, v29

    invoke-virtual {v2, v3, v0}, Lcom/adobe/ave/VideoEngineListener;->onTimeline(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/UpdateType;)V

    goto/16 :goto_0

    .line 1273
    .restart local v23    # "e":Lcom/adobe/ave/UpdateType;
    :cond_9
    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    .line 1290
    .end local v23    # "e":Lcom/adobe/ave/UpdateType;
    .end local v29    # "updateType":Lcom/adobe/ave/UpdateType;
    :sswitch_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->DATA:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1292
    move-object/from16 v0, p1

    iget-object v0, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    move-object/from16 v20, v0

    check-cast v20, Lcom/adobe/ave/VideoEngine$customMessage;

    .line 1294
    .restart local v20    # "customMsg":Lcom/adobe/ave/VideoEngine$customMessage;
    sget-object v12, Lcom/adobe/ave/DataType;->DT_3GPP_CAPTION_METADATA:Lcom/adobe/ave/DataType;

    .line 1295
    .local v12, "dataType":Lcom/adobe/ave/DataType;
    invoke-static {}, Lcom/adobe/ave/DataType;->values()[Lcom/adobe/ave/DataType;

    move-result-object v3

    array-length v4, v3

    const/4 v2, 0x0

    :goto_5
    if-ge v2, v4, :cond_a

    aget-object v21, v3, v2

    .line 1297
    .local v21, "d":Lcom/adobe/ave/DataType;
    invoke-virtual/range {v21 .. v21}, Lcom/adobe/ave/DataType;->getValue()I

    move-result v5

    move-object/from16 v0, v20

    iget v7, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_n1:I

    if-ne v5, v7, :cond_b

    .line 1299
    move-object/from16 v12, v21

    .line 1304
    .end local v21    # "d":Lcom/adobe/ave/DataType;
    :cond_a
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v8

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    move-object/from16 v0, v20

    iget-wide v10, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_l1:J

    move-object/from16 v0, v20

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_obj:Ljava/lang/Object;

    check-cast v2, [B

    move-object v13, v2

    check-cast v13, [B

    move-object/from16 v0, v20

    iget v14, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_n2:I

    invoke-virtual/range {v8 .. v14}, Lcom/adobe/ave/VideoEngineListener;->onData(Lcom/adobe/ave/VideoEngine;JLcom/adobe/ave/DataType;[BI)V

    goto/16 :goto_0

    .line 1295
    .restart local v21    # "d":Lcom/adobe/ave/DataType;
    :cond_b
    add-int/lit8 v2, v2, 0x1

    goto :goto_5

    .line 1312
    .end local v12    # "dataType":Lcom/adobe/ave/DataType;
    .end local v20    # "customMsg":Lcom/adobe/ave/VideoEngine$customMessage;
    .end local v21    # "d":Lcom/adobe/ave/DataType;
    :sswitch_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->MANIFEST_LOAD:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1314
    move-object/from16 v0, p1

    iget-object v0, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    move-object/from16 v20, v0

    check-cast v20, Lcom/adobe/ave/VideoEngine$customMessage;

    .line 1316
    .restart local v20    # "customMsg":Lcom/adobe/ave/VideoEngine$customMessage;
    sget-object v15, Lcom/adobe/ave/MediaErrorCode;->GENERIC_ERROR:Lcom/adobe/ave/MediaErrorCode;

    .line 1317
    .restart local v15    # "errorCode":Lcom/adobe/ave/MediaErrorCode;
    invoke-static {}, Lcom/adobe/ave/MediaErrorCode;->values()[Lcom/adobe/ave/MediaErrorCode;

    move-result-object v3

    array-length v4, v3

    const/4 v2, 0x0

    :goto_6
    if-ge v2, v4, :cond_c

    aget-object v25, v3, v2

    .line 1319
    .restart local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    invoke-virtual/range {v25 .. v25}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v5

    move-object/from16 v0, v20

    iget v7, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_n1:I

    if-ne v5, v7, :cond_d

    .line 1321
    move-object/from16 v15, v25

    .line 1326
    .end local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_c
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    move-object/from16 v0, v20

    iget v0, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_n2:I

    move/from16 v16, v0

    move-object/from16 v0, v20

    iget-wide v2, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_l1:J

    long-to-int v0, v2

    move/from16 v17, v0

    move-object/from16 v0, v20

    iget-wide v0, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_l2:J

    move-wide/from16 v18, v0

    invoke-virtual/range {v13 .. v19}, Lcom/adobe/ave/VideoEngineListener;->onManifestLoad(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;IIJ)V

    goto/16 :goto_0

    .line 1317
    .restart local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_d
    add-int/lit8 v2, v2, 0x1

    goto :goto_6

    .line 1334
    .end local v15    # "errorCode":Lcom/adobe/ave/MediaErrorCode;
    .end local v20    # "customMsg":Lcom/adobe/ave/VideoEngine$customMessage;
    .end local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :sswitch_8
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->SEEK_COMPLETE:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1336
    sget-object v15, Lcom/adobe/ave/MediaErrorCode;->GENERIC_ERROR:Lcom/adobe/ave/MediaErrorCode;

    .line 1337
    .restart local v15    # "errorCode":Lcom/adobe/ave/MediaErrorCode;
    invoke-static {}, Lcom/adobe/ave/MediaErrorCode;->values()[Lcom/adobe/ave/MediaErrorCode;

    move-result-object v3

    array-length v4, v3

    const/4 v2, 0x0

    :goto_7
    if-ge v2, v4, :cond_e

    aget-object v25, v3, v2

    .line 1339
    .restart local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    invoke-virtual/range {v25 .. v25}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v5

    move-object/from16 v0, p1

    iget v7, v0, Landroid/os/Message;->arg1:I

    if-ne v5, v7, :cond_f

    .line 1341
    move-object/from16 v15, v25

    .line 1346
    .end local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_e
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v2, v3, v15}, Lcom/adobe/ave/VideoEngineListener;->onSeekComplete(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;)V

    goto/16 :goto_0

    .line 1337
    .restart local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_f
    add-int/lit8 v2, v2, 0x1

    goto :goto_7

    .line 1354
    .end local v15    # "errorCode":Lcom/adobe/ave/MediaErrorCode;
    .end local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :sswitch_9
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->WARNING:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1356
    sget-object v15, Lcom/adobe/ave/MediaErrorCode;->GENERIC_ERROR:Lcom/adobe/ave/MediaErrorCode;

    .line 1357
    .restart local v15    # "errorCode":Lcom/adobe/ave/MediaErrorCode;
    invoke-static {}, Lcom/adobe/ave/MediaErrorCode;->values()[Lcom/adobe/ave/MediaErrorCode;

    move-result-object v3

    array-length v4, v3

    const/4 v2, 0x0

    :goto_8
    if-ge v2, v4, :cond_10

    aget-object v25, v3, v2

    .line 1359
    .restart local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    invoke-virtual/range {v25 .. v25}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v5

    move-object/from16 v0, p1

    iget v7, v0, Landroid/os/Message;->arg1:I

    if-ne v5, v7, :cond_11

    .line 1361
    move-object/from16 v15, v25

    .line 1366
    .end local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_10
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v3, v4, v15, v2}, Lcom/adobe/ave/VideoEngineListener;->onWarning(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1357
    .restart local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_11
    add-int/lit8 v2, v2, 0x1

    goto :goto_8

    .line 1374
    .end local v15    # "errorCode":Lcom/adobe/ave/MediaErrorCode;
    .end local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :sswitch_a
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->DICTIONARY_DATA:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1376
    move-object/from16 v0, p1

    iget-object v0, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    move-object/from16 v20, v0

    check-cast v20, Lcom/adobe/ave/VideoEngine$customMessage;

    .line 1377
    .restart local v20    # "customMsg":Lcom/adobe/ave/VideoEngine$customMessage;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    move-object/from16 v0, v20

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_obj:Ljava/lang/Object;

    check-cast v2, Lcom/adobe/ave/Dictionary;

    move-object/from16 v0, v20

    iget-wide v8, v0, Lcom/adobe/ave/VideoEngine$customMessage;->m_l1:J

    invoke-virtual {v3, v4, v2, v8, v9}, Lcom/adobe/ave/VideoEngineListener;->onDictionaryData(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/Dictionary;J)V

    goto/16 :goto_0

    .line 1385
    .end local v20    # "customMsg":Lcom/adobe/ave/VideoEngine$customMessage;
    :sswitch_b
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->LOAD_INFO:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1387
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v3, v4, v2}, Lcom/adobe/ave/VideoEngineListener;->onLoadInfo(Lcom/adobe/ave/VideoEngine;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1395
    :sswitch_c
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->TRICK_PLAY_ENDED:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1397
    sget-object v15, Lcom/adobe/ave/MediaErrorCode;->GENERIC_ERROR:Lcom/adobe/ave/MediaErrorCode;

    .line 1398
    .restart local v15    # "errorCode":Lcom/adobe/ave/MediaErrorCode;
    invoke-static {}, Lcom/adobe/ave/MediaErrorCode;->values()[Lcom/adobe/ave/MediaErrorCode;

    move-result-object v3

    array-length v4, v3

    const/4 v2, 0x0

    :goto_9
    if-ge v2, v4, :cond_12

    aget-object v25, v3, v2

    .line 1400
    .restart local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    invoke-virtual/range {v25 .. v25}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v5

    move-object/from16 v0, p1

    iget v7, v0, Landroid/os/Message;->arg1:I

    if-ne v5, v7, :cond_13

    .line 1402
    move-object/from16 v15, v25

    .line 1406
    .end local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_12
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v2, v3, v15}, Lcom/adobe/ave/VideoEngineListener;->onTrickPlayEnded(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;)V

    goto/16 :goto_0

    .line 1398
    .restart local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_13
    add-int/lit8 v2, v2, 0x1

    goto :goto_9

    .line 1413
    .end local v15    # "errorCode":Lcom/adobe/ave/MediaErrorCode;
    .end local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :sswitch_d
    const-string v2, "VideoEngine(j)"

    const-string v3, "Handler : kCTDRMError!!!"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1414
    move-object/from16 v0, p1

    iget-object v0, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    move-object/from16 v22, v0

    check-cast v22, Lcom/adobe/ave/drm/DRMError;

    .line 1415
    .local v22, "drmError":Lcom/adobe/ave/drm/DRMError;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->DRM_ERROR:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_14

    .line 1418
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    move-object/from16 v0, v22

    invoke-virtual {v2, v3, v0}, Lcom/adobe/ave/VideoEngineListener;->onDRMError(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/drm/DRMError;)V

    .line 1421
    :cond_14
    invoke-virtual/range {v22 .. v22}, Lcom/adobe/ave/drm/DRMError;->getMajorError()J

    move-result-wide v2

    sget-object v4, Lcom/adobe/ave/MediaErrorCode;->AAXS_UnknownConnectionType:Lcom/adobe/ave/MediaErrorCode;

    invoke-virtual {v4}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v4

    int-to-long v4, v4

    cmp-long v2, v2, v4

    if-ltz v2, :cond_15

    invoke-virtual/range {v22 .. v22}, Lcom/adobe/ave/drm/DRMError;->getMajorError()J

    move-result-wide v2

    sget-object v4, Lcom/adobe/ave/MediaErrorCode;->AAXS_NoDigitalProtectionAvail:Lcom/adobe/ave/MediaErrorCode;

    invoke-virtual {v4}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v4

    int-to-long v4, v4

    cmp-long v2, v2, v4

    if-lez v2, :cond_16

    .line 1422
    :cond_15
    invoke-virtual/range {v22 .. v22}, Lcom/adobe/ave/drm/DRMError;->getMajorError()J

    move-result-wide v2

    sget-object v4, Lcom/adobe/ave/MediaErrorCode;->AAXS_NoOPConstraintInPixelConstraints:Lcom/adobe/ave/MediaErrorCode;

    invoke-virtual {v4}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v4

    int-to-long v4, v4

    cmp-long v2, v2, v4

    if-ltz v2, :cond_0

    invoke-virtual/range {v22 .. v22}, Lcom/adobe/ave/drm/DRMError;->getMajorError()J

    move-result-wide v2

    sget-object v4, Lcom/adobe/ave/MediaErrorCode;->AAXS_MinorErr_DisplayResolutionLargerThanConstraint:Lcom/adobe/ave/MediaErrorCode;

    invoke-virtual {v4}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v4

    int-to-long v4, v4

    cmp-long v2, v2, v4

    if-gtz v2, :cond_0

    .line 1425
    :cond_16
    :try_start_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    invoke-virtual {v2}, Lcom/adobe/ave/VideoEngine;->reset()V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 1427
    :catch_0
    move-exception v24

    .line 1428
    .local v24, "exception":Lcom/adobe/ave/VideoEngineException;
    const-string v2, "VideoEngine(j)"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error while calling VideoEngine.reset() for output protection error: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, v24

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 1439
    .end local v22    # "drmError":Lcom/adobe/ave/drm/DRMError;
    .end local v24    # "exception":Lcom/adobe/ave/VideoEngineException;
    :sswitch_e
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->BACKGROUND_MANIFEST_ERROR:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1441
    sget-object v15, Lcom/adobe/ave/MediaErrorCode;->GENERIC_ERROR:Lcom/adobe/ave/MediaErrorCode;

    .line 1442
    .restart local v15    # "errorCode":Lcom/adobe/ave/MediaErrorCode;
    invoke-static {}, Lcom/adobe/ave/MediaErrorCode;->values()[Lcom/adobe/ave/MediaErrorCode;

    move-result-object v3

    array-length v4, v3

    const/4 v2, 0x0

    :goto_a
    if-ge v2, v4, :cond_17

    aget-object v25, v3, v2

    .line 1444
    .restart local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    invoke-virtual/range {v25 .. v25}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v5

    move-object/from16 v0, p1

    iget v7, v0, Landroid/os/Message;->arg1:I

    if-ne v5, v7, :cond_18

    .line 1446
    move-object/from16 v15, v25

    .line 1451
    .end local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_17
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v3, v4, v15, v2}, Lcom/adobe/ave/VideoEngineListener;->onBackgroundManifestError(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1442
    .restart local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_18
    add-int/lit8 v2, v2, 0x1

    goto :goto_a

    .line 1459
    .end local v15    # "errorCode":Lcom/adobe/ave/MediaErrorCode;
    .end local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :sswitch_f
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;

    move-result-object v2

    sget-object v3, Lcom/adobe/ave/ListenerType;->BACKGROUND_MANIFEST_WARNING:Lcom/adobe/ave/ListenerType;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1461
    sget-object v15, Lcom/adobe/ave/MediaErrorCode;->GENERIC_ERROR:Lcom/adobe/ave/MediaErrorCode;

    .line 1462
    .restart local v15    # "errorCode":Lcom/adobe/ave/MediaErrorCode;
    invoke-static {}, Lcom/adobe/ave/MediaErrorCode;->values()[Lcom/adobe/ave/MediaErrorCode;

    move-result-object v3

    array-length v4, v3

    const/4 v2, 0x0

    :goto_b
    if-ge v2, v4, :cond_19

    aget-object v25, v3, v2

    .line 1464
    .restart local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    invoke-virtual/range {v25 .. v25}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v5

    move-object/from16 v0, p1

    iget v7, v0, Landroid/os/Message;->arg1:I

    if-ne v5, v7, :cond_1a

    .line 1466
    move-object/from16 v15, v25

    .line 1471
    .end local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_19
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    # getter for: Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;
    invoke-static {v2}, Lcom/adobe/ave/VideoEngine;->access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/adobe/ave/VideoEngine$EventHandler;->mVideoEngine:Lcom/adobe/ave/VideoEngine;

    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v3, v4, v15, v2}, Lcom/adobe/ave/VideoEngineListener;->onBackgroundManifestWarning(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1462
    .restart local v25    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_1a
    add-int/lit8 v2, v2, 0x1

    goto :goto_b

    .line 1182
    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x2 -> :sswitch_1
        0x4 -> :sswitch_2
        0x8 -> :sswitch_3
        0x10 -> :sswitch_4
        0x20 -> :sswitch_5
        0x40 -> :sswitch_6
        0x80 -> :sswitch_7
        0x100 -> :sswitch_8
        0x200 -> :sswitch_9
        0x400 -> :sswitch_a
        0x800 -> :sswitch_b
        0x1000 -> :sswitch_c
        0x2000 -> :sswitch_d
        0x4000 -> :sswitch_e
        0x8000 -> :sswitch_f
    .end sparse-switch
.end method
