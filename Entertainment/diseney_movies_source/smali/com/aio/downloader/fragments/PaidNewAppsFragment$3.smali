.class Lcom/aio/downloader/fragments/PaidNewAppsFragment$3;
.super Landroid/os/Handler;
.source "PaidNewAppsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/PaidNewAppsFragment;->failfile()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private content:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private size:Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/fragments/PaidNewAppsFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/PaidNewAppsFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/PaidNewAppsFragment$3;->this$0:Lcom/aio/downloader/fragments/PaidNewAppsFragment;

    .line 67
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/PaidNewAppsFragment$3;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/aio/downloader/fragments/PaidNewAppsFragment$3;->id:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/fragments/PaidNewAppsFragment$3;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/aio/downloader/fragments/PaidNewAppsFragment$3;->size:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/fragments/PaidNewAppsFragment$3;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/aio/downloader/fragments/PaidNewAppsFragment$3;->content:Ljava/lang/String;

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

    const-string v1, "id"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/PaidNewAppsFragment$3;->id:Ljava/lang/String;

    .line 77
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "size"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/PaidNewAppsFragment$3;->size:Ljava/lang/String;

    .line 78
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "content"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/PaidNewAppsFragment$3;->content:Ljava/lang/String;

    .line 79
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 98
    :goto_0
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 99
    return-void

    .line 81
    :pswitch_0
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/aio/downloader/fragments/PaidNewAppsFragment$3$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/PaidNewAppsFragment$3$1;-><init>(Lcom/aio/downloader/fragments/PaidNewAppsFragment$3;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 94
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    goto :goto_0

    .line 79
    nop

    :pswitch_data_0
    .packed-switch 0x4bc
        :pswitch_0
    .end packed-switch
.end method
