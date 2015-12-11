.class Lcom/aio/downloader/activity/UnInstallActivity$4;
.super Landroid/os/AsyncTask;
.source "UnInstallActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/UnInstallActivity;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
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
.field final synthetic this$0:Lcom/aio/downloader/activity/UnInstallActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/UnInstallActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/UnInstallActivity$4;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    .line 206
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/UnInstallActivity$4;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 3
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 211
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$4;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    # getter for: Lcom/aio/downloader/activity/UnInstallActivity;->PRO_DIR_TO:Ljava/io/File;
    invoke-static {v0}, Lcom/aio/downloader/activity/UnInstallActivity;->access$1(Lcom/aio/downloader/activity/UnInstallActivity;)Ljava/io/File;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$4;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    # getter for: Lcom/aio/downloader/activity/UnInstallActivity;->PRO_DIR_FOME:Ljava/io/File;
    invoke-static {v1}, Lcom/aio/downloader/activity/UnInstallActivity;->access$2(Lcom/aio/downloader/activity/UnInstallActivity;)Ljava/io/File;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/Myutils;->copyfile(Ljava/io/File;Ljava/io/File;Ljava/lang/Boolean;)V

    .line 212
    const/4 v0, 0x0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/UnInstallActivity$4;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 1
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 218
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 219
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$4;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    # invokes: Lcom/aio/downloader/activity/UnInstallActivity;->installApk()V
    invoke-static {v0}, Lcom/aio/downloader/activity/UnInstallActivity;->access$3(Lcom/aio/downloader/activity/UnInstallActivity;)V

    .line 220
    return-void
.end method
