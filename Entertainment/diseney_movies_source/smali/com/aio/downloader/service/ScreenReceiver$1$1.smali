.class Lcom/aio/downloader/service/ScreenReceiver$1$1;
.super Ljava/lang/Object;
.source "ScreenReceiver.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ScreenReceiver$1;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/service/ScreenReceiver$1;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/CleanerUPDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ScreenReceiver$1;Lcom/aio/downloader/dialog/CleanerUPDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ScreenReceiver$1$1;->this$1:Lcom/aio/downloader/service/ScreenReceiver$1;

    iput-object p2, p0, Lcom/aio/downloader/service/ScreenReceiver$1$1;->val$dialog:Lcom/aio/downloader/dialog/CleanerUPDialog;

    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/aio/downloader/service/ScreenReceiver$1$1;->val$dialog:Lcom/aio/downloader/dialog/CleanerUPDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/CleanerUPDialog;->dismiss()V

    .line 66
    return-void
.end method
