.class Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;
.super Landroid/os/AsyncTask;
.source "GooglePlusHelper.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "FetchGoogleTokenTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Landroid/os/Bundle;",
        ">;"
    }
.end annotation


# instance fields
.field public _nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

.field helper:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

.field final synthetic this$0:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;


# direct methods
.method public constructor <init>(Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;)V
    .locals 0

    .prologue
    .line 195
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 196
    return-void
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
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
    const/4 v9, 0x1

    .line 200
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 202
    .local v0, "b":Landroid/os/Bundle;
    :try_start_0
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 203
    .local v3, "extras":Landroid/os/Bundle;
    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    iget-object v6, v6, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->activity:Lcom/poshmark/ui/PMActivity;

    invoke-virtual {v6}, Lcom/poshmark/ui/PMActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    sget-object v7, Lcom/google/android/gms/plus/Plus;->AccountApi:Lcom/google/android/gms/plus/Account;

    iget-object v8, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;
    invoke-static {v8}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->access$100(Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;)Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v8

    invoke-interface {v7, v8}, Lcom/google/android/gms/plus/Account;->getAccountName(Lcom/google/android/gms/common/api/GoogleApiClient;)Ljava/lang/String;

    move-result-object v7

    const-string v8, "oauth2:https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/plus.login"

    invoke-static {v6, v7, v8, v3}, Lcom/google/android/gms/auth/GoogleAuthUtil;->getToken(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v4

    .line 208
    .local v4, "token":Ljava/lang/String;
    sget-object v6, Lcom/google/android/gms/plus/Plus;->AccountApi:Lcom/google/android/gms/plus/Account;

    iget-object v7, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;
    invoke-static {v7}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->access$100(Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;)Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v7

    invoke-interface {v6, v7}, Lcom/google/android/gms/plus/Account;->getAccountName(Lcom/google/android/gms/common/api/GoogleApiClient;)Ljava/lang/String;

    move-result-object v2

    .line 210
    .local v2, "email":Ljava/lang/String;
    const-string v6, "TOKEN"

    invoke-virtual {v0, v6, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 211
    const-string v6, "EMAIL"

    invoke-virtual {v0, v6, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 212
    const-string v6, "GOOGLE_SIGNUP"

    const/4 v7, 0x1

    invoke-virtual {v0, v6, v7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 213
    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;
    invoke-static {v6}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->access$100(Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;)Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v6

    if-eqz v6, :cond_1

    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;
    invoke-static {v6}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->access$100(Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;)Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v6

    invoke-interface {v6}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 214
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->getGooglePlusProfileImageUrl()Ljava/lang/String;

    move-result-object v5

    .line 215
    .local v5, "url":Ljava/lang/String;
    if-eqz v5, :cond_0

    .line 216
    const-string v6, "GOOGLE_AVATAAR_URL"

    invoke-virtual {v0, v6, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 218
    :cond_0
    sget-object v6, Lcom/google/android/gms/plus/Plus;->AccountApi:Lcom/google/android/gms/plus/Account;

    iget-object v7, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;
    invoke-static {v7}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->access$100(Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;)Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v7

    invoke-interface {v6, v7}, Lcom/google/android/gms/plus/Account;->clearDefaultAccount(Lcom/google/android/gms/common/api/GoogleApiClient;)V

    .line 219
    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;
    invoke-static {v6}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->access$100(Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;)Lcom/google/android/gms/common/api/GoogleApiClient;

    move-result-object v6

    invoke-interface {v6}, Lcom/google/android/gms/common/api/GoogleApiClient;->disconnect()V

    .line 221
    .end local v5    # "url":Ljava/lang/String;
    :cond_1
    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    iget-object v6, v6, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->activity:Lcom/poshmark/ui/PMActivity;

    invoke-virtual {v6}, Lcom/poshmark/ui/PMActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6, v4}, Lcom/google/android/gms/auth/GoogleAuthUtil;->invalidateToken(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/google/android/gms/auth/UserRecoverableAuthException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lcom/google/android/gms/auth/GoogleAuthException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3

    .line 232
    .end local v2    # "email":Ljava/lang/String;
    .end local v3    # "extras":Landroid/os/Bundle;
    .end local v4    # "token":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 223
    :catch_0
    move-exception v1

    .line 224
    .local v1, "e":Lcom/google/android/gms/auth/UserRecoverableAuthException;
    const-string v6, "TOKEN_ERROR"

    invoke-virtual {v0, v6, v9}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_0

    .line 225
    .end local v1    # "e":Lcom/google/android/gms/auth/UserRecoverableAuthException;
    :catch_1
    move-exception v1

    .line 226
    .local v1, "e":Ljava/io/IOException;
    const-string v6, "TOKEN_ERROR"

    invoke-virtual {v0, v6, v9}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_0

    .line 227
    .end local v1    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v1

    .line 228
    .local v1, "e":Lcom/google/android/gms/auth/GoogleAuthException;
    const-string v6, "TOKEN_ERROR"

    invoke-virtual {v0, v6, v9}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_0

    .line 229
    .end local v1    # "e":Lcom/google/android/gms/auth/GoogleAuthException;
    :catch_3
    move-exception v1

    .line 230
    .local v1, "e":Ljava/lang/Exception;
    const-string v6, "TOKEN_ERROR"

    invoke-virtual {v0, v6, v9}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "GooglePlusHelper$FetchGoogleTokenTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 191
    :goto_0
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->doInBackground([Ljava/lang/Void;)Landroid/os/Bundle;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "GooglePlusHelper$FetchGoogleTokenTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected onPostExecute(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "b"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    .line 237
    if-eqz p1, :cond_0

    const-string v1, "TOKEN_ERROR"

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-nez v1, :cond_0

    .line 238
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;

    invoke-interface {v1, p1}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;->success(Landroid/os/Bundle;)V

    .line 246
    :goto_0
    return-void

    .line 240
    :cond_0
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    if-eqz v1, :cond_1

    .line 241
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->fragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 243
    :cond_1
    new-instance v0, Lcom/poshmark/http/api/PMApiError;

    const/16 v1, 0xc8

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->GOOGLE_PLUS_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-direct {v0, v3, v3, v1, v2}, Lcom/poshmark/http/api/PMApiError;-><init>(Lcom/poshmark/data_model/models/PMError;Ljava/lang/Throwable;ILcom/poshmark/data_model/models/PMErrorType;)V

    .line 244
    .local v0, "error":Lcom/poshmark/http/api/PMApiError;
    iget-object v1, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    iget-object v1, v1, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;

    invoke-interface {v1, v0}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceUserInfoInterface;->error(Lcom/poshmark/http/api/PMApiError;)V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "GooglePlusHelper$FetchGoogleTokenTask#onPostExecute"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 191
    :goto_0
    check-cast p1, Landroid/os/Bundle;

    invoke-virtual {p0, p1}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$FetchGoogleTokenTask;->onPostExecute(Landroid/os/Bundle;)V

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    return-void

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "GooglePlusHelper$FetchGoogleTokenTask#onPostExecute"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
