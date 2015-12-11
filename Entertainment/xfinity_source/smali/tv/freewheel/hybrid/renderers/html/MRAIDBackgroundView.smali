.class Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;
.super Landroid/widget/FrameLayout;
.source "MRAIDBackgroundView.java"


# instance fields
.field protected activity:Landroid/app/Activity;

.field private logger:Ltv/freewheel/hybrid/utils/Logger;

.field private superRootFrame:Landroid/view/ViewGroup;

.field private titleParentVisibility:I


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 4
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v3, 0x0

    .line 19
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 20
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v1

    iput-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 21
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->activity:Landroid/app/Activity;

    .line 22
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v2, "MRAIDBackgroundView"

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 23
    const/16 v1, 0xcc

    invoke-static {v1, v3, v3, v3}, Landroid/graphics/Color;->argb(IIII)I

    move-result v1

    invoke-virtual {p0, v1}, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->setBackgroundColor(I)V

    .line 24
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 25
    .local v0, "superRoot":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 26
    check-cast v0, Landroid/view/ViewGroup;

    .end local v0    # "superRoot":Landroid/view/View;
    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->superRootFrame:Landroid/view/ViewGroup;

    .line 30
    :goto_0
    return-void

    .line 28
    .restart local v0    # "superRoot":Landroid/view/View;
    :cond_0
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v2, "The DecorView of the activity window is not available, full screen is not supported!"

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method hideFullScreenBackground()V
    .locals 4

    .prologue
    .line 57
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->activity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    const v3, 0x1020016

    invoke-virtual {v2, v3}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 58
    .local v1, "title":Landroid/view/View;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 59
    invoke-virtual {v1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 60
    .local v0, "par":Landroid/view/ViewGroup;
    iget v2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->titleParentVisibility:I

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 63
    .end local v0    # "par":Landroid/view/ViewGroup;
    :cond_0
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->activity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    const/16 v3, 0x400

    invoke-virtual {v2, v3}, Landroid/view/Window;->clearFlags(I)V

    .line 64
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->activity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    const/16 v3, 0x800

    invoke-virtual {v2, v3}, Landroid/view/Window;->addFlags(I)V

    .line 65
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->superRootFrame:Landroid/view/ViewGroup;

    invoke-virtual {v2, p0}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 66
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 34
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onTouchEvent"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 35
    const/4 v0, 0x1

    return v0
.end method

.method showFullScreenBackground()V
    .locals 7

    .prologue
    const/16 v6, 0x400

    const/4 v5, -0x1

    .line 39
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v4, "showFullScreenBackground"

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 40
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->activity:Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v3

    iget v3, v3, Landroid/view/WindowManager$LayoutParams;->flags:I

    and-int/lit16 v3, v3, 0x400

    if-eq v3, v6, :cond_0

    .line 41
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->activity:Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/view/Window;->addFlags(I)V

    .line 43
    :cond_0
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->activity:Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v3

    const/16 v4, 0x800

    invoke-virtual {v3, v4}, Landroid/view/Window;->clearFlags(I)V

    .line 45
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->activity:Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v3

    const v4, 0x1020016

    invoke-virtual {v3, v4}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 46
    .local v2, "title":Landroid/view/View;
    if-eqz v2, :cond_1

    invoke-virtual {v2}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 47
    invoke-virtual {v2}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    .line 48
    .local v1, "par":Landroid/view/ViewGroup;
    invoke-virtual {v1}, Landroid/view/ViewGroup;->getVisibility()I

    move-result v3

    iput v3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->titleParentVisibility:I

    .line 49
    const/16 v3, 0x8

    invoke-virtual {v1, v3}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 51
    .end local v1    # "par":Landroid/view/ViewGroup;
    :cond_1
    new-instance v0, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v0, v5, v5}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    .line 53
    .local v0, "fllp":Landroid/view/ViewGroup$LayoutParams;
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDBackgroundView;->superRootFrame:Landroid/view/ViewGroup;

    invoke-virtual {v3, p0, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 54
    return-void
.end method
