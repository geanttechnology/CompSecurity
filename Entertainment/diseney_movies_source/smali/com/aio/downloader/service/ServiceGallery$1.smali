.class Lcom/aio/downloader/service/ServiceGallery$1;
.super Landroid/os/Handler;
.source "ServiceGallery.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/service/ServiceGallery;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private icon0:Ljava/lang/String;

.field private icon1:Ljava/lang/String;

.field private icon2:Ljava/lang/String;

.field private icon3:Ljava/lang/String;

.field private icon4:Ljava/lang/String;

.field private icon5:Ljava/lang/String;

.field private icon6:Ljava/lang/String;

.field private icon7:Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/service/ServiceGallery;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceGallery;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceGallery$1;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    .line 84
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 98
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 99
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 110
    :goto_0
    return-void

    .line 101
    :pswitch_0
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceGallery$1;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    invoke-virtual {v0}, Lcom/aio/downloader/service/ServiceGallery;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 102
    const-string v1, "first_insall_cleaner"

    .line 101
    invoke-static {v0, v1}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 103
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceGallery$1;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    # getter for: Lcom/aio/downloader/service/ServiceGallery;->dialog:Lcom/aio/downloader/dialog/InstallfirstDialog;
    invoke-static {v0}, Lcom/aio/downloader/service/ServiceGallery;->access$0(Lcom/aio/downloader/service/ServiceGallery;)Lcom/aio/downloader/dialog/InstallfirstDialog;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/InstallfirstDialog;->show()V

    goto :goto_0

    .line 99
    :pswitch_data_0
    .packed-switch 0x1e
        :pswitch_0
    .end packed-switch
.end method
