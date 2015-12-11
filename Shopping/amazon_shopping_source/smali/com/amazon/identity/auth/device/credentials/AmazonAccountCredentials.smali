.class public Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;
.super Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
.source "AmazonAccountCredentials.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mAdpToken:Ljava/lang/String;

.field private final mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private final mContext:Landroid/content/Context;

.field private mDirectedId:Ljava/lang/String;

.field private mEncryptedAdpToken:Ljava/lang/String;

.field private mEncryptedPrivateKey:Ljava/lang/String;

.field private mPrivateKey:Ljava/lang/String;

.field private final mStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

.field private mValidatorString:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->TAG:Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 34
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/credentials/AccountCredentials;-><init>()V

    .line 35
    iput-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mContext:Landroid/content/Context;

    .line 36
    iput-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 37
    iput-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    .line 38
    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 42
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 43
    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;

    .prologue
    .line 46
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/credentials/AccountCredentials;-><init>()V

    .line 47
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mContext:Landroid/content/Context;

    .line 49
    iget-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "dcp_amazon_account_man"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 50
    new-instance v0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    .line 52
    iput-object p2, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mDirectedId:Ljava/lang/String;

    .line 54
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->getValidatorString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mValidatorString:Ljava/lang/String;

    .line 55
    const-string/jumbo v0, "com.amazon.dcp.sso.token.device.adptoken"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->getCurrentUserData(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mEncryptedAdpToken:Ljava/lang/String;

    .line 56
    const-string/jumbo v0, "com.amazon.dcp.sso.token.device.privatekey"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->getCurrentUserData(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mEncryptedPrivateKey:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public static createFromContext(Landroid/content/Context;)Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 65
    new-instance v0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;-><init>(Landroid/content/Context;)V

    .line 66
    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->hasDevicePrimaryAmazonAccount()Z

    move-result v0

    if-nez v0, :cond_0

    .line 68
    const/4 v0, 0x0

    .line 71
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;-><init>(Landroid/content/Context;)V

    goto :goto_0
.end method

.method public static createFromContextForAccount(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 76
    new-instance v0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;-><init>(Landroid/content/Context;)V

    .line 77
    .local v0, "amazonAccountManager":Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
    if-eqz p1, :cond_0

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 79
    :cond_0
    sget-object v1, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Error, the account given does not exist. Cannot construct account credentials"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    const/4 v1, 0x0

    .line 83
    :goto_0
    return-object v1

    :cond_1
    new-instance v1, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;

    invoke-direct {v1, p0, p1}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private getAccountDirectedId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mDirectedId:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 185
    iget-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getDevicePrimaryAmazonAccount()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mDirectedId:Ljava/lang/String;

    .line 187
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mDirectedId:Ljava/lang/String;

    return-object v0
.end method

.method private getCurrentUserData(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 171
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->getAccountDirectedId()Ljava/lang/String;

    move-result-object v0

    .line 172
    .local v0, "accountDirectedId":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 174
    sget-object v1, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Failed to locate an amazon account to retrieve amazon credentials from."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 175
    const/4 v1, 0x0

    .line 178
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    invoke-virtual {v1, v0, p1}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->getUndecryptedUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method private tryToDecryptKey(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 137
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->getAccountDirectedId()Ljava/lang/String;

    move-result-object v0

    .line 138
    .local v0, "accountDirectedId":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 140
    sget-object v1, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Failed to locate an amazon account to retrieve amazon credentials from."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 141
    const/4 v1, 0x0

    .line 144
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    invoke-virtual {v1, v0, p1}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method


# virtual methods
.method public getPrivateKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mPrivateKey:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 129
    const-string/jumbo v0, "com.amazon.dcp.sso.token.device.privatekey"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->tryToDecryptKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mPrivateKey:Ljava/lang/String;

    .line 132
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mPrivateKey:Ljava/lang/String;

    return-object v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mAdpToken:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 118
    const-string/jumbo v0, "com.amazon.dcp.sso.token.device.adptoken"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->tryToDecryptKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mAdpToken:Ljava/lang/String;

    .line 121
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mAdpToken:Ljava/lang/String;

    return-object v0
.end method

.method protected getValidatorString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 149
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->getAccountDirectedId()Ljava/lang/String;

    move-result-object v0

    .line 150
    .local v0, "accountDirectedId":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 152
    sget-object v1, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->TAG:Ljava/lang/String;

    .line 153
    const/4 v1, 0x0

    .line 156
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    const-string/jumbo v2, "com.amazon.dcp.sso.property.account.UUID"

    invoke-virtual {v1, v0, v2}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public isStale(Landroid/content/Context;)Z
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    .line 89
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->getValidatorString()Ljava/lang/String;

    move-result-object v0

    .line 90
    .local v0, "token":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 110
    :cond_0
    :goto_0
    return v1

    .line 95
    :cond_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mValidatorString:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 100
    iget-object v2, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mEncryptedAdpToken:Ljava/lang/String;

    const-string/jumbo v3, "com.amazon.dcp.sso.token.device.adptoken"

    invoke-direct {p0, v3}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->getCurrentUserData(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 105
    iget-object v2, p0, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->mEncryptedPrivateKey:Ljava/lang/String;

    const-string/jumbo v3, "com.amazon.dcp.sso.token.device.privatekey"

    invoke-direct {p0, v3}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->getCurrentUserData(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 110
    const/4 v1, 0x0

    goto :goto_0
.end method
