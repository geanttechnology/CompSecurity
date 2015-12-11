.class Lcom/aio/downloader/cleaner/RubActivity$7;
.super Ljava/lang/Thread;
.source "RubActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/RubActivity;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/RubActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/RubActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$7;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    .line 566
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/cleaner/RubActivity$7;)Lcom/aio/downloader/cleaner/RubActivity;
    .locals 1

    .prologue
    .line 566
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$7;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 570
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 571
    :cond_0
    :goto_0
    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->flag:Z
    invoke-static {}, Lcom/aio/downloader/cleaner/RubActivity;->access$25()Z

    move-result v1

    if-nez v1, :cond_1

    .line 598
    return-void

    .line 572
    :cond_1
    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->cont:D
    invoke-static {}, Lcom/aio/downloader/cleaner/RubActivity;->access$26()D

    move-result-wide v1

    const-wide v3, 0x3ff199999999999aL    # 1.1

    sub-double/2addr v1, v3

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$7(D)V

    .line 573
    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->cont:D
    invoke-static {}, Lcom/aio/downloader/cleaner/RubActivity;->access$26()D

    move-result-wide v1

    const/4 v3, 0x2

    invoke-static {v1, v2, v3}, Lcom/aio/downloader/cleaner/RubActivity;->roundDouble(DI)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v1

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$7(D)V

    .line 574
    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$7;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->tv_neicun:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/RubActivity;->access$10(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v1

    new-instance v2, Lcom/aio/downloader/cleaner/RubActivity$7$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/cleaner/RubActivity$7$1;-><init>(Lcom/aio/downloader/cleaner/RubActivity$7;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->post(Ljava/lang/Runnable;)Z

    .line 588
    const-wide/16 v1, 0xa

    :try_start_0
    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/RubActivity$7;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 594
    :goto_1
    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->cont:D
    invoke-static {}, Lcom/aio/downloader/cleaner/RubActivity;->access$26()D

    move-result-wide v1

    const-wide/16 v3, 0x0

    cmpg-double v1, v1, v3

    if-gtz v1, :cond_0

    .line 595
    const/4 v1, 0x0

    invoke-static {v1}, Lcom/aio/downloader/cleaner/RubActivity;->access$27(Z)V

    goto :goto_0

    .line 589
    :catch_0
    move-exception v0

    .line 591
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_1
.end method
