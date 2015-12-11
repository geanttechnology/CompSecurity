.class Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$2;
.super Ljava/lang/Object;
.source "VideoActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->onPostExecute(Ljava/util/ArrayList;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;

.field private final synthetic val$list:Ljava/util/ArrayList;

.field private final synthetic val$restarydialog:Lcom/aio/downloader/dialog/RestaryDownloadDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;Lcom/aio/downloader/dialog/RestaryDownloadDialog;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$2;->this$1:Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;

    iput-object p2, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$2;->val$restarydialog:Lcom/aio/downloader/dialog/RestaryDownloadDialog;

    iput-object p3, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$2;->val$list:Ljava/util/ArrayList;

    .line 437
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 441
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$2;->val$restarydialog:Lcom/aio/downloader/dialog/RestaryDownloadDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/RestaryDownloadDialog;->dismiss()V

    .line 442
    new-instance v0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;

    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$2;->this$1:Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;

    # getter for: Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->access$2(Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;)Lcom/aio/downloader/activity/VideoActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;-><init>(Lcom/aio/downloader/activity/VideoActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 443
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$2;->this$1:Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;

    # getter for: Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->access$2(Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;)Lcom/aio/downloader/activity/VideoActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$2;->val$list:Ljava/util/ArrayList;

    # invokes: Lcom/aio/downloader/activity/VideoActivity;->dowload_video(Ljava/util/ArrayList;)V
    invoke-static {v0, v1}, Lcom/aio/downloader/activity/VideoActivity;->access$12(Lcom/aio/downloader/activity/VideoActivity;Ljava/util/ArrayList;)V

    .line 445
    return-void
.end method
