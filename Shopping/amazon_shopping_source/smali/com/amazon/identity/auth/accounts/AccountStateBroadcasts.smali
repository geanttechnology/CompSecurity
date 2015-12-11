.class public final Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;
.super Ljava/lang/Object;
.source "AccountStateBroadcasts.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    return-void
.end method

.method static synthetic access$000(Landroid/content/Context;Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "x0"    # Landroid/content/Context;
    .param p1, "x1"    # Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
    .param p2, "x2"    # Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;
    .param p3, "x3"    # Ljava/lang/String;
    .param p4, "x4"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 17
    invoke-virtual {p1, p0, p3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getListOfProfilesWhereTheAccountIsPrimary(Landroid/content/Context;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v0

    invoke-static {p3, v1, p4, v1}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->createAccountChangedIntent(Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->addRelatedProfileIDsToIntent(Landroid/content/Intent;Ljava/util/Set;)V

    const-string/jumbo v0, "com.amazon.identity.permission.MULTIPLE_PROFILE_AWARE"

    invoke-interface {p2, p3, v1, v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;->sendBroadcastToMainUser(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Landroid/accounts/Account;
    .param p3, "x3"    # Ljava/lang/String;
    .param p4, "x4"    # Ljava/lang/String;

    .prologue
    .line 17
    invoke-static {p1, p2, p3, p4}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->createAccountChangedIntent(Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    const-string/jumbo v1, "com.amazon.dcp.sso.permission.account.changed"

    invoke-interface {p0, p1, v0, v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;->sendBroadcast(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V

    return-void
.end method

.method private static addRelatedProfileIDsToIntent(Landroid/content/Intent;Ljava/util/Set;)V
    .locals 2
    .param p0, "intent"    # Landroid/content/Intent;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Intent;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 208
    .local p1, "profileSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Integer;>;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 209
    .local v0, "profileList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    const-string/jumbo v1, "com.amazon.identity.auth.extra.account.profiles"

    invoke-virtual {p0, v1, v0}, Landroid/content/Intent;->putIntegerArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 211
    return-void
.end method

.method private static createAccountChangedIntent(Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 3
    .param p0, "directedId"    # Ljava/lang/String;
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "action"    # Ljava/lang/String;
    .param p3, "packageName"    # Ljava/lang/String;

    .prologue
    .line 111
    invoke-static {p2}, Lcom/amazon/identity/auth/device/utils/SSOBroadcastIntentFactory;->createIntent(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 113
    .local v0, "accountChangedIntent":Landroid/content/Intent;
    if-eqz p3, :cond_0

    .line 115
    invoke-virtual {v0, p3}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 117
    :cond_0
    if-eqz p1, :cond_1

    .line 119
    const-string/jumbo v1, "com.amazon.dcp.sso.extra.account.name"

    iget-object v2, p1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 120
    const-string/jumbo v1, "com.amazon.dcp.sso.extra.account.type"

    iget-object v2, p1, Landroid/accounts/Account;->type:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 122
    :cond_1
    const-string/jumbo v1, "com.amazon.dcp.sso.extra.account.directed_id"

    invoke-virtual {v0, v1, p0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 124
    return-object v0
.end method

.method public static sendAccountForPackageChangedBroadcast(Landroid/content/Context;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 25
    invoke-static {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;->getMultipleAccountPlugin(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    move-result-object v0

    const/4 v1, 0x0

    new-instance v2, Landroid/content/Intent;

    const-string/jumbo v3, "com.amazon.identity.action.ACCOUNT_FOR_PACKAGE_CHANGED"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string/jumbo v3, "com.amazon.dcp.sso.permission.account.changed"

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;->sendBroadcast(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V

    .line 28
    return-void
.end method

.method private static sendAccountRemovedNotification(Landroid/content/Context;Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "account"    # Landroid/accounts/Account;
    .param p3, "action"    # Ljava/lang/String;
    .param p4, "packageName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Landroid/accounts/Account;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 173
    .local p5, "profilesForRemovedDirectedId":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Integer;>;"
    invoke-static {p1, p2, p3, p4}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->createAccountChangedIntent(Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 175
    .local v0, "accountChangedIntent":Landroid/content/Intent;
    invoke-static {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;->getMultipleAccountPlugin(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    move-result-object v1

    const-string/jumbo v2, "com.amazon.dcp.sso.permission.account.changed"

    invoke-interface {v1, p1, p5, v0, v2}, Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;->sendAccountRemovalBroadcast(Ljava/lang/String;Ljava/util/Set;Landroid/content/Intent;Ljava/lang/String;)V

    .line 180
    return-void
.end method

.method public static sendAccountRemovedNotification(Landroid/content/Context;ZLjava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Ljava/util/Set;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "isPrimaryAccount"    # Z
    .param p2, "removedDirectedId"    # Ljava/lang/String;
    .param p3, "account"    # Landroid/accounts/Account;
    .param p4, "packageName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Z",
            "Ljava/lang/String;",
            "Landroid/accounts/Account;",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p5, "profilesForRemovedDirectedId":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Integer;>;"
    const/4 v1, 0x0

    .line 81
    const-string/jumbo v0, "com.amazon.identity.auth.account.removed.on.device"

    invoke-static {p2, v1, v0, v1}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->createAccountChangedIntent(Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    invoke-static {v0, p5}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->addRelatedProfileIDsToIntent(Landroid/content/Intent;Ljava/util/Set;)V

    invoke-static {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;->getMultipleAccountPlugin(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    move-result-object v1

    const-string/jumbo v2, "com.amazon.identity.permission.MULTIPLE_PROFILE_AWARE"

    invoke-interface {v1, p2, v0, v2}, Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;->sendBroadcastToMainUser(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V

    .line 85
    if-eqz p1, :cond_0

    .line 87
    const-string/jumbo v3, "com.amazon.dcp.sso.action.account.removed"

    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    move-object v4, p4

    move-object v5, p5

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->sendAccountRemovedNotification(Landroid/content/Context;Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V

    .line 103
    :goto_0
    return-void

    .line 96
    :cond_0
    const-string/jumbo v3, "com.amazon.dcp.sso.action.secondary.account.removed"

    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    move-object v4, p4

    move-object v5, p5

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->sendAccountRemovedNotification(Landroid/content/Context;Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V

    goto :goto_0
.end method

.method public static sendAsynchronousAccountAddedNotification(Landroid/content/Context;Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "multipleAccountManager"    # Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
    .param p2, "multipleAccountPlugin"    # Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;
    .param p3, "directedId"    # Ljava/lang/String;
    .param p4, "packageName"    # Ljava/lang/String;

    .prologue
    .line 36
    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;

    move-object v1, p0

    move-object v2, p3

    move-object v3, p1

    move-object v4, p2

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;Ljava/lang/String;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    .line 69
    return-void
.end method
