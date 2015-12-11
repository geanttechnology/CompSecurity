.class Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$CustomKeyMappingLogic;
.super Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;
.source "MultipleAccountsLogic.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "CustomKeyMappingLogic"
.end annotation


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V
    .locals 0
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .param p2, "mapping"    # Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .param p3, "amazonAccountManager"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .prologue
    .line 508
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V

    .line 509
    return-void
.end method

.method public static constructCustomKeyMappingsForAccount(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)Ljava/util/List;
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
            "Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$CustomKeyMappingLogic;",
            ">;"
        }
    .end annotation

    .prologue
    .line 515
    new-instance v4, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    invoke-direct {v4, p0}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;-><init>(Landroid/content/Context;)V

    .line 517
    const-string/jumbo v5, "com.amazon.dcp.sso.property.account.extratokens.custom_keys"

    invoke-static {v4, p2, v5}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$CustomKeyMappingLogic;->getMetadataForAccount(Lcom/amazon/identity/auth/device/storage/DataStorage;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v3

    .line 520
    .local v3, "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 522
    .local v0, "customKeyMappingLogics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$CustomKeyMappingLogic;>;"
    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 524
    .local v2, "key":Ljava/lang/String;
    new-instance v4, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$CustomKeyMappingLogic;

    new-instance v5, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$CustomKeyMappingType;

    invoke-direct {v5, v2}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$CustomKeyMappingType;-><init>(Ljava/lang/String;)V

    invoke-direct {v4, p0, v5, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$CustomKeyMappingLogic;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V

    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 529
    .end local v2    # "key":Ljava/lang/String;
    :cond_0
    return-object v0
.end method


# virtual methods
.method public isSupportedOnThisPlatform()Z
    .locals 1

    .prologue
    .line 535
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$CustomKeyMappingLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$CustomKeyMappingType;->isSupportedOnThisPlatform(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public notifyOfChange()Ljava/util/List;
    .locals 8
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
    const/4 v7, 0x0

    .line 541
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$CustomKeyMappingLogic;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingValue()Ljava/lang/String;

    move-result-object v1

    .line 543
    .local v1, "key":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "com.amazon.identity.action.ACCOUNT_FOR_KEY."

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 545
    .local v2, "specificKeyAction":Ljava/lang/String;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 546
    .local v0, "extras":Landroid/os/Bundle;
    const-string/jumbo v3, "account_key"

    invoke-virtual {v0, v3, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 548
    const/4 v3, 0x2

    new-array v3, v3, [Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;

    const/4 v4, 0x0

    new-instance v5, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;

    invoke-direct {v5, v2, v7, v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    aput-object v5, v3, v4

    const/4 v4, 0x1

    new-instance v5, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;

    const-string/jumbo v6, "com.amazon.identity.action.ACCOUNT_FOR_KEY"

    invoke-direct {v5, v6, v7, v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    aput-object v5, v3, v4

    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    return-object v3
.end method
