.class Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;
.super Ljava/lang/Object;
.source "MobileAdsLayout.java"

# interfaces
.implements Lcom/amazon/device/ads/AmazonOOAdListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mobileads/MobileAdsLayout;->load(Lcom/amazon/device/ads/AmazonOOAdListener;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

.field final synthetic val$adListener:Lcom/amazon/device/ads/AmazonOOAdListener;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mobileads/MobileAdsLayout;Lcom/amazon/device/ads/AmazonOOAdListener;)V
    .locals 0

    .prologue
    .line 143
    iput-object p1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->this$0:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    iput-object p2, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->val$adListener:Lcom/amazon/device/ads/AmazonOOAdListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAdCollapsed(Lcom/amazon/device/ads/Ad;)V
    .locals 1
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->val$adListener:Lcom/amazon/device/ads/AmazonOOAdListener;

    if-eqz v0, :cond_0

    .line 148
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->val$adListener:Lcom/amazon/device/ads/AmazonOOAdListener;

    invoke-interface {v0, p1}, Lcom/amazon/device/ads/AmazonOOAdListener;->onAdCollapsed(Lcom/amazon/device/ads/Ad;)V

    .line 151
    :cond_0
    return-void
.end method

.method public onAdDismissed(Lcom/amazon/device/ads/Ad;)V
    .locals 1
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;

    .prologue
    .line 155
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->val$adListener:Lcom/amazon/device/ads/AmazonOOAdListener;

    if-eqz v0, :cond_0

    .line 156
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->val$adListener:Lcom/amazon/device/ads/AmazonOOAdListener;

    invoke-interface {v0, p1}, Lcom/amazon/device/ads/AmazonOOAdListener;->onAdDismissed(Lcom/amazon/device/ads/Ad;)V

    .line 158
    :cond_0
    return-void
.end method

.method public onAdExpanded(Lcom/amazon/device/ads/Ad;)V
    .locals 1
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;

    .prologue
    .line 162
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->val$adListener:Lcom/amazon/device/ads/AmazonOOAdListener;

    if-eqz v0, :cond_0

    .line 163
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->val$adListener:Lcom/amazon/device/ads/AmazonOOAdListener;

    invoke-interface {v0, p1}, Lcom/amazon/device/ads/AmazonOOAdListener;->onAdExpanded(Lcom/amazon/device/ads/Ad;)V

    .line 165
    :cond_0
    return-void
.end method

.method public onAdFailedToLoad(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdError;)V
    .locals 2
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;
    .param p2, "error"    # Lcom/amazon/device/ads/AdError;

    .prologue
    .line 169
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->val$adListener:Lcom/amazon/device/ads/AmazonOOAdListener;

    if-eqz v0, :cond_0

    .line 170
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->val$adListener:Lcom/amazon/device/ads/AmazonOOAdListener;

    invoke-interface {v0, p1, p2}, Lcom/amazon/device/ads/AmazonOOAdListener;->onAdFailedToLoad(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdError;)V

    .line 173
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->this$0:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    iget-object v1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->this$0:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    # getter for: Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForFailure:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v1}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->access$100(Lcom/amazon/mShop/mobileads/MobileAdsLayout;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v1

    # invokes: Lcom/amazon/mShop/mobileads/MobileAdsLayout;->completeMetrics(Lcom/amazon/mShop/net/PageMetricsObserver;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->access$200(Lcom/amazon/mShop/mobileads/MobileAdsLayout;Lcom/amazon/mShop/net/PageMetricsObserver;)V

    .line 174
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->this$0:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    iget-object v1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->this$0:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    # getter for: Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForSuccess:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v1}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->access$300(Lcom/amazon/mShop/mobileads/MobileAdsLayout;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v1

    # invokes: Lcom/amazon/mShop/mobileads/MobileAdsLayout;->cancelMetrics(Lcom/amazon/mShop/net/PageMetricsObserver;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->access$400(Lcom/amazon/mShop/mobileads/MobileAdsLayout;Lcom/amazon/mShop/net/PageMetricsObserver;)V

    .line 175
    return-void
.end method

.method public onAdLoaded(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdProperties;)V
    .locals 2
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;
    .param p2, "prop"    # Lcom/amazon/device/ads/AdProperties;

    .prologue
    .line 179
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->val$adListener:Lcom/amazon/device/ads/AmazonOOAdListener;

    if-eqz v0, :cond_0

    .line 180
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->val$adListener:Lcom/amazon/device/ads/AmazonOOAdListener;

    invoke-interface {v0, p1, p2}, Lcom/amazon/device/ads/AmazonOOAdListener;->onAdLoaded(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdProperties;)V

    .line 183
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->this$0:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    iget-object v1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->this$0:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    # getter for: Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForSuccess:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v1}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->access$300(Lcom/amazon/mShop/mobileads/MobileAdsLayout;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v1

    # invokes: Lcom/amazon/mShop/mobileads/MobileAdsLayout;->completeMetrics(Lcom/amazon/mShop/net/PageMetricsObserver;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->access$200(Lcom/amazon/mShop/mobileads/MobileAdsLayout;Lcom/amazon/mShop/net/PageMetricsObserver;)V

    .line 184
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->this$0:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    iget-object v1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->this$0:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    # getter for: Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForFailure:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v1}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->access$100(Lcom/amazon/mShop/mobileads/MobileAdsLayout;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v1

    # invokes: Lcom/amazon/mShop/mobileads/MobileAdsLayout;->cancelMetrics(Lcom/amazon/mShop/net/PageMetricsObserver;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->access$400(Lcom/amazon/mShop/mobileads/MobileAdsLayout;Lcom/amazon/mShop/net/PageMetricsObserver;)V

    .line 185
    return-void
.end method

.method public onAdReceived(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AmazonOOAdResponse;)Lcom/amazon/device/ads/AmazonOOActionCode;
    .locals 1
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;
    .param p2, "adRes"    # Lcom/amazon/device/ads/AmazonOOAdResponse;

    .prologue
    .line 190
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->val$adListener:Lcom/amazon/device/ads/AmazonOOAdListener;

    if-eqz v0, :cond_0

    .line 191
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->val$adListener:Lcom/amazon/device/ads/AmazonOOAdListener;

    invoke-interface {v0, p1, p2}, Lcom/amazon/device/ads/AmazonOOAdListener;->onAdReceived(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AmazonOOAdResponse;)Lcom/amazon/device/ads/AmazonOOActionCode;

    move-result-object v0

    .line 193
    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/amazon/device/ads/AmazonOOActionCode;->DISPLAY:Lcom/amazon/device/ads/AmazonOOActionCode;

    goto :goto_0
.end method

.method public onSpecialUrlClicked(Lcom/amazon/device/ads/Ad;Ljava/lang/String;)V
    .locals 6
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 199
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 200
    .local v2, "uri":Landroid/net/Uri;
    invoke-virtual {v2}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    .line 201
    .local v1, "scheme":Ljava/lang/String;
    const-string/jumbo v3, "amazonmobile"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 202
    invoke-virtual {v2}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v0

    .line 203
    .local v0, "authority":Ljava/lang/String;
    const-string/jumbo v3, "shopping"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 204
    const-string/jumbo v3, "clickstream-tag"

    invoke-virtual {v2, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 205
    invoke-virtual {v2}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v3

    const-string/jumbo v4, "clickstream-tag"

    sget-object v5, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_MOBILEADS:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v5}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    .line 210
    :cond_0
    new-instance v3, Lcom/amazon/mShop/mash/nav/AmazonNavManager;

    invoke-direct {v3}, Lcom/amazon/mShop/mash/nav/AmazonNavManager;-><init>()V

    iget-object v4, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;->this$0:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    invoke-virtual {v4}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v3, p2, v4}, Lcom/amazon/mShop/mash/nav/AmazonNavManager;->navigate(Ljava/lang/String;Landroid/content/Context;)Z

    .line 214
    .end local v0    # "authority":Ljava/lang/String;
    :cond_1
    return-void
.end method
