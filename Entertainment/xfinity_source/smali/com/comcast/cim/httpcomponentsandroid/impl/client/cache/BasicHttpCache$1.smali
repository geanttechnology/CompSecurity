.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$1;
.super Ljava/lang/Object;
.source "BasicHttpCache.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->storeVariantEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;

.field final synthetic val$entry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

.field final synthetic val$req:Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

.field final synthetic val$variantURI:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 114
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$1;->this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;

    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$1;->val$req:Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    iput-object p3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$1;->val$entry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    iput-object p4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$1;->val$variantURI:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public update(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .locals 6
    .param p1, "existing"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 117
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$1;->this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$1;->val$req:Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v1

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$1;->val$entry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$1;->this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;

    # getter for: Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->uriExtractor:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;
    invoke-static {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->access$000(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;)Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;

    move-result-object v2

    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$1;->val$req:Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$1;->val$entry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    invoke-virtual {v2, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheKeyGenerator;->getVariantKey(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache$1;->val$variantURI:Ljava/lang/String;

    move-object v2, p1

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCache;->doGetUpdatedParentEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v0

    return-object v0
.end method
