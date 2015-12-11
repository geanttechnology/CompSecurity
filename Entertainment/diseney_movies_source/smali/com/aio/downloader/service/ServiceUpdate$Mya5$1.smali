.class Lcom/aio/downloader/service/ServiceUpdate$Mya5$1;
.super Ljava/util/TimerTask;
.source "ServiceUpdate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ServiceUpdate$Mya5;->ShowResult6(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya5;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya5;

    .line 1353
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 1358
    new-instance v0, Landroid/content/Intent;

    const-string v2, "meiri"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1359
    .local v0, "intent_meiri":Landroid/content/Intent;
    const-string v2, "icon_pick1"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya5;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya5;->icon_pick1:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->access$2(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1360
    const-string v2, "title_pick1"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya5;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya5;->title_pick1:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->access$3(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1361
    const-string v2, "short_desc1"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya5;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya5;->short_desc1:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->access$4(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1362
    const-string v2, "id_meiri"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya5;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->access$6(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->id_meiri:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$13(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1363
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya5;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->access$6(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/aio/downloader/service/ServiceUpdate;->sendBroadcast(Landroid/content/Intent;)V

    .line 1365
    new-instance v1, Landroid/content/Intent;

    const-string v2, "meiribig"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1366
    .local v1, "intent_meiribig":Landroid/content/Intent;
    const-string v2, "icon_pick"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya5;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->access$6(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->icon_pick:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$14(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1367
    const-string v2, "title_pick"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya5;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->access$6(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->title_pick:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$15(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1368
    const-string v2, "short_desc"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya5;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->access$6(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->short_desc:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$16(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1369
    const-string v2, "img_pick"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya5;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya5;->img_pick:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->access$5(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1370
    const-string v2, "id_meiribig"

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya5;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->access$6(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v3

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->id_meiribig:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$18(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1371
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya5$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya5;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya5;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate$Mya5;->access$6(Lcom/aio/downloader/service/ServiceUpdate$Mya5;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/aio/downloader/service/ServiceUpdate;->sendBroadcast(Landroid/content/Intent;)V

    .line 1373
    return-void
.end method
