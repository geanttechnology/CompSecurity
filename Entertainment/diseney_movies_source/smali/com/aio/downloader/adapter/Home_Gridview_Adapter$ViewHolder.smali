.class Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;
.super Ljava/lang/Object;
.source "Home_Gridview_Adapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/Home_Gridview_Adapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field private gvdown:Lcom/aio/downloader/views/LImageButton;

.field private gvimg:Landroid/widget/ImageView;

.field private gvratingbar:Landroid/widget/RatingBar;

.field private gvtitle:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)V
    .locals 0

    .prologue
    .line 639
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 640
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->gvimg:Landroid/widget/ImageView;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 641
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->gvtitle:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;Lcom/aio/downloader/views/LImageButton;)V
    .locals 0

    .prologue
    .line 643
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->gvdown:Lcom/aio/downloader/views/LImageButton;

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;Landroid/widget/RatingBar;)V
    .locals 0

    .prologue
    .line 644
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->gvratingbar:Landroid/widget/RatingBar;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 641
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->gvtitle:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;)Landroid/widget/RatingBar;
    .locals 1

    .prologue
    .line 644
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->gvratingbar:Landroid/widget/RatingBar;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 640
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->gvimg:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;)Lcom/aio/downloader/views/LImageButton;
    .locals 1

    .prologue
    .line 643
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->gvdown:Lcom/aio/downloader/views/LImageButton;

    return-object v0
.end method
