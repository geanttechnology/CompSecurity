.class Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;
.super Ljava/lang/Object;
.source "Home_Listview_Adapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/Home_Listview_Adapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field public bannerimg:Landroid/widget/ImageView;

.field bt_gif:Landroid/widget/Button;

.field bt_pics:Landroid/widget/Button;

.field bt_share:Landroid/widget/Button;

.field bt_video:Landroid/widget/Button;

.field private fun_botten:Landroid/widget/TextView;

.field fun_more:Landroid/widget/TextView;

.field fun_title:Landroid/widget/RelativeLayout;

.field private fun_top:Landroid/widget/TextView;

.field private funshouye:Landroid/widget/LinearLayout;

.field private gridviewtv:Landroid/widget/TextView;

.field iv_fun:Landroid/widget/ImageView;

.field public iv_like_new:Landroid/widget/ImageView;

.field private ll_fun_share:Landroid/widget/LinearLayout;

.field private lv_gv_gridview:Landroid/widget/GridView;

.field private lv_gv_tvsearch:Landroid/widget/TextView;

.field private lv_gv_tvtitle:Landroid/widget/TextView;

.field private minigamedetail:Landroid/widget/TextView;

.field private minigameicon:Landroid/widget/ImageView;

.field private minigamelist2:Landroid/widget/RelativeLayout;

.field private minigameplaybt:Landroid/widget/Button;

.field private minigametitle:Landroid/widget/TextView;

.field rl_like:Landroid/widget/RelativeLayout;

.field final synthetic this$0:Lcom/aio/downloader/adapter/Home_Listview_Adapter;

.field private topsearch:Landroid/widget/RelativeLayout;

.field tv_fun:Landroid/widget/TextView;

.field private tv_funadult_download:Landroid/widget/TextView;

.field tv_funadult_like:Landroid/widget/TextView;

.field tv_funadult_share:Landroid/widget/TextView;

.field tv_funadult_time:Landroid/widget/TextView;

.field private tv_game:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;)V
    .locals 0

    .prologue
    .line 324
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->this$0:Lcom/aio/downloader/adapter/Home_Listview_Adapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 325
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->lv_gv_tvtitle:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 325
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->lv_gv_tvsearch:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/LinearLayout;)V
    .locals 0

    .prologue
    .line 335
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->funshouye:Landroid/widget/LinearLayout;

    return-void
.end method

.method static synthetic access$11(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 334
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_game:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$12(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 331
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_botten:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$13(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 331
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_top:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$14(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 325
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_funadult_download:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$15(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/LinearLayout;)V
    .locals 0

    .prologue
    .line 335
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->ll_fun_share:Landroid/widget/LinearLayout;

    return-void
.end method

.method static synthetic access$16(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 325
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->lv_gv_tvtitle:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/GridView;
    .locals 1

    .prologue
    .line 326
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->lv_gv_gridview:Landroid/widget/GridView;

    return-object v0
.end method

.method static synthetic access$18(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 334
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->gridviewtv:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$19(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 328
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigamelist2:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/GridView;)V
    .locals 0

    .prologue
    .line 326
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->lv_gv_gridview:Landroid/widget/GridView;

    return-void
.end method

.method static synthetic access$20(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 334
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_game:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$21(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 331
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigametitle:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$22(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 330
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigameicon:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$23(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 332
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigamedetail:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$24(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 325
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->lv_gv_tvsearch:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$25(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 333
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigameplaybt:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$26(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 335
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->funshouye:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$27(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 331
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_botten:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$28(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 331
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_top:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$29(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 325
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_funadult_download:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/RelativeLayout;)V
    .locals 0

    .prologue
    .line 328
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigamelist2:Landroid/widget/RelativeLayout;

    return-void
.end method

.method static synthetic access$30(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 335
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->ll_fun_share:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 331
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigametitle:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 330
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigameicon:Landroid/widget/ImageView;

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 332
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigamedetail:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$7(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/Button;)V
    .locals 0

    .prologue
    .line 333
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigameplaybt:Landroid/widget/Button;

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/RelativeLayout;)V
    .locals 0

    .prologue
    .line 329
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->topsearch:Landroid/widget/RelativeLayout;

    return-void
.end method

.method static synthetic access$9(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 334
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->gridviewtv:Landroid/widget/TextView;

    return-void
.end method
