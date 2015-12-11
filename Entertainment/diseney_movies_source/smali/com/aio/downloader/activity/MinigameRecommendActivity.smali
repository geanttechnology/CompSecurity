.class public Lcom/aio/downloader/activity/MinigameRecommendActivity;
.super Landroid/app/Activity;
.source "MinigameRecommendActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;
    }
.end annotation


# instance fields
.field private adapter:Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;

.field private gamekeywords:Ljava/lang/String;

.field private list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/SearchkeywordModel;",
            ">;"
        }
    .end annotation
.end field

.field private progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private progressheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private search_view:Lcom/aio/downloader/views/DeletableEditText;

.field private searchfan:Landroid/widget/ImageView;

.field private searchimg:Landroid/widget/ImageView;

.field private serchgridview:Landroid/widget/GridView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 29
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 37
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->gamekeywords:Ljava/lang/String;

    .line 29
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/MinigameRecommendActivity;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->list:Ljava/util/List;

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->list:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/MinigameRecommendActivity;Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->adapter:Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Landroid/widget/GridView;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->serchgridview:Landroid/widget/GridView;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->adapter:Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->progressheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Lcom/aio/downloader/views/DeletableEditText;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/MinigameRecommendActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 37
    iput-object p1, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->gamekeywords:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/MinigameRecommendActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->gamekeywords:Ljava/lang/String;

    return-object v0
.end method

.method private buildListener()V
    .locals 2

    .prologue
    .line 62
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->searchfan:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 64
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->serchgridview:Landroid/widget/GridView;

    new-instance v1, Lcom/aio/downloader/activity/MinigameRecommendActivity$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MinigameRecommendActivity$1;-><init>(Lcom/aio/downloader/activity/MinigameRecommendActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/GridView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 76
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    new-instance v1, Lcom/aio/downloader/activity/MinigameRecommendActivity$2;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MinigameRecommendActivity$2;-><init>(Lcom/aio/downloader/activity/MinigameRecommendActivity;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/DeletableEditText;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 102
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->searchimg:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/activity/MinigameRecommendActivity$3;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MinigameRecommendActivity$3;-><init>(Lcom/aio/downloader/activity/MinigameRecommendActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 120
    return-void
.end method

.method private init()V
    .locals 2

    .prologue
    const v1, 0x7f070072

    .line 52
    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 53
    const v0, 0x7f0702db

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->searchfan:Landroid/widget/ImageView;

    .line 54
    const v0, 0x7f0702dd

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/GridView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->serchgridview:Landroid/widget/GridView;

    .line 55
    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->progressheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 56
    const v0, 0x7f0702dc

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/DeletableEditText;

    iput-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    .line 57
    const v0, 0x7f07015c

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MinigameRecommendActivity;->searchimg:Landroid/widget/ImageView;

    .line 59
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 168
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 174
    :goto_0
    return-void

    .line 170
    :pswitch_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->finish()V

    goto :goto_0

    .line 168
    :pswitch_data_0
    .packed-switch 0x7f0702db
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 42
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 43
    const v0, 0x7f030078

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->setContentView(I)V

    .line 45
    invoke-direct {p0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->init()V

    .line 46
    invoke-direct {p0}, Lcom/aio/downloader/activity/MinigameRecommendActivity;->buildListener()V

    .line 47
    new-instance v0, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;-><init>(Lcom/aio/downloader/activity/MinigameRecommendActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MinigameRecommendActivity$Minigamekeywords;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 49
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 185
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 186
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 187
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 178
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 179
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 180
    return-void
.end method
