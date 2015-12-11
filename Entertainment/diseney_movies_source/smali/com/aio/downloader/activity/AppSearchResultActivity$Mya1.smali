.class Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;
.super Landroid/os/AsyncTask;
.source "AppSearchResultActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/AppSearchResultActivity;
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
.field final synthetic this$0:Lcom/aio/downloader/activity/AppSearchResultActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppSearchResultActivity;)V
    .locals 0

    .prologue
    .line 261
    iput-object p1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppSearchResultActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 4
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 272
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppSearchResultActivity;

    iget-object v3, p0, Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/AppSearchResultActivity;->searchkeywords:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/activity/AppSearchResultActivity;->access$8(Lcom/aio/downloader/activity/AppSearchResultActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/aio/downloader/activity/AppSearchResultActivity;->access$9(Lcom/aio/downloader/activity/AppSearchResultActivity;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 277
    :goto_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "http://android.downloadatoz.com/_201409/market/app_list_more.php?keyword="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 278
    iget-object v3, p0, Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/AppSearchResultActivity;->searchkeywords:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/activity/AppSearchResultActivity;->access$8(Lcom/aio/downloader/activity/AppSearchResultActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "&page="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/AppSearchResultActivity;->page:I
    invoke-static {v3}, Lcom/aio/downloader/activity/AppSearchResultActivity;->access$10(Lcom/aio/downloader/activity/AppSearchResultActivity;)I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 277
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 280
    .local v1, "url":Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 282
    .local v0, "jsonData":Ljava/lang/String;
    return-object v0

    .line 273
    .end local v0    # "jsonData":Ljava/lang/String;
    .end local v1    # "url":Ljava/lang/String;
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 1
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 287
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 289
    if-nez p1, :cond_0

    .line 299
    :goto_0
    return-void

    .line 293
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppSearchResultActivity;

    # invokes: Lcom/aio/downloader/activity/AppSearchResultActivity;->ShowResult(Ljava/lang/String;)V
    invoke-static {v0, p1}, Lcom/aio/downloader/activity/AppSearchResultActivity;->access$11(Lcom/aio/downloader/activity/AppSearchResultActivity;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 264
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 265
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/AppSearchResultActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->access$0(Lcom/aio/downloader/activity/AppSearchResultActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 267
    return-void
.end method
