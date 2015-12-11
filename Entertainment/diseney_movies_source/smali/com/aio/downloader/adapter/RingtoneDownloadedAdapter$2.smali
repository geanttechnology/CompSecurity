.class Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$2;
.super Ljava/lang/Object;
.source "RingtoneDownloadedAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    iput p2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$2;->val$position:I

    .line 197
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 201
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 202
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "ringtonedelete"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 203
    const-string v1, "position"

    iget v2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$2;->val$position:I

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 204
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$2;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    iget-object v1, v1, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 206
    return-void
.end method
