.class public Ltv/freewheel/renderers/html/HTMLRenderer;
.super Ljava/lang/Object;
.source "HTMLRenderer.java"

# interfaces
.implements Ltv/freewheel/renderers/interfaces/IRenderer;
.implements Ltv/freewheel/utils/renderer/RendererTimer$IRendererTimerService;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Ltv/freewheel/renderers/html/HTMLRenderer$15;,
        Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;
    }
.end annotation


# static fields
.field private static final closePositionOptions:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static dateFormat:Ljava/text/SimpleDateFormat;


# instance fields
.field private activity:Landroid/app/Activity;

.field private activityCallbackListener:Ltv/freewheel/renderers/interfaces/IActivityCallbackListener;

.field private allowOffscreen:Z

.field private constants:Ltv/freewheel/ad/interfaces/IConstants;

.field private creativeRequiredExpandHeight:I

.field private creativeRequiredExpandWidth:I

.field private creativeRequiredResizeHeight:I

.field private creativeRequiredResizeOffsetX:I

.field private creativeRequiredResizeOffsetY:I

.field private creativeRequiredResizeWidth:I

.field private customClosePosition:Ljava/lang/String;

.field private duration:D

.field private expandURL:Ljava/lang/String;

.field private headTime:Ljava/util/concurrent/atomic/AtomicInteger;

.field private isInterstitial:Z

.field private isMRAIDAd:Z

.field private isStopped:Z

.field private isUseCustomClose:Z

.field private isViewable:Z

.field private logger:Ltv/freewheel/utils/Logger;

.field private mainLoopHandler:Landroid/os/Handler;

.field private parameters:Ltv/freewheel/renderers/html/Parameters;

.field private pauseNotificationSentWhenExternalBrowserOpened:Z

.field private placementType:Ljava/lang/String;

.field private presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

.field private rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

.field private rendererTimer:Ltv/freewheel/utils/renderer/RendererTimer;

.field private shouldEndAfterDuration:Z

.field private shouldPauseResumeMainVideoOnActivityStateChange:Z

.field private shouldPauseResumeMainVideoWhenExpand:Z

.field private showedPresentation:Z

.field private slot:Ltv/freewheel/ad/interfaces/ISlot;

.field private state:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

.field private stateOfExternalWebBrowserActivity:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 115
    new-instance v0, Ljava/util/HashSet;

    const/4 v1, 0x7

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "top-left"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "top-right"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "center"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "bottom-left"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "bottom-right"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "top-center"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, "bottom-center"

    aput-object v3, v1, v2

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    sput-object v0, Ltv/freewheel/renderers/html/HTMLRenderer;->closePositionOptions:Ljava/util/Set;

    .line 850
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy-MM-dd\'T\'HH:mm:ssZZZ"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    sput-object v0, Ltv/freewheel/renderers/html/HTMLRenderer;->dateFormat:Ljava/text/SimpleDateFormat;

    return-void
.end method

.method public constructor <init>()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    const/4 v3, -0x1

    const/4 v2, 0x0

    .line 187
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object v4, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->parameters:Ltv/freewheel/renderers/html/Parameters;

    .line 50
    iput-object v4, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->placementType:Ljava/lang/String;

    .line 51
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->LOADING:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    iput-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->state:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    .line 52
    iput-boolean v5, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isViewable:Z

    .line 53
    iput-boolean v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isUseCustomClose:Z

    .line 63
    iput-boolean v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->pauseNotificationSentWhenExternalBrowserOpened:Z

    .line 64
    iput-boolean v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->showedPresentation:Z

    .line 67
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    iput-wide v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->duration:D

    .line 68
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0, v3}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->headTime:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 76
    iput v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->stateOfExternalWebBrowserActivity:I

    .line 99
    iput v3, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredExpandWidth:I

    .line 100
    iput v3, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredExpandHeight:I

    .line 125
    iput v3, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredResizeWidth:I

    .line 126
    iput v3, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredResizeHeight:I

    .line 127
    iput v3, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredResizeOffsetX:I

    .line 128
    iput v3, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredResizeOffsetY:I

    .line 129
    const-string v0, "top-right"

    iput-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->customClosePosition:Ljava/lang/String;

    .line 130
    iput-boolean v5, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->allowOffscreen:Z

    .line 174
    iput-boolean v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isMRAIDAd:Z

    .line 175
    iput-boolean v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->shouldEndAfterDuration:Z

    .line 176
    iput-boolean v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->shouldPauseResumeMainVideoWhenExpand:Z

    .line 178
    iput-boolean v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->shouldPauseResumeMainVideoOnActivityStateChange:Z

    .line 180
    iput-object v4, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    .line 181
    iput-object v4, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    .line 182
    iput-object v4, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    .line 184
    iput-object v4, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->mainLoopHandler:Landroid/os/Handler;

    .line 717
    iput-boolean v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isStopped:Z

    .line 188
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    .line 189
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Android SDK Version: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Landroid/os/Build$VERSION;->SDK:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", API Version: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    .line 190
    return-void
.end method

.method private CLASSTAG()Ljava/lang/String;
    .locals 2

    .prologue
    .line 164
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "@"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->placementType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "|"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getPrintableTimePositionClass()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "|"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private MRAIDTAG()Ljava/lang/String;
    .locals 2

    .prologue
    .line 168
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->CLASSTAG()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":=STATE("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getPrintableState()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private _close()V
    .locals 3

    .prologue
    .line 319
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " _close()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    .line 320
    iget-boolean v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isMRAIDAd:Z

    if-eqz v0, :cond_0

    .line 321
    iget v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->stateOfExternalWebBrowserActivity:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 322
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " An external web browser opened. It will delay close operation to resume from browser activity."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 323
    const/4 v0, 0x2

    iput v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->stateOfExternalWebBrowserActivity:I

    .line 333
    :goto_0
    return-void

    .line 327
    :cond_0
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->EXPANDED:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->RESIZED:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 328
    :cond_1
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->DEFAULT:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->transferTo(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)V

    goto :goto_0

    .line 329
    :cond_2
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->DEFAULT:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->LOADING:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 330
    :cond_3
    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->_stop()V

    goto :goto_0

    .line 332
    :cond_4
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Invalid state to close"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private _load(Ltv/freewheel/renderers/interfaces/IRendererContext;)V
    .locals 12
    .param p1, "rendererContext"    # Ltv/freewheel/renderers/interfaces/IRendererContext;

    .prologue
    .line 544
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v9, "load"

    invoke-virtual {v8, v9}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    .line 546
    iput-object p1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    .line 547
    invoke-interface {p1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/ad/interfaces/IConstants;

    move-result-object v8

    iput-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    .line 548
    invoke-interface {p1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v8

    iput-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    .line 549
    invoke-interface {p1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getActivity()Landroid/app/Activity;

    move-result-object v8

    iput-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->activity:Landroid/app/Activity;

    .line 550
    new-instance v8, Landroid/os/Handler;

    iget-object v9, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->activity:Landroid/app/Activity;

    invoke-virtual {v9}, Landroid/app/Activity;->getMainLooper()Landroid/os/Looper;

    move-result-object v9

    invoke-direct {v8, v9}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->mainLoopHandler:Landroid/os/Handler;

    .line 552
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->activity:Landroid/app/Activity;

    invoke-virtual {v8}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v4

    .line 553
    .local v4, "dm":Landroid/util/DisplayMetrics;
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Display size: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget v10, v4, Landroid/util/DisplayMetrics;->widthPixels:I

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "x"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget v10, v4, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " px, app size: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getAppWidth()I

    move-result v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "x"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getAppHeight()I

    move-result v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 555
    invoke-interface {p1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getCreativeAPI()Ljava/lang/String;

    move-result-object v2

    .line 556
    .local v2, "createApi":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v8

    const-string v9, "mraid"

    invoke-virtual {v8, v9}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v8

    iput-boolean v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isMRAIDAd:Z

    .line 557
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "creativeApi: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ", isMRAIDAd:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-boolean v10, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isMRAIDAd:Z

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 559
    new-instance v8, Ltv/freewheel/renderers/html/Parameters;

    invoke-direct {v8, p1}, Ltv/freewheel/renderers/html/Parameters;-><init>(Ltv/freewheel/renderers/interfaces/IRendererContext;)V

    iput-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->parameters:Ltv/freewheel/renderers/html/Parameters;

    .line 560
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->parameters:Ltv/freewheel/renderers/html/Parameters;

    iget-object v8, v8, Ltv/freewheel/renderers/html/Parameters;->placementType:Ljava/lang/String;

    iput-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->placementType:Ljava/lang/String;

    .line 561
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->placementType:Ljava/lang/String;

    if-nez v8, :cond_0

    .line 562
    invoke-interface {p1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getBaseUnit()Ljava/lang/String;

    move-result-object v0

    .line 563
    .local v0, "baseUnit":Ljava/lang/String;
    const-string v8, "app-interstitial"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 564
    const-string v8, "interstitial"

    iput-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->placementType:Ljava/lang/String;

    .line 570
    .end local v0    # "baseUnit":Ljava/lang/String;
    :cond_0
    :goto_0
    const-string v8, "interstitial"

    iget-object v9, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->placementType:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 571
    const/4 v8, 0x1

    iput-boolean v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isInterstitial:Z

    .line 579
    :goto_1
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "isInterstitial:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-boolean v10, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isInterstitial:Z

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 581
    iget-boolean v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isInterstitial:Z

    if-eqz v8, :cond_8

    .line 582
    new-instance v8, Ltv/freewheel/renderers/html/MRAIDPresentationInterstitial;

    iget-object v9, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->activity:Landroid/app/Activity;

    iget-boolean v10, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isMRAIDAd:Z

    invoke-direct {v8, v9, p0, v10}, Ltv/freewheel/renderers/html/MRAIDPresentationInterstitial;-><init>(Landroid/app/Activity;Ltv/freewheel/renderers/html/HTMLRenderer;Z)V

    iput-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    .line 587
    :goto_2
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v6

    .line 588
    .local v6, "tpc":I
    iget-boolean v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isInterstitial:Z

    if-nez v8, :cond_9

    iget-boolean v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isMRAIDAd:Z

    if-eqz v8, :cond_9

    .line 589
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_ACCEPT_INVITATION()Ljava/lang/String;

    move-result-object v8

    iget-object v9, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v9}, Ltv/freewheel/ad/interfaces/IConstants;->CAPABILITY_STATUS_ON()I

    move-result v9

    invoke-interface {p1, v8, v9}, Ltv/freewheel/renderers/interfaces/IRendererContext;->setRendererCapability(Ljava/lang/String;I)V

    .line 591
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_CLOSE()Ljava/lang/String;

    move-result-object v8

    iget-object v9, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v9}, Ltv/freewheel/ad/interfaces/IConstants;->CAPABILITY_STATUS_ON()I

    move-result v9

    invoke-interface {p1, v8, v9}, Ltv/freewheel/renderers/interfaces/IRendererContext;->setRendererCapability(Ljava/lang/String;I)V

    .line 592
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_EXPAND()Ljava/lang/String;

    move-result-object v8

    iget-object v9, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v9}, Ltv/freewheel/ad/interfaces/IConstants;->CAPABILITY_STATUS_ON()I

    move-result v9

    invoke-interface {p1, v8, v9}, Ltv/freewheel/renderers/interfaces/IRendererContext;->setRendererCapability(Ljava/lang/String;I)V

    .line 593
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_COLLAPSE()Ljava/lang/String;

    move-result-object v8

    iget-object v9, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v9}, Ltv/freewheel/ad/interfaces/IConstants;->CAPABILITY_STATUS_ON()I

    move-result v9

    invoke-interface {p1, v8, v9}, Ltv/freewheel/renderers/interfaces/IRendererContext;->setRendererCapability(Ljava/lang/String;I)V

    .line 598
    :cond_1
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IConstants;->TIME_POSITION_CLASS_DISPLAY()I

    move-result v8

    if-eq v6, v8, :cond_2

    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IConstants;->TIME_POSITION_CLASS_OVERLAY()I

    move-result v8

    if-ne v6, v8, :cond_3

    .line 599
    :cond_2
    const/4 v8, 0x1

    iput-boolean v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->shouldPauseResumeMainVideoOnActivityStateChange:Z

    .line 600
    iget-boolean v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isInterstitial:Z

    if-nez v8, :cond_3

    iget-boolean v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isMRAIDAd:Z

    if-eqz v8, :cond_3

    .line 601
    const/4 v8, 0x1

    iput-boolean v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->shouldPauseResumeMainVideoWhenExpand:Z

    .line 604
    :cond_3
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "shouldPauseResumeMainVideoOnActivityStateChange:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-boolean v10, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->shouldPauseResumeMainVideoOnActivityStateChange:Z

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ", shouldPauseResumeMainVideoWhenExpand:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-boolean v10, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->shouldPauseResumeMainVideoWhenExpand:Z

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 607
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->parameters:Ltv/freewheel/renderers/html/Parameters;

    iget-object v5, v8, Ltv/freewheel/renderers/html/Parameters;->shouldEndAfterDuration:Ljava/lang/Boolean;

    .line 608
    .local v5, "pval":Ljava/lang/Boolean;
    if-eqz v5, :cond_b

    .line 609
    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v8

    if-eqz v8, :cond_a

    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IConstants;->TIME_POSITION_CLASS_DISPLAY()I

    move-result v8

    if-eq v8, v6, :cond_a

    const/4 v8, 0x1

    :goto_3
    iput-boolean v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->shouldEndAfterDuration:Z

    .line 614
    :goto_4
    iget-boolean v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->shouldEndAfterDuration:Z

    if-eqz v8, :cond_4

    .line 615
    invoke-interface {p1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getDuration()D

    move-result-wide v8

    iput-wide v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->duration:D

    .line 616
    new-instance v8, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v9, 0x0

    invoke-direct {v8, v9}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->headTime:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 617
    new-instance v8, Ltv/freewheel/utils/renderer/RendererTimer;

    iget-wide v10, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->duration:D

    double-to-int v9, v10

    invoke-direct {v8, v9, p0}, Ltv/freewheel/utils/renderer/RendererTimer;-><init>(ILtv/freewheel/utils/renderer/RendererTimer$IRendererTimerService;)V

    iput-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererTimer:Ltv/freewheel/utils/renderer/RendererTimer;

    .line 620
    :cond_4
    invoke-interface {p1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/ad/interfaces/IAdInstance;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-result-object v8

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v3

    .line 622
    .local v3, "creativeRenditionAsset":Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;
    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;->getURL()Ljava/lang/String;

    move-result-object v7

    .line 623
    .local v7, "url":Ljava/lang/String;
    if-eqz v7, :cond_d

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v8

    if-eqz v8, :cond_d

    .line 625
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-interface {v8, v7, v9, v10}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->loadCreativeWithScript(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 636
    :goto_5
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_LOADED()Ljava/lang/String;

    move-result-object v8

    invoke-interface {p1, v8}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 637
    .end local v3    # "creativeRenditionAsset":Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;
    .end local v5    # "pval":Ljava/lang/Boolean;
    .end local v7    # "url":Ljava/lang/String;
    :goto_6
    return-void

    .line 566
    .end local v6    # "tpc":I
    .restart local v0    # "baseUnit":Ljava/lang/String;
    :cond_5
    const-string v8, "inline"

    iput-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->placementType:Ljava/lang/String;

    goto/16 :goto_0

    .line 572
    .end local v0    # "baseUnit":Ljava/lang/String;
    :cond_6
    const-string v8, "inline"

    iget-object v9, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->placementType:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 573
    const/4 v8, 0x0

    iput-boolean v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isInterstitial:Z

    goto/16 :goto_1

    .line 575
    :cond_7
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Invalid placement type:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v10, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->placementType:Ljava/lang/String;

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ", use inline type as default"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 576
    const/4 v8, 0x0

    iput-boolean v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isInterstitial:Z

    .line 577
    const-string v8, "inline"

    iput-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->placementType:Ljava/lang/String;

    goto/16 :goto_1

    .line 584
    :cond_8
    new-instance v8, Ltv/freewheel/renderers/html/MRAIDPresentationInLine;

    iget-object v9, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->activity:Landroid/app/Activity;

    iget-object v10, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-boolean v11, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isMRAIDAd:Z

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v11

    invoke-direct {v8, v9, p0, v10, v11}, Ltv/freewheel/renderers/html/MRAIDPresentationInLine;-><init>(Landroid/app/Activity;Ltv/freewheel/renderers/html/HTMLRenderer;Ltv/freewheel/renderers/interfaces/IRendererContext;Ljava/lang/Boolean;)V

    iput-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    goto/16 :goto_2

    .line 594
    .restart local v6    # "tpc":I
    :cond_9
    iget-boolean v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isInterstitial:Z

    if-eqz v8, :cond_1

    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IConstants;->TIME_POSITION_CLASS_OVERLAY()I

    move-result v8

    if-ne v6, v8, :cond_1

    .line 595
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_INVALID_SLOT()Ljava/lang/String;

    move-result-object v8

    const-string v9, "The interstitial ad is not supported in overlay slot"

    invoke-direct {p0, v8, v9}, Ltv/freewheel/renderers/html/HTMLRenderer;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_6

    .line 609
    .restart local v5    # "pval":Ljava/lang/Boolean;
    :cond_a
    const/4 v8, 0x0

    goto/16 :goto_3

    .line 611
    :cond_b
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IConstants;->TIME_POSITION_CLASS_DISPLAY()I

    move-result v8

    if-eq v8, v6, :cond_c

    const/4 v8, 0x1

    :goto_7
    iput-boolean v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->shouldEndAfterDuration:Z

    goto/16 :goto_4

    :cond_c
    const/4 v8, 0x0

    goto :goto_7

    .line 627
    .restart local v3    # "creativeRenditionAsset":Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;
    .restart local v7    # "url":Ljava/lang/String;
    :cond_d
    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;->getContent()Ljava/lang/String;

    move-result-object v1

    .line 628
    .local v1, "content":Ljava/lang/String;
    if-eqz v1, :cond_e

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v8

    if-eqz v8, :cond_e

    .line 629
    const-string v8, "[\\s,]*target-densitydpi = device-dpi[\\s]*"

    const-string v9, ""

    invoke-virtual {v1, v8, v9}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 630
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-interface {v8, v9, v1, v10}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->loadCreativeWithScript(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_5

    .line 632
    :cond_e
    iget-object v8, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_NULL_ASSET()Ljava/lang/String;

    move-result-object v8

    const-string v9, "No creative asset"

    invoke-direct {p0, v8, v9}, Ltv/freewheel/renderers/html/HTMLRenderer;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_6
.end method

.method private _loadFail(ILjava/lang/String;)V
    .locals 3
    .param p1, "errorCode"    # I
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 281
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " errorCode:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ",description:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 282
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v0}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_IO()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Load failed"

    invoke-direct {p0, v0, v1}, Ltv/freewheel/renderers/html/HTMLRenderer;->failWithError(Ljava/lang/String;Ljava/lang/String;)V

    .line 283
    return-void
.end method

.method private _loaded()V
    .locals 3

    .prologue
    .line 286
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " _loaded()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    .line 287
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->LOADING:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 288
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->DEFAULT:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->transferTo(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)V

    .line 293
    :goto_0
    return-void

    .line 289
    :cond_0
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->DEFAULT:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 290
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " expanded view loaded."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    goto :goto_0

    .line 292
    :cond_1
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Invalid state to have been loaded"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private _stop()V
    .locals 3

    .prologue
    .line 720
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->CLASSTAG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " _stop, isStopped="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isStopped:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    .line 721
    iget-boolean v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isStopped:Z

    if-eqz v0, :cond_0

    .line 725
    :goto_0
    return-void

    .line 723
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isStopped:Z

    .line 724
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->HIDDEN:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->transferTo(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)V

    goto :goto_0
.end method

.method private _synchStateToPresentation(Z)V
    .locals 18
    .param p1, "isResized"    # Z

    .prologue
    .line 453
    move-object/from16 v0, p0

    iget-boolean v14, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->isMRAIDAd:Z

    if-nez v14, :cond_0

    .line 520
    :goto_0
    return-void

    .line 455
    :cond_0
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->activity:Landroid/app/Activity;

    invoke-virtual {v14}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v14

    invoke-virtual {v14}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v7

    .line 456
    .local v7, "dm":Landroid/util/DisplayMetrics;
    new-instance v9, Lorg/json/JSONObject;

    invoke-direct {v9}, Lorg/json/JSONObject;-><init>()V

    .line 457
    .local v9, "expandProperties":Lorg/json/JSONObject;
    new-instance v12, Lorg/json/JSONObject;

    invoke-direct {v12}, Lorg/json/JSONObject;-><init>()V

    .line 458
    .local v12, "resizeProperties":Lorg/json/JSONObject;
    new-instance v11, Lorg/json/JSONObject;

    invoke-direct {v11}, Lorg/json/JSONObject;-><init>()V

    .line 459
    .local v11, "maxSize":Lorg/json/JSONObject;
    new-instance v13, Lorg/json/JSONObject;

    invoke-direct {v13}, Lorg/json/JSONObject;-><init>()V

    .line 460
    .local v13, "screenSize":Lorg/json/JSONObject;
    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6}, Lorg/json/JSONObject;-><init>()V

    .line 461
    .local v6, "defaultPosition":Lorg/json/JSONObject;
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 463
    .local v2, "currentPosition":Lorg/json/JSONObject;
    :try_start_0
    const-string v14, "width"

    invoke-direct/range {p0 .. p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->expandWidth()I

    move-result v15

    int-to-float v15, v15

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v16, v0

    div-float v15, v15, v16

    float-to-int v15, v15

    invoke-virtual {v9, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "height"

    invoke-direct/range {p0 .. p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->expandHeight()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v17, v0

    div-float v16, v16, v17

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "useCustomClose"

    move-object/from16 v0, p0

    iget-boolean v0, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->isUseCustomClose:Z

    move/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "isModal"

    const/16 v16, 0x1

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 468
    move-object/from16 v0, p0

    iget v14, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredResizeWidth:I

    if-lez v14, :cond_1

    move-object/from16 v0, p0

    iget v14, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredResizeHeight:I

    if-lez v14, :cond_1

    .line 469
    const-string v14, "width"

    move-object/from16 v0, p0

    iget v15, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredResizeWidth:I

    int-to-float v15, v15

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v16, v0

    div-float v15, v15, v16

    float-to-int v15, v15

    invoke-virtual {v12, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "height"

    move-object/from16 v0, p0

    iget v0, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredResizeHeight:I

    move/from16 v16, v0

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v17, v0

    div-float v16, v16, v17

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "offsetX"

    move-object/from16 v0, p0

    iget v0, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredResizeOffsetX:I

    move/from16 v16, v0

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v17, v0

    div-float v16, v16, v17

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "offsetY"

    move-object/from16 v0, p0

    iget v0, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredResizeOffsetY:I

    move/from16 v16, v0

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v17, v0

    div-float v16, v16, v17

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "customClosePosition"

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->customClosePosition:Ljava/lang/String;

    move-object/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "allowOffscreen"

    move-object/from16 v0, p0

    iget-boolean v0, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->allowOffscreen:Z

    move/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 477
    :cond_1
    const-string v14, "width"

    invoke-direct/range {p0 .. p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getAppWidth()I

    move-result v15

    int-to-float v15, v15

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v16, v0

    div-float v15, v15, v16

    float-to-int v15, v15

    invoke-virtual {v11, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "height"

    invoke-direct/range {p0 .. p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getAppHeight()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v17, v0

    div-float v16, v16, v17

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 480
    const-string v14, "width"

    invoke-direct/range {p0 .. p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getScreenWidth()I

    move-result v15

    int-to-float v15, v15

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v16, v0

    div-float v15, v15, v16

    float-to-int v15, v15

    invoke-virtual {v13, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "height"

    invoke-direct/range {p0 .. p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getScreenHeight()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v17, v0

    div-float v16, v16, v17

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 483
    const/4 v14, 0x2

    new-array v1, v14, [I

    .line 484
    .local v1, "appViewLocation":[I
    invoke-direct/range {p0 .. p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getAppView()Landroid/view/View;

    move-result-object v14

    invoke-virtual {v14, v1}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 486
    const/4 v14, 0x4

    new-array v5, v14, [I

    .line 487
    .local v5, "defaultLocation":[I
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    invoke-interface {v14, v5}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->getDefaultPositionOnScreen([I)V

    .line 488
    const-string v14, "x"

    const/4 v15, 0x0

    aget v15, v5, v15

    const/16 v16, 0x0

    aget v16, v1, v16

    sub-int v15, v15, v16

    int-to-float v15, v15

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v16, v0

    div-float v15, v15, v16

    float-to-int v15, v15

    invoke-virtual {v6, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "y"

    const/16 v16, 0x1

    aget v16, v5, v16

    const/16 v17, 0x1

    aget v17, v1, v17

    sub-int v16, v16, v17

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v17, v0

    div-float v16, v16, v17

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "width"

    const/16 v16, 0x2

    aget v16, v5, v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v17, v0

    div-float v16, v16, v17

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "height"

    const/16 v16, 0x3

    aget v16, v5, v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v17, v0

    div-float v16, v16, v17

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 493
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    invoke-interface {v14}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->getCurrentView()Ltv/freewheel/renderers/html/MRAIDWebView;

    move-result-object v3

    .line 494
    .local v3, "currentView":Ltv/freewheel/renderers/html/MRAIDWebView;
    if-eqz v3, :cond_2

    .line 495
    const/4 v14, 0x2

    new-array v4, v14, [I

    .line 496
    .local v4, "currentViewLocation":[I
    invoke-virtual {v3, v4}, Ltv/freewheel/renderers/html/MRAIDWebView;->getLocationOnScreen([I)V

    .line 497
    const-string v14, "x"

    const/4 v15, 0x0

    aget v15, v4, v15

    const/16 v16, 0x0

    aget v16, v1, v16

    sub-int v15, v15, v16

    int-to-float v15, v15

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v16, v0

    div-float v15, v15, v16

    float-to-int v15, v15

    invoke-virtual {v2, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "y"

    const/16 v16, 0x1

    aget v16, v4, v16

    const/16 v17, 0x1

    aget v17, v1, v17

    sub-int v16, v16, v17

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v17, v0

    div-float v16, v16, v17

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "width"

    invoke-virtual {v3}, Ltv/freewheel/renderers/html/MRAIDWebView;->getWidth()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v17, v0

    div-float v16, v16, v17

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "height"

    invoke-virtual {v3}, Ltv/freewheel/renderers/html/MRAIDWebView;->getHeight()I

    move-result v16

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v16, v0

    iget v0, v7, Landroid/util/DisplayMetrics;->density:F

    move/from16 v17, v0

    div-float v16, v16, v17

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 507
    .end local v1    # "appViewLocation":[I
    .end local v3    # "currentView":Ltv/freewheel/renderers/html/MRAIDWebView;
    .end local v4    # "currentViewLocation":[I
    .end local v5    # "defaultLocation":[I
    :goto_1
    const-string v14, "window.mraid._Update(\'%s\', %s, \'%s\', \'%s\', \'%s\', \'%s\', \'%s\', \'%s\', \'%s\', %s);"

    const/16 v15, 0xa

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    invoke-direct/range {p0 .. p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getPrintableState()Ljava/lang/String;

    move-result-object v17

    aput-object v17, v15, v16

    const/16 v16, 0x1

    move-object/from16 v0, p0

    iget-boolean v0, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->isViewable:Z

    move/from16 v17, v0

    invoke-static/range {v17 .. v17}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v17

    aput-object v17, v15, v16

    const/16 v16, 0x2

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->placementType:Ljava/lang/String;

    move-object/from16 v17, v0

    aput-object v17, v15, v16

    const/16 v16, 0x3

    aput-object v9, v15, v16

    const/16 v16, 0x4

    aput-object v12, v15, v16

    const/16 v16, 0x5

    aput-object v11, v15, v16

    const/16 v16, 0x6

    aput-object v13, v15, v16

    const/16 v16, 0x7

    aput-object v6, v15, v16

    const/16 v16, 0x8

    aput-object v2, v15, v16

    const/16 v16, 0x9

    invoke-static/range {p1 .. p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    .line 518
    .local v10, "jsupdate":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct/range {p0 .. p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, " synchStateToPresentation(script=\'"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "\'"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 519
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    invoke-interface {v14, v10}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->runJavaScript(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 502
    .end local v10    # "jsupdate":Ljava/lang/String;
    .restart local v1    # "appViewLocation":[I
    .restart local v3    # "currentView":Ltv/freewheel/renderers/html/MRAIDWebView;
    .restart local v5    # "defaultLocation":[I
    :cond_2
    :try_start_1
    const-string v14, "x"

    const/4 v15, 0x0

    invoke-virtual {v2, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "y"

    const/16 v16, 0x0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "width"

    const/16 v16, 0x0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v14

    const-string v15, "height"

    const/16 v16, 0x0

    invoke-virtual/range {v14 .. v16}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1

    .line 504
    .end local v1    # "appViewLocation":[I
    .end local v3    # "currentView":Ltv/freewheel/renderers/html/MRAIDWebView;
    .end local v5    # "defaultLocation":[I
    :catch_0
    move-exception v8

    .line 505
    .local v8, "e":Lorg/json/JSONException;
    move-object/from16 v0, p0

    iget-object v14, v0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct/range {p0 .. p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, " error in sync MRAID state "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v8}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto/16 :goto_1
.end method

.method static synthetic access$000(Ltv/freewheel/renderers/html/HTMLRenderer;Z)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/html/HTMLRenderer;
    .param p1, "x1"    # Z

    .prologue
    .line 40
    invoke-direct {p0, p1}, Ltv/freewheel/renderers/html/HTMLRenderer;->_synchStateToPresentation(Z)V

    return-void
.end method

.method static synthetic access$100(Ltv/freewheel/renderers/html/HTMLRenderer;Ltv/freewheel/renderers/interfaces/IRendererContext;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/html/HTMLRenderer;
    .param p1, "x1"    # Ltv/freewheel/renderers/interfaces/IRendererContext;

    .prologue
    .line 40
    invoke-direct {p0, p1}, Ltv/freewheel/renderers/html/HTMLRenderer;->_load(Ltv/freewheel/renderers/interfaces/IRendererContext;)V

    return-void
.end method

.method static synthetic access$1000(Ltv/freewheel/renderers/html/HTMLRenderer;)Ltv/freewheel/renderers/html/IMRAIDPresentation;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/html/HTMLRenderer;

    .prologue
    .line 40
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    return-object v0
.end method

.method static synthetic access$1402(Ltv/freewheel/renderers/html/HTMLRenderer;Z)Z
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/html/HTMLRenderer;
    .param p1, "x1"    # Z

    .prologue
    .line 40
    iput-boolean p1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->showedPresentation:Z

    return p1
.end method

.method static synthetic access$1500(Ltv/freewheel/renderers/html/HTMLRenderer;Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/html/HTMLRenderer;
    .param p1, "x1"    # Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    .prologue
    .line 40
    invoke-direct {p0, p1}, Ltv/freewheel/renderers/html/HTMLRenderer;->transferTo(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)V

    return-void
.end method

.method static synthetic access$1600(Ltv/freewheel/renderers/html/HTMLRenderer;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/html/HTMLRenderer;

    .prologue
    .line 40
    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->_stop()V

    return-void
.end method

.method static synthetic access$1700(Ltv/freewheel/renderers/html/HTMLRenderer;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/html/HTMLRenderer;

    .prologue
    .line 40
    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->_loaded()V

    return-void
.end method

.method static synthetic access$1900(Ltv/freewheel/renderers/html/HTMLRenderer;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/html/HTMLRenderer;

    .prologue
    .line 40
    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->_close()V

    return-void
.end method

.method static synthetic access$200(Ltv/freewheel/renderers/html/HTMLRenderer;)Ltv/freewheel/renderers/interfaces/IActivityCallbackListener;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/html/HTMLRenderer;

    .prologue
    .line 40
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->activityCallbackListener:Ltv/freewheel/renderers/interfaces/IActivityCallbackListener;

    return-object v0
.end method

.method static synthetic access$202(Ltv/freewheel/renderers/html/HTMLRenderer;Ltv/freewheel/renderers/interfaces/IActivityCallbackListener;)Ltv/freewheel/renderers/interfaces/IActivityCallbackListener;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/html/HTMLRenderer;
    .param p1, "x1"    # Ltv/freewheel/renderers/interfaces/IActivityCallbackListener;

    .prologue
    .line 40
    iput-object p1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->activityCallbackListener:Ltv/freewheel/renderers/interfaces/IActivityCallbackListener;

    return-object p1
.end method

.method static synthetic access$2600(Ltv/freewheel/renderers/html/HTMLRenderer;ILjava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/html/HTMLRenderer;
    .param p1, "x1"    # I
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 40
    invoke-direct {p0, p1, p2}, Ltv/freewheel/renderers/html/HTMLRenderer;->_loadFail(ILjava/lang/String;)V

    return-void
.end method

.method static synthetic access$400(Ltv/freewheel/renderers/html/HTMLRenderer;)Ltv/freewheel/ad/interfaces/IConstants;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/html/HTMLRenderer;

    .prologue
    .line 40
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    return-object v0
.end method

.method static synthetic access$600(Ltv/freewheel/renderers/html/HTMLRenderer;Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/html/HTMLRenderer;
    .param p1, "x1"    # Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    .prologue
    .line 40
    invoke-direct {p0, p1}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$900(Ltv/freewheel/renderers/html/HTMLRenderer;)Ltv/freewheel/renderers/interfaces/IRendererContext;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/html/HTMLRenderer;

    .prologue
    .line 40
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    return-object v0
.end method

.method private expandHeight()I
    .locals 2

    .prologue
    .line 107
    iget v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredExpandHeight:I

    if-lez v0, :cond_0

    iget v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredExpandHeight:I

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getScreenHeight()I

    move-result v1

    if-ge v0, v1, :cond_0

    iget v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredExpandHeight:I

    :goto_0
    return v0

    :cond_0
    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getScreenHeight()I

    move-result v0

    goto :goto_0
.end method

.method private expandWidth()I
    .locals 2

    .prologue
    .line 103
    iget v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredExpandWidth:I

    if-lez v0, :cond_0

    iget v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredExpandWidth:I

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getScreenWidth()I

    move-result v1

    if-ge v0, v1, :cond_0

    iget v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredExpandWidth:I

    :goto_0
    return v0

    :cond_0
    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getScreenWidth()I

    move-result v0

    goto :goto_0
.end method

.method private failWithError(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "errorCode"    # Ljava/lang/String;
    .param p2, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 523
    iget-object v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->CLASSTAG()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " failWithError errorCode:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", errorMessage:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    .line 524
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 525
    .local v0, "info":Landroid/os/Bundle;
    iget-object v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 526
    iget-object v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 527
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 528
    .local v1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 529
    iget-object v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v3, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 530
    return-void
.end method

.method private getAppHeight()I
    .locals 1

    .prologue
    .line 88
    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getAppView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v0

    return v0
.end method

.method private getAppView()Landroid/view/View;
    .locals 2

    .prologue
    .line 79
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const v1, 0x1020002

    invoke-virtual {v0, v1}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method private getAppWidth()I
    .locals 1

    .prologue
    .line 84
    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getAppView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getWidth()I

    move-result v0

    return v0
.end method

.method private getPrintableState()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->state:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getPrintableState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getPrintableState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Ljava/lang/String;
    .locals 2
    .param p1, "state"    # Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    .prologue
    .line 133
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$15;->$SwitchMap$tv$freewheel$renderers$html$HTMLRenderer$MRAIDState:[I

    invoke-virtual {p1}, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 145
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 135
    :pswitch_0
    const-string v0, "loading"

    goto :goto_0

    .line 137
    :pswitch_1
    const-string v0, "default"

    goto :goto_0

    .line 139
    :pswitch_2
    const-string v0, "expanded"

    goto :goto_0

    .line 141
    :pswitch_3
    const-string v0, "resized"

    goto :goto_0

    .line 143
    :pswitch_4
    const-string v0, "hidden"

    goto :goto_0

    .line 133
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method private getPrintableTimePositionClass()Ljava/lang/String;
    .locals 10

    .prologue
    const/4 v9, 0x4

    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 150
    iget-object v4, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    if-nez v4, :cond_0

    .line 151
    const-string v4, ""

    .line 160
    :goto_0
    return-object v4

    .line 152
    :cond_0
    iget-object v4, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v3

    .line 153
    .local v3, "tpc":I
    const/4 v4, 0x5

    new-array v0, v4, [Ljava/lang/String;

    const-string v4, "display"

    aput-object v4, v0, v5

    const-string v4, "overlay"

    aput-object v4, v0, v6

    const-string v4, "preroll"

    aput-object v4, v0, v7

    const-string v4, "midroll"

    aput-object v4, v0, v8

    const-string v4, "postroll"

    aput-object v4, v0, v9

    .line 154
    .local v0, "arr":[Ljava/lang/String;
    const/4 v4, 0x5

    new-array v1, v4, [I

    iget-object v4, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->TIME_POSITION_CLASS_DISPLAY()I

    move-result v4

    aput v4, v1, v5

    iget-object v4, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->TIME_POSITION_CLASS_OVERLAY()I

    move-result v4

    aput v4, v1, v6

    iget-object v4, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->TIME_POSITION_CLASS_PREROLL()I

    move-result v4

    aput v4, v1, v7

    iget-object v4, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->TIME_POSITION_CLASS_MIDROLL()I

    move-result v4

    aput v4, v1, v8

    iget-object v4, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->TIME_POSITION_CLASS_POSTROLL()I

    move-result v4

    aput v4, v1, v9

    .line 157
    .local v1, "arrTPC":[I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    array-length v4, v1

    if-ge v2, v4, :cond_2

    .line 158
    aget v4, v1, v2

    if-ne v4, v3, :cond_1

    .line 159
    aget-object v4, v0, v2

    goto :goto_0

    .line 157
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 160
    :cond_2
    const-string v4, ""

    goto :goto_0
.end method

.method private getScreenHeight()I
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    return v0
.end method

.method private getScreenWidth()I
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    return v0
.end method

.method private isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z
    .locals 1
    .param p1, "state"    # Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    .prologue
    .line 193
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->state:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-virtual {v0, p1}, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isIntentAvailable(Landroid/content/Context;Landroid/content/Intent;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 988
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const/high16 v1, 0x10000

    invoke-virtual {v0, p1, v1}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private pingBack(Ljava/lang/String;)V
    .locals 3
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 197
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " pingBack("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 198
    iget-boolean v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isInterstitial:Z

    if-nez v0, :cond_0

    .line 199
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    invoke-interface {v0, p1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 200
    :cond_0
    return-void
.end method

.method private setMraidFeatures()V
    .locals 6

    .prologue
    .line 992
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "window.mraid._setSupportingFeatures("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->activity:Landroid/app/Activity;

    new-instance v3, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    const-string v5, "sms:"

    invoke-static {v5}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-static {v2, v3}, Ltv/freewheel/renderers/html/HTMLRenderer;->isIntentAvailable(Landroid/content/Context;Landroid/content/Intent;)Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->activity:Landroid/app/Activity;

    new-instance v3, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    const-string v5, "tel:"

    invoke-static {v5}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-static {v2, v3}, Ltv/freewheel/renderers/html/HTMLRenderer;->isIntentAvailable(Landroid/content/Context;Landroid/content/Intent;)Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "false, "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "false, "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    invoke-interface {v2}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->supportsInlineVideo()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ");"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1004
    .local v0, "js":Ljava/lang/String;
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " setMraidFeatures(script=\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 1005
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    invoke-interface {v1, v0}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->runJavaScript(Ljava/lang/String;)V

    .line 1006
    return-void
.end method

.method private transferTo(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)V
    .locals 9
    .param p1, "toState"    # Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    .prologue
    const/4 v0, 0x0

    .line 203
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " transferTo:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-direct {p0, p1}, Ltv/freewheel/renderers/html/HTMLRenderer;->getPrintableState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 204
    invoke-direct {p0, p1}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v1

    if-eqz v1, :cond_1

    sget-object v1, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->RESIZED:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v1}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 278
    :cond_0
    :goto_0
    return-void

    .line 206
    :cond_1
    const/4 v8, 0x1

    .line 207
    .local v8, "isValidTransfer":Z
    sget-object v1, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->EXPANDED:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-virtual {p1, v1}, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 208
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererTimer:Ltv/freewheel/utils/renderer/RendererTimer;

    if-eqz v1, :cond_2

    .line 209
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererTimer:Ltv/freewheel/utils/renderer/RendererTimer;

    invoke-virtual {v1}, Ltv/freewheel/utils/renderer/RendererTimer;->pause()V

    .line 210
    :cond_2
    iget-boolean v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->shouldPauseResumeMainVideoWhenExpand:Z

    if-eqz v1, :cond_3

    .line 211
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_REQUEST_CONTENT_VIDEO_PAUSE()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 212
    :cond_3
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->expandURL:Ljava/lang/String;

    if-nez v1, :cond_6

    .line 213
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_EXPAND()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Ltv/freewheel/renderers/html/HTMLRenderer;->pingBack(Ljava/lang/String;)V

    .line 216
    :goto_1
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->expandURL:Ljava/lang/String;

    if-nez v1, :cond_7

    const/4 v7, 0x0

    .line 217
    .local v7, "absoluteExpandURL":Ljava/lang/String;
    :goto_2
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    iget-boolean v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isUseCustomClose:Z

    if-nez v2, :cond_4

    const/4 v0, 0x1

    :cond_4
    invoke-interface {v1, v0}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->setCloseButtonVisibility(Z)V

    .line 218
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->expandWidth()I

    move-result v1

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->expandHeight()I

    move-result v2

    invoke-interface {v0, v7, v1, v2}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->expand(Ljava/lang/String;II)V

    .line 275
    .end local v7    # "absoluteExpandURL":Ljava/lang/String;
    :cond_5
    :goto_3
    if-eqz v8, :cond_0

    iget-boolean v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isInterstitial:Z

    if-nez v0, :cond_0

    .line 276
    iput-object p1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->state:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    goto :goto_0

    .line 215
    :cond_6
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_ACCEPT_INVITATION()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Ltv/freewheel/renderers/html/HTMLRenderer;->pingBack(Ljava/lang/String;)V

    goto :goto_1

    .line 216
    :cond_7
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    iget-object v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->expandURL:Ljava/lang/String;

    invoke-interface {v1, v2}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->getAbsoluteURL(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    goto :goto_2

    .line 219
    :cond_8
    sget-object v1, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->DEFAULT:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-virtual {p1, v1}, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 220
    sget-object v1, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->LOADING:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v1}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 221
    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->setMraidFeatures()V

    .line 222
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererTimer:Ltv/freewheel/utils/renderer/RendererTimer;

    if-eqz v1, :cond_9

    .line 223
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererTimer:Ltv/freewheel/utils/renderer/RendererTimer;

    invoke-virtual {v1}, Ltv/freewheel/utils/renderer/RendererTimer;->start()V

    .line 224
    :cond_9
    iput-object p1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->state:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    .line 225
    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->_synchStateToPresentation(Z)V

    goto/16 :goto_0

    .line 227
    :cond_a
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->EXPANDED:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 228
    iget-boolean v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->shouldPauseResumeMainVideoWhenExpand:Z

    if-eqz v0, :cond_b

    .line 229
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_REQUEST_CONTENT_VIDEO_RESUME()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 230
    :cond_b
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererTimer:Ltv/freewheel/utils/renderer/RendererTimer;

    if-eqz v0, :cond_c

    .line 231
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererTimer:Ltv/freewheel/utils/renderer/RendererTimer;

    invoke-virtual {v0}, Ltv/freewheel/utils/renderer/RendererTimer;->resume()V

    .line 233
    :cond_c
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->expandURL:Ljava/lang/String;

    if-nez v0, :cond_d

    .line 234
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v0}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_COLLAPSE()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->pingBack(Ljava/lang/String;)V

    .line 235
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    invoke-interface {v0}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->collapse()V

    goto :goto_3

    .line 237
    :cond_d
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v0}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_CLOSE()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->pingBack(Ljava/lang/String;)V

    .line 238
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    invoke-interface {v0}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->close()V

    goto :goto_3

    .line 240
    :cond_e
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->RESIZED:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 241
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    invoke-interface {v0}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->close()V

    goto/16 :goto_3

    .line 243
    :cond_f
    const/4 v8, 0x0

    .line 244
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Invalid transfer"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 246
    :cond_10
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->HIDDEN:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-virtual {p1, v0}, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_14

    .line 247
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererTimer:Ltv/freewheel/utils/renderer/RendererTimer;

    if-eqz v0, :cond_11

    .line 248
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererTimer:Ltv/freewheel/utils/renderer/RendererTimer;

    invoke-virtual {v0}, Ltv/freewheel/utils/renderer/RendererTimer;->stop()V

    .line 249
    :cond_11
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->LOADING:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    if-eqz v0, :cond_12

    iget-boolean v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->showedPresentation:Z

    if-eqz v0, :cond_13

    .line 250
    :cond_12
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    invoke-interface {v0}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->close()V

    .line 252
    :cond_13
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    invoke-interface {v0}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->dispose()V

    .line 253
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_STOPPED()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 254
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->LOADING:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    if-eqz v0, :cond_5

    iget-boolean v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isInterstitial:Z

    if-eqz v0, :cond_5

    .line 255
    iput-object p1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->state:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    goto/16 :goto_0

    .line 258
    :cond_14
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->RESIZED:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-virtual {p1, v0}, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_18

    .line 259
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->EXPANDED:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    if-eqz v0, :cond_15

    .line 260
    const-string v0, "resize called in expanded state"

    const-string v1, "resize"

    invoke-virtual {p0, v0, v1}, Ltv/freewheel/renderers/html/HTMLRenderer;->dispatchMraidError(Ljava/lang/String;Ljava/lang/String;)V

    .line 261
    const/4 v8, 0x0

    goto/16 :goto_3

    .line 262
    :cond_15
    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->RESIZED:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    if-nez v0, :cond_16

    sget-object v0, Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;->DEFAULT:Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->isInState(Ltv/freewheel/renderers/html/HTMLRenderer$MRAIDState;)Z

    move-result v0

    if-eqz v0, :cond_17

    .line 263
    :cond_16
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    iget v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredResizeOffsetX:I

    iget v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredResizeOffsetY:I

    iget v3, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredResizeWidth:I

    iget v4, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->creativeRequiredResizeHeight:I

    iget-object v5, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->customClosePosition:Ljava/lang/String;

    iget-boolean v6, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->allowOffscreen:Z

    invoke-interface/range {v0 .. v6}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->resize(IIIILjava/lang/String;Z)V

    goto/16 :goto_3

    .line 267
    :cond_17
    const/4 v8, 0x0

    .line 268
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " resize called in "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->getPrintableState()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " state, no effect"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 271
    :cond_18
    const/4 v8, 0x0

    .line 272
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Invalid transfer"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_3
.end method


# virtual methods
.method public dispatchMraidError(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "action"    # Ljava/lang/String;

    .prologue
    .line 1009
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->MRAIDTAG()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " Dispatch MRAID error ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 1010
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "window.mraid.dispatchEvent(\'error\', \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\', \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\');"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1011
    .local v0, "js":Ljava/lang/String;
    iget-object v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->presentation:Ltv/freewheel/renderers/html/IMRAIDPresentation;

    invoke-interface {v1, v0}, Ltv/freewheel/renderers/html/IMRAIDPresentation;->runJavaScript(Ljava/lang/String;)V

    .line 1012
    return-void
.end method

.method public dispose()V
    .locals 3

    .prologue
    .line 742
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->CLASSTAG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " dispose"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    .line 743
    invoke-virtual {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->stop()V

    .line 744
    return-void
.end method

.method public getDuration()D
    .locals 2

    .prologue
    .line 927
    iget-wide v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->duration:D

    return-wide v0
.end method

.method public load(Ltv/freewheel/renderers/interfaces/IRendererContext;)V
    .locals 3
    .param p1, "rendererContext"    # Ltv/freewheel/renderers/interfaces/IRendererContext;

    .prologue
    .line 534
    move-object v0, p1

    .line 535
    .local v0, "rendererContextFinalRef":Ltv/freewheel/renderers/interfaces/IRendererContext;
    invoke-interface {p1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getActivity()Landroid/app/Activity;

    move-result-object v1

    new-instance v2, Ltv/freewheel/renderers/html/HTMLRenderer$2;

    invoke-direct {v2, p0, v0}, Ltv/freewheel/renderers/html/HTMLRenderer$2;-><init>(Ltv/freewheel/renderers/html/HTMLRenderer;Ltv/freewheel/renderers/interfaces/IRendererContext;)V

    invoke-virtual {v1, v2}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 541
    return-void
.end method

.method public mraidClose()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 766
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->mainLoopHandler:Landroid/os/Handler;

    new-instance v1, Ltv/freewheel/renderers/html/HTMLRenderer$7;

    invoke-direct {v1, p0}, Ltv/freewheel/renderers/html/HTMLRenderer$7;-><init>(Ltv/freewheel/renderers/html/HTMLRenderer;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 771
    return-void
.end method

.method public mraidLoadFail(ILjava/lang/String;)V
    .locals 2
    .param p1, "errorCode"    # I
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 894
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->mainLoopHandler:Landroid/os/Handler;

    new-instance v1, Ltv/freewheel/renderers/html/HTMLRenderer$14;

    invoke-direct {v1, p0, p1, p2}, Ltv/freewheel/renderers/html/HTMLRenderer$14;-><init>(Ltv/freewheel/renderers/html/HTMLRenderer;ILjava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 899
    return-void
.end method

.method public mraidLoaded()V
    .locals 2

    .prologue
    .line 748
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->mainLoopHandler:Landroid/os/Handler;

    new-instance v1, Ltv/freewheel/renderers/html/HTMLRenderer$5;

    invoke-direct {v1, p0}, Ltv/freewheel/renderers/html/HTMLRenderer$5;-><init>(Ltv/freewheel/renderers/html/HTMLRenderer;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 753
    return-void
.end method

.method public parameters()Ltv/freewheel/renderers/html/Parameters;
    .locals 1

    .prologue
    .line 902
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->parameters:Ltv/freewheel/renderers/html/Parameters;

    return-object v0
.end method

.method public playHeadTime(I)V
    .locals 1
    .param p1, "headTime"    # I

    .prologue
    .line 946
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->headTime:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 947
    return-void
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 5
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 906
    iget-object v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "shouldOverrideUrlLoading for url: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 908
    invoke-virtual {p1}, Landroid/webkit/WebView;->getHitTestResult()Landroid/webkit/WebView$HitTestResult;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {p1}, Landroid/webkit/WebView;->getHitTestResult()Landroid/webkit/WebView$HitTestResult;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebView$HitTestResult;->getType()I

    move-result v2

    if-lez v2, :cond_0

    iget-boolean v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isMRAIDAd:Z

    if-nez v2, :cond_0

    .line 912
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 913
    .local v0, "info":Landroid/os/Bundle;
    iget-object v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_URL()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 914
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 915
    .local v1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 916
    iget-object v2, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v3, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_CLICK()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 917
    const/4 v2, 0x1

    .line 921
    .end local v0    # "info":Landroid/os/Bundle;
    .end local v1    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public start()V
    .locals 3

    .prologue
    .line 641
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->CLASSTAG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "start"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    .line 642
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->mainLoopHandler:Landroid/os/Handler;

    new-instance v1, Ltv/freewheel/renderers/html/HTMLRenderer$3;

    invoke-direct {v1, p0}, Ltv/freewheel/renderers/html/HTMLRenderer$3;-><init>(Ltv/freewheel/renderers/html/HTMLRenderer;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 698
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererTimer:Ltv/freewheel/utils/renderer/RendererTimer;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->isMRAIDAd:Z

    if-nez v0, :cond_0

    .line 699
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->rendererTimer:Ltv/freewheel/utils/renderer/RendererTimer;

    invoke-virtual {v0}, Ltv/freewheel/utils/renderer/RendererTimer;->start()V

    .line 701
    :cond_0
    return-void
.end method

.method public stop()V
    .locals 3

    .prologue
    .line 729
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->CLASSTAG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " stop"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    .line 730
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->mainLoopHandler:Landroid/os/Handler;

    new-instance v1, Ltv/freewheel/renderers/html/HTMLRenderer$4;

    invoke-direct {v1, p0}, Ltv/freewheel/renderers/html/HTMLRenderer$4;-><init>(Ltv/freewheel/renderers/html/HTMLRenderer;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 738
    return-void
.end method

.method public synchStateToPresentation(Z)V
    .locals 2
    .param p1, "isResized"    # Z

    .prologue
    .line 444
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer;->mainLoopHandler:Landroid/os/Handler;

    new-instance v1, Ltv/freewheel/renderers/html/HTMLRenderer$1;

    invoke-direct {v1, p0, p1}, Ltv/freewheel/renderers/html/HTMLRenderer$1;-><init>(Ltv/freewheel/renderers/html/HTMLRenderer;Z)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 450
    return-void
.end method

.method public timeOut()V
    .locals 0

    .prologue
    .line 951
    invoke-virtual {p0}, Ltv/freewheel/renderers/html/HTMLRenderer;->stop()V

    .line 952
    return-void
.end method
