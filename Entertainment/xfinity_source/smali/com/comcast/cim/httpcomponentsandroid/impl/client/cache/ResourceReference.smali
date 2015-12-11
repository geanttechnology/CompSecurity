.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResourceReference;
.super Ljava/lang/ref/PhantomReference;
.source "ResourceReference.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/ref/PhantomReference",
        "<",
        "Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;",
        ">;"
    }
.end annotation


# instance fields
.field private final resource:Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/lang/ref/ReferenceQueue;)V
    .locals 2
    .param p1, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;",
            "Ljava/lang/ref/ReferenceQueue",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 42
    .local p2, "q":Ljava/lang/ref/ReferenceQueue;, "Ljava/lang/ref/ReferenceQueue<Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;>;"
    invoke-direct {p0, p1, p2}, Ljava/lang/ref/PhantomReference;-><init>(Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V

    .line 43
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getResource()Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v0

    if-nez v0, :cond_0

    .line 44
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Resource may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 46
    :cond_0
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getResource()Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResourceReference;->resource:Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    .line 47
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResourceReference;->resource:Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResourceReference;->resource:Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method
