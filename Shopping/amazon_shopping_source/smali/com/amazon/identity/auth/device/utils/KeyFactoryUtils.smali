.class public final Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;
.super Ljava/lang/Object;
.source "KeyFactoryUtils.java"


# static fields
.field public static final EC_PRIVATE_KEY_FOOTER:Ljava/lang/String; = "-----END EC PRIVATE KEY-----"

.field public static final EC_PRIVATE_KEY_HEADER:Ljava/lang/String; = "-----BEGIN EC PRIVATE KEY-----"

.field private static final KEY_HEADERS_FOOTERS:[Ljava/lang/String;

.field public static final PRIVATE_KEY_FOOTER:Ljava/lang/String; = "-----END PRIVATE KEY-----"

.field public static final PRIVATE_KEY_HEADER:Ljava/lang/String; = "-----BEGIN PRIVATE KEY-----"

.field public static final RSA_PRIVATE_KEY_FOOTER:Ljava/lang/String; = "-----END RSA PRIVATE KEY-----"

.field public static final RSA_PRIVATE_KEY_HEADER:Ljava/lang/String; = "-----BEGIN RSA PRIVATE KEY-----"

.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 35
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, "-----BEGIN RSA PRIVATE KEY-----"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string/jumbo v2, "-----END RSA PRIVATE KEY-----"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string/jumbo v2, "-----BEGIN EC PRIVATE KEY-----"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string/jumbo v2, "-----END EC PRIVATE KEY-----"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string/jumbo v2, "-----BEGIN PRIVATE KEY-----"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string/jumbo v2, "-----END PRIVATE KEY-----"

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->KEY_HEADERS_FOOTERS:[Ljava/lang/String;

    .line 44
    const-class v0, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    return-void
.end method

.method public static getKeyFactoryForAlgorithm(Ljava/lang/String;)Ljava/security/KeyFactory;
    .locals 6
    .param p0, "algorithm"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 57
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 59
    sget-object v2, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "The algorithm cannot be null"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "The algorithm cannot be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 67
    :cond_0
    :try_start_0
    const-string/jumbo v2, "BC"

    invoke-static {p0, v2}, Ljava/security/KeyFactory;->getInstance(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyFactory;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/security/NoSuchProviderException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v2

    .line 96
    :goto_0
    return-object v2

    .line 69
    :catch_0
    move-exception v0

    .line 71
    .local v0, "e":Ljava/security/NoSuchAlgorithmException;
    sget-object v2, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "getKeyFactory: Could not get private key because there was no "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " algorithm"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 74
    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "MAPKeyFactoryGenerationError:BouncyCastleMissing:Algorithm:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":SystemVersion:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-array v3, v5, [Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 96
    .end local v0    # "e":Ljava/security/NoSuchAlgorithmException;
    :goto_1
    const/4 v2, 0x0

    goto :goto_0

    .line 77
    :catch_1
    move-exception v0

    .line 79
    .local v0, "e":Ljava/security/NoSuchProviderException;
    sget-object v2, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "The device doesn\'t contain BouncyCastle Provider, try using the default."

    invoke-static {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 80
    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "MAPKeyFactoryGenerationError:MissingBouncyCastle:Algorithm:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":SystemVersion:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-array v3, v5, [Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 85
    :try_start_1
    invoke-static {p0}, Ljava/security/KeyFactory;->getInstance(Ljava/lang/String;)Ljava/security/KeyFactory;
    :try_end_1
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v2

    goto :goto_0

    .line 87
    :catch_2
    move-exception v1

    .line 89
    .local v1, "e1":Ljava/security/NoSuchAlgorithmException;
    sget-object v2, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "getKeyFactory: Could not get private key because there was no RSA algorithm"

    invoke-static {v2, v3, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 90
    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "MAPKeyFactoryGenerationError:DefaultProviderNotSupportAlgorithm:Algorithm:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":SystemVersion:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-array v3, v5, [Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_1
.end method

.method public static getKeyFactoryForKey(Ljava/lang/String;)Ljava/security/KeyFactory;
    .locals 2
    .param p0, "key"    # Ljava/lang/String;

    .prologue
    .line 107
    const-string/jumbo v0, "RSA"

    .line 110
    .local v0, "algorithm":Ljava/lang/String;
    if-eqz p0, :cond_0

    const-string/jumbo v1, "-----BEGIN EC PRIVATE KEY-----"

    invoke-virtual {p0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 112
    const-string/jumbo v0, "EC"

    .line 115
    :cond_0
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->getKeyFactoryForAlgorithm(Ljava/lang/String;)Ljava/security/KeyFactory;

    move-result-object v1

    return-object v1
.end method

.method static isDMSCredentialGetCorrupted(Ljava/lang/String;)Z
    .locals 1
    .param p0, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 189
    const-string/jumbo v0, "SSO Currently does not have credentials"

    invoke-static {p0, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 191
    const/4 v0, 0x1

    .line 193
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static recordDMSCredentialErrorAndCallDeregisterIfNecessary(Landroid/content/Context;Ljava/lang/String;)V
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 148
    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->isDMSCredentialGetCorrupted(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-static {p0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isAmazonDevice(Landroid/content/Context;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 151
    sget-object v4, Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;->CentralDeviceType:Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;

    invoke-static {p0, v4}, Lcom/amazon/identity/auth/device/utils/Platform;->getDeviceAttribute(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Ljava/lang/String;

    move-result-object v1

    .line 152
    .local v1, "deviceType":Ljava/lang/String;
    sget-object v4, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Central DMS token or DMS private key get corrupted, MAP is going to deregister device to clean the state"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "DMSCredentialCorrupted:DeviceType:"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, ":SYSTEM_VERSION:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/String;

    invoke-static {v4, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 157
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    .line 160
    .local v0, "accountManager":Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    const/4 v4, 0x0

    :try_start_0
    invoke-virtual {v0, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->deregisterDevice(Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/identity/auth/device/api/MAPFuture;->get()Ljava/lang/Object;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_2

    .line 182
    :goto_0
    sget-object v4, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Successfully deregister the device when DMS private-key/DMS token got corrupted or missing."

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    .end local v0    # "accountManager":Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    .end local v1    # "deviceType":Ljava/lang/String;
    :cond_0
    return-void

    .line 162
    .restart local v0    # "accountManager":Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    .restart local v1    # "deviceType":Ljava/lang/String;
    :catch_0
    move-exception v4

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getErrorBundle()Landroid/os/Bundle;

    move-result-object v3

    .line 165
    .local v3, "errorBundle":Landroid/os/Bundle;
    sget-object v4, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Error deregister the device when DMS private-key/DMS token got corrupted or missing. Error code:"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string/jumbo v6, "com.amazon.dcp.sso.ErrorCode"

    invoke-virtual {v3, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " Error message is:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "com.amazon.dcp.sso.ErrorMessage"

    invoke-virtual {v3, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 170
    .end local v3    # "errorBundle":Landroid/os/Bundle;
    :catch_1
    move-exception v2

    .line 172
    .local v2, "e":Ljava/lang/InterruptedException;
    sget-object v4, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "InterruptedException! Error deregister the device when DMS private-key/DMS token got corrupted or missing. "

    invoke-static {v4, v5, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 176
    .end local v2    # "e":Ljava/lang/InterruptedException;
    :catch_2
    move-exception v2

    .line 178
    .local v2, "e":Ljava/util/concurrent/ExecutionException;
    sget-object v4, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "ExecutionException! Error deregister the device when DMS private-key/DMS token got corrupted or missing."

    invoke-static {v4, v5, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static replacePrivateKeyHeaderAndFooter(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "privateKey"    # Ljava/lang/String;

    .prologue
    .line 123
    if-nez p0, :cond_0

    .line 125
    const/4 v5, 0x0

    .line 134
    :goto_0
    return-object v5

    .line 128
    :cond_0
    move-object v3, p0

    .line 129
    .local v3, "key":Ljava/lang/String;
    sget-object v0, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->KEY_HEADERS_FOOTERS:[Ljava/lang/String;

    .local v0, "arr$":[Ljava/lang/String;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_1
    if-ge v2, v4, :cond_1

    aget-object v1, v0, v2

    .line 131
    .local v1, "headerOrFooter":Ljava/lang/String;
    const-string/jumbo v5, ""

    invoke-virtual {v3, v1, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v3

    .line 129
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 133
    .end local v1    # "headerOrFooter":Ljava/lang/String;
    :cond_1
    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    goto :goto_0
.end method
