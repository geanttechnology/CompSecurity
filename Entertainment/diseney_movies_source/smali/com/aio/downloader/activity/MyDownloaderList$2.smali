.class Lcom/aio/downloader/activity/MyDownloaderList$2;
.super Landroid/content/BroadcastReceiver;
.source "MyDownloaderList.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyDownloaderList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyDownloaderList;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyDownloaderList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList$2;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    .line 143
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MyDownloaderList$2;)Lcom/aio/downloader/activity/MyDownloaderList;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$2;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    return-object v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 147
    const-string v2, "mp3position"

    invoke-virtual {p2, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 149
    .local v0, "mp3position":Ljava/lang/String;
    const-string v2, "mp3positiontitle"

    invoke-virtual {p2, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 150
    .local v1, "mp3positiontitle":Ljava/lang/String;
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList$2;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    iget-object v2, v2, Lcom/aio/downloader/activity/MyDownloaderList;->title:Landroid/widget/TextView;

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 152
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList$2;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->playbarmp3:Landroid/widget/RelativeLayout;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyDownloaderList;->access$9(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/RelativeLayout;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 154
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/aio/downloader/activity/MyDownloaderList$2$1;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList$2$1;-><init>(Lcom/aio/downloader/activity/MyDownloaderList$2;Ljava/lang/String;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 176
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 177
    return-void
.end method
