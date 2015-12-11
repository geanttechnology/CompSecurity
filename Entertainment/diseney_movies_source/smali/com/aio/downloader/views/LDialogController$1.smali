.class Lcom/aio/downloader/views/LDialogController$1;
.super Ljava/lang/Object;
.source "LDialogController.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/LDialogController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/LDialogController;


# direct methods
.method constructor <init>(Lcom/aio/downloader/views/LDialogController;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/views/LDialogController$1;->this$0:Lcom/aio/downloader/views/LDialogController;

    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 68
    const/4 v0, 0x0

    .line 69
    .local v0, "m":Landroid/os/Message;
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogController$1;->this$0:Lcom/aio/downloader/views/LDialogController;

    # getter for: Lcom/aio/downloader/views/LDialogController;->mButtonPositive:Lcom/aio/downloader/views/LButton;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogController;->access$0(Lcom/aio/downloader/views/LDialogController;)Lcom/aio/downloader/views/LButton;

    move-result-object v1

    if-ne p1, v1, :cond_2

    iget-object v1, p0, Lcom/aio/downloader/views/LDialogController$1;->this$0:Lcom/aio/downloader/views/LDialogController;

    # getter for: Lcom/aio/downloader/views/LDialogController;->mButtonPositiveMessage:Landroid/os/Message;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogController;->access$1(Lcom/aio/downloader/views/LDialogController;)Landroid/os/Message;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 70
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogController$1;->this$0:Lcom/aio/downloader/views/LDialogController;

    # getter for: Lcom/aio/downloader/views/LDialogController;->mButtonPositiveMessage:Landroid/os/Message;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogController;->access$1(Lcom/aio/downloader/views/LDialogController;)Landroid/os/Message;

    move-result-object v1

    invoke-static {v1}, Landroid/os/Message;->obtain(Landroid/os/Message;)Landroid/os/Message;

    move-result-object v0

    .line 74
    :cond_0
    :goto_0
    if-eqz v0, :cond_1

    .line 75
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 78
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogController$1;->this$0:Lcom/aio/downloader/views/LDialogController;

    iget-boolean v1, v1, Lcom/aio/downloader/views/LDialogController;->clickPositiveBtnDismiss:Z

    if-nez v1, :cond_3

    iget-object v1, p0, Lcom/aio/downloader/views/LDialogController$1;->this$0:Lcom/aio/downloader/views/LDialogController;

    # getter for: Lcom/aio/downloader/views/LDialogController;->mButtonPositive:Lcom/aio/downloader/views/LButton;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogController;->access$0(Lcom/aio/downloader/views/LDialogController;)Lcom/aio/downloader/views/LButton;

    move-result-object v1

    if-ne p1, v1, :cond_3

    .line 85
    :goto_1
    return-void

    .line 71
    :cond_2
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogController$1;->this$0:Lcom/aio/downloader/views/LDialogController;

    # getter for: Lcom/aio/downloader/views/LDialogController;->mButtonNegative:Lcom/aio/downloader/views/LButton;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogController;->access$2(Lcom/aio/downloader/views/LDialogController;)Lcom/aio/downloader/views/LButton;

    move-result-object v1

    if-ne p1, v1, :cond_0

    iget-object v1, p0, Lcom/aio/downloader/views/LDialogController$1;->this$0:Lcom/aio/downloader/views/LDialogController;

    # getter for: Lcom/aio/downloader/views/LDialogController;->mButtonNegativeMessage:Landroid/os/Message;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogController;->access$3(Lcom/aio/downloader/views/LDialogController;)Landroid/os/Message;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 72
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogController$1;->this$0:Lcom/aio/downloader/views/LDialogController;

    # getter for: Lcom/aio/downloader/views/LDialogController;->mButtonNegativeMessage:Landroid/os/Message;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogController;->access$3(Lcom/aio/downloader/views/LDialogController;)Landroid/os/Message;

    move-result-object v1

    invoke-static {v1}, Landroid/os/Message;->obtain(Landroid/os/Message;)Landroid/os/Message;

    move-result-object v0

    goto :goto_0

    .line 83
    :cond_3
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogController$1;->this$0:Lcom/aio/downloader/views/LDialogController;

    # getter for: Lcom/aio/downloader/views/LDialogController;->mHandler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogController;->access$4(Lcom/aio/downloader/views/LDialogController;)Landroid/os/Handler;

    move-result-object v1

    const/4 v2, 0x1

    .line 84
    iget-object v3, p0, Lcom/aio/downloader/views/LDialogController$1;->this$0:Lcom/aio/downloader/views/LDialogController;

    # getter for: Lcom/aio/downloader/views/LDialogController;->mDialogInterface:Landroid/content/DialogInterface;
    invoke-static {v3}, Lcom/aio/downloader/views/LDialogController;->access$5(Lcom/aio/downloader/views/LDialogController;)Landroid/content/DialogInterface;

    move-result-object v3

    .line 83
    invoke-virtual {v1, v2, v3}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    .line 84
    invoke-virtual {v1}, Landroid/os/Message;->sendToTarget()V

    goto :goto_1
.end method
