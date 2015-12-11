.class public Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptorRelativeLayout;
.super Landroid/widget/RelativeLayout;
.source "GestureInterceptorRelativeLayout.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptable;


# instance fields
.field private gestureDetector:Landroid/view/GestureDetector;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 14
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 15
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 19
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 22
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 23
    return-void
.end method


# virtual methods
.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptorRelativeLayout;->gestureDetector:Landroid/view/GestureDetector;

    if-eqz v0, :cond_0

    .line 28
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptorRelativeLayout;->gestureDetector:Landroid/view/GestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 30
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
    .line 35
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptorRelativeLayout;->gestureDetector:Landroid/view/GestureDetector;

    if-eqz v0, :cond_0

    .line 36
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptorRelativeLayout;->gestureDetector:Landroid/view/GestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 38
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

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptorRelativeLayout;->gestureDetector:Landroid/view/GestureDetector;

    .line 48
    :goto_0
    return-void

    .line 46
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/GestureInterceptorRelativeLayout;->gestureDetector:Landroid/view/GestureDetector;

    goto :goto_0
.end method
