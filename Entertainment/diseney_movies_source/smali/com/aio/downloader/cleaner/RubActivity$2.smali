.class Lcom/aio/downloader/cleaner/RubActivity$2;
.super Landroid/os/Handler;
.source "RubActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/RubActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/RubActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/RubActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$2;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    .line 346
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v3, 0x0

    .line 349
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 350
    iget v1, p1, Landroid/os/Message;->what:I

    packed-switch v1, :pswitch_data_0

    .line 376
    :goto_0
    return-void

    .line 352
    :pswitch_0
    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$2;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    const-string v2, "Failed to connect server."

    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 353
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 357
    :pswitch_1
    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$2;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # invokes: Lcom/aio/downloader/cleaner/RubActivity;->Mydialog()V
    invoke-static {v1}, Lcom/aio/downloader/cleaner/RubActivity;->access$16(Lcom/aio/downloader/cleaner/RubActivity;)V

    goto :goto_0

    .line 362
    :pswitch_2
    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$2;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    .line 363
    const-string v2, "\'AIO Cleaner\' is added to download queue."

    .line 362
    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 364
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 366
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$2;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    .line 367
    const-class v2, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 366
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 368
    .local v0, "ti":Landroid/content/Intent;
    const-string v1, "myid"

    const-string v2, "com.evzapp.cleanmaster"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 369
    const-string v1, "widgetdetailfan"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 370
    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$2;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/cleaner/RubActivity;->startActivity(Landroid/content/Intent;)V

    .line 371
    sput-boolean v3, Lcom/aio/downloader/utils/publicTools;->cleanertag:Z

    .line 372
    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$2;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/RubActivity;->finish()V

    goto :goto_0

    .line 350
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
