.class public Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;
.super Ljava/lang/Object;
.source "ADMS_MediaMeasurement.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement$1;,
        Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement$ADMS_MediaMeasurementHolder;
    }
.end annotation


# instance fields
.field public channel:Ljava/lang/String;

.field public completeCloseOffsetThreshold:I

.field public contextDataMapping:Ljava/util/Hashtable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Hashtable",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field public delegate:Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurementDelegate;

.field protected list:Ljava/util/Hashtable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Hashtable",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field public segmentByMilestones:Z

.field public segmentByOffsetMilestones:Z

.field public trackEvents:Ljava/lang/String;

.field public trackMilestones:Ljava/lang/String;

.field public trackOffsetMilestones:Ljava/lang/String;

.field public trackSeconds:I

.field public trackVars:Ljava/lang/String;


# direct methods
.method private constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object v2, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->list:Ljava/util/Hashtable;

    .line 13
    const-string v0, ""

    iput-object v0, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->trackVars:Ljava/lang/String;

    .line 14
    const-string v0, ""

    iput-object v0, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->trackEvents:Ljava/lang/String;

    .line 15
    const-string v0, ""

    iput-object v0, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->channel:Ljava/lang/String;

    .line 16
    iput v1, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->trackSeconds:I

    .line 18
    const/4 v0, 0x1

    iput v0, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->completeCloseOffsetThreshold:I

    .line 20
    const-string v0, ""

    iput-object v0, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->trackMilestones:Ljava/lang/String;

    .line 21
    iput-boolean v1, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->segmentByMilestones:Z

    .line 22
    const-string v0, ""

    iput-object v0, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->trackOffsetMilestones:Ljava/lang/String;

    .line 23
    iput-boolean v1, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->segmentByOffsetMilestones:Z

    .line 25
    iput-object v2, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->contextDataMapping:Ljava/util/Hashtable;

    .line 27
    iput-object v2, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->delegate:Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurementDelegate;

    .line 54
    return-void
.end method

.method synthetic constructor <init>(Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement$1;

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;-><init>()V

    return-void
.end method

.method private isInteger(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x0

    .line 799
    :try_start_0
    check-cast p1, Ljava/lang/Integer;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .end local p1    # "value":Ljava/lang/Object;
    if-eqz p1, :cond_0

    const/4 v0, 0x1

    .line 802
    :cond_0
    :goto_0
    return v0

    .line 800
    .restart local p1    # "value":Ljava/lang/Object;
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private isString(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x0

    .line 787
    :try_start_0
    check-cast p1, Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .end local p1    # "value":Ljava/lang/Object;
    if-eqz p1, :cond_0

    const/4 v0, 0x1

    .line 790
    :cond_0
    :goto_0
    return v0

    .line 788
    .restart local p1    # "value":Ljava/lang/Object;
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public static sharedInstance()Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;
    .locals 1

    .prologue
    .line 39
    sget-object v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement$ADMS_MediaMeasurementHolder;->baseInstance:Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;

    return-object v0
.end method

.method private toString(Ljava/lang/Object;)Ljava/lang/String;
    .locals 0
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 794
    check-cast p1, Ljava/lang/String;

    .end local p1    # "value":Ljava/lang/Object;
    return-object p1
.end method


# virtual methods
.method protected buildContextData(Ljava/util/Hashtable;Ljava/util/Hashtable;Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;)V
    .locals 22
    .param p3, "media"    # Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Hashtable",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/util/Hashtable",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;",
            ")V"
        }
    .end annotation

    .prologue
    .line 211
    .local p1, "contextData":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/Object;>;"
    .local p2, "variableOverrides":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v8, "a.media."

    .line 212
    .local v8, "ns":Ljava/lang/String;
    new-instance v11, Ljava/lang/StringBuffer;

    const-string v17, "linkTrackVars"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-direct {v11, v0}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 213
    .local v11, "v":Ljava/lang/StringBuffer;
    new-instance v5, Ljava/lang/StringBuffer;

    const-string v17, "linkTrackEvents"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-direct {v5, v0}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 214
    .local v5, "e":Ljava/lang/StringBuffer;
    const-string v9, "m_i"

    .line 219
    .local v9, "pe":Ljava/lang/String;
    const-string v17, "a.contentType"

    const-string v18, "video"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 220
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->channel:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_0

    .line 221
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "channel"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->channel:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 222
    :cond_0
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "name"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->name:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 223
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "playerName"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->playerName:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 224
    move-object/from16 v0, p3

    iget-wide v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    move-wide/from16 v18, v0

    const-wide/16 v20, 0x0

    cmpl-double v17, v18, v20

    if-lez v17, :cond_1

    .line 225
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "length"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, ""

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p3

    iget-wide v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    move-wide/from16 v20, v0

    move-wide/from16 v0, v20

    double-to-int v0, v0

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 227
    :cond_1
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "timePlayed"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, ""

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p3

    iget-wide v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timePlayedSinceTrack:D

    move-wide/from16 v20, v0

    invoke-static/range {v20 .. v21}, Ljava/lang/Math;->floor(D)D

    move-result-wide v20

    move-wide/from16 v0, v20

    double-to-int v0, v0

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 230
    move-object/from16 v0, p3

    iget-boolean v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->viewTracked:Z

    move/from16 v17, v0

    if-nez v17, :cond_2

    .line 231
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "view"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    const/16 v18, 0x1

    invoke-static/range {v18 .. v18}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 232
    const-string v9, "m_s"

    .line 233
    const/16 v17, 0x1

    move/from16 v0, v17

    move-object/from16 v1, p3

    iput-boolean v0, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->viewTracked:Z

    .line 237
    :cond_2
    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segment:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_4

    .line 238
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "segmentNum"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, ""

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p3

    iget v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentNum:I

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 239
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "segment"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segment:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 240
    move-object/from16 v0, p3

    iget-wide v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentLength:D

    move-wide/from16 v18, v0

    const-wide/16 v20, 0x0

    cmpl-double v17, v18, v20

    if-lez v17, :cond_3

    .line 241
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "segmentLength"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, ""

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p3

    iget-wide v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentLength:D

    move-wide/from16 v20, v0

    move-object/from16 v0, v18

    move-wide/from16 v1, v20

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 243
    :cond_3
    move-object/from16 v0, p3

    iget-boolean v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentChanged:Z

    move/from16 v17, v0

    if-eqz v17, :cond_4

    move-object/from16 v0, p3

    iget-wide v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timePlayedSinceTrack:D

    move-wide/from16 v18, v0

    const-wide/16 v20, 0x0

    cmpl-double v17, v18, v20

    if-lez v17, :cond_4

    .line 244
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "segmentView"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    const/16 v18, 0x1

    invoke-static/range {v18 .. v18}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 249
    :cond_4
    move-object/from16 v0, p3

    iget-boolean v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->completeTracked:Z

    move/from16 v17, v0

    if-nez v17, :cond_5

    move-object/from16 v0, p3

    iget-boolean v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->complete:Z

    move/from16 v17, v0

    if-eqz v17, :cond_5

    .line 250
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "complete"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    const/16 v18, 0x1

    invoke-static/range {v18 .. v18}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 251
    const/16 v17, 0x1

    move/from16 v0, v17

    move-object/from16 v1, p3

    iput-boolean v0, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->completeTracked:Z

    .line 255
    :cond_5
    move-object/from16 v0, p3

    iget v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastMilestone:I

    move/from16 v17, v0

    if-lez v17, :cond_6

    .line 256
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "milestone"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, ""

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p3

    iget v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastMilestone:I

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 258
    :cond_6
    move-object/from16 v0, p3

    iget v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastOffsetMilestone:I

    move/from16 v17, v0

    if-lez v17, :cond_7

    .line 259
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "offsetMilestone"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, ""

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p3

    iget v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastOffsetMilestone:I

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 263
    :cond_7
    const-string v10, "video"

    .line 264
    .local v10, "pev3":Ljava/lang/String;
    const-string v17, "pe"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-virtual {v0, v1, v9}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 265
    const-string v17, "pev3"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-virtual {v0, v1, v10}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 272
    new-instance v6, Ljava/lang/StringBuffer;

    invoke-direct {v6}, Ljava/lang/StringBuffer;-><init>()V

    .line 273
    .local v6, "events2":Ljava/lang/StringBuffer;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->contextDataMapping:Ljava/util/Hashtable;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_1b

    .line 274
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->contextDataMapping:Ljava/util/Hashtable;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Ljava/util/Hashtable;->keys()Ljava/util/Enumeration;

    move-result-object v7

    .line 275
    .local v7, "keys":Ljava/util/Enumeration;, "Ljava/util/Enumeration<Ljava/lang/String;>;"
    :cond_8
    :goto_0
    invoke-interface {v7}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v17

    if-eqz v17, :cond_19

    .line 276
    invoke-interface {v7}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    .line 277
    .local v12, "varKey":Ljava/lang/String;
    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v17

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v18

    move/from16 v0, v17

    move/from16 v1, v18

    if-le v0, v1, :cond_b

    const/16 v17, 0x0

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v18

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v12, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_b

    .line 278
    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v17

    move/from16 v0, v17

    invoke-virtual {v12, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v13

    .line 282
    .local v13, "varSubKey":Ljava/lang/String;
    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->contextDataMapping:Ljava/util/Hashtable;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v12}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    .line 283
    .local v14, "varValue":Ljava/lang/Object;
    move-object/from16 v0, p0

    invoke-direct {v0, v14}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isString(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_15

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Ljava/util/Hashtable;->containsKey(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_15

    .line 284
    check-cast v14, Ljava/lang/String;

    .end local v14    # "varValue":Ljava/lang/Object;
    const-string v17, ","

    move-object/from16 v0, v17

    invoke-virtual {v14, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v15

    .line 285
    .local v15, "varValueList":[Ljava/lang/String;
    const/16 v16, 0x0

    .local v16, "varValueNum":I
    :goto_2
    array-length v0, v15

    move/from16 v17, v0

    move/from16 v0, v16

    move/from16 v1, v17

    if-ge v0, v1, :cond_8

    .line 286
    aget-object v14, v15, v16

    .line 287
    .local v14, "varValue":Ljava/lang/String;
    const-string v17, "a.contentType"

    move-object/from16 v0, v17

    invoke-virtual {v12, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_c

    .line 288
    invoke-virtual {v11}, Ljava/lang/StringBuffer;->length()I

    move-result v17

    if-lez v17, :cond_9

    .line 289
    const-string v17, ","

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 290
    invoke-static {v14}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 292
    :cond_9
    check-cast v14, Ljava/lang/String;

    .end local v14    # "varValue":Ljava/lang/String;
    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/String;

    check-cast v17, Ljava/lang/String;

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-virtual {v0, v14, v1}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 285
    :cond_a
    :goto_3
    add-int/lit8 v16, v16, 0x1

    goto :goto_2

    .line 280
    .end local v13    # "varSubKey":Ljava/lang/String;
    .end local v15    # "varValueList":[Ljava/lang/String;
    .end local v16    # "varValueNum":I
    :cond_b
    const-string v13, ""

    .restart local v13    # "varSubKey":Ljava/lang/String;
    goto :goto_1

    .line 293
    .restart local v14    # "varValue":Ljava/lang/String;
    .restart local v15    # "varValueList":[Ljava/lang/String;
    .restart local v16    # "varValueNum":I
    :cond_c
    const-string v17, ""

    move-object/from16 v0, v17

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-nez v17, :cond_a

    .line 294
    const-string v17, "view"

    move-object/from16 v0, v17

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-nez v17, :cond_d

    const-string v17, "segmentView"

    move-object/from16 v0, v17

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-nez v17, :cond_d

    const-string v17, "complete"

    move-object/from16 v0, v17

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-nez v17, :cond_d

    const-string v17, "timePlayed"

    move-object/from16 v0, v17

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_11

    .line 295
    :cond_d
    const-string v17, "timePlayed"

    move-object/from16 v0, v17

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_f

    .line 296
    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_a

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/Integer;->intValue()I

    move-result v17

    if-lez v17, :cond_a

    .line 298
    invoke-virtual {v6}, Ljava/lang/StringBuffer;->length()I

    move-result v17

    if-lez v17, :cond_e

    const-string v17, ","

    :goto_4
    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 299
    invoke-static {v14}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 300
    const-string v17, "="

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 301
    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 303
    invoke-virtual {v5}, Ljava/lang/StringBuffer;->length()I

    move-result v17

    if-lez v17, :cond_a

    .line 304
    const-string v17, ","

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 305
    invoke-static {v14}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 306
    const-string v17, "="

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 307
    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    goto/16 :goto_3

    .line 298
    :cond_e
    const-string v17, ""

    goto :goto_4

    .line 310
    :cond_f
    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_a

    .line 311
    invoke-virtual {v6}, Ljava/lang/StringBuffer;->length()I

    move-result v17

    if-lez v17, :cond_10

    const-string v17, ","

    :goto_5
    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 312
    invoke-static {v14}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 313
    invoke-virtual {v5}, Ljava/lang/StringBuffer;->length()I

    move-result v17

    if-lez v17, :cond_a

    .line 314
    const-string v17, ","

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 315
    invoke-static {v14}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_3

    .line 311
    :cond_10
    const-string v17, ""

    goto :goto_5

    .line 318
    :cond_11
    const-string v17, "segment"

    move-object/from16 v0, v17

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_13

    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "Num"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/util/Hashtable;->containsKey(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_13

    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "Num"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_13

    .line 319
    invoke-virtual {v11}, Ljava/lang/StringBuffer;->length()I

    move-result v17

    if-lez v17, :cond_12

    .line 320
    const-string v17, ","

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 321
    invoke-static {v14}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 323
    :cond_12
    invoke-static {v14}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, ""

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v19

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, "Num"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, ":"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    invoke-static/range {v19 .. v19}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_3

    .line 325
    :cond_13
    invoke-virtual {v11}, Ljava/lang/StringBuffer;->length()I

    move-result v17

    if-lez v17, :cond_14

    .line 326
    const-string v17, ","

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 327
    invoke-static {v14}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 329
    :cond_14
    invoke-static {v14}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_3

    .line 333
    .end local v15    # "varValueList":[Ljava/lang/String;
    .end local v16    # "varValueNum":I
    .local v14, "varValue":Ljava/lang/Object;
    :cond_15
    const-string v17, "milestones"

    move-object/from16 v0, v17

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-nez v17, :cond_16

    const-string v17, "offsetMilestones"

    move-object/from16 v0, v17

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_8

    .line 335
    :cond_16
    const/16 v17, 0x0

    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v18

    add-int/lit8 v18, v18, -0x1

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v12, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v12

    .line 337
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->contextDataMapping:Ljava/util/Hashtable;

    move-object/from16 v17, v0

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v18

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "s"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Hashtable;

    .line 339
    .local v4, "castHash":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Ljava/util/Hashtable;->containsKey(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_8

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_8

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/util/Hashtable;->containsKey(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_8

    .line 340
    invoke-virtual {v5}, Ljava/lang/StringBuffer;->length()I

    move-result v17

    if-lez v17, :cond_17

    .line 341
    const-string v17, ","

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 342
    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 344
    :cond_17
    invoke-virtual {v6}, Ljava/lang/StringBuffer;->length()I

    move-result v17

    if-lez v17, :cond_18

    const-string v17, ","

    :goto_6
    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 345
    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    goto/16 :goto_0

    .line 344
    :cond_18
    const-string v17, ""

    goto :goto_6

    .line 350
    .end local v4    # "castHash":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v12    # "varKey":Ljava/lang/String;
    .end local v13    # "varSubKey":Ljava/lang/String;
    .end local v14    # "varValue":Ljava/lang/Object;
    :cond_19
    const-string v17, "events"

    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 365
    :cond_1a
    const-string v17, "linkTrackVars"

    invoke-virtual {v11}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 366
    const-string v17, "linkTrackEvents"

    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 367
    return-void

    .line 354
    .end local v7    # "keys":Ljava/util/Enumeration;, "Ljava/util/Enumeration<Ljava/lang/String;>;"
    :cond_1b
    invoke-virtual {v11}, Ljava/lang/StringBuffer;->length()I

    move-result v17

    if-nez v17, :cond_1c

    .line 355
    const-string v17, "None"

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 357
    :cond_1c
    invoke-virtual/range {p1 .. p1}, Ljava/util/Hashtable;->keys()Ljava/util/Enumeration;

    move-result-object v7

    .line 358
    .restart local v7    # "keys":Ljava/util/Enumeration;, "Ljava/util/Enumeration<Ljava/lang/String;>;"
    :goto_7
    invoke-interface {v7}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v17

    if-eqz v17, :cond_1a

    .line 359
    const-string v17, ",contextdata."

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 360
    invoke-interface {v7}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/String;

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_7
.end method

.method protected cleanName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 58
    const-string v0, "\n"

    const-string v1, ""

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p1

    .line 59
    const-string v0, "\r"

    const-string v1, ""

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p1

    .line 60
    const-string v0, "--**--"

    const-string v1, ""

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p1

    .line 61
    return-object p1
.end method

.method public clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 49
    new-instance v0, Ljava/lang/CloneNotSupportedException;

    invoke-direct {v0}, Ljava/lang/CloneNotSupportedException;-><init>()V

    throw v0
.end method

.method public close(Ljava/lang/String;)V
    .locals 11
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x0

    const/4 v3, 0x0

    const-wide/high16 v4, -0x4010000000000000L    # -1.0

    .line 158
    move-object v1, p0

    move-object v2, p1

    move v6, v3

    move-wide v8, v4

    move-object v10, v7

    invoke-virtual/range {v1 .. v10}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->playerEvent(Ljava/lang/String;IDILjava/lang/String;DLjava/lang/Object;)Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;

    .line 159
    return-void
.end method

.method public complete(Ljava/lang/String;D)V
    .locals 12
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "offset"    # D

    .prologue
    const/4 v7, 0x0

    .line 186
    const/4 v3, 0x5

    const/4 v6, 0x0

    const-wide/high16 v8, -0x4010000000000000L    # -1.0

    move-object v1, p0

    move-object v2, p1

    move-wide v4, p2

    move-object v10, v7

    invoke-virtual/range {v1 .. v10}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->playerEvent(Ljava/lang/String;IDILjava/lang/String;DLjava/lang/Object;)Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;

    .line 187
    return-void
.end method

.method protected isBoolean(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x0

    .line 811
    :try_start_0
    check-cast p1, Ljava/lang/Boolean;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .end local p1    # "value":Ljava/lang/Object;
    if-eqz p1, :cond_0

    const/4 v0, 0x1

    .line 814
    :cond_0
    :goto_0
    return v0

    .line 812
    .restart local p1    # "value":Ljava/lang/Object;
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method protected isSet(D)Z
    .locals 3
    .param p1, "val"    # D

    .prologue
    .line 755
    const-wide/16 v0, 0x0

    cmpl-double v0, p1, v0

    if-nez v0, :cond_0

    .line 756
    const/4 v0, 0x0

    .line 758
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method protected isSet(F)Z
    .locals 4
    .param p1, "val"    # F

    .prologue
    .line 748
    float-to-double v0, p1

    const-wide/16 v2, 0x0

    cmpl-double v0, v0, v2

    if-nez v0, :cond_0

    .line 749
    const/4 v0, 0x0

    .line 751
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method protected isSet(I)Z
    .locals 1
    .param p1, "val"    # I

    .prologue
    .line 741
    if-nez p1, :cond_0

    .line 742
    const/4 v0, 0x0

    .line 744
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method protected isSet(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "val"    # Ljava/lang/Object;

    .prologue
    .line 772
    if-nez p1, :cond_0

    .line 773
    const/4 v0, 0x0

    .line 781
    :goto_0
    return v0

    .line 774
    :cond_0
    invoke-direct {p0, p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isString(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 775
    invoke-direct {p0, p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->toString(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v0

    goto :goto_0

    .line 776
    :cond_1
    invoke-direct {p0, p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isInteger(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 777
    invoke-virtual {p0, p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->toInteger(Ljava/lang/Object;)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(I)Z

    move-result v0

    goto :goto_0

    .line 778
    :cond_2
    invoke-virtual {p0, p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isBoolean(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 779
    invoke-virtual {p0, p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->toBoolean(Ljava/lang/Object;)Z

    move-result v0

    invoke-virtual {p0, v0}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Z)Z

    move-result v0

    goto :goto_0

    .line 781
    :cond_3
    const/4 v0, 0x1

    goto :goto_0
.end method

.method protected isSet(Ljava/lang/String;)Z
    .locals 2
    .param p1, "val"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 762
    if-nez p1, :cond_1

    .line 768
    :cond_0
    :goto_0
    return v0

    .line 765
    :cond_1
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_0

    .line 768
    const/4 v0, 0x1

    goto :goto_0
.end method

.method protected isSet(Z)Z
    .locals 0
    .param p1, "val"    # Z

    .prologue
    .line 737
    return p1
.end method

.method public open(Ljava/lang/String;DLjava/lang/String;)V
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "length"    # D
    .param p4, "playerName"    # Ljava/lang/String;

    .prologue
    .line 148
    move-object v0, p0

    .line 149
    .local v0, "m":Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;
    const/4 v5, 0x0

    move-object v1, p1

    move-wide v2, p2

    move-object v4, p4

    invoke-virtual/range {v0 .. v5}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->open(Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;)V

    .line 150
    return-void
.end method

.method public open(Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "length"    # D
    .param p4, "playerName"    # Ljava/lang/String;
    .param p5, "playerID"    # Ljava/lang/String;

    .prologue
    .line 73
    new-instance v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;

    invoke-direct {v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;-><init>()V

    .line 75
    .local v1, "mediaItem":Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;
    invoke-virtual {p0, p4}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5

    .end local p4    # "playerName":Ljava/lang/String;
    :goto_0
    invoke-virtual {p0, p4}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->cleanName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p4

    .line 77
    .restart local p4    # "playerName":Ljava/lang/String;
    invoke-virtual {p0, p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 78
    invoke-virtual {p0, p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->cleanName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 81
    :cond_0
    invoke-virtual {p0, p2, p3}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(D)Z

    move-result v3

    if-nez v3, :cond_1

    .line 82
    const-wide/high16 p2, -0x4010000000000000L    # -1.0

    .line 84
    :cond_1
    invoke-virtual {p0, p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_7

    invoke-virtual {p0, p4}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 85
    iget-object v3, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->list:Ljava/util/Hashtable;

    invoke-virtual {p0, v3}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 86
    new-instance v3, Ljava/util/Hashtable;

    invoke-direct {v3}, Ljava/util/Hashtable;-><init>()V

    iput-object v3, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->list:Ljava/util/Hashtable;

    .line 88
    :cond_2
    iget-object v3, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->list:Ljava/util/Hashtable;

    invoke-virtual {v3, p1}, Ljava/util/Hashtable;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 89
    invoke-virtual {p0, p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->close(Ljava/lang/String;)V

    .line 91
    :cond_3
    invoke-virtual {p0, p5}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 92
    iget-object v3, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->list:Ljava/util/Hashtable;

    invoke-virtual {v3}, Ljava/util/Hashtable;->keys()Ljava/util/Enumeration;

    move-result-object v0

    .line 93
    .local v0, "keys":Ljava/util/Enumeration;, "Ljava/util/Enumeration<Ljava/lang/String;>;"
    :cond_4
    :goto_1
    invoke-interface {v0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v3

    if-eqz v3, :cond_6

    .line 94
    invoke-interface {v0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 99
    .local v2, "mediaName":Ljava/lang/String;
    iget-object v3, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->list:Ljava/util/Hashtable;

    invoke-virtual {v3, v2}, Ljava/util/Hashtable;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->list:Ljava/util/Hashtable;

    invoke-virtual {v3, v2}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;

    check-cast v3, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;

    iget-object v3, v3, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->playerID:Ljava/lang/String;

    invoke-virtual {v3, p5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 100
    invoke-virtual {p0, v2}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->close(Ljava/lang/String;)V

    goto :goto_1

    .line 75
    .end local v0    # "keys":Ljava/util/Enumeration;, "Ljava/util/Enumeration<Ljava/lang/String;>;"
    .end local v2    # "mediaName":Ljava/lang/String;
    :cond_5
    const-string p4, "Not_Specified"

    goto :goto_0

    .line 105
    :cond_6
    iput-object p1, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->name:Ljava/lang/String;

    .line 106
    iput-wide p2, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    .line 107
    const-wide/16 v4, 0x0

    iput-wide v4, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->offset:D

    .line 108
    const-wide/16 v4, 0x0

    iput-wide v4, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->percent:D

    .line 109
    invoke-virtual {p0, p4}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->cleanName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->playerName:Ljava/lang/String;

    .line 110
    iput-object p5, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->playerID:Ljava/lang/String;

    .line 111
    const-wide/16 v4, 0x0

    iput-wide v4, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timePlayed:D

    .line 112
    const-wide/16 v4, 0x0

    iput-wide v4, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timePlayedSinceTrack:D

    .line 113
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    long-to-double v4, v4

    const-wide v6, 0x408f400000000000L    # 1000.0

    div-double/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    iput-wide v4, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timestamp:D

    .line 114
    const/4 v3, 0x0

    iput v3, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventType:I

    .line 115
    iget-wide v4, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timestamp:D

    iput-wide v4, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventTimestamp:D

    .line 116
    const-wide/16 v4, 0x0

    iput-wide v4, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventOffset:D

    .line 117
    const-string v3, ""

    iput-object v3, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->session:Ljava/lang/String;

    .line 118
    const-wide/high16 v4, -0x4010000000000000L    # -1.0

    iput-wide v4, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastTrackOffset:D

    .line 119
    const/4 v3, 0x0

    iput v3, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->trackCount:I

    .line 120
    new-instance v3, Ljava/util/Hashtable;

    invoke-direct {v3}, Ljava/util/Hashtable;-><init>()V

    iput-object v3, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->firstEventList:Ljava/util/Hashtable;

    .line 122
    const/4 v3, 0x0

    iput-boolean v3, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->viewTracked:Z

    .line 124
    const/4 v3, 0x0

    iput v3, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentNum:I

    .line 125
    const-string v3, ""

    iput-object v3, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segment:Ljava/lang/String;

    .line 126
    const-wide/16 v4, 0x0

    iput-wide v4, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentLength:D

    .line 127
    const/4 v3, 0x0

    iput-boolean v3, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentGenerated:Z

    .line 128
    const/4 v3, 0x0

    iput-boolean v3, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentChanged:Z

    .line 130
    const/4 v3, 0x0

    iput v3, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastMilestone:I

    .line 131
    const/4 v3, 0x0

    iput v3, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastOffsetMilestone:I

    .line 134
    iput-object p0, v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->m:Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;

    .line 136
    iget-object v3, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->list:Ljava/util/Hashtable;

    invoke-virtual {v3, p1, v1}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 138
    :cond_7
    return-void
.end method

.method public play(Ljava/lang/String;D)V
    .locals 12
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "offset"    # D

    .prologue
    const/4 v7, 0x0

    .line 168
    invoke-virtual {p0, p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 169
    invoke-virtual {p0, p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->cleanName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 171
    :cond_0
    const/4 v3, 0x1

    const/4 v6, 0x0

    const-wide/high16 v8, -0x4010000000000000L    # -1.0

    move-object v1, p0

    move-object v2, p1

    move-wide v4, p2

    move-object v10, v7

    invoke-virtual/range {v1 .. v10}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->playerEvent(Ljava/lang/String;IDILjava/lang/String;DLjava/lang/Object;)Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;

    .line 173
    invoke-virtual {p0, p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->list:Ljava/util/Hashtable;

    invoke-virtual {p0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->list:Ljava/util/Hashtable;

    invoke-virtual {v1, p1}, Ljava/util/Hashtable;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 174
    iget-object v1, p0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->list:Ljava/util/Hashtable;

    invoke-virtual {v1, p1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;

    move-object v0, v1

    check-cast v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;

    .line 175
    .local v0, "media":Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;
    invoke-virtual {v0}, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->startMonitor()V

    .line 177
    .end local v0    # "media":Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;
    :cond_1
    return-void
.end method

.method protected playerEvent(Ljava/lang/String;IDILjava/lang/String;DLjava/lang/Object;)Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;
    .locals 35
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "eventType"    # I
    .param p3, "offset"    # D
    .param p5, "segmentNum"    # I
    .param p6, "segment"    # Ljava/lang/String;
    .param p7, "segmentLength"    # D
    .param p9, "playerData"    # Ljava/lang/Object;

    .prologue
    .line 372
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v30

    move-wide/from16 v0, v30

    long-to-double v0, v0

    move-wide/from16 v30, v0

    const-wide v32, 0x408f400000000000L    # 1000.0

    div-double v30, v30, v32

    invoke-static/range {v30 .. v31}, Ljava/lang/Math;->floor(D)D

    move-result-wide v18

    .line 376
    .local v18, "timeStamp":D
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->trackVars:Ljava/lang/String;

    move-object/from16 v25, v0

    .line 377
    .local v25, "trackVarsCopy":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->trackEvents:Ljava/lang/String;

    move-object/from16 v22, v0

    .line 378
    .local v22, "trackEventsCopy":Ljava/lang/String;
    move-object/from16 v0, p0

    iget v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->trackSeconds:I

    move/from16 v29, v0

    move/from16 v0, v29

    int-to-double v0, v0

    move-wide/from16 v26, v0

    .line 379
    .local v26, "trackSecondsCopy":D
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->trackMilestones:Ljava/lang/String;

    move-object/from16 v23, v0

    .line 380
    .local v23, "trackMiletonesCopy":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->trackOffsetMilestones:Ljava/lang/String;

    move-object/from16 v24, v0

    .line 381
    .local v24, "trackOffsetMilestonesCopy":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->segmentByMilestones:Z

    move/from16 v16, v0

    .line 382
    .local v16, "segmentByMilestonesCopy":Z
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->segmentByOffsetMilestones:Z

    move/from16 v17, v0

    .line 384
    .local v17, "segmentByOffsetMilestonesCopy":Z
    const/16 v20, 0x1

    .line 387
    .local v20, "track":Z
    invoke-virtual/range {p0 .. p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_0

    .line 388
    invoke-virtual/range {p0 .. p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->cleanName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 392
    :cond_0
    invoke-virtual/range {p0 .. p1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_c

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->list:Ljava/util/Hashtable;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_c

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->list:Ljava/util/Hashtable;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/util/Hashtable;->containsKey(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_c

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->list:Ljava/util/Hashtable;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v29

    check-cast v29, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;

    check-cast v29, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;

    move-object/from16 v11, v29

    .line 394
    .local v11, "mediaItem":Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;
    :goto_0
    if-eqz v11, :cond_3a

    .line 396
    const-wide/16 v30, 0x0

    cmpg-double v29, p3, v30

    if-gez v29, :cond_1

    .line 397
    iget v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventType:I

    move/from16 v29, v0

    const/16 v30, 0x1

    move/from16 v0, v29

    move/from16 v1, v30

    if-ne v0, v1, :cond_d

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventTimestamp:D

    move-wide/from16 v30, v0

    const-wide/16 v32, 0x0

    cmpl-double v29, v30, v32

    if-lez v29, :cond_d

    .line 398
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventTimestamp:D

    move-wide/from16 v30, v0

    sub-double v30, v18, v30

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventOffset:D

    move-wide/from16 v32, v0

    add-double p3, v30, v32

    .line 404
    :cond_1
    :goto_1
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    move-wide/from16 v30, v0

    const-wide/16 v32, 0x0

    cmpl-double v29, v30, v32

    if-lez v29, :cond_2

    .line 406
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    move-wide/from16 v30, v0

    cmpg-double v29, p3, v30

    if-gez v29, :cond_e

    .line 408
    :cond_2
    :goto_2
    const-wide/16 v30, 0x0

    cmpg-double v29, p3, v30

    if-gez v29, :cond_3

    .line 409
    const-wide/16 p3, 0x0

    .line 411
    :cond_3
    move-wide/from16 v0, p3

    iput-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->offset:D

    .line 413
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    move-wide/from16 v30, v0

    const-wide/16 v32, 0x0

    cmpl-double v29, v30, v32

    if-lez v29, :cond_4

    .line 414
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->offset:D

    move-wide/from16 v30, v0

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    move-wide/from16 v32, v0

    div-double v30, v30, v32

    const-wide/high16 v32, 0x4059000000000000L    # 100.0

    mul-double v30, v30, v32

    move-wide/from16 v0, v30

    iput-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->percent:D

    .line 415
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->percent:D

    move-wide/from16 v30, v0

    const-wide/high16 v32, 0x4059000000000000L    # 100.0

    cmpl-double v29, v30, v32

    if-lez v29, :cond_f

    const-wide/high16 v30, 0x4059000000000000L    # 100.0

    :goto_3
    move-wide/from16 v0, v30

    iput-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->percent:D

    .line 418
    :cond_4
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventOffset:D

    move-wide/from16 v30, v0

    const-wide/16 v32, 0x0

    cmpg-double v29, v30, v32

    if-gez v29, :cond_5

    .line 419
    move-wide/from16 v0, p3

    iput-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventOffset:D

    .line 423
    :cond_5
    iget v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->trackCount:I

    move/from16 v21, v0

    .line 426
    .local v21, "trackCount":I
    new-instance v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;

    invoke-direct {v14}, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;-><init>()V

    .line 427
    .local v14, "mediaState":Lcom/adobe/adms/mediameasurement/ADMS_MediaState;
    move-object/from16 v0, p1

    iput-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->name:Ljava/lang/String;

    .line 428
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    move-wide/from16 v30, v0

    move-wide/from16 v0, v30

    iput-wide v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->length:D

    .line 429
    new-instance v29, Ljava/util/Date;

    invoke-direct/range {v29 .. v29}, Ljava/util/Date;-><init>()V

    move-object/from16 v0, v29

    iput-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->openTime:Ljava/util/Date;

    .line 430
    iget-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->openTime:Ljava/util/Date;

    move-object/from16 v29, v0

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timestamp:D

    move-wide/from16 v30, v0

    move-wide/from16 v0, v30

    double-to-long v0, v0

    move-wide/from16 v30, v0

    invoke-virtual/range {v29 .. v31}, Ljava/util/Date;->setTime(J)V

    .line 431
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->offset:D

    move-wide/from16 v30, v0

    move-wide/from16 v0, v30

    iput-wide v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->offset:D

    .line 432
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->percent:D

    move-wide/from16 v30, v0

    move-wide/from16 v0, v30

    iput-wide v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->percent:D

    .line 433
    iget-object v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->playerName:Ljava/lang/String;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    iput-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->playerName:Ljava/lang/String;

    .line 434
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastTrackOffset:D

    move-wide/from16 v30, v0

    const-wide/16 v32, 0x0

    cmpg-double v29, v30, v32

    if-gez v29, :cond_10

    .line 435
    const-string v29, "OPEN"

    move-object/from16 v0, v29

    iput-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->mediaEvent:Ljava/lang/String;

    .line 470
    :goto_4
    const/16 v29, 0x2

    move/from16 v0, p2

    move/from16 v1, v29

    if-gt v0, v1, :cond_6

    iget v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventType:I

    move/from16 v29, v0

    move/from16 v0, p2

    move/from16 v1, v29

    if-eq v0, v1, :cond_3a

    const/16 v29, 0x2

    move/from16 v0, p2

    move/from16 v1, v29

    if-ne v0, v1, :cond_6

    iget v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventType:I

    move/from16 v29, v0

    const/16 v30, 0x1

    move/from16 v0, v29

    move/from16 v1, v30

    if-ne v0, v1, :cond_3a

    .line 473
    :cond_6
    move-object/from16 v0, p0

    move-object/from16 v1, p6

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_7

    .line 474
    iget v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentNum:I

    move/from16 p5, v0

    .line 475
    iget-object v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segment:Ljava/lang/String;

    move-object/from16 p6, v0

    .line 477
    :cond_7
    if-lez p2, :cond_2d

    .line 484
    const/16 v29, 0x1

    move/from16 v0, p2

    move/from16 v1, v29

    if-ne v0, v1, :cond_8

    .line 485
    move-wide/from16 v0, p3

    iput-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventOffset:D

    .line 489
    :cond_8
    const/16 v29, 0x3

    move/from16 v0, p2

    move/from16 v1, v29

    if-le v0, v1, :cond_9

    const/16 v29, 0x5

    move/from16 v0, p2

    move/from16 v1, v29

    if-ne v0, v1, :cond_17

    :cond_9
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastTrackOffset:D

    move-wide/from16 v30, v0

    const-wide/16 v32, 0x0

    cmpl-double v29, v30, v32

    if-ltz v29, :cond_17

    .line 490
    const/16 v20, 0x0

    .line 491
    const-string v25, "None"

    .line 492
    const-string v22, "None"

    .line 493
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastTrackOffset:D

    move-wide/from16 v30, v0

    sub-double v30, v30, p3

    invoke-static/range {v30 .. v31}, Ljava/lang/Math;->abs(D)D

    move-result-wide v30

    const-wide v32, 0x3f1a36e2eb1c432dL    # 1.0E-4

    cmpl-double v29, v30, v32

    if-lez v29, :cond_17

    .line 495
    iget-wide v12, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastTrackOffset:D

    .line 496
    .local v12, "last":D
    cmpl-double v29, v12, p3

    if-lez v29, :cond_a

    .line 497
    iget-wide v12, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventOffset:D

    .line 498
    cmpl-double v29, v12, p3

    if-lez v29, :cond_a

    .line 499
    move-wide/from16 v12, p3

    .line 504
    :cond_a
    move-object/from16 v0, p0

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_11

    const-string v29, ","

    move-object/from16 v0, v23

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v15

    .line 505
    .local v15, "milestones":[Ljava/lang/String;
    :goto_5
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    move-wide/from16 v30, v0

    const-wide/16 v32, 0x0

    cmpl-double v29, v30, v32

    if-lez v29, :cond_13

    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_13

    cmpl-double v29, p3, v12

    if-ltz v29, :cond_13

    .line 506
    const/4 v10, 0x0

    .local v10, "j":I
    :goto_6
    array-length v0, v15

    move/from16 v29, v0

    move/from16 v0, v29

    if-ge v10, v0, :cond_13

    .line 508
    :try_start_0
    aget-object v29, v15, v10

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_12

    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    const-string v30, ""

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    aget-object v30, v15, v10

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    invoke-static/range {v29 .. v29}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v29

    :goto_7
    move/from16 v0, v29

    int-to-double v6, v0

    .line 512
    .local v6, "current":D
    :goto_8
    move-object/from16 v0, p0

    invoke-virtual {v0, v6, v7}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(D)Z

    move-result v29

    if-eqz v29, :cond_b

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    move-wide/from16 v30, v0

    div-double v30, v12, v30

    const-wide/high16 v32, 0x4059000000000000L    # 100.0

    mul-double v30, v30, v32

    cmpg-double v29, v30, v6

    if-gez v29, :cond_b

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->percent:D

    move-wide/from16 v30, v0

    cmpl-double v29, v30, v6

    if-ltz v29, :cond_b

    .line 513
    const/16 v20, 0x1

    .line 514
    const-string v29, "MILESTONE"

    move-object/from16 v0, v29

    iput-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->mediaEvent:Ljava/lang/String;

    .line 515
    double-to-int v0, v6

    move/from16 v29, v0

    move/from16 v0, v29

    iput v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->milestone:I

    move/from16 v0, v29

    iput v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastMilestone:I

    .line 516
    array-length v10, v15

    .line 506
    :cond_b
    add-int/lit8 v10, v10, 0x1

    goto :goto_6

    .line 392
    .end local v6    # "current":D
    .end local v10    # "j":I
    .end local v11    # "mediaItem":Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;
    .end local v12    # "last":D
    .end local v14    # "mediaState":Lcom/adobe/adms/mediameasurement/ADMS_MediaState;
    .end local v15    # "milestones":[Ljava/lang/String;
    .end local v21    # "trackCount":I
    :cond_c
    const/4 v11, 0x0

    goto/16 :goto_0

    .line 400
    .restart local v11    # "mediaItem":Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;
    :cond_d
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventOffset:D

    move-wide/from16 p3, v0

    goto/16 :goto_1

    .line 406
    :cond_e
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    move-wide/from16 p3, v0

    goto/16 :goto_2

    .line 415
    :cond_f
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->percent:D

    move-wide/from16 v30, v0

    goto/16 :goto_3

    .line 437
    .restart local v14    # "mediaState":Lcom/adobe/adms/mediameasurement/ADMS_MediaState;
    .restart local v21    # "trackCount":I
    :cond_10
    packed-switch p2, :pswitch_data_0

    .line 454
    const-string v29, "CLOSE"

    move-object/from16 v0, v29

    iput-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->mediaEvent:Ljava/lang/String;

    goto/16 :goto_4

    .line 439
    :pswitch_0
    const-string v29, "PLAY"

    move-object/from16 v0, v29

    iput-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->mediaEvent:Ljava/lang/String;

    goto/16 :goto_4

    .line 442
    :pswitch_1
    const-string v29, "STOP"

    move-object/from16 v0, v29

    iput-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->mediaEvent:Ljava/lang/String;

    goto/16 :goto_4

    .line 445
    :pswitch_2
    const-string v29, "MONITOR"

    move-object/from16 v0, v29

    iput-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->mediaEvent:Ljava/lang/String;

    goto/16 :goto_4

    .line 448
    :pswitch_3
    const-string v29, "TRACK"

    move-object/from16 v0, v29

    iput-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->mediaEvent:Ljava/lang/String;

    goto/16 :goto_4

    .line 451
    :pswitch_4
    const-string v29, "COMPLETE"

    move-object/from16 v0, v29

    iput-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->mediaEvent:Ljava/lang/String;

    goto/16 :goto_4

    .line 504
    .restart local v12    # "last":D
    :cond_11
    const/4 v15, 0x0

    goto/16 :goto_5

    .line 508
    .restart local v10    # "j":I
    .restart local v15    # "milestones":[Ljava/lang/String;
    :cond_12
    const/16 v29, 0x0

    goto/16 :goto_7

    .line 509
    :catch_0
    move-exception v9

    .line 510
    .local v9, "ex":Ljava/lang/NumberFormatException;
    const-wide/16 v6, 0x0

    .restart local v6    # "current":D
    goto/16 :goto_8

    .line 522
    .end local v6    # "current":D
    .end local v9    # "ex":Ljava/lang/NumberFormatException;
    .end local v10    # "j":I
    :cond_13
    move-object/from16 v0, p0

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_15

    const-string v29, ","

    move-object/from16 v0, v24

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v15

    .line 523
    :goto_9
    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_17

    cmpl-double v29, p3, v12

    if-ltz v29, :cond_17

    .line 524
    const/4 v10, 0x0

    .restart local v10    # "j":I
    :goto_a
    array-length v0, v15

    move/from16 v29, v0

    move/from16 v0, v29

    if-ge v10, v0, :cond_17

    .line 526
    :try_start_1
    aget-object v29, v15, v10

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_16

    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    const-string v30, ""

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    aget-object v30, v15, v10

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    invoke-static/range {v29 .. v29}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    move-result v29

    :goto_b
    move/from16 v0, v29

    int-to-double v6, v0

    .line 530
    .restart local v6    # "current":D
    :goto_c
    move-object/from16 v0, p0

    invoke-virtual {v0, v6, v7}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(D)Z

    move-result v29

    if-eqz v29, :cond_14

    cmpg-double v29, v12, v6

    if-gez v29, :cond_14

    cmpl-double v29, p3, v6

    if-ltz v29, :cond_14

    .line 531
    const/16 v20, 0x1

    .line 532
    const-string v29, "OFFSET_MILESTONE"

    move-object/from16 v0, v29

    iput-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->mediaEvent:Ljava/lang/String;

    .line 533
    double-to-int v0, v6

    move/from16 v29, v0

    move/from16 v0, v29

    iput v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->offsetMilestone:I

    move/from16 v0, v29

    iput v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastOffsetMilestone:I

    .line 534
    array-length v10, v15

    .line 524
    :cond_14
    add-int/lit8 v10, v10, 0x1

    goto :goto_a

    .line 522
    .end local v6    # "current":D
    .end local v10    # "j":I
    :cond_15
    const/4 v15, 0x0

    goto :goto_9

    .line 526
    .restart local v10    # "j":I
    :cond_16
    const/16 v29, 0x0

    goto :goto_b

    .line 527
    :catch_1
    move-exception v9

    .line 528
    .restart local v9    # "ex":Ljava/lang/NumberFormatException;
    const-wide/16 v6, 0x0

    .restart local v6    # "current":D
    goto :goto_c

    .line 547
    .end local v6    # "current":D
    .end local v9    # "ex":Ljava/lang/NumberFormatException;
    .end local v10    # "j":I
    .end local v12    # "last":D
    .end local v15    # "milestones":[Ljava/lang/String;
    :cond_17
    iget-boolean v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentGenerated:Z

    move/from16 v29, v0

    if-nez v29, :cond_18

    move-object/from16 v0, p0

    move-object/from16 v1, p6

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_24

    .line 549
    :cond_18
    if-eqz v16, :cond_1c

    move-object/from16 v0, p0

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1c

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    move-wide/from16 v30, v0

    const-wide/16 v32, 0x0

    cmpl-double v29, v30, v32

    if-lez v29, :cond_1c

    .line 550
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v29

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, ",100"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    const-string v30, ","

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v15

    .line 551
    .restart local v15    # "milestones":[Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_23

    .line 552
    const-wide/16 v12, 0x0

    .line 553
    .restart local v12    # "last":D
    const/4 v10, 0x0

    .restart local v10    # "j":I
    :goto_d
    array-length v0, v15

    move/from16 v29, v0

    move/from16 v0, v29

    if-ge v10, v0, :cond_23

    .line 555
    :try_start_2
    aget-object v29, v15, v10

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1b

    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    const-string v30, ""

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    aget-object v30, v15, v10

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    invoke-static/range {v29 .. v29}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_2

    move-result v29

    :goto_e
    move/from16 v0, v29

    int-to-double v6, v0

    .line 559
    .restart local v6    # "current":D
    :goto_f
    move-object/from16 v0, p0

    invoke-virtual {v0, v6, v7}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(D)Z

    move-result v29

    if-eqz v29, :cond_1a

    .line 560
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->percent:D

    move-wide/from16 v30, v0

    cmpg-double v29, v30, v6

    if-gez v29, :cond_19

    .line 561
    add-int/lit8 p5, v10, 0x1

    .line 562
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    const-string v30, "M:"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "%1.0f"

    const/16 v31, 0x1

    move/from16 v0, v31

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v31, v0

    const/16 v32, 0x0

    invoke-static {v12, v13}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v33

    aput-object v33, v31, v32

    invoke-static/range {v30 .. v31}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "-"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "%1.0f"

    const/16 v31, 0x1

    move/from16 v0, v31

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v31, v0

    const/16 v32, 0x0

    invoke-static {v6, v7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v33

    aput-object v33, v31, v32

    invoke-static/range {v30 .. v31}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p6

    .line 563
    array-length v10, v15

    .line 565
    :cond_19
    move-wide v12, v6

    .line 553
    :cond_1a
    add-int/lit8 v10, v10, 0x1

    goto/16 :goto_d

    .line 555
    .end local v6    # "current":D
    :cond_1b
    const/16 v29, 0x0

    goto :goto_e

    .line 556
    :catch_2
    move-exception v9

    .line 557
    .restart local v9    # "ex":Ljava/lang/NumberFormatException;
    const-wide/16 v6, 0x0

    .restart local v6    # "current":D
    goto :goto_f

    .line 570
    .end local v6    # "current":D
    .end local v9    # "ex":Ljava/lang/NumberFormatException;
    .end local v10    # "j":I
    .end local v12    # "last":D
    .end local v15    # "milestones":[Ljava/lang/String;
    :cond_1c
    if-eqz v17, :cond_23

    move-object/from16 v0, p0

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_23

    .line 571
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    move-wide/from16 v30, v0

    const-wide/16 v32, 0x0

    cmpl-double v29, v30, v32

    if-lez v29, :cond_21

    .line 572
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v29

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, ","

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    move-wide/from16 v30, v0

    invoke-static/range {v30 .. v31}, Ljava/lang/Math;->floor(D)D

    move-result-wide v30

    move-wide/from16 v0, v30

    double-to-long v0, v0

    move-wide/from16 v30, v0

    invoke-virtual/range {v29 .. v31}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    const-string v30, ","

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v15

    .line 575
    .restart local v15    # "milestones":[Ljava/lang/String;
    :goto_10
    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_23

    .line 576
    const-wide/16 v12, 0x0

    .line 577
    .restart local v12    # "last":D
    const/4 v10, 0x0

    .restart local v10    # "j":I
    :goto_11
    array-length v0, v15

    move/from16 v29, v0

    move/from16 v0, v29

    if-ge v10, v0, :cond_23

    .line 579
    :try_start_3
    aget-object v29, v15, v10

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_22

    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    const-string v30, ""

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    aget-object v30, v15, v10

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    invoke-static/range {v29 .. v29}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_3
    .catch Ljava/lang/NumberFormatException; {:try_start_3 .. :try_end_3} :catch_3

    move-result v29

    :goto_12
    move/from16 v0, v29

    int-to-double v6, v0

    .line 583
    .restart local v6    # "current":D
    :goto_13
    move-object/from16 v0, p0

    invoke-virtual {v0, v6, v7}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(D)Z

    move-result v29

    if-nez v29, :cond_1d

    aget-object v29, v15, v10

    const-string v30, "E"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_20

    .line 584
    :cond_1d
    cmpg-double v29, p3, v6

    if-ltz v29, :cond_1e

    aget-object v29, v15, v10

    const-string v30, "E"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_1f

    .line 585
    :cond_1e
    add-int/lit8 p5, v10, 0x1

    .line 586
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    const-string v30, "O:"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "%1.0f"

    const/16 v31, 0x1

    move/from16 v0, v31

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v31, v0

    const/16 v32, 0x0

    invoke-static {v12, v13}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v33

    aput-object v33, v31, v32

    invoke-static/range {v30 .. v31}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "-"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    aget-object v30, v15, v10

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p6

    .line 587
    array-length v10, v15

    .line 589
    :cond_1f
    move-wide v12, v6

    .line 577
    :cond_20
    add-int/lit8 v10, v10, 0x1

    goto/16 :goto_11

    .line 574
    .end local v6    # "current":D
    .end local v10    # "j":I
    .end local v12    # "last":D
    .end local v15    # "milestones":[Ljava/lang/String;
    :cond_21
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v29

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, ","

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "E"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    const-string v30, ","

    invoke-virtual/range {v29 .. v30}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v15

    .restart local v15    # "milestones":[Ljava/lang/String;
    goto/16 :goto_10

    .line 579
    .restart local v10    # "j":I
    .restart local v12    # "last":D
    :cond_22
    const/16 v29, 0x0

    goto/16 :goto_12

    .line 580
    :catch_3
    move-exception v9

    .line 581
    .restart local v9    # "ex":Ljava/lang/NumberFormatException;
    const-wide/16 v6, 0x0

    .restart local v6    # "current":D
    goto/16 :goto_13

    .line 594
    .end local v6    # "current":D
    .end local v9    # "ex":Ljava/lang/NumberFormatException;
    .end local v10    # "j":I
    .end local v12    # "last":D
    .end local v15    # "milestones":[Ljava/lang/String;
    :cond_23
    move-object/from16 v0, p0

    move-object/from16 v1, p6

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_24

    .line 595
    const/16 v29, 0x1

    move/from16 v0, v29

    iput-boolean v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentGenerated:Z

    .line 600
    :cond_24
    move-object/from16 v0, p0

    move-object/from16 v1, p6

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_25

    iget-object v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segment:Ljava/lang/String;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_27

    :cond_25
    iget-object v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segment:Ljava/lang/String;

    move-object/from16 v29, v0

    move-object/from16 v0, p6

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-nez v29, :cond_27

    .line 601
    const/16 v29, 0x1

    move/from16 v0, v29

    iput-boolean v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->updateSegment:Z

    .line 602
    iget-object v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segment:Ljava/lang/String;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_26

    .line 603
    move/from16 v0, p5

    iput v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentNum:I

    .line 604
    move-object/from16 v0, p6

    iput-object v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segment:Ljava/lang/String;

    .line 606
    :cond_26
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastTrackOffset:D

    move-wide/from16 v30, v0

    const-wide/16 v32, 0x0

    cmpl-double v29, v30, v32

    if-ltz v29, :cond_27

    .line 607
    const/16 v20, 0x1

    .line 612
    :cond_27
    const/16 v29, 0x2

    move/from16 v0, p2

    move/from16 v1, v29

    if-lt v0, v1, :cond_28

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventOffset:D

    move-wide/from16 v30, v0

    cmpg-double v29, v30, p3

    if-gez v29, :cond_28

    .line 613
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timePlayed:D

    move-wide/from16 v30, v0

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventOffset:D

    move-wide/from16 v32, v0

    sub-double v32, p3, v32

    add-double v30, v30, v32

    move-wide/from16 v0, v30

    iput-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timePlayed:D

    .line 614
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timePlayedSinceTrack:D

    move-wide/from16 v30, v0

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventOffset:D

    move-wide/from16 v32, v0

    sub-double v32, p3, v32

    add-double v30, v30, v32

    move-wide/from16 v0, v30

    iput-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timePlayedSinceTrack:D

    .line 618
    :cond_28
    const/16 v29, 0x2

    move/from16 v0, p2

    move/from16 v1, v29

    if-le v0, v1, :cond_29

    const/16 v29, 0x3

    move/from16 v0, p2

    move/from16 v1, v29

    if-ne v0, v1, :cond_2b

    iget v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventType:I

    move/from16 v29, v0

    if-nez v29, :cond_2b

    .line 619
    :cond_29
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->session:Ljava/lang/String;

    move-object/from16 v30, v0

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    const/16 v29, 0x1

    move/from16 v0, p2

    move/from16 v1, v29

    if-eq v0, v1, :cond_2a

    const/16 v29, 0x3

    move/from16 v0, p2

    move/from16 v1, v29

    if-ne v0, v1, :cond_3b

    :cond_2a
    const-string v29, "S"

    :goto_14
    move-object/from16 v0, v30

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-static/range {p3 .. p4}, Ljava/lang/Math;->floor(D)D

    move-result-wide v30

    invoke-virtual/range {v29 .. v31}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v29

    iput-object v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->session:Ljava/lang/String;

    .line 621
    const/16 v29, 0x3

    move/from16 v0, p2

    move/from16 v1, v29

    if-ne v0, v1, :cond_3c

    const/16 v29, 0x1

    :goto_15
    move/from16 v0, v29

    iput v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventType:I

    .line 625
    :cond_2b
    if-nez v20, :cond_2c

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastTrackOffset:D

    move-wide/from16 v30, v0

    const-wide/16 v32, 0x0

    cmpl-double v29, v30, v32

    if-ltz v29, :cond_2c

    const/16 v29, 0x3

    move/from16 v0, p2

    move/from16 v1, v29

    if-gt v0, v1, :cond_2c

    .line 627
    const-wide/16 v30, 0x0

    cmpl-double v29, v26, v30

    if-lez v29, :cond_3d

    .line 628
    :goto_16
    const-wide/16 v30, 0x0

    cmpl-double v29, v26, v30

    if-lez v29, :cond_2c

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timePlayedSinceTrack:D

    move-wide/from16 v30, v0

    cmpl-double v29, v30, v26

    if-ltz v29, :cond_2c

    .line 629
    const/16 v20, 0x1

    .line 630
    const-string v29, "SECONDS"

    move-object/from16 v0, v29

    iput-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->mediaEvent:Ljava/lang/String;

    .line 635
    :cond_2c
    move-wide/from16 v0, v18

    iput-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventTimestamp:D

    .line 636
    move-wide/from16 v0, p3

    iput-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventOffset:D

    .line 640
    :cond_2d
    if-eqz p2, :cond_2e

    const/16 v29, 0x3

    move/from16 v0, p2

    move/from16 v1, v29

    if-gt v0, v1, :cond_30

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->percent:D

    move-wide/from16 v30, v0

    const-wide/high16 v32, 0x4059000000000000L    # 100.0

    cmpl-double v29, v30, v32

    if-ltz v29, :cond_30

    .line 641
    :cond_2e
    iget v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastEventType:I

    move/from16 v29, v0

    const/16 v30, 0x2

    move/from16 v0, v29

    move/from16 v1, v30

    if-eq v0, v1, :cond_2f

    .line 642
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->session:Ljava/lang/String;

    move-object/from16 v30, v0

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "E"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-static/range {p3 .. p4}, Ljava/lang/Math;->floor(D)D

    move-result-wide v30

    invoke-virtual/range {v29 .. v31}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v29

    iput-object v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->session:Ljava/lang/String;

    .line 644
    :cond_2f
    const/16 p2, 0x0

    .line 645
    const-string v25, "None"

    .line 646
    const-string v22, "None"

    .line 647
    const-string v29, "CLOSE"

    move-object/from16 v0, v29

    iput-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->mediaEvent:Ljava/lang/String;

    .line 651
    :cond_30
    const/16 v29, 0x5

    move/from16 v0, p2

    move/from16 v1, v29

    if-eq v0, v1, :cond_32

    if-eqz p2, :cond_31

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->percent:D

    move-wide/from16 v30, v0

    const-wide/high16 v32, 0x4059000000000000L    # 100.0

    cmpl-double v29, v30, v32

    if-ltz v29, :cond_33

    :cond_31
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    move-wide/from16 v30, v0

    const-wide/16 v32, 0x0

    cmpl-double v29, v30, v32

    if-lez v29, :cond_33

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->length:D

    move-wide/from16 v30, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->completeCloseOffsetThreshold:I

    move/from16 v29, v0

    move/from16 v0, v29

    int-to-double v0, v0

    move-wide/from16 v32, v0

    sub-double v30, v30, v32

    cmpl-double v29, p3, v30

    if-ltz v29, :cond_33

    .line 654
    :cond_32
    const/16 v29, 0x1

    move/from16 v0, v29

    iput-boolean v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->complete:Z

    .line 655
    const/16 v29, 0x1

    move/from16 v0, v29

    iput-boolean v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->complete:Z

    .line 656
    const/16 v20, 0x1

    .line 660
    :cond_33
    iget-object v8, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->mediaEvent:Ljava/lang/String;

    .line 661
    .local v8, "eventKey":Ljava/lang/String;
    const-string v29, "MILESTONE"

    move-object/from16 v0, v29

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_3e

    .line 662
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v29

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "_"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    iget v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->milestone:I

    move/from16 v30, v0

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 667
    :cond_34
    :goto_17
    iget-object v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->firstEventList:Ljava/util/Hashtable;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    invoke-virtual {v0, v8}, Ljava/util/Hashtable;->containsKey(Ljava/lang/Object;)Z

    move-result v29

    if-nez v29, :cond_3f

    .line 668
    const/16 v29, 0x1

    move/from16 v0, v29

    iput-boolean v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->eventFirstTime:Z

    .line 669
    iget-object v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->firstEventList:Ljava/util/Hashtable;

    move-object/from16 v29, v0

    const/16 v30, 0x1

    invoke-static/range {v30 .. v30}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v0, v8, v1}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 675
    :goto_18
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timePlayed:D

    move-wide/from16 v30, v0

    move-wide/from16 v0, v30

    iput-wide v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->timePlayed:D

    .line 676
    iget v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentNum:I

    move/from16 v29, v0

    move/from16 v0, v29

    iput v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->segmentNum:I

    .line 677
    iget-object v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segment:Ljava/lang/String;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    iput-object v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->segment:Ljava/lang/String;

    .line 678
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentLength:D

    move-wide/from16 v30, v0

    move-wide/from16 v0, v30

    iput-wide v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->segmentLength:D

    .line 679
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->delegate:Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurementDelegate;

    move-object/from16 v29, v0

    if-eqz v29, :cond_35

    const/16 v29, 0x4

    move/from16 v0, p2

    move/from16 v1, v29

    if-eq v0, v1, :cond_35

    .line 681
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->delegate:Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurementDelegate;

    move-object/from16 v29, v0

    invoke-static {}, Lcom/adobe/adms/measurement/ADMS_Measurement;->sharedInstance()Lcom/adobe/adms/measurement/ADMS_Measurement;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-interface {v0, v1, v14}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurementDelegate;->ADMS_MediaMeasurementMonitor(Lcom/adobe/adms/measurement/ADMS_Measurement;Lcom/adobe/adms/mediameasurement/ADMS_MediaState;)V

    .line 685
    :cond_35
    if-nez p2, :cond_36

    .line 686
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->list:Ljava/util/Hashtable;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/util/Hashtable;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 687
    invoke-virtual {v11}, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->stopMonitor()V

    .line 690
    :cond_36
    if-eqz v20, :cond_3a

    iget v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->trackCount:I

    move/from16 v29, v0

    move/from16 v0, v29

    move/from16 v1, v21

    if-ne v0, v1, :cond_3a

    .line 692
    new-instance v28, Ljava/util/Hashtable;

    invoke-direct/range {v28 .. v28}, Ljava/util/Hashtable;-><init>()V

    .line 693
    .local v28, "variableOverrides":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v5, Ljava/util/Hashtable;

    invoke-direct {v5}, Ljava/util/Hashtable;-><init>()V

    .line 695
    .local v5, "contextData":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_37

    .line 696
    const-string v25, ""

    .line 697
    :cond_37
    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->isSet(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_38

    .line 698
    const-string v22, ""

    .line 700
    :cond_38
    const-string v29, "linkTrackVars"

    move-object/from16 v0, v28

    move-object/from16 v1, v29

    move-object/from16 v2, v25

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 701
    const-string v29, "linkTrackEvents"

    move-object/from16 v0, v28

    move-object/from16 v1, v29

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 703
    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-virtual {v0, v5, v1, v11}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->buildContextData(Ljava/util/Hashtable;Ljava/util/Hashtable;Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;)V

    .line 705
    invoke-static {}, Lcom/adobe/adms/measurement/ADMS_Measurement;->sharedInstance()Lcom/adobe/adms/measurement/ADMS_Measurement;

    move-result-object v4

    .line 706
    .local v4, "Measurement":Lcom/adobe/adms/measurement/ADMS_Measurement;
    move-object/from16 v0, v28

    invoke-virtual {v4, v5, v0}, Lcom/adobe/adms/measurement/ADMS_Measurement;->track(Ljava/util/Hashtable;Ljava/util/Hashtable;)V

    .line 713
    iget-boolean v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->updateSegment:Z

    move/from16 v29, v0

    if-eqz v29, :cond_40

    .line 714
    move/from16 v0, p5

    iput v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentNum:I

    .line 715
    move-object/from16 v0, p6

    iput-object v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segment:Ljava/lang/String;

    .line 716
    const/16 v29, 0x1

    move/from16 v0, v29

    iput-boolean v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentChanged:Z

    .line 717
    const/16 v29, 0x0

    move/from16 v0, v29

    iput-boolean v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->updateSegment:Z

    .line 723
    :cond_39
    :goto_19
    const-string v29, ""

    move-object/from16 v0, v29

    iput-object v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->session:Ljava/lang/String;

    .line 724
    const/16 v29, 0x0

    move/from16 v0, v29

    iput v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastMilestone:I

    .line 725
    const/16 v29, 0x0

    move/from16 v0, v29

    iput v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastOffsetMilestone:I

    .line 726
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timePlayedSinceTrack:D

    move-wide/from16 v30, v0

    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timePlayedSinceTrack:D

    move-wide/from16 v32, v0

    invoke-static/range {v32 .. v33}, Ljava/lang/Math;->floor(D)D

    move-result-wide v32

    sub-double v30, v30, v32

    move-wide/from16 v0, v30

    iput-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timePlayedSinceTrack:D

    .line 727
    move-wide/from16 v0, p3

    iput-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->lastTrackOffset:D

    .line 728
    iget v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->trackCount:I

    move/from16 v29, v0

    add-int/lit8 v29, v29, 0x1

    move/from16 v0, v29

    iput v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->trackCount:I

    .line 733
    .end local v4    # "Measurement":Lcom/adobe/adms/measurement/ADMS_Measurement;
    .end local v5    # "contextData":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v8    # "eventKey":Ljava/lang/String;
    .end local v14    # "mediaState":Lcom/adobe/adms/mediameasurement/ADMS_MediaState;
    .end local v21    # "trackCount":I
    .end local v28    # "variableOverrides":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_3a
    return-object v11

    .line 619
    .restart local v14    # "mediaState":Lcom/adobe/adms/mediameasurement/ADMS_MediaState;
    .restart local v21    # "trackCount":I
    :cond_3b
    const-string v29, "E"

    goto/16 :goto_14

    :cond_3c
    move/from16 v29, p2

    .line 621
    goto/16 :goto_15

    .line 627
    :cond_3d
    const-wide/16 v26, 0x0

    goto/16 :goto_16

    .line 663
    .restart local v8    # "eventKey":Ljava/lang/String;
    :cond_3e
    const-string v29, "OFFSET_MILESTONE"

    move-object/from16 v0, v29

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-eqz v29, :cond_34

    .line 664
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v29

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "_"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    iget v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->offsetMilestone:I

    move/from16 v30, v0

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    goto/16 :goto_17

    .line 671
    :cond_3f
    const/16 v29, 0x0

    move/from16 v0, v29

    iput-boolean v0, v14, Lcom/adobe/adms/mediameasurement/ADMS_MediaState;->eventFirstTime:Z

    goto/16 :goto_18

    .line 719
    .restart local v4    # "Measurement":Lcom/adobe/adms/measurement/ADMS_Measurement;
    .restart local v5    # "contextData":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local v28    # "variableOverrides":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_40
    iget-wide v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->timePlayedSinceTrack:D

    move-wide/from16 v30, v0

    const-wide/16 v32, 0x0

    cmpl-double v29, v30, v32

    if-lez v29, :cond_39

    .line 720
    const/16 v29, 0x0

    move/from16 v0, v29

    iput-boolean v0, v11, Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;->segmentChanged:Z

    goto :goto_19

    .line 437
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public stop(Ljava/lang/String;D)V
    .locals 12
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "offset"    # D

    .prologue
    const/4 v7, 0x0

    .line 196
    const/4 v3, 0x2

    const/4 v6, 0x0

    const-wide/high16 v8, -0x4010000000000000L    # -1.0

    move-object v1, p0

    move-object v2, p1

    move-wide v4, p2

    move-object v10, v7

    invoke-virtual/range {v1 .. v10}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->playerEvent(Ljava/lang/String;IDILjava/lang/String;DLjava/lang/Object;)Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;

    .line 197
    return-void
.end method

.method protected toBoolean(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 818
    check-cast p1, Ljava/lang/Boolean;

    .end local p1    # "value":Ljava/lang/Object;
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method protected toInteger(Ljava/lang/Object;)I
    .locals 1
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 806
    check-cast p1, Ljava/lang/Integer;

    .end local p1    # "value":Ljava/lang/Object;
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public track(Ljava/lang/String;)V
    .locals 11
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x0

    const-wide/high16 v4, -0x4010000000000000L    # -1.0

    .line 205
    const/4 v3, 0x4

    const/4 v6, 0x0

    move-object v1, p0

    move-object v2, p1

    move-wide v8, v4

    move-object v10, v7

    invoke-virtual/range {v1 .. v10}, Lcom/adobe/adms/mediameasurement/ADMS_MediaMeasurement;->playerEvent(Ljava/lang/String;IDILjava/lang/String;DLjava/lang/Object;)Lcom/adobe/adms/mediameasurement/ADMS_MediaItem;

    .line 206
    return-void
.end method
