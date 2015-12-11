.class Lcom/amazon/ansel/fetch/ResourceLoader$Listener$1;
.super Ljava/lang/Object;
.source "ResourceLoader.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->result(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/ansel/fetch/ResourceLoader$Listener;

.field final synthetic val$result:Ljava/lang/Object;


# direct methods
.method constructor <init>(Lcom/amazon/ansel/fetch/ResourceLoader$Listener;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 345
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader$Listener$1;, "Lcom/amazon/ansel/fetch/ResourceLoader$Listener.1;"
    iput-object p1, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener$1;->this$1:Lcom/amazon/ansel/fetch/ResourceLoader$Listener;

    iput-object p2, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener$1;->val$result:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 348
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader$Listener$1;, "Lcom/amazon/ansel/fetch/ResourceLoader$Listener.1;"
    iget-object v1, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener$1;->this$1:Lcom/amazon/ansel/fetch/ResourceLoader$Listener;

    iget-object v1, v1, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    invoke-virtual {v1}, Lcom/amazon/ansel/fetch/ResourceLoader;->getResourceListener()Lcom/amazon/ansel/fetch/ResourceListener;

    move-result-object v0

    .line 350
    .local v0, "resourceListener":Lcom/amazon/ansel/fetch/ResourceListener;, "Lcom/amazon/ansel/fetch/ResourceListener<TResult;>;"
    if-nez v0, :cond_0

    .line 351
    iget-object v1, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener$1;->this$1:Lcom/amazon/ansel/fetch/ResourceLoader$Listener;

    iget-object v1, v1, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    const-string/jumbo v2, "Result listener reference is stale"

    # invokes: Lcom/amazon/ansel/fetch/ResourceLoader;->log(Ljava/lang/String;)V
    invoke-static {v1, v2}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$500(Lcom/amazon/ansel/fetch/ResourceLoader;Ljava/lang/String;)V

    .line 357
    :goto_0
    return-void

    .line 353
    :cond_0
    iget-object v1, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener$1;->this$1:Lcom/amazon/ansel/fetch/ResourceLoader$Listener;

    iget-object v1, v1, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    # getter for: Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;
    invoke-static {v1}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$200(Lcom/amazon/ansel/fetch/ResourceLoader;)Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener$1;->this$1:Lcom/amazon/ansel/fetch/ResourceLoader$Listener;

    iget-object v2, v2, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    invoke-virtual {v2}, Lcom/amazon/ansel/fetch/ResourceLoader;->getResourceKey()Ljava/lang/Object;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener$1;->this$1:Lcom/amazon/ansel/fetch/ResourceLoader$Listener;

    iget-object v3, v3, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    # getter for: Lcom/amazon/ansel/fetch/ResourceLoader;->resourceListenerRef:Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;
    invoke-static {v3}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$100(Lcom/amazon/ansel/fetch/ResourceLoader;)Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/amazon/ansel/fetch/LoaderContext;->addReference(Ljava/lang/Object;Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;)V

    .line 354
    iget-object v1, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener$1;->this$1:Lcom/amazon/ansel/fetch/ResourceLoader$Listener;

    iget-object v1, v1, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    const-string/jumbo v2, "Invoking result callback"

    # invokes: Lcom/amazon/ansel/fetch/ResourceLoader;->log(Ljava/lang/String;)V
    invoke-static {v1, v2}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$500(Lcom/amazon/ansel/fetch/ResourceLoader;Ljava/lang/String;)V

    .line 355
    iget-object v1, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener$1;->val$result:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lcom/amazon/ansel/fetch/ResourceListener;->result(Ljava/lang/Object;)V

    goto :goto_0
.end method
