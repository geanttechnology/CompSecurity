.class public Ltv/freewheel/ad/Creative;
.super Ltv/freewheel/ad/ParametersHolder;
.source "Creative.java"


# instance fields
.field public baseUnit:Ljava/lang/String;

.field public creativeId:I

.field public creativeRenditions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/CreativeRendition;",
            ">;"
        }
    .end annotation
.end field

.field public duration:D


# direct methods
.method public constructor <init>(Ltv/freewheel/ad/AdContext;)V
    .locals 1
    .param p1, "context"    # Ltv/freewheel/ad/AdContext;

    .prologue
    .line 27
    invoke-direct {p0, p1}, Ltv/freewheel/ad/ParametersHolder;-><init>(Ltv/freewheel/ad/AdContext;)V

    .line 28
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/Creative;->creativeRenditions:Ljava/util/ArrayList;

    .line 29
    return-void
.end method


# virtual methods
.method public cloneForTranslation()Ltv/freewheel/ad/Creative;
    .locals 4

    .prologue
    .line 17
    new-instance v0, Ltv/freewheel/ad/Creative;

    iget-object v1, p0, Ltv/freewheel/ad/Creative;->context:Ltv/freewheel/ad/AdContext;

    invoke-direct {v0, v1}, Ltv/freewheel/ad/Creative;-><init>(Ltv/freewheel/ad/AdContext;)V

    .line 18
    .local v0, "ret":Ltv/freewheel/ad/Creative;
    iget v1, p0, Ltv/freewheel/ad/Creative;->creativeId:I

    iput v1, v0, Ltv/freewheel/ad/Creative;->creativeId:I

    .line 19
    iget-wide v2, p0, Ltv/freewheel/ad/Creative;->duration:D

    iput-wide v2, v0, Ltv/freewheel/ad/Creative;->duration:D

    .line 20
    iget-object v1, p0, Ltv/freewheel/ad/Creative;->baseUnit:Ljava/lang/String;

    iput-object v1, v0, Ltv/freewheel/ad/Creative;->baseUnit:Ljava/lang/String;

    .line 21
    iget-object v1, v0, Ltv/freewheel/ad/Creative;->parameters:Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->clear()V

    .line 22
    iget-object v1, v0, Ltv/freewheel/ad/Creative;->parameters:Ljava/util/HashMap;

    iget-object v2, p0, Ltv/freewheel/ad/Creative;->parameters:Ljava/util/HashMap;

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 23
    return-object v0
.end method

.method public createCreativeRendition()Ltv/freewheel/ad/CreativeRendition;
    .locals 2

    .prologue
    .line 95
    new-instance v0, Ltv/freewheel/ad/CreativeRendition;

    invoke-direct {v0, p0}, Ltv/freewheel/ad/CreativeRendition;-><init>(Ltv/freewheel/ad/Creative;)V

    .line 96
    .local v0, "ret":Ltv/freewheel/ad/CreativeRendition;
    iget-object v1, p0, Ltv/freewheel/ad/Creative;->creativeRenditions:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 97
    return-object v0
.end method

.method public getRendition(II)Ltv/freewheel/ad/CreativeRendition;
    .locals 5
    .param p1, "renditionId"    # I
    .param p2, "replicaId"    # I

    .prologue
    .line 78
    const/4 v2, 0x0

    .line 79
    .local v2, "renditionWithMinReplicaId":Ltv/freewheel/ad/CreativeRendition;
    iget-object v3, p0, Ltv/freewheel/ad/Creative;->creativeRenditions:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 80
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/CreativeRendition;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 81
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/ad/CreativeRendition;

    .line 82
    .local v1, "rendition":Ltv/freewheel/ad/CreativeRendition;
    iget v3, v1, Ltv/freewheel/ad/CreativeRendition;->creativeRenditionId:I

    if-ne v3, p1, :cond_0

    .line 83
    iget v3, v1, Ltv/freewheel/ad/CreativeRendition;->replicaId:I

    if-ne v3, p2, :cond_1

    .line 91
    .end local v1    # "rendition":Ltv/freewheel/ad/CreativeRendition;
    :goto_1
    return-object v1

    .line 86
    .restart local v1    # "rendition":Ltv/freewheel/ad/CreativeRendition;
    :cond_1
    if-eqz v2, :cond_2

    iget v3, v1, Ltv/freewheel/ad/CreativeRendition;->replicaId:I

    iget v4, v2, Ltv/freewheel/ad/CreativeRendition;->replicaId:I

    if-ge v3, v4, :cond_0

    .line 87
    :cond_2
    move-object v2, v1

    goto :goto_0

    .end local v1    # "rendition":Ltv/freewheel/ad/CreativeRendition;
    :cond_3
    move-object v1, v2

    .line 91
    goto :goto_1
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 8
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 52
    const-string v4, "creativeId"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ltv/freewheel/ad/Creative;->tryParseInt(Ljava/lang/String;)I

    move-result v4

    iput v4, p0, Ltv/freewheel/ad/Creative;->creativeId:I

    .line 53
    const-string v4, "duration"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ltv/freewheel/ad/Creative;->tryParseDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, p0, Ltv/freewheel/ad/Creative;->duration:D

    .line 54
    const-string v4, "baseUnit"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/ad/Creative;->baseUnit:Ljava/lang/String;

    .line 56
    iget-object v4, p0, Ltv/freewheel/ad/Creative;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "parse(), creative: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget v6, p0, Ltv/freewheel/ad/Creative;->creativeId:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ", parsed duration: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-wide v6, p0, Ltv/freewheel/ad/Creative;->duration:D

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 59
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 60
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v4

    if-ge v2, v4, :cond_3

    .line 61
    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 62
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_0

    .line 63
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    .line 64
    .local v3, "name":Ljava/lang/String;
    iget-object v4, p0, Ltv/freewheel/ad/Creative;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "parse(), name: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 66
    const-string v4, "creativeRenditions"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 67
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {p0, v1}, Ltv/freewheel/ad/Creative;->parseCreativeRenditions(Lorg/w3c/dom/Element;)V

    .line 60
    .end local v3    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 68
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    .restart local v3    # "name":Ljava/lang/String;
    :cond_1
    const-string v4, "parameters"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 69
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-static {v1}, Ltv/freewheel/ad/Creative;->parseParameters(Lorg/w3c/dom/Element;)Ljava/util/HashMap;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/ad/Creative;->parameters:Ljava/util/HashMap;

    goto :goto_1

    .line 71
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    :cond_2
    iget-object v4, p0, Ltv/freewheel/ad/Creative;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "ignore node: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 75
    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    .end local v3    # "name":Ljava/lang/String;
    :cond_3
    return-void
.end method

.method public parseCreativeRenditions(Lorg/w3c/dom/Element;)V
    .locals 8
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 32
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 33
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v5

    if-ge v3, v5, :cond_2

    .line 34
    invoke-interface {v0, v3}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 35
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 36
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    .line 37
    .local v4, "name":Ljava/lang/String;
    iget-object v5, p0, Ltv/freewheel/ad/Creative;->logger:Ltv/freewheel/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "parse(), name: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 39
    const-string v5, "creativeRendition"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 40
    new-instance v2, Ltv/freewheel/ad/CreativeRendition;

    invoke-direct {v2, p0}, Ltv/freewheel/ad/CreativeRendition;-><init>(Ltv/freewheel/ad/Creative;)V

    .line 41
    .local v2, "creativeRendition":Ltv/freewheel/ad/CreativeRendition;
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {v2, v1}, Ltv/freewheel/ad/CreativeRendition;->parse(Lorg/w3c/dom/Element;)V

    .line 42
    iget-wide v6, p0, Ltv/freewheel/ad/Creative;->duration:D

    invoke-virtual {v2, v6, v7}, Ltv/freewheel/ad/CreativeRendition;->setDuration(D)V

    .line 43
    iget-object v5, p0, Ltv/freewheel/ad/Creative;->creativeRenditions:Ljava/util/ArrayList;

    invoke-virtual {v5, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 33
    .end local v2    # "creativeRendition":Ltv/freewheel/ad/CreativeRendition;
    .end local v4    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 45
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    .restart local v4    # "name":Ljava/lang/String;
    :cond_1
    iget-object v5, p0, Ltv/freewheel/ad/Creative;->logger:Ltv/freewheel/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "ignore node: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 49
    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    .end local v4    # "name":Ljava/lang/String;
    :cond_2
    return-void
.end method
