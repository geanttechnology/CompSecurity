.class abstract Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;
.super Ljava/lang/Object;
.source "MultipleAccountsLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$AccountMappingLogic;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x40a
    name = "MetadataMappingClass"
.end annotation


# instance fields
.field private final mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field protected final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

.field protected final mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;)V
    .locals 2
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .param p2, "mapping"    # Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .param p3, "amazonAccountManager"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .prologue
    .line 236
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 237
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 239
    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 241
    new-instance v0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    .line 243
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .line 244
    return-void
.end method

.method public static getMetadataForAccount(Lcom/amazon/identity/auth/device/storage/DataStorage;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Set;
    .locals 4
    .param p0, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "metadataKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/storage/DataStorage;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 261
    invoke-virtual {p0, p1, p2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 262
    .local v2, "keysStr":Ljava/lang/String;
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 263
    .local v0, "keySet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 270
    :goto_0
    return-object v0

    .line 268
    :cond_0
    const-string/jumbo v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 269
    .local v1, "keys":[Ljava/lang/String;
    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    goto :goto_0
.end method

.method private removeMappingFromAccount(Ljava/lang/String;)Z
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 370
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingType()Ljava/lang/String;

    move-result-object v0

    .line 371
    .local v0, "type":Ljava/lang/String;
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingValue()Ljava/lang/String;

    move-result-object v1

    .line 373
    .local v1, "value":Ljava/lang/String;
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    invoke-static {v5, p1, v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->getMetadataForAccount(Lcom/amazon/identity/auth/device/storage/DataStorage;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v2

    .line 374
    .local v2, "values":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    new-array v5, v7, [Ljava/lang/Object;

    aput-object v0, v5, v3

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v4

    .line 376
    invoke-interface {v2, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 378
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Cannot remove %s for type %s from account"

    new-array v7, v7, [Ljava/lang/Object;

    aput-object v1, v7, v3

    aput-object v0, v7, v4

    invoke-static {v5, v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 388
    :goto_0
    return v3

    .line 382
    :cond_0
    invoke-interface {v2, v1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 384
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    new-array v5, v7, [Ljava/lang/Object;

    aput-object v0, v5, v3

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v5, v4

    .line 386
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    invoke-direct {p0, v2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->seralizeValues(Ljava/util/Set;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, p1, v0, v5}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    move v3, v4

    .line 388
    goto :goto_0
.end method

.method private seralizeValues(Ljava/util/Set;)Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 393
    .local p1, "values":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    if-nez p1, :cond_0

    .line 395
    const/4 v0, 0x0

    .line 398
    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, ","

    invoke-static {v0, p1}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public isMappingCurrentlySetForAccount(Ljava/lang/String;)Z
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 252
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingType()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, p1, v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->getMetadataForAccount(Lcom/amazon/identity/auth/device/storage/DataStorage;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v0

    .line 254
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingValue()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public abstract isSupportedOnThisPlatform()Z
.end method

.method protected abstract notifyOfChange()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$NotificationInfo;",
            ">;"
        }
    .end annotation
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
    .line 322
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->removeAndNotify(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public removeAndNotify(Ljava/lang/String;)Ljava/util/List;
    .locals 6
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
    const/4 v2, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 299
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->removeMappingFromAccount(Ljava/lang/String;)Z

    move-result v0

    .line 300
    if-eqz v0, :cond_0

    .line 302
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Notifying of user change of type %s removed. Account for profile %s changed."

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingType()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingValue()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 306
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->notifyOfChange()Ljava/util/List;

    move-result-object v0

    .line 314
    :goto_0
    return-object v0

    .line 310
    :cond_0
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Cannot remove mapping type %s for key %s did not change. Not notifing."

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingType()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingValue()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 314
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    goto :goto_0
.end method

.method public setAndNotify(Ljava/lang/String;)Ljava/util/List;
    .locals 11
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
    const/4 v10, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 276
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getAccounts()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    move v1, v2

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingType()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingValue()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    invoke-static {v7, v0, v5}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->getMetadataForAccount(Lcom/amazon/identity/auth/device/storage/DataStorage;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v7

    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    new-array v8, v10, [Ljava/lang/Object;

    aput-object v5, v8, v2

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v3

    invoke-interface {v7, v6}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v7, "Cannot create mapping of type with value %s to account"

    new-array v8, v10, [Ljava/lang/Object;

    aput-object v5, v8, v2

    aput-object v6, v8, v3

    invoke-static {v0, v7, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    move v0, v2

    :goto_1
    or-int/2addr v0, v1

    move v1, v0

    goto :goto_0

    :cond_0
    invoke-interface {v7, v6}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    new-array v6, v10, [Ljava/lang/Object;

    aput-object v5, v6, v2

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v3

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    invoke-direct {p0, v7}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->seralizeValues(Ljava/util/Set;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v0, v5, v7}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    move v0, v3

    goto :goto_1

    :cond_1
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->removeMappingFromAccount(Ljava/lang/String;)Z

    goto :goto_0

    .line 278
    :cond_2
    if-eqz v1, :cond_3

    .line 280
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Notifying of user change of type %s set. Account for profile %s changed."

    new-array v4, v10, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingType()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v2

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingValue()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v4, v3

    invoke-static {v0, v1, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 284
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->notifyOfChange()Ljava/util/List;

    move-result-object v0

    .line 292
    :goto_2
    return-object v0

    .line 288
    :cond_3
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Setting mapping type %s for key %s did not change. Not notifing."

    new-array v4, v10, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingType()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v2

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic$MetadataMappingClass;->mMapping:Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingValue()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v4, v3

    invoke-static {v0, v1, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 292
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    goto :goto_2
.end method
