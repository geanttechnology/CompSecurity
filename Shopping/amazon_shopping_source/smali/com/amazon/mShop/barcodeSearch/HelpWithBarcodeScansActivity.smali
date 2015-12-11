.class public Lcom/amazon/mShop/barcodeSearch/HelpWithBarcodeScansActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "HelpWithBarcodeScansActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/16 v1, 0x400

    .line 23
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 34
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->help_using_amazon_remembers_help_with_barcode_scans_title:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/barcodeSearch/HelpWithBarcodeScansActivity;->setTitle(I)V

    .line 38
    invoke-virtual {p0}, Lcom/amazon/mShop/barcodeSearch/HelpWithBarcodeScansActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v1, v1}, Landroid/view/Window;->setFlags(II)V

    .line 39
    return-void
.end method

.method protected onStart()V
    .locals 2

    .prologue
    .line 43
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStart()V

    .line 44
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/barcodeSearch/HelpWithBarcodeScansActivity;->setStopBehavior(I)V

    .line 46
    new-instance v0, Lcom/amazon/mShop/StandardView;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->help_using_amazon_remembers_help_with_barcode_scans_title:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/amazon/mShop/StandardView;-><init>(Landroid/content/Context;Ljava/lang/Integer;)V

    .line 47
    .local v0, "content":Lcom/amazon/mShop/StandardView;
    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->help_with_barcode_scans:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/StandardView;->setContentView(I)V

    .line 48
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/barcodeSearch/HelpWithBarcodeScansActivity;->pushView(Landroid/view/View;)V

    .line 49
    return-void
.end method
