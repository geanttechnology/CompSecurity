.class public Ltv/freewheel/hybrid/renderers/vast/model/Vast;
.super Ljava/lang/Object;
.source "Vast.java"


# static fields
.field private static logger:Ltv/freewheel/hybrid/utils/Logger;


# instance fields
.field private context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

.field public errorCode:I

.field public errorMessage:Ljava/lang/String;

.field public inLine:Ltv/freewheel/hybrid/renderers/vast/model/InLine;

.field public wrapper:Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-string v0, "Vast"

    invoke-static {v0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/String;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    sput-object v0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->logger:Ltv/freewheel/hybrid/utils/Logger;

    return-void
.end method

.method public constructor <init>(Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;)V
    .locals 0
    .param p1, "context"    # Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    .line 30
    return-void
.end method

.method public static match(Ljava/util/ArrayList;Ltv/freewheel/hybrid/ad/interfaces/ISlot;)Ltv/freewheel/hybrid/renderers/vast/model/Companion;
    .locals 12
    .param p1, "companionSlot"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<+",
            "Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;",
            ">;",
            "Ltv/freewheel/hybrid/ad/interfaces/ISlot;",
            ")",
            "Ltv/freewheel/hybrid/renderers/vast/model/Companion;"
        }
    .end annotation

    .prologue
    .line 126
    .local p0, "companionRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<+Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;>;"
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-eqz v7, :cond_0

    if-nez p1, :cond_1

    .line 127
    :cond_0
    const/4 v6, 0x0

    .line 150
    :goto_0
    return-object v6

    .line 128
    :cond_1
    const/4 v6, 0x0

    .line 129
    .local v6, "result":Ltv/freewheel/hybrid/renderers/vast/model/Companion;
    const v5, 0x7fffffff

    .line 130
    .local v5, "mindw":I
    const v4, 0x7fffffff

    .line 131
    .local v4, "mindh":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-ge v3, v7, :cond_2

    .line 132
    invoke-virtual {p0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;

    .line 133
    .local v0, "companion":Ltv/freewheel/hybrid/renderers/vast/model/Companion;
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getWidth()I

    move-result v7

    iget-object v8, v0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->width:Ljava/lang/Integer;

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v8

    if-ne v7, v8, :cond_3

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getHeight()I

    move-result v7

    iget-object v8, v0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->height:Ljava/lang/Integer;

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v8

    if-ne v7, v8, :cond_3

    .line 134
    move-object v6, v0

    .line 147
    .end local v0    # "companion":Ltv/freewheel/hybrid/renderers/vast/model/Companion;
    :cond_2
    sget-object v7, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v8, "Match result:slot(customId=%s:width=%d,height=%d) with companion rendition (ID=%s:width=%d,height=%d)"

    const/4 v9, 0x6

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x1

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getWidth()I

    move-result v11

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x2

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getHeight()I

    move-result v11

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x3

    iget-object v11, v6, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->id:Ljava/lang/String;

    aput-object v11, v9, v10

    const/4 v10, 0x4

    iget-object v11, v6, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->width:Ljava/lang/Integer;

    aput-object v11, v9, v10

    const/4 v10, 0x5

    iget-object v11, v6, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->height:Ljava/lang/Integer;

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 137
    .restart local v0    # "companion":Ltv/freewheel/hybrid/renderers/vast/model/Companion;
    :cond_3
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getWidth()I

    move-result v7

    iget-object v8, v0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->width:Ljava/lang/Integer;

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v8

    sub-int v2, v7, v8

    .line 138
    .local v2, "dw":I
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getHeight()I

    move-result v7

    iget-object v8, v0, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->height:Ljava/lang/Integer;

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v8

    sub-int v1, v7, v8

    .line 140
    .local v1, "dh":I
    if-le v5, v2, :cond_4

    if-le v4, v1, :cond_4

    .line 141
    move v5, v2

    .line 142
    move v4, v1

    .line 143
    move-object v6, v0

    .line 131
    :cond_4
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_1
.end method

.method private parseAdNode(Lorg/w3c/dom/Element;)Z
    .locals 9
    .param p1, "ad"    # Lorg/w3c/dom/Element;

    .prologue
    const/4 v8, 0x0

    const/4 v4, 0x1

    .line 77
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 78
    .local v1, "children":Lorg/w3c/dom/NodeList;
    const/4 v3, 0x1

    .line 79
    .local v3, "requiredNodeMissing":Z
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v5

    if-ge v2, v5, :cond_4

    .line 80
    invoke-interface {v1, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 81
    .local v0, "child":Lorg/w3c/dom/Node;
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v5

    if-ne v5, v4, :cond_0

    .line 82
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "InLine"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 83
    new-instance v5, Ltv/freewheel/hybrid/renderers/vast/model/InLine;

    invoke-direct {v5}, Ltv/freewheel/hybrid/renderers/vast/model/InLine;-><init>()V

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->inLine:Ltv/freewheel/hybrid/renderers/vast/model/InLine;

    .line 84
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->inLine:Ltv/freewheel/hybrid/renderers/vast/model/InLine;

    check-cast v0, Lorg/w3c/dom/Element;

    .end local v0    # "child":Lorg/w3c/dom/Node;
    invoke-virtual {v5, v0}, Ltv/freewheel/hybrid/renderers/vast/model/InLine;->parse(Lorg/w3c/dom/Element;)V

    .line 85
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->inLine:Ltv/freewheel/hybrid/renderers/vast/model/InLine;

    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v6}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v6

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v6

    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v7}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Ltv/freewheel/hybrid/renderers/vast/model/InLine;->isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 86
    const/4 v3, 0x0

    .line 79
    :cond_0
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 88
    :cond_1
    iput-object v8, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->inLine:Ltv/freewheel/hybrid/renderers/vast/model/InLine;

    goto :goto_1

    .line 90
    .restart local v0    # "child":Lorg/w3c/dom/Node;
    :cond_2
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "Wrapper"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 91
    new-instance v5, Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;

    invoke-direct {v5}, Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;-><init>()V

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;

    .line 92
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;

    check-cast v0, Lorg/w3c/dom/Element;

    .end local v0    # "child":Lorg/w3c/dom/Node;
    invoke-virtual {v5, v0}, Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;->parse(Lorg/w3c/dom/Element;)V

    .line 93
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;

    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v6}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v6

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v6

    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v7}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;->isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 94
    const/4 v3, 0x0

    goto :goto_1

    .line 96
    :cond_3
    iput-object v8, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;

    goto :goto_1

    .line 101
    :cond_4
    if-eqz v3, :cond_5

    .line 102
    sget-object v5, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v6, "Found an invalid Ad without valid InLine and Wrapper element, try next ad..."

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 104
    :cond_5
    if-nez v3, :cond_6

    :goto_2
    return v4

    :cond_6
    const/4 v4, 0x0

    goto :goto_2
.end method


# virtual methods
.method public getCompanionRenditions(Ltv/freewheel/hybrid/ad/interfaces/ISlot;)Ljava/util/ArrayList;
    .locals 2
    .param p1, "companionSlot"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ltv/freewheel/hybrid/ad/interfaces/ISlot;",
            ")",
            "Ljava/util/ArrayList",
            "<+",
            "Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;",
            ">;"
        }
    .end annotation

    .prologue
    .line 117
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;

    if-eqz v0, :cond_0

    .line 118
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;->searchInCompanionSlot(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;

    move-result-object v0

    .line 122
    :goto_0
    return-object v0

    .line 119
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->inLine:Ltv/freewheel/hybrid/renderers/vast/model/InLine;

    if-eqz v0, :cond_1

    .line 120
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->inLine:Ltv/freewheel/hybrid/renderers/vast/model/InLine;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Ltv/freewheel/hybrid/renderers/vast/model/InLine;->searchInCompanionSlot(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;

    move-result-object v0

    goto :goto_0

    .line 122
    :cond_1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    goto :goto_0
.end method

.method public getRenditionsInDrivingSlot()Ljava/util/ArrayList;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<+",
            "Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;",
            ">;"
        }
    .end annotation

    .prologue
    .line 108
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;

    if-eqz v0, :cond_0

    .line 109
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v1

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;->searchInDrivingSlot(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;

    move-result-object v0

    .line 113
    :goto_0
    return-object v0

    .line 110
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->inLine:Ltv/freewheel/hybrid/renderers/vast/model/InLine;

    if-eqz v0, :cond_1

    .line 111
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->inLine:Ltv/freewheel/hybrid/renderers/vast/model/InLine;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v1

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/hybrid/renderers/vast/model/InLine;->searchInDrivingSlot(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;

    move-result-object v0

    goto :goto_0

    .line 113
    :cond_1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    goto :goto_0
.end method

.method public parse(Ljava/lang/String;)Z
    .locals 9
    .param p1, "is"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x1

    .line 38
    const/4 v5, 0x0

    .line 40
    .local v5, "ret":Z
    :try_start_0
    const-string v6, "VAST"

    invoke-static {p1, v6}, Ltv/freewheel/hybrid/utils/XMLHandler;->getXMLElementFromString(Ljava/lang/String;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v3

    .line 42
    .local v3, "el":Lorg/w3c/dom/Element;
    const-string v6, "version"

    invoke-interface {v3, v6}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "2.0"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 43
    invoke-interface {v3}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 44
    .local v1, "children":Lorg/w3c/dom/NodeList;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v6

    if-ge v4, v6, :cond_0

    .line 45
    invoke-interface {v1, v4}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 46
    .local v0, "child":Lorg/w3c/dom/Node;
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v6

    if-ne v6, v8, :cond_2

    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v6

    const-string v7, "Ad"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 48
    check-cast v0, Lorg/w3c/dom/Element;

    .end local v0    # "child":Lorg/w3c/dom/Node;
    invoke-direct {p0, v0}, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->parseAdNode(Lorg/w3c/dom/Element;)Z

    move-result v5

    .line 49
    if-eqz v5, :cond_2

    .line 50
    const/4 v6, -0x1

    iput v6, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorCode:I

    .line 51
    const-string v6, ""

    iput-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorMessage:Ljava/lang/String;

    .line 56
    :cond_0
    if-nez v5, :cond_1

    .line 57
    const/4 v6, 0x2

    iput v6, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorCode:I

    .line 58
    const-string v6, "Error validating VAST document: no Ad node found!"

    iput-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorMessage:Ljava/lang/String;

    .line 59
    sget-object v6, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->logger:Ltv/freewheel/hybrid/utils/Logger;

    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorMessage:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    .line 73
    .end local v1    # "children":Lorg/w3c/dom/NodeList;
    .end local v3    # "el":Lorg/w3c/dom/Element;
    .end local v4    # "i":I
    :cond_1
    :goto_1
    return v5

    .line 44
    .restart local v1    # "children":Lorg/w3c/dom/NodeList;
    .restart local v3    # "el":Lorg/w3c/dom/Element;
    .restart local v4    # "i":I
    :cond_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 62
    .end local v1    # "children":Lorg/w3c/dom/NodeList;
    .end local v4    # "i":I
    :cond_3
    const/4 v6, 0x1

    iput v6, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorCode:I

    .line 63
    const-string v6, "Only VAST 2.0 is supported."

    iput-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorMessage:Ljava/lang/String;

    .line 64
    sget-object v6, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->logger:Ltv/freewheel/hybrid/utils/Logger;

    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorMessage:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 66
    .end local v3    # "el":Lorg/w3c/dom/Element;
    :catch_0
    move-exception v2

    .line 67
    .local v2, "e":Ljava/lang/Exception;
    const/4 v6, 0x0

    iput v6, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorCode:I

    .line 68
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Error parsing VAST document: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v2}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorMessage:Ljava/lang/String;

    .line 69
    sget-object v6, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->logger:Ltv/freewheel/hybrid/utils/Logger;

    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorMessage:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    .line 70
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    .line 71
    const/4 v5, 0x0

    goto :goto_1
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 34
    const-string v0, "[Ad\n\tInLine=%s\n\tWrapper=%s\n]"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->inLine:Ltv/freewheel/hybrid/renderers/vast/model/InLine;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
