.class public Ltv/freewheel/hybrid/ad/AdResponse;
.super Ltv/freewheel/hybrid/ad/EventCallbackHolder;
.source "AdResponse.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
    }
.end annotation


# instance fields
.field public ads:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/Ad;",
            ">;"
        }
    .end annotation
.end field

.field public nonTemporalSlots:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;",
            ">;"
        }
    .end annotation
.end field

.field public profileParameters:Ljava/util/HashMap;
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

.field public temporalSlots:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/slot/TemporalSlot;",
            ">;"
        }
    .end annotation
.end field

.field public videoAsset:Ltv/freewheel/hybrid/ad/VideoAsset;


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/ad/AdContext;)V
    .locals 1
    .param p1, "context"    # Ltv/freewheel/hybrid/ad/AdContext;

    .prologue
    .line 44
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/EventCallbackHolder;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 46
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdResponse;->ads:Ljava/util/ArrayList;

    .line 47
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdResponse;->temporalSlots:Ljava/util/ArrayList;

    .line 48
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdResponse;->nonTemporalSlots:Ljava/util/ArrayList;

    .line 50
    new-instance v0, Ltv/freewheel/hybrid/ad/VideoAsset;

    invoke-direct {v0, p1}, Ltv/freewheel/hybrid/ad/VideoAsset;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdResponse;->videoAsset:Ltv/freewheel/hybrid/ad/VideoAsset;

    .line 51
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/AdResponse;->profileParameters:Ljava/util/HashMap;

    .line 52
    return-void
.end method

.method private parseAdRendererNode(Lorg/w3c/dom/Element;)V
    .locals 8
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 168
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 170
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v5

    if-ge v2, v5, :cond_1

    .line 171
    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 172
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 173
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    .line 174
    .local v3, "name":Ljava/lang/String;
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "parseAdRendererNode, name: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 176
    const-string v5, "adRenderer"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 177
    new-instance v4, Ltv/freewheel/hybrid/ad/AdRenderer;

    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdResponse;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-direct {v4, v5}, Ltv/freewheel/hybrid/ad/AdRenderer;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 178
    .local v4, "renderer":Ltv/freewheel/hybrid/ad/AdRenderer;
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {v4, v1}, Ltv/freewheel/hybrid/ad/AdRenderer;->parse(Lorg/w3c/dom/Element;)V

    .line 179
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdResponse;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v5, v5, Ltv/freewheel/hybrid/ad/AdContext;->adRenderers:Ljava/util/ArrayList;

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 170
    .end local v3    # "name":Ljava/lang/String;
    .end local v4    # "renderer":Ltv/freewheel/hybrid/ad/AdRenderer;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 183
    :cond_1
    return-void
.end method

.method private parseAdRenderers(Lorg/w3c/dom/Element;)V
    .locals 9
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 148
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 150
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const-string v4, ""

    .line 151
    .local v4, "menifestStr":Ljava/lang/String;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v6

    if-ge v3, v6, :cond_1

    .line 152
    invoke-interface {v0, v3}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 153
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v6

    const/4 v7, 0x3

    if-ne v6, v7, :cond_0

    .line 154
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 151
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 157
    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    :cond_1
    iget-object v6, p0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "parseAdRenderers: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 159
    :try_start_0
    const-string v6, "adRenderers"

    invoke-static {v4, v6}, Ltv/freewheel/hybrid/utils/XMLHandler;->getXMLElementFromString(Ljava/lang/String;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v5

    .line 160
    .local v5, "renderers":Lorg/w3c/dom/Element;
    invoke-direct {p0, v5}, Ltv/freewheel/hybrid/ad/AdResponse;->parseAdRendererNode(Lorg/w3c/dom/Element;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 165
    .end local v5    # "renderers":Lorg/w3c/dom/Element;
    :goto_1
    return-void

    .line 161
    :catch_0
    move-exception v2

    .line 162
    .local v2, "e":Ljava/lang/Exception;
    iget-object v6, p0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v7, "parseAdRenderers failed"

    invoke-virtual {v6, v7}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 163
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method

.method private parseAdSlots(Lorg/w3c/dom/Element;I)V
    .locals 17
    .param p1, "node"    # Lorg/w3c/dom/Element;
    .param p2, "type"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    .line 238
    invoke-interface/range {p1 .. p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v12

    .line 240
    .local v12, "childList":Lorg/w3c/dom/NodeList;
    const/4 v15, 0x0

    .local v15, "i":I
    :goto_0
    invoke-interface {v12}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    if-ge v15, v3, :cond_4

    .line 241
    invoke-interface {v12, v15}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v13

    .line 242
    .local v13, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v13}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_1

    .line 243
    invoke-interface {v13}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v16

    .line 244
    .local v16, "name":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v3, v0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "parseAdSlots, name: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, v16

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 246
    const-string v3, "adSlot"

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    move-object v14, v13

    .line 247
    check-cast v14, Lorg/w3c/dom/Element;

    .line 249
    .local v14, "ele":Lorg/w3c/dom/Element;
    const-string v3, "customId"

    invoke-interface {v14, v3}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 251
    .local v2, "customId":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v3, v0, Ltv/freewheel/hybrid/ad/AdResponse;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v3, v2}, Ltv/freewheel/hybrid/ad/AdContext;->getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;

    .line 252
    .local v1, "slot":Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    if-nez v1, :cond_0

    .line 253
    invoke-virtual/range {p0 .. p0}, Ltv/freewheel/hybrid/ad/AdResponse;->getAdRequest()Ltv/freewheel/hybrid/ad/AdRequest;

    move-result-object v3

    invoke-virtual {v3, v2}, Ltv/freewheel/hybrid/ad/AdRequest;->getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/hybrid/ad/slot/Slot;

    move-result-object v1

    .end local v1    # "slot":Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    check-cast v1, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;

    .line 254
    .restart local v1    # "slot":Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    if-eqz v1, :cond_2

    .line 255
    invoke-virtual {v1}, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->copy()Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;

    move-result-object v1

    .line 260
    :goto_1
    move-object/from16 v0, p0

    iget-object v3, v0, Ltv/freewheel/hybrid/ad/AdResponse;->nonTemporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 262
    :cond_0
    check-cast v13, Lorg/w3c/dom/Element;

    .end local v13    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {v1, v13}, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->parse(Lorg/w3c/dom/Element;)V

    .line 240
    .end local v1    # "slot":Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    .end local v2    # "customId":Ljava/lang/String;
    .end local v14    # "ele":Lorg/w3c/dom/Element;
    .end local v16    # "name":Ljava/lang/String;
    :cond_1
    :goto_2
    add-int/lit8 v15, v15, 0x1

    goto :goto_0

    .line 257
    .restart local v1    # "slot":Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    .restart local v2    # "customId":Ljava/lang/String;
    .restart local v13    # "childNode":Lorg/w3c/dom/Node;
    .restart local v14    # "ele":Lorg/w3c/dom/Element;
    .restart local v16    # "name":Ljava/lang/String;
    :cond_2
    new-instance v1, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;

    .end local v1    # "slot":Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    move-object/from16 v0, p0

    iget-object v3, v0, Ltv/freewheel/hybrid/ad/AdResponse;->context:Ltv/freewheel/hybrid/ad/AdContext;

    move/from16 v0, p2

    invoke-direct {v1, v3, v0}, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;-><init>(Ltv/freewheel/hybrid/ad/AdContext;I)V

    .line 258
    .restart local v1    # "slot":Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    invoke-virtual/range {v1 .. v11}, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->init(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_1

    .line 264
    .end local v1    # "slot":Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    .end local v2    # "customId":Ljava/lang/String;
    .end local v14    # "ele":Lorg/w3c/dom/Element;
    :cond_3
    move-object/from16 v0, p0

    iget-object v3, v0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "ignore node: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, v16

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_2

    .line 268
    .end local v13    # "childNode":Lorg/w3c/dom/Node;
    .end local v16    # "name":Ljava/lang/String;
    :cond_4
    return-void
.end method

.method private parseAds(Lorg/w3c/dom/Element;)V
    .locals 8
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 186
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 188
    .local v1, "childList":Lorg/w3c/dom/NodeList;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v5

    if-ge v3, v5, :cond_2

    .line 189
    invoke-interface {v1, v3}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 190
    .local v2, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 191
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    .line 192
    .local v4, "name":Ljava/lang/String;
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "parseAds, name: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 193
    const-string v5, "ad"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 194
    new-instance v0, Ltv/freewheel/hybrid/ad/Ad;

    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdResponse;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-direct {v0, v5}, Ltv/freewheel/hybrid/ad/Ad;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 195
    .local v0, "ad":Ltv/freewheel/hybrid/ad/Ad;
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {v0, v2}, Ltv/freewheel/hybrid/ad/Ad;->parse(Lorg/w3c/dom/Element;)V

    .line 196
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdResponse;->ads:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 188
    .end local v0    # "ad":Ltv/freewheel/hybrid/ad/Ad;
    .end local v4    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 199
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    .restart local v4    # "name":Ljava/lang/String;
    :cond_1
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    .line 203
    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    .end local v4    # "name":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method private parseSiteSection(Lorg/w3c/dom/Element;)V
    .locals 8
    .param p1, "node"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    .line 206
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 209
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v4

    if-ge v2, v4, :cond_1

    .line 210
    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 211
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v4

    if-ne v4, v7, :cond_0

    .line 212
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    .line 213
    .local v3, "name":Ljava/lang/String;
    const-string v4, "adSlots"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 214
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "parseSiteSection, name: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 215
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdResponse;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdContext;->capabilities:Ltv/freewheel/hybrid/ad/Capabilities;

    const-string v5, "skipsAdSelection"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/ad/Capabilities;->getCapability(Ljava/lang/String;)I

    move-result v4

    if-ne v4, v7, :cond_0

    .line 216
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    const/4 v4, 0x2

    invoke-direct {p0, v1, v4}, Ltv/freewheel/hybrid/ad/AdResponse;->parseAdSlots(Lorg/w3c/dom/Element;I)V

    .line 209
    .end local v3    # "name":Ljava/lang/String;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 223
    :cond_1
    const/4 v2, 0x0

    :goto_1
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v4

    if-ge v2, v4, :cond_4

    .line 224
    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 225
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v4

    if-ne v4, v7, :cond_2

    .line 226
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    .line 227
    .restart local v3    # "name":Ljava/lang/String;
    const-string v4, "videoPlayer"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 228
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "parseSiteSection, name: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 229
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-direct {p0, v1}, Ltv/freewheel/hybrid/ad/AdResponse;->parseVideoPlayer(Lorg/w3c/dom/Element;)V

    .line 223
    .end local v3    # "name":Ljava/lang/String;
    :cond_2
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 230
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    .restart local v3    # "name":Ljava/lang/String;
    :cond_3
    const-string v4, "adSlots"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 231
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "parseSiteSection, ignore node: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_2

    .line 235
    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    .end local v3    # "name":Ljava/lang/String;
    :cond_4
    return-void
.end method

.method private parseVideoPlayer(Lorg/w3c/dom/Element;)V
    .locals 8
    .param p1, "node"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    .line 271
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 274
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v4

    if-ge v2, v4, :cond_1

    .line 275
    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 276
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v4

    if-ne v4, v7, :cond_0

    .line 277
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    .line 278
    .local v3, "name":Ljava/lang/String;
    const-string v4, "adSlots"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 279
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "parseVideoPlayer, name: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 280
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdResponse;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdContext;->capabilities:Ltv/freewheel/hybrid/ad/Capabilities;

    const-string v5, "skipsAdSelection"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/ad/Capabilities;->getCapability(Ljava/lang/String;)I

    move-result v4

    if-ne v4, v7, :cond_0

    .line 281
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-direct {p0, v1, v7}, Ltv/freewheel/hybrid/ad/AdResponse;->parseAdSlots(Lorg/w3c/dom/Element;I)V

    .line 274
    .end local v3    # "name":Ljava/lang/String;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 288
    :cond_1
    const/4 v2, 0x0

    :goto_1
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v4

    if-ge v2, v4, :cond_4

    .line 289
    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 290
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v4

    if-ne v4, v7, :cond_2

    .line 291
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    .line 292
    .restart local v3    # "name":Ljava/lang/String;
    const-string v4, "videoAsset"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 293
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "parseVideoPlayer, name: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 294
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdResponse;->videoAsset:Ltv/freewheel/hybrid/ad/VideoAsset;

    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {v4, v1}, Ltv/freewheel/hybrid/ad/VideoAsset;->parse(Lorg/w3c/dom/Element;)V

    .line 288
    .end local v3    # "name":Ljava/lang/String;
    :cond_2
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 295
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    .restart local v3    # "name":Ljava/lang/String;
    :cond_3
    const-string v4, "adSlots"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 296
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "parseVideoPlayer, ignore node: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_2

    .line 300
    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    .end local v3    # "name":Ljava/lang/String;
    :cond_4
    return-void
.end method

.method private parseXmlDocument(Lorg/w3c/dom/Document;)V
    .locals 11
    .param p1, "document"    # Lorg/w3c/dom/Document;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x1

    .line 106
    const-string v7, "adResponse"

    invoke-interface {p1, v7}, Lorg/w3c/dom/Document;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v6

    .line 107
    .local v6, "rootList":Lorg/w3c/dom/NodeList;
    invoke-interface {v6}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v7

    if-nez v7, :cond_0

    .line 108
    new-instance v7, Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;

    const-string v8, "no root nodeadResponse found in document"

    invoke-direct {v7, v8}, Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 112
    :cond_0
    const/4 v7, 0x0

    invoke-interface {v6, v7}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    check-cast v0, Lorg/w3c/dom/Element;

    .line 113
    .local v0, "adResponseElement":Lorg/w3c/dom/Element;
    invoke-interface {v0}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 115
    .local v1, "childList":Lorg/w3c/dom/NodeList;
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v4

    .line 116
    .local v4, "length":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v4, :cond_8

    .line 117
    invoke-interface {v1, v3}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 118
    .local v2, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v7

    if-ne v7, v10, :cond_1

    .line 120
    iget-object v7, p0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "parseXMLString: name: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 122
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    .line 124
    .local v5, "name":Ljava/lang/String;
    const-string v7, "ads"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 125
    iget-object v7, p0, Ltv/freewheel/hybrid/ad/AdResponse;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v7, v7, Ltv/freewheel/hybrid/ad/AdContext;->capabilities:Ltv/freewheel/hybrid/ad/Capabilities;

    const-string v8, "skipsAdSelection"

    invoke-virtual {v7, v8}, Ltv/freewheel/hybrid/ad/Capabilities;->getCapability(Ljava/lang/String;)I

    move-result v7

    if-ne v7, v10, :cond_1

    .line 126
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-direct {p0, v2}, Ltv/freewheel/hybrid/ad/AdResponse;->parseAds(Lorg/w3c/dom/Element;)V

    .line 116
    .end local v5    # "name":Ljava/lang/String;
    :cond_1
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 128
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    .restart local v5    # "name":Ljava/lang/String;
    :cond_2
    const-string v7, "siteSection"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 129
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-direct {p0, v2}, Ltv/freewheel/hybrid/ad/AdResponse;->parseSiteSection(Lorg/w3c/dom/Element;)V

    goto :goto_1

    .line 130
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    :cond_3
    const-string v7, "eventCallbacks"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 131
    iget-object v7, p0, Ltv/freewheel/hybrid/ad/AdResponse;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v7, v7, Ltv/freewheel/hybrid/ad/AdContext;->capabilities:Ltv/freewheel/hybrid/ad/Capabilities;

    const-string v8, "skipsAdSelection"

    invoke-virtual {v7, v8}, Ltv/freewheel/hybrid/ad/Capabilities;->getCapability(Ljava/lang/String;)I

    move-result v7

    if-ne v7, v10, :cond_1

    .line 132
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {p0, v2}, Ltv/freewheel/hybrid/ad/AdResponse;->parseEventCallbacks(Lorg/w3c/dom/Element;)V

    goto :goto_1

    .line 134
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    :cond_4
    const-string v7, "rendererManifest"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 135
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-direct {p0, v2}, Ltv/freewheel/hybrid/ad/AdResponse;->parseAdRenderers(Lorg/w3c/dom/Element;)V

    goto :goto_1

    .line 136
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    :cond_5
    const-string v7, "visitor"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_6

    .line 137
    iget-object v7, p0, Ltv/freewheel/hybrid/ad/AdResponse;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v7, v7, Ltv/freewheel/hybrid/ad/AdContext;->visitor:Ltv/freewheel/hybrid/ad/Visitor;

    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {v7, v2}, Ltv/freewheel/hybrid/ad/Visitor;->parse(Lorg/w3c/dom/Element;)V

    goto :goto_1

    .line 138
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    :cond_6
    const-string v7, "parameters"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_7

    .line 139
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-static {v2}, Ltv/freewheel/hybrid/ad/ParametersHolder;->parseParameters(Lorg/w3c/dom/Element;)Ljava/util/HashMap;

    move-result-object v7

    iput-object v7, p0, Ltv/freewheel/hybrid/ad/AdResponse;->profileParameters:Ljava/util/HashMap;

    goto :goto_1

    .line 141
    .restart local v2    # "childNode":Lorg/w3c/dom/Node;
    :cond_7
    iget-object v7, p0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "ignore node: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 145
    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    .end local v5    # "name":Ljava/lang/String;
    :cond_8
    return-void
.end method


# virtual methods
.method public getAd(I)Ltv/freewheel/hybrid/ad/Ad;
    .locals 3
    .param p1, "adId"    # I

    .prologue
    .line 55
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdResponse;->ads:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 57
    .local v1, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/Ad;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 58
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/Ad;

    .line 59
    .local v0, "ad":Ltv/freewheel/hybrid/ad/Ad;
    iget v2, v0, Ltv/freewheel/hybrid/ad/Ad;->adId:I

    if-ne v2, p1, :cond_0

    .line 64
    .end local v0    # "ad":Ltv/freewheel/hybrid/ad/Ad;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parse(Ljava/io/InputStream;)V
    .locals 6
    .param p1, "is"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    .line 68
    invoke-static {}, Ljavax/xml/parsers/DocumentBuilderFactory;->newInstance()Ljavax/xml/parsers/DocumentBuilderFactory;

    move-result-object v3

    .line 69
    .local v3, "factory":Ljavax/xml/parsers/DocumentBuilderFactory;
    const/4 v0, 0x0

    .line 72
    .local v0, "builder":Ljavax/xml/parsers/DocumentBuilder;
    :try_start_0
    invoke-virtual {v3}, Ljavax/xml/parsers/DocumentBuilderFactory;->newDocumentBuilder()Ljavax/xml/parsers/DocumentBuilder;
    :try_end_0
    .catch Ljavax/xml/parsers/ParserConfigurationException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 77
    const/4 v1, 0x0

    .line 79
    .local v1, "document":Lorg/w3c/dom/Document;
    :try_start_1
    invoke-virtual {v0, p1}, Ljavax/xml/parsers/DocumentBuilder;->parse(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    :try_end_1
    .catch Lorg/xml/sax/SAXException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v1

    .line 86
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdResponse;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v4}, Ltv/freewheel/hybrid/ad/AdContext;->getActivity()Landroid/app/Activity;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 87
    invoke-direct {p0, v1}, Ltv/freewheel/hybrid/ad/AdResponse;->parseXmlDocument(Lorg/w3c/dom/Document;)V

    .line 91
    :goto_0
    return-void

    .line 73
    .end local v1    # "document":Lorg/w3c/dom/Document;
    :catch_0
    move-exception v2

    .line 74
    .local v2, "e":Ljavax/xml/parsers/ParserConfigurationException;
    new-instance v4, Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;

    const-string v5, "new DocumentBuilder failed"

    invoke-direct {v4, v5}, Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 80
    .end local v2    # "e":Ljavax/xml/parsers/ParserConfigurationException;
    .restart local v1    # "document":Lorg/w3c/dom/Document;
    :catch_1
    move-exception v2

    .line 81
    .local v2, "e":Lorg/xml/sax/SAXException;
    new-instance v4, Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;

    const-string v5, "parse xml failed"

    invoke-direct {v4, v5}, Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 82
    .end local v2    # "e":Lorg/xml/sax/SAXException;
    :catch_2
    move-exception v2

    .line 83
    .local v2, "e":Ljava/io/IOException;
    new-instance v4, Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;

    const-string v5, "IO Error occurred"

    invoke-direct {v4, v5}, Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 89
    .end local v2    # "e":Ljava/io/IOException;
    :cond_0
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdResponse;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v5, "host activity is null, won\'t parse response"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public parse(Ljava/lang/String;)V
    .locals 3
    .param p1, "adResponseString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    .line 96
    :try_start_0
    new-instance v0, Ljava/io/ByteArrayInputStream;

    const-string v2, "UTF-8"

    invoke-virtual {p1, v2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/io/ByteArrayInputStream;-><init>([B)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 101
    .local v0, "byteArrayInputStream":Ljava/io/ByteArrayInputStream;
    :goto_0
    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/ad/AdResponse;->parse(Ljava/io/InputStream;)V

    .line 102
    return-void

    .line 97
    .end local v0    # "byteArrayInputStream":Ljava/io/ByteArrayInputStream;
    :catch_0
    move-exception v1

    .line 98
    .local v1, "e1":Ljava/io/UnsupportedEncodingException;
    new-instance v0, Ljava/io/ByteArrayInputStream;

    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .restart local v0    # "byteArrayInputStream":Ljava/io/ByteArrayInputStream;
    goto :goto_0
.end method
