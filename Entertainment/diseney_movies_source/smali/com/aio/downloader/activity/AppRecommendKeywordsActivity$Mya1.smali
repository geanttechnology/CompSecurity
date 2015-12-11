.class Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;
.super Landroid/os/AsyncTask;
.source "AppRecommendKeywordsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;
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
.field private jsonData:Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V
    .locals 0

    .prologue
    .line 719
    iput-object p1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 3
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 739
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->appkeywords:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$14(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$15(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;Ljava/lang/String;)V

    .line 740
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "http://android.downloadatoz.com/_201409/market/app_list_more.php?keyword="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 741
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->appkeywords:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$14(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&page="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->page:I
    invoke-static {v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$16(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 740
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 743
    .local v0, "url":Ljava/lang/String;
    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->jsonData:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 748
    .end local v0    # "url":Ljava/lang/String;
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->jsonData:Ljava/lang/String;

    return-object v1

    .line 744
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 753
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 755
    if-nez p1, :cond_0

    .line 768
    :goto_0
    return-void

    .line 759
    :cond_0
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # invokes: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->ShowResult(Ljava/lang/String;)V
    invoke-static {v1, p1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$17(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;Ljava/lang/String;)V

    .line 760
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$18(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/refresh/PullableListView_load;

    move-result-object v1

    .line 761
    const v2, 0x7f0701db

    invoke-virtual {v1, v2}, Lcom/aio/downloader/refresh/PullableListView_load;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 760
    check-cast v0, Landroid/widget/RelativeLayout;

    .line 762
    .local v0, "re":Landroid/widget/RelativeLayout;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 763
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$18(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/refresh/PullableListView_load;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/aio/downloader/refresh/PullableListView_load;->setVisibility(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 764
    .end local v0    # "re":Landroid/widget/RelativeLayout;
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/16 v1, 0x8

    .line 724
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 726
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pomitlv:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$4(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/ListView;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setVisibility(I)V

    .line 727
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->serchgridview:Landroid/widget/GridView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$9(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/GridView;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/GridView;->setVisibility(I)V

    .line 728
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->ll_serch_refresh:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$12(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 729
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pulltoresult:Lcom/aio/downloader/refresh/PullToRefreshLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$13(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/refresh/PullToRefreshLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->setVisibility(I)V

    .line 731
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    # getter for: Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->progressheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->access$0(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 733
    return-void
.end method
