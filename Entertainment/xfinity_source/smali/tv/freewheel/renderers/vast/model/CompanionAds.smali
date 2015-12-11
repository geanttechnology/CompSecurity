.class Ltv/freewheel/renderers/vast/model/CompanionAds;
.super Ltv/freewheel/renderers/vast/model/AbstractCreativeRenditionCollection;
.source "CompanionAds.java"


# instance fields
.field companions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/renderers/vast/model/Companion;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Ltv/freewheel/renderers/vast/model/AbstractCreativeRenditionCollection;-><init>()V

    .line 16
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/renderers/vast/model/CompanionAds;->companions:Ljava/util/ArrayList;

    .line 17
    return-void
.end method


# virtual methods
.method public isValid(Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/ad/interfaces/IConstants;)Z
    .locals 1
    .param p1, "slot"    # Ltv/freewheel/ad/interfaces/ISlot;
    .param p2, "constants"    # Ltv/freewheel/ad/interfaces/IConstants;

    .prologue
    .line 36
    iget-object v0, p0, Ltv/freewheel/renderers/vast/model/CompanionAds;->companions:Ljava/util/ArrayList;

    invoke-virtual {p0, v0, p1, p2}, Ltv/freewheel/renderers/vast/model/CompanionAds;->validate(Ljava/util/ArrayList;Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/ad/interfaces/IConstants;)Z

    move-result v0

    return v0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 7
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 20
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 21
    .local v1, "childList":Lorg/w3c/dom/NodeList;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v5

    if-ge v3, v5, :cond_1

    .line 22
    invoke-interface {v1, v3}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 23
    .local v0, "child":Lorg/w3c/dom/Node;
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 24
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    .line 25
    .local v4, "name":Ljava/lang/String;
    const-string v5, "Companion"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 26
    new-instance v2, Ltv/freewheel/renderers/vast/model/Companion;

    invoke-direct {v2}, Ltv/freewheel/renderers/vast/model/Companion;-><init>()V

    .line 27
    .local v2, "companion":Ltv/freewheel/renderers/vast/model/Companion;
    check-cast v0, Lorg/w3c/dom/Element;

    .end local v0    # "child":Lorg/w3c/dom/Node;
    invoke-virtual {v2, v0}, Ltv/freewheel/renderers/vast/model/Companion;->parse(Lorg/w3c/dom/Element;)V

    .line 28
    iget-object v5, p0, Ltv/freewheel/renderers/vast/model/CompanionAds;->companions:Ljava/util/ArrayList;

    invoke-virtual {v5, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 21
    .end local v2    # "companion":Ltv/freewheel/renderers/vast/model/Companion;
    .end local v4    # "name":Ljava/lang/String;
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 32
    :cond_1
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
    .line 40
    iget-object v0, p0, Ltv/freewheel/renderers/vast/model/CompanionAds;->companions:Ljava/util/ArrayList;

    invoke-virtual {p0, v0, p1, p2}, Ltv/freewheel/renderers/vast/model/CompanionAds;->searchAll(Ljava/util/ArrayList;Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/ad/interfaces/IConstants;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method
