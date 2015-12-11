.class public Lcom/amazon/mShop/home/web/MShopWebHomeBar;
.super Landroid/widget/LinearLayout;
.source "MShopWebHomeBar.java"

# interfaces
.implements Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;
.implements Lcom/amazon/mShop/DelayedInitView;
.implements Lcom/amazon/mShop/actionBar/ActionBarIconController;
.implements Lcom/amazon/mShop/control/home/HomeSubscriber;


# instance fields
.field private final mActivity:Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

.field private mApplicationStarted:Z

.field private mHomeController:Lcom/amazon/mShop/control/home/HomeController;

.field private mShopByDepartmentLabel:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 57
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 52
    invoke-static {}, Lcom/amazon/mShop/control/home/HomeController;->getInstance()Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    .line 53
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mApplicationStarted:Z

    .line 58
    check-cast p1, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mActivity:Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mActivity:Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->calcWebviewStartTime()V

    .line 61
    iget-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/control/home/HomeController;->addSubscriberAtFirstPosition(Lcom/amazon/mShop/control/home/HomeSubscriber;)V

    .line 62
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)Lcom/amazon/mShop/control/home/HomeController;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    .prologue
    .line 46
    iget-boolean v0, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mApplicationStarted:Z

    return v0
.end method

.method static synthetic access$102(Lcom/amazon/mShop/home/web/MShopWebHomeBar;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/home/web/MShopWebHomeBar;
    .param p1, "x1"    # Z

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mApplicationStarted:Z

    return p1
.end method

.method static synthetic access$200(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mActivity:Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    return-object v0
.end method

.method private setupVoiceSearch()V
    .locals 4

    .prologue
    .line 107
    :try_start_0
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->web_home_shop_by_department_view:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 109
    .local v1, "sbd":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 110
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

    .line 115
    .end local v1    # "sbd":Landroid/view/View;
    :cond_0
    :goto_1
    return-void

    .line 110
    .restart local v1    # "sbd":Landroid/view/View;
    :cond_1
    const/16 v2, 0x8

    goto :goto_0

    .line 112
    .end local v1    # "sbd":Landroid/view/View;
    :catch_0
    move-exception v0

    .line 113
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v2, "WebHomeBar"

    const-string/jumbo v3, "Failed to setup voice search"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1
.end method

.method private updateShopByDepartmentLabel()V
    .locals 9

    .prologue
    const/16 v8, 0x21

    .line 150
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->categroy_browse_department:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 151
    .local v0, "boldText":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->getResources()Landroid/content/res/Resources;

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

    .line 152
    .local v2, "fullText":Ljava/lang/String;
    new-instance v3, Landroid/text/SpannableString;

    invoke-direct {v3, v2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 155
    .local v3, "ss":Landroid/text/SpannableString;
    const-string/jumbo v5, "ja_JP"

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 156
    iget-object v5, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mShopByDepartmentLabel:Landroid/widget/TextView;

    const/16 v6, 0x15

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setGravity(I)V

    .line 169
    :goto_0
    iget-object v5, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mShopByDepartmentLabel:Landroid/widget/TextView;

    invoke-virtual {v5, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 172
    return-void

    .line 159
    :cond_0
    invoke-virtual {v2, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    .line 160
    .local v4, "startIndex":I
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v1

    .line 162
    .local v1, "endIndex":I
    new-instance v5, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$color;->action_bar_shop_by_department_bold_text_color:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-direct {v5, v6}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v3, v5, v4, v1, v8}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 164
    new-instance v5, Landroid/text/style/AbsoluteSizeSpan;

    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$dimen;->gno_category_browse_department_size:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v6

    const/4 v7, 0x0

    invoke-direct {v5, v6, v7}, Landroid/text/style/AbsoluteSizeSpan;-><init>(IZ)V

    invoke-virtual {v3, v5, v4, v1, v8}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 167
    new-instance v5, Landroid/text/style/StyleSpan;

    const/4 v6, 0x1

    invoke-direct {v5, v6}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-virtual {v3, v5, v4, v1, v8}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto :goto_0
.end method


# virtual methods
.method public handleConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 188
    return-void
.end method

.method public isActionBarSearchIconFadeable()Z
    .locals 1

    .prologue
    .line 177
    const/4 v0, 0x1

    return v0
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 66
    invoke-super {p0}, Landroid/widget/LinearLayout;->onAttachedToWindow()V

    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/control/home/HomeController;->addSubscriberAtFirstPosition(Lcom/amazon/mShop/control/home/HomeSubscriber;)V

    .line 68
    iget-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mActivity:Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->registerConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V

    .line 69
    return-void
.end method

.method public onAvailableCountReceived(I)V
    .locals 0
    .param p1, "availableCount"    # I

    .prologue
    .line 234
    return-void
.end method

.method public onCancelled()V
    .locals 0

    .prologue
    .line 202
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 73
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 74
    iget-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/control/home/HomeController;->removeSubscriber(Lcom/amazon/mShop/control/home/HomeSubscriber;)V

    .line 75
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 207
    iget-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/home/HomeController;->clearException()V

    .line 208
    return-void
.end method

.method protected onFinishInflate()V
    .locals 2

    .prologue
    .line 79
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 81
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->web_home_shop_by_department_label:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mShopByDepartmentLabel:Landroid/widget/TextView;

    .line 82
    invoke-direct {p0}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->updateShopByDepartmentLabel()V

    .line 83
    iget-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mShopByDepartmentLabel:Landroid/widget/TextView;

    new-instance v1, Lcom/amazon/mShop/home/web/MShopWebHomeBar$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/home/web/MShopWebHomeBar$1;-><init>(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 97
    invoke-static {}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->getInstance()Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->shopByDepartmentEnabled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 98
    invoke-direct {p0}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->setupVoiceSearch()V

    .line 100
    :cond_0
    return-void
.end method

.method public onHomeCallStarted()V
    .locals 0

    .prologue
    .line 218
    return-void
.end method

.method public onHomeShoveler0Received(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
    .locals 2
    .param p1, "shoveler"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    .prologue
    .line 238
    if-nez p1, :cond_1

    .line 261
    :cond_0
    :goto_0
    return-void

    .line 244
    :cond_1
    sget-object v0, Lcom/amazon/mShop/sso/IdentityType;->CENTRAL_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v1

    if-ne v0, v1, :cond_0

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->hasAmazonAccount()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 247
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->getInstance(Landroid/content/Context;)Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/home/web/MShopWebHomeBar$3;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/home/web/MShopWebHomeBar$3;-><init>(Lcom/amazon/mShop/home/web/MShopWebHomeBar;Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->postDbOperation(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public onHomeShoveler1Received(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
    .locals 2
    .param p1, "shoveler"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    .prologue
    .line 265
    if-nez p1, :cond_1

    .line 290
    :cond_0
    :goto_0
    return-void

    .line 272
    :cond_1
    sget-object v0, Lcom/amazon/mShop/sso/IdentityType;->CENTRAL_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v1

    if-ne v0, v1, :cond_0

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->hasAmazonAccount()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 275
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->getInstance(Landroid/content/Context;)Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/home/web/MShopWebHomeBar$4;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/home/web/MShopWebHomeBar$4;-><init>(Lcom/amazon/mShop/home/web/MShopWebHomeBar;Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->postDbOperation(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public onNotificationReceived(Lcom/amazon/rio/j2me/client/services/mShop/Notification;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    .prologue
    .line 223
    return-void
.end method

.method public onObjectReceived(Ljava/lang/Object;I)V
    .locals 0
    .param p1, "o"    # Ljava/lang/Object;
    .param p2, "index"    # I

    .prologue
    .line 193
    return-void
.end method

.method public onObjectsReceived()V
    .locals 0

    .prologue
    .line 198
    return-void
.end method

.method public onPageComplete()V
    .locals 0

    .prologue
    .line 229
    return-void
.end method

.method public onPromoSlot0Received(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .prologue
    .line 295
    return-void
.end method

.method public onPromoSlot1Received(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .prologue
    .line 300
    return-void
.end method

.method public onPushViewCompleted()V
    .locals 1

    .prologue
    .line 119
    new-instance v0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$2;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/home/web/MShopWebHomeBar$2;-><init>(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->post(Ljava/lang/Runnable;)Z

    .line 147
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .locals 3
    .param p1, "hasFocus"    # Z

    .prologue
    .line 308
    :try_start_0
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onWindowFocusChanged(Z)V

    .line 310
    if-eqz p1, :cond_0

    .line 311
    invoke-direct {p0}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->setupVoiceSearch()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 316
    :cond_0
    :goto_0
    return-void

    .line 313
    :catch_0
    move-exception v0

    .line 314
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v1, "WebHomeBar"

    const-string/jumbo v2, "onWindowFocusChanged error"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public preHomeCallStarted()V
    .locals 0

    .prologue
    .line 213
    return-void
.end method
