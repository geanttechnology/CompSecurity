.class Lcom/aio/downloader/service/MyService$1;
.super Landroid/os/AsyncTask;
.source "MyService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/MyService;->onStartCommand(Landroid/content/Intent;II)I
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
.field final synthetic this$0:Lcom/aio/downloader/service/MyService;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/MyService;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/MyService$1;->this$0:Lcom/aio/downloader/service/MyService;

    .line 71
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/service/MyService$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 3
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 76
    const-wide/32 v1, 0x1499700

    :try_start_0
    invoke-static {v1, v2}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 82
    :goto_0
    const/4 v1, 0x0

    return-object v1

    .line 78
    :catch_0
    move-exception v0

    .line 80
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/service/MyService$1;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 1
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 88
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 89
    iget-object v0, p0, Lcom/aio/downloader/service/MyService$1;->this$0:Lcom/aio/downloader/service/MyService;

    # getter for: Lcom/aio/downloader/service/MyService;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v0}, Lcom/aio/downloader/service/MyService;->access$0(Lcom/aio/downloader/service/MyService;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile2()Ljava/util/List;

    .line 91
    return-void
.end method
