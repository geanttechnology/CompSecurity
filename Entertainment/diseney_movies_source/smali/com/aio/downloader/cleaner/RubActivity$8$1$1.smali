.class Lcom/aio/downloader/cleaner/RubActivity$8$1$1;
.super Ljava/lang/Object;
.source "RubActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/RubActivity$8$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/aio/downloader/cleaner/RubActivity$8$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/RubActivity$8$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$8$1$1;->this$2:Lcom/aio/downloader/cleaner/RubActivity$8$1;

    .line 656
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 661
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8$1$1;->this$2:Lcom/aio/downloader/cleaner/RubActivity$8$1;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity$8$1;->access$0(Lcom/aio/downloader/cleaner/RubActivity$8$1;)Lcom/aio/downloader/cleaner/RubActivity$8;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->rp_chuang1:Lcom/aio/downloader/views/RoundProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$41(Lcom/aio/downloader/cleaner/RubActivity;)Lcom/aio/downloader/views/RoundProgressBar;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$8$1$1;->this$2:Lcom/aio/downloader/cleaner/RubActivity$8$1;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/RubActivity$8$1;->access$0(Lcom/aio/downloader/cleaner/RubActivity$8$1;)Lcom/aio/downloader/cleaner/RubActivity$8;

    move-result-object v1

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v1

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->pos:I
    invoke-static {v1}, Lcom/aio/downloader/cleaner/RubActivity;->access$39(Lcom/aio/downloader/cleaner/RubActivity;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/RoundProgressBar;->setProgress(I)V

    .line 662
    return-void
.end method
