.class public Lcom/amazon/identity/auth/attributes/CorPfmLogic;
.super Ljava/lang/Object;
.source "CorPfmLogic.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/attributes/CorPfmLogic$1;,
        Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;
    }
.end annotation


# static fields
.field public static final IS_COR_PFM_SET:Ljava/lang/String; = "is_cor_pfm_set"

.field private static final TAG:Ljava/lang/String;

.field private static sTheOneAndTheOnly:Lcom/amazon/identity/auth/attributes/CorPfmLogic;


# instance fields
.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private final mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

.field private final mOutstandingTasks:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 34
    const-class v0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 48
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 50
    new-instance v0, Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    .line 52
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mOutstandingTasks:Ljava/util/Map;

    .line 53
    return-void
.end method

.method private getCurrentAccountCorPfm(Ljava/lang/String;)Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 370
    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v3, "com.amazon.dcp.sso.property.account.cor"

    invoke-virtual {v2, p1, v3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 371
    .local v0, "cor":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v3, "com.amazon.dcp.sso.property.account.pfm"

    invoke-virtual {v2, p1, v3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 373
    .local v1, "pfm":Ljava/lang/String;
    new-instance v2, Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    sget-object v3, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->CUSTOMER_PROVIDED:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    invoke-direct {v2, v0, v1, v3}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;)V

    return-object v2
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/attributes/CorPfmLogic;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 57
    const-class v1, Lcom/amazon/identity/auth/attributes/CorPfmLogic;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/attributes/CorPfmLogic;

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 59
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/attributes/CorPfmLogic;

    .line 62
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/attributes/CorPfmLogic;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 57
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static isValidCorPfmFromDCAS(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1
    .param p0, "cor"    # Ljava/lang/String;
    .param p1, "sourceOfCor"    # Ljava/lang/String;
    .param p2, "pfm"    # Ljava/lang/String;

    .prologue
    .line 67
    if-eqz p0, :cond_0

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    if-nez p2, :cond_1

    .line 69
    :cond_0
    const/4 v0, 0x0

    .line 71
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static notifyChange(Ljava/lang/String;Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;)V
    .locals 2
    .param p0, "directedId"    # Ljava/lang/String;
    .param p1, "multipleAccountPlugin"    # Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    .prologue
    .line 378
    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    .line 380
    const-string/jumbo v1, "com.amazon.dcp.sso.broadcast.CORPFMHasChanged"

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/SSOBroadcastIntentFactory;->createIntent(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 382
    .local v0, "corPfmChanged":Landroid/content/Intent;
    const-string/jumbo v1, "new.account.property.changed"

    invoke-virtual {v0, v1, p0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 386
    const-string/jumbo v1, "com.amazon.dcp.sso.permission.MANAGE_COR_PFM"

    invoke-interface {p1, p0, v0, v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;->sendBroadcast(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;)V

    .line 387
    return-void
.end method

.method private readSecureSettings(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "resource"    # Ljava/lang/String;

    .prologue
    .line 316
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-static {v1, p1}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 321
    :goto_0
    return-object v1

    .line 318
    :catch_0
    move-exception v0

    .line 320
    .local v0, "e":Ljava/lang/Exception;
    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Error calling Secure Settings for resource "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 321
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private saveCorPfmResponse(Ljava/lang/String;Lcom/amazon/identity/auth/attributes/CORPFMResponse;Ljava/util/Map;)Z
    .locals 7
    .param p1, "existingDirectedId"    # Ljava/lang/String;
    .param p2, "response"    # Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/attributes/CORPFMResponse;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p3, "pendingUserDataUpdates":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v2, 0x1

    const/4 v0, 0x0

    .line 238
    sget-object v3, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Trying to save COR/PFM response : \nCoR: %s \nPFM:%s \n Computation Confidence Value: %s"

    const/4 v1, 0x3

    new-array v5, v1, [Ljava/lang/Object;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getCOR()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v5, v0

    invoke-virtual {p2}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getPFM()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v5, v2

    const/4 v6, 0x2

    invoke-virtual {p2}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getComputationConfidenceValue()Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p2}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getComputationConfidenceValue()Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_0
    aput-object v1, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmLogic$1;->$SwitchMap$com$amazon$identity$auth$attributes$CORPFMResponse$ComputationConfidenceValue:[I

    invoke-virtual {p2}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getComputationConfidenceValue()Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->ordinal()I

    move-result v3

    aget v1, v1, v3

    packed-switch v1, :pswitch_data_0

    .line 259
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v3, "Cor Pfm value type %s is not supported"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getComputationConfidenceValue()Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->name()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v0

    invoke-static {v3, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 238
    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 249
    :pswitch_0
    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Saving user backed COR/PFM"

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz p1, :cond_2

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v1, p1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->doesAccountExist(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not save COR/PFM values because the given account does not exist"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 264
    .local v0, "wasValueChanged":Z
    :goto_1
    const-string/jumbo v1, "is_cor_pfm_set"

    const-string/jumbo v2, "true"

    invoke-interface {p3, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 265
    return v0

    .line 249
    .end local v0    # "wasValueChanged":Z
    :cond_1
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->getCurrentAccountCorPfm(Ljava/lang/String;)Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    move-result-object v1

    invoke-virtual {p2, v1}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "User COR PFM has not changed."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.cor"

    invoke-virtual {p2}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getCOR()Ljava/lang/String;

    move-result-object v3

    invoke-interface {p3, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.pfm"

    invoke-virtual {p2}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->getPFM()Ljava/lang/String;

    move-result-object v3

    invoke-interface {p3, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move v0, v2

    goto :goto_1

    .line 253
    :pswitch_1
    const/4 v0, 0x0

    .line 254
    .restart local v0    # "wasValueChanged":Z
    goto :goto_1

    .line 256
    .end local v0    # "wasValueChanged":Z
    :pswitch_2
    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Saving device defaults COR/PFM"

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->getCorPfmDeviceDefaults()Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    move-result-object v1

    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    invoke-virtual {v3, p2}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->setDeviceDefaultCorPfm(Lcom/amazon/identity/auth/attributes/CORPFMResponse;)V

    invoke-virtual {p2, v1}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Default COR/PFM has not changed."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 257
    .restart local v0    # "wasValueChanged":Z
    :goto_2
    goto :goto_1

    .end local v0    # "wasValueChanged":Z
    :cond_3
    move v0, v2

    .line 256
    goto :goto_2

    .line 246
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method


# virtual methods
.method public fetchCorPfm(Ljava/lang/String;)Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 132
    iget-object v5, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mOutstandingTasks:Ljava/util/Map;

    monitor-enter v5

    .line 134
    :try_start_0
    iget-object v4, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mOutstandingTasks:Ljava/util/Map;

    invoke-interface {v4, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;

    .line 135
    .local v3, "task":Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;
    if-nez v3, :cond_2

    .line 138
    new-instance v3, Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;

    .end local v3    # "task":Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;
    const/4 v4, 0x0

    invoke-direct {v3, v4}, Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;-><init>(Lcom/amazon/identity/auth/attributes/CorPfmLogic$1;)V

    .line 139
    .restart local v3    # "task":Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;
    iget-object v4, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mOutstandingTasks:Ljava/util/Map;

    invoke-interface {v4, p1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 140
    const/4 v1, 0x1

    .line 147
    .local v1, "myResponsibilityToCallDCAS":Z
    :goto_0
    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 149
    const/4 v2, 0x0

    .line 150
    .local v2, "response":Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    if-eqz v1, :cond_4

    .line 152
    sget-object v4, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    .line 155
    :try_start_1
    new-instance v4, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;

    iget-object v5, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v4, v5, p1}, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 157
    invoke-virtual {v4}, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->fetch()Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    move-result-object v2

    .line 159
    if-eqz v2, :cond_1

    new-instance v4, Ljava/util/LinkedHashMap;

    invoke-direct {v4}, Ljava/util/LinkedHashMap;-><init>()V

    invoke-direct {p0, p1, v2, v4}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->saveCorPfmResponse(Ljava/lang/String;Lcom/amazon/identity/auth/attributes/CORPFMResponse;Ljava/util/Map;)Z

    move-result v5

    if-eqz p1, :cond_0

    iget-object v6, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v6, p1, v4}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setUserData(Ljava/lang/String;Ljava/util/Map;)V

    :cond_0
    if-eqz v5, :cond_3

    sget-object v4, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "COR/PFM value has changed. Sending notifications."

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v4, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v4}, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;->getMultipleAccountPlugin(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    move-result-object v4

    invoke-static {p1, v4}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->notifyChange(Ljava/lang/String;Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 163
    :cond_1
    :goto_1
    iput-object v2, v3, Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;->mResponse:Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    .line 164
    iget-object v4, v3, Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;->mLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v4}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 167
    iget-object v5, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mOutstandingTasks:Ljava/util/Map;

    monitor-enter v5

    .line 169
    :try_start_2
    iget-object v4, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mOutstandingTasks:Ljava/util/Map;

    invoke-interface {v4, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 170
    monitor-exit v5
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 193
    :goto_2
    return-object v2

    .line 145
    .end local v1    # "myResponsibilityToCallDCAS":Z
    .end local v2    # "response":Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    :cond_2
    const/4 v1, 0x0

    .restart local v1    # "myResponsibilityToCallDCAS":Z
    goto :goto_0

    .line 147
    .end local v1    # "myResponsibilityToCallDCAS":Z
    .end local v3    # "task":Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;
    :catchall_0
    move-exception v4

    monitor-exit v5

    throw v4

    .line 159
    .restart local v1    # "myResponsibilityToCallDCAS":Z
    .restart local v2    # "response":Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    .restart local v3    # "task":Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;
    :cond_3
    :try_start_3
    sget-object v4, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "COR/PFM values are not different. Not firing the changed broadcast"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_1

    .line 171
    :catchall_1
    move-exception v4

    iput-object v2, v3, Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;->mResponse:Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    .line 164
    iget-object v5, v3, Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;->mLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v5}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 167
    iget-object v5, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mOutstandingTasks:Ljava/util/Map;

    monitor-enter v5

    .line 169
    :try_start_4
    iget-object v6, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mOutstandingTasks:Ljava/util/Map;

    invoke-interface {v6, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 170
    monitor-exit v5
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    throw v4

    :catchall_2
    move-exception v4

    monitor-exit v5

    throw v4

    :catchall_3
    move-exception v4

    monitor-exit v5

    throw v4

    .line 175
    :cond_4
    sget-object v4, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    .line 178
    :try_start_5
    iget-object v4, v3, Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;->mLatch:Ljava/util/concurrent/CountDownLatch;

    const-wide/16 v5, 0x5

    sget-object v7, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v4, v5, v6, v7}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 180
    iget-object v2, v3, Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;->mResponse:Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    goto :goto_2

    .line 184
    :cond_5
    sget-object v4, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Timed out waiting for cor/pfm response"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_5} :catch_0

    goto :goto_2

    .line 187
    :catch_0
    move-exception v0

    .line 189
    .local v0, "e":Ljava/lang/InterruptedException;
    sget-object v4, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Interrupted waiting for cor/pfm response"

    invoke-static {v4, v5, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_2
.end method

.method public fetchCorPfmIfNotSet(Ljava/lang/String;)Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 99
    if-eqz p1, :cond_0

    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v3, p1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->doesAccountExist(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_4

    :cond_0
    sget-object v3, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    new-array v3, v1, [Ljava/lang/Object;

    aput-object p1, v3, v2

    sget-object v3, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "getting Cor/Pfm from Secure Settings"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v3, "DEFAULT_COR"

    invoke-direct {p0, v3}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->readSecureSettings(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "DEFAULT_PFM"

    invoke-direct {p0, v4}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->readSecureSettings(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_2

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_2

    sget-object v5, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Returning Cor/Pfm from Secure Settings. Cor: %s, Pfm: %s"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    aput-object v3, v7, v2

    aput-object v4, v7, v1

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v5, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    sget-object v2, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->CUSTOMER_PROVIDED:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    invoke-direct {v1, v3, v4, v2}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;)V

    :goto_0
    if-eqz v1, :cond_3

    move-object v0, v1

    .line 101
    .local v0, "response":Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    :cond_1
    :goto_1
    if-eqz v0, :cond_6

    .line 103
    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    .line 109
    .end local v0    # "response":Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    :goto_2
    return-object v0

    :cond_2
    move-object v1, v0

    .line 99
    goto :goto_0

    :cond_3
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->hasSetDeviceDefaultsForCorPfm()Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mCorPfmInfo:Lcom/amazon/identity/auth/attributes/CorPfmInfo;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/attributes/CorPfmInfo;->getCorPfmDeviceDefaults()Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    move-result-object v0

    goto :goto_1

    :cond_4
    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v4, "is_cor_pfm_set"

    invoke-virtual {v3, p1, v4}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_5

    :goto_3
    if-eqz v1, :cond_1

    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->getCurrentAccountCorPfm(Ljava/lang/String;)Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    move-result-object v0

    goto :goto_1

    :cond_5
    move v1, v2

    goto :goto_3

    .line 107
    .restart local v0    # "response":Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    :cond_6
    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    .line 109
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->fetchCorPfm(Ljava/lang/String;)Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    move-result-object v0

    goto :goto_2
.end method

.method public setCORPFM(Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Value;Lcom/amazon/identity/auth/device/framework/Value;)V
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/framework/Value",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/identity/auth/device/framework/Value",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 76
    .local p2, "cor":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/String;>;"
    .local p3, "pfm":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/String;>;"
    if-nez p1, :cond_0

    .line 78
    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot set COR/PFM to a null account"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    :goto_0
    return-void

    .line 82
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 83
    .local v0, "pendingUserDataUpdates":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p2, :cond_1

    .line 85
    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.cor"

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/framework/Value;->getValue()Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 88
    :cond_1
    if-eqz p3, :cond_2

    .line 90
    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.pfm"

    invoke-virtual {p3}, Lcom/amazon/identity/auth/device/framework/Value;->getValue()Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 92
    :cond_2
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v1, p1, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setUserData(Ljava/lang/String;Ljava/util/Map;)V

    .line 94
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;->getMultipleAccountPlugin(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    move-result-object v1

    invoke-static {p1, v1}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->notifyChange(Ljava/lang/String;Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;)V

    goto :goto_0
.end method

.method public setInitialCORPFM(Lcom/amazon/identity/auth/attributes/CORPFMResponse;Ljava/util/Map;)V
    .locals 2
    .param p1, "response"    # Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/attributes/CORPFMResponse;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 198
    .local p2, "pendingUserDataUpdates":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p1, :cond_0

    .line 200
    sget-object v0, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Cor/PFM response given to set is null. Not setting."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 205
    :goto_0
    return-void

    .line 204
    :cond_0
    const/4 v0, 0x0

    invoke-direct {p0, v0, p1, p2}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->saveCorPfmResponse(Ljava/lang/String;Lcom/amazon/identity/auth/attributes/CORPFMResponse;Ljava/util/Map;)Z

    goto :goto_0
.end method
