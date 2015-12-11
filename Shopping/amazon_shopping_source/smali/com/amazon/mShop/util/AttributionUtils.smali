.class public Lcom/amazon/mShop/util/AttributionUtils;
.super Ljava/lang/Object;
.source "AttributionUtils.java"


# static fields
.field private static final ASSOCIATE_TAG_REGION_CODES:[Ljava/lang/String;

.field public static final sDefaultAssocTags:[Ljava/lang/String;

.field private static final sMapFromLocaleToTagCode:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 29
    new-array v0, v4, [Ljava/lang/String;

    const-string/jumbo v1, "mshop-android-amazon"

    aput-object v1, v0, v2

    const-string/jumbo v1, "mshop-android-amazon-venezia"

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/mShop/util/AttributionUtils;->sDefaultAssocTags:[Ljava/lang/String;

    .line 42
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const-string/jumbo v1, "20"

    aput-object v1, v0, v2

    const-string/jumbo v1, "21"

    aput-object v1, v0, v3

    const-string/jumbo v1, "22"

    aput-object v1, v0, v4

    const/4 v1, 0x3

    const-string/jumbo v2, "23"

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mShop/util/AttributionUtils;->ASSOCIATE_TAG_REGION_CODES:[Ljava/lang/String;

    .line 44
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/util/AttributionUtils;->sMapFromLocaleToTagCode:Ljava/util/Map;

    .line 46
    sget-object v0, Lcom/amazon/mShop/util/AttributionUtils;->sMapFromLocaleToTagCode:Ljava/util/Map;

    const-string/jumbo v1, "de_DE"

    const-string/jumbo v2, "de-21"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    sget-object v0, Lcom/amazon/mShop/util/AttributionUtils;->sMapFromLocaleToTagCode:Ljava/util/Map;

    const-string/jumbo v1, "en_GB"

    const-string/jumbo v2, "uk-21"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 48
    sget-object v0, Lcom/amazon/mShop/util/AttributionUtils;->sMapFromLocaleToTagCode:Ljava/util/Map;

    const-string/jumbo v1, "en_US"

    const-string/jumbo v2, "us-20"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    sget-object v0, Lcom/amazon/mShop/util/AttributionUtils;->sMapFromLocaleToTagCode:Ljava/util/Map;

    const-string/jumbo v1, "fr_FR"

    const-string/jumbo v2, "fr-21"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    sget-object v0, Lcom/amazon/mShop/util/AttributionUtils;->sMapFromLocaleToTagCode:Ljava/util/Map;

    const-string/jumbo v1, "it_IT"

    const-string/jumbo v2, "it-21"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    sget-object v0, Lcom/amazon/mShop/util/AttributionUtils;->sMapFromLocaleToTagCode:Ljava/util/Map;

    const-string/jumbo v1, "es_ES"

    const-string/jumbo v2, "es-21"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    sget-object v0, Lcom/amazon/mShop/util/AttributionUtils;->sMapFromLocaleToTagCode:Ljava/util/Map;

    const-string/jumbo v1, "ja_JP"

    const-string/jumbo v2, "jp-22"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    sget-object v0, Lcom/amazon/mShop/util/AttributionUtils;->sMapFromLocaleToTagCode:Ljava/util/Map;

    const-string/jumbo v1, "zh_CN"

    const-string/jumbo v2, "cn-23"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    sget-object v0, Lcom/amazon/mShop/util/AttributionUtils;->sMapFromLocaleToTagCode:Ljava/util/Map;

    const-string/jumbo v1, "en_CA"

    const-string/jumbo v2, "ca-20"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 55
    sget-object v0, Lcom/amazon/mShop/util/AttributionUtils;->sMapFromLocaleToTagCode:Ljava/util/Map;

    const-string/jumbo v1, "fr_CA"

    const-string/jumbo v2, "ca-20"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 56
    sget-object v0, Lcom/amazon/mShop/util/AttributionUtils;->sMapFromLocaleToTagCode:Ljava/util/Map;

    const-string/jumbo v1, "en_IN"

    const-string/jumbo v2, "in-21"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 57
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static appendMarketplaceToAssociateTag(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
    .locals 2
    .param p0, "associateTag"    # Ljava/lang/StringBuilder;

    .prologue
    .line 70
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v0

    .line 71
    .local v0, "currentLocaleName":Ljava/lang/String;
    const-string/jumbo v1, "-"

    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 72
    sget-object v1, Lcom/amazon/mShop/util/AttributionUtils;->sMapFromLocaleToTagCode:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 78
    return-object p0
.end method

.method private static getAssociateTagUsingMechanismOfOemConfigFile(Landroid/content/Context;)Ljava/lang/String;
    .locals 9
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 213
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/util/R$string;->config_oemConfigFileName:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 214
    .local v4, "oemConfigurationFileName":Ljava/lang/String;
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 215
    .local v3, "oemConfigFile":Ljava/io/File;
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v7

    if-nez v7, :cond_0

    .line 217
    const-string/jumbo v7, ""

    .line 243
    :goto_0
    return-object v7

    .line 221
    :cond_0
    sget v7, Lcom/amazon/mShop/android/util/R$raw;->distribution:I

    invoke-static {p0, v7}, Lcom/amazon/mShop/util/AttributionUtils;->readStringFromRawResourceFile(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 222
    .local v0, "distribution":Ljava/lang/String;
    const-string/jumbo v7, "market"

    invoke-virtual {v7, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 224
    new-instance v6, Ljava/util/Properties;

    invoke-direct {v6}, Ljava/util/Properties;-><init>()V

    .line 226
    .local v6, "props":Ljava/util/Properties;
    :try_start_0
    new-instance v7, Ljava/io/FileInputStream;

    invoke-direct {v7, v4}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v7}, Ljava/util/Properties;->load(Ljava/io/InputStream;)V

    .line 228
    const-string/jumbo v7, "override"

    invoke-virtual {v6, v7}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    .line 229
    .local v5, "override":Ljava/lang/String;
    const-string/jumbo v7, "true"

    invoke-virtual {v7, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    .line 230
    .local v2, "marketTagOverrideOemTag":Z
    if-nez v2, :cond_1

    .line 232
    invoke-static {p0}, Lcom/amazon/mShop/util/AttributionUtils;->readAssociateTagFromOemConfigFile(Landroid/content/Context;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v7

    goto :goto_0

    .line 234
    .end local v2    # "marketTagOverrideOemTag":Z
    .end local v5    # "override":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 235
    .local v1, "e":Ljava/lang/Exception;
    const-string/jumbo v7, "Amazon"

    invoke-static {v7, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 243
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v6    # "props":Ljava/util/Properties;
    :cond_1
    const-string/jumbo v7, ""

    goto :goto_0

    .line 238
    :cond_2
    const-string/jumbo v7, "oem"

    invoke-virtual {v7, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 240
    invoke-static {p0}, Lcom/amazon/mShop/util/AttributionUtils;->readAssociateTagFromOemConfigFile(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v7

    goto :goto_0
.end method

.method public static getAssociatesTag(Landroid/content/Context;)Ljava/lang/String;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 117
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v3

    const/4 v4, 0x1

    invoke-static {p0, v3, v4}, Lcom/amazon/mShop/util/AttributionUtils;->readAssociatesTag(Landroid/content/Context;Lcom/amazon/rio/j2me/client/persistence/DataStore;Z)Ljava/lang/String;

    move-result-object v1

    .line 119
    .local v1, "associateTag":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 120
    const-string/jumbo v3, "Amazon"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "missing associate tag : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 146
    :goto_0
    return-object v1

    .line 125
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 127
    .local v2, "sb":Ljava/lang/StringBuilder;
    invoke-static {v2}, Lcom/amazon/mShop/util/AttributionUtils;->trimMarketplaceFromAssociateTag(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 129
    .local v0, "assocTagNoMarketPlace":Ljava/lang/String;
    sget-object v3, Lcom/amazon/mShop/util/AttributionUtils;->sDefaultAssocTags:[Ljava/lang/String;

    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 132
    const-string/jumbo v1, ""

    goto :goto_0

    .line 135
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v3

    const-string/jumbo v4, "associatesTagWithoutLocaleCode"

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    invoke-static {v2}, Lcom/amazon/mShop/util/AttributionUtils;->appendMarketplaceToAssociateTag(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;

    .line 138
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public static getTrimmedAssociateTag(Landroid/content/Context;Lcom/amazon/rio/j2me/client/persistence/DataStore;Z)Ljava/lang/String;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "dataStore"    # Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .param p2, "readFromRawResource"    # Z

    .prologue
    .line 185
    invoke-static {p0, p1, p2}, Lcom/amazon/mShop/util/AttributionUtils;->readAssociatesTag(Landroid/content/Context;Lcom/amazon/rio/j2me/client/persistence/DataStore;Z)Ljava/lang/String;

    move-result-object v0

    .line 186
    .local v0, "rawAssociateTag":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Lcom/amazon/mShop/util/AttributionUtils;->trimMarketplaceFromAssociateTag(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private static hasOemConfigFile(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 333
    if-nez p0, :cond_0

    .line 334
    const/4 v0, 0x0

    .line 336
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/util/R$bool;->config_hasOemConfigFile:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v0

    goto :goto_0
.end method

.method private static readAssociateTagFromOemConfigFile(Landroid/content/Context;)Ljava/lang/String;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 290
    const-string/jumbo v0, ""

    .line 292
    .local v0, "associateTag":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/util/R$string;->config_oemConfigFileName:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 294
    .local v3, "oemConfigurationFileName":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/util/R$string;->config_associateTagPrefix:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 296
    .local v4, "prefixForAssociateTag":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 298
    new-instance v5, Ljava/util/Properties;

    invoke-direct {v5}, Ljava/util/Properties;-><init>()V

    .line 300
    .local v5, "props":Ljava/util/Properties;
    :try_start_0
    new-instance v6, Ljava/io/FileInputStream;

    invoke-direct {v6, v3}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v6}, Ljava/util/Properties;->load(Ljava/io/InputStream;)V

    .line 302
    const-string/jumbo v6, "OEMtag"

    invoke-virtual {v5, v6}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 304
    .local v2, "encryptedAssociateTag":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 306
    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mShop/util/SecurityUtil;->decryptHex(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 310
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    invoke-virtual {v0, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 311
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .end local v2    # "encryptedAssociateTag":Ljava/lang/String;
    .end local v5    # "props":Ljava/util/Properties;
    :cond_0
    move-object v6, v0

    .line 322
    :goto_0
    return-object v6

    .line 315
    .restart local v5    # "props":Ljava/util/Properties;
    :catch_0
    move-exception v1

    .line 316
    .local v1, "e":Ljava/lang/Exception;
    const-string/jumbo v6, "Amazon"

    invoke-static {v6, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 318
    const-string/jumbo v6, ""

    goto :goto_0
.end method

.method public static readAssociatesTag(Landroid/content/Context;Lcom/amazon/rio/j2me/client/persistence/DataStore;Z)Ljava/lang/String;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "dataStore"    # Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .param p2, "readFromRawResource"    # Z

    .prologue
    .line 157
    const-string/jumbo v1, "associatesTagWithoutLocaleCode"

    invoke-interface {p1, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 160
    .local v0, "associateTag":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 161
    const-string/jumbo v1, "amazonAssociatesTag"

    invoke-interface {p1, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 164
    :cond_0
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 165
    invoke-static {p0}, Lcom/amazon/mShop/util/AttributionUtils;->hasOemConfigFile(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 167
    invoke-static {p0}, Lcom/amazon/mShop/util/AttributionUtils;->getAssociateTagUsingMechanismOfOemConfigFile(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 169
    :cond_1
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    if-eqz p2, :cond_2

    .line 171
    sget v1, Lcom/amazon/mShop/android/util/R$raw;->associate_tag:I

    invoke-static {p0, v1}, Lcom/amazon/mShop/util/AttributionUtils;->readStringFromRawResourceFile(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 174
    :cond_2
    return-object v0
.end method

.method public static readStringFromRawResourceFile(Landroid/content/Context;I)Ljava/lang/String;
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "id"    # I

    .prologue
    .line 250
    const/4 v6, 0x0

    .line 251
    .local v6, "result":Ljava/lang/String;
    const/4 v2, 0x0

    .line 253
    .local v2, "in":Ljava/io/BufferedReader;
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-virtual {v7, p1}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v4

    .line 254
    .local v4, "is":Ljava/io/InputStream;
    new-instance v3, Ljava/io/BufferedReader;

    new-instance v7, Ljava/io/InputStreamReader;

    invoke-direct {v7, v4}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v3, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_7
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 256
    .end local v2    # "in":Ljava/io/BufferedReader;
    .local v3, "in":Ljava/io/BufferedReader;
    :try_start_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 257
    .local v0, "buffer":Ljava/lang/StringBuilder;
    :goto_0
    invoke-virtual {v3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v5

    .local v5, "line":Ljava/lang/String;
    if-eqz v5, :cond_1

    .line 258
    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_1 .. :try_end_1} :catch_6
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_0

    .line 261
    .end local v0    # "buffer":Ljava/lang/StringBuilder;
    .end local v5    # "line":Ljava/lang/String;
    :catch_0
    move-exception v1

    move-object v2, v3

    .line 262
    .end local v3    # "in":Ljava/io/BufferedReader;
    .end local v4    # "is":Ljava/io/InputStream;
    .local v1, "e":Ljava/io/IOException;
    .restart local v2    # "in":Ljava/io/BufferedReader;
    :goto_1
    :try_start_2
    const-string/jumbo v7, "Amazon"

    const-string/jumbo v8, "could not read from a raw resources file"

    invoke-static {v7, v8, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 269
    if-eqz v2, :cond_0

    .line 271
    :try_start_3
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    .line 277
    .end local v1    # "e":Ljava/io/IOException;
    :cond_0
    :goto_2
    return-object v6

    .line 260
    .end local v2    # "in":Ljava/io/BufferedReader;
    .restart local v0    # "buffer":Ljava/lang/StringBuilder;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    .restart local v4    # "is":Ljava/io/InputStream;
    .restart local v5    # "line":Ljava/lang/String;
    :cond_1
    :try_start_4
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_4 .. :try_end_4} :catch_6
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    move-result-object v6

    .line 269
    if-eqz v3, :cond_3

    .line 271
    :try_start_5
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1

    move-object v2, v3

    .line 274
    .end local v3    # "in":Ljava/io/BufferedReader;
    .restart local v2    # "in":Ljava/io/BufferedReader;
    goto :goto_2

    .line 272
    .end local v2    # "in":Ljava/io/BufferedReader;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    :catch_1
    move-exception v1

    .line 273
    .restart local v1    # "e":Ljava/io/IOException;
    const-string/jumbo v7, "Amazon"

    const-string/jumbo v8, "could not close a raw resources file"

    invoke-static {v7, v8, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    move-object v2, v3

    .line 274
    .end local v3    # "in":Ljava/io/BufferedReader;
    .restart local v2    # "in":Ljava/io/BufferedReader;
    goto :goto_2

    .line 272
    .end local v0    # "buffer":Ljava/lang/StringBuilder;
    .end local v4    # "is":Ljava/io/InputStream;
    .end local v5    # "line":Ljava/lang/String;
    :catch_2
    move-exception v1

    .line 273
    const-string/jumbo v7, "Amazon"

    const-string/jumbo v8, "could not close a raw resources file"

    invoke-static {v7, v8, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_2

    .line 263
    .end local v1    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v1

    .line 267
    .local v1, "e":Landroid/content/res/Resources$NotFoundException;
    :goto_3
    :try_start_6
    const-string/jumbo v7, "Amazon"

    const-string/jumbo v8, "could not find a raw resources file"

    invoke-static {v7, v8, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 269
    if-eqz v2, :cond_0

    .line 271
    :try_start_7
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_4

    goto :goto_2

    .line 272
    :catch_4
    move-exception v1

    .line 273
    .local v1, "e":Ljava/io/IOException;
    const-string/jumbo v7, "Amazon"

    const-string/jumbo v8, "could not close a raw resources file"

    invoke-static {v7, v8, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_2

    .line 269
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v7

    :goto_4
    if-eqz v2, :cond_2

    .line 271
    :try_start_8
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_5

    .line 274
    :cond_2
    :goto_5
    throw v7

    .line 272
    :catch_5
    move-exception v1

    .line 273
    .restart local v1    # "e":Ljava/io/IOException;
    const-string/jumbo v8, "Amazon"

    const-string/jumbo v9, "could not close a raw resources file"

    invoke-static {v8, v9, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_5

    .line 269
    .end local v1    # "e":Ljava/io/IOException;
    .end local v2    # "in":Ljava/io/BufferedReader;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    .restart local v4    # "is":Ljava/io/InputStream;
    :catchall_1
    move-exception v7

    move-object v2, v3

    .end local v3    # "in":Ljava/io/BufferedReader;
    .restart local v2    # "in":Ljava/io/BufferedReader;
    goto :goto_4

    .line 263
    .end local v2    # "in":Ljava/io/BufferedReader;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    :catch_6
    move-exception v1

    move-object v2, v3

    .end local v3    # "in":Ljava/io/BufferedReader;
    .restart local v2    # "in":Ljava/io/BufferedReader;
    goto :goto_3

    .line 261
    .end local v4    # "is":Ljava/io/InputStream;
    :catch_7
    move-exception v1

    goto :goto_1

    .end local v2    # "in":Ljava/io/BufferedReader;
    .restart local v0    # "buffer":Ljava/lang/StringBuilder;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    .restart local v4    # "is":Ljava/io/InputStream;
    .restart local v5    # "line":Ljava/lang/String;
    :cond_3
    move-object v2, v3

    .end local v3    # "in":Ljava/io/BufferedReader;
    .restart local v2    # "in":Ljava/io/BufferedReader;
    goto :goto_2
.end method

.method public static trimMarketplaceFromAssociateTag(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
    .locals 10
    .param p0, "associateTag"    # Ljava/lang/StringBuilder;

    .prologue
    const/4 v9, -0x1

    .line 90
    sget-object v7, Lcom/amazon/mShop/util/AttributionUtils;->sMapFromLocaleToTagCode:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 91
    .local v4, "mp":Ljava/lang/String;
    const/4 v5, -0x1

    .line 92
    .local v5, "start":I
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "-"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 93
    .local v1, "dashedMP":Ljava/lang/String;
    :goto_0
    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v5

    if-eq v5, v9, :cond_0

    .line 94
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v7

    add-int/2addr v7, v5

    const-string/jumbo v8, ""

    invoke-virtual {p0, v5, v7, v8}, Ljava/lang/StringBuilder;->replace(IILjava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 101
    .end local v1    # "dashedMP":Ljava/lang/String;
    .end local v4    # "mp":Ljava/lang/String;
    .end local v5    # "start":I
    :cond_1
    sget-object v0, Lcom/amazon/mShop/util/AttributionUtils;->ASSOCIATE_TAG_REGION_CODES:[Ljava/lang/String;

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_1
    if-ge v2, v3, :cond_2

    aget-object v6, v0, v2

    .line 102
    .local v6, "value":Ljava/lang/String;
    const/4 v5, -0x1

    .line 103
    .restart local v5    # "start":I
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "-"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 104
    .restart local v1    # "dashedMP":Ljava/lang/String;
    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v5

    if-eq v5, v9, :cond_3

    .line 105
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v7

    add-int/2addr v7, v5

    const-string/jumbo v8, ""

    invoke-virtual {p0, v5, v7, v8}, Ljava/lang/StringBuilder;->replace(IILjava/lang/String;)Ljava/lang/StringBuilder;

    .line 109
    .end local v1    # "dashedMP":Ljava/lang/String;
    .end local v5    # "start":I
    .end local v6    # "value":Ljava/lang/String;
    :cond_2
    return-object p0

    .line 101
    .restart local v1    # "dashedMP":Ljava/lang/String;
    .restart local v5    # "start":I
    .restart local v6    # "value":Ljava/lang/String;
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method
