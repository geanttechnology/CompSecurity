.class Lcom/amazon/mShop/gno/GNODrawerItemGroup$1$1;
.super Ljava/lang/Object;
.source "GNODrawerItemGroup.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1$1;->this$1:Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1$1;->this$1:Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;

    iget-object v0, v0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/gno/GNODrawerItemGroup;->mIsAnimating:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->access$102(Lcom/amazon/mShop/gno/GNODrawerItemGroup;Z)Z

    .line 65
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 60
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 57
    return-void
.end method
