.class Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "AppDownloadedAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/AppDownloadedAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field private my_delete_movie:Landroid/widget/ImageView;

.field private my_movie_name_item:Landroid/widget/TextView;

.field private my_stop_download_bt:Landroid/widget/TextView;

.field private my_test_head_image:Landroid/widget/ImageView;

.field private my_totalsize:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)V
    .locals 0

    .prologue
    .line 329
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->this$0:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 334
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_stop_download_bt:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 330
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_delete_movie:Landroid/widget/ImageView;

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 331
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_test_head_image:Landroid/widget/ImageView;

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 332
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_movie_name_item:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 333
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_totalsize:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 334
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_stop_download_bt:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 333
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_totalsize:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 332
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_movie_name_item:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 331
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_test_head_image:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 330
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_delete_movie:Landroid/widget/ImageView;

    return-object v0
.end method
