.class Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;
.super Landroid/os/AsyncTask;
.source "AppRecommendKeywordsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "loadpromittv"
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
.field final synthetic this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V
    .locals 0

    .prologue
    .line 552
    iput-object p1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 3
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 564
    const/4 v0, 0x0

    .line 566
    .local v0, "tvjsondata":Ljava/lang/String;
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->isNetworkAvailable(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 568
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "https://market.android.com/suggest/SuggRequest?json=1&c=0&query="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 569
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$1(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v2

    .line 570
    invoke-interface {v2}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v2

    .line 569
    invoke-static {v2}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 570
    const-string v2, "&hl=en"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 568
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 575
    :goto_0
    return-object v1

    .line 573
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 4
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 581
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 583
    if-nez p1, :cond_0

    .line 593
    :goto_0
    return-void

    .line 586
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->list2:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$2(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 587
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->list2:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$2(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/List;

    move-result-object v0

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parsearchpromitlist(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 588
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    new-instance v1, Lcom/aio/downloader/adapter/AppsearchpromitAdapter;

    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-virtual {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 589
    iget-object v3, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->list2:Ljava/util/List;
    invoke-static {v3}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$2(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/List;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/aio/downloader/adapter/AppsearchpromitAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    .line 588
    invoke-static {v0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$3(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;Lcom/aio/downloader/adapter/AppsearchpromitAdapter;)V

    .line 590
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pomitlv:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$4(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/ListView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->adapterpromit:Lcom/aio/downloader/adapter/AppsearchpromitAdapter;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$5(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/adapter/AppsearchpromitAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 591
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->adapterpromit:Lcom/aio/downloader/adapter/AppsearchpromitAdapter;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$5(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/adapter/AppsearchpromitAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/AppsearchpromitAdapter;->notifyDataSetChanged()V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 0

    .prologue
    .line 555
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 557
    return-void
.end method
