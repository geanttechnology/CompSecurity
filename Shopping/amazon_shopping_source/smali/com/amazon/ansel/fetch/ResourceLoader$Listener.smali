.class Lcom/amazon/ansel/fetch/ResourceLoader$Listener;
.super Lcom/amazon/ansel/fetch/LoaderTask$AbstractListener;
.source "ResourceLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/ansel/fetch/ResourceLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Listener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/ansel/fetch/LoaderTask$AbstractListener",
        "<TResult;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/ansel/fetch/ResourceLoader;


# direct methods
.method private constructor <init>(Lcom/amazon/ansel/fetch/ResourceLoader;)V
    .locals 0

    .prologue
    .line 336
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader$Listener;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>.Listener;"
    iput-object p1, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    invoke-direct {p0}, Lcom/amazon/ansel/fetch/LoaderTask$AbstractListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/ansel/fetch/ResourceLoader;Lcom/amazon/ansel/fetch/ResourceLoader$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/ansel/fetch/ResourceLoader;
    .param p2, "x1"    # Lcom/amazon/ansel/fetch/ResourceLoader$1;

    .prologue
    .line 336
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader$Listener;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>.Listener;"
    invoke-direct {p0, p1}, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;-><init>(Lcom/amazon/ansel/fetch/ResourceLoader;)V

    return-void
.end method


# virtual methods
.method public done()V
    .locals 3

    .prologue
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader$Listener;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>.Listener;"
    const/4 v2, 0x1

    .line 391
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    # getter for: Lcom/amazon/ansel/fetch/ResourceLoader;->state:I
    invoke-static {v0}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$400(Lcom/amazon/ansel/fetch/ResourceLoader;)I

    move-result v0

    if-eq v0, v2, :cond_0

    .line 406
    :goto_0
    return-void

    .line 395
    :cond_0
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    const-string/jumbo v1, "Done"

    # invokes: Lcom/amazon/ansel/fetch/ResourceLoader;->log(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$500(Lcom/amazon/ansel/fetch/ResourceLoader;Ljava/lang/String;)V

    .line 397
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    # getter for: Lcom/amazon/ansel/fetch/ResourceLoader;->stateLock:Ljava/lang/Object;
    invoke-static {v0}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$600(Lcom/amazon/ansel/fetch/ResourceLoader;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 398
    :try_start_0
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    # getter for: Lcom/amazon/ansel/fetch/ResourceLoader;->state:I
    invoke-static {v0}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$400(Lcom/amazon/ansel/fetch/ResourceLoader;)I

    move-result v0

    if-eq v0, v2, :cond_1

    .line 399
    monitor-exit v1

    goto :goto_0

    .line 403
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 402
    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    const/4 v2, 0x2

    # setter for: Lcom/amazon/ansel/fetch/ResourceLoader;->state:I
    invoke-static {v0, v2}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$402(Lcom/amazon/ansel/fetch/ResourceLoader;I)I

    .line 403
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 405
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    # invokes: Lcom/amazon/ansel/fetch/ResourceLoader;->dispose()V
    invoke-static {v0}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$700(Lcom/amazon/ansel/fetch/ResourceLoader;)V

    goto :goto_0
.end method

.method public error(Ljava/lang/Throwable;)V
    .locals 3
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 363
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader$Listener;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>.Listener;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    # getter for: Lcom/amazon/ansel/fetch/ResourceLoader;->state:I
    invoke-static {v0}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$400(Lcom/amazon/ansel/fetch/ResourceLoader;)I

    move-result v0

    const/4 v1, 0x1

    if-eq v0, v1, :cond_0

    .line 387
    :goto_0
    return-void

    .line 367
    :cond_0
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Error: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/ansel/fetch/ResourceLoader;->log(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$500(Lcom/amazon/ansel/fetch/ResourceLoader;Ljava/lang/String;)V

    .line 369
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    # getter for: Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;
    invoke-static {v0}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$200(Lcom/amazon/ansel/fetch/ResourceLoader;)Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v0

    new-instance v1, Lcom/amazon/ansel/fetch/ResourceLoader$Listener$2;

    invoke-direct {v1, p0, p1}, Lcom/amazon/ansel/fetch/ResourceLoader$Listener$2;-><init>(Lcom/amazon/ansel/fetch/ResourceLoader$Listener;Ljava/lang/Throwable;)V

    invoke-virtual {v0, v1}, Lcom/amazon/ansel/fetch/LoaderContext;->executeCallback(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public result(Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TResult;)V"
        }
    .end annotation

    .prologue
    .line 339
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader$Listener;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>.Listener;"
    .local p1, "result":Ljava/lang/Object;, "TResult;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    # getter for: Lcom/amazon/ansel/fetch/ResourceLoader;->state:I
    invoke-static {v0}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$400(Lcom/amazon/ansel/fetch/ResourceLoader;)I

    move-result v0

    const/4 v1, 0x1

    if-eq v0, v1, :cond_0

    .line 359
    :goto_0
    return-void

    .line 343
    :cond_0
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    const-string/jumbo v1, "Sending result"

    # invokes: Lcom/amazon/ansel/fetch/ResourceLoader;->log(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$500(Lcom/amazon/ansel/fetch/ResourceLoader;Ljava/lang/String;)V

    .line 345
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;->this$0:Lcom/amazon/ansel/fetch/ResourceLoader;

    # getter for: Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;
    invoke-static {v0}, Lcom/amazon/ansel/fetch/ResourceLoader;->access$200(Lcom/amazon/ansel/fetch/ResourceLoader;)Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v0

    new-instance v1, Lcom/amazon/ansel/fetch/ResourceLoader$Listener$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/ansel/fetch/ResourceLoader$Listener$1;-><init>(Lcom/amazon/ansel/fetch/ResourceLoader$Listener;Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Lcom/amazon/ansel/fetch/LoaderContext;->executeCallback(Ljava/lang/Runnable;)V

    goto :goto_0
.end method
