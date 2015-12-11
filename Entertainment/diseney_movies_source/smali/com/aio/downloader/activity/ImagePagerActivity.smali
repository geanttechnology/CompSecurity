.class public Lcom/aio/downloader/activity/ImagePagerActivity;
.super Landroid/app/Activity;
.source "ImagePagerActivity.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;
    }
.end annotation


# instance fields
.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private inflater:Landroid/view/LayoutInflater;

.field private iv_detail_back:Landroid/widget/ImageView;

.field private list:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private screenshotpos:I

.field private viewPager:Lcom/aio/downloader/pager/JazzyViewPager;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/ImagePagerActivity;Landroid/view/LayoutInflater;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->inflater:Landroid/view/LayoutInflater;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/ImagePagerActivity;)Lcom/aio/downloader/pager/JazzyViewPager;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/ImagePagerActivity;)Landroid/view/LayoutInflater;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->inflater:Landroid/view/LayoutInflater;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/ImagePagerActivity;)Lcom/aio/downloader/mydownload/MyApplcation;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    return-object v0
.end method

.method private init()V
    .locals 4

    .prologue
    .line 48
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ImagePagerActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v1, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 49
    const v1, 0x7f070111

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/ImagePagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/pager/JazzyViewPager;

    iput-object v1, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;

    .line 50
    const v1, 0x7f070114

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/ImagePagerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->iv_detail_back:Landroid/widget/ImageView;

    .line 51
    iget-object v1, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->iv_detail_back:Landroid/widget/ImageView;

    new-instance v2, Lcom/aio/downloader/activity/ImagePagerActivity$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/ImagePagerActivity$1;-><init>(Lcom/aio/downloader/activity/ImagePagerActivity;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 59
    sget-object v0, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->Tablet:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    .line 60
    .local v0, "effect":Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;
    iget-object v1, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/pager/JazzyViewPager;->setTransitionEffect(Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;)V

    .line 62
    iget-object v1, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;

    invoke-virtual {v1, p0}, Lcom/aio/downloader/pager/JazzyViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 64
    iget-object v1, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;

    new-instance v2, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;

    iget-object v3, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->list:Ljava/util/ArrayList;

    invoke-direct {v2, p0, v3}, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;-><init>(Lcom/aio/downloader/activity/ImagePagerActivity;Ljava/util/ArrayList;)V

    invoke-virtual {v1, v2}, Lcom/aio/downloader/pager/JazzyViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 65
    iget-object v1, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;

    iget v2, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->screenshotpos:I

    invoke-virtual {v1, v2}, Lcom/aio/downloader/pager/JazzyViewPager;->setCurrentItem(I)V

    .line 66
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 39
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 40
    const v0, 0x7f03001d

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/ImagePagerActivity;->setContentView(I)V

    .line 41
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ImagePagerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 42
    const-string v1, "screenshotlist"

    .line 41
    invoke-virtual {v0, v1}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->list:Ljava/util/ArrayList;

    .line 43
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ImagePagerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "screenshotpos"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->screenshotpos:I

    .line 44
    invoke-direct {p0}, Lcom/aio/downloader/activity/ImagePagerActivity;->init()V

    .line 45
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 162
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 163
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ImagePagerActivity;->finish()V

    .line 165
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public onPageScrollStateChanged(I)V
    .locals 0
    .param p1, "arg0"    # I

    .prologue
    .line 132
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 0
    .param p1, "arg0"    # I
    .param p2, "arg1"    # F
    .param p3, "arg2"    # I

    .prologue
    .line 138
    return-void
.end method

.method public onPageSelected(I)V
    .locals 0
    .param p1, "arg0"    # I

    .prologue
    .line 142
    iput p1, p0, Lcom/aio/downloader/activity/ImagePagerActivity;->screenshotpos:I

    .line 144
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 156
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 157
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 158
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 149
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 150
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 151
    return-void
.end method
