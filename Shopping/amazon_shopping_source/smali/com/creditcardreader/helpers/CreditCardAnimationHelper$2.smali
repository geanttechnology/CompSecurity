.class Lcom/creditcardreader/helpers/CreditCardAnimationHelper$2;
.super Ljava/lang/Object;
.source "CreditCardAnimationHelper.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->createGhostListener(Z)Landroid/view/animation/Animation$AnimationListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

.field final synthetic val$visible:Z


# direct methods
.method constructor <init>(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;Z)V
    .locals 0

    .prologue
    .line 245
    iput-object p1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$2;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    iput-boolean p2, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$2;->val$visible:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 248
    iget-boolean v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$2;->val$visible:Z

    if-eqz v0, :cond_0

    .line 249
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$2;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    # getter for: Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mGhostView:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->access$200(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/widget/ImageView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 252
    :goto_0
    return-void

    .line 251
    :cond_0
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$2;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    # getter for: Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mGhostView:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->access$200(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/widget/ImageView;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "arg0"    # Landroid/view/animation/Animation;

    .prologue
    .line 255
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "arg0"    # Landroid/view/animation/Animation;

    .prologue
    .line 258
    return-void
.end method
