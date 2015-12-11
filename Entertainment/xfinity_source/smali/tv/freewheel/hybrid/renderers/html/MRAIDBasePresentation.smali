.class abstract Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;
.super Ljava/lang/Object;
.source "MRAIDBasePresentation.java"

# interfaces
.implements Ltv/freewheel/hybrid/renderers/html/IMRAIDPresentation;


# instance fields
.field protected activity:Landroid/app/Activity;

.field protected bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

.field protected closeButton:Landroid/widget/ImageButton;

.field protected enableMRAID:Ljava/lang/Boolean;

.field protected fullScreenBaseView:Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;

.field private isCloseButtonVisible:Z

.field private logger:Ltv/freewheel/hybrid/utils/Logger;

.field private viewHolder:Landroid/widget/FrameLayout;

.field private viewOnFullScreen:Landroid/view/View;


# direct methods
.method constructor <init>(Landroid/app/Activity;Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;Z)V
    .locals 4
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "bridge"    # Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;
    .param p3, "enableMRAID"    # Z

    .prologue
    const/4 v3, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->enableMRAID:Ljava/lang/Boolean;

    .line 16
    iput-object v3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->fullScreenBaseView:Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;

    .line 33
    iput-boolean v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->isCloseButtonVisible:Z

    .line 34
    iput-object v3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->closeButton:Landroid/widget/ImageButton;

    .line 59
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 60
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->activity:Landroid/app/Activity;

    .line 61
    iput-object p2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    .line 62
    invoke-static {p3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->enableMRAID:Ljava/lang/Boolean;

    .line 63
    new-instance v0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;

    invoke-direct {v0, p1}, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;-><init>(Landroid/app/Activity;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->fullScreenBaseView:Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;

    .line 64
    new-instance v0, Landroid/widget/FrameLayout;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->fullScreenBaseView:Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->viewHolder:Landroid/widget/FrameLayout;

    .line 65
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

    .line 66
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->viewHolder:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v2}, Landroid/widget/FrameLayout;->setBackgroundColor(I)V

    .line 68
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->enableMRAID:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 69
    new-instance v0, Landroid/widget/ImageButton;

    invoke-direct {v0, p1}, Landroid/widget/ImageButton;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->closeButton:Landroid/widget/ImageButton;

    .line 70
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->closeButton:Landroid/widget/ImageButton;

    const v1, 0x108005a

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageResource(I)V

    .line 71
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v0, v2}, Landroid/widget/ImageButton;->setBackgroundColor(I)V

    .line 72
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v0, v2, v2, v2, v2}, Landroid/widget/ImageButton;->setPadding(IIII)V

    .line 74
    :cond_1
    return-void
.end method


# virtual methods
.method protected addView(Landroid/view/View;II)V
    .locals 9
    .param p1, "view"    # Landroid/view/View;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    const/16 v8, 0x32

    const/4 v4, -0x1

    .line 77
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v6, "addView"

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 78
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->fullScreenBaseView:Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;

    invoke-virtual {v5}, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->showFullScreenBackground()V

    .line 79
    const/4 v1, 0x0

    .line 80
    .local v1, "fl":Landroid/widget/FrameLayout$LayoutParams;
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->getFullScreenWidth()I

    move-result v5

    if-lt p2, v5, :cond_1

    move v3, v4

    .line 81
    .local v3, "w":I
    :goto_0
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->getFullScreenHeight()I

    move-result v5

    if-lt p3, v5, :cond_2

    move v2, v4

    .line 82
    .local v2, "h":I
    :goto_1
    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;

    .end local v1    # "fl":Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct {v1, v3, v2}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 83
    .restart local v1    # "fl":Landroid/widget/FrameLayout$LayoutParams;
    const/16 v5, 0x11

    iput v5, v1, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 84
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->fullScreenBaseView:Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;

    iget-object v6, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->viewHolder:Landroid/widget/FrameLayout;

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7, v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 85
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->viewHolder:Landroid/widget/FrameLayout;

    invoke-virtual {v5, p1, v4, v4}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;II)V

    .line 87
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->enableMRAID:Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 88
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->closeButton:Landroid/widget/ImageButton;

    new-instance v5, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation$1;

    invoke-direct {v5, p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation$1;-><init>(Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;)V

    invoke-virtual {v4, v5}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 93
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v0, v8, v8}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 94
    .local v0, "cbfl":Landroid/widget/FrameLayout$LayoutParams;
    const/16 v4, 0x35

    iput v4, v0, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 95
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->viewHolder:Landroid/widget/FrameLayout;

    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v4, v5, v0}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 97
    .end local v0    # "cbfl":Landroid/widget/FrameLayout$LayoutParams;
    :cond_0
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->viewHolder:Landroid/widget/FrameLayout;

    invoke-virtual {v4}, Landroid/widget/FrameLayout;->bringToFront()V

    .line 98
    invoke-virtual {p1}, Landroid/view/View;->requestFocus()Z

    .line 99
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->viewOnFullScreen:Landroid/view/View;

    .line 100
    return-void

    .end local v2    # "h":I
    .end local v3    # "w":I
    :cond_1
    move v3, p2

    .line 80
    goto :goto_0

    .restart local v3    # "w":I
    :cond_2
    move v2, p3

    .line 81
    goto :goto_1
.end method

.method protected addView(Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;)V
    .locals 2
    .param p1, "view"    # Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    .prologue
    .line 103
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->getFullScreenWidth()I

    move-result v0

    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->getFullScreenHeight()I

    move-result v1

    invoke-virtual {p0, p1, v0, v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->addView(Landroid/view/View;II)V

    .line 104
    return-void
.end method

.method protected getFullScreenHeight()I
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    return v0
.end method

.method protected getFullScreenWidth()I
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    return v0
.end method

.method protected removeView()V
    .locals 2

    .prologue
    .line 107
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "removeView"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 108
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->fullScreenBaseView:Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->hideFullScreenBackground()V

    .line 109
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->fullScreenBaseView:Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->viewHolder:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->removeView(Landroid/view/View;)V

    .line 110
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->enableMRAID:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 111
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->closeButton:Landroid/widget/ImageButton;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 112
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->viewHolder:Landroid/widget/FrameLayout;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 114
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->viewHolder:Landroid/widget/FrameLayout;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->viewOnFullScreen:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 115
    return-void
.end method

.method public resize(IIIILjava/lang/String;Z)V
    .locals 3
    .param p1, "offsetX"    # I
    .param p2, "offsetY"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I
    .param p5, "customClosePosition"    # Ljava/lang/String;
    .param p6, "allowOffscreen"    # Z

    .prologue
    .line 129
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->bridge:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    const-string v1, "Not supported"

    const-string v2, "resize"

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->dispatchMraidError(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    return-void
.end method

.method public setCloseButtonVisibility(Z)V
    .locals 3
    .param p1, "isVisible"    # Z

    .prologue
    .line 39
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "setCloseButtonVisibility("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    .line 40
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->enableMRAID:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 41
    iget-boolean v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->isCloseButtonVisible:Z

    if-eq v0, p1, :cond_1

    .line 42
    iput-boolean p1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->isCloseButtonVisible:Z

    .line 43
    iget-boolean v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->isCloseButtonVisible:Z

    if-eqz v0, :cond_0

    .line 44
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->closeButton:Landroid/widget/ImageButton;

    const/16 v1, 0xff

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setAlpha(I)V

    .line 45
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v0}, Landroid/widget/ImageButton;->invalidate()V

    .line 56
    :goto_0
    return-void

    .line 47
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->closeButton:Landroid/widget/ImageButton;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setAlpha(I)V

    .line 48
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->closeButton:Landroid/widget/ImageButton;

    invoke-virtual {v0}, Landroid/widget/ImageButton;->invalidate()V

    goto :goto_0

    .line 51
    :cond_1
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "The closeButtonVisibility is the same as the value set by outside, ignored."

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 54
    :cond_2
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "setCloseButtonVisibility doesn\'t work when MRAID disabled."

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected setEnableSync(Landroid/view/View;Z)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "isResized"    # Z

    .prologue
    .line 133
    invoke-virtual {p1}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    new-instance v1, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation$2;

    invoke-direct {v1, p0, p1, p2}, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation$2;-><init>(Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;Landroid/view/View;Z)V

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 140
    return-void
.end method

.method public supportsInlineVideo()Z
    .locals 2

    .prologue
    .line 119
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/html/MRAIDBasePresentation;->getCurrentView()Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;

    move-result-object v0

    .line 120
    .local v0, "currentView":Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;
    if-nez v0, :cond_0

    .line 121
    const/4 v1, 0x0

    .line 124
    :goto_0
    return v1

    :cond_0
    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/html/MRAIDWebView;->supportsInlineVideo()Z

    move-result v1

    goto :goto_0
.end method
