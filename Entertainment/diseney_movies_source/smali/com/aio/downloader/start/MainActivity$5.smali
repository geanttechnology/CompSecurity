.class Lcom/aio/downloader/start/MainActivity$5;
.super Landroid/os/AsyncTask;
.source "MainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/start/MainActivity;->onCreate(Landroid/os/Bundle;)V
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
.field final synthetic this$0:Lcom/aio/downloader/start/MainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/start/MainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/start/MainActivity$5;->this$0:Lcom/aio/downloader/start/MainActivity;

    .line 337
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/start/MainActivity$5;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 2
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 341
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity$5;->this$0:Lcom/aio/downloader/start/MainActivity;

    # getter for: Lcom/aio/downloader/start/MainActivity;->AIOFREEAPK:Ljava/io/File;
    invoke-static {v0}, Lcom/aio/downloader/start/MainActivity;->access$7(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 342
    const-string v0, "jone"

    const-string v1, "delete free"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 343
    const/4 v0, 0x0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/start/MainActivity$5;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 0
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 350
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 352
    return-void
.end method
