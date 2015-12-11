.class Lcom/aio/downloader/activity/MyMainActivity$7$2;
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

.field private final synthetic val$ntPath:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity$7;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$7$2;->this$1:Lcom/aio/downloader/activity/MyMainActivity$7;

    iput-object p2, p0, Lcom/aio/downloader/activity/MyMainActivity$7$2;->val$ntPath:Ljava/lang/String;

    .line 493
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 495
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 507
    :goto_0
    return-void

    .line 497
    :pswitch_0
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$7$2;->this$1:Lcom/aio/downloader/activity/MyMainActivity$7;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$7;->access$0(Lcom/aio/downloader/activity/MyMainActivity$7;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v2

    iget-object v2, v2, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/UpdateDialogVerison2;->dismiss()V

    goto :goto_0

    .line 500
    :pswitch_1
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$7$2;->val$ntPath:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 501
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    .line 502
    const-string v2, "android.intent.action.VIEW"

    .line 501
    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 503
    .local v0, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$7$2;->this$1:Lcom/aio/downloader/activity/MyMainActivity$7;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$7;->access$0(Lcom/aio/downloader/activity/MyMainActivity$7;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v2

    iget-object v2, v2, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/UpdateDialogVerison2;->dismiss()V

    .line 504
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$7$2;->this$1:Lcom/aio/downloader/activity/MyMainActivity$7;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$7;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$7;->access$0(Lcom/aio/downloader/activity/MyMainActivity$7;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 495
    :pswitch_data_0
    .packed-switch 0x7f07015a
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
