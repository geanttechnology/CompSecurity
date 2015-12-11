.class abstract Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;
.super Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;
.source "AbstractNonMediaFile.java"


# instance fields
.field expandedHeight:Ljava/lang/Integer;

.field expandedWidth:Ljava/lang/Integer;

.field htmlResource:Ljava/lang/String;

.field iframeResource:Ljava/lang/String;

.field staticResource:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;-><init>()V

    return-void
.end method

.method private getResource()Ljava/lang/String;
    .locals 2

    .prologue
    .line 25
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->staticResource:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 26
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "staticResource=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->staticResource:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 32
    :goto_0
    return-object v0

    .line 27
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->iframeResource:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 28
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "iframeResource=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->iframeResource:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 29
    :cond_1
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->htmlResource:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 30
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "htmlResource=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->htmlResource:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 32
    :cond_2
    const-string v0, "no resource"

    goto :goto_0
.end method


# virtual methods
.method public parse(Lorg/w3c/dom/Element;)V
    .locals 8
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 42
    invoke-super {p0, p1}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->parse(Lorg/w3c/dom/Element;)V

    .line 43
    const-string v5, "expandedWidth"

    invoke-interface {p1, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ltv/freewheel/hybrid/renderers/vast/util/StringUtils;->parseInt(Ljava/lang/String;)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->expandedWidth:Ljava/lang/Integer;

    .line 44
    const-string v5, "expandedHeight"

    invoke-interface {p1, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ltv/freewheel/hybrid/renderers/vast/util/StringUtils;->parseInt(Ljava/lang/String;)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->expandedHeight:Ljava/lang/Integer;

    .line 45
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 46
    .local v1, "childList":Lorg/w3c/dom/NodeList;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v5

    if-ge v3, v5, :cond_5

    .line 47
    invoke-interface {v1, v3}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 48
    .local v0, "child":Lorg/w3c/dom/Node;
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 49
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    .line 50
    .local v4, "name":Ljava/lang/String;
    const-string v5, "AdParameters"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 51
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->adParameters:Ljava/lang/String;

    .line 46
    .end local v0    # "child":Lorg/w3c/dom/Node;
    .end local v4    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 52
    .restart local v0    # "child":Lorg/w3c/dom/Node;
    .restart local v4    # "name":Ljava/lang/String;
    :cond_1
    const-string v5, "StaticResource"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 53
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->staticResource:Ljava/lang/String;

    .line 54
    check-cast v0, Lorg/w3c/dom/Element;

    .end local v0    # "child":Lorg/w3c/dom/Node;
    const-string v5, "creativeType"

    invoke-interface {v0, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 55
    .local v2, "creativeType":Ljava/lang/String;
    invoke-static {v2}, Ltv/freewheel/hybrid/renderers/vast/model/Util;->isNullOrEmptyString(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 56
    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->type:Ljava/lang/String;

    .line 57
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->staticResource:Ljava/lang/String;

    invoke-static {v5}, Ltv/freewheel/hybrid/renderers/vast/model/Util;->isNullOrEmptyString(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->staticResource:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/webkit/URLUtil;->isValidUrl(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 58
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->staticResource:Ljava/lang/String;

    invoke-super {p0, v5}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->isSetAssetContentSuccessfully(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 59
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->staticResource:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->assetURL:Ljava/lang/String;

    .line 60
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->type:Ljava/lang/String;

    const-string v6, "text/html"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 61
    const-string v5, "text/html_doc_ref"

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->type:Ljava/lang/String;

    goto :goto_1

    .line 65
    .end local v2    # "creativeType":Ljava/lang/String;
    .restart local v0    # "child":Lorg/w3c/dom/Node;
    :cond_2
    const-string v5, "IFrameResource"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 66
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->iframeResource:Ljava/lang/String;

    .line 67
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->iframeResource:Ljava/lang/String;

    invoke-static {v5}, Ltv/freewheel/hybrid/renderers/vast/model/Util;->isNullOrEmptyString(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->iframeResource:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/webkit/URLUtil;->isValidUrl(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 68
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "selected IFrameResource :"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->iframeResource:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 69
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->iframeResource:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->assetURL:Ljava/lang/String;

    .line 70
    const-string v5, "text/html_doc_ref"

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->type:Ljava/lang/String;

    goto/16 :goto_1

    .line 72
    :cond_3
    const-string v5, "HTMLResource"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 73
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->htmlResource:Ljava/lang/String;

    .line 74
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->htmlResource:Ljava/lang/String;

    invoke-static {v5}, Ltv/freewheel/hybrid/renderers/vast/model/Util;->isNullOrEmptyString(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_4

    .line 75
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "selected HTMLResource :"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->htmlResource:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 76
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->htmlResource:Ljava/lang/String;

    invoke-static {v5}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->text_html_TO_text_html_doc_lit_mobile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->assetContent:Ljava/lang/String;

    .line 78
    :cond_4
    const-string v5, "text/html_doc_lit_mobile"

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->type:Ljava/lang/String;

    goto/16 :goto_1

    .line 82
    .end local v0    # "child":Lorg/w3c/dom/Node;
    .end local v4    # "name":Ljava/lang/String;
    :cond_5
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 36
    const-string v0, "[%s resource=%s adParameters=\'%s\' expandedWidth=%d expandedHeight=%d]"

    const/4 v1, 0x5

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-super {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->getResource()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->adParameters:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x3

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->expandedWidth:Ljava/lang/Integer;

    aput-object v3, v1, v2

    const/4 v2, 0x4

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->expandedHeight:Ljava/lang/Integer;

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
    .line 86
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractNonMediaFile;->getClickThroughURL()Ljava/lang/String;

    move-result-object v0

    .line 87
    .local v0, "url":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 88
    invoke-interface {p4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_CLICK()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p2, v0, v1}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->setClickThroughURL(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    :cond_0
    invoke-super {p0, p1, p2, p3, p4}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->translateToFWCreativeRendition(Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)V

    .line 91
    return-void
.end method
