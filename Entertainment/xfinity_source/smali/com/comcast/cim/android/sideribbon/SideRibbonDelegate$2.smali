.class Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;
.super Ljava/lang/Object;
.source "SideRibbonDelegate.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;-><init>(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;Lcom/comcast/cim/android/accessibility/AccessibilityUtil;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

.field final synthetic val$accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field final synthetic val$shadowWidth:I


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Lcom/comcast/cim/android/accessibility/AccessibilityUtil;I)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .prologue
    .line 173
    iput-object p1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    iput-object p2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->val$accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    iput p3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->val$shadowWidth:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 6
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    const/4 v5, 0x0

    .line 187
    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->touchyContentContainer:Landroid/view/ViewGroup;
    invoke-static {v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$600(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 188
    .local v0, "mlp":Landroid/view/ViewGroup$MarginLayoutParams;
    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonWidth:I
    invoke-static {v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$700(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)I

    move-result v2

    iget-object v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonWidth:I
    invoke-static {v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$700(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)I

    move-result v3

    neg-int v3, v3

    invoke-virtual {v0, v2, v5, v3, v5}, Landroid/view/ViewGroup$MarginLayoutParams;->setMargins(IIII)V

    .line 189
    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->touchyContentContainer:Landroid/view/ViewGroup;
    invoke-static {v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$600(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/view/ViewGroup;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 191
    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;
    invoke-static {v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$800(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 192
    .local v1, "smlp":Landroid/view/ViewGroup$MarginLayoutParams;
    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonWidth:I
    invoke-static {v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$700(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)I

    move-result v2

    iget v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->val$shadowWidth:I

    sub-int/2addr v2, v3

    iget-object v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonWidth:I
    invoke-static {v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$700(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)I

    move-result v3

    neg-int v3, v3

    iget v4, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->val$shadowWidth:I

    sub-int/2addr v3, v4

    invoke-virtual {v1, v2, v5, v3, v5}, Landroid/view/ViewGroup$MarginLayoutParams;->setMargins(IIII)V

    .line 193
    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;
    invoke-static {v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$800(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 196
    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;
    invoke-static {v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$400(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonWidth:I
    invoke-static {v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$700(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)I

    move-result v3

    iput v3, v2, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 197
    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;
    invoke-static {v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$400(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewGroup;->requestLayout()V

    .line 198
    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;
    invoke-static {v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$400(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewGroup;->requestFocus()Z

    .line 200
    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    sget-object v3, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->OPEN:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    # invokes: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->updateState(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;)V
    invoke-static {v2, v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$500(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;)V

    .line 201
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 206
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 6
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    const/4 v4, 0x1

    .line 176
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;
    invoke-static {v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$400(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 177
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    sget-object v1, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->IN_PROGRESS:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    # invokes: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->updateState(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;)V
    invoke-static {v0, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$500(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;)V

    .line 179
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->val$accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 180
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->val$accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    iget-object v1, v1, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->focusToggleState:Ljava/util/HashMap;

    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->touchyContentContainer:Landroid/view/ViewGroup;
    invoke-static {v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$600(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->touchyContentContainer:Landroid/view/ViewGroup;
    invoke-static {v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$600(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;

    move-result-object v3

    move v5, v4

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->toggleScreenFocus(Ljava/util/HashMap;Landroid/view/ViewGroup;Landroid/view/ViewGroup;ZZ)V

    .line 182
    :cond_0
    return-void
.end method
