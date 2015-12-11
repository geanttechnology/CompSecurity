.class Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "Mp3DownloadedAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field my_delete_movie:Landroid/widget/ImageView;

.field my_movie_name_item:Landroid/widget/TextView;

.field my_stop_download_bt:Landroid/widget/Button;

.field my_test_head_image:Landroid/widget/ImageView;

.field my_totalsize:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;)V
    .locals 0

    .prologue
    .line 128
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;->this$0:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
