.class Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetTokenSecretTask;
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
    name = "TwitterAsyncGetTokenSecretTask"
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

.field final synthetic this$0:Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;

.field private verifier:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;Ljava/lang/String;)V
    .locals 0
    .param p2, "oauth_verifier"    # Ljava/lang/String;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetTokenSecretTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 84
    iput-object p2, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetTokenSecretTask;->verifier:Ljava/lang/String;

    .line 85
    return-void
.end method


# virtual methods
.method public _nr_setTrace(Lcom/newrelic/agent/android/tracing/Trace;)V
    .locals 1

    :try_start_0
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetTokenSecretTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;
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
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetTokenSecretTask;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "TwitterHelper$TwitterAsyncGetTokenSecretTask#doInBackground"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 80
    :goto_0
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetTokenSecretTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    invoke-static {p0}, Lcom/newrelic/agent/android/tracing/TraceMachine;->unloadTraceContext(Ljava/lang/Object;)V

    return-object v0

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "TwitterHelper$TwitterAsyncGetTokenSecretTask#doInBackground"

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
    .line 91
    :try_start_0
    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetTokenSecretTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->mTwitter:Ltwitter4j/Twitter;
    invoke-static {v3}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->access$000(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;)Ltwitter4j/Twitter;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetTokenSecretTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->mReqToken:Ltwitter4j/auth/RequestToken;
    invoke-static {v4}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->access$100(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;)Ltwitter4j/auth/RequestToken;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetTokenSecretTask;->verifier:Ljava/lang/String;

    invoke-interface {v3, v4, v5}, Ltwitter4j/Twitter;->getOAuthAccessToken(Ltwitter4j/auth/RequestToken;Ljava/lang/String;)Ltwitter4j/auth/AccessToken;

    move-result-object v0

    .line 92
    .local v0, "at":Ltwitter4j/auth/AccessToken;
    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetTokenSecretTask;->this$0:Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;

    # getter for: Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->mTwitter:Ltwitter4j/Twitter;
    invoke-static {v3}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->access$000(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;)Ltwitter4j/Twitter;

    move-result-object v3

    invoke-interface {v3, v0}, Ltwitter4j/Twitter;->setOAuthAccessToken(Ltwitter4j/auth/AccessToken;)V

    .line 95
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 96
    .local v2, "result":Landroid/os/Bundle;
    const-string v3, "TOKEN"

    invoke-virtual {v0}, Ltwitter4j/auth/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 97
    const-string v3, "SECRET"

    invoke-virtual {v0}, Ltwitter4j/auth/AccessToken;->getTokenSecret()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    const-string v3, "USER_ID"

    invoke-virtual {v0}, Ltwitter4j/auth/AccessToken;->getUserId()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 99
    const-string v3, "USER_NAME"

    invoke-virtual {v0}, Ltwitter4j/auth/AccessToken;->getScreenName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    const-string v3, "com.poshmark.intents.TWITTER_LOGIN_OK"

    invoke-static {v3, v2}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V
    :try_end_0
    .catch Ltwitter4j/TwitterException; {:try_start_0 .. :try_end_0} :catch_0

    .line 106
    .end local v0    # "at":Ltwitter4j/auth/AccessToken;
    .end local v2    # "result":Landroid/os/Bundle;
    :goto_0
    const/4 v3, 0x0

    return-object v3

    .line 102
    :catch_0
    move-exception v1

    .line 104
    .local v1, "e":Ltwitter4j/TwitterException;
    invoke-virtual {v1}, Ltwitter4j/TwitterException;->printStackTrace()V

    goto :goto_0
.end method
