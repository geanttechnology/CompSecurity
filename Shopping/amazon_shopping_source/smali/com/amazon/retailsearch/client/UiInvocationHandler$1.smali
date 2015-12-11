.class Lcom/amazon/retailsearch/client/UiInvocationHandler$1;
.super Ljava/lang/Object;
.source "UiInvocationHandler.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/client/UiInvocationHandler;->invoke(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/client/UiInvocationHandler;

.field final synthetic val$args:[Ljava/lang/Object;

.field final synthetic val$method:Ljava/lang/reflect/Method;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/client/UiInvocationHandler;Ljava/lang/reflect/Method;[Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 45
    .local p0, "this":Lcom/amazon/retailsearch/client/UiInvocationHandler$1;, "Lcom/amazon/retailsearch/client/UiInvocationHandler.1;"
    iput-object p1, p0, Lcom/amazon/retailsearch/client/UiInvocationHandler$1;->this$0:Lcom/amazon/retailsearch/client/UiInvocationHandler;

    iput-object p2, p0, Lcom/amazon/retailsearch/client/UiInvocationHandler$1;->val$method:Ljava/lang/reflect/Method;

    iput-object p3, p0, Lcom/amazon/retailsearch/client/UiInvocationHandler$1;->val$args:[Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 48
    .local p0, "this":Lcom/amazon/retailsearch/client/UiInvocationHandler$1;, "Lcom/amazon/retailsearch/client/UiInvocationHandler.1;"
    iget-object v2, p0, Lcom/amazon/retailsearch/client/UiInvocationHandler$1;->this$0:Lcom/amazon/retailsearch/client/UiInvocationHandler;

    # getter for: Lcom/amazon/retailsearch/client/UiInvocationHandler;->resourceRef:Ljava/lang/ref/WeakReference;
    invoke-static {v2}, Lcom/amazon/retailsearch/client/UiInvocationHandler;->access$000(Lcom/amazon/retailsearch/client/UiInvocationHandler;)Ljava/lang/ref/WeakReference;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    .line 50
    .local v1, "resource":Ljava/lang/Object;, "TT;"
    if-nez v1, :cond_0

    .line 59
    :goto_0
    return-void

    .line 55
    :cond_0
    :try_start_0
    iget-object v2, p0, Lcom/amazon/retailsearch/client/UiInvocationHandler$1;->val$method:Ljava/lang/reflect/Method;

    iget-object v3, p0, Lcom/amazon/retailsearch/client/UiInvocationHandler$1;->val$args:[Ljava/lang/Object;

    invoke-virtual {v2, v1, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 56
    :catch_0
    move-exception v0

    .line 57
    .local v0, "e":Ljava/lang/Exception;
    # getter for: Lcom/amazon/retailsearch/client/UiInvocationHandler;->log:Lcom/amazon/retailsearch/log/MessageLogger;
    invoke-static {}, Lcom/amazon/retailsearch/client/UiInvocationHandler;->access$100()Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Failed to invoke method "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/retailsearch/client/UiInvocationHandler$1;->val$method:Ljava/lang/reflect/Method;

    invoke-virtual {v4}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v0}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
