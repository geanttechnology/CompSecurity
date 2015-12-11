.class public Lcom/amazon/mShop/pushnotification/NotificationsSettingView;
.super Landroid/widget/LinearLayout;
.source "NotificationsSettingView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;
.implements Lcom/amazon/mShop/control/Cancellable;
.implements Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;
    }
.end annotation


# instance fields
.field private mAdapter:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

.field private mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mCurrentSubscriptions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;",
            ">;"
        }
    .end annotation
.end field

.field private mDefaultExpandedGroup:Ljava/lang/String;

.field private mExpandableListView:Landroid/widget/ExpandableListView;

.field private mNotificationSetting:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;",
            ">;>;"
        }
    .end annotation
.end field

.field private mNotificationSettingController:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

.field private mPendingSubscribed:Z

.field private mPendingSubscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V
    .locals 8
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "expandedGroup"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 65
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 62
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mCurrentSubscriptions:Ljava/util/List;

    .line 413
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    iput-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mNotificationSetting:Ljava/util/Map;

    .line 66
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 67
    iput-object p2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mDefaultExpandedGroup:Ljava/lang/String;

    .line 69
    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->notification_setting_list_view_header:I

    invoke-static {p1, v3, v6}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 70
    .local v0, "expandableListViewHeader":Landroid/view/View;
    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->notification_setting:I

    invoke-static {p1, v3, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 71
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->notification_setting_listview:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ExpandableListView;

    iput-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    .line 72
    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    invoke-virtual {v3, v0}, Landroid/widget/ExpandableListView;->addHeaderView(Landroid/view/View;)V

    .line 73
    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    invoke-virtual {v3, v7}, Landroid/widget/ExpandableListView;->setHeaderDividersEnabled(Z)V

    .line 74
    new-instance v3, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    invoke-direct {v3, p0, v6}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;-><init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Lcom/amazon/mShop/pushnotification/NotificationsSettingView$1;)V

    iput-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAdapter:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    .line 76
    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    sget v4, Lcom/amazon/mShop/android/lib/R$color;->white:I

    invoke-virtual {v3, v4}, Landroid/widget/ExpandableListView;->setBackgroundResource(I)V

    .line 79
    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    sget v4, Lcom/amazon/mShop/android/lib/R$color;->common_selector:I

    invoke-virtual {v3, v4}, Landroid/widget/ExpandableListView;->setSelector(I)V

    .line 80
    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Landroid/widget/ExpandableListView;->setItemsCanFocus(Z)V

    .line 82
    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    iget-object v4, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAdapter:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    invoke-virtual {v3, v4}, Landroid/widget/ExpandableListView;->setAdapter(Landroid/widget/ExpandableListAdapter;)V

    .line 83
    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    iget-object v4, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAdapter:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    invoke-virtual {v3, v4}, Landroid/widget/ExpandableListView;->setOnChildClickListener(Landroid/widget/ExpandableListView$OnChildClickListener;)V

    .line 84
    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    invoke-virtual {p0}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$drawable;->divider_horizontal_dark:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/ExpandableListView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 85
    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    invoke-virtual {p0}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$drawable;->divider_horizontal_dark:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/ExpandableListView;->setChildDivider(Landroid/graphics/drawable/Drawable;)V

    .line 87
    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    invoke-virtual {v3, v6}, Landroid/widget/ExpandableListView;->setGroupIndicator(Landroid/graphics/drawable/Drawable;)V

    .line 89
    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    invoke-virtual {v3, v7}, Landroid/widget/ExpandableListView;->setScrollbarFadingEnabled(Z)V

    .line 91
    new-instance v3, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;-><init>(Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;)V

    iput-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mNotificationSettingController:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    .line 92
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v1

    .line 93
    .local v1, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    invoke-virtual {v1, v6}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v2

    .line 94
    .local v2, "notificationTarget":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    if-eqz v2, :cond_1

    .line 95
    iget-object v3, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mNotificationSettingController:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    new-instance v4, Lcom/amazon/mShop/TaskCallbackFactory;

    invoke-direct {v4, p1}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->loading:I

    invoke-virtual {v4, p0, v5}, Lcom/amazon/mShop/TaskCallbackFactory;->getTaskCallback(Lcom/amazon/mShop/control/Cancellable;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->getNotificationSubscriptions(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 110
    :goto_0
    const-string/jumbo v3, "zh_CN"

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 111
    if-eqz v2, :cond_2

    const-string/jumbo v3, "pn_gt_available"

    :goto_1
    invoke-static {v3}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 115
    :cond_0
    return-void

    .line 100
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    new-instance v4, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$1;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$1;-><init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)V

    invoke-interface {v3, v4}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 111
    :cond_2
    const-string/jumbo v3, "pn_gt_unavailable"

    goto :goto_1
.end method

.method static synthetic access$100(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mNotificationSetting:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/pushnotification/NotificationsSettingView;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    .prologue
    .line 47
    invoke-direct {p0, p1}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->getStringIdForSignInLabel(Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)I

    move-result v0

    return v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mPendingSubscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    return-object v0
.end method

.method static synthetic access$402(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/pushnotification/NotificationsSettingView;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mPendingSubscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    return-object p1
.end method

.method static synthetic access$502(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/pushnotification/NotificationsSettingView;
    .param p1, "x1"    # Z

    .prologue
    .line 47
    iput-boolean p1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mPendingSubscribed:Z

    return p1
.end method

.method static synthetic access$600(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/pushnotification/NotificationsSettingView;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;

    .prologue
    .line 47
    invoke-direct {p0, p1}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->refreshUI(Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;)V

    return-void
.end method

.method static synthetic access$700(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mNotificationSettingController:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;ZLcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/pushnotification/NotificationsSettingView;
    .param p1, "x1"    # Z
    .param p2, "x2"    # Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    .prologue
    .line 47
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->logRefMarker(ZLcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)V

    return-void
.end method

.method static synthetic access$900(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/pushnotification/NotificationsSettingView;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 47
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->subscribe(Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Ljava/lang/String;)V

    return-void
.end method

.method private constructRefMarkerPerNotificationType(ZLcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)Ljava/lang/String;
    .locals 3
    .param p1, "isTurnOn"    # Z
    .param p2, "subscription"    # Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    .prologue
    .line 564
    const/4 v0, 0x0

    .line 565
    .local v0, "refMarker":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getSubscriptionId()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "ST:shipment-tracking"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 566
    if-eqz p1, :cond_1

    .line 567
    const-string/jumbo v0, "pn_on_shipment-tracking"

    .line 593
    :cond_0
    :goto_0
    return-object v0

    .line 569
    :cond_1
    const-string/jumbo v0, "pn_off_shipment-tracking"

    goto :goto_0

    .line 572
    :cond_2
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getSubscriptionId()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "TD:lightning-deals"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 573
    if-eqz p1, :cond_3

    .line 574
    const-string/jumbo v0, "pn_on_ld_all"

    goto :goto_0

    .line 576
    :cond_3
    const-string/jumbo v0, "pn_off_ld_all"

    goto :goto_0

    .line 579
    :cond_4
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getSubscriptionId()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "TD:deal-of-the-day"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 580
    if-eqz p1, :cond_5

    .line 581
    const-string/jumbo v0, "pn_on_dotd"

    goto :goto_0

    .line 583
    :cond_5
    const-string/jumbo v0, "pn_off_dotd"

    goto :goto_0

    .line 586
    :cond_6
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getSubscriptionId()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "SNS:subscribe-and-save"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 587
    if-eqz p1, :cond_7

    .line 588
    const-string/jumbo v0, "pn_on_sns"

    goto :goto_0

    .line 590
    :cond_7
    const-string/jumbo v0, "pn_off_sns"

    goto :goto_0
.end method

.method private getErrorMessage(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "errorId"    # Ljava/lang/String;

    .prologue
    .line 130
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    .line 131
    .local v0, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    invoke-virtual {p0}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getErrorMessage(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private getStringIdForSignInLabel(Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)I
    .locals 3
    .param p1, "subscription"    # Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    .prologue
    .line 345
    const/4 v0, 0x0

    .line 346
    .local v0, "stringId":I
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getSubscriptionId()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "ST:shipment-tracking"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 347
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->notification_sign_in_to_view_shipment_notifications:I

    .line 360
    :goto_0
    return v0

    .line 349
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getSubscriptionId()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "TD:deal-of-the-day"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 350
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->notification_sign_in_to_view_deal_of_the_day_notifications:I

    goto :goto_0

    .line 352
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getSubscriptionId()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "SNS:subscribe-and-save"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 353
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->notification_sign_in_to_view_sns_notifications:I

    goto :goto_0

    .line 354
    :cond_2
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getSubscriptionId()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "PA:price-alert"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 355
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->notification_sign_in_to_view_pricealert_notifications:I

    goto :goto_0

    .line 358
    :cond_3
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->notification_sign_in_to_receive_notification:I

    goto :goto_0
.end method

.method private logRefMarker(ZLcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)V
    .locals 2
    .param p1, "isTurnOn"    # Z
    .param p2, "subscription"    # Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    .prologue
    .line 598
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->constructRefMarkerPerNotificationType(ZLcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)Ljava/lang/String;

    move-result-object v0

    .line 599
    .local v0, "refMarker":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 600
    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 602
    :cond_0
    return-void
.end method

.method private refreshUI(Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;)V
    .locals 1
    .param p1, "subscriptionsData"    # Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;

    .prologue
    .line 497
    invoke-direct {p0, p1}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->showHeader(Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;)V

    .line 498
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAdapter:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->notifyDataSetChanged()V

    .line 502
    invoke-virtual {p0}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->invalidate()V

    .line 503
    return-void
.end method

.method private showHeader(Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;)V
    .locals 9
    .param p1, "subscriptionsData"    # Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;

    .prologue
    .line 418
    iget-object v7, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    if-eqz v7, :cond_1

    if-eqz p1, :cond_1

    .line 419
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->getMessage()Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    move-result-object v5

    .line 420
    .local v5, "message":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    if-eqz v5, :cond_0

    .line 421
    iget-object v7, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    sget v8, Lcom/amazon/mShop/android/lib/R$id;->notification_setting_explanation:I

    invoke-virtual {v7, v8}, Landroid/widget/ExpandableListView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 422
    .local v1, "explanationView":Landroid/widget/TextView;
    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getText()Ljava/lang/String;

    move-result-object v0

    .line 423
    .local v0, "explanation":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_0

    .line 424
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 427
    .end local v0    # "explanation":Ljava/lang/String;
    .end local v1    # "explanationView":Landroid/widget/TextView;
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->getHelpLink()Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    move-result-object v2

    .line 428
    .local v2, "helpLink":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    if-eqz v2, :cond_1

    .line 429
    iget-object v7, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    sget v8, Lcom/amazon/mShop/android/lib/R$id;->learn_more_about_notifications:I

    invoke-virtual {v7, v8}, Landroid/widget/ExpandableListView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 430
    .local v4, "helpView":Landroid/widget/TextView;
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getText()Ljava/lang/String;

    move-result-object v3

    .line 431
    .local v3, "helpText":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 432
    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 433
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getAttributes()Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;

    move-result-object v7

    invoke-virtual {v7}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getLinkUrl()Ljava/lang/String;

    move-result-object v6

    .line 434
    .local v6, "url":Ljava/lang/String;
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 435
    new-instance v7, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$4;

    invoke-direct {v7, p0, v6, v3}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$4;-><init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 445
    .end local v2    # "helpLink":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    .end local v3    # "helpText":Ljava/lang/String;
    .end local v4    # "helpView":Landroid/widget/TextView;
    .end local v5    # "message":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    .end local v6    # "url":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method private subscribe(Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Ljava/lang/String;)V
    .locals 6
    .param p1, "subscription"    # Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    .param p2, "registrationId"    # Ljava/lang/String;

    .prologue
    .line 366
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mPendingSubscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    .line 367
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getSubscribed()Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v2, 0x1

    :goto_0
    iput-boolean v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mPendingSubscribed:Z

    .line 369
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;-><init>()V

    .line 370
    .local v1, "request":Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getGroupId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->setGroupId(Ljava/lang/String;)V

    .line 371
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getSubscriptionId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->setSubscriptionId(Ljava/lang/String;)V

    .line 372
    iget-boolean v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mPendingSubscribed:Z

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->setSubscribed(Z)V

    .line 374
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    .line 375
    .local v0, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mNotificationSettingController:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v3

    new-instance v4, Lcom/amazon/mShop/TaskCallbackFactory;

    iget-object v5, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v4, v5}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    invoke-virtual {v4, p0}, Lcom/amazon/mShop/TaskCallbackFactory;->getTaskCallback(Lcom/amazon/mShop/control/Cancellable;)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v4

    invoke-virtual {v2, v3, v1, v4}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->updateNotificationSubscriptions(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 383
    iget-boolean v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mPendingSubscribed:Z

    invoke-direct {p0, v2, p1}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->logRefMarker(ZLcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)V

    .line 384
    return-void

    .line 367
    .end local v0    # "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    .end local v1    # "request":Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .prologue
    .line 508
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mNotificationSettingController:Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->cancel()V

    .line 509
    return-void
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v1, 0x1

    .line 139
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v2, p1}, Lcom/amazon/mShop/AmazonActivity;->menuDispatchedKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 165
    :goto_0
    return v1

    .line 143
    :cond_0
    const/4 v2, 0x4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v3

    if-ne v2, v3, :cond_1

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-nez v2, :cond_1

    .line 158
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    .line 159
    .local v0, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .line 160
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->isErrorBoxShowing()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 161
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    goto :goto_0

    .line 165
    .end local v0    # "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_0
.end method

.method public getTitle()Ljava/lang/CharSequence;
    .locals 2

    .prologue
    .line 513
    invoke-virtual {p0}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->notification_setting:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onDeviceTokenUpdated()V
    .locals 0

    .prologue
    .line 551
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 396
    sget-object v1, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->TAG:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 397
    new-instance v0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$3;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$3;-><init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)V

    .line 410
    .local v0, "errorHandler":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    iget-object v1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v1, v0, p0, p1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;)V

    .line 411
    return-void
.end method

.method public onMarketplaceToggled(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "marketPlaceId"    # Ljava/lang/String;
    .param p2, "isMarketplaceSupportsNotifications"    # Z

    .prologue
    .line 557
    return-void
.end method

.method public onRequiresUserLogin(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V
    .locals 0
    .param p1, "callback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    .prologue
    .line 392
    return-void
.end method

.method public onSubscriptionUpdated()V
    .locals 7

    .prologue
    .line 518
    iget-object v4, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mPendingSubscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    iget-boolean v5, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mPendingSubscribed:Z

    invoke-virtual {v4, v5}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->setSubscribed(Z)V

    .line 523
    iget-object v4, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mPendingSubscription:Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getGroupId()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "ST"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 526
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v3

    .line 527
    .local v3, "userIdentify":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "notShowNotificationSettingAtThankyouPage_"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    iget-boolean v6, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mPendingSubscribed:Z

    invoke-interface {v4, v5, v6}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 534
    .end local v3    # "userIdentify":Ljava/lang/String;
    :cond_0
    const/4 v1, 0x1

    .line 535
    .local v1, "showTurnOnNotificationsAtDealresultsPage":Z
    iget-object v4, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mCurrentSubscriptions:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    .line 536
    .local v2, "subscription":Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getGroupId()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "TD"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getSubscribed()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 538
    const/4 v1, 0x0

    .line 542
    .end local v2    # "subscription":Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    :cond_2
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v4

    const-string/jumbo v5, "showTurnOnNotificationsAtDealresultsPage"

    invoke-interface {v4, v5, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 545
    const/4 v4, 0x0

    invoke-direct {p0, v4}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->refreshUI(Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;)V

    .line 546
    return-void
.end method

.method public onSubscriptionsReceived(Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;)V
    .locals 8
    .param p1, "subscriptionsData"    # Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;

    .prologue
    .line 449
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->getSubscriptionGroups()Ljava/util/List;

    move-result-object v3

    .line 450
    .local v3, "subscriptionGroups":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;>;"
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->getSubscriptions()Ljava/util/List;

    move-result-object v5

    .line 451
    .local v5, "subscriptions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;>;"
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v6

    if-nez v6, :cond_1

    .line 452
    sget v6, Lcom/amazon/mShop/android/lib/R$id;->empty_notification_text:I

    invoke-virtual {p0, v6}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->findViewById(I)Landroid/view/View;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Landroid/view/View;->setVisibility(I)V

    .line 494
    :cond_0
    :goto_0
    return-void

    .line 456
    :cond_1
    iget-object v6, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mCurrentSubscriptions:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->clear()V

    .line 457
    iget-object v6, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mNotificationSetting:Ljava/util/Map;

    invoke-interface {v6}, Ljava/util/Map;->clear()V

    .line 458
    iget-object v6, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mCurrentSubscriptions:Ljava/util/List;

    invoke-interface {v6, v5}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 459
    iget-object v6, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAdapter:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    invoke-virtual {v6}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->getGroupList()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6, v3}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 461
    iget-object v6, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mCurrentSubscriptions:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    .line 465
    .local v2, "subscription":Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    iget-object v6, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mNotificationSetting:Ljava/util/Map;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getGroupId()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    if-nez v6, :cond_2

    .line 466
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 467
    .local v4, "subscriptionList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;>;"
    iget-object v6, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mNotificationSetting:Ljava/util/Map;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getGroupId()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 468
    invoke-interface {v4, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 470
    .end local v4    # "subscriptionList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;>;"
    :cond_2
    iget-object v6, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mNotificationSetting:Ljava/util/Map;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getGroupId()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    invoke-interface {v6, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 475
    .end local v2    # "subscription":Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    :cond_3
    invoke-direct {p0, p1}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->refreshUI(Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;)V

    .line 484
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_2
    iget-object v6, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAdapter:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    invoke-virtual {v6}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->getGroupCount()I

    move-result v6

    if-ge v0, v6, :cond_0

    .line 485
    iget-object v6, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mDefaultExpandedGroup:Ljava/lang/String;

    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 486
    iget-object v6, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    invoke-virtual {v6, v0}, Landroid/widget/ExpandableListView;->expandGroup(I)Z

    .line 484
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 489
    :cond_5
    iget-object v6, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAdapter:Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;

    invoke-virtual {v6}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->getGroupList()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;->getGroupId()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mDefaultExpandedGroup:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 490
    iget-object v6, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mExpandableListView:Landroid/widget/ExpandableListView;

    invoke-virtual {v6, v0}, Landroid/widget/ExpandableListView;->expandGroup(I)Z

    goto/16 :goto_0
.end method

.method public showErrorDialog(Ljava/lang/String;)V
    .locals 6
    .param p1, "errorId"    # Ljava/lang/String;

    .prologue
    .line 118
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->hasNetworkConnection()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v1, 0x4

    .line 120
    .local v1, "errorCode":I
    :goto_0
    new-instance v2, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$2;

    invoke-direct {v2, p0, p1}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$2;-><init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Ljava/lang/String;)V

    .line 126
    .local v2, "errorHandler":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0, p1}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->getErrorMessage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->notification_ok:I

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    move-object v3, p0

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportError(Lcom/amazon/mShop/AmazonActivity;ILcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    return-void

    .line 118
    .end local v1    # "errorCode":I
    .end local v2    # "errorHandler":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    :cond_0
    const/4 v1, 0x1

    goto :goto_0
.end method
