.class Lcom/aio/downloader/activity/Mp3DownloadedActivity$7;
.super Ljava/lang/Object;
.source "Mp3DownloadedActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/Mp3DownloadedActivity;->buildLister()V
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
    iput-object p1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$7;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    .line 301
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 305
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$7;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->istag:Ljava/lang/Boolean;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$11(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 307
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$7;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$3(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->pause()V

    .line 308
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$7;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->playpausemp3:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$12(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Landroid/widget/ImageView;

    move-result-object v0

    .line 309
    const v1, 0x7f02015a

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 310
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$7;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$13(Lcom/aio/downloader/activity/Mp3DownloadedActivity;Ljava/lang/Boolean;)V

    .line 319
    :goto_0
    return-void

    .line 312
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$7;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$3(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->play()V

    .line 313
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$7;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->playpausemp3:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$12(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Landroid/widget/ImageView;

    move-result-object v0

    .line 314
    const v1, 0x7f02015e

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 315
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$7;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$13(Lcom/aio/downloader/activity/Mp3DownloadedActivity;Ljava/lang/Boolean;)V

    goto :goto_0
.end method
