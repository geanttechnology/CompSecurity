.class public Lcom/aio/downloader/fragments/RingtoneSearchFragment;
.super Landroid/support/v4/app/Fragment;
.source "RingtoneSearchFragment.java"

# interfaces
.implements Lcom/aio/downloader/refresh/PullableListView$OnLoadListener;
.implements Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;,
        Lcom/aio/downloader/fragments/RingtoneSearchFragment$SeekBarChangeEvent;
    }
.end annotation


# instance fields
.field private adapter:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

.field private cha:Landroid/widget/ImageView;

.field private currenttime:Landroid/widget/TextView;

.field handler:Landroid/os/Handler;

.field private hidesearchringtone:Landroid/content/BroadcastReceiver;

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

.field private ringtonesearch:Landroid/content/BroadcastReceiver;

.field showBroadcast:Landroid/content/BroadcastReceiver;

.field private showsearchringtone:Landroid/content/BroadcastReceiver;

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

    .line 50
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 52
    new-instance v0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$1;-><init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->showsearchringtone:Landroid/content/BroadcastReceiver;

    .line 62
    new-instance v0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$2;-><init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->hidesearchringtone:Landroid/content/BroadcastReceiver;

    .line 101
    new-instance v0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$3;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$3;-><init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->handler:Landroid/os/Handler;

    .line 123
    new-instance v0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$4;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$4;-><init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->showBroadcast:Landroid/content/BroadcastReceiver;

    .line 134
    new-instance v0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$5;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$5;-><init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->ringtonesearch:Landroid/content/BroadcastReceiver;

    .line 149
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->list:Ljava/util/ArrayList;

    .line 151
    iput-object v2, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 152
    iput v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->page:I

    .line 153
    iput v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->next:I

    .line 161
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->istag:Ljava/lang/Boolean;

    .line 165
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->mytotaltime:I

    .line 169
    iput-object v2, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 50
    return-void
.end method

.method private RingtonesearchlistViewbottom()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 509
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    .line 510
    invoke-virtual {v1}, Lcom/aio/downloader/refresh/PullableListView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 509
    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 512
    .local v0, "linearParams":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/high16 v2, 0x42480000    # 50.0f

    invoke-static {v1, v2}, Lcom/aio/downloader/utils/DisplayUtil;->dip2px(Landroid/content/Context;F)I

    move-result v1

    invoke-virtual {v0, v3, v3, v3, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 513
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/refresh/PullableListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 515
    return-void
.end method

.method private Ringtonesearchplaybarbottom()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 518
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->playbar:Landroid/widget/RelativeLayout;

    .line 519
    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 518
    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 520
    .local v0, "linearParams":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/high16 v2, 0x42480000    # 50.0f

    invoke-static {v1, v2}, Lcom/aio/downloader/utils/DisplayUtil;->dip2px(Landroid/content/Context;F)I

    move-result v1

    invoke-virtual {v0, v3, v3, v3, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 521
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->playbar:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 523
    return-void
.end method

.method private ShowResult(Ljava/lang/String;)V
    .locals 5
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    .line 407
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->list:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parseRingtonelist(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 408
    iget v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->page:I

    if-ne v0, v4, :cond_0

    .line 409
    new-instance v0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->list:Ljava/util/ArrayList;

    const-string v3, "ringtonesearch"

    invoke-direct {v0, v1, v2, v3}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->adapter:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    .line 410
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->adapter:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 411
    new-instance v0, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 412
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->adapter:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    invoke-direct {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 411
    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 413
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 414
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 417
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, v4}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    .line 418
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 419
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->adapter:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->notifyDataSetChanged()V

    .line 420
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->currenttime:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 164
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->title:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->playpause:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/fragments/RingtoneSearchFragment;Lcom/aio/downloader/model/Model;)V
    .locals 0

    .prologue
    .line 168
    iput-object p1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->model:Lcom/aio/downloader/model/Model;

    return-void
.end method

.method static synthetic access$13(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Lcom/aio/downloader/model/Model;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->model:Lcom/aio/downloader/model/Model;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/fragments/RingtoneSearchFragment;Ljava/util/Timer;)V
    .locals 0

    .prologue
    .line 166
    iput-object p1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->timer:Ljava/util/Timer;

    return-void
.end method

.method static synthetic access$15(Lcom/aio/downloader/fragments/RingtoneSearchFragment;Ljava/util/TimerTask;)V
    .locals 0

    .prologue
    .line 167
    iput-object p1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->task:Ljava/util/TimerTask;

    return-void
.end method

.method static synthetic access$16(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Ljava/util/Timer;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->timer:Ljava/util/Timer;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Ljava/util/TimerTask;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->task:Ljava/util/TimerTask;

    return-object v0
.end method

.method static synthetic access$18(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Lcom/aio/downloader/adapter/RingtoneListviewAdapter;
    .locals 1

    .prologue
    .line 148
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->adapter:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Lcom/aio/downloader/utils/Player;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->player:Lcom/aio/downloader/utils/Player;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->playbar:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->totaltime:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->list:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Lcom/aio/downloader/refresh/PullableListView;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)I
    .locals 1

    .prologue
    .line 152
    iget v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->page:I

    return v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/fragments/RingtoneSearchFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 405
    invoke-direct {p0, p1}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->ShowResult(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$9(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Lcom/aio/downloader/utils/publicTools;
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->publictools:Lcom/aio/downloader/utils/publicTools;

    return-object v0
.end method

.method private failfile()V
    .locals 1

    .prologue
    .line 70
    new-instance v0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$6;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$6;-><init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)V

    sput-object v0, Lcom/aio/downloader/utils/publicTools;->ringtone_search_handler:Landroid/os/Handler;

    .line 99
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

    .line 208
    new-instance v0, Lcom/aio/downloader/utils/publicTools;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 210
    const v0, 0x7f070072

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 211
    const v0, 0x7f07006f

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/refresh/PullableListView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    .line 212
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/refresh/PullableListView;->setOnLoadListener(Lcom/aio/downloader/refresh/PullableListView$OnLoadListener;)V

    .line 213
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, v2}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    .line 214
    new-instance v0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;-><init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 216
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    new-instance v1, Lcom/aio/downloader/fragments/RingtoneSearchFragment$7;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$7;-><init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 311
    return-void
.end method

.method private init2(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 315
    const v0, 0x7f0700e5

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->playpause:Landroid/widget/ImageView;

    .line 316
    const v0, 0x7f0700e8

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->cha:Landroid/widget/ImageView;

    .line 317
    const v0, 0x7f0700e4

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->playbar:Landroid/widget/RelativeLayout;

    .line 318
    const v0, 0x7f0700ec

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->totaltime:Landroid/widget/TextView;

    .line 319
    const v0, 0x7f0700ea

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->currenttime:Landroid/widget/TextView;

    .line 320
    const v0, 0x7f0700e7

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->title:Landroid/widget/TextView;

    .line 321
    const v0, 0x7f0700eb

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/SeekBar;

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->musicProgress:Landroid/widget/SeekBar;

    .line 322
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->playpause:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 323
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->cha:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 324
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->musicProgress:Landroid/widget/SeekBar;

    new-instance v1, Lcom/aio/downloader/fragments/RingtoneSearchFragment$SeekBarChangeEvent;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$SeekBarChangeEvent;-><init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setOnSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    .line 325
    new-instance v0, Lcom/aio/downloader/utils/Player;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->musicProgress:Landroid/widget/SeekBar;

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/utils/Player;-><init>(Landroid/content/Context;Landroid/widget/SeekBar;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->player:Lcom/aio/downloader/utils/Player;

    .line 327
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const v2, 0x7f02015e

    const/4 v1, 0x1

    .line 424
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 446
    :goto_0
    :pswitch_0
    return-void

    .line 426
    :pswitch_1
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->istag:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 427
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->pause()V

    .line 428
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->playpause:Landroid/widget/ImageView;

    const v1, 0x7f02015a

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 429
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->istag:Ljava/lang/Boolean;

    goto :goto_0

    .line 431
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->play()V

    .line 432
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->playpause:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 433
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->istag:Ljava/lang/Boolean;

    goto :goto_0

    .line 438
    :pswitch_2
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->pause()V

    .line 439
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->playpause:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 440
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->istag:Ljava/lang/Boolean;

    .line 441
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->playbar:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0

    .line 424
    :pswitch_data_0
    .packed-switch 0x7f0700e5
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 8
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 174
    const v5, 0x7f030012

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual {p1, v5, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .line 176
    .local v4, "view":Landroid/view/View;
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    const-string v5, "ringtone_search"

    sput-object v5, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 177
    invoke-direct {p0, v4}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->init(Landroid/view/View;)V

    .line 178
    invoke-direct {p0, v4}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->init2(Landroid/view/View;)V

    .line 179
    invoke-direct {p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->failfile()V

    .line 182
    new-instance v3, Landroid/content/IntentFilter;

    invoke-direct {v3}, Landroid/content/IntentFilter;-><init>()V

    .line 183
    .local v3, "showIntentFilter":Landroid/content/IntentFilter;
    const-string v5, "show"

    invoke-virtual {v3, v5}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 184
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    iget-object v6, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->showBroadcast:Landroid/content/BroadcastReceiver;

    invoke-virtual {v5, v6, v3}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 185
    invoke-direct {p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->Ringtonesearchplaybarbottom()V

    .line 186
    invoke-direct {p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->RingtonesearchlistViewbottom()V

    .line 188
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 189
    .local v0, "myIntentFilter":Landroid/content/IntentFilter;
    const-string v5, "ringtonesearch"

    invoke-virtual {v0, v5}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 190
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    iget-object v6, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->ringtonesearch:Landroid/content/BroadcastReceiver;

    invoke-virtual {v5, v6, v0}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 195
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 196
    .local v1, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v5, "showsearchringtone"

    invoke-virtual {v1, v5}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 197
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    iget-object v6, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->showsearchringtone:Landroid/content/BroadcastReceiver;

    invoke-virtual {v5, v6, v1}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 199
    new-instance v2, Landroid/content/IntentFilter;

    invoke-direct {v2}, Landroid/content/IntentFilter;-><init>()V

    .line 200
    .local v2, "myIntentFilter3":Landroid/content/IntentFilter;
    const-string v5, "hidesearchringtone"

    invoke-virtual {v2, v5}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 201
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    iget-object v6, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->hidesearchringtone:Landroid/content/BroadcastReceiver;

    invoke-virtual {v5, v6, v2}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 202
    return-object v4
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 482
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onDestroy()V

    .line 484
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 486
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 487
    iput-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->timer:Ljava/util/Timer;

    .line 489
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->task:Ljava/util/TimerTask;

    if-eqz v0, :cond_1

    .line 490
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->task:Ljava/util/TimerTask;

    invoke-virtual {v0}, Ljava/util/TimerTask;->cancel()Z

    .line 491
    iput-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->task:Ljava/util/TimerTask;

    .line 495
    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->pause()V

    .line 496
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->stop()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 502
    :goto_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->player:Lcom/aio/downloader/utils/Player;

    if-eqz v0, :cond_2

    .line 504
    iput-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->player:Lcom/aio/downloader/utils/Player;

    .line 506
    :cond_2
    return-void

    .line 498
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onDismiss(Landroid/widget/ListView;[I)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;
    .param p2, "reverseSortedPositions"    # [I

    .prologue
    .line 333
    return-void
.end method

.method public onLoad(Lcom/aio/downloader/refresh/PullableListView;)V
    .locals 4
    .param p1, "pullableListView"    # Lcom/aio/downloader/refresh/PullableListView;

    .prologue
    const/4 v3, 0x0

    .line 338
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->list:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 339
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->list:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->list:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 340
    .local v0, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_next_page()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->next:I

    .line 344
    .end local v0    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_0
    iget v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->next:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    .line 345
    iget v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->page:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->page:I

    .line 346
    new-instance v1, Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;-><init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)V

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 352
    :goto_0
    return-void

    .line 348
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 535
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 536
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 537
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 528
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 529
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 530
    return-void
.end method
