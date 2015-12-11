.class Lcom/aio/downloader/service/ScreenReceiver$1;
.super Landroid/os/Handler;
.source "ScreenReceiver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/service/ScreenReceiver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/service/ScreenReceiver;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ScreenReceiver;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ScreenReceiver$1;->this$0:Lcom/aio/downloader/service/ScreenReceiver;

    .line 45
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/ScreenReceiver$1;)Lcom/aio/downloader/service/ScreenReceiver;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/aio/downloader/service/ScreenReceiver$1;->this$0:Lcom/aio/downloader/service/ScreenReceiver;

    return-object v0
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 5
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 50
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 51
    new-instance v0, Lcom/aio/downloader/dialog/CleanerUPDialog;

    iget-object v3, p0, Lcom/aio/downloader/service/ScreenReceiver$1;->this$0:Lcom/aio/downloader/service/ScreenReceiver;

    # getter for: Lcom/aio/downloader/service/ScreenReceiver;->mContext:Landroid/content/Context;
    invoke-static {v3}, Lcom/aio/downloader/service/ScreenReceiver;->access$0(Lcom/aio/downloader/service/ScreenReceiver;)Landroid/content/Context;

    move-result-object v3

    .line 52
    const v4, 0x7f0c000e

    .line 51
    invoke-direct {v0, v3, v4}, Lcom/aio/downloader/dialog/CleanerUPDialog;-><init>(Landroid/content/Context;I)V

    .line 53
    .local v0, "dialog":Lcom/aio/downloader/dialog/CleanerUPDialog;
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/CleanerUPDialog;->setCanceledOnTouchOutside(Z)V

    .line 54
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/CleanerUPDialog;->getWindow()Landroid/view/Window;

    move-result-object v3

    .line 55
    const/16 v4, 0x7d3

    .line 54
    invoke-virtual {v3, v4}, Landroid/view/Window;->setType(I)V

    .line 56
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/CleanerUPDialog;->show()V

    .line 58
    const v3, 0x7f070141

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/CleanerUPDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 57
    check-cast v1, Landroid/widget/Button;

    .line 59
    .local v1, "networkcancel":Landroid/widget/Button;
    const v3, 0x7f070142

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/CleanerUPDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 60
    .local v2, "networkok":Landroid/widget/Button;
    new-instance v3, Lcom/aio/downloader/service/ScreenReceiver$1$1;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/service/ScreenReceiver$1$1;-><init>(Lcom/aio/downloader/service/ScreenReceiver$1;Lcom/aio/downloader/dialog/CleanerUPDialog;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 68
    new-instance v3, Lcom/aio/downloader/service/ScreenReceiver$1$2;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/service/ScreenReceiver$1$2;-><init>(Lcom/aio/downloader/service/ScreenReceiver$1;Lcom/aio/downloader/dialog/CleanerUPDialog;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 121
    return-void
.end method
