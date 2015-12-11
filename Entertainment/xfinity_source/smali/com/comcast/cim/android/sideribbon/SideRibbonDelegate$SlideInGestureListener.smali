.class Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$SlideInGestureListener;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "SideRibbonDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SlideInGestureListener"
.end annotation


# instance fields
.field final SWIPE_THRESHOLD_VELOCITY:I

.field private sideRibbonDelegate:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

.field final synthetic this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)V
    .locals 1
    .param p2, "sideRibbonDelegate"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .prologue
    .line 418
    iput-object p1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$SlideInGestureListener;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    .line 415
    const/16 v0, 0x14

    iput v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$SlideInGestureListener;->SWIPE_THRESHOLD_VELOCITY:I

    .line 419
    iput-object p2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$SlideInGestureListener;->sideRibbonDelegate:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .line 420
    return-void
.end method


# virtual methods
.method public onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 2
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "velocityX"    # F
    .param p4, "velocityY"    # F

    .prologue
    .line 430
    invoke-static {p3}, Ljava/lang/Math;->abs(F)F

    move-result v0

    invoke-static {p4}, Ljava/lang/Math;->abs(F)F

    move-result v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    const/4 v0, 0x0

    cmpg-float v0, p3, v0

    if-gez v0, :cond_0

    invoke-static {p3}, Ljava/lang/Math;->abs(F)F

    move-result v0

    const/high16 v1, 0x41a00000    # 20.0f

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    .line 431
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$SlideInGestureListener;->sideRibbonDelegate:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->slideClosed(Lcom/comcast/cim/android/sideribbon/SlideClosedListener;)V

    .line 432
    const/4 v0, 0x1

    .line 434
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onSingleTapUp(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 424
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$SlideInGestureListener;->sideRibbonDelegate:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->slideClosed(Lcom/comcast/cim/android/sideribbon/SlideClosedListener;)V

    .line 425
    const/4 v0, 0x1

    return v0
.end method
