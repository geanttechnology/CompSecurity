.class Lcom/aio/downloader/activity/UpdateActivity$1;
.super Landroid/os/Handler;
.source "UpdateActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/UpdateActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/UpdateActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/UpdateActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/UpdateActivity$1;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    .line 58
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 64
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 75
    :goto_0
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 76
    return-void

    .line 67
    :pswitch_0
    new-instance v0, Lcom/aio/downloader/activity/UpdateActivity$Mya6;

    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity$1;->this$0:Lcom/aio/downloader/activity/UpdateActivity;

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/UpdateActivity$Mya6;-><init>(Lcom/aio/downloader/activity/UpdateActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/UpdateActivity$Mya6;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 64
    nop

    :pswitch_data_0
    .packed-switch 0x3e9
        :pswitch_0
    .end packed-switch
.end method
