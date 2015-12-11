.class public Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;
.super Ljava/lang/Object;
.source "ProfileMultipleAccountPlugin.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x11
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private final mContext:Landroid/content/Context;

.field private final mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

.field private final mSendBroadcastCrossProfile:Z

.field private final mUserManWrapper:Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 39
    const-class v0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V
    .locals 6
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .prologue
    .line 49
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    move-result-object v2

    new-instance v3, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;

    invoke-direct {v3, p1}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V

    new-instance v4, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-direct {v4, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;-><init>(Landroid/content/Context;)V

    invoke-static {p1}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v0

    const-string/jumbo v1, "send.broadcast.cross.user"

    const/4 v5, 0x0

    invoke-virtual {v0, v1, v5}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingBoolean(Ljava/lang/String;Z)Z

    move-result v5

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Z)V

    .line 54
    return-void
.end method

.method constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Z)V
    .locals 0
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .param p2, "multipleAccountLogic"    # Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
    .param p3, "userManWrapper"    # Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;
    .param p4, "amazonAccountManager"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
    .param p5, "sendBroadcastCrossProfile"    # Z

    .prologue
    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mContext:Landroid/content/Context;

    .line 63
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    .line 64
    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mUserManWrapper:Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;

    .line 65
    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 66
    iput-boolean p5, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mSendBroadcastCrossProfile:Z

    .line 67
    return-void
.end method

.method private sendBroadcastInternal$3f4fcad8(Landroid/content/Intent;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)V
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "receiverPermission"    # Ljava/lang/String;
    .param p3, "androidUser"    # Lcom/amazon/identity/auth/device/framework/AndroidUser;

    .prologue
    .line 113
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 115
    .local v0, "action":Ljava/lang/String;
    sget-object v1, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->TAG:Ljava/lang/String;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object v0, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getUserId()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 117
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->setIntentPriority(Landroid/content/Intent;)V

    .line 119
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mContext:Landroid/content/Context;

    invoke-static {v1, p1, p2, p3}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->secureSendBroadcast(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)V

    .line 120
    return-void
.end method

.method private setIntentPriority(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 124
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 126
    .local v0, "action":Ljava/lang/String;
    const-string/jumbo v1, "com.amazon.dcp.sso.action.account.added"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "com.amazon.dcp.sso.action.secondary.account.added"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "com.amazon.identity.auth.account.added.on.device"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "com.amazon.dcp.sso.action.AmazonAccountPropertyService.property.changed"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "com.amazon.dcp.sso.broadcast.CORPFMHasChanged"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 139
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Using foreground priority for "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 140
    const/high16 v1, 0x10000000

    invoke-virtual {p1, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 142
    :cond_1
    return-void
.end method

.method private shouldWeFireThisBroadcastForThisAccountToThisUser(Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)Z
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "user"    # Lcom/amazon/identity/auth/device/framework/AndroidUser;

    .prologue
    const/4 v1, 0x1

    .line 213
    if-nez p1, :cond_1

    .line 229
    :cond_0
    :goto_0
    return v1

    .line 219
    :cond_1
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getUserId()I

    move-result v2

    invoke-static {v2}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;->createPrimaryMappingForProfile(I)Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;

    move-result-object v0

    .line 221
    .local v0, "primaryMappingType":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    invoke-virtual {v2, p1, v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->doesAccountHaveMapping(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 229
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    invoke-virtual {v2, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->isAPrimaryAccount(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public addDataOnAddAccount(Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)V
    .locals 6
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "regData"    # Landroid/os/Bundle;
    .param p3, "userdata"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 72
    const-string/jumbo v1, "profile_mapping"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string/jumbo v1, "profile_mapping"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    :goto_0
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    .line 73
    .local v0, "profileIdCreatingAccount":Ljava/lang/Integer;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    new-array v5, v2, [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;->createPrimaryMappingForProfile(I)Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;

    move-result-object v1

    aput-object v1, v5, v3

    invoke-virtual {v4, v5}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_3

    move v1, v2

    :goto_1
    if-eqz v1, :cond_0

    .line 77
    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.extratokens.account_profiles"

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p3, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 79
    :cond_0
    return-void

    .line 72
    .end local v0    # "profileIdCreatingAccount":Ljava/lang/Integer;
    :cond_1
    const-string/jumbo v1, "calling_profile"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-string/jumbo v1, "calling_profile"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    goto :goto_0

    :cond_2
    sget-object v1, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "No calling profile or mapping profile given. Defaulting to main profile"

    invoke-static {v1, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getOwnerId()I

    move-result v1

    goto :goto_0

    .restart local v0    # "profileIdCreatingAccount":Ljava/lang/Integer;
    :cond_3
    move v1, v3

    .line 73
    goto :goto_1
.end method

.method public deregisterAllAccountsOnAccountRemoval(Ljava/lang/String;)Z
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 195
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isDevicePrimaryAmazonAccount(Ljava/lang/String;)Z

    move-result v0

    .line 198
    .local v0, "res":Z
    sget-object v1, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "deregisterAllAccountsOnAccountRemoval returns: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 200
    return v0
.end method

.method public getAccountHierarchy(Ljava/lang/String;I)[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .locals 3
    .param p1, "callingPackageName"    # Ljava/lang/String;
    .param p2, "callingUserId"    # I

    .prologue
    .line 147
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    const/4 v1, 0x0

    new-instance v2, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;

    invoke-direct {v2, p1}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;-><init>(Ljava/lang/String;)V

    aput-object v2, v0, v1

    const/4 v1, 0x1

    invoke-static {p2}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;->createPrimaryMappingForProfile(I)Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;

    move-result-object v2

    aput-object v2, v0, v1

    return-object v0
.end method

.method public getVisibleUser()Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 154
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mUserManWrapper:Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->getCurrentUser()Lcom/amazon/identity/auth/device/framework/AndroidUser;

    move-result-object v0

    .line 155
    .local v0, "currentUser":Lcom/amazon/identity/auth/device/framework/AndroidUser;
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    new-array v3, v6, [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getUserId()I

    move-result v4

    invoke-static {v4}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;->createPrimaryMappingForProfile(I)Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;

    move-result-object v1

    .line 158
    .local v1, "directedId":Ljava/lang/String;
    sget-object v2, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->TAG:Ljava/lang/String;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getUserId()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    aput-object v1, v2, v6

    .line 163
    return-object v1
.end method

.method public notifyToolbarOfUserChanged(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V
    .locals 6
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "receiverPermission"    # Ljava/lang/String;

    .prologue
    .line 171
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->setIntentPriority(Landroid/content/Intent;)V

    .line 172
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mUserManWrapper:Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->getMainUser()Lcom/amazon/identity/auth/device/framework/AndroidUser;

    move-result-object v1

    .line 173
    .local v1, "mainUser":Lcom/amazon/identity/auth/device/framework/AndroidUser;
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mUserManWrapper:Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->getCurrentUser()Lcom/amazon/identity/auth/device/framework/AndroidUser;

    move-result-object v0

    .line 174
    .local v0, "currentUser":Lcom/amazon/identity/auth/device/framework/AndroidUser;
    sget-object v3, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->TAG:Ljava/lang/String;

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getUserId()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getUserId()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 180
    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->shouldWeFireThisBroadcastForThisAccountToThisUser(Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 182
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mContext:Landroid/content/Context;

    invoke-static {v3, p2, p3, v0}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->secureSendBroadcast(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)V

    .line 185
    :cond_0
    sget-object v3, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Sending broadcast to User 0 quick setting bar."

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 186
    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2, p2}, Landroid/content/Intent;-><init>(Landroid/content/Intent;)V

    .line 187
    .local v2, "systemUiIntent":Landroid/content/Intent;
    const-string/jumbo v3, "com.android.systemui"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 188
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mContext:Landroid/content/Context;

    const/4 v4, 0x0

    invoke-static {v3, v2, v4, v1}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->secureSendBroadcast(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)V

    .line 190
    return-void
.end method

.method public sendAccountRemovalBroadcast(Ljava/lang/String;Ljava/util/Set;Landroid/content/Intent;Ljava/lang/String;)V
    .locals 8
    .param p1, "removedDirectedId"    # Ljava/lang/String;
    .param p3, "intent"    # Landroid/content/Intent;
    .param p4, "receiverPermission"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Landroid/content/Intent;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 263
    .local p2, "profilesForRemovedDirectedId":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Integer;>;"
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mUserManWrapper:Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->getCurrentUser()Lcom/amazon/identity/auth/device/framework/AndroidUser;

    move-result-object v0

    .line 265
    .local v0, "currentUser":Lcom/amazon/identity/auth/device/framework/AndroidUser;
    if-nez v0, :cond_1

    .line 267
    sget-object v6, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Can not send broadcast if current AndroidUser is null"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 292
    :cond_0
    return-void

    .line 271
    :cond_1
    new-instance v4, Ljava/util/HashSet;

    invoke-direct {v4, p2}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 273
    .local v4, "profiles":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Integer;>;"
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getUserId()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    .line 274
    .local v1, "currentUserId":Ljava/lang/Integer;
    invoke-interface {v4, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 276
    invoke-direct {p0, p3, p4, v0}, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->sendBroadcastInternal$3f4fcad8(Landroid/content/Intent;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)V

    .line 277
    invoke-interface {v4, v1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 282
    :cond_2
    iget-boolean v6, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mSendBroadcastCrossProfile:Z

    if-eqz v6, :cond_0

    invoke-interface {v4}, Ljava/util/Set;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_0

    invoke-virtual {p3}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "com.amazon.dcp.sso.action.account.removed"

    invoke-static {v6, v7}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 285
    invoke-interface {p2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    .line 287
    .local v3, "profile":Ljava/lang/Integer;
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mUserManWrapper:Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v7

    invoke-virtual {v6, v7}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->getAndroidUserFromUserId(I)Lcom/amazon/identity/auth/device/framework/AndroidUser;

    move-result-object v5

    .line 288
    .local v5, "user":Lcom/amazon/identity/auth/device/framework/AndroidUser;
    invoke-direct {p0, p3, p4, v5}, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->sendBroadcastInternal$3f4fcad8(Landroid/content/Intent;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)V

    goto :goto_0
.end method

.method public sendBroadcast(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "receiverPermission"    # Ljava/lang/String;

    .prologue
    .line 87
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mUserManWrapper:Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->getCurrentUser()Lcom/amazon/identity/auth/device/framework/AndroidUser;

    move-result-object v0

    .line 89
    .local v0, "currentUser":Lcom/amazon/identity/auth/device/framework/AndroidUser;
    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->shouldWeFireThisBroadcastForThisAccountToThisUser(Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 91
    sget-object v1, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->TAG:Ljava/lang/String;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getUserId()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 99
    :goto_0
    return-void

    .line 98
    :cond_0
    invoke-direct {p0, p2, p3, v0}, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->sendBroadcastInternal$3f4fcad8(Landroid/content/Intent;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)V

    goto :goto_0
.end method

.method public sendBroadcastToMainUser(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "receiverPermission"    # Ljava/lang/String;

    .prologue
    .line 104
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->mUserManWrapper:Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/UserManagerWrapper;->getMainUser()Lcom/amazon/identity/auth/device/framework/AndroidUser;

    move-result-object v0

    .line 105
    .local v0, "mainUser":Lcom/amazon/identity/auth/device/framework/AndroidUser;
    invoke-direct {p0, p2, p3, v0}, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;->sendBroadcastInternal$3f4fcad8(Landroid/content/Intent;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)V

    .line 106
    return-void
.end method
