.class Lcom/aio/downloader/activity/AnzhuangActivity$1;
.super Landroid/os/Handler;
.source "AnzhuangActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/AnzhuangActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AnzhuangActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AnzhuangActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AnzhuangActivity$1;->this$0:Lcom/aio/downloader/activity/AnzhuangActivity;

    .line 48
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v3, 0x0

    .line 51
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 52
    iget v1, p1, Landroid/os/Message;->what:I

    packed-switch v1, :pswitch_data_0

    .line 78
    :goto_0
    return-void

    .line 54
    :pswitch_0
    iget-object v1, p0, Lcom/aio/downloader/activity/AnzhuangActivity$1;->this$0:Lcom/aio/downloader/activity/AnzhuangActivity;

    .line 55
    const-string v2, "Failed to connect server."

    .line 54
    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 55
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 59
    :pswitch_1
    iget-object v1, p0, Lcom/aio/downloader/activity/AnzhuangActivity$1;->this$0:Lcom/aio/downloader/activity/AnzhuangActivity;

    # invokes: Lcom/aio/downloader/activity/AnzhuangActivity;->Mydialog()V
    invoke-static {v1}, Lcom/aio/downloader/activity/AnzhuangActivity;->access$0(Lcom/aio/downloader/activity/AnzhuangActivity;)V

    goto :goto_0

    .line 64
    :pswitch_2
    iget-object v1, p0, Lcom/aio/downloader/activity/AnzhuangActivity$1;->this$0:Lcom/aio/downloader/activity/AnzhuangActivity;

    .line 65
    const-string v2, "\'AIO Cleaner\' is added to download queue."

    .line 64
    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 66
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 71
    iget-object v1, p0, Lcom/aio/downloader/activity/AnzhuangActivity$1;->this$0:Lcom/aio/downloader/activity/AnzhuangActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/AnzhuangActivity;->finish()V

    .line 72
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/activity/AnzhuangActivity$1;->this$0:Lcom/aio/downloader/activity/AnzhuangActivity;

    .line 73
    const-class v2, Lcom/aio/downloader/activity/DownloadAppManager;

    .line 72
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 74
    .local v0, "ti":Landroid/content/Intent;
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 75
    iget-object v1, p0, Lcom/aio/downloader/activity/AnzhuangActivity$1;->this$0:Lcom/aio/downloader/activity/AnzhuangActivity;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/activity/AnzhuangActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 52
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
