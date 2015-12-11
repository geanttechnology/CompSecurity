.class Lcom/aio/downloader/service/ServiceUpdate$2$1;
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
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate$2$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    .line 299
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 303
    const-string v1, "qwa"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "icon0="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$2$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->icon0:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$0(Lcom/aio/downloader/service/ServiceUpdate$2;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 304
    new-instance v0, Landroid/content/Intent;

    const-string v1, "paidppp"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 305
    .local v0, "intent_paid":Landroid/content/Intent;
    const-string v1, "icon0"

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$2$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->icon0:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$0(Lcom/aio/downloader/service/ServiceUpdate$2;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 306
    const-string v1, "icon1"

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$2$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->icon1:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$1(Lcom/aio/downloader/service/ServiceUpdate$2;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 307
    const-string v1, "icon2"

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$2$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->icon2:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$2(Lcom/aio/downloader/service/ServiceUpdate$2;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 308
    const-string v1, "icon3"

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$2$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->icon3:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$3(Lcom/aio/downloader/service/ServiceUpdate$2;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 309
    const-string v1, "icon4"

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$2$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->icon4:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$4(Lcom/aio/downloader/service/ServiceUpdate$2;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 310
    const-string v1, "icon5"

    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$2$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->icon5:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$5(Lcom/aio/downloader/service/ServiceUpdate$2;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 311
    iget-object v1, p0, Lcom/aio/downloader/service/ServiceUpdate$2$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$2;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceUpdate$2;->access$6(Lcom/aio/downloader/service/ServiceUpdate$2;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/aio/downloader/service/ServiceUpdate;->sendBroadcast(Landroid/content/Intent;)V

    .line 313
    return-void
.end method
