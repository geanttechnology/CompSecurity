.class public Lcom/aio/downloader/adapter/FunAllAdapter;
.super Landroid/widget/BaseAdapter;
.source "FunAllAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;
    }
.end annotation


# instance fields
.field private adView:Lcom/facebook/ads/AdView;

.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private bitmap:Landroid/graphics/Bitmap;

.field private ctx:Landroid/content/Context;

.field private fd_errer:Z

.field private h:I

.field holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

.field private list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/FunModel;",
            ">;"
        }
    .end annotation
.end field

.field private nativeAd:Lcom/facebook/ads/NativeAd;

.field private typeFace:Landroid/graphics/Typeface;

.field private typeFace2:Landroid/graphics/Typeface;

.field private w:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;Lcom/facebook/ads/NativeAd;Z)V
    .locals 2
    .param p1, "ctx"    # Landroid/content/Context;
    .param p3, "nativeAd"    # Lcom/facebook/ads/NativeAd;
    .param p4, "fd_errer"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/FunModel;",
            ">;",
            "Lcom/facebook/ads/NativeAd;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 47
    .local p2, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/model/FunModel;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 44
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    .line 49
    iput-object p1, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->ctx:Landroid/content/Context;

    .line 50
    iput-object p2, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    .line 51
    iput-object p3, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 52
    iput-boolean p4, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->fd_errer:Z

    .line 54
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v0, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 59
    :goto_0
    :try_start_1
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 60
    const-string v1, "Roboto-Light.ttf"

    .line 59
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->typeFace:Landroid/graphics/Typeface;

    .line 62
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 63
    const-string v1, "Roboto-Condensed.ttf"

    .line 62
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->typeFace2:Landroid/graphics/Typeface;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 69
    :goto_1
    return-void

    .line 65
    :catch_0
    move-exception v0

    goto :goto_1

    .line 55
    :catch_1
    move-exception v0

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/FunAllAdapter;)Ljava/util/List;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/FunAllAdapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method private static addComma(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 610
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, p0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->reverse()Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 611
    .local v2, "reverseStr":Ljava/lang/String;
    const-string v3, ""

    .line 612
    .local v3, "strTemp":Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    if-lt v0, v4, :cond_1

    .line 620
    :goto_1
    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 621
    const/4 v4, 0x0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 624
    :cond_0
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->reverse()Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 625
    .local v1, "resultStr":Ljava/lang/String;
    return-object v1

    .line 613
    .end local v1    # "resultStr":Ljava/lang/String;
    :cond_1
    mul-int/lit8 v4, v0, 0x3

    add-int/lit8 v4, v4, 0x3

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    if-le v4, v5, :cond_2

    .line 614
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    mul-int/lit8 v5, v0, 0x3

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v6

    invoke-virtual {v2, v5, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 615
    goto :goto_1

    .line 617
    :cond_2
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    mul-int/lit8 v5, v0, 0x3

    mul-int/lit8 v6, v0, 0x3

    add-int/lit8 v6, v6, 0x3

    invoke-virtual {v2, v5, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 612
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 75
    iget-object v0, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 77
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getHeight(II)I
    .locals 1
    .param p1, "with"    # I
    .param p2, "height"    # I

    .prologue
    .line 604
    iget-object v0, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    mul-int/2addr v0, p2

    div-int/2addr v0, p1

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 85
    iget-object v0, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 91
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 11
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "arg2"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v10, 0x0

    const/16 v9, 0x8

    .line 99
    if-nez p2, :cond_2

    .line 100
    new-instance v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    invoke-direct {v5, p0}, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/FunAllAdapter;)V

    iput-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    .line 101
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->ctx:Landroid/content/Context;

    const v6, 0x7f03004f

    const/4 v7, 0x0

    invoke-static {v5, v6, v7}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 102
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    const v5, 0x7f0701fb

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->tv_fun:Landroid/widget/TextView;

    .line 103
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    const v5, 0x7f0701fc

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->iv_fun:Landroid/widget/ImageView;

    .line 104
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    .line 105
    const v5, 0x7f0701fe

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 104
    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->tv_funadult_like:Landroid/widget/TextView;

    .line 106
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    .line 107
    const v5, 0x7f070200

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 106
    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->tv_funadult_share:Landroid/widget/TextView;

    .line 108
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    .line 109
    const v5, 0x7f070201

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 108
    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->tv_funadult_time:Landroid/widget/TextView;

    .line 110
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    const v5, 0x7f070203

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_share:Landroid/widget/Button;

    .line 111
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    .line 112
    const v5, 0x7f070202

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    .line 111
    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->rl_like:Landroid/widget/RelativeLayout;

    .line 113
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    const v5, 0x7f070205

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_pics:Landroid/widget/Button;

    .line 114
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    const v5, 0x7f0701fd

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_gif:Landroid/widget/Button;

    .line 115
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    const v5, 0x7f070204

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_video:Landroid/widget/Button;

    .line 116
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    .line 117
    const v5, 0x7f0701f4

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 116
    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->fun_fd_tv_title:Landroid/widget/TextView;

    .line 118
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    .line 119
    const v5, 0x7f0701f5

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    .line 118
    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->fun_fd_iv:Landroid/widget/ImageView;

    .line 120
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    .line 121
    const v5, 0x7f07020c

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    .line 120
    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->lin_fd:Landroid/widget/LinearLayout;

    .line 122
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    .line 123
    const v5, 0x7f0701f3

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    .line 122
    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->lin_fd_dia:Landroid/widget/LinearLayout;

    .line 124
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    .line 125
    const v5, 0x7f07020b

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 124
    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->tv_funadult_download:Landroid/widget/TextView;

    .line 126
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    const v6, 0x7f070206

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    iput-object v6, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->v_fun_top:Landroid/view/View;

    .line 128
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    .line 129
    const v5, 0x7f070207

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    .line 128
    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->ll_fun_share:Landroid/widget/LinearLayout;

    .line 130
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    .line 131
    const v5, 0x7f070208

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    .line 130
    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->ll_fun_like:Landroid/widget/LinearLayout;

    .line 132
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    .line 133
    const v5, 0x7f070209

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    .line 132
    iput-object v5, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->iv_like_new:Landroid/widget/ImageView;

    .line 134
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    invoke-virtual {p2, v5}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 139
    :goto_0
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v5}, Lcom/facebook/ads/NativeAd;->getAdCoverImage()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 140
    .local v0, "adIcon":Lcom/facebook/ads/NativeAd$Image;
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->fun_fd_iv:Landroid/widget/ImageView;

    invoke-static {v0, v5}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 141
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->fun_fd_tv_title:Landroid/widget/TextView;

    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v6}, Lcom/facebook/ads/NativeAd;->getAdTitle()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 142
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->nativeAd:Lcom/facebook/ads/NativeAd;

    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v6, v6, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->lin_fd_dia:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v6}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 144
    if-nez p1, :cond_3

    .line 145
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->v_fun_top:Landroid/view/View;

    invoke-virtual {v5, v10}, Landroid/view/View;->setVisibility(I)V

    .line 150
    :goto_1
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v5, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v5}, Lcom/aio/downloader/model/FunModel;->isLikenum()Z

    move-result v5

    if-eqz v5, :cond_4

    .line 151
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->iv_like_new:Landroid/widget/ImageView;

    const v6, 0x7f0200bd

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 183
    :goto_2
    const-string v6, "www"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v5, "in_fo.getTitle()="

    invoke-direct {v7, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v5, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v5}, Lcom/aio/downloader/model/FunModel;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v6, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 184
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v6, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->tv_fun:Landroid/widget/TextView;

    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v5, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v5}, Lcom/aio/downloader/model/FunModel;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 185
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->tv_funadult_like:Landroid/widget/TextView;

    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 186
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->tv_funadult_share:Landroid/widget/TextView;

    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 187
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->tv_funadult_download:Landroid/widget/TextView;

    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 188
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v6, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->tv_funadult_like:Landroid/widget/TextView;

    new-instance v7, Ljava/lang/StringBuilder;

    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v5, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/model/FunModel;

    .line 189
    invoke-virtual {v5}, Lcom/aio/downloader/model/FunModel;->getLike_count()Ljava/lang/String;

    move-result-object v5

    .line 188
    invoke-static {v5}, Lcom/aio/downloader/adapter/FunAllAdapter;->addComma(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v7, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 190
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v6, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->tv_funadult_share:Landroid/widget/TextView;

    new-instance v7, Ljava/lang/StringBuilder;

    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v5, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/model/FunModel;

    .line 191
    invoke-virtual {v5}, Lcom/aio/downloader/model/FunModel;->getShare_count()Ljava/lang/String;

    move-result-object v5

    .line 190
    invoke-static {v5}, Lcom/aio/downloader/adapter/FunAllAdapter;->addComma(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v7, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 192
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v6, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->tv_funadult_download:Landroid/widget/TextView;

    new-instance v7, Ljava/lang/StringBuilder;

    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v5, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/model/FunModel;

    .line 193
    invoke-virtual {v5}, Lcom/aio/downloader/model/FunModel;->getSave()Ljava/lang/String;

    move-result-object v5

    .line 192
    invoke-static {v5}, Lcom/aio/downloader/adapter/FunAllAdapter;->addComma(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v7, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 196
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v5, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v5}, Lcom/aio/downloader/model/FunModel;->getCreate_time()Ljava/lang/String;

    move-result-object v4

    .line 197
    .local v4, "time1":Ljava/lang/String;
    invoke-static {v4}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v5

    const-wide/16 v7, 0x3e8

    mul-long v2, v5, v7

    .line 198
    .local v2, "time":J
    const-string v5, "www"

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "time="

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 199
    const-string v5, "MM"

    invoke-static {v5, v2, v3}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 200
    .local v1, "month":Ljava/lang/String;
    const-string v5, "01"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 201
    const-string v1, "Jan"

    .line 226
    :cond_0
    :goto_3
    :try_start_0
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->tv_funadult_time:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 227
    const-string v7, " dd, yyyy"

    invoke-static {v7, v2, v3}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 226
    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 230
    :goto_4
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v5, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v5}, Lcom/aio/downloader/model/FunModel;->getCat()Ljava/lang/String;

    move-result-object v5

    const-string v6, "adult"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_10

    .line 231
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v6, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_pics:Landroid/widget/Button;

    new-instance v7, Ljava/lang/StringBuilder;

    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v5, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v5}, Lcom/aio/downloader/model/FunModel;->getImg_count()I

    move-result v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v7, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, " pics"

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 232
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_gif:Landroid/widget/Button;

    invoke-virtual {v5, v9}, Landroid/widget/Button;->setVisibility(I)V

    .line 233
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_video:Landroid/widget/Button;

    invoke-virtual {v5, v9}, Landroid/widget/Button;->setVisibility(I)V

    .line 234
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_pics:Landroid/widget/Button;

    invoke-virtual {v5, v10}, Landroid/widget/Button;->setVisibility(I)V

    .line 235
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->iv_fun:Landroid/widget/ImageView;

    new-instance v6, Lcom/aio/downloader/adapter/FunAllAdapter$1;

    invoke-direct {v6, p0, p1}, Lcom/aio/downloader/adapter/FunAllAdapter$1;-><init>(Lcom/aio/downloader/adapter/FunAllAdapter;I)V

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 272
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_pics:Landroid/widget/Button;

    new-instance v6, Lcom/aio/downloader/adapter/FunAllAdapter$2;

    invoke-direct {v6, p0, p1}, Lcom/aio/downloader/adapter/FunAllAdapter$2;-><init>(Lcom/aio/downloader/adapter/FunAllAdapter;I)V

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 468
    :cond_1
    :goto_5
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->iv_like_new:Landroid/widget/ImageView;

    new-instance v6, Lcom/aio/downloader/adapter/FunAllAdapter$8;

    invoke-direct {v6, p0, p1}, Lcom/aio/downloader/adapter/FunAllAdapter$8;-><init>(Lcom/aio/downloader/adapter/FunAllAdapter;I)V

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 523
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->ll_fun_share:Landroid/widget/LinearLayout;

    new-instance v6, Lcom/aio/downloader/adapter/FunAllAdapter$9;

    invoke-direct {v6, p0, p1}, Lcom/aio/downloader/adapter/FunAllAdapter$9;-><init>(Lcom/aio/downloader/adapter/FunAllAdapter;I)V

    invoke-virtual {v5, v6}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 584
    :try_start_1
    iget-object v6, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v5, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v5}, Lcom/aio/downloader/model/FunModel;->getThu_path()Ljava/lang/String;

    move-result-object v5

    iget-object v7, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v7, v7, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->iv_fun:Landroid/widget/ImageView;

    invoke-virtual {v6, v5, v7}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage1(Ljava/lang/String;Landroid/widget/ImageView;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 589
    :goto_6
    return-object p2

    .line 136
    .end local v0    # "adIcon":Lcom/facebook/ads/NativeAd$Image;
    .end local v1    # "month":Ljava/lang/String;
    .end local v2    # "time":J
    .end local v4    # "time1":Ljava/lang/String;
    :cond_2
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iput-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    goto/16 :goto_0

    .line 147
    .restart local v0    # "adIcon":Lcom/facebook/ads/NativeAd$Image;
    :cond_3
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->v_fun_top:Landroid/view/View;

    invoke-virtual {v5, v9}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_1

    .line 153
    :cond_4
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->iv_like_new:Landroid/widget/ImageView;

    const v6, 0x7f0200bc

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_2

    .line 202
    .restart local v1    # "month":Ljava/lang/String;
    .restart local v2    # "time":J
    .restart local v4    # "time1":Ljava/lang/String;
    :cond_5
    const-string v5, "02"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 203
    const-string v1, "Feb"

    .line 204
    goto/16 :goto_3

    :cond_6
    const-string v5, "03"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 205
    const-string v1, "Mar"

    .line 206
    goto/16 :goto_3

    :cond_7
    const-string v5, "04"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 207
    const-string v1, "Apr"

    .line 208
    goto/16 :goto_3

    :cond_8
    const-string v5, "05"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_9

    .line 209
    const-string v1, "May"

    .line 210
    goto/16 :goto_3

    :cond_9
    const-string v5, "06"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_a

    .line 211
    const-string v1, "June"

    .line 212
    goto/16 :goto_3

    :cond_a
    const-string v5, "07"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_b

    .line 213
    const-string v1, "July"

    .line 214
    goto/16 :goto_3

    :cond_b
    const-string v5, "08"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_c

    .line 215
    const-string v1, "Aug"

    .line 216
    goto/16 :goto_3

    :cond_c
    const-string v5, "09"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_d

    .line 217
    const-string v1, "Sept"

    .line 218
    goto/16 :goto_3

    :cond_d
    const-string v5, "10"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_e

    .line 219
    const-string v1, "Oct"

    .line 220
    goto/16 :goto_3

    :cond_e
    const-string v5, "11"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_f

    .line 221
    const-string v1, "Nov"

    .line 222
    goto/16 :goto_3

    :cond_f
    const-string v5, "12"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 223
    const-string v1, "Dec"

    goto/16 :goto_3

    .line 308
    :cond_10
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v5, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v5}, Lcom/aio/downloader/model/FunModel;->getCat()Ljava/lang/String;

    move-result-object v5

    const-string v6, "gif"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_11

    .line 309
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_pics:Landroid/widget/Button;

    invoke-virtual {v5, v9}, Landroid/widget/Button;->setVisibility(I)V

    .line 310
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_video:Landroid/widget/Button;

    invoke-virtual {v5, v9}, Landroid/widget/Button;->setVisibility(I)V

    .line 311
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_gif:Landroid/widget/Button;

    invoke-virtual {v5, v10}, Landroid/widget/Button;->setVisibility(I)V

    .line 313
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->iv_fun:Landroid/widget/ImageView;

    new-instance v6, Lcom/aio/downloader/adapter/FunAllAdapter$3;

    invoke-direct {v6, p0, p1}, Lcom/aio/downloader/adapter/FunAllAdapter$3;-><init>(Lcom/aio/downloader/adapter/FunAllAdapter;I)V

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 344
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_gif:Landroid/widget/Button;

    new-instance v6, Lcom/aio/downloader/adapter/FunAllAdapter$4;

    invoke-direct {v6, p0, p1}, Lcom/aio/downloader/adapter/FunAllAdapter$4;-><init>(Lcom/aio/downloader/adapter/FunAllAdapter;I)V

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_5

    .line 377
    :cond_11
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v5, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v5}, Lcom/aio/downloader/model/FunModel;->getCat()Ljava/lang/String;

    move-result-object v5

    const-string v6, "video"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_12

    .line 378
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_gif:Landroid/widget/Button;

    invoke-virtual {v5, v9}, Landroid/widget/Button;->setVisibility(I)V

    .line 379
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_pics:Landroid/widget/Button;

    invoke-virtual {v5, v9}, Landroid/widget/Button;->setVisibility(I)V

    .line 380
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_video:Landroid/widget/Button;

    invoke-virtual {v5, v10}, Landroid/widget/Button;->setVisibility(I)V

    .line 381
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->iv_fun:Landroid/widget/ImageView;

    new-instance v6, Lcom/aio/downloader/adapter/FunAllAdapter$5;

    invoke-direct {v6, p0, p1}, Lcom/aio/downloader/adapter/FunAllAdapter$5;-><init>(Lcom/aio/downloader/adapter/FunAllAdapter;I)V

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 405
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_video:Landroid/widget/Button;

    new-instance v6, Lcom/aio/downloader/adapter/FunAllAdapter$6;

    invoke-direct {v6, p0, p1}, Lcom/aio/downloader/adapter/FunAllAdapter$6;-><init>(Lcom/aio/downloader/adapter/FunAllAdapter;I)V

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_5

    .line 429
    :cond_12
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;

    invoke-interface {v5, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v5}, Lcom/aio/downloader/model/FunModel;->getCat()Ljava/lang/String;

    move-result-object v5

    const-string v6, "gag"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 430
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_gif:Landroid/widget/Button;

    invoke-virtual {v5, v9}, Landroid/widget/Button;->setVisibility(I)V

    .line 431
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_pics:Landroid/widget/Button;

    invoke-virtual {v5, v9}, Landroid/widget/Button;->setVisibility(I)V

    .line 432
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->bt_video:Landroid/widget/Button;

    invoke-virtual {v5, v9}, Landroid/widget/Button;->setVisibility(I)V

    .line 433
    iget-object v5, p0, Lcom/aio/downloader/adapter/FunAllAdapter;->holder:Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->iv_fun:Landroid/widget/ImageView;

    new-instance v6, Lcom/aio/downloader/adapter/FunAllAdapter$7;

    invoke-direct {v6, p0, p1}, Lcom/aio/downloader/adapter/FunAllAdapter$7;-><init>(Lcom/aio/downloader/adapter/FunAllAdapter;I)V

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_5

    .line 585
    :catch_0
    move-exception v5

    goto/16 :goto_6

    .line 228
    :catch_1
    move-exception v5

    goto/16 :goto_4
.end method
