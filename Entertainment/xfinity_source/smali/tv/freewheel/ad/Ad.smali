.class public Ltv/freewheel/ad/Ad;
.super Ltv/freewheel/ad/AdContextScoped;
.source "Ad.java"


# instance fields
.field public adId:I

.field public adUnit:Ljava/lang/String;

.field public creatives:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/Creative;",
            ">;"
        }
    .end annotation
.end field

.field public isRequiredToShow:Z

.field public noLoad:Z


# direct methods
.method public constructor <init>(Ltv/freewheel/ad/AdContext;)V
    .locals 2
    .param p1, "context"    # Ltv/freewheel/ad/AdContext;

    .prologue
    const/4 v1, 0x0

    .line 18
    invoke-direct {p0, p1}, Ltv/freewheel/ad/AdContextScoped;-><init>(Ltv/freewheel/ad/AdContext;)V

    .line 19
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/Ad;->creatives:Ljava/util/ArrayList;

    .line 20
    iput v1, p0, Ltv/freewheel/ad/Ad;->adId:I

    .line 21
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/ad/Ad;->adUnit:Ljava/lang/String;

    .line 22
    iput-boolean v1, p0, Ltv/freewheel/ad/Ad;->noLoad:Z

    .line 23
    iput-boolean v1, p0, Ltv/freewheel/ad/Ad;->isRequiredToShow:Z

    .line 24
    return-void
.end method

.method private parseCreatives(Lorg/w3c/dom/Element;)V
    .locals 8
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 51
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 53
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v5

    if-ge v3, v5, :cond_2

    .line 54
    invoke-interface {v0, v3}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 55
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 56
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    .line 57
    .local v4, "name":Ljava/lang/String;
    iget-object v5, p0, Ltv/freewheel/ad/Ad;->logger:Ltv/freewheel/utils/Logger;

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

    .line 59
    const-string v5, "creative"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 60
    new-instance v2, Ltv/freewheel/ad/Creative;

    iget-object v5, p0, Ltv/freewheel/ad/Ad;->context:Ltv/freewheel/ad/AdContext;

    invoke-direct {v2, v5}, Ltv/freewheel/ad/Creative;-><init>(Ltv/freewheel/ad/AdContext;)V

    .line 61
    .local v2, "creative":Ltv/freewheel/ad/Creative;
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {v2, v1}, Ltv/freewheel/ad/Creative;->parse(Lorg/w3c/dom/Element;)V

    .line 62
    iget-object v5, p0, Ltv/freewheel/ad/Ad;->creatives:Ljava/util/ArrayList;

    invoke-virtual {v5, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 53
    .end local v2    # "creative":Ltv/freewheel/ad/Creative;
    .end local v4    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 64
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    .restart local v4    # "name":Ljava/lang/String;
    :cond_1
    iget-object v5, p0, Ltv/freewheel/ad/Ad;->logger:Ltv/freewheel/utils/Logger;

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

    .line 68
    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    .end local v4    # "name":Ljava/lang/String;
    :cond_2
    return-void
.end method


# virtual methods
.method public cloneForTranslation()Ltv/freewheel/ad/Ad;
    .locals 4

    .prologue
    .line 84
    new-instance v0, Ltv/freewheel/ad/Ad;

    iget-object v2, p0, Ltv/freewheel/ad/Ad;->context:Ltv/freewheel/ad/AdContext;

    invoke-direct {v0, v2}, Ltv/freewheel/ad/Ad;-><init>(Ltv/freewheel/ad/AdContext;)V

    .line 85
    .local v0, "clone":Ltv/freewheel/ad/Ad;
    iget v2, p0, Ltv/freewheel/ad/Ad;->adId:I

    iput v2, v0, Ltv/freewheel/ad/Ad;->adId:I

    .line 86
    iget-object v2, p0, Ltv/freewheel/ad/Ad;->adUnit:Ljava/lang/String;

    iput-object v2, v0, Ltv/freewheel/ad/Ad;->adUnit:Ljava/lang/String;

    .line 87
    iget-boolean v2, p0, Ltv/freewheel/ad/Ad;->isRequiredToShow:Z

    iput-boolean v2, v0, Ltv/freewheel/ad/Ad;->isRequiredToShow:Z

    .line 88
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Ltv/freewheel/ad/Ad;->creatives:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 89
    iget-object v3, v0, Ltv/freewheel/ad/Ad;->creatives:Ljava/util/ArrayList;

    iget-object v2, p0, Ltv/freewheel/ad/Ad;->creatives:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/Creative;

    invoke-virtual {v2}, Ltv/freewheel/ad/Creative;->cloneForTranslation()Ltv/freewheel/ad/Creative;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 88
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 92
    :cond_0
    return-object v0
.end method

.method public getCreative(I)Ltv/freewheel/ad/Creative;
    .locals 3
    .param p1, "creativeId"    # I

    .prologue
    .line 71
    iget-object v2, p0, Ltv/freewheel/ad/Ad;->creatives:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 73
    .local v1, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/Creative;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 74
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/ad/Creative;

    .line 75
    .local v0, "creative":Ltv/freewheel/ad/Creative;
    iget v2, v0, Ltv/freewheel/ad/Creative;->creativeId:I

    if-ne v2, p1, :cond_0

    .line 80
    .end local v0    # "creative":Ltv/freewheel/ad/Creative;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 7
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 27
    const-string v4, "adId"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ltv/freewheel/ad/Ad;->tryParseInt(Ljava/lang/String;)I

    move-result v4

    iput v4, p0, Ltv/freewheel/ad/Ad;->adId:I

    .line 28
    const-string v4, "adUnit"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/ad/Ad;->adUnit:Ljava/lang/String;

    .line 29
    const-string v4, "noLoad"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v4, v5}, Ltv/freewheel/ad/Ad;->tryParseBoolean(Ljava/lang/String;Z)Z

    move-result v4

    iput-boolean v4, p0, Ltv/freewheel/ad/Ad;->noLoad:Z

    .line 30
    const-string v4, "required"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->hasAttribute(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 31
    const-string v4, "required"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "true"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    iput-boolean v4, p0, Ltv/freewheel/ad/Ad;->isRequiredToShow:Z

    .line 34
    :cond_0
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 35
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v4

    if-ge v2, v4, :cond_3

    .line 36
    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 37
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_1

    .line 38
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    .line 39
    .local v3, "name":Ljava/lang/String;
    iget-object v4, p0, Ltv/freewheel/ad/Ad;->logger:Ltv/freewheel/utils/Logger;

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

    .line 41
    const-string v4, "creatives"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 42
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-direct {p0, v1}, Ltv/freewheel/ad/Ad;->parseCreatives(Lorg/w3c/dom/Element;)V

    .line 35
    .end local v3    # "name":Ljava/lang/String;
    :cond_1
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 44
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    .restart local v3    # "name":Ljava/lang/String;
    :cond_2
    iget-object v4, p0, Ltv/freewheel/ad/Ad;->logger:Ltv/freewheel/utils/Logger;

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

    .line 48
    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    .end local v3    # "name":Ljava/lang/String;
    :cond_3
    return-void
.end method
