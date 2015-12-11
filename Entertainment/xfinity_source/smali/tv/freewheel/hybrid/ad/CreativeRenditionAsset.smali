.class public Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;
.super Ltv/freewheel/hybrid/ad/AdContextScoped;
.source "CreativeRenditionAsset.java"

# interfaces
.implements Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;


# instance fields
.field public bytes:I

.field public content:Ljava/lang/String;

.field public contentType:Ljava/lang/String;

.field public creativeRenditionAssetId:I

.field public id:Ljava/lang/String;

.field public mimeType:Ljava/lang/String;

.field public name:Ljava/lang/String;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/ad/AdContext;)V
    .locals 0
    .param p1, "context"    # Ltv/freewheel/hybrid/ad/AdContext;

    .prologue
    .line 20
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/AdContextScoped;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 21
    return-void
.end method


# virtual methods
.method public getBytes()I
    .locals 1

    .prologue
    .line 58
    iget v0, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->bytes:I

    return v0
.end method

.method public getContent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->content:Ljava/lang/String;

    return-object v0
.end method

.method public getContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->contentType:Ljava/lang/String;

    return-object v0
.end method

.method public getMimeType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->mimeType:Ljava/lang/String;

    return-object v0
.end method

.method public getURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->url:Ljava/lang/String;

    return-object v0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 8
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    const/4 v7, 0x0

    .line 24
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 25
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const-string v4, "id"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v7}, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->tryParseInt(Ljava/lang/String;I)I

    move-result v4

    iput v4, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->creativeRenditionAssetId:I

    .line 27
    const-string v4, "contentType"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->setContentType(Ljava/lang/String;)V

    .line 28
    const-string v4, "mimeType"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->setMimeType(Ljava/lang/String;)V

    .line 29
    const-string v4, "name"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->name:Ljava/lang/String;

    .line 30
    const-string v4, "url"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->setURL(Ljava/lang/String;)V

    .line 31
    const-string v4, "id"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->id:Ljava/lang/String;

    .line 33
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->url:Ljava/lang/String;

    if-eqz v4, :cond_0

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->url:Ljava/lang/String;

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 34
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->url:Ljava/lang/String;

    const-string v5, " "

    const-string v6, "%20"

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    .line 37
    :cond_0
    const-string v4, "bytes"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->hasAttribute(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 38
    const-string v4, "bytes"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v7}, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->tryParseInt(Ljava/lang/String;I)I

    move-result v4

    invoke-virtual {p0, v4}, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->setBytes(I)V

    .line 42
    :cond_1
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v4

    if-ge v2, v4, :cond_4

    .line 43
    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 44
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_2

    .line 45
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    .line 46
    .local v3, "name":Ljava/lang/String;
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    .line 48
    const-string v4, "content"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 49
    invoke-static {v1}, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->content:Ljava/lang/String;

    .line 42
    .end local v3    # "name":Ljava/lang/String;
    :cond_2
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 51
    .restart local v3    # "name":Ljava/lang/String;
    :cond_3
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    .line 55
    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    .end local v3    # "name":Ljava/lang/String;
    :cond_4
    return-void
.end method

.method public setBytes(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 78
    iput p1, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->bytes:I

    .line 79
    return-void
.end method

.method public setContent(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 82
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->content:Ljava/lang/String;

    .line 83
    return-void
.end method

.method public setContentType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 86
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->contentType:Ljava/lang/String;

    .line 87
    return-void
.end method

.method public setMimeType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 90
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->mimeType:Ljava/lang/String;

    .line 91
    return-void
.end method

.method public setURL(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 94
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/CreativeRenditionAsset;->url:Ljava/lang/String;

    .line 95
    return-void
.end method
