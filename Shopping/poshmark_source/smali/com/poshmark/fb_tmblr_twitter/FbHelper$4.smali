.class Lcom/poshmark/fb_tmblr_twitter/FbHelper$4;
.super Ljava/lang/Object;
.source "FbHelper.java"

# interfaces
.implements Lcom/facebook/GraphRequest$GraphJSONObjectCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getMe(Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

.field final synthetic val$accessToken:Lcom/facebook/AccessToken;

.field final synthetic val$callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;


# direct methods
.method constructor <init>(Lcom/poshmark/fb_tmblr_twitter/FbHelper;Lcom/facebook/AccessToken;Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;)V
    .locals 0

    .prologue
    .line 251
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$4;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    iput-object p2, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$4;->val$accessToken:Lcom/facebook/AccessToken;

    iput-object p3, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$4;->val$callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCompleted(Lorg/json/JSONObject;Lcom/facebook/GraphResponse;)V
    .locals 12
    .param p1, "object"    # Lorg/json/JSONObject;
    .param p2, "response"    # Lcom/facebook/GraphResponse;

    .prologue
    const/4 v11, 0x0

    .line 257
    invoke-virtual {p2}, Lcom/facebook/GraphResponse;->getError()Lcom/facebook/FacebookRequestError;

    move-result-object v3

    .line 259
    .local v3, "fbRequestError":Lcom/facebook/FacebookRequestError;
    if-nez v3, :cond_1

    .line 260
    new-instance v1, Lcom/google/gson/GsonBuilder;

    invoke-direct {v1}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 261
    .local v1, "builder":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v1}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v5

    .line 262
    .local v5, "gson":Lcom/google/gson/Gson;
    invoke-virtual {p2}, Lcom/facebook/GraphResponse;->getRawResponse()Ljava/lang/String;

    move-result-object v9

    const-class v10, Lcom/poshmark/data_model/models/FbUserInfo;

    instance-of v11, v5, Lcom/google/gson/Gson;

    if-nez v11, :cond_0

    invoke-virtual {v5, v9, v10}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v6

    .end local v5    # "gson":Lcom/google/gson/Gson;
    :goto_0
    check-cast v6, Lcom/poshmark/data_model/models/FbUserInfo;

    .line 263
    .local v6, "info":Lcom/poshmark/data_model/models/FbUserInfo;
    iget-object v9, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$4;->val$accessToken:Lcom/facebook/AccessToken;

    invoke-virtual {v9}, Lcom/facebook/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v7

    .line 264
    .local v7, "token":Ljava/lang/String;
    iget-object v9, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$4;->val$accessToken:Lcom/facebook/AccessToken;

    invoke-virtual {v9}, Lcom/facebook/AccessToken;->getExpires()Ljava/util/Date;

    move-result-object v8

    .line 265
    .local v8, "token_expiry_date":Ljava/util/Date;
    invoke-static {v8}, Lcom/poshmark/utils/DateUtils;->getStringFromUTCDate(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    .line 267
    .local v4, "formattedDate":Ljava/lang/String;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 268
    .local v0, "b":Landroid/os/Bundle;
    const-string v9, "TOKEN"

    invoke-virtual {v0, v9, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 269
    const-string v9, "EXPIRY_DATE"

    invoke-virtual {v0, v9, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 270
    const-string v9, "FIRST_NAME"

    iget-object v10, v6, Lcom/poshmark/data_model/models/FbUserInfo;->first_name:Ljava/lang/String;

    invoke-virtual {v0, v9, v10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 271
    const-string v9, "LAST_NAME"

    iget-object v10, v6, Lcom/poshmark/data_model/models/FbUserInfo;->last_name:Ljava/lang/String;

    invoke-virtual {v0, v9, v10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 272
    const-string v9, "EMAIL"

    iget-object v10, v6, Lcom/poshmark/data_model/models/FbUserInfo;->email:Ljava/lang/String;

    invoke-virtual {v0, v9, v10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 273
    const-string v9, "HANDLE"

    iget-object v10, v6, Lcom/poshmark/data_model/models/FbUserInfo;->name:Ljava/lang/String;

    invoke-virtual {v0, v9, v10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 274
    const-string v9, "USERID"

    iget-object v10, v6, Lcom/poshmark/data_model/models/FbUserInfo;->id:Ljava/lang/String;

    invoke-virtual {v0, v9, v10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 275
    const-string v9, "FB_SIGNUP"

    const/4 v10, 0x1

    invoke-virtual {v0, v9, v10}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 277
    iget-object v9, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$4;->val$callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;

    invoke-interface {v9, v0}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;->success(Landroid/os/Bundle;)V

    .line 282
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "builder":Lcom/google/gson/GsonBuilder;
    .end local v4    # "formattedDate":Ljava/lang/String;
    .end local v6    # "info":Lcom/poshmark/data_model/models/FbUserInfo;
    .end local v7    # "token":Ljava/lang/String;
    .end local v8    # "token_expiry_date":Ljava/util/Date;
    :goto_1
    return-void

    .line 262
    .restart local v1    # "builder":Lcom/google/gson/GsonBuilder;
    .restart local v5    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v5, Lcom/google/gson/Gson;

    .end local v5    # "gson":Lcom/google/gson/Gson;
    invoke-static {v5, v9, v10}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v6

    goto :goto_0

    .line 279
    .end local v1    # "builder":Lcom/google/gson/GsonBuilder;
    :cond_1
    new-instance v2, Lcom/poshmark/http/api/PMApiError;

    const/16 v9, 0xc8

    sget-object v10, Lcom/poshmark/data_model/models/PMErrorType;->FB_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-direct {v2, v11, v11, v9, v10}, Lcom/poshmark/http/api/PMApiError;-><init>(Lcom/poshmark/data_model/models/PMError;Ljava/lang/Throwable;ILcom/poshmark/data_model/models/PMErrorType;)V

    .line 280
    .local v2, "error":Lcom/poshmark/http/api/PMApiError;
    iget-object v9, p0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$4;->val$callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;

    invoke-interface {v9, v2}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;->error(Lcom/poshmark/http/api/PMApiError;)V

    goto :goto_1
.end method
