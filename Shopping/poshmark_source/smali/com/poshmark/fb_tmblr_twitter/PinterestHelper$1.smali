.class Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;
.super Lcom/pinterest/android/pdk/PDKCallback;
.source "PinterestHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;


# direct methods
.method constructor <init>(Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;)V
    .locals 0

    .prologue
    .line 140
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    invoke-direct {p0}, Lcom/pinterest/android/pdk/PDKCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailure(Lcom/pinterest/android/pdk/PDKException;)V
    .locals 5
    .param p1, "exception"    # Lcom/pinterest/android/pdk/PDKException;

    .prologue
    const/4 v4, 0x0

    .line 186
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/pinterest/android/pdk/PDKException;->getDetailMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 187
    new-instance v1, Lcom/poshmark/http/api/PMApiError;

    const/16 v2, 0xc8

    sget-object v3, Lcom/poshmark/data_model/models/PMErrorType;->PINTEREST_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-direct {v1, v4, v4, v2, v3}, Lcom/poshmark/http/api/PMApiError;-><init>(Lcom/poshmark/data_model/models/PMError;Ljava/lang/Throwable;ILcom/poshmark/data_model/models/PMErrorType;)V

    .line 188
    .local v1, "error":Lcom/poshmark/http/api/PMApiError;
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v2, v2, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->connectCallback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    if-eqz v2, :cond_0

    .line 189
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v2, v2, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->connectCallback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    invoke-interface {v2, v1}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;->error(Lcom/poshmark/http/api/PMApiError;)V

    .line 197
    :goto_0
    return-void

    .line 191
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 192
    .local v0, "b":Landroid/os/Bundle;
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    # invokes: Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->getCurrentFragmentCaller()Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v3}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->access$000(Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v3

    iput-object v3, v2, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 193
    const-string v2, "HAS_ERROR"

    const/4 v3, 0x1

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 194
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v2, v2, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const/16 v3, 0x2244

    invoke-virtual {v2, v0, v3}, Lcom/poshmark/ui/fragments/PMFragment;->onFragmentResult(Landroid/os/Bundle;I)V

    goto :goto_0
.end method

.method public onSuccess(Lcom/pinterest/android/pdk/PDKResponse;)V
    .locals 4
    .param p1, "response"    # Lcom/pinterest/android/pdk/PDKResponse;

    .prologue
    .line 143
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/pinterest/android/pdk/PDKResponse;->getData()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 144
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getInstance()Lcom/pinterest/android/pdk/PDKClient;

    move-result-object v1

    invoke-virtual {v1}, Lcom/pinterest/android/pdk/PDKClient;->getAccessToken()Ljava/lang/String;

    move-result-object v0

    .line 145
    .local v0, "accessToken":Ljava/lang/String;
    const-string v1, "com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED"

    invoke-static {v1}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 146
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    # invokes: Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->getCurrentFragmentCaller()Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v2}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->access$000(Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 147
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    if-eqz v1, :cond_0

    .line 148
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v2, v2, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v3, 0x7f060190

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 150
    :cond_0
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->scopes:Ljava/util/List;

    const-string v2, ","

    invoke-static {v1, v2}, Lcom/poshmark/utils/StringUtils;->join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;

    invoke-direct {v2, p0}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;-><init>(Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;)V

    invoke-static {v0, v1, v2}, Lcom/poshmark/http/api/PMApi;->pinterestLink(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 182
    return-void
.end method
