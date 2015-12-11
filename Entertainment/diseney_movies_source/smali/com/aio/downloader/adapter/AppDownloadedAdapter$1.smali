.class Lcom/aio/downloader/adapter/AppDownloadedAdapter$1;
.super Landroid/content/BroadcastReceiver;
.source "AppDownloadedAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/AppDownloadedAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    .line 343
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "arg0"    # Landroid/content/Context;
    .param p2, "arg1"    # Landroid/content/Intent;

    .prologue
    .line 348
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 349
    .local v0, "action":Ljava/lang/String;
    const-string v2, "MyUpver"

    const/4 v3, 0x0

    invoke-virtual {p2, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    .line 350
    .local v1, "myupver":I
    const-string v2, "wocaonima"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 352
    iget-object v2, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    iget-object v2, v2, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_stop_download_bt:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v2

    const-string v3, "Open"

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 354
    :cond_0
    return-void
.end method
