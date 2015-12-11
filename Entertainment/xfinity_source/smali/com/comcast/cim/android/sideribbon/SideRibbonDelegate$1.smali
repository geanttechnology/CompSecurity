.class Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;
.super Landroid/widget/RelativeLayout;
.source "SideRibbonDelegate.java"


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

.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Landroid/content/Context;Lcom/comcast/cim/android/accessibility/AccessibilityUtil;Landroid/content/Context;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;
    .param p2, "x0"    # Landroid/content/Context;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    iput-object p3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;->val$accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    iput-object p4, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;->val$context:Landroid/content/Context;

    invoke-direct {p0, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v0, 0x1

    .line 80
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->state:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;
    invoke-static {v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$000(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    move-result-object v1

    sget-object v2, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->CLOSED:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    invoke-virtual {v1, v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 81
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerGestureDetector:Landroid/view/GestureDetector;
    invoke-static {v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$100(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/GestureDetector;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 93
    :cond_0
    :goto_0
    return v0

    .line 85
    :cond_1
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;->val$accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v1}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 86
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->passiveGestureListener:Lcom/comcast/cim/android/accessibility/PassiveGestureListener;
    invoke-static {v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$200(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Lcom/comcast/cim/android/accessibility/PassiveGestureListener;

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;->val$context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    invoke-static {p1, v1}, Lcom/comcast/cim/android/accessibility/PassiveGestureListener;->isDownInRange(Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 93
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerGestureDetectorAtRest:Landroid/view/GestureDetector;
    invoke-static {v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$300(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/GestureDetector;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0

    .line 90
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v0, 0x1

    .line 99
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->state:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;
    invoke-static {v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$000(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    move-result-object v1

    sget-object v2, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->CLOSED:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    invoke-virtual {v1, v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 100
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerGestureDetector:Landroid/view/GestureDetector;
    invoke-static {v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$100(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/GestureDetector;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 112
    :cond_0
    :goto_0
    return v0

    .line 104
    :cond_1
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;->val$accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v1}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 105
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->passiveGestureListener:Lcom/comcast/cim/android/accessibility/PassiveGestureListener;
    invoke-static {v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$200(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Lcom/comcast/cim/android/accessibility/PassiveGestureListener;

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;->val$context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    invoke-static {p1, v1}, Lcom/comcast/cim/android/accessibility/PassiveGestureListener;->isDownInRange(Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 112
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerGestureDetectorAtRest:Landroid/view/GestureDetector;
    invoke-static {v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$300(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/GestureDetector;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0

    .line 109
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method
