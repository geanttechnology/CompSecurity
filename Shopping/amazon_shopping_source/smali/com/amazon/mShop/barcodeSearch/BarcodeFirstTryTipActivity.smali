.class public Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "BarcodeFirstTryTipActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 22
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 33
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->help_root_title:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity;->setTitle(I)V

    .line 34
    return-void
.end method

.method protected onStart()V
    .locals 3

    .prologue
    .line 38
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStart()V

    .line 39
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity;->setStopBehavior(I)V

    .line 41
    new-instance v0, Lcom/amazon/mShop/StandardView;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->bc_search_help_title:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-direct {v0, p0, v2}, Lcom/amazon/mShop/StandardView;-><init>(Landroid/content/Context;Ljava/lang/Integer;)V

    .line 42
    .local v0, "content":Lcom/amazon/mShop/StandardView;
    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->barcode_search_first_try_help:I

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/StandardView;->setContentView(I)V

    .line 44
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->barcode_search_first_try_screen_try_it_button:I

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/StandardView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 45
    .local v1, "tryItBtn":Landroid/widget/Button;
    new-instance v2, Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity$1;-><init>(Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 59
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity;->pushView(Landroid/view/View;)V

    .line 60
    return-void
.end method
