.class public Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "ViewItScanEntryActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method

.method private checkToStart(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 52
    if-eqz p1, :cond_1

    const-string/jumbo v0, "MODULE_TYPE_IS_IMAGE_SEARCH"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 53
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;->shouldShowFlowTutorialScreen()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 54
    invoke-direct {p0, p0}, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;->startFlowTutorialActivity(Lcom/amazon/mShop/AmazonActivity;)V

    .line 66
    :goto_0
    return-void

    .line 56
    :cond_0
    const-string/jumbo v0, "clickStreamOrigin"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;->startFlow(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V

    goto :goto_0

    .line 60
    :cond_1
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;->shouldShowBarcodeScanFirstTryTipScreen()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 61
    invoke-direct {p0, p0}, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;->startBarcodeScanFirstTryTipScreenActivity(Lcom/amazon/mShop/AmazonActivity;)V

    goto :goto_0

    .line 63
    :cond_2
    invoke-direct {p0, p0}, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;->startBarcodeScan(Lcom/amazon/mShop/AmazonActivity;)V

    goto :goto_0
.end method

.method private shouldShowBarcodeScanFirstTryTipScreen()Z
    .locals 2

    .prologue
    .line 75
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "keyBarcodeSearchTryAccepted"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private shouldShowFlowTutorialScreen()Z
    .locals 2

    .prologue
    .line 80
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "keyTutorialScreenDisplayed"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private startBarcodeScan(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 3
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 85
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 86
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x20000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 87
    const-string/jumbo v1, "MODULE_TYPE_IS_IMAGE_SEARCH"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 88
    const/4 v1, 0x4

    invoke-virtual {p1, v0, v1}, Lcom/amazon/mShop/AmazonActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 89
    return-void
.end method

.method private startBarcodeScanFirstTryTipScreenActivity(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 2
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 92
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 93
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x20000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 94
    const/4 v1, 0x5

    invoke-virtual {p1, v0, v1}, Lcom/amazon/mShop/AmazonActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 95
    return-void
.end method

.method private startFlow(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V
    .locals 3
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "clickStreamOrigin"    # Ljava/lang/String;

    .prologue
    .line 98
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 99
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x20000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 100
    const-string/jumbo v1, "MODULE_TYPE_IS_IMAGE_SEARCH"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 101
    const-string/jumbo v1, "clickStreamOrigin"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 102
    const/16 v1, 0x12

    invoke-virtual {p1, v0, v1}, Lcom/amazon/mShop/AmazonActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 103
    return-void
.end method

.method private startFlowTutorialActivity(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 2
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 106
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/search/viewit/ViewItTutorialActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 107
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x20000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 108
    const/16 v1, 0x13

    invoke-virtual {p1, v0, v1}, Lcom/amazon/mShop/AmazonActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 109
    return-void
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 38
    const/4 v0, 0x5

    if-ne p1, v0, :cond_0

    const/16 v0, 0x5a

    if-ne p2, v0, :cond_0

    .line 39
    invoke-direct {p0, p0}, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;->startBarcodeScan(Lcom/amazon/mShop/AmazonActivity;)V

    .line 46
    :goto_0
    return-void

    .line 40
    :cond_0
    const/16 v0, 0x13

    if-ne p1, v0, :cond_1

    const/4 v0, -0x1

    if-ne p2, v0, :cond_1

    .line 41
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string/jumbo v1, "clickStreamOrigin"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;->startFlow(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V

    goto :goto_0

    .line 43
    :cond_1
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;->setResult(ILandroid/content/Intent;)V

    .line 44
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;->finish()V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 26
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 27
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;->checkToStart(Landroid/content/Intent;)V

    .line 28
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 32
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;->setIntent(Landroid/content/Intent;)V

    .line 33
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItScanEntryActivity;->checkToStart(Landroid/content/Intent;)V

    .line 34
    return-void
.end method
