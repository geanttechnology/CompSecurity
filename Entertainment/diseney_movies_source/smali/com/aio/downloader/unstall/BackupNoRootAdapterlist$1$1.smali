.class Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;
.super Landroid/os/AsyncTask;
.source "BackupNoRootAdapterlist.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->onClick(Landroid/view/View;)V
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
.field final synthetic this$1:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;->this$1:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;

    .line 185
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;)Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;
    .locals 1

    .prologue
    .line 185
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;->this$1:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;

    return-object v0
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 1
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 199
    const/4 v0, 0x0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 4
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 206
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 207
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1$1;-><init>(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;)V

    .line 216
    const-wide/16 v2, 0x9c4

    .line 207
    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 218
    return-void
.end method

.method protected onPreExecute()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 190
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 191
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;->this$1:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;
    invoke-static {v0}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->access$0(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;)Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;->this$1:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->access$0(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;)Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    move-result-object v1

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->context:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->access$1(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Landroid/content/Context;

    move-result-object v1

    const-string v2, ""

    .line 192
    const-string v3, "Waiting for backup..."

    .line 191
    invoke-static {v1, v2, v3, v4}, Landroid/app/ProgressDialog;->show(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Landroid/app/ProgressDialog;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->access$5(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;Landroid/app/ProgressDialog;)V

    .line 193
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;->this$1:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;
    invoke-static {v0}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->access$0(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;)Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    move-result-object v0

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->pd:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->access$6(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Landroid/app/ProgressDialog;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/app/ProgressDialog;->setCancelable(Z)V

    .line 194
    return-void
.end method
