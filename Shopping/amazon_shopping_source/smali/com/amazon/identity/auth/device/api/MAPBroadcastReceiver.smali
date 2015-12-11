.class public abstract Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;
.super Landroid/content/BroadcastReceiver;
.source "MAPBroadcastReceiver.java"


# static fields
.field private static final ACCOUNT_ADDED_ACTIONS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final ACCOUNT_REMOVED_ACTIONS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 24
    const-class v0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;->TAG:Ljava/lang/String;

    .line 26
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 29
    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;->ACCOUNT_ADDED_ACTIONS:Ljava/util/Set;

    const-string/jumbo v1, "com.amazon.dcp.sso.action.account.added"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 30
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;->ACCOUNT_ADDED_ACTIONS:Ljava/util/Set;

    const-string/jumbo v1, "com.amazon.dcp.sso.action.secondary.account.added"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 33
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 36
    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;->ACCOUNT_REMOVED_ACTIONS:Ljava/util/Set;

    const-string/jumbo v1, "com.amazon.dcp.sso.action.account.removed"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 37
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;->ACCOUNT_REMOVED_ACTIONS:Ljava/util/Set;

    const-string/jumbo v1, "com.amazon.dcp.sso.action.secondary.account.removed"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 38
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method public static constructBackwardsCompatibleIntent(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/Intent;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v2, 0x0

    .line 93
    if-nez p1, :cond_1

    move-object v1, v2

    .line 115
    :cond_0
    :goto_0
    return-object v1

    .line 98
    :cond_1
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1, p1}, Landroid/content/Intent;-><init>(Landroid/content/Intent;)V

    .line 100
    .local v1, "backCompatIntent":Landroid/content/Intent;
    invoke-virtual {v1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 102
    .local v0, "action":Ljava/lang/String;
    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;->ACCOUNT_ADDED_ACTIONS:Ljava/util/Set;

    invoke-interface {v3, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;->ACCOUNT_REMOVED_ACTIONS:Ljava/util/Set;

    invoke-interface {v3, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 104
    :cond_2
    const-string/jumbo v3, "com.amazon.dcp.sso.extra.account.directed_id"

    invoke-virtual {v1, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_0

    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;->ACCOUNT_REMOVED_ACTIONS:Ljava/util/Set;

    invoke-virtual {v1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    move-object v1, v2

    goto :goto_0

    :cond_3
    const-string/jumbo v2, "com.amazon.dcp.sso.extra.account.type"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "com.amazon.dcp.sso.extra.account.name"

    invoke-virtual {v1, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {p0, v2, v3}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedId(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "com.amazon.dcp.sso.extra.account.directed_id"

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 106
    :cond_4
    const-string/jumbo v2, "com.amazon.dcp.sso.action.AmazonAccountPropertyService.property.changed"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 108
    const-string/jumbo v2, "new.account.property.changed"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_0

    const-string/jumbo v2, "account.property.changed"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/accounts/Account;

    invoke-static {p0, v2}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedId(Landroid/content/Context;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_5

    new-instance v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-direct {v2, p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccount()Ljava/lang/String;

    move-result-object v2

    :cond_5
    const-string/jumbo v3, "new.account.property.changed"

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 110
    :cond_6
    const-string/jumbo v2, "com.amazon.dcp.sso.broadcast.CORPFMHasChanged"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 112
    const-string/jumbo v2, "new.account.property.changed"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_0

    new-instance v2, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-direct {v2, p0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;-><init>(Landroid/content/Context;)V

    const-string/jumbo v3, "new.account.property.changed"

    invoke-virtual {v2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getDevicePrimaryAmazonAccount()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_0
.end method


# virtual methods
.method protected abstract backwardsCompatibleOnReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public final onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 49
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver$1;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver$1;-><init>(Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;Landroid/content/Context;Landroid/content/Intent;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    .line 66
    return-void
.end method
