.class final Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;
.super Ljava/lang/Object;
.source "AccountStateBroadcasts.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->sendAsynchronousAccountAddedNotification(Landroid/content/Context;Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$context:Landroid/content/Context;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$multipleAccountManager:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

.field final synthetic val$multipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

.field final synthetic val$packageName:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$context:Landroid/content/Context;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$directedId:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$multipleAccountManager:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$multipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    iput-object p5, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$packageName:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 41
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$context:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$directedId:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountWithDirectedId(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    .line 44
    .local v0, "account":Landroid/accounts/Account;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$context:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$multipleAccountManager:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$multipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$directedId:Ljava/lang/String;

    const-string/jumbo v5, "com.amazon.identity.auth.account.added.on.device"

    invoke-static {v1, v2, v3, v4, v5}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->access$000(Landroid/content/Context;Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$multipleAccountManager:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$directedId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->isAPrimaryAccount(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 52
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$multipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$directedId:Ljava/lang/String;

    const-string/jumbo v3, "com.amazon.dcp.sso.action.account.added"

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$packageName:Ljava/lang/String;

    invoke-static {v1, v2, v0, v3, v4}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->access$100(Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    :goto_0
    return-void

    .line 60
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$multipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$directedId:Ljava/lang/String;

    const-string/jumbo v3, "com.amazon.dcp.sso.action.secondary.account.added"

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts$1;->val$packageName:Ljava/lang/String;

    invoke-static {v1, v2, v0, v3, v4}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->access$100(Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
