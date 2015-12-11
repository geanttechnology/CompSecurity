.class Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;
.super Landroid/os/AsyncTask;
.source "Ringtone_Popular_Fragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
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
.field final synthetic this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

.field private final synthetic val$arg2:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

    iput p2, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->val$arg2:I

    .line 216
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;)Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

    return-object v0
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 12
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 230
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v0, "http://t.zedge.net/ringtone/"

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 231
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->access$0(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;)Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    move-result-object v0

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->list:Ljava/util/ArrayList;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$9(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;)Ljava/util/ArrayList;

    move-result-object v0

    iget v2, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->val$arg2:I

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/?page=1"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 230
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 232
    .local v10, "ringtonecontent":Ljava/lang/String;
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 233
    .local v8, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v0, "content"

    invoke-virtual {v8, v0, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 234
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v0, "http://android.downloadatoz.com/_201409/market/ringtone_pdt_parser.php?content="

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 235
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->access$0(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;)Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    move-result-object v0

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->list:Ljava/util/ArrayList;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$9(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;)Ljava/util/ArrayList;

    move-result-object v0

    iget v2, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->val$arg2:I

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 234
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    .line 236
    .local v11, "ringtoneposturl":Ljava/lang/String;
    invoke-static {v11, v8}, Lcom/aio/downloader/utils/publicTools;->doHttpPost(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v7

    .line 240
    .local v7, "jsondata":Ljava/lang/String;
    :try_start_0
    new-instance v9, Lorg/json/JSONObject;

    invoke-direct {v9, v7}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 241
    .local v9, "object":Lorg/json/JSONObject;
    const-string v0, "status"

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 242
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->access$0(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;)Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/model/Model;

    invoke-direct {v1}, Lcom/aio/downloader/model/Model;-><init>()V

    invoke-static {v0, v1}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$11(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;Lcom/aio/downloader/model/Model;)V

    .line 243
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->access$0(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;)Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    move-result-object v0

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->model:Lcom/aio/downloader/model/Model;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$12(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;)Lcom/aio/downloader/model/Model;

    move-result-object v0

    const-string v1, "url"

    invoke-virtual {v9, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/model/Model;->setRingtoneurl(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 265
    .end local v9    # "object":Lorg/json/JSONObject;
    :cond_0
    :goto_0
    :try_start_1
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->access$0(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;)Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    move-result-object v0

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$2(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->access$0(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;)Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    move-result-object v1

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->model:Lcom/aio/downloader/model/Model;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$12(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;)Lcom/aio/downloader/model/Model;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/model/Model;->getRingtoneurl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/Player;->playUrl(Ljava/lang/String;)V

    .line 266
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->access$0(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;)Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    move-result-object v0

    new-instance v1, Ljava/util/Timer;

    invoke-direct {v1}, Ljava/util/Timer;-><init>()V

    invoke-static {v0, v1}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$13(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;Ljava/util/Timer;)V

    .line 267
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->access$0(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;)Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1$1;-><init>(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;)V

    invoke-static {v0, v1}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$14(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;Ljava/util/TimerTask;)V

    .line 275
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->access$0(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;)Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    move-result-object v0

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->timer:Ljava/util/Timer;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$15(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;)Ljava/util/Timer;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->access$0(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;)Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    move-result-object v1

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->task:Ljava/util/TimerTask;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$16(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;)Ljava/util/TimerTask;

    move-result-object v1

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x3e8

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 280
    :goto_1
    const/4 v0, 0x0

    return-object v0

    .line 245
    :catch_0
    move-exception v6

    .line 246
    .local v6, "e":Lorg/json/JSONException;
    invoke-virtual {v6}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0

    .line 276
    .end local v6    # "e":Lorg/json/JSONException;
    :catch_1
    move-exception v0

    goto :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 285
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 287
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->access$0(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;)Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    move-result-object v0

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$0(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 288
    if-nez p1, :cond_0

    .line 292
    :cond_0
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 220
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 221
    iget-object v0, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->access$0(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;)Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    move-result-object v0

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->access$0(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 224
    return-void
.end method
