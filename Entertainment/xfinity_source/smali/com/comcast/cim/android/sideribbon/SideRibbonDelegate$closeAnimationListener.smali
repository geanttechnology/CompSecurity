.class Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;
.super Ljava/lang/Object;
.source "SideRibbonDelegate.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "closeAnimationListener"
.end annotation


# instance fields
.field private slideClosedListener:Lcom/comcast/cim/android/sideribbon/SlideClosedListener;

.field final synthetic this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Lcom/comcast/cim/android/sideribbon/SlideClosedListener;)V
    .locals 0
    .param p2, "slideClosedListener"    # Lcom/comcast/cim/android/sideribbon/SlideClosedListener;

    .prologue
    .line 345
    iput-object p1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 346
    iput-object p2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->slideClosedListener:Lcom/comcast/cim/android/sideribbon/SlideClosedListener;

    .line 347
    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 5
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    const/4 v4, 0x0

    .line 361
    iget-object v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->touchyContentContainer:Landroid/view/ViewGroup;
    invoke-static {v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$600(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/ViewGroup;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 362
    .local v0, "mlp":Landroid/view/ViewGroup$MarginLayoutParams;
    invoke-virtual {v0, v4, v4, v4, v4}, Landroid/view/ViewGroup$MarginLayoutParams;->setMargins(IIII)V

    .line 363
    iget-object v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->touchyContentContainer:Landroid/view/ViewGroup;
    invoke-static {v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$600(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;

    move-result-object v3

    invoke-virtual {v3, v0}, Landroid/view/ViewGroup;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 365
    iget-object v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;
    invoke-static {v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$800(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    .line 366
    .local v1, "shadowWidth":I
    iget-object v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;
    invoke-static {v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$800(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 367
    .local v2, "smlp":Landroid/view/ViewGroup$MarginLayoutParams;
    neg-int v3, v1

    invoke-virtual {v2, v3, v4, v4, v4}, Landroid/view/ViewGroup$MarginLayoutParams;->setMargins(IIII)V

    .line 368
    iget-object v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;
    invoke-static {v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$800(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 370
    iget-object v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;
    invoke-static {v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$400(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;

    move-result-object v3

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 371
    iget-object v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    sget-object v4, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->CLOSED:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    # invokes: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->updateState(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;)V
    invoke-static {v3, v4}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$500(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;)V

    .line 373
    iget-object v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->slideClosedListener:Lcom/comcast/cim/android/sideribbon/SlideClosedListener;

    if-eqz v3, :cond_0

    .line 374
    iget-object v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->slideClosedListener:Lcom/comcast/cim/android/sideribbon/SlideClosedListener;

    invoke-interface {v3}, Lcom/comcast/cim/android/sideribbon/SlideClosedListener;->onCloseFinished()V

    .line 376
    :cond_0
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 381
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 6
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 351
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    sget-object v1, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->IN_PROGRESS:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    # invokes: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->updateState(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;)V
    invoke-static {v0, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$500(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;)V

    .line 353
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$1300(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 354
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$1300(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    iget-object v1, v1, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->focusToggleState:Ljava/util/HashMap;

    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->touchyContentContainer:Landroid/view/ViewGroup;
    invoke-static {v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$600(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->touchyContentContainer:Landroid/view/ViewGroup;
    invoke-static {v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$600(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->toggleScreenFocus(Ljava/util/HashMap;Landroid/view/ViewGroup;Landroid/view/ViewGroup;ZZ)V

    .line 356
    :cond_0
    return-void
.end method
