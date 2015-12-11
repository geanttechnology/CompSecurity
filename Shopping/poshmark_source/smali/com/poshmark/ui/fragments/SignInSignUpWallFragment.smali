.class public Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "SignInSignUpWallFragment.java"


# static fields
.field public static final LOGIN_REQUEST:I = 0x1

.field public static final SIGNIN_ACTIVITY_BACK_PRESSED:I = 0x2


# instance fields
.field fbDeferredDeepLink:Landroid/os/Bundle;

.field fbLoginBtn:Landroid/widget/Button;

.field googleLoginBtn:Landroid/widget/Button;

.field signInBtn:Landroid/widget/Button;

.field signUpBtn:Landroid/widget/Button;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->doFbLogin()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;Lcom/poshmark/user/UserInfo;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;
    .param p1, "x1"    # Lcom/poshmark/user/UserInfo;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->login(Lcom/poshmark/user/UserInfo;)V

    return-void
.end method

.method private doFbLogin()V
    .locals 4

    .prologue
    .line 255
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v0

    .line 256
    .local v0, "helper":Lcom/poshmark/fb_tmblr_twitter/FbHelper;
    const/4 v1, 0x1

    const/4 v2, 0x7

    sget v3, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_READ_REQUEST:I

    invoke-virtual {v0, p0, v1, v2, v3}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->link(Lcom/poshmark/ui/fragments/PMFragment;III)V

    .line 257
    return-void
.end method

.method private handleFbLoginResult(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x0

    .line 234
    if-eqz p1, :cond_0

    .line 235
    const-string v6, "HAS_ERROR"

    invoke-virtual {p1, v6, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    .line 236
    .local v5, "hasError":Z
    if-nez v5, :cond_1

    .line 237
    const-string v6, "ACCESS_LEVEL"

    invoke-virtual {p1, v6, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 238
    .local v0, "accessLevel":I
    const-string v6, "ACCESS_TOKEN"

    invoke-virtual {p1, v6, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 239
    .local v1, "accessToken":Ljava/lang/String;
    const-string v6, "FB_DATE"

    invoke-virtual {p1, v6, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 241
    .local v4, "formattedDate":Ljava/lang/String;
    if-eqz v1, :cond_0

    if-eqz v4, :cond_0

    and-int/lit8 v6, v0, 0x1

    const/4 v7, 0x1

    if-ne v6, v7, :cond_0

    .line 242
    invoke-virtual {p0, v1, v4}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->fbLloginComplete(Ljava/lang/String;Ljava/lang/String;)V

    .line 252
    .end local v0    # "accessLevel":I
    .end local v1    # "accessToken":Ljava/lang/String;
    .end local v4    # "formattedDate":Ljava/lang/String;
    .end local v5    # "hasError":Z
    :cond_0
    :goto_0
    return-void

    .line 245
    .restart local v5    # "hasError":Z
    :cond_1
    const-string v6, "ERROR_JSON"

    invoke-virtual {p1, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 246
    .local v3, "errorJson":Ljava/lang/String;
    if-eqz v3, :cond_0

    .line 247
    invoke-static {v3}, Lcom/poshmark/http/api/PMApiError;->deserialize(Ljava/lang/String;)Lcom/poshmark/http/api/PMApiError;

    move-result-object v2

    .line 248
    .local v2, "error":Lcom/poshmark/http/api/PMApiError;
    sget-object v6, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-static {v2, p0, v6}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->showFBLinkError(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    goto :goto_0
.end method

.method private login(Lcom/poshmark/user/UserInfo;)V
    .locals 6
    .param p1, "userInfo"    # Lcom/poshmark/user/UserInfo;

    .prologue
    .line 265
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    .line 266
    .local v0, "session":Lcom/poshmark/application/PMApplicationSession;
    invoke-virtual {v0, p1}, Lcom/poshmark/application/PMApplicationSession;->saveSession(Lcom/poshmark/user/UserInfo;)V

    .line 267
    const-string v1, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-static {v1}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 268
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "login_screen"

    const-string v3, "user"

    const-string v4, "login"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 270
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->finishActivity()V

    .line 271
    return-void
.end method

.method private setupButtonHandlers()V
    .locals 2

    .prologue
    .line 171
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c02dc

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->fbLoginBtn:Landroid/widget/Button;

    .line 172
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->fbLoginBtn:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$2;-><init>(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 184
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c02dd

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->googleLoginBtn:Landroid/widget/Button;

    .line 185
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->googleLoginBtn:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$3;-><init>(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 207
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c02d8

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->signInBtn:Landroid/widget/Button;

    .line 208
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->signInBtn:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$4;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$4;-><init>(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 221
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c02d9

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->signUpBtn:Landroid/widget/Button;

    .line 222
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->signUpBtn:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$5;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$5;-><init>(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 231
    return-void
.end method


# virtual methods
.method public fbLloginComplete(Ljava/lang/String;Ljava/lang/String;)V
    .locals 11
    .param p1, "accessToken"    # Ljava/lang/String;
    .param p2, "formattedDate"    # Ljava/lang/String;

    .prologue
    .line 274
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->isAdded()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 275
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v6

    iget-object v7, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v8, "user"

    const-string v9, "fb_connect_success"

    const/4 v10, 0x0

    invoke-virtual {v6, v7, v8, v9, v10}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 277
    const v6, 0x7f060190

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 279
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 280
    .local v2, "hash":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {}, Lcom/poshmark/utils/DeepLinkUtils;->getDeepLinkHash()Ljava/util/Map;

    move-result-object v0

    .line 281
    .local v0, "deepLinkMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v6

    if-lez v6, :cond_0

    .line 282
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->getView()Landroid/view/View;

    move-result-object v6

    invoke-virtual {v6}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v6

    check-cast v6, Landroid/app/Activity;

    invoke-static {v6}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingStackAsJson(Landroid/app/Activity;)Ljava/lang/String;

    move-result-object v5

    .line 283
    .local v5, "trackingJSON":Ljava/lang/String;
    const-string v6, "stack"

    invoke-virtual {v2, v6, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 285
    new-instance v6, Lcom/google/gson/GsonBuilder;

    invoke-direct {v6}, Lcom/google/gson/GsonBuilder;-><init>()V

    invoke-virtual {v6}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v1

    .line 286
    .local v1, "gson":Lcom/google/gson/Gson;
    new-instance v6, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$6;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$6;-><init>(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;)V

    invoke-virtual {v6}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$6;->getType()Ljava/lang/reflect/Type;

    move-result-object v3

    .line 287
    .local v3, "hashMap":Ljava/lang/reflect/Type;
    instance-of v6, v1, Lcom/google/gson/Gson;

    if-nez v6, :cond_2

    invoke-virtual {v1, v0, v3}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v4

    .line 288
    .end local v1    # "gson":Lcom/google/gson/Gson;
    .local v4, "json":Ljava/lang/String;
    :goto_0
    const-string v6, "deeplinks"

    invoke-virtual {v2, v6, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 290
    .end local v3    # "hashMap":Ljava/lang/reflect/Type;
    .end local v4    # "json":Ljava/lang/String;
    .end local v5    # "trackingJSON":Ljava/lang/String;
    :cond_0
    const-string v6, "fb"

    new-instance v7, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;

    invoke-direct {v7, p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$7;-><init>(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;)V

    invoke-static {v6, p1, p2, v2, v7}, Lcom/poshmark/http/api/PMApi;->saveExternalServiceInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 327
    .end local v0    # "deepLinkMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v2    # "hash":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    return-void

    .line 287
    .restart local v0    # "deepLinkMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    .restart local v2    # "hash":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v3    # "hashMap":Ljava/lang/reflect/Type;
    .restart local v5    # "trackingJSON":Ljava/lang/String;
    :cond_2
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, v0, v3}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v4

    goto :goto_0
.end method

.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 112
    const-string v0, "nus"

    return-object v0
.end method

.method public googleLoginComplete(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "googleLoginBundle"    # Landroid/os/Bundle;

    .prologue
    .line 331
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "user"

    const-string v3, "gp_connect_success"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 334
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 335
    const-string v0, "TOKEN"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$8;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$8;-><init>(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;Landroid/os/Bundle;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->gpLogin(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 349
    return-void
.end method

.method public handleBack()Z
    .locals 2

    .prologue
    .line 125
    const/4 v0, 0x2

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    .line 126
    const/4 v0, 0x1

    return v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 354
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    const-string v2, "com.poshmark.intents.PROFILE_UPDATED"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 355
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 356
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->getView()Landroid/view/View;

    move-result-object v0

    .line 357
    .local v0, "v":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 358
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->setCustomBanner()V

    .line 363
    .end local v0    # "v":Landroid/view/View;
    :cond_0
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 78
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 79
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->setupButtonHandlers()V

    .line 80
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->setCustomBanner()V

    .line 81
    sget-object v1, Lcom/poshmark/config/EnvConfig;->ENV:Lcom/poshmark/config/Env;

    sget-object v2, Lcom/poshmark/config/Env;->DEV:Lcom/poshmark/config/Env;

    if-ne v1, v2, :cond_0

    const-string v1, "https://api.poshmark.com"

    if-nez v1, :cond_0

    .line 82
    new-instance v0, Lcom/poshmark/utils/PMSetIPDialog;

    invoke-direct {v0}, Lcom/poshmark/utils/PMSetIPDialog;-><init>()V

    .line 83
    .local v0, "ipDlg":Lcom/poshmark/utils/PMSetIPDialog;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "pmLoveDlg"

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/utils/PMSetIPDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 86
    .end local v0    # "ipDlg":Lcom/poshmark/utils/PMSetIPDialog;
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 64
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->bShouldHideActionBar:Z

    .line 65
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 66
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 70
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 72
    const v1, 0x7f0300bd

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 73
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 261
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroy()V

    .line 262
    return-void
.end method

.method public onFragmentResult(Landroid/os/Bundle;I)V
    .locals 1
    .param p1, "b"    # Landroid/os/Bundle;
    .param p2, "requestCode"    # I

    .prologue
    .line 90
    sget v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_READ_REQUEST:I

    if-ne p2, v0, :cond_0

    .line 91
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 92
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->handleFbLoginResult(Landroid/os/Bundle;)V

    .line 95
    :cond_0
    return-void
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    .line 99
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 100
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.PROFILE_UPDATED"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 101
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 106
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 107
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 108
    return-void
.end method

.method public setCustomBanner()V
    .locals 4

    .prologue
    .line 131
    sget-object v2, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->getCurrentDeepLinkProcessingState()Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

    move-result-object v2

    sget-object v3, Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;->DL_RECEIVED:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

    if-ne v2, v3, :cond_0

    .line 132
    sget-object v2, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->getImageUrl()Ljava/lang/String;

    move-result-object v1

    .line 133
    .local v1, "url":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 134
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    .line 135
    .local v0, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    new-instance v2, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment$1;-><init>(Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;)V

    invoke-virtual {v0, v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;)V

    .line 166
    .end local v0    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    .end local v1    # "url":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 118
    const-string v0, "login_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 119
    return-void
.end method
