.class interface abstract Lcom/adobe/mediacore/ContentCache;
.super Ljava/lang/Object;


# virtual methods
.method public abstract addContent(Ljava/lang/String;Lcom/adobe/mediacore/AdHandle;)Z
.end method

.method public abstract clearCache()V
.end method

.method public abstract getCachedUrls()Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getHandle(Ljava/lang/String;)Lcom/adobe/mediacore/AdHandle;
.end method

.method public abstract isCached(Ljava/lang/String;)Z
.end method
