.class Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;
.super Landroid/os/AsyncTask;
.source "MySettingsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MySettingsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MyAsyncTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field private mProgressDialog:Landroid/app/ProgressDialog;

.field final synthetic this$0:Lcom/aio/downloader/activity/MySettingsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MySettingsActivity;)V
    .locals 0

    .prologue
    .line 431
    iput-object p1, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 3
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 445
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 446
    sget-object v2, Lcom/aio/downloader/utils/Myutils;->packagename:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "webcache"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 445
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MySettingsActivity;->delFolder(Ljava/lang/String;)V

    .line 448
    const-string v0, "hjhj"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 449
    sget-object v2, Lcom/aio/downloader/utils/Myutils;->packagename:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "webcache"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 448
    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 450
    const/4 v0, 0x0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 457
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 458
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;->mProgressDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 459
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 460
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 462
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/MySettingsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "done"

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 463
    return-void
.end method

.method protected onPreExecute()V
    .locals 4

    .prologue
    .line 438
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 439
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    .line 440
    const/4 v1, 0x0

    iget-object v2, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    const v3, 0x7f0b003e

    invoke-virtual {v2, v3}, Lcom/aio/downloader/activity/MySettingsActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 439
    invoke-static {v0, v1, v2}, Landroid/app/ProgressDialog;->show(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/app/ProgressDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTask;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 441
    return-void
.end method
