.class public final Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;
.super Ljava/lang/Object;
.source "MAPInformationProviderHelpers.java"


# static fields
.field public static final ACCOUNTS_PATH:Ljava/lang/String; = "/accounts"

.field public static final ALL_DATA_PATH:Ljava/lang/String; = "/all_data"

.field public static final ALL_DELETED_DATA_PATH:Ljava/lang/String; = "/all_deleted_data"

.field public static final BULK_DATA_PATH:Ljava/lang/String; = "/bulk_data"

.field public static final COLUMN_QUERY_VALUE:Ljava/lang/String; = "value"

.field public static final DEVICE_DATA_PATH:Ljava/lang/String; = "/device_data"

.field public static final GENERATE_COMMON_INFO_PATH:Ljava/lang/String; = "/generate_common_info"

.field public static final KEY_BULK_DATA:Ljava/lang/String; = "bulk_data"

.field public static final KEY_CURRENT_DEVICE_TYPE:Ljava/lang/String; = "current_device_type"

.field public static final KEY_DELETED:Ljava/lang/String; = "deleted_key"

.field public static final KEY_DEVICE_DATA_KEY:Ljava/lang/String; = "device_data_key"

.field public static final KEY_DEVICE_DATA_VALUE:Ljava/lang/String; = "device_data_value"

.field public static final KEY_DIRECTED_ID:Ljava/lang/String; = "directedId"

.field public static final KEY_DIRTY:Ljava/lang/String; = "dirty_key"

.field public static final KEY_DISPLAY_NAME:Ljava/lang/String; = "display_name"

.field public static final KEY_DSN_OVERRIDE:Ljava/lang/String; = "dsn_override"

.field public static final KEY_KEY:Ljava/lang/String; = "key"

.field public static final KEY_MAP_BRAZIL_VERSION:Ljava/lang/String; = "map_brazil_version"

.field public static final KEY_MAP_INIT_VERSION:Ljava/lang/String; = "map_init_version"

.field public static final KEY_MAP_MAJOR_VERSION:Ljava/lang/String; = "map_major_version"

.field public static final KEY_MAP_MINOR_VERSION:Ljava/lang/String; = "map_minor_version"

.field public static final KEY_MAP_SW_VERSION:Ljava/lang/String; = "map_sw_version"

.field public static final KEY_NAMESPACE:Ljava/lang/String; = "namespace"

.field public static final KEY_TIMESTAMP:Ljava/lang/String; = "timestamp_key"

.field public static final KEY_TOKEN_ACCOUNT:Ljava/lang/String; = "token_account"

.field public static final KEY_TOKEN_KEY:Ljava/lang/String; = "token_key"

.field public static final KEY_TOKEN_VALUE:Ljava/lang/String; = "token_value"

.field public static final KEY_USER_DATA_ACCOUNT:Ljava/lang/String; = "userdata_account"

.field public static final KEY_USER_DATA_BUNDLE:Ljava/lang/String; = "userdata_bundle_key"

.field public static final KEY_USER_DATA_KEY:Ljava/lang/String; = "userdata_key"

.field public static final KEY_USER_DATA_VALUE:Ljava/lang/String; = "userdata_value"

.field public static final KEY_VALUE:Ljava/lang/String; = "value"

.field public static final MAP_INFO_PATH:Ljava/lang/String; = "/map_info"

.field public static final QUERY_BULK_DATA_COLUMNS:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final QUERY_COLUMNS:[Ljava/lang/String;

.field public static final QUERY_COMMON_INFO_COLUMNS:[Ljava/lang/String;

.field public static final QUERY_MAP_INFO_COLUMNS:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final TOKENS_PATH:Ljava/lang/String; = "/tokens"

.field public static final USER_DATA_PATH:Ljava/lang/String; = "/userdata"


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 44
    new-array v0, v4, [Ljava/lang/String;

    const-string/jumbo v1, "value"

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->QUERY_COLUMNS:[Ljava/lang/String;

    .line 46
    new-array v0, v6, [Ljava/lang/String;

    const-string/jumbo v1, "key"

    aput-object v1, v0, v3

    const-string/jumbo v1, "value"

    aput-object v1, v0, v4

    const-string/jumbo v1, "namespace"

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->QUERY_COMMON_INFO_COLUMNS:[Ljava/lang/String;

    .line 48
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/String;

    const-string/jumbo v1, "map_major_version"

    aput-object v1, v0, v3

    const-string/jumbo v1, "map_minor_version"

    aput-object v1, v0, v4

    const-string/jumbo v1, "current_device_type"

    aput-object v1, v0, v5

    const-string/jumbo v1, "dsn_override"

    aput-object v1, v0, v6

    const-string/jumbo v1, "map_sw_version"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string/jumbo v2, "map_init_version"

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->QUERY_MAP_INFO_COLUMNS:Ljava/util/List;

    .line 55
    const/16 v0, 0xe

    new-array v0, v0, [Ljava/lang/String;

    const-string/jumbo v1, "directedId"

    aput-object v1, v0, v3

    const-string/jumbo v1, "namespace"

    aput-object v1, v0, v4

    const-string/jumbo v1, "userdata_account"

    aput-object v1, v0, v5

    const-string/jumbo v1, "token_account"

    aput-object v1, v0, v6

    const-string/jumbo v1, "display_name"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string/jumbo v2, "userdata_key"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string/jumbo v2, "userdata_value"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string/jumbo v2, "token_key"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string/jumbo v2, "token_value"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string/jumbo v2, "device_data_key"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string/jumbo v2, "device_data_value"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string/jumbo v2, "timestamp_key"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string/jumbo v2, "deleted_key"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string/jumbo v2, "dirty_key"

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->QUERY_BULK_DATA_COLUMNS:Ljava/util/List;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 86
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 87
    return-void
.end method

.method public static generateCommonInfoUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "authority"    # Ljava/lang/String;

    .prologue
    .line 131
    const-string/jumbo v0, "/generate_common_info"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getAccountUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "authority"    # Ljava/lang/String;

    .prologue
    .line 91
    const-string/jumbo v0, "/accounts"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getAllDataUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "authority"    # Ljava/lang/String;

    .prologue
    .line 116
    const-string/jumbo v0, "/all_data"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getAllDeletedDataUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "authority"    # Ljava/lang/String;

    .prologue
    .line 121
    const-string/jumbo v0, "/all_deleted_data"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getBulkDataUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "authority"    # Ljava/lang/String;

    .prologue
    .line 126
    const-string/jumbo v0, "/bulk_data"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getDeviceDataUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "authority"    # Ljava/lang/String;

    .prologue
    .line 106
    const-string/jumbo v0, "/device_data"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getMapVersionInfoUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "authority"    # Ljava/lang/String;

    .prologue
    .line 111
    const-string/jumbo v0, "/map_info"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getTokensUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "authority"    # Ljava/lang/String;

    .prologue
    .line 101
    const-string/jumbo v0, "/tokens"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private static getUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    .locals 3
    .param p0, "authority"    # Ljava/lang/String;
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 136
    const-string/jumbo v0, "content://%s%s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    const/4 v2, 0x1

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public static getUserdataUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "authority"    # Ljava/lang/String;

    .prologue
    .line 96
    const-string/jumbo v0, "/userdata"

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getUri(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method
