.class Lco/vine/android/views/HorizontalListView$1;
.super Ljava/lang/Object;
.source "HorizontalListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/views/HorizontalListView;->onTouchEvent(Landroid/view/MotionEvent;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/views/HorizontalListView;

.field final synthetic val$child:Landroid/view/View;

.field final synthetic val$performClick:Lco/vine/android/views/HorizontalListView$PerformClick;


# direct methods
.method constructor <init>(Lco/vine/android/views/HorizontalListView;Landroid/view/View;Lco/vine/android/views/HorizontalListView$PerformClick;)V
    .locals 0

    .prologue
    .line 558
    iput-object p1, p0, Lco/vine/android/views/HorizontalListView$1;->this$0:Lco/vine/android/views/HorizontalListView;

    iput-object p2, p0, Lco/vine/android/views/HorizontalListView$1;->val$child:Landroid/view/View;

    iput-object p3, p0, Lco/vine/android/views/HorizontalListView$1;->val$performClick:Lco/vine/android/views/HorizontalListView$PerformClick;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 560
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView$1;->this$0:Lco/vine/android/views/HorizontalListView;

    const/4 v1, -0x1

    # setter for: Lco/vine/android/views/HorizontalListView;->mTouchMode:I
    invoke-static {v0, v1}, Lco/vine/android/views/HorizontalListView;->access$002(Lco/vine/android/views/HorizontalListView;I)I

    .line 561
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView$1;->val$child:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setPressed(Z)V

    .line 562
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView$1;->this$0:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v0, v2}, Lco/vine/android/views/HorizontalListView;->setPressed(Z)V

    .line 563
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView$1;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mDataChanged:Z
    invoke-static {v0}, Lco/vine/android/views/HorizontalListView;->access$100(Lco/vine/android/views/HorizontalListView;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/views/HorizontalListView$1;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mMotionPosition:I
    invoke-static {v0}, Lco/vine/android/views/HorizontalListView;->access$200(Lco/vine/android/views/HorizontalListView;)I

    move-result v0

    iget-object v1, p0, Lco/vine/android/views/HorizontalListView$1;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mDownPosition:I
    invoke-static {v1}, Lco/vine/android/views/HorizontalListView;->access$300(Lco/vine/android/views/HorizontalListView;)I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 564
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView$1;->val$performClick:Lco/vine/android/views/HorizontalListView$PerformClick;

    invoke-virtual {v0}, Lco/vine/android/views/HorizontalListView$PerformClick;->run()V

    .line 566
    :cond_0
    return-void
.end method
