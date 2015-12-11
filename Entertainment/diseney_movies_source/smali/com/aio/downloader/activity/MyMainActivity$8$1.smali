.class Lcom/aio/downloader/activity/MyMainActivity$8$1;
.super Landroid/os/AsyncTask;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity$8;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/MyMainActivity$8;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity$8;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$8$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$8;

    .line 555
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$8$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 3
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 560
    const-wide/32 v1, 0x9c40

    :try_start_0
    invoke-static {v1, v2}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 565
    :goto_0
    const/4 v1, 0x0

    return-object v1

    .line 561
    :catch_0
    move-exception v0

    .line 563
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$8$1;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 5
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 571
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 572
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$8$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$8;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$8;->access$0(Lcom/aio/downloader/activity/MyMainActivity$8;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    .line 573
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$8$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$8;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$8;->access$0(Lcom/aio/downloader/activity/MyMainActivity$8;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v2

    const v3, 0x7f0c0010

    .line 574
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$8$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$8;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity$8;->access$0(Lcom/aio/downloader/activity/MyMainActivity$8;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v4

    iget-object v4, v4, Lcom/aio/downloader/activity/MyMainActivity;->itemsOnClick2:Landroid/view/View$OnClickListener;

    invoke-direct {v1, v2, v3, v4}, Lcom/aio/downloader/dialog/UpdateDialogVerison2;-><init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;)V

    .line 572
    iput-object v1, v0, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    .line 575
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$8$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$8;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$8;->access$0(Lcom/aio/downloader/activity/MyMainActivity$8;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    .line 576
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/dialog/UpdateDialogVerison2;->setCanceledOnTouchOutside(Z)V

    .line 577
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$8$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$8;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$8;->access$0(Lcom/aio/downloader/activity/MyMainActivity$8;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/UpdateDialogVerison2;->show()V

    .line 578
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$8$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$8;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$8;->access$0(Lcom/aio/downloader/activity/MyMainActivity$8;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$8$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$8;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyMainActivity$8;->access$0(Lcom/aio/downloader/activity/MyMainActivity$8;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v1

    iget-object v1, v1, Lcom/aio/downloader/activity/MyMainActivity;->info:Lcom/aio/downloader/model/GameInfosVersionModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/GameInfosVersionModel;->getNtTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/dialog/UpdateDialogVerison2;->setTvTitle(Ljava/lang/String;)V

    .line 579
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$8$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$8;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$8;->access$0(Lcom/aio/downloader/activity/MyMainActivity$8;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$8$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$8;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyMainActivity$8;->access$0(Lcom/aio/downloader/activity/MyMainActivity$8;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v1

    iget-object v1, v1, Lcom/aio/downloader/activity/MyMainActivity;->info:Lcom/aio/downloader/model/GameInfosVersionModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/GameInfosVersionModel;->getNtMsg()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/dialog/UpdateDialogVerison2;->setTvContent(Ljava/lang/String;)V

    .line 580
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$8$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$8;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$8;->access$0(Lcom/aio/downloader/activity/MyMainActivity$8;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$8$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$8;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$8;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyMainActivity$8;->access$0(Lcom/aio/downloader/activity/MyMainActivity$8;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v1

    iget-object v1, v1, Lcom/aio/downloader/activity/MyMainActivity;->info:Lcom/aio/downloader/model/GameInfosVersionModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/GameInfosVersionModel;->getPicPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/dialog/UpdateDialogVerison2;->setImgIcon(Ljava/lang/String;)V

    .line 581
    return-void
.end method
