.class public Lcom/aio/downloader/activity/VideoActivity;
.super Lcom/aio/downloader/mydownload/BaseActivity;
.source "VideoActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;,
        Lcom/aio/downloader/activity/VideoActivity$Mywebview;
    }
.end annotation


# static fields
.field private static typeFace:Landroid/graphics/Typeface;


# instance fields
.field private adView:Lcom/google/ads/AdView;

.field private adapter:Lcom/aio/downloader/adapter/VideoListviewAdapter;

.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private banner_type_name:Ljava/lang/String;

.field private db:Lnet/tsz/afinal/FinalDBChen;

.field private fan:Landroid/widget/ImageView;

.field hander:Landroid/os/Handler;

.field private lieshow:Landroid/widget/LinearLayout;

.field private model:Lcom/aio/downloader/model/VideoModel;

.field private mychafan:Landroid/widget/ImageView;

.field private net_hint_img_list:Landroid/widget/ImageView;

.field private progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private sp_config:Landroid/content/SharedPreferences;

.field private tvloading:Landroid/widget/TextView;

.field private video_download_img:Landroid/widget/ImageView;

.field private video_download_item_listview:Landroid/widget/ListView;

.field private video_home_url:Ljava/lang/String;

.field private video_info_url:Ljava/lang/String;

.field private video_title:Landroid/widget/TextView;

.field private videobanner:Landroid/widget/LinearLayout;

.field private videodownloader:Landroid/widget/Button;

.field private videodownloader2:Landroid/widget/Button;

.field private videojianpan:Landroid/widget/RelativeLayout;

.field private videoreload:Landroid/widget/Button;

.field private videotitle:Landroid/widget/TextView;

.field private videowebview:Landroid/webkit/WebView;

.field private webviewclient:Lcom/aio/downloader/activity/VideoActivity$Mywebview;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 112
    const/4 v0, 0x0

    sput-object v0, Lcom/aio/downloader/activity/VideoActivity;->typeFace:Landroid/graphics/Typeface;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 66
    invoke-direct {p0}, Lcom/aio/downloader/mydownload/BaseActivity;-><init>()V

    .line 68
    new-instance v0, Lcom/aio/downloader/activity/VideoActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/VideoActivity$1;-><init>(Lcom/aio/downloader/activity/VideoActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->hander:Landroid/os/Handler;

    .line 98
    const-string v0, "http://m.youtube.com/"

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->video_home_url:Ljava/lang/String;

    .line 100
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->video_info_url:Ljava/lang/String;

    .line 101
    iput-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 115
    iput-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->sp_config:Landroid/content/SharedPreferences;

    .line 66
    return-void
.end method

.method private Bottom2()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 627
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->lieshow:Landroid/widget/LinearLayout;

    .line 628
    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 627
    check-cast v0, Landroid/widget/LinearLayout$LayoutParams;

    .line 629
    .local v0, "linearParams":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {v0, v2, v2, v2, v2}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 630
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->lieshow:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 631
    return-void
.end method

.method private Error_dialog()V
    .locals 3

    .prologue
    .line 650
    new-instance v0, Lcom/aio/downloader/dialog/ErrorDialog;

    .line 651
    const v2, 0x7f0c000e

    .line 650
    invoke-direct {v0, p0, v2}, Lcom/aio/downloader/dialog/ErrorDialog;-><init>(Landroid/content/Context;I)V

    .line 652
    .local v0, "dialog":Lcom/aio/downloader/dialog/ErrorDialog;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/aio/downloader/dialog/ErrorDialog;->setCanceledOnTouchOutside(Z)V

    .line 653
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/ErrorDialog;->show()V

    .line 654
    const v2, 0x7f07001e

    invoke-virtual {v0, v2}, Lcom/aio/downloader/dialog/ErrorDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 655
    .local v1, "ok":Landroid/widget/Button;
    new-instance v2, Lcom/aio/downloader/activity/VideoActivity$6;

    invoke-direct {v2, p0, v0}, Lcom/aio/downloader/activity/VideoActivity$6;-><init>(Lcom/aio/downloader/activity/VideoActivity;Lcom/aio/downloader/dialog/ErrorDialog;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 664
    return-void
.end method

.method private Mydialog()V
    .locals 3

    .prologue
    .line 575
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 576
    const v1, 0x7f0b0034

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/VideoActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 577
    const-string v1, "It has been in downloading list already."

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 578
    const-string v1, "Ok"

    .line 579
    new-instance v2, Lcom/aio/downloader/activity/VideoActivity$5;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/VideoActivity$5;-><init>(Lcom/aio/downloader/activity/VideoActivity;)V

    .line 578
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 585
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 587
    return-void
.end method

.method private Mywebview1()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 634
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    .line 635
    invoke-virtual {v1}, Landroid/webkit/WebView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 634
    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 637
    .local v0, "linearParams":Landroid/widget/RelativeLayout$LayoutParams;
    const/high16 v1, 0x42b00000    # 88.0f

    invoke-static {p0, v1}, Lcom/aio/downloader/utils/DisplayUtil;->dip2px(Landroid/content/Context;F)I

    move-result v1

    invoke-virtual {v0, v2, v2, v2, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 638
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 640
    return-void
.end method

.method private Mywebview2()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 643
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    .line 644
    invoke-virtual {v1}, Landroid/webkit/WebView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 643
    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 645
    .local v0, "linearParams":Landroid/widget/RelativeLayout$LayoutParams;
    const/high16 v1, 0x42180000    # 38.0f

    invoke-static {p0, v1}, Lcom/aio/downloader/utils/DisplayUtil;->dip2px(Landroid/content/Context;F)I

    move-result v1

    invoke-virtual {v0, v2, v2, v2, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 646
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 648
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/VideoActivity;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->videodownloader:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/VideoActivity;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->videodownloader2:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/VideoActivity;Lcom/aio/downloader/model/VideoModel;)V
    .locals 0

    .prologue
    .line 126
    iput-object p1, p0, Lcom/aio/downloader/activity/VideoActivity;->model:Lcom/aio/downloader/model/VideoModel;

    return-void
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/model/VideoModel;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->model:Lcom/aio/downloader/model/VideoModel;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/VideoActivity;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 455
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/VideoActivity;->dowload_video(Ljava/util/ArrayList;)V

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/VideoActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->tvloading:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/adapter/VideoListviewAdapter;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->adapter:Lcom/aio/downloader/adapter/VideoListviewAdapter;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/VideoActivity;)Landroid/webkit/WebView;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/VideoActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->net_hint_img_list:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/VideoActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/aio/downloader/activity/VideoActivity;->video_info_url:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/VideoActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->video_info_url:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/VideoActivity;)V
    .locals 0

    .prologue
    .line 649
    invoke-direct {p0}, Lcom/aio/downloader/activity/VideoActivity;->Error_dialog()V

    return-void
.end method

.method private buildListener()V
    .locals 2

    .prologue
    .line 194
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->fan:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 195
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->mychafan:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 196
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->videodownloader:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 197
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->videodownloader2:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 198
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->videoreload:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 201
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    new-instance v1, Lcom/aio/downloader/activity/VideoActivity$2;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/VideoActivity$2;-><init>(Lcom/aio/downloader/activity/VideoActivity;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 227
    return-void
.end method

.method private dowload_video(Ljava/util/ArrayList;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/VideoModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 456
    .local p1, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/model/VideoModel;>;"
    new-instance v0, Lcom/aio/downloader/dialog/VideoDownloadDialog;

    .line 457
    const v1, 0x7f0c000e

    .line 456
    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/dialog/VideoDownloadDialog;-><init>(Landroid/content/Context;I)V

    .line 458
    .local v0, "dialog":Lcom/aio/downloader/dialog/VideoDownloadDialog;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/dialog/VideoDownloadDialog;->setCanceledOnTouchOutside(Z)V

    .line 460
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 461
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/VideoDownloadDialog;->show()V

    .line 463
    const v1, 0x7f070403

    invoke-virtual {v0, v1}, Lcom/aio/downloader/dialog/VideoDownloadDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 462
    iput-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->video_download_img:Landroid/widget/ImageView;

    .line 464
    const v1, 0x7f070404

    invoke-virtual {v0, v1}, Lcom/aio/downloader/dialog/VideoDownloadDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videotitle:Landroid/widget/TextView;

    .line 466
    const v1, 0x7f070405

    invoke-virtual {v0, v1}, Lcom/aio/downloader/dialog/VideoDownloadDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    .line 465
    iput-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->video_download_item_listview:Landroid/widget/ListView;

    .line 467
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    iget-object v2, p0, Lcom/aio/downloader/activity/VideoActivity;->model:Lcom/aio/downloader/model/VideoModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_img()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/activity/VideoActivity;->video_download_img:Landroid/widget/ImageView;

    invoke-virtual {v1, v2, v3}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 468
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videotitle:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/aio/downloader/activity/VideoActivity;->model:Lcom/aio/downloader/model/VideoModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_title()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 470
    new-instance v1, Ljava/lang/Thread;

    new-instance v2, Lcom/aio/downloader/activity/VideoActivity$3;

    invoke-direct {v2, p0, p1}, Lcom/aio/downloader/activity/VideoActivity$3;-><init>(Lcom/aio/downloader/activity/VideoActivity;Ljava/util/ArrayList;)V

    invoke-direct {v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 492
    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 494
    new-instance v1, Lcom/aio/downloader/adapter/VideoListviewAdapter;

    invoke-direct {v1, p0, p1}, Lcom/aio/downloader/adapter/VideoListviewAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    iput-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->adapter:Lcom/aio/downloader/adapter/VideoListviewAdapter;

    .line 495
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->video_download_item_listview:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/aio/downloader/activity/VideoActivity;->adapter:Lcom/aio/downloader/adapter/VideoListviewAdapter;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 497
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->video_download_item_listview:Landroid/widget/ListView;

    .line 498
    new-instance v2, Lcom/aio/downloader/activity/VideoActivity$4;

    invoke-direct {v2, p0, p1, v0}, Lcom/aio/downloader/activity/VideoActivity$4;-><init>(Lcom/aio/downloader/activity/VideoActivity;Ljava/util/ArrayList;Lcom/aio/downloader/dialog/VideoDownloadDialog;)V

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 537
    :cond_0
    return-void
.end method

.method private init()V
    .locals 3

    .prologue
    .line 154
    const v0, 0x7f0703f7

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->videojianpan:Landroid/widget/RelativeLayout;

    .line 155
    const-string v0, "banner_type"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/aio/downloader/activity/VideoActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->sp_config:Landroid/content/SharedPreferences;

    .line 156
    const v0, 0x7f0703f8

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->fan:Landroid/widget/ImageView;

    .line 157
    const v0, 0x7f0703fd

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->tvloading:Landroid/widget/TextView;

    .line 158
    const v0, 0x7f0703f9

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->video_title:Landroid/widget/TextView;

    .line 159
    const v0, 0x7f0703fc

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    .line 160
    const v0, 0x7f0703fa

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->mychafan:Landroid/widget/ImageView;

    .line 162
    const v0, 0x7f070402

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->videobanner:Landroid/widget/LinearLayout;

    .line 163
    const v0, 0x7f070072

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 164
    const v0, 0x7f070274

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->net_hint_img_list:Landroid/widget/ImageView;

    .line 165
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->net_hint_img_list:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 166
    const v0, 0x7f0703ff

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->videodownloader:Landroid/widget/Button;

    .line 167
    const v0, 0x7f070400

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->videodownloader2:Landroid/widget/Button;

    .line 168
    const v0, 0x7f070401

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->videoreload:Landroid/widget/Button;

    .line 169
    const v0, 0x7f0703fe

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->lieshow:Landroid/widget/LinearLayout;

    .line 170
    invoke-virtual {p0}, Lcom/aio/downloader/activity/VideoActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 172
    sget-object v0, Lcom/aio/downloader/activity/VideoActivity;->typeFace:Landroid/graphics/Typeface;

    if-nez v0, :cond_0

    .line 173
    invoke-virtual {p0}, Lcom/aio/downloader/activity/VideoActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 174
    const-string v1, "font.ttf"

    .line 173
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/activity/VideoActivity;->typeFace:Landroid/graphics/Typeface;

    .line 176
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->video_title:Landroid/widget/TextView;

    sget-object v1, Lcom/aio/downloader/activity/VideoActivity;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 178
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->sp_config:Landroid/content/SharedPreferences;

    const-string v1, "banner_type"

    const-string v2, "admob"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->banner_type_name:Ljava/lang/String;

    .line 180
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->banner_type_name:Ljava/lang/String;

    const-string v1, "admob"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 181
    new-instance v0, Lcom/google/ads/AdView;

    sget-object v1, Lcom/google/ads/AdSize;->SMART_BANNER:Lcom/google/ads/AdSize;

    .line 182
    const-string v2, "ca-app-pub-2192624499353475/5842010949"

    invoke-direct {v0, p0, v1, v2}, Lcom/google/ads/AdView;-><init>(Landroid/app/Activity;Lcom/google/ads/AdSize;Ljava/lang/String;)V

    .line 181
    iput-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->adView:Lcom/google/ads/AdView;

    .line 183
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->videobanner:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->adView:Lcom/google/ads/AdView;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 184
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->adView:Lcom/google/ads/AdView;

    new-instance v1, Lcom/google/ads/AdRequest;

    invoke-direct {v1}, Lcom/google/ads/AdRequest;-><init>()V

    invoke-virtual {v0, v1}, Lcom/google/ads/AdView;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 185
    invoke-direct {p0}, Lcom/aio/downloader/activity/VideoActivity;->Mywebview1()V

    .line 191
    :goto_0
    return-void

    .line 188
    :cond_1
    invoke-direct {p0}, Lcom/aio/downloader/activity/VideoActivity;->Bottom2()V

    .line 189
    invoke-direct {p0}, Lcom/aio/downloader/activity/VideoActivity;->Mywebview2()V

    goto :goto_0
.end method


# virtual methods
.method public VideoDownload(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "url"    # Ljava/lang/String;
    .param p4, "icon"    # Ljava/lang/String;

    .prologue
    .line 543
    new-instance v6, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 545
    .local v6, "d":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "file_id"

    .line 546
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    move-object v2, p1

    .line 545
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 546
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 547
    invoke-direct {p0}, Lcom/aio/downloader/activity/VideoActivity;->Mydialog()V

    .line 571
    :goto_0
    return-void

    .line 549
    :cond_0
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 550
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/aio/downloader/activity/VideoActivity;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 551
    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/activity/VideoActivity;->model:Lcom/aio/downloader/model/VideoModel;

    invoke-virtual {v3}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_format()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 549
    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 551
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v7

    .line 553
    .local v7, "path":Ljava/lang/String;
    invoke-virtual {v6, p3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadUrl(Ljava/lang/String;)V

    .line 554
    const-string v0, "erer"

    invoke-static {v0, p3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 555
    invoke-virtual {v6, v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFilePath(Ljava/lang/String;)V

    .line 556
    const/4 v0, 0x4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v6, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 557
    invoke-virtual {v6, p2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieName(Ljava/lang/String;)V

    .line 558
    invoke-virtual {v6, p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 559
    const-string v0, "sdsd"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {p3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "********"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "*********"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 560
    const-string v2, "**********"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/VideoActivity;->model:Lcom/aio/downloader/model/VideoModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_format()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 559
    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 561
    invoke-virtual {v6, p4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImagePath(Ljava/lang/String;)V

    .line 562
    const-string v0, "video"

    invoke-virtual {v6, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setType(Ljava/lang/String;)V

    .line 563
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v6, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCreate_time(Ljava/lang/Long;)V

    .line 564
    invoke-virtual {p0, v6}, Lcom/aio/downloader/activity/VideoActivity;->toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 565
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v0, Lcom/aio/downloader/utils/Myutils;->list:Ljava/util/List;

    invoke-interface {v0, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 566
    invoke-virtual {p0}, Lcom/aio/downloader/activity/VideoActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 567
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\' is added to download queue."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 568
    const/4 v2, 0x0

    .line 566
    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 568
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0
.end method

.method public initView()V
    .locals 6

    .prologue
    .line 232
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->initView()V

    .line 234
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/VideoActivity;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    new-instance v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 235
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 234
    invoke-direct/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V

    .line 237
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 241
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    .line 279
    :cond_0
    :goto_0
    return-void

    .line 244
    :sswitch_0
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->canGoBack()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 245
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->goBack()V

    .line 247
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v1

    const-string v2, "//m.youtube.com"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 248
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v1

    const-string v2, "v="

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 249
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 250
    .local v0, "msg":Landroid/os/Message;
    const/4 v1, 0x1

    iput v1, v0, Landroid/os/Message;->what:I

    .line 251
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->hander:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0

    .line 253
    .end local v0    # "msg":Landroid/os/Message;
    :cond_1
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 254
    .restart local v0    # "msg":Landroid/os/Message;
    const/4 v1, 0x2

    iput v1, v0, Landroid/os/Message;->what:I

    .line 255
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->hander:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0

    .line 259
    .end local v0    # "msg":Landroid/os/Message;
    :cond_2
    invoke-virtual {p0}, Lcom/aio/downloader/activity/VideoActivity;->finish()V

    goto :goto_0

    .line 264
    :sswitch_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/VideoActivity;->finish()V

    goto :goto_0

    .line 268
    :sswitch_2
    new-instance v1, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;-><init>(Lcom/aio/downloader/activity/VideoActivity;)V

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 272
    :sswitch_3
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    iget-object v2, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0

    .line 241
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f0703f8 -> :sswitch_0
        0x7f0703fa -> :sswitch_1
        0x7f0703ff -> :sswitch_2
        0x7f070401 -> :sswitch_3
    .end sparse-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SetJavaScriptEnabled",
            "ResourceAsColor"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 134
    invoke-super {p0, p1}, Lcom/aio/downloader/mydownload/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 135
    const v1, 0x7f0300bd

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/VideoActivity;->setContentView(I)V

    .line 136
    new-instance v1, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/VideoActivity;->getmContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "download2.db"

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/VideoActivity;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v3

    .line 137
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 136
    iput-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 138
    invoke-virtual {p0}, Lcom/aio/downloader/activity/VideoActivity;->initView()V

    .line 139
    invoke-direct {p0}, Lcom/aio/downloader/activity/VideoActivity;->init()V

    .line 140
    invoke-direct {p0}, Lcom/aio/downloader/activity/VideoActivity;->buildListener()V

    .line 141
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    .line 142
    .local v0, "settings":Landroid/webkit/WebSettings;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 143
    new-instance v1, Lcom/aio/downloader/activity/VideoActivity$Mywebview;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/VideoActivity$Mywebview;-><init>(Lcom/aio/downloader/activity/VideoActivity;)V

    iput-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->webviewclient:Lcom/aio/downloader/activity/VideoActivity$Mywebview;

    .line 144
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    iget-object v2, p0, Lcom/aio/downloader/activity/VideoActivity;->webviewclient:Lcom/aio/downloader/activity/VideoActivity$Mywebview;

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 145
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    iget-object v2, p0, Lcom/aio/downloader/activity/VideoActivity;->video_home_url:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 147
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videodownloader2:Landroid/widget/Button;

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 148
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videodownloader:Landroid/widget/Button;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 149
    iget-object v1, p0, Lcom/aio/downloader/activity/VideoActivity;->videowebview:Landroid/webkit/WebView;

    invoke-static {v4, v4, v4, v4}, Landroid/graphics/Color;->argb(IIII)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setBackgroundColor(I)V

    .line 151
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 620
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onPause()V

    .line 621
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 622
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 613
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onResume()V

    .line 614
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 615
    return-void
.end method

.method public toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 7
    .param p1, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 591
    const-string v0, "mymy"

    const-string v1, "ssssss"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 592
    const/4 v0, 0x7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 593
    invoke-virtual {p0}, Lcom/aio/downloader/activity/VideoActivity;->getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/aio/downloader/mydownload/MyApplcation;->setStartDownloadMovieItem(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 594
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-string v1, "download_aio"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/VideoActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 597
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 598
    const-string v1, "movieName"

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 599
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 597
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 600
    .local v6, "ls":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 602
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    invoke-virtual {v0, p1, v1}, Lnet/tsz/afinal/FinalDBChen;->insertObject(Ljava/lang/Object;Ljava/lang/String;)J

    .line 608
    :goto_0
    return-void

    .line 605
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    const-string v2, "movieName=?"

    .line 606
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 605
    invoke-virtual {v0, v1, v2, v3, p1}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
