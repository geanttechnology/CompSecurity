.class public final Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;
.super Ljava/lang/Object;
.source "AccountManagerDataMigrationHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper$AccountManagerLegacyDataEncryptor;
    }
.end annotation


# static fields
.field static final ACCOUNTS_COLUMNS_NUM:I = 0x4

.field static final ACCOUNT_DISPLAY_NAME_COLUMN_INDEX:I = 0x1

.field static final ACCOUNT_ID_COLUMN_INDEX:I = 0x0

.field static final EXTRA_COLUMNS_NUM:I = 0x4

.field static final ID_COLUMN_INDEX:I = 0x1

.field static final KEY_COLUMN_INDEX:I = 0x2

.field private static final TAG:Ljava/lang/String;

.field static final TOKENS_COLUMNS_NUM:I = 0x4

.field static final VALUE_COLUMN_INDEX:I = 0x3


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 46
    const-class v0, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    new-instance v0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    .line 54
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->mContext:Landroid/content/Context;

    .line 55
    return-void
.end method

.method private checkDuplicatedKeyInTwoMaps(Ljava/util/HashMap;Ljava/util/HashMap;)Z
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 626
    .local p1, "tokenMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p2, "userDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 629
    .local v2, "tokenEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 630
    .local v1, "key":Ljava/lang/String;
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 632
    .local v3, "value":Ljava/lang/String;
    invoke-virtual {p2, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 635
    invoke-virtual {p2, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/CharSequence;

    invoke-static {v3, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 637
    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "There\'s inconsistent data in two maps, the key is:"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "AccountManagerInconsistentData"

    invoke-virtual {p0, v4, v5}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    .line 639
    const/4 v4, 0x1

    .line 643
    .end local v1    # "key":Ljava/lang/String;
    .end local v2    # "tokenEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "value":Ljava/lang/String;
    :goto_0
    return v4

    :cond_1
    const/4 v4, 0x0

    goto :goto_0
.end method

.method private decryptTheTokenMap(Ljava/util/HashMap;Ljava/util/HashMap;)Z
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p1, "tokenMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p2, "userDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v7, 0x0

    .line 535
    const-string/jumbo v8, "com.amazon.dcp.sso.property.encryptKey"

    invoke-virtual {p2, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 536
    .local v3, "tokenEncryptionKey":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 538
    const-string/jumbo v8, "There\'s no encryption key for the token. This should be an error"

    const-string/jumbo v9, "AccountManagerMissingEncryptionKey"

    invoke-virtual {p0, v8, v9}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    .line 570
    :goto_0
    return v7

    .line 542
    :cond_0
    new-instance v4, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper$AccountManagerLegacyDataEncryptor;

    invoke-direct {v4, v3}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper$AccountManagerLegacyDataEncryptor;-><init>(Ljava/lang/String;)V

    .line 545
    .local v4, "tokenEncryptor":Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;
    invoke-virtual {p1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map$Entry;

    .line 548
    .local v5, "tokenEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v5}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 549
    .local v1, "key":Ljava/lang/String;
    invoke-interface {v5}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 552
    .local v6, "value":Ljava/lang/String;
    if-nez v6, :cond_1

    .line 554
    new-instance v8, Ljava/lang/StringBuilder;

    const-string/jumbo v9, "Cannot decrypt token when the value is null, the token key is: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "AccountManagerTokenValueIsNull"

    invoke-virtual {p0, v8, v9}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 559
    :cond_1
    invoke-virtual {p0, v4, v6}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->tryToDecryptData(Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 562
    .local v2, "tokenAfterDecryption":Ljava/lang/String;
    if-nez v2, :cond_2

    .line 564
    new-instance v8, Ljava/lang/StringBuilder;

    const-string/jumbo v9, "Error happened when decrypting the token, the token key is: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "AccountManagerTokenDecryptionFail"

    invoke-virtual {p0, v8, v9}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 568
    :cond_2
    invoke-interface {v5, v2}, Ljava/util/Map$Entry;->setValue(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 570
    .end local v1    # "key":Ljava/lang/String;
    .end local v2    # "tokenAfterDecryption":Ljava/lang/String;
    .end local v5    # "tokenEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v6    # "value":Ljava/lang/String;
    :cond_3
    const/4 v7, 0x1

    goto :goto_0
.end method

.method private decryptTheUserDataMap(Ljava/util/HashMap;)Z
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p1, "userDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v10, 0x0

    .line 473
    const-string/jumbo v9, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {p1, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 475
    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 477
    const-string/jumbo v9, "The directedId cannot be null, this should be an error."

    const-string/jumbo v11, "AccountManagerDirectedIdIsNull"

    invoke-virtual {p0, v9, v11}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    move v9, v10

    .line 526
    :goto_0
    return v9

    .line 482
    :cond_0
    const-string/jumbo v9, "com.amazon.dcp.sso.property.encryptKey"

    invoke-virtual {p1, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 483
    .local v5, "userDataEncryptionKey":Ljava/lang/String;
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 485
    const-string/jumbo v9, "The userdata encryption key cannot be null, this should be an error."

    const-string/jumbo v11, "AccountManagerEncryptionKeyIsNull"

    invoke-virtual {p0, v9, v11}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    move v9, v10

    .line 487
    goto :goto_0

    .line 490
    :cond_1
    new-instance v6, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper$AccountManagerLegacyDataEncryptor;

    invoke-direct {v6, v5}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper$AccountManagerLegacyDataEncryptor;-><init>(Ljava/lang/String;)V

    .line 492
    .local v6, "userDataEncryptor":Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;
    new-instance v9, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    iget-object v11, p0, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->mContext:Landroid/content/Context;

    const-string/jumbo v12, "dcp.only.protected.store"

    invoke-direct {v9, v11, v12}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 494
    const-string/jumbo v11, "dcp.only.encrypt.key"

    invoke-virtual {v9, v11}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 495
    .local v0, "dcpDataEncryptionKey":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 497
    const-string/jumbo v9, "The dcp encryption key cannot be null, this should be an error."

    const-string/jumbo v11, "DCPOnlyEncryptionKeyIsNull"

    invoke-virtual {p0, v9, v11}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    move v9, v10

    .line 499
    goto :goto_0

    .line 502
    :cond_2
    new-instance v1, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper$AccountManagerLegacyDataEncryptor;

    invoke-direct {v1, v0}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper$AccountManagerLegacyDataEncryptor;-><init>(Ljava/lang/String;)V

    .line 504
    .local v1, "dcpDataEncryptor":Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;
    invoke-virtual {p1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_3
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_5

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/Map$Entry;

    .line 506
    .local v7, "userDataEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v7}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 507
    .local v3, "key":Ljava/lang/String;
    invoke-interface {v7}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 509
    .local v8, "value":Ljava/lang/String;
    if-eqz v8, :cond_3

    .line 511
    invoke-virtual {p0, v6, v1, v3, v8}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->decryptUserDataIfNecessary(Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 516
    .local v4, "userDataAfterDecryption":Ljava/lang/String;
    if-nez v4, :cond_4

    .line 518
    new-instance v9, Ljava/lang/StringBuilder;

    const-string/jumbo v11, "Exception happened when try to decrypt the user data, the key is:"

    invoke-direct {v9, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    const-string/jumbo v11, "ExceptionHappendWhenDecryptUserData"

    invoke-virtual {p0, v9, v11}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    move v9, v10

    .line 520
    goto/16 :goto_0

    .line 523
    :cond_4
    invoke-interface {v7, v4}, Ljava/util/Map$Entry;->setValue(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 526
    .end local v3    # "key":Ljava/lang/String;
    .end local v4    # "userDataAfterDecryption":Ljava/lang/String;
    .end local v7    # "userDataEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v8    # "value":Ljava/lang/String;
    :cond_5
    const/4 v9, 0x1

    goto/16 :goto_0
.end method


# virtual methods
.method decryptLegacyDataAndCombineTokenMapAndUserDataMap(Ljava/util/HashMap;Ljava/util/HashMap;)Ljava/util/HashMap;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .local p1, "tokenMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p2, "userDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v1, 0x0

    .line 434
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 435
    .local v0, "combinedAccountDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->isTheMapEmpty(Ljava/util/Map;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 437
    const-string/jumbo v2, "There\'s no token map for this account Id. This should be an error."

    const-string/jumbo v3, "AccountManagerMissingTokenData"

    invoke-virtual {p0, v2, v3}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v1

    .line 467
    .end local v0    # "combinedAccountDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_0
    return-object v0

    .line 442
    .restart local v0    # "combinedAccountDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    invoke-virtual {p0, p2}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->isTheMapEmpty(Ljava/util/Map;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 444
    const-string/jumbo v2, "There\'s no userdata map for this account Id. This should be an error."

    const-string/jumbo v3, "AccountManagerMissingUserData"

    invoke-virtual {p0, v2, v3}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v1

    .line 446
    goto :goto_0

    .line 449
    :cond_1
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->decryptTheTokenMap(Ljava/util/HashMap;Ljava/util/HashMap;)Z

    move-result v2

    .line 450
    if-nez v2, :cond_2

    move-object v0, v1

    .line 452
    goto :goto_0

    .line 456
    :cond_2
    invoke-virtual {v0, p1}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 458
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->decryptTheUserDataMap(Ljava/util/HashMap;)Z

    move-result v2

    .line 459
    if-nez v2, :cond_3

    move-object v0, v1

    .line 461
    goto :goto_0

    .line 465
    :cond_3
    invoke-virtual {v0, p2}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    goto :goto_0
.end method

.method decryptUserDataIfNecessary(Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "userDataEncryptor"    # Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;
    .param p2, "dcpDataEncryptor"    # Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;
    .param p3, "key"    # Ljava/lang/String;
    .param p4, "value"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 578
    if-eqz p3, :cond_0

    if-eqz p1, :cond_0

    if-nez p2, :cond_2

    .line 580
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Key is missing or dataEncrytor is null when trying to decrypt the user data"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object p4, v0

    .line 598
    .end local p4    # "value":Ljava/lang/String;
    :cond_1
    :goto_0
    return-object p4

    .line 583
    .restart local p4    # "value":Ljava/lang/String;
    :cond_2
    if-nez p4, :cond_3

    .line 585
    sget-object v1, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "The value of the key:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " is Null"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-object p4, v0

    .line 586
    goto :goto_0

    .line 588
    :cond_3
    invoke-static {p3}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->isADcpOnlyToken(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 590
    invoke-virtual {p0, p2, p4}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->tryToDecryptData(Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p4

    goto :goto_0

    .line 593
    :cond_4
    invoke-static {p3}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->isEncryptedTokenInUserData(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 595
    invoke-virtual {p0, p1, p4}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->tryToDecryptData(Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p4

    goto :goto_0
.end method

.method public dumpDataFromAccountManager()Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/device/storage/AccountInfoV2;",
            ">;"
        }
    .end annotation

    .prologue
    .line 63
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->getSystemAccountManagerDataList()Ljava/util/ArrayList;

    move-result-object v0

    .line 64
    .local v0, "accountManagerDataLists":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/ArrayList<Ljava/lang/String;>;>;"
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v4

    const/4 v5, 0x3

    if-eq v4, v5, :cond_1

    .line 66
    :cond_0
    const/4 v4, 0x0

    .line 73
    :goto_0
    return-object v4

    .line 68
    :cond_1
    const/4 v4, 0x0

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    .line 69
    .local v1, "accountsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v4, 0x1

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    .line 70
    .local v2, "tokenList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v4, 0x2

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/ArrayList;

    .line 71
    .local v3, "userDataList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {p0, v1, v2, v3}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->transformAccountManagerDataListToAccountInfoV2List(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v4

    goto :goto_0
.end method

.method fromUTF8([B)Ljava/lang/String;
    .locals 3
    .param p1, "bytes"    # [B

    .prologue
    .line 409
    if-nez p1, :cond_0

    .line 411
    const/4 v0, 0x0

    .line 424
    :goto_0
    return-object v0

    .line 414
    :cond_0
    :try_start_0
    new-instance v0, Ljava/lang/String;

    const-string/jumbo v1, "UTF-8"

    invoke-direct {v0, p1, v1}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .local v0, "decodedString":Ljava/lang/String;
    goto :goto_0

    .line 421
    .end local v0    # "decodedString":Ljava/lang/String;
    :catch_0
    move-exception v1

    sget-object v1, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot encode the given bytes as aUTF-8 string on this platform."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 422
    new-instance v1, Ljava/lang/RuntimeException;

    const-string/jumbo v2, "The encoding type UTF-8 is not supported, which should never happen."

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method getSystemAccountManagerDataList()Ljava/util/ArrayList;
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 194
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->mContext:Landroid/content/Context;

    const-string/jumbo v13, "amazonaccountmanager"

    invoke-virtual {v12, v13}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 195
    .local v1, "accountManager":Ljava/lang/Object;
    if-nez v1, :cond_0

    .line 197
    const-string/jumbo v12, "Can not get system service: AmazonAccountManager."

    const-string/jumbo v13, "canNotGetSystemServiceAmazonAccountManager"

    move-object/from16 v0, p0

    invoke-virtual {v0, v12, v13}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    .line 199
    const/4 v2, 0x0

    .line 273
    :goto_0
    return-object v2

    .line 201
    :cond_0
    const/4 v5, 0x0

    .line 202
    .local v5, "getAmazonAccount":Ljava/lang/reflect/Method;
    const/4 v6, 0x0

    .line 203
    .local v6, "getAmazonAccountAuthTokens":Ljava/lang/reflect/Method;
    :try_start_0
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v12

    const-string/jumbo v13, "getAmazonAccounts"

    const/4 v14, 0x1

    new-array v14, v14, [Ljava/lang/Class;

    const/4 v15, 0x0

    sget-object v16, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v16, v14, v15

    invoke-virtual {v12, v13, v14}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v5

    .line 207
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v12

    const-string/jumbo v13, "getAmazonAccountAuthTokens"

    const/4 v14, 0x1

    new-array v14, v14, [Ljava/lang/Class;

    const/4 v15, 0x0

    sget-object v16, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v16, v14, v15

    invoke-virtual {v12, v13, v14}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v6

    .line 208
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v12

    const-string/jumbo v13, "getAmazonAccountExtras"

    const/4 v14, 0x1

    new-array v14, v14, [Ljava/lang/Class;

    const/4 v15, 0x0

    sget-object v16, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v16, v14, v15

    invoke-virtual {v12, v13, v14}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v7

    .line 217
    .local v7, "getAmazonAccountExtras":Ljava/lang/reflect/Method;
    if-eqz v5, :cond_1

    if-eqz v6, :cond_1

    if-nez v7, :cond_2

    .line 219
    :cond_1
    const-string/jumbo v12, "Error happened when reflecting the AmazonAccountManager method"

    const-string/jumbo v13, "canNotGetAmazonAccountManagerMethod"

    move-object/from16 v0, p0

    invoke-virtual {v0, v12, v13}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    .line 221
    const/4 v2, 0x0

    goto :goto_0

    .line 212
    .end local v7    # "getAmazonAccountExtras":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v12

    const-string/jumbo v12, "Can not get system service method! This is an error!"

    const-string/jumbo v13, "canNotGetAmazonAccountManagerMethod"

    move-object/from16 v0, p0

    invoke-virtual {v0, v12, v13}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    .line 214
    const/4 v2, 0x0

    goto :goto_0

    .line 223
    .restart local v7    # "getAmazonAccountExtras":Ljava/lang/reflect/Method;
    :cond_2
    const/4 v3, 0x0

    .line 224
    .local v3, "accountsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v8, 0x0

    .line 225
    .local v8, "tokenList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v10, 0x0

    .line 228
    .local v10, "userDataList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :try_start_1
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    const/4 v15, 0x0

    invoke-static {v15}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v13, v14

    invoke-virtual {v12, v5, v1, v13}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invoke(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 230
    .local v4, "accountsObject":Ljava/lang/Object;
    instance-of v12, v4, Ljava/util/ArrayList;

    if-eqz v12, :cond_3

    .line 232
    move-object v0, v4

    check-cast v0, Ljava/util/ArrayList;

    move-object v3, v0

    .line 235
    :cond_3
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    const/4 v15, 0x0

    invoke-static {v15}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v13, v14

    invoke-virtual {v12, v6, v1, v13}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invoke(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    .line 237
    .local v9, "tokenObject":Ljava/lang/Object;
    instance-of v12, v9, Ljava/util/ArrayList;

    if-eqz v12, :cond_4

    .line 239
    move-object v0, v9

    check-cast v0, Ljava/util/ArrayList;

    move-object v8, v0

    .line 242
    :cond_4
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    const/4 v15, 0x0

    invoke-static {v15}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v13, v14

    invoke-virtual {v12, v7, v1, v13}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invoke(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    .line 244
    .local v11, "userDataObject":Ljava/lang/Object;
    instance-of v12, v11, Ljava/util/ArrayList;

    if-eqz v12, :cond_5

    .line 246
    move-object v0, v11

    check-cast v0, Ljava/util/ArrayList;

    move-object v10, v0
    :try_end_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_1 .. :try_end_1} :catch_2

    .line 263
    :cond_5
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->isTheListEmpty(Ljava/util/List;)Z

    move-result v12

    if-nez v12, :cond_6

    move-object/from16 v0, p0

    invoke-virtual {v0, v8}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->isTheListEmpty(Ljava/util/List;)Z

    move-result v12

    if-nez v12, :cond_6

    move-object/from16 v0, p0

    invoke-virtual {v0, v10}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->isTheListEmpty(Ljava/util/List;)Z

    move-result v12

    if-eqz v12, :cond_7

    .line 265
    :cond_6
    const/4 v2, 0x0

    goto/16 :goto_0

    .line 251
    .end local v4    # "accountsObject":Ljava/lang/Object;
    .end local v9    # "tokenObject":Ljava/lang/Object;
    .end local v11    # "userDataObject":Ljava/lang/Object;
    :catch_1
    move-exception v12

    const-string/jumbo v12, "Failed to invoke function in AmazonAccountManager"

    const-string/jumbo v13, "unableToInvokeFunctionInAmazonAccountManager"

    move-object/from16 v0, p0

    invoke-virtual {v0, v12, v13}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    .line 253
    const/4 v2, 0x0

    goto/16 :goto_0

    .line 258
    :catch_2
    move-exception v12

    const-string/jumbo v12, "Failed to invoke function in AmazonAccountManager"

    const-string/jumbo v13, "unableToInvokeFunctionInAmazonAccountManager"

    move-object/from16 v0, p0

    invoke-virtual {v0, v12, v13}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    .line 260
    const/4 v2, 0x0

    goto/16 :goto_0

    .line 268
    .restart local v4    # "accountsObject":Ljava/lang/Object;
    .restart local v9    # "tokenObject":Ljava/lang/Object;
    .restart local v11    # "userDataObject":Ljava/lang/Object;
    :cond_7
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 269
    .local v2, "accountManagerDataList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/ArrayList<Ljava/lang/String;>;>;"
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 270
    invoke-virtual {v2, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 271
    invoke-virtual {v2, v10}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0
.end method

.method isTheListEmpty(Ljava/util/List;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 388
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_1

    .line 390
    :cond_0
    const/4 v0, 0x1

    .line 392
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method isTheListFormatCorrect(Ljava/util/List;I)Z
    .locals 2
    .param p2, "expectedColumnNum"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;I)Z"
        }
    .end annotation

    .prologue
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v0, 0x0

    .line 375
    if-nez p1, :cond_1

    .line 383
    :cond_0
    :goto_0
    return v0

    .line 379
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    rem-int/2addr v1, p2

    if-nez v1, :cond_0

    .line 381
    const/4 v0, 0x1

    goto :goto_0
.end method

.method isTheMapEmpty(Ljava/util/Map;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 397
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 399
    :cond_0
    const/4 v0, 0x1

    .line 401
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "metricName"    # Ljava/lang/String;

    .prologue
    .line 603
    sget-object v0, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->TAG:Ljava/lang/String;

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 604
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    invoke-static {p2, v0}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 605
    return-void
.end method

.method public removeDataFromAccountManagerAfterMigration(Ljava/lang/String;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 81
    if-nez p1, :cond_0

    .line 83
    const-string/jumbo v0, "Cannot delete the account given directed is null!"

    const-string/jumbo v1, "TryToDeleteNullDirectedAccount"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    :goto_0
    return-void

    .line 87
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->removeAccount(Ljava/lang/String;)V

    goto :goto_0
.end method

.method transformAccountManagerDBListToMap(Ljava/util/ArrayList;I)Ljava/util/HashMap;
    .locals 10
    .param p2, "columnNum"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;I)",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .local p1, "dbDataList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v6, 0x0

    .line 331
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 332
    .local v1, "dbDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-ge v2, v7, :cond_0

    .line 336
    add-int/lit8 v7, v2, 0x1

    invoke-virtual {p1, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 337
    .local v0, "accountId":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 339
    const-string/jumbo v7, "Missing accountId in the list. This should be an error!"

    const-string/jumbo v8, "AccountManagerMissingAccountId"

    invoke-virtual {p0, v7, v8}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, v6

    .line 370
    .end local v0    # "accountId":Ljava/lang/String;
    .end local v1    # "dbDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    :cond_0
    :goto_1
    return-object v1

    .line 346
    .restart local v0    # "accountId":Ljava/lang/String;
    .restart local v1    # "dbDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    :cond_1
    invoke-virtual {v1, v0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_2

    .line 348
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 349
    .local v4, "singleAccountDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {v1, v0, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 357
    :goto_2
    add-int/lit8 v7, v2, 0x2

    invoke-virtual {p1, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 358
    .local v3, "key":Ljava/lang/String;
    add-int/lit8 v7, v2, 0x3

    invoke-virtual {p1, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 359
    .local v5, "value":Ljava/lang/String;
    sget-object v7, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Migrate the key: %s for account_id: %s"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object v3, v8, v9

    const/4 v9, 0x1

    aput-object v0, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 361
    if-nez v3, :cond_3

    .line 363
    const-string/jumbo v7, "There is one field missing the key!"

    const-string/jumbo v8, "keyIsNullWhenParsingDataFromAccountManager"

    invoke-virtual {p0, v7, v8}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, v6

    .line 365
    goto :goto_1

    .line 353
    .end local v3    # "key":Ljava/lang/String;
    .end local v4    # "singleAccountDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v5    # "value":Ljava/lang/String;
    :cond_2
    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/HashMap;

    .restart local v4    # "singleAccountDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    goto :goto_2

    .line 367
    .restart local v3    # "key":Ljava/lang/String;
    .restart local v5    # "value":Ljava/lang/String;
    :cond_3
    invoke-virtual {v4, v3, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 332
    add-int/2addr v2, p2

    goto :goto_0
.end method

.method transformAccountManagerDataListToAccountInfoV2List(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/identity/auth/device/storage/AccountInfoV2;",
            ">;"
        }
    .end annotation

    .prologue
    .line 99
    .local p1, "accountsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .local p2, "tokenList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .local p3, "userDataList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual/range {p0 .. p1}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->isTheListEmpty(Ljava/util/List;)Z

    move-result v15

    if-nez v15, :cond_0

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->isTheListEmpty(Ljava/util/List;)Z

    move-result v15

    if-nez v15, :cond_0

    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->isTheListEmpty(Ljava/util/List;)Z

    move-result v15

    if-eqz v15, :cond_2

    .line 101
    :cond_0
    sget-object v15, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v16, "There\'s empty list returned by systen api. High possibility that there\'s no account in previous AccountManager"

    invoke-static/range {v15 .. v16}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    const/4 v4, 0x0

    .line 187
    :cond_1
    :goto_0
    return-object v4

    .line 107
    :cond_2
    const/4 v15, 0x4

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v15}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->isTheListFormatCorrect(Ljava/util/List;I)Z

    move-result v15

    if-eqz v15, :cond_3

    const/4 v15, 0x4

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v15}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->isTheListFormatCorrect(Ljava/util/List;I)Z

    move-result v15

    if-eqz v15, :cond_3

    const/4 v15, 0x4

    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-virtual {v0, v1, v15}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->isTheListFormatCorrect(Ljava/util/List;I)Z

    move-result v15

    if-nez v15, :cond_4

    .line 111
    :cond_3
    const-string/jumbo v15, "The data list returned by platform is malformed!"

    const-string/jumbo v16, "AccountManagerDataMalformed"

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v15, v1}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    const/4 v4, 0x0

    goto :goto_0

    .line 117
    :cond_4
    const/4 v15, 0x4

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v15}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->transformAccountManagerDBListToMap(Ljava/util/ArrayList;I)Ljava/util/HashMap;

    move-result-object v13

    .line 121
    .local v13, "tokensMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    const/4 v15, 0x4

    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-virtual {v0, v1, v15}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->transformAccountManagerDBListToMap(Ljava/util/ArrayList;I)Ljava/util/HashMap;

    move-result-object v14

    .line 125
    .local v14, "userDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-virtual/range {p0 .. p1}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->transformAccountsListToMap(Ljava/util/ArrayList;)Ljava/util/HashMap;

    move-result-object v7

    .line 127
    .local v7, "accountsMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v13, :cond_5

    if-eqz v14, :cond_5

    invoke-virtual {v13}, Ljava/util/HashMap;->isEmpty()Z

    move-result v15

    if-nez v15, :cond_5

    invoke-virtual {v14}, Ljava/util/HashMap;->isEmpty()Z

    move-result v15

    if-nez v15, :cond_5

    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->isTheMapEmpty(Ljava/util/Map;)Z

    move-result v15

    if-eqz v15, :cond_6

    .line 130
    :cond_5
    const-string/jumbo v15, "Error Happend when transform the data list, mainly because missing some fields."

    const-string/jumbo v16, "AccountManagerMissingField"

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v15, v1}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    const/4 v4, 0x0

    goto :goto_0

    .line 137
    :cond_6
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 138
    .local v4, "accountInfoList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/identity/auth/device/storage/AccountInfoV2;>;"
    invoke-virtual {v7}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v15

    invoke-interface {v15}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v12

    .local v12, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_1

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/util/Map$Entry;

    .line 140
    .local v11, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v11}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 141
    .local v2, "accountId":Ljava/lang/String;
    invoke-interface {v11}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    .line 143
    .local v10, "displayName":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v15

    if-eqz v15, :cond_7

    .line 145
    const-string/jumbo v15, "The accountId cannot be null!"

    const-string/jumbo v16, "AccountManagerAccountIdIsNull"

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v15, v1}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    const/4 v4, 0x0

    goto/16 :goto_0

    .line 149
    :cond_7
    if-nez v10, :cond_8

    .line 151
    const-string/jumbo v15, "The displayName cannot be null!"

    const-string/jumbo v16, "AccountManagerDisplayNameIsNull"

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v15, v1}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    const/4 v4, 0x0

    goto/16 :goto_0

    .line 155
    :cond_8
    invoke-virtual {v13, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/HashMap;

    .line 157
    .local v5, "accountTokenMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {v14, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/HashMap;

    .line 160
    .local v6, "accountUserDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    move-object/from16 v0, p0

    invoke-direct {v0, v5, v6}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->checkDuplicatedKeyInTwoMaps(Ljava/util/HashMap;Ljava/util/HashMap;)Z

    move-result v15

    if-eqz v15, :cond_9

    .line 162
    const/4 v4, 0x0

    goto/16 :goto_0

    .line 166
    :cond_9
    move-object/from16 v0, p0

    invoke-virtual {v0, v5, v6}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->decryptLegacyDataAndCombineTokenMapAndUserDataMap(Ljava/util/HashMap;Ljava/util/HashMap;)Ljava/util/HashMap;

    move-result-object v8

    .line 169
    .local v8, "combinedAccountDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    move-object/from16 v0, p0

    invoke-virtual {v0, v8}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->isTheMapEmpty(Ljava/util/Map;)Z

    move-result v15

    if-eqz v15, :cond_a

    .line 171
    const-string/jumbo v15, "Error happens when combined the token map and user data map"

    const-string/jumbo v16, "CombineAccountDataMapError"

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v15, v1}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    .line 173
    const/4 v4, 0x0

    goto/16 :goto_0

    .line 176
    :cond_a
    const-string/jumbo v15, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {v8, v15}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 177
    .local v9, "directedId":Ljava/lang/String;
    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v15

    if-eqz v15, :cond_b

    .line 179
    const-string/jumbo v15, "The directedId cannot be null!"

    const-string/jumbo v16, "AccountManagerDirectedIdIsNull"

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v15, v1}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    .line 180
    const/4 v4, 0x0

    goto/16 :goto_0

    .line 184
    :cond_b
    new-instance v3, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;

    invoke-direct {v3, v9, v10, v8}, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 185
    .local v3, "accountInfo":Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1
.end method

.method transformAccountsListToMap(Ljava/util/ArrayList;)Ljava/util/HashMap;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .local p1, "accountsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v4, 0x0

    .line 287
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 288
    .local v1, "accountsMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-ge v3, v5, :cond_0

    .line 291
    add-int/lit8 v5, v3, 0x0

    invoke-virtual {p1, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 292
    .local v0, "accountId":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 294
    const-string/jumbo v5, "Missing accountId when parsing the accounts list, this should be an error."

    const-string/jumbo v6, "AccountManagerMissingIdInAccountList"

    invoke-virtual {p0, v5, v6}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, v4

    .line 310
    .end local v0    # "accountId":Ljava/lang/String;
    .end local v1    # "accountsMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    :goto_1
    return-object v1

    .line 300
    .restart local v0    # "accountId":Ljava/lang/String;
    .restart local v1    # "accountsMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    add-int/lit8 v5, v3, 0x1

    invoke-virtual {p1, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 302
    .local v2, "displayName":Ljava/lang/String;
    if-nez v2, :cond_2

    .line 304
    const-string/jumbo v5, "Missing display name when parsing the accounts list, this should be an error."

    const-string/jumbo v6, "AccountManagerMissingIdInAccountList"

    invoke-virtual {p0, v5, v6}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->logAndRecordMigrationError(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, v4

    .line 306
    goto :goto_1

    .line 308
    :cond_2
    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 288
    add-int/lit8 v3, v3, 0x4

    goto :goto_0
.end method

.method tryToDecryptData(Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "encryptor"    # Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;
    .param p2, "encryptedValue"    # Ljava/lang/String;

    .prologue
    .line 609
    if-eqz p2, :cond_0

    if-nez p1, :cond_2

    .line 611
    :cond_0
    const/4 v0, 0x0

    .line 619
    :cond_1
    :goto_0
    return-object v0

    .line 614
    :cond_2
    invoke-virtual {p1, p2}, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;->decryptToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 615
    .local v0, "decryptedToken":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 617
    sget-object v1, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not decrypt the token. Something may be wrong with the encryption key"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
