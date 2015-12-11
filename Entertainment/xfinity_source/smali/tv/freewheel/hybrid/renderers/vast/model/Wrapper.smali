.class public Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;
.super Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;
.source "Wrapper.java"


# instance fields
.field public vastAdTagUri:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;-><init>()V

    .line 17
    return-void
.end method


# virtual methods
.method public isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z
    .locals 1
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .param p2, "constants"    # Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .prologue
    .line 37
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;->vastAdTagUri:Ljava/lang/String;

    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/vast/model/Util;->isNullOrEmptyString(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;->vastAdTagUri:Ljava/lang/String;

    invoke-static {v0}, Landroid/webkit/URLUtil;->isValidUrl(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 7
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 21
    invoke-super {p0, p1}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->parse(Lorg/w3c/dom/Element;)V

    .line 22
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 23
    .local v1, "children":Lorg/w3c/dom/NodeList;
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    .line 24
    .local v3, "len":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v3, :cond_1

    .line 25
    invoke-interface {v1, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 26
    .local v0, "child":Lorg/w3c/dom/Node;
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 27
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    .line 28
    .local v4, "name":Ljava/lang/String;
    const-string v5, "VASTAdTagURI"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 29
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;->vastAdTagUri:Ljava/lang/String;

    .line 24
    .end local v4    # "name":Ljava/lang/String;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 33
    .end local v0    # "child":Lorg/w3c/dom/Node;
    :cond_1
    return-void
.end method
