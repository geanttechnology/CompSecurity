.class Lcom/aio/downloader/cleaner/JunkActivity$4;
.super Ljava/lang/Object;
.source "JunkActivity.java"

# interfaces
.implements Lcom/wjj/manager/RuningAppManager$RuningAppManagerListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/JunkActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/JunkActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/JunkActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/JunkActivity$4;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    .line 506
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public DownCountSize(JLcom/wjj/eneity/RuningApp;)V
    .locals 3
    .param p1, "size"    # J
    .param p3, "runapp"    # Lcom/wjj/eneity/RuningApp;

    .prologue
    .line 510
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 511
    .local v0, "message":Landroid/os/Message;
    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    iput-object v2, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 512
    const/4 v2, 0x2

    iput v2, v0, Landroid/os/Message;->what:I

    .line 513
    iget-object v2, p0, Lcom/aio/downloader/cleaner/JunkActivity$4;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$55(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/os/Handler;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 514
    new-instance v1, Landroid/os/Message;

    invoke-direct {v1}, Landroid/os/Message;-><init>()V

    .line 515
    .local v1, "message22":Landroid/os/Message;
    iput-object p3, v1, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 516
    const/16 v2, 0x16

    iput v2, v1, Landroid/os/Message;->what:I

    .line 517
    iget-object v2, p0, Lcom/aio/downloader/cleaner/JunkActivity$4;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$55(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/os/Handler;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 518
    return-void
.end method
