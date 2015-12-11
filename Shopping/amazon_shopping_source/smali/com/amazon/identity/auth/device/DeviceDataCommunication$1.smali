.class Lcom/amazon/identity/auth/device/DeviceDataCommunication$1;
.super Ljava/lang/Object;
.source "DeviceDataCommunication.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/DeviceDataCommunication;->retriveValueFromCentralStore(Ljava/lang/String;)Lcom/amazon/identity/auth/device/DeviceDataInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback",
        "<",
        "Lcom/amazon/identity/auth/device/DeviceDataInfo;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/DeviceDataCommunication;

.field final synthetic val$key:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/DeviceDataCommunication;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lcom/amazon/identity/auth/device/DeviceDataCommunication$1;->this$0:Lcom/amazon/identity/auth/device/DeviceDataCommunication;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/DeviceDataCommunication$1;->val$key:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public useContentProviderClient(Landroid/content/ContentProviderClient;)Lcom/amazon/identity/auth/device/DeviceDataInfo;
    .locals 11
    .param p1, "client"    # Landroid/content/ContentProviderClient;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 77
    iget-object v0, p0, Lcom/amazon/identity/auth/device/DeviceDataCommunication$1;->this$0:Lcom/amazon/identity/auth/device/DeviceDataCommunication;

    # getter for: Lcom/amazon/identity/auth/device/DeviceDataCommunication;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->access$000(Lcom/amazon/identity/auth/device/DeviceDataCommunication;)Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    move-result-object v0

    sget-object v1, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->DEVICE_DATA_STORE_URI:Landroid/net/Uri;

    sget-object v2, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->COLUMNS:[Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/DeviceDataCommunication$1;->val$key:Ljava/lang/String;

    move-object v5, v4

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 86
    .local v9, "result":Landroid/database/Cursor;
    if-eqz v9, :cond_0

    :try_start_0
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-nez v0, :cond_2

    .line 89
    :cond_0
    const-string/jumbo v0, "Key %s was not found in the device data store"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/amazon/identity/auth/device/DeviceDataCommunication$1;->val$key:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 92
    .local v6, "errorMsg":Ljava/lang/String;
    # getter for: Lcom/amazon/identity/auth/device/DeviceDataCommunication;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->access$100()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    new-instance v0, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;

    invoke-direct {v0, v6}, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 119
    .end local v6    # "errorMsg":Ljava/lang/String;
    :catchall_0
    move-exception v0

    if-eqz v9, :cond_1

    .line 121
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    :cond_1
    throw v0

    .line 97
    :cond_2
    :try_start_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/DeviceDataCommunication$1;->this$0:Lcom/amazon/identity/auth/device/DeviceDataCommunication;

    invoke-static {v0, v9}, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->access$200(Lcom/amazon/identity/auth/device/DeviceDataCommunication;Landroid/database/Cursor;)V

    .line 98
    const-string/jumbo v0, "value"

    invoke-static {v9, v0}, Lcom/amazon/identity/auth/device/utils/DBUtils;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 101
    .local v10, "value":Ljava/lang/String;
    const-string/jumbo v0, "isPersistent"

    invoke-static {v9, v0}, Lcom/amazon/identity/auth/device/utils/DBUtils;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 104
    .local v8, "isPersistentStr":Ljava/lang/String;
    invoke-static {v8}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v7

    .line 107
    .local v7, "isPersistent":Z
    # getter for: Lcom/amazon/identity/auth/device/DeviceDataCommunication;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/DeviceDataCommunication;->access$100()Ljava/lang/String;

    const-string/jumbo v0, "Recevied Key=%s, Value=%s, Persistent=%s"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/amazon/identity/auth/device/DeviceDataCommunication$1;->val$key:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object v10, v1, v2

    const/4 v2, 0x2

    aput-object v8, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 113
    new-instance v0, Lcom/amazon/identity/auth/device/DeviceDataInfo;

    invoke-direct {v0, v10, v7}, Lcom/amazon/identity/auth/device/DeviceDataInfo;-><init>(Ljava/lang/String;Z)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 119
    if-eqz v9, :cond_3

    .line 121
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    :cond_3
    return-object v0
.end method

.method public bridge synthetic useContentProviderClient(Landroid/content/ContentProviderClient;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/content/ContentProviderClient;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 72
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/DeviceDataCommunication$1;->useContentProviderClient(Landroid/content/ContentProviderClient;)Lcom/amazon/identity/auth/device/DeviceDataInfo;

    move-result-object v0

    return-object v0
.end method
