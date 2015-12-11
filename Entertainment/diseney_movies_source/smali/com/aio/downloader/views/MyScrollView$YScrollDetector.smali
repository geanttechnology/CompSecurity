.class Lcom/aio/downloader/views/MyScrollView$YScrollDetector;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "MyScrollView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/MyScrollView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "YScrollDetector"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/MyScrollView;


# direct methods
.method constructor <init>(Lcom/aio/downloader/views/MyScrollView;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/aio/downloader/views/MyScrollView$YScrollDetector;->this$0:Lcom/aio/downloader/views/MyScrollView;

    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 2
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "distanceX"    # F
    .param p4, "distanceY"    # F

    .prologue
    .line 34
    invoke-static {p4}, Ljava/lang/Math;->abs(F)F

    move-result v0

    invoke-static {p3}, Ljava/lang/Math;->abs(F)F

    move-result v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    .line 35
    const/4 v0, 0x1

    .line 37
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
