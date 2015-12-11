.class Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper$AccountManagerLegacyDataEncryptor;
.super Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;
.source "AccountManagerDataMigrationHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AccountManagerLegacyDataEncryptor"
.end annotation


# instance fields
.field private final mEncryptionKeyBytes:[B


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "encryptionKey"    # Ljava/lang/String;

    .prologue
    .line 655
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;-><init>()V

    .line 656
    if-nez p1, :cond_0

    .line 658
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "EncryptionKeyCannotBeNull"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 660
    :cond_0
    const/4 v0, 0x0

    invoke-static {p1, v0}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper$AccountManagerLegacyDataEncryptor;->mEncryptionKeyBytes:[B

    .line 661
    return-void
.end method


# virtual methods
.method protected getEncryptionKey()[B
    .locals 1

    .prologue
    .line 666
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper$AccountManagerLegacyDataEncryptor;->mEncryptionKeyBytes:[B

    return-object v0
.end method
