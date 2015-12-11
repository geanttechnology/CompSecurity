.class Lcom/aio/downloader/activity/MySettingsActivity$1$1;
.super Ljava/lang/Object;
.source "MySettingsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MySettingsActivity$1;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/MySettingsActivity$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MySettingsActivity$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MySettingsActivity$1$1;->this$1:Lcom/aio/downloader/activity/MySettingsActivity$1;

    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 65
    iget-object v2, p0, Lcom/aio/downloader/activity/MySettingsActivity$1$1;->this$1:Lcom/aio/downloader/activity/MySettingsActivity$1;

    # getter for: Lcom/aio/downloader/activity/MySettingsActivity$1;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;
    invoke-static {v2}, Lcom/aio/downloader/activity/MySettingsActivity$1;->access$0(Lcom/aio/downloader/activity/MySettingsActivity$1;)Lcom/aio/downloader/activity/MySettingsActivity;

    move-result-object v2

    # getter for: Lcom/aio/downloader/activity/MySettingsActivity;->updateDialog:Lcom/aio/downloader/dialog/UpdateDialogVerison;
    invoke-static {v2}, Lcom/aio/downloader/activity/MySettingsActivity;->access$2(Lcom/aio/downloader/activity/MySettingsActivity;)Lcom/aio/downloader/dialog/UpdateDialogVerison;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/UpdateDialogVerison;->dismiss()V

    .line 66
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 76
    :goto_0
    :pswitch_0
    return-void

    .line 70
    :pswitch_1
    iget-object v2, p0, Lcom/aio/downloader/activity/MySettingsActivity$1$1;->this$1:Lcom/aio/downloader/activity/MySettingsActivity$1;

    # getter for: Lcom/aio/downloader/activity/MySettingsActivity$1;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;
    invoke-static {v2}, Lcom/aio/downloader/activity/MySettingsActivity$1;->access$0(Lcom/aio/downloader/activity/MySettingsActivity$1;)Lcom/aio/downloader/activity/MySettingsActivity;

    move-result-object v2

    # getter for: Lcom/aio/downloader/activity/MySettingsActivity;->newVersionUrl:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/MySettingsActivity;->access$1(Lcom/aio/downloader/activity/MySettingsActivity;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 71
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 73
    .local v0, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/activity/MySettingsActivity$1$1;->this$1:Lcom/aio/downloader/activity/MySettingsActivity$1;

    # getter for: Lcom/aio/downloader/activity/MySettingsActivity$1;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;
    invoke-static {v2}, Lcom/aio/downloader/activity/MySettingsActivity$1;->access$0(Lcom/aio/downloader/activity/MySettingsActivity$1;)Lcom/aio/downloader/activity/MySettingsActivity;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/aio/downloader/activity/MySettingsActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 66
    :pswitch_data_0
    .packed-switch 0x7f070157
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
