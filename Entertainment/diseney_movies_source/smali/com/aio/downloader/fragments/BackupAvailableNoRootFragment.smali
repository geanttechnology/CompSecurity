.class public Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;
.super Landroid/support/v4/app/Fragment;
.source "BackupAvailableNoRootFragment.java"

# interfaces
.implements Lcom/facebook/ads/AdListener;


# instance fields
.field adView:Lcom/google/ads/AdView;

.field private adapter:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

.field adviewscanner:Landroid/widget/LinearLayout;

.field private infos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/unstall/Info;",
            ">;"
        }
    .end annotation
.end field

.field private lv_uninstall:Landroid/widget/ListView;

.field private nativeAd:Lcom/facebook/ads/NativeAd;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 41
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 43
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->infos:Ljava/util/List;

    .line 41
    return-void
.end method

.method private facebookad()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 163
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    .line 164
    const v4, 0x7f03003e

    .line 163
    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 166
    .local v2, "viewtop":Landroid/view/View;
    iget-object v3, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->lv_uninstall:Landroid/widget/ListView;

    const/4 v4, 0x0

    invoke-virtual {v3, v2, v5, v4}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 168
    const v3, 0x7f0701a6

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 167
    check-cast v1, Landroid/widget/ImageView;

    .line 170
    .local v1, "iv_fb_fragment":Landroid/widget/ImageView;
    iget-object v3, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3}, Lcom/facebook/ads/NativeAd;->getAdCoverImage()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 171
    .local v0, "adCover":Lcom/facebook/ads/NativeAd$Image;
    invoke-static {v0, v1}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 173
    iget-object v3, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 174
    return-void
.end method


# virtual methods
.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 140
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 144
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 157
    :cond_0
    :goto_0
    return-void

    .line 149
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 153
    :try_start_0
    invoke-direct {p0}, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->facebookad()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 154
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 13
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 53
    const v9, 0x7f0300b6

    const/4 v10, 0x0

    const/4 v11, 0x0

    invoke-virtual {p1, v9, v10, v11}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v8

    .line 56
    .local v8, "view":Landroid/view/View;
    const v9, 0x7f0703dd

    invoke-virtual {v8, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/LinearLayout;

    iput-object v9, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->adviewscanner:Landroid/widget/LinearLayout;

    .line 57
    new-instance v9, Lcom/google/ads/AdView;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    sget-object v11, Lcom/google/ads/AdSize;->SMART_BANNER:Lcom/google/ads/AdSize;

    .line 58
    const-string v12, "ca-app-pub-2192624499353475/5842010949"

    invoke-direct {v9, v10, v11, v12}, Lcom/google/ads/AdView;-><init>(Landroid/app/Activity;Lcom/google/ads/AdSize;Ljava/lang/String;)V

    .line 57
    iput-object v9, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->adView:Lcom/google/ads/AdView;

    .line 59
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->adviewscanner:Landroid/widget/LinearLayout;

    iget-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->adView:Lcom/google/ads/AdView;

    invoke-virtual {v9, v10}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 60
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->adView:Lcom/google/ads/AdView;

    new-instance v10, Lcom/google/ads/AdRequest;

    invoke-direct {v10}, Lcom/google/ads/AdRequest;-><init>()V

    invoke-virtual {v9, v10}, Lcom/google/ads/AdView;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 62
    new-instance v9, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    const-string v11, "340186902832477_388101491374351"

    invoke-direct {v9, v10, v11}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v9, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 63
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v9, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 64
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    sget-object v10, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v9, v10}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 67
    const v9, 0x7f0703d8

    invoke-virtual {v8, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    .line 68
    .local v5, "ll_top_backup":Landroid/widget/LinearLayout;
    const/16 v9, 0x8

    invoke-virtual {v5, v9}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 69
    const v9, 0x7f0703da

    invoke-virtual {v8, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/ListView;

    iput-object v9, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->lv_uninstall:Landroid/widget/ListView;

    .line 81
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v9

    invoke-virtual {v9}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 83
    .local v6, "pm":Landroid/content/pm/PackageManager;
    const/16 v9, 0x2000

    invoke-virtual {v6, v9}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v0

    .line 84
    .local v0, "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    const/4 v1, 0x0

    .line 85
    .local v1, "appInfo":Landroid/content/pm/ApplicationInfo;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v9

    if-lt v3, v9, :cond_0

    .line 112
    const-string v9, "qqq"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "infos.size()="

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v11, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->infos:Ljava/util/List;

    invoke-interface {v11}, Ljava/util/List;->size()I

    move-result v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 113
    const/4 v3, 0x0

    :goto_1
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->infos:Ljava/util/List;

    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v9

    if-lt v3, v9, :cond_4

    .line 116
    new-instance v9, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    iget-object v11, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->infos:Ljava/util/List;

    invoke-direct {v9, v10, v11}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;-><init>(Landroid/content/Context;Ljava/util/List;)V

    iput-object v9, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->adapter:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    .line 117
    new-instance v7, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 118
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->adapter:Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;

    .line 117
    invoke-direct {v7, v9}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 119
    .local v7, "swingBottomInAnimationAdapter":Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->lv_uninstall:Landroid/widget/ListView;

    invoke-virtual {v7, v9}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 120
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->lv_uninstall:Landroid/widget/ListView;

    invoke-virtual {v9, v7}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 122
    return-object v8

    .line 86
    .end local v7    # "swingBottomInAnimationAdapter":Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;
    :cond_0
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ApplicationInfo;

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ApplicationInfo;

    iget v9, v9, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v9, v9, 0x1

    if-nez v9, :cond_2

    .line 87
    new-instance v4, Lcom/aio/downloader/unstall/Info;

    invoke-direct {v4}, Lcom/aio/downloader/unstall/Info;-><init>()V

    .line 88
    .local v4, "info":Lcom/aio/downloader/unstall/Info;
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v6, v9}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v9

    invoke-interface {v9}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v4, v9}, Lcom/aio/downloader/unstall/Info;->setName(Ljava/lang/String;)V

    .line 89
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v9, v6}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v9

    invoke-virtual {v4, v9}, Lcom/aio/downloader/unstall/Info;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 90
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ApplicationInfo;

    iget-object v9, v9, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v4, v9}, Lcom/aio/downloader/unstall/Info;->setPackagename(Ljava/lang/String;)V

    .line 93
    :try_start_0
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ApplicationInfo;

    iget-object v9, v9, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const/4 v10, 0x0

    invoke-virtual {v6, v9, v10}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 98
    :goto_2
    iget v9, v1, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v10, 0x40000

    and-int/2addr v9, v10

    if-eqz v9, :cond_3

    .line 100
    const-string v9, "qqq"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "infos.size()="

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v11, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->infos:Ljava/util/List;

    invoke-interface {v11}, Ljava/util/List;->size()I

    move-result v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 108
    :cond_1
    :goto_3
    sget-object v10, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ApplicationInfo;

    iget-object v9, v9, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v11, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v9, "============"

    invoke-virtual {v11, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v10, v9}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 85
    .end local v4    # "info":Lcom/aio/downloader/unstall/Info;
    :cond_2
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_0

    .line 94
    .restart local v4    # "info":Lcom/aio/downloader/unstall/Info;
    :catch_0
    move-exception v2

    .line 96
    .local v2, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v2}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 102
    .end local v2    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_3
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ApplicationInfo;

    iget-object v9, v9, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const-string v10, "com.aio.downloader"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_1

    .line 103
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ApplicationInfo;

    iget-object v9, v9, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    .line 104
    const-string v10, "com.evzapp.cleanmaster"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_1

    .line 105
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->infos:Ljava/util/List;

    invoke-interface {v9, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 114
    .end local v4    # "info":Lcom/aio/downloader/unstall/Info;
    :cond_4
    sget-object v10, Ljava/lang/System;->out:Ljava/io/PrintStream;

    iget-object v9, p0, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->infos:Ljava/util/List;

    invoke-interface {v9, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v9}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v10, v9}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 113
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_1
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 179
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 133
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 134
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 135
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 127
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 128
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackupAvailableNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 129
    return-void
.end method
