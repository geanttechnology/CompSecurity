.class Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView$YScrollDetector;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "ObservableScrollView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "YScrollDetector"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView$YScrollDetector;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/ObservableScrollView;

    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 3
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "distanceX"    # F
    .param p4, "distanceY"    # F

    .prologue
    const/4 v0, 0x0

    .line 63
    :try_start_0
    invoke-static {p4}, Ljava/lang/Math;->abs(F)F

    move-result v1

    invoke-static {p3}, Ljava/lang/Math;->abs(F)F
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    cmpl-float v1, v1, v2

    if-lez v1, :cond_0

    .line 64
    const/4 v0, 0x1

    .line 70
    :cond_0
    :goto_0
    return v0

    .line 68
    :catch_0
    move-exception v1

    goto :goto_0
.end method
