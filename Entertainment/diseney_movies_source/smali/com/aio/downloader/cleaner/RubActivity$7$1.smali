.class Lcom/aio/downloader/cleaner/RubActivity$7$1;
.super Ljava/lang/Object;
.source "RubActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/RubActivity$7;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/cleaner/RubActivity$7;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/RubActivity$7;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$7$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$7;

    .line 574
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    const/high16 v4, 0x42480000    # 50.0f

    .line 578
    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->cont:D
    invoke-static {}, Lcom/aio/downloader/cleaner/RubActivity;->access$26()D

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmpg-double v0, v0, v2

    if-gez v0, :cond_0

    .line 579
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$7$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$7;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$7;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity$7;->access$0(Lcom/aio/downloader/cleaner/RubActivity$7;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->tv_neicun:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$10(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setTextSize(F)V

    .line 580
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$7$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$7;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$7;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity$7;->access$0(Lcom/aio/downloader/cleaner/RubActivity$7;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->tv_neicun:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$10(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v0

    const-string v1, "0"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 585
    :goto_0
    return-void

    .line 582
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$7$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$7;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$7;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity$7;->access$0(Lcom/aio/downloader/cleaner/RubActivity$7;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->tv_neicun:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$10(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setTextSize(F)V

    .line 583
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$7$1;->this$1:Lcom/aio/downloader/cleaner/RubActivity$7;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity$7;->this$0:Lcom/aio/downloader/cleaner/RubActivity;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity$7;->access$0(Lcom/aio/downloader/cleaner/RubActivity$7;)Lcom/aio/downloader/cleaner/RubActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->tv_neicun:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$10(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->cont:D
    invoke-static {}, Lcom/aio/downloader/cleaner/RubActivity;->access$26()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
