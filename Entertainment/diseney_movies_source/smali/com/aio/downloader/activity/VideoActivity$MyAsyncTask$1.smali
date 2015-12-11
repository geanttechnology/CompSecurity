.class Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$1;
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

.field private final synthetic val$restarydialog:Lcom/aio/downloader/dialog/RestaryDownloadDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;Lcom/aio/downloader/dialog/RestaryDownloadDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$1;->this$1:Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;

    iput-object p2, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$1;->val$restarydialog:Lcom/aio/downloader/dialog/RestaryDownloadDialog;

    .line 429
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 434
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$1;->val$restarydialog:Lcom/aio/downloader/dialog/RestaryDownloadDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/RestaryDownloadDialog;->dismiss()V

    .line 435
    return-void
.end method
