.class Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;
.super Landroid/support/v4/view/PagerAdapter;
.source "ImagePagerActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/ImagePagerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MyPageAdapter"
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z


# instance fields
.field list:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/aio/downloader/activity/ImagePagerActivity;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 68
    const-class v0, Lcom/aio/downloader/activity/ImagePagerActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;->$assertionsDisabled:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Lcom/aio/downloader/activity/ImagePagerActivity;Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 71
    .local p2, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    iput-object p1, p0, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/ImagePagerActivity;

    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    .line 72
    iput-object p2, p0, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;->list:Ljava/util/ArrayList;

    .line 73
    invoke-virtual {p1}, Lcom/aio/downloader/activity/ImagePagerActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/aio/downloader/activity/ImagePagerActivity;->access$0(Lcom/aio/downloader/activity/ImagePagerActivity;Landroid/view/LayoutInflater;)V

    .line 75
    return-void
.end method


# virtual methods
.method public destroyItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V
    .locals 1
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I
    .param p3, "object"    # Ljava/lang/Object;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/ImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/ImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;
    invoke-static {v0}, Lcom/aio/downloader/activity/ImagePagerActivity;->access$1(Lcom/aio/downloader/activity/ImagePagerActivity;)Lcom/aio/downloader/pager/JazzyViewPager;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/aio/downloader/pager/JazzyViewPager;->findViewFromObject(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 90
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;->list:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;->list:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_1

    .line 81
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;->list:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 83
    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;->list:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    goto :goto_0
.end method

.method public instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
    .locals 8
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I

    .prologue
    const/4 v7, -0x1

    .line 94
    iget-object v4, p0, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/ImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/ImagePagerActivity;->inflater:Landroid/view/LayoutInflater;
    invoke-static {v4}, Lcom/aio/downloader/activity/ImagePagerActivity;->access$2(Lcom/aio/downloader/activity/ImagePagerActivity;)Landroid/view/LayoutInflater;

    move-result-object v4

    const v5, 0x7f030059

    .line 95
    const/4 v6, 0x0

    .line 94
    invoke-virtual {v4, v5, p1, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 96
    .local v0, "imageLayout":Landroid/view/View;
    sget-boolean v4, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;->$assertionsDisabled:Z

    if-nez v4, :cond_0

    if-nez v0, :cond_0

    new-instance v4, Ljava/lang/AssertionError;

    invoke-direct {v4}, Ljava/lang/AssertionError;-><init>()V

    throw v4

    .line 98
    :cond_0
    const v4, 0x7f070245

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 97
    check-cast v1, Landroid/widget/ImageView;

    .line 99
    .local v1, "imageView":Landroid/widget/ImageView;
    const-string v5, "www"

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v4, "list.get(position).getScreenshots()="

    invoke-direct {v6, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;->list:Ljava/util/ArrayList;

    invoke-virtual {v4, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getScreenshots()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v5, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 100
    iget-object v4, p0, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;->list:Ljava/util/ArrayList;

    invoke-virtual {v4, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getScreenshots()Ljava/lang/String;

    move-result-object v2

    .line 101
    .local v2, "path":Ljava/lang/String;
    const-string v4, "310"

    const-string v5, "900"

    invoke-virtual {v2, v4, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v3

    .line 102
    .local v3, "replace":Ljava/lang/String;
    const-string v4, "bbb"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "path="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\nreplace="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 103
    iget-object v4, p0, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/ImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/ImagePagerActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-static {v4}, Lcom/aio/downloader/activity/ImagePagerActivity;->access$3(Lcom/aio/downloader/activity/ImagePagerActivity;)Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v4

    invoke-virtual {v4, v3, v1}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage1(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 106
    check-cast p1, Lcom/aio/downloader/pager/JazzyViewPager;

    .end local p1    # "container":Landroid/view/ViewGroup;
    invoke-virtual {p1, v0, v7, v7}, Lcom/aio/downloader/pager/JazzyViewPager;->addView(Landroid/view/View;II)V

    .line 108
    iget-object v4, p0, Lcom/aio/downloader/activity/ImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/ImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/ImagePagerActivity;->viewPager:Lcom/aio/downloader/pager/JazzyViewPager;
    invoke-static {v4}, Lcom/aio/downloader/activity/ImagePagerActivity;->access$1(Lcom/aio/downloader/activity/ImagePagerActivity;)Lcom/aio/downloader/pager/JazzyViewPager;

    move-result-object v4

    invoke-virtual {v4, v0, p2}, Lcom/aio/downloader/pager/JazzyViewPager;->setObjectForPosition(Ljava/lang/Object;I)V

    .line 114
    return-object v0
.end method

.method public isViewFromObject(Landroid/view/View;Ljava/lang/Object;)Z
    .locals 3
    .param p1, "view"    # Landroid/view/View;
    .param p2, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 120
    instance-of v2, p1, Lcom/aio/downloader/pager/OutlineContainer;

    if-eqz v2, :cond_2

    .line 121
    check-cast p1, Lcom/aio/downloader/pager/OutlineContainer;

    .end local p1    # "view":Landroid/view/View;
    invoke-virtual {p1, v1}, Lcom/aio/downloader/pager/OutlineContainer;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    if-ne v2, p2, :cond_1

    .line 123
    :cond_0
    :goto_0
    return v0

    :cond_1
    move v0, v1

    .line 121
    goto :goto_0

    .line 123
    .restart local p1    # "view":Landroid/view/View;
    :cond_2
    if-eq p1, p2, :cond_0

    move v0, v1

    goto :goto_0
.end method
