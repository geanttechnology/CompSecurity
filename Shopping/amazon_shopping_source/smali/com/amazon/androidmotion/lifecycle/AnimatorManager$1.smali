.class Lcom/amazon/androidmotion/lifecycle/AnimatorManager$1;
.super Landroid/animation/AnimatorListenerAdapter;
.source "AnimatorManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/androidmotion/lifecycle/AnimatorManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/androidmotion/lifecycle/AnimatorManager;


# direct methods
.method constructor <init>(Lcom/amazon/androidmotion/lifecycle/AnimatorManager;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager$1;->this$0:Lcom/amazon/androidmotion/lifecycle/AnimatorManager;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 1
    .param p1, "animation"    # Landroid/animation/Animator;

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager$1;->this$0:Lcom/amazon/androidmotion/lifecycle/AnimatorManager;

    invoke-virtual {v0}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->clearAnimator()V

    .line 32
    return-void
.end method
