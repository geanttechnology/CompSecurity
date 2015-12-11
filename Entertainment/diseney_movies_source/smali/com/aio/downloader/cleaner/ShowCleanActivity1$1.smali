.class Lcom/aio/downloader/cleaner/ShowCleanActivity1$1;
.super Landroid/os/Handler;
.source "ShowCleanActivity1.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$1;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    .line 81
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 83
    iget v0, p1, Landroid/os/Message;->what:I

    const/16 v1, 0x64

    if-ne v0, v1, :cond_0

    .line 84
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$1;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->button1:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$0(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/Button;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Button;->performClick()Z

    .line 85
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$1;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->finish:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$1(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/Button;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 87
    :cond_0
    return-void
.end method
