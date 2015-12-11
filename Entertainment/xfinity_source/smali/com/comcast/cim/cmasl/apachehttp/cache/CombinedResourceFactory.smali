.class public Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResourceFactory;
.super Ljava/lang/Object;
.source "CombinedResourceFactory.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;


# instance fields
.field private final fileResourceFactory:Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;

.field private final heapResourceFactory:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HeapResourceFactory;

.field private final perResourceHeapLimitInBytes:I


# direct methods
.method public constructor <init>(ILcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;)V
    .locals 1
    .param p1, "perResourceHeapLimitInBytes"    # I
    .param p2, "fileResourceFactory"    # Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HeapResourceFactory;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HeapResourceFactory;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResourceFactory;->heapResourceFactory:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HeapResourceFactory;

    .line 26
    iput p1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResourceFactory;->perResourceHeapLimitInBytes:I

    .line 27
    iput-object p2, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResourceFactory;->fileResourceFactory:Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;

    .line 28
    return-void
.end method


# virtual methods
.method public copy(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    .locals 7
    .param p1, "requestId"    # Ljava/lang/String;
    .param p2, "resource"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 52
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;->getInputStream()Ljava/io/InputStream;

    move-result-object v3

    .line 54
    .local v3, "inputStream":Ljava/io/InputStream;
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;

    iget v4, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResourceFactory;->perResourceHeapLimitInBytes:I

    int-to-long v4, v4

    invoke-direct {v1, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;-><init>(J)V

    .line 55
    .local v1, "heapLimit":Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;
    iget-object v4, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResourceFactory;->heapResourceFactory:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HeapResourceFactory;

    invoke-virtual {v4, p1, v3, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HeapResourceFactory;->generate(Ljava/lang/String;Ljava/io/InputStream;Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v2

    .line 56
    .local v2, "heapResource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;->isReached()Z

    move-result v4

    if-nez v4, :cond_0

    .line 61
    .end local v2    # "heapResource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    :goto_0
    return-object v2

    .line 60
    .restart local v2    # "heapResource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    :cond_0
    iget-object v4, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResourceFactory;->fileResourceFactory:Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;

    const/4 v5, 0x0

    invoke-virtual {v4, p1, v3, v5}, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->generate(Ljava/lang/String;Ljava/io/InputStream;Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v0

    .line 61
    .local v0, "fileResource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    new-instance v4, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResource;

    const/4 v5, 0x2

    new-array v5, v5, [Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    const/4 v6, 0x0

    aput-object v2, v5, v6

    const/4 v6, 0x1

    aput-object v0, v5, v6

    invoke-direct {v4, v5}, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResource;-><init>([Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)V

    move-object v2, v4

    goto :goto_0
.end method

.method public generate(Ljava/lang/String;Ljava/io/InputStream;Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    .locals 8
    .param p1, "requestId"    # Ljava/lang/String;
    .param p2, "inputStream"    # Ljava/io/InputStream;
    .param p3, "limit"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 32
    if-eqz p3, :cond_1

    invoke-virtual {p3}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;->getValue()J

    move-result-wide v4

    iget v6, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResourceFactory;->perResourceHeapLimitInBytes:I

    int-to-long v6, v6

    cmp-long v4, v4, v6

    if-gtz v4, :cond_1

    .line 33
    iget-object v4, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResourceFactory;->heapResourceFactory:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HeapResourceFactory;

    invoke-virtual {v4, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HeapResourceFactory;->generate(Ljava/lang/String;Ljava/io/InputStream;Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v3

    .line 47
    :cond_0
    :goto_0
    return-object v3

    .line 36
    :cond_1
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;

    iget v4, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResourceFactory;->perResourceHeapLimitInBytes:I

    int-to-long v4, v4

    invoke-direct {v2, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;-><init>(J)V

    .line 37
    .local v2, "heapLimit":Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;
    iget-object v4, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResourceFactory;->heapResourceFactory:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HeapResourceFactory;

    invoke-virtual {v4, p1, p2, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HeapResourceFactory;->generate(Ljava/lang/String;Ljava/io/InputStream;Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v3

    .line 38
    .local v3, "heapResource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;->isReached()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 42
    if-eqz p3, :cond_3

    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;

    invoke-virtual {p3}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;->getValue()J

    move-result-wide v4

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;->getValue()J

    move-result-wide v6

    sub-long/2addr v4, v6

    invoke-direct {v0, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;-><init>(J)V

    .line 43
    .local v0, "fileLimit":Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;
    :goto_1
    iget-object v4, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResourceFactory;->fileResourceFactory:Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;

    invoke-virtual {v4, p1, p2, v0}, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->generate(Ljava/lang/String;Ljava/io/InputStream;Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v1

    .line 44
    .local v1, "fileResource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;->isReached()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 45
    invoke-virtual {p3}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;->reached()V

    .line 47
    :cond_2
    new-instance v4, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResource;

    const/4 v5, 0x2

    new-array v5, v5, [Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    const/4 v6, 0x0

    aput-object v3, v5, v6

    const/4 v6, 0x1

    aput-object v1, v5, v6

    invoke-direct {v4, v5}, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResource;-><init>([Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)V

    move-object v3, v4

    goto :goto_0

    .line 42
    .end local v0    # "fileLimit":Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;
    .end local v1    # "fileResource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    :cond_3
    const/4 v0, 0x0

    goto :goto_1
.end method
