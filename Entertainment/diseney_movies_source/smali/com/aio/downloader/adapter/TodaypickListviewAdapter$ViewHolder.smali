.class Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "TodaypickListviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/TodaypickListviewAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field private iv_today_icon:Landroid/widget/ImageView;

.field private ll_today_top_title:Landroid/widget/LinearLayout;

.field final synthetic this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

.field private todaydownload_bt:Landroid/widget/Button;

.field private todayhits:Landroid/widget/TextView;

.field private todayimg:Landroid/widget/ImageView;

.field private todayratingbar:Landroid/widget/RatingBar;

.field private todaytime:Landroid/widget/TextView;

.field private todaytitletv:Landroid/widget/TextView;

.field private tv_desc:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)V
    .locals 0

    .prologue
    .line 626
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 627
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todaytime:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 627
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todaytitletv:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 627
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todaytime:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 627
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todaytitletv:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 627
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->tv_desc:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 627
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todayhits:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/RatingBar;
    .locals 1

    .prologue
    .line 629
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todayratingbar:Landroid/widget/RatingBar;

    return-object v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 628
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todayimg:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$16(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 628
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->iv_today_icon:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 630
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todaydownload_bt:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 627
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todayhits:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 628
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todayimg:Landroid/widget/ImageView;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/RatingBar;)V
    .locals 0

    .prologue
    .line 629
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todayratingbar:Landroid/widget/RatingBar;

    return-void
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/Button;)V
    .locals 0

    .prologue
    .line 630
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todaydownload_bt:Landroid/widget/Button;

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 627
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->tv_desc:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$7(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 628
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->iv_today_icon:Landroid/widget/ImageView;

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/LinearLayout;)V
    .locals 0

    .prologue
    .line 631
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->ll_today_top_title:Landroid/widget/LinearLayout;

    return-void
.end method

.method static synthetic access$9(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 631
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->ll_today_top_title:Landroid/widget/LinearLayout;

    return-object v0
.end method
