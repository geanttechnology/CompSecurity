.class Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;
.super Ljava/lang/Thread;
.source "ShowCleanActivity_Rub.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    .line 218
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;)Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;
    .locals 1

    .prologue
    .line 218
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 222
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 223
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->flag:Z
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$5(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 244
    return-void

    .line 224
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->cont:D
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$6(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)D

    move-result-wide v2

    const-wide v4, 0x3ff199999999999aL    # 1.1

    add-double/2addr v2, v4

    invoke-static {v1, v2, v3}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$7(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;D)V

    .line 225
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    iget-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->cont:D
    invoke-static {v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$6(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)D

    move-result-wide v2

    const/4 v4, 0x2

    invoke-static {v2, v3, v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->roundDouble(DI)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    invoke-static {v1, v2, v3}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$7(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;D)V

    .line 226
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->tv_jieguo:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$8(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Landroid/widget/TextView;

    move-result-object v1

    new-instance v2, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6$1;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->post(Ljava/lang/Runnable;)Z

    .line 235
    const-wide/16 v1, 0x7

    :try_start_0
    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 240
    :goto_1
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->cont:D
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$6(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)D

    move-result-wide v1

    iget-object v3, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->roundDouble1:Ljava/lang/Double;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$9(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Ljava/lang/Double;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v3

    cmpl-double v1, v1, v3

    if-ltz v1, :cond_0

    .line 241
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$10(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;Z)V

    goto :goto_0

    .line 236
    :catch_0
    move-exception v0

    .line 238
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_1
.end method
