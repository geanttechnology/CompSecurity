.class Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$2;
.super Ljava/lang/Object;
.source "Mp3DownloadedAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    iput p2, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$2;->val$position:I

    .line 112
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 116
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 117
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "mp3delete"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 118
    const-string v1, "position"

    iget v2, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$2;->val$position:I

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 119
    iget-object v1, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 121
    return-void
.end method
