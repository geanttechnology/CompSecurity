.class public Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;
.super Ljava/lang/Object;
.source "RemoteAmazonDataStorage.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

.field private final mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const-class v0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "remoteMapInfo"    # Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .prologue
    .line 134
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 135
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mContext:Landroid/content/Context;

    .line 137
    new-instance v0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    invoke-direct {v0, p1}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    .line 139
    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .line 140
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private getBulkDataFromUri(Landroid/net/Uri;)Ljava/util/Collection;
    .locals 12
    .param p1, "getBulkDataUri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            ")",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 157
    const/4 v8, 0x0

    .line 160
    .local v8, "cursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    sget-object v1, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->QUERY_BULK_DATA_COLUMNS:Ljava/util/List;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v8

    .line 166
    if-nez v8, :cond_0

    .line 168
    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    .line 200
    :goto_0
    return-object v6

    .line 171
    :cond_0
    :try_start_1
    new-instance v6, Ljava/util/LinkedList;

    invoke-direct {v6}, Ljava/util/LinkedList;-><init>()V

    .line 173
    .local v6, "allData":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    if-nez v0, :cond_1

    .line 200
    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    goto :goto_0

    .line 180
    :cond_1
    :try_start_2
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    .line 181
    .local v9, "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    sget-object v0, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->QUERY_BULK_DATA_COLUMNS:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .local v10, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 183
    .local v7, "column":Ljava/lang/String;
    invoke-static {v8, v7}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 184
    .local v11, "value":Ljava/lang/String;
    if-eqz v7, :cond_2

    .line 186
    invoke-interface {v9, v7, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 200
    .end local v6    # "allData":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    .end local v7    # "column":Ljava/lang/String;
    .end local v9    # "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v10    # "i$":Ljava/util/Iterator;
    .end local v11    # "value":Ljava/lang/String;
    :catchall_0
    move-exception v0

    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    throw v0

    .line 192
    .restart local v6    # "allData":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    .restart local v9    # "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v10    # "i$":Ljava/util/Iterator;
    :cond_3
    :try_start_3
    invoke-interface {v6, v9}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 194
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result v0

    if-nez v0, :cond_1

    .line 200
    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    goto :goto_0
.end method


# virtual methods
.method public addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/util/Date;)Z
    .locals 11
    .param p1, "displayName"    # Ljava/lang/String;
    .param p2, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p3, "timestamp"    # Ljava/util/Date;

    .prologue
    .line 291
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    .line 293
    .local v2, "directedId":Ljava/lang/String;
    if-eqz p1, :cond_0

    if-eqz v2, :cond_0

    if-nez p3, :cond_1

    .line 295
    :cond_0
    const/4 v9, 0x0

    .line 335
    :goto_0
    return v9

    .line 297
    :cond_1
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 299
    .local v1, "bulkData":Ljava/util/List;, "Ljava/util/List<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 300
    .local v0, "accountDataMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v9, "display_name"

    invoke-interface {v0, v9, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 301
    const-string/jumbo v9, "directedId"

    invoke-interface {v0, v9, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 302
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 304
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getUserData()Ljava/util/Map;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 306
    .local v3, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 307
    .local v8, "userDataRow":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v9, "userdata_account"

    invoke-interface {v8, v9, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 308
    const-string/jumbo v9, "userdata_key"

    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v10

    invoke-interface {v8, v9, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 309
    const-string/jumbo v9, "userdata_value"

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v10

    invoke-interface {v8, v9, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 310
    invoke-interface {v1, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 313
    .end local v3    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v8    # "userDataRow":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_2
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getTokens()Ljava/util/Map;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 315
    .restart local v3    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .line 316
    .local v7, "tokenRow":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v9, "token_account"

    invoke-interface {v7, v9, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 317
    const-string/jumbo v9, "token_key"

    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v10

    invoke-interface {v7, v9, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 318
    const-string/jumbo v9, "token_value"

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v10

    invoke-interface {v7, v9, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 319
    invoke-interface {v1, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 324
    .end local v3    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v7    # "tokenRow":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_3
    invoke-virtual {p3}, Ljava/util/Date;->getTime()J

    move-result-wide v9

    invoke-static {v9, v10}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    .line 325
    .local v6, "timestampString":Ljava/lang/String;
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_3
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_4

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map;

    .line 328
    .local v4, "entry":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v9, "timestamp_key"

    invoke-interface {v4, v9, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 329
    const-string/jumbo v9, "deleted_key"

    const-string/jumbo v10, "false"

    invoke-interface {v4, v9, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_3

    .line 335
    .end local v4    # "entry":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_4
    invoke-virtual {p0, v1}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->setBulkData(Ljava/util/Collection;)Z

    move-result v9

    goto/16 :goto_0
.end method

.method public clearBulkData(Ljava/util/Collection;)Z
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)Z"
        }
    .end annotation

    .prologue
    .local p1, "bulkData":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 231
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getProviderAuthority()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getBulkDataUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 233
    .local v1, "setBulkDataUri":Landroid/net/Uri;
    invoke-static {p1}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->create(Ljava/util/Collection;)Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;

    move-result-object v0

    .line 234
    .local v0, "info":Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;
    if-nez v0, :cond_0

    .line 236
    sget-object v4, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Cannot construct selection to clear bulk data"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    move v2, v3

    .line 256
    :goto_0
    return v2

    .line 240
    :cond_0
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    iget-object v6, v0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->selection:Ljava/lang/String;

    iget-object v7, v0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->selectionArgs:[Ljava/lang/String;

    invoke-virtual {v5, v1, v6, v7}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v5

    .line 242
    if-lez v5, :cond_1

    move v2, v4

    .line 243
    .local v2, "success":Z
    :goto_1
    if-eqz v2, :cond_2

    .line 245
    sget-object v5, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "clear bulk data was successful with package %s."

    new-array v4, v4, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v3

    invoke-static {v5, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    goto :goto_0

    .end local v2    # "success":Z
    :cond_1
    move v2, v3

    .line 242
    goto :goto_1

    .line 251
    .restart local v2    # "success":Z
    :cond_2
    sget-object v5, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "clear bulk data was not successful with package %s."

    new-array v4, v4, [Ljava/lang/Object;

    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v7}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v3

    invoke-static {v6, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v5, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public expireToken(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Z
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "timestamp"    # Ljava/util/Date;

    .prologue
    const/4 v6, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 459
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getProviderAuthority()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getTokensUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 461
    .local v2, "tokenUri":Landroid/net/Uri;
    invoke-static {p1, p2, v6, v6, p3}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;

    move-result-object v0

    .line 463
    .local v0, "info":Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;
    if-nez v0, :cond_1

    .line 465
    sget-object v4, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Cannot construct selection to remove token"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 473
    :cond_0
    :goto_0
    return v3

    .line 469
    :cond_1
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mContext:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    iget-object v6, v0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->selection:Ljava/lang/String;

    iget-object v7, v0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->selectionArgs:[Ljava/lang/String;

    invoke-virtual {v5, v2, v6, v7}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 471
    .local v1, "removeCnt":I
    sget-object v5, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Expired %s tokens from package %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v3

    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v7}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v4

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 473
    if-eqz v1, :cond_0

    move v3, v4

    goto :goto_0
.end method

.method public getAccounts()Ljava/util/Set;
    .locals 9
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
    .line 261
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getProviderAuthority()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getAccountUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 262
    .local v1, "accountUri":Landroid/net/Uri;
    const/4 v7, 0x0

    .line 265
    .local v7, "cursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    sget-object v2, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->QUERY_COLUMNS:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 267
    new-instance v6, Ljava/util/HashSet;

    invoke-direct {v6}, Ljava/util/HashSet;-><init>()V

    .line 268
    .local v6, "accounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    if-eqz v7, :cond_0

    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_1

    .line 285
    :cond_0
    invoke-static {v7}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    :goto_0
    return-object v6

    .line 275
    :cond_1
    :try_start_1
    const-string/jumbo v0, "value"

    invoke-static {v7, v0}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 277
    .local v8, "directedId":Ljava/lang/String;
    invoke-interface {v6, v8}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 279
    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    if-nez v0, :cond_1

    .line 285
    invoke-static {v7}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    goto :goto_0

    .end local v6    # "accounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v8    # "directedId":Ljava/lang/String;
    :catchall_0
    move-exception v0

    invoke-static {v7}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->closeCursor(Landroid/database/Cursor;)V

    throw v0
.end method

.method public getAllData()Ljava/util/Collection;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 144
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getProviderAuthority()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getAllDataUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 145
    .local v0, "allDataUri":Landroid/net/Uri;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->getBulkDataFromUri(Landroid/net/Uri;)Ljava/util/Collection;

    move-result-object v1

    return-object v1
.end method

.method public getAllDeletedData()Ljava/util/Collection;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 150
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getProviderAuthority()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getAllDeletedDataUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 152
    .local v0, "allDataUri":Landroid/net/Uri;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->getBulkDataFromUri(Landroid/net/Uri;)Ljava/util/Collection;

    move-result-object v1

    return-object v1
.end method

.method public getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 478
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getProviderAuthority()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getDeviceDataUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 480
    .local v1, "deviceDataUri":Landroid/net/Uri;
    invoke-static {v5, p2, v5, p1, v5}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;

    move-result-object v6

    .line 482
    .local v6, "info":Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;
    if-nez v6, :cond_0

    .line 484
    sget-object v0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot construct selection to get device data"

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 488
    :goto_0
    return-object v5

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    const-string/jumbo v2, "value"

    iget-object v3, v6, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->selection:Ljava/lang/String;

    iget-object v4, v6, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->selectionArgs:[Ljava/lang/String;

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->querySingleResult(Lcom/amazon/identity/auth/device/framework/SecureContentResolver;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    goto :goto_0
.end method

.method public getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 410
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getProviderAuthority()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getTokensUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 412
    .local v1, "tokenUri":Landroid/net/Uri;
    invoke-static {p1, p2, v5, v5, v5}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;

    move-result-object v6

    .line 414
    .local v6, "info":Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;
    if-nez v6, :cond_0

    .line 416
    sget-object v0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot construct selection to get token"

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 420
    :goto_0
    return-object v5

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    const-string/jumbo v2, "value"

    iget-object v3, v6, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->selection:Ljava/lang/String;

    iget-object v4, v6, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->selectionArgs:[Ljava/lang/String;

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->querySingleResult(Lcom/amazon/identity/auth/device/framework/SecureContentResolver;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    goto :goto_0
.end method

.method public getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 359
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getProviderAuthority()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getUserdataUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 361
    .local v1, "userdataUri":Landroid/net/Uri;
    invoke-static {p1, p2, v5, v5, v5}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;

    move-result-object v6

    .line 363
    .local v6, "info":Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;
    if-nez v6, :cond_0

    .line 365
    sget-object v0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot construct selection to get user data"

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 369
    :goto_0
    return-object v5

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    const-string/jumbo v2, "value"

    iget-object v3, v6, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->selection:Ljava/lang/String;

    iget-object v4, v6, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->selectionArgs:[Ljava/lang/String;

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->querySingleResult(Lcom/amazon/identity/auth/device/framework/SecureContentResolver;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    goto :goto_0
.end method

.method public removeAccount(Ljava/lang/String;Ljava/util/Date;)Z
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "timestamp"    # Ljava/util/Date;

    .prologue
    const/4 v4, 0x1

    const/4 v6, 0x0

    const/4 v3, 0x0

    .line 340
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getProviderAuthority()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getAccountUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 342
    .local v0, "accountUri":Landroid/net/Uri;
    invoke-static {p1, v6, v6, v6, p2}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;

    move-result-object v1

    .line 344
    .local v1, "info":Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;
    if-nez v1, :cond_1

    .line 346
    sget-object v4, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Cannot construct selection to remove account"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 354
    :cond_0
    :goto_0
    return v3

    .line 350
    :cond_1
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    iget-object v6, v1, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->selection:Ljava/lang/String;

    iget-object v7, v1, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->selectionArgs:[Ljava/lang/String;

    invoke-virtual {v5, v0, v6, v7}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    .line 352
    .local v2, "removeCnt":I
    sget-object v5, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Removed %s accounts from package %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v3

    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v7}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v4

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 354
    if-eqz v2, :cond_0

    move v3, v4

    goto :goto_0
.end method

.method public setBulkData(Ljava/util/Collection;)Z
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)Z"
        }
    .end annotation

    .prologue
    .local p1, "bulkData":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 206
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getProviderAuthority()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getBulkDataUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 208
    .local v0, "setBulkDataUri":Landroid/net/Uri;
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 209
    .local v2, "values":Landroid/content/ContentValues;
    const-string/jumbo v5, "bulk_data"

    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->listOfMapOfStringsToString(Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 211
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    invoke-virtual {v5, v0, v2}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v5

    .line 213
    if-eqz v5, :cond_0

    move v1, v3

    .line 214
    .local v1, "success":Z
    :goto_0
    if-eqz v1, :cond_1

    .line 216
    sget-object v5, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "set bulk data was successful with package %s."

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v3, v4

    invoke-static {v5, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 226
    :goto_1
    return v1

    .end local v1    # "success":Z
    :cond_0
    move v1, v4

    .line 213
    goto :goto_0

    .line 222
    .restart local v1    # "success":Z
    :cond_1
    sget-object v5, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "set bulk data was not successful with package %s."

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v7}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v3, v4

    invoke-static {v6, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v5, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Z
    .locals 8
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;
    .param p4, "timestamp"    # Ljava/util/Date;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 498
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getProviderAuthority()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getDeviceDataUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 500
    .local v0, "deviceDataUri":Landroid/net/Uri;
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 501
    .local v2, "values":Landroid/content/ContentValues;
    const-string/jumbo v5, "namespace"

    invoke-virtual {v2, v5, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 502
    const-string/jumbo v5, "key"

    invoke-virtual {v2, v5, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 503
    const-string/jumbo v5, "value"

    invoke-virtual {v2, v5, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 504
    if-eqz p4, :cond_0

    .line 506
    const-string/jumbo v5, "timestamp_key"

    invoke-virtual {p4}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 509
    :cond_0
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mContext:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    invoke-virtual {v5, v0, v2}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v5

    .line 511
    if-eqz v5, :cond_1

    move v1, v3

    .line 512
    .local v1, "success":Z
    :goto_0
    if-eqz v1, :cond_2

    .line 514
    sget-object v5, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "set device data was successful with package %s."

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v3, v4

    invoke-static {v5, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 524
    :goto_1
    return v1

    .end local v1    # "success":Z
    :cond_1
    move v1, v4

    .line 511
    goto :goto_0

    .line 519
    .restart local v1    # "success":Z
    :cond_2
    sget-object v5, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "set device daya was not successful with package %s."

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v7}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v3, v4

    invoke-static {v6, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v5, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Z
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "token"    # Ljava/lang/String;
    .param p4, "timestamp"    # Ljava/util/Date;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 430
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getProviderAuthority()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getTokensUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 432
    .local v1, "tokenUri":Landroid/net/Uri;
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 433
    .local v2, "values":Landroid/content/ContentValues;
    const-string/jumbo v5, "directedId"

    invoke-virtual {v2, v5, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 434
    const-string/jumbo v5, "key"

    invoke-virtual {v2, v5, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 435
    const-string/jumbo v5, "value"

    invoke-virtual {v2, v5, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 436
    if-eqz p4, :cond_0

    .line 438
    const-string/jumbo v5, "timestamp_key"

    invoke-virtual {p4}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 441
    :cond_0
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mContext:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    invoke-virtual {v5, v1, v2}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v5

    .line 443
    if-eqz v5, :cond_1

    move v0, v3

    .line 444
    .local v0, "success":Z
    :goto_0
    if-eqz v0, :cond_2

    .line 446
    sget-object v5, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "set token was successful with package %s."

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v3, v4

    invoke-static {v5, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 454
    :goto_1
    return v0

    .end local v0    # "success":Z
    :cond_1
    move v0, v4

    .line 443
    goto :goto_0

    .line 450
    .restart local v0    # "success":Z
    :cond_2
    sget-object v5, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "set token was not successful with package %s."

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v7}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v3, v4

    invoke-static {v6, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v5, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Z
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;
    .param p4, "timestamp"    # Ljava/util/Date;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 379
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getProviderAuthority()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->getUserdataUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 381
    .local v1, "userdataUri":Landroid/net/Uri;
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 382
    .local v2, "values":Landroid/content/ContentValues;
    const-string/jumbo v5, "directedId"

    invoke-virtual {v2, v5, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 383
    const-string/jumbo v5, "key"

    invoke-virtual {v2, v5, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 384
    const-string/jumbo v5, "value"

    invoke-virtual {v2, v5, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 385
    if-eqz p4, :cond_0

    .line 387
    const-string/jumbo v5, "timestamp_key"

    invoke-virtual {p4}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 390
    :cond_0
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mContext:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    invoke-virtual {v5, v1, v2}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v5

    .line 392
    if-eqz v5, :cond_1

    move v0, v3

    .line 393
    .local v0, "success":Z
    :goto_0
    if-eqz v0, :cond_2

    .line 395
    sget-object v5, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "set userdata was successful with package %s."

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v3, v4

    invoke-static {v5, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 405
    :goto_1
    return v0

    .end local v0    # "success":Z
    :cond_1
    move v0, v4

    .line 392
    goto :goto_0

    .line 401
    .restart local v0    # "success":Z
    :cond_2
    sget-object v5, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "set userdata was not successful with package %s."

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->mProviderInfo:Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    invoke-virtual {v7}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v3, v4

    invoke-static {v6, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v5, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method
