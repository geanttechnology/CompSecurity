.class Lcom/aio/downloader/cleaner/RubActivity$5;
.super Ljava/lang/Object;
.source "RubActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/RubActivity;->onCreate(Landroid/os/Bundle;)V
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
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$5;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    .line 428
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 433
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$5;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget v0, v0, Lcom/aio/downloader/cleaner/RubActivity;->i:I

    if-nez v0, :cond_0

    .line 434
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$5;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$5;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    .line 435
    const-class v3, Lcom/aio/downloader/activity/DownloadAppManager;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 434
    invoke-virtual {v0, v1}, Lcom/aio/downloader/cleaner/RubActivity;->startActivity(Landroid/content/Intent;)V

    .line 440
    :goto_0
    return-void

    .line 437
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$5;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/RubActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "Cleaning..."

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 438
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method
