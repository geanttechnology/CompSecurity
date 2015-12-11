.class Lcom/amazon/ansel/fetch/LoaderContext$3;
.super Ljava/lang/Object;
.source "LoaderContext.java"

# interfaces
.implements Lcom/amazon/ansel/fetch/cache/ResourceCacheListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/ansel/fetch/LoaderContext;->createPrimaryCacheListener()Lcom/amazon/ansel/fetch/cache/ResourceCacheListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/ansel/fetch/cache/ResourceCacheListener",
        "<",
        "Ljava/lang/Object;",
        "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
        "<*>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/ansel/fetch/LoaderContext;


# direct methods
.method constructor <init>(Lcom/amazon/ansel/fetch/LoaderContext;)V
    .locals 0

    .prologue
    .line 307
    iput-object p1, p0, Lcom/amazon/ansel/fetch/LoaderContext$3;->this$0:Lcom/amazon/ansel/fetch/LoaderContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public evict(Ljava/lang/Object;Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 310
    .local p2, "value":Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;, "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue<*>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$3;->this$0:Lcom/amazon/ansel/fetch/LoaderContext;

    # getter for: Lcom/amazon/ansel/fetch/LoaderContext;->removalInvalidates:Z
    invoke-static {v0}, Lcom/amazon/ansel/fetch/LoaderContext;->access$000(Lcom/amazon/ansel/fetch/LoaderContext;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 311
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext$3;->this$0:Lcom/amazon/ansel/fetch/LoaderContext;

    invoke-virtual {v0, p1}, Lcom/amazon/ansel/fetch/LoaderContext;->invalidateResource(Ljava/lang/Object;)V

    .line 313
    :cond_0
    return-void
.end method

.method public bridge synthetic evict(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 307
    check-cast p2, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/ansel/fetch/LoaderContext$3;->evict(Ljava/lang/Object;Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;)V

    return-void
.end method
