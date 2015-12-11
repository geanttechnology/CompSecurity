.class Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6$1;
.super Ljava/lang/Object;
.source "ShowCleanActivity_Rub.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6$1;->this$1:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;

    .line 226
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 231
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6$1;->this$1:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->access$0(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;)Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->tv_jieguo:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$8(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6$1;->this$1:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->access$0(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;)Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    move-result-object v2

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->cont:D
    invoke-static {v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$6(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "MB"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 232
    return-void
.end method
