.class Lcom/aio/downloader/activity/MyMainActivity$7$1;
.super Ljava/lang/Object;
.source "MyMainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity$7;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/MyMainActivity$7;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity$7;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$7$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$7;

    .line 438
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 441
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 456
    :goto_0
    return-void

    .line 443
    :pswitch_0
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$7$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$7;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$7;->access$0(Lcom/aio/downloader/activity/MyMainActivity$7;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v2

    iget-object v2, v2, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion:Lcom/aio/downloader/dialog/UpdateDialogVerison;

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/UpdateDialogVerison;->dismiss()V

    goto :goto_0

    .line 448
    :pswitch_1
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$7$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$7;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$7;->access$0(Lcom/aio/downloader/activity/MyMainActivity$7;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v2

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->newVersionUrl:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity;->access$1(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 449
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 452
    .local v0, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$7$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$7;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$7;->access$0(Lcom/aio/downloader/activity/MyMainActivity$7;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v2

    iget-object v2, v2, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion:Lcom/aio/downloader/dialog/UpdateDialogVerison;

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/UpdateDialogVerison;->dismiss()V

    .line 453
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$7$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$7;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$7;->access$0(Lcom/aio/downloader/activity/MyMainActivity$7;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 441
    :pswitch_data_0
    .packed-switch 0x7f070157
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
