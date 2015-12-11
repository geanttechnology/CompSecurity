.class Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$2;
.super Landroid/view/animation/TranslateAnimation;
.source "ViewItTutorialContentView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->startDeviceFrameTranslateAnimation1()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;IFIFIFIF)V
    .locals 9
    .param p2, "x0"    # I
    .param p3, "x1"    # F
    .param p4, "x2"    # I
    .param p5, "x3"    # F
    .param p6, "x4"    # I
    .param p7, "x5"    # F
    .param p8, "x6"    # I
    .param p9, "x7"    # F

    .prologue
    .line 177
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    move-object v0, p0

    move v1, p2

    move v2, p3

    move v3, p4

    move v4, p5

    move v5, p6

    move/from16 v6, p7

    move/from16 v7, p8

    move/from16 v8, p9

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    return-void
.end method


# virtual methods
.method protected applyTransformation(FLandroid/view/animation/Transformation;)V
    .locals 2
    .param p1, "interpolatedTime"    # F
    .param p2, "t"    # Landroid/view/animation/Transformation;

    .prologue
    .line 182
    invoke-super {p0, p1, p2}, Landroid/view/animation/TranslateAnimation;->applyTransformation(FLandroid/view/animation/Transformation;)V

    .line 183
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 184
    .local v0, "parent":Landroid/view/View;
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->postInvalidate()V

    .line 185
    invoke-virtual {v0}, Landroid/view/View;->postInvalidate()V

    .line 186
    return-void
.end method
