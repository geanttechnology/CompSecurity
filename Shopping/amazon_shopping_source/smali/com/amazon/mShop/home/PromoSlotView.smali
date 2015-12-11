.class public Lcom/amazon/mShop/home/PromoSlotView;
.super Landroid/widget/ImageView;
.source "PromoSlotView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;
    }
.end annotation


# instance fields
.field private mActionParam:Ljava/lang/String;

.field private mActionType:Ljava/lang/String;

.field private mDefaultImageRes:I

.field private mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mPromoSlotImage:Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

.field private mPromoSlotValue:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

.field private mRefMarker:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x1

    .line 53
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 59
    invoke-virtual {p0}, Lcom/amazon/mShop/home/PromoSlotView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->promo_loading:I

    move v3, v2

    move v4, v2

    move v5, v2

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/util/BitmapUtil;->loadImage(Landroid/content/res/Resources;IZZZZ)Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/PromoSlotView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 60
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/home/PromoSlotView;)Lcom/amazon/mShop/net/PageMetricsObserver;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/PromoSlotView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/home/PromoSlotView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/home/PromoSlotView;

    .prologue
    .line 44
    invoke-direct {p0}, Lcom/amazon/mShop/home/PromoSlotView;->showPromoSlot()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/home/PromoSlotView;)Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/PromoSlotView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView;->mPromoSlotValue:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/home/PromoSlotView;Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/home/PromoSlotView;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .prologue
    .line 44
    invoke-direct {p0, p1}, Lcom/amazon/mShop/home/PromoSlotView;->navigateToAction(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/mShop/home/PromoSlotView;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/PromoSlotView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView;->mRefMarker:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/home/PromoSlotView;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/PromoSlotView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView;->mActionType:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/mShop/home/PromoSlotView;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/PromoSlotView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView;->mActionParam:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/mShop/home/PromoSlotView;Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;I)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/home/PromoSlotView;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    .param p2, "x2"    # I

    .prologue
    .line 44
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/home/PromoSlotView;->setDefaultClickStreamOrigin(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;I)V

    return-void
.end method

.method private ignorePromoSlot(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)Z
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .prologue
    .line 122
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getAction()Lcom/amazon/rio/j2me/client/services/mShop/Action;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Action;->getType()I

    move-result v0

    const/16 v1, 0xb

    if-ne v0, v1, :cond_1

    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isMarketplaceSupportsNotification()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private navigateToAction(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V
    .locals 14
    .param p1, "promoSlot"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .prologue
    const/4 v8, 0x0

    .line 547
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getSlotToken()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 548
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getSlotToken()Ljava/lang/String;

    move-result-object v6

    .line 549
    .local v6, "promoSlotToken":Ljava/lang/String;
    invoke-static {v6}, Lcom/amazon/mShop/home/HomeView;->postClickedSlotToken(Ljava/lang/String;)V

    .line 552
    .end local v6    # "promoSlotToken":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getAction()Lcom/amazon/rio/j2me/client/services/mShop/Action;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/Action;->getType()I

    move-result v3

    .line 554
    .local v3, "index":I
    packed-switch v3, :pswitch_data_0

    .line 606
    :cond_1
    :goto_0
    :pswitch_0
    return-void

    .line 556
    :pswitch_1
    invoke-virtual {p0}, Lcom/amazon/mShop/home/PromoSlotView;->getContext()Landroid/content/Context;

    move-result-object v10

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v8, v11}, Lcom/amazon/mShop/util/ActivityUtils;->startDealsActivity(Landroid/content/Context;Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;Ljava/lang/String;)Z

    goto :goto_0

    .line 560
    :pswitch_2
    invoke-virtual {p0}, Lcom/amazon/mShop/home/PromoSlotView;->getContext()Landroid/content/Context;

    move-result-object v10

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v11

    const/4 v12, -0x1

    invoke-static {v10, v11, v8, v12}, Lcom/amazon/mShop/util/ActivityUtils;->startWishListActivity(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;I)Z

    goto :goto_0

    .line 564
    :pswitch_3
    iget-object v10, p0, Lcom/amazon/mShop/home/PromoSlotView;->mPromoSlotImage:Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

    if-eqz v10, :cond_1

    .line 567
    iget-object v10, p0, Lcom/amazon/mShop/home/PromoSlotView;->mPromoSlotImage:Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

    invoke-virtual {v10}, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->getThumbnail()Landroid/graphics/Bitmap;

    move-result-object v7

    .line 568
    .local v7, "thumbnail":Landroid/graphics/Bitmap;
    if-nez v7, :cond_2

    .line 569
    .local v8, "thumbnailData":[B
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/mShop/home/PromoSlotView;->getContext()Landroid/content/Context;

    move-result-object v10

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getProduct()Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    move-result-object v11

    new-instance v12, Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v12, v13}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    invoke-static {v10, v11, v12, v8}, Lcom/amazon/mShop/home/HomeView;->forwardProductDetailsView(Landroid/content/Context;Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;Lcom/amazon/mShop/control/item/ClickStreamTag;[B)V

    goto :goto_0

    .line 568
    .end local v8    # "thumbnailData":[B
    :cond_2
    invoke-static {v7}, Lcom/amazon/mShop/util/UIUtils;->convertBitmapToByteArray(Landroid/graphics/Bitmap;)[B

    move-result-object v8

    goto :goto_1

    .line 573
    .end local v7    # "thumbnail":Landroid/graphics/Bitmap;
    :pswitch_4
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getAction()Lcom/amazon/rio/j2me/client/services/mShop/Action;

    move-result-object v10

    if-eqz v10, :cond_1

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getAction()Lcom/amazon/rio/j2me/client/services/mShop/Action;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/Action;->getParams()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_1

    .line 574
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getAction()Lcom/amazon/rio/j2me/client/services/mShop/Action;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/Action;->getParams()Ljava/lang/String;

    move-result-object v9

    .line 575
    .local v9, "url":Ljava/lang/String;
    new-instance v10, Lcom/amazon/mShop/mash/nav/AmazonNavManager;

    invoke-direct {v10}, Lcom/amazon/mShop/mash/nav/AmazonNavManager;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/mShop/home/PromoSlotView;->getContext()Landroid/content/Context;

    move-result-object v11

    invoke-virtual {v10, v9, v11}, Lcom/amazon/mShop/mash/nav/AmazonNavManager;->navigate(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v10

    if-nez v10, :cond_1

    .line 576
    new-instance v5, Landroid/content/Intent;

    const-string/jumbo v10, "android.intent.action.VIEW"

    invoke-static {v9}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v11

    invoke-direct {v5, v10, v11}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 578
    .local v5, "intentUri":Landroid/content/Intent;
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/mShop/home/PromoSlotView;->getContext()Landroid/content/Context;

    move-result-object v10

    invoke-virtual {v10, v5}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 579
    :catch_0
    move-exception v10

    goto :goto_0

    .line 587
    .end local v5    # "intentUri":Landroid/content/Intent;
    .end local v9    # "url":Ljava/lang/String;
    :pswitch_5
    invoke-virtual {p0}, Lcom/amazon/mShop/home/PromoSlotView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 590
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    new-instance v1, Lcom/amazon/mShop/AmazonBrandedWebView;

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getAction()Lcom/amazon/rio/j2me/client/services/mShop/Action;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/Action;->getParams()Ljava/lang/String;

    move-result-object v10

    const-string/jumbo v11, ""

    const/4 v12, 0x1

    invoke-direct {v1, v0, v10, v11, v12}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 591
    .local v1, "amzWebView":Lcom/amazon/mShop/AmazonBrandedWebView;
    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    goto/16 :goto_0

    .line 595
    .end local v0    # "activity":Lcom/amazon/mShop/AmazonActivity;
    .end local v1    # "amzWebView":Lcom/amazon/mShop/AmazonBrandedWebView;
    :pswitch_6
    invoke-virtual {p0}, Lcom/amazon/mShop/home/PromoSlotView;->getContext()Landroid/content/Context;

    move-result-object v2

    .line 596
    .local v2, "context":Landroid/content/Context;
    new-instance v4, Landroid/content/Intent;

    const-class v10, Lcom/amazon/mShop/web/MShopWebActivity;

    invoke-direct {v4, v2, v10}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 597
    .local v4, "intentSmartEmbeddedUrl":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getAction()Lcom/amazon/rio/j2me/client/services/mShop/Action;

    move-result-object v11

    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/Action;->getParams()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v4, v10, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 598
    invoke-virtual {v2, v4}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 602
    .end local v2    # "context":Landroid/content/Context;
    .end local v4    # "intentSmartEmbeddedUrl":Landroid/content/Intent;
    :pswitch_7
    invoke-virtual {p0}, Lcom/amazon/mShop/home/PromoSlotView;->getContext()Landroid/content/Context;

    move-result-object v10

    invoke-static {v10, v8}, Lcom/amazon/mShop/util/ActivityUtils;->startNotificationSettingActivity(Landroid/content/Context;Ljava/lang/String;)Z

    goto/16 :goto_0

    .line 554
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_7
        :pswitch_6
    .end packed-switch
.end method

.method private setDefaultClickStreamOrigin(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;I)V
    .locals 4
    .param p1, "slot"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    .param p2, "actionType"    # I

    .prologue
    .line 533
    if-eqz p1, :cond_0

    if-ltz p2, :cond_0

    sget-object v1, Lcom/amazon/mShop/home/HomeView;->ACTION_NAME_DICTIONARY:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->size()I

    move-result v1

    if-ge p2, v1, :cond_0

    .line 534
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/mShop/home/PromoSlotView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->home_promo_clickstream_prefix:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v1, Lcom/amazon/mShop/home/HomeView;->ACTION_NAME_DICTIONARY:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 536
    .local v0, "defaultClickStreamOrigin":Ljava/lang/String;
    invoke-virtual {p1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->setClickStreamOrigin(Ljava/lang/String;)V

    .line 538
    .end local v0    # "defaultClickStreamOrigin":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private showPromoSlot()V
    .locals 1

    .prologue
    .line 483
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView;->mPromoSlotImage:Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/PromoSlotView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 484
    return-void
.end method


# virtual methods
.method public clear()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 63
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/PromoSlotView;->setFocusable(Z)V

    .line 64
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/PromoSlotView;->setClickable(Z)V

    .line 65
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView;->mPromoSlotImage:Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

    if-eqz v0, :cond_0

    .line 66
    iget-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView;->mPromoSlotImage:Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

    invoke-virtual {v0}, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;->cancel()V

    .line 67
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/home/PromoSlotView;->mPromoSlotImage:Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

    .line 69
    :cond_0
    return-void
.end method

.method public setDefaultPromoSlot()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 487
    iget v0, p0, Lcom/amazon/mShop/home/PromoSlotView;->mDefaultImageRes:I

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/BitmapUtil;->setImageResource(Landroid/widget/ImageView;I)V

    .line 488
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/home/PromoSlotView;->setFocusable(Z)V

    .line 489
    sget v0, Lcom/amazon/mShop/android/lib/R$color;->gallery_image_selector:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/PromoSlotView;->setBackgroundResource(I)V

    .line 490
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/home/PromoSlotView;->setClickable(Z)V

    .line 491
    new-instance v0, Lcom/amazon/mShop/home/PromoSlotView$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/home/PromoSlotView$1;-><init>(Lcom/amazon/mShop/home/PromoSlotView;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/PromoSlotView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 524
    return-void
.end method

.method public setDefaultPromoSlotInfo(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "defaultImageRes"    # I
    .param p2, "actionType"    # Ljava/lang/String;
    .param p3, "actionParam"    # Ljava/lang/String;
    .param p4, "refMarker"    # Ljava/lang/String;

    .prologue
    .line 476
    iput p1, p0, Lcom/amazon/mShop/home/PromoSlotView;->mDefaultImageRes:I

    .line 477
    iput-object p2, p0, Lcom/amazon/mShop/home/PromoSlotView;->mActionType:Ljava/lang/String;

    .line 478
    iput-object p3, p0, Lcom/amazon/mShop/home/PromoSlotView;->mActionParam:Ljava/lang/String;

    .line 479
    iput-object p4, p0, Lcom/amazon/mShop/home/PromoSlotView;->mRefMarker:Ljava/lang/String;

    .line 480
    return-void
.end method

.method public update(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;Lcom/amazon/mShop/net/PageMetricsObserver;)V
    .locals 17
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    .param p2, "pageMetricsObserver"    # Lcom/amazon/mShop/net/PageMetricsObserver;

    .prologue
    .line 74
    move-object/from16 v0, p2

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/home/PromoSlotView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 75
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/home/PromoSlotView;->mPromoSlotValue:Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .line 76
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getProduct()Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    move-result-object v16

    .line 77
    .local v16, "homeItem":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    const/4 v11, 0x0

    .line 80
    .local v11, "imageUrl":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 81
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getAction()Lcom/amazon/rio/j2me/client/services/mShop/Action;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/Action;->getType()I

    move-result v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/home/PromoSlotView;->setDefaultClickStreamOrigin(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;I)V

    .line 84
    :cond_0
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getImageUrl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 85
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getImageUrl()Ljava/lang/String;

    move-result-object v11

    .line 93
    :cond_1
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/home/HomeView;->getPromoSlotHeight()I

    move-result v2

    int-to-float v6, v2

    .line 94
    .local v6, "promoSlotHeight":F
    invoke-static {}, Lcom/amazon/mShop/home/HomeView;->getPromoSlotWidth()I

    move-result v2

    int-to-float v7, v2

    .line 96
    .local v7, "promoSlotWidth":F
    invoke-static {v11}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    invoke-direct/range {p0 .. p1}, Lcom/amazon/mShop/home/PromoSlotView;->ignorePromoSlot(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 97
    :cond_2
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/home/PromoSlotView;->setDefaultPromoSlot()V

    .line 114
    :goto_1
    return-void

    .line 86
    .end local v6    # "promoSlotHeight":F
    .end local v7    # "promoSlotWidth":F
    :cond_3
    if-eqz v16, :cond_4

    invoke-virtual/range {v16 .. v16}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getImageUrl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 87
    invoke-virtual/range {v16 .. v16}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getImageUrl()Ljava/lang/String;

    move-result-object v11

    goto :goto_0

    .line 88
    :cond_4
    if-eqz v16, :cond_1

    invoke-virtual/range {v16 .. v16}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual/range {v16 .. v16}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 89
    invoke-virtual/range {v16 .. v16}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v11

    goto :goto_0

    .line 99
    .restart local v6    # "promoSlotHeight":F
    .restart local v7    # "promoSlotWidth":F
    :cond_5
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getImageUrl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_6

    .line 100
    new-instance v2, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/home/PromoSlotView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getImageUrl()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v3, p0

    invoke-direct/range {v2 .. v7}, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;-><init>(Lcom/amazon/mShop/home/PromoSlotView;Landroid/content/res/Resources;Ljava/lang/String;FF)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/amazon/mShop/home/PromoSlotView;->mPromoSlotImage:Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

    goto :goto_1

    .line 105
    :cond_6
    new-instance v8, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/home/PromoSlotView;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->getProductHeader()Ljava/lang/String;

    move-result-object v12

    invoke-virtual/range {v16 .. v16}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getTitle()Ljava/lang/String;

    move-result-object v13

    move-object/from16 v9, p0

    move v14, v6

    move v15, v7

    invoke-direct/range {v8 .. v15}, Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;-><init>(Lcom/amazon/mShop/home/PromoSlotView;Landroid/content/res/Resources;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FF)V

    move-object/from16 v0, p0

    iput-object v8, v0, Lcom/amazon/mShop/home/PromoSlotView;->mPromoSlotImage:Lcom/amazon/mShop/home/PromoSlotView$PromoSlotImage;

    goto :goto_1
.end method
