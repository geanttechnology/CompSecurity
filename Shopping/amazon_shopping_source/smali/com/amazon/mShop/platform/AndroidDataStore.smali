.class public Lcom/amazon/mShop/platform/AndroidDataStore;
.super Ljava/lang/Object;
.source "AndroidDataStore.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/persistence/DataStore;


# static fields
.field private static final sNonLocalizedKeysList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final sSessionKeyList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final byteArraysCache:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "[B>;"
        }
    .end annotation
.end field

.field private final preferences:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 218
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    .line 220
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "cookieJar"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 221
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "secureCookieJar"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 222
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "userEmail"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 223
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "userFullName"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 224
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "userPrime"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 225
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "userOneClick"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 226
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "userPrimeEligible"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 227
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "userPrimeFunnelUrl"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 228
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "userDob"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 229
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "oneClickAutoSetupState"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 230
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "successfullyConnected"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 231
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "acceptedEulaVersion"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 232
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "allowUseUserCurrentlocation"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 233
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "isLocationAllowDialogShown"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 234
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "isArTried"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 235
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "suppressInfoDialog"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 236
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "lastRemembersUpdate"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 237
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "dataChargesDialogShown"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 238
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "applicationExitReason"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 239
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "applicationStartCount"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 240
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "remembersPendingMatches"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 241
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "remembersMatchesToMarkAsNew"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 242
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "recentProducts"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 243
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "userRatingRequestErrorSet"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 244
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    const-string/jumbo v1, "needToSelectLocale"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 314
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    .line 316
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "amazonAssociatesTag"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 317
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "associatesTagWithoutLocaleCode"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 318
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "applicationCurrentLocale"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 319
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "userRatingRequestErrorSet"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 320
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "partnerName"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 321
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "UDID"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 322
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "gcmRegistrationId"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 323
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "gcmErrorId"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 324
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "latestLocaleOfCanada"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 326
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "enableMAPr5"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 329
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "app_start_count_of_current_version"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 330
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "shortcut_install_current_version"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 331
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "is_shortcut_installed"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 333
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "appStartIndicationDialogNotRemindAgain"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 334
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "referrerSource"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 339
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "applicationInstallId"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 340
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "applicationSecretKey"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 341
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "globalApplicationVersion"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 342
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "hardwareIdentifier"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 343
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "osVersion"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 344
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "Ubid"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 345
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "kiangUpdateSequenceNumber"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 346
    sget-object v0, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    const-string/jumbo v1, "currentLocaleName"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 347
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    const-string/jumbo v0, "DataStore"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    .line 41
    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->byteArraysCache:Ljava/util/Map;

    .line 42
    return-void
.end method

.method private static shouldWrapTagWithLocale(Ljava/lang/String;)Z
    .locals 2
    .param p0, "key"    # Ljava/lang/String;

    .prologue
    .line 364
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocale()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 365
    .local v0, "currentLocale":Ljava/lang/String;
    invoke-static {p0, v0}, Lcom/amazon/mShop/platform/AndroidDataStore;->shouldWrapTagWithLocale(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    return v1
.end method

.method private static shouldWrapTagWithLocale(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 375
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getDefaultLocale()Ljava/lang/String;

    move-result-object v0

    .line 376
    .local v0, "appDefaultLocale":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    invoke-static {p1}, Lcom/amazon/mShop/platform/AppLocale;->isLocaleOfCA(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {v0}, Lcom/amazon/mShop/platform/AppLocale;->isLocaleOfCA(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    :cond_0
    sget-object v1, Lcom/amazon/mShop/platform/AndroidDataStore;->sNonLocalizedKeysList:Ljava/util/List;

    invoke-interface {v1, p0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 381
    :cond_1
    const/4 v1, 0x0

    .line 383
    :goto_0
    return v1

    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public static wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "key"    # Ljava/lang/String;

    .prologue
    .line 285
    invoke-static {p0}, Lcom/amazon/mShop/platform/AndroidDataStore;->shouldWrapTagWithLocale(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 286
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocale()Ljava/util/Locale;

    move-result-object v0

    .line 287
    .local v0, "currentLocale":Ljava/util/Locale;
    invoke-virtual {v0}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    .line 289
    .end local v0    # "currentLocale":Ljava/util/Locale;
    .end local p0    # "key":Ljava/lang/String;
    :cond_0
    return-object p0
.end method

.method private static wrapKeyWithLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 299
    invoke-static {p0, p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->shouldWrapTagWithLocale(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 300
    const/4 v0, 0x0

    .line 301
    .local v0, "localizedKey":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/platform/AppLocale;->isLocaleOfCA(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 302
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "CA"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 308
    .end local v0    # "localizedKey":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 304
    .restart local v0    # "localizedKey":Ljava/lang/String;
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .end local v0    # "localizedKey":Ljava/lang/String;
    :cond_1
    move-object v0, p0

    .line 308
    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized getBoolean(Ljava/lang/String;)Z
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 81
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 82
    .local v0, "localizedKey":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    const/4 v2, 0x0

    invoke-interface {v1, v0, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    monitor-exit p0

    return v1

    .line 81
    .end local v0    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public getBoolean(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "localeName"    # Ljava/lang/String;

    .prologue
    .line 86
    invoke-static {p1, p2}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 87
    .local v0, "localizedKey":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    const/4 v2, 0x0

    invoke-interface {v1, v0, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    return v1
.end method

.method public declared-synchronized getBoolean(Ljava/lang/String;Z)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defValue"    # Z

    .prologue
    .line 92
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 93
    .local v0, "localizedKey":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v1, v0, p2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    monitor-exit p0

    return v1

    .line 92
    .end local v0    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getByteArray(Ljava/lang/String;)[B
    .locals 10
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 46
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 48
    .local v6, "localizedKey":Ljava/lang/String;
    iget-object v8, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->byteArraysCache:Ljava/util/Map;

    invoke-interface {v8, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, [B

    .line 49
    .local v7, "value":[B
    if-nez v7, :cond_1

    .line 51
    iget-object v8, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    const/4 v9, 0x0

    invoke-interface {v8, v6, v9}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 52
    .local v3, "hexa":Ljava/lang/String;
    if-eqz v3, :cond_1

    .line 54
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v8

    shr-int/lit8 v8, v8, 0x1

    new-array v7, v8, [B

    .line 55
    const/4 v0, 0x0

    .local v0, "bIndex":I
    const/4 v1, 0x0

    .local v1, "hIndex":I
    move v2, v1

    .end local v1    # "hIndex":I
    .local v2, "hIndex":I
    :goto_0
    array-length v8, v7

    if-ge v0, v8, :cond_0

    .line 56
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "hIndex":I
    .restart local v1    # "hIndex":I
    invoke-virtual {v3, v2}, Ljava/lang/String;->charAt(I)C

    move-result v8

    const/16 v9, 0x10

    invoke-static {v8, v9}, Ljava/lang/Character;->digit(CI)I

    move-result v4

    .line 57
    .local v4, "iHigh":I
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "hIndex":I
    .restart local v2    # "hIndex":I
    invoke-virtual {v3, v1}, Ljava/lang/String;->charAt(I)C

    move-result v8

    const/16 v9, 0x10

    invoke-static {v8, v9}, Ljava/lang/Character;->digit(CI)I

    move-result v5

    .line 58
    .local v5, "iLow":I
    shl-int/lit8 v8, v4, 0x4

    and-int/lit8 v9, v5, 0xf

    add-int/2addr v8, v9

    int-to-byte v8, v8

    aput-byte v8, v7, v0

    .line 55
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 61
    .end local v4    # "iHigh":I
    .end local v5    # "iLow":I
    :cond_0
    iget-object v8, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->byteArraysCache:Ljava/util/Map;

    invoke-interface {v8, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 64
    .end local v0    # "bIndex":I
    .end local v2    # "hIndex":I
    .end local v3    # "hexa":Ljava/lang/String;
    :cond_1
    monitor-exit p0

    return-object v7

    .line 46
    .end local v6    # "localizedKey":Ljava/lang/String;
    .end local v7    # "value":[B
    :catchall_0
    move-exception v8

    monitor-exit p0

    throw v8
.end method

.method public declared-synchronized getInt(Ljava/lang/String;)I
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 98
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 99
    .local v0, "localizedKey":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    const/4 v2, 0x0

    invoke-interface {v1, v0, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    monitor-exit p0

    return v1

    .line 98
    .end local v0    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getInt(Ljava/lang/String;Ljava/lang/String;)I
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "localeName"    # Ljava/lang/String;

    .prologue
    .line 104
    monitor-enter p0

    :try_start_0
    invoke-static {p1, p2}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 105
    .local v0, "localizedKey":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    const/4 v2, 0x0

    invoke-interface {v1, v0, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    monitor-exit p0

    return v1

    .line 104
    .end local v0    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getLong(Ljava/lang/String;)J
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 110
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 111
    .local v0, "localizedKey":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    const-wide/16 v2, 0x0

    invoke-interface {v1, v0, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    monitor-exit p0

    return-wide v1

    .line 110
    .end local v0    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getLong(Ljava/lang/String;Ljava/lang/String;)J
    .locals 4
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "localeName"    # Ljava/lang/String;

    .prologue
    .line 116
    monitor-enter p0

    :try_start_0
    invoke-static {p1, p2}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 117
    .local v0, "localizedKey":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    const-wide/16 v2, 0x0

    invoke-interface {v1, v0, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v1

    monitor-exit p0

    return-wide v1

    .line 116
    .end local v0    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getString(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 69
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 70
    .local v0, "localizedKey":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    const/4 v2, 0x0

    invoke-interface {v1, v0, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    monitor-exit p0

    return-object v1

    .line 69
    .end local v0    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "localeName"    # Ljava/lang/String;

    .prologue
    .line 75
    monitor-enter p0

    :try_start_0
    invoke-static {p1, p2}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 76
    .local v0, "localizedKey":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    const/4 v2, 0x0

    invoke-interface {v1, v0, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    monitor-exit p0

    return-object v1

    .line 75
    .end local v0    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized putBoolean(Ljava/lang/String;Z)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 171
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 172
    .local v1, "localizedKey":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 173
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, v1, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 174
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 175
    monitor-exit p0

    return-void

    .line 171
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v1    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized putBoolean(Ljava/lang/String;ZLjava/lang/String;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Z
    .param p3, "localeName"    # Ljava/lang/String;

    .prologue
    .line 179
    monitor-enter p0

    :try_start_0
    invoke-static {p1, p3}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 180
    .local v1, "localizedKey":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 181
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, v1, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 182
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 183
    monitor-exit p0

    return-void

    .line 179
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v1    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized putByteArray(Ljava/lang/String;[B)V
    .locals 9
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # [B

    .prologue
    .line 122
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 123
    .local v6, "localizedKey":Ljava/lang/String;
    iget-object v7, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v7}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    .line 124
    .local v2, "editor":Landroid/content/SharedPreferences$Editor;
    if-nez p2, :cond_0

    .line 125
    invoke-interface {v2, v6}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 126
    iget-object v7, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->byteArraysCache:Ljava/util/Map;

    invoke-interface {v7, v6}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 139
    :goto_0
    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 140
    monitor-exit p0

    return-void

    .line 129
    :cond_0
    :try_start_1
    array-length v7, p2

    shl-int/lit8 v7, v7, 0x1

    new-array v5, v7, [C

    .line 130
    .local v5, "hexa":[C
    const/4 v1, 0x0

    .local v1, "bIndex":I
    const/4 v3, 0x0

    .local v3, "hIndex":I
    move v4, v3

    .end local v3    # "hIndex":I
    .local v4, "hIndex":I
    :goto_1
    array-length v7, p2

    if-ge v1, v7, :cond_1

    .line 131
    aget-byte v0, p2, v1

    .line 132
    .local v0, "b":B
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "hIndex":I
    .restart local v3    # "hIndex":I
    shr-int/lit8 v7, v0, 0x4

    and-int/lit8 v7, v7, 0xf

    const/16 v8, 0x10

    invoke-static {v7, v8}, Ljava/lang/Character;->forDigit(II)C

    move-result v7

    aput-char v7, v5, v4

    .line 133
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "hIndex":I
    .restart local v4    # "hIndex":I
    and-int/lit8 v7, v0, 0xf

    const/16 v8, 0x10

    invoke-static {v7, v8}, Ljava/lang/Character;->forDigit(II)C

    move-result v7

    aput-char v7, v5, v3

    .line 130
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 136
    .end local v0    # "b":B
    :cond_1
    new-instance v7, Ljava/lang/String;

    invoke-direct {v7, v5}, Ljava/lang/String;-><init>([C)V

    invoke-interface {v2, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 137
    iget-object v7, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->byteArraysCache:Ljava/util/Map;

    invoke-interface {v7, v6, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 122
    .end local v1    # "bIndex":I
    .end local v2    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v4    # "hIndex":I
    .end local v5    # "hexa":[C
    .end local v6    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v7

    monitor-exit p0

    throw v7
.end method

.method public declared-synchronized putInt(Ljava/lang/String;I)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # I

    .prologue
    .line 187
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 188
    .local v1, "localizedKey":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 189
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, v1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 190
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 191
    monitor-exit p0

    return-void

    .line 187
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v1    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized putLong(Ljava/lang/String;J)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # J

    .prologue
    .line 195
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 196
    .local v1, "localizedKey":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 197
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, v1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 198
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 199
    monitor-exit p0

    return-void

    .line 195
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v1    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized putLong(Ljava/lang/String;JLjava/lang/String;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # J
    .param p4, "localeName"    # Ljava/lang/String;

    .prologue
    .line 203
    monitor-enter p0

    :try_start_0
    invoke-static {p1, p4}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 204
    .local v1, "localizedKey":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 205
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, v1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 206
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 207
    monitor-exit p0

    return-void

    .line 203
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v1    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized putString(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 144
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 145
    .local v1, "localizedKey":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 146
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, v1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 147
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 148
    monitor-exit p0

    return-void

    .line 144
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v1    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized putString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "localeName"    # Ljava/lang/String;

    .prologue
    .line 152
    monitor-enter p0

    :try_start_0
    invoke-static {p1, p3}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 153
    .local v1, "localizedKey":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 154
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, v1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 155
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 156
    monitor-exit p0

    return-void

    .line 152
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v1    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized putString(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "shouldWrapKeyWithLocale"    # Z

    .prologue
    .line 160
    monitor-enter p0

    move-object v1, p1

    .line 161
    .local v1, "k":Ljava/lang/String;
    if-eqz p3, :cond_0

    .line 162
    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 164
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 165
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, v1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 166
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 167
    monitor-exit p0

    return-void

    .line 160
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized remove(Ljava/lang/String;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 211
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 212
    .local v1, "localizedKey":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 213
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, v1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 214
    iget-object v2, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->byteArraysCache:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 215
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 216
    monitor-exit p0

    return-void

    .line 211
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v1    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public remove(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "localeName"    # Ljava/lang/String;

    .prologue
    .line 271
    iget-object v2, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 273
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-static {p1, p2}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 274
    .local v1, "localizedKey":Ljava/lang/String;
    invoke-interface {v0, v1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 275
    iget-object v2, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->byteArraysCache:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 276
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 277
    return-void
.end method

.method public declared-synchronized removeSessionData(Ljava/lang/String;)V
    .locals 5
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 256
    monitor-enter p0

    :try_start_0
    iget-object v4, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 257
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    sget-object v4, Lcom/amazon/mShop/platform/AndroidDataStore;->sSessionKeyList:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 258
    .local v2, "key":Ljava/lang/String;
    invoke-static {v2, p1}, Lcom/amazon/mShop/platform/AndroidDataStore;->wrapKeyWithLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 259
    .local v3, "localizedKey":Ljava/lang/String;
    invoke-interface {v0, v3}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 260
    iget-object v4, p0, Lcom/amazon/mShop/platform/AndroidDataStore;->byteArraysCache:Ljava/util/Map;

    invoke-interface {v4, v3}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 256
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "localizedKey":Ljava/lang/String;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 262
    .restart local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 263
    monitor-exit p0

    return-void
.end method
