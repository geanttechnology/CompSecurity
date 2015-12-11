.class public Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResource;
.super Ljava/lang/Object;
.source "CombinedResource.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;


# instance fields
.field private final resourceList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public varargs constructor <init>([Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)V
    .locals 1
    .param p1, "resources"    # [Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResource;->resourceList:Ljava/util/List;

    .line 22
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResource;->resourceList:Ljava/util/List;

    invoke-static {v0, p1}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    .line 23
    return-void
.end method


# virtual methods
.method public dispose()V
    .locals 3

    .prologue
    .line 50
    iget-object v2, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResource;->resourceList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    .line 51
    .local v1, "resource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;->dispose()V

    goto :goto_0

    .line 53
    .end local v1    # "resource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    :cond_0
    return-void
.end method

.method public getInputStream()Ljava/io/InputStream;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 31
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 32
    .local v1, "inputStreams":Ljava/util/List;, "Ljava/util/List<Ljava/io/InputStream;>;"
    iget-object v3, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResource;->resourceList:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    .line 33
    .local v2, "resource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;->getInputStream()Ljava/io/InputStream;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 36
    .end local v2    # "resource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    :cond_0
    new-instance v3, Ljava/io/SequenceInputStream;

    invoke-static {v1}, Ljava/util/Collections;->enumeration(Ljava/util/Collection;)Ljava/util/Enumeration;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/SequenceInputStream;-><init>(Ljava/util/Enumeration;)V

    return-object v3
.end method

.method public length()J
    .locals 6

    .prologue
    .line 41
    const-wide/16 v2, 0x0

    .line 42
    .local v2, "length":J
    iget-object v4, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/CombinedResource;->resourceList:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    .line 43
    .local v1, "resource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;->length()J

    move-result-wide v4

    add-long/2addr v2, v4

    goto :goto_0

    .line 45
    .end local v1    # "resource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    :cond_0
    return-wide v2
.end method
