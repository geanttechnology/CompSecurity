.class Lco/vine/android/widget/TooltipOverlayView$2;
.super Lco/vine/android/animation/SimpleAnimationListener;
.source "TooltipOverlayView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/widget/TooltipOverlayView;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/widget/TooltipOverlayView;


# direct methods
.method constructor <init>(Lco/vine/android/widget/TooltipOverlayView;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lco/vine/android/widget/TooltipOverlayView$2;->this$0:Lco/vine/android/widget/TooltipOverlayView;

    invoke-direct {p0}, Lco/vine/android/animation/SimpleAnimationListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 3
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 91
    iget-object v1, p0, Lco/vine/android/widget/TooltipOverlayView$2;->this$0:Lco/vine/android/widget/TooltipOverlayView;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Lco/vine/android/widget/TooltipOverlayView;->setVisibility(I)V

    .line 92
    iget-object v1, p0, Lco/vine/android/widget/TooltipOverlayView$2;->this$0:Lco/vine/android/widget/TooltipOverlayView;

    invoke-virtual {v1}, Lco/vine/android/widget/TooltipOverlayView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 93
    .local v0, "parent":Landroid/view/ViewGroup;
    if-eqz v0, :cond_0

    .line 94
    iget-object v1, p0, Lco/vine/android/widget/TooltipOverlayView$2;->this$0:Lco/vine/android/widget/TooltipOverlayView;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 96
    :cond_0
    return-void
.end method
