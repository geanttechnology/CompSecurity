.class Lcom/creditcardreader/helpers/CreditCardAnimationHelper$1;
.super Ljava/lang/Object;
.source "CreditCardAnimationHelper.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->createStatusListener(Ljava/lang/String;)Landroid/view/animation/Animation$AnimationListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

.field final synthetic val$text:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 220
    iput-object p1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$1;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    iput-object p2, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$1;->val$text:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 223
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$1;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    # getter for: Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mStatusView:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->access$000(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$1;->val$text:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 224
    iget-object v0, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$1;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    # getter for: Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mStatusView:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->access$000(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/creditcardreader/helpers/CreditCardAnimationHelper$1;->this$0:Lcom/creditcardreader/helpers/CreditCardAnimationHelper;

    # getter for: Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->mFadeInText:Landroid/view/animation/Animation;
    invoke-static {v1}, Lcom/creditcardreader/helpers/CreditCardAnimationHelper;->access$100(Lcom/creditcardreader/helpers/CreditCardAnimationHelper;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 225
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "arg0"    # Landroid/view/animation/Animation;

    .prologue
    .line 228
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "arg0"    # Landroid/view/animation/Animation;

    .prologue
    .line 231
    return-void
.end method
