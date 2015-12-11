.class Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5;
.super Landroid/content/BroadcastReceiver;
.source "RingtoneDownloadedActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/RingtoneDownloadedActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    .line 149
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5;)Lcom/aio/downloader/activity/RingtoneDownloadedActivity;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    return-object v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 154
    .line 155
    const-string v2, "ringtoneposition"

    invoke-virtual {p2, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 157
    .local v0, "ringtoneposition":Ljava/lang/String;
    const-string v2, "ringtonepositiontitle"

    invoke-virtual {p2, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 158
    .local v1, "ringtonepositiontitle":Ljava/lang/String;
    iget-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    iget-object v2, v2, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->title:Landroid/widget/TextView;

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 160
    iget-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->playbarringtone:Landroid/widget/RelativeLayout;
    invoke-static {v2}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$5(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Landroid/widget/RelativeLayout;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 162
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5$1;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5$1;-><init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5;Ljava/lang/String;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 184
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 186
    return-void
.end method
