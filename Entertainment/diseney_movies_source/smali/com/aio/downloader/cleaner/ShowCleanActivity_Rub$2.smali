.class Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$2;
.super Landroid/os/Handler;
.source "ShowCleanActivity_Rub.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$2;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    .line 106
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 109
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 110
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$2;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->relaquan:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$1(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 111
    return-void
.end method
