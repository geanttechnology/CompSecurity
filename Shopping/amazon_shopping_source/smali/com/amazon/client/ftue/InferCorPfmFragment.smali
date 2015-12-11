.class public Lcom/amazon/client/ftue/InferCorPfmFragment;
.super Landroid/support/v4/app/Fragment;
.source "InferCorPfmFragment.java"

# interfaces
.implements Lcom/amazon/client/ftue/InferenceResponseReceiver$Listener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/ftue/InferCorPfmFragment$Listener;,
        Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;,
        Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;
    }
.end annotation


# static fields
.field private static final LOG:Lcom/amazon/logging/Logger;


# instance fields
.field accountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field authCookieHelper:Ldagger/Lazy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/venezia/web/AuthCookieHelper;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private cookieSetterTask:Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;

.field private customerAttributeStoreFetcherTask:Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;

.field deviceInspector:Lcom/amazon/mas/client/device/DeviceInspector;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private fadText:Landroid/widget/TextView;

.field hardware:Lcom/amazon/mas/client/device/hardware/HardwareEvaluator;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private inferenceResponseReceiver:Lcom/amazon/client/ftue/InferenceResponseReceiver;

.field inferredCorPfm:Lcom/amazon/mas/client/authentication/InferredCorPfm;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private listener:Lcom/amazon/client/ftue/InferCorPfmFragment$Listener;

.field private marketplace:Lcom/amazon/venezia/web/Marketplace;

.field openglInterrogator:Lcom/amazon/mas/client/device/software/opengl/OpenGlActivityInterrogator;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field pageUrlFactory:Lcom/amazon/venezia/web/PageUrlFactory;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field resourceCache:Lcom/amazon/mcc/resources/ResourceCache;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private stack:Lcom/amazon/venezia/web/SSRStack;

.field webViewFactory:Lcom/amazon/venezia/web/WebViewBuilder;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private webview:Landroid/webkit/WebView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 67
    const-class v0, Lcom/amazon/client/ftue/InferCorPfmFragment;

    invoke-static {v0}, Lcom/amazon/venezia/logging/Loggers;->logger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/client/ftue/InferCorPfmFragment;->LOG:Lcom/amazon/logging/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 64
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 445
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/client/ftue/InferCorPfmFragment;)Lcom/amazon/venezia/web/Marketplace;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/client/ftue/InferCorPfmFragment;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->marketplace:Lcom/amazon/venezia/web/Marketplace;

    return-object v0
.end method

.method static synthetic access$002(Lcom/amazon/client/ftue/InferCorPfmFragment;Lcom/amazon/venezia/web/Marketplace;)Lcom/amazon/venezia/web/Marketplace;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/client/ftue/InferCorPfmFragment;
    .param p1, "x1"    # Lcom/amazon/venezia/web/Marketplace;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->marketplace:Lcom/amazon/venezia/web/Marketplace;

    return-object p1
.end method

.method static synthetic access$100(Lcom/amazon/client/ftue/InferCorPfmFragment;)Lcom/amazon/venezia/web/SSRStack;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/client/ftue/InferCorPfmFragment;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->stack:Lcom/amazon/venezia/web/SSRStack;

    return-object v0
.end method

.method static synthetic access$102(Lcom/amazon/client/ftue/InferCorPfmFragment;Lcom/amazon/venezia/web/SSRStack;)Lcom/amazon/venezia/web/SSRStack;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/client/ftue/InferCorPfmFragment;
    .param p1, "x1"    # Lcom/amazon/venezia/web/SSRStack;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->stack:Lcom/amazon/venezia/web/SSRStack;

    return-object p1
.end method

.method static synthetic access$200(Lcom/amazon/client/ftue/InferCorPfmFragment;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/client/ftue/InferCorPfmFragment;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 64
    invoke-direct {p0, p1, p2}, Lcom/amazon/client/ftue/InferCorPfmFragment;->buildMinifiedMasDeviceInfoCookie(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300()Lcom/amazon/logging/Logger;
    .locals 1

    .prologue
    .line 64
    sget-object v0, Lcom/amazon/client/ftue/InferCorPfmFragment;->LOG:Lcom/amazon/logging/Logger;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/client/ftue/InferCorPfmFragment;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/client/ftue/InferCorPfmFragment;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 64
    invoke-direct {p0, p1, p2}, Lcom/amazon/client/ftue/InferCorPfmFragment;->setMasDeviceInfoCookie(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/client/ftue/InferCorPfmFragment;)Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/client/ftue/InferCorPfmFragment;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->cookieSetterTask:Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;

    return-object v0
.end method

.method static synthetic access$502(Lcom/amazon/client/ftue/InferCorPfmFragment;Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;)Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/client/ftue/InferCorPfmFragment;
    .param p1, "x1"    # Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->cookieSetterTask:Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;

    return-object p1
.end method

.method static synthetic access$600(Lcom/amazon/client/ftue/InferCorPfmFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/client/ftue/InferCorPfmFragment;

    .prologue
    .line 64
    invoke-direct {p0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->setInferenceFailed()V

    return-void
.end method

.method static synthetic access$700(Lcom/amazon/client/ftue/InferCorPfmFragment;)Landroid/webkit/WebView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/client/ftue/InferCorPfmFragment;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->webview:Landroid/webkit/WebView;

    return-object v0
.end method

.method private buildMinifiedMasDeviceInfoCookie(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p1, "pfm"    # Ljava/lang/String;
    .param p2, "cor"    # Ljava/lang/String;

    .prologue
    .line 237
    iget-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->hardware:Lcom/amazon/mas/client/device/hardware/HardwareEvaluator;

    invoke-interface {v2}, Lcom/amazon/mas/client/device/hardware/HardwareEvaluator;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 238
    .local v0, "displayMetrics":Landroid/util/DisplayMetrics;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "masclient-device-info=dpi:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, v0, Landroid/util/DisplayMetrics;->density:F

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "|w:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "|h:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "|xdpi:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, v0, Landroid/util/DisplayMetrics;->xdpi:F

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "|ydpi:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, v0, Landroid/util/DisplayMetrics;->ydpi:F

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "|cor:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "|pfm:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "|layout:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v3

    iget v3, v3, Landroid/content/res/Configuration;->screenLayout:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "|deviceType:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->deviceInspector:Lcom/amazon/mas/client/device/DeviceInspector;

    invoke-interface {v3}, Lcom/amazon/mas/client/device/DeviceInspector;->getDeviceType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "|androidTargetSdkVersion:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v3

    iget v3, v3, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 249
    .local v1, "masDeviceInfoCookie":Ljava/lang/String;
    sget-object v2, Lcom/amazon/client/ftue/InferCorPfmFragment;->LOG:Lcom/amazon/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Minified version of mas-device-info cookie :"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/logging/Logger;->d(Ljava/lang/String;)V

    .line 250
    return-object v1
.end method

.method private getInferenceStatus(Ljava/lang/String;)Lcom/amazon/mas/client/authentication/InferredCorPfm$InferenceStatus;
    .locals 5
    .param p1, "status"    # Ljava/lang/String;

    .prologue
    .line 387
    sget-object v1, Lcom/amazon/mas/client/authentication/InferredCorPfm$InferenceStatus;->FAILED:Lcom/amazon/mas/client/authentication/InferredCorPfm$InferenceStatus;

    .line 388
    .local v1, "inferStatus":Lcom/amazon/mas/client/authentication/InferredCorPfm$InferenceStatus;
    if-eqz p1, :cond_0

    .line 390
    :try_start_0
    invoke-static {p1}, Lcom/amazon/mas/client/authentication/InferredCorPfm$InferenceStatus;->valueOf(Ljava/lang/String;)Lcom/amazon/mas/client/authentication/InferredCorPfm$InferenceStatus;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 395
    :cond_0
    :goto_0
    return-object v1

    .line 391
    :catch_0
    move-exception v0

    .line 392
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    sget-object v2, Lcom/amazon/client/ftue/InferCorPfmFragment;->LOG:Lcom/amazon/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Unknown Mapping for status:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/logging/Logger;->e(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private mapAuthenticatedInferenceExperience()V
    .locals 3

    .prologue
    .line 271
    iget-object v1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->accountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->accountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccount()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 272
    new-instance v0, Lcom/amazon/mas/client/authentication/MASClientCustomerAttributeStore;

    invoke-virtual {p0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/mas/client/authentication/MASClientCustomerAttributeStore;-><init>(Landroid/content/Context;)V

    .line 274
    .local v0, "masClientCustomerAttributeStore":Lcom/amazon/mas/client/authentication/MASClientCustomerAttributeStore;
    new-instance v1, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;

    invoke-direct {v1, p0, v0}, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;-><init>(Lcom/amazon/client/ftue/InferCorPfmFragment;Lcom/amazon/mas/client/authentication/MASClientCustomerAttributeStore;)V

    iput-object v1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->customerAttributeStoreFetcherTask:Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;

    .line 276
    iget-object v1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->customerAttributeStoreFetcherTask:Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-static {v1, v2}, Lcom/amazon/venezia/concurrent/AsyncTasks;->executeInParallel(Landroid/os/AsyncTask;[Ljava/lang/Object;)V

    .line 278
    .end local v0    # "masClientCustomerAttributeStore":Lcom/amazon/mas/client/authentication/MASClientCustomerAttributeStore;
    :cond_0
    return-void
.end method

.method private setInferenceFailed()V
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 378
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->inferredCorPfm:Lcom/amazon/mas/client/authentication/InferredCorPfm;

    sget-object v5, Lcom/amazon/mas/client/authentication/InferredCorPfm$InferenceStatus;->FAILED:Lcom/amazon/mas/client/authentication/InferredCorPfm$InferenceStatus;

    move-object v2, v1

    move-object v3, v1

    move-object v4, v1

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mas/client/authentication/InferredCorPfm;->setInferenceResults(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mas/client/authentication/InferredCorPfm$InferenceStatus;)V

    .line 379
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->listener:Lcom/amazon/client/ftue/InferCorPfmFragment$Listener;

    invoke-interface {v0}, Lcom/amazon/client/ftue/InferCorPfmFragment$Listener;->onInferenceComplete()V

    .line 380
    return-void
.end method

.method private setMasDeviceInfoCookie(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "masDeviceInfoCookie"    # Ljava/lang/String;

    .prologue
    .line 212
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    .line 213
    .local v0, "cookieManager":Landroid/webkit/CookieManager;
    invoke-virtual {v0, p1, p2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 214
    return-void
.end method

.method private setUpWebView()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    const/4 v8, -0x1

    .line 220
    iget-object v1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->webViewFactory:Lcom/amazon/venezia/web/WebViewBuilder;

    invoke-virtual {p0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x2

    new-array v4, v4, [Lcom/amazon/venezia/web/client/WebViewClientComponent;

    new-instance v5, Lcom/amazon/venezia/web/client/SSRDialogErrorComponent;

    invoke-virtual {p0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-direct {v5, v6}, Lcom/amazon/venezia/web/client/SSRDialogErrorComponent;-><init>(Landroid/support/v4/app/FragmentActivity;)V

    aput-object v5, v4, v9

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/venezia/web/client/SSRDialogLinkComponent;

    invoke-virtual {p0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/amazon/venezia/web/client/SSRDialogLinkComponent;-><init>(Landroid/content/Context;)V

    aput-object v6, v4, v5

    invoke-static {v4}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v1, v2, p0, v3, v4}, Lcom/amazon/venezia/web/WebViewBuilder;->createWebViewWithoutCookies(Landroid/app/Activity;Landroid/support/v4/app/Fragment;Lcom/amazon/venezia/web/WebViewBuilder$Listener;Ljava/util/List;)Lcom/amazon/venezia/web/WebViewBuilder$Result;

    move-result-object v0

    .line 225
    .local v0, "result":Lcom/amazon/venezia/web/WebViewBuilder$Result;
    invoke-virtual {v0}, Lcom/amazon/venezia/web/WebViewBuilder$Result;->getWebView()Lcom/amazon/venezia/web/AppstoreWebView;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->webview:Landroid/webkit/WebView;

    .line 226
    iget-object v1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->webview:Landroid/webkit/WebView;

    invoke-virtual {v1, v9}, Landroid/webkit/WebView;->setBackgroundColor(I)V

    .line 227
    iget-object v1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->webview:Landroid/webkit/WebView;

    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v2, v8, v8}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 229
    return-void
.end method

.method private unAuthenticatedInferenceExperience()V
    .locals 4

    .prologue
    .line 259
    invoke-static {}, Lcom/amazon/venezia/web/Marketplace;->getMarketplaceByLocale()Lcom/amazon/venezia/web/Marketplace;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->marketplace:Lcom/amazon/venezia/web/Marketplace;

    .line 260
    iget-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->marketplace:Lcom/amazon/venezia/web/Marketplace;

    invoke-virtual {v2}, Lcom/amazon/venezia/web/Marketplace;->getStack()Lcom/amazon/venezia/web/SSRStack;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->stack:Lcom/amazon/venezia/web/SSRStack;

    .line 261
    iget-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->pageUrlFactory:Lcom/amazon/venezia/web/PageUrlFactory;

    iget-object v3, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->stack:Lcom/amazon/venezia/web/SSRStack;

    invoke-virtual {v2, v3}, Lcom/amazon/venezia/web/PageUrlFactory;->getPfmCorUrl(Lcom/amazon/venezia/web/SSRStack;)Ljava/lang/String;

    move-result-object v1

    .line 263
    .local v1, "url":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->marketplace:Lcom/amazon/venezia/web/Marketplace;

    invoke-virtual {v2}, Lcom/amazon/venezia/web/Marketplace;->getEMID()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->marketplace:Lcom/amazon/venezia/web/Marketplace;

    invoke-virtual {v3}, Lcom/amazon/venezia/web/Marketplace;->getCor()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v2, v3}, Lcom/amazon/client/ftue/InferCorPfmFragment;->buildMinifiedMasDeviceInfoCookie(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 264
    .local v0, "masDeviceInfoCookie":Ljava/lang/String;
    invoke-direct {p0, v1, v0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->setMasDeviceInfoCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 265
    iget-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->webview:Landroid/webkit/WebView;

    invoke-virtual {v2, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 266
    return-void
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 4
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 142
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onAttach(Landroid/app/Activity;)V

    .line 143
    instance-of v1, p1, Lcom/amazon/client/ftue/InferCorPfmFragment$Listener;

    if-eqz v1, :cond_0

    move-object v1, p1

    .line 144
    check-cast v1, Lcom/amazon/client/ftue/InferCorPfmFragment$Listener;

    iput-object v1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->listener:Lcom/amazon/client/ftue/InferCorPfmFragment$Listener;

    .line 150
    invoke-static {p0}, Lcom/amazon/android/dagger/DaggerAndroid;->inject(Ljava/lang/Object;)V

    .line 153
    invoke-static {p1}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    .line 154
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    .line 155
    .local v0, "cookieManager":Landroid/webkit/CookieManager;
    invoke-virtual {v0}, Landroid/webkit/CookieManager;->removeAllCookie()V

    .line 156
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 158
    invoke-static {p1}, Lcom/amazon/identity/auth/device/api/MAPInit;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPInit;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPInit;->initialize()V

    .line 159
    iget-object v1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->openglInterrogator:Lcom/amazon/mas/client/device/software/opengl/OpenGlActivityInterrogator;

    invoke-virtual {v1, p1}, Lcom/amazon/mas/client/device/software/opengl/OpenGlActivityInterrogator;->interrogate(Landroid/app/Activity;)V

    .line 160
    return-void

    .line 146
    .end local v0    # "cookieManager":Landroid/webkit/CookieManager;
    :cond_0
    new-instance v1, Ljava/lang/ClassCastException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " must implement "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-class v3, Lcom/amazon/client/ftue/InferCorPfmFragment$Listener;

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/ClassCastException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 165
    sget v2, Lcom/amazon/venezia/R$layout;->infercorpfm_fragment:I

    const/4 v3, 0x0

    invoke-virtual {p1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 166
    .local v1, "root":Landroid/view/View;
    sget v2, Lcom/amazon/venezia/R$id;->fad:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->fadText:Landroid/widget/TextView;

    .line 167
    iget-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->fadText:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->resourceCache:Lcom/amazon/mcc/resources/ResourceCache;

    const-string/jumbo v4, "title_WelcomeMotto"

    invoke-interface {v3, v4}, Lcom/amazon/mcc/resources/ResourceCache;->getText(Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 168
    invoke-direct {p0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->setUpWebView()V

    .line 169
    sget v2, Lcom/amazon/venezia/R$id;->inference_page_container:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 170
    .local v0, "frameView":Landroid/widget/FrameLayout;
    iget-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->webview:Landroid/webkit/WebView;

    invoke-virtual {v0, v2}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 172
    iget-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->accountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->accountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccount()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_0

    .line 173
    invoke-direct {p0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->unAuthenticatedInferenceExperience()V

    .line 177
    :goto_0
    return-object v1

    .line 175
    :cond_0
    invoke-direct {p0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->mapAuthenticatedInferenceExperience()V

    goto :goto_0
.end method

.method public onInferenceComplete(Landroid/content/Intent;)V
    .locals 10
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 346
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v6

    .line 347
    .local v6, "extras":Landroid/os/Bundle;
    if-eqz v6, :cond_0

    .line 348
    const-string/jumbo v0, "InferredCorPfm.PFM"

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 349
    .local v2, "pfm":Ljava/lang/String;
    const-string/jumbo v0, "InferredCorPfm.COR"

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 350
    .local v1, "cor":Ljava/lang/String;
    const-string/jumbo v0, "InferredCorPfm.STATUS"

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 351
    .local v7, "status":Ljava/lang/String;
    const-string/jumbo v0, "InferredCorPfm.AUTHPORTAL_DOMAIN"

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 352
    .local v3, "authPortalDomain":Ljava/lang/String;
    const-string/jumbo v0, "InferredCorPfm.AUTHPORTAL_ASSOCIATION_HANDLE"

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 354
    .local v4, "authPortalAssociationHandle":Ljava/lang/String;
    sget-object v0, Lcom/amazon/client/ftue/InferCorPfmFragment;->LOG:Lcom/amazon/logging/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "FTUE Parameters Received from SSR:Pfm:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ":Cor:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ":Status:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ":Domain:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ":associationHandle:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0, v8}, Lcom/amazon/logging/Logger;->d(Ljava/lang/String;)V

    .line 357
    invoke-direct {p0, v7}, Lcom/amazon/client/ftue/InferCorPfmFragment;->getInferenceStatus(Ljava/lang/String;)Lcom/amazon/mas/client/authentication/InferredCorPfm$InferenceStatus;

    move-result-object v5

    .line 358
    .local v5, "inferenceStatus":Lcom/amazon/mas/client/authentication/InferredCorPfm$InferenceStatus;
    sget-object v0, Lcom/amazon/client/ftue/InferCorPfmFragment;->LOG:Lcom/amazon/logging/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "Setting FTUE Inference Status:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0, v8}, Lcom/amazon/logging/Logger;->d(Ljava/lang/String;)V

    .line 359
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->inferredCorPfm:Lcom/amazon/mas/client/authentication/InferredCorPfm;

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mas/client/authentication/InferredCorPfm;->setInferenceResults(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mas/client/authentication/InferredCorPfm$InferenceStatus;)V

    .line 366
    .end local v1    # "cor":Ljava/lang/String;
    .end local v2    # "pfm":Ljava/lang/String;
    .end local v3    # "authPortalDomain":Ljava/lang/String;
    .end local v4    # "authPortalAssociationHandle":Ljava/lang/String;
    .end local v5    # "inferenceStatus":Lcom/amazon/mas/client/authentication/InferredCorPfm$InferenceStatus;
    .end local v7    # "status":Ljava/lang/String;
    :goto_0
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->listener:Lcom/amazon/client/ftue/InferCorPfmFragment$Listener;

    invoke-interface {v0}, Lcom/amazon/client/ftue/InferCorPfmFragment$Listener;->onInferenceComplete()V

    .line 367
    return-void

    .line 362
    :cond_0
    sget-object v0, Lcom/amazon/client/ftue/InferCorPfmFragment;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v8, "No Extras Received from SSR"

    invoke-virtual {v0, v8}, Lcom/amazon/logging/Logger;->d(Ljava/lang/String;)V

    .line 363
    invoke-direct {p0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->setInferenceFailed()V

    goto :goto_0
.end method

.method public onInferenceRequiresInteraction(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 371
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->listener:Lcom/amazon/client/ftue/InferCorPfmFragment$Listener;

    invoke-interface {v0}, Lcom/amazon/client/ftue/InferCorPfmFragment$Listener;->onInferenceRequiresInteraction()V

    .line 372
    return-void
.end method

.method public onStart()V
    .locals 3

    .prologue
    .line 182
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onStart()V

    .line 183
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->inferenceResponseReceiver:Lcom/amazon/client/ftue/InferenceResponseReceiver;

    if-nez v0, :cond_0

    .line 184
    new-instance v0, Lcom/amazon/client/ftue/InferenceResponseReceiver;

    invoke-direct {v0, p0}, Lcom/amazon/client/ftue/InferenceResponseReceiver;-><init>(Lcom/amazon/client/ftue/InferenceResponseReceiver$Listener;)V

    iput-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->inferenceResponseReceiver:Lcom/amazon/client/ftue/InferenceResponseReceiver;

    .line 185
    invoke-virtual {p0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->inferenceResponseReceiver:Lcom/amazon/client/ftue/InferenceResponseReceiver;

    iget-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->inferenceResponseReceiver:Lcom/amazon/client/ftue/InferenceResponseReceiver;

    invoke-virtual {v2}, Lcom/amazon/client/ftue/InferenceResponseReceiver;->getIntentFilter()Landroid/content/IntentFilter;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 187
    :cond_0
    return-void
.end method

.method public onStop()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 191
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onStop()V

    .line 192
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->inferenceResponseReceiver:Lcom/amazon/client/ftue/InferenceResponseReceiver;

    if-eqz v0, :cond_0

    .line 193
    invoke-virtual {p0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->inferenceResponseReceiver:Lcom/amazon/client/ftue/InferenceResponseReceiver;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 194
    iput-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->inferenceResponseReceiver:Lcom/amazon/client/ftue/InferenceResponseReceiver;

    .line 196
    :cond_0
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->cookieSetterTask:Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;

    if-eqz v0, :cond_1

    .line 197
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->cookieSetterTask:Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;

    invoke-virtual {v0, v3}, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;->cancel(Z)Z

    .line 198
    iput-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->cookieSetterTask:Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;

    .line 200
    :cond_1
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->customerAttributeStoreFetcherTask:Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;

    if-eqz v0, :cond_2

    .line 201
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->customerAttributeStoreFetcherTask:Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;

    invoke-virtual {v0, v3}, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->cancel(Z)Z

    .line 202
    iput-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment;->customerAttributeStoreFetcherTask:Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;

    .line 204
    :cond_2
    return-void
.end method
