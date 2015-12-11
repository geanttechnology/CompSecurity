.class Lcom/aio/downloader/fragments/RingtoneSearchFragment$6;
.super Landroid/os/Handler;
.source "RingtoneSearchFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/RingtoneSearchFragment;->failfile()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private id:Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

.field private type:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$6;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    .line 70
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/RingtoneSearchFragment$6;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$6;->type:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/fragments/RingtoneSearchFragment$6;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$6;->id:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 76
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "type"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$6;->type:Ljava/lang/String;

    .line 77
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "id"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$6;->id:Ljava/lang/String;

    .line 78
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 94
    :goto_0
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 95
    return-void

    .line 80
    :pswitch_0
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/aio/downloader/fragments/RingtoneSearchFragment$6$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$6$1;-><init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment$6;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 90
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    goto :goto_0

    .line 78
    nop

    :pswitch_data_0
    .packed-switch 0x4bc
        :pswitch_0
    .end packed-switch
.end method
