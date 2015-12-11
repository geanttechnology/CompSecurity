.class Lcom/aio/downloader/cleaner/RubActivity$8$2$1;
.super Ljava/lang/Object;
.source "RubActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/RubActivity$8$2;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/aio/downloader/cleaner/RubActivity$8$2;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/RubActivity$8$2;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$8$2$1;->this$2:Lcom/aio/downloader/cleaner/RubActivity$8$2;

    .line 698
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 703
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$8$2$1;->this$2:Lcom/aio/downloader/cleaner/RubActivity$8$2;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8$2;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity$8$2;->access$0(Lcom/aio/downloader/cleaner/RubActivity$8$2;)Lcom/aio/downloader/cleaner/RubActivity$8;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->tv_jieguo_rub:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$35(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v0

    .line 704
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "This time released: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 706
    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$8$2$1;->this$2:Lcom/aio/downloader/cleaner/RubActivity$8$2;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8$2;->this$1:Lcom/aio/downloader/cleaner/RubActivity$8;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity$8$2;->access$0(Lcom/aio/downloader/cleaner/RubActivity$8$2;)Lcom/aio/downloader/cleaner/RubActivity$8;

    move-result-object v2

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$8;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity$8;->access$2(Lcom/aio/downloader/cleaner/RubActivity$8;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v2

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->cont_clean:D
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$45(Lcom/aio/downloader/cleaner/RubActivity;)D

    move-result-wide v2

    .line 707
    const/4 v4, 0x2

    .line 705
    invoke-static {v2, v3, v4}, Lcom/aio/downloader/cleaner/RubActivity;->roundDouble(DI)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 707
    const-string v2, "MB"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 704
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 708
    return-void
.end method
