.class public Ltv/freewheel/renderers/temporal/VideoRenderer;
.super Ljava/lang/Object;
.source "VideoRenderer.java"

# interfaces
.implements Ltv/freewheel/renderers/interfaces/IRenderer;


# static fields
.field private static HLSSupportVersion:I

.field private static STATE_DISPOSED:I

.field private static STATE_STARTED:I

.field private static STATE_STOPPED:I


# instance fields
.field private HLSDropped:Z

.field private assetUrl:Ljava/lang/String;

.field private checkRedirectUrl:Z

.field private clickHandledByPlayer:Z

.field protected constants:Ltv/freewheel/ad/interfaces/IConstants;

.field private defaultImpressionSent:Z

.field private estimatedDuration:D

.field private freezeCount:I

.field private impressionCountBeforeStart:I

.field private internalState:Ljava/util/concurrent/atomic/AtomicInteger;

.field private isPaused:Z

.field private lastPlayheadTime:D

.field private logger:Ltv/freewheel/utils/Logger;

.field private quartilesSent:I

.field private rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

.field private renditionHeight:I

.field private renditionWidth:I

.field private slot:Ltv/freewheel/ad/interfaces/ISlot;

.field private final supportPreload:Z

.field private timeoutCountBeforeStart:I

.field private timeoutCountForAdFreeze:D

.field private timeoutMillisecondsBeforeStart:D

.field private timeoutMillisecondsForAdFreeze:D

.field private timer:Ljava/util/Timer;

.field private useControlPanel:Z

.field private videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x0

    sput v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->STATE_STARTED:I

    .line 53
    const/4 v0, 0x1

    sput v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->STATE_STOPPED:I

    .line 54
    const/4 v0, 0x2

    sput v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->STATE_DISPOSED:I

    .line 65
    const/16 v0, 0xb

    sput v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->HLSSupportVersion:I

    return-void
.end method

.method public constructor <init>()V
    .locals 8

    .prologue
    const-wide v6, 0x40c3880000000000L    # 10000.0

    const-wide/16 v4, 0x0

    const/4 v0, 0x0

    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-boolean v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->defaultImpressionSent:Z

    .line 35
    iput v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->quartilesSent:I

    .line 36
    iput-boolean v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->isPaused:Z

    .line 37
    iput v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->impressionCountBeforeStart:I

    .line 38
    iput-wide v6, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutMillisecondsBeforeStart:D

    .line 39
    iput v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutCountBeforeStart:I

    .line 40
    const-wide/high16 v2, -0x4010000000000000L    # -1.0

    iput-wide v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->estimatedDuration:D

    .line 41
    iput v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->freezeCount:I

    .line 42
    iput-wide v6, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutMillisecondsForAdFreeze:D

    .line 43
    iput-wide v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutCountForAdFreeze:D

    .line 44
    iput-wide v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->lastPlayheadTime:D

    .line 56
    iput-boolean v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->clickHandledByPlayer:Z

    .line 57
    iput-boolean v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->useControlPanel:Z

    .line 60
    iput-boolean v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->checkRedirectUrl:Z

    .line 64
    iput-boolean v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->HLSDropped:Z

    .line 66
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xd

    if-le v1, v2, :cond_0

    const/4 v0, 0x1

    :cond_0
    iput-boolean v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->supportPreload:Z

    .line 71
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    .line 72
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    sget v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->STATE_STARTED:I

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->internalState:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 73
    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/renderers/temporal/VideoRenderer;)Ltv/freewheel/renderers/temporal/VideoAdView;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoRenderer;

    .prologue
    .line 23
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    return-object v0
.end method

.method static synthetic access$002(Ltv/freewheel/renderers/temporal/VideoRenderer;Ltv/freewheel/renderers/temporal/VideoAdView;)Ltv/freewheel/renderers/temporal/VideoAdView;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoRenderer;
    .param p1, "x1"    # Ltv/freewheel/renderers/temporal/VideoAdView;

    .prologue
    .line 23
    iput-object p1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    return-object p1
.end method

.method static synthetic access$100(Ltv/freewheel/renderers/temporal/VideoRenderer;)Ltv/freewheel/ad/interfaces/ISlot;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoRenderer;

    .prologue
    .line 23
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    return-object v0
.end method

.method static synthetic access$200(Ltv/freewheel/renderers/temporal/VideoRenderer;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoRenderer;

    .prologue
    .line 23
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onImprTimer()V

    return-void
.end method

.method private checkAndFailIfFreeze()V
    .locals 8

    .prologue
    .line 782
    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->freezeCount:I

    int-to-double v2, v2

    iget-wide v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutCountForAdFreeze:D

    cmpl-double v2, v2, v4

    if-ltz v2, :cond_0

    .line 783
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "ad content is unexpected paused for "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-wide v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutMillisecondsForAdFreeze:D

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "ms, just fail!"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 784
    const/4 v2, 0x0

    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->freezeCount:I

    .line 785
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 786
    .local v0, "info":Landroid/os/Bundle;
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_TIMEOUT()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 787
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "ad content is unexpected paused for "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-wide v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutMillisecondsForAdFreeze:D

    const-wide v6, 0x408f400000000000L    # 1000.0

    div-double/2addr v4, v6

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "s"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 788
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 789
    .local v1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 790
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 794
    .end local v0    # "info":Landroid/os/Bundle;
    .end local v1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_0
    return-void

    .line 792
    :cond_0
    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->freezeCount:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->freezeCount:I

    goto :goto_0
.end method

.method private checkAndFailIfTimeout()V
    .locals 6

    .prologue
    .line 767
    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->impressionCountBeforeStart:I

    iget v3, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutCountBeforeStart:I

    if-lt v2, v3, :cond_0

    .line 768
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "ad content can not start in "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-wide v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutMillisecondsBeforeStart:D

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "ms, just fail!"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 769
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->stopQuartileTimer()V

    .line 770
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 771
    .local v0, "info":Landroid/os/Bundle;
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_TIMEOUT()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 772
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v2

    const-string v3, "ad content can not start in 10s"

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 773
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 774
    .local v1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 775
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 779
    .end local v0    # "info":Landroid/os/Bundle;
    .end local v1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_0
    return-void

    .line 777
    :cond_0
    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->impressionCountBeforeStart:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->impressionCountBeforeStart:I

    goto :goto_0
.end method

.method private getBestFitRendition()Ltv/freewheel/ad/interfaces/ICreativeRendition;
    .locals 36

    .prologue
    .line 211
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 216
    .local v4, "allRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    sget v31, Landroid/os/Build$VERSION;->SDK_INT:I

    sget v32, Ltv/freewheel/renderers/temporal/VideoRenderer;->HLSSupportVersion:I

    move/from16 v0, v31

    move/from16 v1, v32

    if-lt v0, v1, :cond_0

    const/4 v13, 0x1

    .line 217
    .local v13, "deviceCapable":Z
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 221
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v31, v0

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v31

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/ad/interfaces/IAdInstance;->getRenderableCreativeRenditions()Ljava/util/ArrayList;

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

    check-cast v25, Ltv/freewheel/ad/interfaces/ICreativeRendition;

    .line 222
    .local v25, "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    invoke-interface/range {v25 .. v25}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v31

    const-string v32, "application/x-mpegurl"

    invoke-virtual/range {v31 .. v32}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v31

    if-eqz v31, :cond_3

    .line 223
    invoke-interface/range {v25 .. v25}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v31

    if-nez v31, :cond_1

    .line 224
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_1

    .line 216
    .end local v13    # "deviceCapable":Z
    .end local v15    # "i$":Ljava/util/Iterator;
    .end local v25    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    :cond_0
    const/4 v13, 0x0

    goto/16 :goto_0

    .line 228
    .restart local v13    # "deviceCapable":Z
    .restart local v15    # "i$":Ljava/util/Iterator;
    .restart local v25    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    :cond_1
    if-eqz v13, :cond_2

    .line 229
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 374
    .end local v25    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    :goto_2
    return-object v25

    .line 233
    .restart local v25    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    :cond_2
    const/16 v31, 0x1

    move/from16 v0, v31

    move-object/from16 v1, p0

    iput-boolean v0, v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->HLSDropped:Z

    .line 234
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 236
    :cond_3
    move-object/from16 v0, v25

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 241
    .end local v25    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    :cond_4
    const-wide/16 v28, 0x0

    .line 242
    .local v28, "slotAspectRatio":D
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    move-object/from16 v31, v0

    new-instance v32, Ljava/lang/StringBuilder;

    invoke-direct/range {v32 .. v32}, Ljava/lang/StringBuilder;-><init>()V

    const-string v33, "Slot size "

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    move-object/from16 v33, v0

    invoke-interface/range {v33 .. v33}, Ltv/freewheel/ad/interfaces/ISlot;->getWidth()I

    move-result v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v32

    const-string v33, "x"

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v32

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    move-object/from16 v33, v0

    invoke-interface/range {v33 .. v33}, Ltv/freewheel/ad/interfaces/ISlot;->getHeight()I

    move-result v33

    invoke-virtual/range {v32 .. v33}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 243
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    move-object/from16 v31, v0

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/ad/interfaces/ISlot;->getWidth()I

    move-result v31

    if-lez v31, :cond_c

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    move-object/from16 v31, v0

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/ad/interfaces/ISlot;->getHeight()I

    move-result v31

    if-lez v31, :cond_c

    .line 244
    const-wide/high16 v32, 0x3ff0000000000000L    # 1.0

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    move-object/from16 v31, v0

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/ad/interfaces/ISlot;->getWidth()I

    move-result v31

    move/from16 v0, v31

    int-to-double v0, v0

    move-wide/from16 v34, v0

    mul-double v32, v32, v34

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    move-object/from16 v31, v0

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/ad/interfaces/ISlot;->getHeight()I

    move-result v31

    move/from16 v0, v31

    int-to-double v0, v0

    move-wide/from16 v34, v0

    div-double v28, v32, v34

    .line 245
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 247
    new-instance v27, Ljava/util/ArrayList;

    invoke-direct/range {v27 .. v27}, Ljava/util/ArrayList;-><init>()V

    .line 248
    .local v27, "resultRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    new-instance v30, Ljava/util/ArrayList;

    invoke-direct/range {v30 .. v30}, Ljava/util/ArrayList;-><init>()V

    .line 249
    .local v30, "unknownRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    const-wide/high16 v18, -0x4010000000000000L    # -1.0

    .line 251
    .local v18, "minOffset":D
    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v15

    :goto_3
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v31

    if-eqz v31, :cond_a

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v25

    check-cast v25, Ltv/freewheel/ad/interfaces/ICreativeRendition;

    .line 252
    .restart local v25    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    invoke-interface/range {v25 .. v25}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getWidth()I

    move-result v31

    if-lez v31, :cond_9

    invoke-interface/range {v25 .. v25}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getHeight()I

    move-result v31

    if-lez v31, :cond_9

    .line 253
    const-wide/high16 v32, 0x3ff0000000000000L    # 1.0

    invoke-interface/range {v25 .. v25}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getWidth()I

    move-result v31

    move/from16 v0, v31

    int-to-double v0, v0

    move-wide/from16 v34, v0

    mul-double v32, v32, v34

    invoke-interface/range {v25 .. v25}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getHeight()I

    move-result v31

    move/from16 v0, v31

    int-to-double v0, v0

    move-wide/from16 v34, v0

    div-double v6, v32, v34

    .line 254
    .local v6, "aspectRatio":D
    cmpl-double v31, v6, v28

    if-lez v31, :cond_6

    sub-double v22, v6, v28

    .line 257
    .local v22, "offset":D
    :goto_4
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 261
    const-wide/16 v32, 0x0

    cmpg-double v31, v18, v32

    if-ltz v31, :cond_5

    cmpg-double v31, v22, v18

    if-gez v31, :cond_7

    .line 262
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 263
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 264
    invoke-virtual/range {v27 .. v27}, Ljava/util/ArrayList;->clear()V

    .line 265
    move-object/from16 v0, v27

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 266
    move-wide/from16 v18, v22

    goto/16 :goto_3

    .line 254
    .end local v22    # "offset":D
    :cond_6
    sub-double v22, v28, v6

    goto/16 :goto_4

    .line 267
    .restart local v22    # "offset":D
    :cond_7
    cmpl-double v31, v18, v22

    if-nez v31, :cond_8

    .line 268
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 269
    move-object/from16 v0, v27

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_3

    .line 271
    :cond_8
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 274
    .end local v6    # "aspectRatio":D
    .end local v22    # "offset":D
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 275
    move-object/from16 v0, v30

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_3

    .line 279
    .end local v25    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    :cond_a
    move-object/from16 v0, v27

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 286
    .end local v18    # "minOffset":D
    .end local v30    # "unknownRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    :goto_5
    const-wide v10, 0x408f400000000000L    # 1000.0

    .line 287
    .local v10, "desiredBitRate":D
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v31, v0

    const-string v32, "desiredBitrate"

    invoke-interface/range {v31 .. v32}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    .line 288
    .local v12, "desiredBitrateStr":Ljava/lang/String;
    if-eqz v12, :cond_b

    .line 290
    :try_start_0
    invoke-static {v12}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v10

    .line 291
    const-wide/16 v32, 0x0

    cmpg-double v31, v10, v32

    if-gez v31, :cond_d

    .line 292
    const-wide v10, 0x408f400000000000L    # 1000.0

    .line 293
    new-instance v31, Ljava/lang/NumberFormatException;

    invoke-direct/range {v31 .. v31}, Ljava/lang/NumberFormatException;-><init>()V

    throw v31
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 296
    :catch_0
    move-exception v14

    .line 297
    .local v14, "e":Ljava/lang/NumberFormatException;
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 302
    .end local v14    # "e":Ljava/lang/NumberFormatException;
    :cond_b
    :goto_6
    new-instance v26, Ljava/util/ArrayList;

    invoke-direct/range {v26 .. v26}, Ljava/util/ArrayList;-><init>()V

    .line 304
    .local v26, "reserves":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    move-object/from16 v5, v27

    .line 305
    .local v5, "candidates":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    new-instance v27, Ljava/util/ArrayList;

    .end local v27    # "resultRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    invoke-direct/range {v27 .. v27}, Ljava/util/ArrayList;-><init>()V

    .line 307
    .restart local v27    # "resultRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    new-instance v30, Ljava/util/ArrayList;

    invoke-direct/range {v30 .. v30}, Ljava/util/ArrayList;-><init>()V

    .line 309
    .restart local v30    # "unknownRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    const-wide/16 v16, 0x0

    .local v16, "maxBitRate":D
    const-wide/high16 v20, -0x4010000000000000L    # -1.0

    .line 311
    .local v20, "minReserveBitRate":D
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v15

    :goto_7
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v31

    if-eqz v31, :cond_16

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v25

    check-cast v25, Ltv/freewheel/ad/interfaces/ICreativeRendition;

    .line 312
    .restart local v25    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    invoke-interface/range {v25 .. v25}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v31

    if-nez v31, :cond_e

    .line 313
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_7

    .line 281
    .end local v5    # "candidates":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    .end local v10    # "desiredBitRate":D
    .end local v12    # "desiredBitrateStr":Ljava/lang/String;
    .end local v16    # "maxBitRate":D
    .end local v20    # "minReserveBitRate":D
    .end local v25    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    .end local v26    # "reserves":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    .end local v27    # "resultRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    .end local v30    # "unknownRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    :cond_c
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    move-object/from16 v31, v0

    const-string v32, "Unknown slot dimension, keep all renditions"

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 282
    move-object/from16 v27, v4

    .restart local v27    # "resultRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    goto/16 :goto_5

    .line 295
    .restart local v10    # "desiredBitRate":D
    .restart local v12    # "desiredBitrateStr":Ljava/lang/String;
    :cond_d
    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_6

    .line 317
    .restart local v5    # "candidates":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    .restart local v16    # "maxBitRate":D
    .restart local v20    # "minReserveBitRate":D
    .restart local v25    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    .restart local v26    # "reserves":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    .restart local v30    # "unknownRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ICreativeRendition;>;"
    :cond_e
    invoke-interface/range {v25 .. v25}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v31

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;->getBytes()I

    move-result v31

    if-lez v31, :cond_15

    invoke-interface/range {v25 .. v25}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getDuration()D

    move-result-wide v32

    const-wide/16 v34, 0x0

    cmpl-double v31, v32, v34

    if-lez v31, :cond_15

    .line 319
    const-wide/high16 v32, 0x4020000000000000L    # 8.0

    invoke-interface/range {v25 .. v25}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v31

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;->getBytes()I

    move-result v31

    move/from16 v0, v31

    int-to-double v0, v0

    move-wide/from16 v34, v0

    mul-double v32, v32, v34

    const-wide v34, 0x408f400000000000L    # 1000.0

    div-double v32, v32, v34

    invoke-interface/range {v25 .. v25}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getDuration()D

    move-result-wide v34

    div-double v8, v32, v34

    .line 320
    .local v8, "bitRate":D
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 322
    cmpl-double v31, v8, v10

    if-lez v31, :cond_12

    .line 324
    const-wide/16 v32, 0x0

    cmpg-double v31, v20, v32

    if-ltz v31, :cond_f

    cmpg-double v31, v8, v20

    if-gez v31, :cond_10

    .line 325
    :cond_f
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 326
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 327
    move-wide/from16 v20, v8

    .line 328
    invoke-virtual/range {v26 .. v26}, Ljava/util/ArrayList;->clear()V

    .line 329
    move-object/from16 v0, v26

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_7

    .line 330
    :cond_10
    cmpl-double v31, v8, v20

    if-nez v31, :cond_11

    .line 331
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 332
    move-object/from16 v0, v26

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_7

    .line 334
    :cond_11
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_7

    .line 338
    :cond_12
    cmpl-double v31, v8, v16

    if-lez v31, :cond_13

    .line 339
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 340
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 341
    move-wide/from16 v16, v8

    .line 342
    invoke-virtual/range {v27 .. v27}, Ljava/util/ArrayList;->clear()V

    .line 343
    move-object/from16 v0, v27

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_7

    .line 344
    :cond_13
    cmpl-double v31, v8, v16

    if-nez v31, :cond_14

    .line 345
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 346
    move-object/from16 v0, v27

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_7

    .line 348
    :cond_14
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_7

    .line 352
    .end local v8    # "bitRate":D
    :cond_15
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 353
    move-object/from16 v0, v30

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_7

    .line 357
    .end local v25    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    :cond_16
    move-object/from16 v0, v27

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 359
    invoke-virtual/range {v27 .. v27}, Ljava/util/ArrayList;->size()I

    move-result v31

    if-nez v31, :cond_17

    invoke-virtual/range {v26 .. v26}, Ljava/util/ArrayList;->size()I

    move-result v31

    if-lez v31, :cond_17

    .line 361
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual/range {v31 .. v32}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 363
    move-object/from16 v27, v26

    .line 366
    :cond_17
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v31, v0

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v31

    invoke-interface/range {v31 .. v31}, Ltv/freewheel/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-result-object v24

    .line 367
    .local v24, "primaryRendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    move-object/from16 v0, v27

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v31

    if-eqz v31, :cond_18

    move-object/from16 v25, v24

    .line 368
    goto/16 :goto_2

    .line 371
    :cond_18
    invoke-virtual/range {v27 .. v27}, Ljava/util/ArrayList;->size()I

    move-result v31

    if-lez v31, :cond_19

    .line 372
    const/16 v31, 0x0

    move-object/from16 v0, v27

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v31

    check-cast v31, Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-object/from16 v25, v31

    goto/16 :goto_2

    .line 374
    :cond_19
    const/16 v25, 0x0

    goto/16 :goto_2
.end method

.method private onImprTimer()V
    .locals 11

    .prologue
    const/4 v10, 0x0

    const-wide/16 v8, 0x0

    .line 550
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->getPlayheadTime()D

    move-result-wide v2

    .line 551
    .local v2, "playhead":D
    cmpg-double v4, v2, v8

    if-gtz v4, :cond_1

    .line 552
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v5, "playhead <= 0"

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 553
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->checkAndFailIfTimeout()V

    .line 585
    :cond_0
    :goto_0
    return-void

    .line 555
    :cond_1
    iget-boolean v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->isPaused:Z

    if-nez v4, :cond_2

    .line 556
    iget-wide v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->lastPlayheadTime:D

    sub-double v4, v2, v4

    const-wide v6, 0x3fb999999999999aL    # 0.1

    cmpg-double v4, v4, v6

    if-gez v4, :cond_5

    .line 557
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->checkAndFailIfFreeze()V

    .line 562
    :cond_2
    :goto_1
    iput v10, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->impressionCountBeforeStart:I

    .line 563
    iput-wide v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->lastPlayheadTime:D

    .line 566
    iget-boolean v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->defaultImpressionSent:Z

    if-nez v4, :cond_3

    .line 567
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v5, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v5}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_STARTED()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 568
    const/4 v4, 0x1

    iput-boolean v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->defaultImpressionSent:Z

    .line 571
    :cond_3
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->getDuration()D

    move-result-wide v0

    .line 572
    .local v0, "duration":D
    cmpg-double v4, v0, v8

    if-gtz v4, :cond_4

    iget-wide v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->estimatedDuration:D

    cmpl-double v4, v4, v8

    if-lez v4, :cond_4

    .line 573
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "use estimatedDuration "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-wide v6, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->estimatedDuration:D

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 574
    iget-wide v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->estimatedDuration:D

    .line 576
    :cond_4
    cmpl-double v4, v0, v8

    if-lez v4, :cond_6

    .line 577
    div-double v4, v2, v0

    invoke-direct {p0, v4, v5}, Ltv/freewheel/renderers/temporal/VideoRenderer;->sendQuartiles(D)V

    .line 582
    :goto_2
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    if-eqz v4, :cond_0

    .line 583
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {v4}, Ltv/freewheel/renderers/temporal/VideoAdView;->onImprTimer()V

    goto :goto_0

    .line 559
    .end local v0    # "duration":D
    :cond_5
    iput v10, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->freezeCount:I

    goto :goto_1

    .line 579
    .restart local v0    # "duration":D
    :cond_6
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v5, "unknown duration"

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_2
.end method

.method private preload()V
    .locals 8

    .prologue
    .line 379
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v5, "preload"

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 381
    :try_start_0
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v3

    .line 383
    .local v3, "slotBase":Landroid/view/ViewGroup;
    if-nez v3, :cond_0

    .line 384
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "video display base is null, maybe forget to call registerVideoDisplay()?"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 397
    .end local v3    # "slotBase":Landroid/view/ViewGroup;
    :catch_0
    move-exception v0

    .line 398
    .local v0, "e":Ljava/lang/RuntimeException;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 399
    .local v1, "info":Landroid/os/Bundle;
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v5}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_UNKNOWN()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 400
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/RuntimeException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 401
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 402
    .local v2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 403
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v5, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v5}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v2}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 404
    invoke-virtual {v0}, Ljava/lang/RuntimeException;->printStackTrace()V

    .line 406
    .end local v0    # "e":Ljava/lang/RuntimeException;
    .end local v1    # "info":Landroid/os/Bundle;
    .end local v2    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_0
    return-void

    .line 387
    .restart local v3    # "slotBase":Landroid/view/ViewGroup;
    :cond_0
    :try_start_1
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "slotBase: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 389
    new-instance v4, Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {v3}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v5

    iget-boolean v6, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->useControlPanel:Z

    invoke-direct {v4, v5, p0, v6}, Ltv/freewheel/renderers/temporal/VideoAdView;-><init>(Landroid/content/Context;Ltv/freewheel/renderers/temporal/VideoRenderer;Z)V

    iput-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    .line 390
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    const v5, 0x77df444a

    invoke-virtual {v4, v5}, Ltv/freewheel/renderers/temporal/VideoAdView;->setId(I)V

    .line 391
    iget-boolean v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->checkRedirectUrl:Z

    if-eqz v4, :cond_1

    .line 392
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    iget-object v5, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    iget-wide v6, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutMillisecondsBeforeStart:D

    double-to-int v6, v6

    invoke-virtual {v4, v5, v6}, Ltv/freewheel/renderers/temporal/VideoAdView;->tryToGetRedirectedUrl(Ljava/lang/String;I)V

    goto :goto_0

    .line 394
    :cond_1
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    iget-object v5, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ltv/freewheel/renderers/temporal/VideoAdView;->setAdUrl(Ljava/lang/String;)V

    .line 395
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    const/4 v5, 0x0

    invoke-virtual {p0, v4, v5}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onRedirectUrlChecked(Ljava/lang/String;Ljava/lang/Exception;)V
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method private sendMissingQuartiles()V
    .locals 2

    .prologue
    .line 611
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "sendMissingQuartiles"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 612
    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    invoke-direct {p0, v0, v1}, Ltv/freewheel/renderers/temporal/VideoRenderer;->sendQuartiles(D)V

    .line 613
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

    .line 588
    const-wide/high16 v0, 0x3fd0000000000000L    # 0.25

    cmpl-double v0, p1, v0

    if-ltz v0, :cond_0

    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->quartilesSent:I

    if-ge v0, v3, :cond_0

    .line 589
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "sendQuartiles "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 590
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_FIRST_QUARTILE()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 591
    iput v3, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->quartilesSent:I

    .line 593
    :cond_0
    const-wide/high16 v0, 0x3fe0000000000000L    # 0.5

    cmpl-double v0, p1, v0

    if-ltz v0, :cond_1

    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->quartilesSent:I

    if-ge v0, v4, :cond_1

    .line 594
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "sendQuartiles "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 595
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_MIDPOINT()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 596
    iput v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->quartilesSent:I

    .line 598
    :cond_1
    const-wide/high16 v0, 0x3fe8000000000000L    # 0.75

    cmpl-double v0, p1, v0

    if-ltz v0, :cond_2

    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->quartilesSent:I

    if-ge v0, v5, :cond_2

    .line 599
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "sendQuartiles "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 600
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_THIRD_QUARTILE()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 601
    iput v5, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->quartilesSent:I

    .line 603
    :cond_2
    const-wide v0, 0x3fefae147ae147aeL    # 0.99

    cmpl-double v0, p1, v0

    if-ltz v0, :cond_3

    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->quartilesSent:I

    if-ge v0, v6, :cond_3

    .line 604
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "sendQuartiles "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 605
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_COMPLETE()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 606
    iput v6, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->quartilesSent:I

    .line 608
    :cond_3
    return-void
.end method

.method private startQuartileImpressionAndTimeoutTimer()V
    .locals 6

    .prologue
    .line 740
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "startQuartileImpressionAndTimeoutTimer"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 741
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 751
    :goto_0
    return-void

    .line 744
    :cond_0
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timer:Ljava/util/Timer;

    .line 745
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timer:Ljava/util/Timer;

    new-instance v1, Ltv/freewheel/renderers/temporal/VideoRenderer$4;

    invoke-direct {v1, p0}, Ltv/freewheel/renderers/temporal/VideoRenderer$4;-><init>(Ltv/freewheel/renderers/temporal/VideoRenderer;)V

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x1f4

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->scheduleAtFixedRate(Ljava/util/TimerTask;JJ)V

    goto :goto_0
.end method

.method private stopQuartileTimer()V
    .locals 2

    .prologue
    .line 754
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "stopQuartileTimer"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 755
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 756
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 757
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->purge()I

    .line 758
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timer:Ljava/util/Timer;

    .line 760
    :cond_0
    return-void
.end method


# virtual methods
.method public dispose()V
    .locals 5

    .prologue
    .line 714
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->internalState:Ljava/util/concurrent/atomic/AtomicInteger;

    sget v3, Ltv/freewheel/renderers/temporal/VideoRenderer;->STATE_STARTED:I

    sget v4, Ltv/freewheel/renderers/temporal/VideoRenderer;->STATE_DISPOSED:I

    invoke-virtual {v2, v3, v4}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v2

    if-nez v2, :cond_1

    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->internalState:Ljava/util/concurrent/atomic/AtomicInteger;

    sget v3, Ltv/freewheel/renderers/temporal/VideoRenderer;->STATE_STOPPED:I

    sget v4, Ltv/freewheel/renderers/temporal/VideoRenderer;->STATE_DISPOSED:I

    invoke-virtual {v2, v3, v4}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v2

    if-nez v2, :cond_1

    .line 716
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "dispose in incorrect state"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 737
    :cond_0
    :goto_0
    return-void

    .line 720
    :cond_1
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "dispose"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 721
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    if-eqz v2, :cond_0

    .line 725
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v1

    .line 726
    .local v1, "slotBase":Landroid/view/ViewGroup;
    new-instance v0, Landroid/os/Handler;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v0, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 728
    .local v0, "handler":Landroid/os/Handler;
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {v2}, Ltv/freewheel/renderers/temporal/VideoAdView;->dispose()V

    .line 730
    new-instance v2, Ltv/freewheel/renderers/temporal/VideoRenderer$3;

    invoke-direct {v2, p0, v1}, Ltv/freewheel/renderers/temporal/VideoRenderer$3;-><init>(Ltv/freewheel/renderers/temporal/VideoRenderer;Landroid/view/ViewGroup;)V

    invoke-virtual {v0, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method public getDuration()D
    .locals 6

    .prologue
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    .line 687
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->internalState:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v2

    sget v3, Ltv/freewheel/renderers/temporal/VideoRenderer;->STATE_STARTED:I

    if-eq v2, v3, :cond_1

    .line 688
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "getDuration in incorrect state"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 695
    :cond_0
    :goto_0
    return-wide v0

    .line 692
    :cond_1
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    if-eqz v2, :cond_0

    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {v2}, Ltv/freewheel/renderers/temporal/VideoAdView;->getDuration()D

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmpl-double v2, v2, v4

    if-lez v2, :cond_0

    .line 693
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {v0}, Ltv/freewheel/renderers/temporal/VideoAdView;->getDuration()D

    move-result-wide v0

    const-wide v2, 0x408f400000000000L    # 1000.0

    div-double/2addr v0, v2

    goto :goto_0
.end method

.method public getPlayheadTime()D
    .locals 4

    .prologue
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    .line 700
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->internalState:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v2

    sget v3, Ltv/freewheel/renderers/temporal/VideoRenderer;->STATE_STARTED:I

    if-eq v2, v3, :cond_1

    .line 701
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "getPlayheadTime in incorrect state"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 708
    :cond_0
    :goto_0
    return-wide v0

    .line 705
    :cond_1
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    if-eqz v2, :cond_0

    .line 706
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {v0}, Ltv/freewheel/renderers/temporal/VideoAdView;->getPlayheadTime()D

    move-result-wide v0

    const-wide v2, 0x408f400000000000L    # 1000.0

    div-double/2addr v0, v2

    goto :goto_0
.end method

.method public load(Ltv/freewheel/renderers/interfaces/IRendererContext;)V
    .locals 26
    .param p1, "rendererContext"    # Ltv/freewheel/renderers/interfaces/IRendererContext;

    .prologue
    .line 77
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    move-object/from16 v19, v0

    const-string v22, "init"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 78
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    .line 80
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/ad/interfaces/IConstants;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    .line 81
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v19

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    .line 83
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v19, v0

    const-string v22, "timeoutMillisecondsBeforeStart"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v16

    .line 84
    .local v16, "timeoutParam":Ljava/lang/Object;
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v19, v0

    const-string v22, "renderer.video.playbackUnexpectedPauseTimeout"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v10

    .line 85
    .local v10, "freezeParam":Ljava/lang/Object;
    if-eqz v16, :cond_0

    .line 86
    invoke-virtual/range {v16 .. v16}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v17

    .line 87
    .local v17, "timeoutStr":Ljava/lang/String;
    invoke-static/range {v17 .. v17}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v20

    .line 88
    .local v20, "val":D
    const-wide/16 v22, 0x0

    cmpl-double v19, v20, v22

    if-lez v19, :cond_0

    .line 89
    move-wide/from16 v0, v20

    move-object/from16 v2, p0

    iput-wide v0, v2, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutMillisecondsBeforeStart:D

    .line 92
    .end local v17    # "timeoutStr":Ljava/lang/String;
    .end local v20    # "val":D
    :cond_0
    if-eqz v10, :cond_1

    .line 93
    invoke-virtual {v10}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v11

    .line 94
    .local v11, "freezeStr":Ljava/lang/String;
    invoke-static {v11}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v20

    .line 95
    .restart local v20    # "val":D
    const-wide/16 v22, 0x0

    cmpl-double v19, v20, v22

    if-lez v19, :cond_1

    .line 96
    move-wide/from16 v0, v20

    move-object/from16 v2, p0

    iput-wide v0, v2, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutMillisecondsForAdFreeze:D

    .line 99
    .end local v11    # "freezeStr":Ljava/lang/String;
    .end local v20    # "val":D
    :cond_1
    move-object/from16 v0, p0

    iget-wide v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutMillisecondsBeforeStart:D

    move-wide/from16 v22, v0

    const-wide v24, 0x407f400000000000L    # 500.0

    div-double v22, v22, v24

    move-wide/from16 v0, v22

    double-to-int v0, v0

    move/from16 v19, v0

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutCountBeforeStart:I

    .line 100
    move-object/from16 v0, p0

    iget-wide v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutMillisecondsForAdFreeze:D

    move-wide/from16 v22, v0

    const-wide v24, 0x407f400000000000L    # 500.0

    div-double v22, v22, v24

    move-wide/from16 v0, v22

    double-to-int v0, v0

    move/from16 v19, v0

    move/from16 v0, v19

    int-to-double v0, v0

    move-wide/from16 v22, v0

    move-wide/from16 v0, v22

    move-object/from16 v2, p0

    iput-wide v0, v2, Ltv/freewheel/renderers/temporal/VideoRenderer;->timeoutCountForAdFreeze:D

    .line 102
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v19, v0

    const-string v22, "renderer.video.clickDetection"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    .line 103
    .local v5, "clickParam":Ljava/lang/Object;
    if-eqz v5, :cond_2

    .line 104
    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    .line 105
    .local v6, "clickParamStr":Ljava/lang/String;
    const-string v19, "false"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_2

    .line 108
    const/16 v19, 0x1

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-boolean v0, v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->clickHandledByPlayer:Z

    .line 110
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v19, v0

    const-string v22, "renderer.video.useControlPanel"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    .line 111
    .local v7, "controlParam":Ljava/lang/Object;
    if-eqz v7, :cond_2

    .line 112
    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    .line 113
    .local v8, "controlParamStr":Ljava/lang/String;
    const-string v19, "true"

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-boolean v0, v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->useControlPanel:Z

    .line 118
    .end local v6    # "clickParamStr":Ljava/lang/String;
    .end local v7    # "controlParam":Ljava/lang/Object;
    .end local v8    # "controlParamStr":Ljava/lang/String;
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v19, v0

    const-string v22, "renderer.video.checkRedirectURL"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    .line 119
    .local v4, "checkRedirectParam":Ljava/lang/Object;
    if-eqz v4, :cond_3

    .line 120
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v19

    const-string v22, "true"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_3

    .line 121
    const/16 v19, 0x1

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-boolean v0, v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->checkRedirectUrl:Z

    .line 125
    :cond_3
    invoke-direct/range {p0 .. p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->getBestFitRendition()Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-result-object v14

    .line 126
    .local v14, "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    if-nez v14, :cond_5

    .line 127
    new-instance v12, Landroid/os/Bundle;

    invoke-direct {v12}, Landroid/os/Bundle;-><init>()V

    .line 129
    .local v12, "info":Landroid/os/Bundle;
    move-object/from16 v0, p0

    iget-boolean v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->HLSDropped:Z

    move/from16 v19, v0

    if-eqz v19, :cond_4

    .line 131
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_UNKNOWN()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v12, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v19

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "HLS not supported on Android version "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    sget-object v23, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v12, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 139
    :goto_0
    new-instance v13, Ljava/util/HashMap;

    invoke-direct {v13}, Ljava/util/HashMap;-><init>()V

    .line 140
    .local v13, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v13, v0, v12}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 141
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-interface {v0, v1, v13}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 208
    .end local v12    # "info":Landroid/os/Bundle;
    .end local v13    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_1
    return-void

    .line 135
    .restart local v12    # "info":Landroid/os/Bundle;
    :cond_4
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_NULL_ASSET()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v12, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 136
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v19

    const-string v22, "No asset"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v12, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 145
    .end local v12    # "info":Landroid/os/Bundle;
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    move-object/from16 v19, v0

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "Best fit rendition "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual {v14}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 146
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-interface {v0, v14}, Ltv/freewheel/ad/interfaces/IAdInstance;->setActiveCreativeRendition(Ltv/freewheel/ad/interfaces/ICreativeRendition;)V

    .line 147
    invoke-interface {v14}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getDuration()D

    move-result-wide v22

    move-wide/from16 v0, v22

    move-object/from16 v2, p0

    iput-wide v0, v2, Ltv/freewheel/renderers/temporal/VideoRenderer;->estimatedDuration:D

    .line 148
    invoke-interface {v14}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getWidth()I

    move-result v19

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->renditionWidth:I

    .line 149
    invoke-interface {v14}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getHeight()I

    move-result v19

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->renditionHeight:I

    .line 150
    move-object/from16 v0, p0

    iget v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->renditionWidth:I

    move/from16 v19, v0

    if-gtz v19, :cond_6

    .line 151
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/ISlot;->getWidth()I

    move-result v19

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->renditionWidth:I

    .line 153
    :cond_6
    move-object/from16 v0, p0

    iget v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->renditionHeight:I

    move/from16 v19, v0

    if-gtz v19, :cond_7

    .line 154
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/ISlot;->getHeight()I

    move-result v19

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->renditionHeight:I

    .line 157
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_QUARTILE()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v23, v0

    invoke-interface/range {v23 .. v23}, Ltv/freewheel/ad/interfaces/IConstants;->CAPABILITY_STATUS_ON()I

    move-result v23

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    move/from16 v2, v23

    invoke-interface {v0, v1, v2}, Ltv/freewheel/renderers/interfaces/IRendererContext;->setRendererCapability(Ljava/lang/String;I)V

    .line 158
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_MUTE()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v23, v0

    invoke-interface/range {v23 .. v23}, Ltv/freewheel/ad/interfaces/IConstants;->CAPABILITY_STATUS_ON()I

    move-result v23

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    move/from16 v2, v23

    invoke-interface {v0, v1, v2}, Ltv/freewheel/renderers/interfaces/IRendererContext;->setRendererCapability(Ljava/lang/String;I)V

    .line 159
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_UNMUTE()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v23, v0

    invoke-interface/range {v23 .. v23}, Ltv/freewheel/ad/interfaces/IConstants;->CAPABILITY_STATUS_ON()I

    move-result v23

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    move/from16 v2, v23

    invoke-interface {v0, v1, v2}, Ltv/freewheel/renderers/interfaces/IRendererContext;->setRendererCapability(Ljava/lang/String;I)V

    .line 160
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_PAUSE()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v23, v0

    invoke-interface/range {v23 .. v23}, Ltv/freewheel/ad/interfaces/IConstants;->CAPABILITY_STATUS_ON()I

    move-result v23

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    move/from16 v2, v23

    invoke-interface {v0, v1, v2}, Ltv/freewheel/renderers/interfaces/IRendererContext;->setRendererCapability(Ljava/lang/String;I)V

    .line 161
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_RESUME()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v23, v0

    invoke-interface/range {v23 .. v23}, Ltv/freewheel/ad/interfaces/IConstants;->CAPABILITY_STATUS_ON()I

    move-result v23

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    move/from16 v2, v23

    invoke-interface {v0, v1, v2}, Ltv/freewheel/renderers/interfaces/IRendererContext;->setRendererCapability(Ljava/lang/String;I)V

    .line 163
    invoke-interface {v14}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v19

    if-eqz v19, :cond_8

    .line 164
    invoke-interface {v14}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v19

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;->getURL()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    .line 169
    :goto_2
    move-object/from16 v0, p0

    iget-object v15, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    .line 171
    .local v15, "s":Ljava/lang/String;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    move-object/from16 v19, v0

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "assetUrl passed in: "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    move-object/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 172
    new-instance v18, Ljava/net/URI;

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-direct/range {v18 .. v19}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    .line 173
    .local v18, "uri":Ljava/net/URI;
    invoke-virtual/range {v18 .. v18}, Ljava/net/URI;->isAbsolute()Z

    move-result v19

    if-nez v19, :cond_9

    .line 174
    new-instance v12, Landroid/os/Bundle;

    invoke-direct {v12}, Landroid/os/Bundle;-><init>()V

    .line 175
    .restart local v12    # "info":Landroid/os/Bundle;
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_NULL_ASSET()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v12, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v19

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "original assetUrl: "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v12, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 177
    new-instance v13, Ljava/util/HashMap;

    invoke-direct {v13}, Ljava/util/HashMap;-><init>()V

    .line 178
    .restart local v13    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v13, v0, v12}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 179
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-interface {v0, v1, v13}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_1

    .line 189
    .end local v12    # "info":Landroid/os/Bundle;
    .end local v13    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v18    # "uri":Ljava/net/URI;
    :catch_0
    move-exception v9

    .line 190
    .local v9, "e":Ljava/net/URISyntaxException;
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-static/range {v19 .. v19}, Ltv/freewheel/utils/URIUtil;->getFixedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    .line 191
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    move-object/from16 v19, v0

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "assetUrl fixed: "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    move-object/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 192
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    move-object/from16 v19, v0

    if-nez v19, :cond_b

    .line 193
    new-instance v12, Landroid/os/Bundle;

    invoke-direct {v12}, Landroid/os/Bundle;-><init>()V

    .line 194
    .restart local v12    # "info":Landroid/os/Bundle;
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_NULL_ASSET()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v12, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 195
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v19

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "original assetUrl: "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, ", fixed assetUrl: "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    move-object/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v12, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    new-instance v13, Ljava/util/HashMap;

    invoke-direct {v13}, Ljava/util/HashMap;-><init>()V

    .line 197
    .restart local v13    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v13, v0, v12}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 198
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-interface {v0, v1, v13}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_1

    .line 166
    .end local v9    # "e":Ljava/net/URISyntaxException;
    .end local v12    # "info":Landroid/os/Bundle;
    .end local v13    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v15    # "s":Ljava/lang/String;
    :cond_8
    const-string v19, ""

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    goto/16 :goto_2

    .line 181
    .restart local v15    # "s":Ljava/lang/String;
    .restart local v18    # "uri":Ljava/net/URI;
    :cond_9
    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    move-object/from16 v19, v0

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "converted to URI: "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v18 .. v18}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 182
    move-object/from16 v0, p0

    iget-boolean v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->supportPreload:Z

    move/from16 v19, v0

    if-eqz v19, :cond_a

    .line 183
    invoke-direct/range {p0 .. p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->startQuartileImpressionAndTimeoutTimer()V

    .line 184
    invoke-direct/range {p0 .. p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->preload()V

    goto/16 :goto_1

    .line 186
    :cond_a
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_LOADED()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/net/URISyntaxException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1

    .line 200
    .end local v18    # "uri":Ljava/net/URI;
    .restart local v9    # "e":Ljava/net/URISyntaxException;
    :cond_b
    move-object/from16 v0, p0

    iget-boolean v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->supportPreload:Z

    move/from16 v19, v0

    if-eqz v19, :cond_c

    .line 201
    invoke-direct/range {p0 .. p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->startQuartileImpressionAndTimeoutTimer()V

    .line 202
    invoke-direct/range {p0 .. p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->preload()V

    goto/16 :goto_1

    .line 204
    :cond_c
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_LOADED()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    goto/16 :goto_1
.end method

.method public onAdMuted()V
    .locals 2

    .prologue
    .line 518
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onAdMuted"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 519
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_MUTE()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 520
    return-void
.end method

.method public onAdPaused()V
    .locals 2

    .prologue
    .line 503
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onAdPaused"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 504
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_PAUSE()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 505
    return-void
.end method

.method public onAdResumed()V
    .locals 2

    .prologue
    .line 508
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onAdResumed"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 509
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_RESUME()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 510
    return-void
.end method

.method public onAdRewind()V
    .locals 2

    .prologue
    .line 513
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onAdRewind"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 514
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_REWIND()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 515
    return-void
.end method

.method public onAdUnMuted()V
    .locals 2

    .prologue
    .line 523
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onAdUnMuted"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 524
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_UNMUTE()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 525
    return-void
.end method

.method public onAdVideoViewComplete()V
    .locals 2

    .prologue
    .line 465
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onAdVideoViewComplete"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 467
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->stopQuartileTimer()V

    .line 468
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->sendMissingQuartiles()V

    .line 469
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_STOPPED()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 470
    return-void
.end method

.method public onAdVideoViewError(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "info"    # Landroid/os/Bundle;

    .prologue
    .line 476
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "onAdVideoViewError: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 478
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->stopQuartileTimer()V

    .line 479
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 480
    .local v0, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 481
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 482
    return-void
.end method

.method public onAdViewBuffered(Z)V
    .locals 2
    .param p1, "end"    # Z

    .prologue
    .line 811
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    if-eqz p1, :cond_0

    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v0}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_BUFFERING_END()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-interface {v1, v0}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 812
    return-void

    .line 811
    :cond_0
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v0}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_BUFFERING_START()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public onAdViewClicked()V
    .locals 3

    .prologue
    .line 485
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onAdViewClicked, clickHandleByPlayer "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->clickHandledByPlayer:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 486
    iget-boolean v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->clickHandledByPlayer:Z

    if-nez v0, :cond_0

    .line 487
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_CLICK()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 489
    :cond_0
    return-void
.end method

.method public onAdViewLoaded()V
    .locals 2

    .prologue
    .line 532
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onAdViewLoaded"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 534
    iget-boolean v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->supportPreload:Z

    if-eqz v0, :cond_0

    .line 535
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->stopQuartileTimer()V

    .line 537
    :cond_0
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    if-eqz v0, :cond_1

    .line 538
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_LOADED()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 540
    :cond_1
    return-void
.end method

.method public onAdViewMediaPrepared()V
    .locals 3

    .prologue
    .line 543
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onAdViewMediaPrepared. Renderer paused "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->isPaused:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 544
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->isPaused:Z

    if-nez v0, :cond_0

    .line 545
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {v0}, Ltv/freewheel/renderers/temporal/VideoAdView;->startPlayback()V

    .line 547
    :cond_0
    return-void
.end method

.method public onAdViewStart()V
    .locals 2

    .prologue
    .line 492
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onAdViewStart"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 499
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->startQuartileImpressionAndTimeoutTimer()V

    .line 500
    return-void
.end method

.method public onAdViewSurfaceDestroyed()V
    .locals 0

    .prologue
    .line 763
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->stopQuartileTimer()V

    .line 764
    return-void
.end method

.method public onRedirectUrlChecked(Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 7
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "error"    # Ljava/lang/Exception;

    .prologue
    .line 409
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "onRedirectUrlChecked url "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 410
    if-eqz p2, :cond_1

    .line 411
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 412
    .local v2, "info":Landroid/os/Bundle;
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_UNKNOWN()Ljava/lang/String;

    move-result-object v0

    .line 413
    .local v0, "errorCode":Ljava/lang/String;
    instance-of v4, p2, Ljava/net/SocketTimeoutException;

    if-eqz v4, :cond_0

    .line 414
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_TIMEOUT()Ljava/lang/String;

    move-result-object v0

    .line 416
    :cond_0
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 417
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 418
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 419
    .local v3, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 420
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v5, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v5}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v3}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 435
    .end local v0    # "errorCode":Ljava/lang/String;
    .end local v2    # "info":Landroid/os/Bundle;
    .end local v3    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_0
    return-void

    .line 422
    :cond_1
    iput-object p1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->assetUrl:Ljava/lang/String;

    .line 423
    iget-boolean v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->supportPreload:Z

    if-eqz v4, :cond_2

    .line 424
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {v4}, Ltv/freewheel/renderers/temporal/VideoAdView;->loadContent()V

    goto :goto_0

    .line 426
    :cond_2
    new-instance v1, Landroid/os/Handler;

    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v4

    invoke-direct {v1, v4}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 427
    .local v1, "handler":Landroid/os/Handler;
    new-instance v4, Ltv/freewheel/renderers/temporal/VideoRenderer$1;

    invoke-direct {v4, p0}, Ltv/freewheel/renderers/temporal/VideoRenderer$1;-><init>(Ltv/freewheel/renderers/temporal/VideoRenderer;)V

    invoke-virtual {v1, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method public start()V
    .locals 4

    .prologue
    .line 442
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "start"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 443
    const/4 v2, 0x0

    iput-boolean v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->defaultImpressionSent:Z

    .line 444
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->startQuartileImpressionAndTimeoutTimer()V

    .line 445
    iget-boolean v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->supportPreload:Z

    if-eqz v2, :cond_0

    .line 446
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v1

    .line 447
    .local v1, "slotBase":Landroid/view/ViewGroup;
    new-instance v0, Landroid/os/Handler;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v0, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 448
    .local v0, "handler":Landroid/os/Handler;
    new-instance v2, Ltv/freewheel/renderers/temporal/VideoRenderer$2;

    invoke-direct {v2, p0, v1}, Ltv/freewheel/renderers/temporal/VideoRenderer$2;-><init>(Ltv/freewheel/renderers/temporal/VideoRenderer;Landroid/view/ViewGroup;)V

    invoke-virtual {v0, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 459
    .end local v0    # "handler":Landroid/os/Handler;
    .end local v1    # "slotBase":Landroid/view/ViewGroup;
    :goto_0
    return-void

    .line 457
    :cond_0
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->preload()V

    goto :goto_0
.end method

.method public stop()V
    .locals 3

    .prologue
    .line 620
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->internalState:Ljava/util/concurrent/atomic/AtomicInteger;

    sget v1, Ltv/freewheel/renderers/temporal/VideoRenderer;->STATE_STARTED:I

    sget v2, Ltv/freewheel/renderers/temporal/VideoRenderer;->STATE_STOPPED:I

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v0

    if-nez v0, :cond_0

    .line 621
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "stop in incorrect state"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 632
    :goto_0
    return-void

    .line 625
    :cond_0
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 626
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->stopQuartileTimer()V

    .line 627
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    if-eqz v0, :cond_1

    .line 628
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {v0}, Ltv/freewheel/renderers/temporal/VideoAdView;->stop()V

    .line 631
    :cond_1
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_STOPPED()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    goto :goto_0
.end method
