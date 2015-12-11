.class public Ltv/freewheel/hybrid/renderers/vast/VastTranslator;
.super Ljava/lang/Object;
.source "VastTranslator.java"

# interfaces
.implements Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;


# instance fields
.field private constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

.field private context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

.field private httpLoader:Ltv/freewheel/hybrid/utils/URLLoader;

.field private loadCompleteListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

.field private loadFailedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

.field private logger:Ltv/freewheel/hybrid/utils/Logger;

.field private originalActiveRendition:Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

.field private stopped:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

.field private vastURL:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 371
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->stopped:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 442
    new-instance v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$3;

    invoke-direct {v0, p0}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$3;-><init>(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->loadCompleteListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    .line 450
    new-instance v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$4;

    invoke-direct {v0, p0}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$4;-><init>(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->loadFailedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    .line 47
    const/4 v0, 0x1

    invoke-static {p0, v0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;Z)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 48
    new-instance v0, Ltv/freewheel/hybrid/utils/URLLoader;

    invoke-direct {v0}, Ltv/freewheel/hybrid/utils/URLLoader;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->httpLoader:Ltv/freewheel/hybrid/utils/URLLoader;

    .line 49
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->httpLoader:Ltv/freewheel/hybrid/utils/URLLoader;

    const-string v1, "URLLoader.Load.Complete"

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->loadCompleteListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/hybrid/utils/URLLoader;->addEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 50
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->httpLoader:Ltv/freewheel/hybrid/utils/URLLoader;

    const-string v1, "URLLoader.Load.Error"

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->loadFailedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/hybrid/utils/URLLoader;->addEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 51
    return-void
.end method

.method private _stop()V
    .locals 3

    .prologue
    .line 373
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->stopped:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 385
    :goto_0
    return-void

    .line 375
    :cond_0
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->stopped:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 376
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 377
    .local v0, "mainVideoHandler":Landroid/os/Handler;
    new-instance v1, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$1;

    invoke-direct {v1, p0}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$1;-><init>(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method static synthetic access$000(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)Ltv/freewheel/hybrid/utils/URLLoader;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    .prologue
    .line 34
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->httpLoader:Ltv/freewheel/hybrid/utils/URLLoader;

    return-object v0
.end method

.method static synthetic access$100(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    .prologue
    .line 34
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    return-object v0
.end method

.method static synthetic access$200(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    .prologue
    .line 34
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    return-object v0
.end method

.method static synthetic access$300(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/vast/VastTranslator;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 34
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->parseVastResponse(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$400(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;)Ltv/freewheel/hybrid/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/vast/VastTranslator;

    .prologue
    .line 34
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    return-object v0
.end method

.method static synthetic access$500(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/vast/VastTranslator;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 34
    invoke-direct {p0, p1, p2}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private checkCompatibilityWithSDK()Z
    .locals 3

    .prologue
    .line 418
    :try_start_0
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getVersion()I
    :try_end_0
    .catch Ljava/lang/NoSuchMethodError; {:try_start_0 .. :try_end_0} :catch_0

    .line 423
    const/4 v1, 0x1

    :goto_0
    return v1

    .line 419
    :catch_0
    move-exception v0

    .line 420
    .local v0, "e":Ljava/lang/NoSuchMethodError;
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_RENDERER_INIT()Ljava/lang/String;

    move-result-object v1

    const-string v2, "VastTranslator only compatible with SDK version >= 4.1"

    invoke-direct {p0, v1, v2}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    .line 421
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private configureCreative(Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;ILjava/util/ArrayList;)V
    .locals 11
    .param p1, "adInstance"    # Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .param p2, "ad"    # Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;
    .param p3, "type"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;",
            "Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;",
            "I",
            "Ljava/util/ArrayList",
            "<+",
            "Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p4, "renditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<+Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;>;"
    const/4 v10, 0x1

    .line 235
    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "configureCreative("

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ", type:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ")"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 236
    iget-object v7, p2, Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;->creatives:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/renderers/vast/model/Creative;

    .line 237
    .local v1, "creative":Ltv/freewheel/hybrid/renderers/vast/model/Creative;
    iget-object v7, v1, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->linear:Ltv/freewheel/hybrid/renderers/vast/model/Linear;

    if-eqz v7, :cond_2

    if-ne p3, v10, :cond_0

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v7

    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v7

    iget-object v8, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v8}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_OVERLAY()I

    move-result v8

    if-ne v7, v8, :cond_1

    :cond_0
    if-nez p3, :cond_2

    iget-object v7, v1, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->linear:Ltv/freewheel/hybrid/renderers/vast/model/Linear;

    iget-object v8, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v8}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v8

    iget-object v9, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-virtual {v7, v8, v9}, Ltv/freewheel/hybrid/renderers/vast/model/Linear;->isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 240
    :cond_1
    iget-object v7, v1, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->linear:Ltv/freewheel/hybrid/renderers/vast/model/Linear;

    invoke-direct {p0, p1, v7}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->configureVideoClicks(Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/renderers/vast/model/Linear;)V

    .line 242
    :cond_2
    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v7}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v7

    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v7

    iget-object v8, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-virtual {v1, v7, v8}, Ltv/freewheel/hybrid/renderers/vast/model/Creative;->getTrackingEvents(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Ljava/util/ArrayList;

    move-result-object v7

    invoke-direct {p0, p1, v7}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->configureTracking(Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ljava/util/ArrayList;)V

    goto :goto_0

    .line 245
    .end local v1    # "creative":Ltv/freewheel/hybrid/renderers/vast/model/Creative;
    :cond_3
    if-nez p3, :cond_4

    .line 246
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    invoke-virtual {p4}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-ge v2, v7, :cond_5

    .line 247
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->createCreativeRenditionForTranslation()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    move-result-object v5

    .line 248
    .local v5, "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    invoke-virtual {p4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;

    .line 249
    .local v6, "vastRendition":Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;
    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v7}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v7

    iget-object v8, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-virtual {v6, v5, p1, v7, v8}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->translateToFWCreativeRendition(Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)V

    .line 250
    const-string v7, "Translated vast rendition(InLine)  "

    invoke-virtual {v6}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {p0, v7, v8}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->printMultilineLog(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 253
    .end local v2    # "i":I
    .end local v5    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    .end local v6    # "vastRendition":Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;
    :cond_4
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->createCreativeRenditionForTranslation()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    move-result-object v5

    .line 254
    .restart local v5    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    const-string v7, "external/vast-2"

    invoke-interface {v5, v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->setWrapperType(Ljava/lang/String;)V

    .line 255
    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    iget-object v7, v7, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;

    iget-object v7, v7, Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;->vastAdTagUri:Ljava/lang/String;

    invoke-interface {v5, v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->setWrapperURL(Ljava/lang/String;)V

    .line 256
    invoke-virtual {p4}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lez v7, :cond_6

    .line 257
    const/4 v7, 0x0

    invoke-virtual {p4, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;

    .line 258
    .restart local v6    # "vastRendition":Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;
    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v7}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v7

    iget-object v8, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-virtual {v6, v5, p1, v7, v8}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->translateToFWCreativeRendition(Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)V

    .line 259
    const-string v7, "Translated vast rendition(Wrapper)  "

    invoke-virtual {v6}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {p0, v7, v8}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->printMultilineLog(Ljava/lang/String;Ljava/lang/String;)V

    .line 277
    .end local v5    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    .end local v6    # "vastRendition":Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;
    :cond_5
    :goto_2
    return-void

    .line 261
    .restart local v5    # "rendition":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    :cond_6
    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->originalActiveRendition:Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    if-eqz v7, :cond_7

    .line 262
    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->originalActiveRendition:Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getWidth()I

    move-result v7

    invoke-interface {v5, v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->setWidth(I)V

    .line 263
    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->originalActiveRendition:Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getHeight()I

    move-result v7

    invoke-interface {v5, v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->setHeight(I)V

    .line 264
    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->originalActiveRendition:Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->setContentType(Ljava/lang/String;)V

    .line 265
    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->originalActiveRendition:Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v4

    .line 266
    .local v4, "originalAsset":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;
    const-string v7, "VAST_generated_placeholder_asset"

    invoke-interface {v5, v7, v10}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->createCreativeRenditionAssetForTranslation(Ljava/lang/String;Z)Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v0

    .line 267
    .local v0, "asset":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;
    if-eqz v4, :cond_8

    .line 268
    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->getContentType()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v0, v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->setContentType(Ljava/lang/String;)V

    .line 269
    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->getMimeType()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v0, v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->setMimeType(Ljava/lang/String;)V

    .line 274
    .end local v0    # "asset":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;
    .end local v4    # "originalAsset":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;
    :cond_7
    :goto_3
    const-string v7, "Translated rendition(empty Wrapper)  "

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {p0, v7, v8}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->printMultilineLog(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 271
    .restart local v0    # "asset":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;
    .restart local v4    # "originalAsset":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;
    :cond_8
    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->originalActiveRendition:Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v0, v7}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->setContentType(Ljava/lang/String;)V

    goto :goto_3
.end method

.method private configureDrivingAdInstance(Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ljava/util/ArrayList;)V
    .locals 9
    .param p1, "adInstance"    # Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;",
            "Ljava/util/ArrayList",
            "<+",
            "Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 185
    .local p2, "renditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<+Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;>;"
    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "configureDrivingAdInstance("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ")"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 186
    const/4 v2, 0x0

    .line 187
    .local v2, "impressions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/renderers/vast/model/Impression;>;"
    const/4 v3, -0x1

    .line 188
    .local v3, "type":I
    const/4 v5, 0x0

    .line 189
    .local v5, "vastAd":Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;
    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    iget-object v6, v6, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->inLine:Ltv/freewheel/hybrid/renderers/vast/model/InLine;

    if-eqz v6, :cond_1

    .line 190
    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "configureAdInstance("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ") inline"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 192
    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    iget-object v6, v6, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->inLine:Ltv/freewheel/hybrid/renderers/vast/model/InLine;

    iget-object v2, v6, Ltv/freewheel/hybrid/renderers/vast/model/InLine;->impressions:Ljava/util/ArrayList;

    .line 193
    const/4 v3, 0x0

    .line 194
    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    iget-object v5, v6, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->inLine:Ltv/freewheel/hybrid/renderers/vast/model/InLine;

    .line 209
    :goto_0
    if-eqz v2, :cond_5

    .line 210
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 211
    .local v4, "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/renderers/vast/model/Impression;

    .line 212
    .local v1, "impr":Ltv/freewheel/hybrid/renderers/vast/model/Impression;
    invoke-virtual {v1}, Ltv/freewheel/hybrid/renderers/vast/model/Impression;->isValid()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 213
    iget-object v6, v1, Ltv/freewheel/hybrid/renderers/vast/model/Impression;->url:Ljava/lang/String;

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 195
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "impr":Ltv/freewheel/hybrid/renderers/vast/model/Impression;
    .end local v4    # "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_1
    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    iget-object v6, v6, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;

    if-eqz v6, :cond_2

    .line 196
    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "configureAdInstance("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ") wrapper"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 197
    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    iget-object v6, v6, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;

    iget-object v2, v6, Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;->impressions:Ljava/util/ArrayList;

    .line 198
    const/4 v3, 0x1

    .line 199
    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    iget-object v5, v6, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;

    goto :goto_0

    .line 205
    :cond_2
    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "configureAdInstance("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ") other"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 222
    :cond_3
    :goto_2
    return-void

    .line 215
    .restart local v0    # "i$":Ljava/util/Iterator;
    .restart local v4    # "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_4
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-lez v6, :cond_5

    .line 216
    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_IMPRESSION()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_IMPRESSION()Ljava/lang/String;

    move-result-object v7

    invoke-interface {p1, v6, v7, v4}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 219
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v4    # "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_5
    const/4 v6, -0x1

    if-eq v3, v6, :cond_3

    .line 220
    invoke-direct {p0, p1, v5, v3, p2}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->configureCreative(Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/renderers/vast/model/AbstractAd;ILjava/util/ArrayList;)V

    goto :goto_2
.end method

.method private configureTracking(Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ljava/util/ArrayList;)V
    .locals 6
    .param p1, "adInstance"    # Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/renderers/vast/model/Tracking;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 304
    .local p2, "trackingEvents":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/renderers/vast/model/Tracking;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 305
    .local v2, "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "trackings:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p2}, Ljava/util/ArrayList;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 306
    invoke-virtual {p2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_10

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;

    .line 307
    .local v1, "tracking":Ltv/freewheel/hybrid/renderers/vast/model/Tracking;
    invoke-virtual {v1}, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->isValid()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 309
    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 310
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->url:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 311
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "creativeView"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "start"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 313
    :cond_1
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_IMPRESSION()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_IMPRESSION()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_0

    .line 315
    :cond_2
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "midpoint"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 316
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_MIDPOINT()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_IMPRESSION()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_0

    .line 318
    :cond_3
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "firstQuartile"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 319
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_FIRST_QUARTILE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_IMPRESSION()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_0

    .line 321
    :cond_4
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "thirdQuartile"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 322
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_THIRD_QUARTILE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_IMPRESSION()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 324
    :cond_5
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "complete"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 325
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_COMPLETE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_IMPRESSION()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 327
    :cond_6
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "mute"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 328
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_MUTE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 330
    :cond_7
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "unmute"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 331
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_UNMUTE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 333
    :cond_8
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "pause"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 334
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_PAUSE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 336
    :cond_9
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "resume"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_a

    .line 337
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_RESUME()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 339
    :cond_a
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "rewind"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_b

    .line 340
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_REWIND()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 342
    :cond_b
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "expand"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_c

    .line 343
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_EXPAND()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 345
    :cond_c
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "fullscreen"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_d

    .line 346
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_EXPAND()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 348
    :cond_d
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "collapse"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_e

    .line 349
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_COLLAPSE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 351
    :cond_e
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "acceptInvitation"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_f

    .line 352
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_ACCEPT_INVITATION()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 354
    :cond_f
    iget-object v3, v1, Ltv/freewheel/hybrid/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "close"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 355
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_CLOSE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 359
    .end local v1    # "tracking":Ltv/freewheel/hybrid/renderers/vast/model/Tracking;
    :cond_10
    return-void
.end method

.method private configureVideoClicks(Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/renderers/vast/model/Linear;)V
    .locals 6
    .param p1, "adInstance"    # Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .param p2, "linear"    # Ltv/freewheel/hybrid/renderers/vast/model/Linear;

    .prologue
    .line 280
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v5, "configureEventCallbacks()"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 281
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 282
    .local v3, "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v4, p2, Ltv/freewheel/hybrid/renderers/vast/model/Linear;->videoClicks:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/renderers/vast/model/VideoClick;

    .line 283
    .local v0, "click":Ltv/freewheel/hybrid/renderers/vast/model/VideoClick;
    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/vast/model/VideoClick;->isValid()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 285
    iget-object v4, v0, Ltv/freewheel/hybrid/renderers/vast/model/VideoClick;->type:Ljava/lang/String;

    const-string v5, "ClickThrough"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 286
    iget-object v4, v0, Ltv/freewheel/hybrid/renderers/vast/model/VideoClick;->url:Ljava/lang/String;

    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v5}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_CLICK()Ljava/lang/String;

    move-result-object v5

    invoke-interface {p1, v4, v5}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->setClickThroughURL(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 288
    :cond_1
    iget-object v4, v0, Ltv/freewheel/hybrid/renderers/vast/model/VideoClick;->type:Ljava/lang/String;

    const-string v5, "ClickTracking"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 289
    iget-object v4, v0, Ltv/freewheel/hybrid/renderers/vast/model/VideoClick;->url:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 291
    :cond_2
    iget-object v4, v0, Ltv/freewheel/hybrid/renderers/vast/model/VideoClick;->type:Ljava/lang/String;

    const-string v5, "CustomClick"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 292
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 293
    .local v1, "clickTrackingURLs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v4, v0, Ltv/freewheel/hybrid/renderers/vast/model/VideoClick;->url:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 294
    iget-object v4, v0, Ltv/freewheel/hybrid/renderers/vast/model/VideoClick;->id:Ljava/lang/String;

    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v5}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_CLICK_TRACKING()Ljava/lang/String;

    move-result-object v5

    invoke-interface {p1, v4, v5, v1}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_0

    .line 297
    .end local v0    # "click":Ltv/freewheel/hybrid/renderers/vast/model/VideoClick;
    .end local v1    # "clickTrackingURLs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_3
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lez v4, :cond_4

    .line 298
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_CLICK()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v5}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_CLICK_TRACKING()Ljava/lang/String;

    move-result-object v5

    invoke-interface {p1, v4, v5, v3}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 301
    :cond_4
    return-void
.end method

.method private failWithError(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "errorCode"    # Ljava/lang/String;
    .param p2, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 427
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "failWithError("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ")"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 428
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 429
    .local v0, "info":Landroid/os/Bundle;
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 430
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " wrapperURL: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 431
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 432
    .local v2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 433
    new-instance v1, Landroid/os/Handler;

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v3}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v3

    invoke-direct {v1, v3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 434
    .local v1, "mainVideoHandler":Landroid/os/Handler;
    new-instance v3, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$2;

    invoke-direct {v3, p0, v2}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator$2;-><init>(Ltv/freewheel/hybrid/renderers/vast/VastTranslator;Ljava/util/HashMap;)V

    invoke-virtual {v1, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 440
    return-void
.end method

.method private parseVastResponse(Ljava/lang/String;)V
    .locals 3
    .param p1, "data"    # Ljava/lang/String;

    .prologue
    .line 64
    new-instance v0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-direct {v0, v1}, Ltv/freewheel/hybrid/renderers/vast/model/Vast;-><init>(Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    .line 66
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->parse(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 67
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Vast document parsed, "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 68
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->startTranslateAd()V

    .line 79
    :goto_0
    return-void

    .line 70
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    iget v0, v0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorCode:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_2

    .line 71
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_NO_AD_AVAILABLE()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    iget-object v1, v1, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorMessage:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    :cond_1
    :goto_1
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    goto :goto_0

    .line 72
    :cond_2
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    iget v0, v0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorCode:I

    if-nez v0, :cond_3

    .line 73
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_PARSE()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    iget-object v1, v1, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorMessage:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 74
    :cond_3
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    iget v0, v0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorCode:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 75
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_UNSUPPORTED_3P_FEATURE()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    iget-object v1, v1, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->errorMessage:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method private printMultilineLog(Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "head"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 225
    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p2

    .line 226
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v5

    if-nez v5, :cond_1

    .line 232
    :cond_0
    return-void

    .line 227
    :cond_1
    const/4 v3, 0x1

    .line 228
    .local v3, "linenum":I
    const-string v5, "\n"

    invoke-virtual {p2, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .local v0, "arr$":[Ljava/lang/String;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v4, v0, v1

    .line 229
    .local v4, "log":Ljava/lang/String;
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ":"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 230
    add-int/lit8 v3, v3, 0x1

    .line 228
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method private sendRequest(Ljava/lang/String;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 54
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Loading VAST document from: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 55
    new-instance v0, Ltv/freewheel/hybrid/utils/URLRequest;

    const-string v1, "http.agent"

    invoke-static {v1}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p1, v1}, Ltv/freewheel/hybrid/utils/URLRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    .local v0, "req":Ltv/freewheel/hybrid/utils/URLRequest;
    const/4 v1, 0x1

    iput v1, v0, Ltv/freewheel/hybrid/utils/URLRequest;->method:I

    .line 58
    const-string v1, "text/plain"

    iput-object v1, v0, Ltv/freewheel/hybrid/utils/URLRequest;->contentType:Ljava/lang/String;

    .line 60
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->httpLoader:Ltv/freewheel/hybrid/utils/URLLoader;

    invoke-virtual {v1, v0}, Ltv/freewheel/hybrid/utils/URLLoader;->load(Ltv/freewheel/hybrid/utils/URLRequest;)V

    .line 61
    return-void
.end method

.method private startTranslateAd()V
    .locals 22

    .prologue
    .line 124
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v17, v0

    const-string v18, "startTranslateAd()"

    invoke-virtual/range {v17 .. v18}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 125
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    move-object/from16 v17, v0

    if-eqz v17, :cond_9

    .line 127
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->getRenditionsInDrivingSlot()Ljava/util/ArrayList;

    move-result-object v10

    .line 128
    .local v10, "drivingRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<+Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;>;"
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 129
    .local v4, "companionMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/renderers/vast/model/Companion;>;"
    new-instance v14, Ljava/util/ArrayList;

    invoke-direct {v14}, Ljava/util/ArrayList;-><init>()V

    .line 131
    .local v14, "preparedSlots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/hybrid/renderers/vast/model/Wrapper;

    move-object/from16 v17, v0

    if-nez v17, :cond_0

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->inLine:Ltv/freewheel/hybrid/renderers/vast/model/InLine;

    move-object/from16 v17, v0

    if-eqz v17, :cond_1

    invoke-virtual {v10}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v17

    if-nez v17, :cond_1

    .line 132
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-object/from16 v17, v0

    invoke-interface/range {v17 .. v17}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v17

    invoke-interface/range {v17 .. v17}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v14, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 135
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-object/from16 v17, v0

    invoke-interface/range {v17 .. v17}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getCompanionSlots()Ljava/util/ArrayList;

    move-result-object v7

    .line 136
    .local v7, "companionSlots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    new-instance v13, Ljava/util/ArrayList;

    invoke-direct {v13}, Ljava/util/ArrayList;-><init>()V

    .line 137
    .local v13, "matchedCompanions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/renderers/vast/model/Companion;>;"
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_0
    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v17

    move/from16 v0, v17

    if-ge v11, v0, :cond_4

    .line 139
    invoke-virtual {v7, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 140
    .local v6, "companionSlot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    invoke-virtual {v14, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 141
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vast:Ltv/freewheel/hybrid/renderers/vast/model/Vast;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v6}, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->getCompanionRenditions(Ltv/freewheel/hybrid/ad/interfaces/ISlot;)Ljava/util/ArrayList;

    move-result-object v5

    .line 142
    .local v5, "companionRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<+Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;>;"
    invoke-virtual {v5, v13}, Ljava/util/ArrayList;->removeAll(Ljava/util/Collection;)Z

    .line 143
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v17

    if-lez v17, :cond_2

    .line 144
    invoke-static {v5, v6}, Ltv/freewheel/hybrid/renderers/vast/model/Vast;->match(Ljava/util/ArrayList;Ltv/freewheel/hybrid/ad/interfaces/ISlot;)Ltv/freewheel/hybrid/renderers/vast/model/Companion;

    move-result-object v15

    .line 145
    .local v15, "rend":Ltv/freewheel/hybrid/renderers/vast/model/Companion;
    if-eqz v15, :cond_3

    .line 146
    invoke-virtual {v4, v6, v15}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 147
    invoke-virtual {v13, v15}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 137
    .end local v15    # "rend":Ltv/freewheel/hybrid/renderers/vast/model/Companion;
    :cond_2
    :goto_1
    add-int/lit8 v11, v11, 0x1

    goto :goto_0

    .line 149
    .restart local v15    # "rend":Ltv/freewheel/hybrid/renderers/vast/model/Companion;
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v17, v0

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "No matching rendition for companion slot:"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_1

    .line 153
    .end local v5    # "companionRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<+Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;>;"
    .end local v6    # "companionSlot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .end local v15    # "rend":Ltv/freewheel/hybrid/renderers/vast/model/Companion;
    :cond_4
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-interface {v0, v14}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->scheduleAdInstances(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v16

    .line 154
    .local v16, "scheduledAds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;>;"
    new-instance v3, Ljava/util/ArrayList;

    invoke-virtual/range {v16 .. v16}, Ljava/util/ArrayList;->size()I

    move-result v17

    move/from16 v0, v17

    invoke-direct {v3, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 155
    .local v3, "ads":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;>;"
    move-object/from16 v0, v16

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 156
    const/4 v9, 0x0

    .line 157
    .local v9, "drivingAd":Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v12

    .local v12, "i$":Ljava/util/Iterator;
    :cond_5
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_6

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    .line 158
    .local v2, "adi":Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    if-eqz v2, :cond_5

    .line 159
    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-object/from16 v18, v0

    invoke-interface/range {v18 .. v18}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v18

    invoke-interface/range {v18 .. v18}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    if-ne v0, v1, :cond_5

    .line 160
    move-object v9, v2

    .line 161
    move-object/from16 v0, p0

    invoke-direct {v0, v9, v10}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->configureDrivingAdInstance(Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ljava/util/ArrayList;)V

    .line 165
    .end local v2    # "adi":Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    :cond_6
    if-eqz v9, :cond_7

    .line 166
    invoke-virtual {v3, v9}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 168
    :cond_7
    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v12

    :cond_8
    :goto_2
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_9

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    .line 169
    .restart local v2    # "adi":Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    if-eqz v2, :cond_8

    .line 170
    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ltv/freewheel/hybrid/renderers/vast/model/Companion;

    .line 171
    .restart local v15    # "rend":Ltv/freewheel/hybrid/renderers/vast/model/Companion;
    if-eqz v15, :cond_8

    .line 172
    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->createCreativeRenditionForTranslation()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    move-result-object v8

    .line 173
    .local v8, "cr":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    invoke-virtual {v15}, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->getTrackingEvents()Ljava/util/ArrayList;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v2, v1}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->configureTracking(Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ljava/util/ArrayList;)V

    .line 174
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-object/from16 v17, v0

    invoke-interface/range {v17 .. v17}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v15, v8, v2, v0, v1}, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->translateToFWCreativeRendition(Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)V

    .line 175
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v17, v0

    const-string v18, "Translated companion:slot(customId=%s:width=%d,height=%d) Ad(Id=%d) companion (ID=%s:width=%d,height=%d)"

    const/16 v19, 0x7

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v21

    invoke-interface/range {v21 .. v21}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v21

    aput-object v21, v19, v20

    const/16 v20, 0x1

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v21

    invoke-interface/range {v21 .. v21}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getWidth()I

    move-result v21

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v19, v20

    const/16 v20, 0x2

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v21

    invoke-interface/range {v21 .. v21}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getHeight()I

    move-result v21

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v19, v20

    const/16 v20, 0x3

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getAdId()I

    move-result v21

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v19, v20

    const/16 v20, 0x4

    iget-object v0, v15, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->id:Ljava/lang/String;

    move-object/from16 v21, v0

    aput-object v21, v19, v20

    const/16 v20, 0x5

    iget-object v0, v15, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->width:Ljava/lang/Integer;

    move-object/from16 v21, v0

    aput-object v21, v19, v20

    const/16 v20, 0x6

    iget-object v0, v15, Ltv/freewheel/hybrid/renderers/vast/model/Companion;->height:Ljava/lang/Integer;

    move-object/from16 v21, v0

    aput-object v21, v19, v20

    invoke-static/range {v18 .. v19}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 181
    .end local v2    # "adi":Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .end local v3    # "ads":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;>;"
    .end local v4    # "companionMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/renderers/vast/model/Companion;>;"
    .end local v7    # "companionSlots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    .end local v8    # "cr":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    .end local v9    # "drivingAd":Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .end local v10    # "drivingRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<+Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;>;"
    .end local v11    # "i":I
    .end local v12    # "i$":Ljava/util/Iterator;
    .end local v13    # "matchedCompanions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/renderers/vast/model/Companion;>;"
    .end local v14    # "preparedSlots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    .end local v15    # "rend":Ltv/freewheel/hybrid/renderers/vast/model/Companion;
    .end local v16    # "scheduledAds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;>;"
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-object/from16 v18, v0

    invoke-interface/range {v18 .. v18}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_LOADED()Ljava/lang/String;

    move-result-object v18

    invoke-interface/range {v17 .. v18}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 182
    return-void
.end method


# virtual methods
.method public dispose()V
    .locals 2

    .prologue
    .line 412
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "dispose()"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 413
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->_stop()V

    .line 414
    return-void
.end method

.method public load(Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;)V
    .locals 5
    .param p1, "rendererContext"    # Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    .prologue
    .line 83
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "load()"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 84
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    .line 85
    invoke-interface {p1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .line 87
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->checkCompatibilityWithSDK()Z

    move-result v2

    if-nez v2, :cond_0

    .line 114
    :goto_0
    return-void

    .line 91
    :cond_0
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v0

    .line 92
    .local v0, "drivingSlot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getType()I

    move-result v2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->SLOT_TYPE_TEMPORAL()I

    move-result v3

    if-eq v2, v3, :cond_1

    .line 93
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_INVALID_SLOT()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Vast Translator only supports temporal slots."

    invoke-direct {p0, v2, v3}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 97
    :cond_1
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->originalActiveRendition:Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    .line 100
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getWrapperURL()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    .line 101
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ltv/freewheel/hybrid/renderers/vast/util/StringUtils;->isBlank(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    invoke-static {v2}, Landroid/webkit/URLUtil;->isValidUrl(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 102
    :cond_2
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_INVALID_VALUE()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Not a valid URL to load VAST document from: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v2, v3}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 107
    :cond_3
    :try_start_0
    new-instance v2, Ljava/net/URL;

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    invoke-direct {v2, v3}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 113
    :goto_1
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    invoke-direct {p0, v2}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->sendRequest(Ljava/lang/String;)V

    goto :goto_0

    .line 108
    :catch_0
    move-exception v1

    .line 109
    .local v1, "e":Ljava/net/MalformedURLException;
    invoke-virtual {v1}, Ljava/net/MalformedURLException;->printStackTrace()V

    .line 110
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_INVALID_VALUE()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Not a valid URL to load VAST document from: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v2, v3}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public resize()V
    .locals 0

    .prologue
    .line 463
    return-void
.end method

.method public start()V
    .locals 2

    .prologue
    .line 118
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "start()"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 119
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_STARTED()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 120
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->context:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_STOPPED()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 121
    return-void
.end method

.method public stop()V
    .locals 2

    .prologue
    .line 389
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "stop()"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 390
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/vast/VastTranslator;->_stop()V

    .line 391
    return-void
.end method
