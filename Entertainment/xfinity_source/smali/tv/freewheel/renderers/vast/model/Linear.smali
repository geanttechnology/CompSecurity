.class public Ltv/freewheel/renderers/vast/model/Linear;
.super Ltv/freewheel/renderers/vast/model/AbstractCreativeRenditionCollection;
.source "Linear.java"


# instance fields
.field public adParameters:Ljava/lang/String;

.field public duration:Ljava/lang/Double;

.field public mediaFiles:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/renderers/vast/model/MediaFile;",
            ">;"
        }
    .end annotation
.end field

.field public trackingEvents:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/renderers/vast/model/Tracking;",
            ">;"
        }
    .end annotation
.end field

.field public videoClicks:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/renderers/vast/model/VideoClick;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 22
    invoke-direct {p0}, Ltv/freewheel/renderers/vast/model/AbstractCreativeRenditionCollection;-><init>()V

    .line 23
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/renderers/vast/model/Linear;->trackingEvents:Ljava/util/ArrayList;

    .line 24
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/renderers/vast/model/Linear;->videoClicks:Ljava/util/ArrayList;

    .line 25
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/renderers/vast/model/Linear;->mediaFiles:Ljava/util/ArrayList;

    .line 26
    return-void
.end method


# virtual methods
.method public isValid(Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/ad/interfaces/IConstants;)Z
    .locals 1
    .param p1, "slot"    # Ltv/freewheel/ad/interfaces/ISlot;
    .param p2, "constants"    # Ltv/freewheel/ad/interfaces/IConstants;

    .prologue
    .line 99
    iget-object v0, p0, Ltv/freewheel/renderers/vast/model/Linear;->mediaFiles:Ljava/util/ArrayList;

    invoke-virtual {p0, v0, p1, p2}, Ltv/freewheel/renderers/vast/model/Linear;->validate(Ljava/util/ArrayList;Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/ad/interfaces/IConstants;)Z

    move-result v0

    return v0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 22
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 48
    const-string v19, "AdParameters"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-interface {v0, v1}, Lorg/w3c/dom/Element;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v2

    .line 49
    .local v2, "adParameterList":Lorg/w3c/dom/NodeList;
    invoke-interface {v2}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v19

    if-lez v19, :cond_0

    .line 50
    const/16 v19, 0x0

    move/from16 v0, v19

    invoke-interface {v2, v0}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v19

    invoke-static/range {v19 .. v19}, Ltv/freewheel/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Ltv/freewheel/renderers/vast/model/Linear;->adParameters:Ljava/lang/String;

    .line 53
    :cond_0
    invoke-interface/range {p1 .. p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v4

    .line 54
    .local v4, "children":Lorg/w3c/dom/NodeList;
    invoke-interface {v4}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v10

    .line 55
    .local v10, "len":I
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_0
    if-ge v8, v10, :cond_6

    .line 56
    invoke-interface {v4, v8}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    .line 57
    .local v3, "child":Lorg/w3c/dom/Node;
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v19

    const/16 v20, 0x1

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_1

    .line 58
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v13

    .line 59
    .local v13, "name":Ljava/lang/String;
    const-string v19, "Duration"

    move-object/from16 v0, v19

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_2

    .line 60
    invoke-static {v3}, Ltv/freewheel/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v6

    .line 61
    .local v6, "durationStr":Ljava/lang/String;
    const-string v19, ":"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    .line 62
    .local v7, "hms":[Ljava/lang/String;
    array-length v0, v7

    move/from16 v19, v0

    const/16 v20, 0x3

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_1

    .line 63
    new-instance v19, Ljava/lang/Double;

    const/16 v20, 0x2

    aget-object v20, v7, v20

    invoke-static/range {v20 .. v20}, Ltv/freewheel/renderers/vast/util/StringUtils;->parseInt(Ljava/lang/String;)I

    move-result v20

    const/16 v21, 0x1

    aget-object v21, v7, v21

    invoke-static/range {v21 .. v21}, Ltv/freewheel/renderers/vast/util/StringUtils;->parseInt(Ljava/lang/String;)I

    move-result v21

    mul-int/lit8 v21, v21, 0x3c

    add-int v20, v20, v21

    const/16 v21, 0x0

    aget-object v21, v7, v21

    invoke-static/range {v21 .. v21}, Ltv/freewheel/renderers/vast/util/StringUtils;->parseInt(Ljava/lang/String;)I

    move-result v21

    mul-int/lit8 v21, v21, 0x3c

    mul-int/lit8 v21, v21, 0x3c

    add-int v20, v20, v21

    move/from16 v0, v20

    int-to-double v0, v0

    move-wide/from16 v20, v0

    invoke-direct/range {v19 .. v21}, Ljava/lang/Double;-><init>(D)V

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Ltv/freewheel/renderers/vast/model/Linear;->duration:Ljava/lang/Double;

    .line 55
    .end local v3    # "child":Lorg/w3c/dom/Node;
    .end local v6    # "durationStr":Ljava/lang/String;
    .end local v7    # "hms":[Ljava/lang/String;
    .end local v13    # "name":Ljava/lang/String;
    :cond_1
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 67
    .restart local v3    # "child":Lorg/w3c/dom/Node;
    .restart local v13    # "name":Ljava/lang/String;
    :cond_2
    const-string v19, "TrackingEvents"

    move-object/from16 v0, v19

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_3

    .line 68
    check-cast v3, Lorg/w3c/dom/Element;

    .end local v3    # "child":Lorg/w3c/dom/Node;
    const-string v19, "Tracking"

    move-object/from16 v0, v19

    invoke-interface {v3, v0}, Lorg/w3c/dom/Element;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v15

    .line 69
    .local v15, "trackings":Lorg/w3c/dom/NodeList;
    const/4 v9, 0x0

    .local v9, "j":I
    :goto_1
    invoke-interface {v15}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v19

    move/from16 v0, v19

    if-ge v9, v0, :cond_1

    .line 70
    new-instance v14, Ltv/freewheel/renderers/vast/model/Tracking;

    invoke-direct {v14}, Ltv/freewheel/renderers/vast/model/Tracking;-><init>()V

    .line 71
    .local v14, "tracking":Ltv/freewheel/renderers/vast/model/Tracking;
    invoke-interface {v15, v9}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v19

    check-cast v19, Lorg/w3c/dom/Element;

    move-object/from16 v0, v19

    invoke-virtual {v14, v0}, Ltv/freewheel/renderers/vast/model/Tracking;->parse(Lorg/w3c/dom/Element;)V

    .line 72
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/model/Linear;->trackingEvents:Ljava/util/ArrayList;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v14}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 69
    add-int/lit8 v9, v9, 0x1

    goto :goto_1

    .line 74
    .end local v9    # "j":I
    .end local v14    # "tracking":Ltv/freewheel/renderers/vast/model/Tracking;
    .end local v15    # "trackings":Lorg/w3c/dom/NodeList;
    .restart local v3    # "child":Lorg/w3c/dom/Node;
    :cond_3
    const-string v19, "VideoClicks"

    move-object/from16 v0, v19

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_5

    .line 75
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v18

    .line 76
    .local v18, "videoClicks":Lorg/w3c/dom/NodeList;
    const/4 v9, 0x0

    .restart local v9    # "j":I
    :goto_2
    invoke-interface/range {v18 .. v18}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v19

    move/from16 v0, v19

    if-ge v9, v0, :cond_1

    .line 77
    move-object/from16 v0, v18

    invoke-interface {v0, v9}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v17

    .line 78
    .local v17, "videoClick":Lorg/w3c/dom/Node;
    invoke-interface/range {v17 .. v17}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v19

    const/16 v20, 0x1

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_4

    .line 79
    invoke-interface/range {v17 .. v17}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    .line 80
    .local v5, "clickType":Ljava/lang/String;
    new-instance v16, Ltv/freewheel/renderers/vast/model/VideoClick;

    move-object/from16 v0, v16

    invoke-direct {v0, v5}, Ltv/freewheel/renderers/vast/model/VideoClick;-><init>(Ljava/lang/String;)V

    .line 81
    .local v16, "vc":Ltv/freewheel/renderers/vast/model/VideoClick;
    check-cast v17, Lorg/w3c/dom/Element;

    .end local v17    # "videoClick":Lorg/w3c/dom/Node;
    invoke-virtual/range {v16 .. v17}, Ltv/freewheel/renderers/vast/model/VideoClick;->parse(Lorg/w3c/dom/Element;)V

    .line 82
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/model/Linear;->videoClicks:Ljava/util/ArrayList;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 76
    .end local v5    # "clickType":Ljava/lang/String;
    .end local v16    # "vc":Ltv/freewheel/renderers/vast/model/VideoClick;
    :cond_4
    add-int/lit8 v9, v9, 0x1

    goto :goto_2

    .line 85
    .end local v9    # "j":I
    .end local v18    # "videoClicks":Lorg/w3c/dom/NodeList;
    :cond_5
    const-string v19, "MediaFiles"

    move-object/from16 v0, v19

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_1

    .line 86
    check-cast v3, Lorg/w3c/dom/Element;

    .end local v3    # "child":Lorg/w3c/dom/Node;
    const-string v19, "MediaFile"

    move-object/from16 v0, v19

    invoke-interface {v3, v0}, Lorg/w3c/dom/Element;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v11

    .line 87
    .local v11, "mediaFiles":Lorg/w3c/dom/NodeList;
    const/4 v9, 0x0

    .restart local v9    # "j":I
    :goto_3
    invoke-interface {v11}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v19

    move/from16 v0, v19

    if-ge v9, v0, :cond_1

    .line 88
    new-instance v12, Ltv/freewheel/renderers/vast/model/MediaFile;

    move-object/from16 v0, p0

    invoke-direct {v12, v0}, Ltv/freewheel/renderers/vast/model/MediaFile;-><init>(Ltv/freewheel/renderers/vast/model/Linear;)V

    .line 89
    .local v12, "mf":Ltv/freewheel/renderers/vast/model/MediaFile;
    invoke-interface {v11, v9}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v19

    check-cast v19, Lorg/w3c/dom/Element;

    move-object/from16 v0, v19

    invoke-virtual {v12, v0}, Ltv/freewheel/renderers/vast/model/MediaFile;->parse(Lorg/w3c/dom/Element;)V

    .line 90
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/model/Linear;->mediaFiles:Ljava/util/ArrayList;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 87
    add-int/lit8 v9, v9, 0x1

    goto :goto_3

    .line 95
    .end local v9    # "j":I
    .end local v11    # "mediaFiles":Lorg/w3c/dom/NodeList;
    .end local v12    # "mf":Ltv/freewheel/renderers/vast/model/MediaFile;
    .end local v13    # "name":Ljava/lang/String;
    :cond_6
    return-void
.end method

.method public search(Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/ad/interfaces/IConstants;)Ljava/util/ArrayList;
    .locals 1
    .param p1, "slot"    # Ltv/freewheel/ad/interfaces/ISlot;
    .param p2, "constants"    # Ltv/freewheel/ad/interfaces/IConstants;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ltv/freewheel/ad/interfaces/ISlot;",
            "Ltv/freewheel/ad/interfaces/IConstants;",
            ")",
            "Ljava/util/ArrayList",
            "<+",
            "Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;",
            ">;"
        }
    .end annotation

    .prologue
    .line 103
    iget-object v0, p0, Ltv/freewheel/renderers/vast/model/Linear;->mediaFiles:Ljava/util/ArrayList;

    invoke-virtual {p0, v0, p1, p2}, Ltv/freewheel/renderers/vast/model/Linear;->searchAll(Ljava/util/ArrayList;Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/ad/interfaces/IConstants;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 7

    .prologue
    .line 30
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 31
    .local v1, "sb":Ljava/lang/StringBuilder;
    iget-object v3, p0, Ltv/freewheel/renderers/vast/model/Linear;->trackingEvents:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/renderers/vast/model/Tracking;

    .line 32
    .local v2, "t":Ltv/freewheel/renderers/vast/model/Tracking;
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 33
    const-string v3, "\n\t\t\t\t\t"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 35
    .end local v2    # "t":Ltv/freewheel/renderers/vast/model/Tracking;
    :cond_0
    const-string v3, "[Linear\n\t\t\t\tDuration=%f\n\t\t\t\tAdParameters=%s\n\t\t\t\tTrackingEvents=%s\n\t\t\t\tVideoClicks=%s\n\t\t\t\tMediaFiles=%s\n\t\t\t]"

    const/4 v4, 0x5

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Ltv/freewheel/renderers/vast/model/Linear;->duration:Ljava/lang/Double;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    iget-object v6, p0, Ltv/freewheel/renderers/vast/model/Linear;->adParameters:Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x2

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x3

    iget-object v6, p0, Ltv/freewheel/renderers/vast/model/Linear;->videoClicks:Ljava/util/ArrayList;

    aput-object v6, v4, v5

    const/4 v5, 0x4

    iget-object v6, p0, Ltv/freewheel/renderers/vast/model/Linear;->mediaFiles:Ljava/util/ArrayList;

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method
