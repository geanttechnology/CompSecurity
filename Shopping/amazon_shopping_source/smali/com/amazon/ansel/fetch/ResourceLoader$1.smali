.class Lcom/amazon/ansel/fetch/ResourceLoader$1;
.super Ljava/lang/Object;
.source "ResourceLoader.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/ansel/fetch/ResourceLoader;->loadFromPrimaryCache()Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

.field final synthetic val$key:Ljava/lang/Object;

.field final synthetic val$result:Ljava/lang/Object;


# direct methods
.method constructor <init>(Lcom/amazon/ansel/fetch/ResourceLoader;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 222
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader$1;, "Lcom/amazon/ansel/fetch/ResourceLoader.1;"
    iput-object p1, p0, Lcom/amazon/ansel/fetch/ResourceLoader$1;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    iput-object p2, p0, Lcom/amazon/ansel/fetch/ResourceLoader$1;->val$key:Ljava/lang/Object;

    iput-object p3, p0, Lcom/amazon/ansel/fetch/ResourceLoader$1;->val$result:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 225
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader$1;, "Lcom/amazon/ansel/fetch/ResourceLoader.1;"
    iget-object v1, p0, Lcom/amazon/ansel/fetch/ResourceLoader$1;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    invoke-virtual {v1}, Lcom/amazon/ansel/fetch/ResourceLoader;->getResourceListener()Lcom/amazon/ansel/fetch/ResourceListener;

    move-result-object v0

    .line 227
    .local v0, "listener":Lcom/amazon/ansel/fetch/ResourceListener;, "Lcom/amazon/ansel/fetch/ResourceListener<TResult;>;"
    if-eqz v0, :cond_0

    .line 228
    iget-object v1, p0, Lcom/amazon/ansel/fetch/ResourceLoader$1;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    # getter for: Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;
    invoke-static {v1}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$200(Lcom/amazon/ansel/fetch/ResourceLoader;)Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/ansel/fetch/ResourceLoader$1;->val$key:Ljava/lang/Object;

    iget-object v3, p0, Lcom/amazon/ansel/fetch/ResourceLoader$1;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    # getter for: Lcom/amazon/ansel/fetch/ResourceLoader;->resourceListenerRef:Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;
    invoke-static {v3}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$100(Lcom/amazon/ansel/fetch/ResourceLoader;)Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/amazon/ansel/fetch/LoaderContext;->addReference(Ljava/lang/Object;Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;)V

    .line 229
    iget-object v1, p0, Lcom/amazon/ansel/fetch/ResourceLoader$1;->val$result:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lcom/amazon/ansel/fetch/ResourceListener;->result(Ljava/lang/Object;)V

    .line 231
    :cond_0
    return-void
.end method
