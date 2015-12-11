.class Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;
.super Landroid/os/AsyncTask;
.source "TumblrHelper.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "TumblrAsyncGetTokenSecretTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Landroid/os/Bundle;",
        ">;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Lcom/poshmark/data_model/models/ExternalServiceInfo;",
        ">;"
    }
.end annotation


# instance fields
.field public _nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

.field service_type:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

.field final synthetic this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

.field private verifier:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;Ljava/lang/String;Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;)V
    .locals 0
    .param p2, "oauth_verifier"    # Ljava/lang/String;
    .param p3, "service"    # Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    .prologue
    .line 138
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 139
    iput-object p2, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->verifier:Ljava/lang/String;

    .line 140
    iput-object p3, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->service_type:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    .line 141
    return-void
.end method

.method private PMlink(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "b"    # Landroid/os/Bundle;

    .prologue
    .line 189
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->service_type:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;->TUMBLR:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    if-ne v0, v1, :cond_0

    .line 190
    const-string v0, "TOKEN"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "SECRET"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, p0}, Lcom/poshmark/http/api/PMApi;->tmblrLink(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 194
    :goto_0
    return-void

    .line 192
    :cond_0
    const-string v0, "TOKEN"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "SECRET"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "USER_ID"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "USER_NAME"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v1, v2, v3, p0}, Lcom/poshmark/http/api/PMApi;->twitterLink(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Landroid/os/Bundle;
    .locals 10
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v5, 0x0

    .line 147
    :try_start_0
    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    iget-object v6, v6, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->provider:Loauth/signpost/commonshttp/CommonsHttpOAuthProvider;

    iget-object v7, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    iget-object v7, v7, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->consumer:Loauth/signpost/commonshttp/CommonsHttpOAuthConsumer;

    iget-object v8, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->verifier:Ljava/lang/String;

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/String;

    invoke-virtual {v6, v7, v8, v9}, Loauth/signpost/commonshttp/CommonsHttpOAuthProvider;->retrieveAccessToken(Loauth/signpost/OAuthConsumer;Ljava/lang/String;[Ljava/lang/String;)V

    .line 148
    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    iget-object v6, v6, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->provider:Loauth/signpost/commonshttp/CommonsHttpOAuthProvider;

    invoke-virtual {v6}, Loauth/signpost/commonshttp/CommonsHttpOAuthProvider;->getResponseParameters()Loauth/signpost/http/HttpParameters;

    move-result-object v1

    .line 149
    .local v1, "nameIdParams":Loauth/signpost/http/HttpParameters;
    const-string v6, "screen_name"

    invoke-virtual {v1, v6}, Loauth/signpost/http/HttpParameters;->getFirst(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    .line 150
    .local v4, "userName":Ljava/lang/String;
    const-string v6, "user_id"

    invoke-virtual {v1, v6}, Loauth/signpost/http/HttpParameters;->getFirst(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 153
    .local v3, "userId":Ljava/lang/String;
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 154
    .local v2, "result":Landroid/os/Bundle;
    const-string v6, "TOKEN"

    iget-object v7, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    iget-object v7, v7, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->consumer:Loauth/signpost/commonshttp/CommonsHttpOAuthConsumer;

    invoke-virtual {v7}, Loauth/signpost/commonshttp/CommonsHttpOAuthConsumer;->getToken()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    const-string v6, "SECRET"

    iget-object v7, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    iget-object v7, v7, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->consumer:Loauth/signpost/commonshttp/CommonsHttpOAuthConsumer;

    invoke-virtual {v7}, Loauth/signpost/commonshttp/CommonsHttpOAuthConsumer;->getTokenSecret()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 156
    if-eqz v3, :cond_0

    .line 157
    const-string v6, "USER_ID"

    invoke-virtual {v2, v6, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    :cond_0
    if-eqz v4, :cond_1

    .line 160
    const-string v6, "USER_NAME"

    invoke-virtual {v2, v6, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Loauth/signpost/exception/OAuthMessageSignerException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Loauth/signpost/exception/OAuthNotAuthorizedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Loauth/signpost/exception/OAuthExpectationFailedException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Loauth/signpost/exception/OAuthCommunicationException; {:try_start_0 .. :try_end_0} :catch_3

    .line 171
    .end local v1    # "nameIdParams":Loauth/signpost/http/HttpParameters;
    .end local v2    # "result":Landroid/os/Bundle;
    .end local v3    # "userId":Ljava/lang/String;
    .end local v4    # "userName":Ljava/lang/String;
    :cond_1
    :goto_0
    return-object v2

    .line 164
    :catch_0
    move-exception v0

    .local v0, "e":Loauth/signpost/exception/OAuthMessageSignerException;
    move-object v2, v5

    .line 165
    goto :goto_0

    .line 166
    .end local v0    # "e":Loauth/signpost/exception/OAuthMessageSignerException;
    :catch_1
    move-exception v0

    .local v0, "e":Loauth/signpost/exception/OAuthNotAuthorizedException;
    move-object v2, v5

    .line 167
    goto :goto_0

    .line 168
    .end local v0    # "e":Loauth/signpost/exception/OAuthNotAuthorizedException;
    :catch_2
    move-exception v0

    .local v0, "e":Loauth/signpost/exception/OAuthExpectationFailedException;
    move-object v2, v5

    .line 169
    goto :goto_0

    .line 170
    .end local v0    # "e":Loauth/signpost/exception/OAuthExpectationFailedException;
    :catch_3
    move-exception v0

    .local v0, "e":Loauth/signpost/exception/OAuthCommunicationException;
    move-object v2, v5

    .line 171
    goto :goto_0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "TumblrHelper$TumblrAsyncGetTokenSecretTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 134
    :goto_0
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->doInBackground([Ljava/lang/Void;)Landroid/os/Bundle;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "TumblrHelper$TumblrAsyncGetTokenSecretTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 4
    .param p1, "apiResponse"    # Lcom/poshmark/http/api/PMApiResponse;

    .prologue
    .line 198
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_1

    .line 199
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/ExternalServiceInfo;

    .line 200
    .local v0, "info":Lcom/poshmark/data_model/models/ExternalServiceInfo;
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->service_type:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    sget-object v2, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;->TUMBLR:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    if-ne v1, v2, :cond_0

    .line 201
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/poshmark/application/PMApplicationSession;->updateTumblrData(Lcom/poshmark/data_model/models/ExternalServiceInfo;)V

    .line 205
    :goto_0
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;->success(ILandroid/os/Bundle;)V

    .line 209
    .end local v0    # "info":Lcom/poshmark/data_model/models/ExternalServiceInfo;
    :goto_1
    return-void

    .line 203
    .restart local v0    # "info":Lcom/poshmark/data_model/models/ExternalServiceInfo;
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/poshmark/application/PMApplicationSession;->updateTwitterData(Lcom/poshmark/data_model/models/ExternalServiceInfo;)V

    goto :goto_0

    .line 207
    .end local v0    # "info":Lcom/poshmark/data_model/models/ExternalServiceInfo;
    :cond_1
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    invoke-interface {v1, v2}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;->error(Lcom/poshmark/http/api/PMApiError;)V

    goto :goto_1
.end method

.method protected onPostExecute(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "b"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 177
    if-eqz p1, :cond_0

    .line 178
    invoke-direct {p0, p1}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->PMlink(Landroid/os/Bundle;)V

    .line 185
    :goto_0
    return-void

    .line 180
    :cond_0
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    iget-object v2, v2, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->service:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    sget-object v3, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;->TWITTER:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    if-ne v2, v3, :cond_1

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->TW_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 181
    .local v1, "errorType":Lcom/poshmark/data_model/models/PMErrorType;
    :goto_1
    new-instance v0, Lcom/poshmark/http/api/PMApiError;

    const/16 v2, 0xc8

    invoke-direct {v0, v4, v4, v2, v1}, Lcom/poshmark/http/api/PMApiError;-><init>(Lcom/poshmark/data_model/models/PMError;Ljava/lang/Throwable;ILcom/poshmark/data_model/models/PMErrorType;)V

    .line 182
    .local v0, "error":Lcom/poshmark/http/api/PMApiError;
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    iget-object v2, v2, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    invoke-interface {v2, v0}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;->error(Lcom/poshmark/http/api/PMApiError;)V

    goto :goto_0

    .line 180
    .end local v0    # "error":Lcom/poshmark/http/api/PMApiError;
    .end local v1    # "errorType":Lcom/poshmark/data_model/models/PMErrorType;
    :cond_1
    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->TM_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    goto :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "TumblrHelper$TumblrAsyncGetTokenSecretTask#onPostExecute"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 134
    :goto_0
    check-cast p1, Landroid/os/Bundle;

    invoke-virtual {p0, p1}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->onPostExecute(Landroid/os/Bundle;)V

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    return-void

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "TumblrHelper$TumblrAsyncGetTokenSecretTask#onPostExecute"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
