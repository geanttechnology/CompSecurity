.class public Ltv/freewheel/hybrid/renderers/vast/model/InLine;
.super Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;
.source "InLine.java"


# instance fields
.field public adTitle:Ljava/lang/String;

.field public description:Ljava/lang/String;

.field public survey:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;-><init>()V

    .line 15
    return-void
.end method


# virtual methods
.method public parse(Lorg/w3c/dom/Element;)V
    .locals 5
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    const/4 v4, 0x1

    .line 19
    invoke-super {p0, p1}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->parse(Lorg/w3c/dom/Element;)V

    .line 20
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v3

    invoke-interface {v3}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    if-ge v1, v3, :cond_3

    .line 21
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v3

    invoke-interface {v3, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 22
    .local v0, "child":Lorg/w3c/dom/Node;
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v3

    if-ne v3, v4, :cond_1

    .line 23
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v2

    .line 24
    .local v2, "name":Ljava/lang/String;
    const-string v3, "AdTitle"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 25
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/InLine;->adTitle:Ljava/lang/String;

    .line 20
    .end local v2    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 27
    :cond_1
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v3

    if-ne v3, v4, :cond_2

    .line 28
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v2

    .line 29
    .restart local v2    # "name":Ljava/lang/String;
    const-string v3, "Description"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 30
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/InLine;->description:Ljava/lang/String;

    goto :goto_1

    .line 32
    .end local v2    # "name":Ljava/lang/String;
    :cond_2
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v3

    if-ne v3, v4, :cond_0

    .line 33
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v2

    .line 34
    .restart local v2    # "name":Ljava/lang/String;
    const-string v3, "Survey"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 35
    invoke-static {v0}, Ltv/freewheel/hybrid/utils/XMLHandler;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/InLine;->survey:Ljava/lang/String;

    goto :goto_1

    .line 39
    .end local v0    # "child":Lorg/w3c/dom/Node;
    .end local v2    # "name":Ljava/lang/String;
    :cond_3
    return-void
.end method
