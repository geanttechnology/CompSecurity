.class public Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptorLinearLayout;
.super Landroid/widget/LinearLayout;
.source "GestureInterceptorLinearLayout.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptable;


# instance fields
.field private gestureDetector:Landroid/view/GestureDetector;


# virtual methods
.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptorLinearLayout;->gestureDetector:Landroid/view/GestureDetector;

    if-eqz v0, :cond_0

    .line 29
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptorLinearLayout;->gestureDetector:Landroid/view/GestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 31
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptorLinearLayout;->gestureDetector:Landroid/view/GestureDetector;

    if-eqz v0, :cond_0

    .line 37
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptorLinearLayout;->gestureDetector:Landroid/view/GestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 39
    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method public setGestureListener(Landroid/view/GestureDetector$SimpleOnGestureListener;)V
    .locals 1
    .param p1, "gestureListener"    # Landroid/view/GestureDetector$SimpleOnGestureListener;

    .prologue
    .line 43
    if-eqz p1, :cond_0

    .line 44
    new-instance v0, Landroid/view/GestureDetector;

    invoke-direct {v0, p1}, Landroid/view/GestureDetector;-><init>(Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptorLinearLayout;->gestureDetector:Landroid/view/GestureDetector;

    .line 48
    :goto_0
    return-void

    .line 46
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptorLinearLayout;->gestureDetector:Landroid/view/GestureDetector;

    goto :goto_0
.end method
