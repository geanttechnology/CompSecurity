.class Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1$1;
.super Ljava/lang/Object;
.source "BackupNoRootAdapterlist.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;->onPostExecute(Ljava/lang/Void;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1$1;->this$2:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;

    .line 207
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 212
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1$1;->this$2:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;->this$1:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;
    invoke-static {v0}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;->access$2(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;)Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;

    move-result-object v0

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;
    invoke-static {v0}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->access$0(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;)Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    move-result-object v0

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->pd:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->access$6(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Landroid/app/ProgressDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 213
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1$1;->this$2:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;->this$1:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;
    invoke-static {v0}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;->access$2(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1$1;)Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;

    move-result-object v0

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->this$0:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;
    invoke-static {v0}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;->access$0(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;)Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    move-result-object v0

    # getter for: Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->context:Landroid/content/Context;
    invoke-static {v0}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->access$1(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Landroid/content/Context;

    move-result-object v0

    const-string v1, "Backup successfully"

    .line 214
    const/4 v2, 0x0

    .line 213
    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 214
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 215
    return-void
.end method
