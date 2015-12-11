.class Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;
.super Landroid/os/AsyncTask;
.source "Mp3ListviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->onClick(Landroid/view/View;)V
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
.field final synthetic this$1:Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

.field private final synthetic val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

    iput-object p2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 261
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 6
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 285
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "http://mp3box.to/user/download/?song="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 286
    .local v2, "mp3content":Ljava/lang/String;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 287
    .local v1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v4, "content"

    invoke-virtual {v1, v4, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 289
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "http://android.downloadatoz.com/_201409/market/mp3_pdt_parser.php?id="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 290
    .local v3, "mp3posturl":Ljava/lang/String;
    invoke-static {v3, v1}, Lcom/aio/downloader/utils/publicTools;->doHttpPost(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    .line 293
    .local v0, "jsondata":Ljava/lang/String;
    iget-object v4, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    invoke-static {v4}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    move-result-object v4

    invoke-virtual {v4, v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->getmp3json(Ljava/lang/String;)V

    .line 295
    const/4 v4, 0x0

    return-object v4
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 6
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 301
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 303
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    invoke-static {v5}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    move-result-object v5

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->model:Lcom/aio/downloader/model/Model;
    invoke-static {v5}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$6(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Lcom/aio/downloader/model/Model;

    move-result-object v5

    invoke-virtual {v5}, Lcom/aio/downloader/model/Model;->getMp3url()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v3, v4, v5}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->MydownloadMp3(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 308
    :goto_0
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 309
    .local v1, "ti":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    move-result-object v2

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->mp3tag:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$5(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "mp3recent"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 310
    const-string v2, "hiderecentmp3"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 318
    :cond_0
    :goto_1
    iget-object v2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    move-result-object v2

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$2(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 324
    return-void

    .line 305
    .end local v1    # "ti":Landroid/content/Intent;
    :catch_0
    move-exception v0

    .line 306
    .local v0, "e":Ljava/lang/Exception;
    iget-object v2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    move-result-object v2

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$2(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    move-result-object v3

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$2(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0b0064

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 311
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "ti":Landroid/content/Intent;
    :cond_1
    iget-object v2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    move-result-object v2

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->mp3tag:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$5(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "mp3popular"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 312
    const-string v2, "hidepopularmp3"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_1

    .line 313
    :cond_2
    iget-object v2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    move-result-object v2

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->mp3tag:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$5(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "mp3search"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 314
    const-string v2, "hidesearchmp3"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_1
.end method

.method protected onPreExecute()V
    .locals 3

    .prologue
    .line 267
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 270
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 271
    .local v0, "ti":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    move-result-object v1

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->mp3tag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$5(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "mp3recent"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 272
    const-string v1, "showrecentmp3"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 280
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    move-result-object v1

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$2(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 281
    return-void

    .line 273
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    move-result-object v1

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->mp3tag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$5(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "mp3popular"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 274
    const-string v1, "showpopularmp3"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 275
    :cond_2
    iget-object v1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    move-result-object v1

    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->mp3tag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->access$5(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "mp3search"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 276
    const-string v1, "showsearchmp3"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0
.end method
