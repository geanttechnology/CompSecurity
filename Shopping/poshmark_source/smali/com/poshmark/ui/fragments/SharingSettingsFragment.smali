.class public Lcom/poshmark/ui/fragments/SharingSettingsFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "SharingSettingsFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# instance fields
.field private FB:Ljava/lang/String;

.field private PN:Ljava/lang/String;

.field private TM:Ljava/lang/String;

.field private TW:Ljava/lang/String;

.field private autoLaunchServiceConnect:Z

.field fbShareClickListener:Landroid/view/View$OnClickListener;

.field private fbShareLayout:Landroid/widget/RelativeLayout;

.field private gPlusShareLayout:Landroid/widget/RelativeLayout;

.field googlePlusShareClickListener:Landroid/view/View$OnClickListener;

.field isPinterestButtonEnabled:Z

.field private launchConnectServiceId:Ljava/lang/String;

.field pinterestShareClickListener:Landroid/view/View$OnClickListener;

.field private pinterestShareLayout:Landroid/widget/RelativeLayout;

.field searchIndexListener:Landroid/widget/CompoundButton$OnCheckedChangeListener;

.field private searchIndexSwitch:Landroid/widget/Switch;

.field settingsData:Lcom/poshmark/user/UserInfoDetails$Settings;

.field shareToFbTimelineClickListener:Landroid/view/View$OnClickListener;

.field shareToFbTimelineListener:Landroid/widget/CompoundButton$OnCheckedChangeListener;

.field private timelineOptionSwitch:Landroid/widget/Switch;

.field tmShareClickListener:Landroid/view/View$OnClickListener;

.field private tumblrShareLayout:Landroid/widget/RelativeLayout;

.field twShareClickListener:Landroid/view/View$OnClickListener;

.field private twitterShareLayout:Landroid/widget/RelativeLayout;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 48
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->autoLaunchServiceConnect:Z

    .line 50
    const-string v0, "fb"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->FB:Ljava/lang/String;

    .line 51
    const-string v0, "tw"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->TW:Ljava/lang/String;

    .line 52
    const-string v0, "tm"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->TM:Ljava/lang/String;

    .line 53
    const-string v0, "pn"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->PN:Ljava/lang/String;

    .line 55
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->isPinterestButtonEnabled:Z

    .line 170
    new-instance v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->fbShareClickListener:Landroid/view/View$OnClickListener;

    .line 205
    new-instance v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$3;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$3;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->pinterestShareClickListener:Landroid/view/View$OnClickListener;

    .line 217
    new-instance v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->twShareClickListener:Landroid/view/View$OnClickListener;

    .line 269
    new-instance v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$5;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->tmShareClickListener:Landroid/view/View$OnClickListener;

    .line 321
    new-instance v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->googlePlusShareClickListener:Landroid/view/View$OnClickListener;

    .line 380
    new-instance v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$7;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$7;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->searchIndexListener:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    .line 402
    new-instance v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$9;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$9;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->shareToFbTimelineClickListener:Landroid/view/View$OnClickListener;

    .line 410
    new-instance v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$10;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$10;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->shareToFbTimelineListener:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/SharingSettingsFragment;Landroid/view/View;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SharingSettingsFragment;
    .param p1, "x1"    # Landroid/view/View;

    .prologue
    .line 37
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->setupView(Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    .prologue
    .line 37
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->autoLaunchServiceConnect:Z

    return v0
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->autoLaunchServiceConnect()V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->updateFBShareLayout()V

    return-void
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->connectToPinterest()V

    return-void
.end method

.method static synthetic access$500(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->updateTwitterShareLayout()V

    return-void
.end method

.method static synthetic access$600(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->updateTumblrShareLayout()V

    return-void
.end method

.method static synthetic access$700(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->updateGoogleShareLayout()V

    return-void
.end method

.method static synthetic access$800(Lcom/poshmark/ui/fragments/SharingSettingsFragment;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SharingSettingsFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 37
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->setSearchSettings(Z)V

    return-void
.end method

.method static synthetic access$900(Lcom/poshmark/ui/fragments/SharingSettingsFragment;Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SharingSettingsFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;

    .prologue
    .line 37
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->handleChangeSettingsResponse(Lcom/poshmark/http/api/PMApiResponse;)V

    return-void
.end method

.method private autoLaunchServiceConnect()V
    .locals 2

    .prologue
    .line 105
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->launchConnectServiceId:Ljava/lang/String;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->FB:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 117
    :cond_0
    :goto_0
    return-void

    .line 107
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->launchConnectServiceId:Ljava/lang/String;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->TW:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 109
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->launchConnectServiceId:Ljava/lang/String;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->TM:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 111
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->launchConnectServiceId:Ljava/lang/String;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->PN:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 112
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getPinterestToken()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    .line 113
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->autoLaunchServiceConnect:Z

    .line 114
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->connectToPinterest()V

    goto :goto_0
.end method

.method private connectToPinterest()V
    .locals 5

    .prologue
    .line 614
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getViewNameForAnalytics()Ljava/lang/String;

    move-result-object v1

    const-string v2, "user"

    const-string v3, "connect_pinterest_initiated"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 615
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060190

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 616
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->getGlobalConnectManager()Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->pinterestLink(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 617
    return-void
.end method

.method private handleChangeSettingsResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 443
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 450
    :goto_0
    return-void

    .line 447
    :cond_0
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->UPDATE_USER_PROFILE:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    const v3, 0x7f060101

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private pinterestConnectFinish()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 621
    new-instance v0, Lcom/poshmark/utils/view_holders/PinterestDialog;

    invoke-direct {v0}, Lcom/poshmark/utils/view_holders/PinterestDialog;-><init>()V

    .line 622
    .local v0, "dialog":Lcom/poshmark/utils/view_holders/PinterestDialog;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "post_connect_pinterest_dlg_screen"

    invoke-virtual {v1, v2}, Lcom/poshmark/analytics/Analytics;->trackView(Ljava/lang/String;)V

    .line 623
    sget-object v1, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;->POST_CONN:Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/view_holders/PinterestDialog;->setCurrent_mode(Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;)V

    .line 624
    new-instance v1, Lcom/poshmark/ui/fragments/SharingSettingsFragment$12;

    invoke-direct {v1, p0, v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$12;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;Lcom/poshmark/utils/view_holders/PinterestDialog;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/view_holders/PinterestDialog;->setClickListener(Landroid/view/View$OnClickListener;)V

    .line 630
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "pin"

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/utils/view_holders/PinterestDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 631
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/application/PMApplicationSession;->setPinterestPostDialogShown(Ljava/lang/Boolean;)V

    .line 632
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/application/PMApplicationSession;->setPinterestPreDialogShownFlag(Ljava/lang/Boolean;)V

    .line 634
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->setupView(Landroid/view/View;)V

    .line 635
    return-void
.end method

.method private setFacebookPostToTimelineSettings(Z)V
    .locals 1
    .param p1, "bTimelineSettings"    # Z

    .prologue
    .line 432
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/poshmark/application/PMApplicationSession;->setFacebookPostToTimelineFlag(Z)V

    .line 433
    new-instance v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$11;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$11;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    invoke-static {p1, v0}, Lcom/poshmark/http/api/PMApi;->postFacebookTimelineFlag(ZLcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 441
    return-void
.end method

.method private setSearchSettings(Z)V
    .locals 1
    .param p1, "bSearchVisibility"    # Z

    .prologue
    .line 388
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/poshmark/application/PMApplicationSession;->setSearchVisibilityFlag(Z)V

    .line 389
    const v0, 0x7f0602b5

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 390
    new-instance v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$8;

    invoke-direct {v0, p0, p1}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$8;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;Z)V

    invoke-static {p1, v0}, Lcom/poshmark/http/api/PMApi;->postSearchVisibilityFlag(ZLcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 400
    return-void
.end method

.method private setupView(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 453
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->updateFBShareLayout()V

    .line 454
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->updateTwitterShareLayout()V

    .line 455
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->updateTumblrShareLayout()V

    .line 456
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->updatePinterestShareLayout()V

    .line 459
    const v0, 0x7f0c02c3

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Switch;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->searchIndexSwitch:Landroid/widget/Switch;

    .line 460
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->searchIndexSwitch:Landroid/widget/Switch;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->settingsData:Lcom/poshmark/user/UserInfoDetails$Settings;

    iget-boolean v1, v1, Lcom/poshmark/user/UserInfoDetails$Settings;->search_visibility:Z

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setChecked(Z)V

    .line 461
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->searchIndexSwitch:Landroid/widget/Switch;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->searchIndexListener:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 462
    return-void
.end method

.method private updateFBShareLayout()V
    .locals 12

    .prologue
    const v11, 0x7f0c020b

    const/4 v10, 0x0

    .line 488
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getView()Landroid/view/View;

    move-result-object v7

    const v8, 0x7f0c02bc

    invoke-virtual {v7, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/RelativeLayout;

    iput-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    .line 489
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v7}, Landroid/widget/RelativeLayout;->getPaddingTop()I

    move-result v6

    .line 490
    .local v6, "padding":I
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x7f020024

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 491
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v7, v6, v6, v6, v6}, Landroid/widget/RelativeLayout;->setPadding(IIII)V

    .line 493
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    const v8, 0x7f0c01ba

    invoke-virtual {v7, v8}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    .line 494
    .local v5, "fbTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v7, 0x7f060108

    invoke-virtual {p0, v7}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 495
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    iget-object v8, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->fbShareClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v7, v8}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 497
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    const v8, 0x7f0c01bd

    invoke-virtual {v7, v8}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    .line 498
    .local v1, "connectTextView":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    const v8, 0x7f0c01be

    invoke-virtual {v7, v8}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 500
    .local v0, "connectIconView":Landroid/widget/ImageView;
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v7

    sget-object v8, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->READ_PERMISSION:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->isPermissionEnabled(Ljava/lang/String;)Z

    move-result v4

    .line 501
    .local v4, "fbReadPermissionEnabled":Z
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v7

    sget-object v8, Lcom/poshmark/fb_tmblr_twitter/FBPermissionStates;->PUBLISH_PERMISSION:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->isPermissionEnabled(Ljava/lang/String;)Z

    move-result v3

    .line 502
    .local v3, "fbPublishPermissionEnabled":Z
    if-eqz v4, :cond_2

    .line 503
    const v7, 0x7f060095

    invoke-virtual {p0, v7}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v7}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 504
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f02007d

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 505
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f090039

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v7

    invoke-virtual {v1, v7}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 506
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v7, v11}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 507
    .local v2, "extraOptionsLayout":Landroid/widget/LinearLayout;
    invoke-virtual {v2, v10}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 508
    const v7, 0x7f0c02bb

    invoke-virtual {v2, v7}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/Switch;

    iput-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->timelineOptionSwitch:Landroid/widget/Switch;

    .line 509
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->settingsData:Lcom/poshmark/user/UserInfoDetails$Settings;

    iget-boolean v7, v7, Lcom/poshmark/user/UserInfoDetails$Settings;->timeline:Z

    if-eqz v7, :cond_1

    .line 511
    if-eqz v3, :cond_0

    .line 512
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->timelineOptionSwitch:Landroid/widget/Switch;

    const/4 v8, 0x1

    invoke-virtual {v7, v8}, Landroid/widget/Switch;->setChecked(Z)V

    .line 519
    :goto_0
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->timelineOptionSwitch:Landroid/widget/Switch;

    iget-object v8, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->shareToFbTimelineListener:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    invoke-virtual {v7, v8}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 528
    :goto_1
    return-void

    .line 514
    :cond_0
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->timelineOptionSwitch:Landroid/widget/Switch;

    invoke-virtual {v7, v10}, Landroid/widget/Switch;->setChecked(Z)V

    goto :goto_0

    .line 517
    :cond_1
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->timelineOptionSwitch:Landroid/widget/Switch;

    iget-object v8, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->settingsData:Lcom/poshmark/user/UserInfoDetails$Settings;

    iget-boolean v8, v8, Lcom/poshmark/user/UserInfoDetails$Settings;->timeline:Z

    invoke-virtual {v7, v8}, Landroid/widget/Switch;->setChecked(Z)V

    goto :goto_0

    .line 522
    .end local v2    # "extraOptionsLayout":Landroid/widget/LinearLayout;
    :cond_2
    const v7, 0x7f060094

    invoke-virtual {p0, v7}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v7}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 523
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f09003c

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v7

    invoke-virtual {v1, v7}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 524
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f0200a5

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 525
    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->fbShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v7, v11}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 526
    .restart local v2    # "extraOptionsLayout":Landroid/widget/LinearLayout;
    const/16 v7, 0x8

    invoke-virtual {v2, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_1
.end method

.method private updateGoogleShareLayout()V
    .locals 9

    .prologue
    .line 585
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getView()Landroid/view/View;

    move-result-object v6

    const v7, 0x7f0c02c0

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout;

    .line 586
    .local v4, "googleShareLayout":Landroid/widget/LinearLayout;
    const v6, 0x7f0c02c1

    invoke-virtual {v4, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/RelativeLayout;

    iput-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->gPlusShareLayout:Landroid/widget/RelativeLayout;

    .line 588
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->getGoogleToken()Ljava/lang/String;

    move-result-object v3

    .line 590
    .local v3, "gPlusToken":Ljava/lang/String;
    if-eqz v3, :cond_0

    .line 592
    const/4 v6, 0x0

    invoke-virtual {v4, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 594
    iget-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->gPlusShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v6}, Landroid/widget/RelativeLayout;->getPaddingTop()I

    move-result v5

    .line 595
    .local v5, "padding":I
    iget-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->gPlusShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f020021

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 596
    iget-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->gPlusShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v6, v5, v5, v5, v5}, Landroid/widget/RelativeLayout;->setPadding(IIII)V

    .line 598
    iget-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->gPlusShareLayout:Landroid/widget/RelativeLayout;

    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->googlePlusShareClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 599
    iget-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->gPlusShareLayout:Landroid/widget/RelativeLayout;

    const v7, 0x7f0c01ba

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    .line 600
    .local v2, "gPlusTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v6, 0x7f06013a

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 602
    iget-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->gPlusShareLayout:Landroid/widget/RelativeLayout;

    const v7, 0x7f0c01bd

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    .line 603
    .local v1, "connectTextView":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->gPlusShareLayout:Landroid/widget/RelativeLayout;

    const v7, 0x7f0c01be

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 605
    .local v0, "connectIconView":Landroid/widget/ImageView;
    const v6, 0x7f060095

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 606
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f02007d

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v0, v6}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 611
    .end local v0    # "connectIconView":Landroid/widget/ImageView;
    .end local v1    # "connectTextView":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v2    # "gPlusTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v5    # "padding":I
    :goto_0
    return-void

    .line 609
    :cond_0
    const/16 v6, 0x8

    invoke-virtual {v4, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method private updatePinterestShareLayout()V
    .locals 6

    .prologue
    .line 465
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getView()Landroid/view/View;

    move-result-object v4

    const v5, 0x7f0c02bd

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/RelativeLayout;

    iput-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->pinterestShareLayout:Landroid/widget/RelativeLayout;

    .line 466
    iget-boolean v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->isPinterestButtonEnabled:Z

    if-eqz v4, :cond_1

    .line 467
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->pinterestShareLayout:Landroid/widget/RelativeLayout;

    const v5, 0x7f0c01ba

    invoke-virtual {v4, v5}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    .line 468
    .local v2, "pinterestTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v4, 0x7f060203

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 469
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->pinterestShareLayout:Landroid/widget/RelativeLayout;

    const v5, 0x7f0c01bd

    invoke-virtual {v4, v5}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    .line 470
    .local v1, "connectTextView":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->pinterestShareLayout:Landroid/widget/RelativeLayout;

    const v5, 0x7f0c01be

    invoke-virtual {v4, v5}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 471
    .local v0, "connectIconView":Landroid/widget/ImageView;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getPinterestToken()Ljava/lang/String;

    move-result-object v3

    .line 472
    .local v3, "pinterestToken":Ljava/lang/String;
    if-eqz v3, :cond_0

    .line 473
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getPinterestUserName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 474
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f090039

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 481
    :goto_0
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->pinterestShareLayout:Landroid/widget/RelativeLayout;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->pinterestShareClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v4, v5}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 485
    .end local v0    # "connectIconView":Landroid/widget/ImageView;
    .end local v1    # "connectTextView":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v2    # "pinterestTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v3    # "pinterestToken":Ljava/lang/String;
    :goto_1
    return-void

    .line 477
    .restart local v0    # "connectIconView":Landroid/widget/ImageView;
    .restart local v1    # "connectTextView":Lcom/poshmark/ui/customviews/PMTextView;
    .restart local v2    # "pinterestTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    .restart local v3    # "pinterestToken":Ljava/lang/String;
    :cond_0
    const v4, 0x7f060094

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 478
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f09003c

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 479
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0200a5

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 483
    .end local v0    # "connectIconView":Landroid/widget/ImageView;
    .end local v1    # "connectTextView":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v2    # "pinterestTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v3    # "pinterestToken":Ljava/lang/String;
    :cond_1
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->pinterestShareLayout:Landroid/widget/RelativeLayout;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_1
.end method

.method private updateTumblrShareLayout()V
    .locals 9

    .prologue
    .line 553
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getView()Landroid/view/View;

    move-result-object v6

    const v7, 0x7f0c02bf

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/RelativeLayout;

    iput-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    .line 556
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->getGoogleToken()Ljava/lang/String;

    move-result-object v2

    .line 557
    .local v2, "gPlusToken":Ljava/lang/String;
    if-nez v2, :cond_0

    .line 558
    iget-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v6}, Landroid/widget/RelativeLayout;->getPaddingTop()I

    move-result v3

    .line 559
    .local v3, "padding":I
    iget-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f020021

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 560
    iget-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v6, v3, v3, v3, v3}, Landroid/widget/RelativeLayout;->setPadding(IIII)V

    .line 563
    .end local v3    # "padding":I
    :cond_0
    iget-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    iget-object v7, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->tmShareClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 564
    iget-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    const v7, 0x7f0c01ba

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    .line 565
    .local v5, "tumblrTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v6, 0x7f06029e

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 567
    iget-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    const v7, 0x7f0c01bd

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    .line 568
    .local v1, "connectTextView":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->tumblrShareLayout:Landroid/widget/RelativeLayout;

    const v7, 0x7f0c01be

    invoke-virtual {v6, v7}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 570
    .local v0, "connectIconView":Landroid/widget/ImageView;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->getTumblrToken()Ljava/lang/String;

    move-result-object v4

    .line 571
    .local v4, "tmToken":Ljava/lang/String;
    if-eqz v4, :cond_1

    .line 572
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->getTumblrUsername()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 573
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f090039

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v1, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 574
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f02007d

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v0, v6}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 581
    :goto_0
    return-void

    .line 577
    :cond_1
    const v6, 0x7f060094

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 578
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f09003c

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v1, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 579
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f0200a5

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v0, v6}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method private updateTwitterShareLayout()V
    .locals 6

    .prologue
    .line 531
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getView()Landroid/view/View;

    move-result-object v4

    const v5, 0x7f0c02be

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/RelativeLayout;

    iput-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->twitterShareLayout:Landroid/widget/RelativeLayout;

    .line 532
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->twitterShareLayout:Landroid/widget/RelativeLayout;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->twShareClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v4, v5}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 533
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->twitterShareLayout:Landroid/widget/RelativeLayout;

    const v5, 0x7f0c01ba

    invoke-virtual {v4, v5}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMTextView;

    .line 534
    .local v3, "twitterTitleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v4, 0x7f0602a0

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 536
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->twitterShareLayout:Landroid/widget/RelativeLayout;

    const v5, 0x7f0c01bd

    invoke-virtual {v4, v5}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    .line 537
    .local v1, "connectTextView":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->twitterShareLayout:Landroid/widget/RelativeLayout;

    const v5, 0x7f0c01be

    invoke-virtual {v4, v5}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 539
    .local v0, "connectIconView":Landroid/widget/ImageView;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getTwitterToken()Ljava/lang/String;

    move-result-object v2

    .line 540
    .local v2, "twToken":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 541
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getTwitterUsername()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 542
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f02007d

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 543
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f090039

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 550
    :goto_0
    return-void

    .line 546
    :cond_0
    const v4, 0x7f060094

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 547
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f09003c

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 548
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0200a5

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method


# virtual methods
.method public handleNotification(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 638
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 81
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 82
    const v0, 0x7f06025e

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->setTitle(I)V

    .line 83
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 84
    new-instance v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$1;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getUserSettings(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 102
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 60
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 61
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 62
    if-nez p1, :cond_0

    .line 64
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ext_service_id"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->launchConnectServiceId:Ljava/lang/String;

    .line 65
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->launchConnectServiceId:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 66
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->autoLaunchServiceConnect:Z

    .line 69
    :cond_0
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FeatureManager;->isPinterestButtonEnabled()Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->isPinterestButtonEnabled:Z

    .line 70
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 74
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 75
    const v1, 0x7f0300b5

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 76
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onFragmentResult(Landroid/os/Bundle;I)V
    .locals 11
    .param p1, "result"    # Landroid/os/Bundle;
    .param p2, "requestCode"    # I

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 121
    sget v6, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_PUBLISH_REQUEST:I

    if-ne p2, v6, :cond_2

    .line 123
    if-eqz p1, :cond_0

    .line 124
    const-string v6, "HAS_ERROR"

    invoke-virtual {p1, v6, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    .line 125
    .local v3, "hasError":Z
    const-string v6, "ACCESS_LEVEL"

    invoke-virtual {p1, v6, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v2

    .line 126
    .local v2, "granterPermissions":I
    if-nez v3, :cond_1

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->isAdded()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 127
    and-int/lit8 v6, v2, 0x8

    if-eqz v6, :cond_0

    .line 128
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->updateFBShareLayout()V

    .line 164
    .end local v2    # "granterPermissions":I
    .end local v3    # "hasError":Z
    :cond_0
    :goto_0
    return-void

    .line 131
    .restart local v2    # "granterPermissions":I
    .restart local v3    # "hasError":Z
    :cond_1
    const-string v6, "ERROR_JSON"

    invoke-virtual {p1, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 132
    .local v1, "errorJson":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 133
    invoke-static {v1}, Lcom/poshmark/http/api/PMApiError;->deserialize(Ljava/lang/String;)Lcom/poshmark/http/api/PMApiError;

    move-result-object v0

    .line 134
    .local v0, "error":Lcom/poshmark/http/api/PMApiError;
    invoke-static {v0, p0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->showFBLinkError(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/fragments/PMFragment;)V

    goto :goto_0

    .line 139
    .end local v0    # "error":Lcom/poshmark/http/api/PMApiError;
    .end local v1    # "errorJson":Ljava/lang/String;
    .end local v2    # "granterPermissions":I
    .end local v3    # "hasError":Z
    :cond_2
    sget v6, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_AUTO_TIMELINE_REQUEST:I

    if-ne p2, v6, :cond_5

    .line 140
    const-string v6, "ACCESS_LEVEL"

    invoke-virtual {p1, v6, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v4

    .line 141
    .local v4, "permissions":I
    and-int/lit8 v6, v4, 0x8

    if-eqz v6, :cond_4

    .line 142
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getView()Landroid/view/View;

    move-result-object v5

    .line 143
    .local v5, "v":Landroid/view/View;
    if-eqz v5, :cond_3

    .line 144
    invoke-direct {p0, v5}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->setupView(Landroid/view/View;)V

    .line 146
    :cond_3
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6, v8}, Lcom/poshmark/application/PMApplicationSession;->setFacebookPostToTimelineFlag(Z)V

    .line 147
    const/4 v6, 0x0

    invoke-static {v8, v6}, Lcom/poshmark/http/api/PMApi;->postFacebookTimelineFlag(ZLcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 149
    .end local v5    # "v":Landroid/view/View;
    :cond_4
    iget-object v6, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->timelineOptionSwitch:Landroid/widget/Switch;

    invoke-virtual {v6, v7}, Landroid/widget/Switch;->setChecked(Z)V

    goto :goto_0

    .line 151
    .end local v4    # "permissions":I
    :cond_5
    const/16 v6, 0x2244

    if-ne p2, v6, :cond_0

    .line 152
    if-eqz p1, :cond_0

    .line 153
    const-string v6, "HAS_ERROR"

    invoke-virtual {p1, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v3

    .line 154
    .restart local v3    # "hasError":Z
    if-eqz v3, :cond_6

    .line 155
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v6

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getViewNameForAnalytics()Ljava/lang/String;

    move-result-object v7

    const-string v8, "user"

    const-string v9, "connect_pinterest_failed"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v10

    invoke-virtual {v10}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v7, v8, v9, v10}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 156
    const v6, 0x7f06022e

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;)V

    goto :goto_0

    .line 158
    :cond_6
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v6

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getViewNameForAnalytics()Ljava/lang/String;

    move-result-object v7

    const-string v8, "user"

    const-string v9, "connect_pinterest_complete"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v10

    invoke-virtual {v10}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v7, v8, v9, v10}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->pinterestConnectFinish()V

    goto/16 :goto_0
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 167
    const-string v0, "share_settings_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 168
    return-void
.end method
