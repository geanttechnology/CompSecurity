.class public Lcom/aio/downloader/activity/UpdateActivity;
.super Landroid/app/Activity;
.source "UpdateActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/facebook/ads/AdListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/UpdateActivity$Mya6;
    }
.end annotation


# instance fields
.field adView:Lcom/google/ads/AdView;

.field private adviewscanner:Landroid/widget/LinearLayout;

.field private animationDrawable:Landroid/graphics/drawable/AnimationDrawable;

.field private appHandler:Landroid/os/Handler;

.field private dEVICE_ID:Ljava/lang/String;

.field private isfa:Z

.field private isshow:Z

.field private iv_ioio:Landroid/widget/ImageView;

.field private jsonArray:Lorg/json/JSONArray;

.field list_update:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private ll_downnull:Landroid/widget/LinearLayout;

.field private lv_uninstall:Landroid/widget/ListView;

.field public mListInfo:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/AppInfo;",
            ">;"
        }
    .end annotation
.end field

.field private nativeAd:Lcom/facebook/ads/NativeAd;

.field private nativeAdgift:Lcom/facebook/ads/NativeAd;

.field private progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private tv_title_uninstall:Landroid/widget/TextView;

.field private upJsonStr:Ljava/lang/String;

.field private updatesize:I


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 51
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->mListInfo:Ljava/util/List;

    .line 57
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->list_update:Ljava/util/ArrayList;

    .line 58
    new-instance v0, Lcom/aio/downloader/activity/UpdateActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/UpdateActivity$1;-><init>(Lcom/aio/downloader/activity/UpdateActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->appHandler:Landroid/os/Handler;

    .line 91
    iput-boolean v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->isfa:Z

    .line 92
    iput-boolean v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->isshow:Z

    .line 51
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/UpdateActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/UpdateActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->upJsonStr:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/UpdateActivity;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->appHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/UpdateActivity;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->lv_uninstall:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/UpdateActivity;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->ll_downnull:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/UpdateActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->iv_ioio:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/UpdateActivity;Landroid/graphics/drawable/AnimationDrawable;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lcom/aio/downloader/activity/UpdateActivity;->animationDrawable:Landroid/graphics/drawable/AnimationDrawable;

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/UpdateActivity;)Landroid/graphics/drawable/AnimationDrawable;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->animationDrawable:Landroid/graphics/drawable/AnimationDrawable;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/UpdateActivity;)Lorg/json/JSONArray;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->jsonArray:Lorg/json/JSONArray;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/UpdateActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->dEVICE_ID:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/UpdateActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/aio/downloader/activity/UpdateActivity;->upJsonStr:Ljava/lang/String;

    return-void
.end method

.method private facebookad()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 371
    invoke-virtual {p0}, Lcom/aio/downloader/activity/UpdateActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 372
    const v4, 0x7f03003e

    .line 371
    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 374
    .local v2, "viewtop":Landroid/view/View;
    iget-object v3, p0, Lcom/aio/downloader/activity/UpdateActivity;->lv_uninstall:Landroid/widget/ListView;

    const/4 v4, 0x0

    invoke-virtual {v3, v2, v5, v4}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 376
    const v3, 0x7f0701a6

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 375
    check-cast v1, Landroid/widget/ImageView;

    .line 378
    .local v1, "iv_fb_fragment":Landroid/widget/ImageView;
    iget-object v3, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3}, Lcom/facebook/ads/NativeAd;->getAdCoverImage()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 379
    .local v0, "adCover":Lcom/facebook/ads/NativeAd$Image;
    invoke-static {v0, v1}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 381
    iget-object v3, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 383
    return-void
.end method

.method private getNewApps()V
    .locals 2

    .prologue
    .line 234
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/aio/downloader/activity/UpdateActivity$2;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/UpdateActivity$2;-><init>(Lcom/aio/downloader/activity/UpdateActivity;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 271
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 272
    return-void
.end method

.method private init()V
    .locals 2

    .prologue
    .line 151
    const v0, 0x7f0703d9

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/UpdateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 152
    const v0, 0x7f070182

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/UpdateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->tv_title_uninstall:Landroid/widget/TextView;

    .line 153
    const v0, 0x7f0703da

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/UpdateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->lv_uninstall:Landroid/widget/ListView;

    .line 154
    const v0, 0x7f0703dd

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/UpdateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->adviewscanner:Landroid/widget/LinearLayout;

    .line 155
    const v0, 0x7f070072

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/UpdateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 156
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 157
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->tv_title_uninstall:Landroid/widget/TextView;

    const-string v1, "Update"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 159
    const v0, 0x7f07018b

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/UpdateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->ll_downnull:Landroid/widget/LinearLayout;

    .line 160
    const v0, 0x7f07018d

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/UpdateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->iv_ioio:Landroid/widget/ImageView;

    .line 162
    return-void
.end method


# virtual methods
.method public getAllAppInfo()V
    .locals 20

    .prologue
    .line 166
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/UpdateActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v14

    .line 168
    .local v14, "pm":Landroid/content/pm/PackageManager;
    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/content/pm/PackageManager;->getInstalledPackages(I)Ljava/util/List;

    move-result-object v13

    .line 170
    .local v13, "packs":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    new-instance v15, Lorg/json/JSONArray;

    invoke-direct {v15}, Lorg/json/JSONArray;-><init>()V

    move-object/from16 v0, p0

    iput-object v15, v0, Lcom/aio/downloader/activity/UpdateActivity;->jsonArray:Lorg/json/JSONArray;

    .line 172
    new-instance v5, Landroid/os/Build;

    invoke-direct {v5}, Landroid/os/Build;-><init>()V

    .line 173
    .local v5, "bd":Landroid/os/Build;
    const/4 v8, 0x0

    .line 174
    .local v8, "ids_map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v8, Ljava/util/HashMap;

    .end local v8    # "ids_map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 175
    .restart local v8    # "ids_map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    invoke-interface {v13}, Ljava/util/List;->size()I

    move-result v15

    if-lt v7, v15, :cond_0

    .line 227
    const-string v15, "update"

    new-instance v16, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/UpdateActivity;->mListInfo:Ljava/util/List;

    move-object/from16 v17, v0

    invoke-interface/range {v17 .. v17}, Ljava/util/List;->size()I

    move-result v17

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v17

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 228
    const-string v15, "update"

    new-instance v16, Ljava/lang/StringBuilder;

    const-string v17, "jsonArray="

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/UpdateActivity;->jsonArray:Lorg/json/JSONArray;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 230
    return-void

    .line 177
    :cond_0
    new-instance v10, Lorg/json/JSONObject;

    invoke-direct {v10}, Lorg/json/JSONObject;-><init>()V

    .line 179
    .local v10, "object":Lorg/json/JSONObject;
    new-instance v9, Lcom/aio/downloader/model/AppInfo;

    invoke-direct {v9}, Lcom/aio/downloader/model/AppInfo;-><init>()V

    .line 181
    .local v9, "info":Lcom/aio/downloader/model/AppInfo;
    invoke-interface {v13, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroid/content/pm/PackageInfo;

    .line 183
    .local v11, "p":Landroid/content/pm/PackageInfo;
    iget-object v2, v11, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 185
    .local v2, "app":Landroid/content/pm/ApplicationInfo;
    iget v15, v2, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v15, v15, 0x1

    if-gtz v15, :cond_1

    .line 192
    invoke-virtual {v14, v2}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v15

    invoke-interface {v15}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    .line 194
    .local v3, "appname":Ljava/lang/String;
    iget-object v12, v11, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    .line 196
    .local v12, "packagename":Ljava/lang/String;
    iget-object v4, v11, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    .line 198
    .local v4, "appversion":Ljava/lang/String;
    const-string v15, "appname"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v14, v2}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v16

    .line 199
    iget-object v0, v11, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    .line 198
    invoke-static/range {v15 .. v16}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 201
    invoke-virtual {v9, v3}, Lcom/aio/downloader/model/AppInfo;->setAppname(Ljava/lang/String;)V

    .line 203
    invoke-virtual {v9, v12}, Lcom/aio/downloader/model/AppInfo;->setP_name(Ljava/lang/String;)V

    .line 205
    invoke-virtual {v14, v2}, Landroid/content/pm/PackageManager;->getApplicationIcon(Landroid/content/pm/ApplicationInfo;)Landroid/graphics/drawable/Drawable;

    move-result-object v15

    invoke-virtual {v9, v15}, Lcom/aio/downloader/model/AppInfo;->setAvatar(Landroid/graphics/drawable/Drawable;)V

    .line 207
    invoke-virtual {v9, v4}, Lcom/aio/downloader/model/AppInfo;->setVersion(Ljava/lang/String;)V

    .line 209
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/UpdateActivity;->mListInfo:Ljava/util/List;

    invoke-interface {v15, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 212
    :try_start_0
    const-string v15, "title"

    invoke-virtual {v10, v15, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 213
    const-string v15, "url_id"

    invoke-virtual {v10, v15, v12}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 214
    const-string v15, "version"

    invoke-virtual {v10, v15, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 215
    const-string v15, "install_time"

    .line 216
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v16

    const-wide/16 v18, 0x3e8

    div-long v16, v16, v18

    .line 215
    move-wide/from16 v0, v16

    invoke-virtual {v10, v15, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 222
    :goto_1
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/UpdateActivity;->jsonArray:Lorg/json/JSONArray;

    invoke-virtual {v15, v10}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 175
    .end local v3    # "appname":Ljava/lang/String;
    .end local v4    # "appversion":Ljava/lang/String;
    .end local v12    # "packagename":Ljava/lang/String;
    :cond_1
    add-int/lit8 v7, v7, 0x1

    goto/16 :goto_0

    .line 217
    .restart local v3    # "appname":Ljava/lang/String;
    .restart local v4    # "appversion":Ljava/lang/String;
    .restart local v12    # "packagename":Ljava/lang/String;
    :catch_0
    move-exception v6

    .line 219
    .local v6, "e":Lorg/json/JSONException;
    invoke-virtual {v6}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1
.end method

.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 337
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 2
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 342
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    if-ne v0, p1, :cond_2

    .line 343
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 365
    :cond_0
    :goto_0
    return-void

    .line 346
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 348
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->ll_downnull:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    goto :goto_0

    .line 349
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-ne v0, p1, :cond_0

    .line 350
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-ne v0, p1, :cond_0

    .line 355
    iget-object v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 359
    :try_start_0
    invoke-direct {p0}, Lcom/aio/downloader/activity/UpdateActivity;->facebookad()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 363
    :goto_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/activity/UpdateActivity;->isfa:Z

    goto :goto_0

    .line 360
    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 323
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 331
    :goto_0
    return-void

    .line 325
    :pswitch_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/UpdateActivity;->finish()V

    goto :goto_0

    .line 323
    :pswitch_data_0
    .packed-switch 0x7f0703d9
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const v6, 0x7f040006

    const/16 v5, 0x8

    const/4 v4, 0x0

    .line 99
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 100
    const v1, 0x7f0300b6

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/UpdateActivity;->setContentView(I)V

    .line 102
    invoke-direct {p0}, Lcom/aio/downloader/activity/UpdateActivity;->init()V

    .line 104
    const v1, 0x7f0703dd

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/UpdateActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->adviewscanner:Landroid/widget/LinearLayout;

    .line 105
    new-instance v1, Lcom/google/ads/AdView;

    sget-object v2, Lcom/google/ads/AdSize;->SMART_BANNER:Lcom/google/ads/AdSize;

    .line 106
    const-string v3, "ca-app-pub-2192624499353475/5842010949"

    invoke-direct {v1, p0, v2, v3}, Lcom/google/ads/AdView;-><init>(Landroid/app/Activity;Lcom/google/ads/AdSize;Ljava/lang/String;)V

    .line 105
    iput-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->adView:Lcom/google/ads/AdView;

    .line 107
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->adviewscanner:Landroid/widget/LinearLayout;

    iget-object v2, p0, Lcom/aio/downloader/activity/UpdateActivity;->adView:Lcom/google/ads/AdView;

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 108
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->adView:Lcom/google/ads/AdView;

    new-instance v2, Lcom/google/ads/AdRequest;

    invoke-direct {v2}, Lcom/google/ads/AdRequest;-><init>()V

    invoke-virtual {v1, v2}, Lcom/google/ads/AdView;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 110
    new-instance v1, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/UpdateActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "340186902832477_388101491374351"

    invoke-direct {v1, v2, v3}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 111
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v1, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 112
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    sget-object v2, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v1, v2}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 113
    invoke-static {}, Lcom/aio/downloader/utils/Updatesize;->getUpdatesize()Lcom/aio/downloader/utils/Updatesize;

    move-result-object v1

    iget-object v1, v1, Lcom/aio/downloader/utils/Updatesize;->list_update:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->updatesize:I

    .line 114
    iget v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->updatesize:I

    if-lez v1, :cond_1

    .line 115
    sget v1, Lcom/aio/downloader/utils/Myutils;->status:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    .line 116
    const-string v1, "update"

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/aio/downloader/activity/UpdateActivity;->list_update:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 117
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    invoke-virtual {v1, v5}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 118
    new-instance v0, Lcom/aio/downloader/adapter/UndateAdapter;

    .line 119
    invoke-virtual {p0}, Lcom/aio/downloader/activity/UpdateActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 120
    invoke-static {}, Lcom/aio/downloader/utils/Updatesize;->getUpdatesize()Lcom/aio/downloader/utils/Updatesize;

    move-result-object v2

    iget-object v2, v2, Lcom/aio/downloader/utils/Updatesize;->list_update:Ljava/util/ArrayList;

    .line 118
    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/adapter/UndateAdapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;)V

    .line 121
    .local v0, "adapter":Lcom/aio/downloader/adapter/UndateAdapter;
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->lv_uninstall:Landroid/widget/ListView;

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 142
    .end local v0    # "adapter":Lcom/aio/downloader/adapter/UndateAdapter;
    :goto_0
    new-instance v1, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/UpdateActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 143
    const-string v3, "340186902832477_436045659913267"

    invoke-direct {v1, v2, v3}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 142
    iput-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    .line 144
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v1, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 145
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    sget-object v2, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v1, v2}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 147
    return-void

    .line 123
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->ll_downnull:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 124
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->iv_ioio:Landroid/widget/ImageView;

    invoke-virtual {v1, v6}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 125
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->iv_ioio:Landroid/widget/ImageView;

    invoke-virtual {v1}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/AnimationDrawable;

    iput-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->animationDrawable:Landroid/graphics/drawable/AnimationDrawable;

    .line 126
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->animationDrawable:Landroid/graphics/drawable/AnimationDrawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/AnimationDrawable;->start()V

    goto :goto_0

    .line 129
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    invoke-virtual {v1, v5}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 130
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->ll_downnull:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 131
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->iv_ioio:Landroid/widget/ImageView;

    invoke-virtual {v1, v6}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 132
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->iv_ioio:Landroid/widget/ImageView;

    invoke-virtual {v1}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/AnimationDrawable;

    iput-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->animationDrawable:Landroid/graphics/drawable/AnimationDrawable;

    .line 133
    iget-object v1, p0, Lcom/aio/downloader/activity/UpdateActivity;->animationDrawable:Landroid/graphics/drawable/AnimationDrawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/AnimationDrawable;->start()V

    goto :goto_0
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 389
    return-void
.end method
