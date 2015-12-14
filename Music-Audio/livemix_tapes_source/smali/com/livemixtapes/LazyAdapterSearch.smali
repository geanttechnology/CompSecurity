.class public Lcom/livemixtapes/LazyAdapterSearch;
.super Landroid/widget/BaseAdapter;
.source "LazyAdapterSearch.java"


# static fields
.field private static final isSimpleSearch:I = 0x1

.field private static final isTextBasedSearch:I = 0x2


# instance fields
.field public data:Ljava/util/ArrayList;
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

.field private fragment:Lcom/livemixtapes/SearchFragment;

.field private imageLoader:Lcom/livemixtapes/ImageLoader;

.field private inflater:Landroid/view/LayoutInflater;

.field private isSimpleSearchOrComplexSearch:I

.field public shouldShowTracks:Z

.field private targetHeight:I

.field public trackResults:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/livemixtapes/SearchFragment;)V
    .locals 6
    .param p1, "fragment"    # Lcom/livemixtapes/SearchFragment;

    .prologue
    .line 39
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 33
    const/4 v4, 0x1

    iput-boolean v4, p0, Lcom/livemixtapes/LazyAdapterSearch;->shouldShowTracks:Z

    .line 44
    invoke-virtual {p1}, Lcom/livemixtapes/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 45
    .local v0, "context":Landroid/content/Context;
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, p0, Lcom/livemixtapes/LazyAdapterSearch;->data:Ljava/util/ArrayList;

    .line 46
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, p0, Lcom/livemixtapes/LazyAdapterSearch;->trackResults:Ljava/util/ArrayList;

    .line 47
    const-string v4, "layout_inflater"

    invoke-virtual {v0, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/LayoutInflater;

    iput-object v4, p0, Lcom/livemixtapes/LazyAdapterSearch;->inflater:Landroid/view/LayoutInflater;

    .line 48
    new-instance v4, Lcom/livemixtapes/ImageLoader;

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/livemixtapes/ImageLoader;-><init>(Landroid/content/Context;)V

    iput-object v4, p0, Lcom/livemixtapes/LazyAdapterSearch;->imageLoader:Lcom/livemixtapes/ImageLoader;

    .line 49
    const-string v4, "window"

    invoke-virtual {v0, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/WindowManager;

    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    .line 50
    .local v1, "display":Landroid/view/Display;
    new-instance v2, Landroid/util/DisplayMetrics;

    invoke-direct {v2}, Landroid/util/DisplayMetrics;-><init>()V

    .line 51
    .local v2, "outMetrics":Landroid/util/DisplayMetrics;
    invoke-virtual {v1, v2}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 52
    iget v4, v2, Landroid/util/DisplayMetrics;->widthPixels:I

    int-to-float v3, v4

    .line 53
    .local v3, "scWidth":F
    const v4, 0x3e19999a    # 0.15f

    mul-float/2addr v4, v3

    float-to-int v4, v4

    iput v4, p0, Lcom/livemixtapes/LazyAdapterSearch;->targetHeight:I

    .line 54
    iput-object p1, p0, Lcom/livemixtapes/LazyAdapterSearch;->fragment:Lcom/livemixtapes/SearchFragment;

    .line 55
    return-void
.end method

.method private getDurationString(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "secondsStr"    # Ljava/lang/String;

    .prologue
    .line 182
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    .line 183
    .local v1, "seconds":I
    div-int/lit8 v0, v1, 0x3c

    .line 184
    .local v0, "minutes":I
    rem-int/lit8 v1, v1, 0x3c

    .line 185
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {p0, v0}, Lcom/livemixtapes/LazyAdapterSearch;->twoDigitString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-direct {p0, v1}, Lcom/livemixtapes/LazyAdapterSearch;->twoDigitString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method private twoDigitString(I)Ljava/lang/String;
    .locals 2
    .param p1, "number"    # I

    .prologue
    .line 189
    if-nez p1, :cond_0

    .line 190
    const-string v0, "00"

    .line 193
    :goto_0
    return-object v0

    .line 191
    :cond_0
    div-int/lit8 v0, p1, 0xa

    if-nez v0, :cond_1

    .line 192
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "0"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 193
    :cond_1
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public appendSearchResults(Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    .locals 1
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
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 252
    .local p1, "queryResultsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    .local p2, "trackResultsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    const/4 v0, 0x2

    iput v0, p0, Lcom/livemixtapes/LazyAdapterSearch;->isSimpleSearchOrComplexSearch:I

    .line 254
    iget-object v0, p0, Lcom/livemixtapes/LazyAdapterSearch;->data:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 255
    iget-object v0, p0, Lcom/livemixtapes/LazyAdapterSearch;->trackResults:Ljava/util/ArrayList;

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 257
    invoke-virtual {p0}, Lcom/livemixtapes/LazyAdapterSearch;->notifyDataSetChanged()V

    .line 258
    return-void
.end method

.method public clear()V
    .locals 1

    .prologue
    .line 240
    iget-object v0, p0, Lcom/livemixtapes/LazyAdapterSearch;->data:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 241
    iget-object v0, p0, Lcom/livemixtapes/LazyAdapterSearch;->trackResults:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 242
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/livemixtapes/LazyAdapterSearch;->data:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 71
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 75
    int-to-long v0, p1

    return-wide v0
.end method

.method public getResult(I)Ljava/util/HashMap;
    .locals 1
    .param p1, "position"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 265
    iget-object v0, p0, Lcom/livemixtapes/LazyAdapterSearch;->data:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 25
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 80
    move-object/from16 v19, p2

    .line 82
    .local v19, "vi":Landroid/view/View;
    move-object/from16 v0, p0

    iget v0, v0, Lcom/livemixtapes/LazyAdapterSearch;->isSimpleSearchOrComplexSearch:I

    move/from16 v20, v0

    const/16 v21, 0x1

    move/from16 v0, v20

    move/from16 v1, v21

    if-ne v0, v1, :cond_3

    .line 83
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/LazyAdapterSearch;->inflater:Landroid/view/LayoutInflater;

    move-object/from16 v20, v0

    const v21, 0x7f03003a

    const/16 v22, 0x0

    invoke-virtual/range {v20 .. v22}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v19

    .line 85
    const v20, 0x7f080104

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 86
    .local v6, "artistTitle":Landroid/widget/TextView;
    const v20, 0x7f080105

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 87
    .local v8, "changeTitle":Landroid/widget/TextView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/LazyAdapterSearch;->data:Ljava/util/ArrayList;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    move/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/util/HashMap;

    const-string v21, "artist"

    invoke-virtual/range {v20 .. v21}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 88
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/LazyAdapterSearch;->data:Ljava/util/ArrayList;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    move/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/util/HashMap;

    const-string v21, "change"

    invoke-virtual/range {v20 .. v21}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    .line 89
    invoke-virtual/range {v20 .. v20}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v20

    .line 88
    invoke-static/range {v20 .. v20}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v7

    .line 90
    .local v7, "change":I
    if-nez v7, :cond_1

    .line 91
    const-string v20, ""

    move-object/from16 v0, v20

    invoke-virtual {v8, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 178
    .end local v6    # "artistTitle":Landroid/widget/TextView;
    .end local v7    # "change":I
    .end local v8    # "changeTitle":Landroid/widget/TextView;
    :cond_0
    :goto_0
    return-object v19

    .line 92
    .restart local v6    # "artistTitle":Landroid/widget/TextView;
    .restart local v7    # "change":I
    .restart local v8    # "changeTitle":Landroid/widget/TextView;
    :cond_1
    if-lez v7, :cond_2

    .line 93
    new-instance v20, Ljava/lang/StringBuilder;

    const-string v21, "+"

    invoke-direct/range {v20 .. v21}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v20

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v8, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 94
    const-string v20, "#00A100"

    invoke-static/range {v20 .. v20}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v20

    move/from16 v0, v20

    invoke-virtual {v8, v0}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_0

    .line 96
    :cond_2
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v21

    invoke-direct/range {v20 .. v21}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v8, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 97
    const-string v20, "#F2003C"

    invoke-static/range {v20 .. v20}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v20

    move/from16 v0, v20

    invoke-virtual {v8, v0}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_0

    .line 102
    .end local v6    # "artistTitle":Landroid/widget/TextView;
    .end local v7    # "change":I
    .end local v8    # "changeTitle":Landroid/widget/TextView;
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/LazyAdapterSearch;->inflater:Landroid/view/LayoutInflater;

    move-object/from16 v20, v0

    const v21, 0x7f030039

    const/16 v22, 0x0

    invoke-virtual/range {v20 .. v22}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v19

    .line 104
    const v20, 0x7f0800bb

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    .line 105
    .local v14, "text":Landroid/widget/TextView;
    const v20, 0x7f0800ba

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/ImageView;

    .line 107
    .local v9, "image":Landroid/widget/ImageView;
    const v20, 0x7f080103

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    .line 106
    check-cast v17, Landroid/widget/LinearLayout;

    .line 109
    .local v17, "trackLayout":Landroid/widget/LinearLayout;
    invoke-virtual {v9}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v20

    move-object/from16 v0, p0

    iget v0, v0, Lcom/livemixtapes/LazyAdapterSearch;->targetHeight:I

    move/from16 v21, v0

    move/from16 v0, v21

    move-object/from16 v1, v20

    iput v0, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 111
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/LazyAdapterSearch;->data:Ljava/util/ArrayList;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    move/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/util/Map;

    invoke-static/range {v20 .. v20}, Lcom/livemixtapes/Utils;->getArtistAndTitle(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v16

    .line 113
    .local v16, "title":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/LazyAdapterSearch;->fragment:Lcom/livemixtapes/SearchFragment;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    iget-object v0, v0, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/livemixtapes/ui/widgets/SearchView;->getQuery()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v12

    .line 114
    .local v12, "searchStr":Ljava/lang/String;
    new-instance v4, Landroid/text/SpannableString;

    move-object/from16 v0, v16

    invoke-direct {v4, v0}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 115
    .local v4, "WordtoSpan":Landroid/text/Spannable;
    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v10

    .line 116
    .local v10, "index":I
    const/16 v20, -0x1

    move/from16 v0, v20

    if-ne v10, v0, :cond_5

    .line 117
    move-object/from16 v0, v16

    invoke-virtual {v14, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 125
    :goto_1
    invoke-virtual {v14}, Landroid/widget/TextView;->bringToFront()V

    .line 126
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/LazyAdapterSearch;->imageLoader:Lcom/livemixtapes/ImageLoader;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/LazyAdapterSearch;->data:Ljava/util/ArrayList;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    move/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/util/HashMap;

    const-string v22, "thumbnail"

    move-object/from16 v0, v20

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    .line 127
    invoke-virtual/range {v20 .. v20}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v20

    .line 126
    move-object/from16 v0, v21

    move-object/from16 v1, v20

    invoke-virtual {v0, v1, v9}, Lcom/livemixtapes/ImageLoader;->DisplayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 129
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/livemixtapes/LazyAdapterSearch;->shouldShowTracks:Z

    move/from16 v20, v0

    if-eqz v20, :cond_0

    .line 131
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/LazyAdapterSearch;->data:Ljava/util/ArrayList;

    move-object/from16 v20, v0

    .line 132
    move-object/from16 v0, v20

    move/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/util/HashMap;

    const-string v21, "tracks"

    invoke-virtual/range {v20 .. v21}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Ljava/util/ArrayList;

    .line 134
    .local v18, "tracks":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-virtual/range {v18 .. v18}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v21

    :cond_4
    :goto_2
    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_0

    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/util/HashMap;

    .line 136
    .local v11, "obj":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v20, "track_id"

    move-object/from16 v0, v20

    invoke-virtual {v11, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/String;

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/livemixtapes/LazyAdapterSearch;->isTrackPresent(Ljava/lang/String;)Z

    move-result v20

    if-eqz v20, :cond_4

    .line 138
    new-instance v15, Landroid/widget/TextView;

    .line 139
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/LazyAdapterSearch;->fragment:Lcom/livemixtapes/SearchFragment;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/livemixtapes/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v20

    .line 138
    move-object/from16 v0, v20

    invoke-direct {v15, v0}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 140
    .local v15, "textView":Landroid/widget/TextView;
    const/high16 v20, -0x1000000

    move/from16 v0, v20

    invoke-virtual {v15, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 143
    new-instance v22, Ljava/lang/StringBuilder;

    const-string v20, "track_number"

    move-object/from16 v0, v20

    invoke-virtual {v11, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/String;

    invoke-static/range {v20 .. v20}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v20

    move-object/from16 v0, p0

    move/from16 v1, v20

    invoke-direct {v0, v1}, Lcom/livemixtapes/LazyAdapterSearch;->twoDigitString(I)Ljava/lang/String;

    move-result-object v20

    invoke-static/range {v20 .. v20}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v20, ". "

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v20, "track_artist"

    move-object/from16 v0, v20

    invoke-virtual {v11, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/String;

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v22, " - "

    move-object/from16 v0, v20

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    .line 144
    const-string v20, "track_title"

    move-object/from16 v0, v20

    invoke-virtual {v11, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/String;

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v22, " ("

    move-object/from16 v0, v20

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    .line 145
    const-string v20, "track_duration"

    move-object/from16 v0, v20

    invoke-virtual {v11, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/String;

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Lcom/livemixtapes/LazyAdapterSearch;->getDurationString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v22, ")"

    move-object/from16 v0, v20

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    .line 143
    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 146
    .local v13, "subtitle":Ljava/lang/String;
    invoke-virtual {v13, v12}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v20

    if-eqz v20, :cond_6

    .line 148
    new-instance v5, Landroid/text/SpannableString;

    invoke-direct {v5, v13}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 149
    .local v5, "WordtoSpan1":Landroid/text/Spannable;
    new-instance v20, Landroid/text/style/BackgroundColorSpan;

    const/16 v22, -0x100

    move-object/from16 v0, v20

    move/from16 v1, v22

    invoke-direct {v0, v1}, Landroid/text/style/BackgroundColorSpan;-><init>(I)V

    invoke-virtual {v13, v12}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v22

    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v23

    invoke-virtual {v13, v12}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v24

    add-int v23, v23, v24

    .line 150
    const/16 v24, 0x21

    .line 149
    move-object/from16 v0, v20

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    invoke-interface {v5, v0, v1, v2, v3}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    .line 151
    invoke-virtual {v15, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 156
    .end local v5    # "WordtoSpan1":Landroid/text/Spannable;
    :goto_3
    new-instance v20, Landroid/widget/LinearLayout$LayoutParams;

    .line 157
    const/16 v22, -0x1

    .line 158
    const/16 v23, -0x2

    move-object/from16 v0, v20

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-direct {v0, v1, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 156
    move-object/from16 v0, v20

    invoke-virtual {v15, v0}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 159
    const/16 v20, 0x1

    move/from16 v0, v20

    invoke-virtual {v15, v0}, Landroid/widget/TextView;->setClickable(Z)V

    .line 161
    const/16 v20, 0x2

    const/16 v22, 0x8

    const/16 v23, 0x8

    const/16 v24, 0x5

    move/from16 v0, v20

    move/from16 v1, v22

    move/from16 v2, v23

    move/from16 v3, v24

    invoke-virtual {v15, v0, v1, v2, v3}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 162
    const/16 v20, 0x2

    move/from16 v0, v20

    invoke-virtual {v15, v0}, Landroid/widget/TextView;->setMaxLines(I)V

    .line 163
    const/high16 v20, 0x41600000    # 14.0f

    move/from16 v0, v20

    invoke-virtual {v15, v0}, Landroid/widget/TextView;->setTextSize(F)V

    .line 165
    new-instance v20, Lcom/livemixtapes/LazyAdapterSearch$1;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    move/from16 v2, p1

    invoke-direct {v0, v1, v2, v11}, Lcom/livemixtapes/LazyAdapterSearch$1;-><init>(Lcom/livemixtapes/LazyAdapterSearch;ILjava/util/HashMap;)V

    move-object/from16 v0, v20

    invoke-virtual {v15, v0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 172
    move-object/from16 v0, v17

    invoke-virtual {v0, v15}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto/16 :goto_2

    .line 120
    .end local v11    # "obj":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v13    # "subtitle":Ljava/lang/String;
    .end local v15    # "textView":Landroid/widget/TextView;
    .end local v18    # "tracks":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    :cond_5
    new-instance v20, Landroid/text/style/BackgroundColorSpan;

    const/16 v21, -0x100

    invoke-direct/range {v20 .. v21}, Landroid/text/style/BackgroundColorSpan;-><init>(I)V

    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v21

    add-int v21, v21, v10

    .line 121
    const/16 v22, 0x21

    .line 120
    move-object/from16 v0, v20

    move/from16 v1, v21

    move/from16 v2, v22

    invoke-interface {v4, v0, v10, v1, v2}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    .line 122
    invoke-virtual {v14, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_1

    .line 154
    .restart local v11    # "obj":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v13    # "subtitle":Ljava/lang/String;
    .restart local v15    # "textView":Landroid/widget/TextView;
    .restart local v18    # "tracks":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    :cond_6
    invoke-virtual {v15, v13}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_3
.end method

.method public isTopArtistSearch()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 261
    iget v1, p0, Lcom/livemixtapes/LazyAdapterSearch;->isSimpleSearchOrComplexSearch:I

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isTrackPresent(Ljava/lang/String;)Z
    .locals 4
    .param p1, "trackId"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 198
    iget-object v1, p0, Lcom/livemixtapes/LazyAdapterSearch;->trackResults:Ljava/util/ArrayList;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/livemixtapes/LazyAdapterSearch;->trackResults:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-nez v1, :cond_1

    :cond_0
    move v1, v2

    .line 205
    :goto_0
    return v1

    .line 200
    :cond_1
    iget-object v1, p0, Lcom/livemixtapes/LazyAdapterSearch;->trackResults:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-nez v1, :cond_3

    .line 205
    const/4 v1, 0x0

    goto :goto_0

    .line 200
    :cond_3
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    .line 202
    .local v0, "obj":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "track_id"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    move v1, v2

    .line 203
    goto :goto_0
.end method

.method openNowPlaying(Ljava/util/HashMap;ILjava/util/HashMap;)V
    .locals 6
    .param p2, "position"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;I",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "mixtape":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local p3, "selectedTrack":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v5, 0x2

    .line 210
    iget-object v1, p0, Lcom/livemixtapes/LazyAdapterSearch;->fragment:Lcom/livemixtapes/SearchFragment;

    iget-object v2, p0, Lcom/livemixtapes/LazyAdapterSearch;->fragment:Lcom/livemixtapes/SearchFragment;

    invoke-virtual {v2}, Lcom/livemixtapes/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    sget-object v3, Lcom/livemixtapes/MainActivity;->nowplayingbutton:Landroid/widget/ImageView;

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4}, Lcom/livemixtapes/SearchFragment;->shake(Landroid/content/Context;Landroid/view/View;Ljava/lang/Runnable;)V

    .line 211
    sput-object p1, Lcom/livemixtapes/NowPlayingActivity;->mixtape:Ljava/util/Map;

    .line 212
    sput v5, Lcom/livemixtapes/NowPlayingActivity;->flag:I

    .line 213
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 214
    .local v0, "temp":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 215
    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    .line 216
    const/4 v1, 0x0

    sput v1, Lcom/livemixtapes/NowPlayingActivity;->position:I

    .line 217
    sput v5, Lcom/livemixtapes/NowPlayingActivity;->flag:I

    .line 218
    const/4 v1, 0x1

    sput-boolean v1, Lcom/livemixtapes/MainActivity;->isPlaying:Z

    .line 219
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->initializeAndReload()V

    .line 221
    sget-object v1, Lcom/livemixtapes/MainActivity;->nowplayingbutton:Landroid/widget/ImageView;

    const v2, 0x7f0200f8

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 237
    return-void
.end method

.method public setTopArtists(Ljava/util/ArrayList;)V
    .locals 1
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
    .line 245
    .local p1, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    const/4 v0, 0x1

    iput v0, p0, Lcom/livemixtapes/LazyAdapterSearch;->isSimpleSearchOrComplexSearch:I

    .line 246
    invoke-virtual {p0}, Lcom/livemixtapes/LazyAdapterSearch;->clear()V

    .line 247
    iget-object v0, p0, Lcom/livemixtapes/LazyAdapterSearch;->data:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 248
    invoke-virtual {p0}, Lcom/livemixtapes/LazyAdapterSearch;->notifyDataSetChanged()V

    .line 249
    return-void
.end method
