.class public Lcom/comcast/cim/cmasl/apachehttp/cache/CachingHttpClientProvider;
.super Ljava/lang/Object;
.source "CachingHttpClientProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<",
        "Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final cacheConfiguration:Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheConfiguration;

.field private final delegateClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/comcast/cim/cmasl/apachehttp/cache/CachingHttpClientProvider;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/apachehttp/cache/CachingHttpClientProvider;->LOG:Lorg/slf4j/Logger;

    return-void
.end method


# virtual methods
.method public get()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .locals 10

    .prologue
    .line 28
    new-instance v3, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruCacheProvider;

    iget-object v6, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CachingHttpClientProvider;->cacheConfiguration:Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheConfiguration;

    invoke-interface {v6}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheConfiguration;->getCacheDirectory()Ljava/io/File;

    move-result-object v6

    const/4 v7, 0x3

    iget-object v8, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CachingHttpClientProvider;->cacheConfiguration:Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheConfiguration;

    invoke-interface {v8}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheConfiguration;->getMaxSizeInBytes()I

    move-result v8

    iget-object v9, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CachingHttpClientProvider;->cacheConfiguration:Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheConfiguration;

    invoke-interface {v9}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheConfiguration;->getCacheVersion()I

    move-result v9

    invoke-direct {v3, v6, v7, v8, v9}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruCacheProvider;-><init>(Ljava/io/File;III)V

    .line 32
    .local v3, "diskLruCacheProvider":Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruCacheProvider;
    new-instance v4, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;

    iget-object v6, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CachingHttpClientProvider;->cacheConfiguration:Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheConfiguration;

    invoke-interface {v6}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheConfiguration;->getFileResourceDirectory()Ljava/io/File;

    move-result-object v6

    invoke-direct {v4, v6}, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;-><init>(Ljava/io/File;)V

    .line 33
    .local v4, "managedFileResourceFactory":Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;
    new-instance v5, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResourceFactory;

    iget-object v6, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CachingHttpClientProvider;->cacheConfiguration:Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheConfiguration;

    invoke-interface {v6}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheConfiguration;->getPerResourceHeapLimitInBytes()I

    move-result v6

    invoke-direct {v5, v6, v4}, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResourceFactory;-><init>(ILcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;)V

    .line 34
    .local v5, "resourceFactory":Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;
    new-instance v2, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;

    invoke-direct {v2, v3, v5}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;-><init>(Lcom/comcast/cim/cmasl/utils/provider/Provider;Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;)V

    .line 35
    .local v2, "delegate":Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;
    new-instance v1, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorageAdapter;

    new-instance v6, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;

    invoke-direct {v6}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;-><init>()V

    invoke-direct {v1, v2, v6}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorageAdapter;-><init>(Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;)V

    .line 36
    .local v1, "cacheStorage":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;
    iget-object v6, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CachingHttpClientProvider;->cacheConfiguration:Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheConfiguration;

    invoke-interface {v6}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheConfiguration;->getApacheCacheConfig()Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;

    move-result-object v0

    .line 38
    .local v0, "cacheConfig":Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;
    new-instance v6, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;

    iget-object v7, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CachingHttpClientProvider;->delegateClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-direct {v6, v7, v5, v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V

    return-object v6
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 12
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/CachingHttpClientProvider;->get()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    return-object v0
.end method
