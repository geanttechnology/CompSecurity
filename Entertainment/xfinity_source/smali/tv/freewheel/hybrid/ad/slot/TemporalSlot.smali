.class public Ltv/freewheel/hybrid/ad/slot/TemporalSlot;
.super Ltv/freewheel/hybrid/ad/slot/Slot;
.source "TemporalSlot.java"


# instance fields
.field public cuePointSequence:I

.field public embeddedAdsDuration:D

.field public endTimePosition:D

.field public maxDuration:D

.field public minDuration:D

.field public timePosition:D


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/ad/AdContext;I)V
    .locals 0
    .param p1, "context"    # Ltv/freewheel/hybrid/ad/AdContext;
    .param p2, "type"    # I

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Ltv/freewheel/hybrid/ad/slot/Slot;-><init>(Ltv/freewheel/hybrid/ad/AdContext;I)V

    .line 26
    return-void
.end method


# virtual methods
.method public buildXMLElement()Ltv/freewheel/hybrid/utils/XMLElement;
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 71
    new-instance v0, Ltv/freewheel/hybrid/utils/XMLElement;

    const-string v1, "temporalAdSlot"

    invoke-direct {v0, v1}, Ltv/freewheel/hybrid/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 72
    .local v0, "node":Ltv/freewheel/hybrid/utils/XMLElement;
    invoke-super {p0, v0}, Ltv/freewheel/hybrid/ad/slot/Slot;->buildXMLElement(Ltv/freewheel/hybrid/utils/XMLElement;)Ltv/freewheel/hybrid/utils/XMLElement;

    .line 73
    const-string v1, "timePosition"

    iget-wide v2, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePosition:D

    invoke-virtual {v0, v1, v2, v3}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;D)V

    .line 75
    const-string v1, "maxSlotDuration"

    iget-wide v2, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->maxDuration:D

    invoke-virtual {v0, v1, v2, v3, v4}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;DZ)V

    .line 77
    const-string v1, "minSlotDuration"

    iget-wide v2, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->minDuration:D

    invoke-virtual {v0, v1, v2, v3, v4}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;DZ)V

    .line 79
    const-string v1, "cuePointSequence"

    iget v2, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->cuePointSequence:I

    invoke-virtual {v0, v1, v2, v4}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;IZ)V

    .line 82
    return-object v0
.end method

.method public bridge synthetic copy()Ltv/freewheel/hybrid/ad/slot/Slot;
    .locals 1

    .prologue
    .line 16
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->copy()Ltv/freewheel/hybrid/ad/slot/TemporalSlot;

    move-result-object v0

    return-object v0
.end method

.method public copy()Ltv/freewheel/hybrid/ad/slot/TemporalSlot;
    .locals 4

    .prologue
    .line 45
    invoke-super {p0}, Ltv/freewheel/hybrid/ad/slot/Slot;->copy()Ltv/freewheel/hybrid/ad/slot/Slot;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;

    .line 46
    .local v0, "slot":Ltv/freewheel/hybrid/ad/slot/TemporalSlot;
    iget-wide v2, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePosition:D

    iput-wide v2, v0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePosition:D

    .line 47
    iget v1, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->cuePointSequence:I

    iput v1, v0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->cuePointSequence:I

    .line 48
    iget-wide v2, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->maxDuration:D

    iput-wide v2, v0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->maxDuration:D

    .line 49
    return-object v0
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
    .line 171
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 173
    .local v2, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;>;"
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->getAdInstancesInPlayPlan()Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 174
    .local v1, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/AdInstance;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 175
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/AdInstance;

    .line 176
    .local v0, "ad":Ltv/freewheel/hybrid/ad/AdInstance;
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 178
    .end local v0    # "ad":Ltv/freewheel/hybrid/ad/AdInstance;
    :cond_0
    return-object v2
.end method

.method public getBase()Landroid/view/ViewGroup;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/AdContext;->getTemporalSlotBase()Landroid/widget/FrameLayout;

    move-result-object v0

    return-object v0
.end method

.method public getHeight()I
    .locals 3

    .prologue
    const/4 v1, -0x1

    .line 151
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/AdContext;->getTemporalSlotBase()Landroid/widget/FrameLayout;

    move-result-object v0

    .line 152
    .local v0, "slotBase":Landroid/widget/FrameLayout;
    if-eqz v0, :cond_0

    .line 153
    invoke-virtual {v0}, Landroid/widget/FrameLayout;->getHeight()I

    move-result v2

    if-lez v2, :cond_0

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->getHeight()I

    move-result v1

    .line 155
    :cond_0
    return v1
.end method

.method public getTimePosition()D
    .locals 2

    .prologue
    .line 104
    iget-wide v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePosition:D

    return-wide v0
.end method

.method public getWidth()I
    .locals 3

    .prologue
    const/4 v1, -0x1

    .line 161
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/AdContext;->getTemporalSlotBase()Landroid/widget/FrameLayout;

    move-result-object v0

    .line 162
    .local v0, "slotBase":Landroid/widget/FrameLayout;
    if-eqz v0, :cond_0

    .line 163
    invoke-virtual {v0}, Landroid/widget/FrameLayout;->getWidth()I

    move-result v2

    if-lez v2, :cond_0

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->getWidth()I

    move-result v1

    .line 165
    :cond_0
    return v1
.end method

.method public onComplete()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 131
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onComplete"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    .line 132
    iget v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePositionClass:I

    const/4 v1, 0x6

    if-ne v0, v1, :cond_1

    .line 133
    iput-boolean v2, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->requestContentPause:Z

    .line 141
    :cond_0
    :goto_0
    invoke-super {p0}, Ltv/freewheel/hybrid/ad/slot/Slot;->onComplete()V

    .line 142
    return-void

    .line 134
    :cond_1
    iget v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePositionClass:I

    const/4 v1, 0x4

    if-eq v0, v1, :cond_2

    .line 135
    iput-boolean v2, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->requestContentPause:Z

    .line 136
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/AdContext;->requestContentResume(Ltv/freewheel/hybrid/ad/slot/Slot;)V

    goto :goto_0

    .line 137
    :cond_2
    iget-boolean v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->requestContentPause:Z

    if-eqz v0, :cond_0

    .line 138
    iput-boolean v2, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->requestContentPause:Z

    .line 139
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/AdContext;->requestContentResume(Ltv/freewheel/hybrid/ad/slot/Slot;)V

    goto :goto_0
.end method

.method public onStartPlay()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 119
    iget v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePositionClass:I

    const/4 v1, 0x4

    if-eq v0, v1, :cond_0

    .line 120
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/AdContext;->requestContentPause(Ltv/freewheel/hybrid/ad/slot/Slot;)V

    .line 121
    iput-boolean v2, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->requestContentPause:Z

    .line 123
    :cond_0
    iget v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePositionClass:I

    const/4 v1, 0x6

    if-ne v0, v1, :cond_1

    .line 124
    iput-boolean v2, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->requestContentPause:Z

    .line 126
    :cond_1
    invoke-super {p0}, Ltv/freewheel/hybrid/ad/slot/Slot;->onStartPlay()V

    .line 127
    return-void
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 10
    .param p1, "node"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    const-wide/high16 v6, -0x4010000000000000L    # -1.0

    .line 87
    const-string v5, "timePosition"

    invoke-interface {p1, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->tryParseDouble(Ljava/lang/String;)D

    move-result-wide v8

    iput-wide v8, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePosition:D

    .line 89
    const-string v5, "embeddedAdsDuration"

    invoke-interface {p1, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, v6, v7}, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->tryParseDouble(Ljava/lang/String;D)D

    move-result-wide v0

    .line 91
    .local v0, "parsedEmbeddedAdsDuration":D
    const-wide/16 v8, 0x0

    cmpl-double v5, v0, v8

    if-ltz v5, :cond_0

    .end local v0    # "parsedEmbeddedAdsDuration":D
    :goto_0
    iput-wide v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->embeddedAdsDuration:D

    .line 92
    const-string v5, "endTimePosition"

    invoke-interface {p1, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, v6, v7}, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->tryParseDouble(Ljava/lang/String;D)D

    move-result-wide v2

    .line 93
    .local v2, "parsedEndTimePosition":D
    iget-wide v8, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePosition:D

    cmpl-double v5, v2, v8

    if-ltz v5, :cond_1

    .end local v2    # "parsedEndTimePosition":D
    :goto_1
    iput-wide v2, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->endTimePosition:D

    .line 94
    const-string v5, "cuePointSequence"

    invoke-interface {p1, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->tryParseInt(Ljava/lang/String;)I

    move-result v5

    iput v5, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->cuePointSequence:I

    .line 96
    const-string v5, "timePositionClass"

    invoke-interface {p1, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v4

    .line 98
    .local v4, "timePositionClassStr":Ljava/lang/String;
    invoke-virtual {p0, v4}, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->setTimePositionClass(Ljava/lang/String;)V

    .line 99
    invoke-super {p0, p1}, Ltv/freewheel/hybrid/ad/slot/Slot;->parse(Lorg/w3c/dom/Element;)V

    .line 100
    return-void

    .end local v4    # "timePositionClassStr":Ljava/lang/String;
    .restart local v0    # "parsedEmbeddedAdsDuration":D
    :cond_0
    move-wide v0, v6

    .line 91
    goto :goto_0

    .end local v0    # "parsedEmbeddedAdsDuration":D
    .restart local v2    # "parsedEndTimePosition":D
    :cond_1
    move-wide v2, v6

    .line 93
    goto :goto_1
.end method

.method protected setTimePositionClass(Ljava/lang/String;)V
    .locals 1
    .param p1, "adUnit"    # Ljava/lang/String;

    .prologue
    .line 54
    const-string v0, "PREROLL"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 55
    const/4 v0, 0x1

    iput v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePositionClass:I

    .line 67
    :goto_0
    return-void

    .line 56
    :cond_0
    const-string v0, "MIDROLL"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 57
    const/4 v0, 0x2

    iput v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePositionClass:I

    goto :goto_0

    .line 58
    :cond_1
    const-string v0, "POSTROLL"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 59
    const/4 v0, 0x3

    iput v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePositionClass:I

    goto :goto_0

    .line 60
    :cond_2
    const-string v0, "OVERLAY"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 61
    const/4 v0, 0x4

    iput v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePositionClass:I

    goto :goto_0

    .line 62
    :cond_3
    const-string v0, "PAUSE_MIDROLL"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 63
    const/4 v0, 0x6

    iput v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePositionClass:I

    goto :goto_0

    .line 65
    :cond_4
    const/4 v0, 0x0

    iput v0, p0, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->timePositionClass:I

    goto :goto_0
.end method
