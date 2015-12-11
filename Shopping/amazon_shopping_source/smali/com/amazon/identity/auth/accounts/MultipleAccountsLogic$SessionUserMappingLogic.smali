.class Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;
.super Ljava/lang/Object;
.source "MultipleAccountsLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SessionUserMappingLogic"
.end annotation


# instance fields
.field private final mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private final mSessionUserChanger:Lcom/amazon/identity/auth/accounts/SessionUserChanger;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V
    .locals 1
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .param p2, "amazonAccountManager"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .prologue
    .line 138
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 139
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 141
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 142
    new-instance v0, Lcom/amazon/identity/auth/accounts/SessionUserChanger;

    invoke-direct {v0, p2}, Lcom/amazon/identity/auth/accounts/SessionUserChanger;-><init>(Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->mSessionUserChanger:Lcom/amazon/identity/auth/accounts/SessionUserChanger;

    .line 143
    return-void
.end method

.method public static constructSessionUserMappingsForAccount(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p0, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .param p1, "amznAcctMan"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
    .param p2, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;",
            "Lcom/amazon/identity/auth/accounts/AmazonAccountManager;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;",
            ">;"
        }
    .end annotation

    .prologue
    .line 149
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 150
    .local v0, "sessionUserMappings":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;>;"
    invoke-virtual {p1, p2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isSessionUserAmazonAccount(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 152
    new-instance v1, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;

    invoke-direct {v1, p0, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 155
    :cond_0
    return-object v0
.end method

.method private createChangedNotification(Z)Ljava/util/List;
    .locals 4
    .param p1, "changed"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 216
    if-eqz p1, :cond_0

    .line 218
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;

    const/4 v1, 0x0

    new-instance v2, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;

    const-string/jumbo v3, "com.amazon.identity.action.ACCOUNT_FOR_PACKAGE_CHANGED"

    invoke-direct {v2, v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;-><init>(Ljava/lang/String;)V

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    .line 221
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    goto :goto_0
.end method


# virtual methods
.method public isMappingCurrentlySetForAccount(Ljava/lang/String;)Z
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 167
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isSessionUserAmazonAccount(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public isSupportedOnThisPlatform()Z
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$SessionUserMappingType;->isSupportedOnThisPlatform(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public onDeregister(Ljava/lang/String;)Ljava/util/List;
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 201
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isSessionUserAmazonAccount(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 203
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Account is not a session user, so cannot remove"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 204
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 211
    :goto_0
    return-object v1

    .line 207
    :cond_0
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    .line 209
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->mSessionUserChanger:Lcom/amazon/identity/auth/accounts/SessionUserChanger;

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->onSessionUserDeregistered(Ljava/lang/String;)Ljava/util/Set;

    .line 210
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isSessionUserAmazonAccount(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    const/4 v0, 0x1

    .line 211
    .local v0, "removedSessionUsers":Z
    :goto_1
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->createChangedNotification(Z)Ljava/util/List;

    move-result-object v1

    goto :goto_0

    .line 210
    .end local v0    # "removedSessionUsers":Z
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public removeAndNotify(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 188
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isSessionUserAmazonAccount(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 190
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Account is not a session user, so cannot remove"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 195
    :goto_0
    return-object v0

    .line 194
    :cond_0
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    .line 195
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getDevicePrimaryAmazonAccount()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->setAndNotify(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public setAndNotify(Ljava/lang/String;)Ljava/util/List;
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 173
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isSessionUserAmazonAccount(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 175
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Account is already a session user"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 182
    :goto_0
    return-object v1

    .line 179
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->mSessionUserChanger:Lcom/amazon/identity/auth/accounts/SessionUserChanger;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/ArrayUtil;->asSet([Ljava/lang/Object;)Ljava/util/Set;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/accounts/SessionUserChanger;->changeSessionUsers(Ljava/util/Set;)Ljava/util/Set;

    .line 180
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isSessionUserAmazonAccount(Ljava/lang/String;)Z

    move-result v0

    .line 182
    .local v0, "changedSessionUsers":Z
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$SessionUserMappingLogic;->createChangedNotification(Z)Ljava/util/List;

    move-result-object v1

    goto :goto_0
.end method
