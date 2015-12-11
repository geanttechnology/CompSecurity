.class public Lcom/amazon/mShop/error/AmazonErrorBox;
.super Landroid/widget/LinearLayout;
.source "AmazonErrorBox.java"

# interfaces
.implements Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    }
.end annotation


# instance fields
.field private mActionButton:Landroid/widget/Button;

.field private mCurrentOrientation:I

.field private mDialogBox:Landroid/widget/LinearLayout;

.field private mMsgTextView:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 39
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 36
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/error/AmazonErrorBox;->mCurrentOrientation:I

    .line 41
    invoke-virtual {p0}, Lcom/amazon/mShop/error/AmazonErrorBox;->createDialog()V

    .line 43
    invoke-virtual {p0}, Lcom/amazon/mShop/error/AmazonErrorBox;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/error/AmazonErrorBox;->handleConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 44
    return-void
.end method

.method private adjustLayout(I)V
    .locals 8
    .param p1, "orientation"    # I

    .prologue
    const/4 v7, 0x1

    const/4 v6, -0x1

    const/4 v5, -0x2

    .line 104
    invoke-virtual {p0}, Lcom/amazon/mShop/error/AmazonErrorBox;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$dimen;->padding:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 106
    .local v2, "padding":I
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v1, v6, v5}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 108
    .local v1, "msgTextViewParams":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {v1, v2, v2, v2, v2}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 110
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v0, v6, v5}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 112
    .local v0, "actionButtonParams":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {v0, v2, v2, v2, v2}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 114
    const/4 v3, 0x2

    if-ne p1, v3, :cond_0

    .line 116
    invoke-virtual {p0}, Lcom/amazon/mShop/error/AmazonErrorBox;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$integer;->error_dialog_msg_weight_landscape:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v3

    int-to-float v3, v3

    iput v3, v1, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 119
    const/16 v3, 0x10

    iput v3, v0, Landroid/widget/LinearLayout$LayoutParams;->gravity:I

    .line 120
    invoke-virtual {p0}, Lcom/amazon/mShop/error/AmazonErrorBox;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$integer;->error_dialog_positive_button_weight_landscape:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v3

    int-to-float v3, v3

    iput v3, v0, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 123
    iget-object v3, p0, Lcom/amazon/mShop/error/AmazonErrorBox;->mDialogBox:Landroid/widget/LinearLayout;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 130
    :goto_0
    iget-object v3, p0, Lcom/amazon/mShop/error/AmazonErrorBox;->mMsgTextView:Landroid/widget/TextView;

    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 131
    iget-object v3, p0, Lcom/amazon/mShop/error/AmazonErrorBox;->mActionButton:Landroid/widget/Button;

    invoke-virtual {v3, v0}, Landroid/widget/Button;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 133
    return-void

    .line 125
    :cond_0
    iput v7, v0, Landroid/widget/LinearLayout$LayoutParams;->gravity:I

    .line 127
    iget-object v3, p0, Lcom/amazon/mShop/error/AmazonErrorBox;->mDialogBox:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v7}, Landroid/widget/LinearLayout;->setOrientation(I)V

    goto :goto_0
.end method

.method private getButton(I)Landroid/widget/Button;
    .locals 2
    .param p1, "whichButton"    # I

    .prologue
    .line 136
    const/4 v0, 0x0

    .line 137
    .local v0, "button":Landroid/widget/Button;
    const/4 v1, 0x1

    if-ne p1, v1, :cond_0

    .line 138
    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonErrorBox;->mActionButton:Landroid/widget/Button;

    .line 140
    :cond_0
    return-object v0
.end method


# virtual methods
.method protected createDialog()V
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 47
    invoke-virtual {p0}, Lcom/amazon/mShop/error/AmazonErrorBox;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 50
    .local v0, "context":Landroid/content/Context;
    const/4 v2, 0x1

    iput v2, p0, Lcom/amazon/mShop/error/AmazonErrorBox;->mCurrentOrientation:I

    .line 51
    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->amazon_error_box:I

    invoke-static {v0, v2, p0}, Lcom/amazon/mShop/error/AmazonErrorBox;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 52
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->error_box_action_box:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/error/AmazonErrorBox;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/amazon/mShop/error/AmazonErrorBox;->mDialogBox:Landroid/widget/LinearLayout;

    .line 54
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->error_box_message:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/error/AmazonErrorBox;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/amazon/mShop/error/AmazonErrorBox;->mMsgTextView:Landroid/widget/TextView;

    .line 56
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->error_box_action_button:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/error/AmazonErrorBox;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    iput-object v2, p0, Lcom/amazon/mShop/error/AmazonErrorBox;->mActionButton:Landroid/widget/Button;

    .line 60
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v1, v3, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 62
    .local v1, "fillContentAreaParams":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/error/AmazonErrorBox;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 64
    return-void
.end method

.method public handleConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 68
    iget v0, p0, Lcom/amazon/mShop/error/AmazonErrorBox;->mCurrentOrientation:I

    iget v1, p1, Landroid/content/res/Configuration;->orientation:I

    if-eq v0, v1, :cond_0

    .line 69
    iget v0, p1, Landroid/content/res/Configuration;->orientation:I

    iput v0, p0, Lcom/amazon/mShop/error/AmazonErrorBox;->mCurrentOrientation:I

    .line 70
    iget v0, p0, Lcom/amazon/mShop/error/AmazonErrorBox;->mCurrentOrientation:I

    invoke-direct {p0, v0}, Lcom/amazon/mShop/error/AmazonErrorBox;->adjustLayout(I)V

    .line 73
    :cond_0
    return-void
.end method

.method public setButtonOnClick(ILandroid/view/View$OnClickListener;)V
    .locals 1
    .param p1, "whichButton"    # I
    .param p2, "listener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 87
    invoke-direct {p0, p1}, Lcom/amazon/mShop/error/AmazonErrorBox;->getButton(I)Landroid/widget/Button;

    move-result-object v0

    .line 88
    .local v0, "btn":Landroid/widget/Button;
    if-eqz v0, :cond_0

    .line 89
    invoke-virtual {v0, p2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 91
    :cond_0
    return-void
.end method

.method public setButtonText(ILjava/lang/CharSequence;)V
    .locals 1
    .param p1, "whichButton"    # I
    .param p2, "text"    # Ljava/lang/CharSequence;

    .prologue
    .line 80
    invoke-direct {p0, p1}, Lcom/amazon/mShop/error/AmazonErrorBox;->getButton(I)Landroid/widget/Button;

    move-result-object v0

    .line 81
    .local v0, "btn":Landroid/widget/Button;
    if-eqz v0, :cond_0

    .line 82
    invoke-virtual {v0, p2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 84
    :cond_0
    return-void
.end method

.method public setMessage(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/CharSequence;

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonErrorBox;->mMsgTextView:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 77
    return-void
.end method
