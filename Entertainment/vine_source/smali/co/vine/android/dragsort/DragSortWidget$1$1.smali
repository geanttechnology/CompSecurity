.class Lco/vine/android/dragsort/DragSortWidget$1$1;
.super Ljava/lang/Object;
.source "DragSortWidget.java"

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/dragsort/DragSortWidget$1;->onPreDraw()Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lco/vine/android/dragsort/DragSortWidget$1;


# direct methods
.method constructor <init>(Lco/vine/android/dragsort/DragSortWidget$1;)V
    .locals 0

    .prologue
    .line 357
    iput-object p1, p0, Lco/vine/android/dragsort/DragSortWidget$1$1;->this$1:Lco/vine/android/dragsort/DragSortWidget$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 1
    .param p1, "animation"    # Landroid/animation/ValueAnimator;

    .prologue
    .line 360
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget$1$1;->this$1:Lco/vine/android/dragsort/DragSortWidget$1;

    iget-object v0, v0, Lco/vine/android/dragsort/DragSortWidget$1;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;
    invoke-static {v0}, Lco/vine/android/dragsort/DragSortWidget;->access$000(Lco/vine/android/dragsort/DragSortWidget;)Lco/vine/android/views/HorizontalListView;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/views/HorizontalListView;->invalidate()V

    .line 361
    return-void
.end method
