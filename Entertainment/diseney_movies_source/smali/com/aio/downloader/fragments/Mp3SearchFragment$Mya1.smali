.class Lcom/aio/downloader/fragments/Mp3SearchFragment$Mya1;
.super Landroid/os/AsyncTask;
.source "Mp3SearchFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/Mp3SearchFragment;
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
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/Mp3SearchFragment;)V
    .locals 0

    .prologue
    .line 345
    iput-object p1, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/Mp3SearchFragment$Mya1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 7
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 359
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "http://mp3box.to/search?q="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 360
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v6, Lcom/aio/downloader/utils/Myutils;->searchkeywords:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "&page="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3SearchFragment;->page:I
    invoke-static {v6}, Lcom/aio/downloader/fragments/Mp3SearchFragment;->access$7(Lcom/aio/downloader/fragments/Mp3SearchFragment;)I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 359
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 361
    .local v4, "url":Ljava/lang/String;
    invoke-static {v4}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 364
    .local v0, "content":Ljava/lang/String;
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 365
    .local v2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v5, "content"

    invoke-virtual {v2, v5, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 367
    const-string v3, "http://android.downloadatoz.com/_201409/market/mp3_list_more_parser.php"

    .line 369
    .local v3, "mp3searchposturl":Ljava/lang/String;
    invoke-static {v3, v2}, Lcom/aio/downloader/utils/publicTools;->doHttpPost(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v1

    .line 372
    .local v1, "jsondata":Ljava/lang/String;
    return-object v1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/Mp3SearchFragment$Mya1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 4
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 377
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 378
    if-nez p1, :cond_0

    .line 393
    :goto_0
    return-void

    .line 382
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    # invokes: Lcom/aio/downloader/fragments/Mp3SearchFragment;->ShowResult(Ljava/lang/String;)V
    invoke-static {v1, p1}, Lcom/aio/downloader/fragments/Mp3SearchFragment;->access$8(Lcom/aio/downloader/fragments/Mp3SearchFragment;Ljava/lang/String;)V

    .line 389
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3SearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Mp3SearchFragment;->access$6(Lcom/aio/downloader/fragments/Mp3SearchFragment;)Lcom/aio/downloader/refresh/PullableListView;

    move-result-object v1

    const v2, 0x7f0701db

    invoke-virtual {v1, v2}, Lcom/aio/downloader/refresh/PullableListView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 390
    .local v0, "re":Landroid/widget/RelativeLayout;
    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 391
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3SearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Mp3SearchFragment;->access$6(Lcom/aio/downloader/fragments/Mp3SearchFragment;)Lcom/aio/downloader/refresh/PullableListView;

    move-result-object v1

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView;->setVisibility(I)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 349
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 350
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3SearchFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/Mp3SearchFragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3SearchFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Mp3SearchFragment;->access$0(Lcom/aio/downloader/fragments/Mp3SearchFragment;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 352
    return-void
.end method
