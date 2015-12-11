.class public Lcom/auditude/ads/response/VMAPParser;
.super Lcom/auditude/ads/util/event/EventDispatcher;
.source "VMAPParser.java"

# interfaces
.implements Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;
.implements Lcom/auditude/ads/response/IResponseParser;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/auditude/ads/response/VMAPParser$sortOnStartTime;
    }
.end annotation


# instance fields
.field private adBreaks:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/response/VMAPAdBreak;",
            ">;"
        }
    .end annotation
.end field

.field private adRequest:Lcom/auditude/ads/loader/AdRequest;

.field private adResponse:Lcom/auditude/ads/response/AdResponse;

.field private breaks:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Group;",
            ">;"
        }
    .end annotation
.end field

.field private chapters:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Group;",
            ">;"
        }
    .end annotation
.end field

.field private dataLoader:Lcom/auditude/ads/loader/DataLoader;

.field private listener:Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

.field private loadFailed:Ljava/lang/Boolean;

.field private timeout:I

.field private trackingAd:Lcom/auditude/ads/model/Ad;

.field private xmlParser:Lcom/auditude/ads/response/VmapXmlParser;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/auditude/ads/util/event/EventDispatcher;-><init>()V

    .line 42
    new-instance v0, Lcom/auditude/ads/response/VmapXmlParser;

    invoke-direct {v0}, Lcom/auditude/ads/response/VmapXmlParser;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/response/VMAPParser;->xmlParser:Lcom/auditude/ads/response/VmapXmlParser;

    .line 43
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/response/VMAPParser;->breaks:Ljava/util/ArrayList;

    .line 44
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/response/VMAPParser;->chapters:Ljava/util/ArrayList;

    .line 45
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/response/VMAPParser;->adBreaks:Ljava/util/ArrayList;

    .line 49
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/response/VMAPParser;->loadFailed:Ljava/lang/Boolean;

    .line 34
    return-void
.end method

.method private appendSequenceState(Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Group;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Group;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 510
    .local p1, "groups":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/smil/Group;>;"
    .local p2, "targetGroups":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/smil/Group;>;"
    const/4 v1, 0x0

    .local v1, "groupIndex":I
    :goto_0
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-lt v1, v9, :cond_0

    .line 535
    return-void

    .line 512
    :cond_0
    invoke-virtual {p2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/auditude/ads/model/smil/Group;

    .line 513
    .local v6, "targetGroup":Lcom/auditude/ads/model/smil/Group;
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-le v9, v1, :cond_1

    .line 515
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/smil/Group;

    .line 516
    .local v0, "group":Lcom/auditude/ads/model/smil/Group;
    const/4 v4, 0x0

    .local v4, "sequenceIndex":I
    :goto_1
    invoke-virtual {v6}, Lcom/auditude/ads/model/smil/Group;->getSequenceList()Ljava/util/ArrayList;

    move-result-object v9

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-lt v4, v9, :cond_2

    .line 510
    .end local v0    # "group":Lcom/auditude/ads/model/smil/Group;
    .end local v4    # "sequenceIndex":I
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 518
    .restart local v0    # "group":Lcom/auditude/ads/model/smil/Group;
    .restart local v4    # "sequenceIndex":I
    :cond_2
    invoke-virtual {v6}, Lcom/auditude/ads/model/smil/Group;->getSequenceList()Ljava/util/ArrayList;

    move-result-object v9

    invoke-virtual {v9, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/auditude/ads/model/smil/Sequence;

    .line 519
    .local v7, "targetSequence":Lcom/auditude/ads/model/smil/Sequence;
    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Group;->getSequenceList()Ljava/util/ArrayList;

    move-result-object v9

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-le v9, v4, :cond_3

    .line 521
    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Group;->getSequenceList()Ljava/util/ArrayList;

    move-result-object v9

    invoke-virtual {v9, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/auditude/ads/model/smil/Sequence;

    .line 523
    .local v3, "sequence":Lcom/auditude/ads/model/smil/Sequence;
    invoke-virtual {v7}, Lcom/auditude/ads/model/smil/Sequence;->getSubmissionId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v3, v9}, Lcom/auditude/ads/model/smil/Sequence;->setSubmissionId(Ljava/lang/String;)V

    .line 524
    invoke-virtual {v7}, Lcom/auditude/ads/model/smil/Sequence;->getState()Ljava/util/HashMap;

    move-result-object v5

    .line 525
    .local v5, "state":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {v5}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_2
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-nez v10, :cond_4

    .line 516
    .end local v3    # "sequence":Lcom/auditude/ads/model/smil/Sequence;
    .end local v5    # "state":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_3
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 525
    .restart local v3    # "sequence":Lcom/auditude/ads/model/smil/Sequence;
    .restart local v5    # "state":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_4
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 527
    .local v2, "key":Ljava/lang/String;
    invoke-virtual {v5, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 528
    .local v8, "value":Ljava/lang/String;
    invoke-virtual {v3, v2, v8}, Lcom/auditude/ads/model/smil/Sequence;->addState(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2
.end method

.method private constructURL(Ljava/lang/String;)Ljava/lang/String;
    .locals 14
    .param p1, "source"    # Ljava/lang/String;

    .prologue
    const v13, 0x989680

    .line 130
    const-string v7, ""

    .line 131
    .local v7, "slot":Ljava/lang/String;
    const/4 v3, 0x1

    .line 132
    .local v3, "index":I
    iget-object v10, p0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    invoke-virtual {v10}, Lcom/auditude/ads/response/AdResponse;->getBreaks()Ljava/util/ArrayList;

    move-result-object v10

    invoke-virtual {v10}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :cond_0
    :goto_0
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-nez v11, :cond_3

    .line 152
    const/16 v2, 0x528

    .line 153
    .local v2, "dur":I
    const/4 v1, -0x1

    .line 154
    .local v1, "contentDuration":I
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v10

    invoke-virtual {v10}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v10

    const-string v11, "duration"

    invoke-virtual {v10, v11}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/Integer;

    if-eqz v10, :cond_1

    .line 156
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v10

    invoke-virtual {v10}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v10

    const-string v11, "duration"

    invoke-virtual {v10, v11}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/Integer;

    invoke-virtual {v10}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 158
    :cond_1
    if-lez v1, :cond_2

    .line 160
    move v2, v1

    .line 163
    :cond_2
    move-object v9, p1

    .line 166
    .local v9, "url":Ljava/lang/String;
    iget-object v10, p0, Lcom/auditude/ads/response/VMAPParser;->adRequest:Lcom/auditude/ads/loader/AdRequest;

    invoke-virtual {v10}, Lcom/auditude/ads/loader/AdRequest;->getMediaId()Ljava/lang/Object;

    move-result-object v10

    invoke-static {v10}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    .line 167
    .local v4, "mediaId":Ljava/lang/String;
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v10

    invoke-virtual {v10}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v10

    invoke-virtual {v10}, Lcom/auditude/ads/core/AdSettings;->getPassThroughParams()Ljava/util/HashMap;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/auditude/ads/util/AuditudeUtil;->substituteCustomPublisherTags(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v9

    .line 168
    const-string v10, "\\[vdur\\]"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 169
    const-string v10, "\\[pvrn\\]"

    const-string v11, "[random]"

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 170
    const-string v10, "\\[vprn\\]"

    const-string v11, "[random]"

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 171
    const-string v10, "\\[vid\\]"

    invoke-virtual {v9, v10, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 172
    const-string v10, "\\[slot\\]"

    invoke-virtual {v9, v10, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 173
    invoke-static {v9}, Lcom/auditude/ads/util/AuditudeUtil;->substituteTags(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 175
    return-object v9

    .line 132
    .end local v1    # "contentDuration":I
    .end local v2    # "dur":I
    .end local v4    # "mediaId":Ljava/lang/String;
    .end local v9    # "url":Ljava/lang/String;
    :cond_3
    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/smil/Group;

    .line 134
    .local v0, "adBreak":Lcom/auditude/ads/model/smil/Group;
    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Group;->getStartTime()I

    move-result v11

    if-lez v11, :cond_0

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Group;->getStartTime()I

    move-result v11

    if-ge v11, v13, :cond_0

    .line 136
    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "pod"

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 137
    .local v6, "slid":Ljava/lang/String;
    const-string v5, "midroll"

    .line 138
    .local v5, "slau":Ljava/lang/String;
    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Group;->getStartTime()I

    move-result v11

    if-gtz v11, :cond_5

    .line 140
    const-string v5, "preroll"

    .line 146
    :cond_4
    :goto_1
    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Group;->getStartTime()I

    move-result v11

    div-int/lit16 v8, v11, 0x3e8

    .line 147
    .local v8, "tpos":I
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v12, "slid="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "&slau="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "&h=[height]&w=[width]&tpos="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "&ptgt=a&cpsq="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, ";"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 148
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_0

    .line 142
    .end local v8    # "tpos":I
    :cond_5
    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Group;->getStartTime()I

    move-result v11

    if-lt v11, v13, :cond_4

    .line 144
    const-string v5, "postroll"

    goto :goto_1
.end method

.method private createGroups()V
    .locals 20

    .prologue
    .line 402
    const/4 v7, 0x0

    .line 403
    .local v7, "lastStartTime":I
    const/4 v4, 0x0

    .line 404
    .local v4, "breakIndex":I
    const/4 v5, 0x0

    .line 405
    .local v5, "chapterIndex":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->adBreaks:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    new-instance v17, Lcom/auditude/ads/response/VMAPParser$sortOnStartTime;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/auditude/ads/response/VMAPParser$sortOnStartTime;-><init>(Lcom/auditude/ads/response/VMAPParser;)V

    invoke-static/range {v16 .. v17}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 406
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->adBreaks:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v16

    :goto_0
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-nez v17, :cond_1

    .line 495
    const v16, 0x186a0

    move/from16 v0, v16

    if-ge v7, v0, :cond_0

    .line 497
    new-instance v9, Lcom/auditude/ads/model/smil/Group;

    sget-object v16, Lcom/auditude/ads/model/smil/SmilElementType;->NON_LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/auditude/ads/response/AdResponse;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v17

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    invoke-direct {v9, v0, v5, v1}, Lcom/auditude/ads/model/smil/Group;-><init>(Lcom/auditude/ads/model/smil/SmilElementType;ILcom/auditude/ads/core/AdSettings;)V

    .line 498
    .local v9, "nChapter":Lcom/auditude/ads/model/smil/Group;
    mul-int/lit16 v0, v7, 0x3e8

    move/from16 v16, v0

    move/from16 v0, v16

    invoke-virtual {v9, v0}, Lcom/auditude/ads/model/smil/Group;->setStartTime(I)V

    .line 499
    new-instance v6, Lcom/auditude/ads/model/smil/Sequence;

    const/16 v16, 0x0

    sget-object v17, Lcom/auditude/ads/model/smil/SmilElementType;->NON_LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    invoke-direct {v6, v0, v1}, Lcom/auditude/ads/model/smil/Sequence;-><init>(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/SmilElementType;)V

    .line 500
    .local v6, "chapterSequence":Lcom/auditude/ads/model/smil/Sequence;
    const v16, 0x5f5e100

    move/from16 v0, v16

    invoke-virtual {v6, v0}, Lcom/auditude/ads/model/smil/Sequence;->setDuration(I)V

    .line 501
    invoke-virtual {v9, v6}, Lcom/auditude/ads/model/smil/Group;->addSequence(Lcom/auditude/ads/model/smil/Sequence;)V

    .line 502
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->chapters:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 503
    add-int/lit8 v5, v5, 0x1

    .line 506
    .end local v6    # "chapterSequence":Lcom/auditude/ads/model/smil/Sequence;
    .end local v9    # "nChapter":Lcom/auditude/ads/model/smil/Group;
    :cond_0
    return-void

    .line 406
    :cond_1
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/auditude/ads/response/VMAPAdBreak;

    .line 412
    .local v3, "adBreak":Lcom/auditude/ads/response/VMAPAdBreak;
    if-nez v4, :cond_2

    invoke-virtual {v3}, Lcom/auditude/ads/response/VMAPAdBreak;->getStartTime()I

    move-result v17

    if-eqz v17, :cond_2

    .line 414
    new-instance v8, Lcom/auditude/ads/model/smil/Group;

    sget-object v17, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/auditude/ads/response/AdResponse;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-direct {v8, v0, v4, v1}, Lcom/auditude/ads/model/smil/Group;-><init>(Lcom/auditude/ads/model/smil/SmilElementType;ILcom/auditude/ads/core/AdSettings;)V

    .line 415
    .local v8, "nBreak":Lcom/auditude/ads/model/smil/Group;
    new-instance v11, Lcom/auditude/ads/model/smil/Sequence;

    const/16 v17, 0x0

    sget-object v18, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-direct {v11, v0, v1}, Lcom/auditude/ads/model/smil/Sequence;-><init>(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/SmilElementType;)V

    .line 416
    .local v11, "preroll":Lcom/auditude/ads/model/smil/Sequence;
    invoke-virtual {v8, v11}, Lcom/auditude/ads/model/smil/Group;->addSequence(Lcom/auditude/ads/model/smil/Sequence;)V

    .line 417
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->breaks:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 418
    add-int/lit8 v4, v4, 0x1

    .line 422
    .end local v8    # "nBreak":Lcom/auditude/ads/model/smil/Group;
    .end local v11    # "preroll":Lcom/auditude/ads/model/smil/Sequence;
    :cond_2
    invoke-virtual {v3}, Lcom/auditude/ads/response/VMAPAdBreak;->getStartTime()I

    move-result v17

    move/from16 v0, v17

    mul-int/lit16 v0, v0, 0x3e8

    move/from16 v17, v0

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-direct {v0, v1}, Lcom/auditude/ads/response/VMAPParser;->getBreakAt(I)Lcom/auditude/ads/model/smil/Group;

    move-result-object v8

    .line 423
    .restart local v8    # "nBreak":Lcom/auditude/ads/model/smil/Group;
    if-nez v8, :cond_3

    .line 425
    new-instance v8, Lcom/auditude/ads/model/smil/Group;

    .end local v8    # "nBreak":Lcom/auditude/ads/model/smil/Group;
    sget-object v17, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/auditude/ads/response/AdResponse;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-direct {v8, v0, v4, v1}, Lcom/auditude/ads/model/smil/Group;-><init>(Lcom/auditude/ads/model/smil/SmilElementType;ILcom/auditude/ads/core/AdSettings;)V

    .line 426
    .restart local v8    # "nBreak":Lcom/auditude/ads/model/smil/Group;
    invoke-virtual {v3}, Lcom/auditude/ads/response/VMAPAdBreak;->getStartTime()I

    move-result v17

    move/from16 v0, v17

    mul-int/lit16 v0, v0, 0x3e8

    move/from16 v17, v0

    move/from16 v0, v17

    invoke-virtual {v8, v0}, Lcom/auditude/ads/model/smil/Group;->setStartTime(I)V

    .line 427
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->breaks:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 428
    add-int/lit8 v4, v4, 0x1

    .line 432
    :cond_3
    new-instance v13, Lcom/auditude/ads/model/smil/Sequence;

    const/16 v17, 0x0

    sget-object v18, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-direct {v13, v0, v1}, Lcom/auditude/ads/model/smil/Sequence;-><init>(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/SmilElementType;)V

    .line 433
    .local v13, "sequence":Lcom/auditude/ads/model/smil/Sequence;
    const v17, 0x5f5e100

    move/from16 v0, v17

    invoke-virtual {v13, v0}, Lcom/auditude/ads/model/smil/Sequence;->setDuration(I)V

    .line 434
    invoke-virtual {v8, v13}, Lcom/auditude/ads/model/smil/Group;->addSequence(Lcom/auditude/ads/model/smil/Sequence;)V

    .line 436
    invoke-virtual {v3}, Lcom/auditude/ads/response/VMAPAdBreak;->getVastDocuments()Ljava/util/ArrayList;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v17

    :goto_1
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->hasNext()Z

    move-result v18

    if-nez v18, :cond_5

    .line 480
    invoke-virtual {v3}, Lcom/auditude/ads/response/VMAPAdBreak;->getStartTime()I

    move-result v17

    move/from16 v0, v17

    if-eq v0, v7, :cond_4

    .line 482
    new-instance v9, Lcom/auditude/ads/model/smil/Group;

    sget-object v17, Lcom/auditude/ads/model/smil/SmilElementType;->NON_LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/auditude/ads/response/AdResponse;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-direct {v9, v0, v5, v1}, Lcom/auditude/ads/model/smil/Group;-><init>(Lcom/auditude/ads/model/smil/SmilElementType;ILcom/auditude/ads/core/AdSettings;)V

    .line 483
    .restart local v9    # "nChapter":Lcom/auditude/ads/model/smil/Group;
    mul-int/lit16 v0, v7, 0x3e8

    move/from16 v17, v0

    move/from16 v0, v17

    invoke-virtual {v9, v0}, Lcom/auditude/ads/model/smil/Group;->setStartTime(I)V

    .line 484
    new-instance v6, Lcom/auditude/ads/model/smil/Sequence;

    const/16 v17, 0x0

    sget-object v18, Lcom/auditude/ads/model/smil/SmilElementType;->NON_LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-direct {v6, v0, v1}, Lcom/auditude/ads/model/smil/Sequence;-><init>(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/SmilElementType;)V

    .line 485
    .restart local v6    # "chapterSequence":Lcom/auditude/ads/model/smil/Sequence;
    invoke-virtual {v3}, Lcom/auditude/ads/response/VMAPAdBreak;->getStartTime()I

    move-result v17

    sub-int v17, v17, v7

    move/from16 v0, v17

    mul-int/lit16 v0, v0, 0x3e8

    move/from16 v17, v0

    move/from16 v0, v17

    invoke-virtual {v6, v0}, Lcom/auditude/ads/model/smil/Sequence;->setDuration(I)V

    .line 486
    invoke-virtual {v9, v6}, Lcom/auditude/ads/model/smil/Group;->addSequence(Lcom/auditude/ads/model/smil/Sequence;)V

    .line 487
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->chapters:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 488
    add-int/lit8 v5, v5, 0x1

    .line 491
    .end local v6    # "chapterSequence":Lcom/auditude/ads/model/smil/Sequence;
    .end local v9    # "nChapter":Lcom/auditude/ads/model/smil/Group;
    :cond_4
    invoke-virtual {v3}, Lcom/auditude/ads/response/VMAPAdBreak;->getStartTime()I

    move-result v7

    goto/16 :goto_0

    .line 436
    :cond_5
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lcom/auditude/ads/network/vast/model/VASTDocument;

    .line 438
    .local v15, "vastDoc":Lcom/auditude/ads/network/vast/model/VASTDocument;
    invoke-virtual {v3}, Lcom/auditude/ads/response/VMAPAdBreak;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v18

    :goto_2
    invoke-interface/range {v18 .. v18}, Ljava/util/Iterator;->hasNext()Z

    move-result v19

    if-nez v19, :cond_7

    .line 444
    new-instance v2, Lcom/auditude/ads/model/Ad;

    const/16 v18, 0x0

    move-object/from16 v0, v18

    invoke-direct {v2, v0}, Lcom/auditude/ads/model/Ad;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 445
    .local v2, "ad":Lcom/auditude/ads/model/Ad;
    const/16 v18, 0x1

    invoke-static/range {v18 .. v18}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v2, v0}, Lcom/auditude/ads/model/Ad;->setIsFromVmapDoc(Ljava/lang/Boolean;)V

    .line 446
    const/16 v18, 0x0

    invoke-static/range {v18 .. v18}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v2, v0}, Lcom/auditude/ads/model/Ad;->setDispatchError(Ljava/lang/Boolean;)V

    .line 447
    const/16 v18, 0x1

    move/from16 v0, v18

    invoke-virtual {v2, v0}, Lcom/auditude/ads/model/Ad;->setIsNetworkAd(Z)V

    .line 448
    const-string v18, "vast"

    move-object/from16 v0, v18

    invoke-virtual {v2, v0}, Lcom/auditude/ads/model/Ad;->setNetworkAdType(Ljava/lang/String;)V

    .line 449
    invoke-virtual {v3}, Lcom/auditude/ads/response/VMAPAdBreak;->getFollowRedirects()Ljava/lang/Boolean;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v2, v0}, Lcom/auditude/ads/model/Ad;->setFollowRedirects(Ljava/lang/Boolean;)V

    .line 450
    invoke-virtual {v3}, Lcom/auditude/ads/response/VMAPAdBreak;->getAllowMultipleAds()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v2, v0}, Lcom/auditude/ads/model/Ad;->setAllowMultipleAds(Ljava/lang/String;)V

    .line 453
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->trackingAd:Lcom/auditude/ads/model/Ad;

    move-object/from16 v18, v0

    if-eqz v18, :cond_6

    .line 455
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->trackingAd:Lcom/auditude/ads/model/Ad;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/auditude/ads/model/Ad;->getID()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v2, v0}, Lcom/auditude/ads/model/Ad;->setID(Ljava/lang/String;)V

    .line 456
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->trackingAd:Lcom/auditude/ads/model/Ad;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/auditude/ads/model/Ad;->isRepackagingEnabled()Z

    move-result v18

    move/from16 v0, v18

    invoke-virtual {v2, v0}, Lcom/auditude/ads/model/Ad;->setRepackagingEnabled(Z)V

    .line 457
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->trackingAd:Lcom/auditude/ads/model/Ad;

    move-object/from16 v18, v0

    const-string v19, "linear"

    invoke-virtual/range {v18 .. v19}, Lcom/auditude/ads/model/Ad;->getTrackingAssetByType(Ljava/lang/String;)Lcom/auditude/ads/model/Asset;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v2, v0}, Lcom/auditude/ads/model/Ad;->addTrackingAsset(Lcom/auditude/ads/model/Asset;)V

    .line 458
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->trackingAd:Lcom/auditude/ads/model/Ad;

    move-object/from16 v18, v0

    const-string v19, "nonlinear"

    invoke-virtual/range {v18 .. v19}, Lcom/auditude/ads/model/Ad;->getTrackingAssetByType(Ljava/lang/String;)Lcom/auditude/ads/model/Asset;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v2, v0}, Lcom/auditude/ads/model/Ad;->addTrackingAsset(Lcom/auditude/ads/model/Asset;)V

    .line 459
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/VMAPParser;->trackingAd:Lcom/auditude/ads/model/Ad;

    move-object/from16 v18, v0

    const-string v19, "companion"

    invoke-virtual/range {v18 .. v19}, Lcom/auditude/ads/model/Ad;->getTrackingAssetByType(Ljava/lang/String;)Lcom/auditude/ads/model/Asset;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v2, v0}, Lcom/auditude/ads/model/Ad;->addTrackingAsset(Lcom/auditude/ads/model/Asset;)V

    .line 462
    :cond_6
    iget-object v0, v15, Lcom/auditude/ads/network/vast/model/VASTDocument;->adTagURI:Ljava/lang/String;

    move-object/from16 v18, v0

    if-eqz v18, :cond_8

    .line 464
    iget-object v0, v15, Lcom/auditude/ads/network/vast/model/VASTDocument;->adTagURI:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v2, v0}, Lcom/auditude/ads/model/Ad;->setNetworkAdSource(Ljava/lang/Object;)V

    .line 472
    :goto_3
    new-instance v10, Lcom/auditude/ads/model/smil/Par;

    invoke-direct {v10, v13}, Lcom/auditude/ads/model/smil/Par;-><init>(Lcom/auditude/ads/model/smil/Sequence;)V

    .line 473
    .local v10, "par":Lcom/auditude/ads/model/smil/Par;
    new-instance v12, Lcom/auditude/ads/model/smil/Ref;

    invoke-direct {v12, v10}, Lcom/auditude/ads/model/smil/Ref;-><init>(Lcom/auditude/ads/model/smil/Par;)V

    .line 474
    .local v12, "ref":Lcom/auditude/ads/model/smil/Ref;
    invoke-virtual {v10, v12}, Lcom/auditude/ads/model/smil/Par;->addRef(Lcom/auditude/ads/model/smil/Ref;)V

    .line 475
    invoke-virtual {v12, v2}, Lcom/auditude/ads/model/smil/Ref;->setAd(Lcom/auditude/ads/model/Ad;)V

    .line 476
    invoke-virtual {v13, v10}, Lcom/auditude/ads/model/smil/Sequence;->addPar(Lcom/auditude/ads/model/smil/Par;)V

    goto/16 :goto_1

    .line 438
    .end local v2    # "ad":Lcom/auditude/ads/model/Ad;
    .end local v10    # "par":Lcom/auditude/ads/model/smil/Par;
    .end local v12    # "ref":Lcom/auditude/ads/model/smil/Ref;
    :cond_7
    invoke-interface/range {v18 .. v18}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lcom/auditude/ads/model/tracking/TrackingUrl;

    .line 440
    .local v14, "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    invoke-virtual {v14}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getType()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v13, v14, v0}, Lcom/auditude/ads/model/smil/Sequence;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    goto/16 :goto_2

    .line 468
    .end local v14    # "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    .restart local v2    # "ad":Lcom/auditude/ads/model/Ad;
    :cond_8
    invoke-virtual {v2, v15}, Lcom/auditude/ads/model/Ad;->setNetworkAdSource(Ljava/lang/Object;)V

    goto :goto_3
.end method

.method private createRepeatBreaks(Lcom/auditude/ads/response/VMAPAdBreak;I)V
    .locals 8
    .param p1, "adBreakToRepeat"    # Lcom/auditude/ads/response/VMAPAdBreak;
    .param p2, "contentDuration"    # I

    .prologue
    const/4 v7, 0x0

    .line 363
    invoke-virtual {p1}, Lcom/auditude/ads/response/VMAPAdBreak;->getStartTime()I

    move-result v4

    .line 364
    .local v4, "timeOffset":I
    invoke-virtual {p1}, Lcom/auditude/ads/response/VMAPAdBreak;->getRepeatAfter()I

    move-result v2

    .line 367
    .local v2, "repeatAfter":I
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 368
    .local v3, "timeList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    iget-object v5, p0, Lcom/auditude/ads/response/VMAPParser;->adBreaks:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-nez v6, :cond_2

    .line 375
    invoke-static {v3}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 378
    :cond_1
    add-int v5, v4, v2

    if-le v5, p2, :cond_3

    .line 397
    return-void

    .line 368
    :cond_2
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/response/VMAPAdBreak;

    .line 370
    .local v0, "adBreak":Lcom/auditude/ads/response/VMAPAdBreak;
    invoke-virtual {v0}, Lcom/auditude/ads/response/VMAPAdBreak;->getStartTime()I

    move-result v6

    if-le v6, v4, :cond_0

    .line 372
    invoke-virtual {v0}, Lcom/auditude/ads/response/VMAPAdBreak;->getStartTime()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 380
    .end local v0    # "adBreak":Lcom/auditude/ads/response/VMAPAdBreak;
    :cond_3
    add-int/2addr v4, v2

    .line 381
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_4

    invoke-virtual {v3, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    if-lt v5, v4, :cond_5

    .line 383
    :cond_4
    invoke-virtual {p1, v4}, Lcom/auditude/ads/response/VMAPAdBreak;->getCopy(I)Lcom/auditude/ads/response/VMAPAdBreak;

    move-result-object v1

    .line 384
    .local v1, "newBreak":Lcom/auditude/ads/response/VMAPAdBreak;
    iget-object v5, p0, Lcom/auditude/ads/response/VMAPParser;->adBreaks:Ljava/util/ArrayList;

    invoke-virtual {v5, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 392
    .end local v1    # "newBreak":Lcom/auditude/ads/response/VMAPAdBreak;
    :cond_5
    :goto_1
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_1

    invoke-virtual {v3, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    if-gt v5, v4, :cond_1

    .line 394
    invoke-virtual {v3, v7}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    goto :goto_1
.end method

.method private getAdBreakAt(I)Lcom/auditude/ads/response/VMAPAdBreak;
    .locals 2
    .param p1, "offset"    # I

    .prologue
    .line 539
    new-instance v0, Lcom/auditude/ads/response/VMAPAdBreak;

    invoke-direct {v0, p1}, Lcom/auditude/ads/response/VMAPAdBreak;-><init>(I)V

    .line 540
    .local v0, "vmapBreak":Lcom/auditude/ads/response/VMAPAdBreak;
    iget-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->adBreaks:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 541
    return-object v0
.end method

.method private getAssetException(ILjava/lang/String;)Lcom/auditude/ads/exception/AssetException;
    .locals 2
    .param p1, "id"    # I
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 631
    new-instance v0, Lcom/auditude/ads/exception/AssetException;

    invoke-direct {v0, p1, p2}, Lcom/auditude/ads/exception/AssetException;-><init>(ILjava/lang/String;)V

    .line 632
    .local v0, "exception":Lcom/auditude/ads/exception/AssetException;
    iget-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->trackingAd:Lcom/auditude/ads/model/Ad;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->trackingAd:Lcom/auditude/ads/model/Ad;

    invoke-virtual {v1}, Lcom/auditude/ads/model/Ad;->getID()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/auditude/ads/exception/AssetException;->adId:Ljava/lang/String;

    .line 633
    :cond_0
    return-object v0
.end method

.method private getBreakAt(I)Lcom/auditude/ads/model/smil/Group;
    .locals 3
    .param p1, "startTime"    # I

    .prologue
    .line 546
    iget-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->breaks:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 553
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 546
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/smil/Group;

    .line 548
    .local v0, "nBreak":Lcom/auditude/ads/model/smil/Group;
    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Group;->getStartTime()I

    move-result v2

    if-ne v2, p1, :cond_0

    goto :goto_0
.end method

.method private getTimeOffset(Ljava/lang/String;)I
    .locals 5
    .param p1, "offset"    # Ljava/lang/String;

    .prologue
    .line 561
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    if-gtz v3, :cond_1

    .line 563
    :cond_0
    const/4 v1, -0x1

    .line 601
    :goto_0
    return v1

    .line 566
    :cond_1
    const/4 v0, -0x1

    .line 567
    .local v0, "contentDuration":I
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v3

    invoke-virtual {v3}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v3

    const-string v4, "duration"

    invoke-virtual {v3, v4}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    if-eqz v3, :cond_2

    .line 569
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v3

    invoke-virtual {v3}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v3

    const-string v4, "duration"

    invoke-virtual {v3, v4}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 572
    :cond_2
    const/4 v1, -0x1

    .line 573
    .local v1, "nOffset":I
    const-string v3, "start"

    invoke-virtual {p1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 575
    const/4 v1, 0x0

    .line 576
    goto :goto_0

    .line 577
    :cond_3
    const-string v3, "end"

    invoke-virtual {p1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 579
    const v1, 0x186a0

    .line 580
    goto :goto_0

    .line 581
    :cond_4
    const-string v3, "(^[-.0-9]+:[-.0-9]+:[-.0-9]+$)"

    invoke-virtual {p1, v3}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 583
    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->parseDuration(Ljava/lang/String;)I

    move-result v1

    .line 584
    goto :goto_0

    .line 585
    :cond_5
    const-string v3, "%"

    invoke-virtual {p1, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_7

    if-lez v0, :cond_7

    .line 587
    const-string v3, "%"

    const-string v4, ""

    invoke-virtual {p1, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/auditude/ads/util/StringUtil;->convertToInt(Ljava/lang/String;)I

    move-result v2

    .line 588
    .local v2, "per":I
    const/16 v3, 0x64

    if-lt v2, v3, :cond_6

    .line 590
    const v1, 0x186a0

    .line 591
    goto :goto_0

    .line 594
    :cond_6
    int-to-float v3, v0

    int-to-float v4, v2

    mul-float/2addr v3, v4

    const/high16 v4, 0x42c80000    # 100.0f

    div-float/2addr v3, v4

    float-to-int v3, v3

    div-int/lit16 v1, v3, 0x3e8

    .line 596
    goto :goto_0

    .line 599
    .end local v2    # "per":I
    :cond_7
    const/4 v1, -0x1

    goto :goto_0
.end method

.method public static isValidParserForResponse(Lcom/auditude/ads/response/AdResponse;)Ljava/lang/Boolean;
    .locals 6
    .param p0, "adResponse"    # Lcom/auditude/ads/response/AdResponse;

    .prologue
    .line 53
    if-eqz p0, :cond_1

    .line 55
    invoke-virtual {p0}, Lcom/auditude/ads/response/AdResponse;->getAds()Ljava/util/HashMap;

    move-result-object v1

    .line 56
    .local v1, "ads":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Lcom/auditude/ads/model/Ad;>;"
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/util/HashMap;->size()I

    move-result v3

    if-lez v3, :cond_1

    .line 58
    invoke-virtual {v1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_2

    .line 69
    .end local v1    # "ads":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Lcom/auditude/ads/model/Ad;>;"
    :cond_1
    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    :goto_0
    return-object v3

    .line 58
    .restart local v1    # "ads":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Lcom/auditude/ads/model/Ad;>;"
    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 60
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/auditude/ads/model/Ad;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/Ad;

    .line 61
    .local v0, "ad":Lcom/auditude/ads/model/Ad;
    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->getIsNetworkAd()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->getNetworkAdType()Ljava/lang/String;

    move-result-object v4

    const-string v5, "VMAP"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 63
    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    goto :goto_0
.end method

.method private loadVMAP(Ljava/lang/String;)V
    .locals 4
    .param p1, "source"    # Ljava/lang/String;

    .prologue
    const/16 v3, 0x455

    .line 104
    if-eqz p1, :cond_0

    .line 106
    new-instance v1, Lcom/auditude/ads/loader/DataLoader;

    invoke-direct {v1}, Lcom/auditude/ads/loader/DataLoader;-><init>()V

    iput-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    .line 107
    iget-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    invoke-virtual {v1, p0}, Lcom/auditude/ads/loader/DataLoader;->setDataLoaderListener(Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;)V

    .line 108
    invoke-direct {p0, p1}, Lcom/auditude/ads/response/VMAPParser;->constructURL(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 109
    iget-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    const/4 v2, 0x0

    iget v3, p0, Lcom/auditude/ads/response/VMAPParser;->timeout:I

    invoke-virtual {v1, p1, v2, v3}, Lcom/auditude/ads/loader/DataLoader;->load(Ljava/lang/String;Ljava/lang/String;I)V

    .line 125
    :goto_0
    return-void

    .line 113
    :cond_0
    iget-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    iget-object v2, p0, Lcom/auditude/ads/response/VMAPParser;->breaks:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Lcom/auditude/ads/response/AdResponse;->setBreaks(Ljava/util/ArrayList;)V

    .line 114
    iget-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    iget-object v2, p0, Lcom/auditude/ads/response/VMAPParser;->chapters:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Lcom/auditude/ads/response/AdResponse;->setChapters(Ljava/util/ArrayList;)V

    .line 115
    const-string v0, "VMAP load failed"

    .line 116
    .local v0, "msg":Ljava/lang/String;
    iget-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->trackingAd:Lcom/auditude/ads/model/Ad;

    if-eqz v1, :cond_1

    .line 118
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ": "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/auditude/ads/response/VMAPParser;->trackingAd:Lcom/auditude/ads/model/Ad;

    invoke-virtual {v2}, Lcom/auditude/ads/model/Ad;->getNetworkAdSource()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 120
    :cond_1
    iget-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->listener:Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

    invoke-direct {p0, v3, v0}, Lcom/auditude/ads/response/VMAPParser;->getAssetException(ILjava/lang/String;)Lcom/auditude/ads/exception/AssetException;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;->onRequestComplete(Lcom/auditude/ads/exception/AssetException;)V

    .line 121
    invoke-virtual {p0, v3, v0}, Lcom/auditude/ads/response/VMAPParser;->logError(ILjava/lang/String;)V

    .line 122
    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->loadFailed:Ljava/lang/Boolean;

    goto :goto_0
.end method

.method private parseLinearBreak(Lcom/auditude/ads/response/VmapXmlNode;)V
    .locals 22
    .param p1, "adBreakNode"    # Lcom/auditude/ads/response/VmapXmlNode;

    .prologue
    .line 291
    const-string v19, "timeOffset"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/auditude/ads/response/VmapXmlNode;->getAttributeByName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-direct {v0, v1}, Lcom/auditude/ads/response/VMAPParser;->getTimeOffset(Ljava/lang/String;)I

    move-result v10

    .line 292
    .local v10, "timeOffset":I
    if-ltz v10, :cond_3

    .line 294
    move-object/from16 v0, p0

    invoke-direct {v0, v10}, Lcom/auditude/ads/response/VMAPParser;->getAdBreakAt(I)Lcom/auditude/ads/response/VMAPAdBreak;

    move-result-object v2

    .line 295
    .local v2, "adBreak":Lcom/auditude/ads/response/VMAPAdBreak;
    const-string v19, "repeatAfter"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/auditude/ads/response/VmapXmlNode;->getAttributeByName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-direct {v0, v1}, Lcom/auditude/ads/response/VMAPParser;->getTimeOffset(Ljava/lang/String;)I

    move-result v9

    .line 296
    .local v9, "repeatAfter":I
    if-ltz v9, :cond_0

    .line 298
    invoke-virtual {v2, v9}, Lcom/auditude/ads/response/VMAPAdBreak;->setRepeatAfter(I)V

    .line 302
    :cond_0
    const-string v19, "AdSource"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/auditude/ads/response/VmapXmlNode;->getChildeNodesByName(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v6

    .line 303
    .local v6, "adSourceNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    if-eqz v6, :cond_2

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v19

    if-lez v19, :cond_2

    .line 305
    const/16 v19, 0x0

    move/from16 v0, v19

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/auditude/ads/response/VmapXmlNode;

    .line 306
    .local v5, "adSourceNode":Lcom/auditude/ads/response/VmapXmlNode;
    const-string v19, "allowMultipleAds"

    move-object/from16 v0, v19

    invoke-virtual {v5, v0}, Lcom/auditude/ads/response/VmapXmlNode;->getAttributeByName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 307
    .local v7, "allowMultipleAds":Ljava/lang/String;
    const-string v19, "followRedirects"

    move-object/from16 v0, v19

    invoke-virtual {v5, v0}, Lcom/auditude/ads/response/VmapXmlNode;->getAttributeByName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 309
    .local v8, "followRedirects":Ljava/lang/String;
    invoke-virtual {v5}, Lcom/auditude/ads/response/VmapXmlNode;->getChildNodes()Ljava/util/ArrayList;

    move-result-object v4

    .line 311
    .local v4, "adDataNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    if-eqz v4, :cond_2

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v19

    if-lez v19, :cond_2

    .line 313
    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v19

    :cond_1
    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-nez v20, :cond_4

    .line 340
    .end local v4    # "adDataNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    .end local v5    # "adSourceNode":Lcom/auditude/ads/response/VmapXmlNode;
    .end local v7    # "allowMultipleAds":Ljava/lang/String;
    .end local v8    # "followRedirects":Ljava/lang/String;
    :cond_2
    const-string v19, "TrackingEvents"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/auditude/ads/response/VmapXmlNode;->getChildeNodesByName(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v12

    .line 341
    .local v12, "trackingEventsNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    if-eqz v12, :cond_3

    invoke-virtual {v12}, Ljava/util/ArrayList;->size()I

    move-result v19

    if-lez v19, :cond_3

    .line 343
    const/16 v19, 0x0

    move/from16 v0, v19

    invoke-virtual {v12, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lcom/auditude/ads/response/VmapXmlNode;

    .line 344
    .local v11, "trackingEventsNode":Lcom/auditude/ads/response/VmapXmlNode;
    const-string v19, "Tracking"

    move-object/from16 v0, v19

    invoke-virtual {v11, v0}, Lcom/auditude/ads/response/VmapXmlNode;->getChildeNodesByName(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v14

    .line 346
    .local v14, "trackingNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    if-eqz v14, :cond_3

    invoke-virtual {v14}, Ljava/util/ArrayList;->size()I

    move-result v19

    if-lez v19, :cond_3

    .line 348
    invoke-virtual {v14}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v19

    :goto_0
    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-nez v20, :cond_7

    .line 358
    .end local v2    # "adBreak":Lcom/auditude/ads/response/VMAPAdBreak;
    .end local v6    # "adSourceNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    .end local v9    # "repeatAfter":I
    .end local v11    # "trackingEventsNode":Lcom/auditude/ads/response/VmapXmlNode;
    .end local v12    # "trackingEventsNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    .end local v14    # "trackingNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    :cond_3
    return-void

    .line 313
    .restart local v2    # "adBreak":Lcom/auditude/ads/response/VMAPAdBreak;
    .restart local v4    # "adDataNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    .restart local v5    # "adSourceNode":Lcom/auditude/ads/response/VmapXmlNode;
    .restart local v6    # "adSourceNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    .restart local v7    # "allowMultipleAds":Ljava/lang/String;
    .restart local v8    # "followRedirects":Ljava/lang/String;
    .restart local v9    # "repeatAfter":I
    :cond_4
    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/auditude/ads/response/VmapXmlNode;

    .line 315
    .local v3, "adDataNode":Lcom/auditude/ads/response/VmapXmlNode;
    invoke-virtual {v3}, Lcom/auditude/ads/response/VmapXmlNode;->getName()Ljava/lang/String;

    move-result-object v20

    const-string v21, "AdTagURI"

    invoke-virtual/range {v20 .. v21}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v20

    if-eqz v20, :cond_5

    .line 317
    invoke-virtual {v2, v7}, Lcom/auditude/ads/response/VMAPAdBreak;->setAllowMultipleAds(Ljava/lang/String;)V

    .line 318
    invoke-virtual {v2, v8}, Lcom/auditude/ads/response/VMAPAdBreak;->setFollowRedirects(Ljava/lang/String;)V

    .line 319
    new-instance v17, Lcom/auditude/ads/network/vast/model/VASTDocument;

    const/16 v20, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Lcom/auditude/ads/network/vast/model/VASTDocument;-><init>(Lcom/auditude/ads/network/vast/model/VASTAd;)V

    .line 320
    .local v17, "vDoc":Lcom/auditude/ads/network/vast/model/VASTDocument;
    invoke-virtual {v3}, Lcom/auditude/ads/response/VmapXmlNode;->getValue()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    move-object/from16 v1, v17

    iput-object v0, v1, Lcom/auditude/ads/network/vast/model/VASTDocument;->adTagURI:Ljava/lang/String;

    .line 321
    move-object/from16 v0, v17

    invoke-virtual {v2, v0}, Lcom/auditude/ads/response/VMAPAdBreak;->addVastDocument(Lcom/auditude/ads/network/vast/model/VASTDocument;)V

    .line 323
    .end local v17    # "vDoc":Lcom/auditude/ads/network/vast/model/VASTDocument;
    :cond_5
    invoke-virtual {v3}, Lcom/auditude/ads/response/VmapXmlNode;->getName()Ljava/lang/String;

    move-result-object v20

    const-string v21, "VASTAdData"

    invoke-virtual/range {v20 .. v21}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v20

    if-eqz v20, :cond_1

    .line 325
    invoke-virtual {v3}, Lcom/auditude/ads/response/VmapXmlNode;->getVastDocuments()Ljava/util/ArrayList;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v20

    :cond_6
    :goto_1
    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->hasNext()Z

    move-result v21

    if-eqz v21, :cond_1

    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Lcom/auditude/ads/network/vast/model/VASTDocument;

    .line 327
    .local v18, "vastDoc":Lcom/auditude/ads/network/vast/model/VASTDocument;
    if-eqz v18, :cond_6

    .line 329
    invoke-virtual {v2, v7}, Lcom/auditude/ads/response/VMAPAdBreak;->setAllowMultipleAds(Ljava/lang/String;)V

    .line 330
    invoke-virtual {v2, v8}, Lcom/auditude/ads/response/VMAPAdBreak;->setFollowRedirects(Ljava/lang/String;)V

    .line 331
    move-object/from16 v0, v18

    invoke-virtual {v2, v0}, Lcom/auditude/ads/response/VMAPAdBreak;->addVastDocument(Lcom/auditude/ads/network/vast/model/VASTDocument;)V

    goto :goto_1

    .line 348
    .end local v3    # "adDataNode":Lcom/auditude/ads/response/VmapXmlNode;
    .end local v4    # "adDataNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    .end local v5    # "adSourceNode":Lcom/auditude/ads/response/VmapXmlNode;
    .end local v7    # "allowMultipleAds":Ljava/lang/String;
    .end local v8    # "followRedirects":Ljava/lang/String;
    .end local v18    # "vastDoc":Lcom/auditude/ads/network/vast/model/VASTDocument;
    .restart local v11    # "trackingEventsNode":Lcom/auditude/ads/response/VmapXmlNode;
    .restart local v12    # "trackingEventsNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    .restart local v14    # "trackingNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    :cond_7
    invoke-interface/range {v19 .. v19}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/auditude/ads/response/VmapXmlNode;

    .line 350
    .local v13, "trackingNode":Lcom/auditude/ads/response/VmapXmlNode;
    const-string v20, "event"

    move-object/from16 v0, v20

    invoke-virtual {v13, v0}, Lcom/auditude/ads/response/VmapXmlNode;->getAttributeByName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 351
    .local v15, "type":Ljava/lang/String;
    invoke-virtual {v13}, Lcom/auditude/ads/response/VmapXmlNode;->getValue()Ljava/lang/String;

    move-result-object v16

    .line 352
    .local v16, "url":Ljava/lang/String;
    move-object/from16 v0, v16

    invoke-virtual {v2, v15, v0}, Lcom/auditude/ads/response/VMAPAdBreak;->addTrackingUrl(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private parseXML(Ljava/lang/String;)V
    .locals 9
    .param p1, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 238
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v6

    if-lez v6, :cond_1

    .line 240
    iget-object v6, p0, Lcom/auditude/ads/response/VMAPParser;->xmlParser:Lcom/auditude/ads/response/VmapXmlParser;

    invoke-virtual {v6, p1}, Lcom/auditude/ads/response/VmapXmlParser;->parseXML(Ljava/lang/String;)V

    .line 241
    iget-object v6, p0, Lcom/auditude/ads/response/VMAPParser;->xmlParser:Lcom/auditude/ads/response/VmapXmlParser;

    const-string v7, "AdBreak"

    invoke-virtual {v6, v7}, Lcom/auditude/ads/response/VmapXmlParser;->getChildeNodesByName(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v2

    .line 242
    .local v2, "adBreakNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    if-eqz v2, :cond_1

    .line 244
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_0
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_6

    .line 256
    .end local v2    # "adBreakNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    :cond_1
    const/4 v4, -0x1

    .line 257
    .local v4, "contentDuration":I
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v6

    invoke-virtual {v6}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v6

    const-string v7, "duration"

    invoke-virtual {v6, v7}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    if-eqz v6, :cond_2

    .line 259
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v6

    invoke-virtual {v6}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v6

    const-string v7, "duration"

    invoke-virtual {v6, v7}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v4

    .line 261
    :cond_2
    if-lez v4, :cond_4

    .line 264
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 265
    .local v5, "repeatList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VMAPAdBreak;>;"
    iget-object v6, p0, Lcom/auditude/ads/response/VMAPParser;->adBreaks:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_3
    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_7

    .line 273
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_8

    .line 279
    .end local v5    # "repeatList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VMAPAdBreak;>;"
    :cond_4
    iget-object v6, p0, Lcom/auditude/ads/response/VMAPParser;->adBreaks:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-lez v6, :cond_5

    .line 282
    invoke-direct {p0}, Lcom/auditude/ads/response/VMAPParser;->createGroups()V

    .line 284
    iget-object v6, p0, Lcom/auditude/ads/response/VMAPParser;->breaks:Ljava/util/ArrayList;

    iget-object v7, p0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    invoke-virtual {v7}, Lcom/auditude/ads/response/AdResponse;->getBreaks()Ljava/util/ArrayList;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/auditude/ads/response/VMAPParser;->appendSequenceState(Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    .line 285
    iget-object v6, p0, Lcom/auditude/ads/response/VMAPParser;->chapters:Ljava/util/ArrayList;

    iget-object v7, p0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    invoke-virtual {v7}, Lcom/auditude/ads/response/AdResponse;->getChapters()Ljava/util/ArrayList;

    move-result-object v7

    invoke-direct {p0, v6, v7}, Lcom/auditude/ads/response/VMAPParser;->appendSequenceState(Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    .line 287
    :cond_5
    return-void

    .line 244
    .end local v4    # "contentDuration":I
    .restart local v2    # "adBreakNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    :cond_6
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/response/VmapXmlNode;

    .line 246
    .local v1, "adBreakNode":Lcom/auditude/ads/response/VmapXmlNode;
    const-string v7, "breakType"

    invoke-virtual {v1, v7}, Lcom/auditude/ads/response/VmapXmlNode;->getAttributeByName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const-string v8, ","

    invoke-virtual {v7, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    aget-object v3, v7, v8

    .line 247
    .local v3, "breakType":Ljava/lang/String;
    const-string v7, "linear"

    invoke-virtual {v3, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 249
    invoke-direct {p0, v1}, Lcom/auditude/ads/response/VMAPParser;->parseLinearBreak(Lcom/auditude/ads/response/VmapXmlNode;)V

    goto/16 :goto_0

    .line 265
    .end local v1    # "adBreakNode":Lcom/auditude/ads/response/VmapXmlNode;
    .end local v2    # "adBreakNodes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VmapXmlNode;>;"
    .end local v3    # "breakType":Ljava/lang/String;
    .restart local v4    # "contentDuration":I
    .restart local v5    # "repeatList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/response/VMAPAdBreak;>;"
    :cond_7
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/response/VMAPAdBreak;

    .line 267
    .local v0, "adBreak":Lcom/auditude/ads/response/VMAPAdBreak;
    invoke-virtual {v0}, Lcom/auditude/ads/response/VMAPAdBreak;->getRepeatAfter()I

    move-result v7

    if-lez v7, :cond_3

    .line 269
    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 273
    .end local v0    # "adBreak":Lcom/auditude/ads/response/VMAPAdBreak;
    :cond_8
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/response/VMAPAdBreak;

    .line 275
    .restart local v0    # "adBreak":Lcom/auditude/ads/response/VMAPAdBreak;
    div-int/lit16 v7, v4, 0x3e8

    invoke-direct {p0, v0, v7}, Lcom/auditude/ads/response/VMAPParser;->createRepeatBreaks(Lcom/auditude/ads/response/VMAPAdBreak;I)V

    goto :goto_2
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .prologue
    .line 609
    iget-object v0, p0, Lcom/auditude/ads/response/VMAPParser;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    if-eqz v0, :cond_0

    .line 611
    iget-object v0, p0, Lcom/auditude/ads/response/VMAPParser;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    invoke-virtual {v0}, Lcom/auditude/ads/loader/DataLoader;->cancel()V

    .line 613
    :cond_0
    return-void
.end method

.method public loadAdRequest(Lcom/auditude/ads/response/AdResponse;Lcom/auditude/ads/loader/AdRequest;I)V
    .locals 7
    .param p1, "adResponse"    # Lcom/auditude/ads/response/AdResponse;
    .param p2, "adRequest"    # Lcom/auditude/ads/loader/AdRequest;
    .param p3, "timeout"    # I

    .prologue
    .line 74
    iput-object p1, p0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    .line 75
    iput-object p2, p0, Lcom/auditude/ads/response/VMAPParser;->adRequest:Lcom/auditude/ads/loader/AdRequest;

    .line 76
    iput p3, p0, Lcom/auditude/ads/response/VMAPParser;->timeout:I

    .line 78
    iget-object v4, p0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    if-eqz v4, :cond_1

    .line 80
    iget-object v4, p0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    invoke-virtual {v4}, Lcom/auditude/ads/response/AdResponse;->getAds()Ljava/util/HashMap;

    move-result-object v2

    .line 81
    .local v2, "ads":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Lcom/auditude/ads/model/Ad;>;"
    if-eqz v2, :cond_1

    invoke-virtual {v2}, Ljava/util/HashMap;->size()I

    move-result v4

    if-lez v4, :cond_1

    .line 83
    invoke-virtual {v2}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_3

    .line 99
    .end local v2    # "ads":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Lcom/auditude/ads/model/Ad;>;"
    :cond_1
    iget-object v4, p0, Lcom/auditude/ads/response/VMAPParser;->listener:Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

    const/4 v5, 0x0

    invoke-interface {v4, v5}, Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;->onRequestComplete(Lcom/auditude/ads/exception/AssetException;)V

    .line 100
    :cond_2
    :goto_0
    return-void

    .line 83
    .restart local v2    # "ads":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Lcom/auditude/ads/model/Ad;>;"
    :cond_3
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 85
    .local v3, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/auditude/ads/model/Ad;>;"
    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/Ad;

    .line 86
    .local v0, "ad":Lcom/auditude/ads/model/Ad;
    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->getIsNetworkAd()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->getNetworkAdType()Ljava/lang/String;

    move-result-object v5

    const-string v6, "VMAP"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 88
    iput-object v0, p0, Lcom/auditude/ads/response/VMAPParser;->trackingAd:Lcom/auditude/ads/model/Ad;

    .line 89
    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->getNetworkAdSource()Ljava/lang/Object;

    move-result-object v1

    .line 90
    .local v1, "adSource":Ljava/lang/Object;
    instance-of v4, v1, Ljava/lang/String;

    if-eqz v4, :cond_2

    .line 92
    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->getNetworkAdSource()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-direct {p0, v4}, Lcom/auditude/ads/response/VMAPParser;->loadVMAP(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected final logError(ILjava/lang/String;)V
    .locals 4
    .param p1, "id"    # I
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 625
    invoke-direct {p0, p1, p2}, Lcom/auditude/ads/response/VMAPParser;->getAssetException(ILjava/lang/String;)Lcom/auditude/ads/exception/AssetException;

    move-result-object v0

    .line 626
    .local v0, "exception":Lcom/auditude/ads/exception/AssetException;
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v1

    invoke-virtual {v1}, Lcom/auditude/ads/core/AuditudeEnv;->getAPI()Lcom/auditude/ads/core/APIBridge;

    move-result-object v1

    const-string v2, "playerError"

    new-instance v3, Lcom/auditude/ads/event/PlayerErrorEvent;

    invoke-direct {v3, p0, v0}, Lcom/auditude/ads/event/PlayerErrorEvent;-><init>(Lcom/auditude/ads/util/event/IEventDispatcher;Lcom/auditude/ads/exception/PlayerException;)V

    invoke-virtual {v1, v2, v3}, Lcom/auditude/ads/core/APIBridge;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 627
    return-void
.end method

.method public onRequestComplete(Ljava/lang/String;)V
    .locals 5
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 182
    :try_start_0
    invoke-direct {p0, p1}, Lcom/auditude/ads/response/VMAPParser;->parseXML(Ljava/lang/String;)V

    .line 183
    iget-object v3, p0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    iget-object v4, p0, Lcom/auditude/ads/response/VMAPParser;->breaks:Ljava/util/ArrayList;

    invoke-virtual {v3, v4}, Lcom/auditude/ads/response/AdResponse;->setBreaks(Ljava/util/ArrayList;)V

    .line 184
    iget-object v3, p0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    iget-object v4, p0, Lcom/auditude/ads/response/VMAPParser;->chapters:Ljava/util/ArrayList;

    invoke-virtual {v3, v4}, Lcom/auditude/ads/response/AdResponse;->setChapters(Ljava/util/ArrayList;)V

    .line 185
    const-string v1, "VMAP returned no ads"

    .line 186
    .local v1, "msg":Ljava/lang/String;
    iget-object v3, p0, Lcom/auditude/ads/response/VMAPParser;->trackingAd:Lcom/auditude/ads/model/Ad;

    if-eqz v3, :cond_0

    .line 188
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, ": "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/auditude/ads/response/VMAPParser;->trackingAd:Lcom/auditude/ads/model/Ad;

    invoke-virtual {v4}, Lcom/auditude/ads/model/Ad;->getNetworkAdSource()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 190
    :cond_0
    iget-object v3, p0, Lcom/auditude/ads/response/VMAPParser;->listener:Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

    if-eqz v3, :cond_1

    .line 192
    iget-object v3, p0, Lcom/auditude/ads/response/VMAPParser;->listener:Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

    const/16 v4, 0x454

    invoke-direct {p0, v4, v1}, Lcom/auditude/ads/response/VMAPParser;->getAssetException(ILjava/lang/String;)Lcom/auditude/ads/exception/AssetException;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;->onRequestComplete(Lcom/auditude/ads/exception/AssetException;)V

    .line 194
    :cond_1
    iget-object v3, p0, Lcom/auditude/ads/response/VMAPParser;->loadFailed:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_2

    iget-object v3, p0, Lcom/auditude/ads/response/VMAPParser;->breaks:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-gtz v3, :cond_2

    .line 196
    const/16 v3, 0x454

    invoke-virtual {p0, v3, v1}, Lcom/auditude/ads/response/VMAPParser;->logError(ILjava/lang/String;)V
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 212
    .end local v1    # "msg":Ljava/lang/String;
    :cond_2
    :goto_0
    return-void

    .line 199
    :catch_0
    move-exception v2

    .line 201
    .local v2, "ppe":Lorg/xmlpull/v1/XmlPullParserException;
    invoke-virtual {v2}, Lorg/xmlpull/v1/XmlPullParserException;->printStackTrace()V

    .line 202
    const/16 v3, 0x44f

    const-string v4, ""

    invoke-virtual {p0, v3, v4}, Lcom/auditude/ads/response/VMAPParser;->logError(ILjava/lang/String;)V

    .line 203
    iget-object v3, p0, Lcom/auditude/ads/response/VMAPParser;->listener:Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

    if-eqz v3, :cond_2

    .line 205
    iget-object v3, p0, Lcom/auditude/ads/response/VMAPParser;->listener:Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

    const/4 v4, 0x0

    invoke-interface {v3, v4}, Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;->onRequestComplete(Lcom/auditude/ads/exception/AssetException;)V

    goto :goto_0

    .line 208
    .end local v2    # "ppe":Lorg/xmlpull/v1/XmlPullParserException;
    :catch_1
    move-exception v0

    .line 210
    .local v0, "ioe":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method public onRequestFailed(Ljava/lang/Throwable;)V
    .locals 4
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    const/16 v3, 0x455

    .line 216
    iget-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    iget-object v2, p0, Lcom/auditude/ads/response/VMAPParser;->breaks:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Lcom/auditude/ads/response/AdResponse;->setBreaks(Ljava/util/ArrayList;)V

    .line 217
    iget-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    iget-object v2, p0, Lcom/auditude/ads/response/VMAPParser;->chapters:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Lcom/auditude/ads/response/AdResponse;->setChapters(Ljava/util/ArrayList;)V

    .line 218
    instance-of v1, p1, Ljava/net/SocketTimeoutException;

    if-eqz v1, :cond_0

    .line 220
    iget-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->listener:Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;->onRequestComplete(Lcom/auditude/ads/exception/AssetException;)V

    .line 221
    const/16 v1, 0x458

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lcom/auditude/ads/response/VMAPParser;->logError(ILjava/lang/String;)V

    .line 233
    :goto_0
    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->loadFailed:Ljava/lang/Boolean;

    .line 234
    return-void

    .line 225
    :cond_0
    const-string v0, "VMAP load failed"

    .line 226
    .local v0, "msg":Ljava/lang/String;
    iget-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->trackingAd:Lcom/auditude/ads/model/Ad;

    if-eqz v1, :cond_1

    .line 228
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ": "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/auditude/ads/response/VMAPParser;->trackingAd:Lcom/auditude/ads/model/Ad;

    invoke-virtual {v2}, Lcom/auditude/ads/model/Ad;->getNetworkAdSource()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 230
    :cond_1
    iget-object v1, p0, Lcom/auditude/ads/response/VMAPParser;->listener:Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

    invoke-direct {p0, v3, v0}, Lcom/auditude/ads/response/VMAPParser;->getAssetException(ILjava/lang/String;)Lcom/auditude/ads/exception/AssetException;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;->onRequestComplete(Lcom/auditude/ads/exception/AssetException;)V

    .line 231
    invoke-virtual {p0, v3, v0}, Lcom/auditude/ads/response/VMAPParser;->logError(ILjava/lang/String;)V

    goto :goto_0
.end method

.method public setResponseParserListener(Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

    .prologue
    .line 605
    iput-object p1, p0, Lcom/auditude/ads/response/VMAPParser;->listener:Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

    return-void
.end method
