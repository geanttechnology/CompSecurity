.class Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;
.super Landroid/os/AsyncTask;
.source "RingtoneSearchFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/RingtoneSearchFragment;
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
.field final synthetic this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)V
    .locals 0

    .prologue
    .line 354
    iput-object p1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 7
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 369
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "http://54.241.35.253/testamz2/?p=ringtones-7-0-"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 370
    iget-object v6, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    # getter for: Lcom/aio/downloader/fragments/RingtoneSearchFragment;->page:I
    invoke-static {v6}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->access$7(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "&search="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v6, Lcom/aio/downloader/utils/Myutils;->searchkeywords:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 371
    const-string v6, "&sec=4"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 369
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 372
    .local v4, "url":Ljava/lang/String;
    invoke-static {v4}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 374
    .local v0, "content":Ljava/lang/String;
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 375
    .local v2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v5, "content"

    invoke-virtual {v2, v5, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 377
    const-string v3, "http://android.downloadatoz.com/_201409/market/ringtone_list_more_parser.php?"

    .line 379
    .local v3, "ringtonesearchposturl":Ljava/lang/String;
    invoke-static {v3, v2}, Lcom/aio/downloader/utils/publicTools;->doHttpPost(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v1

    .line 381
    .local v1, "jsondata":Ljava/lang/String;
    return-object v1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 4
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 386
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 387
    if-nez p1, :cond_0

    .line 401
    :goto_0
    return-void

    .line 391
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    # invokes: Lcom/aio/downloader/fragments/RingtoneSearchFragment;->ShowResult(Ljava/lang/String;)V
    invoke-static {v1, p1}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->access$8(Lcom/aio/downloader/fragments/RingtoneSearchFragment;Ljava/lang/String;)V

    .line 398
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    # getter for: Lcom/aio/downloader/fragments/RingtoneSearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;
    invoke-static {v1}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->access$6(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Lcom/aio/downloader/refresh/PullableListView;

    move-result-object v1

    const v2, 0x7f0701db

    invoke-virtual {v1, v2}, Lcom/aio/downloader/refresh/PullableListView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 399
    .local v0, "re":Landroid/widget/RelativeLayout;
    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 400
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    # getter for: Lcom/aio/downloader/fragments/RingtoneSearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;
    invoke-static {v1}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->access$6(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Lcom/aio/downloader/refresh/PullableListView;

    move-result-object v1

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView;->setVisibility(I)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 358
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 359
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    # getter for: Lcom/aio/downloader/fragments/RingtoneSearchFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->access$0(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 361
    return-void
.end method
