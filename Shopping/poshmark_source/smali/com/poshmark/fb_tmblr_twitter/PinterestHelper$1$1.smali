.class Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;
.super Ljava/lang/Object;
.source "PinterestHelper.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->onSuccess(Lcom/pinterest/android/pdk/PDKResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Lcom/poshmark/data_model/models/ExternalServiceInfo;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;


# direct methods
.method constructor <init>(Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;)V
    .locals 0

    .prologue
    .line 150
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;->this$1:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/ExternalServiceInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/ExternalServiceInfo;>;"
    const/16 v4, 0x2244

    const/4 v3, 0x0

    .line 153
    const-string v1, "Pinterest Helper"

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->responseString:Ljava/lang/String;

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 154
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;->this$1:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    if-eqz v1, :cond_0

    .line 155
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;->this$1:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 157
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 158
    .local v0, "b":Landroid/os/Bundle;
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_2

    .line 159
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v1, Lcom/poshmark/data_model/models/ExternalServiceInfo;

    invoke-virtual {v2, v1}, Lcom/poshmark/application/PMApplicationSession;->updatePinterestData(Lcom/poshmark/data_model/models/ExternalServiceInfo;)V

    .line 160
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;->this$1:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->connectCallback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    if-eqz v1, :cond_1

    .line 161
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;->this$1:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->connectCallback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    const/4 v2, 0x0

    invoke-interface {v1, v3, v2}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;->success(ILandroid/os/Bundle;)V

    .line 180
    :goto_0
    return-void

    .line 163
    :cond_1
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;->this$1:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;->this$1:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;

    iget-object v2, v2, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    # invokes: Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->getCurrentFragmentCaller()Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v2}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->access$000(Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 164
    const-string v1, "HAS_ERROR"

    invoke-virtual {v0, v1, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 165
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;->this$1:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v1, v0, v4}, Lcom/poshmark/ui/fragments/PMFragment;->onFragmentResult(Landroid/os/Bundle;I)V

    goto :goto_0

    .line 170
    :cond_2
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;->this$1:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->connectCallback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    if-eqz v1, :cond_3

    .line 171
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;->this$1:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->connectCallback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    invoke-interface {v1, v2}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;->error(Lcom/poshmark/http/api/PMApiError;)V

    goto :goto_0

    .line 173
    :cond_3
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;->this$1:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;->this$1:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;

    iget-object v2, v2, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    # invokes: Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->getCurrentFragmentCaller()Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v2}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->access$000(Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 174
    const-string v1, "HAS_ERROR"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 175
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1$1;->this$1:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper$1;->this$0:Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v1, v0, v4}, Lcom/poshmark/ui/fragments/PMFragment;->onFragmentResult(Landroid/os/Bundle;I)V

    goto :goto_0
.end method
