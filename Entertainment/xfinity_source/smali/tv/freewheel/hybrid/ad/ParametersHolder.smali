.class public Ltv/freewheel/hybrid/ad/ParametersHolder;
.super Ltv/freewheel/hybrid/ad/AdContextScoped;
.source "ParametersHolder.java"


# instance fields
.field public parameters:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/ad/AdContext;)V
    .locals 1
    .param p1, "context"    # Ltv/freewheel/hybrid/ad/AdContext;

    .prologue
    .line 15
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/AdContextScoped;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 16
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/ParametersHolder;->parameters:Ljava/util/HashMap;

    .line 17
    return-void
.end method

.method public static parseParameters(Lorg/w3c/dom/Element;)Ljava/util/HashMap;
    .locals 11
    .param p0, "node"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/w3c/dom/Element;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 28
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 29
    .local v6, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-interface {p0}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 31
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v8

    if-ge v2, v8, :cond_2

    .line 32
    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 33
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v8

    const/4 v9, 0x1

    if-ne v8, v9, :cond_1

    .line 34
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    .line 37
    .local v4, "name":Ljava/lang/String;
    const-string v8, "parameter"

    invoke-virtual {v4, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    move-object v5, v1

    .line 38
    check-cast v5, Lorg/w3c/dom/Element;

    .line 39
    .local v5, "paramNode":Lorg/w3c/dom/Element;
    const-string v8, "name"

    invoke-interface {v5, v8}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 41
    .local v3, "key":Ljava/lang/String;
    invoke-static {v5}, Ltv/freewheel/hybrid/ad/ParametersHolder;->getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v7

    .line 42
    .local v7, "value":Ljava/lang/String;
    if-nez v7, :cond_0

    .line 43
    const-string v7, ""

    .line 45
    :cond_0
    if-eqz v3, :cond_1

    .line 46
    invoke-virtual {v6, v3, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    const-string v8, "ParametersHolder"

    invoke-static {v8}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/String;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v8

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "profile parameter name:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " value:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 31
    .end local v3    # "key":Ljava/lang/String;
    .end local v4    # "name":Ljava/lang/String;
    .end local v5    # "paramNode":Lorg/w3c/dom/Element;
    .end local v7    # "value":Ljava/lang/String;
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 54
    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    :cond_2
    return-object v6
.end method


# virtual methods
.method protected parseRendererParameters(Lorg/w3c/dom/Element;)V
    .locals 10
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 67
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 69
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v7

    if-ge v2, v7, :cond_3

    .line 70
    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 71
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v7

    const/4 v8, 0x1

    if-ne v7, v8, :cond_1

    .line 72
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    .line 73
    .local v4, "name":Ljava/lang/String;
    iget-object v7, p0, Ltv/freewheel/hybrid/ad/ParametersHolder;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "parse(), name: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 75
    const-string v7, "parameter"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    move-object v5, v1

    .line 76
    check-cast v5, Lorg/w3c/dom/Element;

    .line 77
    .local v5, "paramNode":Lorg/w3c/dom/Element;
    const-string v7, "name"

    invoke-interface {v5, v7}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 79
    .local v3, "key":Ljava/lang/String;
    const-string v7, "value"

    invoke-interface {v5, v7}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 81
    .local v6, "value":Ljava/lang/String;
    if-nez v6, :cond_0

    .line 82
    const-string v6, ""

    .line 84
    :cond_0
    if-eqz v3, :cond_1

    .line 85
    iget-object v7, p0, Ltv/freewheel/hybrid/ad/ParametersHolder;->parameters:Ljava/util/HashMap;

    invoke-virtual {v7, v3, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 69
    .end local v3    # "key":Ljava/lang/String;
    .end local v4    # "name":Ljava/lang/String;
    .end local v5    # "paramNode":Lorg/w3c/dom/Element;
    .end local v6    # "value":Ljava/lang/String;
    :cond_1
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 88
    .restart local v4    # "name":Ljava/lang/String;
    :cond_2
    iget-object v7, p0, Ltv/freewheel/hybrid/ad/ParametersHolder;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "ignore node: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 92
    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    .end local v4    # "name":Ljava/lang/String;
    :cond_3
    return-void
.end method
