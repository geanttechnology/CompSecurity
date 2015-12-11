.class Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;
.super Landroid/os/AsyncTask;
.source "AppRecommendKeywordsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "loadingSearchKeywords"
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
    .line 597
    iput-object p1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 3
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 606
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v1, v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$6(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;Ljava/util/List;)V

    .line 607
    const/4 v0, 0x0

    .line 609
    .local v0, "jsondata":Ljava/lang/String;
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->isNetworkAvailable(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 611
    const-string v1, "http://android.downloadatoz.com/_201409/market/top_keywords.php"

    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 617
    :goto_0
    return-object v1

    .line 614
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 4
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 624
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 625
    if-nez p1, :cond_1

    .line 647
    :cond_0
    :goto_0
    return-void

    .line 629
    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->list:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$7(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/List;

    move-result-object v0

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parseSearchKeywords(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 630
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    new-instance v1, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;

    .line 631
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-virtual {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->list:Ljava/util/List;
    invoke-static {v3}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$7(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/List;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    .line 630
    invoke-static {v0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$8(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;)V

    .line 632
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->serchgridview:Landroid/widget/GridView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$9(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/GridView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->adapter:Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$10(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/GridView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 633
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->adapter:Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$10(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->notifyDataSetChanged()V

    .line 634
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->progressheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$0(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 635
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->myjpush:I
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$11(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)I

    move-result v0

    if-nez v0, :cond_0

    .line 636
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$1(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v1

    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->list:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$7(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/List;

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/SearchkeywordModel;

    invoke-virtual {v0}, Lcom/aio/downloader/model/SearchkeywordModel;->getKeyword()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/aio/downloader/views/DeletableEditText;->setHint(Ljava/lang/CharSequence;)V

    .line 637
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pomitlv:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$4(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/ListView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setVisibility(I)V

    .line 638
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->serchgridview:Landroid/widget/GridView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$9(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/GridView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/GridView;->setVisibility(I)V

    .line 639
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->ll_serch_refresh:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$12(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 640
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->list:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$7(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/SearchkeywordModel;

    invoke-virtual {v0}, Lcom/aio/downloader/model/SearchkeywordModel;->getKeyword()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/utils/Myutils;->hint:Ljava/lang/String;

    .line 641
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->list:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$7(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/SearchkeywordModel;

    invoke-virtual {v0}, Lcom/aio/downloader/model/SearchkeywordModel;->getId()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/utils/Myutils;->hintid:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 644
    :catch_0
    move-exception v0

    goto/16 :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 600
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 601
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->progressheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$0(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 602
    return-void
.end method
