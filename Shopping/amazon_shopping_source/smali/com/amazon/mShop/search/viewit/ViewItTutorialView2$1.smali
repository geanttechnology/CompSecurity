.class Lcom/amazon/mShop/search/viewit/ViewItTutorialView2$1;
.super Ljava/lang/Object;
.source "ViewItTutorialView2.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;->adjustDeviceFramePosition()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialView2$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialView2$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;->animateOutProductsFrame(Z)V

    .line 43
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 48
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 53
    return-void
.end method
