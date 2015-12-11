.class Lcom/aio/downloader/activity/MyDownloaderList$8;
.super Ljava/lang/Object;
.source "MyDownloaderList.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyDownloaderList;->buildLister()V
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
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList$8;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    .line 680
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 684
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$8;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->istag:Ljava/lang/Boolean;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$20(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 686
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$8;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$8(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->pause()V

    .line 687
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$8;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->playpausemp3:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$21(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/ImageView;

    move-result-object v0

    .line 688
    const v1, 0x7f02015a

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 689
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$8;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/MyDownloaderList;->access$22(Lcom/aio/downloader/activity/MyDownloaderList;Ljava/lang/Boolean;)V

    .line 698
    :goto_0
    return-void

    .line 691
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$8;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$8(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->play()V

    .line 692
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$8;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->playpausemp3:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$21(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/ImageView;

    move-result-object v0

    .line 693
    const v1, 0x7f02015e

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 694
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$8;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/MyDownloaderList;->access$22(Lcom/aio/downloader/activity/MyDownloaderList;Ljava/lang/Boolean;)V

    goto :goto_0
.end method
