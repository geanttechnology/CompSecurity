.class Lcom/aio/downloader/cleaner/RubActivity$8$1;
.super Ljava/lang/Thread;
.source "RubActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/RubActivity$8;->onPostExecute(Ljava/lang/Void;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/cleaner/RubActivity$8;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/RubActivity$8;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$8$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    .line 648
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/cleaner/RubActivity$8$1;)Lcom/aio/downloader/cleaner/RubActivity$8;
    .locals 1

    .prologue
    .line 648
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 653
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 654
    :cond_0
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$8$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v2

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->flag_cilcle:Z
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$38(Lcom/aio/downloader/cleaner/RubActivity;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 686
    return-void

    .line 655
    :cond_1
    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$8$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v2

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->pos:I
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$39(Lcom/aio/downloader/cleaner/RubActivity;)I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-static {v2, v3}, Lcom/aio/downloader/cleaner/RubActivity;->access$40(Lcom/aio/downloader/cleaner/RubActivity;I)V

    .line 656
    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$8$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v2

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->rp_chuang1:Lcom/aio/downloader/views/RoundProgressBar;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$41(Lcom/aio/downloader/cleaner/RubActivity;)Lcom/aio/downloader/views/RoundProgressBar;

    move-result-object v2

    new-instance v3, Lcom/aio/downloader/cleaner/RubActivity$8$1$1;

    invoke-direct {v3, p0}, Lcom/aio/downloader/cleaner/RubActivity$8$1$1;-><init>(Lcom/aio/downloader/cleaner/RubActivity$8$1;)V

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/RoundProgressBar;->post(Ljava/lang/Runnable;)Z

    .line 666
    const-wide/16 v2, 0x23

    :try_start_0
    invoke-static {v2, v3}, Lcom/aio/downloader/cleaner/RubActivity$8$1;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 670
    :goto_1
    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$8$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v2

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->pos:I
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$39(Lcom/aio/downloader/cleaner/RubActivity;)I

    move-result v2

    const/16 v3, 0x50

    if-le v2, v3, :cond_2

    .line 672
    const-wide/16 v2, 0x2d

    :try_start_1
    invoke-static {v2, v3}, Lcom/aio/downloader/cleaner/RubActivity$8$1;->sleep(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1

    .line 677
    :cond_2
    :goto_2
    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$8$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v2

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->pos:I
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$39(Lcom/aio/downloader/cleaner/RubActivity;)I

    move-result v2

    const/16 v3, 0x64

    if-ne v2, v3, :cond_0

    .line 678
    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$8$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v2

    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/aio/downloader/cleaner/RubActivity;->access$37(Lcom/aio/downloader/cleaner/RubActivity;Z)V

    .line 680
    new-instance v1, Landroid/os/Message;

    invoke-direct {v1}, Landroid/os/Message;-><init>()V

    .line 681
    .local v1, "message":Landroid/os/Message;
    const/16 v2, 0xc8

    iput v2, v1, Landroid/os/Message;->what:I

    .line 682
    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$8$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v2

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->handler2:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$42(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/os/Handler;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0

    .line 667
    .end local v1    # "message":Landroid/os/Message;
    :catch_0
    move-exception v0

    .line 668
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_1

    .line 673
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :catch_1
    move-exception v0

    .line 674
    .restart local v0    # "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_2
.end method
