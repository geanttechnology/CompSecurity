.class Lcom/aio/downloader/activity/AppDetailsActivity$Myagv1;
.super Landroid/os/AsyncTask;
.source "AppDetailsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/AppDetailsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Myagv1"
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
.field final synthetic this$0:Lcom/aio/downloader/activity/AppDetailsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V
    .locals 0

    .prologue
    .line 2159
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Myagv1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppDetailsActivity$Myagv1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 2
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 2168
    const-string v1, "http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=aio_ad_2"

    .line 2169
    .local v1, "url":Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 2170
    .local v0, "jsonData":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 2171
    const/4 v0, 0x0

    .line 2174
    .end local v0    # "jsonData":Ljava/lang/String;
    :cond_0
    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppDetailsActivity$Myagv1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 2179
    if-nez p1, :cond_0

    .line 2185
    :goto_0
    return-void

    .line 2182
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Myagv1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # invokes: Lcom/aio/downloader/activity/AppDetailsActivity;->ShowResult1(Ljava/lang/String;)V
    invoke-static {v0, p1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$65(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/lang/String;)V

    .line 2183
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Myagv1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->detaillinewyc1:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$66(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 2162
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 2163
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Myagv1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 2164
    return-void
.end method
