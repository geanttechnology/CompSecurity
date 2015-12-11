.class Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$5;
.super Landroid/os/Handler;
.source "Mp3_Popular_Fragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->failfile()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private id:Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;

.field private type:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$5;->this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;

    .line 97
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$5;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$5;->type:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$5;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$5;->id:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 103
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "type"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$5;->type:Ljava/lang/String;

    .line 104
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "id"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$5;->id:Ljava/lang/String;

    .line 105
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 121
    :goto_0
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 122
    return-void

    .line 107
    :pswitch_0
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$5$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$5$1;-><init>(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$5;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 117
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    goto :goto_0

    .line 105
    nop

    :pswitch_data_0
    .packed-switch 0x4bc
        :pswitch_0
    .end packed-switch
.end method
