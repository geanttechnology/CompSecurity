.class Lcom/poshmark/fb_tmblr_twitter/FbHelper$2;
.super Ljava/lang/Object;
.source "FbHelper.java"

# interfaces
.implements Lcom/facebook/FacebookCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/fb_tmblr_twitter/FbHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/facebook/FacebookCallback",
        "<",
        "Lcom/facebook/login/LoginResult;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;


# direct methods
.method constructor <init>(Lcom/poshmark/fb_tmblr_twitter/FbHelper;)V
    .locals 0

    .prologue
    .line 164
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$2;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel()V
    .locals 0

    .prologue
    .line 188
    return-void
.end method

.method public onError(Lcom/facebook/FacebookException;)V
    .locals 0
    .param p1, "e"    # Lcom/facebook/FacebookException;

    .prologue
    .line 193
    return-void
.end method

.method public onSuccess(Lcom/facebook/login/LoginResult;)V
    .locals 7
    .param p1, "loginResult"    # Lcom/facebook/login/LoginResult;

    .prologue
    .line 167
    invoke-virtual {p1}, Lcom/facebook/login/LoginResult;->getRecentlyGrantedPermissions()Ljava/util/Set;

    move-result-object v3

    .line 168
    .local v3, "permissions":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v5, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$2;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    # invokes: Lcom/poshmark/fb_tmblr_twitter/FbHelper;->inferCurrentAccessLevelFromSet(Ljava/util/Set;)I
    invoke-static {v5, v3}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->access$400(Lcom/poshmark/fb_tmblr_twitter/FbHelper;Ljava/util/Set;)I

    move-result v1

    .line 169
    .local v1, "currentGrantedPermissions":I
    invoke-virtual {p1}, Lcom/facebook/login/LoginResult;->getAccessToken()Lcom/facebook/AccessToken;

    move-result-object v0

    .line 170
    .local v0, "accessToken":Lcom/facebook/AccessToken;
    invoke-virtual {v0}, Lcom/facebook/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v4

    .line 172
    .local v4, "token":Ljava/lang/String;
    invoke-virtual {v0}, Lcom/facebook/AccessToken;->getExpires()Ljava/util/Date;

    move-result-object v5

    invoke-static {v5}, Lcom/poshmark/utils/DateUtils;->getStringFromUTCDate(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    .line 173
    .local v2, "formattedDate":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 174
    iget-object v5, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$2;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    invoke-virtual {v0}, Lcom/facebook/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6, v2, v1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->linkWithPM(Ljava/lang/String;Ljava/lang/String;I)V

    .line 183
    :goto_0
    return-void

    .line 176
    :cond_0
    iget-object v5, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$2;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/FbHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;
    invoke-static {v5}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->access$500(Lcom/poshmark/fb_tmblr_twitter/FbHelper;)Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 177
    iget-object v5, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$2;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/FbHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;
    invoke-static {v5}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->access$500(Lcom/poshmark/fb_tmblr_twitter/FbHelper;)Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;

    move-result-object v5

    invoke-virtual {v0}, Lcom/facebook/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v1, v6, v2}, Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;->success(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 180
    :cond_1
    iget-object v5, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$2;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    invoke-virtual {v0}, Lcom/facebook/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v6

    # invokes: Lcom/poshmark/fb_tmblr_twitter/FbHelper;->returnResult(ILjava/lang/String;Ljava/lang/String;)V
    invoke-static {v5, v1, v6, v2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->access$600(Lcom/poshmark/fb_tmblr_twitter/FbHelper;ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public bridge synthetic onSuccess(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 164
    check-cast p1, Lcom/facebook/login/LoginResult;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper$2;->onSuccess(Lcom/facebook/login/LoginResult;)V

    return-void
.end method
