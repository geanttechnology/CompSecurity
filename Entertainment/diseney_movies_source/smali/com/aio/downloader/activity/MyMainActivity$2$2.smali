.class Lcom/aio/downloader/activity/MyMainActivity$2$2;
.super Ljava/lang/Object;
.source "MyMainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity$2;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/MyMainActivity$2;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/NoupdareversionDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity$2;Lcom/aio/downloader/dialog/NoupdareversionDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$2$2;->this$1:Lcom/aio/downloader/activity/MyMainActivity$2;

    iput-object p2, p0, Lcom/aio/downloader/activity/MyMainActivity$2$2;->val$dialog:Lcom/aio/downloader/dialog/NoupdareversionDialog;

    .line 319
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 323
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$2$2;->val$dialog:Lcom/aio/downloader/dialog/NoupdareversionDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/NoupdareversionDialog;->dismiss()V

    .line 325
    return-void
.end method
