.class Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;
.super Ljava/lang/Object;
.source "CreditCardAnimationHelper.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->createSlideListener()Landroid/view/animation/Animation$AnimationListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;


# direct methods
.method constructor <init>(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)V
    .locals 0

    .prologue
    .line 270
    iput-object p1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 3
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 273
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    # getter for: Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeOutScan:Landroid/view/animation/Animation;
    invoke-static {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->access$300(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/view/animation/Animation;

    move-result-object v0

    const-wide/16 v1, 0x12c

    invoke-virtual {v0, v1, v2}, Landroid/view/animation/Animation;->setStartOffset(J)V

    .line 274
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    # getter for: Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeOutScan:Landroid/view/animation/Animation;
    invoke-static {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->access$300(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/view/animation/Animation;

    move-result-object v0

    new-instance v1, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3$1;

    invoke-direct {v1, p0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3$1;-><init>(Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 289
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    # getter for: Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;
    invoke-static {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->access$400(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Lcom/creditcardreader/camera/CreditCardCameraPreview;

    move-result-object v0

    invoke-virtual {v0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->isScanning()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 290
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    # getter for: Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mProgressView:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->access$600(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/widget/ImageView;

    move-result-object v0

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$3;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    # getter for: Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeOutScan:Landroid/view/animation/Animation;
    invoke-static {v1}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->access$300(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 292
    :cond_0
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "arg0"    # Landroid/view/animation/Animation;

    .prologue
    .line 295
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "arg0"    # Landroid/view/animation/Animation;

    .prologue
    .line 298
    return-void
.end method
