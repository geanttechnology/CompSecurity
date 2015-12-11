.class public Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;
.super Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;
.source "ViewItTutorialView2.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;II)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "deviceFrameHeight"    # I
    .param p3, "productsFrameWidth"    # I

    .prologue
    .line 15
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;-><init>(Landroid/content/Context;)V

    .line 16
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;->updateContentView()V

    .line 17
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;->reLayoutContentView(II)V

    .line 18
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;->hideNextButton()V

    .line 19
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;->adjustDeviceFramePosition()V

    .line 20
    return-void
.end method

.method private adjustDeviceFramePosition()V
    .locals 10

    .prologue
    const/4 v6, 0x0

    const/4 v1, 0x0

    const/4 v5, 0x1

    .line 23
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;->mDeviceAndHistoryTrayFrame:Landroid/view/ViewGroup;

    invoke-virtual {v3, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 24
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;->mScannedHistoryItem:Landroid/widget/ImageView;

    sget v4, Lcom/amazon/mShop/android/lib/R$drawable;->tutorial_history_jar:I

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 26
    iget v3, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;->mProductsFrameWidth:I

    int-to-float v3, v3

    const/high16 v4, 0x3ec00000    # 0.375f

    mul-float v2, v3, v4

    .line 27
    .local v2, "fromXValue":F
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    move v3, v1

    move v4, v2

    move v7, v5

    move v8, v6

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 34
    .local v0, "translateAnimation":Landroid/view/animation/TranslateAnimation;
    new-instance v9, Landroid/view/animation/AnimationSet;

    invoke-direct {v9, v5}, Landroid/view/animation/AnimationSet;-><init>(Z)V

    .line 35
    .local v9, "set":Landroid/view/animation/AnimationSet;
    invoke-virtual {v9, v0}, Landroid/view/animation/AnimationSet;->addAnimation(Landroid/view/animation/Animation;)V

    .line 36
    new-instance v1, Landroid/view/animation/AccelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/AccelerateInterpolator;-><init>()V

    invoke-virtual {v9, v1}, Landroid/view/animation/AnimationSet;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 37
    invoke-virtual {v9, v5}, Landroid/view/animation/AnimationSet;->setFillAfter(Z)V

    .line 38
    const-wide/16 v3, 0x32

    invoke-virtual {v9, v3, v4}, Landroid/view/animation/AnimationSet;->setDuration(J)V

    .line 39
    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItTutorialView2$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView2$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;)V

    invoke-virtual {v9, v1}, Landroid/view/animation/AnimationSet;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 56
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialView2;->mDeviceAndHistoryTrayFrame:Landroid/view/ViewGroup;

    invoke-virtual {v1, v9}, Landroid/view/ViewGroup;->startAnimation(Landroid/view/animation/Animation;)V

    .line 57
    return-void
.end method
