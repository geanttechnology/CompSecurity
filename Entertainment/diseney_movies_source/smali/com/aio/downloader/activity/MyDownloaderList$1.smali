.class Lcom/aio/downloader/activity/MyDownloaderList$1;
.super Landroid/os/Handler;
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
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    .line 92
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 7
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 96
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 97
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 138
    :goto_0
    return-void

    .line 100
    :pswitch_0
    :try_start_0
    iget-object v6, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$0(Lcom/aio/downloader/activity/MyDownloaderList;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 101
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 100
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    invoke-static {v6, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$1(Lcom/aio/downloader/activity/MyDownloaderList;Ljava/util/List;)V

    .line 102
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->ds:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$2(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-eqz v0, :cond_0

    .line 104
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->ll_downnull:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$3(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 105
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->tv_downloading:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$4(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/TextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 112
    :goto_1
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$5(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 114
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->ll_downnull:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$3(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 115
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->tv_downloaded:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$6(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/TextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 116
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->rl_downloading:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$7(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 128
    :goto_2
    :pswitch_1
    :try_start_1
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    iget-object v0, v0, Lcom/aio/downloader/activity/MyDownloaderList;->currenttime:Landroid/widget/TextView;

    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyDownloaderList;->access$8(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/utils/Player;

    move-result-object v2

    iget-object v2, v2, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 129
    invoke-virtual {v2}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v2

    int-to-long v2, v2

    .line 128
    invoke-static {v2, v3}, Lcom/aio/downloader/utils/Player;->formatTime(J)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0

    .line 130
    :catch_0
    move-exception v0

    goto/16 :goto_0

    .line 107
    :cond_0
    :try_start_2
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->ll_downnull:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$3(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 108
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->tv_downloading:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$4(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/TextView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 123
    :catch_1
    move-exception v0

    goto :goto_2

    .line 119
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->tv_downloaded:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$6(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/TextView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 120
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$1;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->rl_downloading:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$7(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_2

    .line 97
    :pswitch_data_0
    .packed-switch 0x64
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
