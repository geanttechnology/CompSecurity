.class Lco/vine/android/widget/TooltipOverlayView$1;
.super Lco/vine/android/animation/SimpleAnimationListener;
.source "TooltipOverlayView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/widget/TooltipOverlayView;->showTooltip(I)V
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
    .line 73
    iput-object p1, p0, Lco/vine/android/widget/TooltipOverlayView$1;->this$0:Lco/vine/android/widget/TooltipOverlayView;

    invoke-direct {p0}, Lco/vine/android/animation/SimpleAnimationListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 1
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 76
    iget-object v0, p0, Lco/vine/android/widget/TooltipOverlayView$1;->this$0:Lco/vine/android/widget/TooltipOverlayView;

    invoke-virtual {v0}, Lco/vine/android/widget/TooltipOverlayView;->clearAnimation()V

    .line 77
    return-void
.end method
