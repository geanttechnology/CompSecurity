.class public Ltv/freewheel/renderers/vast/model/NonLinearAds;
.super Ltv/freewheel/renderers/vast/model/AbstractCreativeRenditionCollection;
.source "NonLinearAds.java"


# instance fields
.field nonLinears:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/renderers/vast/model/NonLinear;",
            ">;"
        }
    .end annotation
.end field

.field trackingEvents:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/renderers/vast/model/Tracking;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Ltv/freewheel/renderers/vast/model/AbstractCreativeRenditionCollection;-><init>()V

    .line 19
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/renderers/vast/model/NonLinearAds;->trackingEvents:Ljava/util/ArrayList;

    .line 20
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/renderers/vast/model/NonLinearAds;->nonLinears:Ljava/util/ArrayList;

    .line 21
    return-void
.end method


# virtual methods
.method public isValid(Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/ad/interfaces/IConstants;)Z
    .locals 1
    .param p1, "slot"    # Ltv/freewheel/ad/interfaces/ISlot;
    .param p2, "constants"    # Ltv/freewheel/ad/interfaces/IConstants;

    .prologue
    .line 46
    iget-object v0, p0, Ltv/freewheel/renderers/vast/model/NonLinearAds;->nonLinears:Ljava/util/ArrayList;

    invoke-virtual {p0, v0, p1, p2}, Ltv/freewheel/renderers/vast/model/NonLinearAds;->validate(Ljava/util/ArrayList;Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/ad/interfaces/IConstants;)Z

    move-result v0

    return v0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 9
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 24
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v7

    invoke-interface {v7}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v7

    if-ge v1, v7, :cond_2

    .line 25
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v7

    invoke-interface {v7, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 26
    .local v0, "child":Lorg/w3c/dom/Node;
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v7

    const/4 v8, 0x1

    if-ne v7, v8, :cond_1

    .line 27
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    .line 28
    .local v3, "name":Ljava/lang/String;
    const-string v7, "TrackingEvents"

    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 29
    check-cast v0, Lorg/w3c/dom/Element;

    .end local v0    # "child":Lorg/w3c/dom/Node;
    const-string v7, "Tracking"

    invoke-interface {v0, v7}, Lorg/w3c/dom/Element;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v6

    .line 30
    .local v6, "trackings":Lorg/w3c/dom/NodeList;
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_1
    invoke-interface {v6}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v7

    if-ge v2, v7, :cond_1

    .line 31
    new-instance v5, Ltv/freewheel/renderers/vast/model/Tracking;

    invoke-direct {v5}, Ltv/freewheel/renderers/vast/model/Tracking;-><init>()V

    .line 32
    .local v5, "tracking":Ltv/freewheel/renderers/vast/model/Tracking;
    invoke-interface {v6, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v7

    check-cast v7, Lorg/w3c/dom/Element;

    invoke-virtual {v5, v7}, Ltv/freewheel/renderers/vast/model/Tracking;->parse(Lorg/w3c/dom/Element;)V

    .line 33
    iget-object v7, p0, Ltv/freewheel/renderers/vast/model/NonLinearAds;->trackingEvents:Ljava/util/ArrayList;

    invoke-virtual {v7, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 30
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 35
    .end local v2    # "j":I
    .end local v5    # "tracking":Ltv/freewheel/renderers/vast/model/Tracking;
    .end local v6    # "trackings":Lorg/w3c/dom/NodeList;
    .restart local v0    # "child":Lorg/w3c/dom/Node;
    :cond_0
    const-string v7, "NonLinear"

    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 36
    new-instance v4, Ltv/freewheel/renderers/vast/model/NonLinear;

    invoke-direct {v4}, Ltv/freewheel/renderers/vast/model/NonLinear;-><init>()V

    .line 37
    .local v4, "nonlinear":Ltv/freewheel/renderers/vast/model/NonLinear;
    check-cast v0, Lorg/w3c/dom/Element;

    .end local v0    # "child":Lorg/w3c/dom/Node;
    invoke-virtual {v4, v0}, Ltv/freewheel/renderers/vast/model/NonLinear;->parse(Lorg/w3c/dom/Element;)V

    .line 38
    iget-object v7, p0, Ltv/freewheel/renderers/vast/model/NonLinearAds;->nonLinears:Ljava/util/ArrayList;

    invoke-virtual {v7, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 24
    .end local v3    # "name":Ljava/lang/String;
    .end local v4    # "nonlinear":Ltv/freewheel/renderers/vast/model/NonLinear;
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 42
    :cond_2
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
    .line 50
    iget-object v0, p0, Ltv/freewheel/renderers/vast/model/NonLinearAds;->nonLinears:Ljava/util/ArrayList;

    invoke-virtual {p0, v0, p1, p2}, Ltv/freewheel/renderers/vast/model/NonLinearAds;->searchAll(Ljava/util/ArrayList;Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/ad/interfaces/IConstants;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method
