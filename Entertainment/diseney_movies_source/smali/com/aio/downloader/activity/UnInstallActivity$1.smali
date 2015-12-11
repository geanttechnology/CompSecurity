.class Lcom/aio/downloader/activity/UnInstallActivity$1;
.super Landroid/os/Handler;
.source "UnInstallActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/UnInstallActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/UnInstallActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/UnInstallActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/UnInstallActivity$1;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    .line 46
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v3, 0x0

    .line 49
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 50
    iget v1, p1, Landroid/os/Message;->what:I

    packed-switch v1, :pswitch_data_0

    .line 76
    :goto_0
    return-void

    .line 52
    :pswitch_0
    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$1;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    .line 53
    const-string v2, "Failed to connect server."

    .line 52
    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 53
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 57
    :pswitch_1
    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$1;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    # invokes: Lcom/aio/downloader/activity/UnInstallActivity;->Mydialog()V
    invoke-static {v1}, Lcom/aio/downloader/activity/UnInstallActivity;->access$0(Lcom/aio/downloader/activity/UnInstallActivity;)V

    goto :goto_0

    .line 62
    :pswitch_2
    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$1;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    .line 63
    const-string v2, "\'AIO Cleaner\' is added to download queue."

    .line 62
    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 64
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 69
    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$1;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/UnInstallActivity;->finish()V

    .line 70
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$1;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    .line 71
    const-class v2, Lcom/aio/downloader/activity/DownloadAppManager;

    .line 70
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 72
    .local v0, "ti":Landroid/content/Intent;
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 73
    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$1;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/activity/UnInstallActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 50
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
