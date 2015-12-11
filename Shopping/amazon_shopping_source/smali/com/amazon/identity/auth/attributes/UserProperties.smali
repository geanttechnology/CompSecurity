.class public final Lcom/amazon/identity/auth/attributes/UserProperties;
.super Ljava/lang/Object;
.source "UserProperties.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/identity/auth/attributes/UserProperties;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/attributes/UserProperties;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    return-void
.end method

.method public static forceSendPropertyChangedBroadcast(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "properties"    # Landroid/os/Bundle;

    .prologue
    .line 86
    sget-object v4, Lcom/amazon/identity/auth/attributes/UserProperties;->TAG:Ljava/lang/String;

    .line 88
    const-string/jumbo v4, "com.amazon.dcp.sso.action.AmazonAccountPropertyService.property.changed"

    invoke-static {v4}, Lcom/amazon/identity/auth/device/utils/SSOBroadcastIntentFactory;->createIntent(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    .line 91
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {p2}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 93
    .local v2, "key":Ljava/lang/String;
    sget-object v4, Lcom/amazon/identity/auth/attributes/UserProperties;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Key = %s, Value = %s"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v2, v5, v6

    const/4 v6, 0x1

    invoke-virtual {p2, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 94
    invoke-virtual {p2, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 97
    .end local v2    # "key":Ljava/lang/String;
    :cond_0
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountWithDirectedId(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v3

    .line 98
    .local v3, "oldAccount":Landroid/accounts/Account;
    if-eqz v3, :cond_1

    .line 100
    const-string/jumbo v4, "account.property.changed"

    invoke-virtual {v1, v4, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 103
    :cond_1
    const-string/jumbo v4, "new.account.property.changed"

    invoke-virtual {v1, v4, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 105
    invoke-static {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;->getMultipleAccountPlugin(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    move-result-object v4

    .line 108
    const-string/jumbo v5, "com.amazon.dcp.sso.permission.AmazonAccountPropertyService.property.changed"

    invoke-interface {v4, p1, v1, v5}, Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;->notifyToolbarOfUserChanged(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V

    .line 112
    sget-object v4, Lcom/amazon/identity/auth/attributes/UserProperties;->TAG:Ljava/lang/String;

    .line 113
    return-void
.end method

.method public static getVisibleToolbarUser(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 117
    invoke-static {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;->getMultipleAccountPlugin(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    move-result-object v0

    .line 120
    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;->getVisibleUser()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static sendDeviceEmailChangedNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "deviceEmail"    # Ljava/lang/String;

    .prologue
    .line 52
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 54
    sget-object v1, Lcom/amazon/identity/auth/attributes/UserProperties;->TAG:Ljava/lang/String;

    .line 57
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/attributes/UserProperties;->TAG:Ljava/lang/String;

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p2, v1, v2

    .line 59
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 60
    .local v0, "changedProperties":Landroid/os/Bundle;
    const-string/jumbo v1, "com.amazon.dcp.sso.property.deviceemail"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    invoke-static {p0, p1, v0}, Lcom/amazon/identity/auth/attributes/UserProperties;->sendPropertyChangedBroadcast(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 63
    return-object v0
.end method

.method public static sendDeviceNameChangedNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "newDeviceName"    # Ljava/lang/String;

    .prologue
    .line 40
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 41
    .local v0, "properties":Landroid/os/Bundle;
    const-string/jumbo v1, "com.amazon.dcp.sso.property.devicename"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    invoke-static {p0, p1, v0}, Lcom/amazon/identity/auth/attributes/UserProperties;->sendPropertyChangedBroadcast(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 45
    return-object v0
.end method

.method public static sendPropertyChangedBroadcast(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "properties"    # Landroid/os/Bundle;

    .prologue
    .line 70
    sget-object v0, Lcom/amazon/identity/auth/attributes/UserProperties;->TAG:Ljava/lang/String;

    .line 72
    if-eqz p1, :cond_0

    invoke-static {p0}, Lcom/amazon/identity/auth/attributes/UserProperties;->getVisibleToolbarUser(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 74
    sget-object v0, Lcom/amazon/identity/auth/attributes/UserProperties;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Not notifying that the given accounts property has changed because it is not currently visibile"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    :goto_0
    return-void

    .line 79
    :cond_0
    invoke-static {p0, p1, p2}, Lcom/amazon/identity/auth/attributes/UserProperties;->forceSendPropertyChangedBroadcast(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public static storeDeviceName(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "newDeviceName"    # Ljava/lang/String;

    .prologue
    .line 29
    new-instance v0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;-><init>(Landroid/content/Context;)V

    .line 31
    const-string/jumbo v1, "com.amazon.dcp.sso.property.devicename"

    invoke-virtual {v0, p1, v1, p2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    invoke-static {p0, p1, p2}, Lcom/amazon/identity/auth/attributes/UserProperties;->sendDeviceNameChangedNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method
