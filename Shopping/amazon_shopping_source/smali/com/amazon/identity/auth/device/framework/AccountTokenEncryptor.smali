.class public Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;
.super Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;
.source "AccountTokenEncryptor.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private final mContext:Landroid/content/Context;

.field private final mDirectedId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/accounts/Account;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Landroid/accounts/Account;

    .prologue
    .line 32
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedId(Landroid/content/Context;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 33
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;-><init>()V

    .line 40
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;->mContext:Landroid/content/Context;

    .line 42
    const-string/jumbo v0, "dcp_amazon_account_man"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 45
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;->mDirectedId:Ljava/lang/String;

    .line 46
    return-void
.end method


# virtual methods
.method protected getEncryptionKey()[B
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 51
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    if-nez v2, :cond_0

    .line 64
    :goto_0
    return-object v1

    .line 56
    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;->mDirectedId:Ljava/lang/String;

    const-string/jumbo v4, "com.amazon.dcp.sso.property.encryptKey"

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 57
    .local v0, "encryptionKey":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 59
    sget-object v2, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "The current account does not have an encryption key. This is probably because it is not registered."

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 64
    :cond_1
    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v1

    goto :goto_0
.end method
