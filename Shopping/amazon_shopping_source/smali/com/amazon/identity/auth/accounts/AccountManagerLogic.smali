.class public Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
.super Ljava/lang/Object;
.source "AccountManagerLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/AccountManagerDefinition;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/AccountManagerLogic$9;
    }
.end annotation


# static fields
.field private static final ACCOUNT_AUTHENTICATOR_QUEUE:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;

.field private static final TAG:Ljava/lang/String;

.field private static sTheOneAndTheOnly:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;


# instance fields
.field private final mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private final mAuthenticator:Lcom/amazon/identity/auth/accounts/AccountAuthenticator;

.field private final mContext:Landroid/content/Context;

.field private final mCookieDataStore:Lcom/amazon/identity/auth/device/storage/CookieDataStore;

.field private final mCorPfmLogic:Lcom/amazon/identity/auth/attributes/CorPfmLogic;

.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

.field private final mDelegatedAccountHelper:Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

.field private final mDeregisterAccount:Lcom/amazon/identity/auth/accounts/DeregisterAccount;

.field private final mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

.field private final mMultipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

.field private final mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

.field private final mRegisterChildApplicationAction:Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;

.field private final mRegistrar:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

.field private final mRegistrarAuthenticator:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

.field private final mRegistry:Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;

.field private final mRenameDevice:Lcom/amazon/identity/auth/accounts/RenameDevice;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 90
    const-class v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    .line 92
    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;

    invoke-direct {v0}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->ACCOUNT_AUTHENTICATOR_QUEUE:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V
    .locals 19
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .prologue
    .line 123
    new-instance v4, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;

    move-object/from16 v0, p1

    invoke-direct {v4, v0}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;-><init>(Landroid/content/Context;)V

    new-instance v5, Lcom/amazon/identity/auth/accounts/DeregisterAccount;

    move-object/from16 v0, p1

    invoke-direct {v5, v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;-><init>(Landroid/content/Context;)V

    new-instance v6, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;

    move-object/from16 v0, p1

    invoke-direct {v6, v0}, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;-><init>(Landroid/content/Context;)V

    new-instance v7, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;

    move-object/from16 v0, p1

    invoke-direct {v7, v0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;-><init>(Landroid/content/Context;)V

    new-instance v8, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    move-object/from16 v0, p1

    invoke-direct {v8, v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;-><init>(Landroid/content/Context;)V

    new-instance v9, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    move-object/from16 v0, p1

    invoke-direct {v9, v0}, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;-><init>(Landroid/content/Context;)V

    new-instance v10, Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    move-object/from16 v0, p1

    invoke-direct {v10, v0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;-><init>(Landroid/content/Context;)V

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v11

    invoke-static/range {p1 .. p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    move-result-object v12

    invoke-static/range {p1 .. p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;->getMultipleAccountPlugin(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    move-result-object v13

    invoke-static/range {p1 .. p1}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/attributes/CorPfmLogic;

    move-result-object v14

    new-instance v15, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    invoke-direct {v15}, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;-><init>()V

    new-instance v16, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    move-object/from16 v0, v16

    move-object/from16 v1, p1

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;-><init>(Landroid/content/Context;)V

    new-instance v2, Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;

    move-object/from16 v0, p1

    invoke-direct {v2, v0}, Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;->getDataStore()Lcom/amazon/identity/auth/device/storage/CookieDataStore;

    move-result-object v17

    new-instance v18, Lcom/amazon/identity/auth/accounts/RenameDevice;

    move-object/from16 v0, v18

    move-object/from16 v1, p1

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/accounts/RenameDevice;-><init>(Landroid/content/Context;)V

    move-object/from16 v2, p0

    move-object/from16 v3, p1

    invoke-direct/range {v2 .. v18}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AccountAuthenticator;Lcom/amazon/identity/auth/accounts/DeregisterAccount;Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/device/storage/DataStorage;Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;Lcom/amazon/identity/auth/attributes/CorPfmLogic;Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;Lcom/amazon/identity/auth/device/token/OAuthTokenManager;Lcom/amazon/identity/auth/device/storage/CookieDataStore;Lcom/amazon/identity/auth/accounts/RenameDevice;)V

    .line 139
    return-void
.end method

.method constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/accounts/AccountAuthenticator;Lcom/amazon/identity/auth/accounts/DeregisterAccount;Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/device/storage/DataStorage;Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;Lcom/amazon/identity/auth/attributes/CorPfmLogic;Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;Lcom/amazon/identity/auth/device/token/OAuthTokenManager;Lcom/amazon/identity/auth/device/storage/CookieDataStore;Lcom/amazon/identity/auth/accounts/RenameDevice;)V
    .locals 1
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .param p2, "authenticator"    # Lcom/amazon/identity/auth/accounts/AccountAuthenticator;
    .param p3, "deregisterAccount"    # Lcom/amazon/identity/auth/accounts/DeregisterAccount;
    .param p4, "registerChildApplicationAction"    # Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;
    .param p5, "subAuthenticatorRegistry"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;
    .param p6, "amazonAccountManager"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
    .param p7, "accountRegistrarAuthenticator"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .param p8, "accountRegistrar"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar;
    .param p9, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;
    .param p10, "multipleAccountsLogic"    # Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
    .param p11, "multipleAccountPlugin"    # Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;
    .param p12, "corPfmLogic"    # Lcom/amazon/identity/auth/attributes/CorPfmLogic;
    .param p13, "delegatedAccountHelper"    # Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;
    .param p14, "oAuthTokenManager"    # Lcom/amazon/identity/auth/device/token/OAuthTokenManager;
    .param p15, "cookieDataStore"    # Lcom/amazon/identity/auth/device/storage/CookieDataStore;
    .param p16, "renameDevice"    # Lcom/amazon/identity/auth/accounts/RenameDevice;

    .prologue
    .line 157
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 158
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    .line 159
    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mDeregisterAccount:Lcom/amazon/identity/auth/accounts/DeregisterAccount;

    .line 160
    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mRegisterChildApplicationAction:Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;

    .line 161
    iput-object p5, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mRegistry:Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;

    .line 162
    iput-object p6, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 164
    iput-object p7, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mRegistrarAuthenticator:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    .line 165
    iput-object p8, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mRegistrar:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    .line 167
    iput-object p9, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 169
    iput-object p10, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    .line 170
    iput-object p11, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    .line 171
    iput-object p12, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mCorPfmLogic:Lcom/amazon/identity/auth/attributes/CorPfmLogic;

    .line 172
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAuthenticator:Lcom/amazon/identity/auth/accounts/AccountAuthenticator;

    .line 173
    iput-object p13, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mDelegatedAccountHelper:Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    .line 175
    iput-object p14, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    .line 176
    move-object/from16 v0, p15

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mCookieDataStore:Lcom/amazon/identity/auth/device/storage/CookieDataStore;

    .line 178
    move-object/from16 v0, p16

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mRenameDevice:Lcom/amazon/identity/auth/accounts/RenameDevice;

    .line 179
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Landroid/os/Bundle;

    .prologue
    .line 88
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->updateAccountCredentials(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Ljava/lang/String;

    .prologue
    .line 88
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "The central device email is missing. Please check that the capability EMAIL_ALIAS_SUPPORTED is defined for the following device type in DMS: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v0, "CentralDeviceEmailIsMissing"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    invoke-static {v0, p2, p1}, Lcom/amazon/identity/auth/attributes/UserProperties;->sendDeviceEmailChangedNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    return-void
.end method

.method static synthetic access$1200(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;
    .locals 9
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p3, "x3"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 88
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Starting Deregistration"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountWithDirectedId(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v4

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->isAPrimaryAccount(Ljava/lang/String;)Z

    move-result v2

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getListOfProfilesWhereTheAccountIsPrimary(Landroid/content/Context;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v5

    iget-object v7, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mDeregisterAccount:Lcom/amazon/identity/auth/accounts/DeregisterAccount;

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mRegistry:Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->getSubAuthenticators()Ljava/util/List;

    move-result-object v8

    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;

    move-object v1, p0

    move-object v3, p1

    move-object v6, p2

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;-><init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;ZLjava/lang/String;Landroid/accounts/Account;Ljava/util/Set;Lcom/amazon/identity/auth/device/api/Callback;)V

    invoke-virtual {v7, v8, v0, p1, p3}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->startDeregister(Ljava/util/List;Lcom/amazon/identity/auth/accounts/DeregisterAccount$IDeregisterAccount;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    const/4 v0, 0x0

    return-object v0
.end method

.method static synthetic access$1300(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 88
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->callbackDeregisterCommon(Lcom/amazon/identity/auth/device/api/Callback;Z)V

    return-void
.end method

.method static synthetic access$1400(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Lcom/amazon/identity/auth/accounts/RenameDevice;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mRenameDevice:Lcom/amazon/identity/auth/accounts/RenameDevice;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Lcom/amazon/identity/auth/device/storage/DataStorage;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Lcom/amazon/identity/auth/accounts/AccountAuthenticator;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAuthenticator:Lcom/amazon/identity/auth/accounts/AccountAuthenticator;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;
    .locals 7
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/api/RegistrationType;
    .param p2, "x2"    # Landroid/os/Bundle;
    .param p3, "x3"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p4, "x4"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v6, 0x0

    .line 88
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Starting Registration: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$4;-><init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getDevicePrimaryAmazonAccount()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    sget-object v2, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_DEVICE_SECRET:Lcom/amazon/identity/auth/device/api/RegistrationType;

    if-ne p1, v2, :cond_0

    sget-object v1, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Already registered. Returning success for register via device secret"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    invoke-static {v2, v0, v1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->addAccountManagerSuccessInformation(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    invoke-interface {p3, v1}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    :goto_0
    return-object v6

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mRegistrar:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mRegistrarAuthenticator:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    move-object v2, p1

    move-object v3, p2

    move-object v5, p4

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->register(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0
.end method

.method static synthetic access$500(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 17
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/api/RegistrationType;
    .param p2, "x2"    # Landroid/os/Bundle;
    .param p3, "x3"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p4, "x4"    # Ljava/lang/String;
    .param p5, "x5"    # Ljava/lang/String;
    .param p6, "x6"    # Landroid/os/Bundle;

    .prologue
    .line 88
    if-nez p6, :cond_0

    sget-object v3, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "No userdata returned. The account cannot be created."

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v3, 0x7

    const-string/jumbo v4, "No userdata given. Cannot construct an account"

    move-object/from16 v0, p3

    invoke-static {v0, v3, v4}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onAccountManagerError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    new-instance v10, Landroid/os/Bundle;

    invoke-direct {v10}, Landroid/os/Bundle;-><init>()V

    const-string/jumbo v3, "com.amazon.dcp.sso.property.account.acctId"

    move-object/from16 v0, p6

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v3, v5}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExistAfterDeregisteringStateCleanup(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    const/4 v3, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p6

    invoke-direct {v0, v5, v3, v1}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->updateAccountCredentials(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    sget-object v3, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "An account has been registered multiple times!"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, p3

    invoke-static {v0, v5}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onAccountAlreadyExistsError(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->hasDevicePrimaryAmazonAccount()Z

    move-result v3

    if-eqz v3, :cond_2

    const-string/jumbo v3, "com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"

    move-object/from16 v0, p2

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    const-string/jumbo v3, "com.amazon.dcp.sso.property.secondary"

    const-string/jumbo v4, "true"

    move-object/from16 v0, p6

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getSessionUsers()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_3

    const-string/jumbo v3, "com.amazon.dcp.sso.property.sessionuser"

    const-string/jumbo v4, "true"

    move-object/from16 v0, p6

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_3
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    move-object/from16 v0, p2

    move-object/from16 v1, p6

    invoke-interface {v3, v5, v0, v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;->addDataOnAddAccount(Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)V

    new-instance v11, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-direct {v11, v3, v4}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/DataStorage;)V

    move-object/from16 v0, p0

    move-object/from16 v1, p6

    move-object/from16 v2, p2

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->addNeccesaryUserdata(Landroid/os/Bundle;Landroid/os/Bundle;)V

    sget-object v3, Lcom/amazon/identity/auth/device/api/RegistrationType;->REGISTER_DELEGATED_ACCOUNT:Lcom/amazon/identity/auth/device/api/RegistrationType;

    move-object/from16 v0, p1

    if-ne v0, v3, :cond_4

    const-string/jumbo v3, "com.amazon.dcp.sso.property.account.delegateeaccount"

    move-object/from16 v0, p2

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "com.amazon.dcp.sso.property.account.delegateeaccount"

    move-object/from16 v0, p6

    invoke-virtual {v0, v4, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mDelegatedAccountHelper:Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    move-object/from16 v0, p2

    invoke-virtual {v3, v0}, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;->getDelegationDomainFromAPIBundle(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_4

    const-string/jumbo v4, "com.amazon.dcp.sso.property.account.delegationDomain"

    move-object/from16 v0, p6

    invoke-virtual {v0, v4, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_4
    const/4 v4, 0x0

    const/4 v3, 0x0

    const-string/jumbo v6, "com.amazon.dcp.sso.property.account.customer_region"

    move-object/from16 v0, p6

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_5

    invoke-static {v6}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getAuthPortalDomainBasedOnCustomerRegion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v3, "customer region (home region)"

    :cond_5
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_6

    const-string/jumbo v6, "com.amazon.dcp.sso.token.device.accountpool"

    move-object/from16 v0, p6

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_6

    invoke-static {v6}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getAuthPortalDomainBasedOnAccountPool(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v3, "account pool"

    :cond_6
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_7

    invoke-static {v4}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getCompleteAuthPortalDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    sget-object v6, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Marking the amazon domain for added account: %s. It\'s generated base on %s."

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object v4, v8, v9

    const/4 v9, 0x1

    aput-object v3, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v6, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v3, "authDomain"

    move-object/from16 v0, p6

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_7
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-object/from16 v0, p5

    invoke-static {v3, v0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getUniqueAccountName(Lcom/amazon/identity/auth/device/storage/DataStorage;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    const-string/jumbo v3, "com.amazon.dcp.sso.property.account.cor"

    move-object/from16 v0, p6

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v3, "com.amazon.dcp.sso.property.account.sourceofcor"

    move-object/from16 v0, p6

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v3, "com.amazon.dcp.sso.property.account.pfm"

    move-object/from16 v0, p6

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const-string/jumbo v3, "com.amazon.dcp.sso.property.account.cor"

    move-object/from16 v0, p6

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    const-string/jumbo v3, "com.amazon.dcp.sso.property.account.sourceofcor"

    move-object/from16 v0, p6

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    const-string/jumbo v3, "com.amazon.dcp.sso.property.account.pfm"

    move-object/from16 v0, p6

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    invoke-static {v4, v6, v7}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->isValidCorPfmFromDCAS(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_a

    sget-object v3, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Registering account did not return cor/pfm."

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v3, 0x0

    :goto_1
    const-string/jumbo v4, "com.amazon.dcp.sso.token.device.credentialsmap"

    move-object/from16 v0, p6

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/identity/kcpsdk/auth/CredentialMapSerializer;->toMap(Ljava/lang/String;)Ljava/util/Map;

    move-result-object v4

    const-string/jumbo v6, "com.amazon.dcp.sso.token.device.credentialsmap"

    move-object/from16 v0, p6

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    if-nez v4, :cond_8

    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v4

    :cond_8
    move-object/from16 v0, p0

    move-object/from16 v1, p6

    invoke-direct {v0, v5, v1}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->getCookiesAndRemove(Ljava/lang/String;Landroid/os/Bundle;)Ljava/util/List;

    move-result-object v13

    const-string/jumbo v6, "com.amazon.dcp.sso.token.oauth.amazon.access_token"

    move-object/from16 v0, p6

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    new-instance v14, Landroid/os/Bundle;

    invoke-direct {v14}, Landroid/os/Bundle;-><init>()V

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_9

    const-string/jumbo v7, "com.amazon.dcp.sso.token.oauth.amazon.access_token"

    invoke-virtual {v14, v7, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v6, "com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at"

    const-string/jumbo v7, "com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at"

    move-object/from16 v0, p6

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v6, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"

    const-string/jumbo v7, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"

    move-object/from16 v0, p6

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v14, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_9
    const-string/jumbo v6, "com.amazon.dcp.sso.token.oauth.amazon.access_token"

    move-object/from16 v0, p6

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    const-string/jumbo v6, "com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at"

    move-object/from16 v0, p6

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    const-string/jumbo v6, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"

    move-object/from16 v0, p6

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    const-string/jumbo v6, "com.amazon.dcp.sso.property.deviceemail"

    move-object/from16 v0, p6

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const-string/jumbo v6, "com.amazon.dcp.sso.token.devicedevicetype"

    move-object/from16 v0, p6

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    invoke-virtual {v14}, Landroid/os/Bundle;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_b

    invoke-static/range {p2 .. p2}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getPartialAmazonDomainFromAPIBundle(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getCompleteCookieDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    invoke-virtual {v15, v14}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getTokenMapFromRegistrationData(Landroid/os/Bundle;)Ljava/util/Map;

    move-result-object v14

    invoke-interface {v9, v14}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    invoke-static {v13, v9}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->updateTheSidInStorageAndRemoveTheSidCookieInCookiesIfNecessary(Ljava/util/List;Ljava/util/Map;)V

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mCookieDataStore:Lcom/amazon/identity/auth/device/storage/CookieDataStore;

    invoke-virtual {v14, v5, v13, v6}, Lcom/amazon/identity/auth/device/storage/CookieDataStore;->getCookieTokenMapOrWriteToDataStoreFromRegistrationData(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Ljava/util/Map;

    move-result-object v13

    invoke-interface {v9, v13}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    move-object/from16 v16, v6

    move-object v6, v9

    move-object/from16 v9, v16

    :goto_2
    invoke-static/range {p6 .. p6}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->toStringStringMap(Landroid/os/Bundle;)Ljava/util/Map;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mCorPfmLogic:Lcom/amazon/identity/auth/attributes/CorPfmLogic;

    invoke-virtual {v14, v3, v13}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->setInitialCORPFM(Lcom/amazon/identity/auth/attributes/CORPFMResponse;Ljava/util/Map;)V

    new-instance v14, Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    invoke-direct {v14, v5, v13, v6}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;-><init>(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_3
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_c

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map;

    invoke-static {v13, v14, v4, v3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->populateChildApplicationTokensWithoutRegister(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_3

    :cond_a
    sget-object v3, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Using COR/SourceOfCor/PFM/ returned when registering the account: %s, %s, %s"

    const/4 v9, 0x3

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v13, 0x0

    aput-object v4, v9, v13

    const/4 v13, 0x1

    aput-object v6, v9, v13

    const/4 v13, 0x2

    aput-object v7, v9, v13

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v3, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v3, Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    invoke-direct {v3, v4, v7, v6}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    :cond_b
    const/4 v6, 0x0

    move-object/from16 v16, v6

    move-object v6, v9

    move-object/from16 v9, v16

    goto :goto_2

    :cond_c
    new-instance v3, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;

    move-object/from16 v4, p0

    move-object/from16 v6, p6

    invoke-direct/range {v3 .. v8}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;-><init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v11, v12, v14, v3}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)Z

    move-result v3

    if-nez v3, :cond_d

    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ACCOUNT_ALREADY_EXISTS:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v4, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-direct {v0, v3, v1, v4}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->onRegistrationError(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V

    goto/16 :goto_0

    :cond_d
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->invalidateCache()V

    invoke-static {v12, v5, v10}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->addAccountManagerSuccessInformation(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    if-eqz v9, :cond_e

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mCookieDataStore:Lcom/amazon/identity/auth/device/storage/CookieDataStore;

    invoke-virtual {v3, v9}, Lcom/amazon/identity/auth/device/storage/CookieDataStore;->getNonAuthCookies(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/identity/auth/device/utils/CollectionUtils;->isEmpty(Ljava/util/Collection;)Z

    move-result v3

    if-nez v3, :cond_e

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mCookieDataStore:Lcom/amazon/identity/auth/device/storage/CookieDataStore;

    const/4 v4, 0x0

    invoke-virtual {v3, v9, v4}, Lcom/amazon/identity/auth/device/storage/CookieDataStore;->setNonAuthCookies(Ljava/lang/String;Ljava/util/List;)V

    :cond_e
    sget-object v3, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "MAP finished adding account locally and will do the other necessary work asynchronously in the data propogation callback"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, p3

    invoke-interface {v0, v10}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    goto/16 :goto_0
.end method

.method static synthetic access$600(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .param p2, "x2"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p3, "x3"    # Landroid/os/Bundle;

    .prologue
    .line 88
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->onRegistrationError(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V

    return-void
.end method

.method static synthetic access$700()Ljava/lang/String;
    .locals 1

    .prologue
    .line 88
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    return-object v0
.end method

.method static synthetic access$900(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    return-object v0
.end method

.method private addNeccesaryUserdata(Landroid/os/Bundle;Landroid/os/Bundle;)V
    .locals 4
    .param p1, "userdata"    # Landroid/os/Bundle;
    .param p2, "options"    # Landroid/os/Bundle;

    .prologue
    .line 1211
    const-string/jumbo v2, "com.amazon.dcp.sso.property.account.UUID"

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1216
    invoke-virtual {p2}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 1218
    .local v1, "key":Ljava/lang/String;
    const-string/jumbo v2, "com.amazon.dcp.sso.property.account.extratokens"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1220
    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 1223
    .end local v1    # "key":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method private callbackDeregisterCommon(Lcom/amazon/identity/auth/device/api/Callback;Z)V
    .locals 2
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "success"    # Z

    .prologue
    .line 1333
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 1334
    .local v0, "result":Landroid/os/Bundle;
    const-string/jumbo v1, "booleanResult"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1335
    invoke-interface {p1, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    .line 1336
    return-void
.end method

.method private confirmCredentialInternal(Landroid/app/Activity;Ljava/lang/String;ZLandroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 8
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "requireRegistration"    # Z
    .param p4, "options"    # Landroid/os/Bundle;
    .param p5, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p6, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 625
    if-eqz p4, :cond_0

    move-object v0, p4

    .line 627
    .local v0, "ccOptions":Landroid/os/Bundle;
    :goto_0
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->sanitizeSerializableOptions(Landroid/os/Bundle;)V

    .line 629
    sget-object v2, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Confirm Credential called with options: %s."

    new-array v4, v7, [Ljava/lang/Object;

    invoke-virtual {v0}, Landroid/os/Bundle;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v2, v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 631
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 633
    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v3, "Cannot confirm credential given empty directedId."

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    invoke-interface {p5, v2}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 663
    :goto_1
    return-void

    .line 625
    .end local v0    # "ccOptions":Landroid/os/Bundle;
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    goto :goto_0

    .line 638
    .restart local v0    # "ccOptions":Landroid/os/Bundle;
    :cond_1
    if-eqz p3, :cond_2

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v2, p2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 640
    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->CUSTOMER_NOT_FOUND:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    const-string/jumbo v3, "Customer %s is not registered."

    new-array v4, v7, [Ljava/lang/Object;

    aput-object p2, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    invoke-interface {p5, v2}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_1

    .line 646
    :cond_2
    const-string/jumbo v2, "requestType"

    sget-object v3, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->CONFIRM_CREDENTIAL:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 647
    const-string/jumbo v2, "directedid"

    invoke-virtual {v0, v2, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 648
    invoke-direct {p0, v0, p5, p6}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->signInOrCreateAccountWithWebView(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    move-result-object v1

    .line 650
    .local v1, "result":Landroid/os/Bundle;
    if-eqz v1, :cond_3

    if-eqz p1, :cond_3

    .line 652
    invoke-direct {p0, p1, v1, p5}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->startIntentForActivity(Landroid/app/Activity;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    goto :goto_1

    .line 654
    :cond_3
    if-eqz v1, :cond_4

    .line 656
    invoke-static {p5, v1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->resultToSuccessOrError(Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V

    goto :goto_1

    .line 660
    :cond_4
    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v3, "Could not find a sign in UI. This more than likely represents a bug."

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    invoke-interface {p5, v2}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_1
.end method

.method private getCookiesAndRemove(Ljava/lang/String;Landroid/os/Bundle;)Ljava/util/List;
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "userData"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            ")",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1094
    const-string/jumbo v5, "website_cookies_json_array"

    invoke-virtual {p2, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 1095
    .local v3, "cookiesJSONArrayStr":Ljava/lang/String;
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 1099
    .local v0, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    :try_start_0
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2, v3}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1108
    .local v2, "cookiesJSONArray":Lorg/json/JSONArray;
    :try_start_1
    new-instance v5, Lcom/amazon/identity/auth/device/token/MAPCookieManager;

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    invoke-direct {v5, v6}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;-><init>(Landroid/content/Context;)V

    invoke-virtual {v5, p1, v2}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->parseJSONArrayCookies(Ljava/lang/String;Lorg/json/JSONArray;)Ljava/util/List;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    .line 1115
    :goto_0
    const-string/jumbo v5, "website_cookies_json_array"

    invoke-virtual {p2, v5}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    move-object v1, v0

    .line 1116
    .end local v0    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    .end local v2    # "cookiesJSONArray":Lorg/json/JSONArray;
    .local v1, "cookies":Ljava/lang/Object;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    :goto_1
    return-object v1

    .line 1101
    .end local v1    # "cookies":Ljava/lang/Object;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    .restart local v0    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    :catch_0
    move-exception v4

    .line 1103
    .local v4, "e":Lorg/json/JSONException;
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "String to JSONArray Conversion failed : "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, v0

    .line 1104
    .restart local v1    # "cookies":Ljava/lang/Object;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    goto :goto_1

    .line 1110
    .end local v1    # "cookies":Ljava/lang/Object;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    .end local v4    # "e":Lorg/json/JSONException;
    .restart local v2    # "cookiesJSONArray":Lorg/json/JSONArray;
    :catch_1
    move-exception v4

    .line 1112
    .restart local v4    # "e":Lorg/json/JSONException;
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "Failed to parse the cookie JSONArray : "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 183
    const-class v1, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 185
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V

    sput-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    .line 189
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 183
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private handleIntent(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/lang/String;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p3, "result"    # Landroid/os/Bundle;
    .param p4, "uiNotFoundErrorMessage"    # Ljava/lang/String;

    .prologue
    .line 283
    if-eqz p3, :cond_0

    if-eqz p1, :cond_0

    .line 285
    invoke-direct {p0, p1, p3, p2}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->startIntentForActivity(Landroid/app/Activity;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 296
    :goto_0
    return-void

    .line 287
    :cond_0
    if-eqz p3, :cond_1

    .line 289
    invoke-static {p2, p3}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->resultToSuccessOrError(Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V

    goto :goto_0

    .line 293
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UI_NOT_FOUND:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-static {v0, p4}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method private onRegistrationError(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V
    .locals 2
    .param p1, "error"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p3, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 1430
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v0

    const/4 v1, 0x0

    invoke-static {p2, v0, v1, p3}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;Landroid/os/Bundle;)V

    .line 1431
    return-void
.end method

.method private registerWithMyAccount(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Landroid/os/Bundle;
    .locals 8
    .param p1, "options"    # Landroid/os/Bundle;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    const/4 v6, 0x0

    const/4 v3, 0x0

    .line 330
    sget-object v2, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Register with My Account"

    invoke-static {v2, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 333
    const-string/jumbo v2, "com.amazon.dcp.sso.AddAccount"

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    invoke-static {v4}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v4

    const-string/jumbo v5, "default.to.register.client"

    invoke-virtual {v4, v5, v6}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingBoolean(Ljava/lang/String;Z)Z

    move-result v4

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    new-instance v2, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    invoke-direct {v2, v5}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2, v0, v6}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    move-object v2, v3

    :cond_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/content/pm/ResolveInfo;

    iget-object v2, v2, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    const-string/jumbo v6, "com.amazon.registerclient"

    iget-object v7, v2, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v4, :cond_1

    if-eqz v6, :cond_2

    :cond_1
    if-eqz v4, :cond_0

    if-eqz v6, :cond_0

    :cond_2
    if-nez v2, :cond_3

    move-object v0, v3

    .line 334
    .local v0, "intent":Landroid/content/Intent;
    :goto_0
    if-nez v0, :cond_4

    .line 354
    :goto_1
    return-object v3

    .line 333
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_3
    new-instance v4, Landroid/content/ComponentName;

    iget-object v5, v2, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    iget-object v2, v2, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-direct {v4, v5, v2}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v4}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    goto :goto_0

    .line 339
    .restart local v0    # "intent":Landroid/content/Intent;
    :cond_4
    invoke-virtual {v0, p1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 342
    const-string/jumbo v2, "accountAuthenticatorResponse"

    invoke-static {p2}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseHelper;->createCallbackToAccountAuthenticatorResponseAdapter(Lcom/amazon/identity/auth/device/api/Callback;)Landroid/accounts/AccountAuthenticatorResponse;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 344
    const-string/jumbo v2, "com.amazon.dcp.sso.addAccountParameters.authTokenType"

    const-string/jumbo v3, "com.amazon.dcp.sso.addAccountParameters.authTokenType"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 346
    const-string/jumbo v2, "com.amazon.dcp.sso.addAccountParameters.requiredFeatures"

    const-string/jumbo v3, "com.amazon.dcp.sso.addAccountParameters.requiredFeatures"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 348
    const-string/jumbo v2, "com.amazon.dcp.sso.addAccountParameters.options"

    const-string/jumbo v3, "com.amazon.dcp.sso.addAccountParameters.options"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 350
    const-string/jumbo v2, "com.amazon.dcp.sso.addAccountParameters.caller"

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 352
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 353
    .local v1, "result":Landroid/os/Bundle;
    const-string/jumbo v2, "intent"

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    move-object v3, v1

    .line 354
    goto :goto_1
.end method

.method private scheduleDeregister(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v2, 0x0

    const/4 v3, 0x0

    .line 1232
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Deregister initiated"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1234
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v0

    const-string/jumbo v1, "ignore.deregister"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1236
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Ignoring deregister based on DCP settings"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1237
    invoke-direct {p0, p2, v2}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->callbackDeregisterCommon(Lcom/amazon/identity/auth/device/api/Callback;Z)V

    .line 1258
    :goto_0
    return-object v3

    .line 1241
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1243
    const/4 v0, 0x1

    invoke-direct {p0, p2, v0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->callbackDeregisterCommon(Lcom/amazon/identity/auth/device/api/Callback;Z)V

    goto :goto_0

    .line 1247
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->ACCOUNT_AUTHENTICATOR_QUEUE:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;

    new-instance v1, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$6;

    invoke-direct {v1, p0, p1, p3}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$6;-><init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    const-string/jumbo v2, "DeregisterAccount"

    invoke-virtual {v0, v1, p2, v2}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;->addAccountAuthenticatorTask(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private signInOrCreateAccountWithWebView(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;
    .locals 5
    .param p1, "regOptions"    # Landroid/os/Bundle;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 407
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    const/4 v3, 0x0

    const-class v4, Lcom/amazon/identity/auth/device/AuthPortalUIActivity;

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v3, v4}, Lcom/amazon/identity/auth/device/utils/IntentHelpers;->getBestIntentForActivity(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 409
    .local v0, "intent":Landroid/content/Intent;
    if-eqz p3, :cond_0

    .line 411
    invoke-virtual {p3, v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->addToIntent(Landroid/content/Intent;)V

    .line 415
    :cond_0
    invoke-virtual {v0, p1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 419
    const-string/jumbo v2, "requestType"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 421
    const-string/jumbo v2, "requestType"

    sget-object v3, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->SIGN_IN:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 424
    :cond_1
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 425
    .local v1, "result":Landroid/os/Bundle;
    const-string/jumbo v2, "intent"

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 426
    const-string/jumbo v2, "callback"

    new-instance v3, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;

    invoke-direct {v3, p2}, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 427
    const-string/jumbo v2, "result code"

    const/16 v3, 0x64

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 429
    return-object v1
.end method

.method private startIntentForActivity(Landroid/app/Activity;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 5
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "result"    # Landroid/os/Bundle;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 300
    const-string/jumbo v3, "intent"

    invoke-virtual {p2, v3}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/content/Intent;

    .line 301
    .local v1, "intent":Landroid/content/Intent;
    const-string/jumbo v3, "intent"

    invoke-virtual {p2, v3}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 302
    if-nez v1, :cond_0

    .line 304
    const-string/jumbo v0, "Failed to locate an activity containing the sign-in UI"

    .line 305
    .local v0, "errorMessage":Ljava/lang/String;
    sget-object v3, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    invoke-static {v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 306
    const/4 v3, 0x6

    invoke-static {p3, v3, v0}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onAccountManagerError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 326
    .end local v0    # "errorMessage":Ljava/lang/String;
    :goto_0
    return-void

    .line 312
    :cond_0
    const-string/jumbo v3, "result code"

    invoke-virtual {p2, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    const-string/jumbo v3, "result code"

    const/4 v4, 0x0

    invoke-virtual {p2, v3, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    .line 315
    .local v2, "resultCode":Ljava/lang/Integer;
    :goto_1
    const-string/jumbo v3, "result code"

    invoke-virtual {p2, v3}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 318
    if-eqz v2, :cond_2

    .line 320
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-virtual {p1, v1, v3}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    .line 312
    .end local v2    # "resultCode":Ljava/lang/Integer;
    :cond_1
    const/4 v2, 0x0

    goto :goto_1

    .line 324
    .restart local v2    # "resultCode":Ljava/lang/Integer;
    :cond_2
    invoke-virtual {p1, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method private updateAccountCredentials(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 10
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 1343
    if-nez p3, :cond_1

    .line 1394
    :cond_0
    :goto_0
    return-void

    .line 1348
    :cond_1
    new-instance v0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    iget-object v8, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    iget-object v9, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-direct {v0, v8, v9}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/DataStorage;)V

    .line 1351
    .local v0, "backwardsCompatiableDataStorage":Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;
    const-string/jumbo v8, "com.amazon.dcp.sso.property.devicename"

    invoke-virtual {v0, p1, v8}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 1353
    .local v7, "oldDeviceName":Ljava/lang/String;
    const-string/jumbo v8, "com.amazon.dcp.sso.property.deviceemail"

    invoke-virtual {v0, p1, v8}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 1356
    .local v6, "oldDeviceEmail":Ljava/lang/String;
    if-nez p2, :cond_2

    .line 1358
    invoke-virtual {p3}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 1360
    .local v2, "key":Ljava/lang/String;
    invoke-virtual {p3, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0, p1, v2, v8}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 1365
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "key":Ljava/lang/String;
    :cond_2
    new-instance v3, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    iget-object v8, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    invoke-direct {v3, v8, v0}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/DataStorage;)V

    .line 1368
    .local v3, "localAppDataAwareDataStorage":Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;
    invoke-virtual {p3}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .restart local v1    # "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 1370
    .restart local v2    # "key":Ljava/lang/String;
    invoke-static {p2, v2}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p3, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v3, p1, v8, v9}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 1376
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "localAppDataAwareDataStorage":Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;
    :cond_3
    const-string/jumbo v8, "com.amazon.dcp.sso.property.devicename"

    invoke-virtual {v0, p1, v8}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 1378
    .local v5, "newDeviceName":Ljava/lang/String;
    const-string/jumbo v8, "com.amazon.dcp.sso.property.deviceemail"

    invoke-virtual {v0, p1, v8}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 1381
    .local v4, "newDeviceEmail":Ljava/lang/String;
    invoke-static {v7, v5}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_4

    iget-object v8, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    invoke-static {v8, p2}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->isPackageUsingCentralDeviceType(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 1384
    sget-object v8, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    .line 1385
    iget-object v8, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    invoke-static {v8, p1, v5}, Lcom/amazon/identity/auth/attributes/UserProperties;->storeDeviceName(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    .line 1388
    :cond_4
    invoke-static {v6, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_0

    iget-object v8, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    const-string/jumbo v9, "com.amazon.kindle"

    invoke-static {v8, p2, v9}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->arePackagesUsingTheSameDeviceType(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 1391
    sget-object v8, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    .line 1392
    iget-object v8, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;

    invoke-static {v8, p1, v4}, Lcom/amazon/identity/auth/attributes/UserProperties;->sendDeviceEmailChangedNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    goto/16 :goto_0
.end method


# virtual methods
.method public authenticateAccount(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 2
    .param p1, "authData"    # Landroid/os/Bundle;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 668
    if-eqz p1, :cond_1

    const-string/jumbo v0, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "authAccount"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const-string/jumbo v0, "password"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 672
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "A login/directedId and password are required to authenticate/confirmCredential."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 694
    :goto_0
    return-void

    .line 677
    :cond_2
    const-string/jumbo v0, "authAccount"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string/jumbo v0, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 680
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const-string/jumbo v1, "Cannot pass in both login and directedId to authenticateAccount API."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0

    .line 685
    :cond_3
    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$2;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$2;-><init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public authenticateAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 9
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "option"    # Lcom/amazon/identity/auth/device/api/SigninOption;
    .param p3, "regOptions"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v3, 0x0

    .line 703
    const-string/jumbo v0, "option"

    invoke-static {p2, v0}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 704
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "authenticateAccountWithUI SigninOption:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/api/SigninOption;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 706
    if-eqz p3, :cond_0

    move-object v7, p3

    .line 707
    .local v7, "nonNullRegOptions":Landroid/os/Bundle;
    :goto_0
    invoke-static {v7}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->sanitizeSerializableOptions(Landroid/os/Bundle;)V

    .line 708
    const/4 v8, 0x0

    .line 709
    .local v8, "result":Landroid/os/Bundle;
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$9;->$SwitchMap$com$amazon$identity$auth$device$api$SigninOption:[I

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/api/SigninOption;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 727
    :pswitch_0
    const/4 v0, 0x7

    const-string/jumbo v1, "Signin Options %s is not supported"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/api/SigninOption;->name()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p4, v0, v1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onAccountManagerError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 734
    :goto_1
    const-string/jumbo v0, "Could not find the sign in UI. This more than likely represents a bug."

    invoke-direct {p0, p1, p4, v8, v0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->handleIntent(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/lang/String;)V

    .line 738
    :goto_2
    return-void

    .line 706
    .end local v7    # "nonNullRegOptions":Landroid/os/Bundle;
    .end local v8    # "result":Landroid/os/Bundle;
    :cond_0
    new-instance v7, Landroid/os/Bundle;

    invoke-direct {v7}, Landroid/os/Bundle;-><init>()V

    goto :goto_0

    .line 712
    .restart local v7    # "nonNullRegOptions":Landroid/os/Bundle;
    .restart local v8    # "result":Landroid/os/Bundle;
    :pswitch_1
    const-string/jumbo v0, "requestType"

    sget-object v1, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->AUTHENTICATE:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 714
    invoke-direct {p0, v7, p4, p5}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->signInOrCreateAccountWithWebView(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    move-result-object v8

    .line 715
    goto :goto_1

    .line 718
    :pswitch_2
    const-string/jumbo v0, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object v0, p0

    move-object v1, p1

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->confirmCredentialInternal(Landroid/app/Activity;Ljava/lang/String;ZLandroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_2

    .line 709
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public confirmCredential(Landroid/app/Activity;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 7
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 612
    const/4 v3, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->confirmCredentialInternal(Landroid/app/Activity;Ljava/lang/String;ZLandroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 614
    return-void
.end method

.method public deregisterAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "innerCallback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 482
    sget-object v1, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "deregisterAccount logic called"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 484
    new-instance v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v0, p2}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 486
    .local v0, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    invoke-direct {p0, p1, v0, p3}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->scheduleDeregister(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    .line 488
    return-object v0
.end method

.method public deregisterDevice(Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 6
    .param p1, "innerCallback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 494
    sget-object v1, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "deregisterDevice logic called"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 496
    new-instance v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v0, p1}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 498
    .local v0, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->getAccounts()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    invoke-interface {v4, v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;->deregisterAllAccountsOnAccountRemoval(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-direct {p0, v1, v0, p2}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->scheduleDeregister(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    .line 500
    :goto_0
    return-object v0

    .line 498
    :cond_1
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    :try_start_0
    new-instance v3, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v3}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>()V

    invoke-direct {p0, v1, v3, p2}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->scheduleDeregister(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->get()Landroid/os/Bundle;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_2

    goto :goto_1

    :catch_0
    move-exception v1

    sget-object v3, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "MAP Error calling deregister. Error: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getErrorBundle()Landroid/os/Bundle;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->toString(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    :catch_1
    move-exception v1

    sget-object v3, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "InterruptedException calling deregister."

    invoke-static {v3, v4, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    :catch_2
    move-exception v1

    sget-object v3, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "ExecutionException calling deregister"

    invoke-static {v3, v4, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    :cond_2
    const/4 v1, 0x1

    invoke-direct {p0, v0, v1}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->callbackDeregisterCommon(Lcom/amazon/identity/auth/device/api/Callback;Z)V

    goto :goto_0
.end method

.method public getAccount(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 1466
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getCallingUserId()I

    move-result v0

    .line 1467
    .local v0, "callingUserId":I
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    invoke-interface {v2, p1, v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;->getAccountHierarchy(Ljava/lang/String;I)[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getAccounts()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1457
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getNonDeregisteringAmazonAccounts()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public getPrimaryAccount()Ljava/lang/String;
    .locals 5

    .prologue
    .line 1450
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getCallingUserId()I

    move-result v0

    .line 1451
    .local v0, "callingUserId":I
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    const/4 v2, 0x1

    new-array v2, v2, [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    const/4 v3, 0x0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;->createPrimaryMappingForProfile(I)Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public isAccountRegistered(Ljava/lang/String;)Z
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 1442
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->getAccounts()Ljava/util/Set;

    move-result-object v0

    .line 1444
    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isDeviceRegistered()Z
    .locals 1

    .prologue
    .line 1436
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->hasDevicePrimaryAmazonAccount()Z

    move-result v0

    return v0
.end method

.method public registerAccount(Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 3
    .param p1, "regType"    # Lcom/amazon/identity/auth/device/api/RegistrationType;
    .param p2, "regData"    # Landroid/os/Bundle;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p4, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 438
    const-string/jumbo v0, "RegistrationType"

    invoke-static {p1, v0}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 440
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "registerAccount:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/api/RegistrationType;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 442
    if-eqz p2, :cond_0

    .end local p2    # "regData":Landroid/os/Bundle;
    :goto_0
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->ACCOUNT_AUTHENTICATOR_QUEUE:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;

    new-instance v1, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$3;

    invoke-direct {v1, p0, p1, p2, p4}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$3;-><init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    const-string/jumbo v2, "AddAccount"

    invoke-virtual {v0, v1, p3, v2}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;->addAccountAuthenticatorTask(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    .line 443
    return-void

    .line 442
    .restart local p2    # "regData":Landroid/os/Bundle;
    :cond_0
    new-instance p2, Landroid/os/Bundle;

    .end local p2    # "regData":Landroid/os/Bundle;
    invoke-direct {p2}, Landroid/os/Bundle;-><init>()V

    goto :goto_0
.end method

.method public registerAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 7
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "option"    # Lcom/amazon/identity/auth/device/api/SigninOption;
    .param p3, "regOptions"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 199
    sget-object v2, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "registerAccountWithUI SigninOption:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/api/SigninOption;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 201
    if-eqz p3, :cond_0

    move-object v0, p3

    .line 203
    .local v0, "nonNullRegOptions":Landroid/os/Bundle;
    :goto_0
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->sanitizeSerializableOptions(Landroid/os/Bundle;)V

    .line 206
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->hasDevicePrimaryAmazonAccount()Z

    move-result v2

    if-eqz v2, :cond_1

    const-string/jumbo v2, "com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 209
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getDevicePrimaryAmazonAccount()Ljava/lang/String;

    move-result-object v2

    invoke-static {p4, v2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onAccountAlreadyExistsError(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    .line 268
    :goto_1
    return-void

    .line 201
    .end local v0    # "nonNullRegOptions":Landroid/os/Bundle;
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    goto :goto_0

    .line 214
    .restart local v0    # "nonNullRegOptions":Landroid/os/Bundle;
    :cond_1
    const/4 v1, 0x0

    .line 215
    .local v1, "result":Landroid/os/Bundle;
    sget-object v2, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$9;->$SwitchMap$com$amazon$identity$auth$device$api$SigninOption:[I

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/api/SigninOption;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 256
    const/4 v2, 0x7

    const-string/jumbo v3, "Signin Options %s is not supported"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/api/SigninOption;->name()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {p4, v2, v3}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onAccountManagerError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 264
    :cond_2
    :goto_2
    const-string/jumbo v2, "Could not find the sign in UI. If the option passed in was MyAccount, you are on a 3rd party device. Otherwise, this more than likely represents a bug."

    invoke-direct {p0, p1, p4, v1, v2}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->handleIntent(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/lang/String;)V

    goto :goto_1

    .line 221
    :pswitch_0
    const-string/jumbo v2, "com.amazon.identity.auth.ChallengeException"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 223
    const-string/jumbo v2, "requestType"

    sget-object v3, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->SIGN_IN:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 225
    invoke-direct {p0, v0, p4, p5}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->signInOrCreateAccountWithWebView(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    move-result-object v1

    .line 227
    goto :goto_2

    .line 232
    :cond_3
    invoke-direct {p0, v0, p4}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->registerWithMyAccount(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Landroid/os/Bundle;

    move-result-object v1

    .line 234
    if-nez v1, :cond_2

    .line 236
    const-string/jumbo v2, "requestType"

    sget-object v3, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->SIGN_IN:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    invoke-direct {p0, v0, p4, p5}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->signInOrCreateAccountWithWebView(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    move-result-object v1

    goto :goto_2

    .line 244
    :pswitch_1
    const-string/jumbo v2, "requestType"

    sget-object v3, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->REGISTER:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    invoke-direct {p0, v0, p4, p5}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->signInOrCreateAccountWithWebView(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    move-result-object v1

    .line 247
    goto :goto_2

    .line 251
    :pswitch_2
    invoke-direct {p0, v0, p4}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->registerWithMyAccount(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Landroid/os/Bundle;

    move-result-object v1

    .line 252
    goto :goto_2

    .line 215
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public registerChildApplication(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 6
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "deviceType"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "innerCallback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 452
    const-string/jumbo v0, "directedId"

    invoke-static {p1, v0}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 453
    const-string/jumbo v0, "deviceType"

    invoke-static {p2, v0}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 455
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "registerChildApplication device type:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 456
    new-instance v4, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v4, p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 460
    .local v4, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mRegisterChildApplicationAction:Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->registerChildApplication(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    :try_end_0
    .catch Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction$NotChildApplicationException; {:try_start_0 .. :try_end_0} :catch_0

    .line 474
    :goto_0
    return-object v4

    .line 468
    :catch_0
    move-exception v0

    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v0

    const-string/jumbo v1, "%s is not a child application device type"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p2, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v4, v0, v1, v2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public renameDevice(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "newDeviceName"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1478
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "renameDevice logic called"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1480
    new-instance v6, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v6, p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 1482
    .local v6, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    sget-object v7, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->ACCOUNT_AUTHENTICATOR_QUEUE:Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;

    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$8;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$8;-><init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    const-string/jumbo v1, "RenameDevice"

    invoke-virtual {v7, v0, v6, v1}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;->addAccountAuthenticatorTask(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    .line 1494
    return-object v6
.end method

.method public updateAccountWithKey(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callBack"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/utils/KeyInfo;",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 554
    new-instance v7, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v7, p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 556
    .local v7, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    invoke-virtual {p0, p1, v7}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->validateAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 600
    :goto_0
    return-object v7

    .line 561
    :cond_0
    invoke-static {p2}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreKeyUtils;->canUpdateCredentials(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 563
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v0

    const-string/jumbo v2, "key %s is not valid"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-static {v7, v0, v2, v3}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0

    .line 570
    :cond_1
    new-instance v1, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;

    invoke-direct {v1, p0, p1, p2, v7}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$1;-><init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V

    .line 597
    .local v1, "updateCredsResponse":Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mRegistrar:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v3

    if-eqz p3, :cond_2

    move-object v4, p3

    :goto_1
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mRegistrarAuthenticator:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    move-object v2, p1

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->updateCredentials(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0

    :cond_2
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    goto :goto_1
.end method

.method protected validateAccount(Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;)Z
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "response"    # Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;

    .prologue
    .line 1398
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1400
    :cond_0
    const/4 v0, 0x7

    const-string/jumbo v1, "The provided account does not exist"

    invoke-virtual {p2, v0, v1}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->onError(ILjava/lang/String;)V

    .line 1401
    const/4 v0, 0x0

    .line 1404
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method protected validateAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Z
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 1409
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1411
    :cond_0
    const/4 v0, 0x7

    const-string/jumbo v1, "The provided account does not exist"

    const/4 v2, 0x0

    invoke-static {p2, v0, v1, v2}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;Landroid/os/Bundle;)V

    .line 1415
    const/4 v0, 0x0

    .line 1418
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method
