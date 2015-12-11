.class public Lcom/aio/downloader/activity/ChapingActivity;
.super Landroid/app/Activity;
.source "ChapingActivity.java"

# interfaces
.implements Lcom/facebook/ads/InterstitialAdListener;


# instance fields
.field private interstitialAd:Lcom/facebook/ads/InterstitialAd;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method private loadInterstitialAd()V
    .locals 2

    .prologue
    .line 37
    new-instance v0, Lcom/facebook/ads/InterstitialAd;

    .line 38
    const-string v1, "340186902832477_401798000004700"

    invoke-direct {v0, p0, v1}, Lcom/facebook/ads/InterstitialAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 37
    iput-object v0, p0, Lcom/aio/downloader/activity/ChapingActivity;->interstitialAd:Lcom/facebook/ads/InterstitialAd;

    .line 39
    iget-object v0, p0, Lcom/aio/downloader/activity/ChapingActivity;->interstitialAd:Lcom/facebook/ads/InterstitialAd;

    invoke-virtual {v0, p0}, Lcom/facebook/ads/InterstitialAd;->setAdListener(Lcom/facebook/ads/InterstitialAdListener;)V

    .line 41
    iget-object v0, p0, Lcom/aio/downloader/activity/ChapingActivity;->interstitialAd:Lcom/facebook/ads/InterstitialAd;

    invoke-virtual {v0}, Lcom/facebook/ads/InterstitialAd;->loadAd()V

    .line 43
    return-void
.end method


# virtual methods
.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 2
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 49
    const-string v0, "www"

    const-string v1, "onAdClicked"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 50
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/aio/downloader/activity/ChapingActivity;->interstitialAd:Lcom/facebook/ads/InterstitialAd;

    invoke-virtual {v0}, Lcom/facebook/ads/InterstitialAd;->show()Z

    .line 56
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 22
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 23
    const v1, 0x7f030022

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/ChapingActivity;->setContentView(I)V

    .line 24
    const v1, 0x7f070135

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/ChapingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 25
    .local v0, "ll_ad":Landroid/widget/LinearLayout;
    new-instance v1, Lcom/aio/downloader/activity/ChapingActivity$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/ChapingActivity$1;-><init>(Lcom/aio/downloader/activity/ChapingActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 33
    invoke-direct {p0}, Lcom/aio/downloader/activity/ChapingActivity;->loadInterstitialAd()V

    .line 34
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 61
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ChapingActivity;->finish()V

    .line 62
    return-void
.end method

.method public onInterstitialDismissed(Lcom/facebook/ads/Ad;)V
    .locals 2
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 67
    const-string v0, "www"

    const-string v1, "onInterstitialDismissed"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 68
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ChapingActivity;->finish()V

    .line 69
    return-void
.end method

.method public onInterstitialDisplayed(Lcom/facebook/ads/Ad;)V
    .locals 2
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 74
    const-string v0, "www"

    const-string v1, "onInterstitialDisplayed"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 75
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 79
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method
