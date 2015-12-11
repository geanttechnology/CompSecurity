.class Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3$1;
.super Ljava/lang/Object;
.source "CreditCardAnimationHelper.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;->onAnimationEnd(Landroid/view/animation/Animation;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;


# direct methods
.method constructor <init>(Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;)V
    .locals 0

    .prologue
    .line 274
    iput-object p1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3$1;->this$1:Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 277
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3$1;->this$1:Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;

    iget-object v0, v0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    # getter for: Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;
    invoke-static {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->access$400(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Lcom/creditcardreader/camera/CreditCardCameraPreview;

    move-result-object v0

    invoke-virtual {v0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->isScanning()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 278
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3$1;->this$1:Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;

    iget-object v0, v0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    # getter for: Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mProgressView:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->access$600(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/widget/ImageView;

    move-result-object v0

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3$1;->this$1:Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;

    iget-object v1, v1, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    # getter for: Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mSlideScan:Landroid/view/animation/Animation;
    invoke-static {v1}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->access$500(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 280
    :cond_0
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "arg0"    # Landroid/view/animation/Animation;

    .prologue
    .line 283
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "arg0"    # Landroid/view/animation/Animation;

    .prologue
    .line 286
    return-void
.end method
