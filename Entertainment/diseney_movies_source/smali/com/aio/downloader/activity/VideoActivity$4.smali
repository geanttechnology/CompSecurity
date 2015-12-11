.class Lcom/aio/downloader/activity/VideoActivity$4;
.super Ljava/lang/Object;
.source "VideoActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/VideoActivity;->dowload_video(Ljava/util/ArrayList;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/widget/AdapterView$OnItemClickListener;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/VideoActivity;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/VideoDownloadDialog;

.field private final synthetic val$list:Ljava/util/ArrayList;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/VideoActivity;Ljava/util/ArrayList;Lcom/aio/downloader/dialog/VideoDownloadDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/VideoActivity$4;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/VideoActivity$4;->val$list:Ljava/util/ArrayList;

    iput-object p3, p0, Lcom/aio/downloader/activity/VideoActivity$4;->val$dialog:Lcom/aio/downloader/dialog/VideoDownloadDialog;

    .line 498
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 6
    .param p2, "arg1"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "arg3"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 509
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/activity/VideoActivity$4;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity$4;->val$list:Ljava/util/ArrayList;

    invoke-virtual {v1, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/VideoModel;

    .line 510
    invoke-virtual {v1}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_id()Ljava/lang/String;

    move-result-object v3

    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity$4;->val$list:Ljava/util/ArrayList;

    invoke-virtual {v1, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/VideoModel;

    .line 511
    invoke-virtual {v1}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_title()Ljava/lang/String;

    move-result-object v4

    .line 512
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity$4;->val$list:Ljava/util/ArrayList;

    invoke-virtual {v1, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/VideoModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_url()Ljava/lang/String;

    move-result-object v5

    .line 513
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity$4;->val$list:Ljava/util/ArrayList;

    invoke-virtual {v1, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/VideoModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_img()Ljava/lang/String;

    move-result-object v1

    .line 509
    invoke-virtual {v2, v3, v4, v5, v1}, Lcom/aio/downloader/activity/VideoActivity;->VideoDownload(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 514
    new-instance v1, Ljava/lang/Thread;

    new-instance v2, Lcom/aio/downloader/activity/VideoActivity$4$1;

    iget-object v3, p0, Lcom/aio/downloader/activity/VideoActivity$4;->val$list:Ljava/util/ArrayList;

    invoke-direct {v2, p0, v3, p3}, Lcom/aio/downloader/activity/VideoActivity$4$1;-><init>(Lcom/aio/downloader/activity/VideoActivity$4;Ljava/util/ArrayList;I)V

    invoke-direct {v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 524
    invoke-virtual {v1}, Ljava/lang/Thread;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 531
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity$4;->val$dialog:Lcom/aio/downloader/dialog/VideoDownloadDialog;

    invoke-virtual {v1}, Lcom/aio/downloader/dialog/VideoDownloadDialog;->dismiss()V

    .line 532
    return-void

    .line 526
    :catch_0
    move-exception v0

    .line 528
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method
