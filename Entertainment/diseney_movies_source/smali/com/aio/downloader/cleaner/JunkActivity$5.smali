.class Lcom/aio/downloader/cleaner/JunkActivity$5;
.super Ljava/lang/Object;
.source "JunkActivity.java"

# interfaces
.implements Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;


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
    iput-object p1, p0, Lcom/aio/downloader/cleaner/JunkActivity$5;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    .line 537
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public DownCount(Ljava/util/List;J)V
    .locals 2
    .param p2, "size"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/RubSoftware;",
            ">;J)V"
        }
    .end annotation

    .prologue
    .line 541
    .local p1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/wjj/eneity/RubSoftware;>;"
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 542
    .local v0, "message":Landroid/os/Message;
    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    iput-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 543
    const/4 v1, 0x4

    iput v1, v0, Landroid/os/Message;->what:I

    .line 544
    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$5;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$55(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 545
    return-void
.end method
