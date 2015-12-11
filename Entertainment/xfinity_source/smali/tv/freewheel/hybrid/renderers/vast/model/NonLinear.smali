.class public Ltv/freewheel/hybrid/renderers/vast/model/NonLinear;
.super Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;
.source "NonLinear.java"


# instance fields
.field maintainAspectRatio:Ljava/lang/Boolean;

.field minSuggestionDuration:Ljava/lang/String;

.field nonLinearClickThrough:Ljava/lang/String;

.field scalable:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;-><init>()V

    return-void
.end method


# virtual methods
.method getClickThroughURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/NonLinear;->nonLinearClickThrough:Ljava/lang/String;

    return-object v0
.end method

.method public isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z
    .locals 2
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .param p2, "constants"    # Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .prologue
    .line 53
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v0

    invoke-interface {p2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_OVERLAY()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 54
    invoke-super {p0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v0

    .line 56
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 5
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 28
    invoke-super {p0, p1}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->parse(Lorg/w3c/dom/Element;)V

    .line 29
    const-string v3, "scalable"

    invoke-interface {p1, v3}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ltv/freewheel/hybrid/renderers/vast/util/StringUtils;->parseBoolean(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/NonLinear;->scalable:Ljava/lang/Boolean;

    .line 30
    const-string v3, "maintainAspectRatio"

    invoke-interface {p1, v3}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ltv/freewheel/hybrid/renderers/vast/util/StringUtils;->parseBoolean(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/NonLinear;->maintainAspectRatio:Ljava/lang/Boolean;

    .line 31
    const-string v3, "minSuggestionDuration"

    invoke-interface {p1, v3}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/NonLinear;->minSuggestionDuration:Ljava/lang/String;

    .line 32
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v3

    invoke-interface {v3}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    if-ge v1, v3, :cond_1

    .line 33
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v3

    invoke-interface {v3, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 34
    .local v0, "child":Lorg/w3c/dom/Node;
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 35
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v2

    .line 36
    .local v2, "name":Ljava/lang/String;
    const-string v3, "NonLinearClickThrough"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 37
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/NonLinear;->nonLinearClickThrough:Ljava/lang/String;

    .line 32
    .end local v2    # "name":Ljava/lang/String;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 41
    .end local v0    # "child":Lorg/w3c/dom/Node;
    :cond_1
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 22
    const-string v0, "[NonLinear  %s minSuggestionDuration=%s nonLinearClickThrough=%s scalable=%b maintainAspectRatio=%b ]"

    const/4 v1, 0x5

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-super {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/NonLinear;->minSuggestionDuration:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/NonLinear;->nonLinearClickThrough:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x3

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/NonLinear;->scalable:Ljava/lang/Boolean;

    aput-object v3, v1, v2

    const/4 v2, 0x4

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/NonLinear;->maintainAspectRatio:Ljava/lang/Boolean;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public translateToFWCreativeRendition(Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)V
    .locals 2
    .param p1, "cr"    # Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    .param p2, "adi"    # Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .param p3, "hostAdi"    # Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .param p4, "constants"    # Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .prologue
    .line 45
    invoke-interface {p3}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 46
    invoke-interface {p3}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    move-result-object v0

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getDuration()D

    move-result-wide v0

    invoke-interface {p1, v0, v1}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->setDuration(D)V

    .line 48
    :cond_0
    invoke-super {p0, p1, p2, p3, p4}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->translateToFWCreativeRendition(Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)V

    .line 49
    return-void
.end method
