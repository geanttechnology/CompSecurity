.class public Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;
.super Landroid/widget/ScrollView;
.source "ObservableScrollView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView$YScrollDetector;
    }
.end annotation


# instance fields
.field private gestureDetector:Landroid/view/GestureDetector;

.field private onObservableScrollChangedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/OnObservableScrollChangedListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 12
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;->onObservableScrollChangedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/OnObservableScrollChangedListener;

    .line 18
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;->init(Landroid/content/Context;)V

    .line 19
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 12
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;->onObservableScrollChangedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/OnObservableScrollChangedListener;

    .line 28
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;->init(Landroid/content/Context;)V

    .line 29
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 22
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 12
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;->onObservableScrollChangedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/OnObservableScrollChangedListener;

    .line 23
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;->init(Landroid/content/Context;)V

    .line 24
    return-void
.end method

.method private init(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 36
    new-instance v0, Landroid/view/GestureDetector;

    new-instance v1, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView$YScrollDetector;

    invoke-direct {v1, p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView$YScrollDetector;-><init>(Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;)V

    invoke-direct {v0, v1}, Landroid/view/GestureDetector;-><init>(Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;->gestureDetector:Landroid/view/GestureDetector;

    .line 37
    return-void
.end method


# virtual methods
.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 50
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;->gestureDetector:Landroid/view/GestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 51
    const/4 v0, 0x0

    .line 54
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/widget/ScrollView;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onScrollChanged(IIII)V
    .locals 6
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "oldx"    # I
    .param p4, "oldy"    # I

    .prologue
    .line 41
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/ScrollView;->onScrollChanged(IIII)V

    .line 42
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;->onObservableScrollChangedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/OnObservableScrollChangedListener;

    if-eqz v0, :cond_0

    .line 43
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;->onObservableScrollChangedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/OnObservableScrollChangedListener;

    move-object v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-interface/range {v0 .. v5}, Lcom/comcast/cim/cmasl/android/util/view/widget/OnObservableScrollChangedListener;->onObservableScrollChanged(Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;IIII)V

    .line 45
    :cond_0
    return-void
.end method

.method public setOnObservableScrollChangedListener(Lcom/comcast/cim/cmasl/android/util/view/widget/OnObservableScrollChangedListener;)V
    .locals 0
    .param p1, "onObservableScrollChangedListener"    # Lcom/comcast/cim/cmasl/android/util/view/widget/OnObservableScrollChangedListener;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;->onObservableScrollChangedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/OnObservableScrollChangedListener;

    .line 33
    return-void
.end method
