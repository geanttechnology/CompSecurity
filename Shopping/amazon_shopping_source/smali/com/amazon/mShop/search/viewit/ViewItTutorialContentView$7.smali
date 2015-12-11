.class Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;
.super Ljava/lang/Object;
.source "ViewItTutorialContentView.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startScannedItemTranslateAnimation(IF)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

.field final synthetic val$fromXValue:F

.field final synthetic val$scannedItemIndex:I


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;IF)V
    .locals 0

    .prologue
    .line 354
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    iput p2, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->val$scannedItemIndex:I

    iput p3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->val$fromXValue:F

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 357
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedItemFrame:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$500(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)Landroid/widget/ImageView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 358
    iget v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->val$scannedItemIndex:I

    packed-switch v0, :pswitch_data_0

    .line 390
    :goto_0
    return-void

    .line 360
    :pswitch_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedHistoryItem:Landroid/widget/ImageView;

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->tutorial_history_bottle:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 361
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->val$fromXValue:F

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startDeviceFrameTranslateAnimation2(F)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$600(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;F)V

    goto :goto_0

    .line 364
    :pswitch_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedHistoryItem:Landroid/widget/ImageView;

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->tutorial_history_book:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 365
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    iget v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->val$fromXValue:F

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startDeviceFrameTranslateAnimation3(F)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$700(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;F)V

    goto :goto_0

    .line 368
    :pswitch_2
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedHistoryItem:Landroid/widget/ImageView;

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->tutorial_history_jar:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 369
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;)V

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->showNextButton(Landroid/view/View$OnClickListener;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$900(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 378
    :pswitch_3
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->mScannedHistoryItem:Landroid/widget/ImageView;

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->tutorial_history_barcode:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 379
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7$2;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$7;)V

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->showNextButton(Landroid/view/View$OnClickListener;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$900(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 358
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 395
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 400
    return-void
.end method
