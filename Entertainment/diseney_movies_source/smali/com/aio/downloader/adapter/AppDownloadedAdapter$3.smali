.class Lcom/aio/downloader/adapter/AppDownloadedAdapter$3;
.super Ljava/lang/Object;
.source "AppDownloadedAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/AppDownloadedAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/AppDownloadedAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$3;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    iput p2, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$3;->val$position:I

    .line 312
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 317
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 318
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "delete"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 319
    const-string v1, "position"

    iget v2, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$3;->val$position:I

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 320
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$3;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 322
    return-void
.end method
