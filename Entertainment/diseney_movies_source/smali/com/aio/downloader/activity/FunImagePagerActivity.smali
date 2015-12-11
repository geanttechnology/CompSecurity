.class public Lcom/aio/downloader/activity/FunImagePagerActivity;
.super Landroid/app/Activity;
.source "FunImagePagerActivity.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;
.implements Lcom/google/ads/AdListener;
.implements Lcom/facebook/ads/AdListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;
    }
.end annotation


# instance fields
.field private AIOGALLERY:Ljava/io/File;

.field private AIOGALLERYAPK:Ljava/io/File;

.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private appbanner:Landroid/widget/LinearLayout;

.field private bitmap:Landroid/graphics/Bitmap;

.field private dPicture:I

.field private detailcount:I

.field private detailserial:Ljava/lang/String;

.field private detailtitle:Ljava/lang/String;

.field private gag:I

.field private handler:Landroid/os/Handler;

.field private inflater:Landroid/view/LayoutInflater;

.field private interstitial:Lcom/google/ads/InterstitialAd;

.field private iv_detail_back:Lcom/aio/downloader/views/LImageButton;

.field private iv_fun_likeshow:Landroid/widget/ImageView;

.field private iv_mygift:Landroid/widget/ImageView;

.field private iv_mygift_gallery:Landroid/widget/ImageView;

.field private lf_fun_download:Lcom/aio/downloader/views/LFrameLayout;

.field private lf_fun_like:Lcom/aio/downloader/views/LFrameLayout;

.field private lf_fun_share:Lcom/aio/downloader/views/LFrameLayout;

.field private list:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private ll_mygift:Landroid/widget/LinearLayout;

.field private ll_mygift_gallery:Landroid/widget/LinearLayout;

.field private nativeAd:Lcom/facebook/ads/NativeAd;

.field private picture_name:Ljava/lang/String;

.field private rl_fun_gongneng:Landroid/widget/RelativeLayout;

.field private screenshotpos:I

.field private shake:Landroid/view/animation/Animation;

.field private tv_detail_jingdu:Landroid/widget/TextView;

.field private tv_detail_title:Landroid/widget/TextView;

.field private url:Ljava/lang/String;

.field private url_gallery:Ljava/lang/String;

.field private viewPager:Lcom/aio/downloader/pager/JazzyViewPager;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 63
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 87
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 88
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 89
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 90
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "gallery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->AIOGALLERY:Ljava/io/File;

    .line 92
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 93
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 94
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 95
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "gallery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->AIOGALLERYAPK:Ljava/io/File;

    .line 99
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->bitmap:Landroid/graphics/Bitmap;

    .line 101
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->dPicture:I

    .line 104
    new-instance v0, Lcom/aio/downloader/activity/FunImagePagerActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/FunImagePagerActivity$1;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->handler:Landroid/os/Handler;

    .line 63
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->picture_name:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/FunImagePagerActivity;Landroid/view/LayoutInflater;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->inflater:Landroid/view/LayoutInflater;

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/FunImagePagerActivity;)Lcom/aio/downloader/mydownload/MyApplcation;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->url:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->AIOGALLERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->AIOGALLERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->list:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/activity/FunImagePagerActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 694
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getImage(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$16(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->iv_fun_likeshow:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->detailserial:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$18(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->detailtitle:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$19(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->url_gallery:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/FunImagePagerActivity;)Lcom/aio/downloader/pager/JazzyViewPager;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;

    return-object v0
.end method

.method static synthetic access$20(Lcom/aio/downloader/activity/FunImagePagerActivity;Landroid/graphics/Bitmap;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->bitmap:Landroid/graphics/Bitmap;

    return-void
.end method

.method static synthetic access$21(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/view/LayoutInflater;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->inflater:Landroid/view/LayoutInflater;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/FunImagePagerActivity;Landroid/widget/LinearLayout;)V
    .locals 0

    .prologue
    .line 102
    iput-object p1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->appbanner:Landroid/widget/LinearLayout;

    return-void
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->appbanner:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/FunImagePagerActivity;)Lcom/aio/downloader/views/LImageButton;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->iv_detail_back:Lcom/aio/downloader/views/LImageButton;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->tv_detail_title:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->tv_detail_jingdu:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->rl_fun_gongneng:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method private facebookad()V
    .locals 3

    .prologue
    .line 670
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v1}, Lcom/facebook/ads/NativeAd;->getAdIcon()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 671
    .local v0, "adIcon":Lcom/facebook/ads/NativeAd$Image;
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->iv_mygift:Landroid/widget/ImageView;

    invoke-static {v0, v1}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 672
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->iv_mygift:Landroid/widget/ImageView;

    invoke-virtual {v1, v2}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 673
    return-void
.end method

.method private getImage(Ljava/lang/String;)V
    .locals 4
    .param p1, "picPath"    # Ljava/lang/String;

    .prologue
    .line 696
    move-object v1, p1

    .line 697
    .local v1, "uri":Ljava/lang/String;
    new-instance v0, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 698
    const-string v3, "AIO_PICTURE"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->picture_name:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".jpg"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 697
    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 699
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 700
    const-string v2, "ALREADY EXISTS"

    const/4 v3, 0x0

    invoke-static {p0, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    .line 777
    :goto_0
    return-void

    .line 704
    :cond_0
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/aio/downloader/activity/FunImagePagerActivity$12;

    invoke-direct {v3, p0, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity$12;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity;Ljava/lang/String;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 775
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    goto :goto_0
.end method

.method private init()V
    .locals 4

    .prologue
    .line 207
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 208
    const v1, 0x7f070111

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/pager/JazzyViewPager;

    iput-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;

    .line 209
    const v1, 0x7f070116

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->tv_detail_title:Landroid/widget/TextView;

    .line 210
    const v1, 0x7f070113

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->tv_detail_jingdu:Landroid/widget/TextView;

    .line 211
    const v1, 0x7f070114

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/views/LImageButton;

    iput-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->iv_detail_back:Lcom/aio/downloader/views/LImageButton;

    .line 213
    const v1, 0x7f07011b

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->ll_mygift:Landroid/widget/LinearLayout;

    .line 214
    const v1, 0x7f07011c

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->iv_mygift:Landroid/widget/ImageView;

    .line 216
    const v1, 0x7f070119

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/views/LFrameLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->lf_fun_download:Lcom/aio/downloader/views/LFrameLayout;

    .line 217
    const v1, 0x7f070112

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->rl_fun_gongneng:Landroid/widget/RelativeLayout;

    .line 218
    const v1, 0x7f070117

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/views/LFrameLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->lf_fun_like:Lcom/aio/downloader/views/LFrameLayout;

    .line 219
    const v1, 0x7f07011a

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/views/LFrameLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->lf_fun_share:Lcom/aio/downloader/views/LFrameLayout;

    .line 220
    const v1, 0x7f070118

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->iv_fun_likeshow:Landroid/widget/ImageView;

    .line 222
    const v1, 0x7f07011d

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->ll_mygift_gallery:Landroid/widget/LinearLayout;

    .line 223
    const v1, 0x7f07011e

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->iv_mygift_gallery:Landroid/widget/ImageView;

    .line 224
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->iv_mygift_gallery:Landroid/widget/ImageView;

    new-instance v2, Lcom/aio/downloader/activity/FunImagePagerActivity$3;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/FunImagePagerActivity$3;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 290
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->iv_detail_back:Lcom/aio/downloader/views/LImageButton;

    new-instance v2, Lcom/aio/downloader/activity/FunImagePagerActivity$4;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/FunImagePagerActivity$4;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity;)V

    invoke-virtual {v1, v2}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 311
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->tv_detail_title:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->detailtitle:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 313
    sget-object v0, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->Tablet:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    .line 314
    .local v0, "effect":Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/pager/JazzyViewPager;->setTransitionEffect(Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;)V

    .line 316
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;

    invoke-virtual {v1, p0}, Lcom/aio/downloader/pager/JazzyViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 317
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;

    new-instance v2, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;

    iget-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->list:Ljava/util/ArrayList;

    invoke-direct {v2, p0, v3}, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity;Ljava/util/ArrayList;)V

    invoke-virtual {v1, v2}, Lcom/aio/downloader/pager/JazzyViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 318
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;

    iget v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->screenshotpos:I

    invoke-virtual {v1, v2}, Lcom/aio/downloader/pager/JazzyViewPager;->setCurrentItem(I)V

    .line 319
    return-void
.end method

.method private show_big_ad()V
    .locals 3

    .prologue
    .line 199
    new-instance v1, Lcom/google/ads/InterstitialAd;

    .line 200
    const-string v2, "ca-app-pub-2192624499353475/7318744145"

    invoke-direct {v1, p0, v2}, Lcom/google/ads/InterstitialAd;-><init>(Landroid/app/Activity;Ljava/lang/String;)V

    .line 199
    iput-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->interstitial:Lcom/google/ads/InterstitialAd;

    .line 201
    new-instance v0, Lcom/google/ads/AdRequest;

    invoke-direct {v0}, Lcom/google/ads/AdRequest;-><init>()V

    .line 202
    .local v0, "adRequest":Lcom/google/ads/AdRequest;
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->interstitial:Lcom/google/ads/InterstitialAd;

    invoke-virtual {v1, v0}, Lcom/google/ads/InterstitialAd;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 203
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->interstitial:Lcom/google/ads/InterstitialAd;

    invoke-virtual {v1, p0}, Lcom/google/ads/InterstitialAd;->setAdListener(Lcom/google/ads/AdListener;)V

    .line 204
    return-void
.end method


# virtual methods
.method public getFileSizes(Ljava/io/File;)J
    .locals 4
    .param p1, "f"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 683
    const-wide/16 v1, 0x0

    .line 684
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 685
    const/4 v0, 0x0

    .line 686
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 687
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 691
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 689
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 652
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 2
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    const/16 v1, 0x8

    .line 657
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 666
    :cond_0
    :goto_0
    return-void

    .line 661
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 662
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->ll_mygift:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 663
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->ll_mygift_gallery:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 665
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->ll_mygift_gallery:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->clearAnimation()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x0

    .line 165
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 166
    const v0, 0x7f03001c

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->setContentView(I)V

    .line 167
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 168
    const-string v1, "screenshotlist"

    .line 167
    invoke-virtual {v0, v1}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->list:Ljava/util/ArrayList;

    .line 169
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "screenshotpos"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->screenshotpos:I

    .line 170
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "detailtitle"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->detailtitle:Ljava/lang/String;

    .line 171
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "detailcount"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->detailcount:I

    .line 172
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "detailserial"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->detailserial:Ljava/lang/String;

    .line 173
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "gag"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->gag:I

    .line 174
    invoke-direct {p0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->init()V

    .line 175
    iget v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->gag:I

    if-nez v0, :cond_0

    .line 176
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://welaf.com/fun/stat.php?type=gallery&serial="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 177
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->detailserial:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&page=1"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 176
    iput-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->url:Ljava/lang/String;

    .line 178
    new-instance v0, Lcom/aio/downloader/activity/FunImagePagerActivity$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/FunImagePagerActivity$2;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity;)V

    .line 187
    invoke-virtual {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity$2;->start()V

    .line 189
    :cond_0
    iget v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->detailcount:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 190
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->tv_detail_jingdu:Landroid/widget/TextView;

    const-string v1, "1/1"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 194
    :goto_0
    return-void

    .line 192
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->tv_detail_jingdu:Landroid/widget/TextView;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "1/"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->detailcount:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method public onDismissScreen(Lcom/google/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/google/ads/Ad;

    .prologue
    .line 620
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 3
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 678
    const-string v0, "qwer"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Lcom/facebook/ads/AdError;->getErrorMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "++++++"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 679
    return-void
.end method

.method public onFailedToReceiveAd(Lcom/google/ads/Ad;Lcom/google/ads/AdRequest$ErrorCode;)V
    .locals 0
    .param p1, "arg0"    # Lcom/google/ads/Ad;
    .param p2, "arg1"    # Lcom/google/ads/AdRequest$ErrorCode;

    .prologue
    .line 626
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 610
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 611
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->finish()V

    .line 613
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public onLeaveApplication(Lcom/google/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/google/ads/Ad;

    .prologue
    .line 632
    return-void
.end method

.method public onPageScrollStateChanged(I)V
    .locals 0
    .param p1, "arg0"    # I

    .prologue
    .line 416
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 0
    .param p1, "arg0"    # I
    .param p2, "arg1"    # F
    .param p3, "arg2"    # I

    .prologue
    .line 422
    return-void
.end method

.method public onPageSelected(I)V
    .locals 7
    .param p1, "arg0"    # I

    .prologue
    .line 426
    iget-object v4, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->iv_fun_likeshow:Landroid/widget/ImageView;

    const v5, 0x7f0200b9

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 427
    const/4 v4, 0x1

    iput v4, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->dPicture:I

    .line 428
    iget-object v4, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->list:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 429
    .local v2, "str":[Ljava/lang/String;
    array-length v4, v2

    add-int/lit8 v4, v4, -0x1

    aget-object v1, v2, v4

    .line 430
    .local v1, "s1":Ljava/lang/String;
    const-string v4, ".jpg"

    invoke-virtual {v1, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 431
    .local v3, "str2":[Ljava/lang/String;
    const/4 v4, 0x0

    aget-object v4, v3, v4

    iput-object v4, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->picture_name:Ljava/lang/String;

    .line 432
    iget-object v4, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->lf_fun_download:Lcom/aio/downloader/views/LFrameLayout;

    new-instance v5, Lcom/aio/downloader/activity/FunImagePagerActivity$5;

    invoke-direct {v5, p0, p1}, Lcom/aio/downloader/activity/FunImagePagerActivity$5;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity;I)V

    invoke-virtual {v4, v5}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 444
    iget-object v4, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->lf_fun_like:Lcom/aio/downloader/views/LFrameLayout;

    new-instance v5, Lcom/aio/downloader/activity/FunImagePagerActivity$6;

    invoke-direct {v5, p0}, Lcom/aio/downloader/activity/FunImagePagerActivity$6;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity;)V

    invoke-virtual {v4, v5}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 466
    iget-object v4, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->lf_fun_share:Lcom/aio/downloader/views/LFrameLayout;

    new-instance v5, Lcom/aio/downloader/activity/FunImagePagerActivity$7;

    invoke-direct {v5, p0}, Lcom/aio/downloader/activity/FunImagePagerActivity$7;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity;)V

    invoke-virtual {v4, v5}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 493
    iput p1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->screenshotpos:I

    .line 494
    iget-object v4, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->tv_detail_jingdu:Landroid/widget/TextView;

    new-instance v5, Ljava/lang/StringBuilder;

    add-int/lit8 v6, p1, 0x1

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, "/"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget v6, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->detailcount:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 495
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "http://welaf.com/fun/stat.php?type=gallery&serial="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 496
    iget-object v5, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->detailserial:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "&page="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    add-int/lit8 v5, p1, 0x1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 495
    iput-object v4, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->url_gallery:Ljava/lang/String;

    .line 497
    new-instance v4, Lcom/aio/downloader/activity/FunImagePagerActivity$8;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/FunImagePagerActivity$8;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity;)V

    .line 507
    invoke-virtual {v4}, Lcom/aio/downloader/activity/FunImagePagerActivity$8;->start()V

    .line 508
    const/4 v4, 0x5

    if-eq p1, v4, :cond_0

    const/16 v4, 0xa

    if-eq p1, v4, :cond_0

    const/16 v4, 0x14

    if-eq p1, v4, :cond_0

    const/16 v4, 0x28

    if-ne p1, v4, :cond_1

    .line 509
    :cond_0
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 510
    const-class v5, Lcom/aio/downloader/activity/FunChapingActivity;

    .line 509
    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 511
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v0, v4}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 512
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->startActivity(Landroid/content/Intent;)V

    .line 515
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_1
    add-int/lit8 v4, p1, 0x1

    rem-int/lit8 v4, v4, 0xa

    if-nez v4, :cond_2

    .line 516
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 517
    const v5, 0x7f040017

    .line 516
    invoke-static {v4, v5}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->shake:Landroid/view/animation/Animation;

    .line 518
    iget-object v4, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->ll_mygift:Landroid/widget/LinearLayout;

    iget-object v5, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->shake:Landroid/view/animation/Animation;

    invoke-virtual {v4, v5}, Landroid/widget/LinearLayout;->setAnimation(Landroid/view/animation/Animation;)V

    .line 519
    iget-object v4, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->ll_mygift_gallery:Landroid/widget/LinearLayout;

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->getVisibility()I

    move-result v4

    if-nez v4, :cond_2

    .line 520
    iget-object v4, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->ll_mygift_gallery:Landroid/widget/LinearLayout;

    iget-object v5, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->shake:Landroid/view/animation/Animation;

    invoke-virtual {v4, v5}, Landroid/widget/LinearLayout;->setAnimation(Landroid/view/animation/Animation;)V

    .line 523
    :cond_2
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 604
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 605
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 606
    return-void
.end method

.method public onPresentScreen(Lcom/google/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/google/ads/Ad;

    .prologue
    .line 638
    return-void
.end method

.method public onReceiveAd(Lcom/google/ads/Ad;)V
    .locals 1
    .param p1, "arg0"    # Lcom/google/ads/Ad;

    .prologue
    .line 643
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->interstitial:Lcom/google/ads/InterstitialAd;

    if-ne p1, v0, :cond_0

    .line 644
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->interstitial:Lcom/google/ads/InterstitialAd;

    invoke-virtual {v0}, Lcom/google/ads/InterstitialAd;->show()V

    .line 646
    :cond_0
    return-void
.end method

.method protected onResume()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 528
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 529
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 530
    iget v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->dPicture:I

    if-nez v3, :cond_0

    .line 532
    iget-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->list:Ljava/util/ArrayList;

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 533
    .local v1, "str":[Ljava/lang/String;
    array-length v3, v1

    add-int/lit8 v3, v3, -0x1

    aget-object v0, v1, v3

    .line 534
    .local v0, "s1":Ljava/lang/String;
    const-string v3, ".jpg"

    invoke-virtual {v0, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 535
    .local v2, "str2":[Ljava/lang/String;
    aget-object v3, v2, v5

    iput-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->picture_name:Ljava/lang/String;

    .line 536
    iget-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->lf_fun_download:Lcom/aio/downloader/views/LFrameLayout;

    new-instance v4, Lcom/aio/downloader/activity/FunImagePagerActivity$9;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/FunImagePagerActivity$9;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity;)V

    invoke-virtual {v3, v4}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 547
    iget-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->lf_fun_like:Lcom/aio/downloader/views/LFrameLayout;

    new-instance v4, Lcom/aio/downloader/activity/FunImagePagerActivity$10;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/FunImagePagerActivity$10;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity;)V

    invoke-virtual {v3, v4}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 569
    iget-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity;->lf_fun_share:Lcom/aio/downloader/views/LFrameLayout;

    new-instance v4, Lcom/aio/downloader/activity/FunImagePagerActivity$11;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/FunImagePagerActivity$11;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity;)V

    invoke-virtual {v3, v4}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 599
    .end local v0    # "s1":Ljava/lang/String;
    .end local v1    # "str":[Ljava/lang/String;
    .end local v2    # "str2":[Ljava/lang/String;
    :cond_0
    return-void
.end method
