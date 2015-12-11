.class Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;
.super Ljava/lang/Object;
.source "MAPInformationProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/MAPInformationProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SelectionInfo"
.end annotation


# static fields
.field private static final EMPTY_SELECTION_INFO:Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;


# instance fields
.field public final bulkData:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field public final directedId:Ljava/lang/String;

.field public final displayName:Ljava/lang/String;

.field public final key:Ljava/lang/String;

.field public final namespace:Ljava/lang/String;

.field public final timestamp:Ljava/util/Date;

.field public final userdata:Landroid/os/Bundle;

.field public final value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v1, 0x0

    .line 57
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;

    move-object v2, v1

    move-object v3, v1

    move-object v4, v1

    move-object v5, v1

    move-object v6, v1

    move-object v7, v1

    move-object v8, v1

    invoke-direct/range {v0 .. v8}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->EMPTY_SELECTION_INFO:Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;)V
    .locals 1
    .param p1, "givenDirectedId"    # Ljava/lang/String;
    .param p2, "givenKey"    # Ljava/lang/String;
    .param p3, "givenValue"    # Ljava/lang/String;
    .param p4, "givenNamespace"    # Ljava/lang/String;
    .param p5, "givenDisplayName"    # Ljava/lang/String;
    .param p6, "givenSeralizedUserdata"    # Ljava/lang/String;
    .param p7, "givenTimestamp"    # Ljava/util/Date;
    .param p8, "givenBulkData"    # Ljava/lang/String;

    .prologue
    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 84
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->directedId:Ljava/lang/String;

    .line 85
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->key:Ljava/lang/String;

    .line 86
    iput-object p3, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->value:Ljava/lang/String;

    .line 87
    iput-object p4, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->namespace:Ljava/lang/String;

    .line 88
    iput-object p5, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->displayName:Ljava/lang/String;

    .line 89
    invoke-static {p6}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->stringToBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->userdata:Landroid/os/Bundle;

    .line 90
    iput-object p7, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->timestamp:Ljava/util/Date;

    .line 91
    invoke-static {p8}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->stringToListOfMapOfStrings(Ljava/lang/String;)Ljava/util/Collection;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->bulkData:Ljava/util/Collection;

    .line 92
    return-void
.end method

.method public static parseSelection(Landroid/content/ContentValues;)Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;
    .locals 10
    .param p0, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 96
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;

    const-string/jumbo v1, "directedId"

    invoke-virtual {p0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "key"

    invoke-virtual {p0, v2}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "value"

    invoke-virtual {p0, v3}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "namespace"

    invoke-virtual {p0, v4}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "display_name"

    invoke-virtual {p0, v5}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "userdata_bundle_key"

    invoke-virtual {p0, v6}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "timestamp_key"

    invoke-virtual {p0, v7}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v8

    if-nez v8, :cond_0

    const/4 v7, 0x0

    :goto_0
    const-string/jumbo v8, "bulk_data"

    invoke-virtual {p0, v8}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-direct/range {v0 .. v8}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;)V

    return-object v0

    :cond_0
    new-instance v7, Ljava/util/Date;

    invoke-virtual {v8}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    invoke-direct {v7, v8, v9}, Ljava/util/Date;-><init>(J)V

    goto :goto_0
.end method

.method public static parseSelection(Ljava/lang/String;[Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;
    .locals 14
    .param p0, "selection"    # Ljava/lang/String;
    .param p1, "givenSelectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 110
    if-nez p0, :cond_0

    .line 112
    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;->EMPTY_SELECTION_INFO:Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;

    .line 155
    :goto_0
    return-object v0

    .line 115
    :cond_0
    if-nez p1, :cond_2

    const/4 v0, 0x0

    new-array v12, v0, [Ljava/lang/String;

    .line 117
    .local v12, "selectionArgs":[Ljava/lang/String;
    :cond_1
    const-string/jumbo v0, "\"?\""

    const-string/jumbo v1, "%s"

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 119
    check-cast v12, [Ljava/lang/Object;

    .end local v12    # "selectionArgs":[Ljava/lang/String;
    invoke-static {v0, v12}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    .line 121
    .local v11, "processedSelection":Ljava/lang/String;
    new-instance v10, Lorg/json/JSONObject;

    invoke-direct {v10, v11}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 123
    .local v10, "jsonSelection":Lorg/json/JSONObject;
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;

    const-string/jumbo v1, "directedId"

    const/4 v2, 0x0

    invoke-static {v10, v1, v2}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "key"

    const/4 v3, 0x0

    invoke-static {v10, v2, v3}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "value"

    const/4 v4, 0x0

    invoke-static {v10, v3, v4}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "namespace"

    const/4 v5, 0x0

    invoke-static {v10, v4, v5}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "display_name"

    const/4 v6, 0x0

    invoke-static {v10, v5, v6}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "userdata_bundle_key"

    const/4 v7, 0x0

    invoke-static {v10, v6, v7}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "timestamp_key"

    const/4 v8, 0x0

    invoke-static {v10, v7, v8}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->deserialize(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v7

    const-string/jumbo v8, "bulk_data"

    const/4 v13, 0x0

    invoke-static {v10, v8, v13}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-direct/range {v0 .. v8}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider$SelectionInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/util/IllegalFormatException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 146
    .end local v10    # "jsonSelection":Lorg/json/JSONObject;
    .end local v11    # "processedSelection":Ljava/lang/String;
    :catch_0
    move-exception v9

    .line 148
    .local v9, "e":Ljava/util/IllegalFormatException;
    # getter for: Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->access$000()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Format not valid. Error: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9}, Ljava/util/IllegalFormatException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    .end local v9    # "e":Ljava/util/IllegalFormatException;
    :goto_1
    const/4 v0, 0x0

    goto/16 :goto_0

    .line 115
    :cond_2
    :try_start_1
    array-length v0, p1

    new-array v12, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    :goto_2
    array-length v1, p1

    if-ge v0, v1, :cond_1

    aget-object v1, p1, v0

    invoke-static {v1}, Lorg/json/JSONObject;->quote(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v12, v0
    :try_end_1
    .catch Ljava/util/IllegalFormatException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 150
    :catch_1
    move-exception v9

    .line 152
    .local v9, "e":Lorg/json/JSONException;
    # getter for: Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/MAPInformationProvider;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Format was not valid JSON"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method
