.class public Lcom/amazon/mShop/youraccount/OneClickSettingsView;
.super Landroid/widget/ScrollView;
.source "OneClickSettingsView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;
.implements Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;


# instance fields
.field private final amazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field private controller:Lcom/amazon/mShop/control/account/OneClickController;

.field private final deviceNameEdit:Landroid/widget/EditText;

.field private final digitalOneClickExplanation:Landroid/widget/TextView;

.field private final oneClickOnOffButton:Landroid/widget/CompoundButton;

.field private final oneClickOnOffContainer:Landroid/view/ViewGroup;

.field private final oneClickSettingWholeRow:Landroid/widget/LinearLayout;

.field private final shippingAndPaymentsView:Landroid/widget/TextView;

.field private final swapView:Z

.field private final taskCallback:Lcom/amazon/mShop/TaskCallbackFactory;

.field private viewDisplayed:Z


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;Z)V
    .locals 6
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "swapView"    # Z

    .prologue
    .line 79
    invoke-direct {p0, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 80
    iput-object p1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 81
    iput-boolean p2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->swapView:Z

    .line 83
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->oneclick_settings:I

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    .line 85
    .local v1, "content":Landroid/view/ViewGroup;
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->addView(Landroid/view/View;)V

    .line 87
    new-instance v2, Lcom/amazon/mShop/control/account/OneClickController;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/control/account/OneClickController;-><init>(Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;)V

    iput-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    .line 88
    new-instance v2, Lcom/amazon/mShop/TaskCallbackFactory;

    invoke-direct {v2, p1}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->taskCallback:Lcom/amazon/mShop/TaskCallbackFactory;

    .line 90
    iget-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/account/OneClickController;->hasServiceCallRunning()Z

    move-result v2

    if-nez v2, :cond_0

    .line 91
    iget-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    iget-object v3, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->taskCallback:Lcom/amazon/mShop/TaskCallbackFactory;

    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_loading:I

    invoke-virtual {v3, v4, v5}, Lcom/amazon/mShop/TaskCallbackFactory;->getTaskCallback(Lcom/amazon/mShop/control/Cancellable;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/control/account/OneClickController;->doGetOneClickConfig(Lcom/amazon/mShop/control/TaskCallback;)V

    .line 95
    :cond_0
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->oneclick_settings_toggle_container:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    iput-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->oneClickOnOffContainer:Landroid/view/ViewGroup;

    .line 99
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->oneclick_settings_whole_row:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->oneClickSettingWholeRow:Landroid/widget/LinearLayout;

    .line 100
    iget-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->oneClickSettingWholeRow:Landroid/widget/LinearLayout;

    new-instance v3, Lcom/amazon/mShop/youraccount/OneClickSettingsView$1;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView$1;-><init>(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)V

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 108
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->oneclick_settings_toggle_button:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/CompoundButton;

    iput-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->oneClickOnOffButton:Landroid/widget/CompoundButton;

    .line 109
    iget-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->oneClickOnOffButton:Landroid/widget/CompoundButton;

    new-instance v3, Lcom/amazon/mShop/youraccount/OneClickSettingsView$2;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView$2;-><init>(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)V

    invoke-virtual {v2, v3}, Landroid/widget/CompoundButton;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 130
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->digital_oneclick_explanation:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->digitalOneClickExplanation:Landroid/widget/TextView;

    .line 131
    invoke-static {}, Lcom/amazon/mShop/util/ConfigUtils;->isDigitalContentEnabled()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 132
    iget-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->digitalOneClickExplanation:Landroid/widget/TextView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 137
    :goto_0
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->oneclick_settings_device_name:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    iput-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->deviceNameEdit:Landroid/widget/EditText;

    .line 139
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->oneclick_settings_shipping_and_payments_data:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->shippingAndPaymentsView:Landroid/widget/TextView;

    .line 140
    iget-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->shippingAndPaymentsView:Landroid/widget/TextView;

    new-instance v3, Lcom/amazon/mShop/youraccount/OneClickSettingsView$3;

    invoke-direct {v3, p0, p1}, Lcom/amazon/mShop/youraccount/OneClickSettingsView$3;-><init>(Lcom/amazon/mShop/youraccount/OneClickSettingsView;Lcom/amazon/mShop/AmazonActivity;)V

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 155
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->oneclick_settings_about_button:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 156
    .local v0, "aboutOneClick":Landroid/widget/Button;
    new-instance v2, Lcom/amazon/mShop/youraccount/OneClickSettingsView$4;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView$4;-><init>(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)V

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 162
    return-void

    .line 134
    .end local v0    # "aboutOneClick":Landroid/widget/Button;
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->digitalOneClickExplanation:Landroid/widget/TextView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;ZZ)V
    .locals 2
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "swapView"    # Z
    .param p3, "showContinueButton"    # Z

    .prologue
    .line 183
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;-><init>(Lcom/amazon/mShop/AmazonActivity;Z)V

    .line 185
    if-eqz p3, :cond_0

    .line 186
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->continue_button:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 187
    .local v0, "continueBtn":Landroid/widget/Button;
    new-instance v1, Lcom/amazon/mShop/youraccount/OneClickSettingsView$5;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/youraccount/OneClickSettingsView$5;-><init>(Lcom/amazon/mShop/youraccount/OneClickSettingsView;Lcom/amazon/mShop/AmazonActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 194
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 196
    .end local v0    # "continueBtn":Landroid/widget/Button;
    :cond_0
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/youraccount/OneClickSettingsView;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/youraccount/OneClickSettingsView;
    .param p1, "x1"    # Z

    .prologue
    .line 48
    invoke-direct {p0, p1}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->setOneClickSetting(Z)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->deviceNameEdit:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/TaskCallbackFactory;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->taskCallback:Lcom/amazon/mShop/TaskCallbackFactory;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->performAboutOneClick()V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method private performAboutOneClick()V
    .locals 4

    .prologue
    .line 202
    new-instance v0, Lcom/amazon/mShop/InfoView;

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_about_title:I

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_about_text:I

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mShop/InfoView;-><init>(Lcom/amazon/mShop/AmazonActivity;II)V

    .line 205
    .local v0, "infoView":Lcom/amazon/mShop/InfoView;
    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 206
    return-void
.end method

.method private setOneClickSetting(Z)V
    .locals 5
    .param p1, "isTurnOn"    # Z

    .prologue
    .line 165
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/account/OneClickController;->hasServiceCallRunning()Z

    move-result v0

    if-nez v0, :cond_1

    .line 166
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/account/OneClickController;->isDeviceNameSet()Z

    move-result v0

    if-nez v0, :cond_0

    .line 167
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->deviceNameEdit:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController;->setDeviceName(Ljava/lang/String;)V

    .line 170
    :cond_0
    if-eqz p1, :cond_2

    const-string/jumbo v0, "1clk_on"

    :goto_0
    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 171
    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    iget-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->taskCallback:Lcom/amazon/mShop/TaskCallbackFactory;

    iget-object v3, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    if-eqz p1, :cond_3

    sget v0, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_turning_on:I

    :goto_1
    invoke-virtual {v2, v3, v4, v0}, Lcom/amazon/mShop/TaskCallbackFactory;->getPopViewTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v0

    invoke-virtual {v1, p1, v0}, Lcom/amazon/mShop/control/account/OneClickController;->doSetOneClickEnabled(ZLcom/amazon/mShop/control/TaskCallback;)V

    .line 173
    :cond_1
    return-void

    .line 170
    :cond_2
    const-string/jumbo v0, "1clk_off"

    goto :goto_0

    .line 171
    :cond_3
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_turning_off:I

    goto :goto_1
.end method

.method private showSettingsViewIfNotDisplayed()V
    .locals 1

    .prologue
    .line 279
    iget-boolean v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->viewDisplayed:Z

    if-nez v0, :cond_0

    .line 280
    iget-boolean v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->swapView:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    instance-of v0, v0, Lcom/amazon/mShop/home/GatewayActivity;

    if-nez v0, :cond_1

    .line 281
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/AmazonActivity;->swapView(Landroid/view/View;)V

    .line 287
    :goto_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->viewDisplayed:Z

    .line 289
    :cond_0
    return-void

    .line 284
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    goto :goto_0
.end method

.method private updateUI()V
    .locals 9

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 209
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/account/OneClickController;->getOneClickConfigResponse()Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    move-result-object v1

    .line 210
    .local v1, "oneClickConfig":Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;
    if-nez v1, :cond_1

    .line 211
    const-string/jumbo v4, "Amazon.OnceClickSettingsView.updateUI"

    const-string/jumbo v5, "oneClickConfig is null"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 212
    iget-boolean v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->viewDisplayed:Z

    if-eqz v4, :cond_0

    .line 213
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v4}, Lcom/amazon/mShop/AmazonActivity;->popView()Z

    .line 276
    :cond_0
    :goto_0
    return-void

    .line 218
    :cond_1
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/account/OneClickController;->isDeviceNameSet()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 219
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->deviceNameEdit:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-virtual {v5}, Lcom/amazon/mShop/control/account/OneClickController;->getDeviceName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 220
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->deviceNameEdit:Landroid/widget/EditText;

    invoke-virtual {v4, v7}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 230
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->deviceNameEdit:Landroid/widget/EditText;

    invoke-virtual {v4, v7}, Landroid/widget/EditText;->setFocusable(Z)V

    .line 231
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->deviceNameEdit:Landroid/widget/EditText;

    invoke-virtual {v4, v7}, Landroid/widget/EditText;->setFocusableInTouchMode(Z)V

    .line 233
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->deviceNameEdit:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v5}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$color;->background_default:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setBackgroundColor(I)V

    .line 241
    :goto_1
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->getAddress()Lcom/amazon/rio/j2me/client/services/mShop/Address;

    move-result-object v0

    .line 242
    .local v0, "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->getPaymentMethod()Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    move-result-object v2

    .line 244
    .local v2, "paymentMethod":Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    if-nez v0, :cond_4

    .line 248
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/account/OneClickController;->isOneClickStatusEnabled()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 249
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->oneClickOnOffContainer:Landroid/view/ViewGroup;

    invoke-virtual {v4, v7}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 250
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->oneClickOnOffButton:Landroid/widget/CompoundButton;

    iget-object v5, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-virtual {v5}, Lcom/amazon/mShop/control/account/OneClickController;->isOneClickStatusEnabled()Z

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/CompoundButton;->setChecked(Z)V

    .line 255
    :goto_2
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->shippingAndPaymentsView:Landroid/widget/TextView;

    invoke-virtual {v4, v8}, Landroid/widget/TextView;->setEnabled(Z)V

    .line 256
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->shippingAndPaymentsView:Landroid/widget/TextView;

    invoke-virtual {v4, v8}, Landroid/widget/TextView;->setFocusable(Z)V

    .line 257
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->shippingAndPaymentsView:Landroid/widget/TextView;

    invoke-virtual {v4, v8}, Landroid/widget/TextView;->setClickable(Z)V

    .line 259
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->shippingAndPaymentsView:Landroid/widget/TextView;

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_shipping_and_payments_empty:I

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(I)V

    .line 260
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->shippingAndPaymentsView:Landroid/widget/TextView;

    iget-object v5, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v5}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$color;->error_text:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTextColor(I)V

    .line 275
    :goto_3
    invoke-direct {p0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->showSettingsViewIfNotDisplayed()V

    goto :goto_0

    .line 235
    .end local v0    # "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .end local v2    # "paymentMethod":Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    :cond_2
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->deviceNameEdit:Landroid/widget/EditText;

    invoke-static {}, Lcom/amazon/mShop/control/account/OneClickController;->getDefaultDeviceName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 236
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->deviceNameEdit:Landroid/widget/EditText;

    invoke-virtual {v4, v8}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 238
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->deviceNameEdit:Landroid/widget/EditText;

    iget-object v5, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v5}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$drawable;->edit_text:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1

    .line 252
    .restart local v0    # "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .restart local v2    # "paymentMethod":Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    :cond_3
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->oneClickOnOffContainer:Landroid/view/ViewGroup;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/ViewGroup;->setVisibility(I)V

    goto :goto_2

    .line 263
    :cond_4
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->oneClickOnOffContainer:Landroid/view/ViewGroup;

    invoke-virtual {v4, v7}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 264
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->oneClickOnOffButton:Landroid/widget/CompoundButton;

    iget-object v5, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-virtual {v5}, Lcom/amazon/mShop/control/account/OneClickController;->isOneClickStatusEnabled()Z

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/CompoundButton;->setChecked(Z)V

    .line 266
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->shippingAndPaymentsView:Landroid/widget/TextView;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->getOneClickStatus()Z

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setEnabled(Z)V

    .line 267
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->shippingAndPaymentsView:Landroid/widget/TextView;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->getOneClickStatus()Z

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setFocusable(Z)V

    .line 268
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->shippingAndPaymentsView:Landroid/widget/TextView;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->getOneClickStatus()Z

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setClickable(Z)V

    .line 270
    invoke-static {v0, v2}, Lcom/amazon/mShop/ui/resources/AddressFormat;->formatOneClickAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;)Ljava/lang/String;

    move-result-object v3

    .line 271
    .local v3, "shippingAndPayment":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->shippingAndPaymentsView:Landroid/widget/TextView;

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 272
    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->shippingAndPaymentsView:Landroid/widget/TextView;

    iget-object v5, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v5}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$color;->gray_text:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_3
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 48
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 370
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_title:I

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 4
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 328
    const-string/jumbo v2, "Amazon.OnceClickSettingsView.onError"

    invoke-virtual {p1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 329
    invoke-virtual {p1}, Ljava/lang/Exception;->printStackTrace()V

    .line 333
    invoke-direct {p0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->showSettingsViewIfNotDisplayed()V

    .line 335
    invoke-interface {p2}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->getMethod()Ljava/lang/String;

    move-result-object v0

    .line 337
    .local v0, "errorMethod":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;

    invoke-direct {v1, p0, v0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;-><init>(Lcom/amazon/mShop/youraccount/OneClickSettingsView;Ljava/lang/String;)V

    .line 362
    .local v1, "listener":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    iget-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-boolean v3, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->viewDisplayed:Z

    if-eqz v3, :cond_0

    .end local p0    # "this":Lcom/amazon/mShop/youraccount/OneClickSettingsView;
    :goto_0
    invoke-static {v2, v1, p0, p1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;)V

    .line 363
    return-void

    .line 362
    .restart local p0    # "this":Lcom/amazon/mShop/youraccount/OneClickSettingsView;
    :cond_0
    iget-object v3, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object p0

    goto :goto_0
.end method

.method public onReceiveOneClickAddresses(Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 295
    .local p1, "oneClickAddresses":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;>;"
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    new-instance v1, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;

    iget-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v3, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/account/OneClickController;->getSelectedOneClickAddress()Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-direct {v1, v2, v3, p1, v4}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;Ljava/util/List;Lcom/amazon/mShop/control/account/OneClickController;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 297
    return-void
.end method

.method public onReceiveOneClickConfig(Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;)V
    .locals 0
    .param p1, "oneClickConfigResponse"    # Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    .prologue
    .line 301
    invoke-direct {p0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->updateUI()V

    .line 302
    return-void
.end method

.method public onRequiresUserLogin(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V
    .locals 2
    .param p1, "callback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    .prologue
    .line 311
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    new-instance v1, Lcom/amazon/mShop/youraccount/OneClickSettingsView$6;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView$6;-><init>(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)V

    invoke-virtual {v0, p1, v1}, Lcom/amazon/mShop/AmazonActivity;->authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V

    .line 321
    return-void
.end method

.method public onSaveOneClickStatus(Z)V
    .locals 0
    .param p1, "oneClickEnabled"    # Z

    .prologue
    .line 306
    invoke-direct {p0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->updateUI()V

    .line 307
    return-void
.end method
