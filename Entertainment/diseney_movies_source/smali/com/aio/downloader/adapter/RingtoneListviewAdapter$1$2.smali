.class Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;
.super Landroid/os/AsyncTask;
.source "RingtoneListviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->onClick(Landroid/view/View;)V
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
.field private model:Lcom/aio/downloader/model/Model;

.field final synthetic this$1:Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;

.field private final synthetic val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;

    iput-object p2, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 255
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 8
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 277
    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "http://t.zedge.net/ringtone/"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 278
    iget-object v7, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/?page=1"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 277
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 279
    .local v4, "ringtonecontent":Ljava/lang/String;
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 280
    .local v2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v6, "content"

    invoke-virtual {v2, v6, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 282
    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "http://android.downloadatoz.com/_201409/market/ringtone_pdt_parser.php?content="

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 283
    iget-object v7, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 282
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 284
    .local v5, "ringtoneposturl":Ljava/lang/String;
    invoke-static {v5, v2}, Lcom/aio/downloader/utils/publicTools;->doHttpPost(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v1

    .line 288
    .local v1, "jsondata":Ljava/lang/String;
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 289
    .local v3, "object":Lorg/json/JSONObject;
    const-string v6, "status"

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v6

    const/4 v7, 0x1

    if-ne v6, v7, :cond_0

    .line 290
    new-instance v6, Lcom/aio/downloader/model/Model;

    invoke-direct {v6}, Lcom/aio/downloader/model/Model;-><init>()V

    iput-object v6, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->model:Lcom/aio/downloader/model/Model;

    .line 291
    iget-object v6, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->model:Lcom/aio/downloader/model/Model;

    .line 292
    const-string v7, "url"

    invoke-virtual {v3, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 291
    invoke-virtual {v6, v7}, Lcom/aio/downloader/model/Model;->setRingtoneurl(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 298
    .end local v3    # "object":Lorg/json/JSONObject;
    :cond_0
    :goto_0
    const/4 v6, 0x0

    return-object v6

    .line 294
    :catch_0
    move-exception v0

    .line 296
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 6
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 304
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 306
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;
    invoke-static {v2}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;)Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v3

    .line 307
    iget-object v4, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    .line 308
    iget-object v5, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->model:Lcom/aio/downloader/model/Model;

    invoke-virtual {v5}, Lcom/aio/downloader/model/Model;->getRingtoneurl()Ljava/lang/String;

    move-result-object v5

    .line 306
    invoke-virtual {v2, v3, v4, v5}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->MydownloadMp3AndRingtone(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 315
    :goto_0
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 316
    .local v1, "ti":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;
    invoke-static {v2}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;)Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    move-result-object v2

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ringtonetag:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->access$4(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "ringtonerecent"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 317
    const-string v2, "hiderecentringtone"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 323
    :cond_0
    :goto_1
    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;
    invoke-static {v2}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;)Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    move-result-object v2

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->access$1(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 331
    return-void

    .line 309
    .end local v1    # "ti":Landroid/content/Intent;
    :catch_0
    move-exception v0

    .line 311
    .local v0, "e":Ljava/lang/Exception;
    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;
    invoke-static {v2}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;)Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    move-result-object v2

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->access$1(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)Landroid/content/Context;

    move-result-object v2

    .line 312
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;
    invoke-static {v3}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;)Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    move-result-object v3

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v3}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->access$1(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0b0064

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 313
    const/4 v4, 0x1

    .line 310
    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 313
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 318
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "ti":Landroid/content/Intent;
    :cond_1
    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;
    invoke-static {v2}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;)Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    move-result-object v2

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ringtonetag:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->access$4(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "ringtonepopular"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 319
    const-string v2, "hidepopularringtone"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_1

    .line 320
    :cond_2
    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;
    invoke-static {v2}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;)Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    move-result-object v2

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ringtonetag:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->access$4(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "ringtonesearch"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 321
    const-string v2, "hidesearchringtone"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_1
.end method

.method protected onPreExecute()V
    .locals 3

    .prologue
    .line 260
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 263
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 264
    .local v0, "ti":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;
    invoke-static {v1}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;)Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    move-result-object v1

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ringtonetag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->access$4(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "ringtonerecent"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 265
    const-string v1, "showrecentringtone"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 271
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;
    invoke-static {v1}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;)Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    move-result-object v1

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->access$1(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 272
    return-void

    .line 266
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;
    invoke-static {v1}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;)Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    move-result-object v1

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ringtonetag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->access$4(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "ringtonepopular"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 267
    const-string v1, "showpopularringtone"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 268
    :cond_2
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1$2;->this$1:Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;
    invoke-static {v1}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;->access$0(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;)Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    move-result-object v1

    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ringtonetag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->access$4(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "ringtonesearch"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 269
    const-string v1, "showsearchringtone"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0
.end method
