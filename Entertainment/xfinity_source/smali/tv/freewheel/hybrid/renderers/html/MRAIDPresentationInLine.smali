.class Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;
.super Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;
.source "MRAIDPresentationInLine.java"


# static fields
.field private static OVERLAY_SLOT_HEIGHT:I

.field private static OVERLAY_SLOT_WIDTH:I

.field private static gravityMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private alphaHolder:Landroid/widget/FrameLayout;

.field private alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

.field private appView:Landroid/view/View;

.field private betaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

.field private creativeRendition:Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

.field private defaultLocation:[I

.field private expandedURL:Ljava/lang/String;

.field private expandedViewRef:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

.field private height:I

.field private logger:Ltv/freewheel/hybrid/utils/Logger;

.field private rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

.field private resizeBaseView:Landroid/widget/FrameLayout;

.field private resizeHelperView:Landroid/widget/FrameLayout;

.field private slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

.field private width:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 25
    const/16 v0, 0xf0

    sput v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->OVERLAY_SLOT_WIDTH:I

    .line 26
    const/16 v0, 0x32

    sput v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->OVERLAY_SLOT_HEIGHT:I

    .line 46
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->gravityMap:Ljava/util/Map;

    .line 49
    sget-object v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->gravityMap:Ljava/util/Map;

    const-string v1, "top-left"

    const/16 v2, 0x33

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    sget-object v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->gravityMap:Ljava/util/Map;

    const-string v1, "top-right"

    const/16 v2, 0x35

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    sget-object v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->gravityMap:Ljava/util/Map;

    const-string v1, "center"

    const/16 v2, 0x11

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    sget-object v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->gravityMap:Ljava/util/Map;

    const-string v1, "bottom-left"

    const/16 v2, 0x53

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    sget-object v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->gravityMap:Ljava/util/Map;

    const-string v1, "bottom-right"

    const/16 v2, 0x55

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    sget-object v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->gravityMap:Ljava/util/Map;

    const-string v1, "top-center"

    const/16 v2, 0x31

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 55
    sget-object v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->gravityMap:Ljava/util/Map;

    const-string v1, "bottom-center"

    const/16 v2, 0x51

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 56
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;Ljava/lang/Boolean;)V
    .locals 5
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "bridge"    # Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;
    .param p3, "rendererContext"    # Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;
    .param p4, "enableMRAID"    # Ljava/lang/Boolean;

    .prologue
    const/16 v4, 0xa

    const/4 v3, 0x0

    .line 62
    invoke-virtual {p4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-direct {p0, p1, p2, v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;-><init>(Landroid/app/Activity;Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;Z)V

    .line 63
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 64
    iput-object p3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    .line 65
    invoke-interface {p3}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v0

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 66
    invoke-interface {p3}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getAdInstance()Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v0

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->creativeRendition:Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    .line 67
    new-instance v0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    const/4 v1, 0x1

    invoke-virtual {p4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-direct {v0, p1, p2, v1, v2}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;-><init>(Landroid/app/Activity;Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;ZZ)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    .line 68
    new-instance v0, Landroid/widget/FrameLayout;

    invoke-direct {v0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    .line 69
    invoke-virtual {p2}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->parameters()Ltv/freewheel/hybrid/renderers/html/Parameters;

    move-result-object v0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/html/Parameters;->shouldBackgroundTransparent:Ljava/lang/Boolean;

    if-eqz v0, :cond_0

    invoke-virtual {p2}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->parameters()Ltv/freewheel/hybrid/renderers/html/Parameters;

    move-result-object v0

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/html/Parameters;->shouldBackgroundTransparent:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 70
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v3}, Landroid/widget/FrameLayout;->setBackgroundColor(I)V

    .line 72
    :cond_0
    new-instance v0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {p4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-direct {v0, p1, p2, v3, v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;-><init>(Landroid/app/Activity;Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;ZZ)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->betaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    .line 74
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->calculateAdSize()V

    .line 75
    const/4 v0, 0x2

    new-array v0, v0, [I

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->defaultLocation:[I

    .line 76
    new-instance v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine$1;

    invoke-direct {v0, p0, p1}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine$1;-><init>(Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;Landroid/content/Context;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeHelperView:Landroid/widget/FrameLayout;

    .line 82
    new-instance v0, Landroid/widget/FrameLayout;

    invoke-direct {v0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeBaseView:Landroid/widget/FrameLayout;

    .line 83
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeHelperView:Landroid/widget/FrameLayout;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeBaseView:Landroid/widget/FrameLayout;

    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v2, v4, v4}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1, v2}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 84
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const v1, 0x1020002

    invoke-virtual {v0, v1}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    .line 85
    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;)Landroid/widget/FrameLayout;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;

    .prologue
    .line 23
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    return-object v0
.end method

.method static synthetic access$100(Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;)Ltv/freewheel/hybrid/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;

    .prologue
    .line 23
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    return-object v0
.end method

.method private calculateAdSize()V
    .locals 5

    .prologue
    const/4 v2, -0x1

    .line 88
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "calculateAdSize, slot width: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getWidth()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", rendition width:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->creativeRendition:Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getWidth()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 89
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getType()I

    move-result v1

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v3}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v3

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->SLOT_TYPE_TEMPORAL()I

    move-result v3

    if-ne v1, v3, :cond_6

    .line 90
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v1

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v3}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v3

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_OVERLAY()I

    move-result v3

    if-ne v1, v3, :cond_1

    .line 91
    sget v1, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->OVERLAY_SLOT_WIDTH:I

    iput v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    .line 92
    sget v1, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->OVERLAY_SLOT_HEIGHT:I

    iput v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    .line 97
    :goto_0
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->creativeRendition:Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getWidth()I

    move-result v1

    if-lez v1, :cond_4

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->creativeRendition:Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getWidth()I

    move-result v1

    :goto_1
    iput v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    .line 98
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->creativeRendition:Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getHeight()I

    move-result v1

    if-lez v1, :cond_5

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->creativeRendition:Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getHeight()I

    move-result v1

    :goto_2
    iput v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    .line 117
    :cond_0
    :goto_3
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "ad width = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " height = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 118
    return-void

    .line 94
    :cond_1
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getWidth()I

    move-result v1

    if-lez v1, :cond_3

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getWidth()I

    move-result v1

    :goto_4
    iput v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    .line 95
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getHeight()I

    move-result v1

    if-lez v1, :cond_2

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getHeight()I

    move-result v2

    :cond_2
    iput v2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    goto :goto_0

    :cond_3
    move v1, v2

    .line 94
    goto :goto_4

    .line 97
    :cond_4
    iget v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    goto :goto_1

    .line 98
    :cond_5
    iget v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    goto :goto_2

    .line 100
    :cond_6
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getWidth()I

    move-result v1

    iput v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    .line 101
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getHeight()I

    move-result v1

    iput v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    .line 102
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->parameters()Ltv/freewheel/hybrid/renderers/html/Parameters;

    move-result-object v1

    iget-object v1, v1, Ltv/freewheel/hybrid/renderers/html/Parameters;->shouldUseDip:Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 103
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 104
    .local v0, "dm":Landroid/util/DisplayMetrics;
    iget v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    int-to-float v1, v1

    iget v2, v0, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v1, v2

    float-to-int v1, v1

    iput v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    .line 105
    iget v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    int-to-float v1, v1

    iget v2, v0, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v1, v2

    float-to-int v1, v1

    iput v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    .line 107
    iget v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    iget v2, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    if-le v1, v2, :cond_7

    .line 108
    iget v1, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    mul-int/2addr v1, v2

    int-to-float v1, v1

    iget v2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    float-to-int v1, v1

    iput v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    .line 109
    iget v1, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iput v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    .line 111
    :cond_7
    iget v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    iget v2, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    if-le v1, v2, :cond_0

    .line 112
    iget v1, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    iget v2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    mul-int/2addr v1, v2

    int-to-float v1, v1

    iget v2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    float-to-int v1, v1

    iput v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    .line 113
    iget v1, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    iput v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    goto/16 :goto_3
.end method


# virtual methods
.method public close()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v2, -0x1

    const/4 v4, 0x0

    .line 274
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "close"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 275
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->expandedViewRef:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    if-eqz v0, :cond_0

    .line 276
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "close expanded ad view"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 277
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->betaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->closeCustomView()V

    .line 278
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->removeView()V

    .line 279
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->show()V

    .line 280
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->betaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->dispose()V

    .line 281
    new-instance v0, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->activity:Landroid/app/Activity;

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->enableMRAID:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    invoke-direct {v0, v1, v2, v5, v3}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;-><init>(Landroid/app/Activity;Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;ZZ)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->betaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    .line 282
    iput-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->expandedViewRef:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    .line 299
    :goto_0
    return-void

    .line 283
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeBaseView:Landroid/widget/FrameLayout;

    if-ne v0, v1, :cond_1

    .line 284
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "close resized ad view"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 285
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v0, v4}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 286
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeBaseView:Landroid/widget/FrameLayout;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 287
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeBaseView:Landroid/widget/FrameLayout;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 288
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeHelperView:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 289
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {p0, v0, v5}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->setEnableSync(Landroid/view/View;Z)V

    .line 290
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, v1, v2, v2}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;II)V

    goto :goto_0

    .line 292
    :cond_1
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "close inline ad view"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 293
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v1

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_OVERLAY()I

    move-result v1

    if-ne v0, v1, :cond_2

    .line 294
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/ViewGroup;->setOnHierarchyChangeListener(Landroid/view/ViewGroup$OnHierarchyChangeListener;)V

    .line 295
    :cond_2
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->closeCustomView()V

    .line 296
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 297
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public collapse()V
    .locals 2

    .prologue
    .line 260
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "collapse"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 261
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->expandedURL:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 262
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->closeCustomView()V

    .line 263
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->removeView()V

    .line 264
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->setFullScreen(Z)V

    .line 265
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->show()V

    .line 266
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->expandedViewRef:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    .line 270
    :goto_0
    return-void

    .line 268
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "The collapse shouldn\'t be called."

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public dispose()V
    .locals 1

    .prologue
    .line 340
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->dispose()V

    .line 341
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->betaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->dispose()V

    .line 342
    return-void
.end method

.method public expand(Ljava/lang/String;II)V
    .locals 5
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 231
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "expand(url:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ",w="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ",h="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 232
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->expandedURL:Ljava/lang/String;

    .line 233
    if-nez p1, :cond_2

    .line 234
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, v3}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->setFullScreen(Z)V

    .line 235
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->expandedViewRef:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    .line 242
    :goto_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v1

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_OVERLAY()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 243
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/ViewGroup;->setOnHierarchyChangeListener(Landroid/view/ViewGroup$OnHierarchyChangeListener;)V

    .line 244
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->closeCustomView()V

    .line 245
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    if-ne v0, v1, :cond_3

    .line 246
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 253
    :cond_1
    :goto_1
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 254
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->expandedViewRef:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->setEnableSync(Landroid/view/View;Z)V

    .line 255
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->expandedViewRef:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-super {p0, v0, p2, p3}, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->addView(Landroid/view/View;II)V

    .line 256
    return-void

    .line 237
    :cond_2
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->betaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    const-string v1, "mraid.state=\'expanded\';"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->runJavaScript(Ljava/lang/String;)V

    .line 238
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->betaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, v3}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->setFullScreen(Z)V

    .line 239
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->betaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->loadUrl(Ljava/lang/String;)V

    .line 240
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->betaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->expandedViewRef:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    goto :goto_0

    .line 247
    :cond_3
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeBaseView:Landroid/widget/FrameLayout;

    if-ne v0, v1, :cond_1

    .line 248
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v0, v4}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 249
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeBaseView:Landroid/widget/FrameLayout;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 250
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeBaseView:Landroid/widget/FrameLayout;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 251
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeHelperView:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_1
.end method

.method public getAbsoluteURL(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 308
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->expandedViewRef:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    if-eqz v0, :cond_0

    .line 309
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->expandedViewRef:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->URLWithBaseURL(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 311
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->URLWithBaseURL(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getCurrentView()Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;
    .locals 1

    .prologue
    .line 316
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->expandedViewRef:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    if-eqz v0, :cond_0

    .line 317
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->expandedViewRef:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    .line 324
    :goto_0
    return-object v0

    .line 320
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    if-eqz v0, :cond_1

    .line 321
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    goto :goto_0

    .line 324
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getDefaultPositionOnScreen([I)V
    .locals 4
    .param p1, "location"    # [I

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 329
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->getWindowVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-eq v0, v1, :cond_0

    .line 330
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->defaultLocation:[I

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->getLocationOnScreen([I)V

    .line 332
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->defaultLocation:[I

    aget v0, v0, v2

    aput v0, p1, v2

    .line 333
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->defaultLocation:[I

    aget v0, v0, v3

    aput v0, p1, v3

    .line 334
    const/4 v0, 0x2

    iget v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    aput v1, p1, v0

    .line 335
    const/4 v0, 0x3

    iget v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    aput v1, p1, v0

    .line 336
    return-void
.end method

.method public loadContent(Ljava/lang/String;)V
    .locals 6
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 128
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "loadContent: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    .line 129
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    const-string v4, "UTF-8"

    move-object v2, p1

    move-object v3, v1

    move-object v5, v1

    invoke-virtual/range {v0 .. v5}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    return-void
.end method

.method public loadURL(Ljava/lang/String;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 122
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "loadURL("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    .line 123
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->loadUrl(Ljava/lang/String;)V

    .line 124
    return-void
.end method

.method public refresh()V
    .locals 3

    .prologue
    .line 134
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v2, "refresh"

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 135
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 136
    .local v0, "handler":Landroid/os/Handler;
    new-instance v1, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine$2;

    invoke-direct {v1, p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine$2;-><init>(Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 141
    return-void
.end method

.method public resize(IIIILjava/lang/String;Z)V
    .locals 17
    .param p1, "requestedOffsetX"    # I
    .param p2, "requestedOffsetY"    # I
    .param p3, "requestedWidth"    # I
    .param p4, "requestedHeight"    # I
    .param p5, "customClosePosition"    # Ljava/lang/String;
    .param p6, "allowOffscreen"    # Z

    .prologue
    .line 346
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v12}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->getParent()Landroid/view/ViewParent;

    move-result-object v9

    check-cast v9, Landroid/view/ViewGroup;

    .line 347
    .local v9, "parent":Landroid/view/ViewGroup;
    if-eqz v9, :cond_0

    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    invoke-virtual {v12}, Landroid/widget/FrameLayout;->getWindowVisibility()I

    move-result v12

    const/16 v13, 0x8

    if-ne v12, v13, :cond_1

    .line 348
    :cond_0
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    const-string v13, "Resize called at incorrect state"

    const-string v14, "resize"

    invoke-virtual {v12, v13, v14}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->dispatchMraidError(Ljava/lang/String;Ljava/lang/String;)V

    .line 431
    :goto_0
    return-void

    .line 352
    :cond_1
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    if-eqz v12, :cond_2

    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    instance-of v12, v12, Landroid/view/ViewGroup;

    if-nez v12, :cond_3

    .line 353
    :cond_2
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    const-string v13, "Could not attach view to app root view"

    const-string v14, "resize"

    invoke-virtual {v12, v13, v14}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->dispatchMraidError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 357
    :cond_3
    if-nez p6, :cond_5

    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    invoke-virtual {v12}, Landroid/view/View;->getWidth()I

    move-result v12

    move/from16 v0, p3

    if-gt v0, v12, :cond_4

    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    invoke-virtual {v12}, Landroid/view/View;->getHeight()I

    move-result v12

    move/from16 v0, p4

    if-le v0, v12, :cond_5

    .line 358
    :cond_4
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    const-string v13, "Resize parameter out of range"

    const-string v14, "resize"

    invoke-virtual {v12, v13, v14}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->dispatchMraidError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 362
    :cond_5
    const/4 v12, 0x2

    new-array v2, v12, [I

    .line 363
    .local v2, "appLocation":[I
    const/4 v12, 0x2

    new-array v6, v12, [I

    .line 364
    .local v6, "defaultLocation":[I
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    invoke-virtual {v12, v2}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 365
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    invoke-virtual {v12, v6}, Landroid/widget/FrameLayout;->getLocationOnScreen([I)V

    .line 367
    const/4 v12, 0x0

    aget v12, v6, v12

    const/4 v13, 0x0

    aget v13, v2, v13

    sub-int/2addr v12, v13

    add-int v10, v12, p1

    .line 368
    .local v10, "x":I
    const/4 v12, 0x1

    aget v12, v6, v12

    const/4 v13, 0x1

    aget v13, v2, v13

    sub-int/2addr v12, v13

    add-int v11, v12, p2

    .line 370
    .local v11, "y":I
    if-nez p6, :cond_d

    .line 371
    if-gez v10, :cond_b

    .line 372
    const/4 v10, 0x0

    .line 377
    :cond_6
    :goto_1
    if-gez v11, :cond_c

    .line 378
    const/4 v11, 0x0

    .line 399
    :cond_7
    :goto_2
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v9, v12}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 401
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeHelperView:Landroid/widget/FrameLayout;

    invoke-virtual {v12}, Landroid/widget/FrameLayout;->getParent()Landroid/view/ViewParent;

    move-result-object v12

    if-nez v12, :cond_8

    .line 402
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    check-cast v12, Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    iget-object v13, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeHelperView:Landroid/widget/FrameLayout;

    new-instance v14, Landroid/view/ViewGroup$LayoutParams;

    const/4 v15, -0x1

    const/16 v16, -0x1

    invoke-direct/range {v14 .. v16}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v12, v13, v14}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 405
    :cond_8
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "Resize to: ("

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, ","

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "), size ("

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    move/from16 v0, p3

    invoke-virtual {v13, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "x"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    move/from16 v0, p4

    invoke-virtual {v13, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, ") pixels"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 406
    new-instance v8, Landroid/widget/FrameLayout$LayoutParams;

    move/from16 v0, p3

    move/from16 v1, p4

    invoke-direct {v8, v0, v1}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 407
    .local v8, "lp":Landroid/widget/FrameLayout$LayoutParams;
    iput v10, v8, Landroid/widget/FrameLayout$LayoutParams;->leftMargin:I

    .line 408
    iput v11, v8, Landroid/widget/FrameLayout$LayoutParams;->topMargin:I

    .line 409
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeBaseView:Landroid/widget/FrameLayout;

    invoke-virtual {v12, v8}, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 411
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    const/4 v13, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v12, v13}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->setEnableSync(Landroid/view/View;Z)V

    .line 412
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeBaseView:Landroid/widget/FrameLayout;

    move-object/from16 v0, p0

    iget-object v13, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    new-instance v14, Landroid/widget/FrameLayout$LayoutParams;

    const/4 v15, -0x1

    const/16 v16, -0x1

    invoke-direct/range {v14 .. v16}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v12, v13, v14}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 414
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v12}, Landroid/widget/ImageButton;->getParent()Landroid/view/ViewParent;

    move-result-object v12

    if-eqz v12, :cond_9

    .line 415
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v12}, Landroid/widget/ImageButton;->getParent()Landroid/view/ViewParent;

    move-result-object v12

    check-cast v12, Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    iget-object v13, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v12, v13}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 417
    :cond_9
    const/4 v12, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->setCloseButtonVisibility(Z)V

    .line 418
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->closeButton:Landroid/widget/ImageButton;

    new-instance v13, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine$4;

    move-object/from16 v0, p0

    invoke-direct {v13, v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine$4;-><init>(Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;)V

    invoke-virtual {v12, v13}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 423
    new-instance v3, Landroid/widget/FrameLayout$LayoutParams;

    const/16 v12, 0x32

    const/16 v13, 0x32

    invoke-direct {v3, v12, v13}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 424
    .local v3, "cbfl":Landroid/widget/FrameLayout$LayoutParams;
    sget-object v12, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->gravityMap:Ljava/util/Map;

    move-object/from16 v0, p5

    invoke-interface {v12, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Integer;

    .line 425
    .local v7, "gravity":Ljava/lang/Integer;
    if-nez v7, :cond_a

    .line 426
    const/16 v12, 0x35

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    .line 428
    :cond_a
    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v12

    iput v12, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 429
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeBaseView:Landroid/widget/FrameLayout;

    move-object/from16 v0, p0

    iget-object v13, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v12, v13, v3}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 430
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->resizeHelperView:Landroid/widget/FrameLayout;

    invoke-virtual {v12}, Landroid/widget/FrameLayout;->bringToFront()V

    goto/16 :goto_0

    .line 373
    .end local v3    # "cbfl":Landroid/widget/FrameLayout$LayoutParams;
    .end local v7    # "gravity":Ljava/lang/Integer;
    .end local v8    # "lp":Landroid/widget/FrameLayout$LayoutParams;
    :cond_b
    add-int v12, v10, p3

    move-object/from16 v0, p0

    iget-object v13, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    invoke-virtual {v13}, Landroid/view/View;->getWidth()I

    move-result v13

    if-le v12, v13, :cond_6

    .line 374
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    invoke-virtual {v12}, Landroid/view/View;->getWidth()I

    move-result v12

    sub-int v10, v12, p3

    goto/16 :goto_1

    .line 379
    :cond_c
    add-int v12, v11, p4

    move-object/from16 v0, p0

    iget-object v13, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    invoke-virtual {v13}, Landroid/view/View;->getHeight()I

    move-result v13

    if-le v12, v13, :cond_7

    .line 380
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    invoke-virtual {v12}, Landroid/view/View;->getHeight()I

    move-result v12

    sub-int v11, v12, p4

    goto/16 :goto_2

    .line 384
    :cond_d
    div-int/lit8 v12, p3, 0x2

    add-int v4, v10, v12

    .line 385
    .local v4, "centerX":I
    div-int/lit8 v12, p4, 0x2

    add-int v5, v10, v12

    .line 387
    .local v5, "centerY":I
    const-string v12, "center"

    move-object/from16 v0, p5

    invoke-virtual {v0, v12}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_e

    const/16 v12, 0x19

    if-lt v5, v12, :cond_13

    add-int/lit8 v12, v5, 0x19

    move-object/from16 v0, p0

    iget-object v13, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    invoke-virtual {v13}, Landroid/view/View;->getHeight()I

    move-result v13

    if-gt v12, v13, :cond_13

    :cond_e
    const-string v12, "top"

    move-object/from16 v0, p5

    invoke-virtual {v0, v12}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_f

    if-ltz v11, :cond_13

    :cond_f
    const-string v12, "bottom"

    move-object/from16 v0, p5

    invoke-virtual {v0, v12}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_10

    add-int v12, v11, p4

    move-object/from16 v0, p0

    iget-object v13, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    invoke-virtual {v13}, Landroid/view/View;->getHeight()I

    move-result v13

    if-gt v12, v13, :cond_13

    :cond_10
    const-string v12, "center"

    move-object/from16 v0, p5

    invoke-virtual {v0, v12}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_11

    const/16 v12, 0x19

    if-lt v4, v12, :cond_13

    add-int/lit8 v12, v4, 0x19

    move-object/from16 v0, p0

    iget-object v13, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    invoke-virtual {v13}, Landroid/view/View;->getWidth()I

    move-result v13

    if-gt v12, v13, :cond_13

    :cond_11
    const-string v12, "left"

    move-object/from16 v0, p5

    invoke-virtual {v0, v12}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_12

    if-ltz v10, :cond_13

    :cond_12
    const-string v12, "right"

    move-object/from16 v0, p5

    invoke-virtual {v0, v12}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_7

    add-int v12, v10, p3

    move-object/from16 v0, p0

    iget-object v13, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->appView:Landroid/view/View;

    invoke-virtual {v13}, Landroid/view/View;->getWidth()I

    move-result v13

    if-le v12, v13, :cond_7

    .line 394
    :cond_13
    move-object/from16 v0, p0

    iget-object v12, v0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    const-string v13, "Close region out of screen"

    const-string v14, "resize"

    invoke-virtual {v12, v13, v14}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->dispatchMraidError(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method public runJavaScript(Ljava/lang/String;)V
    .locals 1
    .param p1, "script"    # Ljava/lang/String;

    .prologue
    .line 303
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->runJavaScript(Ljava/lang/String;)V

    .line 304
    return-void
.end method

.method public show()V
    .locals 11

    .prologue
    const/16 v10, 0x11

    const/4 v9, 0x0

    const/4 v8, -0x1

    const/4 v6, -0x2

    .line 145
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v7, "show"

    invoke-virtual {v5, v7}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 146
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaView:Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    invoke-virtual {v5, v7, v8, v8}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;II)V

    .line 148
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v5}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getType()I

    move-result v5

    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v7}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v7

    invoke-interface {v7}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->SLOT_TYPE_TEMPORAL()I

    move-result v7

    if-ne v5, v7, :cond_a

    .line 149
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v5}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v5

    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v6}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v6

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_OVERLAY()I

    move-result v6

    if-ne v5, v6, :cond_9

    .line 150
    new-instance v3, Landroid/widget/FrameLayout$LayoutParams;

    iget v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    iget v6, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    invoke-direct {v3, v5, v6}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 151
    .local v3, "p":Landroid/widget/FrameLayout$LayoutParams;
    iput v9, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 153
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    invoke-virtual {v5}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->parameters()Ltv/freewheel/hybrid/renderers/html/Parameters;

    move-result-object v5

    iget-object v0, v5, Ltv/freewheel/hybrid/renderers/html/Parameters;->primaryAnchor:Ljava/lang/String;

    .line 154
    .local v0, "ar":Ljava/lang/String;
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    invoke-virtual {v5}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->parameters()Ltv/freewheel/hybrid/renderers/html/Parameters;

    move-result-object v5

    iget-object v2, v5, Ltv/freewheel/hybrid/renderers/html/Parameters;->marginWidth:Ljava/lang/Integer;

    .line 155
    .local v2, "mw":Ljava/lang/Integer;
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    invoke-virtual {v5}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->parameters()Ltv/freewheel/hybrid/renderers/html/Parameters;

    move-result-object v5

    iget-object v1, v5, Ltv/freewheel/hybrid/renderers/html/Parameters;->marginHeight:Ljava/lang/Integer;

    .line 157
    .local v1, "mh":Ljava/lang/Integer;
    if-nez v0, :cond_0

    .line 158
    const-string v0, "bc"

    .line 160
    :cond_0
    const-string v5, "t"

    invoke-virtual {v0, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 161
    iget v5, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    or-int/lit8 v5, v5, 0x30

    iput v5, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 162
    if-eqz v1, :cond_1

    .line 163
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v5

    iput v5, v3, Landroid/widget/FrameLayout$LayoutParams;->topMargin:I

    .line 166
    :cond_1
    const-string v5, "l"

    invoke-virtual {v0, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 167
    iget v5, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    or-int/lit8 v5, v5, 0x3

    iput v5, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 168
    if-eqz v2, :cond_2

    .line 169
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v5

    iput v5, v3, Landroid/widget/FrameLayout$LayoutParams;->leftMargin:I

    .line 172
    :cond_2
    const-string v5, "r"

    invoke-virtual {v0, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 173
    iget v5, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    or-int/lit8 v5, v5, 0x5

    iput v5, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 174
    if-eqz v2, :cond_3

    .line 175
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v5

    iput v5, v3, Landroid/widget/FrameLayout$LayoutParams;->rightMargin:I

    .line 178
    :cond_3
    const-string v5, "b"

    invoke-virtual {v0, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 179
    iget v5, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    or-int/lit8 v5, v5, 0x50

    iput v5, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 180
    if-eqz v1, :cond_4

    .line 181
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v5

    iput v5, v3, Landroid/widget/FrameLayout$LayoutParams;->bottomMargin:I

    .line 184
    :cond_4
    const-string v5, "c"

    invoke-virtual {v0, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 185
    iget v5, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    or-int/lit8 v5, v5, 0x1

    iput v5, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 187
    :cond_5
    const-string v5, "m"

    invoke-virtual {v0, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 188
    iget v5, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    or-int/lit8 v5, v5, 0x10

    iput v5, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 190
    :cond_6
    const-string v5, "c"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_7

    const-string v5, "m"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_7

    const-string v5, "cm"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_7

    const-string v5, "mc"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 191
    :cond_7
    iput v10, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 194
    :cond_8
    move-object v4, v3

    .line 196
    .local v4, "pFinalRef":Landroid/view/ViewGroup$LayoutParams;
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "show, overlay layout width: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget v7, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ", height: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget v7, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " ar:"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ", marginWidth: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ", marginHeight: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 198
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v5}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v5

    new-instance v6, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine$3;

    invoke-direct {v6, p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine$3;-><init>(Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;)V

    invoke-virtual {v5, v6}, Landroid/view/ViewGroup;->setOnHierarchyChangeListener(Landroid/view/ViewGroup$OnHierarchyChangeListener;)V

    .line 224
    .end local v0    # "ar":Ljava/lang/String;
    .end local v1    # "mh":Ljava/lang/Integer;
    .end local v2    # "mw":Ljava/lang/Integer;
    .end local v3    # "p":Landroid/widget/FrameLayout$LayoutParams;
    :goto_0
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    invoke-virtual {p0, v5, v9}, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->setEnableSync(Landroid/view/View;Z)V

    .line 225
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->slot:Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    invoke-interface {v5}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v5

    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    invoke-virtual {v5, v6, v4}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 226
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;

    invoke-virtual {v5}, Landroid/widget/FrameLayout;->bringToFront()V

    .line 227
    return-void

    .line 214
    .end local v4    # "pFinalRef":Landroid/view/ViewGroup$LayoutParams;
    :cond_9
    new-instance v3, Landroid/widget/FrameLayout$LayoutParams;

    iget v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    iget v6, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    invoke-direct {v3, v5, v6}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 215
    .restart local v3    # "p":Landroid/widget/FrameLayout$LayoutParams;
    iput v10, v3, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 216
    move-object v4, v3

    .line 217
    .restart local v4    # "pFinalRef":Landroid/view/ViewGroup$LayoutParams;
    goto :goto_0

    .line 219
    .end local v3    # "p":Landroid/widget/FrameLayout$LayoutParams;
    .end local v4    # "pFinalRef":Landroid/view/ViewGroup$LayoutParams;
    :cond_a
    new-instance v3, Landroid/widget/RelativeLayout$LayoutParams;

    iget v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    if-lez v5, :cond_c

    iget v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->width:I

    :goto_1
    iget v7, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    if-lez v7, :cond_b

    iget v6, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;->height:I

    :cond_b
    invoke-direct {v3, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 221
    .local v3, "p":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v5, 0xd

    invoke-virtual {v3, v5}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 222
    move-object v4, v3

    .restart local v4    # "pFinalRef":Landroid/view/ViewGroup$LayoutParams;
    goto :goto_0

    .end local v3    # "p":Landroid/widget/RelativeLayout$LayoutParams;
    .end local v4    # "pFinalRef":Landroid/view/ViewGroup$LayoutParams;
    :cond_c
    move v5, v6

    .line 219
    goto :goto_1
.end method
