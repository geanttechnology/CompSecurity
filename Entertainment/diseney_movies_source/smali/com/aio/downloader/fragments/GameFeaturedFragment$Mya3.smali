.class Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya3;
.super Landroid/os/AsyncTask;
.source "GameFeaturedFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/GameFeaturedFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Mya3"
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
.field final synthetic this$0:Lcom/aio/downloader/fragments/GameFeaturedFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/GameFeaturedFragment;)V
    .locals 0

    .prologue
    .line 277
    iput-object p1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya3;->this$0:Lcom/aio/downloader/fragments/GameFeaturedFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya3;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 2
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 288
    const-string v1, "http://welaf.com/fun/list.php?tab=random&page=1"

    .line 289
    .local v1, "url":Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 290
    .local v0, "jsonData":Ljava/lang/String;
    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya3;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 1
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 295
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 296
    if-nez p1, :cond_0

    .line 305
    :goto_0
    return-void

    .line 301
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya3;->this$0:Lcom/aio/downloader/fragments/GameFeaturedFragment;

    # invokes: Lcom/aio/downloader/fragments/GameFeaturedFragment;->ShowResult1(Ljava/lang/String;)V
    invoke-static {v0, p1}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->access$3(Lcom/aio/downloader/fragments/GameFeaturedFragment;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 281
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 282
    iget-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya3;->this$0:Lcom/aio/downloader/fragments/GameFeaturedFragment;

    # getter for: Lcom/aio/downloader/fragments/GameFeaturedFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->access$0(Lcom/aio/downloader/fragments/GameFeaturedFragment;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 284
    return-void
.end method
