.class public Lcom/aio/downloader/fragments/FungagFragment;
.super Landroid/support/v4/app/Fragment;
.source "FungagFragment.java"

# interfaces
.implements Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;
.implements Lcom/aio/downloader/mydownload/ContentValue;
.implements Lcom/facebook/ads/AdListener;
.implements Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/fragments/FungagFragment$Mya1;
    }
.end annotation


# instance fields
.field private adView:Lcom/facebook/ads/AdView;

.field private fd_errer:Z

.field private list:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/FunModel;",
            ">;"
        }
    .end annotation
.end field

.field private lv_fun_adult:Lcom/aio/downloader/refresh/PullableListView_load;

.field private nativeAd:Lcom/facebook/ads/NativeAd;

.field private next:I

.field private page:I

.field private progress_wheel_fun:Lcom/aio/downloader/utils/ProgressWheel;

.field private swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 34
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 39
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/fragments/FungagFragment;->list:Ljava/util/ArrayList;

    .line 40
    iput v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->page:I

    .line 41
    iput v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->next:I

    .line 34
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/FungagFragment;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/aio/downloader/fragments/FungagFragment;->progress_wheel_fun:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/fragments/FungagFragment;)I
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/aio/downloader/fragments/FungagFragment;->page:I

    return v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/fragments/FungagFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/aio/downloader/fragments/FungagFragment;->list:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/fragments/FungagFragment;)Lcom/facebook/ads/NativeAd;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/aio/downloader/fragments/FungagFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/fragments/FungagFragment;)Z
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/aio/downloader/fragments/FungagFragment;->fd_errer:Z

    return v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/fragments/FungagFragment;Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/aio/downloader/fragments/FungagFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/fragments/FungagFragment;)Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/aio/downloader/fragments/FungagFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/fragments/FungagFragment;)Lcom/aio/downloader/refresh/PullableListView_load;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/aio/downloader/fragments/FungagFragment;->lv_fun_adult:Lcom/aio/downloader/refresh/PullableListView_load;

    return-object v0
.end method


# virtual methods
.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 139
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 144
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/fragments/FungagFragment;->fd_errer:Z

    .line 145
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v5, 0x0

    .line 50
    const v1, 0x7f030048

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 51
    .local v0, "view":Landroid/view/View;
    const v1, 0x7f0701f1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/refresh/PullableListView_load;

    iput-object v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->lv_fun_adult:Lcom/aio/downloader/refresh/PullableListView_load;

    .line 53
    const v1, 0x7f0701f2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/utils/ProgressWheel;

    .line 52
    iput-object v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->progress_wheel_fun:Lcom/aio/downloader/utils/ProgressWheel;

    .line 54
    new-instance v1, Lcom/facebook/ads/AdView;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/FungagFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const-string v3, "340186902832477_411793852338448"

    sget-object v4, Lcom/facebook/ads/AdSize;->RECTANGLE_HEIGHT_250:Lcom/facebook/ads/AdSize;

    invoke-direct {v1, v2, v3, v4}, Lcom/facebook/ads/AdView;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/ads/AdSize;)V

    iput-object v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->adView:Lcom/facebook/ads/AdView;

    .line 55
    new-instance v1, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/FungagFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    .line 56
    const-string v3, "340186902832477_411793852338448"

    invoke-direct {v1, v2, v3}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 55
    iput-object v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 57
    iget-object v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v1, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 58
    iget-object v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    sget-object v2, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v1, v2}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 59
    iget-object v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->lv_fun_adult:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v1, p0}, Lcom/aio/downloader/refresh/PullableListView_load;->setOnLoadListener(Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;)V

    .line 60
    iget-object v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->lv_fun_adult:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v1, v5}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    .line 61
    new-instance v1, Lcom/aio/downloader/fragments/FungagFragment$Mya1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/FungagFragment$Mya1;-><init>(Lcom/aio/downloader/fragments/FungagFragment;)V

    new-array v2, v5, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/fragments/FungagFragment$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 63
    return-object v0
.end method

.method public onDismiss(Landroid/widget/ListView;[I)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;
    .param p2, "reverseSortedPositions"    # [I

    .prologue
    .line 119
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 151
    return-void
.end method

.method public onLoad(Lcom/aio/downloader/refresh/PullableListView_load;)V
    .locals 4
    .param p1, "pullableListView"    # Lcom/aio/downloader/refresh/PullableListView_load;

    .prologue
    const/4 v3, 0x0

    .line 157
    const-string v1, "www"

    const-string v2, "onLoad"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 158
    iget-object v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->list:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 159
    iget-object v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->list:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/aio/downloader/fragments/FungagFragment;->list:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/FunModel;

    .line 160
    .local v0, "model":Lcom/aio/downloader/model/FunModel;
    invoke-virtual {v0}, Lcom/aio/downloader/model/FunModel;->getHas_next_page()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->next:I

    .line 163
    .end local v0    # "model":Lcom/aio/downloader/model/FunModel;
    :cond_0
    iget v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->next:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    .line 164
    iget v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->page:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->page:I

    .line 165
    new-instance v1, Lcom/aio/downloader/fragments/FungagFragment$Mya1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/FungagFragment$Mya1;-><init>(Lcom/aio/downloader/fragments/FungagFragment;)V

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/fragments/FungagFragment$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 170
    :goto_0
    return-void

    .line 167
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/fragments/FungagFragment;->lv_fun_adult:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 131
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 132
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/FungagFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 133
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 124
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 125
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/FungagFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 126
    return-void
.end method
