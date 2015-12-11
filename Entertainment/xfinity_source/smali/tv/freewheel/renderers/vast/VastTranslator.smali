.class public Ltv/freewheel/renderers/vast/VastTranslator;
.super Ljava/lang/Object;
.source "VastTranslator.java"

# interfaces
.implements Ltv/freewheel/renderers/interfaces/IRenderer;


# instance fields
.field private constants:Ltv/freewheel/ad/interfaces/IConstants;

.field private context:Ltv/freewheel/renderers/interfaces/IRendererContext;

.field private httpLoader:Ltv/freewheel/utils/URLLoader;

.field private loadCompleteListener:Ltv/freewheel/ad/interfaces/IEventListener;

.field private loadFailedListener:Ltv/freewheel/ad/interfaces/IEventListener;

.field private logger:Ltv/freewheel/utils/Logger;

.field private originalActiveRendition:Ltv/freewheel/ad/interfaces/ICreativeRendition;

.field private paramParser:Ltv/freewheel/utils/renderer/ParamParser;

.field private stopped:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private vast:Ltv/freewheel/renderers/vast/model/Vast;

.field private vastURL:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 381
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->stopped:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 452
    new-instance v0, Ltv/freewheel/renderers/vast/VastTranslator$3;

    invoke-direct {v0, p0}, Ltv/freewheel/renderers/vast/VastTranslator$3;-><init>(Ltv/freewheel/renderers/vast/VastTranslator;)V

    iput-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->loadCompleteListener:Ltv/freewheel/ad/interfaces/IEventListener;

    .line 460
    new-instance v0, Ltv/freewheel/renderers/vast/VastTranslator$4;

    invoke-direct {v0, p0}, Ltv/freewheel/renderers/vast/VastTranslator$4;-><init>(Ltv/freewheel/renderers/vast/VastTranslator;)V

    iput-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->loadFailedListener:Ltv/freewheel/ad/interfaces/IEventListener;

    .line 51
    const/4 v0, 0x1

    invoke-static {p0, v0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;Z)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

    .line 52
    new-instance v0, Ltv/freewheel/utils/URLLoader;

    invoke-direct {v0}, Ltv/freewheel/utils/URLLoader;-><init>()V

    iput-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->httpLoader:Ltv/freewheel/utils/URLLoader;

    .line 53
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->httpLoader:Ltv/freewheel/utils/URLLoader;

    const-string v1, "URLLoader.Load.Complete"

    iget-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->loadCompleteListener:Ltv/freewheel/ad/interfaces/IEventListener;

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/utils/URLLoader;->addEventListener(Ljava/lang/String;Ltv/freewheel/ad/interfaces/IEventListener;)V

    .line 54
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->httpLoader:Ltv/freewheel/utils/URLLoader;

    const-string v1, "URLLoader.Load.Error"

    iget-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->loadFailedListener:Ltv/freewheel/ad/interfaces/IEventListener;

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/utils/URLLoader;->addEventListener(Ljava/lang/String;Ltv/freewheel/ad/interfaces/IEventListener;)V

    .line 55
    return-void
.end method

.method private _stop()V
    .locals 3

    .prologue
    .line 383
    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator;->stopped:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 395
    :goto_0
    return-void

    .line 385
    :cond_0
    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator;->stopped:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 386
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    invoke-interface {v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 387
    .local v0, "mainVideoHandler":Landroid/os/Handler;
    new-instance v1, Ltv/freewheel/renderers/vast/VastTranslator$1;

    invoke-direct {v1, p0}, Ltv/freewheel/renderers/vast/VastTranslator$1;-><init>(Ltv/freewheel/renderers/vast/VastTranslator;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method static synthetic access$000(Ltv/freewheel/renderers/vast/VastTranslator;)Ltv/freewheel/utils/URLLoader;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/vast/VastTranslator;

    .prologue
    .line 37
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->httpLoader:Ltv/freewheel/utils/URLLoader;

    return-object v0
.end method

.method static synthetic access$100(Ltv/freewheel/renderers/vast/VastTranslator;)Ltv/freewheel/ad/interfaces/IConstants;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/vast/VastTranslator;

    .prologue
    .line 37
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    return-object v0
.end method

.method static synthetic access$200(Ltv/freewheel/renderers/vast/VastTranslator;)Ltv/freewheel/renderers/interfaces/IRendererContext;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/vast/VastTranslator;

    .prologue
    .line 37
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    return-object v0
.end method

.method static synthetic access$300(Ltv/freewheel/renderers/vast/VastTranslator;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/vast/VastTranslator;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 37
    invoke-direct {p0, p1}, Ltv/freewheel/renderers/vast/VastTranslator;->parseVastResponse(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$400(Ltv/freewheel/renderers/vast/VastTranslator;)Ltv/freewheel/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/vast/VastTranslator;

    .prologue
    .line 37
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

    return-object v0
.end method

.method static synthetic access$500(Ltv/freewheel/renderers/vast/VastTranslator;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/vast/VastTranslator;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 37
    invoke-direct {p0, p1, p2}, Ltv/freewheel/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private checkCompatibilityWithSDK()Z
    .locals 3

    .prologue
    .line 428
    :try_start_0
    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    invoke-interface {v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getVersion()I
    :try_end_0
    .catch Ljava/lang/NoSuchMethodError; {:try_start_0 .. :try_end_0} :catch_0

    .line 433
    const/4 v1, 0x1

    :goto_0
    return v1

    .line 429
    :catch_0
    move-exception v0

    .line 430
    .local v0, "e":Ljava/lang/NoSuchMethodError;
    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_RENDERER_INIT()Ljava/lang/String;

    move-result-object v1

    const-string v2, "VastTranslator only compatible with SDK version >= 4.1"

    invoke-direct {p0, v1, v2}, Ltv/freewheel/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    .line 431
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private configureCreative(Ltv/freewheel/ad/interfaces/IAdInstance;Ltv/freewheel/renderers/vast/model/AbstractAd;ILjava/util/ArrayList;)V
    .locals 11
    .param p1, "adInstance"    # Ltv/freewheel/ad/interfaces/IAdInstance;
    .param p2, "ad"    # Ltv/freewheel/renderers/vast/model/AbstractAd;
    .param p3, "type"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ltv/freewheel/ad/interfaces/IAdInstance;",
            "Ltv/freewheel/renderers/vast/model/AbstractAd;",
            "I",
            "Ljava/util/ArrayList",
            "<+",
            "Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p4, "renditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<+Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;>;"
    const/4 v10, 0x1

    .line 244
    iget-object v7, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v7, v8}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 245
    iget-object v7, p2, Ltv/freewheel/renderers/vast/model/AbstractAd;->creatives:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/renderers/vast/model/Creative;

    .line 246
    .local v1, "creative":Ltv/freewheel/renderers/vast/model/Creative;
    iget-object v7, v1, Ltv/freewheel/renderers/vast/model/Creative;->linear:Ltv/freewheel/renderers/vast/model/Linear;

    if-eqz v7, :cond_2

    if-ne p3, v10, :cond_0

    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v7

    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v7

    iget-object v8, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IConstants;->TIME_POSITION_CLASS_OVERLAY()I

    move-result v8

    if-ne v7, v8, :cond_1

    :cond_0
    if-nez p3, :cond_2

    iget-object v7, v1, Ltv/freewheel/renderers/vast/model/Creative;->linear:Ltv/freewheel/renderers/vast/model/Linear;

    iget-object v8, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    invoke-interface {v8}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v8

    iget-object v9, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-virtual {v7, v8, v9}, Ltv/freewheel/renderers/vast/model/Linear;->isValid(Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/ad/interfaces/IConstants;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 249
    :cond_1
    iget-object v7, v1, Ltv/freewheel/renderers/vast/model/Creative;->linear:Ltv/freewheel/renderers/vast/model/Linear;

    invoke-direct {p0, p1, v7}, Ltv/freewheel/renderers/vast/VastTranslator;->configureVideoClicks(Ltv/freewheel/ad/interfaces/IAdInstance;Ltv/freewheel/renderers/vast/model/Linear;)V

    .line 251
    :cond_2
    iget-object v7, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    invoke-interface {v7}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v7

    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v7

    iget-object v8, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-virtual {v1, v7, v8}, Ltv/freewheel/renderers/vast/model/Creative;->getTrackingEvents(Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/ad/interfaces/IConstants;)Ljava/util/ArrayList;

    move-result-object v7

    invoke-direct {p0, p1, v7}, Ltv/freewheel/renderers/vast/VastTranslator;->configureTracking(Ltv/freewheel/ad/interfaces/IAdInstance;Ljava/util/ArrayList;)V

    goto :goto_0

    .line 254
    .end local v1    # "creative":Ltv/freewheel/renderers/vast/model/Creative;
    :cond_3
    if-nez p3, :cond_4

    .line 255
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    invoke-virtual {p4}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-ge v2, v7, :cond_5

    .line 256
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IAdInstance;->createCreativeRenditionForTranslation()Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-result-object v5

    .line 257
    .local v5, "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    invoke-virtual {p4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;

    .line 258
    .local v6, "vastRendition":Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;
    iget-object v7, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    invoke-interface {v7}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v7

    iget-object v8, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-virtual {v6, v5, p1, v7, v8}, Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;->translateToFWCreativeRendition(Ltv/freewheel/ad/interfaces/ICreativeRendition;Ltv/freewheel/ad/interfaces/IAdInstance;Ltv/freewheel/ad/interfaces/IAdInstance;Ltv/freewheel/ad/interfaces/IConstants;)V

    .line 259
    const-string v7, "Translated vast rendition(InLine)  "

    invoke-virtual {v6}, Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {p0, v7, v8}, Ltv/freewheel/renderers/vast/VastTranslator;->printMultilineLog(Ljava/lang/String;Ljava/lang/String;)V

    .line 255
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 262
    .end local v2    # "i":I
    .end local v5    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    .end local v6    # "vastRendition":Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;
    :cond_4
    invoke-interface {p1}, Ltv/freewheel/ad/interfaces/IAdInstance;->createCreativeRenditionForTranslation()Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-result-object v5

    .line 263
    .restart local v5    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    const-string v7, "external/vast-2"

    invoke-interface {v5, v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setWrapperType(Ljava/lang/String;)V

    .line 264
    iget-object v7, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    iget-object v7, v7, Ltv/freewheel/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/renderers/vast/model/Wrapper;

    iget-object v7, v7, Ltv/freewheel/renderers/vast/model/Wrapper;->vastAdTagUri:Ljava/lang/String;

    invoke-interface {v5, v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setWrapperURL(Ljava/lang/String;)V

    .line 265
    invoke-virtual {p4}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lez v7, :cond_6

    .line 266
    const/4 v7, 0x0

    invoke-virtual {p4, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;

    .line 267
    .restart local v6    # "vastRendition":Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;
    iget-object v7, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    invoke-interface {v7}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v7

    iget-object v8, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-virtual {v6, v5, p1, v7, v8}, Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;->translateToFWCreativeRendition(Ltv/freewheel/ad/interfaces/ICreativeRendition;Ltv/freewheel/ad/interfaces/IAdInstance;Ltv/freewheel/ad/interfaces/IAdInstance;Ltv/freewheel/ad/interfaces/IConstants;)V

    .line 268
    const-string v7, "Translated vast rendition(Wrapper)  "

    invoke-virtual {v6}, Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {p0, v7, v8}, Ltv/freewheel/renderers/vast/VastTranslator;->printMultilineLog(Ljava/lang/String;Ljava/lang/String;)V

    .line 287
    .end local v5    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    .end local v6    # "vastRendition":Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;
    :cond_5
    :goto_2
    return-void

    .line 270
    .restart local v5    # "rendition":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    :cond_6
    iget-object v7, p0, Ltv/freewheel/renderers/vast/VastTranslator;->originalActiveRendition:Ltv/freewheel/ad/interfaces/ICreativeRendition;

    if-eqz v7, :cond_7

    .line 271
    iget-object v7, p0, Ltv/freewheel/renderers/vast/VastTranslator;->originalActiveRendition:Ltv/freewheel/ad/interfaces/ICreativeRendition;

    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getWidth()I

    move-result v7

    invoke-interface {v5, v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setWidth(I)V

    .line 272
    iget-object v7, p0, Ltv/freewheel/renderers/vast/VastTranslator;->originalActiveRendition:Ltv/freewheel/ad/interfaces/ICreativeRendition;

    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getHeight()I

    move-result v7

    invoke-interface {v5, v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setHeight(I)V

    .line 273
    iget-object v7, p0, Ltv/freewheel/renderers/vast/VastTranslator;->originalActiveRendition:Ltv/freewheel/ad/interfaces/ICreativeRendition;

    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setContentType(Ljava/lang/String;)V

    .line 274
    iget-object v7, p0, Ltv/freewheel/renderers/vast/VastTranslator;->originalActiveRendition:Ltv/freewheel/ad/interfaces/ICreativeRendition;

    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getCreativeAPI()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setCreativeAPI(Ljava/lang/String;)V

    .line 275
    iget-object v7, p0, Ltv/freewheel/renderers/vast/VastTranslator;->originalActiveRendition:Ltv/freewheel/ad/interfaces/ICreativeRendition;

    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v4

    .line 276
    .local v4, "originalAsset":Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;
    const-string v7, "VAST_generated_placeholder_asset"

    invoke-interface {v5, v7, v10}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->createCreativeRenditionAssetForTranslation(Ljava/lang/String;Z)Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v0

    .line 277
    .local v0, "asset":Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;
    if-eqz v4, :cond_8

    .line 278
    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;->getContentType()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v0, v7}, Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;->setContentType(Ljava/lang/String;)V

    .line 279
    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;->getMimeType()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v0, v7}, Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;->setMimeType(Ljava/lang/String;)V

    .line 284
    .end local v0    # "asset":Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;
    .end local v4    # "originalAsset":Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;
    :cond_7
    :goto_3
    const-string v7, "Translated rendition(empty Wrapper)  "

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {p0, v7, v8}, Ltv/freewheel/renderers/vast/VastTranslator;->printMultilineLog(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 281
    .restart local v0    # "asset":Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;
    .restart local v4    # "originalAsset":Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;
    :cond_8
    iget-object v7, p0, Ltv/freewheel/renderers/vast/VastTranslator;->originalActiveRendition:Ltv/freewheel/ad/interfaces/ICreativeRendition;

    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v0, v7}, Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;->setContentType(Ljava/lang/String;)V

    goto :goto_3
.end method

.method private configureDrivingAdInstance(Ltv/freewheel/ad/interfaces/IAdInstance;Ljava/util/ArrayList;)V
    .locals 9
    .param p1, "adInstance"    # Ltv/freewheel/ad/interfaces/IAdInstance;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ltv/freewheel/ad/interfaces/IAdInstance;",
            "Ljava/util/ArrayList",
            "<+",
            "Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 194
    .local p2, "renditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<+Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;>;"
    iget-object v6, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 195
    const/4 v2, 0x0

    .line 196
    .local v2, "impressions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/renderers/vast/model/Impression;>;"
    const/4 v3, -0x1

    .line 197
    .local v3, "type":I
    const/4 v5, 0x0

    .line 198
    .local v5, "vastAd":Ltv/freewheel/renderers/vast/model/AbstractAd;
    iget-object v6, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    iget-object v6, v6, Ltv/freewheel/renderers/vast/model/Vast;->inLine:Ltv/freewheel/renderers/vast/model/InLine;

    if-eqz v6, :cond_1

    .line 199
    iget-object v6, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 201
    iget-object v6, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    iget-object v6, v6, Ltv/freewheel/renderers/vast/model/Vast;->inLine:Ltv/freewheel/renderers/vast/model/InLine;

    iget-object v2, v6, Ltv/freewheel/renderers/vast/model/InLine;->impressions:Ljava/util/ArrayList;

    .line 202
    const/4 v3, 0x0

    .line 203
    iget-object v6, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    iget-object v5, v6, Ltv/freewheel/renderers/vast/model/Vast;->inLine:Ltv/freewheel/renderers/vast/model/InLine;

    .line 218
    :goto_0
    if-eqz v2, :cond_5

    .line 219
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 220
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

    check-cast v1, Ltv/freewheel/renderers/vast/model/Impression;

    .line 221
    .local v1, "impr":Ltv/freewheel/renderers/vast/model/Impression;
    invoke-virtual {v1}, Ltv/freewheel/renderers/vast/model/Impression;->isValid()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 222
    iget-object v6, v1, Ltv/freewheel/renderers/vast/model/Impression;->url:Ljava/lang/String;

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 204
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "impr":Ltv/freewheel/renderers/vast/model/Impression;
    .end local v4    # "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_1
    iget-object v6, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    iget-object v6, v6, Ltv/freewheel/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/renderers/vast/model/Wrapper;

    if-eqz v6, :cond_2

    .line 205
    iget-object v6, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 206
    iget-object v6, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    iget-object v6, v6, Ltv/freewheel/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/renderers/vast/model/Wrapper;

    iget-object v2, v6, Ltv/freewheel/renderers/vast/model/Wrapper;->impressions:Ljava/util/ArrayList;

    .line 207
    const/4 v3, 0x1

    .line 208
    iget-object v6, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    iget-object v5, v6, Ltv/freewheel/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/renderers/vast/model/Wrapper;

    goto :goto_0

    .line 214
    :cond_2
    iget-object v6, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 231
    :cond_3
    :goto_2
    return-void

    .line 224
    .restart local v0    # "i$":Ljava/util/Iterator;
    .restart local v4    # "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_4
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-lez v6, :cond_5

    .line 225
    iget-object v6, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v6}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_IMPRESSION()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v7}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_IMPRESSION()Ljava/lang/String;

    move-result-object v7

    invoke-interface {p1, v6, v7, v4}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 228
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v4    # "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_5
    const/4 v6, -0x1

    if-eq v3, v6, :cond_3

    .line 229
    invoke-direct {p0, p1, v5, v3, p2}, Ltv/freewheel/renderers/vast/VastTranslator;->configureCreative(Ltv/freewheel/ad/interfaces/IAdInstance;Ltv/freewheel/renderers/vast/model/AbstractAd;ILjava/util/ArrayList;)V

    goto :goto_2
.end method

.method private configureTracking(Ltv/freewheel/ad/interfaces/IAdInstance;Ljava/util/ArrayList;)V
    .locals 6
    .param p1, "adInstance"    # Ltv/freewheel/ad/interfaces/IAdInstance;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ltv/freewheel/ad/interfaces/IAdInstance;",
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/renderers/vast/model/Tracking;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 314
    .local p2, "trackingEvents":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/renderers/vast/model/Tracking;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 315
    .local v2, "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 316
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

    check-cast v1, Ltv/freewheel/renderers/vast/model/Tracking;

    .line 317
    .local v1, "tracking":Ltv/freewheel/renderers/vast/model/Tracking;
    invoke-virtual {v1}, Ltv/freewheel/renderers/vast/model/Tracking;->isValid()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 319
    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 320
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->url:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 321
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "creativeView"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "start"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 323
    :cond_1
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_IMPRESSION()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_IMPRESSION()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_0

    .line 325
    :cond_2
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "midpoint"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 326
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_MIDPOINT()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_IMPRESSION()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_0

    .line 328
    :cond_3
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "firstQuartile"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 329
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_FIRST_QUARTILE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_IMPRESSION()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_0

    .line 331
    :cond_4
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "thirdQuartile"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 332
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_THIRD_QUARTILE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_IMPRESSION()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 334
    :cond_5
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "complete"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 335
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_COMPLETE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_IMPRESSION()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 337
    :cond_6
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "mute"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 338
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_MUTE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 340
    :cond_7
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "unmute"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 341
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_UNMUTE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 343
    :cond_8
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "pause"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 344
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_PAUSE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 346
    :cond_9
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "resume"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_a

    .line 347
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_RESUME()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 349
    :cond_a
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "rewind"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_b

    .line 350
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_REWIND()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 352
    :cond_b
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "expand"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_c

    .line 353
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_EXPAND()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 355
    :cond_c
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "fullscreen"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_d

    .line 356
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_EXPAND()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 358
    :cond_d
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "collapse"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_e

    .line 359
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_COLLAPSE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 361
    :cond_e
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "acceptInvitation"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_f

    .line 362
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_ACCEPT_INVITATION()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 364
    :cond_f
    iget-object v3, v1, Ltv/freewheel/renderers/vast/model/Tracking;->event:Ljava/lang/String;

    const-string v4, "close"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 365
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_CLOSE()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_STANDARD()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4, v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 369
    .end local v1    # "tracking":Ltv/freewheel/renderers/vast/model/Tracking;
    :cond_10
    return-void
.end method

.method private configureVideoClicks(Ltv/freewheel/ad/interfaces/IAdInstance;Ltv/freewheel/renderers/vast/model/Linear;)V
    .locals 6
    .param p1, "adInstance"    # Ltv/freewheel/ad/interfaces/IAdInstance;
    .param p2, "linear"    # Ltv/freewheel/renderers/vast/model/Linear;

    .prologue
    .line 290
    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

    const-string v5, "configureEventCallbacks()"

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 291
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 292
    .local v3, "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v4, p2, Ltv/freewheel/renderers/vast/model/Linear;->videoClicks:Ljava/util/ArrayList;

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

    check-cast v0, Ltv/freewheel/renderers/vast/model/VideoClick;

    .line 293
    .local v0, "click":Ltv/freewheel/renderers/vast/model/VideoClick;
    invoke-virtual {v0}, Ltv/freewheel/renderers/vast/model/VideoClick;->isValid()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 295
    iget-object v4, v0, Ltv/freewheel/renderers/vast/model/VideoClick;->type:Ljava/lang/String;

    const-string v5, "ClickThrough"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 296
    iget-object v4, v0, Ltv/freewheel/renderers/vast/model/VideoClick;->url:Ljava/lang/String;

    iget-object v5, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v5}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_CLICK()Ljava/lang/String;

    move-result-object v5

    invoke-interface {p1, v4, v5}, Ltv/freewheel/ad/interfaces/IAdInstance;->setClickThroughURL(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 298
    :cond_1
    iget-object v4, v0, Ltv/freewheel/renderers/vast/model/VideoClick;->type:Ljava/lang/String;

    const-string v5, "ClickTracking"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 299
    iget-object v4, v0, Ltv/freewheel/renderers/vast/model/VideoClick;->url:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 301
    :cond_2
    iget-object v4, v0, Ltv/freewheel/renderers/vast/model/VideoClick;->type:Ljava/lang/String;

    const-string v5, "CustomClick"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 302
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 303
    .local v1, "clickTrackingURLs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v4, v0, Ltv/freewheel/renderers/vast/model/VideoClick;->url:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 304
    iget-object v4, v0, Ltv/freewheel/renderers/vast/model/VideoClick;->id:Ljava/lang/String;

    iget-object v5, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v5}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_CLICK_TRACKING()Ljava/lang/String;

    move-result-object v5

    invoke-interface {p1, v4, v5, v1}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_0

    .line 307
    .end local v0    # "click":Ltv/freewheel/renderers/vast/model/VideoClick;
    .end local v1    # "clickTrackingURLs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_3
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lez v4, :cond_4

    .line 308
    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_CLICK()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v5}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_TYPE_CLICK_TRACKING()Ljava/lang/String;

    move-result-object v5

    invoke-interface {p1, v4, v5, v3}, Ltv/freewheel/ad/interfaces/IAdInstance;->addEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 311
    :cond_4
    return-void
.end method

.method private failWithError(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "errorCode"    # Ljava/lang/String;
    .param p2, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 437
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 438
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 439
    .local v0, "info":Landroid/os/Bundle;
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 440
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " wrapperURL: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 441
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 442
    .local v2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 443
    new-instance v1, Landroid/os/Handler;

    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    invoke-interface {v3}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v3

    invoke-direct {v1, v3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 444
    .local v1, "mainVideoHandler":Landroid/os/Handler;
    new-instance v3, Ltv/freewheel/renderers/vast/VastTranslator$2;

    invoke-direct {v3, p0, v2}, Ltv/freewheel/renderers/vast/VastTranslator$2;-><init>(Ltv/freewheel/renderers/vast/VastTranslator;Ljava/util/HashMap;)V

    invoke-virtual {v1, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 450
    return-void
.end method

.method private parseVastResponse(Ljava/lang/String;)V
    .locals 3
    .param p1, "data"    # Ljava/lang/String;

    .prologue
    .line 68
    new-instance v0, Ltv/freewheel/renderers/vast/model/Vast;

    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    invoke-direct {v0, v1}, Ltv/freewheel/renderers/vast/model/Vast;-><init>(Ltv/freewheel/renderers/interfaces/IRendererContext;)V

    iput-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    .line 70
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    invoke-virtual {v0, p1}, Ltv/freewheel/renderers/vast/model/Vast;->parse(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 71
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Vast document parsed, "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 72
    invoke-direct {p0}, Ltv/freewheel/renderers/vast/VastTranslator;->startTranslateAd()V

    .line 83
    :goto_0
    return-void

    .line 74
    :cond_0
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    iget v0, v0, Ltv/freewheel/renderers/vast/model/Vast;->errorCode:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_2

    .line 75
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v0}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_NO_AD_AVAILABLE()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    iget-object v1, v1, Ltv/freewheel/renderers/vast/model/Vast;->errorMessage:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Ltv/freewheel/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    :cond_1
    :goto_1
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    goto :goto_0

    .line 76
    :cond_2
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    iget v0, v0, Ltv/freewheel/renderers/vast/model/Vast;->errorCode:I

    if-nez v0, :cond_3

    .line 77
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v0}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_PARSE()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    iget-object v1, v1, Ltv/freewheel/renderers/vast/model/Vast;->errorMessage:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Ltv/freewheel/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 78
    :cond_3
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    iget v0, v0, Ltv/freewheel/renderers/vast/model/Vast;->errorCode:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 79
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v0}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_UNSUPPORTED_3P_FEATURE()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    iget-object v1, v1, Ltv/freewheel/renderers/vast/model/Vast;->errorMessage:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Ltv/freewheel/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method private printMultilineLog(Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "head"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 234
    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p2

    .line 235
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v5

    if-nez v5, :cond_1

    .line 241
    :cond_0
    return-void

    .line 236
    :cond_1
    const/4 v3, 0x1

    .line 237
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

    .line 238
    .local v4, "log":Ljava/lang/String;
    iget-object v5, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

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

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 239
    add-int/lit8 v3, v3, 0x1

    .line 237
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method private sendRequest(Ljava/lang/String;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 58
    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Loading VAST document from: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 59
    new-instance v0, Ltv/freewheel/utils/URLRequest;

    const-string v1, "http.agent"

    invoke-static {v1}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p1, v1}, Ltv/freewheel/utils/URLRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    .local v0, "req":Ltv/freewheel/utils/URLRequest;
    const/4 v1, 0x1

    iput v1, v0, Ltv/freewheel/utils/URLRequest;->method:I

    .line 62
    const-string v1, "text/plain"

    iput-object v1, v0, Ltv/freewheel/utils/URLRequest;->contentType:Ljava/lang/String;

    .line 64
    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator;->httpLoader:Ltv/freewheel/utils/URLLoader;

    invoke-virtual {v1, v0}, Ltv/freewheel/utils/URLLoader;->load(Ltv/freewheel/utils/URLRequest;)V

    .line 65
    return-void
.end method

.method private startTranslateAd()V
    .locals 26

    .prologue
    .line 129
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

    move-object/from16 v21, v0

    const-string v22, "startTranslateAd()"

    invoke-virtual/range {v21 .. v22}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 130
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    move-object/from16 v21, v0

    if-eqz v21, :cond_9

    .line 132
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Ltv/freewheel/renderers/vast/model/Vast;->getRenditionsInDrivingSlot()Ljava/util/ArrayList;

    move-result-object v14

    .line 133
    .local v14, "drivingRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<+Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;>;"
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 134
    .local v6, "companionMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/renderers/vast/model/Companion;>;"
    new-instance v18, Ljava/util/ArrayList;

    invoke-direct/range {v18 .. v18}, Ljava/util/ArrayList;-><init>()V

    .line 136
    .local v18, "preparedSlots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ISlot;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Ltv/freewheel/renderers/vast/model/Vast;->wrapper:Ltv/freewheel/renderers/vast/model/Wrapper;

    move-object/from16 v21, v0

    if-nez v21, :cond_0

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Ltv/freewheel/renderers/vast/model/Vast;->inLine:Ltv/freewheel/renderers/vast/model/InLine;

    move-object/from16 v21, v0

    if-eqz v21, :cond_1

    invoke-virtual {v14}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v21

    if-nez v21, :cond_1

    .line 137
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v21, v0

    invoke-interface/range {v21 .. v21}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v21

    invoke-interface/range {v21 .. v21}, Ltv/freewheel/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v21

    move-object/from16 v0, v18

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 140
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v21, v0

    invoke-interface/range {v21 .. v21}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getCompanionSlots()Ljava/util/ArrayList;

    move-result-object v9

    .line 141
    .local v9, "companionSlots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ISlot;>;"
    new-instance v17, Ljava/util/ArrayList;

    invoke-direct/range {v17 .. v17}, Ljava/util/ArrayList;-><init>()V

    .line 142
    .local v17, "matchedCompanions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/renderers/vast/model/Companion;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v21, v0

    invoke-interface/range {v21 .. v21}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getActivity()Landroid/app/Activity;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v21

    move-object/from16 v0, v21

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    move/from16 v21, v0

    move/from16 v0, v21

    float-to-double v12, v0

    .line 143
    .local v12, "device_dpr":D
    const/4 v15, 0x0

    .local v15, "i":I
    :goto_0
    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v21

    move/from16 v0, v21

    if-ge v15, v0, :cond_4

    .line 145
    invoke-virtual {v9, v15}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ltv/freewheel/ad/interfaces/ISlot;

    .line 146
    .local v8, "companionSlot":Ltv/freewheel/ad/interfaces/ISlot;
    move-object/from16 v0, v18

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 147
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->vast:Ltv/freewheel/renderers/vast/model/Vast;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v0, v8}, Ltv/freewheel/renderers/vast/model/Vast;->getCompanionRenditions(Ltv/freewheel/ad/interfaces/ISlot;)Ljava/util/ArrayList;

    move-result-object v7

    .line 148
    .local v7, "companionRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<+Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;>;"
    move-object/from16 v0, v17

    invoke-virtual {v7, v0}, Ljava/util/ArrayList;->removeAll(Ljava/util/Collection;)Z

    .line 149
    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v21

    if-lez v21, :cond_2

    .line 151
    invoke-static {v7, v8, v12, v13}, Ltv/freewheel/renderers/vast/model/Vast;->match(Ljava/util/ArrayList;Ltv/freewheel/ad/interfaces/ISlot;D)Ltv/freewheel/renderers/vast/model/Companion;

    move-result-object v19

    .line 152
    .local v19, "rend":Ltv/freewheel/renderers/vast/model/Companion;
    if-eqz v19, :cond_3

    .line 153
    move-object/from16 v0, v19

    invoke-virtual {v6, v8, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 154
    move-object/from16 v0, v17

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 143
    .end local v19    # "rend":Ltv/freewheel/renderers/vast/model/Companion;
    :cond_2
    :goto_1
    add-int/lit8 v15, v15, 0x1

    goto :goto_0

    .line 156
    .restart local v19    # "rend":Ltv/freewheel/renderers/vast/model/Companion;
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

    move-object/from16 v21, v0

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "No matching rendition for companion slot:"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_1

    .line 160
    .end local v7    # "companionRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<+Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;>;"
    .end local v8    # "companionSlot":Ltv/freewheel/ad/interfaces/ISlot;
    .end local v19    # "rend":Ltv/freewheel/renderers/vast/model/Companion;
    :cond_4
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    move-object/from16 v1, v18

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->scheduleAdInstances(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v20

    .line 161
    .local v20, "scheduledAds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/IAdInstance;>;"
    new-instance v5, Ljava/util/ArrayList;

    invoke-virtual/range {v20 .. v20}, Ljava/util/ArrayList;->size()I

    move-result v21

    move/from16 v0, v21

    invoke-direct {v5, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 162
    .local v5, "ads":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/IAdInstance;>;"
    move-object/from16 v0, v20

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 163
    const/4 v11, 0x0

    .line 164
    .local v11, "drivingAd":Ltv/freewheel/ad/interfaces/IAdInstance;
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v16

    .local v16, "i$":Ljava/util/Iterator;
    :cond_5
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v21

    if-eqz v21, :cond_6

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ltv/freewheel/ad/interfaces/IAdInstance;

    .line 165
    .local v4, "adi":Ltv/freewheel/ad/interfaces/IAdInstance;
    if-eqz v4, :cond_5

    .line 166
    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v21

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v22

    invoke-interface/range {v22 .. v22}, Ltv/freewheel/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    if-ne v0, v1, :cond_5

    .line 167
    move-object v11, v4

    .line 168
    move-object/from16 v0, p0

    invoke-direct {v0, v11, v14}, Ltv/freewheel/renderers/vast/VastTranslator;->configureDrivingAdInstance(Ltv/freewheel/ad/interfaces/IAdInstance;Ljava/util/ArrayList;)V

    .line 172
    .end local v4    # "adi":Ltv/freewheel/ad/interfaces/IAdInstance;
    :cond_6
    if-eqz v11, :cond_7

    .line 173
    invoke-virtual {v5, v11}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 175
    :cond_7
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v16

    :cond_8
    :goto_2
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v21

    if-eqz v21, :cond_9

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ltv/freewheel/ad/interfaces/IAdInstance;

    .line 176
    .restart local v4    # "adi":Ltv/freewheel/ad/interfaces/IAdInstance;
    if-eqz v4, :cond_8

    .line 177
    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v6, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ltv/freewheel/renderers/vast/model/Companion;

    .line 178
    .restart local v19    # "rend":Ltv/freewheel/renderers/vast/model/Companion;
    if-eqz v19, :cond_8

    .line 179
    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IAdInstance;->createCreativeRenditionForTranslation()Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-result-object v10

    .line 180
    .local v10, "cr":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    invoke-virtual/range {v19 .. v19}, Ltv/freewheel/renderers/vast/model/Companion;->getTrackingEvents()Ljava/util/ArrayList;

    move-result-object v21

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-direct {v0, v4, v1}, Ltv/freewheel/renderers/vast/VastTranslator;->configureTracking(Ltv/freewheel/ad/interfaces/IAdInstance;Ljava/util/ArrayList;)V

    .line 181
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v21, v0

    invoke-interface/range {v21 .. v21}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v21

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v22, v0

    move-object/from16 v0, v19

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v10, v4, v1, v2}, Ltv/freewheel/renderers/vast/model/Companion;->translateToFWCreativeRendition(Ltv/freewheel/ad/interfaces/ICreativeRendition;Ltv/freewheel/ad/interfaces/IAdInstance;Ltv/freewheel/ad/interfaces/IAdInstance;Ltv/freewheel/ad/interfaces/IConstants;)V

    .line 182
    invoke-interface {v10}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getWidth()I

    move-result v21

    move/from16 v0, v21

    int-to-double v0, v0

    move-wide/from16 v22, v0

    div-double v22, v22, v12

    move-wide/from16 v0, v22

    double-to-int v0, v0

    move/from16 v21, v0

    move/from16 v0, v21

    invoke-interface {v10, v0}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setWidth(I)V

    .line 183
    invoke-interface {v10}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getHeight()I

    move-result v21

    move/from16 v0, v21

    int-to-double v0, v0

    move-wide/from16 v22, v0

    div-double v22, v22, v12

    move-wide/from16 v0, v22

    double-to-int v0, v0

    move/from16 v21, v0

    move/from16 v0, v21

    invoke-interface {v10, v0}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->setHeight(I)V

    .line 184
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

    move-object/from16 v21, v0

    const-string v22, "Translated companion:slot(customId=%s:width=%d,height=%d) Ad(Id=%d) companion (ID=%s:width=%d,height=%d)"

    const/16 v23, 0x7

    move/from16 v0, v23

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v23, v0

    const/16 v24, 0x0

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v25

    invoke-interface/range {v25 .. v25}, Ltv/freewheel/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v25

    aput-object v25, v23, v24

    const/16 v24, 0x1

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v25

    invoke-interface/range {v25 .. v25}, Ltv/freewheel/ad/interfaces/ISlot;->getWidth()I

    move-result v25

    invoke-static/range {v25 .. v25}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v25

    aput-object v25, v23, v24

    const/16 v24, 0x2

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v25

    invoke-interface/range {v25 .. v25}, Ltv/freewheel/ad/interfaces/ISlot;->getHeight()I

    move-result v25

    invoke-static/range {v25 .. v25}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v25

    aput-object v25, v23, v24

    const/16 v24, 0x3

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IAdInstance;->getAdId()I

    move-result v25

    invoke-static/range {v25 .. v25}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v25

    aput-object v25, v23, v24

    const/16 v24, 0x4

    move-object/from16 v0, v19

    iget-object v0, v0, Ltv/freewheel/renderers/vast/model/Companion;->id:Ljava/lang/String;

    move-object/from16 v25, v0

    aput-object v25, v23, v24

    const/16 v24, 0x5

    move-object/from16 v0, v19

    iget-object v0, v0, Ltv/freewheel/renderers/vast/model/Companion;->width:Ljava/lang/Integer;

    move-object/from16 v25, v0

    aput-object v25, v23, v24

    const/16 v24, 0x6

    move-object/from16 v0, v19

    iget-object v0, v0, Ltv/freewheel/renderers/vast/model/Companion;->height:Ljava/lang/Integer;

    move-object/from16 v25, v0

    aput-object v25, v23, v24

    invoke-static/range {v22 .. v23}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 190
    .end local v4    # "adi":Ltv/freewheel/ad/interfaces/IAdInstance;
    .end local v5    # "ads":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/IAdInstance;>;"
    .end local v6    # "companionMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ltv/freewheel/ad/interfaces/ISlot;Ltv/freewheel/renderers/vast/model/Companion;>;"
    .end local v9    # "companionSlots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ISlot;>;"
    .end local v10    # "cr":Ltv/freewheel/ad/interfaces/ICreativeRendition;
    .end local v11    # "drivingAd":Ltv/freewheel/ad/interfaces/IAdInstance;
    .end local v12    # "device_dpr":D
    .end local v14    # "drivingRenditions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<+Ltv/freewheel/renderers/vast/model/AbstractCreativeRendition;>;"
    .end local v15    # "i":I
    .end local v16    # "i$":Ljava/util/Iterator;
    .end local v17    # "matchedCompanions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/renderers/vast/model/Companion;>;"
    .end local v18    # "preparedSlots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ISlot;>;"
    .end local v19    # "rend":Ltv/freewheel/renderers/vast/model/Companion;
    .end local v20    # "scheduledAds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/IAdInstance;>;"
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_LOADED()Ljava/lang/String;

    move-result-object v22

    invoke-interface/range {v21 .. v22}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 191
    return-void
.end method


# virtual methods
.method public dispose()V
    .locals 2

    .prologue
    .line 422
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "dispose()"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 423
    invoke-direct {p0}, Ltv/freewheel/renderers/vast/VastTranslator;->_stop()V

    .line 424
    return-void
.end method

.method public getDuration()D
    .locals 2

    .prologue
    .line 412
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    return-wide v0
.end method

.method public load(Ltv/freewheel/renderers/interfaces/IRendererContext;)V
    .locals 5
    .param p1, "rendererContext"    # Ltv/freewheel/renderers/interfaces/IRendererContext;

    .prologue
    .line 87
    iget-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "load()"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 88
    iput-object p1, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    .line 89
    invoke-interface {p1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/ad/interfaces/IConstants;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    .line 90
    new-instance v2, Ltv/freewheel/utils/renderer/ParamParser;

    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    const-string v4, "translator.vast"

    invoke-direct {v2, v3, v4}, Ltv/freewheel/utils/renderer/ParamParser;-><init>(Ltv/freewheel/renderers/interfaces/IRendererContext;Ljava/lang/String;)V

    iput-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->paramParser:Ltv/freewheel/utils/renderer/ParamParser;

    .line 92
    invoke-direct {p0}, Ltv/freewheel/renderers/vast/VastTranslator;->checkCompatibilityWithSDK()Z

    move-result v2

    if-nez v2, :cond_0

    .line 119
    :goto_0
    return-void

    .line 96
    :cond_0
    iget-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    invoke-interface {v2}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v0

    .line 97
    .local v0, "drivingSlot":Ltv/freewheel/ad/interfaces/ISlot;
    invoke-interface {v0}, Ltv/freewheel/ad/interfaces/ISlot;->getType()I

    move-result v2

    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->SLOT_TYPE_TEMPORAL()I

    move-result v3

    if-eq v2, v3, :cond_1

    .line 98
    iget-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_INVALID_SLOT()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Vast Translator only supports temporal slots."

    invoke-direct {p0, v2, v3}, Ltv/freewheel/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 102
    :cond_1
    iget-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    invoke-interface {v2}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->originalActiveRendition:Ltv/freewheel/ad/interfaces/ICreativeRendition;

    .line 105
    iget-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    invoke-interface {v2}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getWrapperURL()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    .line 106
    iget-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ltv/freewheel/renderers/vast/util/StringUtils;->isBlank(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    invoke-static {v2}, Landroid/webkit/URLUtil;->isValidUrl(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 107
    :cond_2
    iget-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_INVALID_VALUE()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Not a valid URL to load VAST document from: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v2, v3}, Ltv/freewheel/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 112
    :cond_3
    :try_start_0
    new-instance v2, Ljava/net/URL;

    iget-object v3, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    invoke-direct {v2, v3}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 118
    :goto_1
    iget-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    invoke-direct {p0, v2}, Ltv/freewheel/renderers/vast/VastTranslator;->sendRequest(Ljava/lang/String;)V

    goto :goto_0

    .line 113
    :catch_0
    move-exception v1

    .line 114
    .local v1, "e":Ljava/net/MalformedURLException;
    invoke-virtual {v1}, Ljava/net/MalformedURLException;->printStackTrace()V

    .line 115
    iget-object v2, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_INVALID_VALUE()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Not a valid URL to load VAST document from: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/vast/VastTranslator;->vastURL:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v2, v3}, Ltv/freewheel/renderers/vast/VastTranslator;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public start()V
    .locals 2

    .prologue
    .line 123
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "start()"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 124
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_STARTED()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 125
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/vast/VastTranslator;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_STOPPED()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 126
    return-void
.end method

.method public stop()V
    .locals 2

    .prologue
    .line 399
    iget-object v0, p0, Ltv/freewheel/renderers/vast/VastTranslator;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "stop()"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 400
    invoke-direct {p0}, Ltv/freewheel/renderers/vast/VastTranslator;->_stop()V

    .line 401
    return-void
.end method
