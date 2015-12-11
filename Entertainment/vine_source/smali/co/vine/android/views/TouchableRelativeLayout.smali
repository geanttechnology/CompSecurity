.class public Lco/vine/android/views/TouchableRelativeLayout;
.super Landroid/widget/RelativeLayout;
.source "TouchableRelativeLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/views/TouchableRelativeLayout$TouchListener;
    }
.end annotation


# instance fields
.field public mTouchListener:Lco/vine/android/views/TouchableRelativeLayout$TouchListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 23
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 24
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 28
    return-void
.end method


# virtual methods
.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 36
    iget-object v0, p0, Lco/vine/android/views/TouchableRelativeLayout;->mTouchListener:Lco/vine/android/views/TouchableRelativeLayout$TouchListener;

    if-eqz v0, :cond_0

    .line 37
    iget-object v0, p0, Lco/vine/android/views/TouchableRelativeLayout;->mTouchListener:Lco/vine/android/views/TouchableRelativeLayout$TouchListener;

    invoke-interface {v0, p1}, Lco/vine/android/views/TouchableRelativeLayout$TouchListener;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 39
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/widget/RelativeLayout;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 45
    iget-object v0, p0, Lco/vine/android/views/TouchableRelativeLayout;->mTouchListener:Lco/vine/android/views/TouchableRelativeLayout$TouchListener;

    if-eqz v0, :cond_0

    .line 46
    iget-object v0, p0, Lco/vine/android/views/TouchableRelativeLayout;->mTouchListener:Lco/vine/android/views/TouchableRelativeLayout$TouchListener;

    invoke-interface {v0, p1}, Lco/vine/android/views/TouchableRelativeLayout$TouchListener;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 48
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/widget/RelativeLayout;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public setTouchListener(Lco/vine/android/views/TouchableRelativeLayout$TouchListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/views/TouchableRelativeLayout$TouchListener;

    .prologue
    .line 31
    iput-object p1, p0, Lco/vine/android/views/TouchableRelativeLayout;->mTouchListener:Lco/vine/android/views/TouchableRelativeLayout$TouchListener;

    .line 32
    return-void
.end method
