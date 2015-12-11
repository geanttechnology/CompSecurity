.class Lcom/amazon/androidmotion/animator/ViewAlphaAnimator$1;
.super Ljava/lang/Object;
.source "ViewAlphaAnimator.java"

# interfaces
.implements Lcom/amazon/androidmotion/lifecycle/AnimatorManager$ElapsedFractionCalculator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->init(FFJ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;


# direct methods
.method constructor <init>(Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator$1;->this$0:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getElapsedFraction(Landroid/animation/ValueAnimator;)F
    .locals 1
    .param p1, "animator"    # Landroid/animation/ValueAnimator;

    .prologue
    .line 82
    iget-object v0, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator$1;->this$0:Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;

    invoke-virtual {v0}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->getFraction()F

    move-result v0

    return v0
.end method
