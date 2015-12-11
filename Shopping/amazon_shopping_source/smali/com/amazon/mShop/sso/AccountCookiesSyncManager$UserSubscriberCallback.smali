.class Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;
.super Ljava/lang/Object;
.source "AccountCookiesSyncManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/sso/AccountCookiesSyncManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "UserSubscriberCallback"
.end annotation


# instance fields
.field private final mAccount:Ljava/lang/String;

.field private final mApplicationContext:Landroid/content/Context;

.field private final mCheckLoginAfterCookieRetrieved:Z


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "applicationContext"    # Landroid/content/Context;
    .param p2, "account"    # Ljava/lang/String;
    .param p3, "checkLoginAfterCookieRetrieved"    # Z

    .prologue
    .line 188
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 189
    iput-object p1, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;->mApplicationContext:Landroid/content/Context;

    .line 190
    iput-boolean p3, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;->mCheckLoginAfterCookieRetrieved:Z

    .line 191
    iput-object p2, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;->mAccount:Ljava/lang/String;

    .line 192
    return-void
.end method


# virtual methods
.method public identityCookiesSuccessfullyFetched()V
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v5, 0x0

    const/4 v3, 0x0

    .line 195
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 196
    const-string/jumbo v0, "Amazon.SSOUtil"

    const-string/jumbo v1, "AccountCookiesSyncManager.UserSubscriberCallback.identityCookiesSuccessfullyFetched()"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 200
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;->mApplicationContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;->mAccount:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->onCookieFetchCompleted(Landroid/content/Context;Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->access$200(Landroid/content/Context;Ljava/lang/String;)V

    .line 203
    iget-boolean v0, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;->mCheckLoginAfterCookieRetrieved:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;->mAccount:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 204
    iget-object v0, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;->mAccount:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->getFullNameFromCustomerAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 205
    .local v2, "fullName":Ljava/lang/String;
    new-instance v0, Lcom/amazon/mShop/model/auth/User;

    const-string/jumbo v1, ""

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    move v4, v3

    move-object v7, v5

    invoke-direct/range {v0 .. v7}, Lcom/amazon/mShop/model/auth/User;-><init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/lang/Boolean;Ljava/lang/String;)V

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->saveUser(Lcom/amazon/mShop/model/auth/User;)V

    .line 209
    .end local v2    # "fullName":Ljava/lang/String;
    :cond_1
    # invokes: Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->onSynchronizationComplete()V
    invoke-static {}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->access$300()V

    .line 212
    iget-object v0, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;->mAccount:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 213
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v8

    .line 214
    .local v8, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v0, "hasFetchedNonauthCookies"

    invoke-interface {v8, v0, v9}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 222
    .end local v8    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    :cond_2
    :goto_0
    return-void

    .line 219
    :cond_3
    iget-boolean v0, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;->mCheckLoginAfterCookieRetrieved:Z

    if-eqz v0, :cond_2

    .line 220
    new-instance v0, Lcom/amazon/mShop/sso/MShopCheckLogin;

    iget-object v1, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;->mApplicationContext:Landroid/content/Context;

    invoke-direct {v0, v1, v9, v5}, Lcom/amazon/mShop/sso/MShopCheckLogin;-><init>(Landroid/content/Context;ZLcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;)V

    invoke-virtual {v0}, Lcom/amazon/mShop/sso/MShopCheckLogin;->checkLogin()V

    goto :goto_0
.end method

.method public onFailed(Ljava/lang/String;)V
    .locals 3
    .param p1, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 225
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 226
    const-string/jumbo v0, "Amazon.SSOUtil"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "MAPCookieFetcher failed "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 228
    :cond_0
    # invokes: Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->onSynchronizationComplete()V
    invoke-static {}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->access$300()V

    .line 230
    return-void
.end method
