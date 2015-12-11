.class public Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;
.super Ljava/lang/Object;
.source "ExtServiceConnectManager.java"


# static fields
.field static gShareManager:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;


# instance fields
.field callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

.field tumblrHelper:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const/4 v0, 0x0

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->gShareManager:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    return-void
.end method

.method constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    invoke-direct {v0}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;-><init>()V

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->tumblrHelper:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    .line 29
    return-void
.end method

.method public static getGlobalConnectManager()Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;
    .locals 1

    .prologue
    .line 17
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->gShareManager:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    if-nez v0, :cond_0

    .line 18
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    invoke-direct {v0}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;-><init>()V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->gShareManager:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    .line 20
    :cond_0
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->gShareManager:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    return-object v0
.end method


# virtual methods
.method public fbGetUserInfo(Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;)V
    .locals 1
    .param p1, "callback"    # Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;

    .prologue
    .line 52
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getMe(Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;)V

    .line 53
    return-void
.end method

.method public fbLink(Lcom/poshmark/ui/fragments/PMFragment;IILcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V
    .locals 2
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p2, "minimumAccessLevel"    # I
    .param p3, "maximumAccessLevel"    # I
    .param p4, "callback"    # Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    .prologue
    .line 32
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v0

    new-instance v1, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager$1;

    invoke-direct {v1, p0, p4}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager$1;-><init>(Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V

    invoke-virtual {v0, p1, p2, p3, v1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->link(Lcom/poshmark/ui/fragments/PMFragment;IILcom/poshmark/fb_tmblr_twitter/FBConnectCallback;)V

    .line 49
    return-void
.end method

.method public fbUnlink()V
    .locals 1

    .prologue
    .line 89
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->logout()V

    .line 90
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->clearFacebookInfo()V

    .line 91
    return-void
.end method

.method public logout()V
    .locals 0

    .prologue
    .line 103
    invoke-virtual {p0}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->fbUnlink()V

    .line 104
    invoke-virtual {p0}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->tmUnlink()V

    .line 105
    invoke-virtual {p0}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->twUnlink()V

    .line 106
    return-void
.end method

.method public pinterestLink(Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 2
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 84
    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 85
    .local v0, "context":Landroid/content/Context;
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->connect(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 86
    return-void
.end method

.method public pinterestLink(Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V
    .locals 2
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p2, "callback"    # Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    .prologue
    .line 76
    iput-object p2, p0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    .line 78
    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 79
    .local v0, "context":Landroid/content/Context;
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    move-result-object v1

    invoke-virtual {v1, v0, p2}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->connect(Landroid/content/Context;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V

    .line 80
    return-void
.end method

.method public pinterestUnlink()V
    .locals 1

    .prologue
    .line 109
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->clearPinterestInfo()V

    .line 110
    return-void
.end method

.method public tmUnlink()V
    .locals 1

    .prologue
    .line 94
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->clearTumblrInfo()V

    .line 95
    return-void
.end method

.method public tumblrLink(Ljava/lang/Object;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V
    .locals 4
    .param p1, "caller"    # Ljava/lang/Object;
    .param p2, "callback"    # Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    .prologue
    .line 67
    :try_start_0
    iput-object p2, p0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    .line 68
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->tumblrHelper:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    sget-object v2, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;->TUMBLR:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    invoke-virtual {v1, v2, p1, v3}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->link(Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;Ljava/lang/Object;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V
    :try_end_0
    .catch Lcom/poshmark/utils/InvalidShareCallerException; {:try_start_0 .. :try_end_0} :catch_0

    .line 73
    :goto_0
    return-void

    .line 69
    :catch_0
    move-exception v0

    .line 71
    .local v0, "e":Lcom/poshmark/utils/InvalidShareCallerException;
    invoke-virtual {v0}, Lcom/poshmark/utils/InvalidShareCallerException;->printStackTrace()V

    goto :goto_0
.end method

.method public twUnlink()V
    .locals 1

    .prologue
    .line 98
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->clearTwitterInfo()V

    .line 99
    return-void
.end method

.method public twitterLink(Ljava/lang/Object;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V
    .locals 4
    .param p1, "caller"    # Ljava/lang/Object;
    .param p2, "callback"    # Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    .prologue
    .line 57
    :try_start_0
    iput-object p2, p0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    .line 58
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->tumblrHelper:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    sget-object v2, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;->TWITTER:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    invoke-virtual {v1, v2, p1, v3}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->link(Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;Ljava/lang/Object;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V
    :try_end_0
    .catch Lcom/poshmark/utils/InvalidShareCallerException; {:try_start_0 .. :try_end_0} :catch_0

    .line 63
    :goto_0
    return-void

    .line 59
    :catch_0
    move-exception v0

    .line 61
    .local v0, "e":Lcom/poshmark/utils/InvalidShareCallerException;
    invoke-virtual {v0}, Lcom/poshmark/utils/InvalidShareCallerException;->printStackTrace()V

    goto :goto_0
.end method
