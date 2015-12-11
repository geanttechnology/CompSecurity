.class public Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;
.super Ljava/lang/Object;
.source "TumblrHelper.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;,
        Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;,
        Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;
    }
.end annotation


# static fields
.field private static final CALLBACK_URL:Ljava/lang/String; = "http://localhost"

.field public static final SERVICE_ID:Ljava/lang/String; = "tm"


# instance fields
.field accessTokenUrl:Ljava/lang/String;

.field authorizeUrl:Ljava/lang/String;

.field callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

.field consumer:Loauth/signpost/commonshttp/CommonsHttpOAuthConsumer;

.field consumerKey:Ljava/lang/String;

.field consumerSecret:Ljava/lang/String;

.field provider:Loauth/signpost/commonshttp/CommonsHttpOAuthProvider;

.field requestUrl:Ljava/lang/String;

.field service:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.OAUTH_REPONSE_OK"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 54
    return-void
.end method

.method private setServiceValues(Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;)V
    .locals 1
    .param p1, "service"    # Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->service:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    .line 80
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;->TWITTER:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    if-ne p1, v0, :cond_0

    .line 81
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/TwitterConsts;->ConsumerKey:Lcom/poshmark/fb_tmblr_twitter/TwitterConsts;

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/TwitterConsts;->getValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->consumerKey:Ljava/lang/String;

    .line 82
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/TwitterConsts;->ConsumerSecret:Lcom/poshmark/fb_tmblr_twitter/TwitterConsts;

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/TwitterConsts;->getValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->consumerSecret:Ljava/lang/String;

    .line 83
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/TwitterConsts;->RequestUrl:Lcom/poshmark/fb_tmblr_twitter/TwitterConsts;

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/TwitterConsts;->getValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->requestUrl:Ljava/lang/String;

    .line 84
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/TwitterConsts;->AccessTokenUrl:Lcom/poshmark/fb_tmblr_twitter/TwitterConsts;

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/TwitterConsts;->getValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->accessTokenUrl:Ljava/lang/String;

    .line 85
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/TwitterConsts;->AuthorizeUrl:Lcom/poshmark/fb_tmblr_twitter/TwitterConsts;

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/TwitterConsts;->getValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->authorizeUrl:Ljava/lang/String;

    .line 93
    :goto_0
    return-void

    .line 87
    :cond_0
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->ConsumerKey:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->getValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->consumerKey:Ljava/lang/String;

    .line 88
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->ConsumerSecret:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->getValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->consumerSecret:Ljava/lang/String;

    .line 89
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->RequestUrl:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->getValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->requestUrl:Ljava/lang/String;

    .line 90
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->AccessTokenUrl:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->getValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->accessTokenUrl:Ljava/lang/String;

    .line 91
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->AuthorizeUrl:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->getValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->authorizeUrl:Ljava/lang/String;

    goto :goto_0
.end method


# virtual methods
.method public handleNotification(Landroid/content/Intent;)V
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 214
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "com.poshmark.intents.OAUTH_REPONSE_OK"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 215
    const-string v2, "RESULT"

    invoke-virtual {p1, v2}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 216
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "oauth_verifier"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 217
    .local v1, "oauth_verifier":Ljava/lang/String;
    new-instance v2, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;

    iget-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->service:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    invoke-direct {v2, p0, v1, v3}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;-><init>(Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;Ljava/lang/String;Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;)V

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    instance-of v4, v2, Landroid/os/AsyncTask;

    if-nez v4, :cond_1

    invoke-virtual {v2, v3}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetTokenSecretTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 219
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "oauth_verifier":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 217
    .restart local v0    # "b":Landroid/os/Bundle;
    .restart local v1    # "oauth_verifier":Ljava/lang/String;
    :cond_1
    check-cast v2, Landroid/os/AsyncTask;

    invoke-static {v2, v3}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public declared-synchronized link(Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;Ljava/lang/Object;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V
    .locals 7
    .param p1, "service"    # Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;
    .param p2, "caller"    # Ljava/lang/Object;
    .param p3, "callback"    # Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/poshmark/utils/InvalidShareCallerException;
        }
    .end annotation

    .prologue
    .line 58
    monitor-enter p0

    :try_start_0
    iput-object p3, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->callback:Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;

    .line 59
    invoke-direct {p0, p1}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->setServiceValues(Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;)V

    .line 60
    new-instance v3, Loauth/signpost/commonshttp/CommonsHttpOAuthConsumer;

    iget-object v4, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->consumerKey:Ljava/lang/String;

    iget-object v5, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->consumerSecret:Ljava/lang/String;

    invoke-direct {v3, v4, v5}, Loauth/signpost/commonshttp/CommonsHttpOAuthConsumer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->consumer:Loauth/signpost/commonshttp/CommonsHttpOAuthConsumer;

    .line 61
    new-instance v3, Loauth/signpost/commonshttp/CommonsHttpOAuthProvider;

    iget-object v4, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->requestUrl:Ljava/lang/String;

    iget-object v5, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->accessTokenUrl:Ljava/lang/String;

    iget-object v6, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->authorizeUrl:Ljava/lang/String;

    invoke-direct {v3, v4, v5, v6}, Loauth/signpost/commonshttp/CommonsHttpOAuthProvider;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v3, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;->provider:Loauth/signpost/commonshttp/CommonsHttpOAuthProvider;

    .line 62
    instance-of v3, p2, Landroid/app/Activity;

    if-eqz v3, :cond_1

    .line 63
    new-instance v3, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;

    check-cast p2, Lcom/poshmark/ui/PMActivity;

    .end local p2    # "caller":Ljava/lang/Object;
    invoke-direct {v3, p0, p2}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;-><init>(Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;Lcom/poshmark/ui/PMActivity;)V

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    instance-of v5, v3, Landroid/os/AsyncTask;

    if-nez v5, :cond_0

    invoke-virtual {v3, v4}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 76
    :goto_0
    monitor-exit p0

    return-void

    .line 63
    :cond_0
    :try_start_1
    check-cast v3, Landroid/os/AsyncTask;

    invoke-static {v3, v4}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 73
    :catch_0
    move-exception v3

    goto :goto_0

    .line 64
    .restart local p2    # "caller":Ljava/lang/Object;
    :cond_1
    instance-of v3, p2, Landroid/support/v4/app/Fragment;

    if-eqz v3, :cond_3

    .line 65
    move-object v0, p2

    check-cast v0, Landroid/support/v4/app/Fragment;

    move-object v2, v0

    .line 66
    .local v2, "fragment":Landroid/support/v4/app/Fragment;
    invoke-virtual {v2}, Landroid/support/v4/app/Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 67
    .local v1, "activity":Lcom/poshmark/ui/PMActivity;
    new-instance v3, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;

    invoke-direct {v3, p0, v1}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;-><init>(Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;Lcom/poshmark/ui/PMActivity;)V

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    instance-of v5, v3, Landroid/os/AsyncTask;

    if-nez v5, :cond_2

    invoke-virtual {v3, v4}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$TumblrAsyncGetVerifierTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 58
    .end local v1    # "activity":Lcom/poshmark/ui/PMActivity;
    .end local v2    # "fragment":Landroid/support/v4/app/Fragment;
    .end local p2    # "caller":Ljava/lang/Object;
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 67
    .restart local v1    # "activity":Lcom/poshmark/ui/PMActivity;
    .restart local v2    # "fragment":Landroid/support/v4/app/Fragment;
    .restart local p2    # "caller":Ljava/lang/Object;
    :cond_2
    :try_start_2
    check-cast v3, Landroid/os/AsyncTask;

    invoke-static {v3, v4}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 69
    .end local v1    # "activity":Lcom/poshmark/ui/PMActivity;
    .end local v2    # "fragment":Landroid/support/v4/app/Fragment;
    :cond_3
    new-instance v3, Lcom/poshmark/utils/InvalidShareCallerException;

    invoke-direct {v3}, Lcom/poshmark/utils/InvalidShareCallerException;-><init>()V

    throw v3
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0
.end method

.method public logout()V
    .locals 0

    .prologue
    .line 222
    return-void
.end method
