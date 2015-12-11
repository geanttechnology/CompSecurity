.class Lcom/aio/downloader/cleaner/RubActivity$3;
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
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$3;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    .line 404
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 408
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$3;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/RubActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 409
    const-class v2, Lcom/aio/downloader/activity/DownloadAppManager;

    .line 408
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 410
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$3;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/cleaner/RubActivity;->startActivity(Landroid/content/Intent;)V

    .line 411
    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$3;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/RubActivity;->finish()V

    .line 412
    const/4 v1, 0x0

    sput-boolean v1, Lcom/aio/downloader/utils/publicTools;->cleanertag:Z

    .line 413
    return-void
.end method
