.class Lcom/aio/downloader/cleaner/PhoneBoostActivity$2;
.super Ljava/lang/Object;
.source "PhoneBoostActivity.java"

# interfaces
.implements Lcom/wjj/manager/BoostRuningAppManager$BoostRuningAppManagerListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/PhoneBoostActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$2;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    .line 408
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public DownCountSize(JLcom/wjj/eneity/RuningApp;)V
    .locals 4
    .param p1, "size"    # J
    .param p3, "runapp"    # Lcom/wjj/eneity/RuningApp;

    .prologue
    .line 412
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 413
    .local v0, "message":Landroid/os/Message;
    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    iput-object v3, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 414
    const/4 v3, 0x1

    iput v3, v0, Landroid/os/Message;->what:I

    .line 415
    iget-object v3, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$2;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v3

    invoke-virtual {v3, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 416
    new-instance v1, Landroid/os/Message;

    invoke-direct {v1}, Landroid/os/Message;-><init>()V

    .line 417
    .local v1, "message2":Landroid/os/Message;
    iget-object v3, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$2;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->listdata:Ljava/util/List;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$1(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3, p3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 418
    iget-object v3, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$2;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->listdata:Ljava/util/List;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$1(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Ljava/util/List;

    move-result-object v3

    iput-object v3, v1, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 419
    const/4 v3, 0x2

    iput v3, v1, Landroid/os/Message;->what:I

    .line 420
    iget-object v3, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$2;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 421
    new-instance v2, Landroid/os/Message;

    invoke-direct {v2}, Landroid/os/Message;-><init>()V

    .line 422
    .local v2, "message3":Landroid/os/Message;
    iput-object p3, v2, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 423
    const/4 v3, 0x3

    iput v3, v2, Landroid/os/Message;->what:I

    .line 424
    iget-object v3, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$2;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 425
    return-void
.end method
