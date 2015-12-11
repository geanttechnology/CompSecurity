.class public Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
.super Ljava/lang/Object;
.source "AmazonAccountManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 59
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;-><init>(Lcom/amazon/identity/auth/device/storage/DataStorage;)V

    .line 60
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/storage/DataStorage;)V
    .locals 0
    .param p1, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 65
    return-void
.end method


# virtual methods
.method public doesAccountExist(Ljava/lang/String;)Z
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 209
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getAccounts()Ljava/util/Set;

    move-result-object v1

    .line 210
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 212
    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 214
    const/4 v1, 0x1

    .line 217
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public doesAccountExistAfterDeregisteringStateCleanup(Ljava/lang/String;)Z
    .locals 5
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 228
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getAccounts()Ljava/util/Set;

    move-result-object v1

    .line 229
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 231
    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.ACCOUNT_STATUS"

    invoke-virtual {p0, p1, v1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;->fromValue(Ljava/lang/String;)Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;

    move-result-object v1

    sget-object v4, Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;->Deregistering:Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;

    if-ne v1, v4, :cond_1

    const-string/jumbo v1, "AccountRemovedBecauseDeregisteringState"

    new-array v4, v3, [Ljava/lang/String;

    invoke-static {v1, v4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    sget-object v1, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Removing account from database since database is stuck in bad state. Account status is Deregistering and registerAccount API is called"

    invoke-static {v1, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->removeAccount(Ljava/lang/String;)V

    move v1, v2

    :goto_0
    if-nez v1, :cond_0

    move v1, v2

    .line 237
    :goto_1
    return v1

    :cond_1
    move v1, v3

    .line 231
    goto :goto_0

    :cond_2
    move v1, v3

    .line 237
    goto :goto_1
.end method

.method public getAccountRegistrationStatus(Ljava/lang/String;)Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 285
    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.ACCOUNT_STATUS"

    invoke-virtual {p0, p1, v1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 286
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;->fromValue(Ljava/lang/String;)Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;

    move-result-object v0

    .line 289
    .local v0, "currentStatus":Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;
    if-eqz v0, :cond_0

    .line 301
    .end local v0    # "currentStatus":Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;
    :goto_0
    return-object v0

    .line 295
    .restart local v0    # "currentStatus":Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;
    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 297
    sget-object v0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;->Registered:Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;

    goto :goto_0

    .line 301
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;->NotFound:Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;

    goto :goto_0
.end method

.method public getAccountValidator(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 276
    const-string/jumbo v0, "com.amazon.dcp.sso.property.account.UUID"

    invoke-virtual {p0, p1, v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getAccounts()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 105
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getAccounts()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public getDevicePrimaryAmazonAccount()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v3, 0x0

    .line 83
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getNonDeregisteringAmazonAccounts()Ljava/util/Set;

    move-result-object v0

    .line 84
    .local v0, "accountsDirectedIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v4

    if-gtz v4, :cond_0

    move-object v1, v3

    .line 96
    :goto_0
    return-object v1

    .line 89
    :cond_0
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 91
    .local v1, "directedId":Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isSecondaryAmazonAccount(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    goto :goto_0

    .end local v1    # "directedId":Ljava/lang/String;
    :cond_2
    move-object v1, v3

    .line 96
    goto :goto_0
.end method

.method public getNonDeregisteringAmazonAccounts()Ljava/util/Set;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 110
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getAccounts()Ljava/util/Set;

    move-result-object v1

    .line 111
    .local v1, "directedIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    .line 112
    .local v3, "nonDeregisteringDirectedIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 114
    .local v0, "directedId":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isAccountDeregistering(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 116
    invoke-interface {v3, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 120
    .end local v0    # "directedId":Ljava/lang/String;
    :cond_1
    return-object v3
.end method

.method public getSecondaryAmazonAccounts()Ljava/util/Set;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 166
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getAccounts()Ljava/util/Set;

    move-result-object v1

    .line 167
    .local v1, "allAccounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    .line 168
    .local v3, "secondaryAccounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 170
    .local v0, "account":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isSecondaryAmazonAccount(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 172
    invoke-interface {v3, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 175
    .end local v0    # "account":Ljava/lang/String;
    :cond_1
    return-object v3
.end method

.method public getSessionUsers()Ljava/util/Set;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 135
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    .line 137
    .local v2, "sessionUsers":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getAccounts()Ljava/util/Set;

    move-result-object v3

    .line 138
    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 140
    .local v0, "account":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isSessionUserAmazonAccount(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 142
    invoke-interface {v2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 146
    .end local v0    # "account":Ljava/lang/String;
    :cond_1
    return-object v2
.end method

.method public getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 266
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public hasDevicePrimaryAmazonAccount()Z
    .locals 1

    .prologue
    .line 72
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getDevicePrimaryAmazonAccount()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isAccountDeregistering(Ljava/lang/String;)Z
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 125
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getAccountRegistrationStatus(Ljava/lang/String;)Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;

    move-result-object v0

    .line 126
    .local v0, "status":Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;
    sget-object v1, Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;->NotFound:Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;

    if-eq v0, v1, :cond_0

    sget-object v1, Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;->Deregistering:Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isDevicePrimaryAmazonAccount(Ljava/lang/String;)Z
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 200
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isSecondaryAmazonAccount(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isSecondaryAmazonAccount(Ljava/lang/String;)Z
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 183
    const-string/jumbo v0, "com.amazon.dcp.sso.property.secondary"

    invoke-virtual {p0, p1, v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isSessionUserAmazonAccount(Ljava/lang/String;)Z
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 191
    const-string/jumbo v0, "com.amazon.dcp.sso.property.sessionuser"

    invoke-virtual {p0, p1, v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public removeAccountAsSessionUser(Ljava/lang/String;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 158
    const-string/jumbo v0, "com.amazon.dcp.sso.property.sessionuser"

    const/4 v1, 0x0

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    return-void
.end method

.method public setAccountAsSessionUser(Ljava/lang/String;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 152
    const-string/jumbo v0, "com.amazon.dcp.sso.property.sessionuser"

    const-string/jumbo v1, "true"

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 153
    return-void
.end method

.method public setAccountRegistrationStatus(Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "status"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;

    .prologue
    .line 308
    const-string/jumbo v0, "com.amazon.dcp.sso.property.account.ACCOUNT_STATUS"

    invoke-virtual {p2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 309
    return-void
.end method

.method public setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 271
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 272
    return-void
.end method
