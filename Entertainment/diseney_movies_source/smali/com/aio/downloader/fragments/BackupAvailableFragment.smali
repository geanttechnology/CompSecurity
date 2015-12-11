.class public Lcom/aio/downloader/fragments/BackupAvailableFragment;
.super Landroid/support/v4/app/Fragment;
.source "BackupAvailableFragment.java"

# interfaces
.implements Lcom/facebook/ads/AdListener;


# instance fields
.field adView:Lcom/google/ads/AdView;

.field private adapter:Lcom/aio/downloader/unstall/BackupAdapter;

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
    .line 40
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 42
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->infos:Ljava/util/List;

    .line 40
    return-void
.end method

.method private facebookad()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 164
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackupAvailableFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const v4, 0x7f03003e

    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 166
    .local v2, "viewtop":Landroid/view/View;
    iget-object v3, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->lv_uninstall:Landroid/widget/ListView;

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
    iget-object v3, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3}, Lcom/facebook/ads/NativeAd;->getAdCoverImage()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 171
    .local v0, "adCover":Lcom/facebook/ads/NativeAd$Image;
    invoke-static {v0, v1}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 173
    iget-object v3, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

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
    .line 145
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 158
    :cond_0
    :goto_0
    return-void

    .line 150
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 154
    :try_start_0
    invoke-direct {p0}, Lcom/aio/downloader/fragments/BackupAvailableFragment;->facebookad()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 155
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 14
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 52
    const v10, 0x7f0300b6

    const/4 v11, 0x0

    const/4 v12, 0x0

    invoke-virtual {p1, v10, v11, v12}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v9

    .line 55
    .local v9, "view":Landroid/view/View;
    const v10, 0x7f0703dd

    invoke-virtual {v9, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/LinearLayout;

    iput-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->adviewscanner:Landroid/widget/LinearLayout;

    .line 56
    new-instance v10, Lcom/google/ads/AdView;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackupAvailableFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v11

    sget-object v12, Lcom/google/ads/AdSize;->SMART_BANNER:Lcom/google/ads/AdSize;

    .line 57
    const-string v13, "ca-app-pub-2192624499353475/5842010949"

    invoke-direct {v10, v11, v12, v13}, Lcom/google/ads/AdView;-><init>(Landroid/app/Activity;Lcom/google/ads/AdSize;Ljava/lang/String;)V

    .line 56
    iput-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->adView:Lcom/google/ads/AdView;

    .line 58
    iget-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->adviewscanner:Landroid/widget/LinearLayout;

    iget-object v11, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->adView:Lcom/google/ads/AdView;

    invoke-virtual {v10, v11}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 59
    iget-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->adView:Lcom/google/ads/AdView;

    new-instance v11, Lcom/google/ads/AdRequest;

    invoke-direct {v11}, Lcom/google/ads/AdRequest;-><init>()V

    invoke-virtual {v10, v11}, Lcom/google/ads/AdView;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 61
    new-instance v10, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackupAvailableFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v11

    const-string v12, "340186902832477_388101491374351"

    invoke-direct {v10, v11, v12}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 62
    iget-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v10, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 63
    iget-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    sget-object v11, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v10, v11}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 66
    const v10, 0x7f0703d8

    invoke-virtual {v9, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .line 65
    check-cast v6, Landroid/widget/LinearLayout;

    .line 67
    .local v6, "ll_top_backup":Landroid/widget/LinearLayout;
    const/16 v10, 0x8

    invoke-virtual {v6, v10}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 68
    const v10, 0x7f0703da

    invoke-virtual {v9, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/ListView;

    iput-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->lv_uninstall:Landroid/widget/ListView;

    .line 69
    const v10, 0x7f0703dc

    invoke-virtual {v9, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    .line 70
    .local v5, "ll_root":Landroid/widget/LinearLayout;
    invoke-static {}, Lcom/stericson/RootTools/RootTools;->isRootAvailable()Z

    move-result v10

    if-eqz v10, :cond_0

    .line 71
    iget-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->lv_uninstall:Landroid/widget/ListView;

    const/4 v11, 0x0

    invoke-virtual {v10, v11}, Landroid/widget/ListView;->setVisibility(I)V

    .line 72
    const/16 v10, 0x8

    invoke-virtual {v5, v10}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 78
    :goto_0
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackupAvailableFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v10

    invoke-virtual {v10}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v7

    .line 80
    .local v7, "pm":Landroid/content/pm/PackageManager;
    const/16 v10, 0x2000

    invoke-virtual {v7, v10}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v0

    .line 81
    .local v0, "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    const/4 v1, 0x0

    .line 82
    .local v1, "appInfo":Landroid/content/pm/ApplicationInfo;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v10

    if-lt v3, v10, :cond_1

    .line 109
    const-string v10, "qqq"

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "infos.size()="

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v12, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->infos:Ljava/util/List;

    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 110
    const/4 v3, 0x0

    :goto_2
    iget-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->infos:Ljava/util/List;

    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v10

    if-lt v3, v10, :cond_5

    .line 113
    new-instance v10, Lcom/aio/downloader/unstall/BackupAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackupAvailableFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v11

    iget-object v12, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->infos:Ljava/util/List;

    invoke-direct {v10, v11, v12}, Lcom/aio/downloader/unstall/BackupAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    iput-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->adapter:Lcom/aio/downloader/unstall/BackupAdapter;

    .line 114
    new-instance v8, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 115
    iget-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->adapter:Lcom/aio/downloader/unstall/BackupAdapter;

    .line 114
    invoke-direct {v8, v10}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 116
    .local v8, "swingBottomInAnimationAdapter":Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;
    iget-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->lv_uninstall:Landroid/widget/ListView;

    invoke-virtual {v8, v10}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 117
    iget-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->lv_uninstall:Landroid/widget/ListView;

    invoke-virtual {v10, v8}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 119
    return-object v9

    .line 74
    .end local v0    # "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    .end local v1    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v3    # "i":I
    .end local v7    # "pm":Landroid/content/pm/PackageManager;
    .end local v8    # "swingBottomInAnimationAdapter":Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;
    :cond_0
    iget-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->lv_uninstall:Landroid/widget/ListView;

    const/16 v11, 0x8

    invoke-virtual {v10, v11}, Landroid/widget/ListView;->setVisibility(I)V

    .line 75
    const/4 v10, 0x0

    invoke-virtual {v5, v10}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0

    .line 83
    .restart local v0    # "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    .restart local v1    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .restart local v3    # "i":I
    .restart local v7    # "pm":Landroid/content/pm/PackageManager;
    :cond_1
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/content/pm/ApplicationInfo;

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/content/pm/ApplicationInfo;

    iget v10, v10, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v10, v10, 0x1

    if-nez v10, :cond_3

    .line 84
    new-instance v4, Lcom/aio/downloader/unstall/Info;

    invoke-direct {v4}, Lcom/aio/downloader/unstall/Info;-><init>()V

    .line 85
    .local v4, "info":Lcom/aio/downloader/unstall/Info;
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v7, v10}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v10

    invoke-interface {v10}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Lcom/aio/downloader/unstall/Info;->setName(Ljava/lang/String;)V

    .line 86
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v10, v7}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v10

    invoke-virtual {v4, v10}, Lcom/aio/downloader/unstall/Info;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 87
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/content/pm/ApplicationInfo;

    iget-object v10, v10, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v4, v10}, Lcom/aio/downloader/unstall/Info;->setPackagename(Ljava/lang/String;)V

    .line 90
    :try_start_0
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/content/pm/ApplicationInfo;

    iget-object v10, v10, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const/4 v11, 0x0

    invoke-virtual {v7, v10, v11}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 95
    :goto_3
    iget v10, v1, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v11, 0x40000

    and-int/2addr v10, v11

    if-eqz v10, :cond_4

    .line 97
    const-string v10, "qqq"

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "infos.size()="

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v12, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->infos:Ljava/util/List;

    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 105
    :cond_2
    :goto_4
    sget-object v11, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/content/pm/ApplicationInfo;

    iget-object v10, v10, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    invoke-static {v10}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v12, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, "============"

    invoke-virtual {v12, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v11, v10}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 82
    .end local v4    # "info":Lcom/aio/downloader/unstall/Info;
    :cond_3
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_1

    .line 91
    .restart local v4    # "info":Lcom/aio/downloader/unstall/Info;
    :catch_0
    move-exception v2

    .line 93
    .local v2, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v2}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 99
    .end local v2    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_4
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/content/pm/ApplicationInfo;

    iget-object v10, v10, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const-string v11, "com.aio.downloader"

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_2

    .line 100
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/content/pm/ApplicationInfo;

    iget-object v10, v10, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    .line 101
    const-string v11, "com.evzapp.cleanmaster"

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_2

    .line 102
    iget-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->infos:Ljava/util/List;

    invoke-interface {v10, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 111
    .end local v4    # "info":Lcom/aio/downloader/unstall/Info;
    :cond_5
    sget-object v11, Ljava/lang/System;->out:Ljava/io/PrintStream;

    iget-object v10, p0, Lcom/aio/downloader/fragments/BackupAvailableFragment;->infos:Ljava/util/List;

    invoke-interface {v10, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v10}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v11, v10}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 110
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_2
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 180
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 132
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 133
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackupAvailableFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 134
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 125
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 126
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackupAvailableFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 127
    return-void
.end method
