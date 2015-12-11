.class final Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;
.super Ljava/lang/Object;
.source "RemoteAmazonDataStorage.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "SelectionContentProviderInfo"
.end annotation


# instance fields
.field public final selection:Ljava/lang/String;

.field public final selectionArgs:[Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 0
    .param p1, "givenSelection"    # Ljava/lang/String;
    .param p2, "givenSelectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->selection:Ljava/lang/String;

    .line 47
    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->selectionArgs:[Ljava/lang/String;

    .line 48
    return-void
.end method

.method private static addValueToSelection(Ljava/util/LinkedHashMap;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 117
    .local p0, "selection":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p1, "selectionArgs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez p3, :cond_0

    .line 125
    :goto_0
    return-void

    .line 122
    :cond_0
    const-string/jumbo v0, "?"

    invoke-virtual {p0, p2, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 124
    invoke-interface {p1, p3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public static create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;
    .locals 6
    .param p0, "directedId"    # Ljava/lang/String;
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "namespace"    # Ljava/lang/String;
    .param p4, "timestamp"    # Ljava/util/Date;

    .prologue
    .line 58
    :try_start_0
    new-instance v1, Ljava/util/LinkedHashMap;

    invoke-direct {v1}, Ljava/util/LinkedHashMap;-><init>()V

    .line 59
    .local v1, "selection":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 61
    .local v2, "selectionArgs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string/jumbo v3, "directedId"

    invoke-static {v1, v2, v3, p0}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->addValueToSelection(Ljava/util/LinkedHashMap;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    const-string/jumbo v3, "key"

    invoke-static {v1, v2, v3, p1}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->addValueToSelection(Ljava/util/LinkedHashMap;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    const-string/jumbo v3, "value"

    invoke-static {v1, v2, v3, p2}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->addValueToSelection(Ljava/util/LinkedHashMap;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    const-string/jumbo v3, "namespace"

    invoke-static {v1, v2, v3, p3}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->addValueToSelection(Ljava/util/LinkedHashMap;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V

    .line 68
    const-string/jumbo v3, "timestamp_key"

    invoke-static {p4}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->serialize(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->addValueToSelection(Ljava/util/LinkedHashMap;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    new-instance v4, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->toJsonString(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v5

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/String;

    invoke-interface {v2, v3}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Ljava/lang/String;

    invoke-direct {v4, v5, v3}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;-><init>(Ljava/lang/String;[Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v3, v4

    .line 78
    .end local v1    # "selection":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v2    # "selectionArgs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :goto_0
    return-object v3

    .line 73
    :catch_0
    move-exception v0

    .line 75
    .local v0, "e":Lorg/json/JSONException;
    # getter for: Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->access$000()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "Error consturcting selection. Error: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 78
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public static create(Ljava/util/Collection;)Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)",
            "Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;"
        }
    .end annotation

    .prologue
    .line 85
    .local p0, "bulkData":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    :try_start_0
    new-instance v1, Ljava/util/LinkedHashMap;

    invoke-direct {v1}, Ljava/util/LinkedHashMap;-><init>()V

    .line 86
    .local v1, "selection":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 88
    .local v2, "selectionArgs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string/jumbo v3, "bulk_data"

    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->listOfMapOfStringsToString(Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;->addValueToSelection(Ljava/util/LinkedHashMap;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    new-instance v4, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->toJsonString(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v5

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/String;

    invoke-interface {v2, v3}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Ljava/lang/String;

    invoke-direct {v4, v5, v3}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage$SelectionContentProviderInfo;-><init>(Ljava/lang/String;[Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v3, v4

    .line 101
    .end local v1    # "selection":Ljava/util/LinkedHashMap;, "Ljava/util/LinkedHashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v2    # "selectionArgs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :goto_0
    return-object v3

    .line 96
    :catch_0
    move-exception v0

    .line 98
    .local v0, "e":Lorg/json/JSONException;
    # getter for: Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/storage/RemoteAmazonDataStorage;->access$000()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "Error consturcting selection. Error: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    const/4 v3, 0x0

    goto :goto_0
.end method
