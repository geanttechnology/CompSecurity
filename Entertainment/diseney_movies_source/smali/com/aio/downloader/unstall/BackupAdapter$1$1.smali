.class Lcom/aio/downloader/unstall/BackupAdapter$1$1;
.super Landroid/os/AsyncTask;
.source "BackupAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/unstall/BackupAdapter$1;->onClick(Landroid/view/View;)V
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
.field final synthetic this$1:Lcom/aio/downloader/unstall/BackupAdapter$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/unstall/BackupAdapter$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/unstall/BackupAdapter$1$1;->this$1:Lcom/aio/downloader/unstall/BackupAdapter$1;

    .line 169
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/unstall/BackupAdapter$1$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 3
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 184
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupAdapter$1$1;->this$1:Lcom/aio/downloader/unstall/BackupAdapter$1;

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter$1;->apkFile:Ljava/io/File;
    invoke-static {v0}, Lcom/aio/downloader/unstall/BackupAdapter$1;->access$0(Lcom/aio/downloader/unstall/BackupAdapter$1;)Ljava/io/File;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/unstall/BackupAdapter$1$1;->this$1:Lcom/aio/downloader/unstall/BackupAdapter$1;

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter$1;->backupFile:Ljava/io/File;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupAdapter$1;->access$1(Lcom/aio/downloader/unstall/BackupAdapter$1;)Ljava/io/File;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/Myutils;->copyfile(Ljava/io/File;Ljava/io/File;Ljava/lang/Boolean;)V

    .line 185
    const/4 v0, 0x0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/unstall/BackupAdapter$1$1;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 4
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 192
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 193
    iget-object v1, p0, Lcom/aio/downloader/unstall/BackupAdapter$1$1;->this$1:Lcom/aio/downloader/unstall/BackupAdapter$1;

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter$1;->this$0:Lcom/aio/downloader/unstall/BackupAdapter;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupAdapter$1;->access$2(Lcom/aio/downloader/unstall/BackupAdapter$1;)Lcom/aio/downloader/unstall/BackupAdapter;

    move-result-object v1

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter;->pd:Landroid/app/ProgressDialog;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupAdapter;->access$3(Lcom/aio/downloader/unstall/BackupAdapter;)Landroid/app/ProgressDialog;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/ProgressDialog;->dismiss()V

    .line 194
    iget-object v1, p0, Lcom/aio/downloader/unstall/BackupAdapter$1$1;->this$1:Lcom/aio/downloader/unstall/BackupAdapter$1;

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter$1;->apkFile:Ljava/io/File;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupAdapter$1;->access$0(Lcom/aio/downloader/unstall/BackupAdapter$1;)Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 195
    iget-object v1, p0, Lcom/aio/downloader/unstall/BackupAdapter$1$1;->this$1:Lcom/aio/downloader/unstall/BackupAdapter$1;

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter$1;->this$0:Lcom/aio/downloader/unstall/BackupAdapter;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupAdapter$1;->access$2(Lcom/aio/downloader/unstall/BackupAdapter$1;)Lcom/aio/downloader/unstall/BackupAdapter;

    move-result-object v1

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter;->context:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupAdapter;->access$1(Lcom/aio/downloader/unstall/BackupAdapter;)Landroid/content/Context;

    move-result-object v1

    const-string v2, "Backup successfully"

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 197
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "backup"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 198
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/unstall/BackupAdapter$1$1;->this$1:Lcom/aio/downloader/unstall/BackupAdapter$1;

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter$1;->this$0:Lcom/aio/downloader/unstall/BackupAdapter;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupAdapter$1;->access$2(Lcom/aio/downloader/unstall/BackupAdapter$1;)Lcom/aio/downloader/unstall/BackupAdapter;

    move-result-object v1

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter;->context:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupAdapter;->access$1(Lcom/aio/downloader/unstall/BackupAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 199
    return-void
.end method

.method protected onPreExecute()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 176
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 177
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupAdapter$1$1;->this$1:Lcom/aio/downloader/unstall/BackupAdapter$1;

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter$1;->this$0:Lcom/aio/downloader/unstall/BackupAdapter;
    invoke-static {v0}, Lcom/aio/downloader/unstall/BackupAdapter$1;->access$2(Lcom/aio/downloader/unstall/BackupAdapter$1;)Lcom/aio/downloader/unstall/BackupAdapter;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/unstall/BackupAdapter$1$1;->this$1:Lcom/aio/downloader/unstall/BackupAdapter$1;

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter$1;->this$0:Lcom/aio/downloader/unstall/BackupAdapter;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupAdapter$1;->access$2(Lcom/aio/downloader/unstall/BackupAdapter$1;)Lcom/aio/downloader/unstall/BackupAdapter;

    move-result-object v1

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter;->context:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/unstall/BackupAdapter;->access$1(Lcom/aio/downloader/unstall/BackupAdapter;)Landroid/content/Context;

    move-result-object v1

    const-string v2, ""

    const-string v3, "Waitting for backup..."

    invoke-static {v1, v2, v3, v4}, Landroid/app/ProgressDialog;->show(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Landroid/app/ProgressDialog;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/unstall/BackupAdapter;->access$2(Lcom/aio/downloader/unstall/BackupAdapter;Landroid/app/ProgressDialog;)V

    .line 179
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupAdapter$1$1;->this$1:Lcom/aio/downloader/unstall/BackupAdapter$1;

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter$1;->this$0:Lcom/aio/downloader/unstall/BackupAdapter;
    invoke-static {v0}, Lcom/aio/downloader/unstall/BackupAdapter$1;->access$2(Lcom/aio/downloader/unstall/BackupAdapter$1;)Lcom/aio/downloader/unstall/BackupAdapter;

    move-result-object v0

    # getter for: Lcom/aio/downloader/unstall/BackupAdapter;->pd:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lcom/aio/downloader/unstall/BackupAdapter;->access$3(Lcom/aio/downloader/unstall/BackupAdapter;)Landroid/app/ProgressDialog;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/app/ProgressDialog;->setCancelable(Z)V

    .line 180
    return-void
.end method
