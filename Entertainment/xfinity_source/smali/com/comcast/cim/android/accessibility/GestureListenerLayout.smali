.class public Lcom/comcast/cim/android/accessibility/GestureListenerLayout;
.super Landroid/widget/LinearLayout;
.source "GestureListenerLayout.java"


# instance fields
.field private gestureDetector:Landroid/view/GestureDetector;

.field private isDownValid:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 15
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->isDownValid:Z

    .line 19
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 15
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->isDownValid:Z

    .line 23
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 26
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 15
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->isDownValid:Z

    .line 27
    return-void
.end method


# virtual methods
.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->gestureDetector:Landroid/view/GestureDetector;

    if-eqz v0, :cond_2

    .line 38
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_0

    .line 39
    invoke-virtual {p0}, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/comcast/cim/android/accessibility/PassiveGestureListener;->isDownInRange(Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->isDownValid:Z

    .line 40
    iget-boolean v0, p0, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->isDownValid:Z

    .line 49
    :goto_0
    return v0

    .line 43
    :cond_0
    iget-boolean v0, p0, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->isDownValid:Z

    if-eqz v0, :cond_1

    .line 44
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->gestureDetector:Landroid/view/GestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0

    .line 46
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 49
    :cond_2
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->gestureDetector:Landroid/view/GestureDetector;

    if-eqz v0, :cond_2

    .line 58
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_0

    .line 59
    invoke-virtual {p0}, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/comcast/cim/android/accessibility/PassiveGestureListener;->isDownInRange(Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->isDownValid:Z

    .line 60
    iget-boolean v0, p0, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->isDownValid:Z

    .line 69
    :goto_0
    return v0

    .line 63
    :cond_0
    iget-boolean v0, p0, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->isDownValid:Z

    if-eqz v0, :cond_1

    .line 64
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->gestureDetector:Landroid/view/GestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0

    .line 66
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 69
    :cond_2
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public setGestureListener(Landroid/view/GestureDetector;)V
    .locals 0
    .param p1, "gestureDetector"    # Landroid/view/GestureDetector;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->gestureDetector:Landroid/view/GestureDetector;

    .line 31
    return-void
.end method
