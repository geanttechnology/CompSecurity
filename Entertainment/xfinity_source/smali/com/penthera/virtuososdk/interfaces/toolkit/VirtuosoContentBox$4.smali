.class Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$4;
.super Ljava/lang/Object;
.source "VirtuosoContentBox.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->initService()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;


# direct methods
.method constructor <init>(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$4;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    .line 362
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 3
    .param p1, "className"    # Landroid/content/ComponentName;
    .param p2, "service"    # Landroid/os/IBinder;

    .prologue
    .line 366
    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$8()Ljava/lang/String;

    move-result-object v0

    .line 367
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Service Connected: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/ComponentName;->getClassName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 366
    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 388
    const-class v0, Lcom/penthera/virtuososdk/service/VirtuosoService;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    .line 389
    invoke-virtual {p1}, Landroid/content/ComponentName;->getClassName()Ljava/lang/String;

    move-result-object v1

    .line 388
    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 390
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$4;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-static {p2}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;->asInterface(Landroid/os/IBinder;)Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$9(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;)V

    .line 391
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$4;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    # invokes: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->registerCallbackHandlers()V
    invoke-static {v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$10(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)V

    .line 392
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$4;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceConnectedCallback:Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;
    invoke-static {v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$11(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 393
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$4;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceConnectedCallback:Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;
    invoke-static {v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$11(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;

    move-result-object v0

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;->connected()V

    .line 396
    :cond_0
    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 4
    .param p1, "className"    # Landroid/content/ComponentName;

    .prologue
    const/4 v3, 0x0

    .line 400
    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$8()Ljava/lang/String;

    move-result-object v0

    .line 401
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Service Disconnected: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/ComponentName;->getClassName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 400
    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 404
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$4;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$9(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;)V

    .line 405
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$4;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-static {v0, v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$12(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;Z)V

    .line 406
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$4;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-static {v0, v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$13(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;S)V

    .line 407
    return-void
.end method
