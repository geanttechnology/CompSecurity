.class Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1$1;
.super Ljava/util/TimerTask;
.source "Ringtone_Popular_Fragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1$1;->this$2:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;

    .line 267
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 270
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 271
    .local v0, "msg":Landroid/os/Message;
    const/16 v1, 0x1f4

    iput v1, v0, Landroid/os/Message;->what:I

    .line 272
    iget-object v1, p0, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1$1;->this$2:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->this$1:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;->access$2(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6$1;)Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;

    move-result-object v1

    # getter for: Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;->access$0(Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment$6;)Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;

    move-result-object v1

    iget-object v1, v1, Lcom/aio/downloader/fragments/Ringtone_Popular_Fragment;->handler:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 273
    return-void
.end method
