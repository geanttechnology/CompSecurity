.class public Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;
.super Ljava/lang/Object;
.source "PrimeUpsellHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$1;,
        Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeOneClickSubscriber;,
        Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;
    }
.end annotation


# static fields
.field private static final sExcludeOrigin:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static sPrimeUpsellLaunched:Z

.field private static sPrimeUpsellSubscriber:Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 38
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const-string/jumbo v1, "public_url"

    aput-object v1, v0, v3

    const/4 v1, 0x1

    const-string/jumbo v2, "authenticate_user"

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->sExcludeOrigin:Ljava/util/List;

    .line 54
    sput-boolean v3, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->sPrimeUpsellLaunched:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 290
    return-void
.end method

.method static synthetic access$100()V
    .locals 0

    .prologue
    .line 33
    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->refreshUserInfo()V

    return-void
.end method

.method public static getPrimeRefMarkerFromLoginOrigin(ZLjava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "forceSignin"    # Z
    .param p1, "origin"    # Ljava/lang/String;

    .prologue
    .line 279
    const/4 v0, 0x0

    .line 280
    .local v0, "refMarker":Ljava/lang/String;
    if-eqz p0, :cond_1

    .line 281
    const-string/jumbo v0, "prime_fs"

    .line 287
    :cond_0
    :goto_0
    return-object v0

    .line 282
    :cond_1
    const-string/jumbo v1, "gno"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 283
    const-string/jumbo v0, "prime_gno"

    goto :goto_0

    .line 284
    :cond_2
    const-string/jumbo v1, "gw"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 285
    const-string/jumbo v0, "prime_gw"

    goto :goto_0
.end method

.method public static isPrimeUpsellLaunched()Z
    .locals 1

    .prologue
    .line 57
    sget-boolean v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->sPrimeUpsellLaunched:Z

    return v0
.end method

.method private static notExceedMaximumTimes(Lcom/amazon/mShop/model/auth/User;)Z
    .locals 5
    .param p0, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 182
    invoke-virtual {p0}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 183
    const/4 v1, 0x1

    .line 185
    .local v1, "maxTimeToShow":I
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 186
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "primeMaximumTimeToShowDebug"

    invoke-interface {v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 187
    .local v0, "debugMaxTime":I
    if-eqz v0, :cond_0

    .line 188
    move v1, v0

    .line 191
    .end local v0    # "debugMaxTime":I
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->getInstance()Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x3

    invoke-virtual {v2, v3, v1, v4}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->notExceedMaxCount(Ljava/lang/String;II)Z

    move-result v2

    .line 193
    .end local v1    # "maxTimeToShow":I
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method static primePageFinishLoading()V
    .locals 1

    .prologue
    .line 243
    sget-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->sPrimeUpsellSubscriber:Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;

    if-eqz v0, :cond_0

    .line 244
    sget-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->sPrimeUpsellSubscriber:Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;

    invoke-interface {v0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;->onPageLoadFinished()V

    .line 246
    :cond_0
    return-void
.end method

.method static primeUpsellFinished(Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;)V
    .locals 3
    .param p0, "primeUpsellResult"    # Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    .prologue
    .line 213
    const/4 v0, 0x0

    .line 214
    .local v0, "encounteredError":Z
    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_SIGNUP_SUCCESS:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    if-ne v1, p0, :cond_3

    .line 215
    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->userSignupPrime()V

    .line 223
    :cond_0
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->showedPrimeUpsellTo(Lcom/amazon/mShop/model/auth/User;Z)V

    .line 226
    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->sPrimeUpsellSubscriber:Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;

    if-eqz v1, :cond_2

    .line 228
    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_USER_CANCELLED:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    if-eq v1, p0, :cond_1

    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_LOAD_PAGE_ERROR:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    if-eq v1, p0, :cond_1

    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_OFFER_PAGE_NOT_DISPLAYED:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    if-ne v1, p0, :cond_5

    .line 231
    :cond_1
    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->sPrimeUpsellSubscriber:Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;

    invoke-interface {v1}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;->onUserCancel()V

    .line 237
    :cond_2
    :goto_1
    const/4 v1, 0x0

    sput-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->sPrimeUpsellSubscriber:Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;

    .line 238
    return-void

    .line 216
    :cond_3
    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_OFFER_PAGE_NOT_DISPLAYED:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    if-eq v1, p0, :cond_4

    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_LOAD_PAGE_ERROR:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    if-ne v1, p0, :cond_0

    .line 219
    :cond_4
    const/4 v0, 0x1

    goto :goto_0

    .line 232
    :cond_5
    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_SIGNUP_SUCCESS:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    if-eq v1, p0, :cond_6

    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_SIGNUP_FAILURE:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    if-ne v1, p0, :cond_2

    .line 233
    :cond_6
    sget-object v2, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->sPrimeUpsellSubscriber:Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;

    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_SIGNUP_SUCCESS:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    if-ne v1, p0, :cond_7

    const/4 v1, 0x1

    :goto_2
    invoke-interface {v2, v1}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;->onComplete(Z)V

    goto :goto_1

    :cond_7
    const/4 v1, 0x0

    goto :goto_2
.end method

.method private static refreshUserInfo()V
    .locals 2

    .prologue
    .line 267
    new-instance v0, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;-><init>(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;)V

    invoke-virtual {v0}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->checkFlag()V

    .line 268
    return-void
.end method

.method public static shouldCheckPrimeFlagStatus()Z
    .locals 5

    .prologue
    const/4 v2, 0x1

    .line 142
    const/4 v1, 0x0

    .line 143
    .local v1, "needCheck":Z
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->config_prime_upsell_support:I

    invoke-static {v3}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 144
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v0

    .line 145
    .local v0, "currentUser":Lcom/amazon/mShop/model/auth/User;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/amazon/mShop/model/auth/User;->isPrime()Z

    move-result v3

    if-nez v3, :cond_1

    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->getInstance()Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;

    move-result-object v3

    invoke-virtual {v0}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4, v2, v2}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->notExceedMaxCount(Ljava/lang/String;II)Z

    move-result v3

    if-eqz v3, :cond_1

    move v1, v2

    .line 150
    .end local v0    # "currentUser":Lcom/amazon/mShop/model/auth/User;
    :cond_0
    :goto_0
    return v1

    .line 145
    .restart local v0    # "currentUser":Lcom/amazon/mShop/model/auth/User;
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static shouldShowPrimeUpsell(Landroid/content/Context;)Z
    .locals 7
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 158
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v0

    .line 159
    .local v0, "currentUser":Lcom/amazon/mShop/model/auth/User;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/amazon/mShop/model/auth/User;->isPrimeEligible()Z

    move-result v5

    if-eqz v5, :cond_2

    move v2, v3

    .line 162
    .local v2, "isEligible":Z
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v5

    if-eqz v5, :cond_5

    .line 164
    if-eqz v0, :cond_0

    .line 165
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v5

    const-string/jumbo v6, "primeUpsellForceEligibleToNonPrimeUserDebug"

    invoke-interface {v5, v6, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 166
    invoke-virtual {v0}, Lcom/amazon/mShop/model/auth/User;->isPrime()Z

    move-result v5

    if-nez v5, :cond_3

    move v2, v3

    .line 169
    :cond_0
    :goto_1
    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->getPrimeUpsellDebugMode()Ljava/lang/String;

    move-result-object v1

    .line 170
    .local v1, "debuggingMode":Ljava/lang/String;
    const-string/jumbo v5, "always"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    move v4, v2

    .line 177
    .end local v1    # "debuggingMode":Ljava/lang/String;
    :cond_1
    :goto_2
    return v4

    .end local v2    # "isEligible":Z
    :cond_2
    move v2, v4

    .line 159
    goto :goto_0

    .restart local v2    # "isEligible":Z
    :cond_3
    move v2, v4

    .line 166
    goto :goto_1

    .line 172
    .restart local v1    # "debuggingMode":Ljava/lang/String;
    :cond_4
    const-string/jumbo v5, "never"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 177
    .end local v1    # "debuggingMode":Ljava/lang/String;
    :cond_5
    if-eqz v2, :cond_6

    invoke-static {v0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->notExceedMaximumTimes(Lcom/amazon/mShop/model/auth/User;)Z

    move-result v5

    if-eqz v5, :cond_6

    :goto_3
    move v4, v3

    goto :goto_2

    :cond_6
    move v3, v4

    goto :goto_3
.end method

.method public static shouldTryToShowPrimeAfterLogin(Ljava/lang/String;ZZ)Z
    .locals 2
    .param p0, "origin"    # Ljava/lang/String;
    .param p1, "isInitialLogin"    # Z
    .param p2, "isForceSignIn"    # Z

    .prologue
    .line 129
    const/4 v0, 0x1

    .line 132
    .local v0, "shouldTry":Z
    sget-object v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->sExcludeOrigin:Ljava/util/List;

    invoke-interface {v1, p0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 133
    const/4 v0, 0x0

    .line 138
    :goto_0
    return v0

    .line 135
    :cond_0
    if-nez p1, :cond_1

    if-eqz p2, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_1
    goto :goto_0

    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public static showPrimeUpsell(Landroid/app/Activity;Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;Ljava/lang/String;)Z
    .locals 1
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "primeUpsellSubscriber"    # Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;
    .param p2, "refMarker"    # Ljava/lang/String;

    .prologue
    .line 118
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->showPrimeUpsell(Landroid/app/Activity;Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static showPrimeUpsell(Landroid/app/Activity;Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 7
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "primeUpsellSubscriber"    # Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;
    .param p2, "refMarker"    # Ljava/lang/String;
    .param p3, "startupTaskId"    # Ljava/lang/String;

    .prologue
    .line 74
    const/4 v3, 0x0

    .line 77
    .local v3, "isShowedPrime":Z
    if-eqz p0, :cond_0

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->config_prime_upsell_support:I

    invoke-static {v4}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->hasNetworkConnection()Z

    move-result v4

    if-nez v4, :cond_2

    .line 78
    :cond_0
    const/4 v3, 0x0

    .line 107
    :cond_1
    :goto_0
    sput-boolean v3, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->sPrimeUpsellLaunched:Z

    .line 108
    return v3

    .line 79
    :cond_2
    invoke-static {p0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->shouldShowPrimeUpsell(Landroid/content/Context;)Z

    move-result v4

    if-eqz v4, :cond_1

    instance-of v4, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;

    if-nez v4, :cond_1

    .line 81
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v4

    const-string/jumbo v5, "currentPrimeUpsellUrl"

    invoke-interface {v4, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 83
    .local v0, "baseUrl":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v4

    if-eqz v4, :cond_3

    .line 84
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/model/auth/User;->getPrimeFunnelUrl()Ljava/lang/String;

    move-result-object v0

    .line 88
    :cond_3
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 89
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v1

    .line 90
    .local v1, "builder":Landroid/net/Uri$Builder;
    const-string/jumbo v4, "return_url"

    const-string/jumbo v5, "amznapp://page?app-action=dismiss-all"

    invoke-virtual {v1, v4, v5}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 92
    const-class v4, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v5}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v5

    const/4 v6, -0x1

    invoke-static {p0, v4, v5, v6}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v2

    .line 94
    .local v2, "intent":Landroid/content/Intent;
    invoke-static {p3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 95
    invoke-virtual {p0, v2}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 100
    :goto_1
    sput-object p1, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->sPrimeUpsellSubscriber:Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;

    .line 101
    const/4 v3, 0x1

    .line 104
    invoke-static {p2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0

    .line 98
    :cond_4
    invoke-static {p0, v2, p3}, Lcom/amazon/mShop/splashscreen/StartupActivity;->startActivityForStartup(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)V

    goto :goto_1
.end method

.method private static showedPrimeUpsellTo(Lcom/amazon/mShop/model/auth/User;Z)V
    .locals 2
    .param p0, "user"    # Lcom/amazon/mShop/model/auth/User;
    .param p1, "encounteredError"    # Z

    .prologue
    .line 199
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 200
    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->getInstance()Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->showedPrimeTo(Ljava/lang/String;Z)V

    .line 203
    :cond_0
    return-void
.end method

.method private static userSignupPrime()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 251
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/model/auth/User;->isOneClick()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 252
    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->refreshUserInfo()V

    .line 261
    .local v0, "controller":Lcom/amazon/mShop/control/account/OneClickController;
    :goto_0
    return-void

    .line 256
    .end local v0    # "controller":Lcom/amazon/mShop/control/account/OneClickController;
    :cond_0
    new-instance v0, Lcom/amazon/mShop/control/account/OneClickController;

    new-instance v1, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeOneClickSubscriber;

    invoke-direct {v1, v2}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeOneClickSubscriber;-><init>(Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$1;)V

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController;-><init>(Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;)V

    .line 257
    .restart local v0    # "controller":Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDeviceName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController;->setDeviceName(Ljava/lang/String;)V

    .line 258
    const/4 v1, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/control/account/OneClickController;->doSetOneClickEnabled(ZLcom/amazon/mShop/control/TaskCallback;)V

    goto :goto_0
.end method
