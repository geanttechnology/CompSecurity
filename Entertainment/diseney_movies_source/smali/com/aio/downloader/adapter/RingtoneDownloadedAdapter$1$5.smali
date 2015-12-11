.class Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$5;
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
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$5;->this$1:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;

    .line 184
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 188
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$5;->this$1:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;

    # getter for: Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;
    invoke-static {v0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->access$0(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;)Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    move-result-object v0

    # getter for: Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->mWindow:Landroid/widget/PopupWindow;
    invoke-static {v0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->access$4(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Landroid/widget/PopupWindow;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 190
    return-void
.end method
