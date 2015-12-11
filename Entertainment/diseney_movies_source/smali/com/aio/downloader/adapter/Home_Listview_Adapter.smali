.class public Lcom/aio/downloader/adapter/Home_Listview_Adapter;
.super Landroid/widget/BaseAdapter;
.source "Home_Listview_Adapter.java"

# interfaces
.implements Lcom/aio/downloader/mydownload/ContentValue;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;
    }
.end annotation


# instance fields
.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private apptag:Ljava/lang/String;

.field private biaoshi:I

.field private ctx:Landroid/content/Context;

.field private funarray:Ljava/util/ArrayList;

.field holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

.field private list_fun:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/FunModel;",
            ">;"
        }
    .end annotation
.end field

.field private listdata:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;>;"
        }
    .end annotation
.end field

.field private shuliang:I

.field private typeFace:Landroid/graphics/Typeface;

.field private typeFace2:Landroid/graphics/Typeface;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 2
    .param p1, "ctx"    # Landroid/content/Context;
    .param p3, "apptag"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;>;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/FunModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, "listdata":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;>;"
    .local p4, "list_fun":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/model/FunModel;>;"
    const/4 v0, 0x0

    .line 52
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 41
    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->typeFace:Landroid/graphics/Typeface;

    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->typeFace2:Landroid/graphics/Typeface;

    .line 47
    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 48
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->biaoshi:I

    .line 49
    const/4 v0, 0x5

    iput v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->shuliang:I

    .line 50
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->funarray:Ljava/util/ArrayList;

    .line 56
    iput-object p2, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->listdata:Ljava/util/ArrayList;

    .line 57
    iput-object p3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->apptag:Ljava/lang/String;

    .line 58
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->ctx:Landroid/content/Context;

    .line 59
    iput-object p4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    .line 61
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 62
    const-string v1, "Roboto-Light.ttf"

    .line 61
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->typeFace:Landroid/graphics/Typeface;

    .line 63
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 64
    const-string v1, "Roboto-Condensed.ttf"

    .line 63
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->typeFace2:Landroid/graphics/Typeface;

    .line 65
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 68
    :goto_0
    return-void

    .line 66
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/Home_Listview_Adapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/Home_Listview_Adapter;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    return-object v0
.end method

.method private static addComma(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 756
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, p0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->reverse()Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 757
    .local v2, "reverseStr":Ljava/lang/String;
    const-string v3, ""

    .line 758
    .local v3, "strTemp":Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    if-lt v0, v4, :cond_1

    .line 766
    :goto_1
    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 767
    const/4 v4, 0x0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 770
    :cond_0
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->reverse()Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 771
    .local v1, "resultStr":Ljava/lang/String;
    return-object v1

    .line 759
    .end local v1    # "resultStr":Ljava/lang/String;
    :cond_1
    mul-int/lit8 v4, v0, 0x3

    add-int/lit8 v4, v4, 0x3

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    if-le v4, v5, :cond_2

    .line 760
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

    .line 761
    goto :goto_1

    .line 763
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

    .line 758
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->listdata:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 85
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->listdata:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

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
    .locals 9
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const v8, 0x7f0702d5

    const/16 v7, 0x8

    const/4 v6, 0x0

    .line 96
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->listdata:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    .line 98
    .local v2, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    if-nez p2, :cond_0

    .line 99
    new-instance v3, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    invoke-direct {v3, p0}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;)V

    iput-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 100
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->ctx:Landroid/content/Context;

    const v4, 0x7f03006b

    .line 101
    const/4 v5, 0x0

    .line 100
    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 102
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 103
    const v3, 0x7f070283

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 102
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V

    .line 104
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 105
    const v3, 0x7f070284

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 104
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$1(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V

    .line 107
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 108
    const v3, 0x7f070285

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/GridView;

    .line 107
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$2(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/GridView;)V

    .line 109
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 110
    const v3, 0x7f070287

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 109
    iput-object v3, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bannerimg:Landroid/widget/ImageView;

    .line 112
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 113
    const v3, 0x7f070288

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RelativeLayout;

    .line 112
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$3(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/RelativeLayout;)V

    .line 114
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 115
    const v3, 0x7f0702d3

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 114
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$4(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V

    .line 116
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 117
    const v3, 0x7f07022c

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 116
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$5(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/ImageView;)V

    .line 118
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 119
    const v3, 0x7f0702d4

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 118
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$6(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V

    .line 120
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 121
    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    .line 120
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$7(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/Button;)V

    .line 123
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 124
    const v3, 0x7f070282

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RelativeLayout;

    .line 123
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$8(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/RelativeLayout;)V

    .line 125
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 126
    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    .line 125
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$7(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/Button;)V

    .line 127
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 128
    const v3, 0x7f070286

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 127
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$9(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V

    .line 129
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 130
    const v3, 0x7f07028c

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    .line 129
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$10(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/LinearLayout;)V

    .line 132
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    const v3, 0x7f0701fb

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_fun:Landroid/widget/TextView;

    .line 133
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    const v3, 0x7f0701fc

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    iput-object v3, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->iv_fun:Landroid/widget/ImageView;

    .line 134
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 135
    const v3, 0x7f0701fe

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 134
    iput-object v3, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_funadult_like:Landroid/widget/TextView;

    .line 136
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 137
    const v3, 0x7f070200

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 136
    iput-object v3, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_funadult_share:Landroid/widget/TextView;

    .line 138
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 139
    const v3, 0x7f070201

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 138
    iput-object v3, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_funadult_time:Landroid/widget/TextView;

    .line 140
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    const v3, 0x7f070203

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_share:Landroid/widget/Button;

    .line 141
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 142
    const v3, 0x7f070202

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RelativeLayout;

    .line 141
    iput-object v3, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->rl_like:Landroid/widget/RelativeLayout;

    .line 143
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    const v3, 0x7f070205

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_pics:Landroid/widget/Button;

    .line 144
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    const v3, 0x7f0701fd

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_gif:Landroid/widget/Button;

    .line 145
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    const v3, 0x7f070204

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_video:Landroid/widget/Button;

    .line 146
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    const v3, 0x7f07022d

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$11(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V

    .line 147
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 148
    const v3, 0x7f07028d

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 147
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$12(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V

    .line 149
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    const v3, 0x7f070289

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$13(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V

    .line 150
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 151
    const v3, 0x7f07020b

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 150
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$14(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/TextView;)V

    .line 152
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 153
    const v3, 0x7f07028a

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RelativeLayout;

    .line 152
    iput-object v3, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_title:Landroid/widget/RelativeLayout;

    .line 154
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 155
    const v3, 0x7f07028b

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 154
    iput-object v3, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_more:Landroid/widget/TextView;

    .line 156
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 157
    const v3, 0x7f070209

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 156
    iput-object v3, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->iv_like_new:Landroid/widget/ImageView;

    .line 158
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    .line 159
    const v3, 0x7f070207

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    .line 158
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$15(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;Landroid/widget/LinearLayout;)V

    .line 160
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    invoke-virtual {p2, v3}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 164
    :goto_0
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->lv_gv_tvtitle:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$16(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v4

    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getInfotitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 165
    new-instance v1, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->ctx:Landroid/content/Context;

    .line 166
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->apptag:Ljava/lang/String;

    .line 165
    invoke-direct {v1, v3, v2, v4}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;)V

    .line 167
    .local v1, "gvadapter":Lcom/aio/downloader/adapter/Home_Gridview_Adapter;
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->lv_gv_gridview:Landroid/widget/GridView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$17(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/GridView;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/widget/GridView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 169
    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getBannerstatus()Ljava/lang/String;

    move-result-object v3

    const-string v4, "1"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 171
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v3, v3, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bannerimg:Landroid/widget/ImageView;

    invoke-virtual {v3, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 173
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getBannericon()Ljava/lang/String;

    move-result-object v3

    .line 174
    iget-object v5, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v5, v5, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bannerimg:Landroid/widget/ImageView;

    .line 173
    invoke-virtual {v4, v3, v5}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage1(Ljava/lang/String;Landroid/widget/ImageView;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 179
    :goto_1
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->gridviewtv:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$18(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 189
    :goto_2
    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMinigamestatus()Ljava/lang/String;

    move-result-object v3

    const-string v4, "1"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 190
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigamelist2:Landroid/widget/RelativeLayout;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$19(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/RelativeLayout;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 191
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_game:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$20(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 196
    :goto_3
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigametitle:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$21(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v4

    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMinigametitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 197
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMinigameicon()Ljava/lang/String;

    move-result-object v3

    iget-object v5, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigameicon:Landroid/widget/ImageView;
    invoke-static {v5}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$22(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v5

    invoke-virtual {v4, v3, v5}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 198
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigamedetail:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$23(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v4

    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getDetail()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 199
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v3, v3, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_more:Landroid/widget/TextView;

    new-instance v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$1;-><init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;)V

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 207
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->lv_gv_tvsearch:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$24(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    new-instance v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$2;

    invoke-direct {v4, p0, v2}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$2;-><init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;Ljava/util/ArrayList;)V

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 218
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->lv_gv_gridview:Landroid/widget/GridView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$17(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/GridView;

    move-result-object v3

    new-instance v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$3;

    invoke-direct {v4, p0, v2}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$3;-><init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;Ljava/util/ArrayList;)V

    invoke-virtual {v3, v4}, Landroid/widget/GridView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 232
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v3, v3, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bannerimg:Landroid/widget/ImageView;

    new-instance v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$4;

    invoke-direct {v4, p0, v2}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$4;-><init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;Ljava/util/ArrayList;)V

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 241
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigameplaybt:Landroid/widget/Button;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$25(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/Button;

    move-result-object v3

    new-instance v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$5;

    invoke-direct {v4, p0, v2}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$5;-><init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;Ljava/util/ArrayList;)V

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 251
    add-int/lit8 v3, p1, 0x1

    div-int/lit8 v3, v3, 0x4

    add-int/lit8 v0, v3, -0x1

    .line 252
    .local v0, "funpos":I
    add-int/lit8 v3, p1, 0x1

    rem-int/lit8 v3, v3, 0x4

    if-nez v3, :cond_4

    const/16 v3, 0x14

    if-ge v0, v3, :cond_4

    .line 253
    const-string v3, "qwer"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "list_fun.size="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 254
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_3

    .line 255
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->funshouye:Landroid/widget/LinearLayout;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$26(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/LinearLayout;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 256
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_botten:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$27(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 257
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_top:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$28(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 258
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v3, v3, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_title:Landroid/widget/RelativeLayout;

    invoke-virtual {v3, v6}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 262
    invoke-virtual {p0, v0}, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->jiexie(I)V

    .line 264
    const-string v3, "eee"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "biaoshi="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v5, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->biaoshi:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 320
    :goto_4
    return-object p2

    .line 162
    .end local v0    # "funpos":I
    .end local v1    # "gvadapter":Lcom/aio/downloader/adapter/Home_Gridview_Adapter;
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iput-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    goto/16 :goto_0

    .line 183
    .restart local v1    # "gvadapter":Lcom/aio/downloader/adapter/Home_Gridview_Adapter;
    :cond_1
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v3, v3, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bannerimg:Landroid/widget/ImageView;

    invoke-virtual {v3, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 185
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->gridviewtv:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$18(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_2

    .line 193
    :cond_2
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->minigamelist2:Landroid/widget/RelativeLayout;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$19(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/RelativeLayout;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 194
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_game:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$20(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_3

    .line 266
    .restart local v0    # "funpos":I
    :cond_3
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->funshouye:Landroid/widget/LinearLayout;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$26(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/LinearLayout;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 267
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_botten:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$27(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 268
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_top:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$28(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 269
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v3, v3, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_title:Landroid/widget/RelativeLayout;

    invoke-virtual {v3, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_4

    .line 273
    :cond_4
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->funshouye:Landroid/widget/LinearLayout;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$26(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/LinearLayout;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 274
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_botten:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$27(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 275
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_top:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$28(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 276
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v3, v3, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->fun_title:Landroid/widget/RelativeLayout;

    invoke-virtual {v3, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_4

    .line 175
    .end local v0    # "funpos":I
    :catch_0
    move-exception v3

    goto/16 :goto_1
.end method

.method jiexie(I)V
    .locals 10
    .param p1, "ppp"    # I

    .prologue
    const/4 v9, 0x0

    const/16 v8, 0x8

    .line 345
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v5, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_fun:Landroid/widget/TextView;

    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v4}, Lcom/aio/downloader/model/FunModel;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 346
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_funadult_like:Landroid/widget/TextView;

    iget-object v5, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 347
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_funadult_share:Landroid/widget/TextView;

    iget-object v5, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 348
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_funadult_download:Landroid/widget/TextView;
    invoke-static {v4}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$29(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v4

    iget-object v5, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 349
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v5, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_funadult_like:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v4}, Lcom/aio/downloader/model/FunModel;->getLike_count()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->addComma(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v6, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 350
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v5, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_funadult_share:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v4}, Lcom/aio/downloader/model/FunModel;->getShare_count()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->addComma(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v6, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 351
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_funadult_download:Landroid/widget/TextView;
    invoke-static {v4}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$29(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v4}, Lcom/aio/downloader/model/FunModel;->getSave()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->addComma(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v6, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 352
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v4}, Lcom/aio/downloader/model/FunModel;->isLikenum()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 353
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->iv_like_new:Landroid/widget/ImageView;

    const v5, 0x7f0200bd

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 358
    :goto_0
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v4}, Lcom/aio/downloader/model/FunModel;->getCreate_time()Ljava/lang/String;

    move-result-object v3

    .line 359
    .local v3, "time1":Ljava/lang/String;
    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    mul-long v1, v4, v6

    .line 360
    .local v1, "time":J
    const-string v4, "www"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "time="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 361
    const-string v4, "MM"

    invoke-static {v4, v1, v2}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 362
    .local v0, "month":Ljava/lang/String;
    const-string v4, "01"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 363
    const-string v0, "Jan"

    .line 388
    :cond_0
    :goto_1
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->tv_funadult_time:Landroid/widget/TextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 389
    const-string v6, " dd, yyyy"

    invoke-static {v6, v1, v2}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 388
    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 392
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v4}, Lcom/aio/downloader/model/FunModel;->getCat()Ljava/lang/String;

    move-result-object v4

    const-string v5, "adult"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_e

    .line 393
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v5, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_pics:Landroid/widget/Button;

    new-instance v6, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v4}, Lcom/aio/downloader/model/FunModel;->getImg_count()I

    move-result v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v6, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, " pics"

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5, v4}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 394
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_gif:Landroid/widget/Button;

    invoke-virtual {v4, v8}, Landroid/widget/Button;->setVisibility(I)V

    .line 395
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_video:Landroid/widget/Button;

    invoke-virtual {v4, v8}, Landroid/widget/Button;->setVisibility(I)V

    .line 396
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_pics:Landroid/widget/Button;

    invoke-virtual {v4, v9}, Landroid/widget/Button;->setVisibility(I)V

    .line 397
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->iv_fun:Landroid/widget/ImageView;

    new-instance v5, Lcom/aio/downloader/adapter/Home_Listview_Adapter$6;

    invoke-direct {v5, p0, p1}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$6;-><init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;I)V

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 433
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_pics:Landroid/widget/Button;

    new-instance v5, Lcom/aio/downloader/adapter/Home_Listview_Adapter$7;

    invoke-direct {v5, p0, p1}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$7;-><init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;I)V

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 628
    :cond_1
    :goto_3
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->iv_like_new:Landroid/widget/ImageView;

    new-instance v5, Lcom/aio/downloader/adapter/Home_Listview_Adapter$13;

    invoke-direct {v5, p0, p1}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$13;-><init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;I)V

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 660
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->ll_fun_share:Landroid/widget/LinearLayout;
    invoke-static {v4}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->access$30(Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;)Landroid/widget/LinearLayout;

    move-result-object v4

    new-instance v5, Lcom/aio/downloader/adapter/Home_Listview_Adapter$14;

    invoke-direct {v5, p0, p1}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$14;-><init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;I)V

    invoke-virtual {v4, v5}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 752
    iget-object v5, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v4}, Lcom/aio/downloader/model/FunModel;->getThu_path()Ljava/lang/String;

    move-result-object v4

    iget-object v6, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v6, v6, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->iv_fun:Landroid/widget/ImageView;

    invoke-virtual {v5, v4, v6}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage1(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 753
    return-void

    .line 355
    .end local v0    # "month":Ljava/lang/String;
    .end local v1    # "time":J
    .end local v3    # "time1":Ljava/lang/String;
    :cond_2
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->iv_like_new:Landroid/widget/ImageView;

    const v5, 0x7f0200bc

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_0

    .line 364
    .restart local v0    # "month":Ljava/lang/String;
    .restart local v1    # "time":J
    .restart local v3    # "time1":Ljava/lang/String;
    :cond_3
    const-string v4, "02"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 365
    const-string v0, "Feb"

    .line 366
    goto/16 :goto_1

    :cond_4
    const-string v4, "03"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 367
    const-string v0, "March"

    .line 368
    goto/16 :goto_1

    :cond_5
    const-string v4, "04"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 369
    const-string v0, "Apr"

    .line 370
    goto/16 :goto_1

    :cond_6
    const-string v4, "05"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 371
    const-string v0, "May"

    .line 372
    goto/16 :goto_1

    :cond_7
    const-string v4, "06"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_8

    .line 373
    const-string v0, "June"

    .line 374
    goto/16 :goto_1

    :cond_8
    const-string v4, "07"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_9

    .line 375
    const-string v0, "July"

    .line 376
    goto/16 :goto_1

    :cond_9
    const-string v4, "08"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_a

    .line 377
    const-string v0, "Aug"

    .line 378
    goto/16 :goto_1

    :cond_a
    const-string v4, "09"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_b

    .line 379
    const-string v0, "Sept"

    .line 380
    goto/16 :goto_1

    :cond_b
    const-string v4, "10"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_c

    .line 381
    const-string v0, "Oct"

    .line 382
    goto/16 :goto_1

    :cond_c
    const-string v4, "11"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_d

    .line 383
    const-string v0, "Nov"

    .line 384
    goto/16 :goto_1

    :cond_d
    const-string v4, "12"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 385
    const-string v0, "Dec"

    goto/16 :goto_1

    .line 469
    :cond_e
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v4}, Lcom/aio/downloader/model/FunModel;->getCat()Ljava/lang/String;

    move-result-object v4

    const-string v5, "gif"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_f

    .line 470
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_pics:Landroid/widget/Button;

    invoke-virtual {v4, v8}, Landroid/widget/Button;->setVisibility(I)V

    .line 471
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_video:Landroid/widget/Button;

    invoke-virtual {v4, v8}, Landroid/widget/Button;->setVisibility(I)V

    .line 472
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_gif:Landroid/widget/Button;

    invoke-virtual {v4, v9}, Landroid/widget/Button;->setVisibility(I)V

    .line 474
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->iv_fun:Landroid/widget/ImageView;

    new-instance v5, Lcom/aio/downloader/adapter/Home_Listview_Adapter$8;

    invoke-direct {v5, p0, p1}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$8;-><init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;I)V

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 504
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_gif:Landroid/widget/Button;

    new-instance v5, Lcom/aio/downloader/adapter/Home_Listview_Adapter$9;

    invoke-direct {v5, p0, p1}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$9;-><init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;I)V

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_3

    .line 535
    :cond_f
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v4}, Lcom/aio/downloader/model/FunModel;->getCat()Ljava/lang/String;

    move-result-object v4

    const-string v5, "video"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_10

    .line 536
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_gif:Landroid/widget/Button;

    invoke-virtual {v4, v8}, Landroid/widget/Button;->setVisibility(I)V

    .line 537
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_pics:Landroid/widget/Button;

    invoke-virtual {v4, v8}, Landroid/widget/Button;->setVisibility(I)V

    .line 538
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_video:Landroid/widget/Button;

    invoke-virtual {v4, v9}, Landroid/widget/Button;->setVisibility(I)V

    .line 539
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->iv_fun:Landroid/widget/ImageView;

    new-instance v5, Lcom/aio/downloader/adapter/Home_Listview_Adapter$10;

    invoke-direct {v5, p0, p1}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$10;-><init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;I)V

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 564
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_video:Landroid/widget/Button;

    new-instance v5, Lcom/aio/downloader/adapter/Home_Listview_Adapter$11;

    invoke-direct {v5, p0, p1}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$11;-><init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;I)V

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_3

    .line 589
    :cond_10
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->list_fun:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v4}, Lcom/aio/downloader/model/FunModel;->getCat()Ljava/lang/String;

    move-result-object v4

    const-string v5, "gag"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 590
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_gif:Landroid/widget/Button;

    invoke-virtual {v4, v8}, Landroid/widget/Button;->setVisibility(I)V

    .line 591
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_pics:Landroid/widget/Button;

    invoke-virtual {v4, v8}, Landroid/widget/Button;->setVisibility(I)V

    .line 592
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->bt_video:Landroid/widget/Button;

    invoke-virtual {v4, v8}, Landroid/widget/Button;->setVisibility(I)V

    .line 593
    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;

    iget-object v4, v4, Lcom/aio/downloader/adapter/Home_Listview_Adapter$ViewHolder;->iv_fun:Landroid/widget/ImageView;

    new-instance v5, Lcom/aio/downloader/adapter/Home_Listview_Adapter$12;

    invoke-direct {v5, p0, p1}, Lcom/aio/downloader/adapter/Home_Listview_Adapter$12;-><init>(Lcom/aio/downloader/adapter/Home_Listview_Adapter;I)V

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_3

    .line 390
    :catch_0
    move-exception v4

    goto/16 :goto_2
.end method
