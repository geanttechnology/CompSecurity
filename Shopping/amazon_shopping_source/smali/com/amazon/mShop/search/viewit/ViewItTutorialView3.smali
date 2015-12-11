.class public Lcom/amazon/mShop/search/viewit/ViewItTutorialView3;
.super Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;
.source "ViewItTutorialView3.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;II)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "deviceFrameHeight"    # I
    .param p3, "productsFrameWidth"    # I

    .prologue
    .line 10
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;-><init>(Landroid/content/Context;)V

    .line 11
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView3;->updateContentView()V

    .line 12
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView3;->reLayoutContentView(II)V

    .line 13
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->view_it_tutorial_title_2:I

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->view_it_tutorial_description_2:I

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView3;->updateTitleAndDescription(II)V

    .line 14
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView3;->hideTutorialTitleAndDescription()V

    .line 15
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView3;->hideNextButton()V

    .line 16
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView3;->animateOutProductsFrame(Z)V

    .line 17
    return-void
.end method


# virtual methods
.method public updateContentView()V
    .locals 2

    .prologue
    .line 21
    invoke-super {p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->updateContentView()V

    .line 22
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialView3;->mDeviceAndHistoryTrayFrame:Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 23
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialView3;->mScannedHistoryItem:Landroid/widget/ImageView;

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->tutorial_history_barcode:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 24
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialView3;->mProductsFrame:Landroid/widget/ImageView;

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->tutorial_barcode:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 25
    return-void
.end method
