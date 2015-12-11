.class Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;
.super Ljava/lang/Thread;
.source "ShowCleanActivity1.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity1;->onCreate(Landroid/os/Bundle;)V
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
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    .line 156
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;)Lcom/aio/downloader/cleaner/ShowCleanActivity1;
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 159
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 160
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->flag:Z
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$16(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 188
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$22(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/os/Handler;

    move-result-object v1

    const/16 v2, 0x64

    invoke-virtual {v1, v2}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 189
    return-void

    .line 161
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->cont:D
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$17(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)D

    move-result-wide v2

    const-wide v4, 0x4000cccccccccccdL    # 2.1

    add-double/2addr v2, v4

    invoke-static {v1, v2, v3}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$18(Lcom/aio/downloader/cleaner/ShowCleanActivity1;D)V

    .line 162
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    iget-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->cont:D
    invoke-static {v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$17(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)D

    move-result-wide v2

    const/4 v4, 0x2

    invoke-static {v2, v3, v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->roundDouble(DI)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    invoke-static {v1, v2, v3}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$18(Lcom/aio/downloader/cleaner/ShowCleanActivity1;D)V

    .line 163
    const-string v1, "fff"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "cont"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->cont:D
    invoke-static {v3}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$17(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)D

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 164
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->tv_jieguo:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$19(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/TextView;

    move-result-object v1

    new-instance v2, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4$1;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->post(Ljava/lang/Runnable;)Z

    .line 179
    const-wide/16 v1, 0xf

    :try_start_0
    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 184
    :goto_1
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->cont:D
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$17(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)D

    move-result-wide v1

    iget-object v3, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->roundDouble1:Ljava/lang/Double;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$20(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Ljava/lang/Double;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v3

    cmpl-double v1, v1, v3

    if-ltz v1, :cond_0

    .line 185
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$21(Lcom/aio/downloader/cleaner/ShowCleanActivity1;Z)V

    goto :goto_0

    .line 180
    :catch_0
    move-exception v0

    .line 182
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_1
.end method
