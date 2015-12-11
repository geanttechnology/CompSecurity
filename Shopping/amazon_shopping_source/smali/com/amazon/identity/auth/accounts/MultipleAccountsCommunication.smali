.class public Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;
.super Ljava/lang/Object;
.source "MultipleAccountsCommunication.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/MultipleAccountDefinition;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$GetAccountForMappingsUserAction;,
        Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$DoesAccountHaveMappingAction;,
        Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$RemoveAccountMappingsUserAction;,
        Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$SetAccountMappingsUserAction;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

.field private final mPlatformWrapper:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 194
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 195
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mContext:Landroid/content/Context;

    .line 197
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "sso_platform"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mPlatformWrapper:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 199
    new-instance v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "com.amazon.dcp.sso.ErrorCode"

    const-string/jumbo v3, "com.amazon.dcp.sso.ErrorMessage"

    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    .line 204
    return-void
.end method

.method static synthetic access$000([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    .line 27
    invoke-static {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->serialize([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Ljava/lang/String;)[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .locals 1
    .param p0, "x0"    # Ljava/lang/String;

    .prologue
    .line 27
    invoke-static {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->deserialize(Ljava/lang/String;)[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private static deserialize(Ljava/lang/String;)[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .locals 14
    .param p0, "seralizedStr"    # Ljava/lang/String;

    .prologue
    const/4 v9, 0x0

    .line 296
    if-nez p0, :cond_1

    move-object v4, v9

    .line 358
    :cond_0
    :goto_0
    return-object v4

    .line 303
    :cond_1
    :try_start_0
    new-instance v10, Lorg/json/JSONObject;

    invoke-direct {v10, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 304
    const-string/jumbo v11, "mappings"

    invoke-virtual {v10, v11}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 306
    .local v0, "array":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v10

    new-array v4, v10, [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .line 308
    .local v4, "mappings":[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v10

    if-ge v2, v10, :cond_0

    .line 310
    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 311
    .local v5, "obj":Lorg/json/JSONObject;
    const-string/jumbo v10, "type"

    invoke-virtual {v5, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 312
    .local v7, "type":Ljava/lang/String;
    const-string/jumbo v10, "value"

    invoke-virtual {v5, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 314
    .local v8, "value":Ljava/lang/String;
    const/4 v3, 0x0

    .line 316
    .local v3, "mapping":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    const-string/jumbo v10, "com.amazon.dcp.sso.property.sessionuser"

    invoke-virtual {v10, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_4

    .line 318
    new-instance v3, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$SessionUserMappingType;

    .end local v3    # "mapping":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    invoke-direct {v3}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$SessionUserMappingType;-><init>()V

    .line 345
    .restart local v3    # "mapping":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    :cond_2
    :goto_2
    if-eqz v3, :cond_3

    .line 347
    aput-object v3, v4, v2

    .line 308
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 320
    :cond_4
    const-string/jumbo v10, "com.amazon.dcp.sso.property.account.extratokens.account_profiles"

    invoke-virtual {v10, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_6

    .line 322
    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v6

    .line 323
    .local v6, "profileId":Ljava/lang/Integer;
    if-eqz v6, :cond_5

    .line 325
    new-instance v3, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$ProfileMappingType;

    .end local v3    # "mapping":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v10

    invoke-direct {v3, v10}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$ProfileMappingType;-><init>(I)V

    .restart local v3    # "mapping":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    goto :goto_2

    .line 329
    :cond_5
    sget-object v10, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->TAG:Ljava/lang/String;

    const-string/jumbo v11, "%s is not a valid profile id"

    const/4 v12, 0x1

    new-array v12, v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    aput-object v8, v12, v13

    invoke-static {v10, v11, v12}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    .line 353
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v3    # "mapping":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .end local v4    # "mappings":[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .end local v5    # "obj":Lorg/json/JSONObject;
    .end local v6    # "profileId":Ljava/lang/Integer;
    .end local v7    # "type":Ljava/lang/String;
    .end local v8    # "value":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 355
    .local v1, "e":Lorg/json/JSONException;
    sget-object v10, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->TAG:Ljava/lang/String;

    const-string/jumbo v11, "Could not deseralize all mappings"

    invoke-static {v10, v11, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v4, v9

    .line 358
    goto :goto_0

    .line 332
    .end local v1    # "e":Lorg/json/JSONException;
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v3    # "mapping":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .restart local v4    # "mappings":[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .restart local v5    # "obj":Lorg/json/JSONObject;
    .restart local v7    # "type":Ljava/lang/String;
    .restart local v8    # "value":Ljava/lang/String;
    :cond_6
    :try_start_1
    const-string/jumbo v10, "com.amazon.dcp.sso.property.account.extratokens.account_packages"

    invoke-virtual {v10, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_7

    .line 334
    new-instance v3, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;

    .end local v3    # "mapping":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    invoke-direct {v3, v8}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;-><init>(Ljava/lang/String;)V

    .restart local v3    # "mapping":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    goto :goto_2

    .line 336
    :cond_7
    const-string/jumbo v10, "com.amazon.dcp.sso.property.account.extratokens.custom_keys"

    invoke-virtual {v10, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_8

    .line 338
    new-instance v3, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$CustomKeyMappingType;

    .end local v3    # "mapping":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    invoke-direct {v3, v8}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$CustomKeyMappingType;-><init>(Ljava/lang/String;)V

    .restart local v3    # "mapping":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    goto :goto_2

    .line 340
    :cond_8
    const-string/jumbo v10, "primary_account_type"

    invoke-virtual {v10, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_2

    .line 342
    new-instance v3, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;

    .end local v3    # "mapping":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    invoke-direct {v3}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PrimaryUserMappingType;-><init>()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    .restart local v3    # "mapping":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    goto :goto_2
.end method

.method private static varargs serialize([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;
    .locals 10
    .param p0, "mappings"    # [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    .line 270
    :try_start_0
    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6}, Lorg/json/JSONObject;-><init>()V

    .line 272
    .local v6, "root":Lorg/json/JSONObject;
    new-instance v7, Lorg/json/JSONArray;

    invoke-direct {v7}, Lorg/json/JSONArray;-><init>()V

    .line 273
    .local v7, "seralizedMappings":Lorg/json/JSONArray;
    move-object v0, p0

    .local v0, "arr$":[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    array-length v3, p0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v4, v0, v2

    .line 275
    .local v4, "mapping":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5}, Lorg/json/JSONObject;-><init>()V

    .line 276
    .local v5, "obj":Lorg/json/JSONObject;
    const-string/jumbo v8, "type"

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingType()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 277
    const-string/jumbo v8, "value"

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;->getAccountMappingValue()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 279
    invoke-virtual {v7, v5}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 273
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 282
    .end local v4    # "mapping":Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .end local v5    # "obj":Lorg/json/JSONObject;
    :cond_0
    const-string/jumbo v8, "mappings"

    invoke-virtual {v6, v8, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 284
    invoke-virtual {v6}, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v8

    .line 291
    .end local v0    # "arr$":[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .end local v2    # "i$":I
    .end local v3    # "len$":I
    .end local v6    # "root":Lorg/json/JSONObject;
    .end local v7    # "seralizedMappings":Lorg/json/JSONArray;
    :goto_1
    return-object v8

    .line 286
    :catch_0
    move-exception v1

    .line 288
    .local v1, "e":Lorg/json/JSONException;
    sget-object v8, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Could not seralize all mappings"

    invoke-static {v8, v9, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 291
    const/4 v8, 0x0

    goto :goto_1
.end method


# virtual methods
.method public doesAccountHaveMapping(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "mapping"    # Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    .line 254
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mPlatformWrapper:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isNewIdentiyMobilePlatformSSO()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 256
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$DoesAccountHaveMappingAction;->parametersToBundle(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Landroid/os/Bundle;

    move-result-object v0

    .line 257
    .local v0, "parameters":Landroid/os/Bundle;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v2, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$DoesAccountHaveMappingAction;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v1

    .line 258
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$DoesAccountHaveMappingAction;->getResult(Landroid/os/Bundle;)Z

    move-result v1

    .line 262
    .end local v0    # "parameters":Landroid/os/Bundle;
    :goto_0
    return v1

    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->doesAccountHaveMapping(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z

    move-result v1

    goto :goto_0
.end method

.method public varargs getAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;
    .locals 3
    .param p1, "accountMappings"    # [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    .line 209
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mPlatformWrapper:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isNewIdentiyMobilePlatformSSO()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 211
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$GetAccountForMappingsUserAction;->parametersToBundle([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Landroid/os/Bundle;

    move-result-object v0

    .line 212
    .local v0, "parameters":Landroid/os/Bundle;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v2, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$GetAccountForMappingsUserAction;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v1

    .line 213
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$GetAccountForMappingsUserAction;->getResult(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    .line 217
    .end local v0    # "parameters":Landroid/os/Bundle;
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public varargs removeAccountMappings(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "mappings"    # [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    .line 239
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mPlatformWrapper:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isNewIdentiyMobilePlatformSSO()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 241
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$RemoveAccountMappingsUserAction;->parametersToBundle(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Landroid/os/Bundle;

    move-result-object v0

    .line 242
    .local v0, "parameters":Landroid/os/Bundle;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v2, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$RemoveAccountMappingsUserAction;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v1

    .line 243
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$RemoveAccountMappingsUserAction;->getResult(Landroid/os/Bundle;)Z

    move-result v1

    .line 247
    .end local v0    # "parameters":Landroid/os/Bundle;
    :goto_0
    return v1

    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->removeAccountMappings(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z

    move-result v1

    goto :goto_0
.end method

.method public varargs setAccountMappings(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "mappings"    # [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    .line 224
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mPlatformWrapper:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isNewIdentiyMobilePlatformSSO()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 226
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$SetAccountMappingsUserAction;->parametersToBundle(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Landroid/os/Bundle;

    move-result-object v0

    .line 227
    .local v0, "parameters":Landroid/os/Bundle;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v2, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$SetAccountMappingsUserAction;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v1

    .line 228
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$SetAccountMappingsUserAction;->getResult(Landroid/os/Bundle;)Z

    move-result v1

    .line 232
    .end local v0    # "parameters":Landroid/os/Bundle;
    :goto_0
    return v1

    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->setAccountMappings(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z

    move-result v1

    goto :goto_0
.end method
