.class Lcom/poshmark/fb_tmblr_twitter/FbHelper$1;
.super Lcom/facebook/AccessTokenTracker;
.source "FbHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/fb_tmblr_twitter/FbHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;


# direct methods
.method constructor <init>(Lcom/poshmark/fb_tmblr_twitter/FbHelper;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    invoke-direct {p0}, Lcom/facebook/AccessTokenTracker;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCurrentAccessTokenChanged(Lcom/facebook/AccessToken;Lcom/facebook/AccessToken;)V
    .locals 6
    .param p1, "oldAccessToken"    # Lcom/facebook/AccessToken;
    .param p2, "currentAccessToken"    # Lcom/facebook/AccessToken;

    .prologue
    const/4 v5, 0x0

    .line 86
    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    iget-object v3, v3, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->handleTokenChange:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v3}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_1

    if-eqz p1, :cond_1

    .line 87
    if-nez p2, :cond_2

    .line 89
    const-string v3, "fb"

    invoke-static {v3, v5}, Lcom/poshmark/http/api/PMApi;->unlinkExternalService(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 90
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->clearFacebookInfo()V

    .line 102
    :cond_0
    :goto_0
    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    iget-object v3, v3, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->handleTokenChange:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 104
    :cond_1
    return-void

    .line 92
    :cond_2
    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    # invokes: Lcom/poshmark/fb_tmblr_twitter/FbHelper;->createTokenFromPMData()Lcom/facebook/AccessToken;
    invoke-static {v3}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->access$100(Lcom/poshmark/fb_tmblr_twitter/FbHelper;)Lcom/facebook/AccessToken;

    move-result-object v2

    .line 93
    .local v2, "tokenFromPMData":Lcom/facebook/AccessToken;
    if-eqz v2, :cond_0

    .line 94
    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    # invokes: Lcom/poshmark/fb_tmblr_twitter/FbHelper;->isTokenUpdated(Lcom/facebook/AccessToken;Lcom/facebook/AccessToken;)Z
    invoke-static {v3, v2, p2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->access$200(Lcom/poshmark/fb_tmblr_twitter/FbHelper;Lcom/facebook/AccessToken;Lcom/facebook/AccessToken;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 95
    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    # invokes: Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getExternalConnectionInfoFromAccessToken(Lcom/facebook/AccessToken;)Lcom/poshmark/data_model/models/ExternalServiceInfo;
    invoke-static {v3, p2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->access$300(Lcom/poshmark/fb_tmblr_twitter/FbHelper;Lcom/facebook/AccessToken;)Lcom/poshmark/data_model/models/ExternalServiceInfo;

    move-result-object v1

    .line 96
    .local v1, "info":Lcom/poshmark/data_model/models/ExternalServiceInfo;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/poshmark/application/PMApplicationSession;->updateFacebookData(Lcom/poshmark/data_model/models/ExternalServiceInfo;)V

    .line 97
    invoke-virtual {p2}, Lcom/facebook/AccessToken;->getExpires()Ljava/util/Date;

    move-result-object v3

    invoke-static {v3}, Lcom/poshmark/utils/DateUtils;->getStringFromUTCDate(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    .line 98
    .local v0, "formattedExpiryDate":Ljava/lang/String;
    const-string v3, "fb"

    invoke-virtual {p2}, Lcom/facebook/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v0, v5, v5}, Lcom/poshmark/http/api/PMApi;->saveExternalServiceInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method
