.class Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$PackageMappingLogic;
.super Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;
.source "MultipleAccountsLogic.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "PackageMappingLogic"
.end annotation


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V
    .locals 0
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .param p2, "mapping"    # Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .param p3, "amazonAccountManager"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .prologue
    .line 463
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V

    .line 464
    return-void
.end method

.method public static constructPackageMappingsForAccount(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)Ljava/util/List;
    .locals 6
    .param p0, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .param p1, "amazonAccountManager"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
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
            "Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$PackageMappingLogic;",
            ">;"
        }
    .end annotation

    .prologue
    .line 470
    new-instance v4, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    invoke-direct {v4, p0}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;-><init>(Landroid/content/Context;)V

    .line 472
    const-string/jumbo v5, "com.amazon.dcp.sso.property.account.extratokens.account_packages"

    invoke-static {v4, p2, v5}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$PackageMappingLogic;->getMetadataForAccount(Lcom/amazon/identity/auth/device/storage/DataStorage;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v3

    .line 475
    .local v3, "packageNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 477
    .local v1, "packageMappingLogics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$PackageMappingLogic;>;"
    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 479
    .local v2, "packageName":Ljava/lang/String;
    new-instance v4, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$PackageMappingLogic;

    new-instance v5, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;

    invoke-direct {v5, v2}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;-><init>(Ljava/lang/String;)V

    invoke-direct {v4, p0, v5, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$PackageMappingLogic;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V

    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 484
    .end local v2    # "packageName":Ljava/lang/String;
    :cond_0
    return-object v1
.end method


# virtual methods
.method public isSupportedOnThisPlatform()Z
    .locals 1

    .prologue
    .line 490
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$PackageMappingLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;->isSupportedOnThisPlatform(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public notifyOfChange()Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 496
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;

    const/4 v1, 0x0

    new-instance v2, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;

    const-string/jumbo v3, "com.amazon.identity.action.ACCOUNT_FOR_PACKAGE_CHANGED"

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$PackageMappingLogic;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingValue()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-direct {v2, v3, v4, v5}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
