.class Lcom/aio/downloader/activity/MyMainActivity$1;
.super Landroid/os/Handler;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyMainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 231
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 237
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 248
    :goto_0
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 249
    return-void

    .line 240
    :pswitch_0
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$Mya6;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$Mya6;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$Mya6;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 237
    nop

    :pswitch_data_0
    .packed-switch 0x3e9
        :pswitch_0
    .end packed-switch
.end method
