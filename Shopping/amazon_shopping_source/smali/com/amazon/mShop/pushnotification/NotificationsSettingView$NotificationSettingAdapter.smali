.class Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;
.super Landroid/widget/BaseExpandableListAdapter;
.source "NotificationsSettingView.java"

# interfaces
.implements Landroid/widget/ExpandableListView$OnChildClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/pushnotification/NotificationsSettingView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "NotificationSettingAdapter"
.end annotation


# instance fields
.field private mGroupList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)V
    .locals 1

    .prologue
    .line 172
    iput-object p1, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    invoke-direct {p0}, Landroid/widget/BaseExpandableListAdapter;-><init>()V

    .line 175
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->mGroupList:Ljava/util/List;

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Lcom/amazon/mShop/pushnotification/NotificationsSettingView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/pushnotification/NotificationsSettingView;
    .param p2, "x1"    # Lcom/amazon/mShop/pushnotification/NotificationsSettingView$1;

    .prologue
    .line 172
    invoke-direct {p0, p1}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;-><init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)V

    return-void
.end method

.method private getChildrenOfTheGroup(I)Ljava/util/List;
    .locals 2
    .param p1, "groupPosition"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;",
            ">;"
        }
    .end annotation

    .prologue
    .line 182
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    # getter for: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mNotificationSetting:Ljava/util/Map;
    invoke-static {v0}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$200(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Ljava/util/Map;

    move-result-object v1

    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->mGroupList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;->getGroupId()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method


# virtual methods
.method public getChild(II)Ljava/lang/Object;
    .locals 1
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I

    .prologue
    .line 187
    invoke-direct {p0, p1}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->getChildrenOfTheGroup(I)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getChildId(II)J
    .locals 2
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I

    .prologue
    .line 192
    int-to-long v0, p2

    return-wide v0
.end method

.method public getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 12
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I
    .param p3, "isLastChild"    # Z
    .param p4, "convertView"    # Landroid/view/View;
    .param p5, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 206
    move-object/from16 v4, p4

    check-cast v4, Landroid/widget/LinearLayout;

    .line 207
    .local v4, "childView":Landroid/widget/LinearLayout;
    if-nez v4, :cond_0

    .line 208
    iget-object v9, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    # getter for: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v9}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$100(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v9

    invoke-virtual {v9}, Lcom/amazon/mShop/AmazonActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v9

    sget v10, Lcom/amazon/mShop/android/lib/R$layout;->notification_setting_item:I

    const/4 v11, 0x0

    invoke-virtual {v9, v10, v11}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v4

    .end local v4    # "childView":Landroid/widget/LinearLayout;
    check-cast v4, Landroid/widget/LinearLayout;

    .line 212
    .restart local v4    # "childView":Landroid/widget/LinearLayout;
    :cond_0
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->item_text_block:I

    invoke-virtual {v4, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 213
    .local v2, "childTextBlock":Landroid/view/View;
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->item_name:I

    invoke-virtual {v4, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 214
    .local v3, "childTitle":Landroid/widget/TextView;
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->item_checkbox:I

    invoke-virtual {v4, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;

    .line 215
    .local v0, "checkBox":Lcom/amazon/mShop/ui/AmazonSwitchWidget;
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->sign_in_to_view:I

    invoke-virtual {v4, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 216
    .local v7, "signInToView":Landroid/widget/TextView;
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->item_description:I

    invoke-virtual {v4, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 217
    .local v1, "childDescription":Landroid/widget/TextView;
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v5

    .line 218
    .local v5, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    invoke-virtual {v5}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getCurrentMShopDeviceToken()Ljava/lang/String;

    move-result-object v6

    .line 219
    .local v6, "registrationId":Ljava/lang/String;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->getChild(II)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    .line 221
    .local v8, "subscription":Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    invoke-virtual {v8}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getRequiresUserRecognized()Ljava/lang/Boolean;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v9

    if-nez v9, :cond_1

    .line 222
    const/4 v9, 0x0

    invoke-virtual {v7, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 223
    iget-object v9, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    # invokes: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->getStringIdForSignInLabel(Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)I
    invoke-static {v9, v8}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$300(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)I

    move-result v9

    invoke-virtual {v7, v9}, Landroid/widget/TextView;->setText(I)V

    .line 224
    const/16 v9, 0x8

    invoke-virtual {v2, v9}, Landroid/view/View;->setVisibility(I)V

    .line 225
    const/16 v9, 0x8

    invoke-virtual {v0, v9}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setVisibility(I)V

    .line 226
    new-instance v9, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;

    invoke-direct {v9, p0, v8}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1;-><init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;)V

    invoke-virtual {v7, v9}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 280
    :goto_0
    return-object v4

    .line 259
    :cond_1
    const/16 v9, 0x8

    invoke-virtual {v7, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 260
    const/4 v9, 0x0

    invoke-virtual {v2, v9}, Landroid/view/View;->setVisibility(I)V

    .line 261
    const/4 v9, 0x0

    invoke-virtual {v0, v9}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setVisibility(I)V

    .line 262
    const/16 v9, 0x8

    invoke-virtual {v1, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 263
    invoke-virtual {v8}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getTitle()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 265
    invoke-virtual {v8}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getDetails()Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    move-result-object v9

    if-eqz v9, :cond_2

    invoke-virtual {v8}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getDetails()Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    move-result-object v9

    invoke-virtual {v9}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getText()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_2

    .line 266
    invoke-virtual {v8}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getDetails()Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    move-result-object v9

    invoke-virtual {v9}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getText()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 267
    const/4 v9, 0x0

    invoke-virtual {v1, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 270
    :cond_2
    const/4 v9, 0x0

    invoke-virtual {v0, v9}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 271
    invoke-virtual {v8}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getSubscribed()Z

    move-result v9

    invoke-virtual {v0, v9}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setChecked(Z)V

    .line 272
    new-instance v9, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$2;

    invoke-direct {v9, p0, v8, v6}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$2;-><init>(Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Ljava/lang/String;)V

    invoke-virtual {v0, v9}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    goto :goto_0
.end method

.method public getChildrenCount(I)I
    .locals 1
    .param p1, "groupPosition"    # I

    .prologue
    .line 197
    invoke-direct {p0, p1}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->getChildrenOfTheGroup(I)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 198
    invoke-direct {p0, p1}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->getChildrenOfTheGroup(I)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 199
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getGroup(I)Ljava/lang/Object;
    .locals 1
    .param p1, "groupPosition"    # I

    .prologue
    .line 285
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->mGroupList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getGroupCount()I
    .locals 1

    .prologue
    .line 290
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->mGroupList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getGroupId(I)J
    .locals 2
    .param p1, "groupPosition"    # I

    .prologue
    .line 295
    int-to-long v0, p1

    return-wide v0
.end method

.method public getGroupList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;",
            ">;"
        }
    .end annotation

    .prologue
    .line 178
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->mGroupList:Ljava/util/List;

    return-object v0
.end method

.method public getGroupView(IZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "groupPosition"    # I
    .param p2, "isExpanded"    # Z
    .param p3, "convertView"    # Landroid/view/View;
    .param p4, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v1, 0x0

    .line 301
    move-object v0, p3

    check-cast v0, Lcom/amazon/mShop/search/GroupItemView;

    .line 302
    .local v0, "groupItemView":Lcom/amazon/mShop/search/GroupItemView;
    if-nez v0, :cond_0

    .line 303
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    # getter for: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v2}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$100(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->search_refine_group_view:I

    invoke-virtual {v2, v3, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .end local v0    # "groupItemView":Lcom/amazon/mShop/search/GroupItemView;
    check-cast v0, Lcom/amazon/mShop/search/GroupItemView;

    .line 306
    .restart local v0    # "groupItemView":Lcom/amazon/mShop/search/GroupItemView;
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->mGroupList:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;->getDetails()Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    move-result-object v2

    if-nez v2, :cond_1

    .line 307
    .local v1, "subTitle":Ljava/lang/String;
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->mGroupList:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2, v1, p2}, Lcom/amazon/mShop/search/GroupItemView;->update(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 308
    return-object v0

    .line 306
    .end local v1    # "subTitle":Ljava/lang/String;
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->mGroupList:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;->getDetails()Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getText()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 318
    const/4 v0, 0x1

    return v0
.end method

.method public isChildSelectable(II)Z
    .locals 1
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I

    .prologue
    .line 313
    const/4 v0, 0x1

    return v0
.end method

.method public onChildClick(Landroid/widget/ExpandableListView;Landroid/view/View;IIJ)Z
    .locals 4
    .param p1, "parent"    # Landroid/widget/ExpandableListView;
    .param p2, "notificationSettingItem"    # Landroid/view/View;
    .param p3, "groupPosition"    # I
    .param p4, "childPosition"    # I
    .param p5, "id"    # J

    .prologue
    .line 326
    invoke-virtual {p0, p3, p4}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->getChild(II)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    .line 328
    .local v1, "subscription":Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getRequiresUserRecognized()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v2

    if-nez v2, :cond_0

    .line 331
    const/4 v2, 0x0

    .line 337
    :goto_0
    return v2

    .line 335
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    .line 336
    .local v0, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter;->this$0:Lcom/amazon/mShop/pushnotification/NotificationsSettingView;

    invoke-virtual {v0}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getCurrentMShopDeviceToken()Ljava/lang/String;

    move-result-object v3

    # invokes: Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->subscribe(Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Ljava/lang/String;)V
    invoke-static {v2, v1, v3}, Lcom/amazon/mShop/pushnotification/NotificationsSettingView;->access$900(Lcom/amazon/mShop/pushnotification/NotificationsSettingView;Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Ljava/lang/String;)V

    .line 337
    const/4 v2, 0x1

    goto :goto_0
.end method
