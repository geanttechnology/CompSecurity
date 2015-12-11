.class public Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
.super Ltv/freewheel/hybrid/ad/slot/Slot;
.source "NonTemporalSlot.java"


# instance fields
.field public acceptCompanion:Z

.field public compatibleDimensions:Ljava/lang/String;

.field private hasPendingCompanion:Z

.field private holdsCompanionAd:Z

.field public initialAdOption:I


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/ad/AdContext;I)V
    .locals 1
    .param p1, "context"    # Ltv/freewheel/hybrid/ad/AdContext;
    .param p2, "type"    # I

    .prologue
    const/4 v0, 0x0

    .line 25
    invoke-direct {p0, p1, p2}, Ltv/freewheel/hybrid/ad/slot/Slot;-><init>(Ltv/freewheel/hybrid/ad/AdContext;I)V

    .line 18
    iput-boolean v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->holdsCompanionAd:Z

    .line 22
    iput-boolean v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->hasPendingCompanion:Z

    .line 26
    return-void
.end method


# virtual methods
.method public buildXMLElement()Ltv/freewheel/hybrid/utils/XMLElement;
    .locals 8

    .prologue
    const/16 v7, 0x8

    const/4 v6, 0x5

    const/4 v5, 0x4

    const/4 v4, 0x2

    const/4 v3, 0x1

    .line 52
    new-instance v0, Ltv/freewheel/hybrid/utils/XMLElement;

    const-string v1, "nonTemporalAdSlot"

    invoke-direct {v0, v1}, Ltv/freewheel/hybrid/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 53
    .local v0, "node":Ltv/freewheel/hybrid/utils/XMLElement;
    invoke-super {p0, v0}, Ltv/freewheel/hybrid/ad/slot/Slot;->buildXMLElement(Ltv/freewheel/hybrid/utils/XMLElement;)Ltv/freewheel/hybrid/utils/XMLElement;

    .line 54
    const-string v1, "width"

    iget v2, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->width:I

    invoke-virtual {v0, v1, v2, v3}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;IZ)V

    .line 55
    const-string v1, "height"

    iget v2, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->height:I

    invoke-virtual {v0, v1, v2, v3}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;IZ)V

    .line 56
    const-string v1, "compatibleDimensions"

    iget-object v2, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->compatibleDimensions:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    const-string v1, "acceptCompanion"

    iget-boolean v2, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->acceptCompanion:Z

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;Z)V

    .line 59
    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->initialAdOption:I

    if-eq v1, v3, :cond_0

    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->initialAdOption:I

    if-ne v1, v4, :cond_1

    .line 61
    :cond_0
    const-string v1, "noInitial"

    invoke-virtual {v0, v1, v3}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;Z)V

    .line 63
    :cond_1
    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->initialAdOption:I

    if-eq v1, v4, :cond_2

    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->initialAdOption:I

    const/4 v2, 0x3

    if-eq v1, v2, :cond_2

    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->initialAdOption:I

    if-eq v1, v5, :cond_2

    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->initialAdOption:I

    if-eq v1, v6, :cond_2

    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->initialAdOption:I

    if-ne v1, v7, :cond_3

    .line 68
    :cond_2
    const-string v1, "firstCompanionAsInitial"

    invoke-virtual {v0, v1, v3}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;Z)V

    .line 70
    :cond_3
    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->initialAdOption:I

    if-ne v1, v5, :cond_4

    .line 71
    const-string v1, "noInitialIfCompanion"

    invoke-virtual {v0, v1, v3}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;Z)V

    .line 73
    :cond_4
    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->initialAdOption:I

    const/4 v2, 0x6

    if-eq v1, v2, :cond_5

    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->initialAdOption:I

    if-ne v1, v6, :cond_6

    .line 75
    :cond_5
    const-string v1, "noStandalone"

    invoke-virtual {v0, v1, v3}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;Z)V

    .line 77
    :cond_6
    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->initialAdOption:I

    const/4 v2, 0x7

    if-eq v1, v2, :cond_7

    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->initialAdOption:I

    if-ne v1, v7, :cond_8

    .line 79
    :cond_7
    const-string v1, "noStandaloneIfTemporal"

    invoke-virtual {v0, v1, v3}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;Z)V

    .line 82
    :cond_8
    return-object v0
.end method

.method public copy()Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    .locals 2

    .prologue
    .line 38
    invoke-super {p0}, Ltv/freewheel/hybrid/ad/slot/Slot;->copy()Ltv/freewheel/hybrid/ad/slot/Slot;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;

    .line 39
    .local v0, "slot":Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;
    iget-boolean v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->acceptCompanion:Z

    iput-boolean v1, v0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->acceptCompanion:Z

    .line 40
    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->initialAdOption:I

    iput v1, v0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->initialAdOption:I

    .line 41
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->compatibleDimensions:Ljava/lang/String;

    iput-object v1, v0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->compatibleDimensions:Ljava/lang/String;

    .line 42
    return-object v0
.end method

.method public bridge synthetic copy()Ltv/freewheel/hybrid/ad/slot/Slot;
    .locals 1

    .prologue
    .line 10
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->copy()Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;

    move-result-object v0

    return-object v0
.end method

.method protected dispatchSlotEvent(Ljava/lang/String;)V
    .locals 1
    .param p1, "eventName"    # Ljava/lang/String;

    .prologue
    .line 135
    iget-boolean v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->holdsCompanionAd:Z

    if-nez v0, :cond_0

    .line 136
    invoke-super {p0, p1}, Ltv/freewheel/hybrid/ad/slot/Slot;->dispatchSlotEvent(Ljava/lang/String;)V

    .line 138
    :cond_0
    return-void
.end method

.method public getAdInstances()Ljava/util/ArrayList;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;",
            ">;"
        }
    .end annotation

    .prologue
    .line 193
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 196
    .local v2, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;>;"
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->currentPlayingAdInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    if-eqz v3, :cond_1

    .line 197
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->currentPlayingAdInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 205
    :cond_0
    return-object v2

    .line 201
    :cond_1
    const/4 v3, 0x1

    invoke-virtual {p0, v3}, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->getAdInstancesInPlayPlan(Z)Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/AdInstance;

    .line 202
    .local v0, "adi":Ltv/freewheel/hybrid/ad/AdInstance;
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public getBase()Landroid/view/ViewGroup;
    .locals 6

    .prologue
    .line 96
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->displayBase:Landroid/view/ViewGroup;

    if-nez v0, :cond_0

    .line 97
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/AdContext;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_1

    .line 98
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "host activity is null, can not create slot base"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    .line 105
    :cond_0
    :goto_0
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->displayBase:Landroid/view/ViewGroup;

    return-object v0

    .line 100
    :cond_1
    new-instance v0, Landroid/widget/RelativeLayout;

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/ad/AdContext;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->displayBase:Landroid/view/ViewGroup;

    .line 101
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->displayBase:Landroid/view/ViewGroup;

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v2

    const-wide v4, 0x4197d78400000000L    # 1.0E8

    mul-double/2addr v2, v4

    double-to-int v1, v2

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setId(I)V

    goto :goto_0
.end method

.method public getHeight()I
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 175
    iget v2, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->height:I

    if-lez v2, :cond_1

    .line 176
    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->height:I

    .line 187
    :cond_0
    :goto_0
    return v1

    .line 179
    :cond_1
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->currentPlayingAdInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    if-eqz v2, :cond_0

    .line 180
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->currentPlayingAdInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/AdInstance;->getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/CreativeRendition;

    move-result-object v0

    .line 181
    .local v0, "cr":Ltv/freewheel/hybrid/ad/CreativeRendition;
    if-eqz v0, :cond_0

    .line 182
    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/CreativeRendition;->getHeight()I

    move-result v1

    goto :goto_0
.end method

.method public getWidth()I
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 157
    iget v2, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->width:I

    if-lez v2, :cond_1

    .line 158
    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->width:I

    .line 169
    :cond_0
    :goto_0
    return v1

    .line 161
    :cond_1
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->currentPlayingAdInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    if-eqz v2, :cond_0

    .line 162
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->currentPlayingAdInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/AdInstance;->getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/CreativeRendition;

    move-result-object v0

    .line 163
    .local v0, "cr":Ltv/freewheel/hybrid/ad/CreativeRendition;
    if-eqz v0, :cond_0

    .line 164
    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/CreativeRendition;->getWidth()I

    move-result v1

    goto :goto_0
.end method

.method public init(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    .locals 7
    .param p1, "customId"    # Ljava/lang/String;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .param p4, "slotProfile"    # Ljava/lang/String;
    .param p5, "adUnit"    # Ljava/lang/String;
    .param p6, "acceptCompanion"    # Z
    .param p7, "acceptPrimaryContentType"    # Ljava/lang/String;
    .param p8, "acceptContentType"    # Ljava/lang/String;
    .param p9, "initialAdOption"    # I
    .param p10, "compatibleDimensions"    # Ljava/lang/String;

    .prologue
    .line 29
    move-object v1, p0

    move-object v2, p1

    move-object v3, p5

    move-object v4, p4

    move-object v5, p8

    move-object v6, p7

    invoke-super/range {v1 .. v6}, Ltv/freewheel/hybrid/ad/slot/Slot;->init(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 30
    iput p2, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->width:I

    .line 31
    iput p3, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->height:I

    .line 32
    iput-boolean p6, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->acceptCompanion:Z

    .line 33
    move/from16 v0, p9

    iput v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->initialAdOption:I

    .line 34
    move-object/from16 v0, p10

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->compatibleDimensions:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public onComplete()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 142
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onComplete"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    .line 143
    invoke-super {p0}, Ltv/freewheel/hybrid/ad/slot/Slot;->onComplete()V

    .line 144
    iget-boolean v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->hasPendingCompanion:Z

    if-eqz v0, :cond_0

    .line 145
    const/4 v0, 0x1

    iput-boolean v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->holdsCompanionAd:Z

    .line 146
    iput-boolean v2, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->hasPendingCompanion:Z

    .line 147
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->play()V

    .line 149
    :cond_0
    iget-boolean v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->requestContentPause:Z

    if-eqz v0, :cond_1

    .line 150
    iput-boolean v2, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->requestContentPause:Z

    .line 151
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/AdContext;->requestContentResume(Ltv/freewheel/hybrid/ad/slot/Slot;)V

    .line 153
    :cond_1
    return-void
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 2
    .param p1, "node"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 87
    iget v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->width:I

    if-gtz v0, :cond_0

    iget v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->height:I

    if-gtz v0, :cond_0

    .line 88
    const-string v0, "width"

    invoke-interface {p1, v0}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v1}, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->tryParseInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->width:I

    .line 89
    const-string v0, "height"

    invoke-interface {p1, v0}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v1}, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->tryParseInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->height:I

    .line 91
    :cond_0
    invoke-super {p0, p1}, Ltv/freewheel/hybrid/ad/slot/Slot;->parse(Lorg/w3c/dom/Element;)V

    .line 92
    return-void
.end method

.method public play()V
    .locals 2

    .prologue
    .line 110
    :goto_0
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->adChains:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_0

    .line 111
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->adChains:Ljava/util/ArrayList;

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->adChains:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    goto :goto_0

    .line 113
    :cond_0
    invoke-super {p0}, Ltv/freewheel/hybrid/ad/slot/Slot;->play()V

    .line 114
    return-void
.end method

.method public playCompanionAdInstance(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 4
    .param p1, "adInstance"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    const/4 v3, 0x1

    .line 117
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " playCompanionAdInstance("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 119
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->adChain:Ltv/freewheel/hybrid/ad/AdChain;

    if-nez v0, :cond_0

    .line 120
    new-instance v0, Ltv/freewheel/hybrid/ad/AdChain;

    invoke-direct {v0, p1}, Ltv/freewheel/hybrid/ad/AdChain;-><init>(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 122
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->adChains:Ljava/util/ArrayList;

    const/4 v1, 0x0

    iget-object v2, p1, Ltv/freewheel/hybrid/ad/AdInstance;->adChain:Ltv/freewheel/hybrid/ad/AdChain;

    invoke-virtual {v0, v1, v2}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 124
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->currentPlayingAdInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    if-eqz v0, :cond_1

    .line 125
    iput-boolean v3, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->hasPendingCompanion:Z

    .line 126
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->stop()V

    .line 131
    :goto_0
    return-void

    .line 128
    :cond_1
    iput-boolean v3, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->holdsCompanionAd:Z

    .line 129
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->play()V

    goto :goto_0
.end method

.method protected setTimePositionClass(Ljava/lang/String;)V
    .locals 1
    .param p1, "adUnit"    # Ljava/lang/String;

    .prologue
    .line 47
    const/4 v0, 0x5

    iput v0, p0, Ltv/freewheel/hybrid/ad/slot/NonTemporalSlot;->timePositionClass:I

    .line 48
    return-void
.end method
