.class public Ltv/freewheel/ad/slot/Slot;
.super Ltv/freewheel/ad/EventCallbackHolder;
.source "Slot.java"

# interfaces
.implements Ltv/freewheel/ad/interfaces/ISlot;


# instance fields
.field public acceptContentType:Ljava/lang/String;

.field public acceptPrimaryContentType:Ljava/lang/String;

.field public adChains:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/AdChain;",
            ">;"
        }
    .end annotation
.end field

.field public adUnit:Ljava/lang/String;

.field public callbackHandler:Ltv/freewheel/ad/handler/SlotImpressionCallbackHandler;

.field public currentPlayingAdInstance:Ltv/freewheel/ad/AdInstance;

.field public customId:Ljava/lang/String;

.field protected displayBase:Landroid/view/ViewGroup;

.field public height:I

.field private lastPlayheadTime:D

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

.field public requestContentPause:Z

.field public slotProfile:Ljava/lang/String;

.field public state:Ltv/freewheel/ad/state/SlotState;

.field public timePositionClass:I

.field public type:I

.field public width:I


# direct methods
.method public constructor <init>(Ltv/freewheel/ad/AdContext;I)V
    .locals 2
    .param p1, "context"    # Ltv/freewheel/ad/AdContext;
    .param p2, "type"    # I

    .prologue
    .line 51
    invoke-direct {p0, p1}, Ltv/freewheel/ad/EventCallbackHolder;-><init>(Ltv/freewheel/ad/AdContext;)V

    .line 47
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Ltv/freewheel/ad/slot/Slot;->lastPlayheadTime:D

    .line 52
    iput p2, p0, Ltv/freewheel/ad/slot/Slot;->type:I

    .line 53
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/slot/Slot;->parameters:Ljava/util/HashMap;

    .line 54
    invoke-static {}, Ltv/freewheel/ad/state/SlotInitState;->Instance()Ltv/freewheel/ad/state/SlotState;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/slot/Slot;->state:Ltv/freewheel/ad/state/SlotState;

    .line 55
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/ad/slot/Slot;->requestContentPause:Z

    .line 56
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/slot/Slot;->adChains:Ljava/util/ArrayList;

    .line 57
    return-void
.end method

.method protected static buildContentTypeElement([Ljava/lang/String;[Ljava/lang/String;)Ltv/freewheel/utils/XMLElement;
    .locals 8
    .param p0, "primaryContentTypes"    # [Ljava/lang/String;
    .param p1, "contentTypes"    # [Ljava/lang/String;

    .prologue
    .line 126
    new-instance v4, Ltv/freewheel/utils/XMLElement;

    const-string v6, "contentTypes"

    invoke-direct {v4, v6}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 128
    .local v4, "node":Ltv/freewheel/utils/XMLElement;
    array-length v3, p0

    .line 129
    .local v3, "length":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v3, :cond_0

    .line 130
    new-instance v5, Ltv/freewheel/utils/XMLElement;

    const-string v6, "acceptPrimaryContentType"

    invoke-direct {v5, v6}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 131
    .local v5, "pc":Ltv/freewheel/utils/XMLElement;
    const-string v6, "contentTypeId"

    aget-object v7, p0, v1

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 133
    invoke-virtual {v4, v5}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    .line 129
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 136
    .end local v5    # "pc":Ltv/freewheel/utils/XMLElement;
    :cond_0
    array-length v3, p1

    .line 137
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_1
    if-ge v2, v3, :cond_1

    .line 138
    new-instance v0, Ltv/freewheel/utils/XMLElement;

    const-string v6, "acceptContentType"

    invoke-direct {v0, v6}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 139
    .local v0, "c":Ltv/freewheel/utils/XMLElement;
    const-string v6, "contentTypeId"

    aget-object v7, p1, v2

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v6, v7}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 141
    invoke-virtual {v4, v0}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    .line 137
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 144
    .end local v0    # "c":Ltv/freewheel/utils/XMLElement;
    :cond_1
    return-object v4
.end method

.method private findNextPlayableAd(Ltv/freewheel/ad/AdInstance;)Ltv/freewheel/ad/AdInstance;
    .locals 7
    .param p1, "from"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 438
    iget-object v4, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " findNextPlayableAd() from:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 439
    const/4 v3, 0x0

    .line 440
    .local v3, "ret":Ltv/freewheel/ad/AdInstance;
    const/4 v1, -0x1

    .line 441
    .local v1, "chainIndex":I
    if-eqz p1, :cond_1

    .line 442
    iget-object v4, p0, Ltv/freewheel/ad/slot/Slot;->adChains:Ljava/util/ArrayList;

    iget-object v5, p1, Ltv/freewheel/ad/AdInstance;->adChain:Ltv/freewheel/ad/AdChain;

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v1

    .line 446
    :goto_0
    iget-object v4, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " findNextPlayableAd() look from chain index "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " chain size:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Ltv/freewheel/ad/slot/Slot;->adChains:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 447
    const/4 v0, 0x0

    .line 448
    .local v0, "chain":Ltv/freewheel/ad/AdChain;
    move v2, v1

    .local v2, "i":I
    :goto_1
    iget-object v4, p0, Ltv/freewheel/ad/slot/Slot;->adChains:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v2, v4, :cond_0

    .line 449
    iget-object v4, p0, Ltv/freewheel/ad/slot/Slot;->adChains:Ljava/util/ArrayList;

    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "chain":Ltv/freewheel/ad/AdChain;
    check-cast v0, Ltv/freewheel/ad/AdChain;

    .line 450
    .restart local v0    # "chain":Ltv/freewheel/ad/AdChain;
    invoke-virtual {v0, p1}, Ltv/freewheel/ad/AdChain;->findNextPlayableAd(Ltv/freewheel/ad/AdInstance;)Ltv/freewheel/ad/AdInstance;

    move-result-object v3

    .line 451
    if-eqz v3, :cond_2

    .line 455
    :cond_0
    iget-object v4, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " findNextPlayableAd() returning "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 456
    return-object v3

    .line 444
    .end local v0    # "chain":Ltv/freewheel/ad/AdChain;
    .end local v2    # "i":I
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    .line 448
    .restart local v0    # "chain":Ltv/freewheel/ad/AdChain;
    .restart local v2    # "i":I
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method

.method private parseSelectedAds(Lorg/w3c/dom/Element;)V
    .locals 9
    .param p1, "node"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    .line 183
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v2

    .line 185
    .local v2, "childList":Lorg/w3c/dom/NodeList;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    invoke-interface {v2}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v6

    if-ge v4, v6, :cond_2

    .line 186
    invoke-interface {v2, v4}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    .line 187
    .local v3, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v6

    const/4 v7, 0x1

    if-ne v6, v7, :cond_0

    .line 188
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    .line 189
    .local v5, "name":Ljava/lang/String;
    iget-object v6, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "parse(), name: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 191
    const-string v6, "adReference"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 192
    new-instance v1, Ltv/freewheel/ad/AdInstance;

    iget-object v6, p0, Ltv/freewheel/ad/slot/Slot;->context:Ltv/freewheel/ad/AdContext;

    invoke-direct {v1, v6}, Ltv/freewheel/ad/AdInstance;-><init>(Ltv/freewheel/ad/AdContext;)V

    .line 193
    .local v1, "adInstance":Ltv/freewheel/ad/AdInstance;
    iput-object p0, v1, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    .line 194
    check-cast v3, Lorg/w3c/dom/Element;

    .end local v3    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {v1, v3}, Ltv/freewheel/ad/AdInstance;->parse(Lorg/w3c/dom/Element;)V

    .line 195
    invoke-virtual {v1}, Ltv/freewheel/ad/AdInstance;->buildAdChain()Ltv/freewheel/ad/AdChain;

    move-result-object v0

    .line 196
    .local v0, "adChain":Ltv/freewheel/ad/AdChain;
    iget-object v6, p0, Ltv/freewheel/ad/slot/Slot;->adChains:Ljava/util/ArrayList;

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 185
    .end local v0    # "adChain":Ltv/freewheel/ad/AdChain;
    .end local v1    # "adInstance":Ltv/freewheel/ad/AdInstance;
    .end local v5    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 198
    .restart local v3    # "childNode":Lorg/w3c/dom/Node;
    .restart local v5    # "name":Ljava/lang/String;
    :cond_1
    iget-object v6, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "ignore node: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 202
    .end local v3    # "childNode":Lorg/w3c/dom/Node;
    .end local v5    # "name":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method public static slotTypeString(I)Ljava/lang/String;
    .locals 1
    .param p0, "tpc"    # I

    .prologue
    .line 481
    packed-switch p0, :pswitch_data_0

    .line 495
    const-string v0, ""

    :goto_0
    return-object v0

    .line 483
    :pswitch_0
    const-string v0, "preroll"

    goto :goto_0

    .line 485
    :pswitch_1
    const-string v0, "midroll"

    goto :goto_0

    .line 487
    :pswitch_2
    const-string v0, "postroll"

    goto :goto_0

    .line 489
    :pswitch_3
    const-string v0, "overlay"

    goto :goto_0

    .line 491
    :pswitch_4
    const-string v0, "display"

    goto :goto_0

    .line 493
    :pswitch_5
    const-string v0, "pause_midroll"

    goto :goto_0

    .line 481
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method


# virtual methods
.method public buildXMLElement()Ltv/freewheel/utils/XMLElement;
    .locals 1

    .prologue
    .line 152
    const/4 v0, 0x0

    return-object v0
.end method

.method protected buildXMLElement(Ltv/freewheel/utils/XMLElement;)Ltv/freewheel/utils/XMLElement;
    .locals 5
    .param p1, "node"    # Ltv/freewheel/utils/XMLElement;

    .prologue
    .line 90
    const-string v3, "slotProfile"

    iget-object v4, p0, Ltv/freewheel/ad/slot/Slot;->slotProfile:Ljava/lang/String;

    invoke-virtual {p1, v3, v4}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    const-string v3, "customId"

    iget-object v4, p0, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-virtual {p1, v3, v4}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->adUnit:Ljava/lang/String;

    const-string v4, "UNKNOWN"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 93
    const-string v3, "adUnit"

    iget-object v4, p0, Ltv/freewheel/ad/slot/Slot;->adUnit:Ljava/lang/String;

    invoke-virtual {p1, v3, v4}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    :cond_0
    const/4 v3, 0x0

    new-array v2, v3, [Ljava/lang/String;

    .line 96
    .local v2, "primaryContentTypes":[Ljava/lang/String;
    move-object v1, v2

    .line 97
    .local v1, "contentTypes":[Ljava/lang/String;
    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->acceptPrimaryContentType:Ljava/lang/String;

    if-eqz v3, :cond_1

    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->acceptPrimaryContentType:Ljava/lang/String;

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    :cond_1
    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->context:Ltv/freewheel/ad/AdContext;

    iget-object v3, v3, Ltv/freewheel/ad/AdContext;->playerProfile:Ljava/lang/String;

    if-eqz v3, :cond_2

    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->context:Ltv/freewheel/ad/AdContext;

    iget-object v3, v3, Ltv/freewheel/ad/AdContext;->playerProfile:Ljava/lang/String;

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    :cond_2
    iget v3, p0, Ltv/freewheel/ad/slot/Slot;->type:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_3

    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->context:Ltv/freewheel/ad/AdContext;

    iget-object v3, v3, Ltv/freewheel/ad/AdContext;->defaultVideoPlayerSlotProfile:Ljava/lang/String;

    if-eqz v3, :cond_4

    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->context:Ltv/freewheel/ad/AdContext;

    iget-object v3, v3, Ltv/freewheel/ad/AdContext;->defaultVideoPlayerSlotProfile:Ljava/lang/String;

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    :cond_3
    iget v3, p0, Ltv/freewheel/ad/slot/Slot;->type:I

    const/4 v4, 0x2

    if-ne v3, v4, :cond_5

    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->context:Ltv/freewheel/ad/AdContext;

    iget-object v3, v3, Ltv/freewheel/ad/AdContext;->defaultSiteSectionSlotProfile:Ljava/lang/String;

    if-eqz v3, :cond_4

    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->context:Ltv/freewheel/ad/AdContext;

    iget-object v3, v3, Ltv/freewheel/ad/AdContext;->defaultSiteSectionSlotProfile:Ljava/lang/String;

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 107
    :cond_4
    const-string v3, "text/html_doc_lit_mobile"

    iput-object v3, p0, Ltv/freewheel/ad/slot/Slot;->acceptPrimaryContentType:Ljava/lang/String;

    .line 109
    :cond_5
    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->acceptPrimaryContentType:Ljava/lang/String;

    if-eqz v3, :cond_6

    .line 110
    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->acceptPrimaryContentType:Ljava/lang/String;

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 112
    :cond_6
    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->acceptContentType:Ljava/lang/String;

    if-eqz v3, :cond_7

    .line 113
    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->acceptContentType:Ljava/lang/String;

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 115
    :cond_7
    array-length v3, v2

    if-gtz v3, :cond_8

    array-length v3, v1

    if-lez v3, :cond_9

    .line 116
    :cond_8
    invoke-static {v2, v1}, Ltv/freewheel/ad/slot/Slot;->buildContentTypeElement([Ljava/lang/String;[Ljava/lang/String;)Ltv/freewheel/utils/XMLElement;

    move-result-object v0

    .line 117
    .local v0, "child":Ltv/freewheel/utils/XMLElement;
    invoke-virtual {p1, v0}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    .line 120
    .end local v0    # "child":Ltv/freewheel/utils/XMLElement;
    :cond_9
    return-object p1
.end method

.method public copy()Ltv/freewheel/ad/slot/Slot;
    .locals 7

    .prologue
    .line 72
    const/4 v2, 0x0

    .line 74
    .local v2, "slot":Ltv/freewheel/ad/slot/Slot;
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    const-class v6, Ltv/freewheel/ad/AdContext;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    sget-object v6, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v6, v4, v5

    invoke-virtual {v3, v4}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v3

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Ltv/freewheel/ad/slot/Slot;->context:Ltv/freewheel/ad/AdContext;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    iget v6, p0, Ltv/freewheel/ad/slot/Slot;->type:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v3, v4}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    move-object v0, v3

    check-cast v0, Ltv/freewheel/ad/slot/Slot;

    move-object v2, v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 78
    :goto_0
    iget v3, p0, Ltv/freewheel/ad/slot/Slot;->width:I

    iput v3, v2, Ltv/freewheel/ad/slot/Slot;->width:I

    .line 79
    iget v3, p0, Ltv/freewheel/ad/slot/Slot;->height:I

    iput v3, v2, Ltv/freewheel/ad/slot/Slot;->height:I

    .line 80
    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    iput-object v3, v2, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    .line 81
    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->adUnit:Ljava/lang/String;

    iput-object v3, v2, Ltv/freewheel/ad/slot/Slot;->adUnit:Ljava/lang/String;

    .line 82
    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->slotProfile:Ljava/lang/String;

    iput-object v3, v2, Ltv/freewheel/ad/slot/Slot;->slotProfile:Ljava/lang/String;

    .line 83
    iget v3, p0, Ltv/freewheel/ad/slot/Slot;->timePositionClass:I

    iput v3, v2, Ltv/freewheel/ad/slot/Slot;->timePositionClass:I

    .line 84
    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->acceptContentType:Ljava/lang/String;

    iput-object v3, v2, Ltv/freewheel/ad/slot/Slot;->acceptContentType:Ljava/lang/String;

    .line 85
    iget-object v3, p0, Ltv/freewheel/ad/slot/Slot;->acceptPrimaryContentType:Ljava/lang/String;

    iput-object v3, v2, Ltv/freewheel/ad/slot/Slot;->acceptPrimaryContentType:Ljava/lang/String;

    .line 86
    return-object v2

    .line 75
    :catch_0
    move-exception v1

    .line 76
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method protected dispatchSlotEvent(Ljava/lang/String;)V
    .locals 3
    .param p1, "eventName"    # Ljava/lang/String;

    .prologue
    .line 393
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 394
    .local v0, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v1, "message"

    iget-object v2, p0, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 395
    const-string v1, "customId"

    iget-object v2, p0, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 396
    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->context:Ltv/freewheel/ad/AdContext;

    new-instance v2, Ltv/freewheel/utils/events/Event;

    invoke-direct {v2, p1, v0}, Ltv/freewheel/utils/events/Event;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-virtual {v1, v2}, Ltv/freewheel/ad/AdContext;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V

    .line 397
    return-void
.end method

.method protected findNextAdToWork(Ltv/freewheel/ad/AdInstance;)Ltv/freewheel/ad/AdInstance;
    .locals 4
    .param p1, "from"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    const/4 v0, 0x0

    .line 414
    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " findNextAdToWork() from:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 415
    if-nez p1, :cond_0

    .line 416
    invoke-direct {p0, v0}, Ltv/freewheel/ad/slot/Slot;->findNextPlayableAd(Ltv/freewheel/ad/AdInstance;)Ltv/freewheel/ad/AdInstance;

    move-result-object v0

    .line 434
    :goto_0
    return-object v0

    .line 418
    :cond_0
    iget-object v1, p1, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    if-eq v1, p0, :cond_1

    .line 419
    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "findNextAdToWork() AdInstance "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " does not belong to slot "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0

    .line 423
    :cond_1
    const/4 v0, 0x0

    .line 424
    .local v0, "next":Ltv/freewheel/ad/AdInstance;
    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->state:Ltv/freewheel/ad/state/SlotState;

    iget-object v2, p1, Ltv/freewheel/ad/AdInstance;->adChain:Ltv/freewheel/ad/AdChain;

    invoke-virtual {v2}, Ltv/freewheel/ad/AdChain;->relatedSlotState()Ltv/freewheel/ad/state/SlotState;

    move-result-object v2

    if-ne v1, v2, :cond_3

    .line 425
    iget-object v1, p1, Ltv/freewheel/ad/AdInstance;->adChain:Ltv/freewheel/ad/AdChain;

    invoke-virtual {v1, p1}, Ltv/freewheel/ad/AdChain;->isChainStopper(Ltv/freewheel/ad/AdInstance;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 426
    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " findNextAdToWork() met chain stopper "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 427
    iget-object v1, p1, Ltv/freewheel/ad/AdInstance;->adChain:Ltv/freewheel/ad/AdChain;

    invoke-virtual {v1}, Ltv/freewheel/ad/AdChain;->getLastAdInstanceInChain()Ltv/freewheel/ad/AdInstance;

    move-result-object p1

    .line 429
    :cond_2
    invoke-direct {p0, p1}, Ltv/freewheel/ad/slot/Slot;->findNextPlayableAd(Ltv/freewheel/ad/AdInstance;)Ltv/freewheel/ad/AdInstance;

    move-result-object v0

    .line 433
    :goto_1
    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "findNextAdToWork() returning "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 431
    :cond_3
    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "findNextAdToWork() slot state is not "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p1, Ltv/freewheel/ad/AdInstance;->adChain:Ltv/freewheel/ad/AdChain;

    invoke-virtual {v3}, Ltv/freewheel/ad/AdChain;->relatedSlotState()Ltv/freewheel/ad/state/SlotState;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", so won\'t continue"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public getAdInstances()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/interfaces/IAdInstance;",
            ">;"
        }
    .end annotation

    .prologue
    .line 358
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    return-object v0
.end method

.method public getAdInstancesInPlayPlan()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/AdInstance;",
            ">;"
        }
    .end annotation

    .prologue
    .line 383
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/slot/Slot;->getAdInstancesInPlayPlan(Z)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public getAdInstancesInPlayPlan(Z)Ljava/util/ArrayList;
    .locals 9
    .param p1, "withTranslator"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/AdInstance;",
            ">;"
        }
    .end annotation

    .prologue
    .line 362
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 363
    .local v5, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/AdInstance;>;"
    const/4 v2, 0x0

    .line 364
    .local v2, "foundPlayable":Z
    iget-object v6, p0, Ltv/freewheel/ad/slot/Slot;->adChains:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/ad/AdChain;

    .line 365
    .local v1, "adChain":Ltv/freewheel/ad/AdChain;
    iget-object v6, v1, Ltv/freewheel/ad/AdChain;->adInstances:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/ad/AdInstance;

    .line 366
    .local v0, "ad":Ltv/freewheel/ad/AdInstance;
    if-nez v2, :cond_1

    invoke-virtual {v0}, Ltv/freewheel/ad/AdInstance;->isPlayable()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 367
    iget-boolean v6, v0, Ltv/freewheel/ad/AdInstance;->scheduledDrivingAd:Z

    if-nez v6, :cond_1

    .line 368
    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 369
    const/4 v2, 0x1

    .line 372
    :cond_1
    if-eqz p1, :cond_0

    iget-boolean v6, v0, Ltv/freewheel/ad/AdInstance;->scheduledDrivingAd:Z

    if-eqz v6, :cond_0

    .line 373
    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 376
    .end local v0    # "ad":Ltv/freewheel/ad/AdInstance;
    :cond_2
    const/4 v2, 0x0

    .line 377
    goto :goto_0

    .line 378
    .end local v1    # "adChain":Ltv/freewheel/ad/AdChain;
    .end local v4    # "i$":Ljava/util/Iterator;
    :cond_3
    iget-object v6, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " getAdInstancesInPlayPlan() withTranslator:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", returning "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 379
    return-object v5
.end method

.method public getBase()Landroid/view/ViewGroup;
    .locals 1

    .prologue
    .line 353
    const/4 v0, 0x0

    return-object v0
.end method

.method public getCustomId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 205
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    return-object v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 233
    iget v0, p0, Ltv/freewheel/ad/slot/Slot;->height:I

    return v0
.end method

.method public getTimePosition()D
    .locals 2

    .prologue
    .line 213
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    return-wide v0
.end method

.method public getTimePositionClass()I
    .locals 1

    .prologue
    .line 217
    iget v0, p0, Ltv/freewheel/ad/slot/Slot;->timePositionClass:I

    return v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 209
    iget v0, p0, Ltv/freewheel/ad/slot/Slot;->type:I

    return v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 229
    iget v0, p0, Ltv/freewheel/ad/slot/Slot;->width:I

    return v0
.end method

.method public init(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "customId"    # Ljava/lang/String;
    .param p2, "adUnit"    # Ljava/lang/String;
    .param p3, "slotProfile"    # Ljava/lang/String;
    .param p4, "acceptContentType"    # Ljava/lang/String;
    .param p5, "acceptPrimaryContentType"    # Ljava/lang/String;

    .prologue
    .line 60
    iput-object p1, p0, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    .line 61
    iput-object p2, p0, Ltv/freewheel/ad/slot/Slot;->adUnit:Ljava/lang/String;

    .line 62
    iput-object p3, p0, Ltv/freewheel/ad/slot/Slot;->slotProfile:Ljava/lang/String;

    .line 63
    iput-object p4, p0, Ltv/freewheel/ad/slot/Slot;->acceptContentType:Ljava/lang/String;

    .line 64
    iput-object p5, p0, Ltv/freewheel/ad/slot/Slot;->acceptPrimaryContentType:Ljava/lang/String;

    .line 65
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->adUnit:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 66
    const-string v0, "UNKNOWN"

    iput-object v0, p0, Ltv/freewheel/ad/slot/Slot;->adUnit:Ljava/lang/String;

    .line 68
    :cond_0
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->adUnit:Ljava/lang/String;

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/slot/Slot;->setTimePositionClass(Ljava/lang/String;)V

    .line 69
    return-void
.end method

.method public isPauseMidroll()Z
    .locals 2

    .prologue
    .line 400
    iget v0, p0, Ltv/freewheel/ad/slot/Slot;->timePositionClass:I

    const/4 v1, 0x6

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public notifyAdDone(Ltv/freewheel/ad/AdInstance;)V
    .locals 4
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 460
    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " notifyAdDone() "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 461
    invoke-virtual {p0, p1}, Ltv/freewheel/ad/slot/Slot;->findNextAdToWork(Ltv/freewheel/ad/AdInstance;)Ltv/freewheel/ad/AdInstance;

    move-result-object v0

    .line 462
    .local v0, "nextAd":Ltv/freewheel/ad/AdInstance;
    if-eqz v0, :cond_2

    .line 463
    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " notifyAdDone() found next ad "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 464
    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->state:Ltv/freewheel/ad/state/SlotState;

    invoke-static {}, Ltv/freewheel/ad/state/SlotPreloadingState;->Instance()Ltv/freewheel/ad/state/SlotState;

    move-result-object v2

    if-ne v1, v2, :cond_1

    .line 465
    invoke-virtual {v0}, Ltv/freewheel/ad/AdInstance;->preload()V

    .line 478
    :cond_0
    :goto_0
    return-void

    .line 466
    :cond_1
    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->state:Ltv/freewheel/ad/state/SlotState;

    invoke-static {}, Ltv/freewheel/ad/state/SlotPlayingState;->Instance()Ltv/freewheel/ad/state/SlotState;

    move-result-object v2

    if-ne v1, v2, :cond_0

    .line 467
    iput-object v0, p0, Ltv/freewheel/ad/slot/Slot;->currentPlayingAdInstance:Ltv/freewheel/ad/AdInstance;

    .line 468
    invoke-virtual {v0}, Ltv/freewheel/ad/AdInstance;->play()V

    goto :goto_0

    .line 471
    :cond_2
    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " notifyAdDone() no more ad to work on"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 472
    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->state:Ltv/freewheel/ad/state/SlotState;

    invoke-static {}, Ltv/freewheel/ad/state/SlotPreloadingState;->Instance()Ltv/freewheel/ad/state/SlotState;

    move-result-object v2

    if-ne v1, v2, :cond_3

    .line 473
    const-string v1, "slotPreloaded"

    invoke-virtual {p0, v1}, Ltv/freewheel/ad/slot/Slot;->dispatchSlotEvent(Ljava/lang/String;)V

    goto :goto_0

    .line 474
    :cond_3
    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->state:Ltv/freewheel/ad/state/SlotState;

    invoke-static {}, Ltv/freewheel/ad/state/SlotPlayingState;->Instance()Ltv/freewheel/ad/state/SlotState;

    move-result-object v2

    if-eq v1, v2, :cond_4

    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->state:Ltv/freewheel/ad/state/SlotState;

    invoke-static {}, Ltv/freewheel/ad/state/SlotPauseState;->Instance()Ltv/freewheel/ad/state/SlotState;

    move-result-object v2

    if-eq v1, v2, :cond_4

    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->state:Ltv/freewheel/ad/state/SlotState;

    invoke-static {}, Ltv/freewheel/ad/state/SlotEndedState;->Instance()Ltv/freewheel/ad/state/SlotState;

    move-result-object v2

    if-ne v1, v2, :cond_0

    :cond_4
    iget-object v1, p1, Ltv/freewheel/ad/AdInstance;->adChain:Ltv/freewheel/ad/AdChain;

    invoke-virtual {v1}, Ltv/freewheel/ad/AdChain;->relatedSlotState()Ltv/freewheel/ad/state/SlotState;

    move-result-object v1

    invoke-static {}, Ltv/freewheel/ad/state/SlotPlayingState;->Instance()Ltv/freewheel/ad/state/SlotState;

    move-result-object v2

    if-ne v1, v2, :cond_0

    .line 475
    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->state:Ltv/freewheel/ad/state/SlotState;

    invoke-virtual {v1, p0}, Ltv/freewheel/ad/state/SlotState;->complete(Ltv/freewheel/ad/slot/Slot;)V

    goto :goto_0
.end method

.method public onComplete()V
    .locals 2

    .prologue
    .line 387
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onComplete"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    .line 388
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/ad/slot/Slot;->currentPlayingAdInstance:Ltv/freewheel/ad/AdInstance;

    .line 389
    const-string v0, "slotEnded"

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/slot/Slot;->dispatchSlotEvent(Ljava/lang/String;)V

    .line 390
    return-void
.end method

.method public onResumePlay()V
    .locals 2

    .prologue
    .line 303
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onResumePlay"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    .line 304
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->currentPlayingAdInstance:Ltv/freewheel/ad/AdInstance;

    if-eqz v0, :cond_0

    .line 305
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->currentPlayingAdInstance:Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v0}, Ltv/freewheel/ad/AdInstance;->resume()V

    .line 307
    :cond_0
    return-void
.end method

.method public onStartPlay()V
    .locals 2

    .prologue
    .line 278
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onStartPlay"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    .line 279
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->callbackHandler:Ltv/freewheel/ad/handler/SlotImpressionCallbackHandler;

    if-eqz v0, :cond_0

    .line 280
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->callbackHandler:Ltv/freewheel/ad/handler/SlotImpressionCallbackHandler;

    invoke-virtual {v0}, Ltv/freewheel/ad/handler/SlotImpressionCallbackHandler;->send()V

    .line 282
    :cond_0
    const-string v0, "slotStarted"

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/slot/Slot;->dispatchSlotEvent(Ljava/lang/String;)V

    .line 284
    invoke-virtual {p0}, Ltv/freewheel/ad/slot/Slot;->playAd()V

    .line 285
    return-void
.end method

.method public onStopPlay()V
    .locals 2

    .prologue
    .line 288
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onStopPlay"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    .line 290
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->currentPlayingAdInstance:Ltv/freewheel/ad/AdInstance;

    if-eqz v0, :cond_0

    .line 291
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->currentPlayingAdInstance:Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v0}, Ltv/freewheel/ad/AdInstance;->stop()V

    .line 293
    :cond_0
    return-void
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 7
    .param p1, "node"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    .line 156
    const-string v4, "customId"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    .line 157
    const-string v4, "adUnit"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/ad/slot/Slot;->adUnit:Ljava/lang/String;

    .line 159
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 160
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v4

    if-ge v2, v4, :cond_3

    .line 161
    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 162
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_0

    .line 163
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    .line 165
    .local v3, "name":Ljava/lang/String;
    const-string v4, "selectedAds"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 166
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-direct {p0, v1}, Ltv/freewheel/ad/slot/Slot;->parseSelectedAds(Lorg/w3c/dom/Element;)V

    .line 160
    .end local v3    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 167
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    .restart local v3    # "name":Ljava/lang/String;
    :cond_1
    const-string v4, "eventCallbacks"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 168
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {p0, v1}, Ltv/freewheel/ad/slot/Slot;->parseEventCallbacks(Lorg/w3c/dom/Element;)V

    .line 170
    const-string v4, "slotImpression"

    const-string v5, "IMPRESSION"

    const/4 v6, 0x0

    invoke-virtual {p0, v4, v5, v6}, Ltv/freewheel/ad/slot/Slot;->createEventHandler(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v4

    check-cast v4, Ltv/freewheel/ad/handler/SlotImpressionCallbackHandler;

    iput-object v4, p0, Ltv/freewheel/ad/slot/Slot;->callbackHandler:Ltv/freewheel/ad/handler/SlotImpressionCallbackHandler;

    .line 174
    iget-object v4, p0, Ltv/freewheel/ad/slot/Slot;->callbackHandler:Ltv/freewheel/ad/handler/SlotImpressionCallbackHandler;

    invoke-virtual {v4, p0}, Ltv/freewheel/ad/handler/SlotImpressionCallbackHandler;->setSlot(Ltv/freewheel/ad/slot/Slot;)V

    goto :goto_1

    .line 176
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    :cond_2
    iget-object v4, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

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

    .line 180
    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    .end local v3    # "name":Ljava/lang/String;
    :cond_3
    return-void
.end method

.method public play()V
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->state:Ltv/freewheel/ad/state/SlotState;

    invoke-virtual {v0, p0}, Ltv/freewheel/ad/state/SlotState;->play(Ltv/freewheel/ad/slot/Slot;)V

    .line 267
    return-void
.end method

.method public playAd()V
    .locals 2

    .prologue
    .line 310
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "playAd"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    .line 311
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/slot/Slot;->findNextAdToWork(Ltv/freewheel/ad/AdInstance;)Ltv/freewheel/ad/AdInstance;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/slot/Slot;->currentPlayingAdInstance:Ltv/freewheel/ad/AdInstance;

    .line 313
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->currentPlayingAdInstance:Ltv/freewheel/ad/AdInstance;

    if-eqz v0, :cond_0

    .line 314
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->currentPlayingAdInstance:Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v0}, Ltv/freewheel/ad/AdInstance;->play()V

    .line 319
    :goto_0
    return-void

    .line 316
    :cond_0
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "no playable ad"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 317
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->state:Ltv/freewheel/ad/state/SlotState;

    invoke-virtual {v0, p0}, Ltv/freewheel/ad/state/SlotState;->complete(Ltv/freewheel/ad/slot/Slot;)V

    goto :goto_0
.end method

.method protected setTimePositionClass(Ljava/lang/String;)V
    .locals 0
    .param p1, "adUnit"    # Ljava/lang/String;

    .prologue
    .line 149
    return-void
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 274
    iget-object v0, p0, Ltv/freewheel/ad/slot/Slot;->state:Ltv/freewheel/ad/state/SlotState;

    invoke-virtual {v0, p0}, Ltv/freewheel/ad/state/SlotState;->stop(Ltv/freewheel/ad/slot/Slot;)V

    .line 275
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 331
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[Slot:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", timePositionClass: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Ltv/freewheel/ad/slot/Slot;->timePositionClass:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", state: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/ad/slot/Slot;->state:Ltv/freewheel/ad/state/SlotState;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
