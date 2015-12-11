.class Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;
.super Landroid/os/AsyncTask;
.source "MinigamesSearchResultActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MinigamesSearchResultActivity;
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
.field final synthetic this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)V
    .locals 0

    .prologue
    .line 176
    iput-object p1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 5
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 185
    iget-object v3, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    iget-object v4, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->searchkeywords:Ljava/lang/String;
    invoke-static {v4}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->access$1(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->access$2(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;Ljava/lang/String;)V

    .line 187
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "http://app.loveitsomuch.com/game/h5/search.php?ucode=abc&version=1.0&keyword="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 188
    iget-object v4, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->searchkeywords:Ljava/lang/String;
    invoke-static {v4}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->access$1(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "&page="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->page:I
    invoke-static {v4}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->access$3(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 187
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 190
    .local v2, "url":Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 191
    .local v0, "jsonData":Ljava/lang/String;
    invoke-static {v0}, Lcom/aio/downloader/utils/ASCIIutil;->toparse(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 192
    .local v1, "myjson":Ljava/lang/String;
    return-object v1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 4
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 197
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 199
    if-nez p1, :cond_0

    .line 208
    :goto_0
    return-void

    .line 203
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    # invokes: Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->ShowResult(Ljava/lang/String;)V
    invoke-static {v1, p1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->access$4(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;Ljava/lang/String;)V

    .line 205
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;
    invoke-static {v1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->access$5(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Lcom/aio/downloader/refresh/PullableListView;

    move-result-object v1

    const v2, 0x7f0701db

    invoke-virtual {v1, v2}, Lcom/aio/downloader/refresh/PullableListView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 206
    .local v0, "re":Landroid/widget/RelativeLayout;
    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 207
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;
    invoke-static {v1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->access$5(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Lcom/aio/downloader/refresh/PullableListView;

    move-result-object v1

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView;->setVisibility(I)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 179
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 180
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->access$0(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 181
    return-void
.end method
