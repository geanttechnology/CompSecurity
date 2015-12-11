.class Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$DevicePrimaryUserMappingLogic;
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
    name = "DevicePrimaryUserMappingLogic"
.end annotation


# instance fields
.field private final mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private final mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V
    .locals 0
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .param p2, "amazonAccountManager"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .prologue
    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 84
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$DevicePrimaryUserMappingLogic;->mContext:Landroid/content/Context;

    .line 86
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$DevicePrimaryUserMappingLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 87
    return-void
.end method

.method public static isDevicePlatformMappingSet(Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)Z
    .locals 1
    .param p0, "amznAcctMan"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 104
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isDevicePrimaryAmazonAccount(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public isMappingCurrentlySetForAccount(Ljava/lang/String;)Z
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$DevicePrimaryUserMappingLogic;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$DevicePrimaryUserMappingLogic;->isDevicePlatformMappingSet(Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public isSupportedOnThisPlatform()Z
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$DevicePrimaryUserMappingLogic;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;->isSupportedOnThisPlatform(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public onDeregister(Ljava/lang/String;)Ljava/util/List;
    .locals 1
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
    .line 124
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    .line 125
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    return-object v0
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
    .line 117
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Primary user mapping cannot be removed"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    return-object v0
.end method

.method public setAndNotify(Ljava/lang/String;)Ljava/util/List;
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
    .line 110
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Primary user mapping cannot be changed"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 111
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    return-object v0
.end method
