.class Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;
.super Landroid/os/AsyncTask;
.source "TwitterHelper.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "TwitterAsyncGetVerifierTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field public _nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

.field private activity:Lcom/poshmark/ui/PMActivity;

.field final synthetic this$0:Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;


# direct methods
.method public constructor <init>(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;Lcom/poshmark/ui/PMActivity;)V
    .locals 0
    .param p2, "activity"    # Lcom/poshmark/ui/PMActivity;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 58
    iput-object p2, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;->activity:Lcom/poshmark/ui/PMActivity;

    .line 59
    return-void
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    .prologue
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "TwitterHelper$TwitterAsyncGetVerifierTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 54
    :goto_0
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "TwitterHelper$TwitterAsyncGetVerifierTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 6
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v5, 0x0

    .line 64
    :try_start_0
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;

    new-instance v3, Ltwitter4j/TwitterFactory;

    invoke-direct {v3}, Ltwitter4j/TwitterFactory;-><init>()V

    invoke-virtual {v3}, Ltwitter4j/TwitterFactory;->getInstance()Ltwitter4j/Twitter;

    move-result-object v3

    # setter for: Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->mTwitter:Ltwitter4j/Twitter;
    invoke-static {v2, v3}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->access$002(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;Ltwitter4j/Twitter;)Ltwitter4j/Twitter;

    .line 65
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->mTwitter:Ltwitter4j/Twitter;
    invoke-static {v2}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->access$000(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;)Ltwitter4j/Twitter;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;

    iget-object v3, v3, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->TwitterConsumerKey:Ljava/lang/String;

    iget-object v4, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;

    iget-object v4, v4, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->TwitterConsumerSecret:Ljava/lang/String;

    invoke-interface {v2, v3, v4}, Ltwitter4j/Twitter;->setOAuthConsumer(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;

    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->mTwitter:Ltwitter4j/Twitter;
    invoke-static {v3}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->access$000(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;)Ltwitter4j/Twitter;

    move-result-object v3

    const-string v4, "http://localhost"

    invoke-interface {v3, v4}, Ltwitter4j/Twitter;->getOAuthRequestToken(Ljava/lang/String;)Ltwitter4j/auth/RequestToken;

    move-result-object v3

    # setter for: Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->mReqToken:Ltwitter4j/auth/RequestToken;
    invoke-static {v2, v3}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->access$102(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;Ltwitter4j/auth/RequestToken;)Ltwitter4j/auth/RequestToken;

    .line 67
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 68
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "URL"

    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->mReqToken:Ltwitter4j/auth/RequestToken;
    invoke-static {v3}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->access$100(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;)Ltwitter4j/auth/RequestToken;

    move-result-object v3

    invoke-virtual {v3}, Ltwitter4j/auth/RequestToken;->getAuthenticationURL()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "twitter_login_screen"

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    iget-object v2, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;->activity:Lcom/poshmark/ui/PMActivity;

    const-class v3, Lcom/poshmark/ui/fragments/OAuthLoginFragment;

    const/4 v4, 0x0

    invoke-virtual {v2, v0, v3, v4}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V
    :try_end_0
    .catch Ltwitter4j/TwitterException; {:try_start_0 .. :try_end_0} :catch_0

    .line 75
    .end local v0    # "b":Landroid/os/Bundle;
    :goto_0
    return-object v5

    .line 71
    :catch_0
    move-exception v1

    .line 73
    .local v1, "e":Ltwitter4j/TwitterException;
    invoke-virtual {v1}, Ltwitter4j/TwitterException;->printStackTrace()V

    goto :goto_0
.end method
