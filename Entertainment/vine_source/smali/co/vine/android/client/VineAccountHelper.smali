.class public Lco/vine/android/client/VineAccountHelper;
.super Ljava/lang/Object;
.source "VineAccountHelper.java"


# static fields
.field public static final ACCOUNT_TYPE:Ljava/lang/String;

.field public static final KEY_ADD_WIDGET:Ljava/lang/String; = "account_add_widget"

.field public static final KEY_DID_SHOW_STORE_CONTACTS_PROMPT:Ljava/lang/String; = "account_did_show_store_contacts"

.field public static final KEY_DID_SHOW_VM_ONBOARD:Ljava/lang/String; = "account_did_show_vm_onboard"

.field public static final KEY_LOGIN_TYPE:Ljava/lang/String; = "account_login_type"

.field public static final KEY_NORMAL_VIDEO_PLAYABLE:Ljava/lang/String; = "account_normal_video_playable"

.field public static final KEY_PASSWORD_ENCRYPTED:Ljava/lang/String; = "account_password_encrypted"

.field public static final KEY_SETTINGS:Ljava/lang/String; = "account_settings"

.field public static final KEY_TWITTER_SECRET:Ljava/lang/String; = "account_t_secret"

.field public static final KEY_TWITTER_TOKEN:Ljava/lang/String; = "account_t_token"

.field public static final KEY_TWITTER_USERNAME:Ljava/lang/String; = "account_t_username"

.field public static final KEY_TWITTER_USER_ID:Ljava/lang/String; = "account_t_id"

.field public static final KEY_USER_AVATAR:Ljava/lang/String; = "account_user_avatar"

.field public static final KEY_USER_DATA:Ljava/lang/String; = "account_user_data"

.field public static final KEY_USER_ID:Ljava/lang/String; = "account_user_info"

.field public static final KEY_USER_NAME:Ljava/lang/String; = "account_user_name"

.field public static final LOGIN_TYPE_EMAIL:I = 0x1

.field public static final LOGIN_TYPE_TWITTER:I = 0x2

.field public static final SESSION_TOKEN_KEY:Ljava/lang/String; = "co.vine.android.basic_auth.token.secret"

.field private static mActiveSession:Lco/vine/android/client/Session;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 73
    const-string v0, ".auth"

    invoke-static {v0}, Lco/vine/android/util/BuildUtil;->getAuthority(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lco/vine/android/client/VineAccountHelper;->ACCOUNT_TYPE:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createAccount(Landroid/content/Context;Ljava/lang/String;Lco/vine/android/api/VineLogin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/accounts/Account;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "uniqueLogin"    # Ljava/lang/String;
    .param p2, "vl"    # Lco/vine/android/api/VineLogin;
    .param p3, "password"    # Ljava/lang/String;
    .param p4, "avatar"    # Ljava/lang/String;
    .param p5, "accountName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineLoggingException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v3, 0x0

    .line 124
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v1

    .line 125
    .local v1, "am":Landroid/accounts/AccountManager;
    invoke-static {p0, p1}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    .line 126
    .local v0, "account":Landroid/accounts/Account;
    if-nez v0, :cond_1

    .line 127
    new-instance v0, Landroid/accounts/Account;

    .end local v0    # "account":Landroid/accounts/Account;
    sget-object v4, Lco/vine/android/client/VineAccountHelper;->ACCOUNT_TYPE:Ljava/lang/String;

    invoke-direct {v0, p1, v4}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    .restart local v0    # "account":Landroid/accounts/Account;
    if-eqz v1, :cond_0

    const/4 v4, 0x0

    const/4 v5, 0x0

    :try_start_0
    invoke-virtual {v1, v0, v4, v5}, Landroid/accounts/AccountManager;->addAccountExplicitly(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)Z
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    if-nez v4, :cond_1

    .line 164
    :cond_0
    :goto_0
    return-object v3

    .line 132
    :catch_0
    move-exception v2

    .line 133
    .local v2, "e":Ljava/lang/SecurityException;
    new-instance v3, Lco/vine/android/VineLoggingException;

    invoke-direct {v3, v2}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 136
    .end local v2    # "e":Ljava/lang/SecurityException;
    :cond_1
    iget v3, p2, Lco/vine/android/api/VineLogin;->loginType:I

    packed-switch v3, :pswitch_data_0

    .line 160
    :goto_1
    const-string v3, "account_user_name"

    invoke-virtual {v1, v0, v3, p5}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 161
    const-string v3, "account_user_avatar"

    invoke-virtual {v1, v0, v3, p4}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 162
    const-string v3, "account_user_info"

    iget-wide v4, p2, Lco/vine/android/api/VineLogin;->userId:J

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v0, v3, v4}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 163
    const-string v3, "co.vine.android.basic_auth.token.secret"

    iget-object v4, p2, Lco/vine/android/api/VineLogin;->key:Ljava/lang/String;

    invoke-virtual {v1, v0, v3, v4}, Landroid/accounts/AccountManager;->setAuthToken(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v0

    .line 164
    goto :goto_0

    .line 139
    :pswitch_0
    :try_start_1
    invoke-static {p0}, Lco/vine/android/client/VineAccountHelper;->getDeviceId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, p3}, Lco/vine/android/client/VineAccountHelper;->encrypt(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v0, v3}, Landroid/accounts/AccountManager;->setPassword(Landroid/accounts/Account;Ljava/lang/String;)V

    .line 141
    const-string v3, "account_password_encrypted"

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v0, v3, v4}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 147
    :goto_2
    const-string v3, "account_login_type"

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v0, v3, v4}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 142
    :catch_1
    move-exception v2

    .line 143
    .local v2, "e":Ljava/lang/Exception;
    const-string v3, "Error encrypting password."

    invoke-static {v3, v2}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 145
    invoke-virtual {v1, v0, p3}, Landroid/accounts/AccountManager;->setPassword(Landroid/accounts/Account;Ljava/lang/String;)V

    goto :goto_2

    .line 151
    .end local v2    # "e":Ljava/lang/Exception;
    :pswitch_1
    const-string v3, "account_t_token"

    iget-object v4, p2, Lco/vine/android/api/VineLogin;->twitterToken:Ljava/lang/String;

    invoke-virtual {v1, v0, v3, v4}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    const-string v3, "account_t_secret"

    iget-object v4, p2, Lco/vine/android/api/VineLogin;->twitterSecret:Ljava/lang/String;

    invoke-virtual {v1, v0, v3, v4}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 153
    const-string v3, "account_t_id"

    iget-wide v4, p2, Lco/vine/android/api/VineLogin;->twitterUserId:J

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v0, v3, v4}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 154
    const-string v3, "account_t_username"

    iget-object v4, p2, Lco/vine/android/api/VineLogin;->twitterUsername:Ljava/lang/String;

    invoke-virtual {v1, v0, v3, v4}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    const-string v3, "account_login_type"

    const/4 v4, 0x2

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v0, v3, v4}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 136
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private static createSession()Lco/vine/android/client/Session;
    .locals 7

    .prologue
    const/4 v1, 0x0

    .line 472
    new-instance v0, Lco/vine/android/client/Session;

    const-wide/16 v2, 0x0

    move-object v4, v1

    move-object v5, v1

    move-object v6, v1

    invoke-direct/range {v0 .. v6}, Lco/vine/android/client/Session;-><init>(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public static createSession(Landroid/content/Context;Landroid/accounts/Account;)Lco/vine/android/client/Session;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 418
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v7

    .line 419
    .local v7, "am":Landroid/accounts/AccountManager;
    invoke-static {v7, p1}, Lco/vine/android/client/VineAccountHelper;->getUserId(Landroid/accounts/AccountManager;Landroid/accounts/Account;)J

    move-result-wide v2

    .line 420
    .local v2, "userId":J
    invoke-static {p0}, Lco/vine/android/provider/SettingsManager;->getEdition(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v6

    .line 421
    .local v6, "edition":Ljava/lang/String;
    new-instance v0, Lco/vine/android/client/Session;

    invoke-static {v7, p1}, Lco/vine/android/client/VineAccountHelper;->getSessionKey(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v7, p1}, Lco/vine/android/client/VineAccountHelper;->getName(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v7, p1}, Lco/vine/android/client/VineAccountHelper;->getAvatarUrl(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v0 .. v6}, Lco/vine/android/client/Session;-><init>(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method private static decrypt(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "encrypted"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 533
    new-instance v2, Ljavax/crypto/spec/SecretKeySpec;

    invoke-static {p0}, Lco/vine/android/client/VineAccountHelper;->getKeyDigest(Ljava/lang/String;)[B

    move-result-object v3

    const-string v4, "AES"

    invoke-direct {v2, v3, v4}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 534
    .local v2, "secretKeySpec":Ljavax/crypto/spec/SecretKeySpec;
    const-string v3, "AES"

    invoke-static {v3}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v0

    .line 535
    .local v0, "cipher":Ljavax/crypto/Cipher;
    const/4 v3, 0x2

    invoke-virtual {v0, v3, v2}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 537
    const/4 v3, 0x0

    invoke-static {p1, v3}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v3

    invoke-virtual {v0, v3}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v1

    .line 538
    .local v1, "decrypted":[B
    new-instance v3, Ljava/lang/String;

    const-string v4, "UTF-8"

    invoke-direct {v3, v1, v4}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    return-object v3
.end method

.method private static encrypt(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "cleartext"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 524
    new-instance v2, Ljavax/crypto/spec/SecretKeySpec;

    invoke-static {p0}, Lco/vine/android/client/VineAccountHelper;->getKeyDigest(Ljava/lang/String;)[B

    move-result-object v3

    const-string v4, "AES"

    invoke-direct {v2, v3, v4}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 525
    .local v2, "secretKeySpec":Ljavax/crypto/spec/SecretKeySpec;
    const-string v3, "AES"

    invoke-static {v3}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v0

    .line 526
    .local v0, "cipher":Ljavax/crypto/Cipher;
    const/4 v3, 0x1

    invoke-virtual {v0, v3, v2}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 527
    const-string v3, "UTF-8"

    invoke-virtual {p1, v3}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v3

    invoke-virtual {v0, v3}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v1

    .line 529
    .local v1, "encrypted":[B
    const/4 v3, 0x0

    invoke-static {v1, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method public static getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "accountName"    # Ljava/lang/String;
    .annotation build Lorg/jetbrains/annotations/Nullable;
    .end annotation

    .prologue
    .line 91
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v2

    .line 92
    .local v2, "am":Landroid/accounts/AccountManager;
    if-eqz v2, :cond_1

    .line 93
    sget-object v6, Lco/vine/android/client/VineAccountHelper;->ACCOUNT_TYPE:Ljava/lang/String;

    invoke-virtual {v2, v6}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v1

    .line 94
    .local v1, "accounts":[Landroid/accounts/Account;
    if-eqz v1, :cond_1

    .line 95
    move-object v3, v1

    .local v3, "arr$":[Landroid/accounts/Account;
    array-length v5, v3

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_1

    aget-object v0, v3, v4

    .line 96
    .local v0, "account":Landroid/accounts/Account;
    iget-object v6, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v6, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 102
    .end local v0    # "account":Landroid/accounts/Account;
    .end local v1    # "accounts":[Landroid/accounts/Account;
    .end local v3    # "arr$":[Landroid/accounts/Account;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    :goto_1
    return-object v0

    .line 95
    .restart local v0    # "account":Landroid/accounts/Account;
    .restart local v1    # "accounts":[Landroid/accounts/Account;
    .restart local v3    # "arr$":[Landroid/accounts/Account;
    .restart local v4    # "i$":I
    .restart local v5    # "len$":I
    :cond_0
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 102
    .end local v0    # "account":Landroid/accounts/Account;
    .end local v1    # "accounts":[Landroid/accounts/Account;
    .end local v3    # "arr$":[Landroid/accounts/Account;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public static getAccountsCount(Landroid/content/Context;)I
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 112
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    .line 113
    .local v0, "am":Landroid/accounts/AccountManager;
    sget-object v1, Lco/vine/android/client/VineAccountHelper;->ACCOUNT_TYPE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v1

    array-length v1, v1

    return v1
.end method

.method public static getActiveAccount(Landroid/content/Context;)Landroid/accounts/Account;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 507
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    return-object v0
.end method

.method public static getActiveAccountReadOnly(Landroid/content/Context;)Landroid/accounts/Account;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 512
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->getActiveSessionReadOnly()Lco/vine/android/client/Session;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    return-object v0
.end method

.method public static getActiveSession(Landroid/content/Context;Z)Lco/vine/android/client/Session;
    .locals 9
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "readOnly"    # Z

    .prologue
    .line 431
    sget-object v7, Lco/vine/android/client/VineAccountHelper;->mActiveSession:Lco/vine/android/client/Session;

    .line 432
    .local v7, "session":Lco/vine/android/client/Session;
    if-nez v7, :cond_5

    .line 433
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v3

    .line 434
    .local v3, "am":Landroid/accounts/AccountManager;
    sget-object v8, Lco/vine/android/client/VineAccountHelper;->ACCOUNT_TYPE:Ljava/lang/String;

    invoke-virtual {v3, v8}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v2

    .line 436
    .local v2, "accounts":[Landroid/accounts/Account;
    array-length v8, v2

    if-lez v8, :cond_3

    .line 438
    invoke-static {p0}, Lco/vine/android/provider/SettingsManager;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 441
    .local v1, "accountName":Ljava/lang/String;
    move-object v4, v2

    .local v4, "arr$":[Landroid/accounts/Account;
    array-length v6, v4

    .local v6, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_0
    if-ge v5, v6, :cond_3

    aget-object v0, v4, v5

    .line 442
    .local v0, "account":Landroid/accounts/Account;
    if-eqz v1, :cond_0

    iget-object v8, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v8, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 445
    :cond_0
    iget-object v8, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {p0, v8}, Lco/vine/android/client/VineAccountHelper;->getSession(Landroid/content/Context;Ljava/lang/String;)Lco/vine/android/client/Session;

    move-result-object v7

    .line 446
    iget-object v8, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lco/vine/android/client/Session;->setLoginEmail(Ljava/lang/String;)V

    .line 447
    sget-object v8, Lco/vine/android/client/Session$LoginStatus;->LOGGED_IN:Lco/vine/android/client/Session$LoginStatus;

    invoke-virtual {v7, v8}, Lco/vine/android/client/Session;->setLoginStatus(Lco/vine/android/client/Session$LoginStatus;)V

    .line 448
    if-nez p1, :cond_1

    .line 449
    invoke-static {p0, v7}, Lco/vine/android/client/VineAccountHelper;->setActiveSession(Landroid/content/Context;Lco/vine/android/client/Session;)V

    .line 451
    :cond_1
    sput-object v7, Lco/vine/android/client/VineAccountHelper;->mActiveSession:Lco/vine/android/client/Session;

    move-object v8, v7

    .line 468
    .end local v0    # "account":Landroid/accounts/Account;
    .end local v1    # "accountName":Ljava/lang/String;
    .end local v2    # "accounts":[Landroid/accounts/Account;
    .end local v3    # "am":Landroid/accounts/AccountManager;
    .end local v4    # "arr$":[Landroid/accounts/Account;
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    :goto_1
    return-object v8

    .line 441
    .restart local v0    # "account":Landroid/accounts/Account;
    .restart local v1    # "accountName":Ljava/lang/String;
    .restart local v2    # "accounts":[Landroid/accounts/Account;
    .restart local v3    # "am":Landroid/accounts/AccountManager;
    .restart local v4    # "arr$":[Landroid/accounts/Account;
    .restart local v5    # "i$":I
    .restart local v6    # "len$":I
    :cond_2
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 459
    .end local v0    # "account":Landroid/accounts/Account;
    .end local v1    # "accountName":Ljava/lang/String;
    .end local v4    # "arr$":[Landroid/accounts/Account;
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    :cond_3
    invoke-static {}, Lco/vine/android/client/VineAccountHelper;->createSession()Lco/vine/android/client/Session;

    move-result-object v7

    .line 462
    if-nez p1, :cond_4

    .line 463
    invoke-static {p0, v7}, Lco/vine/android/client/VineAccountHelper;->setActiveSession(Landroid/content/Context;Lco/vine/android/client/Session;)V

    .line 465
    :cond_4
    sput-object v7, Lco/vine/android/client/VineAccountHelper;->mActiveSession:Lco/vine/android/client/Session;

    .line 468
    .end local v2    # "accounts":[Landroid/accounts/Account;
    .end local v3    # "am":Landroid/accounts/AccountManager;
    :cond_5
    sget-object v8, Lco/vine/android/client/VineAccountHelper;->mActiveSession:Lco/vine/android/client/Session;

    goto :goto_1
.end method

.method public static getAvatarUrl(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Ljava/lang/String;
    .locals 1
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 273
    const-string v0, "account_user_avatar"

    invoke-virtual {p0, p1, v0}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getCachedActiveSession()Lco/vine/android/client/Session;
    .locals 1

    .prologue
    .line 427
    sget-object v0, Lco/vine/android/client/VineAccountHelper;->mActiveSession:Lco/vine/android/client/Session;

    return-object v0
.end method

.method private static getDeviceId(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 548
    const-string v1, "phone"

    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    .line 549
    .local v0, "telephonyManager":Landroid/telephony/TelephonyManager;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getDeviceId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 550
    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getDeviceId()Ljava/lang/String;

    move-result-object v1

    .line 552
    :goto_0
    return-object v1

    :cond_0
    sget-object v1, Landroid/os/Build;->SERIAL:Ljava/lang/String;

    goto :goto_0
.end method

.method private static getKeyDigest(Ljava/lang/String;)[B
    .locals 2
    .param p0, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 542
    const-string v1, "SHA-256"

    invoke-static {v1}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 543
    .local v0, "messageDigest":Ljava/security/MessageDigest;
    const-string v1, "UTF-8"

    invoke-virtual {p0, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/security/MessageDigest;->update([B)V

    .line 544
    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v1

    return-object v1
.end method

.method public static getLoginType(Landroid/accounts/AccountManager;Landroid/accounts/Account;)I
    .locals 1
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 291
    const-string v0, "account_login_type"

    invoke-virtual {p0, p1, v0}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static getName(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Ljava/lang/String;
    .locals 1
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 284
    const-string v0, "account_user_name"

    invoke-virtual {p0, p1, v0}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getPassword(Landroid/accounts/AccountManager;Landroid/accounts/Account;Landroid/content/Context;)Ljava/lang/String;
    .locals 5
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 298
    invoke-virtual {p0, p1}, Landroid/accounts/AccountManager;->getPassword(Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v1

    .line 300
    .local v1, "password":Ljava/lang/String;
    const-string v3, "account_password_encrypted"

    invoke-virtual {p0, p1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 301
    .local v2, "passwordFlag":Ljava/lang/String;
    if-eqz v2, :cond_1

    invoke-static {v2}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_1

    .line 303
    :try_start_0
    invoke-static {p2}, Lco/vine/android/client/VineAccountHelper;->getDeviceId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v1}, Lco/vine/android/client/VineAccountHelper;->decrypt(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    :cond_0
    :goto_0
    move-object v3, v1

    .line 314
    :goto_1
    return-object v3

    .line 304
    :catch_0
    move-exception v0

    .line 305
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "Error decrypting password."

    invoke-static {v3, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 306
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 307
    const/4 v3, 0x0

    goto :goto_1

    .line 309
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    if-eqz v1, :cond_0

    .line 311
    invoke-static {p0, p1, p2}, Lco/vine/android/client/VineAccountHelper;->migratePassword(Landroid/accounts/AccountManager;Landroid/accounts/Account;Landroid/content/Context;)V

    goto :goto_0
.end method

.method public static getSession(Landroid/content/Context;Ljava/lang/String;)Lco/vine/android/client/Session;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "accountName"    # Ljava/lang/String;

    .prologue
    .line 488
    if-nez p1, :cond_0

    .line 489
    invoke-static {}, Lco/vine/android/client/VineAccountHelper;->createSession()Lco/vine/android/client/Session;

    move-result-object v1

    .line 499
    :goto_0
    return-object v1

    .line 491
    :cond_0
    sget-object v1, Lco/vine/android/client/VineAccountHelper;->mActiveSession:Lco/vine/android/client/Session;

    if-nez v1, :cond_1

    .line 492
    invoke-static {p0, p1}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    .line 493
    .local v0, "account":Landroid/accounts/Account;
    if-nez v0, :cond_2

    .line 494
    invoke-static {}, Lco/vine/android/client/VineAccountHelper;->createSession()Lco/vine/android/client/Session;

    move-result-object v1

    sput-object v1, Lco/vine/android/client/VineAccountHelper;->mActiveSession:Lco/vine/android/client/Session;

    .line 499
    .end local v0    # "account":Landroid/accounts/Account;
    :cond_1
    :goto_1
    sget-object v1, Lco/vine/android/client/VineAccountHelper;->mActiveSession:Lco/vine/android/client/Session;

    goto :goto_0

    .line 496
    .restart local v0    # "account":Landroid/accounts/Account;
    :cond_2
    invoke-static {p0, v0}, Lco/vine/android/client/VineAccountHelper;->createSession(Landroid/content/Context;Landroid/accounts/Account;)Lco/vine/android/client/Session;

    move-result-object v1

    sput-object v1, Lco/vine/android/client/VineAccountHelper;->mActiveSession:Lco/vine/android/client/Session;

    goto :goto_1
.end method

.method public static getSessionKey(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Ljava/lang/String;
    .locals 1
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 246
    const-string v0, "co.vine.android.basic_auth.token.secret"

    invoke-virtual {p0, p1, v0}, Landroid/accounts/AccountManager;->peekAuthToken(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getTwitterSecret(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Ljava/lang/String;
    .locals 1
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 328
    const-string v0, "account_t_secret"

    invoke-virtual {p0, p1, v0}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getTwitterToken(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Ljava/lang/String;
    .locals 1
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 321
    const-string v0, "account_t_token"

    invoke-virtual {p0, p1, v0}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getTwitterUsername(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Ljava/lang/String;
    .locals 1
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 335
    const-string v0, "account_t_username"

    invoke-virtual {p0, p1, v0}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getUserId(Landroid/accounts/AccountManager;Landroid/accounts/Account;)J
    .locals 3
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 257
    const-string v1, "account_user_info"

    invoke-virtual {p0, p1, v1}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 258
    .local v0, "userIdS":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 259
    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v1

    .line 261
    :goto_0
    return-wide v1

    :cond_0
    const-wide/16 v1, 0x0

    goto :goto_0
.end method

.method public static isLoggedIn(Landroid/content/Context;Z)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "readOnly"    # Z

    .prologue
    .line 517
    invoke-static {p0, p1}, Lco/vine/android/client/VineAccountHelper;->getActiveSession(Landroid/content/Context;Z)Lco/vine/android/client/Session;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/Session;->isLoggedIn()Z

    move-result v0

    return v0
.end method

.method public static isNormalVideoPlayable(Landroid/content/Context;)Lco/vine/android/util/SystemUtil$PrefBooleanState;
    .locals 4
    .param p0, "activity"    # Landroid/content/Context;

    .prologue
    .line 400
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v1

    .line 401
    .local v1, "am":Landroid/accounts/AccountManager;
    if-nez v1, :cond_0

    .line 402
    sget-object v3, Lco/vine/android/util/SystemUtil$PrefBooleanState;->UNKNOWN:Lco/vine/android/util/SystemUtil$PrefBooleanState;

    .line 412
    :goto_0
    return-object v3

    .line 404
    :cond_0
    invoke-static {p0}, Lco/vine/android/client/VineAccountHelper;->getActiveAccount(Landroid/content/Context;)Landroid/accounts/Account;

    move-result-object v0

    .line 405
    .local v0, "account":Landroid/accounts/Account;
    const/4 v2, 0x0

    .line 406
    .local v2, "data":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 407
    const-string v3, "account_normal_video_playable"

    invoke-virtual {v1, v0, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 409
    :cond_1
    if-eqz v2, :cond_2

    .line 410
    invoke-static {v2}, Lco/vine/android/util/SystemUtil$PrefBooleanState;->valueOf(Ljava/lang/String;)Lco/vine/android/util/SystemUtil$PrefBooleanState;

    move-result-object v3

    goto :goto_0

    .line 412
    :cond_2
    sget-object v3, Lco/vine/android/util/SystemUtil$PrefBooleanState;->UNKNOWN:Lco/vine/android/util/SystemUtil$PrefBooleanState;

    goto :goto_0
.end method

.method public static migratePassword(Landroid/accounts/AccountManager;Landroid/accounts/Account;Landroid/content/Context;)V
    .locals 5
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 558
    if-eqz p0, :cond_0

    if-nez p1, :cond_2

    .line 559
    :cond_0
    const-string v3, "Skipping migrate password check due to null AccountManager or Account"

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    .line 579
    :cond_1
    :goto_0
    return-void

    .line 563
    :cond_2
    const-string v3, "account_password_encrypted"

    invoke-virtual {p0, p1, v3}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 564
    .local v2, "passwordFlag":Ljava/lang/String;
    if-eqz v2, :cond_3

    invoke-static {v2}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 566
    :cond_3
    invoke-virtual {p0, p1}, Landroid/accounts/AccountManager;->getPassword(Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v1

    .line 567
    .local v1, "password":Ljava/lang/String;
    if-eqz v1, :cond_1

    .line 569
    :try_start_0
    invoke-static {p2}, Lco/vine/android/client/VineAccountHelper;->getDeviceId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v1}, Lco/vine/android/client/VineAccountHelper;->encrypt(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, p1, v3}, Landroid/accounts/AccountManager;->setPassword(Landroid/accounts/Account;Ljava/lang/String;)V

    .line 571
    const-string v3, "account_password_encrypted"

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, p1, v3, v4}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 572
    :catch_0
    move-exception v0

    .line 573
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "Error migrating password."

    invoke-static {v3, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 574
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static needsAddwidget(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Z
    .locals 2
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 342
    const-string v1, "account_add_widget"

    invoke-virtual {p0, p1, v1}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 343
    .local v0, "data":Ljava/lang/String;
    if-nez v0, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static removeAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/AccountManagerFuture;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "accountName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            ")",
            "Landroid/accounts/AccountManagerFuture",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 178
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v2

    .line 179
    .local v2, "am":Landroid/accounts/AccountManager;
    sget-object v7, Lco/vine/android/client/VineAccountHelper;->ACCOUNT_TYPE:Ljava/lang/String;

    invoke-virtual {v2, v7}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v1

    .line 181
    .local v1, "accounts":[Landroid/accounts/Account;
    move-object v3, v1

    .local v3, "arr$":[Landroid/accounts/Account;
    array-length v5, v3

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_0

    aget-object v0, v3, v4

    .line 182
    .local v0, "account":Landroid/accounts/Account;
    iget-object v7, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v7, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 183
    invoke-virtual {v2, v0, v6, v6}, Landroid/accounts/AccountManager;->removeAccount(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    move-result-object v6

    .line 186
    .end local v0    # "account":Landroid/accounts/Account;
    :cond_0
    return-object v6

    .line 181
    .restart local v0    # "account":Landroid/accounts/Account;
    :cond_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0
.end method

.method public static removeTwitterInfo(Landroid/content/Context;Ljava/lang/String;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "accountName"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 222
    invoke-static {p0, p1}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    .line 223
    .local v0, "account":Landroid/accounts/Account;
    if-eqz v0, :cond_0

    .line 224
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v1

    .line 225
    .local v1, "am":Landroid/accounts/AccountManager;
    const-string v2, "account_t_token"

    invoke-virtual {v1, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 226
    const-string v2, "account_t_secret"

    invoke-virtual {v1, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 227
    const-string v2, "account_t_id"

    invoke-virtual {v1, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 228
    const-string v2, "account_t_username"

    invoke-virtual {v1, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 229
    const-string v2, "account_login_type"

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    .end local v1    # "am":Landroid/accounts/AccountManager;
    :cond_0
    return-void
.end method

.method public static resetActiveSession()V
    .locals 1

    .prologue
    .line 503
    const/4 v0, 0x0

    sput-object v0, Lco/vine/android/client/VineAccountHelper;->mActiveSession:Lco/vine/android/client/Session;

    .line 504
    return-void
.end method

.method public static saveTwitterInfo(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "accountName"    # Ljava/lang/String;
    .param p2, "username"    # Ljava/lang/String;
    .param p3, "token"    # Ljava/lang/String;
    .param p4, "secret"    # Ljava/lang/String;
    .param p5, "twitterUserId"    # J

    .prologue
    .line 208
    invoke-static {p0, p1}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    .line 209
    .local v0, "account":Landroid/accounts/Account;
    if-eqz v0, :cond_0

    .line 210
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v1

    .line 211
    .local v1, "am":Landroid/accounts/AccountManager;
    const-string v2, "account_t_token"

    invoke-virtual {v1, v0, v2, p3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 212
    const-string v2, "account_t_secret"

    invoke-virtual {v1, v0, v2, p4}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    const-string v2, "account_t_id"

    invoke-static {p5, p6}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 215
    const-string v2, "account_t_username"

    invoke-virtual {v1, v0, v2, p2}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 216
    const-string v2, "account_login_type"

    const/4 v3, 0x2

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 219
    .end local v1    # "am":Landroid/accounts/AccountManager;
    :cond_0
    return-void
.end method

.method public static saveUserId(Landroid/content/Context;Ljava/lang/String;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "accountName"    # Ljava/lang/String;
    .param p2, "userId"    # J

    .prologue
    .line 197
    invoke-static {p0, p1}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    .line 198
    .local v0, "account":Landroid/accounts/Account;
    if-eqz v0, :cond_0

    .line 199
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v1

    .line 200
    .local v1, "am":Landroid/accounts/AccountManager;
    const-wide/16 v2, 0x0

    cmp-long v2, p2, v2

    if-lez v2, :cond_0

    .line 201
    const-string v2, "account_user_info"

    invoke-static {p2, p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v0, v2, v3}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 204
    .end local v1    # "am":Landroid/accounts/AccountManager;
    :cond_0
    return-void
.end method

.method public static setActiveSession(Landroid/content/Context;Lco/vine/android/client/Session;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "session"    # Lco/vine/android/client/Session;

    .prologue
    .line 483
    invoke-virtual {p1}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lco/vine/android/client/Session;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v2

    invoke-static {p0, v0, v1, v2, v3}, Lco/vine/android/provider/SettingsManager;->setCurrentAccount(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)V

    .line 485
    return-void
.end method

.method public static setDidShowAddWidget(Landroid/accounts/AccountManager;Landroid/accounts/Account;)V
    .locals 2
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 350
    const-string v0, "account_add_widget"

    const-string v1, "YES"

    invoke-virtual {p0, p1, v0, v1}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 351
    return-void
.end method

.method public static setDidShowStoreContactsPrompt(Landroid/accounts/AccountManager;Landroid/accounts/Account;)V
    .locals 2
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 372
    if-eqz p0, :cond_0

    if-eqz p1, :cond_0

    .line 373
    const-string v0, "account_did_show_store_contacts"

    const-string v1, "YES"

    invoke-virtual {p0, p1, v0, v1}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 375
    :cond_0
    return-void
.end method

.method public static setDidShowVmOnboard(Landroid/accounts/AccountManager;Landroid/accounts/Account;)V
    .locals 2
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 359
    const-string v0, "account_did_show_vm_onboard"

    const-string v1, "YES"

    invoke-virtual {p0, p1, v0, v1}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 360
    return-void
.end method

.method public static setSessionKey(Landroid/accounts/AccountManager;Landroid/accounts/Account;Ljava/lang/String;)V
    .locals 1
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 235
    const-string v0, "co.vine.android.basic_auth.token.secret"

    invoke-virtual {p0, p1, v0, p2}, Landroid/accounts/AccountManager;->setAuthToken(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 236
    return-void
.end method

.method public static shouldShowStoreContactsPrompt(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Z
    .locals 3
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    const/4 v1, 0x1

    .line 363
    if-eqz p0, :cond_0

    if-eqz p1, :cond_0

    .line 364
    const-string v2, "account_did_show_store_contacts"

    invoke-virtual {p0, p1, v2}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 365
    .local v0, "data":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 367
    .end local v0    # "data":Ljava/lang/String;
    :cond_0
    :goto_0
    return v1

    .line 365
    .restart local v0    # "data":Ljava/lang/String;
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static shouldShowVmOnboard(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Z
    .locals 2
    .param p0, "am"    # Landroid/accounts/AccountManager;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 354
    const-string v1, "account_did_show_vm_onboard"

    invoke-virtual {p0, p1, v1}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 355
    .local v0, "data":Ljava/lang/String;
    if-nez v0, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static syncNormalVideoPlayable(Landroid/content/Context;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 382
    invoke-static {p0}, Lco/vine/android/client/VineAccountHelper;->isNormalVideoPlayable(Landroid/content/Context;)Lco/vine/android/util/SystemUtil$PrefBooleanState;

    move-result-object v1

    .line 383
    .local v1, "accountStatus":Lco/vine/android/util/SystemUtil$PrefBooleanState;
    invoke-static {p0}, Lco/vine/android/util/SystemUtil;->isNormalVideoPlayable(Landroid/content/Context;)Lco/vine/android/util/SystemUtil$PrefBooleanState;

    move-result-object v3

    .line 384
    .local v3, "preferenceStatus":Lco/vine/android/util/SystemUtil$PrefBooleanState;
    if-eq v1, v3, :cond_0

    .line 385
    sget-object v4, Lco/vine/android/util/SystemUtil$PrefBooleanState;->UNKNOWN:Lco/vine/android/util/SystemUtil$PrefBooleanState;

    if-eq v3, v4, :cond_1

    .line 387
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v2

    .line 388
    .local v2, "am":Landroid/accounts/AccountManager;
    invoke-static {p0}, Lco/vine/android/client/VineAccountHelper;->getActiveAccount(Landroid/content/Context;)Landroid/accounts/Account;

    move-result-object v0

    .line 389
    .local v0, "account":Landroid/accounts/Account;
    if-eqz v2, :cond_0

    if-eqz v0, :cond_0

    .line 390
    const-string v4, "account_normal_video_playable"

    invoke-virtual {v3}, Lco/vine/android/util/SystemUtil$PrefBooleanState;->name()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v0, v4, v5}, Landroid/accounts/AccountManager;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 397
    .end local v0    # "account":Landroid/accounts/Account;
    .end local v2    # "am":Landroid/accounts/AccountManager;
    :cond_0
    :goto_0
    return-void

    .line 394
    :cond_1
    sget-object v4, Lco/vine/android/util/SystemUtil$PrefBooleanState;->TRUE:Lco/vine/android/util/SystemUtil$PrefBooleanState;

    if-ne v1, v4, :cond_2

    const/4 v4, 0x1

    :goto_1
    invoke-static {p0, v4}, Lco/vine/android/util/SystemUtil;->setNormalVideoPlayable(Landroid/content/Context;Z)V

    goto :goto_0

    :cond_2
    const/4 v4, 0x0

    goto :goto_1
.end method
