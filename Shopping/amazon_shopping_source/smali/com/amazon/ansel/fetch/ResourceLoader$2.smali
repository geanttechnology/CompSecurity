.class Lcom/amazon/ansel/fetch/ResourceLoader$2;
.super Ljava/lang/Object;
.source "ResourceLoader.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/ansel/fetch/ResourceLoader;->sendDone()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/ansel/fetch/ResourceLoader;


# direct methods
.method constructor <init>(Lcom/amazon/ansel/fetch/ResourceLoader;)V
    .locals 0

    .prologue
    .line 244
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader$2;, "Lcom/amazon/ansel/fetch/ResourceLoader.2;"
    iput-object p1, p0, Lcom/amazon/ansel/fetch/ResourceLoader$2;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 247
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader$2;, "Lcom/amazon/ansel/fetch/ResourceLoader.2;"
    iget-object v4, p0, Lcom/amazon/ansel/fetch/ResourceLoader$2;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    invoke-virtual {v4}, Lcom/amazon/ansel/fetch/ResourceLoader;->getResourceListener()Lcom/amazon/ansel/fetch/ResourceListener;

    move-result-object v3

    .line 249
    .local v3, "resourceListener":Lcom/amazon/ansel/fetch/ResourceListener;, "Lcom/amazon/ansel/fetch/ResourceListener<TResult;>;"
    if-eqz v3, :cond_0

    .line 250
    invoke-interface {v3}, Lcom/amazon/ansel/fetch/ResourceListener;->done()V

    .line 253
    :cond_0
    iget-object v4, p0, Lcom/amazon/ansel/fetch/ResourceLoader$2;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    # getter for: Lcom/amazon/ansel/fetch/ResourceLoader;->loaderListeners:Ljava/util/List;
    invoke-static {v4}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$300(Lcom/amazon/ansel/fetch/ResourceLoader;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;

    .line 254
    .local v2, "ref":Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;, "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<Lcom/amazon/ansel/fetch/LoaderListener;>;"
    invoke-interface {v2}, Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/ansel/fetch/LoaderListener;

    .line 256
    .local v1, "listener":Lcom/amazon/ansel/fetch/LoaderListener;
    if-eqz v1, :cond_1

    .line 257
    invoke-interface {v1}, Lcom/amazon/ansel/fetch/LoaderListener;->done()V

    goto :goto_0

    .line 260
    .end local v1    # "listener":Lcom/amazon/ansel/fetch/LoaderListener;
    .end local v2    # "ref":Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;, "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<Lcom/amazon/ansel/fetch/LoaderListener;>;"
    :cond_2
    return-void
.end method
