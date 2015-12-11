.class public Lcom/aio/downloader/activity/MiniGameDetails;
.super Landroid/app/Activity;
.source "MiniGameDetails.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field private static typeFace:Landroid/graphics/Typeface;


# instance fields
.field private adView:Lcom/google/ads/AdView;

.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private backtv:Landroid/widget/TextView;

.field private banner:Landroid/widget/LinearLayout;

.field private banner_type_name:Ljava/lang/String;

.field private dec:Landroid/widget/TextView;

.field private detailfan:Landroid/widget/ImageView;

.field private detailplaytop:Landroid/widget/Button;

.field private gamedetailplaybottom:Landroid/widget/Button;

.field private id:I

.field private list:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/MiniGameModel;",
            ">;"
        }
    .end annotation
.end field

.field private minigame_ratingbar:Landroid/widget/RatingBar;

.field private minigamehints:Landroid/widget/TextView;

.field private minigameicon:Landroid/widget/ImageView;

.field private minigametitle:Landroid/widget/TextView;

.field private sp_config:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    const/4 v0, 0x0

    sput-object v0, Lcom/aio/downloader/activity/MiniGameDetails;->typeFace:Landroid/graphics/Typeface;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 42
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->sp_config:Landroid/content/SharedPreferences;

    .line 28
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MiniGameDetails;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->list:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/MiniGameDetails;)I
    .locals 1

    .prologue
    .line 44
    iget v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->id:I

    return v0
.end method

.method private buildListener()V
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->detailfan:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 148
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->gamedetailplaybottom:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 149
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->detailplaytop:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 150
    return-void
.end method

.method private getData()V
    .locals 4

    .prologue
    .line 97
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGameDetails;->minigametitle:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->list:Ljava/util/ArrayList;

    iget v2, p0, Lcom/aio/downloader/activity/MiniGameDetails;->id:I

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v0}, Lcom/aio/downloader/model/MiniGameModel;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 98
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGameDetails;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->list:Ljava/util/ArrayList;

    iget v2, p0, Lcom/aio/downloader/activity/MiniGameDetails;->id:I

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v0}, Lcom/aio/downloader/model/MiniGameModel;->getIcon()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/aio/downloader/activity/MiniGameDetails;->minigameicon:Landroid/widget/ImageView;

    invoke-virtual {v1, v0, v2}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 99
    iget v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->id:I

    rem-int/lit8 v0, v0, 0x2

    if-nez v0, :cond_0

    .line 100
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->minigame_ratingbar:Landroid/widget/RatingBar;

    const/high16 v1, 0x40800000    # 4.0f

    invoke-virtual {v0, v1}, Landroid/widget/RatingBar;->setRating(F)V

    .line 104
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGameDetails;->minigamehints:Landroid/widget/TextView;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v0, "More than "

    invoke-direct {v2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->list:Ljava/util/ArrayList;

    iget v3, p0, Lcom/aio/downloader/activity/MiniGameDetails;->id:I

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v0}, Lcom/aio/downloader/model/MiniGameModel;->getHits()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 105
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGameDetails;->dec:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->list:Ljava/util/ArrayList;

    iget v2, p0, Lcom/aio/downloader/activity/MiniGameDetails;->id:I

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v0}, Lcom/aio/downloader/model/MiniGameModel;->getDetail()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 106
    return-void

    .line 102
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->minigame_ratingbar:Landroid/widget/RatingBar;

    const/high16 v1, 0x40a00000    # 5.0f

    invoke-virtual {v0, v1}, Landroid/widget/RatingBar;->setRating(F)V

    goto :goto_0
.end method

.method private init()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 59
    const v0, 0x7f070098

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGameDetails;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->detailfan:Landroid/widget/ImageView;

    .line 60
    const v0, 0x7f0702cf

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGameDetails;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->backtv:Landroid/widget/TextView;

    .line 61
    const v0, 0x7f0702c9

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGameDetails;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->minigameicon:Landroid/widget/ImageView;

    .line 62
    const v0, 0x7f0702ca

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGameDetails;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->minigametitle:Landroid/widget/TextView;

    .line 63
    const v0, 0x7f0702cb

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGameDetails;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RatingBar;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->minigame_ratingbar:Landroid/widget/RatingBar;

    .line 64
    const v0, 0x7f0702cc

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGameDetails;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->minigamehints:Landroid/widget/TextView;

    .line 65
    const v0, 0x7f0700a5

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGameDetails;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->detailplaytop:Landroid/widget/Button;

    .line 66
    const v0, 0x7f0702d1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGameDetails;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->dec:Landroid/widget/TextView;

    .line 67
    const v0, 0x7f0702d2

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGameDetails;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->gamedetailplaybottom:Landroid/widget/Button;

    .line 68
    const v0, 0x7f070059

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGameDetails;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->banner:Landroid/widget/LinearLayout;

    .line 69
    const-string v0, "banner_type"

    invoke-virtual {p0, v0, v1}, Lcom/aio/downloader/activity/MiniGameDetails;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->sp_config:Landroid/content/SharedPreferences;

    .line 70
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MiniGameDetails;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 71
    const-string v1, "font.ttf"

    .line 70
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/activity/MiniGameDetails;->typeFace:Landroid/graphics/Typeface;

    .line 72
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->backtv:Landroid/widget/TextView;

    sget-object v1, Lcom/aio/downloader/activity/MiniGameDetails;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 75
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MiniGameDetails;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 76
    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    .line 75
    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 81
    :goto_0
    :try_start_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MiniGameDetails;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "pos"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->id:I

    .line 82
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MiniGameDetails;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 83
    const-string v1, "list"

    .line 82
    invoke-virtual {v0, v1}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->list:Ljava/util/ArrayList;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 87
    :goto_1
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->sp_config:Landroid/content/SharedPreferences;

    const-string v1, "banner_type"

    const-string v2, "admob"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->banner_type_name:Ljava/lang/String;

    .line 88
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->banner_type_name:Ljava/lang/String;

    const-string v1, "admob"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 89
    new-instance v0, Lcom/google/ads/AdView;

    sget-object v1, Lcom/google/ads/AdSize;->SMART_BANNER:Lcom/google/ads/AdSize;

    .line 90
    const-string v2, "ca-app-pub-2192624499353475/5842010949"

    invoke-direct {v0, p0, v1, v2}, Lcom/google/ads/AdView;-><init>(Landroid/app/Activity;Lcom/google/ads/AdSize;Ljava/lang/String;)V

    .line 89
    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->adView:Lcom/google/ads/AdView;

    .line 91
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->banner:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGameDetails;->adView:Lcom/google/ads/AdView;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 92
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGameDetails;->adView:Lcom/google/ads/AdView;

    new-instance v1, Lcom/google/ads/AdRequest;

    invoke-direct {v1}, Lcom/google/ads/AdRequest;-><init>()V

    invoke-virtual {v0, v1}, Lcom/google/ads/AdView;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 94
    :cond_0
    return-void

    .line 84
    :catch_0
    move-exception v0

    goto :goto_1

    .line 78
    :catch_1
    move-exception v0

    goto :goto_0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 110
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    sparse-switch v2, :sswitch_data_0

    .line 144
    :goto_0
    return-void

    .line 112
    :sswitch_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MiniGameDetails;->finish()V

    goto :goto_0

    .line 115
    :sswitch_1
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/aio/downloader/activity/MiniGameDetails$1;

    invoke-direct {v3, p0}, Lcom/aio/downloader/activity/MiniGameDetails$1;-><init>(Lcom/aio/downloader/activity/MiniGameDetails;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 120
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 121
    new-instance v0, Landroid/content/Intent;

    .line 122
    const-class v2, Lcom/aio/downloader/activity/MiniGamePlayActivity;

    .line 121
    invoke-direct {v0, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 123
    .local v0, "ti":Landroid/content/Intent;
    const-string v3, "playurl"

    iget-object v2, p0, Lcom/aio/downloader/activity/MiniGameDetails;->list:Ljava/util/ArrayList;

    iget v4, p0, Lcom/aio/downloader/activity/MiniGameDetails;->id:I

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/MiniGameModel;->getPlay_url()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 124
    const-string v3, "proc"

    iget-object v2, p0, Lcom/aio/downloader/activity/MiniGameDetails;->list:Ljava/util/ArrayList;

    iget v4, p0, Lcom/aio/downloader/activity/MiniGameDetails;->id:I

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/MiniGameModel;->getProc()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 125
    const-string v3, "sound"

    iget-object v2, p0, Lcom/aio/downloader/activity/MiniGameDetails;->list:Ljava/util/ArrayList;

    iget v4, p0, Lcom/aio/downloader/activity/MiniGameDetails;->id:I

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/MiniGameModel;->getSound()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 126
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGameDetails;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 129
    .end local v0    # "ti":Landroid/content/Intent;
    :sswitch_2
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/aio/downloader/activity/MiniGameDetails$2;

    invoke-direct {v3, p0}, Lcom/aio/downloader/activity/MiniGameDetails$2;-><init>(Lcom/aio/downloader/activity/MiniGameDetails;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 134
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 135
    new-instance v1, Landroid/content/Intent;

    .line 136
    const-class v2, Lcom/aio/downloader/activity/MiniGamePlayActivity;

    .line 135
    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 137
    .local v1, "ti2":Landroid/content/Intent;
    const-string v3, "playurl"

    iget-object v2, p0, Lcom/aio/downloader/activity/MiniGameDetails;->list:Ljava/util/ArrayList;

    iget v4, p0, Lcom/aio/downloader/activity/MiniGameDetails;->id:I

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/MiniGameModel;->getPlay_url()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 138
    const-string v3, "proc"

    iget-object v2, p0, Lcom/aio/downloader/activity/MiniGameDetails;->list:Ljava/util/ArrayList;

    iget v4, p0, Lcom/aio/downloader/activity/MiniGameDetails;->id:I

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/MiniGameModel;->getProc()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 139
    const-string v3, "sound"

    iget-object v2, p0, Lcom/aio/downloader/activity/MiniGameDetails;->list:Ljava/util/ArrayList;

    iget v4, p0, Lcom/aio/downloader/activity/MiniGameDetails;->id:I

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/MiniGameModel;->getSound()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 140
    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/MiniGameDetails;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 110
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f070098 -> :sswitch_0
        0x7f0700a5 -> :sswitch_1
        0x7f0702d2 -> :sswitch_2
    .end sparse-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 50
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 51
    const v0, 0x7f030075

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGameDetails;->setContentView(I)V

    .line 52
    invoke-direct {p0}, Lcom/aio/downloader/activity/MiniGameDetails;->init()V

    .line 53
    invoke-direct {p0}, Lcom/aio/downloader/activity/MiniGameDetails;->buildListener()V

    .line 54
    invoke-direct {p0}, Lcom/aio/downloader/activity/MiniGameDetails;->getData()V

    .line 55
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 162
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 163
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 164
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 155
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 156
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 157
    return-void
.end method
