.class Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;
.super Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;
.source "MultipleAccountsLogic.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ProfilePrimaryMappingLogic"
.end annotation


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V
    .locals 0
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .param p2, "mapping"    # Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .param p3, "amazonAccountManager"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .prologue
    .line 410
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V

    .line 411
    return-void
.end method

.method public static constructProfileMappingForAccount(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)Ljava/util/List;
    .locals 9
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
            "Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;",
            ">;"
        }
    .end annotation

    .prologue
    .line 417
    new-instance v5, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    invoke-direct {v5, p0}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;-><init>(Landroid/content/Context;)V

    .line 419
    const-string/jumbo v6, "com.amazon.dcp.sso.property.account.extratokens.account_profiles"

    invoke-static {v5, p2, v6}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;->getMetadataForAccount(Lcom/amazon/identity/auth/device/storage/DataStorage;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v4

    .line 422
    .local v4, "profileStrs":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 424
    .local v2, "profileMappingLogics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;>;"
    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 426
    .local v3, "profileStr":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    .line 427
    .local v1, "profileId":Ljava/lang/Integer;
    if-nez v1, :cond_0

    .line 429
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "%s is not a valid profile id"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v3, v7, v8

    invoke-static {v5, v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 433
    :cond_0
    new-instance v5, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v6

    invoke-static {v6}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;->createPrimaryMappingForProfile(I)Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;

    move-result-object v6

    invoke-direct {v5, p0, v6, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V

    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 438
    .end local v1    # "profileId":Ljava/lang/Integer;
    .end local v3    # "profileStr":Ljava/lang/String;
    :cond_1
    return-object v2
.end method


# virtual methods
.method public isSupportedOnThisPlatform()Z
    .locals 2

    .prologue
    .line 444
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$ProfilePrimaryMappingLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v1, "sso_platform"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 447
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->shouldUseProfiles()Z

    move-result v0

    return v0
.end method

.method public notifyOfChange()Ljava/util/List;
    .locals 4
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
    .line 453
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;

    const/4 v1, 0x0

    new-instance v2, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;

    const-string/jumbo v3, "com.amazon.identity.action.ACCOUNT_FOR_PACKAGE_CHANGED"

    invoke-direct {v2, v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;-><init>(Ljava/lang/String;)V

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
