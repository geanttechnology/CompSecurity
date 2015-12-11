.class Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;
.super Ljava/lang/Object;
.source "MAPCookiesFetcher.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/MAPCookiesFetcher;->getCookies()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/MAPCookiesFetcher;

.field final synthetic val$callObserver:Lcom/amazon/mShop/net/CallObserver;

.field final synthetic val$cookieDomain:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/MAPCookiesFetcher;Ljava/lang/String;Lcom/amazon/mShop/net/CallObserver;)V
    .locals 0

    .prologue
    .line 113
    iput-object p1, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->this$0:Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    iput-object p2, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->val$cookieDomain:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->val$callObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 152
    iget-object v1, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->val$callObserver:Lcom/amazon/mShop/net/CallObserver;

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/os/Bundle;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v1, v0}, Lcom/amazon/mShop/net/CallObserver;->onFailed(Ljava/lang/String;)V

    .line 153
    iget-object v0, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->this$0:Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    # invokes: Lcom/amazon/mShop/sso/MAPCookiesFetcher;->failure(Landroid/os/Bundle;)V
    invoke-static {v0, p1}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->access$500(Lcom/amazon/mShop/sso/MAPCookiesFetcher;Landroid/os/Bundle;)V

    .line 154
    return-void

    .line 152
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 116
    const-string/jumbo v2, "com.amazon.identity.auth.device.api.cookiekeys.all"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 121
    .local v0, "cookies":[Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->this$0:Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    # getter for: Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mApplicationContext:Landroid/content/Context;
    invoke-static {v2}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->access$000(Lcom/amazon/mShop/sso/MAPCookiesFetcher;)Landroid/content/Context;

    move-result-object v2

    const/4 v3, 0x1

    invoke-static {v2, v3}, Lcom/amazon/mShop/net/CookieBridge;->getCookieDomain(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v1

    .line 123
    .local v1, "currentCookieDomain":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->val$cookieDomain:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 124
    :cond_0
    sget-boolean v2, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v2, :cond_1

    .line 125
    # getter for: Lcom/amazon/mShop/sso/MAPCookiesFetcher;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->access$100()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "current CookieDomain is "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " \n new cookies: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {v0}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 128
    :cond_1
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->onError(Landroid/os/Bundle;)V

    .line 148
    :cond_2
    :goto_0
    return-void

    .line 130
    :cond_3
    iget-object v2, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->val$callObserver:Lcom/amazon/mShop/net/CallObserver;

    invoke-virtual {v2}, Lcom/amazon/mShop/net/CallObserver;->onComplete()V

    .line 131
    sget-boolean v2, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v2, :cond_4

    .line 132
    # getter for: Lcom/amazon/mShop/sso/MAPCookiesFetcher;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->access$100()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "new cookies: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {v0}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 133
    # getter for: Lcom/amazon/mShop/sso/MAPCookiesFetcher;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->access$100()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "mAccount "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->this$0:Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    # getter for: Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mAccount:Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->access$200(Lcom/amazon/mShop/sso/MAPCookiesFetcher;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " mXCookieOnly "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->this$0:Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    # getter for: Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mXCookieOnly:Z
    invoke-static {v4}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->access$300(Lcom/amazon/mShop/sso/MAPCookiesFetcher;)Z

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 136
    :cond_4
    iget-object v2, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->this$0:Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    # getter for: Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mAccount:Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->access$200(Lcom/amazon/mShop/sso/MAPCookiesFetcher;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_5

    iget-object v2, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->this$0:Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    # getter for: Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mXCookieOnly:Z
    invoke-static {v2}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->access$300(Lcom/amazon/mShop/sso/MAPCookiesFetcher;)Z

    move-result v2

    if-nez v2, :cond_6

    .line 138
    :cond_5
    iget-object v2, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->this$0:Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    # getter for: Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mApplicationContext:Landroid/content/Context;
    invoke-static {v2}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->access$000(Lcom/amazon/mShop/sso/MAPCookiesFetcher;)Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, v0}, Lcom/amazon/mShop/sso/CookieHelper;->setCookies(Landroid/content/Context;[Ljava/lang/String;)V

    .line 144
    :goto_1
    iget-object v2, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->this$0:Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    # getter for: Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mUserSubscriberCallback:Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;
    invoke-static {v2}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->access$400(Lcom/amazon/mShop/sso/MAPCookiesFetcher;)Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 145
    iget-object v2, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->this$0:Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    # getter for: Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mUserSubscriberCallback:Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;
    invoke-static {v2}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->access$400(Lcom/amazon/mShop/sso/MAPCookiesFetcher;)Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;->identityCookiesSuccessfullyFetched()V

    goto/16 :goto_0

    .line 141
    :cond_6
    iget-object v2, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;->this$0:Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    # getter for: Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mApplicationContext:Landroid/content/Context;
    invoke-static {v2}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->access$000(Lcom/amazon/mShop/sso/MAPCookiesFetcher;)Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, v0}, Lcom/amazon/mShop/sso/CookieHelper;->setXCookie(Landroid/content/Context;[Ljava/lang/String;)Z

    goto :goto_1
.end method
