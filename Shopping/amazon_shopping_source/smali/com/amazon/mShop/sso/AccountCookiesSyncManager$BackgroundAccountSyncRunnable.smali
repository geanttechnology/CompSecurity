.class Lcom/amazon/mShop/sso/AccountCookiesSyncManager$BackgroundAccountSyncRunnable;
.super Ljava/lang/Object;
.source "AccountCookiesSyncManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/sso/AccountCookiesSyncManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "BackgroundAccountSyncRunnable"
.end annotation


# instance fields
.field final mAccount:Ljava/lang/String;

.field final mApplicationContext:Landroid/content/Context;

.field final mCheckLoginAfterCookieRetrieved:Z

.field final mForceSync:Z

.field final mXCookieOnly:Z


# direct methods
.method constructor <init>(Landroid/content/Context;ZZLjava/lang/String;Z)V
    .locals 0
    .param p1, "applicationContext"    # Landroid/content/Context;
    .param p2, "forceSync"    # Z
    .param p3, "checkLoginAfterCookieRetrieved"    # Z
    .param p4, "account"    # Ljava/lang/String;
    .param p5, "xCookieOnly"    # Z

    .prologue
    .line 145
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 146
    iput-object p1, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$BackgroundAccountSyncRunnable;->mApplicationContext:Landroid/content/Context;

    .line 147
    iput-boolean p2, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$BackgroundAccountSyncRunnable;->mForceSync:Z

    .line 148
    iput-boolean p3, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$BackgroundAccountSyncRunnable;->mCheckLoginAfterCookieRetrieved:Z

    .line 149
    iput-object p4, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$BackgroundAccountSyncRunnable;->mAccount:Ljava/lang/String;

    .line 150
    iput-boolean p5, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$BackgroundAccountSyncRunnable;->mXCookieOnly:Z

    .line 151
    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 155
    # invokes: Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->isAccountSyncInProgress()Z
    invoke-static {}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->access$000()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 156
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 157
    const-string/jumbo v0, "Amazon.SSOUtil"

    const-string/jumbo v1, "Amazon Account synchronization already in progress"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 164
    :cond_0
    :goto_0
    return-void

    .line 163
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$BackgroundAccountSyncRunnable;->mApplicationContext:Landroid/content/Context;

    iget-boolean v1, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$BackgroundAccountSyncRunnable;->mForceSync:Z

    iget-boolean v2, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$BackgroundAccountSyncRunnable;->mCheckLoginAfterCookieRetrieved:Z

    iget-object v3, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$BackgroundAccountSyncRunnable;->mAccount:Ljava/lang/String;

    iget-boolean v4, p0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$BackgroundAccountSyncRunnable;->mXCookieOnly:Z

    # invokes: Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->doSync(Landroid/content/Context;ZZLjava/lang/String;Z)V
    invoke-static {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->access$100(Landroid/content/Context;ZZLjava/lang/String;Z)V

    goto :goto_0
.end method
