.class Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "AppListviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/AppListviewAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field private app_download_bt:Lcom/aio/downloader/views/LImageButton;

.field private app_ratingbar:Landroid/widget/RatingBar;

.field private app_ratingbar_fb:Landroid/widget/RatingBar;

.field private appauthortitle:Landroid/widget/TextView;

.field private appauthortitle_fb:Landroid/widget/TextView;

.field private appicon:Landroid/widget/ImageView;

.field private appicon_fb:Landroid/widget/ImageView;

.field private appprice:Landroid/widget/TextView;

.field private appprice_fb:Landroid/widget/TextView;

.field private apptitle:Landroid/widget/TextView;

.field private apptitle_fb:Landroid/widget/TextView;

.field private inmobtop:Landroid/widget/RelativeLayout;

.field private inmobtop_fb:Landroid/widget/RelativeLayout;

.field private playtop:Landroid/widget/ImageView;

.field final synthetic this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

.field private xian:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/AppListviewAdapter;)V
    .locals 0

    .prologue
    .line 1000
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 1001
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appicon:Landroid/widget/ImageView;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 1002
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->apptitle:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 1004
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appprice:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/RatingBar;
    .locals 1

    .prologue
    .line 1005
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->app_ratingbar:Landroid/widget/RatingBar;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 1001
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appicon:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 1008
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->playtop:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Lcom/aio/downloader/views/LImageButton;
    .locals 1

    .prologue
    .line 1006
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->app_download_bt:Lcom/aio/downloader/views/LImageButton;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 1008
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->playtop:Landroid/widget/ImageView;

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 1004
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appprice:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 1003
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appauthortitle:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Landroid/widget/RatingBar;)V
    .locals 0

    .prologue
    .line 1005
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->app_ratingbar:Landroid/widget/RatingBar;

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Lcom/aio/downloader/views/LImageButton;)V
    .locals 0

    .prologue
    .line 1006
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->app_download_bt:Lcom/aio/downloader/views/LImageButton;

    return-void
.end method

.method static synthetic access$7(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 1009
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->xian:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 1002
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->apptitle:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 1003
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appauthortitle:Landroid/widget/TextView;

    return-object v0
.end method
