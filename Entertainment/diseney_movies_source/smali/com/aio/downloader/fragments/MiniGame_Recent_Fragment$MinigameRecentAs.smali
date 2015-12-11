.class Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;
.super Landroid/os/AsyncTask;
.source "MiniGame_Recent_Fragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MinigameRecentAs"
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
.field private myjson:Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;)V
    .locals 1

    .prologue
    .line 74
    iput-object p1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;->this$0:Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 76
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;->myjson:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 3
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 88
    :try_start_0
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "http://app.loveitsomuch.com/game/h5/game_list.php?ucode=abc&version=1.0&order_type=hot&page="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;->this$0:Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;

    # getter for: Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->page:I
    invoke-static {v2}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->access$1(Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 89
    .local v0, "data":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 90
    invoke-static {v0}, Lcom/aio/downloader/utils/ASCIIutil;->toparse(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;->myjson:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 99
    .end local v0    # "data":Ljava/lang/String;
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;->myjson:Ljava/lang/String;

    return-object v1

    .line 93
    .restart local v0    # "data":Ljava/lang/String;
    :cond_0
    const/4 v1, 0x0

    :try_start_1
    iput-object v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;->myjson:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 96
    .end local v0    # "data":Ljava/lang/String;
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 104
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 105
    if-nez p1, :cond_0

    .line 115
    :goto_0
    return-void

    .line 110
    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;->this$0:Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;

    # invokes: Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->ShowResult(Ljava/lang/String;)V
    invoke-static {v0, p1}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->access$2(Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 114
    :goto_1
    iget-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;->this$0:Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;

    # getter for: Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->access$0(Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    goto :goto_0

    .line 111
    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 81
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 82
    iget-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;->this$0:Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;

    # getter for: Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->access$0(Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 83
    return-void
.end method
