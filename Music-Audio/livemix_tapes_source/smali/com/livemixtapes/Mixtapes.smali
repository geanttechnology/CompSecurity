.class public Lcom/livemixtapes/Mixtapes;
.super Landroid/app/Fragment;
.source "Mixtapes.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/Mixtapes$JSONParse;,
        Lcom/livemixtapes/Mixtapes$LoadDownloadData;
    }
.end annotation


# static fields
.field private static final DAY:I = 0x5265c00

.field private static final HOUR:I = 0x36ee80

.field private static final MINUTE:I = 0xea60

.field private static final SECOND:I = 0x3e8

.field private static unixTime:J

.field private static url:Ljava/lang/String;


# instance fields
.field Btngetdata:Landroid/widget/Button;

.field JSONTask:Lcom/livemixtapes/Mixtapes$JSONParse;

.field actionBarImage:Landroid/widget/ImageView;

.field activity:Lcom/livemixtapes/MixtapesActivity;

.field adapter:Lcom/livemixtapes/LazyAdapterMixtapes;

.field allSwitch:Landroid/widget/TextView;

.field private curPage:I

.field private current_scope:Ljava/lang/String;

.field private dataloading:Ljava/lang/Boolean;

.field private dayValue:J

.field displayObject:Ljava/lang/Object;

.field dots:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/widget/ImageView;",
            ">;"
        }
    .end annotation
.end field

.field dotsLayout:Landroid/widget/LinearLayout;

.field featuredImage:Landroid/widget/ImageView;

.field private featured_tape:Ljava/lang/String;

.field footerView:Landroid/view/View;

.field grid:Landroid/widget/GridView;

.field private hourValue:J

.field imageLoader:Lcom/livemixtapes/ImageLoader;

.field private lastPosition:I

.field layoutSwitchImage:Landroid/widget/ImageView;

.field listView:Lcom/livemixtapes/PullToRefreshListView;

.field private minuteValue:J

.field mixtapeCount:Landroid/widget/TextView;

.field mixtapelist:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field

.field mixtapes:Lorg/json/JSONArray;

.field noData:Ljava/lang/Boolean;

.field pageCount:I

.field pagerAdapter:Lcom/livemixtapes/adapter/ViewPagerAdapter;

.field private positionCount:I

.field rootView:Landroid/view/View;

.field sObj:Lorg/json/JSONObject;

.field private secondValue:J

.field sourcelist:Lorg/json/JSONArray;

.field private tempDay:J

.field private tempHour:J

.field private tempMinute:J

.field private tempSecond:J

.field timer:Ljava/util/Timer;

.field todaySwitch:Landroid/widget/TextView;

.field unreleasedSwitch:Landroid/widget/TextView;

.field viewPager:Lcom/livemixtapes/adapter/ViewPagerCustomDuration;

.field weekSwitch:Landroid/widget/TextView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 60
    const-string v0, "https://api.livemixtapes.com/api/mixtape/all"

    sput-object v0, Lcom/livemixtapes/Mixtapes;->url:Ljava/lang/String;

    .line 73
    return-void
.end method

.method public constructor <init>()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    const-wide/16 v1, 0x0

    .line 52
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 57
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/Mixtapes;->mixtapelist:Ljava/util/ArrayList;

    .line 61
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/Mixtapes;->dataloading:Ljava/lang/Boolean;

    .line 62
    const/4 v0, -0x1

    iput v0, p0, Lcom/livemixtapes/Mixtapes;->lastPosition:I

    .line 63
    iput v4, p0, Lcom/livemixtapes/Mixtapes;->curPage:I

    .line 64
    iput v4, p0, Lcom/livemixtapes/Mixtapes;->positionCount:I

    .line 67
    const-string v0, "all_mixtapes"

    iput-object v0, p0, Lcom/livemixtapes/Mixtapes;->current_scope:Ljava/lang/String;

    .line 74
    iput-wide v1, p0, Lcom/livemixtapes/Mixtapes;->dayValue:J

    .line 75
    iput-wide v1, p0, Lcom/livemixtapes/Mixtapes;->hourValue:J

    .line 76
    iput-wide v1, p0, Lcom/livemixtapes/Mixtapes;->minuteValue:J

    .line 77
    iput-wide v1, p0, Lcom/livemixtapes/Mixtapes;->secondValue:J

    .line 78
    iput-wide v1, p0, Lcom/livemixtapes/Mixtapes;->tempDay:J

    .line 79
    iput-wide v1, p0, Lcom/livemixtapes/Mixtapes;->tempHour:J

    .line 80
    iput-wide v1, p0, Lcom/livemixtapes/Mixtapes;->tempMinute:J

    .line 81
    iput-wide v1, p0, Lcom/livemixtapes/Mixtapes;->tempSecond:J

    .line 84
    iput-object v3, p0, Lcom/livemixtapes/Mixtapes;->mixtapes:Lorg/json/JSONArray;

    .line 85
    iput-object v3, p0, Lcom/livemixtapes/Mixtapes;->sourcelist:Lorg/json/JSONArray;

    .line 86
    iput-object v3, p0, Lcom/livemixtapes/Mixtapes;->sObj:Lorg/json/JSONObject;

    .line 87
    iput-object v3, p0, Lcom/livemixtapes/Mixtapes;->footerView:Landroid/view/View;

    .line 91
    iput-object v3, p0, Lcom/livemixtapes/Mixtapes;->JSONTask:Lcom/livemixtapes/Mixtapes$JSONParse;

    .line 92
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/Mixtapes;->noData:Ljava/lang/Boolean;

    .line 107
    iput v4, p0, Lcom/livemixtapes/Mixtapes;->pageCount:I

    .line 52
    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/Mixtapes;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 61
    iput-object p1, p0, Lcom/livemixtapes/Mixtapes;->dataloading:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$1(Lcom/livemixtapes/Mixtapes;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes;->current_scope:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$10(Lcom/livemixtapes/Mixtapes;)I
    .locals 1

    .prologue
    .line 62
    iget v0, p0, Lcom/livemixtapes/Mixtapes;->lastPosition:I

    return v0
.end method

.method static synthetic access$11(Lcom/livemixtapes/Mixtapes;I)V
    .locals 0

    .prologue
    .line 62
    iput p1, p0, Lcom/livemixtapes/Mixtapes;->lastPosition:I

    return-void
.end method

.method static synthetic access$12(Lcom/livemixtapes/Mixtapes;I)V
    .locals 0

    .prologue
    .line 64
    iput p1, p0, Lcom/livemixtapes/Mixtapes;->positionCount:I

    return-void
.end method

.method static synthetic access$2(Lcom/livemixtapes/Mixtapes;)I
    .locals 1

    .prologue
    .line 63
    iget v0, p0, Lcom/livemixtapes/Mixtapes;->curPage:I

    return v0
.end method

.method static synthetic access$3(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 60
    sput-object p0, Lcom/livemixtapes/Mixtapes;->url:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$4()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    sget-object v0, Lcom/livemixtapes/Mixtapes;->url:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$5(Lcom/livemixtapes/Mixtapes;I)V
    .locals 0

    .prologue
    .line 63
    iput p1, p0, Lcom/livemixtapes/Mixtapes;->curPage:I

    return-void
.end method

.method static synthetic access$6(Lcom/livemixtapes/Mixtapes;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 555
    invoke-direct {p0, p1}, Lcom/livemixtapes/Mixtapes;->setFlipperContent(Ljava/util/ArrayList;)V

    return-void
.end method

.method static synthetic access$7(Lcom/livemixtapes/Mixtapes;Ljava/util/HashMap;I)V
    .locals 0

    .prologue
    .line 854
    invoke-direct {p0, p1, p2}, Lcom/livemixtapes/Mixtapes;->loadMixtapeFragment(Ljava/util/HashMap;I)V

    return-void
.end method

.method static synthetic access$8(Lcom/livemixtapes/Mixtapes;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 430
    invoke-direct {p0, p1}, Lcom/livemixtapes/Mixtapes;->switchMixtapeView(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$9(Lcom/livemixtapes/Mixtapes;)Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes;->dataloading:Ljava/lang/Boolean;

    return-object v0
.end method

.method private loadMixtapeFragment(Ljava/util/HashMap;I)V
    .locals 5
    .param p2, "action"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 855
    .local p1, "tracksData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v3, p0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    invoke-virtual {v3}, Lcom/livemixtapes/MixtapesActivity;->getAnimatedFragmentTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 856
    .local v1, "fragmentTransaction":Landroid/app/FragmentTransaction;
    new-instance v2, Lcom/livemixtapes/Mixtape;

    invoke-direct {v2}, Lcom/livemixtapes/Mixtape;-><init>()V

    .line 857
    .local v2, "mixtapeFragment":Lcom/livemixtapes/Mixtape;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 858
    .local v0, "extras":Landroid/os/Bundle;
    const-string v3, "mixtapeData"

    invoke-virtual {v0, v3, p1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 859
    const-string v3, "init_action"

    invoke-virtual {v0, v3, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 860
    invoke-virtual {v2, v0}, Lcom/livemixtapes/Mixtape;->setArguments(Landroid/os/Bundle;)V

    .line 861
    const v3, 0x7f0800cc

    const-string v4, "MIXTAPE"

    invoke-virtual {v1, v3, v2, v4}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 862
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 863
    return-void
.end method

.method private setFlipperContent(Ljava/util/ArrayList;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 557
    .local p1, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtapes;->isAdded()Z

    move-result v0

    if-nez v0, :cond_0

    .line 663
    :goto_0
    return-void

    .line 561
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes;->viewPager:Lcom/livemixtapes/adapter/ViewPagerCustomDuration;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->setVisibility(I)V

    .line 563
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes;->pagerAdapter:Lcom/livemixtapes/adapter/ViewPagerAdapter;

    if-eqz v0, :cond_1

    .line 564
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes;->pagerAdapter:Lcom/livemixtapes/adapter/ViewPagerAdapter;

    invoke-virtual {v0}, Lcom/livemixtapes/adapter/ViewPagerAdapter;->cancelTimers()V

    .line 567
    :cond_1
    new-instance v0, Lcom/livemixtapes/adapter/ViewPagerAdapter;

    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    invoke-direct {v0, v1, p1}, Lcom/livemixtapes/adapter/ViewPagerAdapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;)V

    iput-object v0, p0, Lcom/livemixtapes/Mixtapes;->pagerAdapter:Lcom/livemixtapes/adapter/ViewPagerAdapter;

    .line 569
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes;->pagerAdapter:Lcom/livemixtapes/adapter/ViewPagerAdapter;

    new-instance v1, Lcom/livemixtapes/Mixtapes$13;

    invoke-direct {v1, p0, p1}, Lcom/livemixtapes/Mixtapes$13;-><init>(Lcom/livemixtapes/Mixtapes;Ljava/util/ArrayList;)V

    invoke-virtual {v0, v1}, Lcom/livemixtapes/adapter/ViewPagerAdapter;->setCallbacks(Lcom/livemixtapes/adapter/ViewPagerAdapter$PagerCallbacks;)V

    .line 579
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes;->viewPager:Lcom/livemixtapes/adapter/ViewPagerCustomDuration;

    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->pagerAdapter:Lcom/livemixtapes/adapter/ViewPagerAdapter;

    invoke-virtual {v0, v1}, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 581
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/livemixtapes/Mixtapes;->addDots(I)V

    .line 639
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_2

    .line 640
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 643
    :cond_2
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/Mixtapes;->timer:Ljava/util/Timer;

    .line 644
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes;->timer:Ljava/util/Timer;

    new-instance v1, Lcom/livemixtapes/Mixtapes$14;

    invoke-direct {v1, p0, p1}, Lcom/livemixtapes/Mixtapes$14;-><init>(Lcom/livemixtapes/Mixtapes;Ljava/util/ArrayList;)V

    .line 662
    const-wide/16 v2, 0x1f4

    const-wide/16 v4, 0xbb8

    .line 644
    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    goto :goto_0
.end method

.method private switchMixtapeView(Ljava/lang/String;)V
    .locals 14
    .param p1, "new_scope"    # Ljava/lang/String;

    .prologue
    const/4 v13, 0x1

    const-wide/16 v11, 0x3c

    const-wide/16 v9, 0x0

    .line 434
    :try_start_0
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->mixtapelist:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->clear()V

    .line 435
    const/4 v5, 0x0

    iput v5, p0, Lcom/livemixtapes/Mixtapes;->curPage:I

    .line 436
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtapes;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f0b001d

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    .line 437
    .local v1, "normalTextColor":I
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtapes;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x106000b

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    .line 439
    .local v4, "selectedTextColor":I
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->weekSwitch:Landroid/widget/TextView;

    const v6, 0x7f0200ef

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 440
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->todaySwitch:Landroid/widget/TextView;

    const v6, 0x7f0200ef

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 441
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->allSwitch:Landroid/widget/TextView;

    const v6, 0x7f0200ed

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 442
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->unreleasedSwitch:Landroid/widget/TextView;

    const v6, 0x7f0200f1

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 444
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->weekSwitch:Landroid/widget/TextView;

    invoke-virtual {v5, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 445
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->todaySwitch:Landroid/widget/TextView;

    invoke-virtual {v5, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 446
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->allSwitch:Landroid/widget/TextView;

    invoke-virtual {v5, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 447
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->unreleasedSwitch:Landroid/widget/TextView;

    invoke-virtual {v5, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 449
    const/4 v0, 0x1

    .line 450
    .local v0, "doUpdate":I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/16 v7, 0x3e8

    div-long/2addr v5, v7

    sput-wide v5, Lcom/livemixtapes/Mixtapes;->unixTime:J

    .line 452
    const-string v5, "week"

    invoke-virtual {p1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 454
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->weekSwitch:Landroid/widget/TextView;

    const v6, 0x7f0200f0

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 455
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->weekSwitch:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 457
    const-string v5, "week_mixtapes"

    iput-object v5, p0, Lcom/livemixtapes/Mixtapes;->current_scope:Ljava/lang/String;

    .line 460
    sget-wide v5, Lcom/livemixtapes/App;->lastUpdateWeek:J

    cmp-long v5, v5, v9

    if-eqz v5, :cond_0

    sget-wide v5, Lcom/livemixtapes/Mixtapes;->unixTime:J

    sget-wide v7, Lcom/livemixtapes/App;->lastUpdateWeek:J

    sub-long/2addr v5, v7

    cmp-long v5, v5, v11

    if-lez v5, :cond_3

    .line 462
    :cond_0
    sget-wide v5, Lcom/livemixtapes/Mixtapes;->unixTime:J

    sput-wide v5, Lcom/livemixtapes/App;->lastUpdateWeek:J

    .line 523
    :cond_1
    :goto_0
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtapes;->getActivity()Landroid/app/Activity;

    move-result-object v5

    const/4 v6, 0x0

    invoke-static {v5, v6}, Lcom/livemixtapes/utils/Utility;->dpToPixel(Landroid/content/Context;F)F

    move-result v5

    float-to-int v2, v5

    .line 524
    .local v2, "padLeftRight":I
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtapes;->getActivity()Landroid/app/Activity;

    move-result-object v5

    const/high16 v6, 0x40800000    # 4.0f

    invoke-static {v5, v6}, Lcom/livemixtapes/utils/Utility;->dpToPixel(Landroid/content/Context;F)F

    move-result v5

    float-to-int v3, v5

    .line 525
    .local v3, "padTopBottom":I
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->allSwitch:Landroid/widget/TextView;

    invoke-virtual {v5, v2, v3, v2, v3}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 526
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->weekSwitch:Landroid/widget/TextView;

    invoke-virtual {v5, v2, v3, v2, v3}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 527
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->todaySwitch:Landroid/widget/TextView;

    invoke-virtual {v5, v2, v3, v2, v3}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 528
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->unreleasedSwitch:Landroid/widget/TextView;

    invoke-virtual {v5, v2, v3, v2, v3}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 530
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->mixtapelist:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->clear()V

    .line 531
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->mixtapelist:Ljava/util/ArrayList;

    iget-object v6, p0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    iget-object v6, v6, Lcom/livemixtapes/MixtapesActivity;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    iget-object v7, p0, Lcom/livemixtapes/Mixtapes;->current_scope:Ljava/lang/String;

    invoke-virtual {v6, v7}, Lcom/livemixtapes/database/DBHelper;->getAllMixtapeData(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 532
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->adapter:Lcom/livemixtapes/LazyAdapterMixtapes;

    invoke-virtual {v5}, Lcom/livemixtapes/LazyAdapterMixtapes;->notifyDataSetChanged()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 534
    if-ne v0, v13, :cond_2

    .line 538
    :try_start_1
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->JSONTask:Lcom/livemixtapes/Mixtapes$JSONParse;

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Lcom/livemixtapes/Mixtapes$JSONParse;->cancel(Z)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 544
    :goto_1
    :try_start_2
    new-instance v5, Lcom/livemixtapes/Mixtapes$JSONParse;

    const/4 v6, 0x0

    invoke-direct {v5, p0, v6}, Lcom/livemixtapes/Mixtapes$JSONParse;-><init>(Lcom/livemixtapes/Mixtapes;Lcom/livemixtapes/Mixtapes$JSONParse;)V

    iput-object v5, p0, Lcom/livemixtapes/Mixtapes;->JSONTask:Lcom/livemixtapes/Mixtapes$JSONParse;

    .line 545
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->JSONTask:Lcom/livemixtapes/Mixtapes$JSONParse;

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/String;

    invoke-virtual {v5, v6}, Lcom/livemixtapes/Mixtapes$JSONParse;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 553
    .end local v0    # "doUpdate":I
    .end local v1    # "normalTextColor":I
    .end local v2    # "padLeftRight":I
    .end local v3    # "padTopBottom":I
    .end local v4    # "selectedTextColor":I
    :cond_2
    :goto_2
    return-void

    .line 466
    .restart local v0    # "doUpdate":I
    .restart local v1    # "normalTextColor":I
    .restart local v4    # "selectedTextColor":I
    :cond_3
    const/4 v0, 0x0

    .line 469
    goto :goto_0

    .line 470
    :cond_4
    const-string v5, "day"

    invoke-virtual {p1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 472
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->todaySwitch:Landroid/widget/TextView;

    const v6, 0x7f0200f0

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 473
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->todaySwitch:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 475
    const-string v5, "day_mixtapes"

    iput-object v5, p0, Lcom/livemixtapes/Mixtapes;->current_scope:Ljava/lang/String;

    .line 478
    sget-wide v5, Lcom/livemixtapes/App;->lastUpdateToday:J

    cmp-long v5, v5, v9

    if-eqz v5, :cond_5

    sget-wide v5, Lcom/livemixtapes/Mixtapes;->unixTime:J

    sget-wide v7, Lcom/livemixtapes/App;->lastUpdateToday:J

    sub-long/2addr v5, v7

    cmp-long v5, v5, v11

    if-lez v5, :cond_6

    .line 480
    :cond_5
    sget-wide v5, Lcom/livemixtapes/Mixtapes;->unixTime:J

    sput-wide v5, Lcom/livemixtapes/App;->lastUpdateToday:J

    goto/16 :goto_0

    .line 549
    .end local v0    # "doUpdate":I
    .end local v1    # "normalTextColor":I
    .end local v4    # "selectedTextColor":I
    :catch_0
    move-exception v5

    goto :goto_2

    .line 484
    .restart local v0    # "doUpdate":I
    .restart local v1    # "normalTextColor":I
    .restart local v4    # "selectedTextColor":I
    :cond_6
    const/4 v0, 0x0

    .line 487
    goto/16 :goto_0

    .line 488
    :cond_7
    const-string v5, "unreleased"

    invoke-virtual {p1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_a

    .line 490
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->unreleasedSwitch:Landroid/widget/TextView;

    const v6, 0x7f0200f2

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 491
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->unreleasedSwitch:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 493
    const-string v5, "unreleased_mixtapes"

    iput-object v5, p0, Lcom/livemixtapes/Mixtapes;->current_scope:Ljava/lang/String;

    .line 495
    sget-wide v5, Lcom/livemixtapes/App;->lastUpdateUnreleased:J

    cmp-long v5, v5, v9

    if-eqz v5, :cond_8

    sget-wide v5, Lcom/livemixtapes/Mixtapes;->unixTime:J

    sget-wide v7, Lcom/livemixtapes/App;->lastUpdateUnreleased:J

    sub-long/2addr v5, v7

    cmp-long v5, v5, v11

    if-lez v5, :cond_9

    .line 497
    :cond_8
    sget-wide v5, Lcom/livemixtapes/Mixtapes;->unixTime:J

    sput-wide v5, Lcom/livemixtapes/App;->lastUpdateUnreleased:J

    goto/16 :goto_0

    .line 501
    :cond_9
    const/4 v0, 0x0

    .line 504
    goto/16 :goto_0

    .line 505
    :cond_a
    const-string v5, "all"

    invoke-virtual {p1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 507
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->allSwitch:Landroid/widget/TextView;

    const v6, 0x7f0200ee

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 508
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes;->allSwitch:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 510
    const-string v5, "all_mixtapes"

    iput-object v5, p0, Lcom/livemixtapes/Mixtapes;->current_scope:Ljava/lang/String;

    .line 512
    sget-wide v5, Lcom/livemixtapes/App;->lastUpdateAll:J

    cmp-long v5, v5, v9

    if-eqz v5, :cond_b

    sget-wide v5, Lcom/livemixtapes/Mixtapes;->unixTime:J

    sget-wide v7, Lcom/livemixtapes/App;->lastUpdateAll:J

    sub-long/2addr v5, v7

    cmp-long v5, v5, v11

    if-lez v5, :cond_c

    .line 514
    :cond_b
    sget-wide v5, Lcom/livemixtapes/Mixtapes;->unixTime:J

    sput-wide v5, Lcom/livemixtapes/App;->lastUpdateAll:J
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_0

    .line 518
    :cond_c
    const/4 v0, 0x0

    goto/16 :goto_0

    .line 540
    .restart local v2    # "padLeftRight":I
    .restart local v3    # "padTopBottom":I
    :catch_1
    move-exception v5

    goto/16 :goto_1
.end method


# virtual methods
.method public addDots(I)V
    .locals 6
    .param p1, "count"    # I

    .prologue
    const/4 v5, -0x1

    .line 810
    iget-object v3, p0, Lcom/livemixtapes/Mixtapes;->dotsLayout:Landroid/widget/LinearLayout;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 811
    iget-object v3, p0, Lcom/livemixtapes/Mixtapes;->dotsLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 812
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lcom/livemixtapes/Mixtapes;->dots:Ljava/util/ArrayList;

    .line 814
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-lt v1, p1, :cond_0

    .line 827
    iget-object v3, p0, Lcom/livemixtapes/Mixtapes;->viewPager:Lcom/livemixtapes/adapter/ViewPagerCustomDuration;

    new-instance v4, Lcom/livemixtapes/Mixtapes$15;

    invoke-direct {v4, p0, p1}, Lcom/livemixtapes/Mixtapes$15;-><init>(Lcom/livemixtapes/Mixtapes;I)V

    invoke-virtual {v3, v4}, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 842
    return-void

    .line 815
    :cond_0
    new-instance v0, Landroid/widget/ImageView;

    iget-object v3, p0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    invoke-direct {v0, v3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 816
    .local v0, "dot":Landroid/widget/ImageView;
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtapes;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 817
    const v4, 0x7f02006c

    .line 816
    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 819
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v2, v5, v5}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 822
    .local v2, "params":Landroid/widget/LinearLayout$LayoutParams;
    iget-object v3, p0, Lcom/livemixtapes/Mixtapes;->dotsLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v0, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 824
    iget-object v3, p0, Lcom/livemixtapes/Mixtapes;->dots:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 814
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 8
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v7, 0x0

    const/4 v4, -0x1

    const/16 v6, 0x8

    const/4 v5, 0x0

    .line 120
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    if-nez v1, :cond_2

    .line 121
    const v1, 0x7f030029

    invoke-virtual {p1, v1, p2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    .line 123
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtapes;->getActivity()Landroid/app/Activity;

    move-result-object v1

    check-cast v1, Lcom/livemixtapes/MixtapesActivity;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    .line 125
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    const v2, 0x7f0800c7

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->viewPager:Lcom/livemixtapes/adapter/ViewPagerCustomDuration;

    .line 126
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->viewPager:Lcom/livemixtapes/adapter/ViewPagerCustomDuration;

    const-wide/high16 v2, 0x4008000000000000L    # 3.0

    invoke-virtual {v1, v2, v3}, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->setScrollDurationFactor(D)V

    .line 127
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->viewPager:Lcom/livemixtapes/adapter/ViewPagerCustomDuration;

    const/4 v2, 0x3

    invoke-virtual {v1, v2}, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->setOffscreenPageLimit(I)V

    .line 128
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    const v2, 0x7f0800c8

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->dotsLayout:Landroid/widget/LinearLayout;

    .line 130
    new-instance v1, Lcom/livemixtapes/ImageLoader;

    invoke-virtual {p0}, Lcom/livemixtapes/Mixtapes;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/livemixtapes/ImageLoader;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->imageLoader:Lcom/livemixtapes/ImageLoader;

    .line 132
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    const v2, 0x7f08005f

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->actionBarImage:Landroid/widget/ImageView;

    .line 134
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    const v2, 0x7f080078

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->featuredImage:Landroid/widget/ImageView;

    .line 136
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    const v2, 0x7f0800c6

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->layoutSwitchImage:Landroid/widget/ImageView;

    .line 137
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    const v2, 0x7f0800c1

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->allSwitch:Landroid/widget/TextView;

    .line 139
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    const v2, 0x7f0800c2

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->weekSwitch:Landroid/widget/TextView;

    .line 140
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    const v2, 0x7f0800c3

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->todaySwitch:Landroid/widget/TextView;

    .line 141
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    const v2, 0x7f0800c4

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->unreleasedSwitch:Landroid/widget/TextView;

    .line 144
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->weekSwitch:Landroid/widget/TextView;

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    iget v3, v3, Lcom/livemixtapes/MixtapesActivity;->week_mixtapes:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " This Week"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 145
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->todaySwitch:Landroid/widget/TextView;

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    iget v3, v3, Lcom/livemixtapes/MixtapesActivity;->day_mixtapes:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " Today"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 146
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->unreleasedSwitch:Landroid/widget/TextView;

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    iget v3, v3, Lcom/livemixtapes/MixtapesActivity;->unreleased_mixtapes:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " Unreleased"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 151
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    const v2, 0x7f0800c5

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->mixtapeCount:Landroid/widget/TextView;

    .line 154
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    const v2, 0x7f0800ca

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->Btngetdata:Landroid/widget/Button;

    .line 155
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->Btngetdata:Landroid/widget/Button;

    new-instance v2, Lcom/livemixtapes/Mixtapes$1;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Mixtapes$1;-><init>(Lcom/livemixtapes/Mixtapes;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 170
    new-instance v1, Lcom/livemixtapes/AsyncHttp;

    invoke-direct {v1}, Lcom/livemixtapes/AsyncHttp;-><init>()V

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "https://api.livemixtapes.com/api/page_counts?auth="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 171
    new-instance v3, Lcom/livemixtapes/Mixtapes$2;

    invoke-direct {v3, p0}, Lcom/livemixtapes/Mixtapes$2;-><init>(Lcom/livemixtapes/Mixtapes;)V

    .line 170
    invoke-virtual {v1, v2, v3}, Lcom/livemixtapes/AsyncHttp;->get(Ljava/lang/String;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V

    .line 209
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->layoutSwitchImage:Landroid/widget/ImageView;

    new-instance v2, Lcom/livemixtapes/Mixtapes$3;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Mixtapes$3;-><init>(Lcom/livemixtapes/Mixtapes;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 235
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->weekSwitch:Landroid/widget/TextView;

    new-instance v2, Lcom/livemixtapes/Mixtapes$4;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Mixtapes$4;-><init>(Lcom/livemixtapes/Mixtapes;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 242
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->todaySwitch:Landroid/widget/TextView;

    new-instance v2, Lcom/livemixtapes/Mixtapes$5;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Mixtapes$5;-><init>(Lcom/livemixtapes/Mixtapes;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 248
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->unreleasedSwitch:Landroid/widget/TextView;

    new-instance v2, Lcom/livemixtapes/Mixtapes$6;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Mixtapes$6;-><init>(Lcom/livemixtapes/Mixtapes;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 255
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->allSwitch:Landroid/widget/TextView;

    new-instance v2, Lcom/livemixtapes/Mixtapes$7;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Mixtapes$7;-><init>(Lcom/livemixtapes/Mixtapes;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 264
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->Btngetdata:Landroid/widget/Button;

    invoke-virtual {v1, v6}, Landroid/widget/Button;->setVisibility(I)V

    .line 266
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    const v2, 0x7f0800c9

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/livemixtapes/PullToRefreshListView;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->listView:Lcom/livemixtapes/PullToRefreshListView;

    .line 268
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    const v2, 0x7f0800cb

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/GridView;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->grid:Landroid/widget/GridView;

    .line 271
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->mixtapelist:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    iget-object v2, v2, Lcom/livemixtapes/MixtapesActivity;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    iget-object v3, p0, Lcom/livemixtapes/Mixtapes;->current_scope:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/livemixtapes/database/DBHelper;->getAllMixtapeData(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 273
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->mixtapelist:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 275
    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->noData:Ljava/lang/Boolean;

    .line 278
    :cond_0
    new-instance v1, Lcom/livemixtapes/LazyAdapterMixtapes;

    invoke-virtual {p0}, Lcom/livemixtapes/Mixtapes;->getActivity()Landroid/app/Activity;

    move-result-object v2

    iget-object v3, p0, Lcom/livemixtapes/Mixtapes;->mixtapelist:Ljava/util/ArrayList;

    invoke-direct {v1, v2, v3}, Lcom/livemixtapes/LazyAdapterMixtapes;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;)V

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->adapter:Lcom/livemixtapes/LazyAdapterMixtapes;

    .line 279
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->listView:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v1, v4}, Lcom/livemixtapes/PullToRefreshListView;->setBackgroundColor(I)V

    .line 280
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->listView:Lcom/livemixtapes/PullToRefreshListView;

    iget-object v2, p0, Lcom/livemixtapes/Mixtapes;->adapter:Lcom/livemixtapes/LazyAdapterMixtapes;

    invoke-virtual {v1, v2}, Lcom/livemixtapes/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 281
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->grid:Landroid/widget/GridView;

    invoke-virtual {v1, v4}, Landroid/widget/GridView;->setBackgroundColor(I)V

    .line 282
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->grid:Landroid/widget/GridView;

    iget-object v2, p0, Lcom/livemixtapes/Mixtapes;->adapter:Lcom/livemixtapes/LazyAdapterMixtapes;

    invoke-virtual {v1, v2}, Landroid/widget/GridView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 284
    sget-object v1, Lcom/livemixtapes/App;->viewStyle:Ljava/lang/String;

    const-string v2, "list"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 286
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->grid:Landroid/widget/GridView;

    invoke-virtual {v1, v6}, Landroid/widget/GridView;->setVisibility(I)V

    .line 288
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->listView:Lcom/livemixtapes/PullToRefreshListView;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->displayObject:Ljava/lang/Object;

    .line 299
    :cond_1
    :goto_0
    new-instance v1, Lcom/livemixtapes/Mixtapes$JSONParse;

    invoke-direct {v1, p0, v7}, Lcom/livemixtapes/Mixtapes$JSONParse;-><init>(Lcom/livemixtapes/Mixtapes;Lcom/livemixtapes/Mixtapes$JSONParse;)V

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->JSONTask:Lcom/livemixtapes/Mixtapes$JSONParse;

    .line 300
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const-wide/16 v3, 0x3e8

    div-long/2addr v1, v3

    sput-wide v1, Lcom/livemixtapes/Mixtapes;->unixTime:J

    .line 301
    sget-wide v1, Lcom/livemixtapes/Mixtapes;->unixTime:J

    sput-wide v1, Lcom/livemixtapes/App;->lastUpdateAll:J

    .line 303
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->JSONTask:Lcom/livemixtapes/Mixtapes$JSONParse;

    new-array v2, v5, [Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/livemixtapes/Mixtapes$JSONParse;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 305
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->listView:Lcom/livemixtapes/PullToRefreshListView;

    new-instance v2, Lcom/livemixtapes/Mixtapes$8;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Mixtapes$8;-><init>(Lcom/livemixtapes/Mixtapes;)V

    invoke-virtual {v1, v2}, Lcom/livemixtapes/PullToRefreshListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 315
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    .line 316
    const-string v2, "layout_inflater"

    invoke-virtual {v1, v2}, Lcom/livemixtapes/MixtapesActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/LayoutInflater;

    .line 317
    const v2, 0x7f030022

    .line 316
    invoke-virtual {v1, v2, v7, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 315
    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->footerView:Landroid/view/View;

    .line 318
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->listView:Lcom/livemixtapes/PullToRefreshListView;

    iget-object v2, p0, Lcom/livemixtapes/Mixtapes;->footerView:Landroid/view/View;

    invoke-virtual {v1, v2}, Lcom/livemixtapes/PullToRefreshListView;->addFooterView(Landroid/view/View;)V

    .line 319
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->footerView:Landroid/view/View;

    invoke-virtual {v1, v6}, Landroid/view/View;->setVisibility(I)V

    .line 321
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->listView:Lcom/livemixtapes/PullToRefreshListView;

    new-instance v2, Lcom/livemixtapes/Mixtapes$9;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Mixtapes$9;-><init>(Lcom/livemixtapes/Mixtapes;)V

    invoke-virtual {v1, v2}, Lcom/livemixtapes/PullToRefreshListView;->setOnBottomReachedListener(Lcom/livemixtapes/PullToRefreshListView$OnBottomReachedListener;)V

    .line 339
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->listView:Lcom/livemixtapes/PullToRefreshListView;

    new-instance v2, Lcom/livemixtapes/Mixtapes$10;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Mixtapes$10;-><init>(Lcom/livemixtapes/Mixtapes;)V

    invoke-virtual {v1, v2}, Lcom/livemixtapes/PullToRefreshListView;->setOnRefreshListener(Lcom/livemixtapes/PullToRefreshListView$OnRefreshListener;)V

    .line 366
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->grid:Landroid/widget/GridView;

    new-instance v2, Lcom/livemixtapes/Mixtapes$11;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Mixtapes$11;-><init>(Lcom/livemixtapes/Mixtapes;)V

    invoke-virtual {v1, v2}, Landroid/widget/GridView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 378
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->grid:Landroid/widget/GridView;

    new-instance v2, Lcom/livemixtapes/Mixtapes$12;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Mixtapes$12;-><init>(Lcom/livemixtapes/Mixtapes;)V

    invoke-virtual {v1, v2}, Landroid/widget/GridView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 405
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    invoke-virtual {v1}, Lcom/livemixtapes/MixtapesActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v2, "mixtapeId"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 406
    .local v0, "pushMixtapeId":Ljava/lang/String;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_2

    .line 407
    new-instance v1, Lcom/livemixtapes/Mixtapes$LoadDownloadData;

    invoke-direct {v1, p0}, Lcom/livemixtapes/Mixtapes$LoadDownloadData;-><init>(Lcom/livemixtapes/Mixtapes;)V

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    aput-object v0, v2, v5

    invoke-virtual {v1, v2}, Lcom/livemixtapes/Mixtapes$LoadDownloadData;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 413
    .end local v0    # "pushMixtapeId":Ljava/lang/String;
    :cond_2
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->rootView:Landroid/view/View;

    return-object v1

    .line 291
    :cond_3
    sget-object v1, Lcom/livemixtapes/App;->viewStyle:Ljava/lang/String;

    const-string v2, "grid"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 293
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->listView:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v1, v6}, Lcom/livemixtapes/PullToRefreshListView;->setVisibility(I)V

    .line 294
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes;->grid:Landroid/widget/GridView;

    iput-object v1, p0, Lcom/livemixtapes/Mixtapes;->displayObject:Ljava/lang/Object;

    goto/16 :goto_0
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 418
    invoke-super {p0}, Landroid/app/Fragment;->onDestroy()V

    .line 420
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes;->pagerAdapter:Lcom/livemixtapes/adapter/ViewPagerAdapter;

    if-eqz v0, :cond_0

    .line 421
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes;->pagerAdapter:Lcom/livemixtapes/adapter/ViewPagerAdapter;

    invoke-virtual {v0}, Lcom/livemixtapes/adapter/ViewPagerAdapter;->cancelTimers()V

    .line 424
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_1

    .line 425
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 426
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/livemixtapes/Mixtapes;->timer:Ljava/util/Timer;

    .line 428
    :cond_1
    return-void
.end method

.method public selectDot(II)V
    .locals 5
    .param p1, "count"    # I
    .param p2, "idx"    # I

    .prologue
    .line 845
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtapes;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 846
    .local v3, "res":Landroid/content/res/Resources;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-lt v2, p1, :cond_0

    .line 852
    return-void

    .line 847
    :cond_0
    if-ne v2, p2, :cond_1

    const v1, 0x7f02006b

    .line 849
    .local v1, "drawableId":I
    :goto_1
    invoke-virtual {v3, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 850
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes;->dots:Ljava/util/ArrayList;

    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    invoke-virtual {v4, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 846
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 848
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    .end local v1    # "drawableId":I
    :cond_1
    const v1, 0x7f02006c

    goto :goto_1
.end method

.method updateJSONDatatoSQlite(Ljava/util/ArrayList;Ljava/lang/String;)V
    .locals 18
    .param p2, "which_screen"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 807
    .local p1, "mixtapeList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 764
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "WHICH SCREEN: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v1, v3

    invoke-static {v1}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 765
    const-string v2, ""

    .line 766
    .local v2, "write_scope":Ljava/lang/String;
    const-string v1, "thisweek"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 768
    const-string v2, "week_mixtapes"

    .line 780
    :cond_0
    :goto_0
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 783
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "WRITE SCOPE: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v1, v3

    invoke-static {v1}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 785
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    invoke-static {v3}, Lcom/livemixtapes/database/DBHelper;->sharedInstance(Landroid/content/Context;)Lcom/livemixtapes/database/DBHelper;

    move-result-object v3

    iput-object v3, v1, Lcom/livemixtapes/MixtapesActivity;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    .line 786
    move-object/from16 v0, p0

    iget v1, v0, Lcom/livemixtapes/Mixtapes;->curPage:I

    if-nez v1, :cond_2

    invoke-virtual/range {p1 .. p1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_2

    .line 787
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    iget-object v1, v1, Lcom/livemixtapes/MixtapesActivity;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    invoke-virtual {v1, v2}, Lcom/livemixtapes/database/DBHelper;->clearMixtapeTable(Ljava/lang/String;)V

    .line 789
    invoke-virtual/range {p1 .. p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v17

    :cond_1
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-nez v1, :cond_6

    :cond_2
    return-void

    .line 770
    :cond_3
    const-string v1, "today"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 772
    const-string v2, "day_mixtapes"

    .line 773
    goto :goto_0

    .line 774
    :cond_4
    const-string v1, "unreleased"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 776
    const-string v2, "unreleased_mixtapes"

    .line 777
    goto :goto_0

    .line 778
    :cond_5
    const-string v1, "all"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 780
    const-string v2, "all_mixtapes"

    goto :goto_0

    .line 789
    :cond_6
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/util/HashMap;

    .line 791
    .local v14, "mixtape":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    iget-object v1, v1, Lcom/livemixtapes/MixtapesActivity;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    const-string v3, "id"

    invoke-virtual {v14, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 792
    const-string v4, "title"

    invoke-virtual {v14, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 793
    const-string v5, "artist"

    invoke-virtual {v14, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    .line 794
    const-string v6, "thumbnail"

    invoke-virtual {v14, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    .line 795
    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    const-string v7, "DJ"

    invoke-virtual {v14, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    .line 796
    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    const-string v8, "views"

    invoke-virtual {v14, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    .line 797
    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    const-string v9, "cover"

    invoke-virtual {v14, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    .line 798
    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    const-string v10, "score"

    invoke-virtual {v14, v10}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    .line 799
    invoke-virtual {v10}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v10

    const-string v11, "sharetext"

    invoke-virtual {v14, v11}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    .line 800
    invoke-virtual {v11}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v11

    const-string v12, "date"

    invoke-virtual {v14, v12}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    .line 801
    invoke-virtual {v12}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v12

    const-string v13, "featured"

    invoke-virtual {v14, v13}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v13

    .line 791
    invoke-virtual/range {v1 .. v13}, Lcom/livemixtapes/database/DBHelper;->insertMixtape(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    .line 802
    const-string v1, "tracks"

    invoke-virtual {v14, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/util/ArrayList;

    .line 803
    .local v16, "tracks":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-virtual/range {v16 .. v16}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/util/HashMap;

    .line 804
    .local v15, "track":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    iget-object v3, v3, Lcom/livemixtapes/MixtapesActivity;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    const-string v4, "id"

    invoke-virtual {v14, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "track_id"

    invoke-virtual {v15, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    const-string v6, "track_title"

    invoke-virtual {v15, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    const-string v7, "track_duration"

    invoke-virtual {v15, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    const-string v8, "download_url"

    invoke-virtual {v15, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    const-string v9, "track_sharetext"

    invoke-virtual {v15, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    invoke-virtual/range {v3 .. v9}, Lcom/livemixtapes/database/DBHelper;->insertTrack(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    goto :goto_1
.end method
