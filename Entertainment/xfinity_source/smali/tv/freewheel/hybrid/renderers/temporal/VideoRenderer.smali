.class public Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;
.super Ljava/lang/Object;
.source "VideoRenderer.java"

# interfaces
.implements Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;


# static fields
.field private static HLSSupportVersion:I

.field private static STATE_DISPOSED:I

.field private static STATE_STARTED:I

.field private static STATE_STOPPED:I


# instance fields
.field private HLSDropped:Z

.field private assetUrl:Ljava/lang/String;

.field private clickHandledByPlayer:Z

.field protected constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

.field private defaultImpressionSent:Z

.field private estimatedDuration:D

.field private impressionCountBeforeStart:I

.field private internalState:Ljava/util/concurrent/atomic/AtomicInteger;

.field private isPaused:Z

.field private logger:Ltv/freewheel/hybrid/utils/Logger;

.field private quartilesSent:I

.field private rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

.field private renditionHeight:I

.field private renditionWidth:I

.field private slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

.field private final supportPreload:Z

.field private timeoutCountBeforeStart:I

.field private timeoutMillisecondsBeforeStart:D

.field private timer:Ljava/util/Timer;

.field private videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    const/4 v0, 0x0

    sput v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->STATE_STARTED:I

    .line 48
    const/4 v0, 0x1

    sput v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->STATE_STOPPED:I

    .line 49
    const/4 v0, 0x2

    sput v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->STATE_DISPOSED:I

    .line 57
    const/16 v0, 0xb

    sput v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->HLSSupportVersion:I

    return-void
.end method

.method public constructor <init>()V
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->defaultImpressionSent:Z

    .line 34
    iput v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->quartilesSent:I

    .line 35
    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->isPaused:Z

    .line 36
    iput v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->impressionCountBeforeStart:I

    .line 37
    const-wide v2, 0x40c3880000000000L    # 10000.0

    iput-wide v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->timeoutMillisecondsBeforeStart:D

    .line 38
    iput v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->timeoutCountBeforeStart:I

    .line 39
    const-wide/high16 v2, -0x4010000000000000L    # -1.0

    iput-wide v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->estimatedDuration:D

    .line 51
    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->clickHandledByPlayer:Z

    .line 56
    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->HLSDropped:Z

    .line 58
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xd

    if-le v1, v2, :cond_0

    const/4 v0, 0x1

    :cond_0
    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->supportPreload:Z

    .line 63
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 64
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    sget v1, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->STATE_STARTED:I

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->internalState:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 65
    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;)Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    .prologue
    .line 22
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    return-object v0
.end method

.method static synthetic access$002(Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;
    .param p1, "x1"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    .prologue
    .line 22
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    return-object p1
.end method

.method static synthetic access$100(Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    .prologue
    .line 22
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onImprTimer()V

    return-void
.end method

.method private checkAndFailIfTimeout()V
    .locals 6

    .prologue
    .line 700
    iget v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->impressionCountBeforeStart:I

    iget v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->timeoutCountBeforeStart:I

    if-lt v2, v3, :cond_0

    .line 701
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "ad content can not start in "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-wide v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->timeoutMillisecondsBeforeStart:D

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "ms, just fail!"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 702
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->stopQuartileTimer()V

    .line 703
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 704
    .local v0, "info":Landroid/os/Bundle;
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_TIMEOUT()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 705
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v2

    const-string v3, "ad content can not start in 10s"

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 706
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 707
    .local v1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 708
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 712
    .end local v0    # "info":Landroid/os/Bundle;
    .end local v1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_0
    return-void

    .line 710
    :cond_0
    iget v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->impressionCountBeforeStart:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->impressionCountBeforeStart:I

    goto :goto_0
.end method

.method private getBestFitRendition()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    .locals 36

    .prologue
    .line 179
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 184
    .local v4, "allRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    sget v31, Landroid/os/Build$VERSION;->SDK_INT:I

    sget v32, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->HLSSupportVersion:I

    move/from16 v0, v31

    move/from16 v1, v32

    if-lt v0, v1, :cond_0

    const/4 v13, 0x1

    .line 185
    .local v13, "deviceCapable":Z
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Android version "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    sget-object v33, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, ", API "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    sget v33, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, ", HLS supported: "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, v32

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 189
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-object/from16 v31, v0

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v31

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getRenderableCreativeRenditions()Ljava/util/ArrayList;

    move-result-object v31

    invoke-virtual/range {v31 .. v31}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v15

    .local v15, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v31

    if-eqz v31, :cond_4

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v25

    check-cast v25, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    .line 190
    .local v25, "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    invoke-interface/range {v25 .. v25}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v31

    const-string v32, "application/x-mpegurl"

    invoke-virtual/range {v31 .. v32}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v31

    if-eqz v31, :cond_3

    .line 191
    invoke-interface/range {v25 .. v25}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v31

    if-nez v31, :cond_1

    .line 192
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Drop HLS rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, " that has no asset"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_1

    .line 184
    .end local v13    # "deviceCapable":Z
    .end local v15    # "i$":Ljava/util/Iterator;
    .end local v25    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    :cond_0
    const/4 v13, 0x0

    goto/16 :goto_0

    .line 196
    .restart local v13    # "deviceCapable":Z
    .restart local v15    # "i$":Ljava/util/Iterator;
    .restart local v25    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    :cond_1
    if-eqz v13, :cond_2

    .line 197
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Return HLS rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 342
    .end local v25    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    :goto_2
    return-object v25

    .line 201
    .restart local v25    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    :cond_2
    const/16 v31, 0x1

    move/from16 v0, v31

    move-object/from16 v1, p0

    iput-boolean v0, v1, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->HLSDropped:Z

    .line 202
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Drop HLS rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, " for Android version is too old"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 204
    :cond_3
    move-object/from16 v0, v25

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 209
    .end local v25    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    :cond_4
    const-wide/16 v28, 0x0

    .line 210
    .local v28, "slotAspectRatio":D
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Slot size "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-object/from16 v33, v0

    invoke-interface/range {v33 .. v33}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getWidth()I

    move-result v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, "x"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-object/from16 v33, v0

    invoke-interface/range {v33 .. v33}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getHeight()I

    move-result v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 211
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-object/from16 v31, v0

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getWidth()I

    move-result v31

    if-lez v31, :cond_c

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-object/from16 v31, v0

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getHeight()I

    move-result v31

    if-lez v31, :cond_c

    .line 212
    const-wide/high16 v32, 0x3ff0000000000000L    # 1.0

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-object/from16 v31, v0

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getWidth()I

    move-result v31

    move/from16 v0, v31

    int-to-double v0, v0

    move-wide/from16 v34, v0

    mul-double v32, v32, v34

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-object/from16 v31, v0

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getHeight()I

    move-result v31

    move/from16 v0, v31

    int-to-double v0, v0

    move-wide/from16 v34, v0

    div-double v28, v32, v34

    .line 213
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Slot aspect ratio "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, v32

    move-wide/from16 v1, v28

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 215
    new-instance v27, Ljava/util/ArrayList;

    invoke-direct/range {v27 .. v27}, Ljava/util/ArrayList;-><init>()V

    .line 216
    .local v27, "resultRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    new-instance v30, Ljava/util/ArrayList;

    invoke-direct/range {v30 .. v30}, Ljava/util/ArrayList;-><init>()V

    .line 217
    .local v30, "unknownRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    const-wide/high16 v18, -0x4010000000000000L    # -1.0

    .line 219
    .local v18, "minOffset":D
    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v15

    :goto_3
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v31

    if-eqz v31, :cond_a

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v25

    check-cast v25, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    .line 220
    .restart local v25    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    invoke-interface/range {v25 .. v25}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getWidth()I

    move-result v31

    if-lez v31, :cond_9

    invoke-interface/range {v25 .. v25}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getHeight()I

    move-result v31

    if-lez v31, :cond_9

    .line 221
    const-wide/high16 v32, 0x3ff0000000000000L    # 1.0

    invoke-interface/range {v25 .. v25}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getWidth()I

    move-result v31

    move/from16 v0, v31

    int-to-double v0, v0

    move-wide/from16 v34, v0

    mul-double v32, v32, v34

    invoke-interface/range {v25 .. v25}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getHeight()I

    move-result v31

    move/from16 v0, v31

    int-to-double v0, v0

    move-wide/from16 v34, v0

    div-double v6, v32, v34

    .line 222
    .local v6, "aspectRatio":D
    cmpl-double v31, v6, v28

    if-lez v31, :cond_6

    sub-double v22, v6, v28

    .line 225
    .local v22, "offset":D
    :goto_4
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, " aspect ratio "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, v32

    invoke-virtual {v0, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, " offset "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, v32

    move-wide/from16 v1, v22

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 229
    const-wide/16 v32, 0x0

    cmpg-double v31, v18, v32

    if-ltz v31, :cond_5

    cmpg-double v31, v22, v18

    if-gez v31, :cond_7

    .line 230
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Less offset "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, v32

    move-wide/from16 v1, v22

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, ", drop "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v27 .. v27}, Ljava/util/ArrayList;->size()I

    move-result v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, " kept renditions"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 231
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Keep rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 232
    invoke-virtual/range {v27 .. v27}, Ljava/util/ArrayList;->clear()V

    .line 233
    move-object/from16 v0, v27

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 234
    move-wide/from16 v18, v22

    goto/16 :goto_3

    .line 222
    .end local v22    # "offset":D
    :cond_6
    sub-double v22, v28, v6

    goto/16 :goto_4

    .line 235
    .restart local v22    # "offset":D
    :cond_7
    cmpl-double v31, v18, v22

    if-nez v31, :cond_8

    .line 236
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Keep rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 237
    move-object/from16 v0, v27

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_3

    .line 239
    :cond_8
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Drop rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 242
    .end local v6    # "aspectRatio":D
    .end local v22    # "offset":D
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Keep rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, ": unknown width or height"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 243
    move-object/from16 v0, v30

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_3

    .line 247
    .end local v25    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    :cond_a
    move-object/from16 v0, v27

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 254
    .end local v18    # "minOffset":D
    .end local v30    # "unknownRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    :goto_5
    const-wide v10, 0x408f400000000000L    # 1000.0

    .line 255
    .local v10, "desiredBitRate":D
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-object/from16 v31, v0

    const-string v32, "desiredBitrate"

    invoke-interface/range {v31 .. v32}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    .line 256
    .local v12, "desiredBitrateStr":Ljava/lang/String;
    if-eqz v12, :cond_b

    .line 258
    :try_start_0
    invoke-static {v12}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v10

    .line 259
    const-wide/16 v32, 0x0

    cmpg-double v31, v10, v32

    if-gez v31, :cond_d

    .line 260
    const-wide v10, 0x408f400000000000L    # 1000.0

    .line 261
    new-instance v31, Ljava/lang/NumberFormatException;

    invoke-direct/range {v31 .. v31}, Ljava/lang/NumberFormatException;-><init>()V

    throw v31
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 264
    :catch_0
    move-exception v14

    .line 265
    .local v14, "e":Ljava/lang/NumberFormatException;
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Malformed or negative value of desiredBitrate: "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, v32

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 270
    .end local v14    # "e":Ljava/lang/NumberFormatException;
    :cond_b
    :goto_6
    new-instance v26, Ljava/util/ArrayList;

    invoke-direct/range {v26 .. v26}, Ljava/util/ArrayList;-><init>()V

    .line 272
    .local v26, "reserves":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    move-object/from16 v5, v27

    .line 273
    .local v5, "candidates":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    new-instance v27, Ljava/util/ArrayList;

    .end local v27    # "resultRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    invoke-direct/range {v27 .. v27}, Ljava/util/ArrayList;-><init>()V

    .line 275
    .restart local v27    # "resultRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    new-instance v30, Ljava/util/ArrayList;

    invoke-direct/range {v30 .. v30}, Ljava/util/ArrayList;-><init>()V

    .line 277
    .restart local v30    # "unknownRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    const-wide/16 v16, 0x0

    .local v16, "maxBitRate":D
    const-wide/high16 v20, -0x4010000000000000L    # -1.0

    .line 279
    .local v20, "minReserveBitRate":D
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v15

    :goto_7
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v31

    if-eqz v31, :cond_16

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v25

    check-cast v25, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    .line 280
    .restart local v25    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    invoke-interface/range {v25 .. v25}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v31

    if-nez v31, :cond_e

    .line 281
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Drop rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, " that has no asset"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_7

    .line 249
    .end local v5    # "candidates":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    .end local v10    # "desiredBitRate":D
    .end local v12    # "desiredBitrateStr":Ljava/lang/String;
    .end local v16    # "maxBitRate":D
    .end local v20    # "minReserveBitRate":D
    .end local v25    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    .end local v26    # "reserves":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    .end local v27    # "resultRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    .end local v30    # "unknownRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    :cond_c
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    const-string v32, "Unknown slot dimension, keep all renditions"

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 250
    move-object/from16 v27, v4

    .restart local v27    # "resultRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    goto/16 :goto_5

    .line 263
    .restart local v10    # "desiredBitRate":D
    .restart local v12    # "desiredBitrateStr":Ljava/lang/String;
    :cond_d
    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Desired bit rate "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, v32

    invoke-virtual {v0, v10, v11}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, " kbps"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_6

    .line 285
    .restart local v5    # "candidates":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    .restart local v16    # "maxBitRate":D
    .restart local v20    # "minReserveBitRate":D
    .restart local v25    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    .restart local v26    # "reserves":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    .restart local v30    # "unknownRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;>;"
    :cond_e
    invoke-interface/range {v25 .. v25}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v31

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->getBytes()I

    move-result v31

    if-lez v31, :cond_15

    invoke-interface/range {v25 .. v25}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getDuration()D

    move-result-wide v32

    const-wide/16 v34, 0x0

    cmpl-double v31, v32, v34

    if-lez v31, :cond_15

    .line 287
    const-wide/high16 v32, 0x4020000000000000L    # 8.0

    invoke-interface/range {v25 .. v25}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v31

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->getBytes()I

    move-result v31

    move/from16 v0, v31

    int-to-double v0, v0

    move-wide/from16 v34, v0

    mul-double v32, v32, v34

    const-wide v34, 0x408f400000000000L    # 1000.0

    div-double v32, v32, v34

    invoke-interface/range {v25 .. v25}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getDuration()D

    move-result-wide v34

    div-double v8, v32, v34

    .line 288
    .local v8, "bitRate":D
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, " bit rate "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, v32

    invoke-virtual {v0, v8, v9}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 290
    cmpl-double v31, v8, v10

    if-lez v31, :cond_12

    .line 292
    const-wide/16 v32, 0x0

    cmpg-double v31, v20, v32

    if-ltz v31, :cond_f

    cmpg-double v31, v8, v20

    if-gez v31, :cond_10

    .line 293
    :cond_f
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Less higher bit rate "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, v32

    invoke-virtual {v0, v8, v9}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, ", drop "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v26 .. v26}, Ljava/util/ArrayList;->size()I

    move-result v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, " renditions in pending list"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 294
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Keep rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, " in pending list"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 295
    move-wide/from16 v20, v8

    .line 296
    invoke-virtual/range {v26 .. v26}, Ljava/util/ArrayList;->clear()V

    .line 297
    move-object/from16 v0, v26

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_7

    .line 298
    :cond_10
    cmpl-double v31, v8, v20

    if-nez v31, :cond_11

    .line 299
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Keep rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, " in pending list"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 300
    move-object/from16 v0, v26

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_7

    .line 302
    :cond_11
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Drop rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_7

    .line 306
    :cond_12
    cmpl-double v31, v8, v16

    if-lez v31, :cond_13

    .line 307
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Less lower bit rate "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, v32

    invoke-virtual {v0, v8, v9}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, ", drop "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v27 .. v27}, Ljava/util/ArrayList;->size()I

    move-result v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, " kept renditions"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 308
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Keep rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 309
    move-wide/from16 v16, v8

    .line 310
    invoke-virtual/range {v27 .. v27}, Ljava/util/ArrayList;->clear()V

    .line 311
    move-object/from16 v0, v27

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_7

    .line 312
    :cond_13
    cmpl-double v31, v8, v16

    if-nez v31, :cond_14

    .line 313
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Keep rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 314
    move-object/from16 v0, v27

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_7

    .line 316
    :cond_14
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Drop rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_7

    .line 320
    .end local v8    # "bitRate":D
    :cond_15
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Keep rendition "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, ": unknown duration or asset size"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 321
    move-object/from16 v0, v30

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_7

    .line 325
    .end local v25    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    :cond_16
    move-object/from16 v0, v27

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 327
    invoke-virtual/range {v27 .. v27}, Ljava/util/ArrayList;->size()I

    move-result v31

    if-nez v31, :cond_17

    invoke-virtual/range {v26 .. v26}, Ljava/util/ArrayList;->size()I

    move-result v31

    if-lez v31, :cond_17

    .line 329
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "All renditions have higher bit rates than desired, use "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v26 .. v26}, Ljava/util/ArrayList;->size()I

    move-result v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, " renditions in pending list"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 331
    move-object/from16 v27, v26

    .line 334
    :cond_17
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-object/from16 v31, v0

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v31

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    move-result-object v24

    .line 335
    .local v24, "primaryRendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    move-object/from16 v0, v27

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v31

    if-eqz v31, :cond_18

    move-object/from16 v25, v24

    .line 336
    goto/16 :goto_2

    .line 339
    :cond_18
    invoke-virtual/range {v27 .. v27}, Ljava/util/ArrayList;->size()I

    move-result v31

    if-lez v31, :cond_19

    .line 340
    const/16 v31, 0x0

    move-object/from16 v0, v27

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v31

    check-cast v31, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    move-object/from16 v25, v31

    goto/16 :goto_2

    .line 342
    :cond_19
    const/16 v25, 0x0

    goto/16 :goto_2
.end method

.method private onImprTimer()V
    .locals 10

    .prologue
    const-wide/16 v8, 0x0

    .line 491
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->getPlayheadTime()D

    move-result-wide v2

    .line 492
    .local v2, "playhead":D
    cmpg-double v4, v2, v8

    if-gtz v4, :cond_1

    .line 493
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v5, "playhead <= 0"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 494
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->checkAndFailIfTimeout()V

    .line 519
    :cond_0
    :goto_0
    return-void

    .line 497
    :cond_1
    const/4 v4, 0x0

    iput v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->impressionCountBeforeStart:I

    .line 500
    iget-boolean v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->defaultImpressionSent:Z

    if-nez v4, :cond_2

    .line 501
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v5}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_STARTED()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 502
    const/4 v4, 0x1

    iput-boolean v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->defaultImpressionSent:Z

    .line 505
    :cond_2
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->getDuration()D

    move-result-wide v0

    .line 506
    .local v0, "duration":D
    cmpg-double v4, v0, v8

    if-gtz v4, :cond_3

    iget-wide v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->estimatedDuration:D

    cmpl-double v4, v4, v8

    if-lez v4, :cond_3

    .line 507
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "use estimatedDuration "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-wide v6, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->estimatedDuration:D

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 508
    iget-wide v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->estimatedDuration:D

    .line 510
    :cond_3
    cmpl-double v4, v0, v8

    if-lez v4, :cond_4

    .line 511
    div-double v4, v2, v0

    invoke-direct {p0, v4, v5}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->sendQuartiles(D)V

    .line 516
    :goto_1
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    if-eqz v4, :cond_0

    .line 517
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v4}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->onImprTimer()V

    goto :goto_0

    .line 513
    :cond_4
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v5, "unknown duration"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_1
.end method

.method private preload()V
    .locals 8

    .prologue
    .line 347
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v6, "preload"

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 349
    :try_start_0
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v5}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v4

    .line 351
    .local v4, "slotBase":Landroid/view/ViewGroup;
    if-nez v4, :cond_0

    .line 352
    new-instance v5, Ljava/lang/RuntimeException;

    const-string v6, "video display base is null, maybe forget to call registerVideoDisplay()?"

    invoke-direct {v5, v6}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v5
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 372
    .end local v4    # "slotBase":Landroid/view/ViewGroup;
    :catch_0
    move-exception v0

    .line 373
    .local v0, "e":Ljava/lang/RuntimeException;
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 374
    .local v2, "info":Landroid/os/Bundle;
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v5}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_UNKNOWN()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 375
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v5}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0}, Ljava/lang/RuntimeException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 376
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 377
    .local v3, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v5}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 378
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6, v3}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 379
    invoke-virtual {v0}, Ljava/lang/RuntimeException;->printStackTrace()V

    .line 381
    .end local v0    # "e":Ljava/lang/RuntimeException;
    .end local v2    # "info":Landroid/os/Bundle;
    .end local v3    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_0
    return-void

    .line 355
    .restart local v4    # "slotBase":Landroid/view/ViewGroup;
    :cond_0
    :try_start_1
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "slotBase: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 357
    new-instance v5, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v4}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v6

    iget-boolean v7, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->clickHandledByPlayer:Z

    invoke-direct {v5, v6, p0, v7}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;-><init>(Landroid/content/Context;Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;Z)V

    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    .line 358
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    const v6, 0x77df444a

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->setId(I)V

    .line 359
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->setAdUrl(Ljava/lang/String;)V

    .line 361
    iget-boolean v5, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->supportPreload:Z

    if-eqz v5, :cond_1

    .line 362
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v5}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->loadContent()V

    goto :goto_0

    .line 364
    :cond_1
    new-instance v1, Landroid/os/Handler;

    invoke-virtual {v4}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v5

    invoke-direct {v1, v5}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 365
    .local v1, "handler":Landroid/os/Handler;
    new-instance v5, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$1;

    invoke-direct {v5, p0, v4}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$1;-><init>(Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;Landroid/view/ViewGroup;)V

    invoke-virtual {v1, v5}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method private sendMissingQuartiles()V
    .locals 2

    .prologue
    .line 545
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "sendMissingQuartiles"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 546
    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    invoke-direct {p0, v0, v1}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->sendQuartiles(D)V

    .line 547
    return-void
.end method

.method private sendQuartiles(D)V
    .locals 7
    .param p1, "percent"    # D

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    .line 522
    const-wide/high16 v0, 0x3fd0000000000000L    # 0.25

    cmpl-double v0, p1, v0

    if-ltz v0, :cond_0

    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->quartilesSent:I

    if-ge v0, v3, :cond_0

    .line 523
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "sendQuartiles "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 524
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_FIRST_QUARTILE()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 525
    iput v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->quartilesSent:I

    .line 527
    :cond_0
    const-wide/high16 v0, 0x3fe0000000000000L    # 0.5

    cmpl-double v0, p1, v0

    if-ltz v0, :cond_1

    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->quartilesSent:I

    if-ge v0, v4, :cond_1

    .line 528
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "sendQuartiles "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 529
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_MIDPOINT()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 530
    iput v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->quartilesSent:I

    .line 532
    :cond_1
    const-wide/high16 v0, 0x3fe8000000000000L    # 0.75

    cmpl-double v0, p1, v0

    if-ltz v0, :cond_2

    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->quartilesSent:I

    if-ge v0, v5, :cond_2

    .line 533
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "sendQuartiles "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 534
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_THIRD_QUARTILE()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 535
    iput v5, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->quartilesSent:I

    .line 537
    :cond_2
    const-wide v0, 0x3fefae147ae147aeL    # 0.99

    cmpl-double v0, p1, v0

    if-ltz v0, :cond_3

    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->quartilesSent:I

    if-ge v0, v6, :cond_3

    .line 538
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "sendQuartiles "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 539
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_COMPLETE()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 540
    iput v6, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->quartilesSent:I

    .line 542
    :cond_3
    return-void
.end method

.method private startQuartileImpressionAndTimeoutTimer()V
    .locals 6

    .prologue
    .line 674
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 684
    :goto_0
    return-void

    .line 677
    :cond_0
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->timer:Ljava/util/Timer;

    .line 678
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->timer:Ljava/util/Timer;

    new-instance v1, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$4;

    invoke-direct {v1, p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$4;-><init>(Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;)V

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x1f4

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->scheduleAtFixedRate(Ljava/util/TimerTask;JJ)V

    goto :goto_0
.end method

.method private stopQuartileTimer()V
    .locals 2

    .prologue
    .line 687
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "stopQuartileTimer"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 688
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 689
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 690
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->purge()I

    .line 691
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->timer:Ljava/util/Timer;

    .line 693
    :cond_0
    return-void
.end method


# virtual methods
.method public dispose()V
    .locals 5

    .prologue
    .line 648
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->internalState:Ljava/util/concurrent/atomic/AtomicInteger;

    sget v3, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->STATE_STARTED:I

    sget v4, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->STATE_DISPOSED:I

    invoke-virtual {v2, v3, v4}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v2

    if-nez v2, :cond_1

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->internalState:Ljava/util/concurrent/atomic/AtomicInteger;

    sget v3, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->STATE_STOPPED:I

    sget v4, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->STATE_DISPOSED:I

    invoke-virtual {v2, v3, v4}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v2

    if-nez v2, :cond_1

    .line 650
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "dispose in incorrect state"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 671
    :cond_0
    :goto_0
    return-void

    .line 654
    :cond_1
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "dispose"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 655
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    if-eqz v2, :cond_0

    .line 659
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v1

    .line 660
    .local v1, "slotBase":Landroid/view/ViewGroup;
    new-instance v0, Landroid/os/Handler;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v0, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 662
    .local v0, "handler":Landroid/os/Handler;
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->dispose()V

    .line 664
    new-instance v2, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$3;

    invoke-direct {v2, p0, v1}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$3;-><init>(Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;Landroid/view/ViewGroup;)V

    invoke-virtual {v0, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method public getDuration()D
    .locals 6

    .prologue
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    .line 621
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->internalState:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v2

    sget v3, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->STATE_STARTED:I

    if-eq v2, v3, :cond_1

    .line 622
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "getDuration in incorrect state"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 629
    :cond_0
    :goto_0
    return-wide v0

    .line 626
    :cond_1
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    if-eqz v2, :cond_0

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->getDuration()D

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmpl-double v2, v2, v4

    if-lez v2, :cond_0

    .line 627
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->getDuration()D

    move-result-wide v0

    const-wide v2, 0x408f400000000000L    # 1000.0

    div-double/2addr v0, v2

    goto :goto_0
.end method

.method public getPlayheadTime()D
    .locals 4

    .prologue
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    .line 634
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->internalState:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v2

    sget v3, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->STATE_STARTED:I

    if-eq v2, v3, :cond_1

    .line 635
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "getPlayheadTime in incorrect state"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 642
    :cond_0
    :goto_0
    return-wide v0

    .line 639
    :cond_1
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    if-eqz v2, :cond_0

    .line 640
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->getPlayheadTime()D

    move-result-wide v0

    const-wide v2, 0x408f400000000000L    # 1000.0

    div-double/2addr v0, v2

    goto :goto_0
.end method

.method public load(Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;)V
    .locals 18
    .param p1, "rendererContext"    # Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    .prologue
    .line 69
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v15, "init"

    invoke-virtual {v14, v15}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 70
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    .line 72
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v14}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v14

    move-object/from16 v0, p0

    iput-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .line 73
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v14}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v14

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v14

    move-object/from16 v0, p0

    iput-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 75
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    const-string v15, "timeoutMillisecondsBeforeStart"

    invoke-interface {v14, v15}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v9

    .line 76
    .local v9, "timeoutParam":Ljava/lang/Object;
    if-eqz v9, :cond_0

    .line 77
    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v10

    .line 78
    .local v10, "timeoutStr":Ljava/lang/String;
    invoke-static {v10}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v12

    .line 79
    .local v12, "val":D
    const-wide/16 v14, 0x0

    cmpl-double v14, v12, v14

    if-lez v14, :cond_0

    .line 80
    move-object/from16 v0, p0

    iput-wide v12, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->timeoutMillisecondsBeforeStart:D

    .line 83
    .end local v10    # "timeoutStr":Ljava/lang/String;
    .end local v12    # "val":D
    :cond_0
    move-object/from16 v0, p0

    iget-wide v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->timeoutMillisecondsBeforeStart:D

    const-wide v16, 0x407f400000000000L    # 500.0

    div-double v14, v14, v16

    double-to-int v14, v14

    move-object/from16 v0, p0

    iput v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->timeoutCountBeforeStart:I

    .line 85
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    const-string v15, "renderer.video.clickDetection"

    invoke-interface {v14, v15}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 86
    .local v2, "clickParam":Ljava/lang/Object;
    if-eqz v2, :cond_1

    .line 87
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 88
    .local v3, "clickParamStr":Ljava/lang/String;
    const-string v14, "false"

    invoke-virtual {v3, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_1

    .line 91
    const/4 v14, 0x1

    move-object/from16 v0, p0

    iput-boolean v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->clickHandledByPlayer:Z

    .line 95
    .end local v3    # "clickParamStr":Ljava/lang/String;
    :cond_1
    invoke-direct/range {p0 .. p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->getBestFitRendition()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    move-result-object v7

    .line 96
    .local v7, "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    if-nez v7, :cond_3

    .line 97
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 99
    .local v5, "info":Landroid/os/Bundle;
    move-object/from16 v0, p0

    iget-boolean v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->HLSDropped:Z

    if-eqz v14, :cond_2

    .line 101
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v15, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v15}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_UNKNOWN()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v5, v14, v15}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 102
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v14

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "HLS not supported on Android version "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    sget-object v16, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v5, v14, v15}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 109
    :goto_0
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 110
    .local v6, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v6, v14, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 111
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p1

    invoke-interface {v0, v14, v6}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 176
    .end local v5    # "info":Landroid/os/Bundle;
    .end local v6    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_1
    return-void

    .line 105
    .restart local v5    # "info":Landroid/os/Bundle;
    :cond_2
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v15, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v15}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_NULL_ASSET()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v5, v14, v15}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v14

    const-string v15, "No asset"

    invoke-virtual {v5, v14, v15}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 115
    .end local v5    # "info":Landroid/os/Bundle;
    :cond_3
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "Best fit rendition "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 116
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v14}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v14

    invoke-interface {v14, v7}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->setActiveCreativeRendition(Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;)V

    .line 117
    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getDuration()D

    move-result-wide v14

    move-object/from16 v0, p0

    iput-wide v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->estimatedDuration:D

    .line 118
    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getWidth()I

    move-result v14

    move-object/from16 v0, p0

    iput v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->renditionWidth:I

    .line 119
    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getHeight()I

    move-result v14

    move-object/from16 v0, p0

    iput v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->renditionHeight:I

    .line 120
    move-object/from16 v0, p0

    iget v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->renditionWidth:I

    if-gtz v14, :cond_4

    .line 121
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getWidth()I

    move-result v14

    move-object/from16 v0, p0

    iput v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->renditionWidth:I

    .line 123
    :cond_4
    move-object/from16 v0, p0

    iget v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->renditionHeight:I

    if-gtz v14, :cond_5

    .line 124
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getHeight()I

    move-result v14

    move-object/from16 v0, p0

    iput v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->renditionHeight:I

    .line 127
    :cond_5
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-object/from16 v0, p0

    iget-object v15, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v15}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_QUARTILE()Ljava/lang/String;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-object/from16 v16, v0

    invoke-interface/range {v16 .. v16}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->CAPABILITY_STATUS_ON()I

    move-result v16

    invoke-interface/range {v14 .. v16}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->setRendererCapability(Ljava/lang/String;I)V

    .line 128
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-object/from16 v0, p0

    iget-object v15, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v15}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_MUTE()Ljava/lang/String;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-object/from16 v16, v0

    invoke-interface/range {v16 .. v16}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->CAPABILITY_STATUS_ON()I

    move-result v16

    invoke-interface/range {v14 .. v16}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->setRendererCapability(Ljava/lang/String;I)V

    .line 129
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-object/from16 v0, p0

    iget-object v15, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v15}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_UNMUTE()Ljava/lang/String;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-object/from16 v16, v0

    invoke-interface/range {v16 .. v16}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->CAPABILITY_STATUS_ON()I

    move-result v16

    invoke-interface/range {v14 .. v16}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->setRendererCapability(Ljava/lang/String;I)V

    .line 130
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-object/from16 v0, p0

    iget-object v15, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v15}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_PAUSE()Ljava/lang/String;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-object/from16 v16, v0

    invoke-interface/range {v16 .. v16}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->CAPABILITY_STATUS_ON()I

    move-result v16

    invoke-interface/range {v14 .. v16}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->setRendererCapability(Ljava/lang/String;I)V

    .line 131
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-object/from16 v0, p0

    iget-object v15, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v15}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_RESUME()Ljava/lang/String;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-object/from16 v16, v0

    invoke-interface/range {v16 .. v16}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->CAPABILITY_STATUS_ON()I

    move-result v16

    invoke-interface/range {v14 .. v16}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->setRendererCapability(Ljava/lang/String;I)V

    .line 133
    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v14

    if-eqz v14, :cond_6

    .line 134
    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v14

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->getURL()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p0

    iput-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    .line 139
    :goto_2
    move-object/from16 v0, p0

    iget-object v8, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    .line 141
    .local v8, "s":Ljava/lang/String;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "assetUrl passed in: "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    move-object/from16 v16, v0

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 142
    new-instance v11, Ljava/net/URI;

    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    invoke-direct {v11, v14}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    .line 143
    .local v11, "uri":Ljava/net/URI;
    invoke-virtual {v11}, Ljava/net/URI;->isAbsolute()Z

    move-result v14

    if-nez v14, :cond_7

    .line 144
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 145
    .restart local v5    # "info":Landroid/os/Bundle;
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v15, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v15}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_NULL_ASSET()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v5, v14, v15}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v14

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "original assetUrl: "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v5, v14, v15}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 147
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 148
    .restart local v6    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v6, v14, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 149
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p1

    invoke-interface {v0, v14, v6}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_1

    .line 158
    .end local v5    # "info":Landroid/os/Bundle;
    .end local v6    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v11    # "uri":Ljava/net/URI;
    :catch_0
    move-exception v4

    .line 159
    .local v4, "e":Ljava/net/URISyntaxException;
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    invoke-static {v14}, Ltv/freewheel/hybrid/utils/URIUtil;->getFixedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p0

    iput-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    .line 160
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "assetUrl fixed: "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    move-object/from16 v16, v0

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 161
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    if-nez v14, :cond_9

    .line 162
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 163
    .restart local v5    # "info":Landroid/os/Bundle;
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v15, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v15}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_NULL_ASSET()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v5, v14, v15}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 164
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v14

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "original assetUrl: "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, ", fixed assetUrl: "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    move-object/from16 v16, v0

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v5, v14, v15}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 166
    .restart local v6    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v6, v14, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 167
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p1

    invoke-interface {v0, v14, v6}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_1

    .line 136
    .end local v4    # "e":Ljava/net/URISyntaxException;
    .end local v5    # "info":Landroid/os/Bundle;
    .end local v6    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v8    # "s":Ljava/lang/String;
    :cond_6
    const-string v14, ""

    move-object/from16 v0, p0

    iput-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    goto/16 :goto_2

    .line 151
    .restart local v8    # "s":Ljava/lang/String;
    .restart local v11    # "uri":Ljava/net/URI;
    :cond_7
    :try_start_1
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "converted to URI: "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v11}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 152
    move-object/from16 v0, p0

    iget-boolean v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->supportPreload:Z

    if-eqz v14, :cond_8

    .line 153
    invoke-direct/range {p0 .. p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->preload()V

    goto/16 :goto_1

    .line 155
    :cond_8
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_LOADED()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p1

    invoke-interface {v0, v14}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/net/URISyntaxException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1

    .line 169
    .end local v11    # "uri":Ljava/net/URI;
    .restart local v4    # "e":Ljava/net/URISyntaxException;
    :cond_9
    move-object/from16 v0, p0

    iget-boolean v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->supportPreload:Z

    if-eqz v14, :cond_a

    .line 170
    invoke-direct/range {p0 .. p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->preload()V

    goto/16 :goto_1

    .line 172
    :cond_a
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v14}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_LOADED()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p1

    invoke-interface {v0, v14}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    goto/16 :goto_1
.end method

.method public onAdMuted()V
    .locals 2

    .prologue
    .line 462
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onAdMuted"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 463
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_MUTE()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 464
    return-void
.end method

.method public onAdPaused()V
    .locals 2

    .prologue
    .line 447
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onAdPaused"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 448
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_PAUSE()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 449
    return-void
.end method

.method public onAdResumed()V
    .locals 2

    .prologue
    .line 452
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onAdResumed"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 453
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_RESUME()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 454
    return-void
.end method

.method public onAdRewind()V
    .locals 2

    .prologue
    .line 457
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onAdRewind"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 458
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_REWIND()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 459
    return-void
.end method

.method public onAdUnMuted()V
    .locals 2

    .prologue
    .line 467
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onAdUnMuted"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 468
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_UNMUTE()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 469
    return-void
.end method

.method public onAdVideoViewComplete()V
    .locals 2

    .prologue
    .line 411
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onAdVideoViewComplete"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 413
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->stopQuartileTimer()V

    .line 414
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->sendMissingQuartiles()V

    .line 415
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_STOPPED()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 416
    return-void
.end method

.method public onAdVideoViewError(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "info"    # Landroid/os/Bundle;

    .prologue
    .line 422
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "onAdVideoViewError: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 424
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->stopQuartileTimer()V

    .line 425
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 426
    .local v0, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 427
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 428
    return-void
.end method

.method public onAdViewClicked()V
    .locals 2

    .prologue
    .line 431
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onAdViewClicked"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 432
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_CLICK()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 433
    return-void
.end method

.method public onAdViewLoaded()V
    .locals 2

    .prologue
    .line 476
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onAdViewLoaded"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 478
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    if-eqz v0, :cond_0

    .line 479
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_LOADED()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 481
    :cond_0
    return-void
.end method

.method public onAdViewMediaPrepared()V
    .locals 3

    .prologue
    .line 484
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onAdViewMediaPrepared. Renderer paused "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->isPaused:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 485
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->isPaused:Z

    if-nez v0, :cond_0

    .line 486
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->startPlayback()V

    .line 488
    :cond_0
    return-void
.end method

.method public onAdViewStart()V
    .locals 2

    .prologue
    .line 436
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onAdViewStart"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 443
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->startQuartileImpressionAndTimeoutTimer()V

    .line 444
    return-void
.end method

.method public onAdViewSurfaceDestroyed()V
    .locals 0

    .prologue
    .line 696
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->stopQuartileTimer()V

    .line 697
    return-void
.end method

.method public resize()V
    .locals 3

    .prologue
    .line 716
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    if-eqz v1, :cond_0

    .line 717
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 718
    .local v0, "displayBase":Landroid/widget/FrameLayout;
    if-eqz v0, :cond_0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 719
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v2, "video display base changed"

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 720
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->pause()V

    .line 721
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 722
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 723
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->start()V

    .line 726
    .end local v0    # "displayBase":Landroid/widget/FrameLayout;
    :cond_0
    return-void
.end method

.method public start()V
    .locals 4

    .prologue
    .line 388
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "start"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 389
    const/4 v2, 0x0

    iput-boolean v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->defaultImpressionSent:Z

    .line 390
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->startQuartileImpressionAndTimeoutTimer()V

    .line 391
    iget-boolean v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->supportPreload:Z

    if-eqz v2, :cond_0

    .line 392
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v1

    .line 393
    .local v1, "slotBase":Landroid/view/ViewGroup;
    new-instance v0, Landroid/os/Handler;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v0, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 394
    .local v0, "handler":Landroid/os/Handler;
    new-instance v2, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$2;

    invoke-direct {v2, p0, v1}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$2;-><init>(Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;Landroid/view/ViewGroup;)V

    invoke-virtual {v0, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 405
    .end local v0    # "handler":Landroid/os/Handler;
    .end local v1    # "slotBase":Landroid/view/ViewGroup;
    :goto_0
    return-void

    .line 403
    :cond_0
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->preload()V

    goto :goto_0
.end method

.method public stop()V
    .locals 3

    .prologue
    .line 554
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->internalState:Ljava/util/concurrent/atomic/AtomicInteger;

    sget v1, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->STATE_STARTED:I

    sget v2, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->STATE_STOPPED:I

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v0

    if-nez v0, :cond_0

    .line 555
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "stop in incorrect state"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 566
    :goto_0
    return-void

    .line 559
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 560
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->stopQuartileTimer()V

    .line 561
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    if-eqz v0, :cond_1

    .line 562
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->stop()V

    .line 565
    :cond_1
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_STOPPED()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    goto :goto_0
.end method
