.class Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;
.super Ljava/lang/Object;
.source "FbHelper.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/fb_tmblr_twitter/FbHelper;->linkWithPM(Ljava/lang/String;Ljava/lang/String;I)V
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
.field final synthetic this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

.field final synthetic val$accessToken:Ljava/lang/String;

.field final synthetic val$currentGrantedPermissions:I

.field final synthetic val$formattedDate:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/fb_tmblr_twitter/FbHelper;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 201
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    iput p2, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->val$currentGrantedPermissions:I

    iput-object p3, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->val$accessToken:Ljava/lang/String;

    iput-object p4, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->val$formattedDate:Ljava/lang/String;

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
    .line 204
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/ExternalServiceInfo;>;"
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 205
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 207
    :cond_0
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_2

    .line 208
    const-string v1, "FB_STATUS"

    const-string v2, "linkWithPM success"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 209
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;

    .line 210
    .local v0, "info":Lcom/poshmark/data_model/models/ExternalServiceInfo;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/poshmark/application/PMApplicationSession;->updateFacebookData(Lcom/poshmark/data_model/models/ExternalServiceInfo;)V

    .line 211
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/FbHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;
    invoke-static {v1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->access$500(Lcom/poshmark/fb_tmblr_twitter/FbHelper;)Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 212
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/FbHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;
    invoke-static {v1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->access$500(Lcom/poshmark/fb_tmblr_twitter/FbHelper;)Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;

    move-result-object v1

    iget v2, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->val$currentGrantedPermissions:I

    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->val$accessToken:Ljava/lang/String;

    iget-object v4, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->val$formattedDate:Ljava/lang/String;

    invoke-interface {v1, v2, v3, v4}, Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;->success(ILjava/lang/String;Ljava/lang/String;)V

    .line 224
    .end local v0    # "info":Lcom/poshmark/data_model/models/ExternalServiceInfo;
    :goto_0
    return-void

    .line 214
    .restart local v0    # "info":Lcom/poshmark/data_model/models/ExternalServiceInfo;
    :cond_1
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    iget v2, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->val$currentGrantedPermissions:I

    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->val$accessToken:Ljava/lang/String;

    iget-object v4, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->val$formattedDate:Ljava/lang/String;

    # invokes: Lcom/poshmark/fb_tmblr_twitter/FbHelper;->returnResult(ILjava/lang/String;Ljava/lang/String;)V
    invoke-static {v1, v2, v3, v4}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->access$600(Lcom/poshmark/fb_tmblr_twitter/FbHelper;ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 217
    .end local v0    # "info":Lcom/poshmark/data_model/models/ExternalServiceInfo;
    :cond_2
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    invoke-virtual {v1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->logout()V

    .line 218
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/FbHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;
    invoke-static {v1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->access$500(Lcom/poshmark/fb_tmblr_twitter/FbHelper;)Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 219
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/FbHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;
    invoke-static {v1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->access$500(Lcom/poshmark/fb_tmblr_twitter/FbHelper;)Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;

    move-result-object v1

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    invoke-interface {v1, v2}, Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;->error(Lcom/poshmark/http/api/PMApiError;)V

    goto :goto_0

    .line 221
    :cond_3
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$3;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    # invokes: Lcom/poshmark/fb_tmblr_twitter/FbHelper;->returnError(Lcom/poshmark/http/api/PMApiError;)V
    invoke-static {v1, v2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->access$700(Lcom/poshmark/fb_tmblr_twitter/FbHelper;Lcom/poshmark/http/api/PMApiError;)V

    goto :goto_0
.end method
