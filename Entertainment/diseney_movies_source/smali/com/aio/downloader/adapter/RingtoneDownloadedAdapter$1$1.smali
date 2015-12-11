.class Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$1;
.super Ljava/lang/Object;
.source "RingtoneDownloadedAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$1;->this$1:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;

    .line 146
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 151
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$1;->this$1:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;
    invoke-static {v0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->access$0(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;)Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    move-result-object v0

    const/4 v1, 0x7

    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$1;->this$1:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;
    invoke-static {v2}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->access$0(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;)Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    move-result-object v2

    # getter for: Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->new_file_path:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->access$2(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->setRingtone(ILjava/lang/String;)V

    .line 152
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$1;->this$1:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;
    invoke-static {v0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->access$0(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;)Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    move-result-object v0

    # getter for: Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->access$4(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Landroid/widget/PopupWindow;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 154
    return-void
.end method
