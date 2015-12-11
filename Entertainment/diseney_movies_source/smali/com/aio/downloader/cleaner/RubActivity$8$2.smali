.class Lcom/aio/downloader/cleaner/RubActivity$8$2;
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
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$8$2;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    .line 691
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/cleaner/RubActivity$8$2;)Lcom/aio/downloader/cleaner/RubActivity$8;
    .locals 1

    .prologue
    .line 691
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8$2;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 695
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 696
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8$2;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->flag_clean:Z
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$44(Lcom/aio/downloader/cleaner/RubActivity;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 719
    return-void

    .line 697
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8$2;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->cont_clean:D
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$45(Lcom/aio/downloader/cleaner/RubActivity;)D

    move-result-wide v1

    const-wide v3, 0x3ff199999999999aL    # 1.1

    add-double/2addr v1, v3

    invoke-static {v0, v1, v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$46(Lcom/aio/downloader/cleaner/RubActivity;D)V

    .line 698
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8$2;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->tv_jieguo_rub:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$35(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/cleaner/RubActivity$8$2$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/cleaner/RubActivity$8$2$1;-><init>(Lcom/aio/downloader/cleaner/RubActivity$8$2;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->post(Ljava/lang/Runnable;)Z

    .line 711
    const-wide/16 v0, 0x14

    :try_start_0
    invoke-static {v0, v1}, Lcom/aio/downloader/cleaner/RubActivity$8$2;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 715
    :goto_1
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8$2;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->cont_clean:D
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$45(Lcom/aio/downloader/cleaner/RubActivity;)D

    move-result-wide v0

    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$8$2;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v2

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->roundDouble:Ljava/lang/Double;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$11(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    cmpl-double v0, v0, v2

    if-ltz v0, :cond_0

    .line 716
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8$2;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/aio/downloader/cleaner/RubActivity;->access$43(Lcom/aio/downloader/cleaner/RubActivity;Z)V

    goto :goto_0

    .line 712
    :catch_0
    move-exception v0

    goto :goto_1
.end method
