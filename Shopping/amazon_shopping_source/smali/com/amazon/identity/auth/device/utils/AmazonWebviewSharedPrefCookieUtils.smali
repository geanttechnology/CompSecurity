.class public Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;
.super Ljava/lang/Object;
.source "AmazonWebviewSharedPrefCookieUtils.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private final mContext:Landroid/content/Context;

.field private final mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

.field private final mSharedPrefs:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const-class v0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-object p1, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mContext:Landroid/content/Context;

    .line 45
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .line 46
    new-instance v0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 47
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "com.amazon.identity.auth.device.utils.CookieAuthorityInfo"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mSharedPrefs:Landroid/content/SharedPreferences;

    .line 48
    return-void
.end method

.method private getCurrentRegistrationUUID()Ljava/lang/String;
    .locals 2

    .prologue
    .line 129
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccount()Ljava/lang/String;

    move-result-object v0

    .line 131
    .local v0, "accountToUse":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v1, v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getAccountValidator(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private getUpdatedCookieString(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "domain"    # Ljava/lang/String;
    .param p2, "newCookies"    # [Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    .line 156
    iget-object v5, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5, p1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 162
    iget-object v5, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5, p1, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 163
    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->fromJsonOrSerializedBundle(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 170
    .local v2, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    :goto_0
    move-object v0, p2

    .local v0, "arr$":[Ljava/lang/String;
    array-length v4, p2

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_1
    if-ge v3, v4, :cond_1

    aget-object v5, v0, v3

    .line 172
    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->parseMapCookieFromSetCookieString(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/token/MAPCookie;

    move-result-object v1

    .line 173
    .local v1, "cookie":Lcom/amazon/identity/auth/device/token/MAPCookie;
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 170
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 167
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v1    # "cookie":Lcom/amazon/identity/auth/device/token/MAPCookie;
    .end local v2    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    :cond_0
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .restart local v2    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    goto :goto_0

    .line 176
    .restart local v0    # "arr$":[Ljava/lang/String;
    .restart local v3    # "i$":I
    .restart local v4    # "len$":I
    :cond_1
    new-instance v5, Ljava/util/ArrayList;

    new-instance v6, Ljava/util/HashSet;

    invoke-direct {v6, v2}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    invoke-direct {v5, v6}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-static {v5}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->toSerializedBundleString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v5

    return-object v5
.end method


# virtual methods
.method public addCookiesToSharedPrefs(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 10
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "cookies"    # [Ljava/lang/String;

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    const/4 v7, 0x0

    .line 85
    iget-object v2, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mSharedPrefs:Landroid/content/SharedPreferences;

    const-string/jumbo v3, "com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL"

    invoke-interface {v2, v3}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    iget-object v2, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mSharedPrefs:Landroid/content/SharedPreferences;

    const-string/jumbo v3, "com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL"

    invoke-interface {v2, v3, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->toStringSet(Ljava/lang/String;)Ljava/util/Set;

    move-result-object v2

    :goto_0
    invoke-interface {v2, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->toSerializedBundleString(Ljava/util/Set;)Ljava/lang/String;

    move-result-object v1

    .line 88
    .local v1, "updatedUrlValue":Ljava/lang/String;
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->getUpdatedCookieString(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 91
    .local v0, "updatedCookieValue":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mSharedPrefs:Landroid/content/SharedPreferences;

    const-string/jumbo v3, "com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL"

    invoke-interface {v2, v3, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v3, p1, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->getCurrentRegistrationUUID()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mSharedPrefs:Landroid/content/SharedPreferences;

    const-string/jumbo v6, "com.amazon.identity.auth.device.utils.CookieAuthorityInfo.REGISTRATION_UUID"

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v6}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    if-eqz v2, :cond_0

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    :cond_0
    sget-object v2, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v2, "Setting SharedPreferences Url value to %s"

    new-array v7, v9, [Ljava/lang/Object;

    aput-object v1, v7, v8

    invoke-static {v2, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    const-string/jumbo v2, "com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL"

    invoke-interface {v6, v2, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    :cond_1
    if-eqz v3, :cond_2

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    :cond_2
    sget-object v2, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v2, "Setting SharedPreferences Cookie value for domain %s to %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    aput-object v1, v3, v8

    aput-object v0, v3, v9

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    invoke-interface {v6, p1, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    :cond_3
    invoke-static {v4, v5}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_4

    const-string/jumbo v2, "com.amazon.identity.auth.device.utils.CookieAuthorityInfo.REGISTRATION_UUID"

    invoke-interface {v6, v2, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    :cond_4
    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 92
    return-void

    .line 85
    .end local v0    # "updatedCookieValue":Ljava/lang/String;
    .end local v1    # "updatedUrlValue":Ljava/lang/String;
    :cond_5
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    goto :goto_0
.end method

.method public checkIfProcessKnowsSameRegistration()Z
    .locals 7

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 58
    iget-object v4, p0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mSharedPrefs:Landroid/content/SharedPreferences;

    const-string/jumbo v5, "com.amazon.identity.auth.device.utils.CookieAuthorityInfo.REGISTRATION_UUID"

    const/4 v6, 0x0

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 60
    .local v0, "processRegistrationUUID":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 79
    :cond_0
    :goto_0
    return v2

    .line 65
    :cond_1
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->getCurrentRegistrationUUID()Ljava/lang/String;

    move-result-object v1

    .line 68
    .local v1, "registrationUUID":Ljava/lang/String;
    if-nez v1, :cond_2

    move v2, v3

    .line 70
    goto :goto_0

    .line 73
    :cond_2
    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    move v2, v3

    .line 79
    goto :goto_0
.end method

.method public cleanUpKnownCookies()V
    .locals 18

    .prologue
    .line 181
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->getAll()Ljava/util/Map;

    move-result-object v16

    .line 184
    .local v16, "sharedPrefMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;*>;"
    const-string/jumbo v2, "com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL"

    move-object/from16 v0, v16

    invoke-interface {v0, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 230
    :goto_0
    return-void

    .line 189
    :cond_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mContext:Landroid/content/Context;

    invoke-static {v2}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->getAmazonCookieManager(Landroid/content/Context;)Lcom/amazon/android/webkit/AmazonCookieManager;

    move-result-object v11

    .line 190
    .local v11, "cookieManager":Lcom/amazon/android/webkit/AmazonCookieManager;
    const/4 v2, 0x1

    invoke-virtual {v11, v2}, Lcom/amazon/android/webkit/AmazonCookieManager;->setAcceptCookie(Z)V

    .line 191
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mContext:Landroid/content/Context;

    invoke-static {v2}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->syncAmazonCookieSyncManager(Landroid/content/Context;)V

    .line 193
    const-string/jumbo v2, "com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL"

    move-object/from16 v0, v16

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 194
    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->toStringSet(Ljava/lang/String;)Ljava/util/Set;

    move-result-object v2

    .line 196
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :cond_1
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/String;

    .line 198
    .local v17, "url":Ljava/lang/String;
    invoke-interface/range {v16 .. v17}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 200
    invoke-interface/range {v16 .. v17}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 204
    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->fromJsonOrSerializedBundle(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 206
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v14

    .local v14, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lorg/apache/http/cookie/Cookie;

    .line 209
    .local v10, "cookie":Lorg/apache/http/cookie/Cookie;
    new-instance v1, Lcom/amazon/identity/auth/device/token/MAPCookie;

    invoke-interface {v10}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, ""

    invoke-interface {v10}, Lorg/apache/http/cookie/Cookie;->getDomain()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v10}, Lorg/apache/http/cookie/Cookie;->getExpiryDate()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/Date;->toGMTString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v10}, Lorg/apache/http/cookie/Cookie;->getPath()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v10}, Lorg/apache/http/cookie/Cookie;->isSecure()Z

    move-result v8

    check-cast v10, Lcom/amazon/identity/auth/device/token/MAPCookie;

    .end local v10    # "cookie":Lorg/apache/http/cookie/Cookie;
    invoke-virtual {v10}, Lcom/amazon/identity/auth/device/token/MAPCookie;->isHttpOnly()Z

    move-result v9

    invoke-direct/range {v1 .. v9}, Lcom/amazon/identity/auth/device/token/MAPCookie;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V

    .line 218
    .local v1, "newCookie":Lcom/amazon/identity/auth/device/token/MAPCookie;
    sget-object v2, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->LOG_TAG:Ljava/lang/String;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v17, v2, v3

    const/4 v3, 0x1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 219
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getSetCookieHeader()Ljava/lang/String;

    move-result-object v15

    .line 220
    .local v15, "newCookieString":Ljava/lang/String;
    move-object/from16 v0, v17

    invoke-virtual {v11, v0, v15}, Lcom/amazon/android/webkit/AmazonCookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 225
    .end local v1    # "newCookie":Lcom/amazon/identity/auth/device/token/MAPCookie;
    .end local v14    # "i$":Ljava/util/Iterator;
    .end local v15    # "newCookieString":Ljava/lang/String;
    .end local v17    # "url":Ljava/lang/String;
    :cond_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v12

    .line 226
    .local v12, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v12}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    .line 227
    invoke-interface {v12}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 229
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->mContext:Landroid/content/Context;

    invoke-static {v2}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->syncAmazonCookieSyncManager(Landroid/content/Context;)V

    goto/16 :goto_0
.end method
