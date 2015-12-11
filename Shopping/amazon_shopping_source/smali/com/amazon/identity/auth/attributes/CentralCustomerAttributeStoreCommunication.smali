.class public Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;
.super Ljava/lang/Object;
.source "CentralCustomerAttributeStoreCommunication.java"

# interfaces
.implements Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;


# static fields
.field public static final COLUMNS:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final COLUMN_BUNDLE_VALUE:Ljava/lang/String; = "bundle_value"

.field public static final COMMAND_KEY:Ljava/lang/String; = "command"

.field public static final CUSTOMER_ATTRIBUTE_STORE_URI:Landroid/net/Uri;

.field public static final GET_ATTRIBUTE_COMMAND:Ljava/lang/String; = "getAttribute"

.field public static final KEY_ACCOUNT_NAME:Ljava/lang/String; = "accountName"

.field public static final KEY_ACCOUNT_TYPE:Ljava/lang/String; = "accountType"

.field public static final KEY_BUNDLE_INFO:Ljava/lang/String; = "bundleInfo"

.field public static final KEY_CUSTOMER_ATTRIBUTE_NAME:Ljava/lang/String; = "key"

.field public static final KEY_DIRECTED_ID:Ljava/lang/String; = "directedId"

.field public static final KEY_GET_OPTIONS_ARRAY:Ljava/lang/String; = "getOptions"

.field public static final PEEK_ATTRIBUTE_COMMAND:Ljava/lang/String; = "peekAttribute"

.field public static final SET_ATTRIBUTE_COMMAND:Ljava/lang/String; = "setAttribute"

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private final mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

.field private final mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 51
    const-string/jumbo v0, "content://amazon_customer_attribute_store"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->CUSTOMER_ATTRIBUTE_STORE_URI:Landroid/net/Uri;

    .line 54
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, "bundle_value"

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->COLUMNS:Ljava/util/List;

    .line 56
    const-class v0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V
    .locals 2
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .prologue
    .line 66
    const-string/jumbo v0, "sso_platform"

    invoke-virtual {p1, v0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    new-instance v1, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    invoke-direct {v1, p1}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;-><init>(Landroid/content/Context;)V

    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/framework/PlatformWrapper;Lcom/amazon/identity/auth/device/framework/SecureContentResolver;)V

    .line 69
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;Lcom/amazon/identity/auth/device/framework/PlatformWrapper;Lcom/amazon/identity/auth/device/framework/SecureContentResolver;)V
    .locals 0
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .param p2, "platform"    # Lcom/amazon/identity/auth/device/framework/PlatformWrapper;
    .param p3, "secureContentResolver"    # Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    .prologue
    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    iput-object p1, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 76
    iput-object p2, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 77
    iput-object p3, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    .line 78
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/util/EnumSet;)Lorg/json/JSONObject;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Ljava/lang/String;
    .param p4, "x4"    # Landroid/os/Bundle;
    .param p5, "x5"    # Ljava/util/EnumSet;

    .prologue
    .line 37
    invoke-direct/range {p0 .. p5}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->getJsonCommandInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/util/EnumSet;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;Lorg/json/JSONObject;)Landroid/os/Bundle;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;
    .param p1, "x1"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/concurrent/ExecutionException;
        }
    .end annotation

    .prologue
    .line 37
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->queryCentralStore(Lorg/json/JSONObject;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Landroid/os/Bundle;ILjava/lang/String;)V
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    .param p3, "x3"    # Landroid/os/Bundle;
    .param p4, "x4"    # I
    .param p5, "x5"    # Ljava/lang/String;

    .prologue
    .line 37
    if-nez p3, :cond_0

    invoke-static {p2, p4, p5}, Lcom/amazon/identity/auth/attributes/AttributeCallbackHelpers;->callbackWithError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    const-string/jumbo v0, "error_code_key"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p2, p3}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onError(Landroid/os/Bundle;)V

    goto :goto_0

    :cond_1
    invoke-virtual {p2, p3}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onSuccess(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method static synthetic access$300()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    sget-object v0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private getJsonCommandInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/util/EnumSet;)Lorg/json/JSONObject;
    .locals 6
    .param p1, "command"    # Ljava/lang/String;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "key"    # Ljava/lang/String;
    .param p4, "info"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            "Ljava/util/EnumSet",
            "<",
            "Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;",
            ">;)",
            "Lorg/json/JSONObject;"
        }
    .end annotation

    .prologue
    .local p5, "options":Ljava/util/EnumSet;, "Ljava/util/EnumSet<Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;>;"
    const/4 v3, 0x0

    .line 290
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 291
    .local v1, "commandInfo":Lorg/json/JSONObject;
    const-string/jumbo v4, "command"

    invoke-virtual {v1, v4, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 292
    const-string/jumbo v4, "directedId"

    invoke-virtual {v1, v4, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 295
    iget-object v4, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isNewIdentiyMobilePlatformSSO()Z

    move-result v4

    if-eqz v4, :cond_2

    move-object v0, v3

    .line 296
    .local v0, "account":Landroid/accounts/Account;
    :goto_0
    if-eqz v0, :cond_0

    .line 298
    const-string/jumbo v4, "accountType"

    iget-object v5, v0, Landroid/accounts/Account;->type:Ljava/lang/String;

    invoke-virtual {v1, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 299
    const-string/jumbo v4, "accountName"

    iget-object v5, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v1, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 301
    :cond_0
    const-string/jumbo v4, "key"

    iget-object v5, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v5}, Lcom/amazon/identity/platform/util/PlatformUtils;->isPostMergeDevice(Landroid/content/Context;)Z

    move-result v5

    if-eqz v5, :cond_3

    .end local p3    # "key":Ljava/lang/String;
    :goto_1
    invoke-virtual {v1, v4, p3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 302
    const-string/jumbo v4, "bundleInfo"

    invoke-static {p4}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->bundleToString(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 303
    if-eqz p5, :cond_1

    .line 305
    const-string/jumbo v4, "getOptions"

    invoke-static {p5}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;->serializeList(Ljava/util/EnumSet;)Lorg/json/JSONArray;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 314
    .end local v0    # "account":Landroid/accounts/Account;
    .end local v1    # "commandInfo":Lorg/json/JSONObject;
    :cond_1
    :goto_2
    return-object v1

    .line 295
    .restart local v1    # "commandInfo":Lorg/json/JSONObject;
    .restart local p3    # "key":Ljava/lang/String;
    :cond_2
    iget-object v4, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v4, p2}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountWithDirectedId(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    goto :goto_0

    .line 301
    .restart local v0    # "account":Landroid/accounts/Account;
    :cond_3
    invoke-static {p3}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->parseKey(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p3

    goto :goto_1

    .line 310
    .end local v0    # "account":Landroid/accounts/Account;
    .end local v1    # "commandInfo":Lorg/json/JSONObject;
    .end local p3    # "key":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 312
    .local v2, "e":Lorg/json/JSONException;
    sget-object v4, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Error creating Customer Attribute IPC Command"

    invoke-static {v4, v5, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v1, v3

    .line 314
    goto :goto_2
.end method

.method public static parseCursor(Landroid/database/Cursor;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 5
    .param p0, "cursor"    # Landroid/database/Cursor;
    .param p1, "command"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 265
    if-eqz p0, :cond_0

    invoke-interface {p0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-nez v2, :cond_1

    .line 267
    :cond_0
    sget-object v2, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "No results found from central store: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 278
    :goto_0
    return-object v1

    .line 271
    :cond_1
    const-string/jumbo v2, "bundle_value"

    invoke-static {p0, v2}, Lcom/amazon/identity/auth/device/utils/DBUtils;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 272
    .local v0, "base64SeralizedValue":Ljava/lang/String;
    if-nez v0, :cond_2

    .line 274
    sget-object v2, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->TAG:Ljava/lang/String;

    goto :goto_0

    .line 278
    :cond_2
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->stringToBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    goto :goto_0
.end method

.method private queryCentralStore(Lorg/json/JSONObject;)Landroid/os/Bundle;
    .locals 4
    .param p1, "commandInfo"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/concurrent/ExecutionException;
        }
    .end annotation

    .prologue
    .line 232
    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    .line 234
    .local v0, "command":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    sget-object v2, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->CUSTOMER_ATTRIBUTE_STORE_URI:Landroid/net/Uri;

    new-instance v3, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$3;

    invoke-direct {v3, p0, v0}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$3;-><init>(Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;Ljava/lang/String;)V

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->acquireContentProviderClient(Landroid/net/Uri;Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Bundle;

    return-object v1
.end method


# virtual methods
.method public getAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p4, "info"    # Landroid/os/Bundle;
    .param p6, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Landroid/os/Bundle;",
            "Ljava/util/EnumSet",
            "<",
            "Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;",
            ">;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 88
    .local p5, "options":Ljava/util/EnumSet;, "Ljava/util/EnumSet<Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;>;"
    new-instance v6, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v6, p3}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 90
    .local v6, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    new-instance v0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p4

    move-object v5, p5

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;-><init>(Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    .line 128
    return-object v6
.end method

.method public peekAttribute(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 11
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    const/4 v10, 0x4

    const/4 v4, 0x0

    .line 134
    const-string/jumbo v1, "peekAttribute"

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v5, v4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->getJsonCommandInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/util/EnumSet;)Lorg/json/JSONObject;

    move-result-object v6

    .line 135
    .local v6, "commandInfo":Lorg/json/JSONObject;
    if-nez v6, :cond_0

    .line 137
    sget-object v0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Failed to construct peek attribute command"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 158
    :goto_0
    return-object v4

    .line 143
    :cond_0
    :try_start_0
    invoke-direct {p0, v6}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->queryCentralStore(Lorg/json/JSONObject;)Landroid/os/Bundle;

    move-result-object v9

    .line 144
    .local v9, "result":Landroid/os/Bundle;
    if-nez v9, :cond_1

    .line 146
    const/4 v0, 0x4

    const-string/jumbo v1, "CustomerAttributeStore returned null"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/attributes/AttributeCallbackHelpers;->createErrorResult(ILjava/lang/String;)Landroid/os/Bundle;
    :try_end_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    goto :goto_0

    :cond_1
    move-object v4, v9

    .line 151
    goto :goto_0

    .line 154
    .end local v9    # "result":Landroid/os/Bundle;
    :catch_0
    move-exception v7

    .line 156
    .local v7, "e":Ljava/util/concurrent/ExecutionException;
    const-string/jumbo v8, "Failed to call peekAttribute"

    .line 157
    .local v8, "errorMessage":Ljava/lang/String;
    sget-object v0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->TAG:Ljava/lang/String;

    invoke-static {v0, v8, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 158
    invoke-static {v10, v8}, Lcom/amazon/identity/auth/attributes/AttributeCallbackHelpers;->createErrorResult(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v4

    goto :goto_0
.end method

.method public setAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 6
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 169
    new-instance v5, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v5, p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 171
    .local v5, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    new-instance v0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;

    move-object v1, p0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;-><init>(Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    .line 207
    return-object v5
.end method
