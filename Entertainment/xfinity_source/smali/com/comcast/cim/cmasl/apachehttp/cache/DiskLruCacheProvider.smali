.class public Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruCacheProvider;
.super Ljava/lang/Object;
.source "DiskLruCacheProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<",
        "Lcom/jakewharton/DiskLruCache;",
        ">;"
    }
.end annotation


# instance fields
.field private final appVersion:I

.field private final cacheDir:Ljava/io/File;

.field private final maxSizeOfCache:I

.field private final numValuesPerEntry:I


# direct methods
.method public constructor <init>(Ljava/io/File;III)V
    .locals 0
    .param p1, "cacheDir"    # Ljava/io/File;
    .param p2, "numValuesPerEntry"    # I
    .param p3, "maxSizeOfCache"    # I
    .param p4, "appVersion"    # I

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput p3, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruCacheProvider;->maxSizeOfCache:I

    .line 18
    iput-object p1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruCacheProvider;->cacheDir:Ljava/io/File;

    .line 19
    iput p4, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruCacheProvider;->appVersion:I

    .line 20
    iput p2, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruCacheProvider;->numValuesPerEntry:I

    .line 21
    return-void
.end method


# virtual methods
.method public get()Lcom/jakewharton/DiskLruCache;
    .locals 6

    .prologue
    .line 26
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruCacheProvider;->cacheDir:Ljava/io/File;

    iget v2, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruCacheProvider;->appVersion:I

    iget v3, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruCacheProvider;->numValuesPerEntry:I

    iget v4, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruCacheProvider;->maxSizeOfCache:I

    int-to-long v4, v4

    invoke-static {v1, v2, v3, v4, v5}, Lcom/jakewharton/DiskLruCache;->open(Ljava/io/File;IIJ)Lcom/jakewharton/DiskLruCache;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    .line 27
    :catch_0
    move-exception v0

    .line 28
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-direct {v1, v0}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/io/IOException;)V

    throw v1
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 10
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruCacheProvider;->get()Lcom/jakewharton/DiskLruCache;

    move-result-object v0

    return-object v0
.end method
