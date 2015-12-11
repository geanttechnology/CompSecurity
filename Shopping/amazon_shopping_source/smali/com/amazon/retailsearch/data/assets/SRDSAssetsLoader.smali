.class public Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;
.super Ljava/lang/Object;
.source "SRDSAssetsLoader.java"

# interfaces
.implements Lcom/amazon/retailsearch/data/assets/AssetsLoader;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;
    }
.end annotation


# static fields
.field private static final resourceIdMapping:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final badges:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field context:Landroid/content/Context;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private doLoad:Z

.field featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private fetchType:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

.field private gotData:Z

.field private final loaderGroup:Lcom/amazon/ansel/fetch/ResourceProvider;

.field parentResourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private requestListener:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;

.field private retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

.field private serviceCall:Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 71
    new-instance v0, Ljava/util/HashMap;

    const/16 v1, 0x14

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    sput-object v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    .line 74
    sget-object v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    const-string/jumbo v1, "addOnBadge"

    sget v2, Lcom/amazon/retailsearch/R$drawable;->rs_assets_add_on_badge:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 75
    sget-object v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    const-string/jumbo v1, "autoRipBadge"

    sget v2, Lcom/amazon/retailsearch/R$drawable;->rs_assets_auto_rip_badge:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 76
    sget-object v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    const-string/jumbo v1, "bestSellerBadge"

    sget v2, Lcom/amazon/retailsearch/R$drawable;->rs_assets_best_seller_badge:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 77
    sget-object v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    const-string/jumbo v1, "fbaBadge"

    sget v2, Lcom/amazon/retailsearch/R$drawable;->rs_assets_fba_badge:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    sget-object v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    const-string/jumbo v1, "primeBadge"

    sget v2, Lcom/amazon/retailsearch/R$drawable;->rs_assets_prime_badge:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    sget-object v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    const-string/jumbo v1, "primeFreshBadge"

    sget v2, Lcom/amazon/retailsearch/R$drawable;->rs_assets_prime_fresh_badge:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 80
    sget-object v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    const-string/jumbo v1, "primeOneDayBadge"

    sget v2, Lcom/amazon/retailsearch/R$drawable;->rs_assets_prime_one_day_badge:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 81
    sget-object v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    const-string/jumbo v1, "primePantryBadge"

    sget v2, Lcom/amazon/retailsearch/R$drawable;->rs_assets_prime_pantry_badge:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 82
    sget-object v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    const-string/jumbo v1, "primeStandardBadge"

    sget v2, Lcom/amazon/retailsearch/R$drawable;->rs_assets_prime_standard_badge:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    sget-object v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    const-string/jumbo v1, "stars1Image"

    sget v2, Lcom/amazon/retailsearch/R$drawable;->stars_1:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    sget-object v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    const-string/jumbo v1, "stars2Image"

    sget v2, Lcom/amazon/retailsearch/R$drawable;->stars_2:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    sget-object v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    const-string/jumbo v1, "stars3Image"

    sget v2, Lcom/amazon/retailsearch/R$drawable;->stars_3:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    sget-object v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    const-string/jumbo v1, "stars4Image"

    sget v2, Lcom/amazon/retailsearch/R$drawable;->stars_4:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    sget-object v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    const-string/jumbo v1, "stars5Image"

    sget v2, Lcom/amazon/retailsearch/R$drawable;->stars_5:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 88
    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 94
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 57
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->badges:Ljava/util/Map;

    .line 60
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->doLoad:Z

    .line 62
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->gotData:Z

    .line 95
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 96
    new-instance v0, Lcom/amazon/ansel/fetch/ResourceProvider;

    iget-object v1, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->parentResourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    invoke-direct {v0, v1}, Lcom/amazon/ansel/fetch/ResourceProvider;-><init>(Lcom/amazon/ansel/fetch/LoaderGroup;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->loaderGroup:Lcom/amazon/ansel/fetch/ResourceProvider;

    .line 97
    return-void
.end method

.method static synthetic access$202(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;
    .param p1, "x1"    # Z

    .prologue
    .line 44
    iput-boolean p1, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->doLoad:Z

    return p1
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->badges:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)Lcom/amazon/retailsearch/data/assets/AssetFetchType;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->fetchType:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;Lcom/amazon/searchapp/retailsearch/model/Assets;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;
    .param p1, "x1"    # Lcom/amazon/searchapp/retailsearch/model/Assets;

    .prologue
    .line 44
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->retreiveBadges(Lcom/amazon/searchapp/retailsearch/model/Assets;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    .prologue
    .line 44
    iget-boolean v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->gotData:Z

    return v0
.end method

.method static synthetic access$702(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;
    .param p1, "x1"    # Z

    .prologue
    .line 44
    iput-boolean p1, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->gotData:Z

    return p1
.end method

.method static synthetic access$800(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->serviceCall:Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;

    return-object v0
.end method

.method private retreiveBadges(Lcom/amazon/searchapp/retailsearch/model/Assets;)Ljava/util/Map;
    .locals 11
    .param p1, "assets"    # Lcom/amazon/searchapp/retailsearch/model/Assets;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/model/Assets;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .prologue
    .line 226
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Assets;->getMedia()Ljava/util/Map;

    move-result-object v1

    if-nez v1, :cond_1

    .line 228
    :cond_0
    const/4 v1, 0x0

    .line 269
    :goto_0
    return-object v1

    .line 231
    :cond_1
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Assets;->getMedia()Ljava/util/Map;

    move-result-object v7

    .line 233
    .local v7, "badgeMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v7}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 235
    .local v6, "badgeId":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->badges:Ljava/util/Map;

    invoke-interface {v1, v6}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 241
    invoke-interface {v7, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    .line 243
    .local v10, "url":Ljava/lang/String;
    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 247
    new-instance v9, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$1;

    invoke-direct {v9, p0, v6}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$1;-><init>(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;Ljava/lang/String;)V

    .line 259
    .local v9, "listener":Lcom/amazon/ansel/fetch/ResourceListener;, "Lcom/amazon/ansel/fetch/ResourceListener<Landroid/graphics/Bitmap;>;"
    new-instance v0, Lcom/amazon/ansel/fetch/ImageLoader;

    iget-object v1, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->loaderGroup:Lcom/amazon/ansel/fetch/ResourceProvider;

    invoke-virtual {v1}, Lcom/amazon/ansel/fetch/ResourceProvider;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v1

    new-instance v2, Lcom/amazon/ansel/fetch/tools/ref/StrongObjectReference;

    invoke-direct {v2, v9}, Lcom/amazon/ansel/fetch/tools/ref/StrongObjectReference;-><init>(Ljava/lang/Object;)V

    const-wide/16 v3, 0x0

    new-instance v5, Lcom/amazon/ansel/fetch/ImageRequest;

    invoke-direct {v5, v10}, Lcom/amazon/ansel/fetch/ImageRequest;-><init>(Ljava/lang/String;)V

    invoke-direct/range {v0 .. v5}, Lcom/amazon/ansel/fetch/ImageLoader;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;JLcom/amazon/ansel/fetch/ImageRequest;)V

    .line 266
    .local v0, "loader":Lcom/amazon/ansel/fetch/ImageLoader;
    iget-object v1, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->loaderGroup:Lcom/amazon/ansel/fetch/ResourceProvider;

    invoke-virtual {v1, v0}, Lcom/amazon/ansel/fetch/ResourceProvider;->execute(Lcom/amazon/ansel/fetch/ResourceLoader;)V

    goto :goto_1

    .line 269
    .end local v0    # "loader":Lcom/amazon/ansel/fetch/ImageLoader;
    .end local v6    # "badgeId":Ljava/lang/String;
    .end local v9    # "listener":Lcom/amazon/ansel/fetch/ResourceListener;, "Lcom/amazon/ansel/fetch/ResourceListener<Landroid/graphics/Bitmap;>;"
    .end local v10    # "url":Ljava/lang/String;
    :cond_3
    iget-object v1, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->badges:Ljava/util/Map;

    goto :goto_0
.end method


# virtual methods
.method public clear()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 166
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->loaderGroup:Lcom/amazon/ansel/fetch/ResourceProvider;

    if-eqz v0, :cond_0

    .line 168
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->loaderGroup:Lcom/amazon/ansel/fetch/ResourceProvider;

    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/ResourceProvider;->cancel()V

    .line 171
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->requestListener:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;

    if-eqz v0, :cond_1

    .line 173
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->requestListener:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;

    # setter for: Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->cancelled:Z
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->access$102(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;Z)Z

    .line 176
    :cond_1
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->badges:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 177
    iput-boolean v1, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->doLoad:Z

    .line 178
    return-void
.end method

.method public getBadges()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .prologue
    .line 106
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->badges:Ljava/util/Map;

    return-object v0
.end method

.method public load(Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V
    .locals 6
    .param p1, "fetchType"    # Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    .prologue
    const/4 v3, 0x0

    .line 116
    iget-boolean v4, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->doLoad:Z

    if-nez v4, :cond_1

    .line 159
    :cond_0
    :goto_0
    return-void

    .line 123
    :cond_1
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->preloadLocalResources()V

    .line 124
    iget-object v4, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    invoke-static {v4}, Lcom/amazon/retailsearch/experiment/FeatureStateUtil;->getAssetsWeblab(Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;)Ljava/lang/String;

    move-result-object v0

    .line 125
    .local v0, "assetsTreatment":Ljava/lang/String;
    const-string/jumbo v4, "C"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 131
    const-string/jumbo v4, "T1"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    sget-object v4, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->POST_SEARCH_PAGE_LOAD:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    invoke-virtual {v4, p1}, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 136
    :cond_2
    const-string/jumbo v4, "T2"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_3

    const-string/jumbo v4, "T4"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    :cond_3
    const/4 v3, 0x1

    .line 137
    .local v3, "fetchAssetsBeforeSearchPageRequested":Z
    :cond_4
    sget-object v4, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->STARTUP_SEQUENCE:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    invoke-virtual {v4, p1}, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    if-eqz v3, :cond_0

    .line 142
    :cond_5
    const/4 v4, 0x0

    iput-boolean v4, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->doLoad:Z

    .line 143
    const/4 v4, 0x0

    iput-boolean v4, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->gotData:Z

    .line 145
    iput-object p1, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->fetchType:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    .line 147
    invoke-static {}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->getClient()Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    move-result-object v1

    .line 149
    .local v1, "client":Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    new-instance v4, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;

    const/4 v5, 0x0

    invoke-direct {v4, p0, v5}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;-><init>(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$1;)V

    iput-object v4, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->requestListener:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;

    .line 151
    iget-object v4, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->requestListener:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;

    const-class v5, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;

    invoke-static {v4, v5}, Lcom/amazon/retailsearch/client/UiInvocationHandler;->createUiProxy(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;

    invoke-virtual {v1, v4}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->assets(Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;)Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->serviceCall:Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;

    .line 154
    iget-object v4, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->serviceCall:Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;

    invoke-static {v4}, Lcom/amazon/retailsearch/client/SearchClientUtil;->executeRequest(Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;)Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 155
    .end local v0    # "assetsTreatment":Ljava/lang/String;
    .end local v1    # "client":Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    .end local v3    # "fetchAssetsBeforeSearchPageRequested":Z
    :catch_0
    move-exception v2

    .line 157
    .local v2, "e":Ljava/lang/Exception;
    iget-object v4, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    const-string/jumbo v5, "Error while running the assets loader\'s load method"

    invoke-interface {v4, v5, v2}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public preloadLocalResources()V
    .locals 9

    .prologue
    .line 188
    iget-object v6, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    invoke-static {v6}, Lcom/amazon/retailsearch/experiment/FeatureStateUtil;->getAssetsWeblab(Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;)Ljava/lang/String;

    move-result-object v0

    .line 189
    .local v0, "assetsTreatment":Ljava/lang/String;
    const-string/jumbo v6, "C"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    const-string/jumbo v6, "T3"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    const-string/jumbo v6, "T4"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 217
    :cond_0
    return-void

    .line 193
    :cond_1
    sget-object v6, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    if-eqz v6, :cond_0

    sget-object v6, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    invoke-interface {v6}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v6

    if-eqz v6, :cond_0

    .line 197
    sget-object v6, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->resourceIdMapping:Ljava/util/Map;

    invoke-interface {v6}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 199
    .local v1, "badge":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Integer;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 201
    .local v2, "badgeId":Ljava/lang/String;
    iget-object v6, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->badges:Ljava/util/Map;

    invoke-interface {v6, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    if-nez v6, :cond_2

    .line 208
    :try_start_0
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    .line 209
    .local v3, "badgeResource":Ljava/lang/Integer;
    iget-object v6, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->badges:Ljava/util/Map;

    iget-object v7, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->context:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v8

    invoke-static {v7, v8}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v7

    invoke-interface {v6, v2, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 211
    .end local v3    # "badgeResource":Ljava/lang/Integer;
    :catch_0
    move-exception v4

    .line 213
    .local v4, "e":Ljava/lang/Exception;
    iget-object v6, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "SRDSAssetsLoader encountered an error while preloading \'"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, "\' from local resources"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7, v4}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
