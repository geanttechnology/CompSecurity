.class public Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;
.super Landroid/support/v4/app/Fragment;
.source "Mp3_Popular_Fragment.java"

# interfaces
.implements Lcom/aio/downloader/refresh/PullableListView$OnLoadListener;
.implements Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$Mya1;,
        Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$SeekBarChangeEvent;
    }
.end annotation


# instance fields
.field private adapter:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

.field private cha:Landroid/widget/ImageView;

.field private currenttime:Landroid/widget/TextView;

.field handler:Landroid/os/Handler;

.field private hidepopularmp3:Landroid/content/BroadcastReceiver;

.field private istag:Ljava/lang/Boolean;

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

.field private listView:Lcom/aio/downloader/refresh/PullableListView;

.field private model:Lcom/aio/downloader/model/Model;

.field private musicProgress:Landroid/widget/SeekBar;

.field mytotaltime:I

.field private next:I

.field private page:I

.field private playbar:Landroid/widget/RelativeLayout;

.field private player:Lcom/aio/downloader/utils/Player;

.field private playpause:Landroid/widget/ImageView;

.field private progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private publictools:Lcom/aio/downloader/utils/publicTools;

.field showBroadcast:Landroid/content/BroadcastReceiver;

.field private showpopularmp3:Landroid/content/BroadcastReceiver;

.field private swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

.field private task:Ljava/util/TimerTask;

.field private timer:Ljava/util/Timer;

.field private title:Landroid/widget/TextView;

.field private totaltime:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 51
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 55
    new-instance v0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$1;-><init>(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->showpopularmp3:Landroid/content/BroadcastReceiver;

    .line 65
    new-instance v0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$2;-><init>(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->hidepopularmp3:Landroid/content/BroadcastReceiver;

    .line 74
    new-instance v0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$3;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$3;-><init>(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->handler:Landroid/os/Handler;

    .line 129
    new-instance v0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$4;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$4;-><init>(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->showBroadcast:Landroid/content/BroadcastReceiver;

    .line 139
    iput-object v2, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 142
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->list:Ljava/util/ArrayList;

    .line 144
    iput-object v2, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 145
    iput v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->page:I

    .line 146
    iput v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->next:I

    .line 154
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->istag:Ljava/lang/Boolean;

    .line 158
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->mytotaltime:I

    .line 51
    return-void
.end method

.method private Mp3popularplaybarbottom()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 486
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    .line 487
    invoke-virtual {v1}, Lcom/aio/downloader/refresh/PullableListView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 486
    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 488
    .local v0, "linearParams":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/high16 v2, 0x42480000    # 50.0f

    invoke-static {v1, v2}, Lcom/aio/downloader/utils/DisplayUtil;->dip2px(Landroid/content/Context;F)I

    move-result v1

    invoke-virtual {v0, v3, v3, v3, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 489
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/refresh/PullableListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 491
    return-void
.end method

.method private Mp3populistViewbottom()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 477
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    .line 478
    invoke-virtual {v1}, Lcom/aio/downloader/refresh/PullableListView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 477
    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 480
    .local v0, "linearParams":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/high16 v2, 0x42480000    # 50.0f

    invoke-static {v1, v2}, Lcom/aio/downloader/utils/DisplayUtil;->dip2px(Landroid/content/Context;F)I

    move-result v1

    invoke-virtual {v0, v3, v3, v3, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 481
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/refresh/PullableListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 483
    return-void
.end method

.method private ShowResult(Ljava/lang/String;)V
    .locals 5
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    .line 373
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->list:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parseMp3list(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 374
    iget v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->page:I

    if-ne v0, v4, :cond_0

    .line 375
    new-instance v0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->list:Ljava/util/ArrayList;

    const-string v3, "mp3popular"

    invoke-direct {v0, v1, v2, v3}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->adapter:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    .line 380
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->adapter:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 383
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, v4}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    .line 384
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 385
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->adapter:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->notifyDataSetChanged()V

    .line 386
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->currenttime:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->playpause:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;Lcom/aio/downloader/model/Model;)V
    .locals 0

    .prologue
    .line 161
    iput-object p1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->model:Lcom/aio/downloader/model/Model;

    return-void
.end method

.method static synthetic access$12(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Lcom/aio/downloader/model/Model;
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->model:Lcom/aio/downloader/model/Model;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;Ljava/util/Timer;)V
    .locals 0

    .prologue
    .line 159
    iput-object p1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->timer:Ljava/util/Timer;

    return-void
.end method

.method static synthetic access$14(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;Ljava/util/TimerTask;)V
    .locals 0

    .prologue
    .line 160
    iput-object p1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->task:Ljava/util/TimerTask;

    return-void
.end method

.method static synthetic access$15(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Ljava/util/Timer;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->timer:Ljava/util/Timer;

    return-object v0
.end method

.method static synthetic access$16(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Ljava/util/TimerTask;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->task:Ljava/util/TimerTask;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->adapter:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Lcom/aio/downloader/utils/Player;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->player:Lcom/aio/downloader/utils/Player;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->playbar:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->totaltime:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)I
    .locals 1

    .prologue
    .line 145
    iget v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->page:I

    return v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 371
    invoke-direct {p0, p1}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->ShowResult(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$7(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Lcom/aio/downloader/utils/publicTools;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->publictools:Lcom/aio/downloader/utils/publicTools;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->title:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->list:Ljava/util/ArrayList;

    return-object v0
.end method

.method private failfile()V
    .locals 1

    .prologue
    .line 97
    new-instance v0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$5;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$5;-><init>(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)V

    sput-object v0, Lcom/aio/downloader/utils/publicTools;->mp3_popular_handler:Landroid/os/Handler;

    .line 126
    return-void
.end method

.method private init(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 284
    new-instance v0, Lcom/aio/downloader/utils/publicTools;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 286
    const v0, 0x7f070072

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 287
    const v0, 0x7f07006f

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/refresh/PullableListView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    .line 288
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/refresh/PullableListView;->setOnLoadListener(Lcom/aio/downloader/refresh/PullableListView$OnLoadListener;)V

    .line 289
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, v2}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    .line 290
    new-instance v0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$Mya1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$Mya1;-><init>(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 292
    return-void
.end method

.method private init2(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 296
    const v0, 0x7f0700e5

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->playpause:Landroid/widget/ImageView;

    .line 297
    const v0, 0x7f0700e8

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->cha:Landroid/widget/ImageView;

    .line 298
    const v0, 0x7f0700e4

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->playbar:Landroid/widget/RelativeLayout;

    .line 299
    const v0, 0x7f0700ec

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->totaltime:Landroid/widget/TextView;

    .line 300
    const v0, 0x7f0700ea

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->currenttime:Landroid/widget/TextView;

    .line 301
    const v0, 0x7f0700e7

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->title:Landroid/widget/TextView;

    .line 302
    const v0, 0x7f0700eb

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/SeekBar;

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->musicProgress:Landroid/widget/SeekBar;

    .line 303
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->playpause:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 304
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->cha:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 305
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->musicProgress:Landroid/widget/SeekBar;

    new-instance v1, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$SeekBarChangeEvent;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$SeekBarChangeEvent;-><init>(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setOnSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    .line 306
    new-instance v0, Lcom/aio/downloader/utils/Player;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->musicProgress:Landroid/widget/SeekBar;

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/utils/Player;-><init>(Landroid/content/Context;Landroid/widget/SeekBar;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->player:Lcom/aio/downloader/utils/Player;

    .line 308
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const v3, 0x7f02015e

    const/16 v2, 0x8

    const/4 v1, 0x1

    .line 390
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 414
    :goto_0
    :pswitch_0
    return-void

    .line 392
    :pswitch_1
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->istag:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 393
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->pause()V

    .line 394
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->playpause:Landroid/widget/ImageView;

    const v1, 0x7f02015a

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 395
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->istag:Ljava/lang/Boolean;

    goto :goto_0

    .line 398
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->play()V

    .line 399
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->playpause:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 400
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->istag:Ljava/lang/Boolean;

    goto :goto_0

    .line 405
    :pswitch_2
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->pause()V

    .line 406
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->playpause:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 407
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->istag:Ljava/lang/Boolean;

    .line 408
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->playbar:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 409
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    invoke-virtual {v0, v2}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    goto :goto_0

    .line 390
    nop

    :pswitch_data_0
    .packed-switch 0x7f0700e5
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 7
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 166
    const v4, 0x7f030012

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual {p1, v4, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 168
    .local v3, "view":Landroid/view/View;
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    const-string v4, "mp3_popular"

    sput-object v4, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 169
    invoke-direct {p0, v3}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->init(Landroid/view/View;)V

    .line 170
    invoke-direct {p0, v3}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->init2(Landroid/view/View;)V

    .line 172
    invoke-direct {p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->failfile()V

    .line 174
    iget-object v4, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    new-instance v5, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6;

    invoke-direct {v5, p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6;-><init>(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)V

    invoke-virtual {v4, v5}, Lcom/aio/downloader/refresh/PullableListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 263
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 264
    .local v0, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v4, "showpopularmp3"

    invoke-virtual {v0, v4}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 265
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    iget-object v5, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->showpopularmp3:Landroid/content/BroadcastReceiver;

    invoke-virtual {v4, v5, v0}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 267
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 268
    .local v1, "myIntentFilter3":Landroid/content/IntentFilter;
    const-string v4, "hidepopularmp3"

    invoke-virtual {v1, v4}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 269
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    iget-object v5, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->hidepopularmp3:Landroid/content/BroadcastReceiver;

    invoke-virtual {v4, v5, v1}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 273
    new-instance v2, Landroid/content/IntentFilter;

    invoke-direct {v2}, Landroid/content/IntentFilter;-><init>()V

    .line 274
    .local v2, "showIntentFilter":Landroid/content/IntentFilter;
    const-string v4, "show"

    invoke-virtual {v2, v4}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 275
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    iget-object v5, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->showBroadcast:Landroid/content/BroadcastReceiver;

    invoke-virtual {v4, v5, v2}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 278
    return-object v3
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 450
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onDestroy()V

    .line 452
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 454
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 455
    iput-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->timer:Ljava/util/Timer;

    .line 457
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->task:Ljava/util/TimerTask;

    if-eqz v0, :cond_1

    .line 458
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->task:Ljava/util/TimerTask;

    invoke-virtual {v0}, Ljava/util/TimerTask;->cancel()Z

    .line 459
    iput-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->task:Ljava/util/TimerTask;

    .line 463
    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->pause()V

    .line 464
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->stop()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 470
    :goto_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->player:Lcom/aio/downloader/utils/Player;

    if-eqz v0, :cond_2

    .line 472
    iput-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->player:Lcom/aio/downloader/utils/Player;

    .line 474
    :cond_2
    return-void

    .line 467
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onDismiss(Landroid/widget/ListView;[I)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;
    .param p2, "reverseSortedPositions"    # [I

    .prologue
    .line 314
    return-void
.end method

.method public onLoad(Lcom/aio/downloader/refresh/PullableListView;)V
    .locals 4
    .param p1, "pullableListView"    # Lcom/aio/downloader/refresh/PullableListView;

    .prologue
    const/4 v3, 0x0

    .line 319
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->list:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 320
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->list:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->list:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 321
    .local v0, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_next_page()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->next:I

    .line 325
    .end local v0    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_0
    iget v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->next:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    .line 326
    iget v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->page:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->page:I

    .line 327
    new-instance v1, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$Mya1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$Mya1;-><init>(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)V

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 333
    :goto_0
    return-void

    .line 329
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 503
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 504
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 505
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 496
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 497
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 498
    return-void
.end method
