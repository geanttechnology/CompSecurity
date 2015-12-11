.class public Lcom/amazon/mShop/home/HomeView;
.super Landroid/widget/LinearLayout;
.source "HomeView.java"

# interfaces
.implements Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;
.implements Lcom/amazon/mShop/DelayedInitView;
.implements Lcom/amazon/mShop/actionBar/ActionBarIconController;
.implements Lcom/amazon/mShop/control/home/HomeSubscriber;
.implements Lcom/amazon/mShop/model/auth/UserListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/home/HomeView$AdLoadingState;
    }
.end annotation


# static fields
.field public static final ACTION_NAME_DICTIONARY:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final ACTION_TYPE_DICTIONARY:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mActivity:Lcom/amazon/mShop/home/GatewayActivity;

.field private mAdSize:Lcom/amazon/device/ads/AdSize;

.field private mApplicationStarted:Z

.field private mBmpLoading:Landroid/graphics/Bitmap;

.field private mCurrentOrientation:I

.field private mHomeBottomBanner:Landroid/view/View;

.field private mHomeController:Lcom/amazon/mShop/control/home/HomeController;

.field private mHomeStrenchFrame:Landroid/view/View;

.field private mIsHomeViewJustCreated:Z

.field private mLeftAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

.field private mLeftAdLayout:Landroid/widget/FrameLayout;

.field private mLeftAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

.field private mLeftAdType:Lcom/amazon/device/ads/AdProperties$AdType;

.field private mLoginLeftMessage:Landroid/widget/TextView;

.field private mLoginOrYourAccountButton:Landroid/view/View;

.field private mLoginRightMessage:Landroid/widget/TextView;

.field private mNeedInvokeHomeCallStarted:Z

.field private mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mPromoSlotImage0:Lcom/amazon/mShop/home/PromoSlotView;

.field private mPromoSlotImage1:Lcom/amazon/mShop/home/PromoSlotView;

.field private mRightAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

.field private mRightAdLayout:Landroid/widget/FrameLayout;

.field private mRightAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

.field private mRightAdType:Lcom/amazon/device/ads/AdProperties$AdType;

.field private mShopByDepartmentLabel:Landroid/widget/TextView;

.field private mShoveler0:Lcom/amazon/mShop/home/HomeShovelerView;

.field private mShoveler1:Lcom/amazon/mShop/home/HomeShovelerView;

.field private mShovelerEmptyPlaceHolder:Landroid/widget/ImageView;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x5

    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x0

    .line 711
    new-instance v0, Ljava/util/HashMap;

    const/16 v1, 0xb

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_TYPE_DICTIONARY:Ljava/util/Map;

    .line 713
    new-instance v0, Ljava/util/HashMap;

    const/16 v1, 0xb

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_NAME_DICTIONARY:Ljava/util/Map;

    .line 728
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_TYPE_DICTIONARY:Ljava/util/Map;

    const-string/jumbo v1, "do_nothing"

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 729
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_TYPE_DICTIONARY:Ljava/util/Map;

    const-string/jumbo v1, "deals"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 730
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_TYPE_DICTIONARY:Ljava/util/Map;

    const-string/jumbo v1, "wishlist"

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 731
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_TYPE_DICTIONARY:Ljava/util/Map;

    const-string/jumbo v1, "product"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 732
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_TYPE_DICTIONARY:Ljava/util/Map;

    const-string/jumbo v1, "open_url"

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 733
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_TYPE_DICTIONARY:Ljava/util/Map;

    const-string/jumbo v1, "embed_url"

    const/4 v2, 0x6

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 734
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_TYPE_DICTIONARY:Ljava/util/Map;

    const-string/jumbo v1, "cart"

    const/4 v2, 0x7

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 735
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_TYPE_DICTIONARY:Ljava/util/Map;

    const-string/jumbo v1, "saved_for_later"

    const/16 v2, 0x8

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 736
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_TYPE_DICTIONARY:Ljava/util/Map;

    const-string/jumbo v1, "track_package"

    const/16 v2, 0x9

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 737
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_TYPE_DICTIONARY:Ljava/util/Map;

    const-string/jumbo v1, "your_account"

    const/16 v2, 0xa

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 739
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_NAME_DICTIONARY:Ljava/util/Map;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "do_nothing"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 740
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_NAME_DICTIONARY:Ljava/util/Map;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "deals"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 741
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_NAME_DICTIONARY:Ljava/util/Map;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "wishlist"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 742
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_NAME_DICTIONARY:Ljava/util/Map;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "product"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 743
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_NAME_DICTIONARY:Ljava/util/Map;

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "open_url"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 744
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_NAME_DICTIONARY:Ljava/util/Map;

    const/4 v1, 0x6

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "embed_url"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 745
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_NAME_DICTIONARY:Ljava/util/Map;

    const/4 v1, 0x7

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "cart"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 746
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_NAME_DICTIONARY:Ljava/util/Map;

    const/16 v1, 0x8

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "saved_for_later"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 747
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_NAME_DICTIONARY:Ljava/util/Map;

    const/16 v1, 0x9

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "track_package"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 748
    sget-object v0, Lcom/amazon/mShop/home/HomeView;->ACTION_NAME_DICTIONARY:Ljava/util/Map;

    const/16 v1, 0xa

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "your_account"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 749
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x1

    .line 135
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 117
    invoke-static {}, Lcom/amazon/mShop/control/home/HomeController;->getInstance()Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    .line 129
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mBmpLoading:Landroid/graphics/Bitmap;

    .line 132
    iput-boolean v1, p0, Lcom/amazon/mShop/home/HomeView;->mNeedInvokeHomeCallStarted:Z

    .line 453
    iput-boolean v1, p0, Lcom/amazon/mShop/home/HomeView;->mApplicationStarted:Z

    .line 136
    check-cast p1, Lcom/amazon/mShop/home/GatewayActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;

    .line 137
    iput-boolean v1, p0, Lcom/amazon/mShop/home/HomeView;->mIsHomeViewJustCreated:Z

    .line 142
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/control/home/HomeController;->addSubscriberAtFirstPosition(Lcom/amazon/mShop/control/home/HomeSubscriber;)V

    .line 143
    new-instance v0, Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "Home"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 144
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 145
    new-instance v0, Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "HomeCriticalFeature"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 146
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 147
    new-instance v0, Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v1, "HomeRefreshCriticalFeature"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 148
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 149
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/mobileads/MobileAdsLayout;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/control/home/HomeController;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/amazon/mShop/home/HomeView;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-boolean v0, p0, Lcom/amazon/mShop/home/HomeView;->mIsHomeViewJustCreated:Z

    return v0
.end method

.method static synthetic access$1100(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/net/PageMetricsObserver;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    return-object v0
.end method

.method static synthetic access$1102(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/mShop/net/PageMetricsObserver;)Lcom/amazon/mShop/net/PageMetricsObserver;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;
    .param p1, "x1"    # Lcom/amazon/mShop/net/PageMetricsObserver;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    return-object p1
.end method

.method static synthetic access$1200(Lcom/amazon/mShop/home/HomeView;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-boolean v0, p0, Lcom/amazon/mShop/home/HomeView;->mNeedInvokeHomeCallStarted:Z

    return v0
.end method

.method static synthetic access$1202(Lcom/amazon/mShop/home/HomeView;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;
    .param p1, "x1"    # Z

    .prologue
    .line 89
    iput-boolean p1, p0, Lcom/amazon/mShop/home/HomeView;->mNeedInvokeHomeCallStarted:Z

    return p1
.end method

.method static synthetic access$1300(Lcom/amazon/mShop/home/HomeView;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-boolean v0, p0, Lcom/amazon/mShop/home/HomeView;->mApplicationStarted:Z

    return v0
.end method

.method static synthetic access$1302(Lcom/amazon/mShop/home/HomeView;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;
    .param p1, "x1"    # Z

    .prologue
    .line 89
    iput-boolean p1, p0, Lcom/amazon/mShop/home/HomeView;->mApplicationStarted:Z

    return p1
.end method

.method static synthetic access$1400(Lcom/amazon/mShop/home/HomeView;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;
    .param p1, "x1"    # Z

    .prologue
    .line 89
    invoke-direct {p0, p1}, Lcom/amazon/mShop/home/HomeView;->addWeblabCsmMetrics(Z)V

    return-void
.end method

.method static synthetic access$1500(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/GatewayActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;

    return-object v0
.end method

.method static synthetic access$1600(Lcom/amazon/mShop/home/HomeView;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShovelerEmptyPlaceHolder:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$1700(Lcom/amazon/mShop/home/HomeView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeBottomBanner:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1800(Lcom/amazon/mShop/home/HomeView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeStrenchFrame:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1900(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/HomeShovelerView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler0:Lcom/amazon/mShop/home/HomeShovelerView;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/net/PageMetricsObserver;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    return-object v0
.end method

.method static synthetic access$2000(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/HomeShovelerView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler1:Lcom/amazon/mShop/home/HomeShovelerView;

    return-object v0
.end method

.method static synthetic access$2100(Lcom/amazon/mShop/home/HomeView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeView;->loadAds()V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/PromoSlotView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage0:Lcom/amazon/mShop/home/PromoSlotView;

    return-object v0
.end method

.method static synthetic access$402(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/mShop/home/HomeView$AdLoadingState;)Lcom/amazon/mShop/home/HomeView$AdLoadingState;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;
    .param p1, "x1"    # Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    return-object p1
.end method

.method static synthetic access$500(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/mobileads/MobileAdsLayout;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mRightAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/PromoSlotView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage1:Lcom/amazon/mShop/home/PromoSlotView;

    return-object v0
.end method

.method static synthetic access$702(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/mShop/home/HomeView$AdLoadingState;)Lcom/amazon/mShop/home/HomeView$AdLoadingState;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;
    .param p1, "x1"    # Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeView;->mRightAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    return-object p1
.end method

.method static synthetic access$802(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/device/ads/AdProperties$AdType;)Lcom/amazon/device/ads/AdProperties$AdType;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;
    .param p1, "x1"    # Lcom/amazon/device/ads/AdProperties$AdType;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAdType:Lcom/amazon/device/ads/AdProperties$AdType;

    return-object p1
.end method

.method static synthetic access$902(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/device/ads/AdProperties$AdType;)Lcom/amazon/device/ads/AdProperties$AdType;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/home/HomeView;
    .param p1, "x1"    # Lcom/amazon/device/ads/AdProperties$AdType;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeView;->mRightAdType:Lcom/amazon/device/ads/AdProperties$AdType;

    return-object p1
.end method

.method private addWeblabCsmMetrics(Z)V
    .locals 7
    .param p1, "phoneHomeInvoked"    # Z

    .prologue
    .line 1173
    if-eqz p1, :cond_0

    const-string/jumbo v0, "debugHTMLGateway"

    invoke-static {v0}, Lcom/amazon/mShop/util/ActivityUtils;->isDebugSettingEnabled(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1177
    iget-object v6, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    new-instance v0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/home/HomeController;->getRequestId()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "GatewayMShop"

    const-string/jumbo v3, "pageComponent"

    const-string/jumbo v4, "Android_ShopAppHTMLGateway"

    const-string/jumbo v5, "cf"

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v6, v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->setEventListener(Lcom/amazon/mShop/net/PageMetricsEventListener;)V

    .line 1184
    :cond_0
    return-void
.end method

.method public static forwardProductDetailsView(Landroid/content/Context;Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;Lcom/amazon/mShop/control/item/ClickStreamTag;[B)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "item"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    .param p2, "clickStreamTag"    # Lcom/amazon/mShop/control/item/ClickStreamTag;
    .param p3, "thumbnail"    # [B

    .prologue
    .line 631
    if-nez p1, :cond_1

    .line 650
    .end local p0    # "context":Landroid/content/Context;
    :cond_0
    :goto_0
    return-void

    .line 634
    .restart local p0    # "context":Landroid/content/Context;
    :cond_1
    if-eqz p0, :cond_0

    .line 635
    instance-of v1, p0, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v1, :cond_0

    .line 636
    new-instance v0, Lcom/amazon/mShop/control/item/ProductController;

    invoke-direct {v0, p1}, Lcom/amazon/mShop/control/item/ProductController;-><init>(Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;)V

    .line 638
    .local v0, "productController":Lcom/amazon/mShop/control/item/ProductController;
    invoke-static {p3}, Lcom/amazon/mShop/util/Util;->isEmpty([B)Z

    move-result v1

    if-nez v1, :cond_2

    .line 639
    invoke-virtual {v0, p3}, Lcom/amazon/mShop/control/item/ProductController;->setThumbnail([B)V

    .line 642
    :cond_2
    if-eqz p2, :cond_3

    invoke-virtual {p2}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 643
    invoke-virtual {v0, p2}, Lcom/amazon/mShop/control/item/ProductController;->setClickStreamTag(Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    .line 646
    :cond_3
    check-cast p0, Lcom/amazon/mShop/AmazonActivity;

    .end local p0    # "context":Landroid/content/Context;
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/AmazonActivity;->forward(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private getAdSize()Lcom/amazon/device/ads/AdSize;
    .locals 4

    .prologue
    .line 226
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView;->mAdSize:Lcom/amazon/device/ads/AdSize;

    if-nez v2, :cond_0

    .line 227
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$integer;->config_HomePromoAdSizeWidth:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    .line 228
    .local v1, "width":I
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$integer;->config_HomePromoAdSizeHeight:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    .line 229
    .local v0, "height":I
    new-instance v2, Lcom/amazon/device/ads/AdSize;

    invoke-direct {v2, v1, v0}, Lcom/amazon/device/ads/AdSize;-><init>(II)V

    iput-object v2, p0, Lcom/amazon/mShop/home/HomeView;->mAdSize:Lcom/amazon/device/ads/AdSize;

    .line 231
    .end local v0    # "height":I
    .end local v1    # "width":I
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView;->mAdSize:Lcom/amazon/device/ads/AdSize;

    return-object v2
.end method

.method private getBmpLoading()Landroid/graphics/Bitmap;
    .locals 7

    .prologue
    .line 1111
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mBmpLoading:Landroid/graphics/Bitmap;

    if-nez v0, :cond_0

    .line 1113
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->promo_loading:I

    const/4 v2, 0x1

    const/4 v3, 0x1

    const/4 v4, 0x1

    const/4 v5, 0x1

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/util/BitmapUtil;->loadImage(Landroid/content/res/Resources;IZZZZ)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mBmpLoading:Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    .line 1118
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mBmpLoading:Landroid/graphics/Bitmap;

    return-object v0

    .line 1114
    :catch_0
    move-exception v6

    .line 1115
    .local v6, "oome":Ljava/lang/OutOfMemoryError;
    invoke-static {}, Ljava/lang/System;->gc()V

    goto :goto_0
.end method

.method private getCurrentOrientation()I
    .locals 1

    .prologue
    .line 509
    iget v0, p0, Lcom/amazon/mShop/home/HomeView;->mCurrentOrientation:I

    return v0
.end method

.method public static getPromoSlotHeight()I
    .locals 3

    .prologue
    .line 1083
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 1084
    .local v0, "context":Landroid/content/Context;
    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 1085
    .local v1, "res":Landroid/content/res/Resources;
    sget v2, Lcom/amazon/mShop/android/lib/R$dimen;->home_promo_slot_image_view_height:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    return v2
.end method

.method public static getPromoSlotWidth()I
    .locals 6

    .prologue
    .line 1096
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/content/Context;

    .line 1097
    .local v2, "context":Landroid/content/Context;
    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    .line 1098
    .local v4, "res":Landroid/content/res/Resources;
    sget v5, Lcom/amazon/mShop/android/lib/R$integer;->config_HomePromoAspectRatioWidth:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    .line 1099
    .local v1, "aspectRationWidth":I
    sget v5, Lcom/amazon/mShop/android/lib/R$integer;->config_HomePromoAspectRatioHeight:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    .line 1100
    .local v0, "aspectRationHeight":I
    invoke-static {}, Lcom/amazon/mShop/home/HomeView;->getPromoSlotHeight()I

    move-result v3

    .line 1101
    .local v3, "h":I
    mul-int v5, v3, v1

    div-int/2addr v5, v0

    return v5
.end method

.method private handlerError(Ljava/lang/Exception;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 854
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->onCancelled()V

    .line 855
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/home/HomeController;->clearException()V

    .line 856
    new-instance v0, Lcom/amazon/mShop/home/HomeView$7;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/home/HomeView$7;-><init>(Lcom/amazon/mShop/home/HomeView;)V

    .line 868
    .local v0, "listener":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;

    invoke-static {v1, v0, p0, p1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;)V

    .line 869
    return-void
.end method

.method private initAdState()V
    .locals 1

    .prologue
    .line 239
    sget-object v0, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->INIT:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    .line 240
    sget-object v0, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->INIT:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mRightAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    .line 241
    return-void
.end method

.method private loadAdForPromoSlot(Lcom/amazon/mShop/home/PromoSlotView;Landroid/widget/FrameLayout;)V
    .locals 12
    .param p1, "promoSlot"    # Lcom/amazon/mShop/home/PromoSlotView;
    .param p2, "adsLayout"    # Landroid/widget/FrameLayout;

    .prologue
    const/4 v11, 0x0

    .line 272
    invoke-virtual {p2, v11}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 273
    invoke-virtual {p2}, Landroid/widget/FrameLayout;->removeAllViews()V

    .line 274
    const/16 v8, 0x8

    invoke-virtual {p1, v8}, Lcom/amazon/mShop/home/PromoSlotView;->setVisibility(I)V

    .line 275
    invoke-static {}, Lcom/amazon/mShop/home/HomeView;->getPromoSlotHeight()I

    move-result v5

    .line 276
    .local v5, "promoHeight":I
    invoke-static {}, Lcom/amazon/mShop/home/HomeView;->getPromoSlotWidth()I

    move-result v7

    .line 285
    .local v7, "promoWidth":I
    new-instance v6, Landroid/widget/ImageView;

    iget-object v8, p0, Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;

    invoke-direct {v6, v8}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 286
    .local v6, "promoLoading":Landroid/widget/ImageView;
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v9, -0x1

    const/high16 v10, 0x41880000    # 17.0f

    invoke-direct {v8, v9, v5, v10}, Landroid/widget/LinearLayout$LayoutParams;-><init>(IIF)V

    invoke-virtual {v6, v8}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 287
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$dimen;->promo_loading_padding:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    .line 288
    .local v4, "padding":I
    invoke-virtual {v6, v11, v4, v11, v4}, Landroid/widget/ImageView;->setPadding(IIII)V

    .line 289
    sget-object v8, Landroid/widget/ImageView$ScaleType;->FIT_CENTER:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v6, v8}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 290
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeView;->getBmpLoading()Landroid/graphics/Bitmap;

    move-result-object v8

    invoke-virtual {v6, v8}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 291
    invoke-virtual {p2, v6}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 293
    const/4 v3, 0x0

    .line 294
    .local v3, "amazonAd":Lcom/amazon/mShop/mobileads/MobileAdsLayout;
    const/4 v0, 0x0

    .line 295
    .local v0, "adId":Ljava/lang/String;
    iget-object v8, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAdLayout:Landroid/widget/FrameLayout;

    if-ne p2, v8, :cond_1

    .line 299
    new-instance v8, Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    iget-object v9, p0, Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;

    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeView;->getAdSize()Lcom/amazon/device/ads/AdSize;

    move-result-object v10

    invoke-direct {v8, v9, v10}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;-><init>(Landroid/app/Activity;Lcom/amazon/device/ads/AdSize;)V

    iput-object v8, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    .line 300
    sget-object v8, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->LOADING:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    iput-object v8, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    .line 301
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    .line 302
    const-string/jumbo v0, "GW_PROMO_LEFT"

    .line 312
    :goto_0
    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;

    const/16 v8, 0x11

    invoke-direct {v1, v7, v5, v8}, Landroid/widget/FrameLayout$LayoutParams;-><init>(III)V

    .line 313
    .local v1, "adLayoutParams":Landroid/widget/FrameLayout$LayoutParams;
    invoke-virtual {v3, v1}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 314
    invoke-virtual {p2, v3}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 316
    new-instance v2, Lcom/amazon/mShop/home/HomeView$1;

    invoke-direct {v2, p0, p2, p1, v6}, Lcom/amazon/mShop/home/HomeView$1;-><init>(Lcom/amazon/mShop/home/HomeView;Landroid/widget/FrameLayout;Lcom/amazon/mShop/home/PromoSlotView;Landroid/widget/ImageView;)V

    .line 362
    .local v2, "adListener":Lcom/amazon/device/ads/AmazonOOAdListener;
    iget-object v8, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    const-class v9, Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    invoke-virtual {v9}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 364
    invoke-virtual {v3, v2, v0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->load(Lcom/amazon/device/ads/AmazonOOAdListener;Ljava/lang/String;)V

    .line 365
    .end local v1    # "adLayoutParams":Landroid/widget/FrameLayout$LayoutParams;
    .end local v2    # "adListener":Lcom/amazon/device/ads/AmazonOOAdListener;
    :cond_0
    return-void

    .line 304
    :cond_1
    iget-object v8, p0, Lcom/amazon/mShop/home/HomeView;->mRightAdLayout:Landroid/widget/FrameLayout;

    if-ne p2, v8, :cond_0

    .line 305
    new-instance v8, Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    iget-object v9, p0, Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;

    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeView;->getAdSize()Lcom/amazon/device/ads/AdSize;

    move-result-object v10

    invoke-direct {v8, v9, v10}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;-><init>(Landroid/app/Activity;Lcom/amazon/device/ads/AdSize;)V

    iput-object v8, p0, Lcom/amazon/mShop/home/HomeView;->mRightAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    .line 306
    sget-object v8, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->LOADING:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    iput-object v8, p0, Lcom/amazon/mShop/home/HomeView;->mRightAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    .line 307
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeView;->mRightAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    .line 308
    const-string/jumbo v0, "GW_PROMO_RIGHT"

    goto :goto_0
.end method

.method private loadAds()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 244
    invoke-static {}, Lcom/amazon/mShop/mobileads/AdsHelper;->isAdsEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 245
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_hasMobileAdsOnLeftPromoSlot:I

    invoke-static {v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 246
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage0:Lcom/amazon/mShop/home/PromoSlotView;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAdLayout:Landroid/widget/FrameLayout;

    invoke-direct {p0, v0, v1}, Lcom/amazon/mShop/home/HomeView;->loadAdForPromoSlot(Lcom/amazon/mShop/home/PromoSlotView;Landroid/widget/FrameLayout;)V

    .line 254
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage1:Lcom/amazon/mShop/home/PromoSlotView;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mRightAdLayout:Landroid/widget/FrameLayout;

    invoke-direct {p0, v0, v1}, Lcom/amazon/mShop/home/HomeView;->loadAdForPromoSlot(Lcom/amazon/mShop/home/PromoSlotView;Landroid/widget/FrameLayout;)V

    .line 261
    :goto_1
    return-void

    .line 251
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAdLayout:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v2}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 252
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage0:Lcom/amazon/mShop/home/PromoSlotView;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/home/PromoSlotView;->setVisibility(I)V

    goto :goto_0

    .line 256
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAdLayout:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v2}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 257
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mRightAdLayout:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v2}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 258
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage0:Lcom/amazon/mShop/home/PromoSlotView;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/home/PromoSlotView;->setVisibility(I)V

    .line 259
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage1:Lcom/amazon/mShop/home/PromoSlotView;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/home/PromoSlotView;->setVisibility(I)V

    goto :goto_1
.end method

.method public static postClickedSlotToken(Ljava/lang/String;)V
    .locals 2
    .param p0, "token"    # Ljava/lang/String;

    .prologue
    .line 661
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 662
    .local v0, "clickedSlotToken":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v0, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 663
    new-instance v1, Lcom/amazon/mShop/net/ClickedSlotsMetricsObserver;

    invoke-direct {v1}, Lcom/amazon/mShop/net/ClickedSlotsMetricsObserver;-><init>()V

    .line 664
    .local v1, "observer":Lcom/amazon/mShop/net/ClickedSlotsMetricsObserver;
    invoke-virtual {v1, v0}, Lcom/amazon/mShop/net/ClickedSlotsMetricsObserver;->postSlotTokens(Ljava/util/List;)V

    .line 665
    return-void
.end method

.method private setCurrentOrientation(I)V
    .locals 0
    .param p1, "orientation"    # I

    .prologue
    .line 505
    iput p1, p0, Lcom/amazon/mShop/home/HomeView;->mCurrentOrientation:I

    .line 506
    return-void
.end method

.method private setDefaultShoveler()V
    .locals 4

    .prologue
    const/4 v2, 0x0

    const/16 v1, 0x8

    .line 1065
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler0:Lcom/amazon/mShop/home/HomeShovelerView;

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/home/HomeController;->getHomeShoveler0()Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    move-result-object v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_0
    invoke-virtual {v3, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->setVisibility(I)V

    .line 1066
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler1:Lcom/amazon/mShop/home/HomeShovelerView;

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/home/HomeController;->getHomeShoveler1()Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    move-result-object v0

    if-nez v0, :cond_2

    move v0, v1

    :goto_1
    invoke-virtual {v3, v0}, Lcom/amazon/mShop/home/HomeShovelerView;->setVisibility(I)V

    .line 1068
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/home/HomeController;->getHomeShoveler0()Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    move-result-object v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/home/HomeController;->getHomeShoveler1()Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    move-result-object v0

    if-nez v0, :cond_0

    .line 1069
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShovelerEmptyPlaceHolder:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1070
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeBottomBanner:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1071
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeStrenchFrame:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1073
    :cond_0
    return-void

    :cond_1
    move v0, v2

    .line 1065
    goto :goto_0

    :cond_2
    move v0, v2

    .line 1066
    goto :goto_1
.end method

.method private setupVoiceSearch()V
    .locals 4

    .prologue
    .line 207
    :try_start_0
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->home_shop_by_department_view:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 209
    .local v1, "sbd":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 210
    invoke-static {}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->getInstance()Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->shopByDepartmentEnabled()Z

    move-result v2

    if-eqz v2, :cond_1

    const/4 v2, 0x0

    :goto_0
    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 215
    .end local v1    # "sbd":Landroid/view/View;
    :cond_0
    :goto_1
    return-void

    .line 210
    .restart local v1    # "sbd":Landroid/view/View;
    :cond_1
    const/16 v2, 0x8

    goto :goto_0

    .line 212
    .end local v1    # "sbd":Landroid/view/View;
    :catch_0
    move-exception v0

    .line 213
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v2, "HomeView"

    const-string/jumbo v3, "Failed to setup voice search"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1
.end method

.method private updateButtonsOnUserStatusChanged(Lcom/amazon/mShop/model/auth/User;)V
    .locals 9
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    const/4 v5, 0x0

    const/4 v3, 0x0

    .line 539
    if-nez p1, :cond_1

    .line 540
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    .line 541
    .local v8, "applicationContext":Landroid/content/Context;
    invoke-static {v8}, Lcom/amazon/mShop/sso/SSOUtil;->isSSOSupported(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->hasAmazonAccount()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 543
    const-string/jumbo v1, "com.amazon.dcp.sso.property.username"

    invoke-static {v8, v1}, Lcom/amazon/mShop/sso/SSOUtil;->peekCustomerAttribute(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 544
    .local v2, "fullName":Ljava/lang/String;
    new-instance v0, Lcom/amazon/mShop/model/auth/User;

    const-string/jumbo v1, ""

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    move v4, v3

    move-object v7, v5

    invoke-direct/range {v0 .. v7}, Lcom/amazon/mShop/model/auth/User;-><init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/lang/Boolean;Ljava/lang/String;)V

    .line 545
    .local v0, "tempUser":Lcom/amazon/mShop/model/auth/User;
    invoke-direct {p0, v0}, Lcom/amazon/mShop/home/HomeView;->updateYourAccountButton(Lcom/amazon/mShop/model/auth/User;)V

    .line 552
    .end local v0    # "tempUser":Lcom/amazon/mShop/model/auth/User;
    .end local v2    # "fullName":Ljava/lang/String;
    .end local v8    # "applicationContext":Landroid/content/Context;
    :goto_0
    return-void

    .line 547
    .restart local v8    # "applicationContext":Landroid/content/Context;
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeView;->updateLoginButton()V

    goto :goto_0

    .line 550
    .end local v8    # "applicationContext":Landroid/content/Context;
    :cond_1
    invoke-direct {p0, p1}, Lcom/amazon/mShop/home/HomeView;->updateYourAccountButton(Lcom/amazon/mShop/model/auth/User;)V

    goto :goto_0
.end method

.method private updateLoginButton()V
    .locals 2

    .prologue
    .line 558
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLoginLeftMessage:Landroid/widget/TextView;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->home_title:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 559
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLoginRightMessage:Landroid/widget/TextView;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->home_sign_in:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 560
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLoginOrYourAccountButton:Landroid/view/View;

    new-instance v1, Lcom/amazon/mShop/home/HomeView$4;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/home/HomeView$4;-><init>(Lcom/amazon/mShop/home/HomeView;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 573
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLoginOrYourAccountButton:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 574
    return-void
.end method

.method private updatePromoSlot0()V
    .locals 3

    .prologue
    .line 1002
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/home/HomeController;->getPromoSlot0()Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    move-result-object v0

    .line 1003
    .local v0, "value":Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    if-nez v0, :cond_1

    .line 1004
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage0:Lcom/amazon/mShop/home/PromoSlotView;

    invoke-virtual {v1}, Lcom/amazon/mShop/home/PromoSlotView;->setDefaultPromoSlot()V

    .line 1016
    :cond_0
    :goto_0
    return-void

    .line 1006
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/mobileads/AdsHelper;->isAdsEnabled()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 1007
    sget-object v1, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->FAILURE:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->config_hasMobileAdsOnLeftPromoSlot:I

    invoke-static {v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1009
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage0:Lcom/amazon/mShop/home/PromoSlotView;

    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v1, v0, v2}, Lcom/amazon/mShop/home/PromoSlotView;->update(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;Lcom/amazon/mShop/net/PageMetricsObserver;)V

    goto :goto_0

    .line 1013
    :cond_3
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage0:Lcom/amazon/mShop/home/PromoSlotView;

    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v1, v0, v2}, Lcom/amazon/mShop/home/PromoSlotView;->update(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;Lcom/amazon/mShop/net/PageMetricsObserver;)V

    goto :goto_0
.end method

.method private updatePromoSlot1()V
    .locals 3

    .prologue
    .line 1028
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/home/HomeController;->getPromoSlot1()Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    move-result-object v0

    .line 1029
    .local v0, "value":Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    if-nez v0, :cond_1

    .line 1030
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage1:Lcom/amazon/mShop/home/PromoSlotView;

    invoke-virtual {v1}, Lcom/amazon/mShop/home/PromoSlotView;->setDefaultPromoSlot()V

    .line 1041
    :cond_0
    :goto_0
    return-void

    .line 1032
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/mobileads/AdsHelper;->isAdsEnabled()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1033
    sget-object v1, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->FAILURE:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView;->mRightAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1034
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage1:Lcom/amazon/mShop/home/PromoSlotView;

    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v1, v0, v2}, Lcom/amazon/mShop/home/PromoSlotView;->update(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;Lcom/amazon/mShop/net/PageMetricsObserver;)V

    goto :goto_0

    .line 1038
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage1:Lcom/amazon/mShop/home/PromoSlotView;

    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v1, v0, v2}, Lcom/amazon/mShop/home/PromoSlotView;->update(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;Lcom/amazon/mShop/net/PageMetricsObserver;)V

    goto :goto_0
.end method

.method private updatePromoSlots()V
    .locals 0

    .prologue
    .line 1057
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeView;->updatePromoSlot0()V

    .line 1058
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeView;->updatePromoSlot1()V

    .line 1059
    return-void
.end method

.method private updateShopByDepartmentLabel()V
    .locals 9

    .prologue
    const/16 v8, 0x21

    .line 686
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->categroy_browse_department:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 687
    .local v0, "boldText":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->shop_by_text:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 688
    .local v2, "fullText":Ljava/lang/String;
    new-instance v3, Landroid/text/SpannableString;

    invoke-direct {v3, v2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 691
    .local v3, "ss":Landroid/text/SpannableString;
    const-string/jumbo v5, "ja_JP"

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 692
    iget-object v5, p0, Lcom/amazon/mShop/home/HomeView;->mShopByDepartmentLabel:Landroid/widget/TextView;

    const/16 v6, 0x15

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setGravity(I)V

    .line 705
    :goto_0
    iget-object v5, p0, Lcom/amazon/mShop/home/HomeView;->mShopByDepartmentLabel:Landroid/widget/TextView;

    invoke-virtual {v5, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 708
    return-void

    .line 695
    :cond_0
    invoke-virtual {v2, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    .line 696
    .local v4, "startIndex":I
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v1

    .line 698
    .local v1, "endIndex":I
    new-instance v5, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$color;->action_bar_shop_by_department_bold_text_color:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-direct {v5, v6}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v3, v5, v4, v1, v8}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 700
    new-instance v5, Landroid/text/style/AbsoluteSizeSpan;

    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$dimen;->gno_category_browse_department_size:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v6

    const/4 v7, 0x0

    invoke-direct {v5, v6, v7}, Landroid/text/style/AbsoluteSizeSpan;-><init>(IZ)V

    invoke-virtual {v3, v5, v4, v1, v8}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 703
    new-instance v5, Landroid/text/style/StyleSpan;

    const/4 v6, 0x1

    invoke-direct {v5, v6}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-virtual {v3, v5, v4, v1, v8}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto :goto_0
.end method

.method private updateYourAccountButton(Lcom/amazon/mShop/model/auth/User;)V
    .locals 9
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    const/4 v8, 0x0

    .line 580
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->home_sign_in_message_welcome:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 581
    .local v1, "format":Ljava/lang/String;
    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-static {v1, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 583
    .local v3, "welcomeNameAdded":Ljava/lang/String;
    new-instance v4, Landroid/text/SpannableString;

    invoke-direct {v4, v3}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 584
    .local v4, "welcomeSpannable":Landroid/text/SpannableString;
    const-string/jumbo v5, "%1$s"

    invoke-virtual {v1, v5}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    .line 585
    .local v2, "start":I
    const/4 v5, -0x1

    if-eq v2, v5, :cond_0

    .line 587
    invoke-virtual {p1}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    add-int v0, v2, v5

    .line 588
    .local v0, "end":I
    new-instance v5, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$color;->amazon_gold:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-direct {v5, v6}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    const/16 v6, 0x21

    invoke-virtual {v4, v5, v2, v0, v6}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 591
    .end local v0    # "end":I
    :cond_0
    iget-object v5, p0, Lcom/amazon/mShop/home/HomeView;->mLoginLeftMessage:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 592
    iget-object v5, p0, Lcom/amazon/mShop/home/HomeView;->mLoginRightMessage:Landroid/widget/TextView;

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->home_sign_in_message_youraccount:I

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(I)V

    .line 593
    iget-object v5, p0, Lcom/amazon/mShop/home/HomeView;->mLoginOrYourAccountButton:Landroid/view/View;

    new-instance v6, Lcom/amazon/mShop/home/HomeView$5;

    invoke-direct {v6, p0}, Lcom/amazon/mShop/home/HomeView$5;-><init>(Lcom/amazon/mShop/home/HomeView;)V

    invoke-virtual {v5, v6}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 602
    iget-object v5, p0, Lcom/amazon/mShop/home/HomeView;->mLoginOrYourAccountButton:Landroid/view/View;

    invoke-virtual {v5, v8}, Landroid/view/View;->setVisibility(I)V

    .line 603
    return-void
.end method


# virtual methods
.method public destroy()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1156
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    if-eqz v0, :cond_0

    .line 1157
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    invoke-virtual {v0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->onDetachedFromWindow()V

    .line 1158
    iput-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    .line 1161
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mRightAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    if-eqz v0, :cond_1

    .line 1162
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mRightAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    invoke-virtual {v0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->onDetachedFromWindow()V

    .line 1163
    iput-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mRightAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    .line 1167
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mRightAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    if-eqz v0, :cond_2

    .line 1168
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->onDetachedFromWindow()V

    .line 1170
    :cond_2
    return-void
.end method

.method public handleConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 489
    invoke-static {}, Lcom/amazon/mShop/mobileads/AdsHelper;->isAdsEnabled()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeView;->getCurrentOrientation()I

    move-result v0

    iget v1, p1, Landroid/content/res/Configuration;->orientation:I

    if-eq v0, v1, :cond_5

    .line 490
    iget v0, p1, Landroid/content/res/Configuration;->orientation:I

    invoke-direct {p0, v0}, Lcom/amazon/mShop/home/HomeView;->setCurrentOrientation(I)V

    .line 491
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAdType:Lcom/amazon/device/ads/AdProperties$AdType;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAdType:Lcom/amazon/device/ads/AdProperties$AdType;

    sget-object v1, Lcom/amazon/device/ads/AdProperties$AdType;->MRAID_1:Lcom/amazon/device/ads/AdProperties$AdType;

    if-eq v0, v1, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAdType:Lcom/amazon/device/ads/AdProperties$AdType;

    sget-object v1, Lcom/amazon/device/ads/AdProperties$AdType;->MRAID_2:Lcom/amazon/device/ads/AdProperties$AdType;

    if-eq v0, v1, :cond_1

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    sget-object v1, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->LOADING:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    if-ne v0, v1, :cond_2

    .line 493
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage0:Lcom/amazon/mShop/home/PromoSlotView;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAdLayout:Landroid/widget/FrameLayout;

    invoke-direct {p0, v0, v1}, Lcom/amazon/mShop/home/HomeView;->loadAdForPromoSlot(Lcom/amazon/mShop/home/PromoSlotView;Landroid/widget/FrameLayout;)V

    .line 495
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mRightAdType:Lcom/amazon/device/ads/AdProperties$AdType;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mRightAdType:Lcom/amazon/device/ads/AdProperties$AdType;

    sget-object v1, Lcom/amazon/device/ads/AdProperties$AdType;->MRAID_1:Lcom/amazon/device/ads/AdProperties$AdType;

    if-eq v0, v1, :cond_4

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mRightAdType:Lcom/amazon/device/ads/AdProperties$AdType;

    sget-object v1, Lcom/amazon/device/ads/AdProperties$AdType;->MRAID_2:Lcom/amazon/device/ads/AdProperties$AdType;

    if-eq v0, v1, :cond_4

    :cond_3
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mRightAdLoadingState:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    sget-object v1, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->LOADING:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    if-ne v0, v1, :cond_5

    .line 497
    :cond_4
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage1:Lcom/amazon/mShop/home/PromoSlotView;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mRightAdLayout:Landroid/widget/FrameLayout;

    invoke-direct {p0, v0, v1}, Lcom/amazon/mShop/home/HomeView;->loadAdForPromoSlot(Lcom/amazon/mShop/home/PromoSlotView;Landroid/widget/FrameLayout;)V

    .line 500
    :cond_5
    return-void
.end method

.method public insertErrorBox(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 1124
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->home_error_box_separator:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 1125
    .local v1, "errorSeparator":Landroid/view/View;
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/home/HomeView;->indexOfChild(Landroid/view/View;)I

    move-result v0

    .line 1126
    .local v0, "destIndex":I
    if-ltz v0, :cond_0

    .line 1127
    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/home/HomeView;->addView(Landroid/view/View;I)V

    .line 1128
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 1132
    :goto_0
    return-void

    .line 1130
    :cond_0
    const-string/jumbo v2, "HomeView"

    const-string/jumbo v3, "The home content scroller is not in place"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public isActionBarSearchIconFadeable()Z
    .locals 1

    .prologue
    .line 1142
    const/4 v0, 0x1

    return v0
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 460
    invoke-super {p0}, Landroid/widget/LinearLayout;->onAttachedToWindow()V

    .line 461
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 467
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/control/home/HomeController;->addSubscriberAtFirstPosition(Lcom/amazon/mShop/control/home/HomeSubscriber;)V

    .line 468
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/home/GatewayActivity;->registerConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V

    .line 469
    return-void
.end method

.method public onAvailableCountReceived(I)V
    .locals 0
    .param p1, "availableCount"    # I

    .prologue
    .line 906
    return-void
.end method

.method public onCancelled()V
    .locals 1

    .prologue
    .line 825
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/home/HomeView;->mNeedInvokeHomeCallStarted:Z

    .line 826
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler0:Lcom/amazon/mShop/home/HomeShovelerView;

    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeShovelerView;->clear()V

    .line 827
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler1:Lcom/amazon/mShop/home/HomeShovelerView;

    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeShovelerView;->clear()V

    .line 834
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 835
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 838
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_1

    .line 839
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 842
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_2

    .line 843
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 846
    :cond_2
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 514
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 515
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->removeUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 516
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/control/home/HomeController;->removeSubscriber(Lcom/amazon/mShop/control/home/HomeSubscriber;)V

    .line 517
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/home/GatewayActivity;->unregisterConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V

    .line 519
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 520
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 523
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_1

    .line 524
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 527
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_2

    .line 528
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 531
    :cond_2
    iput-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    .line 532
    iput-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mRightAd:Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    .line 533
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 850
    invoke-direct {p0, p1}, Lcom/amazon/mShop/home/HomeView;->handlerError(Ljava/lang/Exception;)V

    .line 851
    return-void
.end method

.method protected onFinishInflate()V
    .locals 7

    .prologue
    const/4 v2, 0x1

    .line 153
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 154
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->home_login_or_your_account_button:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLoginOrYourAccountButton:Landroid/view/View;

    .line 155
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->home_sign_in_left_message:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLoginLeftMessage:Landroid/widget/TextView;

    .line 156
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->home_sign_in_right_message:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLoginRightMessage:Landroid/widget/TextView;

    .line 158
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->home_shop_by_department_label:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShopByDepartmentLabel:Landroid/widget/TextView;

    .line 159
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeView;->updateShopByDepartmentLabel()V

    .line 161
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeView;->setupVoiceSearch()V

    .line 163
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->home_mobileads_banner_left:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mLeftAdLayout:Landroid/widget/FrameLayout;

    .line 164
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->home_mobileads_banner_right:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mRightAdLayout:Landroid/widget/FrameLayout;

    .line 166
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->shoveler_view_empty_placeholder:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShovelerEmptyPlaceHolder:Landroid/widget/ImageView;

    .line 168
    iget-object v6, p0, Lcom/amazon/mShop/home/HomeView;->mShovelerEmptyPlaceHolder:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->home_shoveler_placeholder:I

    move v3, v2

    move v4, v2

    move v5, v2

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/util/BitmapUtil;->loadImage(Landroid/content/res/Resources;IZZZZ)Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-virtual {v6, v0}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 171
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->home_shoveler0:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/home/HomeShovelerView;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler0:Lcom/amazon/mShop/home/HomeShovelerView;

    .line 172
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->home_shoveler1:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/home/HomeShovelerView;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler1:Lcom/amazon/mShop/home/HomeShovelerView;

    .line 174
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->promo_slot0:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/home/PromoSlotView;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage0:Lcom/amazon/mShop/home/PromoSlotView;

    .line 175
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->promo_slot1:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/home/PromoSlotView;

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage1:Lcom/amazon/mShop/home/PromoSlotView;

    .line 178
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler0:Lcom/amazon/mShop/home/HomeShovelerView;

    const-string/jumbo v1, "hm_c0_mr"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/home/HomeShovelerView;->setMoreLinkRefMarker(Ljava/lang/String;)V

    .line 179
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler0:Lcom/amazon/mShop/home/HomeShovelerView;

    const-string/jumbo v1, "hm_c0_%1$d"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/home/HomeShovelerView;->setHomeCarouselArg(Ljava/lang/String;)V

    .line 183
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler1:Lcom/amazon/mShop/home/HomeShovelerView;

    const-string/jumbo v1, "hm_c1_mr"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/home/HomeShovelerView;->setMoreLinkRefMarker(Ljava/lang/String;)V

    .line 184
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler1:Lcom/amazon/mShop/home/HomeShovelerView;

    const-string/jumbo v1, "hm_c1_%1$d"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/home/HomeShovelerView;->setHomeCarouselArg(Ljava/lang/String;)V

    .line 187
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage0:Lcom/amazon/mShop/home/PromoSlotView;

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->promo_defaultslot0:I

    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->home_promo0_action_android:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->home_promo0_param_android:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "hm_p0"

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/home/PromoSlotView;->setDefaultPromoSlotInfo(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPromoSlotImage1:Lcom/amazon/mShop/home/PromoSlotView;

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->promo_defaultslot1:I

    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->home_promo1_action_android:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->home_promo1_param_android:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "hm_p1"

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/home/PromoSlotView;->setDefaultPromoSlotInfo(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->home_bottom_banner:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeBottomBanner:Landroid/view/View;

    .line 197
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->home_strentch_frame:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeStrenchFrame:Landroid/view/View;

    .line 199
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    invoke-direct {p0, v0}, Lcom/amazon/mShop/home/HomeView;->setCurrentOrientation(I)V

    .line 200
    return-void
.end method

.method public onHomeCallStarted()V
    .locals 3

    .prologue
    .line 774
    move-object v0, p0

    .line 775
    .local v0, "view":Landroid/view/View;
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;

    new-instance v2, Lcom/amazon/mShop/home/HomeView$6;

    invoke-direct {v2, p0, v0}, Lcom/amazon/mShop/home/HomeView$6;-><init>(Lcom/amazon/mShop/home/HomeView;Landroid/view/View;)V

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/home/GatewayActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 807
    return-void
.end method

.method public onHomeShoveler0Received(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
    .locals 6
    .param p1, "shoveler"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    .prologue
    .line 910
    if-nez p1, :cond_2

    .line 911
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 912
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 914
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_1

    .line 915
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 950
    :cond_1
    :goto_0
    return-void

    .line 920
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler0:Lcom/amazon/mShop/home/HomeShovelerView;

    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v3, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v4, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/home/HomeController;->getRequestId()Ljava/lang/String;

    move-result-object v5

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/home/HomeShovelerView;->update(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;Lcom/amazon/mShop/net/PageMetricsObserver;Lcom/amazon/mShop/net/PageMetricsObserver;Lcom/amazon/mShop/net/PageMetricsObserver;Ljava/lang/String;)V

    .line 925
    sget-object v0, Lcom/amazon/mShop/sso/IdentityType;->CENTRAL_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v1

    if-ne v0, v1, :cond_4

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->hasAmazonAccount()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 928
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->getInstance(Landroid/content/Context;)Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/home/HomeView$8;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/home/HomeView$8;-><init>(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->postDbOperation(Ljava/lang/Runnable;)V

    .line 944
    :cond_4
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_5

    .line 945
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 947
    :cond_5
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_1

    .line 948
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onHomeShoveler1Received(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
    .locals 6
    .param p1, "shoveler"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    .prologue
    const/4 v3, 0x0

    .line 954
    if-nez p1, :cond_1

    .line 955
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 956
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 990
    :cond_0
    :goto_0
    return-void

    .line 962
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler1:Lcom/amazon/mShop/home/HomeShovelerView;

    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/home/HomeController;->getRequestId()Ljava/lang/String;

    move-result-object v5

    move-object v1, p1

    move-object v4, v3

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/home/HomeShovelerView;->update(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;Lcom/amazon/mShop/net/PageMetricsObserver;Lcom/amazon/mShop/net/PageMetricsObserver;Lcom/amazon/mShop/net/PageMetricsObserver;Ljava/lang/String;)V

    .line 967
    sget-object v0, Lcom/amazon/mShop/sso/IdentityType;->CENTRAL_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v1

    if-ne v0, v1, :cond_3

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->hasAmazonAccount()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 970
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->getInstance(Landroid/content/Context;)Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/home/HomeView$9;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/home/HomeView$9;-><init>(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->postDbOperation(Ljava/lang/Runnable;)V

    .line 987
    :cond_3
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 988
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onNotificationReceived(Lcom/amazon/rio/j2me/client/services/mShop/Notification;)V
    .locals 1
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    .prologue
    .line 819
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;Lcom/amazon/rio/j2me/client/services/mShop/Notification;)V

    .line 820
    return-void
.end method

.method public onObjectReceived(Ljava/lang/Object;I)V
    .locals 0
    .param p1, "o"    # Ljava/lang/Object;
    .param p2, "index"    # I

    .prologue
    .line 811
    return-void
.end method

.method public onObjectsReceived()V
    .locals 0

    .prologue
    .line 815
    return-void
.end method

.method public onPageComplete()V
    .locals 2

    .prologue
    .line 874
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/home/HomeView;->mNeedInvokeHomeCallStarted:Z

    .line 875
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeView;->updatePromoSlots()V

    .line 876
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeView;->setDefaultShoveler()V

    .line 882
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 884
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 886
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_1

    .line 888
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 891
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_2

    .line 893
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 898
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;

    invoke-static {}, Lcom/amazon/mShop/AmazonActivity;->getTopMostBaseActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    if-ne v0, v1, :cond_3

    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/home/GatewayActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    instance-of v0, v0, Lcom/amazon/mShop/home/HomeView;

    if-eqz v0, :cond_3

    .line 899
    invoke-virtual {p0}, Lcom/amazon/mShop/home/HomeView;->postHomePageImpression()V

    .line 901
    :cond_3
    return-void
.end method

.method public onPromoSlot0Received(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .prologue
    .line 999
    return-void
.end method

.method public onPromoSlot1Received(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .prologue
    .line 1025
    return-void
.end method

.method public onPushViewCompleted()V
    .locals 3

    .prologue
    .line 372
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v0

    .line 373
    .local v0, "user":Lcom/amazon/mShop/model/auth/User;
    invoke-direct {p0, v0}, Lcom/amazon/mShop/home/HomeView;->updateButtonsOnUserStatusChanged(Lcom/amazon/mShop/model/auth/User;)V

    .line 375
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mShopByDepartmentLabel:Landroid/widget/TextView;

    new-instance v2, Lcom/amazon/mShop/home/HomeView$2;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/home/HomeView$2;-><init>(Lcom/amazon/mShop/home/HomeView;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 396
    new-instance v1, Lcom/amazon/mShop/home/HomeView$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/home/HomeView$3;-><init>(Lcom/amazon/mShop/home/HomeView;)V

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/home/HomeView;->post(Ljava/lang/Runnable;)Z

    .line 444
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/home/HomeController;->getException()Ljava/lang/Exception;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 445
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/home/HomeController;->getException()Ljava/lang/Exception;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/amazon/mShop/home/HomeView;->handlerError(Ljava/lang/Exception;)V

    .line 448
    :cond_0
    iget-boolean v1, p0, Lcom/amazon/mShop/home/HomeView;->mIsHomeViewJustCreated:Z

    if-eqz v1, :cond_1

    .line 449
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;

    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->handleSigninPrompt(Landroid/content/Context;)Z

    .line 451
    :cond_1
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .locals 3
    .param p1, "hasFocus"    # Z

    .prologue
    .line 1192
    :try_start_0
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onWindowFocusChanged(Z)V

    .line 1194
    if-eqz p1, :cond_0

    .line 1195
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeView;->setupVoiceSearch()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1200
    :cond_0
    :goto_0
    return-void

    .line 1197
    :catch_0
    move-exception v0

    .line 1198
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v1, "HomeView"

    const-string/jumbo v2, "onWindowFocusChanged error"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public postHomePageImpression()V
    .locals 3

    .prologue
    .line 675
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/home/HomeController;->getHomepageTokens()Ljava/util/List;

    move-result-object v0

    .line 676
    .local v0, "homePageTokens":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 677
    new-instance v1, Lcom/amazon/mShop/net/ExposedSlotsMetricsObserver;

    invoke-direct {v1}, Lcom/amazon/mShop/net/ExposedSlotsMetricsObserver;-><init>()V

    .line 678
    .local v1, "observer":Lcom/amazon/mShop/net/ExposedSlotsMetricsObserver;
    invoke-virtual {v1, v0}, Lcom/amazon/mShop/net/ExposedSlotsMetricsObserver;->postSlotTokens(Ljava/util/List;)V

    .line 680
    .end local v1    # "observer":Lcom/amazon/mShop/net/ExposedSlotsMetricsObserver;
    :cond_0
    return-void
.end method

.method public preHomeCallStarted()V
    .locals 1

    .prologue
    .line 753
    invoke-direct {p0}, Lcom/amazon/mShop/home/HomeView;->initAdState()V

    .line 755
    iget-boolean v0, p0, Lcom/amazon/mShop/home/HomeView;->mIsHomeViewJustCreated:Z

    if-nez v0, :cond_2

    .line 759
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 760
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 762
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_1

    .line 763
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mPageMetricsCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 768
    :cond_1
    :goto_0
    return-void

    .line 766
    :cond_2
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/home/HomeView;->mIsHomeViewJustCreated:Z

    goto :goto_0
.end method

.method public removeErrorBox(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 1135
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/home/HomeView;->removeView(Landroid/view/View;)V

    .line 1136
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->home_error_box_separator:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 1137
    .local v0, "errorSeparator":Landroid/view/View;
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1138
    return-void
.end method

.method public scollToTop()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1044
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->home_content_scroller:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/home/HomeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ScrollView;

    .line 1045
    .local v0, "scrollView":Landroid/widget/ScrollView;
    invoke-virtual {v0, v2, v2}, Landroid/widget/ScrollView;->scrollTo(II)V

    .line 1046
    return-void
.end method

.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 615
    invoke-direct {p0, p1}, Lcom/amazon/mShop/home/HomeView;->updateButtonsOnUserStatusChanged(Lcom/amazon/mShop/model/auth/User;)V

    .line 616
    return-void
.end method

.method public userSignedOut()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 620
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/home/HomeView;->updateButtonsOnUserStatusChanged(Lcom/amazon/mShop/model/auth/User;)V

    .line 621
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShovelerEmptyPlaceHolder:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 622
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeBottomBanner:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 623
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mHomeStrenchFrame:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 624
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler0:Lcom/amazon/mShop/home/HomeShovelerView;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/home/HomeShovelerView;->setVisibility(I)V

    .line 625
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler1:Lcom/amazon/mShop/home/HomeShovelerView;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/home/HomeShovelerView;->setVisibility(I)V

    .line 626
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler0:Lcom/amazon/mShop/home/HomeShovelerView;

    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeShovelerView;->clear()V

    .line 627
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView;->mShoveler1:Lcom/amazon/mShop/home/HomeShovelerView;

    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeShovelerView;->clear()V

    .line 628
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 610
    invoke-direct {p0, p1}, Lcom/amazon/mShop/home/HomeView;->updateButtonsOnUserStatusChanged(Lcom/amazon/mShop/model/auth/User;)V

    .line 611
    return-void
.end method
