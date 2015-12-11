.class public Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;
.super Ljava/lang/Object;
.source "TwitterHelper.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetTokenSecretTask;,
        Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;
    }
.end annotation


# static fields
.field private static final CALLBACK_URL:Ljava/lang/String; = "http://localhost"

.field public static final SERVICE_ID:Ljava/lang/String; = "tw"


# instance fields
.field TwitterConsumerKey:Ljava/lang/String;

.field TwitterConsumerSecret:Ljava/lang/String;

.field TwitterOAuthURL:Ljava/lang/String;

.field private mReqToken:Ltwitter4j/auth/RequestToken;

.field private mTwitter:Ltwitter4j/Twitter;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->mTwitter:Ltwitter4j/Twitter;

    .line 28
    const-string v0, "https://api.twitter.com/oauth/"

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->TwitterOAuthURL:Ljava/lang/String;

    .line 29
    const-string v0, "kTbA6j5Zi0yX8LS6wT3yHg"

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->TwitterConsumerKey:Ljava/lang/String;

    .line 30
    const-string v0, "koq93pMZSIBsG5U3zOsinGzPU0moy8nt8sbMaGvL68"

    iput-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->TwitterConsumerSecret:Ljava/lang/String;

    .line 38
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;)Ltwitter4j/Twitter;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->mTwitter:Ltwitter4j/Twitter;

    return-object v0
.end method

.method static synthetic access$002(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;Ltwitter4j/Twitter;)Ltwitter4j/Twitter;
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;
    .param p1, "x1"    # Ltwitter4j/Twitter;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->mTwitter:Ltwitter4j/Twitter;

    return-object p1
.end method

.method static synthetic access$100(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;)Ltwitter4j/auth/RequestToken;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->mReqToken:Ltwitter4j/auth/RequestToken;

    return-object v0
.end method

.method static synthetic access$102(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;Ltwitter4j/auth/RequestToken;)Ltwitter4j/auth/RequestToken;
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;
    .param p1, "x1"    # Ltwitter4j/auth/RequestToken;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->mReqToken:Ltwitter4j/auth/RequestToken;

    return-object p1
.end method


# virtual methods
.method public handleNotification(Landroid/content/Intent;)V
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 113
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "com.poshmark.intents.OAUTH_REPONSE_OK"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 114
    const-string v2, "RESULT"

    invoke-virtual {p1, v2}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 115
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "oauth_verifier"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 116
    .local v1, "oauth_verifier":Ljava/lang/String;
    new-instance v2, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetTokenSecretTask;

    invoke-direct {v2, p0, v1}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetTokenSecretTask;-><init>(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;Ljava/lang/String;)V

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    instance-of v4, v2, Landroid/os/AsyncTask;

    if-nez v4, :cond_1

    invoke-virtual {v2, v3}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetTokenSecretTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 118
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "oauth_verifier":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 116
    .restart local v0    # "b":Landroid/os/Bundle;
    .restart local v1    # "oauth_verifier":Ljava/lang/String;
    :cond_1
    check-cast v2, Landroid/os/AsyncTask;

    invoke-static {v2, v3}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public login(Ljava/lang/Object;)V
    .locals 5
    .param p1, "caller"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/poshmark/utils/InvalidShareCallerException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 41
    instance-of v2, p1, Landroid/app/Activity;

    if-eqz v2, :cond_1

    .line 42
    new-instance v2, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;

    check-cast p1, Lcom/poshmark/ui/PMActivity;

    .end local p1    # "caller":Ljava/lang/Object;
    invoke-direct {v2, p0, p1}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;-><init>(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;Lcom/poshmark/ui/PMActivity;)V

    new-array v3, v3, [Ljava/lang/Void;

    instance-of v4, v2, Landroid/os/AsyncTask;

    if-nez v4, :cond_0

    invoke-virtual {v2, v3}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 50
    :goto_0
    return-void

    .line 42
    :cond_0
    check-cast v2, Landroid/os/AsyncTask;

    invoke-static {v2, v3}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 43
    .restart local p1    # "caller":Ljava/lang/Object;
    :cond_1
    instance-of v2, p1, Landroid/support/v4/app/Fragment;

    if-eqz v2, :cond_3

    move-object v1, p1

    .line 44
    check-cast v1, Landroid/support/v4/app/Fragment;

    .line 45
    .local v1, "fragment":Landroid/support/v4/app/Fragment;
    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 46
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    new-instance v2, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;

    invoke-direct {v2, p0, v0}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;-><init>(Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;Lcom/poshmark/ui/PMActivity;)V

    new-array v3, v3, [Ljava/lang/Void;

    instance-of v4, v2, Landroid/os/AsyncTask;

    if-nez v4, :cond_2

    invoke-virtual {v2, v3}, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper$TwitterAsyncGetVerifierTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    :cond_2
    check-cast v2, Landroid/os/AsyncTask;

    invoke-static {v2, v3}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 48
    .end local v0    # "activity":Lcom/poshmark/ui/PMActivity;
    .end local v1    # "fragment":Landroid/support/v4/app/Fragment;
    :cond_3
    new-instance v2, Lcom/poshmark/utils/InvalidShareCallerException;

    invoke-direct {v2}, Lcom/poshmark/utils/InvalidShareCallerException;-><init>()V

    throw v2
.end method

.method public logout()V
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->mTwitter:Ltwitter4j/Twitter;

    if-eqz v0, :cond_0

    .line 122
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TwitterHelper;->mTwitter:Ltwitter4j/Twitter;

    invoke-interface {v0}, Ltwitter4j/Twitter;->shutdown()V

    .line 124
    :cond_0
    return-void
.end method
