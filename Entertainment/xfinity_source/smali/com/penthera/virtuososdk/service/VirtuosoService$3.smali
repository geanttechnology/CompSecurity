.class Lcom/penthera/virtuososdk/service/VirtuosoService$3;
.super Ljava/lang/Object;
.source "VirtuosoService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/penthera/virtuososdk/service/VirtuosoService;->onBind(Landroid/content/Intent;)Landroid/os/IBinder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

.field private final synthetic val$auth:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    iput-object p2, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->val$auth:Ljava/lang/String;

    .line 581
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 584
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iProviders:Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;
    invoke-static {v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$12(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;

    move-result-object v1

    iget-object v2, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->val$auth:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->addProvider(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$13(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/util/List;)V

    .line 585
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientDownloadCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$1(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->val$auth:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 586
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientDownloadCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$1(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->val$auth:Ljava/lang/String;

    new-instance v2, Landroid/os/RemoteCallbackList;

    invoke-direct {v2}, Landroid/os/RemoteCallbackList;-><init>()V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 587
    :cond_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientQueueCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$3(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->val$auth:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 588
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientQueueCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$3(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->val$auth:Ljava/lang/String;

    new-instance v2, Landroid/os/RemoteCallbackList;

    invoke-direct {v2}, Landroid/os/RemoteCallbackList;-><init>()V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 589
    :cond_1
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientEngineCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$2(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->val$auth:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 590
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientEngineCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$2(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$3;->val$auth:Ljava/lang/String;

    new-instance v2, Landroid/os/RemoteCallbackList;

    invoke-direct {v2}, Landroid/os/RemoteCallbackList;-><init>()V

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 591
    :cond_2
    return-void
.end method
