.class Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;
.super Landroid/os/AsyncTask;
.source "MinigameRecommendActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MinigameRecommendActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Minigamekeywords"
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
.field final synthetic this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MinigameRecommendActivity;)V
    .locals 0

    .prologue
    .line 122
    iput-object p1, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 3
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 131
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v1, v2}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$1(Lcom/aio/downloader/activity/MinigameRecommendActivity;Ljava/util/List;)V

    .line 133
    const-string v1, "http://android.downloadatoz.com/_201409/market/minigame_search_recommend_list.php"

    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 135
    .local v0, "data":Ljava/lang/String;
    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 5
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/16 v4, 0x8

    .line 140
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 141
    if-nez p1, :cond_0

    .line 161
    :goto_0
    return-void

    .line 145
    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    # getter for: Lcom/aio/downloader/activity/MinigameRecommendActivity;->list:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$2(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Ljava/util/List;

    move-result-object v0

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parseminikeywords(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 146
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    new-instance v1, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;

    iget-object v2, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    invoke-virtual {v2}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 147
    iget-object v3, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    # getter for: Lcom/aio/downloader/activity/MinigameRecommendActivity;->list:Ljava/util/List;
    invoke-static {v3}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$2(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Ljava/util/List;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    .line 146
    invoke-static {v0, v1}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$3(Lcom/aio/downloader/activity/MinigameRecommendActivity;Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;)V

    .line 148
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    # getter for: Lcom/aio/downloader/activity/MinigameRecommendActivity;->serchgridview:Landroid/widget/GridView;
    invoke-static {v0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$4(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Landroid/widget/GridView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    # getter for: Lcom/aio/downloader/activity/MinigameRecommendActivity;->adapter:Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;
    invoke-static {v1}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$5(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/GridView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 149
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    # getter for: Lcom/aio/downloader/activity/MinigameRecommendActivity;->adapter:Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;
    invoke-static {v0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$5(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->notifyDataSetChanged()V

    .line 150
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    # getter for: Lcom/aio/downloader/activity/MinigameRecommendActivity;->progressheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$6(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 158
    :goto_1
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    # getter for: Lcom/aio/downloader/activity/MinigameRecommendActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$7(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v1

    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    # getter for: Lcom/aio/downloader/activity/MinigameRecommendActivity;->list:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$2(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Ljava/util/List;

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/SearchkeywordModel;

    invoke-virtual {v0}, Lcom/aio/downloader/model/SearchkeywordModel;->getKeyword()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/aio/downloader/views/DeletableEditText;->setHint(Ljava/lang/CharSequence;)V

    .line 159
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    # getter for: Lcom/aio/downloader/activity/MinigameRecommendActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$0(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    goto :goto_0

    .line 155
    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 125
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 126
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->this$0:Lcom/aio/downloader/activity/MinigameRecommendActivity;

    # getter for: Lcom/aio/downloader/activity/MinigameRecommendActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->access$0(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 127
    return-void
.end method
