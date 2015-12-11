.class public Ltv/freewheel/hybrid/renderers/vast/model/Companion;
.super Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;
.source "Companion.java"


# instance fields
.field altText:Ljava/lang/String;

.field companionClickThrough:Ljava/lang/String;

.field trackingEvents:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/renderers/vast/model/Tracking;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 22
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;-><init>()V

    .line 23
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->trackingEvents:Ljava/util/ArrayList;

    .line 24
    return-void
.end method


# virtual methods
.method getAltText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->altText:Ljava/lang/String;

    return-object v0
.end method

.method getClickThroughURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->companionClickThrough:Ljava/lang/String;

    return-object v0
.end method

.method public getTrackingEvents()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/renderers/vast/model/Tracking;",
            ">;"
        }
    .end annotation

    .prologue
    .line 67
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->trackingEvents:Ljava/util/ArrayList;

    return-object v0
.end method

.method public isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z
    .locals 1
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .param p2, "constants"    # Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .prologue
    .line 56
    invoke-super {p0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v0

    return v0
.end method

.method public isValidCompanion(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z
    .locals 3
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .param p2, "constants"    # Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .prologue
    const/4 v0, 0x0

    .line 60
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getType()I

    move-result v1

    invoke-interface {p2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->SLOT_TYPE_TEMPORAL()I

    move-result v2

    if-eq v1, v2, :cond_0

    .line 61
    invoke-super {p0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->width:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getWidth()I

    move-result v2

    if-gt v1, v2, :cond_0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->height:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getHeight()I

    move-result v2

    if-gt v1, v2, :cond_0

    const/4 v0, 0x1

    .line 63
    :cond_0
    return v0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 8
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 33
    invoke-super {p0, p1}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->parse(Lorg/w3c/dom/Element;)V

    .line 34
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v6

    invoke-interface {v6}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v6

    if-ge v1, v6, :cond_3

    .line 35
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v6

    invoke-interface {v6, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 36
    .local v0, "child":Lorg/w3c/dom/Node;
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v6

    const/4 v7, 0x1

    if-ne v6, v7, :cond_0

    .line 37
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    .line 38
    .local v3, "name":Ljava/lang/String;
    const-string v6, "CompanionClickThrough"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 39
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->companionClickThrough:Ljava/lang/String;

    .line 34
    .end local v0    # "child":Lorg/w3c/dom/Node;
    .end local v3    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 40
    .restart local v0    # "child":Lorg/w3c/dom/Node;
    .restart local v3    # "name":Ljava/lang/String;
    :cond_1
    const-string v6, "TrackingEvents"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 41
    check-cast v0, Lorg/w3c/dom/Element;

    .end local v0    # "child":Lorg/w3c/dom/Node;
    const-string v6, "Tracking"

    invoke-interface {v0, v6}, Lorg/w3c/dom/Element;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v5

    .line 42
    .local v5, "trackings":Lorg/w3c/dom/NodeList;
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_2
    invoke-interface {v5}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v6

    if-ge v2, v6, :cond_0

    .line 43
    new-instance v4, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;

    invoke-direct {v4}, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;-><init>()V

    .line 44
    .local v4, "tracking":Ltv/freewheel/hybrid/renderers/vast/model/Tracking;
    invoke-interface {v5, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v6

    check-cast v6, Lorg/w3c/dom/Element;

    invoke-virtual {v4, v6}, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->parse(Lorg/w3c/dom/Element;)V

    .line 45
    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->trackingEvents:Ljava/util/ArrayList;

    invoke-virtual {v6, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 42
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 47
    .end local v2    # "j":I
    .end local v4    # "tracking":Ltv/freewheel/hybrid/renderers/vast/model/Tracking;
    .end local v5    # "trackings":Lorg/w3c/dom/NodeList;
    .restart local v0    # "child":Lorg/w3c/dom/Node;
    :cond_2
    const-string v6, "AltText"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 48
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->altText:Ljava/lang/String;

    goto :goto_1

    .line 52
    .end local v0    # "child":Lorg/w3c/dom/Node;
    .end local v3    # "name":Ljava/lang/String;
    :cond_3
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 27
    const-string v0, "[Companion  %s companionClickThrough=%s trackingEvents=%s altText=%s  ]"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-super {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->companionClickThrough:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->trackingEvents:Ljava/util/ArrayList;

    aput-object v3, v1, v2

    const/4 v2, 0x3

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->altText:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic translateToFWCreativeRendition(Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)V
    .locals 0
    .param p1, "x0"    # Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    .param p2, "x1"    # Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .param p3, "x2"    # Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .param p4, "x3"    # Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .prologue
    .line 12
    invoke-super {p0, p1, p2, p3, p4}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->translateToFWCreativeRendition(Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)V

    return-void
.end method
