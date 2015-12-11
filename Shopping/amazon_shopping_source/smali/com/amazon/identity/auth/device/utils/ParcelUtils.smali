.class public final Lcom/amazon/identity/auth/device/utils/ParcelUtils;
.super Ljava/lang/Object;
.source "ParcelUtils.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/amazon/identity/auth/device/utils/ParcelUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    return-void
.end method

.method public static bundleToString(Landroid/os/Bundle;)Ljava/lang/String;
    .locals 2
    .param p0, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 87
    if-nez p0, :cond_0

    .line 89
    const/4 v1, 0x0

    .line 101
    :goto_0
    return-object v1

    .line 92
    :cond_0
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 95
    .local v0, "serialize":Landroid/os/Parcel;
    :try_start_0
    invoke-virtual {v0, p0}, Landroid/os/Parcel;->writeBundle(Landroid/os/Bundle;)V

    .line 97
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->parcelToString(Landroid/os/Parcel;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 101
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    goto :goto_0

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    throw v1
.end method

.method public static deserialize(Ljava/lang/String;)Ljava/io/Serializable;
    .locals 2
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 180
    if-nez p0, :cond_0

    .line 182
    const/4 v1, 0x0

    .line 192
    :goto_0
    return-object v1

    .line 185
    :cond_0
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->seralizedParcelStringToParcel(Ljava/lang/String;)Landroid/os/Parcel;

    move-result-object v0

    .line 188
    .local v0, "p":Landroid/os/Parcel;
    :try_start_0
    invoke-virtual {v0}, Landroid/os/Parcel;->readSerializable()Ljava/io/Serializable;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 192
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    goto :goto_0

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    throw v1
.end method

.method public static listOfMapOfStringsToString(Ljava/util/Collection;)Ljava/lang/String;
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
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 33
    .local p0, "collectionOfMaps":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    if-nez p0, :cond_0

    .line 35
    const/4 v5, 0x0

    .line 52
    :goto_0
    return-object v5

    .line 38
    :cond_0
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v4

    .line 41
    .local v4, "serialize":Landroid/os/Parcel;
    :try_start_0
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 42
    .local v3, "serializableCollection":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 44
    .local v0, "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2, v0}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    .line 45
    .local v2, "newData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 52
    .end local v0    # "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "newData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "serializableCollection":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    :catchall_0
    move-exception v5

    invoke-virtual {v4}, Landroid/os/Parcel;->recycle()V

    throw v5

    .line 47
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v3    # "serializableCollection":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    :cond_1
    :try_start_1
    invoke-virtual {v4, v3}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 48
    invoke-static {v4}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->parcelToString(Landroid/os/Parcel;)Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v5

    .line 52
    invoke-virtual {v4}, Landroid/os/Parcel;->recycle()V

    goto :goto_0
.end method

.method private static parcelToString(Landroid/os/Parcel;)Ljava/lang/String;
    .locals 2
    .param p0, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 142
    invoke-virtual {p0}, Landroid/os/Parcel;->marshall()[B

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static seralizedParcelStringToParcel(Ljava/lang/String;)Landroid/os/Parcel;
    .locals 4
    .param p0, "base64SeralizedValue"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 147
    invoke-static {p0, v3}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v1

    .line 148
    .local v1, "seralizedValue":[B
    if-nez v1, :cond_0

    .line 150
    const/4 v0, 0x0

    .line 156
    :goto_0
    return-object v0

    .line 153
    :cond_0
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 154
    .local v0, "parcel":Landroid/os/Parcel;
    array-length v2, v1

    invoke-virtual {v0, v1, v3, v2}, Landroid/os/Parcel;->unmarshall([BII)V

    .line 155
    invoke-virtual {v0, v3}, Landroid/os/Parcel;->setDataPosition(I)V

    goto :goto_0
.end method

.method public static serialize(Ljava/io/Serializable;)Ljava/lang/String;
    .locals 2
    .param p0, "serializable"    # Ljava/io/Serializable;

    .prologue
    .line 161
    if-nez p0, :cond_0

    .line 163
    const/4 v1, 0x0

    .line 174
    :goto_0
    return-object v1

    .line 166
    :cond_0
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 169
    .local v0, "p":Landroid/os/Parcel;
    :try_start_0
    invoke-virtual {v0, p0}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 170
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->parcelToString(Landroid/os/Parcel;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 174
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    goto :goto_0

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    throw v1
.end method

.method public static stringToBundle(Ljava/lang/String;)Landroid/os/Bundle;
    .locals 5
    .param p0, "seralizedBundle"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 112
    if-nez p0, :cond_1

    .line 136
    :cond_0
    :goto_0
    return-object v2

    .line 119
    :cond_1
    :try_start_0
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->seralizedParcelStringToParcel(Ljava/lang/String;)Landroid/os/Parcel;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 120
    .local v1, "parcel":Landroid/os/Parcel;
    if-eqz v1, :cond_0

    .line 126
    :try_start_1
    invoke-virtual {v1}, Landroid/os/Parcel;->readBundle()Landroid/os/Bundle;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v3

    .line 130
    :try_start_2
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    move-object v2, v3

    goto :goto_0

    :catchall_0
    move-exception v3

    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    throw v3
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 133
    .end local v1    # "parcel":Landroid/os/Parcel;
    :catch_0
    move-exception v0

    .line 135
    .local v0, "e":Ljava/lang/Exception;
    sget-object v3, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Failed to deserialize parcel"

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static stringToListOfMapOfStrings(Ljava/lang/String;)Ljava/util/Collection;
    .locals 2
    .param p0, "seralizedListOfMapOfStrings"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
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
    const/4 v1, 0x0

    .line 59
    if-nez p0, :cond_1

    .line 75
    :cond_0
    :goto_0
    return-object v1

    .line 64
    :cond_1
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->seralizedParcelStringToParcel(Ljava/lang/String;)Landroid/os/Parcel;

    move-result-object v0

    .line 65
    .local v0, "parcel":Landroid/os/Parcel;
    if-eqz v0, :cond_0

    .line 71
    :try_start_0
    invoke-virtual {v0}, Landroid/os/Parcel;->readSerializable()Ljava/io/Serializable;

    move-result-object v1

    check-cast v1, Ljava/util/Collection;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 75
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    goto :goto_0

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    throw v1
.end method

.method public static toSerializedBundleString(Ljava/util/Set;)Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 204
    .local p0, "strings":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    const-string/jumbo v2, "string_array"

    invoke-interface {p0}, Ljava/util/Set;->size()I

    move-result v0

    new-array v0, v0, [Ljava/lang/String;

    invoke-interface {p0, v0}, Ljava/util/Set;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putStringArray(Ljava/lang/String;[Ljava/lang/String;)V

    .line 205
    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->bundleToString(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static toStringSet(Ljava/lang/String;)Ljava/util/Set;
    .locals 5
    .param p0, "serializedBundle"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 215
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->stringToBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 216
    .local v0, "bundle":Landroid/os/Bundle;
    if-nez v0, :cond_0

    .line 218
    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    .line 235
    :goto_0
    return-object v3

    .line 224
    :cond_0
    :try_start_0
    const-string/jumbo v3, "string_array"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 231
    .local v2, "strings":[Ljava/lang/String;
    :goto_1
    if-nez v2, :cond_1

    .line 233
    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    goto :goto_0

    .line 226
    .end local v2    # "strings":[Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 228
    .local v1, "e":Ljava/lang/Exception;
    sget-object v3, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Failed to deserialize parcel"

    invoke-static {v3, v4, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 229
    const/4 v2, 0x0

    .restart local v2    # "strings":[Ljava/lang/String;
    goto :goto_1

    .line 235
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_1
    new-instance v3, Ljava/util/HashSet;

    invoke-static {v2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    goto :goto_0
.end method
