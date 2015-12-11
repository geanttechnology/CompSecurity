.class Lcom/amazon/retailsearch/android/ui/results/ProductView$SwipeListener;
.super Ljava/lang/Object;
.source "ProductView.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/ProductView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SwipeListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/ProductView;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/results/ProductView;)V
    .locals 0

    .prologue
    .line 412
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView$SwipeListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/ProductView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/results/ProductView;Lcom/amazon/retailsearch/android/ui/results/ProductView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/results/ProductView;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ProductView$1;

    .prologue
    .line 412
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/ProductView$SwipeListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/ProductView;)V

    return-void
.end method


# virtual methods
.method public onDown(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "motionEvent"    # Landroid/view/MotionEvent;

    .prologue
    .line 417
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView$SwipeListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/ProductView;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->swipeDetector:Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->isSwiping()Z

    move-result v0

    if-nez v0, :cond_0

    .line 419
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView$SwipeListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/ProductView;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->swiped:Z

    .line 421
    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method public onMove(FFLandroid/view/MotionEvent;FF)Z
    .locals 2
    .param p1, "startX"    # F
    .param p2, "startY"    # F
    .param p3, "motionEvent"    # Landroid/view/MotionEvent;
    .param p4, "velocityX"    # F
    .param p5, "velocityY"    # F

    .prologue
    const/4 v1, 0x1

    .line 430
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView$SwipeListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/ProductView;

    iget-boolean v0, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->swiped:Z

    if-nez v0, :cond_0

    .line 432
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ProductView$SwipeListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/ProductView;

    iput-boolean v1, v0, Lcom/amazon/retailsearch/android/ui/results/ProductView;->swiped:Z

    .line 438
    :cond_0
    return v1
.end method

.method public onSwipe(FFLandroid/view/MotionEvent;FF)Z
    .locals 1
    .param p1, "startX"    # F
    .param p2, "startY"    # F
    .param p3, "motionEvent"    # Landroid/view/MotionEvent;
    .param p4, "velocityX"    # F
    .param p5, "velocityY"    # F

    .prologue
    .line 444
    const/4 v0, 0x1

    return v0
.end method
