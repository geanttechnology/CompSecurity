.class public Lcom/amazon/mShop/AmazonProgressDialog;
.super Landroid/app/AlertDialog;
.source "AmazonProgressDialog.java"


# instance fields
.field private mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v7, -0x2

    .line 32
    invoke-direct {p0, p1}, Landroid/app/AlertDialog;-><init>(Landroid/content/Context;)V

    .line 33
    iput-object p1, p0, Lcom/amazon/mShop/AmazonProgressDialog;->mContext:Landroid/content/Context;

    .line 39
    new-instance v2, Landroid/widget/RelativeLayout;

    iget-object v4, p0, Lcom/amazon/mShop/AmazonProgressDialog;->mContext:Landroid/content/Context;

    invoke-direct {v2, v4}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 40
    .local v2, "progressView":Landroid/widget/RelativeLayout;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v4, v7, v7}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v2, v4}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 41
    const/16 v4, 0x11

    invoke-virtual {v2, v4}, Landroid/widget/RelativeLayout;->setGravity(I)V

    .line 42
    iget-object v4, p0, Lcom/amazon/mShop/AmazonProgressDialog;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$dimen;->padding:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v4

    float-to-int v0, v4

    .line 43
    .local v0, "padding":I
    invoke-virtual {v2, v0, v0, v0, v0}, Landroid/widget/RelativeLayout;->setPadding(IIII)V

    .line 45
    new-instance v1, Landroid/widget/ProgressBar;

    iget-object v4, p0, Lcom/amazon/mShop/AmazonProgressDialog;->mContext:Landroid/content/Context;

    const/4 v5, 0x0

    const v6, 0x1010077

    invoke-direct {v1, v4, v5, v6}, Landroid/widget/ProgressBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 46
    .local v1, "progressBar":Landroid/widget/ProgressBar;
    new-instance v3, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v3, v7, v7}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 49
    .local v3, "relativeLayoutParams":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v4, 0xd

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 50
    invoke-virtual {v1, v3}, Landroid/widget/ProgressBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 52
    invoke-virtual {v2, v1}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 53
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/AmazonProgressDialog;->setView(Landroid/view/View;)V

    .line 54
    return-void
.end method


# virtual methods
.method public dismiss()V
    .locals 3

    .prologue
    .line 69
    :try_start_0
    invoke-super {p0}, Landroid/app/AlertDialog;->dismiss()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 75
    :cond_0
    :goto_0
    return-void

    .line 70
    :catch_0
    move-exception v0

    .line 71
    .local v0, "e":Ljava/lang/RuntimeException;
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 72
    const-string/jumbo v1, "AmazonProgressDialog"

    invoke-virtual {v0}, Ljava/lang/RuntimeException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 58
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonProgressDialog;->dismiss()V

    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/AmazonProgressDialog;->mContext:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->onSearchRequested()Z

    move-result v0

    return v0
.end method
