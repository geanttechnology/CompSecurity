.class Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;
.super Landroid/os/AsyncTask;
.source "MyAppAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/unstall/MyAppAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Mya1"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/util/ArrayList",
        "<",
        "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/unstall/MyAppAdapter;


# direct methods
.method constructor <init>(Lcom/aio/downloader/unstall/MyAppAdapter;)V
    .locals 0

    .prologue
    .line 305
    iput-object p1, p0, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->doInBackground([Ljava/lang/Void;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/util/ArrayList;
    .locals 8
    .param p1, "params"    # [Ljava/lang/Void;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/Void;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 316
    iget-object v5, p0, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->url:Ljava/lang/String;
    invoke-static {v5}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$0(Lcom/aio/downloader/unstall/MyAppAdapter;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 317
    .local v1, "jsonData":Ljava/lang/String;
    const-string v5, "gak"

    new-instance v6, Ljava/lang/StringBuilder;

    iget-object v7, p0, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->url:Ljava/lang/String;
    invoke-static {v7}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$0(Lcom/aio/downloader/unstall/MyAppAdapter;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v7, "=====================jsonData="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 318
    if-nez v1, :cond_1

    .line 339
    :cond_0
    :goto_0
    return-object v4

    .line 322
    :cond_1
    iget-object v5, p0, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v5, v6}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$1(Lcom/aio/downloader/unstall/MyAppAdapter;Ljava/util/ArrayList;)V

    .line 324
    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 325
    .local v2, "object":Lorg/json/JSONObject;
    const-string v5, "status"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 326
    iget-object v4, p0, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    new-instance v5, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    invoke-static {v4, v5}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$2(Lcom/aio/downloader/unstall/MyAppAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 327
    const-string v4, "pdt"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 328
    .local v3, "object2":Lorg/json/JSONObject;
    iget-object v4, p0, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v4}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$3(Lcom/aio/downloader/unstall/MyAppAdapter;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v4

    const-string v5, "id"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setId(Ljava/lang/String;)V

    .line 329
    iget-object v4, p0, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v4}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$3(Lcom/aio/downloader/unstall/MyAppAdapter;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v4

    const-string v5, "serial"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 339
    .end local v2    # "object":Lorg/json/JSONObject;
    .end local v3    # "object2":Lorg/json/JSONObject;
    :goto_1
    iget-object v4, p0, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->list:Ljava/util/ArrayList;
    invoke-static {v4}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$4(Lcom/aio/downloader/unstall/MyAppAdapter;)Ljava/util/ArrayList;

    move-result-object v4

    goto :goto_0

    .line 335
    :catch_0
    move-exception v0

    .line 337
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/util/ArrayList;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->onPostExecute(Ljava/util/ArrayList;)V

    return-void
.end method

.method protected onPostExecute(Ljava/util/ArrayList;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 344
    .local p1, "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 345
    iget-object v2, p0, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$5(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/content/Context;

    move-result-object v2

    const-string v3, "share"

    invoke-static {v2, v3}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 346
    if-eqz p1, :cond_0

    .line 347
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Share: http://android.downloadatoz.com/apps/"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 349
    iget-object v3, p0, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v3}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$3(Lcom/aio/downloader/unstall/MyAppAdapter;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v3

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v3}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$3(Lcom/aio/downloader/unstall/MyAppAdapter;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v3

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".html"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 347
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 350
    .local v1, "share_t":Ljava/lang/String;
    const-string v2, "location"

    invoke-static {v2, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 351
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.SEND"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 352
    .local v0, "intent":Landroid/content/Intent;
    const-string v2, "text/plain"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 353
    const-string v2, "android.intent.extra.TEXT"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 354
    iget-object v2, p0, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$5(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/content/Context;

    move-result-object v2

    .line 355
    const-string v3, "AIO Downloaded"

    .line 354
    invoke-static {v0, v3}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v3

    .line 356
    const/high16 v4, 0x10000000

    .line 355
    invoke-virtual {v3, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    move-result-object v3

    .line 354
    invoke-virtual {v2, v3}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 370
    :goto_0
    return-void

    .line 359
    .end local v0    # "intent":Landroid/content/Intent;
    .end local v1    # "share_t":Ljava/lang/String;
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Share: http://android.downloadatoz.com/search.php?q="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 361
    iget-object v3, p0, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->myididididid:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$6(Lcom/aio/downloader/unstall/MyAppAdapter;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 359
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 362
    .restart local v1    # "share_t":Ljava/lang/String;
    const-string v2, "location"

    invoke-static {v2, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 363
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.SEND"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 364
    .restart local v0    # "intent":Landroid/content/Intent;
    const-string v2, "text/plain"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 365
    const-string v2, "android.intent.extra.TEXT"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 366
    iget-object v2, p0, Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;->this$0:Lcom/aio/downloader/unstall/MyAppAdapter;

    # getter for: Lcom/aio/downloader/unstall/MyAppAdapter;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/unstall/MyAppAdapter;->access$5(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/content/Context;

    move-result-object v2

    .line 367
    const-string v3, "AIO Downloaded"

    .line 366
    invoke-static {v0, v3}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 0

    .prologue
    .line 308
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 310
    return-void
.end method
