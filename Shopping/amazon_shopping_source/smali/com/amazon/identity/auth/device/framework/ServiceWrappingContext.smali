.class public final Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
.super Landroid/content/ContextWrapper;
.source "ServiceWrappingContext.java"


# static fields
.field public static final ACCOUNT_MANAGER:Ljava/lang/String; = "dcp_account_manager"

.field public static final ACCOUNT_MANAGER_COMMUNICATOR:Ljava/lang/String; = "sso_map_account_manager_communicator"

.field public static final ALARM_MANAGER:Ljava/lang/String; = "sso_alarm_maanger"

.field public static final AMAZON_ACCOUNT_MANAGER:Ljava/lang/String; = "dcp_amazon_account_man"

.field public static final AMAZON_WEBSERVICE_CALLER_CREATOR:Ljava/lang/String; = "sso_webservice_caller_creator"

.field public static final AUTHENTICATED_URL_CONNECTION_FACTORY:Ljava/lang/String; = "dcp_authenticated_url_connection_factory"

.field public static final CUSTOMER_ATTRIBUTE_STORE_FACTORY:Ljava/lang/String; = "sso_customer_attribute_store_factory"

.field public static final DATA_STORAGE_FACTORY:Ljava/lang/String; = "dcp_data_storage_factory"

.field public static final DEVICE_INFO:Ljava/lang/String; = "dcp_device_info"

.field public static final HTTP_CLIENT:Ljava/lang/String; = "dcp_http_client"

.field public static final LOCAL_DATA_STORAGE:Ljava/lang/String; = "sso_local_datastorage"

.field public static final LOCAL_DATA_STORAGE_V2:Ljava/lang/String; = "sso_local_datastorage_v2"

.field public static final PLATFORM:Ljava/lang/String; = "sso_platform"

.field public static final REGISTER_ACCOUNT_HELPER:Ljava/lang/String; = "dcp_account_register_helper"

.field public static final SINGLE_THREADED_EXECUTOR:Ljava/lang/String; = "dcp_single_threaded_executor"

.field public static final SYNCHRONIZATION_FACTORY:Ljava/lang/String; = "dcp_synchronization_factory"

.field public static final SYSTEM:Ljava/lang/String; = "dcp_system"

.field public static final TOKEN_CACHE_HOLDER:Ljava/lang/String; = "dcp_token_cache_holder"

.field public static final TOKEN_MANGEMENT:Ljava/lang/String; = "dcp_token_mangement"

.field public static final WIFI_SERVICE:Ljava/lang/String; = "dcp_wifi"


# instance fields
.field private mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

.field private final mSystemServiceLookup:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "base"    # Landroid/content/Context;

    .prologue
    .line 63
    invoke-direct {p0, p1}, Landroid/content/ContextWrapper;-><init>(Landroid/content/Context;)V

    .line 65
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->mSystemServiceLookup:Ljava/util/Map;

    .line 66
    return-void
.end method

.method public static create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 70
    instance-of v0, p0, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    if-eqz v0, :cond_0

    .line 72
    check-cast p0, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 75
    .end local p0    # "context":Landroid/content/Context;
    :goto_0
    return-object p0

    .restart local p0    # "context":Landroid/content/Context;
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;-><init>(Landroid/content/Context;)V

    move-object p0, v0

    goto :goto_0
.end method


# virtual methods
.method public getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;
    .locals 1

    .prologue
    .line 183
    const-string/jumbo v0, "dcp_data_storage_factory"

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getFeatureSet()Lcom/amazon/identity/auth/device/features/FeatureSet;
    .locals 2

    .prologue
    .line 188
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    if-nez v0, :cond_0

    .line 190
    new-instance v0, Lcom/amazon/identity/auth/device/features/FeatureSetCache;

    new-instance v1, Lcom/amazon/identity/auth/device/features/FeatureSetProvider;

    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/device/features/FeatureSetProvider;-><init>(Landroid/content/Context;)V

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/features/FeatureSetCache;-><init>(Lcom/amazon/identity/auth/device/features/FeatureSet;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    .line 192
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 188
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getFilesDir()Ljava/io/File;
    .locals 1

    .prologue
    .line 178
    invoke-super {p0}, Landroid/content/ContextWrapper;->getFilesDir()Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method public getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    .locals 3
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 81
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getBaseContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 82
    .local v0, "retval":Ljava/lang/Object;
    if-eqz v0, :cond_0

    .line 94
    .end local v0    # "retval":Ljava/lang/Object;
    :goto_0
    return-object v0

    .line 87
    .restart local v0    # "retval":Ljava/lang/Object;
    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->mSystemServiceLookup:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 88
    .local v1, "systemService":Ljava/lang/Object;
    if-nez v1, :cond_1

    .line 90
    const-string/jumbo v2, "dcp_system"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    new-instance v1, Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    .end local v1    # "systemService":Ljava/lang/Object;
    invoke-direct {v1}, Lcom/amazon/identity/auth/device/framework/SystemWrapper;-><init>()V

    .line 91
    .restart local v1    # "systemService":Ljava/lang/Object;
    :goto_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->mSystemServiceLookup:Ljava/util/Map;

    invoke-interface {v2, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    move-object v0, v1

    .line 94
    goto :goto_0

    .line 90
    :cond_2
    const-string/jumbo v2, "dcp_http_client"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    new-instance v1, Lorg/apache/http/impl/client/DefaultHttpClient;

    .end local v1    # "systemService":Ljava/lang/Object;
    invoke-direct {v1}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>()V

    goto :goto_1

    .restart local v1    # "systemService":Ljava/lang/Object;
    :cond_3
    const-string/jumbo v2, "dcp_device_info"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-static {p0}, Lcom/amazon/identity/auth/device/framework/DeviceInfoHolder;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    move-result-object v1

    goto :goto_1

    :cond_4
    const-string/jumbo v2, "dcp_account_manager"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->get(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    move-result-object v1

    goto :goto_1

    :cond_5
    const-string/jumbo v2, "dcp_single_threaded_executor"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    const-string/jumbo v2, "MAP-ServiceWrappingContextThread"

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->getNamedThreadFactory(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/NamedThreadFactory;

    move-result-object v2

    invoke-static {v2}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    goto :goto_1

    :cond_6
    const-string/jumbo v2, "dcp_amazon_account_man"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    new-instance v1, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .end local v1    # "systemService":Ljava/lang/Object;
    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;-><init>(Landroid/content/Context;)V

    goto :goto_1

    .restart local v1    # "systemService":Ljava/lang/Object;
    :cond_7
    const-string/jumbo v2, "dcp_authenticated_url_connection_factory"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8

    new-instance v1, Lcom/amazon/identity/auth/device/framework/AuthenticatedUrlConnectionFactory;

    .end local v1    # "systemService":Ljava/lang/Object;
    invoke-direct {v1}, Lcom/amazon/identity/auth/device/framework/AuthenticatedUrlConnectionFactory;-><init>()V

    goto :goto_1

    .restart local v1    # "systemService":Ljava/lang/Object;
    :cond_8
    const-string/jumbo v2, "dcp_token_cache_holder"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    invoke-static {p0}, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;

    move-result-object v1

    goto :goto_1

    :cond_9
    const-string/jumbo v2, "dcp_data_storage_factory"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    invoke-static {p0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/DataStorageFactoryImpl;

    move-result-object v1

    goto :goto_1

    :cond_a
    const-string/jumbo v2, "sso_map_account_manager_communicator"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_b

    new-instance v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    .end local v1    # "systemService":Ljava/lang/Object;
    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;-><init>(Landroid/content/Context;)V

    goto/16 :goto_1

    .restart local v1    # "systemService":Ljava/lang/Object;
    :cond_b
    const-string/jumbo v2, "dcp_token_mangement"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_c

    new-instance v1, Lcom/amazon/identity/auth/device/api/TokenManagement;

    .end local v1    # "systemService":Ljava/lang/Object;
    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/device/api/TokenManagement;-><init>(Landroid/content/Context;)V

    goto/16 :goto_1

    .restart local v1    # "systemService":Ljava/lang/Object;
    :cond_c
    const-string/jumbo v2, "dcp_account_register_helper"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_d

    new-instance v1, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;

    .end local v1    # "systemService":Ljava/lang/Object;
    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;-><init>(Landroid/content/Context;)V

    goto/16 :goto_1

    .restart local v1    # "systemService":Ljava/lang/Object;
    :cond_d
    const-string/jumbo v2, "sso_local_datastorage"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_e

    invoke-static {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorage;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/LocalDataStorage;

    move-result-object v1

    goto/16 :goto_1

    :cond_e
    const-string/jumbo v2, "sso_local_datastorage_v2"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_f

    invoke-static {p0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    move-result-object v1

    goto/16 :goto_1

    :cond_f
    const-string/jumbo v2, "sso_alarm_maanger"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_10

    new-instance v1, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;

    .end local v1    # "systemService":Ljava/lang/Object;
    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;-><init>(Landroid/content/Context;)V

    goto/16 :goto_1

    .restart local v1    # "systemService":Ljava/lang/Object;
    :cond_10
    const-string/jumbo v2, "sso_customer_attribute_store_factory"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_11

    new-instance v1, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreFactory;

    .end local v1    # "systemService":Ljava/lang/Object;
    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreFactory;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V

    goto/16 :goto_1

    .restart local v1    # "systemService":Ljava/lang/Object;
    :cond_11
    const-string/jumbo v2, "sso_platform"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_12

    new-instance v1, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .end local v1    # "systemService":Ljava/lang/Object;
    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;-><init>(Landroid/content/Context;)V

    goto/16 :goto_1

    .restart local v1    # "systemService":Ljava/lang/Object;
    :cond_12
    const-string/jumbo v2, "sso_webservice_caller_creator"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_13

    new-instance v1, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    .end local v1    # "systemService":Ljava/lang/Object;
    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;-><init>(Landroid/content/Context;)V

    goto/16 :goto_1

    .restart local v1    # "systemService":Ljava/lang/Object;
    :cond_13
    const/4 v1, 0x0

    goto/16 :goto_1
.end method
