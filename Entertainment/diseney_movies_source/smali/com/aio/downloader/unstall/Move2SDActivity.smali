.class public Lcom/aio/downloader/unstall/Move2SDActivity;
.super Landroid/app/Activity;
.source "Move2SDActivity.java"

# interfaces
.implements Lcom/facebook/ads/AdListener;


# instance fields
.field adView:Lcom/google/ads/AdView;

.field private adapter:Lcom/aio/downloader/unstall/Move2SDAdapter;

.field adviewscanner:Landroid/widget/LinearLayout;

.field private header_left_uninstall:Lcom/aio/downloader/views/LImageButton;

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

.field private isfa:Z

.field private isshow:Z

.field private lv_uninstall:Landroid/widget/ListView;

.field private nativeAd:Lcom/facebook/ads/NativeAd;

.field private tv_title_uninstall:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 36
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 37
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->infos:Ljava/util/List;

    .line 44
    iput-boolean v1, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->isfa:Z

    .line 45
    iput-boolean v1, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->isshow:Z

    .line 36
    return-void
.end method

.method private facebookad()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 181
    invoke-virtual {p0}, Lcom/aio/downloader/unstall/Move2SDActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 182
    const v4, 0x7f03003e

    .line 181
    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 184
    .local v2, "viewtop":Landroid/view/View;
    iget-object v3, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->lv_uninstall:Landroid/widget/ListView;

    const/4 v4, 0x0

    invoke-virtual {v3, v2, v5, v4}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 186
    const v3, 0x7f0701a6

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 185
    check-cast v1, Landroid/widget/ImageView;

    .line 188
    .local v1, "iv_fb_fragment":Landroid/widget/ImageView;
    iget-object v3, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3}, Lcom/facebook/ads/NativeAd;->getAdCoverImage()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 189
    .local v0, "adCover":Lcom/facebook/ads/NativeAd$Image;
    invoke-static {v0, v1}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 191
    iget-object v3, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 193
    return-void
.end method


# virtual methods
.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 156
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 161
    iget-object v0, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 175
    :cond_0
    :goto_0
    return-void

    .line 166
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 170
    :try_start_0
    invoke-direct {p0}, Lcom/aio/downloader/unstall/Move2SDActivity;->facebookad()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 174
    :goto_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->isfa:Z

    goto :goto_0

    .line 171
    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 10
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 51
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 52
    const v7, 0x7f0300b6

    invoke-virtual {p0, v7}, Lcom/aio/downloader/unstall/Move2SDActivity;->setContentView(I)V

    .line 55
    const v7, 0x7f0703dd

    invoke-virtual {p0, v7}, Lcom/aio/downloader/unstall/Move2SDActivity;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/LinearLayout;

    iput-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->adviewscanner:Landroid/widget/LinearLayout;

    .line 56
    new-instance v7, Lcom/google/ads/AdView;

    sget-object v8, Lcom/google/ads/AdSize;->SMART_BANNER:Lcom/google/ads/AdSize;

    .line 57
    const-string v9, "ca-app-pub-2192624499353475/5842010949"

    invoke-direct {v7, p0, v8, v9}, Lcom/google/ads/AdView;-><init>(Landroid/app/Activity;Lcom/google/ads/AdSize;Ljava/lang/String;)V

    .line 56
    iput-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->adView:Lcom/google/ads/AdView;

    .line 58
    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->adviewscanner:Landroid/widget/LinearLayout;

    iget-object v8, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->adView:Lcom/google/ads/AdView;

    invoke-virtual {v7, v8}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 59
    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->adView:Lcom/google/ads/AdView;

    new-instance v8, Lcom/google/ads/AdRequest;

    invoke-direct {v8}, Lcom/google/ads/AdRequest;-><init>()V

    invoke-virtual {v7, v8}, Lcom/google/ads/AdView;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 61
    new-instance v7, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/unstall/Move2SDActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    const-string v9, "340186902832477_388101491374351"

    invoke-direct {v7, v8, v9}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 62
    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v7, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 63
    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    sget-object v8, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v7, v8}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 65
    const v7, 0x7f0703da

    invoke-virtual {p0, v7}, Lcom/aio/downloader/unstall/Move2SDActivity;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/ListView;

    iput-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->lv_uninstall:Landroid/widget/ListView;

    .line 66
    const v7, 0x7f070182

    invoke-virtual {p0, v7}, Lcom/aio/downloader/unstall/Move2SDActivity;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    iput-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->tv_title_uninstall:Landroid/widget/TextView;

    .line 67
    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->tv_title_uninstall:Landroid/widget/TextView;

    const-string v8, "Move2SD"

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 68
    const v7, 0x7f0703d9

    invoke-virtual {p0, v7}, Lcom/aio/downloader/unstall/Move2SDActivity;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Lcom/aio/downloader/views/LImageButton;

    iput-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->header_left_uninstall:Lcom/aio/downloader/views/LImageButton;

    .line 69
    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->header_left_uninstall:Lcom/aio/downloader/views/LImageButton;

    new-instance v8, Lcom/aio/downloader/unstall/Move2SDActivity$1;

    invoke-direct {v8, p0}, Lcom/aio/downloader/unstall/Move2SDActivity$1;-><init>(Lcom/aio/downloader/unstall/Move2SDActivity;)V

    invoke-virtual {v7, v8}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 93
    invoke-virtual {p0}, Lcom/aio/downloader/unstall/Move2SDActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 95
    .local v5, "pm":Landroid/content/pm/PackageManager;
    const/16 v7, 0x2000

    invoke-virtual {v5, v7}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v0

    .line 96
    .local v0, "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    const/4 v1, 0x0

    .line 97
    .local v1, "appInfo":Landroid/content/pm/ApplicationInfo;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v7

    if-lt v3, v7, :cond_0

    .line 124
    const-string v7, "qqq"

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "infos.size()="

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->infos:Ljava/util/List;

    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 125
    const/4 v3, 0x0

    :goto_1
    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->infos:Ljava/util/List;

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v7

    if-lt v3, v7, :cond_4

    .line 128
    new-instance v7, Lcom/aio/downloader/unstall/Move2SDAdapter;

    iget-object v8, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->infos:Ljava/util/List;

    invoke-direct {v7, p0, v8}, Lcom/aio/downloader/unstall/Move2SDAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    iput-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->adapter:Lcom/aio/downloader/unstall/Move2SDAdapter;

    .line 129
    new-instance v6, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 130
    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->adapter:Lcom/aio/downloader/unstall/Move2SDAdapter;

    .line 129
    invoke-direct {v6, v7}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 131
    .local v6, "swingBottomInAnimationAdapter":Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;
    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->lv_uninstall:Landroid/widget/ListView;

    invoke-virtual {v6, v7}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 132
    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->lv_uninstall:Landroid/widget/ListView;

    invoke-virtual {v7, v6}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 135
    return-void

    .line 98
    .end local v6    # "swingBottomInAnimationAdapter":Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;
    :cond_0
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/content/pm/ApplicationInfo;

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/content/pm/ApplicationInfo;

    iget v7, v7, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v7, v7, 0x1

    if-nez v7, :cond_2

    .line 99
    new-instance v4, Lcom/aio/downloader/unstall/Info;

    invoke-direct {v4}, Lcom/aio/downloader/unstall/Info;-><init>()V

    .line 100
    .local v4, "info":Lcom/aio/downloader/unstall/Info;
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v5, v7}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-interface {v7}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Lcom/aio/downloader/unstall/Info;->setName(Ljava/lang/String;)V

    .line 101
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v7, v5}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    invoke-virtual {v4, v7}, Lcom/aio/downloader/unstall/Info;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 102
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/content/pm/ApplicationInfo;

    iget-object v7, v7, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/unstall/Info;->setPackagename(Ljava/lang/String;)V

    .line 105
    :try_start_0
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/content/pm/ApplicationInfo;

    iget-object v7, v7, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const/4 v8, 0x0

    invoke-virtual {v5, v7, v8}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 110
    :goto_2
    iget v7, v1, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v8, 0x40000

    and-int/2addr v7, v8

    if-eqz v7, :cond_3

    .line 112
    const-string v7, "qqq"

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "infos.size()="

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->infos:Ljava/util/List;

    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 120
    :cond_1
    :goto_3
    sget-object v8, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/content/pm/ApplicationInfo;

    iget-object v7, v7, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v9, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v7, "============"

    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v8, v7}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 97
    .end local v4    # "info":Lcom/aio/downloader/unstall/Info;
    :cond_2
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_0

    .line 106
    .restart local v4    # "info":Lcom/aio/downloader/unstall/Info;
    :catch_0
    move-exception v2

    .line 108
    .local v2, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v2}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 114
    .end local v2    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_3
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/content/pm/ApplicationInfo;

    iget-object v7, v7, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const-string v8, "com.aio.downloader"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 115
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/content/pm/ApplicationInfo;

    iget-object v7, v7, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    .line 116
    const-string v8, "com.evzapp.cleanmaster"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 117
    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->infos:Ljava/util/List;

    invoke-interface {v7, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 126
    .end local v4    # "info":Lcom/aio/downloader/unstall/Info;
    :cond_4
    sget-object v8, Ljava/lang/System;->out:Ljava/io/PrintStream;

    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDActivity;->infos:Ljava/util/List;

    invoke-interface {v7, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v7}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v8, v7}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 125
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_1
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 199
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 148
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 149
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 150
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 141
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 142
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 143
    return-void
.end method
