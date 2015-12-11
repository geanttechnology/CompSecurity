.class Lcom/aio/downloader/activity/RingtoneDownloadedActivity$8;
.super Ljava/lang/Object;
.source "RingtoneDownloadedActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->buildLister()V
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
    iput-object p1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$8;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    .line 334
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const v3, 0x7f02015e

    const/16 v2, 0x8

    const/4 v1, 0x1

    .line 339
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$8;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$3(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 340
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$8;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$3(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->pause()V

    .line 341
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$8;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->playpauseringtone:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$12(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 342
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$8;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$13(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;Ljava/lang/Boolean;)V

    .line 343
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$8;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->playbarringtone:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$5(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 349
    :goto_0
    return-void

    .line 345
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$8;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->playpauseringtone:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$12(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Landroid/widget/ImageView;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 346
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$8;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$13(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;Ljava/lang/Boolean;)V

    .line 347
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$8;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->playbarringtone:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$5(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0
.end method
