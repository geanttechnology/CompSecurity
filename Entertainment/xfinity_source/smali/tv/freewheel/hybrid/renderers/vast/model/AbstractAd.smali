.class public abstract Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;
.super Ljava/lang/Object;
.source "AbstractAd.java"

# interfaces
.implements Ltv/freewheel/hybrid/renderers/vast/model/IVastValidation;


# instance fields
.field public creatives:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/renderers/vast/model/Creative;",
            ">;"
        }
    .end annotation
.end field

.field error:Ljava/lang/String;

.field public impressions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/renderers/vast/model/Impression;",
            ">;"
        }
    .end annotation
.end field

.field private logger:Ltv/freewheel/hybrid/utils/Logger;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 22
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->impressions:Ljava/util/ArrayList;

    .line 23
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->creatives:Ljava/util/ArrayList;

    .line 24
    return-void
.end method


# virtual methods
.method public isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z
    .locals 4
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .param p2, "constants"    # Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .prologue
    const/4 v2, 0x0

    .line 53
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->creatives:Ljava/util/ArrayList;

    if-eqz v3, :cond_0

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->creatives:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 60
    :cond_0
    :goto_0
    return v2

    .line 55
    :cond_1
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->creatives:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;

    .line 56
    .local v0, "creative":Ltv/freewheel/hybrid/renderers/vast/model/Creative;
    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 57
    const/4 v2, 0x1

    goto :goto_0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 11
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 27
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 28
    .local v1, "children":Lorg/w3c/dom/NodeList;
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v7

    .line 29
    .local v7, "len":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v7, :cond_3

    .line 30
    invoke-interface {v1, v4}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 31
    .local v0, "child":Lorg/w3c/dom/Node;
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v9

    const/4 v10, 0x1

    if-ne v9, v10, :cond_0

    .line 32
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v8

    .line 33
    .local v8, "name":Ljava/lang/String;
    const-string v9, "Error"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 34
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v9

    iput-object v9, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->error:Ljava/lang/String;

    .line 29
    .end local v0    # "child":Lorg/w3c/dom/Node;
    .end local v8    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 35
    .restart local v0    # "child":Lorg/w3c/dom/Node;
    .restart local v8    # "name":Ljava/lang/String;
    :cond_1
    const-string v9, "Impression"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 36
    new-instance v5, Ltv/freewheel/hybrid/renderers/vast/model/Impression;

    invoke-direct {v5}, Ltv/freewheel/hybrid/renderers/vast/model/Impression;-><init>()V

    .line 37
    .local v5, "impr":Ltv/freewheel/hybrid/renderers/vast/model/Impression;
    check-cast v0, Lorg/w3c/dom/Element;

    .end local v0    # "child":Lorg/w3c/dom/Node;
    invoke-virtual {v5, v0}, Ltv/freewheel/hybrid/renderers/vast/model/Impression;->parse(Lorg/w3c/dom/Element;)V

    .line 38
    iget-object v9, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->impressions:Ljava/util/ArrayList;

    invoke-virtual {v9, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 39
    .end local v5    # "impr":Ltv/freewheel/hybrid/renderers/vast/model/Impression;
    .restart local v0    # "child":Lorg/w3c/dom/Node;
    :cond_2
    const-string v9, "Creatives"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 40
    check-cast v0, Lorg/w3c/dom/Element;

    .end local v0    # "child":Lorg/w3c/dom/Node;
    const-string v9, "Creative"

    invoke-interface {v0, v9}, Lorg/w3c/dom/Element;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v3

    .line 41
    .local v3, "creatives":Lorg/w3c/dom/NodeList;
    const/4 v6, 0x0

    .local v6, "j":I
    :goto_2
    invoke-interface {v3}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v9

    if-ge v6, v9, :cond_0

    .line 42
    new-instance v2, Ltv/freewheel/hybrid/renderers/vast/model/Creative;

    invoke-direct {v2}, Ltv/freewheel/hybrid/renderers/vast/model/Creative;-><init>()V

    .line 43
    .local v2, "creative":Ltv/freewheel/hybrid/renderers/vast/model/Creative;
    invoke-interface {v3, v6}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v9

    check-cast v9, Lorg/w3c/dom/Element;

    invoke-virtual {v2, v9}, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->parse(Lorg/w3c/dom/Element;)V

    .line 44
    iget-object v9, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->creatives:Ljava/util/ArrayList;

    invoke-virtual {v9, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 41
    add-int/lit8 v6, v6, 0x1

    goto :goto_2

    .line 49
    .end local v2    # "creative":Ltv/freewheel/hybrid/renderers/vast/model/Creative;
    .end local v3    # "creatives":Lorg/w3c/dom/NodeList;
    .end local v6    # "j":I
    .end local v8    # "name":Ljava/lang/String;
    :cond_3
    return-void
.end method

.method public searchInCompanionSlot(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;
    .locals 5
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
    .line 75
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 76
    .local v2, "retval":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;>;"
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getType()I

    move-result v3

    invoke-interface {p2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->SLOT_TYPE_TEMPORAL()I

    move-result v4

    if-eq v3, v4, :cond_0

    .line 77
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->creatives:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;

    .line 78
    .local v0, "creative":Ltv/freewheel/hybrid/renderers/vast/model/Creative;
    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->searchInCompanionSlot(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 81
    .end local v0    # "creative":Ltv/freewheel/hybrid/renderers/vast/model/Creative;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v4, "Temporal slot should NOT be companion slot. "

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 82
    :cond_1
    return-object v2
.end method

.method public searchInDrivingSlot(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;
    .locals 5
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
    .line 64
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 65
    .local v2, "retval":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;>;"
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getType()I

    move-result v3

    invoke-interface {p2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->SLOT_TYPE_TEMPORAL()I

    move-result v4

    if-ne v3, v4, :cond_0

    .line 66
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->creatives:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/renderers/vast/model/Creative;

    .line 67
    .local v0, "creative":Ltv/freewheel/hybrid/renderers/vast/model/Creative;
    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->searchInDrivingSlot(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 70
    .end local v0    # "creative":Ltv/freewheel/hybrid/renderers/vast/model/Creative;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v4, "Non-Temporal slot should NOT be driving slot. "

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 71
    :cond_1
    return-object v2
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 87
    const-string v0, "[VastAd\n\t\tError=%s\n\t\tImpressions=%s\n\t\tCreatives=%s\n\t]"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->error:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->impressions:Ljava/util/ArrayList;

    aput-object v3, v1, v2

    const/4 v2, 0x2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->creatives:Ljava/util/ArrayList;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
