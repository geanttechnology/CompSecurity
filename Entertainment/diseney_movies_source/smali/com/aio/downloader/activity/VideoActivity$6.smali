.class Lcom/aio/downloader/activity/VideoActivity$6;
.super Ljava/lang/Object;
.source "VideoActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/VideoActivity;->Error_dialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/VideoActivity;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/ErrorDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/VideoActivity;Lcom/aio/downloader/dialog/ErrorDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/VideoActivity$6;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/VideoActivity$6;->val$dialog:Lcom/aio/downloader/dialog/ErrorDialog;

    .line 655
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 659
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$6;->val$dialog:Lcom/aio/downloader/dialog/ErrorDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/ErrorDialog;->dismiss()V

    .line 661
    return-void
.end method
