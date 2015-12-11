.class Lcom/aio/downloader/activity/MyMainActivity$19;
.super Ljava/lang/Thread;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$19;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 1729
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 1735
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 1736
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "http://android.downloadatoz.com/_201409/market/hits.php?type=downloader_mp3&action="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1737
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$19;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp3:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity;->access$82(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 1736
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1738
    .local v0, "url":Ljava/lang/String;
    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 1739
    return-void
.end method
