.class Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;
.super Landroid/support/v4/view/PagerAdapter;
.source "FunImagePagerActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/FunImagePagerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MyPageAdapter"
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z


# instance fields
.field private adView:Lcom/google/ads/AdView;

.field list:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 321
    const-class v0, Lcom/aio/downloader/activity/FunImagePagerActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->$assertionsDisabled:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Lcom/aio/downloader/activity/FunImagePagerActivity;Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 325
    .local p2, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    .line 326
    iput-object p2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->list:Ljava/util/ArrayList;

    .line 327
    invoke-virtual {p1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$1(Lcom/aio/downloader/activity/FunImagePagerActivity;Landroid/view/LayoutInflater;)V

    .line 329
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;)Lcom/aio/downloader/activity/FunImagePagerActivity;
    .locals 1

    .prologue
    .line 321
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    return-object v0
.end method


# virtual methods
.method public destroyItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V
    .locals 1
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I
    .param p3, "object"    # Ljava/lang/Object;

    .prologue
    .line 343
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$2(Lcom/aio/downloader/activity/FunImagePagerActivity;)Lcom/aio/downloader/pager/JazzyViewPager;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/aio/downloader/pager/JazzyViewPager;->findViewFromObject(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 344
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 334
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->list:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->list:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_1

    .line 335
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->list:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 337
    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->list:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    goto :goto_0
.end method

.method public instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
    .locals 7
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I

    .prologue
    const/4 v6, -0x1

    .line 348
    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->inflater:Landroid/view/LayoutInflater;
    invoke-static {v2}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$3(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/view/LayoutInflater;

    move-result-object v2

    const v3, 0x7f030059

    .line 349
    const/4 v4, 0x0

    .line 348
    invoke-virtual {v2, v3, p1, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 350
    .local v0, "imageLayout":Landroid/view/View;
    sget-boolean v2, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->$assertionsDisabled:Z

    if-nez v2, :cond_0

    if-nez v0, :cond_0

    new-instance v2, Ljava/lang/AssertionError;

    invoke-direct {v2}, Ljava/lang/AssertionError;-><init>()V

    throw v2

    .line 351
    :cond_0
    const-string v2, "qwer"

    const-string v3, "fdfdfdf"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 353
    const v2, 0x7f070245

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 352
    check-cast v1, Landroid/widget/ImageView;

    .line 354
    .local v1, "imageView":Landroid/widget/ImageView;
    iget-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    .line 355
    const v2, 0x7f070246

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 354
    invoke-static {v3, v2}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$4(Lcom/aio/downloader/activity/FunImagePagerActivity;Landroid/widget/LinearLayout;)V

    .line 356
    new-instance v2, Lcom/google/ads/AdView;

    iget-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    .line 357
    sget-object v4, Lcom/google/ads/AdSize;->SMART_BANNER:Lcom/google/ads/AdSize;

    .line 358
    const-string v5, "ca-app-pub-2192624499353475/1272210540"

    invoke-direct {v2, v3, v4, v5}, Lcom/google/ads/AdView;-><init>(Landroid/app/Activity;Lcom/google/ads/AdSize;Ljava/lang/String;)V

    .line 356
    iput-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->adView:Lcom/google/ads/AdView;

    .line 359
    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->appbanner:Landroid/widget/LinearLayout;
    invoke-static {v2}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$5(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/widget/LinearLayout;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->adView:Lcom/google/ads/AdView;

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 360
    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->adView:Lcom/google/ads/AdView;

    new-instance v3, Lcom/google/ads/AdRequest;

    invoke-direct {v3}, Lcom/google/ads/AdRequest;-><init>()V

    invoke-virtual {v2, v3}, Lcom/google/ads/AdView;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 362
    const-string v2, "qwer"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "adView="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->adView:Lcom/google/ads/AdView;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 363
    new-instance v2, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter$1;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 385
    const-string v3, "picture"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v2, "++++++list.get(position)="

    invoke-direct {v4, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->list:Ljava/util/ArrayList;

    invoke-virtual {v2, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 387
    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-static {v2}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$10(Lcom/aio/downloader/activity/FunImagePagerActivity;)Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v3

    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->list:Ljava/util/ArrayList;

    invoke-virtual {v2, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v3, v2, v1}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage1(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 390
    check-cast p1, Lcom/aio/downloader/pager/JazzyViewPager;

    .end local p1    # "container":Landroid/view/ViewGroup;
    invoke-virtual {p1, v0, v6, v6}, Lcom/aio/downloader/pager/JazzyViewPager;->addView(Landroid/view/View;II)V

    .line 392
    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;
    invoke-static {v2}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$2(Lcom/aio/downloader/activity/FunImagePagerActivity;)Lcom/aio/downloader/pager/JazzyViewPager;

    move-result-object v2

    invoke-virtual {v2, v0, p2}, Lcom/aio/downloader/pager/JazzyViewPager;->setObjectForPosition(Ljava/lang/Object;I)V

    .line 398
    return-object v0
.end method

.method public isViewFromObject(Landroid/view/View;Ljava/lang/Object;)Z
    .locals 3
    .param p1, "view"    # Landroid/view/View;
    .param p2, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 404
    instance-of v2, p1, Lcom/aio/downloader/pager/OutlineContainer;

    if-eqz v2, :cond_2

    .line 405
    check-cast p1, Lcom/aio/downloader/pager/OutlineContainer;

    .end local p1    # "view":Landroid/view/View;
    invoke-virtual {p1, v1}, Lcom/aio/downloader/pager/OutlineContainer;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    if-ne v2, p2, :cond_1

    .line 407
    :cond_0
    :goto_0
    return v0

    :cond_1
    move v0, v1

    .line 405
    goto :goto_0

    .line 407
    .restart local p1    # "view":Landroid/view/View;
    :cond_2
    if-eq p1, p2, :cond_0

    move v0, v1

    goto :goto_0
.end method
