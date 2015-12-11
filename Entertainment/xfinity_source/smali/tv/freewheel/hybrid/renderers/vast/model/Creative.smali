.class public Ltv/freewheel/hybrid/renderers/vast/model/Creative;
.super Ljava/lang/Object;
.source "Creative.java"

# interfaces
.implements Ltv/freewheel/hybrid/renderers/vast/model/IVastValidation;


# instance fields
.field adId:Ljava/lang/String;

.field public companionAds:Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;

.field public linear:Ltv/freewheel/hybrid/renderers/vast/model/Linear;

.field public nonLinearAds:Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    return-void
.end method


# virtual methods
.method public getTrackingEvents(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;
    .locals 2
    .param p1, "drivingSlot"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .param p2, "constants"    # Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ltv/freewheel/hybrid/ad/interfaces/ISlot;",
            "Ltv/freewheel/hybrid/ad/interfaces/IConstants;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/renderers/vast/model/Tracking;",
            ">;"
        }
    .end annotation

    .prologue
    .line 75
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->linear:Ltv/freewheel/hybrid/renderers/vast/model/Linear;

    if-eqz v0, :cond_0

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getType()I

    move-result v0

    invoke-interface {p2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->SLOT_TYPE_TEMPORAL()I

    move-result v1

    if-ne v0, v1, :cond_0

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v0

    invoke-interface {p2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_OVERLAY()I

    move-result v1

    if-eq v0, v1, :cond_0

    .line 78
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->linear:Ltv/freewheel/hybrid/renderers/vast/model/Linear;

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/model/Linear;->trackingEvents:Ljava/util/ArrayList;

    .line 82
    :goto_0
    return-object v0

    .line 79
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->nonLinearAds:Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;

    if-eqz v0, :cond_1

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v0

    invoke-interface {p2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_OVERLAY()I

    move-result v1

    if-ne v0, v1, :cond_1

    .line 80
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->nonLinearAds:Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;->trackingEvents:Ljava/util/ArrayList;

    goto :goto_0

    .line 82
    :cond_1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    goto :goto_0
.end method

.method public isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z
    .locals 1
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .param p2, "constants"    # Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .prologue
    .line 53
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->linear:Ltv/freewheel/hybrid/renderers/vast/model/Linear;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->linear:Ltv/freewheel/hybrid/renderers/vast/model/Linear;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/model/Linear;->isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v0

    if-nez v0, :cond_2

    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->nonLinearAds:Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->nonLinearAds:Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;->isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v0

    if-nez v0, :cond_2

    :cond_1
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->companionAds:Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;

    if-eqz v0, :cond_3

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->companionAds:Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;->isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_2
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 7
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 30
    const-string v5, "AdID"

    invoke-interface {p1, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->adId:Ljava/lang/String;

    .line 31
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 32
    .local v1, "children":Lorg/w3c/dom/NodeList;
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    .line 33
    .local v3, "len":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v3, :cond_3

    .line 34
    invoke-interface {v1, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 35
    .local v0, "child":Lorg/w3c/dom/Node;
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 36
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    .line 37
    .local v4, "name":Ljava/lang/String;
    const-string v5, "Linear"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 38
    new-instance v5, Ltv/freewheel/hybrid/renderers/vast/model/Linear;

    invoke-direct {v5}, Ltv/freewheel/hybrid/renderers/vast/model/Linear;-><init>()V

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->linear:Ltv/freewheel/hybrid/renderers/vast/model/Linear;

    .line 39
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->linear:Ltv/freewheel/hybrid/renderers/vast/model/Linear;

    check-cast v0, Lorg/w3c/dom/Element;

    .end local v0    # "child":Lorg/w3c/dom/Node;
    invoke-virtual {v5, v0}, Ltv/freewheel/hybrid/renderers/vast/model/Linear;->parse(Lorg/w3c/dom/Element;)V

    .line 33
    .end local v4    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 40
    .restart local v0    # "child":Lorg/w3c/dom/Node;
    .restart local v4    # "name":Ljava/lang/String;
    :cond_1
    const-string v5, "NonLinearAds"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 41
    new-instance v5, Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;

    invoke-direct {v5}, Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;-><init>()V

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->nonLinearAds:Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;

    .line 42
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->nonLinearAds:Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;

    check-cast v0, Lorg/w3c/dom/Element;

    .end local v0    # "child":Lorg/w3c/dom/Node;
    invoke-virtual {v5, v0}, Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;->parse(Lorg/w3c/dom/Element;)V

    goto :goto_1

    .line 43
    .restart local v0    # "child":Lorg/w3c/dom/Node;
    :cond_2
    const-string v5, "CompanionAds"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 44
    new-instance v5, Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;

    invoke-direct {v5}, Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;-><init>()V

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->companionAds:Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;

    .line 45
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->companionAds:Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;

    check-cast v0, Lorg/w3c/dom/Element;

    .end local v0    # "child":Lorg/w3c/dom/Node;
    invoke-virtual {v5, v0}, Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;->parse(Lorg/w3c/dom/Element;)V

    goto :goto_1

    .line 49
    .end local v4    # "name":Ljava/lang/String;
    :cond_3
    return-void
.end method

.method public searchInCompanionSlot(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;
    .locals 1
    .param p1, "companionSlot"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .param p2, "constants"    # Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ltv/freewheel/hybrid/ad/interfaces/ISlot;",
            "Ltv/freewheel/hybrid/ad/interfaces/IConstants;",
            ")",
            "Ljava/util/ArrayList",
            "<+",
            "Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;",
            ">;"
        }
    .end annotation

    .prologue
    .line 68
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->companionAds:Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->companionAds:Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;->isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 69
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->companionAds:Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;->search(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;

    move-result-object v0

    .line 71
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    goto :goto_0
.end method

.method public searchInDrivingSlot(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;
    .locals 1
    .param p1, "drivingSlot"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .param p2, "constants"    # Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ltv/freewheel/hybrid/ad/interfaces/ISlot;",
            "Ltv/freewheel/hybrid/ad/interfaces/IConstants;",
            ")",
            "Ljava/util/ArrayList",
            "<+",
            "Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;",
            ">;"
        }
    .end annotation

    .prologue
    .line 59
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->linear:Ltv/freewheel/hybrid/renderers/vast/model/Linear;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->linear:Ltv/freewheel/hybrid/renderers/vast/model/Linear;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/model/Linear;->isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 60
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->linear:Ltv/freewheel/hybrid/renderers/vast/model/Linear;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/model/Linear;->search(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;

    move-result-object v0

    .line 64
    :goto_0
    return-object v0

    .line 61
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->nonLinearAds:Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->nonLinearAds:Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;->isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 62
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->nonLinearAds:Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;->search(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;

    move-result-object v0

    goto :goto_0

    .line 64
    :cond_1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 25
    const-string v0, "[Creative\n\t\t\tadId=%s\n\t\t\tLinear=%s\n\t\t\tCompanions=%s\n\t\t\tNonLinearAds=%s\n\t\t]"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->adId:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->linear:Ltv/freewheel/hybrid/renderers/vast/model/Linear;

    aput-object v3, v1, v2

    const/4 v2, 0x2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->companionAds:Ltv/freewheel/hybrid/renderers/vast/model/CompanionAds;

    aput-object v3, v1, v2

    const/4 v2, 0x3

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->nonLinearAds:Ltv/freewheel/hybrid/renderers/vast/model/NonLinearAds;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
