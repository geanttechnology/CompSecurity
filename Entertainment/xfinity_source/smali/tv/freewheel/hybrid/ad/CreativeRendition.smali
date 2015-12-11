.class public Ltv/freewheel/hybrid/ad/CreativeRendition;
.super Ltv/freewheel/hybrid/ad/ParametersHolder;
.source "CreativeRendition.java"

# interfaces
.implements Ljava/lang/Comparable;
.implements Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ltv/freewheel/hybrid/ad/ParametersHolder;",
        "Ljava/lang/Comparable",
        "<",
        "Ltv/freewheel/hybrid/ad/CreativeRendition;",
        ">;",
        "Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;"
    }
.end annotation


# instance fields
.field private baseUnit:Ljava/lang/String;

.field private contentType:Ljava/lang/String;

.field private creativeAPI:Ljava/lang/String;

.field public creativeRenditionId:I

.field private duration:D

.field private height:I

.field private otherCreativeRenditionAssets:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;",
            ">;"
        }
    .end annotation
.end field

.field private preference:I

.field private primaryCreativeRenditionAsset:Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;

.field public replicaId:I

.field private width:I

.field private wrapperType:Ljava/lang/String;

.field private wrapperUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/ad/Creative;)V
    .locals 1
    .param p1, "creative"    # Ltv/freewheel/hybrid/ad/Creative;

    .prologue
    .line 31
    invoke-virtual {p1}, Ltv/freewheel/hybrid/ad/Creative;->getAdContext()Ltv/freewheel/hybrid/ad/AdContext;

    move-result-object v0

    invoke-direct {p0, v0}, Ltv/freewheel/hybrid/ad/ParametersHolder;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 32
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/Creative;->baseUnit:Ljava/lang/String;

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->baseUnit:Ljava/lang/String;

    .line 33
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->otherCreativeRenditionAssets:Ljava/util/ArrayList;

    .line 34
    const-string v0, "None"

    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/ad/CreativeRendition;->setCreativeAPI(Ljava/lang/String;)V

    .line 35
    return-void
.end method


# virtual methods
.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 13
    check-cast p1, Ltv/freewheel/hybrid/ad/CreativeRendition;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Ltv/freewheel/hybrid/ad/CreativeRendition;->compareTo(Ltv/freewheel/hybrid/ad/CreativeRendition;)I

    move-result v0

    return v0
.end method

.method public compareTo(Ltv/freewheel/hybrid/ad/CreativeRendition;)I
    .locals 2
    .param p1, "another"    # Ltv/freewheel/hybrid/ad/CreativeRendition;

    .prologue
    .line 228
    iget v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->preference:I

    iget v1, p1, Ltv/freewheel/hybrid/ad/CreativeRendition;->preference:I

    if-le v0, v1, :cond_0

    .line 229
    const/4 v0, -0x1

    .line 233
    :goto_0
    return v0

    .line 230
    :cond_0
    iget v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->preference:I

    iget v1, p1, Ltv/freewheel/hybrid/ad/CreativeRendition;->preference:I

    if-ge v0, v1, :cond_1

    .line 231
    const/4 v0, 0x1

    goto :goto_0

    .line 233
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public createCreativeRenditionAssetForTranslation(Ljava/lang/String;Z)Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "isPrimary"    # Z

    .prologue
    .line 129
    new-instance v0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-direct {v0, v1}, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 130
    .local v0, "asset":Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;
    iput-object p1, v0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->name:Ljava/lang/String;

    .line 131
    if-eqz p2, :cond_0

    .line 132
    iput-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->primaryCreativeRenditionAsset:Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;

    .line 137
    :goto_0
    return-object v0

    .line 135
    :cond_0
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->otherCreativeRenditionAssets:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public getBaseUnit()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->baseUnit:Ljava/lang/String;

    return-object v0
.end method

.method public getContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->contentType:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->contentType:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 142
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->contentType:Ljava/lang/String;

    .line 146
    :goto_0
    return-object v0

    .line 143
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->primaryCreativeRenditionAsset:Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;

    if-eqz v0, :cond_1

    .line 144
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->primaryCreativeRenditionAsset:Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;

    iget-object v0, v0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->contentType:Ljava/lang/String;

    goto :goto_0

    .line 146
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCreativeAPI()Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->creativeAPI:Ljava/lang/String;

    return-object v0
.end method

.method public getDuration()D
    .locals 2

    .prologue
    .line 163
    iget-wide v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->duration:D

    return-wide v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 167
    iget v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->height:I

    return v0
.end method

.method public getPrimaryCreativRenditionAsset()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->primaryCreativeRenditionAsset:Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;

    return-object v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 184
    iget v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->width:I

    return v0
.end method

.method public getWrapperType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->wrapperType:Ljava/lang/String;

    return-object v0
.end method

.method public getWrapperURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 224
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->wrapperUrl:Ljava/lang/String;

    return-object v0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 7
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    const/4 v6, 0x0

    .line 39
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 41
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const-string v4, "creativeRenditionId"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Ltv/freewheel/hybrid/ad/CreativeRendition;->tryParseInt(Ljava/lang/String;I)I

    move-result v4

    iput v4, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->creativeRenditionId:I

    .line 44
    const-string v4, "adReplicaId"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const/4 v5, -0x1

    invoke-static {v4, v5}, Ltv/freewheel/hybrid/ad/CreativeRendition;->tryParseInt(Ljava/lang/String;I)I

    move-result v4

    iput v4, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->replicaId:I

    .line 47
    const-string v4, "contentType"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Ltv/freewheel/hybrid/ad/CreativeRendition;->setContentType(Ljava/lang/String;)V

    .line 50
    const-string v4, "wrapperType"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Ltv/freewheel/hybrid/ad/CreativeRendition;->setWrapperType(Ljava/lang/String;)V

    .line 53
    const-string v4, "wrapperUrl"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Ltv/freewheel/hybrid/ad/CreativeRendition;->setWrapperURL(Ljava/lang/String;)V

    .line 56
    const-string v4, "preference"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Ltv/freewheel/hybrid/ad/CreativeRendition;->tryParseInt(Ljava/lang/String;I)I

    move-result v4

    invoke-virtual {p0, v4}, Ltv/freewheel/hybrid/ad/CreativeRendition;->setPreference(I)V

    .line 59
    const-string v4, "height"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Ltv/freewheel/hybrid/ad/CreativeRendition;->tryParseInt(Ljava/lang/String;I)I

    move-result v4

    invoke-virtual {p0, v4}, Ltv/freewheel/hybrid/ad/CreativeRendition;->setHeight(I)V

    .line 62
    const-string v4, "width"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Ltv/freewheel/hybrid/ad/CreativeRendition;->tryParseInt(Ljava/lang/String;I)I

    move-result v4

    invoke-virtual {p0, v4}, Ltv/freewheel/hybrid/ad/CreativeRendition;->setWidth(I)V

    .line 65
    const-string v4, "creativeApi"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Ltv/freewheel/hybrid/ad/CreativeRendition;->setCreativeAPI(Ljava/lang/String;)V

    .line 68
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v4

    if-ge v2, v4, :cond_4

    .line 69
    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 70
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_0

    .line 71
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    .line 72
    .local v3, "name":Ljava/lang/String;
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "parse(), name: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 74
    const-string v4, "parameters"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 75
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-static {v1}, Ltv/freewheel/hybrid/ad/CreativeRendition;->parseParameters(Lorg/w3c/dom/Element;)Ljava/util/HashMap;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->parameters:Ljava/util/HashMap;

    .line 68
    .end local v3    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 76
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    .restart local v3    # "name":Ljava/lang/String;
    :cond_1
    const-string v4, "asset"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 77
    new-instance v4, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;

    iget-object v5, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-direct {v4, v5}, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    iput-object v4, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->primaryCreativeRenditionAsset:Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;

    .line 78
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->primaryCreativeRenditionAsset:Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;

    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {v4, v1}, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->parse(Lorg/w3c/dom/Element;)V

    goto :goto_1

    .line 79
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    :cond_2
    const-string v4, "otherAssets"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 80
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {p0, v1}, Ltv/freewheel/hybrid/ad/CreativeRendition;->parseOtherAssets(Lorg/w3c/dom/Element;)V

    goto :goto_1

    .line 82
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    :cond_3
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "ignore node: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 86
    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    .end local v3    # "name":Ljava/lang/String;
    :cond_4
    return-void
.end method

.method protected parseOtherAssets(Lorg/w3c/dom/Element;)V
    .locals 8
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 89
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 91
    .local v1, "childList":Lorg/w3c/dom/NodeList;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v5

    if-ge v3, v5, :cond_2

    .line 92
    invoke-interface {v1, v3}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 93
    .local v2, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 94
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    .line 95
    .local v4, "name":Ljava/lang/String;
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "parseOtherAssets(), name: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 97
    const-string v5, "asset"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 98
    new-instance v0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;

    iget-object v5, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-direct {v0, v5}, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 99
    .local v0, "asset":Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {v0, v2}, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->parse(Lorg/w3c/dom/Element;)V

    .line 100
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->otherCreativeRenditionAssets:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 91
    .end local v0    # "asset":Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;
    .end local v4    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 102
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    .restart local v4    # "name":Ljava/lang/String;
    :cond_1
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "ignore node: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 106
    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    .end local v4    # "name":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method public setContentType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 188
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->contentType:Ljava/lang/String;

    .line 189
    return-void
.end method

.method public setCreativeAPI(Ljava/lang/String;)V
    .locals 0
    .param p1, "creativeAPIStr"    # Ljava/lang/String;

    .prologue
    .line 192
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->creativeAPI:Ljava/lang/String;

    .line 193
    return-void
.end method

.method public setDuration(D)V
    .locals 1
    .param p1, "value"    # D

    .prologue
    .line 196
    iput-wide p1, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->duration:D

    .line 197
    return-void
.end method

.method public setHeight(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 200
    iput p1, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->height:I

    .line 201
    return-void
.end method

.method public setParameter(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 117
    if-nez p1, :cond_0

    .line 126
    :goto_0
    return-void

    .line 121
    :cond_0
    if-eqz p2, :cond_1

    .line 122
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->parameters:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 124
    :cond_1
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->parameters:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public setPreference(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 204
    iput p1, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->preference:I

    .line 205
    return-void
.end method

.method public setWidth(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 208
    iput p1, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->width:I

    .line 209
    return-void
.end method

.method public setWrapperType(Ljava/lang/String;)V
    .locals 0
    .param p1, "wrapperType"    # Ljava/lang/String;

    .prologue
    .line 212
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->wrapperType:Ljava/lang/String;

    .line 213
    return-void
.end method

.method public setWrapperURL(Ljava/lang/String;)V
    .locals 0
    .param p1, "wrapperUrl"    # Ljava/lang/String;

    .prologue
    .line 220
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->wrapperUrl:Ljava/lang/String;

    .line 221
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 242
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Ltv/freewheel/hybrid/ad/CreativeRendition;->creativeRenditionId:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
