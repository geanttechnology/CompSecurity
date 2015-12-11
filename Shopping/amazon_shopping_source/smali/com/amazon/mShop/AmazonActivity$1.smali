.class Lcom/amazon/mShop/AmazonActivity$1;
.super Ljava/lang/Object;
.source "AmazonActivity.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/AmazonActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/AmazonActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0

    .prologue
    .line 906
    iput-object p1, p0, Lcom/amazon/mShop/AmazonActivity$1;->this$0:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "arg0"    # Landroid/view/animation/Animation;

    .prologue
    .line 910
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity$1;->this$0:Lcom/amazon/mShop/AmazonActivity;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/AmazonActivity;->pushAnimationInProgress:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->access$202(Lcom/amazon/mShop/AmazonActivity;Z)Z

    .line 911
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "arg0"    # Landroid/view/animation/Animation;

    .prologue
    .line 915
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity$1;->this$0:Lcom/amazon/mShop/AmazonActivity;

    const/4 v1, 0x1

    # setter for: Lcom/amazon/mShop/AmazonActivity;->pushAnimationInProgress:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->access$202(Lcom/amazon/mShop/AmazonActivity;Z)Z

    .line 916
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "arg0"    # Landroid/view/animation/Animation;

    .prologue
    .line 920
    iget-object v0, p0, Lcom/amazon/mShop/AmazonActivity$1;->this$0:Lcom/amazon/mShop/AmazonActivity;

    const/4 v1, 0x1

    # setter for: Lcom/amazon/mShop/AmazonActivity;->pushAnimationInProgress:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->access$202(Lcom/amazon/mShop/AmazonActivity;Z)Z

    .line 921
    return-void
.end method
