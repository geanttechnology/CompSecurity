.class Lcom/amazon/mShop/home/HomeView$1;
.super Lcom/amazon/mShop/mobileads/MobileAdsLayout$MobileAdsDefaultListener;
.source "HomeView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/HomeView;->loadAdForPromoSlot(Lcom/amazon/mShop/home/PromoSlotView;Landroid/widget/FrameLayout;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/home/HomeView;

.field final synthetic val$adsLayout:Landroid/widget/FrameLayout;

.field final synthetic val$promoLoading:Landroid/widget/ImageView;

.field final synthetic val$promoSlot:Lcom/amazon/mShop/home/PromoSlotView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/HomeView;Landroid/widget/FrameLayout;Lcom/amazon/mShop/home/PromoSlotView;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 316
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    iput-object p2, p0, Lcom/amazon/mShop/home/HomeView$1;->val$adsLayout:Landroid/widget/FrameLayout;

    iput-object p3, p0, Lcom/amazon/mShop/home/HomeView$1;->val$promoSlot:Lcom/amazon/mShop/home/PromoSlotView;

    iput-object p4, p0, Lcom/amazon/mShop/home/HomeView$1;->val$promoLoading:Landroid/widget/ImageView;

    invoke-direct {p0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout$MobileAdsDefaultListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onAdFailedToLoad(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdError;)V
    .locals 4
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;
    .param p2, "err"    # Lcom/amazon/device/ads/AdError;

    .prologue
    .line 320
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$1;->val$adsLayout:Landroid/widget/FrameLayout;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 321
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$1;->val$promoSlot:Lcom/amazon/mShop/home/PromoSlotView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/home/PromoSlotView;->setVisibility(I)V

    .line 326
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mLeftAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$000(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    move-result-object v2

    if-ne p1, v2, :cond_2

    .line 327
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$100(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/control/home/HomeController;->getPromoSlot0()Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    move-result-object v0

    .line 328
    .local v0, "promo0":Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    if-eqz v0, :cond_0

    .line 329
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage0:Lcom/amazon/mShop/home/PromoSlotView;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$300(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/PromoSlotView;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeView;->access$200(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Lcom/amazon/mShop/home/PromoSlotView;->update(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;Lcom/amazon/mShop/net/PageMetricsObserver;)V

    .line 331
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    sget-object v3, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->FAILURE:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    # setter for: Lcom/amazon/mShop/home/HomeView;->mLeftAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;
    invoke-static {v2, v3}, Lcom/amazon/mShop/home/HomeView;->access$402(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/mShop/home/HomeView$AdLoadingState;)Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    .line 344
    .end local v0    # "promo0":Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    :cond_1
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$200(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v2

    const-class v3, Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 345
    return-void

    .line 332
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mRightAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$500(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    move-result-object v2

    if-ne p1, v2, :cond_1

    .line 333
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$100(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/control/home/HomeController;->getPromoSlot1()Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    move-result-object v1

    .line 334
    .local v1, "promo1":Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    if-eqz v1, :cond_3

    .line 335
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage1:Lcom/amazon/mShop/home/PromoSlotView;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$600(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/PromoSlotView;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeView;->access$200(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v3

    invoke-virtual {v2, v1, v3}, Lcom/amazon/mShop/home/PromoSlotView;->update(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;Lcom/amazon/mShop/net/PageMetricsObserver;)V

    .line 337
    :cond_3
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    sget-object v3, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->FAILURE:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    # setter for: Lcom/amazon/mShop/home/HomeView;->mRightAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;
    invoke-static {v2, v3}, Lcom/amazon/mShop/home/HomeView;->access$702(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/mShop/home/HomeView$AdLoadingState;)Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    goto :goto_0
.end method

.method public onAdLoaded(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdProperties;)V
    .locals 2
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;
    .param p2, "prop"    # Lcom/amazon/device/ads/AdProperties;

    .prologue
    .line 350
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$1;->val$adsLayout:Landroid/widget/FrameLayout;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView$1;->val$promoLoading:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 351
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mLeftAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$000(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    move-result-object v0

    if-ne p1, v0, :cond_1

    .line 352
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    invoke-virtual {p2}, Lcom/amazon/device/ads/AdProperties;->getAdType()Lcom/amazon/device/ads/AdProperties$AdType;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/home/HomeView;->mLeftAdType:Lcom/amazon/device/ads/AdProperties$AdType;
    invoke-static {v0, v1}, Lcom/amazon/mShop/home/HomeView;->access$802(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/device/ads/AdProperties$AdType;)Lcom/amazon/device/ads/AdProperties$AdType;

    .line 353
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    sget-object v1, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->SUCCESS:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    # setter for: Lcom/amazon/mShop/home/HomeView;->mLeftAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;
    invoke-static {v0, v1}, Lcom/amazon/mShop/home/HomeView;->access$402(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/mShop/home/HomeView$AdLoadingState;)Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    .line 358
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$200(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v0

    const-class v1, Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 359
    return-void

    .line 354
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mRightAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$500(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    move-result-object v0

    if-ne p1, v0, :cond_0

    .line 355
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    invoke-virtual {p2}, Lcom/amazon/device/ads/AdProperties;->getAdType()Lcom/amazon/device/ads/AdProperties$AdType;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/home/HomeView;->mRightAdType:Lcom/amazon/device/ads/AdProperties$AdType;
    invoke-static {v0, v1}, Lcom/amazon/mShop/home/HomeView;->access$902(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/device/ads/AdProperties$AdType;)Lcom/amazon/device/ads/AdProperties$AdType;

    .line 356
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$1;->this$0:Lcom/amazon/mShop/home/HomeView;

    sget-object v1, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->SUCCESS:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    # setter for: Lcom/amazon/mShop/home/HomeView;->mRightAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;
    invoke-static {v0, v1}, Lcom/amazon/mShop/home/HomeView;->access$702(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/mShop/home/HomeView$AdLoadingState;)Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    goto :goto_0
.end method
