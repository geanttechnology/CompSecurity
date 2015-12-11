.class Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;
.super Landroid/os/AsyncTask;
.source "TumblrHelper.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "TumblrAsyncGetVerifierTask"
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

.field activity:Lcom/poshmark/ui/PMActivity;

.field final synthetic this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;


# direct methods
.method public constructor <init>(Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;Lcom/poshmark/ui/PMActivity;)V
    .locals 0
    .param p2, "activity"    # Lcom/poshmark/ui/PMActivity;

    .prologue
    .line 98
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 99
    iput-object p2, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;->activity:Lcom/poshmark/ui/PMActivity;

    .line 100
    return-void
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Landroid/os/Bundle;
    .locals 8
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v3, 0x0

    .line 105
    :try_start_0
    iget-object v4, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    iget-object v4, v4, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->provider:Loauth/signpost/commonshttp/CommonsHttpOAuthProvider;

    iget-object v5, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    iget-object v5, v5, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->consumer:Loauth/signpost/commonshttp/CommonsHttpOAuthConsumer;

    const-string v6, "http://localhost"

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/String;

    invoke-virtual {v4, v5, v6, v7}, Loauth/signpost/commonshttp/CommonsHttpOAuthProvider;->retrieveRequestToken(Loauth/signpost/OAuthConsumer;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 106
    .local v2, "url":Ljava/lang/String;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 107
    .local v0, "b":Landroid/os/Bundle;
    const-string v4, "URL"

    invoke-virtual {v0, v4, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    const-string v4, "ANALYTICS_PAGE_NAME"

    const-string v5, "tumblr_login_screen"

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Loauth/signpost/exception/OAuthMessageSignerException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Loauth/signpost/exception/OAuthNotAuthorizedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Loauth/signpost/exception/OAuthExpectationFailedException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Loauth/signpost/exception/OAuthCommunicationException; {:try_start_0 .. :try_end_0} :catch_3

    .line 117
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v2    # "url":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 110
    :catch_0
    move-exception v1

    .local v1, "e":Loauth/signpost/exception/OAuthMessageSignerException;
    move-object v0, v3

    .line 111
    goto :goto_0

    .line 112
    .end local v1    # "e":Loauth/signpost/exception/OAuthMessageSignerException;
    :catch_1
    move-exception v1

    .local v1, "e":Loauth/signpost/exception/OAuthNotAuthorizedException;
    move-object v0, v3

    .line 113
    goto :goto_0

    .line 114
    .end local v1    # "e":Loauth/signpost/exception/OAuthNotAuthorizedException;
    :catch_2
    move-exception v1

    .local v1, "e":Loauth/signpost/exception/OAuthExpectationFailedException;
    move-object v0, v3

    .line 115
    goto :goto_0

    .line 116
    .end local v1    # "e":Loauth/signpost/exception/OAuthExpectationFailedException;
    :catch_3
    move-exception v1

    .local v1, "e":Loauth/signpost/exception/OAuthCommunicationException;
    move-object v0, v3

    .line 117
    goto :goto_0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "TumblrHelper$TumblrAsyncGetVerifierTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 95
    :goto_0
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;->doInBackground([Ljava/lang/Void;)Landroid/os/Bundle;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "TumblrHelper$TumblrAsyncGetVerifierTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected onPostExecute(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "b"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 123
    if-eqz p1, :cond_0

    .line 124
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;->activity:Lcom/poshmark/ui/PMActivity;

    const-class v3, Lcom/poshmark/ui/fragments/OAuthLoginFragment;

    invoke-virtual {v2, p1, v3, v4}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 130
    :goto_0
    return-void

    .line 126
    :cond_0
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    iget-object v2, v2, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->service:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    sget-object v3, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;->TWITTER:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    if-ne v2, v3, :cond_1

    sget-object v1, Lcom/poshmark/data_model/models/PMErrorType;->TW_LOGIN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    .line 127
    .local v1, "errorType":Lcom/poshmark/data_model/models/PMErrorType;
    :goto_1
    new-instance v0, Lcom/poshmark/http/api/PMApiError;

    const/16 v2, 0xc8

    invoke-direct {v0, v4, v4, v2, v1}, Lcom/poshmark/http/api/PMApiError;-><init>(Lcom/poshmark/data_model/models/PMError;Ljava/lang/Throwable;ILcom/poshmark/data_model/models/PMErrorType;)V

    .line 128
    .local v0, "error":Lcom/poshmark/http/api/PMApiError;
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;

    iget-object v2, v2, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    invoke-interface {v2, v0}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;->error(Lcom/poshmark/http/api/PMApiError;)V

    goto :goto_0

    .line 126
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
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "TumblrHelper$TumblrAsyncGetVerifierTask#onPostExecute"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 95
    :goto_0
    check-cast p1, Landroid/os/Bundle;

    invoke-virtual {p0, p1}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;->onPostExecute(Landroid/os/Bundle;)V

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    return-void

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "TumblrHelper$TumblrAsyncGetVerifierTask#onPostExecute"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
