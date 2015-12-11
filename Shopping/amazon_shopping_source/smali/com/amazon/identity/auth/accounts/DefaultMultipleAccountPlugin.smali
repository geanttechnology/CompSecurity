.class public Lcom/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin;
.super Ljava/lang/Object;
.source "DefaultMultipleAccountPlugin.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private final mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V
    .locals 1
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .prologue
    .line 27
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;)V

    .line 28
    return-void
.end method

.method constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;)V
    .locals 0
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .param p2, "multipleAccountLogic"    # Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 34
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    .line 35
    return-void
.end method


# virtual methods
.method public addDataOnAddAccount(Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)V
    .locals 0
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "regData"    # Landroid/os/Bundle;
    .param p3, "userdata"    # Landroid/os/Bundle;

    .prologue
    .line 41
    return-void
.end method

.method public deregisterAllAccountsOnAccountRemoval(Ljava/lang/String;)Z
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 74
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->isAPrimaryAccount(Ljava/lang/String;)Z

    move-result v0

    .line 76
    .local v0, "res":Z
    sget-object v1, Lcom/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "deregisterAllAccountsOnAccountRemoval returns: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 78
    return v0
.end method

.method public getAccountHierarchy(Ljava/lang/String;I)[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .locals 3
    .param p1, "callingPackageName"    # Ljava/lang/String;
    .param p2, "callingUserId"    # I

    .prologue
    .line 52
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    const/4 v1, 0x0

    new-instance v2, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;

    invoke-direct {v2, p1}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;-><init>(Ljava/lang/String;)V

    aput-object v2, v0, v1

    const/4 v1, 0x1

    new-instance v2, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$SessionUserMappingType;

    invoke-direct {v2}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$SessionUserMappingType;-><init>()V

    aput-object v2, v0, v1

    const/4 v1, 0x2

    invoke-static {p2}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;->createPrimaryMappingForProfile(I)Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;

    move-result-object v2

    aput-object v2, v0, v1

    return-object v0
.end method

.method public getVisibleUser()Ljava/lang/String;
    .locals 4

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    const/4 v1, 0x2

    new-array v1, v1, [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    const/4 v2, 0x0

    new-instance v3, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$SessionUserMappingType;

    invoke-direct {v3}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$SessionUserMappingType;-><init>()V

    aput-object v3, v1, v2

    const/4 v2, 0x1

    new-instance v3, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;

    invoke-direct {v3}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;-><init>()V

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public notifyToolbarOfUserChanged(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "receiverPermission"    # Ljava/lang/String;

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const/4 v1, 0x0

    invoke-static {v0, p2, p3, v1}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->secureSendBroadcast(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)V

    .line 69
    return-void
.end method

.method public sendAccountRemovalBroadcast(Ljava/lang/String;Ljava/util/Set;Landroid/content/Intent;Ljava/lang/String;)V
    .locals 0
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
    .line 87
    .local p2, "profilesForRemovedDirectedId":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Integer;>;"
    invoke-virtual {p0, p1, p3, p4}, Lcom/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin;->sendBroadcast(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V

    .line 88
    return-void
.end method

.method public sendBroadcast(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "receiverPermission"    # Ljava/lang/String;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const/4 v1, 0x0

    invoke-static {v0, p2, p3, v1}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->secureSendBroadcast(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/AndroidUser;)V

    .line 47
    return-void
.end method

.method public sendBroadcastToMainUser(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "receiverPermission"    # Ljava/lang/String;

    .prologue
    .line 95
    sget-object v0, Lcom/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Cannot send broadcasts to multiple profiles on a platform where multiple profiles are not supported. (Only 1P GEN6+ Devices after Android 4.2 supporting the multiple profiles)"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 97
    return-void
.end method
