.class public Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;
.super Ljava/lang/Object;
.source "PinterestHelper.java"


# static fields
.field static INSTANCE:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper; = null

.field public static final PDKCLIENT_EXPLICIT_SHARE_REQUEST_CODE:I = 0x2516

.field public static final PDKCLIENT_EXTRA_RESULT:Ljava/lang/String; = "PDKCLIENT_EXTRA_RESULT"

.field public static final PDKCLIENT_REQUEST_CODE:I = 0x2244

.field public static final SERVICE_ID:Ljava/lang/String; = "pn"

.field static notificationListener:Lcom/poshmark/notifications/PMNotificationListener;


# instance fields
.field callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

.field connectCallback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

.field fragmentId:Ljava/util/UUID;

.field image_url:Ljava/lang/String;

.field loginCallback:Lcom/pinterest/android/pdk/PDKCallback;

.field note:Ljava/lang/String;

.field savedCallingFragmentBundle:Landroid/os/Bundle;

.field scopes:Ljava/util/List;

.field url:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 46
    const/4 v0, 0x0

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->INSTANCE:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    .line 211
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$2;

    invoke-direct {v0}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$2;-><init>()V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->notificationListener:Lcom/poshmark/notifications/PMNotificationListener;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->scopes:Ljava/util/List;

    .line 140
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;

    invoke-direct {v0, p0}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;-><init>(Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;)V

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->loginCallback:Lcom/pinterest/android/pdk/PDKCallback;

    .line 61
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->scopes:Ljava/util/List;

    const-string v1, "read_public"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 62
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->scopes:Ljava/util/List;

    const-string v1, "write_public"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 63
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->scopes:Ljava/util/List;

    const-string v1, "read_relationships"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 64
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "4794312476046927699"

    invoke-static {v0, v1}, Lcom/pinterest/android/pdk/PDKClient;->configureInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/pinterest/android/pdk/PDKClient;

    .line 65
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;)Lcom/poshmark/ui/fragments/PMFragment;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->getCurrentFragmentCaller()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    return-object v0
.end method

.method private getCurrentFragmentCaller()Lcom/poshmark/ui/fragments/PMFragment;
    .locals 7

    .prologue
    const/4 v3, 0x0

    .line 221
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v2

    .line 222
    .local v2, "topActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v2, :cond_0

    iget-object v4, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->savedCallingFragmentBundle:Landroid/os/Bundle;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->fragmentId:Ljava/util/UUID;

    if-eqz v4, :cond_0

    .line 224
    :try_start_0
    invoke-virtual {v2}, Lcom/poshmark/ui/PMActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->savedCallingFragmentBundle:Landroid/os/Bundle;

    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v6}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/support/v4/app/FragmentManager;->getFragment(Landroid/os/Bundle;Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 230
    :goto_0
    return-object v1

    .line 226
    :catch_0
    move-exception v0

    .local v0, "exception":Ljava/lang/IllegalStateException;
    move-object v1, v3

    .line 227
    goto :goto_0

    .end local v0    # "exception":Ljava/lang/IllegalStateException;
    :cond_0
    move-object v1, v3

    .line 230
    goto :goto_0
.end method

.method public static getInstance()Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;
    .locals 3

    .prologue
    .line 54
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->INSTANCE:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    if-nez v0, :cond_0

    .line 55
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    invoke-direct {v0}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;-><init>()V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->INSTANCE:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    .line 56
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.PINTEREST_DEEPLINK"

    sget-object v2, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->notificationListener:Lcom/poshmark/notifications/PMNotificationListener;

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 58
    :cond_0
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->INSTANCE:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    return-object v0
.end method


# virtual methods
.method public connect(Landroid/content/Context;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "connectCallback"    # Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    .prologue
    const/4 v1, 0x0

    .line 68
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getInstance()Lcom/pinterest/android/pdk/PDKClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/pinterest/android/pdk/PDKClient;->onConnect(Landroid/content/Context;)V

    .line 69
    iput-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 70
    iput-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->savedCallingFragmentBundle:Landroid/os/Bundle;

    .line 71
    iput-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->fragmentId:Ljava/util/UUID;

    .line 72
    iput-object p2, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->connectCallback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    .line 73
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getInstance()Lcom/pinterest/android/pdk/PDKClient;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->scopes:Ljava/util/List;

    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->loginCallback:Lcom/pinterest/android/pdk/PDKCallback;

    invoke-virtual {v0, p1, v1, v2}, Lcom/pinterest/android/pdk/PDKClient;->login(Landroid/content/Context;Ljava/util/List;Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 74
    return-void
.end method

.method public connect(Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 4
    .param p1, "callingFragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 77
    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 78
    .local v0, "context":Landroid/content/Context;
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getInstance()Lcom/pinterest/android/pdk/PDKClient;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/pinterest/android/pdk/PDKClient;->onConnect(Landroid/content/Context;)V

    .line 79
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->connectCallback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    .line 80
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 81
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    iput-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->savedCallingFragmentBundle:Landroid/os/Bundle;

    .line 82
    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/PMFragment;->getFragmentId()Ljava/util/UUID;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->fragmentId:Ljava/util/UUID;

    .line 83
    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->savedCallingFragmentBundle:Landroid/os/Bundle;

    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v3}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3, p1}, Landroid/support/v4/app/FragmentManager;->putFragment(Landroid/os/Bundle;Ljava/lang/String;Landroid/support/v4/app/Fragment;)V

    .line 85
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getInstance()Lcom/pinterest/android/pdk/PDKClient;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->scopes:Ljava/util/List;

    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->loginCallback:Lcom/pinterest/android/pdk/PDKCallback;

    invoke-virtual {v1, v0, v2, v3}, Lcom/pinterest/android/pdk/PDKClient;->login(Landroid/content/Context;Ljava/util/List;Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 86
    return-void
.end method

.method public destroy()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 236
    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->notificationListener:Lcom/poshmark/notifications/PMNotificationListener;

    .line 237
    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->connectCallback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    .line 238
    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->url:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->image_url:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->note:Ljava/lang/String;

    .line 239
    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->INSTANCE:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    .line 240
    return-void
.end method

.method public explicitShare(Landroid/content/Context;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "connectCallback"    # Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    .prologue
    .line 90
    iput-object p2, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->connectCallback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    .line 91
    const-string v3, "https://www.pinterest.com/pin/create/button/?url=%s&media=%s&description=%s"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->url:Ljava/lang/String;

    invoke-static {v6}, Lcom/poshmark/utils/StringUtils;->urlEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->image_url:Ljava/lang/String;

    invoke-static {v6}, Lcom/poshmark/utils/StringUtils;->urlEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->note:Ljava/lang/String;

    invoke-static {v6}, Lcom/poshmark/utils/StringUtils;->urlEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 94
    .local v0, "finalUrl":Ljava/lang/String;
    new-instance v1, Landroid/content/Intent;

    const-string v3, "android.intent.action.VIEW"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-direct {v1, v3, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 95
    .local v1, "intent":Landroid/content/Intent;
    const-string v3, "com.pinterest"

    invoke-static {p1, v1, v3}, Lcom/poshmark/utils/ExternalAppUtils;->filterByPackageName(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 96
    .local v2, "packageName":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 97
    invoke-virtual {v1, v2}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 99
    :cond_0
    check-cast p1, Lcom/poshmark/ui/PMActivity;

    .end local p1    # "context":Landroid/content/Context;
    const/16 v3, 0x2516

    invoke-virtual {p1, v1, v3}, Lcom/poshmark/ui/PMActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 100
    return-void
.end method

.method public explicitShare(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "callingFragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 103
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->connectCallback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    .line 104
    iput-object p2, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 105
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    iput-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->savedCallingFragmentBundle:Landroid/os/Bundle;

    .line 106
    invoke-virtual {p2}, Lcom/poshmark/ui/fragments/PMFragment;->getFragmentId()Ljava/util/UUID;

    move-result-object v3

    iput-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->fragmentId:Ljava/util/UUID;

    .line 107
    const-string v3, "https://www.pinterest.com/pin/create/button/?url=%s&media=%s&description=%s"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->url:Ljava/lang/String;

    invoke-static {v6}, Lcom/poshmark/utils/StringUtils;->urlEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->image_url:Ljava/lang/String;

    invoke-static {v6}, Lcom/poshmark/utils/StringUtils;->urlEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->note:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 110
    .local v0, "finalUrl":Ljava/lang/String;
    new-instance v1, Landroid/content/Intent;

    const-string v3, "android.intent.action.VIEW"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-direct {v1, v3, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 111
    .local v1, "intent":Landroid/content/Intent;
    const-string v3, "com.pinterest"

    invoke-static {p1, v1, v3}, Lcom/poshmark/utils/ExternalAppUtils;->filterByPackageName(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 112
    .local v2, "packageName":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 113
    invoke-virtual {v1, v2}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 115
    :cond_0
    check-cast p1, Lcom/poshmark/ui/PMActivity;

    .end local p1    # "context":Landroid/content/Context;
    const/16 v3, 0x2516

    invoke-virtual {p1, v1, v3}, Lcom/poshmark/ui/PMActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 116
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 125
    const-string v0, "Pinterest Helper"

    const-string v1, "Authenticated Via App"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 126
    const/16 v0, 0x2244

    if-ne p1, v0, :cond_1

    .line 127
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getInstance()Lcom/pinterest/android/pdk/PDKClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/pinterest/android/pdk/PDKClient;->onOauthResponse(IILandroid/content/Intent;)V

    .line 138
    :cond_0
    :goto_0
    return-void

    .line 129
    :cond_1
    const/16 v0, 0x2516

    if-ne p1, v0, :cond_0

    .line 130
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->connectCallback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    if-eqz v0, :cond_2

    .line 131
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->connectCallback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;->success(ILandroid/os/Bundle;)V

    goto :goto_0

    .line 134
    :cond_2
    invoke-direct {p0}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->getCurrentFragmentCaller()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    goto :goto_0
.end method

.method public setData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "note"    # Ljava/lang/String;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "image_url"    # Ljava/lang/String;

    .prologue
    .line 119
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->note:Ljava/lang/String;

    .line 120
    iput-object p2, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->url:Ljava/lang/String;

    .line 121
    iput-object p3, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->image_url:Ljava/lang/String;

    .line 122
    return-void
.end method

.method public unlink()V
    .locals 1

    .prologue
    .line 244
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getInstance()Lcom/pinterest/android/pdk/PDKClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/pinterest/android/pdk/PDKClient;->logout()V

    .line 245
    return-void
.end method
