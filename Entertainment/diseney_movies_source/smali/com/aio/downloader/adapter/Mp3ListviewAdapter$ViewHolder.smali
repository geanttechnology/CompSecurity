.class Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "Mp3ListviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field private list_bg:Landroid/widget/RelativeLayout;

.field private mp3_download_bt:Landroid/widget/Button;

.field private mp3album_title:Landroid/widget/TextView;

.field private mp3artist_title:Landroid/widget/TextView;

.field private mp3size:Landroid/widget/TextView;

.field private mp3title:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)V
    .locals 0

    .prologue
    .line 451
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->this$0:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 453
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->mp3title:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 454
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->mp3album_title:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 456
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->mp3size:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 457
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->mp3_download_bt:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 455
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->mp3artist_title:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 456
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->mp3size:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;Landroid/widget/Button;)V
    .locals 0

    .prologue
    .line 457
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->mp3_download_bt:Landroid/widget/Button;

    return-void
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;Landroid/widget/RelativeLayout;)V
    .locals 0

    .prologue
    .line 458
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->list_bg:Landroid/widget/RelativeLayout;

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 458
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->list_bg:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 453
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->mp3title:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 454
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->mp3album_title:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 455
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->mp3artist_title:Landroid/widget/TextView;

    return-object v0
.end method
