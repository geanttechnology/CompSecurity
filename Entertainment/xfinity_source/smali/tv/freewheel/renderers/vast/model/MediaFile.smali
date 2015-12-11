.class public Ltv/freewheel/renderers/vast/model/MediaFile;
.super Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;
.source "MediaFile.java"


# instance fields
.field public bitrate:Ljava/lang/Integer;

.field public delivery:Ljava/lang/String;

.field private linear:Ltv/freewheel/renderers/vast/model/Linear;

.field public maintainAspectRatio:Ljava/lang/Boolean;

.field public scalable:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>(Ltv/freewheel/renderers/vast/model/Linear;)V
    .locals 0
    .param p1, "linear"    # Ltv/freewheel/renderers/vast/model/Linear;

    .prologue
    .line 25
    invoke-direct {p0}, Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;-><init>()V

    .line 26
    iput-object p1, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->linear:Ltv/freewheel/renderers/vast/model/Linear;

    .line 27
    return-void
.end method


# virtual methods
.method public adjustMatchedRendition(Ltv/freewheel/ad/interfaces/ICreativeRendition;Ljava/lang/String;Ljava/lang/String;)V
    .locals 9
    .param p1, "cr"    # Ltv/freewheel/ad/interfaces/ICreativeRendition;
    .param p2, "expectedContentType"    # Ljava/lang/String;
    .param p3, "expectedCreativeAPI"    # Ljava/lang/String;

    .prologue
    .line 82
    const/4 v1, 0x0

    .line 83
    .local v1, "contentTypeMatched":Z
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_0

    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_0

    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/lang/String;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_0

    .line 85
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    .line 86
    .local v3, "ct":Ljava/lang/String;
    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v5

    .line 88
    .local v5, "ect":Ljava/lang/String;
    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 89
    const/4 v1, 0x1

    .line 97
    .end local v3    # "ct":Ljava/lang/String;
    .end local v5    # "ect":Ljava/lang/String;
    :cond_0
    :goto_0
    const/4 v2, 0x0

    .line 98
    .local v2, "creativeAPIMatched":Z
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getCreativeAPI()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_1

    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getCreativeAPI()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_1

    if-eqz p3, :cond_1

    invoke-virtual {p3}, Ljava/lang/String;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_1

    .line 100
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getCreativeAPI()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    .line 101
    .local v0, "capi":Ljava/lang/String;
    invoke-virtual {p3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    .line 103
    .local v4, "ecapi":Ljava/lang/String;
    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 104
    const/4 v2, 0x1

    .line 111
    .end local v0    # "capi":Ljava/lang/String;
    .end local v4    # "ecapi":Ljava/lang/String;
    :cond_1
    :goto_1
    if-eqz v1, :cond_6

    if-eqz v2, :cond_6

    .line 112
    const/16 v6, 0xa

    invoke-interface {p1, v6}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setPreference(I)V

    .line 121
    :goto_2
    iget-object v6, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->logger:Ltv/freewheel/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "adjustMatchedRendition "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getId()I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", contentType "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", creativeAPI "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getCreativeAPI()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", preference "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getPreference()I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 125
    return-void

    .line 90
    .end local v2    # "creativeAPIMatched":Z
    .restart local v3    # "ct":Ljava/lang/String;
    .restart local v5    # "ect":Ljava/lang/String;
    :cond_2
    const-string v6, "video/mp4"

    invoke-virtual {v3, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    const-string v6, "video/mp4"

    invoke-virtual {v5, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_4

    :cond_3
    const-string v6, "text/js_ref"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    const-string v6, "application/javascript"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 92
    :cond_4
    const/4 v1, 0x1

    .line 93
    invoke-interface {p1, p2}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setContentType(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 105
    .end local v3    # "ct":Ljava/lang/String;
    .end local v5    # "ect":Ljava/lang/String;
    .restart local v0    # "capi":Ljava/lang/String;
    .restart local v2    # "creativeAPIMatched":Z
    .restart local v4    # "ecapi":Ljava/lang/String;
    :cond_5
    const-string v6, "mraid"

    invoke-virtual {v0, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    const-string v6, "mraid"

    invoke-virtual {v4, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 106
    const/4 v2, 0x1

    .line 107
    invoke-interface {p1, p3}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setCreativeAPI(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 113
    .end local v0    # "capi":Ljava/lang/String;
    .end local v4    # "ecapi":Ljava/lang/String;
    :cond_6
    if-eqz v2, :cond_7

    .line 114
    const/4 v6, 0x6

    invoke-interface {p1, v6}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setPreference(I)V

    goto/16 :goto_2

    .line 115
    :cond_7
    if-eqz v1, :cond_8

    .line 116
    const/4 v6, 0x5

    invoke-interface {p1, v6}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setPreference(I)V

    goto/16 :goto_2

    .line 118
    :cond_8
    const/4 v6, 0x0

    invoke-interface {p1, v6}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setPreference(I)V

    goto/16 :goto_2
.end method

.method getClickThroughURL()Ljava/lang/String;
    .locals 5

    .prologue
    .line 142
    const/4 v1, 0x0

    .line 143
    .local v1, "ret":Ljava/lang/String;
    iget-object v3, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->linear:Ltv/freewheel/renderers/vast/model/Linear;

    iget-object v3, v3, Ltv/freewheel/renderers/vast/model/Linear;->videoClicks:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/renderers/vast/model/VideoClick;

    .line 144
    .local v2, "vclick":Ltv/freewheel/renderers/vast/model/VideoClick;
    const-string v3, "ClickThrough"

    iget-object v4, v2, Ltv/freewheel/renderers/vast/model/VideoClick;->type:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 145
    iget-object v1, v2, Ltv/freewheel/renderers/vast/model/VideoClick;->url:Ljava/lang/String;

    .line 149
    .end local v2    # "vclick":Ltv/freewheel/renderers/vast/model/VideoClick;
    :cond_1
    return-object v1
.end method

.method public isValid(Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/ad/interfaces/IConstants;)Z
    .locals 2
    .param p1, "slot"    # Ltv/freewheel/ad/interfaces/ISlot;
    .param p2, "constants"    # Ltv/freewheel/ad/interfaces/IConstants;

    .prologue
    .line 66
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/ISlot;->getType()I

    move-result v0

    invoke-interface {p2}, Ltv/freewheel/ad/interfaces/IConstants;->SLOT_TYPE_TEMPORAL()I

    move-result v1

    if-ne v0, v1, :cond_0

    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v0

    invoke-interface {p2}, Ltv/freewheel/ad/interfaces/IConstants;->TIME_POSITION_CLASS_OVERLAY()I

    move-result v1

    if-eq v0, v1, :cond_0

    .line 68
    invoke-super {p0, p1, p2}, Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;->isValid(Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/ad/interfaces/IConstants;)Z

    move-result v0

    .line 70
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 4
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 37
    invoke-super {p0, p1}, Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;->parse(Lorg/w3c/dom/Element;)V

    .line 38
    const-string v2, "type"

    invoke-interface {p1, v2}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 39
    .local v0, "tp":Ljava/lang/String;
    invoke-static {v0}, Ltv/freewheel/renderers/vast/model/Util;->isNullOrEmptyString(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 40
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->type:Ljava/lang/String;

    .line 41
    invoke-static {p1}, Ltv/freewheel/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 42
    .local v1, "url":Ljava/lang/String;
    invoke-static {v1}, Ltv/freewheel/renderers/vast/model/Util;->isNullOrEmptyString(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    invoke-static {v1}, Landroid/webkit/URLUtil;->isValidUrl(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 43
    invoke-super {p0, v1}, Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;->isSetAssetContentSuccessfully(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 44
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->assetURL:Ljava/lang/String;

    .line 45
    iget-object v2, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->type:Ljava/lang/String;

    const-string v3, "text/html"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 46
    const-string v2, "text/html_doc_ref"

    iput-object v2, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->type:Ljava/lang/String;

    .line 51
    :cond_0
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->assetURL:Ljava/lang/String;

    .line 53
    :cond_1
    iget-object v2, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->type:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    const-string v3, "javascript"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 54
    const-string v2, "text/js_ref"

    iput-object v2, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->type:Ljava/lang/String;

    .line 57
    .end local v1    # "url":Ljava/lang/String;
    :cond_2
    const-string v2, "delivery"

    invoke-interface {p1, v2}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->delivery:Ljava/lang/String;

    .line 58
    const-string v2, "bitrate"

    invoke-interface {p1, v2}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ltv/freewheel/renderers/vast/util/StringUtils;->parseInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->bitrate:Ljava/lang/Integer;

    .line 59
    const-string v2, "scalable"

    invoke-interface {p1, v2}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ltv/freewheel/renderers/vast/util/StringUtils;->parseBoolean(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->scalable:Ljava/lang/Boolean;

    .line 60
    const-string v2, "maintainAspectRatio"

    invoke-interface {p1, v2}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ltv/freewheel/renderers/vast/util/StringUtils;->parseBoolean(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->maintainAspectRatio:Ljava/lang/Boolean;

    .line 61
    iget-object v2, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->linear:Ltv/freewheel/renderers/vast/model/Linear;

    iget-object v2, v2, Ltv/freewheel/renderers/vast/model/Linear;->adParameters:Ljava/lang/String;

    iput-object v2, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->adParameters:Ljava/lang/String;

    .line 62
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 31
    const-string v0, "[MediaFile %s delivery=%s bitrate=%d scalable=%b maintainAspectRatio=%b]"

    const/4 v1, 0x5

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-super {p0}, Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->delivery:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x2

    iget-object v3, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->bitrate:Ljava/lang/Integer;

    aput-object v3, v1, v2

    const/4 v2, 0x3

    iget-object v3, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->scalable:Ljava/lang/Boolean;

    aput-object v3, v1, v2

    const/4 v2, 0x4

    iget-object v3, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->maintainAspectRatio:Ljava/lang/Boolean;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public translateToFWCreativeRendition(Ltv/freewheel/ad/interfaces/ICreativeRendition;Ltv/freewheel/ad/interfaces/IAdInstance;Ltv/freewheel/ad/interfaces/IAdInstance;Ltv/freewheel/ad/interfaces/IConstants;)V
    .locals 4
    .param p1, "cr"    # Ltv/freewheel/ad/interfaces/ICreativeRendition;
    .param p2, "adi"    # Ltv/freewheel/ad/interfaces/IAdInstance;
    .param p3, "hostAdi"    # Ltv/freewheel/ad/interfaces/IAdInstance;
    .param p4, "constants"    # Ltv/freewheel/ad/interfaces/IConstants;

    .prologue
    .line 129
    iget-object v0, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->linear:Ltv/freewheel/renderers/vast/model/Linear;

    iget-object v0, v0, Ltv/freewheel/renderers/vast/model/Linear;->duration:Ljava/lang/Double;

    if-eqz v0, :cond_1

    .line 130
    iget-object v0, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->linear:Ltv/freewheel/renderers/vast/model/Linear;

    iget-object v0, v0, Ltv/freewheel/renderers/vast/model/Linear;->duration:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    invoke-interface {p1, v0, v1}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setDuration(D)V

    .line 137
    :cond_0
    :goto_0
    invoke-super {p0, p1, p2, p3, p4}, Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;->translateToFWCreativeRendition(Ltv/freewheel/ad/interfaces/ICreativeRendition;Ltv/freewheel/ad/interfaces/IAdInstance;Ltv/freewheel/ad/interfaces/IAdInstance;Ltv/freewheel/ad/interfaces/IConstants;)V

    .line 138
    return-void

    .line 132
    :cond_1
    invoke-interface {p3}, Ltv/freewheel/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 133
    iget-object v0, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->linear:Ltv/freewheel/renderers/vast/model/Linear;

    invoke-interface {p3}, Ltv/freewheel/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-result-object v1

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getDuration()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    iput-object v1, v0, Ltv/freewheel/renderers/vast/model/Linear;->duration:Ljava/lang/Double;

    .line 134
    iget-object v0, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->linear:Ltv/freewheel/renderers/vast/model/Linear;

    iget-object v0, v0, Ltv/freewheel/renderers/vast/model/Linear;->duration:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    invoke-interface {p1, v0, v1}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setDuration(D)V

    goto :goto_0
.end method

.method public translateToFWCreativeRenditionAsset(Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;)V
    .locals 4
    .param p1, "asset"    # Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;

    .prologue
    .line 75
    iget-object v0, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->linear:Ltv/freewheel/renderers/vast/model/Linear;

    iget-object v0, v0, Ltv/freewheel/renderers/vast/model/Linear;->duration:Ljava/lang/Double;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->linear:Ltv/freewheel/renderers/vast/model/Linear;

    iget-object v0, v0, Ltv/freewheel/renderers/vast/model/Linear;->duration:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmpl-double v0, v0, v2

    if-lez v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->bitrate:Ljava/lang/Integer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->bitrate:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-lez v0, :cond_0

    .line 76
    iget-object v0, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->linear:Ltv/freewheel/renderers/vast/model/Linear;

    iget-object v0, v0, Ltv/freewheel/renderers/vast/model/Linear;->duration:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    iget-object v2, p0, Ltv/freewheel/renderers/vast/model/MediaFile;->bitrate:Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    int-to-double v2, v2

    mul-double/2addr v0, v2

    const-wide v2, 0x408f400000000000L    # 1000.0

    mul-double/2addr v0, v2

    const-wide/high16 v2, 0x4020000000000000L    # 8.0

    div-double/2addr v0, v2

    double-to-int v0, v0

    invoke-interface {p1, v0}, Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;->setBytes(I)V

    .line 78
    :cond_0
    return-void
.end method
