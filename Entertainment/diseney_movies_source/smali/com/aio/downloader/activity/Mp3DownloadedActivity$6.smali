.class Lcom/aio/downloader/activity/Mp3DownloadedActivity$6;
.super Landroid/content/BroadcastReceiver;
.source "Mp3DownloadedActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/Mp3DownloadedActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$6;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    .line 185
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "arg0"    # Landroid/content/Context;
    .param p2, "arg1"    # Landroid/content/Intent;

    .prologue
    .line 190
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$6;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->champ3:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$10(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/ImageView;->performClick()Z

    .line 192
    return-void
.end method
