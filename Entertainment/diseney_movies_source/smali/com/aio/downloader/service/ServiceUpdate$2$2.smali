.class Lcom/aio/downloader/service/ServiceUpdate$2$2;
.super Ljava/util/TimerTask;
.source "ServiceUpdate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ServiceUpdate$2;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/service/ServiceUpdate$2;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceUpdate$2;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate$2$2;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    .line 349
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 354
    new-instance v0, Landroid/content/Intent;

    const-string v2, "meiri"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 355
    .local v0, "intent_meiri":Landroid/content/Intent;
    const-string v2, "icon_pick1"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$2$2;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$6(Lcom/aio/downloader/service/ServiceUpdate$2;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->icon_pick1:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$10(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 356
    const-string v2, "title_pick1"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$2$2;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$6(Lcom/aio/downloader/service/ServiceUpdate$2;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->title_pick1:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$11(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 357
    const-string v2, "short_desc1"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$2$2;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$6(Lcom/aio/downloader/service/ServiceUpdate$2;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->short_desc1:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$12(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 358
    const-string v2, "id_meiri"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$2$2;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$6(Lcom/aio/downloader/service/ServiceUpdate$2;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->id_meiri:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$13(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 359
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$2$2;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$6(Lcom/aio/downloader/service/ServiceUpdate$2;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/aio/downloader/service/ServiceUpdate;->sendBroadcast(Landroid/content/Intent;)V

    .line 361
    new-instance v1, Landroid/content/Intent;

    const-string v2, "meiribig"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 362
    .local v1, "intent_meiribig":Landroid/content/Intent;
    const-string v2, "icon_pick"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$2$2;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$6(Lcom/aio/downloader/service/ServiceUpdate$2;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->icon_pick:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$14(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 363
    const-string v2, "title_pick"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$2$2;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$6(Lcom/aio/downloader/service/ServiceUpdate$2;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->title_pick:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$15(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 364
    const-string v2, "short_desc"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$2$2;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$6(Lcom/aio/downloader/service/ServiceUpdate$2;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->short_desc:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$16(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 365
    const-string v2, "img_pick"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$2$2;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$6(Lcom/aio/downloader/service/ServiceUpdate$2;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->img_pick:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$17(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 366
    const-string v2, "id_meiribig"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$2$2;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$6(Lcom/aio/downloader/service/ServiceUpdate$2;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->id_meiribig:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$18(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 367
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$2$2;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$6(Lcom/aio/downloader/service/ServiceUpdate$2;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/aio/downloader/service/ServiceUpdate;->sendBroadcast(Landroid/content/Intent;)V

    .line 369
    return-void
.end method
