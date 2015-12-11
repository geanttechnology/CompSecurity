.class Lcom/aio/downloader/cleaner/ShowCleanActivity1$4$1;
.super Ljava/lang/Object;
.source "ShowCleanActivity1.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4$1;->this$1:Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;

    .line 164
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    const-wide/high16 v4, 0x4090000000000000L    # 1024.0

    .line 169
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4$1;->this$1:Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->access$0(Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;)Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->cont:D
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$17(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)D

    move-result-wide v0

    cmpg-double v0, v0, v4

    if-gez v0, :cond_0

    .line 170
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4$1;->this$1:Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->access$0(Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;)Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->tv_jieguo:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$19(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Cleaned: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4$1;->this$1:Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->access$0(Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;)Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    move-result-object v2

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->cont:D
    invoke-static {v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$17(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "MB"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 176
    :goto_0
    return-void

    .line 173
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4$1;->this$1:Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->access$0(Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;)Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->tv_jieguo:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$19(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Cleaned: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 174
    iget-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4$1;->this$1:Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity1;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;->access$0(Lcom/aio/downloader/cleaner/ShowCleanActivity1$4;)Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    move-result-object v2

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity1;->cont:D
    invoke-static {v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->access$17(Lcom/aio/downloader/cleaner/ShowCleanActivity1;)D

    move-result-wide v2

    div-double/2addr v2, v4

    const/4 v4, 0x2

    invoke-static {v2, v3, v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity1;->roundDouble(DI)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "GB"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 173
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
