.class Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;
.super Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;
.source "EventsByLeagueParser.java"


# instance fields
.field contentType:Ljava/lang/String;

.field eventRequestType:I

.field sendPartialErrorBroadcast:Z

.field sendSuccessBroadcast:Z


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 22
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;-><init>()V

    .line 24
    iput-boolean v1, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendSuccessBroadcast:Z

    .line 25
    iput-boolean v1, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendPartialErrorBroadcast:Z

    .line 26
    const-string v0, ""

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    .line 27
    iput v1, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->eventRequestType:I

    .line 22
    return-void
.end method


# virtual methods
.method broadcastIntent(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;I)V
    .locals 2
    .param p1, "success"    # Ljava/lang/Boolean;
    .param p2, "partial"    # Ljava/lang/Boolean;
    .param p3, "errorCode"    # Ljava/lang/Integer;
    .param p4, "type"    # I

    .prologue
    .line 285
    if-eqz p1, :cond_5

    .line 286
    packed-switch p4, :pswitch_data_0

    .line 353
    :cond_0
    :goto_0
    return-void

    .line 288
    :pswitch_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 289
    const-string v0, "com.espn.action.SPORTEVENTSBYLEAGUE_LIVE_UPDATED"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_0

    .line 290
    :cond_1
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 291
    const-string v0, "com.espn.action.SPORTEVENTSBYLEAGUE_UPCOMING_UPDATED"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_0

    .line 292
    :cond_2
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 293
    const-string v0, "com.espn.action.SPORTEVENTSBYLEAGUE_REPLAY_UPDATED"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_0

    .line 296
    :pswitch_1
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 297
    const-string v0, "com.espn.action.CHANNELEVENTSBYLEAGUE_LIVE_UPDATED"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_0

    .line 298
    :cond_3
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 299
    const-string v0, "com.espn.action.CHANNELEVENTSBYLEAGUE_UPCOMING_UPDATED"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_0

    .line 300
    :cond_4
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 301
    const-string v0, "com.espn.action.CHANNELEVENTSBYLEAGUE_REPLAY_UPDATED"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_0

    .line 307
    :cond_5
    if-eqz p2, :cond_a

    .line 308
    packed-switch p4, :pswitch_data_1

    goto :goto_0

    .line 310
    :pswitch_2
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 311
    const-string v0, "com.espn.action.SPORTEVENTSBYLEAGUE_LIVE_PARTIAL_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 312
    :cond_6
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 313
    const-string v0, "com.espn.action.SPORTEVENTSBYLEAGUE_UPCOMING_PARTIAL_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 314
    :cond_7
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 315
    const-string v0, "com.espn.action.SPORTEVENTSBYLEAGUE_REPLAY_PARTIAL_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 318
    :pswitch_3
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 319
    const-string v0, "com.espn.action.CHANNELEVENTSBYLEAGUE_LIVE_PARTIAL_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 320
    :cond_8
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 321
    const-string v0, "com.espn.action.CHANNELEVENTSBYLEAGUE_UPCOMING_PARTIAL_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 322
    :cond_9
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 323
    const-string v0, "com.espn.action.CHANNELEVENTSBYLEAGUE_REPLAY_PARTIAL_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 329
    :cond_a
    if-eqz p3, :cond_0

    .line 330
    packed-switch p4, :pswitch_data_2

    goto/16 :goto_0

    .line 332
    :pswitch_4
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 333
    const-string v0, "com.espn.action.SPORTEVENTSBYLEAGUE_LIVE_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 334
    :cond_b
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 335
    const-string v0, "com.espn.action.SPORTEVENTSBYLEAGUE_UPCOMING_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 336
    :cond_c
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 337
    const-string v0, "com.espn.action.SPORTEVENTSBYLEAGUE_REPLAY_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 340
    :pswitch_5
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 341
    const-string v0, "com.espn.action.CHANNELEVENTSBYLEAGUE_LIVE_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 342
    :cond_d
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 343
    const-string v0, "com.espn.action.CHANNELEVENTSBYLEAGUE_UPCOMING_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 344
    :cond_e
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/utilities/EPEventType;->getEventStr()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 345
    const-string v0, "com.espn.action.CHANNELEVENTSBYLEAGUE_REPLAY_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendBroadcast(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 286
    nop

    :pswitch_data_0
    .packed-switch 0x7
        :pswitch_0
        :pswitch_1
    .end packed-switch

    .line 308
    :pswitch_data_1
    .packed-switch 0x7
        :pswitch_2
        :pswitch_3
    .end packed-switch

    .line 330
    :pswitch_data_2
    .packed-switch 0x7
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method public errorHandler(I)V
    .locals 3
    .param p1, "errorCode"    # I

    .prologue
    const/4 v2, 0x0

    .line 277
    const/4 v0, 0x1

    if-eq p1, v0, :cond_0

    const/4 v0, 0x2

    if-ne p1, v0, :cond_1

    .line 278
    :cond_0
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iget v1, p0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->eventRequestType:I

    invoke-virtual {p0, v2, v2, v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->broadcastIntent(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;I)V

    .line 279
    :cond_1
    return-void
.end method

.method public parse(Lorg/json/JSONObject;Ljava/util/HashMap;)V
    .locals 41
    .param p1, "object"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 31
    .local p2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v36, "EventsByLeagueParser"

    const/16 v37, 0x3

    const/16 v38, 0x0

    invoke-static/range {v36 .. v38}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 34
    :try_start_0
    new-instance v14, Landroid/content/ContentValues;

    invoke-direct {v14}, Landroid/content/ContentValues;-><init>()V

    .line 35
    .local v14, "eventsBySportsValues":Landroid/content/ContentValues;
    new-instance v28, Landroid/content/ContentValues;

    invoke-direct/range {v28 .. v28}, Landroid/content/ContentValues;-><init>()V

    .line 37
    .local v28, "metaValues":Landroid/content/ContentValues;
    const-string v36, "eventType"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v36

    if-eqz v36, :cond_0

    .line 38
    const-string v36, "eventType"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Ljava/lang/String;

    move-object/from16 v0, v36

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->contentType:Ljava/lang/String;

    .line 40
    :cond_0
    const-string v36, "relationType"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v36

    if-eqz v36, :cond_1

    .line 41
    const-string v36, "relationType"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Ljava/lang/String;

    invoke-static/range {v36 .. v36}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v36

    move/from16 v0, v36

    move-object/from16 v1, p0

    iput v0, v1, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->eventRequestType:I

    .line 43
    :cond_1
    const-string v36, "eventWhere"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v36

    if-eqz v36, :cond_2

    const-string v36, "eventWhereArg"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v36

    if-eqz v36, :cond_2

    .line 45
    sget-object v38, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    const-string v39, "events"

    const-string v36, "eventWhere"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Ljava/lang/String;

    .line 46
    const-string v37, "eventWhereArg"

    move-object/from16 v0, p2

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v37

    check-cast v37, [Ljava/lang/String;

    .line 45
    move-object/from16 v0, v38

    move-object/from16 v1, v39

    move-object/from16 v2, v36

    move-object/from16 v3, v37

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->delAllRows(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 48
    :cond_2
    const-string v36, "categories"

    move-object/from16 v0, p1

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    .line 49
    .local v7, "catagoriesArray":Lorg/json/JSONArray;
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v8

    .line 50
    .local v8, "catagoriesArraySize":I
    if-lez v8, :cond_7

    .line 52
    const/16 v19, 0x0

    .local v19, "j":I
    :goto_0
    move/from16 v0, v19

    if-lt v0, v8, :cond_9

    .line 234
    if-eqz p2, :cond_3

    const-string v36, "ttl"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v36

    if-eqz v36, :cond_3

    .line 236
    :try_start_1
    const-string v37, "ttl"

    const-string v36, "ttl"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Ljava/lang/String;

    invoke-static/range {v36 .. v36}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v36

    invoke-static/range {v36 .. v36}, Lcom/espn/androidplayersdk/utilities/Utils;->getExpiryTime(I)Ljava/lang/String;

    move-result-object v36

    move-object/from16 v0, v28

    move-object/from16 v1, v37

    move-object/from16 v2, v36

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 243
    :cond_3
    :goto_1
    if-eqz p2, :cond_4

    :try_start_2
    const-string v36, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v36

    if-eqz v36, :cond_4

    .line 244
    const-string v37, "sportId"

    const-string v36, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Ljava/lang/String;

    move-object/from16 v0, v28

    move-object/from16 v1, v37

    move-object/from16 v2, v36

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    :cond_4
    if-eqz p2, :cond_2e

    const-string v36, "eventType"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v36

    if-eqz v36, :cond_2e

    .line 247
    const-string v37, "eventsType"

    const-string v36, "eventType"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Ljava/lang/String;

    move-object/from16 v0, v28

    move-object/from16 v1, v37

    move-object/from16 v2, v36

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    :goto_2
    const-string v36, "omniture"

    move-object/from16 v0, p1

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_5

    const-string v36, "omniture"

    move-object/from16 v0, p1

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_5

    .line 252
    const-string v36, "omnitureJson"

    const-string v37, "omniture"

    move-object/from16 v0, p1

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v37

    invoke-virtual/range {v37 .. v37}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v28

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 254
    :cond_5
    const-string v36, "resultsCount"

    move-object/from16 v0, p1

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_6

    const-string v36, "resultsCount"

    move-object/from16 v0, p1

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_6

    .line 255
    const-string v36, "count"

    const-string v37, "resultsCount"

    move-object/from16 v0, p1

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v28

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 257
    :cond_6
    const-string v37, "eventRelationId"

    const-string v36, "relationType"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Ljava/lang/String;

    move-object/from16 v0, v28

    move-object/from16 v1, v37

    move-object/from16 v2, v36

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 259
    sget-object v36, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    move-object/from16 v0, v36

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertOrUpdateMetaEventsTable(Landroid/content/ContentValues;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 268
    .end local v19    # "j":I
    :cond_7
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendSuccessBroadcast:Z

    move/from16 v36, v0

    if-eqz v36, :cond_31

    .line 269
    const/16 v36, 0x1

    invoke-static/range {v36 .. v36}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v36

    const/16 v37, 0x0

    const/16 v38, 0x0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->eventRequestType:I

    move/from16 v39, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    move-object/from16 v3, v38

    move/from16 v4, v39

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->broadcastIntent(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;I)V

    .line 273
    .end local v7    # "catagoriesArray":Lorg/json/JSONArray;
    .end local v8    # "catagoriesArraySize":I
    .end local v14    # "eventsBySportsValues":Landroid/content/ContentValues;
    .end local v28    # "metaValues":Landroid/content/ContentValues;
    :cond_8
    :goto_3
    return-void

    .line 54
    .restart local v7    # "catagoriesArray":Lorg/json/JSONArray;
    .restart local v8    # "catagoriesArraySize":I
    .restart local v14    # "eventsBySportsValues":Landroid/content/ContentValues;
    .restart local v19    # "j":I
    .restart local v28    # "metaValues":Landroid/content/ContentValues;
    :cond_9
    :try_start_3
    invoke-virtual {v14}, Landroid/content/ContentValues;->clear()V

    .line 55
    move/from16 v0, v19

    invoke-virtual {v7, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    .line 56
    .local v9, "categoriesObject":Lorg/json/JSONObject;
    const-string v36, "subcategories"

    move-object/from16 v0, v36

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v35

    .line 57
    .local v35, "subcategoriesArray":Lorg/json/JSONArray;
    invoke-virtual/range {v35 .. v35}, Lorg/json/JSONArray;->length()I

    move-result v34

    .line 58
    .local v34, "subcatagoriesArrayLength":I
    if-lez v34, :cond_a

    .line 59
    const/16 v17, 0x0

    .local v17, "i":I
    :goto_4
    move/from16 v0, v17

    move/from16 v1, v34

    if-lt v0, v1, :cond_b

    .line 52
    .end local v9    # "categoriesObject":Lorg/json/JSONObject;
    .end local v17    # "i":I
    .end local v34    # "subcatagoriesArrayLength":I
    .end local v35    # "subcategoriesArray":Lorg/json/JSONArray;
    :cond_a
    :goto_5
    add-int/lit8 v19, v19, 0x1

    goto/16 :goto_0

    .line 60
    .restart local v9    # "categoriesObject":Lorg/json/JSONObject;
    .restart local v17    # "i":I
    .restart local v34    # "subcatagoriesArrayLength":I
    .restart local v35    # "subcategoriesArray":Lorg/json/JSONArray;
    :cond_b
    move-object/from16 v0, v35

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v33

    .line 61
    .local v33, "subCatObj":Lorg/json/JSONObject;
    const-string v36, "id"

    move-object/from16 v0, v33

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_c

    const-string v36, "id"

    move-object/from16 v0, v33

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_c

    .line 62
    const-string v36, "league"

    const-string v37, "id"

    move-object/from16 v0, v33

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    :cond_c
    const-string v36, "name"

    move-object/from16 v0, v33

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_d

    const-string v36, "name"

    move-object/from16 v0, v33

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_d

    .line 64
    const-string v36, "leagueName"

    const-string v37, "name"

    move-object/from16 v0, v33

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    :cond_d
    const-string v36, "listings"

    move-object/from16 v0, v33

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v24

    .line 67
    .local v24, "listingsArray":Lorg/json/JSONArray;
    invoke-virtual/range {v24 .. v24}, Lorg/json/JSONArray;->length()I

    move-result v23

    .line 68
    .local v23, "listingArraysize":I
    if-lez v23, :cond_e

    .line 69
    const/16 v36, 0x1

    move/from16 v0, v36

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendSuccessBroadcast:Z
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 70
    const/16 v20, 0x0

    .local v20, "k":I
    :goto_6
    move/from16 v0, v20

    move/from16 v1, v23

    if-lt v0, v1, :cond_f

    .line 59
    .end local v20    # "k":I
    :cond_e
    add-int/lit8 v17, v17, 0x1

    goto/16 :goto_4

    .line 72
    .restart local v20    # "k":I
    :cond_f
    :try_start_4
    move-object/from16 v0, v24

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v15

    .line 74
    .local v15, "eventsObject":Lorg/json/JSONObject;
    const-string v36, "broadcastStartTime"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_10

    const-string v36, "broadcastStartTime"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_10

    .line 75
    const-string v36, "broadcastStartTime"

    const-string v37, "broadcastStartTime"

    move-object/from16 v0, v37

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    :cond_10
    const-string v36, "description"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_11

    const-string v36, "description"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_11

    .line 78
    const-string v36, "description"

    const-string v37, "description"

    move-object/from16 v0, v37

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    :cond_11
    const-string v36, "blackouts"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_12

    const-string v36, "blackouts"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_12

    .line 81
    const-string v36, "coverageType"

    const-string v37, "blackouts"

    move-object/from16 v0, v37

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v37

    invoke-virtual/range {v37 .. v37}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    :cond_12
    const-string v36, "categories"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_14

    const-string v36, "categories"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_14

    .line 84
    const-string v36, "categories"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v10

    .line 85
    .local v10, "categoryArray":Lorg/json/JSONArray;
    invoke-virtual {v10}, Lorg/json/JSONArray;->length()I

    move-result v36

    if-lez v36, :cond_14

    .line 86
    const/16 v36, 0x0

    move/from16 v0, v36

    invoke-virtual {v10, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v11

    .line 87
    .local v11, "categoryObj":Lorg/json/JSONObject;
    const-string v36, "name"

    move-object/from16 v0, v36

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_13

    const-string v36, "name"

    move-object/from16 v0, v36

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_13

    .line 88
    const-string v36, "SPORT"

    const-string v37, "name"

    move-object/from16 v0, v37

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 89
    :cond_13
    const-string v36, "abbreviation"

    move-object/from16 v0, v36

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_14

    const-string v36, "abbreviation"

    move-object/from16 v0, v36

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_14

    .line 90
    const-string v36, "sportCode"

    const-string v37, "abbreviation"

    move-object/from16 v0, v37

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 94
    .end local v10    # "categoryArray":Lorg/json/JSONArray;
    .end local v11    # "categoryObj":Lorg/json/JSONObject;
    :cond_14
    const-string v36, "program"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_15

    const-string v36, "program"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_15

    .line 95
    const-string v36, "program"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v30

    .line 96
    .local v30, "programObj":Lorg/json/JSONObject;
    const-string v36, "code"

    move-object/from16 v0, v30

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_15

    const-string v36, "code"

    move-object/from16 v0, v30

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_15

    .line 97
    const-string v36, "programingCode"

    const-string v37, "code"

    move-object/from16 v0, v30

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    .end local v30    # "programObj":Lorg/json/JSONObject;
    :cond_15
    const-string v36, "type"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_16

    const-string v36, "type"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_16

    .line 101
    const-string v36, "eventType"

    const-string v37, "type"

    move-object/from16 v0, v37

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    :cond_16
    const-string v36, "endTime"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_17

    const-string v36, "endTime"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_17

    .line 104
    const-string v36, "endTime"

    const-string v37, "endTime"

    move-object/from16 v0, v37

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    :cond_17
    const-string v36, "broadcasts"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_1b

    const-string v36, "broadcasts"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_1b

    .line 107
    const-string v36, "broadcasts"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5

    .line 108
    .local v5, "broadcastArray":Lorg/json/JSONArray;
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I

    move-result v36

    if-lez v36, :cond_1b

    .line 109
    const/16 v36, 0x0

    move/from16 v0, v36

    invoke-virtual {v5, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v6

    .line 110
    .local v6, "broadcastObj":Lorg/json/JSONObject;
    const-string v36, "abbreviation"

    move-object/from16 v0, v36

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_18

    const-string v36, "abbreviation"

    move-object/from16 v0, v36

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_18

    .line 111
    const-string v36, "networkCode"

    const-string v37, "abbreviation"

    move-object/from16 v0, v37

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    :cond_18
    const-string v36, "name"

    move-object/from16 v0, v36

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_19

    const-string v36, "name"

    move-object/from16 v0, v36

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_19

    .line 114
    const-string v36, "networkName"

    const-string v37, "name"

    move-object/from16 v0, v37

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 116
    :cond_19
    const-string v36, "ncsId"

    move-object/from16 v0, v36

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_1a

    const-string v36, "ncsId"

    move-object/from16 v0, v36

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_1a

    .line 117
    const-string v36, "networkId"

    const-string v37, "ncsId"

    move-object/from16 v0, v37

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    const-string v36, "networkId"

    const-string v37, "ncsId"

    move-object/from16 v0, v37

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v28

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 121
    :cond_1a
    const-string v36, "adobeResource"

    move-object/from16 v0, v36

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_1b

    const-string v36, "adobeResource"

    move-object/from16 v0, v36

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_1b

    .line 122
    const-string v36, "networkResourceId"

    const-string v37, "adobeResource"

    move-object/from16 v0, v37

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    .end local v5    # "broadcastArray":Lorg/json/JSONArray;
    .end local v6    # "broadcastObj":Lorg/json/JSONObject;
    :cond_1b
    const-string v36, "guid"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_1c

    const-string v36, "guid"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_1c

    .line 128
    const-string v36, "guid"

    const-string v37, "guid"

    move-object/from16 v0, v37

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    :cond_1c
    const-string v36, "startTime"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_1d

    const-string v36, "startTime"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_1d

    .line 131
    const-string v36, "startTime"

    const-string v37, "startTime"

    move-object/from16 v0, v37

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 133
    :cond_1d
    const-string v36, "id"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_1e

    const-string v36, "id"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_1e

    .line 134
    const-string v36, "eventId"

    const-string v37, "id"

    move-object/from16 v0, v37

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 136
    :cond_1e
    const-string v36, "name"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_1f

    const-string v36, "name"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_1f

    .line 137
    const-string v36, "showName"

    const-string v37, "name"

    move-object/from16 v0, v37

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 139
    :cond_1f
    const-string v36, "simulcastAiringId"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_20

    const-string v36, "simulcastAiringId"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_20

    .line 140
    const-string v36, "simulcastAiringId"

    const-string v37, "simulcastAiringId"

    move-object/from16 v0, v37

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 142
    :cond_20
    const-string v36, "seekInSeconds"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_21

    const-string v36, "seekInSeconds"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_21

    .line 143
    const-string v36, "seekInSeconds"

    const-string v37, "seekInSeconds"

    move-object/from16 v0, v37

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    :cond_21
    const-string v36, "parentalRating"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_22

    const-string v36, "parentalRating"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_22

    .line 146
    const-string v36, "parentalRating"

    const-string v37, "parentalRating"

    move-object/from16 v0, v37

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 148
    :cond_22
    const-string v36, "omniture"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_23

    const-string v36, "omniture"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_23

    .line 149
    const-string v36, "omnitureJson"

    const-string v37, "omniture"

    move-object/from16 v0, v37

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v37

    invoke-virtual/range {v37 .. v37}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 151
    :cond_23
    const-string v36, "thumbnails"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_26

    const-string v36, "thumbnails"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_26

    .line 152
    const-string v36, "thumbnails"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v18

    .line 154
    .local v18, "imageObj":Lorg/json/JSONObject;
    const-string v36, "small"

    move-object/from16 v0, v18

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_24

    const-string v36, "small"

    move-object/from16 v0, v18

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_24

    .line 155
    const-string v36, "small"

    move-object/from16 v0, v18

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v31

    .line 156
    .local v31, "small":Lorg/json/JSONObject;
    const-string v36, "href"

    move-object/from16 v0, v31

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_24

    const-string v36, "href"

    move-object/from16 v0, v31

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_24

    .line 157
    const-string v36, "imageSmall"

    const-string v37, "href"

    move-object/from16 v0, v31

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 160
    .end local v31    # "small":Lorg/json/JSONObject;
    :cond_24
    const-string v36, "medium"

    move-object/from16 v0, v18

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_25

    const-string v36, "medium"

    move-object/from16 v0, v18

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_25

    .line 161
    const-string v36, "medium"

    move-object/from16 v0, v18

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v27

    .line 162
    .local v27, "med":Lorg/json/JSONObject;
    const-string v36, "href"

    move-object/from16 v0, v27

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_25

    const-string v36, "href"

    move-object/from16 v0, v27

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_25

    .line 163
    const-string v36, "imageMed"

    const-string v37, "href"

    move-object/from16 v0, v27

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    .end local v27    # "med":Lorg/json/JSONObject;
    :cond_25
    const-string v36, "large"

    move-object/from16 v0, v18

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_26

    const-string v36, "large"

    move-object/from16 v0, v18

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_26

    .line 167
    const-string v36, "large"

    move-object/from16 v0, v18

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v21

    .line 168
    .local v21, "large":Lorg/json/JSONObject;
    const-string v36, "href"

    move-object/from16 v0, v21

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_26

    const-string v36, "href"

    move-object/from16 v0, v21

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_26

    .line 169
    const-string v36, "imageLarge"

    const-string v37, "href"

    move-object/from16 v0, v21

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 173
    .end local v18    # "imageObj":Lorg/json/JSONObject;
    .end local v21    # "large":Lorg/json/JSONObject;
    :cond_26
    const-string v36, "name"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_27

    const-string v36, "name"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_27

    .line 174
    const-string v36, "eventName"

    const-string v37, "name"

    move-object/from16 v0, v37

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    :cond_27
    const-string v36, "links"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_2b

    const-string v36, "links"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_2b

    .line 177
    const-string v36, "links"

    move-object/from16 v0, v36

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v22

    .line 178
    .local v22, "linksObj":Lorg/json/JSONObject;
    const-string v36, "source"

    move-object/from16 v0, v22

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_2b

    const-string v36, "source"

    move-object/from16 v0, v22

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_2b

    .line 179
    const-string v36, "source"

    move-object/from16 v0, v22

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v32

    .line 180
    .local v32, "sourceObj":Lorg/json/JSONObject;
    const-string v36, "hls"

    move-object/from16 v0, v32

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_2b

    const-string v36, "hls"

    move-object/from16 v0, v32

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_2b

    .line 181
    const-string v36, "hls"

    move-object/from16 v0, v32

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v16

    .line 183
    .local v16, "hlsObj":Lorg/json/JSONObject;
    const-string v36, "default"

    move-object/from16 v0, v16

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_28

    const-string v36, "default"

    move-object/from16 v0, v16

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_28

    .line 184
    const-string v36, "default"

    move-object/from16 v0, v16

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v12

    .line 185
    .local v12, "dfltObj":Lorg/json/JSONObject;
    const-string v36, "href"

    move-object/from16 v0, v36

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_28

    const-string v36, "href"

    move-object/from16 v0, v36

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_28

    .line 186
    const-string v36, "videoURLDefault"

    const-string v37, "href"

    move-object/from16 v0, v37

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    .end local v12    # "dfltObj":Lorg/json/JSONObject;
    :cond_28
    const-string v36, "high"

    move-object/from16 v0, v16

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_29

    const-string v36, "high"

    move-object/from16 v0, v16

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_29

    .line 191
    const-string v36, "high"

    move-object/from16 v0, v16

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v26

    .line 192
    .local v26, "lrgObj":Lorg/json/JSONObject;
    const-string v36, "href"

    move-object/from16 v0, v26

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_29

    const-string v36, "href"

    move-object/from16 v0, v26

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_29

    .line 193
    const-string v36, "videoURLLarge"

    const-string v37, "href"

    move-object/from16 v0, v26

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    .end local v26    # "lrgObj":Lorg/json/JSONObject;
    :cond_29
    const-string v36, "mid"

    move-object/from16 v0, v16

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_2a

    const-string v36, "mid"

    move-object/from16 v0, v16

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_2a

    .line 197
    const-string v36, "mid"

    move-object/from16 v0, v16

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v29

    .line 198
    .local v29, "midObj":Lorg/json/JSONObject;
    const-string v36, "href"

    move-object/from16 v0, v29

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_2a

    const-string v36, "href"

    move-object/from16 v0, v29

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_2a

    .line 199
    const-string v36, "videoURLMed"

    const-string v37, "href"

    move-object/from16 v0, v29

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 202
    .end local v29    # "midObj":Lorg/json/JSONObject;
    :cond_2a
    const-string v36, "low"

    move-object/from16 v0, v16

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_2b

    const-string v36, "low"

    move-object/from16 v0, v16

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_2b

    .line 203
    const-string v36, "low"

    move-object/from16 v0, v16

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v25

    .line 204
    .local v25, "lowObj":Lorg/json/JSONObject;
    const-string v36, "href"

    move-object/from16 v0, v25

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_2b

    const-string v36, "href"

    move-object/from16 v0, v25

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v36

    if-nez v36, :cond_2b

    .line 205
    const-string v36, "videoURLSmall"

    const-string v37, "href"

    move-object/from16 v0, v25

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v36

    move-object/from16 v1, v37

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 210
    .end local v16    # "hlsObj":Lorg/json/JSONObject;
    .end local v22    # "linksObj":Lorg/json/JSONObject;
    .end local v25    # "lowObj":Lorg/json/JSONObject;
    .end local v32    # "sourceObj":Lorg/json/JSONObject;
    :cond_2b
    const-string v37, "metaEventRelationId"

    .line 211
    const-string v36, "relationType"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Ljava/lang/String;

    .line 210
    move-object/from16 v0, v37

    move-object/from16 v1, v36

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    if-eqz p2, :cond_2c

    const-string v36, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v36

    if-eqz v36, :cond_2c

    .line 214
    const-string v37, "sportId"

    const-string v36, "sportId"

    move-object/from16 v0, p2

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Ljava/lang/String;

    move-object/from16 v0, v37

    move-object/from16 v1, v36

    invoke-virtual {v14, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 216
    :cond_2c
    sget-object v36, Lcom/espn/androidplayersdk/datamanager/DataManager;->feedsDbConn:Lcom/espn/androidplayersdk/datamanager/FeedsDB;

    move-object/from16 v0, v36

    invoke-virtual {v0, v14}, Lcom/espn/androidplayersdk/datamanager/FeedsDB;->insertIntoEventsTable(Landroid/content/ContentValues;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 70
    .end local v15    # "eventsObject":Lorg/json/JSONObject;
    :goto_7
    add-int/lit8 v20, v20, 0x1

    goto/16 :goto_6

    .line 218
    :catch_0
    move-exception v13

    .line 219
    .local v13, "e":Ljava/lang/Exception;
    :try_start_5
    const-string v36, "EventsByLeagueParser"

    const/16 v37, 0x5

    move-object/from16 v0, v36

    move/from16 v1, v37

    invoke-static {v0, v1, v13}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 220
    const/16 v36, 0x0

    move/from16 v0, v36

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendSuccessBroadcast:Z

    .line 221
    const/16 v36, 0x1

    move/from16 v0, v36

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendPartialErrorBroadcast:Z
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_7

    .line 227
    .end local v9    # "categoriesObject":Lorg/json/JSONObject;
    .end local v13    # "e":Ljava/lang/Exception;
    .end local v17    # "i":I
    .end local v20    # "k":I
    .end local v23    # "listingArraysize":I
    .end local v24    # "listingsArray":Lorg/json/JSONArray;
    .end local v33    # "subCatObj":Lorg/json/JSONObject;
    .end local v34    # "subcatagoriesArrayLength":I
    .end local v35    # "subcategoriesArray":Lorg/json/JSONArray;
    :catch_1
    move-exception v13

    .line 228
    .restart local v13    # "e":Ljava/lang/Exception;
    :try_start_6
    const-string v36, "EventsByLeagueParser"

    const/16 v37, 0x5

    move-object/from16 v0, v36

    move/from16 v1, v37

    invoke-static {v0, v1, v13}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 229
    const/16 v36, 0x0

    move/from16 v0, v36

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendSuccessBroadcast:Z

    .line 230
    const/16 v36, 0x1

    move/from16 v0, v36

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendPartialErrorBroadcast:Z
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto/16 :goto_5

    .line 262
    .end local v7    # "catagoriesArray":Lorg/json/JSONArray;
    .end local v8    # "catagoriesArraySize":I
    .end local v13    # "e":Ljava/lang/Exception;
    .end local v14    # "eventsBySportsValues":Landroid/content/ContentValues;
    .end local v19    # "j":I
    .end local v28    # "metaValues":Landroid/content/ContentValues;
    :catch_2
    move-exception v13

    .line 263
    .restart local v13    # "e":Ljava/lang/Exception;
    :try_start_7
    const-string v36, "EventsByLeagueParser"

    const/16 v37, 0x5

    move-object/from16 v0, v36

    move/from16 v1, v37

    invoke-static {v0, v1, v13}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 264
    const/16 v36, 0x0

    move/from16 v0, v36

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendSuccessBroadcast:Z

    .line 265
    const/16 v36, 0x0

    move/from16 v0, v36

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendPartialErrorBroadcast:Z

    .line 266
    const/16 v36, 0x2

    move-object/from16 v0, p0

    move/from16 v1, v36

    invoke-virtual {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->errorHandler(I)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 268
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendSuccessBroadcast:Z

    move/from16 v36, v0

    if-eqz v36, :cond_2f

    .line 269
    const/16 v36, 0x1

    invoke-static/range {v36 .. v36}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v36

    const/16 v37, 0x0

    const/16 v38, 0x0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->eventRequestType:I

    move/from16 v39, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    move-object/from16 v3, v38

    move/from16 v4, v39

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->broadcastIntent(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;I)V

    goto/16 :goto_3

    .line 237
    .end local v13    # "e":Ljava/lang/Exception;
    .restart local v7    # "catagoriesArray":Lorg/json/JSONArray;
    .restart local v8    # "catagoriesArraySize":I
    .restart local v14    # "eventsBySportsValues":Landroid/content/ContentValues;
    .restart local v19    # "j":I
    .restart local v28    # "metaValues":Landroid/content/ContentValues;
    :catch_3
    move-exception v13

    .line 238
    .restart local v13    # "e":Ljava/lang/Exception;
    :try_start_8
    const-string v36, "EventsByLeagueParser"

    const/16 v37, 0x5

    move-object/from16 v0, v36

    move/from16 v1, v37

    invoke-static {v0, v1, v13}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 239
    const-string v36, "ttl"

    const-string v37, ""

    move-object/from16 v0, v28

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_2
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto/16 :goto_1

    .line 267
    .end local v7    # "catagoriesArray":Lorg/json/JSONArray;
    .end local v8    # "catagoriesArraySize":I
    .end local v13    # "e":Ljava/lang/Exception;
    .end local v14    # "eventsBySportsValues":Landroid/content/ContentValues;
    .end local v19    # "j":I
    .end local v28    # "metaValues":Landroid/content/ContentValues;
    :catchall_0
    move-exception v36

    .line 268
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendSuccessBroadcast:Z

    move/from16 v37, v0

    if-eqz v37, :cond_30

    .line 269
    const/16 v37, 0x1

    invoke-static/range {v37 .. v37}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v37

    const/16 v38, 0x0

    const/16 v39, 0x0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->eventRequestType:I

    move/from16 v40, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v37

    move-object/from16 v2, v38

    move-object/from16 v3, v39

    move/from16 v4, v40

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->broadcastIntent(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;I)V

    .line 272
    :cond_2d
    :goto_8
    throw v36

    .line 249
    .restart local v7    # "catagoriesArray":Lorg/json/JSONArray;
    .restart local v8    # "catagoriesArraySize":I
    .restart local v14    # "eventsBySportsValues":Landroid/content/ContentValues;
    .restart local v19    # "j":I
    .restart local v28    # "metaValues":Landroid/content/ContentValues;
    :cond_2e
    :try_start_9
    const-string v36, "eventsType"

    const-string v37, ""

    move-object/from16 v0, v28

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_2
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    goto/16 :goto_2

    .line 270
    .end local v7    # "catagoriesArray":Lorg/json/JSONArray;
    .end local v8    # "catagoriesArraySize":I
    .end local v14    # "eventsBySportsValues":Landroid/content/ContentValues;
    .end local v19    # "j":I
    .end local v28    # "metaValues":Landroid/content/ContentValues;
    .restart local v13    # "e":Ljava/lang/Exception;
    :cond_2f
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendPartialErrorBroadcast:Z

    move/from16 v36, v0

    if-eqz v36, :cond_8

    .line 271
    const/16 v36, 0x0

    const/16 v37, 0x1

    invoke-static/range {v37 .. v37}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v37

    const/16 v38, 0x0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->eventRequestType:I

    move/from16 v39, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    move-object/from16 v3, v38

    move/from16 v4, v39

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->broadcastIntent(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;I)V

    goto/16 :goto_3

    .line 270
    .end local v13    # "e":Ljava/lang/Exception;
    :cond_30
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendPartialErrorBroadcast:Z

    move/from16 v37, v0

    if-eqz v37, :cond_2d

    .line 271
    const/16 v37, 0x0

    const/16 v38, 0x1

    invoke-static/range {v38 .. v38}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v38

    const/16 v39, 0x0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->eventRequestType:I

    move/from16 v40, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v37

    move-object/from16 v2, v38

    move-object/from16 v3, v39

    move/from16 v4, v40

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->broadcastIntent(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;I)V

    goto :goto_8

    .line 270
    .restart local v7    # "catagoriesArray":Lorg/json/JSONArray;
    .restart local v8    # "catagoriesArraySize":I
    .restart local v14    # "eventsBySportsValues":Landroid/content/ContentValues;
    .restart local v28    # "metaValues":Landroid/content/ContentValues;
    :cond_31
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->sendPartialErrorBroadcast:Z

    move/from16 v36, v0

    if-eqz v36, :cond_8

    .line 271
    const/16 v36, 0x0

    const/16 v37, 0x1

    invoke-static/range {v37 .. v37}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v37

    const/16 v38, 0x0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->eventRequestType:I

    move/from16 v39, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    move-object/from16 v3, v38

    move/from16 v4, v39

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;->broadcastIntent(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;I)V

    goto/16 :goto_3
.end method
