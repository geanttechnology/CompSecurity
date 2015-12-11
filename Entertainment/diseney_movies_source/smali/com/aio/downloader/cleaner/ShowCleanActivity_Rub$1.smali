.class Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$1;
.super Landroid/os/Handler;
.source "ShowCleanActivity_Rub.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$1;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    .line 59
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v3, 0x0

    .line 62
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 63
    iget v1, p1, Landroid/os/Message;->what:I

    packed-switch v1, :pswitch_data_0

    .line 89
    :goto_0
    return-void

    .line 65
    :pswitch_0
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$1;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    const-string v2, "Failed to connect server."

    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 69
    :pswitch_1
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$1;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    # invokes: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->Mydialog()V
    invoke-static {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$0(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V

    goto :goto_0

    .line 74
    :pswitch_2
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$1;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    .line 75
    const-string v2, "\'AIO Cleaner\' is added to download queue."

    .line 74
    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 76
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 81
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$1;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->finish()V

    .line 82
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$1;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    .line 83
    const-class v2, Lcom/aio/downloader/activity/DownloadAppManager;

    .line 82
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 84
    .local v0, "ti":Landroid/content/Intent;
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 85
    iget-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$1;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->startActivity(Landroid/content/Intent;)V

    .line 86
    sput-boolean v3, Lcom/aio/downloader/utils/publicTools;->cleanertag:Z

    goto :goto_0

    .line 63
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
