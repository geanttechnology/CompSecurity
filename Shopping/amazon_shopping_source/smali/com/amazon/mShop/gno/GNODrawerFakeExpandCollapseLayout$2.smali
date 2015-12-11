.class Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout$2;
.super Ljava/lang/Object;
.source "GNODrawerFakeExpandCollapseLayout.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;->startExpandCollapseAnimation(ZZLjava/lang/Runnable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;

.field final synthetic val$endAction:Ljava/lang/Runnable;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;Ljava/lang/Runnable;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout$2;->this$0:Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout$2;->val$endAction:Ljava/lang/Runnable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 1
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 109
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout$2;->val$endAction:Ljava/lang/Runnable;

    if-eqz v0, :cond_0

    .line 110
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerFakeExpandCollapseLayout$2;->val$endAction:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 112
    :cond_0
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 105
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 102
    return-void
.end method
