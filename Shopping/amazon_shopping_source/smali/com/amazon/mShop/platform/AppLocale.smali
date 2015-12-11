.class public Lcom/amazon/mShop/platform/AppLocale;
.super Ljava/lang/Object;
.source "AppLocale.java"


# static fields
.field private static final mInstance:Lcom/amazon/mShop/platform/AppLocale;


# instance fields
.field private mCurrentLocale:Ljava/util/Locale;

.field private mDefaultLocaleName:Ljava/lang/String;

.field private mMapMappingMarketPlaceWithLocale:Ljava/util/Map;
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

.field private mSupportedLocaleNameSet:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 36
    new-instance v0, Lcom/amazon/mShop/platform/AppLocale;

    invoke-direct {v0}, Lcom/amazon/mShop/platform/AppLocale;-><init>()V

    sput-object v0, Lcom/amazon/mShop/platform/AppLocale;->mInstance:Lcom/amazon/mShop/platform/AppLocale;

    return-void
.end method

.method private constructor <init>()V
    .locals 3

    .prologue
    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 61
    const-string/jumbo v0, "en_US"

    iput-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mDefaultLocaleName:Ljava/lang/String;

    .line 62
    new-instance v0, Ljava/util/Locale;

    const-string/jumbo v1, "en"

    const-string/jumbo v2, "US"

    invoke-direct {v0, v1, v2}, Ljava/util/Locale;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mCurrentLocale:Ljava/util/Locale;

    .line 63
    invoke-direct {p0}, Lcom/amazon/mShop/platform/AppLocale;->initSupportedLocaleNameSet()V

    .line 64
    invoke-direct {p0}, Lcom/amazon/mShop/platform/AppLocale;->initMapMappingMarketPlaceWithLocale()V

    .line 65
    return-void
.end method

.method public static getInstance()Lcom/amazon/mShop/platform/AppLocale;
    .locals 1

    .prologue
    .line 48
    sget-object v0, Lcom/amazon/mShop/platform/AppLocale;->mInstance:Lcom/amazon/mShop/platform/AppLocale;

    return-object v0
.end method

.method private initMapMappingMarketPlaceWithLocale()V
    .locals 3

    .prologue
    .line 276
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mMapMappingMarketPlaceWithLocale:Ljava/util/Map;

    .line 277
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mMapMappingMarketPlaceWithLocale:Ljava/util/Map;

    const-string/jumbo v1, "en_CA"

    const-string/jumbo v2, "A2EUQ1WTGCTBG2"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 278
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mMapMappingMarketPlaceWithLocale:Ljava/util/Map;

    const-string/jumbo v1, "fr_CA"

    const-string/jumbo v2, "A2EUQ1WTGCTBG2"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 279
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mMapMappingMarketPlaceWithLocale:Ljava/util/Map;

    const-string/jumbo v1, "zh_CN"

    const-string/jumbo v2, "AAHKV2X7AFYLW"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 280
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mMapMappingMarketPlaceWithLocale:Ljava/util/Map;

    const-string/jumbo v1, "ja_JP"

    const-string/jumbo v2, "A1VC38T7YXB528"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 281
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mMapMappingMarketPlaceWithLocale:Ljava/util/Map;

    const-string/jumbo v1, "en_GB"

    const-string/jumbo v2, "A1F83G8C2ARO7P"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 282
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mMapMappingMarketPlaceWithLocale:Ljava/util/Map;

    const-string/jumbo v1, "en_IN"

    const-string/jumbo v2, "A21TJRUUN4KGV"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 283
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mMapMappingMarketPlaceWithLocale:Ljava/util/Map;

    const-string/jumbo v1, "en_US"

    const-string/jumbo v2, "ATVPDKIKX0DER"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 284
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mMapMappingMarketPlaceWithLocale:Ljava/util/Map;

    const-string/jumbo v1, "de_DE"

    const-string/jumbo v2, "A1PA6795UKMFR9"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 285
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mMapMappingMarketPlaceWithLocale:Ljava/util/Map;

    const-string/jumbo v1, "es_ES"

    const-string/jumbo v2, "A1RKKUPIHCS9HS"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 286
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mMapMappingMarketPlaceWithLocale:Ljava/util/Map;

    const-string/jumbo v1, "fr_FR"

    const-string/jumbo v2, "A13V1IB3VIYZZH"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 287
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mMapMappingMarketPlaceWithLocale:Ljava/util/Map;

    const-string/jumbo v1, "it_IT"

    const-string/jumbo v2, "APJ6JRA9NG5V4"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 289
    return-void
.end method

.method private initSupportedLocaleNameSet()V
    .locals 2

    .prologue
    .line 102
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mSupportedLocaleNameSet:Ljava/util/Set;

    .line 103
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mSupportedLocaleNameSet:Ljava/util/Set;

    const-string/jumbo v1, "de_DE"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mSupportedLocaleNameSet:Ljava/util/Set;

    const-string/jumbo v1, "en_GB"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 105
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mSupportedLocaleNameSet:Ljava/util/Set;

    const-string/jumbo v1, "en_IN"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 106
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mSupportedLocaleNameSet:Ljava/util/Set;

    const-string/jumbo v1, "en_US"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 107
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mSupportedLocaleNameSet:Ljava/util/Set;

    const-string/jumbo v1, "fr_FR"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 108
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mSupportedLocaleNameSet:Ljava/util/Set;

    const-string/jumbo v1, "ja_JP"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 109
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mSupportedLocaleNameSet:Ljava/util/Set;

    const-string/jumbo v1, "zh_CN"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 110
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mSupportedLocaleNameSet:Ljava/util/Set;

    const-string/jumbo v1, "it_IT"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 111
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mSupportedLocaleNameSet:Ljava/util/Set;

    const-string/jumbo v1, "es_ES"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 112
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mSupportedLocaleNameSet:Ljava/util/Set;

    const-string/jumbo v1, "en_CA"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 113
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mSupportedLocaleNameSet:Ljava/util/Set;

    const-string/jumbo v1, "fr_CA"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 114
    return-void
.end method

.method public static isLocaleOfCA(Ljava/lang/String;)Z
    .locals 1
    .param p0, "localeName"    # Ljava/lang/String;

    .prologue
    .line 314
    const-string/jumbo v0, "en_CA"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "fr_CA"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized getCurrentLocale()Ljava/util/Locale;
    .locals 1

    .prologue
    .line 219
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mCurrentLocale:Ljava/util/Locale;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getCurrentLocaleName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 208
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mCurrentLocale:Ljava/util/Locale;

    invoke-virtual {v0}, Ljava/util/Locale;->toString()Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDefaultLocale()Ljava/lang/String;
    .locals 1

    .prologue
    .line 230
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mDefaultLocaleName:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getLocaleByMarketPlaceId(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "marketplaceId"    # Ljava/lang/String;

    .prologue
    .line 298
    iget-object v2, p0, Lcom/amazon/mShop/platform/AppLocale;->mMapMappingMarketPlaceWithLocale:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 299
    iget-object v2, p0, Lcom/amazon/mShop/platform/AppLocale;->mMapMappingMarketPlaceWithLocale:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 300
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 301
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 305
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    :goto_0
    return-object v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getLocaleName(Ljava/util/Locale;)Ljava/lang/String;
    .locals 2
    .param p1, "locale"    # Ljava/util/Locale;

    .prologue
    .line 151
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMarketPlaceIdByLocale(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 292
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 293
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mMapMappingMarketPlaceWithLocale:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 294
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getSupportedLocaleNameArray()[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mSupportedLocaleNameSet:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->toArray()[Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public isSupported(Ljava/lang/String;)Z
    .locals 1
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 139
    iget-object v0, p0, Lcom/amazon/mShop/platform/AppLocale;->mSupportedLocaleNameSet:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public declared-synchronized setCurrentLocale(Ljava/lang/String;)Z
    .locals 5
    .param p1, "localeName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 187
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 188
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "localeName should not be null nor empty"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 187
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 190
    :cond_0
    :try_start_1
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/platform/AppLocale;->isSupported(Ljava/lang/String;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v3

    if-nez v3, :cond_1

    .line 191
    const/4 v3, 0x0

    .line 197
    :goto_0
    monitor-exit p0

    return v3

    .line 193
    :cond_1
    :try_start_2
    new-instance v2, Ljava/util/StringTokenizer;

    const-string/jumbo v3, "_"

    invoke-direct {v2, p1, v3}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 194
    .local v2, "tokenizer":Ljava/util/StringTokenizer;
    invoke-virtual {v2}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v0

    .line 195
    .local v0, "language":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v1

    .line 196
    .local v1, "region":Ljava/lang/String;
    new-instance v3, Ljava/util/Locale;

    invoke-direct {v3, v0, v1}, Ljava/util/Locale;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v3, p0, Lcom/amazon/mShop/platform/AppLocale;->mCurrentLocale:Ljava/util/Locale;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 197
    const/4 v3, 0x1

    goto :goto_0
.end method

.method public declared-synchronized setDefaultLocale(Ljava/lang/String;)Z
    .locals 2
    .param p1, "localeName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 248
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 249
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "locale should not be null nor empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 248
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 251
    :cond_0
    :try_start_1
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/platform/AppLocale;->isSupported(Ljava/lang/String;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    if-nez v0, :cond_1

    .line 252
    const/4 v0, 0x0

    .line 255
    :goto_0
    monitor-exit p0

    return v0

    .line 254
    :cond_1
    :try_start_2
    iput-object p1, p0, Lcom/amazon/mShop/platform/AppLocale;->mDefaultLocaleName:Ljava/lang/String;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 255
    const/4 v0, 0x1

    goto :goto_0
.end method
