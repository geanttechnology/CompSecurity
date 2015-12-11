.class public Lco/vine/android/ExploreChannelsActivity;
.super Lco/vine/android/BaseTimelineActivity;
.source "ExploreChannelsActivity.java"

# interfaces
.implements Landroid/widget/TabHost$OnTabChangeListener;
.implements Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ExploreChannelsActivity$ExploreChannelsAppSessionListener;
    }
.end annotation


# static fields
.field public static final LOADER_ID_ICON_PATH:I = 0x0

.field public static final PARAM_ICON_PATH:Ljava/lang/String; = "icon"

.field public static final PARAM_NAME:Ljava/lang/String; = "name"

.field public static final PARAM_NAV_RGB:Ljava/lang/String; = "navRGB"

.field public static final PARAM_SHOW_RECENT:Ljava/lang/String; = "showRecent"

.field public static final PARAM_TITLE_RGB:Ljava/lang/String; = "titleRGB"

.field public static final PATH_SEGMENT_CHANNEL_ID:I = 0x0

.field public static final SORT_POPULAR:Ljava/lang/String; = "popular"

.field public static final SORT_RECENT:Ljava/lang/String; = "recent"

.field public static final TAG_POPULAR:Ljava/lang/String; = "popular"

.field public static final TAG_RECENT:Ljava/lang/String; = "recent"


# instance fields
.field private mChannelId:Ljava/lang/String;

.field private mIconImageKey:Lco/vine/android/util/image/ImageKey;

.field private mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

.field private mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

.field private mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

.field private mViewPager:Landroid/support/v4/view/ViewPager;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Lco/vine/android/BaseTimelineActivity;-><init>()V

    .line 324
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/ExploreChannelsActivity;)Lco/vine/android/util/image/ImageKey;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ExploreChannelsActivity;

    .prologue
    .line 49
    iget-object v0, p0, Lco/vine/android/ExploreChannelsActivity;->mIconImageKey:Lco/vine/android/util/image/ImageKey;

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/ExploreChannelsActivity;Landroid/graphics/Bitmap;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ExploreChannelsActivity;
    .param p1, "x1"    # Landroid/graphics/Bitmap;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lco/vine/android/ExploreChannelsActivity;->setIconImage(Landroid/graphics/Bitmap;)V

    return-void
.end method

.method static synthetic access$200(Lco/vine/android/ExploreChannelsActivity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ExploreChannelsActivity;

    .prologue
    .line 49
    iget-object v0, p0, Lco/vine/android/ExploreChannelsActivity;->mChannelId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/ExploreChannelsActivity;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/ExploreChannelsActivity;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lco/vine/android/ExploreChannelsActivity;->setIconImage(Ljava/lang/String;)V

    return-void
.end method

.method private setIconImage(Landroid/graphics/Bitmap;)V
    .locals 5
    .param p1, "iconImage"    # Landroid/graphics/Bitmap;

    .prologue
    .line 316
    invoke-virtual {p0}, Lco/vine/android/ExploreChannelsActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 317
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v0, :cond_0

    .line 318
    invoke-virtual {p0}, Lco/vine/android/ExploreChannelsActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0b0011

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 319
    .local v1, "l":I
    const/4 v3, 0x1

    invoke-static {p1, v1, v1, v3}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v2

    .line 320
    .local v2, "scaledIconImage":Landroid/graphics/Bitmap;
    new-instance v3, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p0}, Lco/vine/android/ExploreChannelsActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-direct {v3, v4, v2}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v3}, Landroid/support/v7/app/ActionBar;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 322
    .end local v1    # "l":I
    .end local v2    # "scaledIconImage":Landroid/graphics/Bitmap;
    :cond_0
    return-void
.end method

.method private setIconImage(Ljava/lang/String;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 305
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 306
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lco/vine/android/util/BuildUtil;->getWebsiteUrl(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 307
    .local v0, "fullUrl":Ljava/lang/String;
    new-instance v2, Lco/vine/android/util/image/ImageKey;

    invoke-direct {v2, v0}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;)V

    iput-object v2, p0, Lco/vine/android/ExploreChannelsActivity;->mIconImageKey:Lco/vine/android/util/image/ImageKey;

    .line 308
    iget-object v2, p0, Lco/vine/android/ExploreChannelsActivity;->mAppController:Lco/vine/android/client/AppController;

    iget-object v3, p0, Lco/vine/android/ExploreChannelsActivity;->mIconImageKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {v2, v3}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 309
    .local v1, "iconImage":Landroid/graphics/Bitmap;
    if-eqz v1, :cond_0

    .line 310
    invoke-direct {p0, v1}, Lco/vine/android/ExploreChannelsActivity;->setIconImage(Landroid/graphics/Bitmap;)V

    .line 313
    .end local v0    # "fullUrl":Ljava/lang/String;
    .end local v1    # "iconImage":Landroid/graphics/Bitmap;
    :cond_0
    return-void
.end method

.method private setupTabs()V
    .locals 2

    .prologue
    .line 243
    const v0, 0x1020012

    invoke-virtual {p0, v0}, Lco/vine/android/ExploreChannelsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/tabs/IconTabHost;

    iput-object v0, p0, Lco/vine/android/ExploreChannelsActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    .line 244
    iget-object v0, p0, Lco/vine/android/ExploreChannelsActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    if-nez v0, :cond_0

    .line 245
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Your content must have a TabHost whose id attribute is \'android.R.id.tabhost\'"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 250
    :cond_0
    iget-object v0, p0, Lco/vine/android/ExploreChannelsActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v0}, Lco/vine/android/widget/tabs/IconTabHost;->setup()V

    .line 251
    const v0, 0x7f0a00da

    invoke-virtual {p0, v0}, Lco/vine/android/ExploreChannelsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/view/ViewPager;

    iput-object v0, p0, Lco/vine/android/ExploreChannelsActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    .line 252
    return-void
.end method


# virtual methods
.method protected getCurrentTimeLineFragment()Lco/vine/android/BaseTimelineFragment;
    .locals 2

    .prologue
    .line 207
    iget-object v1, p0, Lco/vine/android/ExploreChannelsActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/TabsAdapter;->getCurrentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 208
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    instance-of v1, v0, Lco/vine/android/BaseTimelineFragment;

    if-eqz v1, :cond_0

    .line 209
    check-cast v0, Lco/vine/android/BaseTimelineFragment;

    .line 211
    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    :goto_0
    return-object v0

    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasTabs()Z
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lco/vine/android/ExploreChannelsActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v0}, Lco/vine/android/widget/tabs/IconTabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/TabWidget;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isShowing(Ljava/lang/String;)Z
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 301
    if-eqz p1, :cond_0

    iget-object v0, p0, Lco/vine/android/ExploreChannelsActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v0}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentTabTag()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 216
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseTimelineActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 217
    invoke-virtual {p0}, Lco/vine/android/ExploreChannelsActivity;->getCurrentTimeLineFragment()Lco/vine/android/BaseTimelineFragment;

    move-result-object v0

    .line 218
    .local v0, "fragment":Lco/vine/android/BaseTimelineFragment;
    if-eqz v0, :cond_0

    .line 219
    invoke-virtual {v0, p1, p2, p3}, Lco/vine/android/BaseTimelineFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 221
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 26
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 76
    const v4, 0x7f030052

    const/4 v6, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-super {v0, v1, v4, v6}, Lco/vine/android/BaseTimelineActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 77
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 78
    invoke-direct/range {p0 .. p0}, Lco/vine/android/ExploreChannelsActivity;->setupTabs()V

    .line 81
    :cond_0
    new-instance v4, Lco/vine/android/ExploreChannelsActivity$ExploreChannelsAppSessionListener;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lco/vine/android/ExploreChannelsActivity$ExploreChannelsAppSessionListener;-><init>(Lco/vine/android/ExploreChannelsActivity;)V

    move-object/from16 v0, p0

    iput-object v4, v0, Lco/vine/android/ExploreChannelsActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 84
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ExploreChannelsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    .line 85
    .local v3, "intent":Landroid/content/Intent;
    if-eqz v3, :cond_1

    invoke-virtual {v3}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v4

    if-nez v4, :cond_2

    .line 86
    :cond_1
    new-instance v4, Ljava/lang/IllegalAccessError;

    const-string v6, "Intent data is null. You must provide a URI in order to view a video list."

    invoke-direct {v4, v6}, Ljava/lang/IllegalAccessError;-><init>(Ljava/lang/String;)V

    throw v4

    .line 88
    :cond_2
    invoke-virtual {v3}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v12

    .line 89
    .local v12, "data":Landroid/net/Uri;
    invoke-virtual {v12}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    const/4 v6, 0x0

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 90
    .local v5, "channelId":Ljava/lang/String;
    const-string v4, "icon"

    invoke-virtual {v12, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 91
    .local v14, "iconPath":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "#"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "navRGB"

    invoke-virtual {v12, v6}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    .line 92
    .local v16, "navRGBParam":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "#"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "titleRGB"

    invoke-virtual {v12, v6}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    .line 93
    .local v23, "titleRGBParam":Ljava/lang/String;
    const-string v4, "showRecent"

    const/4 v6, 0x0

    invoke-virtual {v12, v4, v6}, Landroid/net/Uri;->getBooleanQueryParameter(Ljava/lang/String;Z)Z

    move-result v19

    .line 95
    .local v19, "showRecent":Z
    const-string v4, "name"

    invoke-virtual {v12, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 96
    .local v11, "channel":Ljava/lang/String;
    if-eqz v11, :cond_3

    .line 97
    const/16 v4, 0x2b

    const/16 v6, 0x20

    invoke-virtual {v11, v4, v6}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v11

    .line 103
    :cond_3
    :try_start_0
    invoke-static/range {v16 .. v16}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v8

    .line 108
    .local v8, "navRGB":I
    :goto_0
    :try_start_1
    invoke-static/range {v23 .. v23}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_1

    move-result v22

    .line 113
    .local v22, "titleRGB":I
    :goto_1
    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    const/4 v6, 0x1

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    const/4 v7, 0x0

    const/16 v24, 0x1

    invoke-static/range {v24 .. v24}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v24

    move-object/from16 v0, p0

    move-object/from16 v1, v24

    invoke-virtual {v0, v4, v6, v7, v1}, Lco/vine/android/ExploreChannelsActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 115
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ExploreChannelsActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v9

    .line 116
    .local v9, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v9, :cond_4

    .line 117
    invoke-virtual {v9, v11}, Landroid/support/v7/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 118
    new-instance v4, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v4, v8}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v9, v4}, Landroid/support/v7/app/ActionBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 123
    :cond_4
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v4

    const-string v6, "action_bar_title"

    const-string v7, "id"

    const-string v24, "android"

    move-object/from16 v0, v24

    invoke-virtual {v4, v6, v7, v0}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v10

    .line 124
    .local v10, "actionBarTitleId":I
    if-lez v10, :cond_5

    .line 125
    move-object/from16 v0, p0

    invoke-virtual {v0, v10}, Lco/vine/android/ExploreChannelsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v21

    check-cast v21, Landroid/widget/TextView;

    .line 126
    .local v21, "title":Landroid/widget/TextView;
    if-eqz v21, :cond_5

    .line 127
    invoke-virtual/range {v21 .. v22}, Landroid/widget/TextView;->setTextColor(I)V

    .line 132
    .end local v21    # "title":Landroid/widget/TextView;
    :cond_5
    const v4, 0x7f0a011c

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lco/vine/android/ExploreChannelsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    move-object/from16 v0, p0

    iput-object v4, v0, Lco/vine/android/ExploreChannelsActivity;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    .line 133
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ExploreChannelsActivity;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    invoke-virtual {v4, v8}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->setLineColor(I)V

    .line 134
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ExploreChannelsActivity;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    const/4 v6, 0x2

    invoke-virtual {v4, v6}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->setRange(I)V

    .line 135
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ExploreChannelsActivity;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    const/4 v6, 0x0

    invoke-virtual {v4, v6}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->setVisibility(I)V

    .line 137
    const v4, 0x7f0a00da

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lco/vine/android/ExploreChannelsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/support/v4/view/ViewPager;

    move-object/from16 v0, p0

    iput-object v4, v0, Lco/vine/android/ExploreChannelsActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    .line 138
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ExploreChannelsActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ExploreChannelsActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f0b0054

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v6

    invoke-virtual {v4, v6}, Landroid/support/v4/view/ViewPager;->setPageMargin(I)V

    .line 139
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ExploreChannelsActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    const v6, 0x7f09000e

    invoke-virtual {v4, v6}, Landroid/support/v4/view/ViewPager;->setPageMarginDrawable(I)V

    .line 140
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ExploreChannelsActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    const/4 v6, 0x1

    invoke-virtual {v4, v6}, Landroid/support/v4/view/ViewPager;->setOffscreenPageLimit(I)V

    .line 142
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/ExploreChannelsActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    move-object/from16 v20, v0

    .line 143
    .local v20, "tabHost":Lco/vine/android/widget/tabs/IconTabHost;
    new-instance v4, Lco/vine/android/widget/tabs/TabsAdapter;

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/ExploreChannelsActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    move-object/from16 v0, p0

    iget-object v7, v0, Lco/vine/android/ExploreChannelsActivity;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v4, v0, v1, v6, v7}, Lco/vine/android/widget/tabs/TabsAdapter;-><init>(Lco/vine/android/BaseControllerActionBarActivity;Landroid/widget/TabHost;Landroid/support/v4/view/ViewPager;Lco/vine/android/widget/tabs/ViewPagerScrollBar;)V

    move-object/from16 v0, p0

    iput-object v4, v0, Lco/vine/android/ExploreChannelsActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    .line 144
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ExploreChannelsActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    const/4 v6, 0x0

    invoke-virtual {v4, v6}, Lco/vine/android/widget/tabs/TabsAdapter;->setSetActionBarColorOnPageSelectedEnabled(Z)V

    .line 145
    invoke-static/range {p0 .. p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v15

    .line 146
    .local v15, "inflater":Landroid/view/LayoutInflater;
    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lco/vine/android/widget/tabs/IconTabHost;->setOnTabChangedListener(Landroid/widget/TabHost$OnTabChangeListener;)V

    .line 147
    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lco/vine/android/widget/tabs/IconTabHost;->setOnTabClickedListener(Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;)V

    .line 150
    const/4 v4, 0x1

    const-string v6, "popular"

    const-string v7, "popular"

    invoke-static/range {v3 .. v8}, Lco/vine/android/ExploreChannelsFragment;->prepareArguments(Landroid/content/Intent;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/os/Bundle;

    move-result-object v17

    .line 152
    .local v17, "popularBundle":Landroid/os/Bundle;
    const-string v4, "empty_desc"

    const v6, 0x7f0e00da

    move-object/from16 v0, v17

    invoke-virtual {v0, v4, v6}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 154
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ExploreChannelsActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    const-string v6, "popular"

    move-object/from16 v0, v20

    invoke-virtual {v0, v6}, Lco/vine/android/widget/tabs/IconTabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v6

    const v7, 0x7f03003a

    const v24, 0x7f0e023b

    const/16 v25, 0x1

    move-object/from16 v0, v20

    move/from16 v1, v24

    move/from16 v2, v25

    invoke-static {v15, v7, v0, v1, v2}, Lco/vine/android/widget/tabs/TabIndicator;->newTextIndicator(Landroid/view/LayoutInflater;ILandroid/widget/TabHost;IZ)Lco/vine/android/widget/tabs/TabIndicator;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    move-result-object v6

    const-class v7, Lco/vine/android/ExploreChannelsFragment;

    move-object/from16 v0, v17

    invoke-virtual {v4, v6, v7, v0}, Lco/vine/android/widget/tabs/TabsAdapter;->addTab(Landroid/widget/TabHost$TabSpec;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 161
    if-eqz v19, :cond_6

    .line 162
    const/4 v4, 0x1

    const-string v6, "recent"

    const-string v7, "recent"

    invoke-static/range {v3 .. v8}, Lco/vine/android/ExploreChannelsFragment;->prepareArguments(Landroid/content/Intent;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/os/Bundle;

    move-result-object v18

    .line 164
    .local v18, "recentBundle":Landroid/os/Bundle;
    const-string v4, "empty_desc"

    const v6, 0x7f0e00da

    move-object/from16 v0, v18

    invoke-virtual {v0, v4, v6}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 166
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ExploreChannelsActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    const-string v6, "recent"

    move-object/from16 v0, v20

    invoke-virtual {v0, v6}, Lco/vine/android/widget/tabs/IconTabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v6

    const v7, 0x7f03003a

    const v24, 0x7f0e023d

    const/16 v25, 0x1

    move-object/from16 v0, v20

    move/from16 v1, v24

    move/from16 v2, v25

    invoke-static {v15, v7, v0, v1, v2}, Lco/vine/android/widget/tabs/TabIndicator;->newTextIndicator(Landroid/view/LayoutInflater;ILandroid/widget/TabHost;IZ)Lco/vine/android/widget/tabs/TabIndicator;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    move-result-object v6

    const-class v7, Lco/vine/android/ExploreChannelsFragment;

    move-object/from16 v0, v18

    invoke-virtual {v4, v6, v7, v0}, Lco/vine/android/widget/tabs/TabsAdapter;->addTab(Landroid/widget/TabHost$TabSpec;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 177
    .end local v18    # "recentBundle":Landroid/os/Bundle;
    :goto_2
    move-object/from16 v0, p0

    iput-object v5, v0, Lco/vine/android/ExploreChannelsActivity;->mChannelId:Ljava/lang/String;

    .line 178
    move-object/from16 v0, p0

    invoke-direct {v0, v14}, Lco/vine/android/ExploreChannelsActivity;->setIconImage(Ljava/lang/String;)V

    .line 180
    return-void

    .line 104
    .end local v8    # "navRGB":I
    .end local v9    # "ab":Landroid/support/v7/app/ActionBar;
    .end local v10    # "actionBarTitleId":I
    .end local v15    # "inflater":Landroid/view/LayoutInflater;
    .end local v17    # "popularBundle":Landroid/os/Bundle;
    .end local v20    # "tabHost":Lco/vine/android/widget/tabs/IconTabHost;
    .end local v22    # "titleRGB":I
    :catch_0
    move-exception v13

    .line 105
    .local v13, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ExploreChannelsActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v6, 0x7f090096

    invoke-virtual {v4, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v8

    .restart local v8    # "navRGB":I
    goto/16 :goto_0

    .line 109
    .end local v13    # "e":Ljava/lang/IllegalArgumentException;
    :catch_1
    move-exception v13

    .line 110
    .restart local v13    # "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/ExploreChannelsActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v6, 0x7f090083

    invoke-virtual {v4, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v22

    .restart local v22    # "titleRGB":I
    goto/16 :goto_1

    .line 173
    .end local v13    # "e":Ljava/lang/IllegalArgumentException;
    .restart local v9    # "ab":Landroid/support/v7/app/ActionBar;
    .restart local v10    # "actionBarTitleId":I
    .restart local v15    # "inflater":Landroid/view/LayoutInflater;
    .restart local v17    # "popularBundle":Landroid/os/Bundle;
    .restart local v20    # "tabHost":Lco/vine/android/widget/tabs/IconTabHost;
    :cond_6
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ExploreChannelsActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v4}, Lco/vine/android/widget/tabs/IconTabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v4

    const/16 v6, 0x8

    invoke-virtual {v4, v6}, Landroid/widget/TabWidget;->setVisibility(I)V

    .line 174
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/ExploreChannelsActivity;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    const/16 v6, 0x8

    invoke-virtual {v4, v6}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->setVisibility(I)V

    goto :goto_2
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 201
    invoke-virtual {p0}, Lco/vine/android/ExploreChannelsActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const v1, 0x7f100005

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 202
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public onCurrentTabClicked()V
    .locals 0

    .prologue
    .line 275
    invoke-virtual {p0}, Lco/vine/android/ExploreChannelsActivity;->scrollTop()V

    .line 276
    return-void
.end method

.method protected onResume()V
    .locals 2

    .prologue
    .line 230
    invoke-super {p0}, Lco/vine/android/BaseTimelineActivity;->onResume()V

    .line 231
    iget-object v0, p0, Lco/vine/android/ExploreChannelsActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    iget-object v1, p0, Lco/vine/android/ExploreChannelsActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentTab()I

    move-result v1

    iput v1, v0, Lco/vine/android/widget/tabs/TabsAdapter;->previousTab:I

    .line 232
    return-void
.end method

.method public onScroll(I)V
    .locals 4
    .param p1, "delta"    # I

    .prologue
    .line 187
    invoke-virtual {p0}, Lco/vine/android/ExploreChannelsActivity;->hasTabs()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 188
    iget-object v3, p0, Lco/vine/android/ExploreChannelsActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v3}, Lco/vine/android/widget/tabs/IconTabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v2

    check-cast v2, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;

    .line 189
    .local v2, "tabWidget":Lco/vine/android/widget/tabs/ScrollAwayTabWidget;
    invoke-virtual {v2, p1}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->onScroll(I)V

    .line 190
    iget-object v3, p0, Lco/vine/android/ExploreChannelsActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v3}, Lco/vine/android/widget/tabs/TabsAdapter;->getCurrentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 191
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    instance-of v3, v0, Lco/vine/android/BaseArrayListFragment;

    if-eqz v3, :cond_0

    .line 192
    invoke-virtual {v2}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->getNavBottom()I

    move-result v1

    .line 193
    .local v1, "navBottom":I
    check-cast v0, Lco/vine/android/BaseArrayListFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-virtual {v0, v1}, Lco/vine/android/BaseArrayListFragment;->setNavBottom(I)V

    .line 194
    iget-object v3, p0, Lco/vine/android/ExploreChannelsActivity;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    invoke-virtual {v3, v1}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->setNavOffset(I)V

    .line 197
    .end local v1    # "navBottom":I
    .end local v2    # "tabWidget":Lco/vine/android/widget/tabs/ScrollAwayTabWidget;
    :cond_0
    return-void
.end method

.method public onSupportContentChanged()V
    .locals 1

    .prologue
    .line 236
    invoke-super {p0}, Lco/vine/android/BaseTimelineActivity;->onSupportContentChanged()V

    .line 237
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v0

    if-nez v0, :cond_0

    .line 238
    invoke-direct {p0}, Lco/vine/android/ExploreChannelsActivity;->setupTabs()V

    .line 240
    :cond_0
    return-void
.end method

.method public onTabChanged(Ljava/lang/String;)V
    .locals 2
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 225
    iget-object v0, p0, Lco/vine/android/ExploreChannelsActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lco/vine/android/ExploreChannelsActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentTab()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 226
    return-void
.end method

.method public resetNav()V
    .locals 4

    .prologue
    .line 255
    iget-object v3, p0, Lco/vine/android/ExploreChannelsActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    if-eqz v3, :cond_0

    .line 256
    iget-object v3, p0, Lco/vine/android/ExploreChannelsActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    invoke-virtual {v3}, Lco/vine/android/widget/tabs/IconTabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v2

    check-cast v2, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;

    .line 257
    .local v2, "widget":Lco/vine/android/widget/tabs/ScrollAwayTabWidget;
    if-eqz v2, :cond_0

    .line 258
    invoke-virtual {v2}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->resetScroll()V

    .line 259
    invoke-virtual {v2}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->invalidate()V

    .line 261
    invoke-virtual {v2}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->getNavBottom()I

    move-result v1

    .line 262
    .local v1, "navBottom":I
    iget-object v3, p0, Lco/vine/android/ExploreChannelsActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    if-eqz v3, :cond_0

    .line 263
    iget-object v3, p0, Lco/vine/android/ExploreChannelsActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v3}, Lco/vine/android/widget/tabs/TabsAdapter;->getCurrentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 264
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    if-eqz v0, :cond_0

    .line 265
    check-cast v0, Lco/vine/android/BaseArrayListFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-virtual {v0, v1}, Lco/vine/android/BaseArrayListFragment;->setNavBottom(I)V

    .line 266
    iget-object v3, p0, Lco/vine/android/ExploreChannelsActivity;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    invoke-virtual {v3, v1}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->setNavOffset(I)V

    .line 271
    .end local v1    # "navBottom":I
    .end local v2    # "widget":Lco/vine/android/widget/tabs/ScrollAwayTabWidget;
    :cond_0
    return-void
.end method

.method public scrollTop()V
    .locals 4

    .prologue
    .line 279
    iget-object v3, p0, Lco/vine/android/ExploreChannelsActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v3}, Lco/vine/android/widget/tabs/TabsAdapter;->getCurrentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 281
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    instance-of v3, v0, Lco/vine/android/BaseArrayListFragment;

    if-nez v3, :cond_1

    .line 298
    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    :cond_0
    :goto_0
    return-void

    .line 285
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    :cond_1
    if-eqz v0, :cond_0

    .line 288
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getView()Landroid/view/View;

    move-result-object v2

    .line 289
    .local v2, "view":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 292
    const v3, 0x102000a

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/twitter/android/widget/TopScrollable;

    .line 294
    .local v1, "list":Lcom/twitter/android/widget/TopScrollable;
    if-eqz v1, :cond_0

    invoke-interface {v1}, Lcom/twitter/android/widget/TopScrollable;->scrollTop()Z

    move-result v3

    if-nez v3, :cond_0

    .line 296
    check-cast v0, Lco/vine/android/BaseArrayListFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-virtual {v0}, Lco/vine/android/BaseArrayListFragment;->invokeScrollFirstItem()V

    goto :goto_0
.end method
