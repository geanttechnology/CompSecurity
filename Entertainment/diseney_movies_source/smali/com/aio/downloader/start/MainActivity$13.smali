.class Lcom/aio/downloader/start/MainActivity$13;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/start/MainActivity;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/start/MainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/start/MainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/start/MainActivity$13;->this$0:Lcom/aio/downloader/start/MainActivity;

    .line 720
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 725
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/start/MainActivity$13;->this$0:Lcom/aio/downloader/start/MainActivity;

    .line 726
    const-class v2, Lcom/aio/downloader/activity/MyDownloaderList;

    .line 725
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 727
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "acquire_url_start"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 728
    iget-object v1, p0, Lcom/aio/downloader/start/MainActivity$13;->this$0:Lcom/aio/downloader/start/MainActivity;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/start/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 729
    iget-object v1, p0, Lcom/aio/downloader/start/MainActivity$13;->this$0:Lcom/aio/downloader/start/MainActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/start/MainActivity;->finish()V

    .line 730
    iget-object v1, p0, Lcom/aio/downloader/start/MainActivity$13;->this$0:Lcom/aio/downloader/start/MainActivity;

    const v2, 0x7f04000c

    const v3, 0x7f040011

    invoke-virtual {v1, v2, v3}, Lcom/aio/downloader/start/MainActivity;->overridePendingTransition(II)V

    .line 731
    return-void
.end method
