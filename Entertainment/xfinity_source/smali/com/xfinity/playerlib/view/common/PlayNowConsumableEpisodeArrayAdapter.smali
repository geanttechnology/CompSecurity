.class public Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;
.super Landroid/widget/ArrayAdapter;
.source "PlayNowConsumableEpisodeArrayAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;,
        Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;,
        Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;",
        ">;"
    }
.end annotation


# instance fields
.field bookmarks:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;"
        }
    .end annotation
.end field

.field private checkedPos:I

.field private currentlyWatchingVideoId:Ljava/lang/Long;

.field private inflater:Landroid/view/LayoutInflater;

.field nonEpisodeBookmarks:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;"
        }
    .end annotation
.end field

.field private onInfoClickListener:Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;


# direct methods
.method public constructor <init>(Landroid/app/Activity;ILjava/util/List;Landroid/view/LayoutInflater;Lcom/comcast/cim/utils/UIUtil;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "textViewResourceId"    # I
    .param p4, "inflater"    # Landroid/view/LayoutInflater;
    .param p5, "uiUtil"    # Lcom/comcast/cim/utils/UIUtil;
    .param p6, "currWatchVideoId"    # Ljava/lang/Long;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "I",
            "Ljava/util/List",
            "<+",
            "Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;",
            ">;",
            "Landroid/view/LayoutInflater;",
            "Lcom/comcast/cim/utils/UIUtil;",
            "Ljava/lang/Long;",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 41
    .local p3, "objects":Ljava/util/List;, "Ljava/util/List<+Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    .local p7, "bookmarks":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    .local p8, "nonEpisodeBookmarks":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Long;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 29
    const/4 v0, -0x1

    iput v0, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->checkedPos:I

    .line 42
    iput-object p4, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 43
    iput-object p7, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->bookmarks:Ljava/util/Map;

    .line 44
    iput-object p8, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->nonEpisodeBookmarks:Ljava/util/Map;

    .line 45
    iput-object p6, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->currentlyWatchingVideoId:Ljava/lang/Long;

    .line 46
    return-void
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;)Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->onInfoClickListener:Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;

    return-object v0
.end method

.method private buildEpisodeString(Landroid/content/Context;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)Ljava/lang/String;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "episodeFacade"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 188
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-lez v0, :cond_0

    .line 189
    sget v0, Lcom/xfinity/playerlib/R$string;->just_episode:I

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 191
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private updateTitleText(Landroid/widget/TextView;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 3
    .param p1, "titleText"    # Landroid/widget/TextView;
    .param p2, "episodeFacade"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 175
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v0

    .line 176
    .local v0, "episodeTitle":Ljava/lang/String;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_1

    .line 177
    invoke-static {v0}, Lcom/comcast/cim/utils/UIPresentationUtil;->addQuotesToString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 184
    :cond_0
    :goto_0
    return-void

    .line 178
    :cond_1
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getOriginalAirdate()Ljava/util/Date;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 179
    const-string v2, "MMM d, yyyy"

    invoke-static {v2}, Lorg/apache/commons/lang3/time/FastDateFormat;->getInstance(Ljava/lang/String;)Lorg/apache/commons/lang3/time/FastDateFormat;

    move-result-object v1

    .line 180
    .local v1, "formatter":Lorg/apache/commons/lang3/time/FastDateFormat;
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getOriginalAirdate()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v1, v2}, Lorg/apache/commons/lang3/time/FastDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 181
    .end local v1    # "formatter":Lorg/apache/commons/lang3/time/FastDateFormat;
    :cond_2
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getSeriesTitle()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 182
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getSeriesTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 10
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 56
    new-instance v1, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;

    const/4 v5, 0x0

    invoke-direct {v1, p0, v5}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;-><init>(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;)V

    .line 58
    .local v1, "contentDescription":Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;
    if-nez p2, :cond_4

    .line 59
    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->inflater:Landroid/view/LayoutInflater;

    sget v6, Lcom/xfinity/playerlib/R$layout;->consumable_episode_list_item:I

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 61
    new-instance v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;

    const/4 v5, 0x0

    invoke-direct {v3, p0, v5}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;-><init>(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;)V

    .line 62
    .local v3, "holder":Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;
    sget v5, Lcom/xfinity/playerlib/R$id;->list_item_container:I

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    iput-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->listItemContainer:Landroid/view/View;

    .line 63
    sget v5, Lcom/xfinity/playerlib/R$id;->consumable_episode_title:I

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->titleText:Landroid/widget/TextView;

    .line 64
    sget v5, Lcom/xfinity/playerlib/R$id;->new_indicator:I

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->newIndicator:Landroid/widget/ImageView;

    .line 65
    sget v5, Lcom/xfinity/playerlib/R$id;->episode_num:I

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->episodeNumText:Landroid/widget/TextView;

    .line 66
    sget v5, Lcom/xfinity/playerlib/R$id;->watching_indicator:I

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->watchingIndicator:Landroid/widget/ImageView;

    .line 67
    sget v5, Lcom/xfinity/playerlib/R$id;->progressIndicator:I

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->progressIndicator:Landroid/widget/TextView;

    .line 68
    sget v5, Lcom/xfinity/playerlib/R$id;->downloadable_indicator:I

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    iput-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->downloadableIndicator:Landroid/view/View;

    .line 70
    invoke-virtual {p2, v3}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    :goto_0
    move-object v5, p2

    .line 75
    check-cast v5, Landroid/widget/Checkable;

    iget v6, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->checkedPos:I

    if-ne p1, v6, :cond_5

    const/4 v6, 0x1

    :goto_1
    invoke-interface {v5, v6}, Landroid/widget/Checkable;->setChecked(Z)V

    .line 77
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .line 79
    .local v4, "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->titleText:Landroid/widget/TextView;

    if-eqz v5, :cond_0

    .line 80
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->titleText:Landroid/widget/TextView;

    invoke-direct {p0, v5, v4}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->updateTitleText(Landroid/widget/TextView;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V

    .line 81
    invoke-virtual {v1, v4}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->setupTitleText(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V

    .line 84
    :cond_0
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->newIndicator:Landroid/widget/ImageView;

    if-eqz v5, :cond_1

    .line 85
    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->isNew()Z

    move-result v5

    if-eqz v5, :cond_6

    .line 86
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->newIndicator:Landroid/widget/ImageView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 87
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->newIndicator:Landroid/widget/ImageView;

    iget-object v6, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->titleText:Landroid/widget/TextView;

    invoke-static {v5, v6, p3}, Lcom/comcast/cim/utils/TextFlowHelper;->tryFlowText(Landroid/view/View;Landroid/widget/TextView;Landroid/view/ViewGroup;)V

    .line 92
    :goto_2
    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->isNew()Z

    move-result v5

    iput-boolean v5, v1, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->isNew:Z

    .line 95
    :cond_1
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->episodeNumText:Landroid/widget/TextView;

    if-eqz v5, :cond_9

    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v5

    if-eqz v5, :cond_9

    .line 97
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->episodeNumText:Landroid/widget/TextView;

    invoke-virtual {v5}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {p0, v5, v4}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->buildEpisodeString(Landroid/content/Context;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)Ljava/lang/String;

    move-result-object v2

    .line 99
    .local v2, "episodeDescriptor":Ljava/lang/String;
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->episodeNumText:Landroid/widget/TextView;

    invoke-virtual {v5, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 100
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->episodeNumText:Landroid/widget/TextView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 102
    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    const/4 v6, 0x1

    if-ge v5, v6, :cond_7

    const-string v5, ""

    .line 103
    :goto_3
    iput-object v5, v1, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->episodeNumber:Ljava/lang/String;

    .line 105
    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    const/4 v6, 0x1

    if-ge v5, v6, :cond_8

    const-string v5, ""

    .line 106
    :goto_4
    iput-object v5, v1, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->seasonNumber:Ljava/lang/String;

    .line 112
    .end local v2    # "episodeDescriptor":Ljava/lang/String;
    :goto_5
    new-instance v5, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;

    invoke-direct {v5, p0, v4, p1}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;-><init>(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;I)V

    invoke-virtual {p2, v5}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 121
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->progressIndicator:Landroid/widget/TextView;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 123
    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v5

    if-eqz v5, :cond_3

    .line 125
    const/4 v0, 0x0

    .line 126
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->bookmarks:Ljava/util/Map;

    if-eqz v5, :cond_a

    .line 127
    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->bookmarks:Ljava/util/Map;

    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v6

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    check-cast v0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .line 132
    .restart local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    :cond_2
    :goto_6
    if-eqz v0, :cond_b

    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getCategories()Ljava/util/List;

    move-result-object v5

    sget-object v6, Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;->CATEGORY_RECENT:Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;

    invoke-interface {v5, v6}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_b

    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getPosition()I

    move-result v5

    if-lez v5, :cond_b

    .line 133
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->progressIndicator:Landroid/widget/TextView;

    .line 135
    invoke-virtual {p2}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v6

    .line 136
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getDuration()I

    move-result v7

    .line 137
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getPosition()I

    move-result v8

    .line 135
    invoke-static {v6, v7, v8}, Lcom/comcast/cim/utils/UIPresentationUtil;->getRemainingTime(Landroid/content/Context;II)Ljava/lang/String;

    move-result-object v6

    .line 133
    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 140
    invoke-virtual {p2}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v5

    .line 141
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getDuration()I

    move-result v6

    .line 142
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getPosition()I

    move-result v7

    .line 140
    invoke-static {v5, v6, v7}, Lcom/comcast/cim/utils/UIPresentationUtil;->getRemainingTimeTalkBack(Landroid/content/Context;II)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v1, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->timeRemaining:Ljava/lang/String;

    .line 144
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->progressIndicator:Landroid/widget/TextView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 149
    :goto_7
    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->currentlyWatchingVideoId:Ljava/lang/Long;

    if-eqz v5, :cond_d

    .line 150
    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->currentlyWatchingVideoId:Ljava/lang/Long;

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-interface {v4, v6, v7}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->findVideoById(J)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v5

    if-eqz v5, :cond_c

    .line 151
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->watchingIndicator:Landroid/widget/ImageView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 152
    const/4 v5, 0x1

    iput-boolean v5, v1, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->isWatching:Z

    .line 162
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    :cond_3
    :goto_8
    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->hasDownloadableVideo()Z

    move-result v5

    if-eqz v5, :cond_e

    .line 163
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->downloadableIndicator:Landroid/view/View;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/view/View;->setVisibility(I)V

    .line 164
    const/4 v5, 0x1

    iput-boolean v5, v1, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->isAvailableForDownload:Z

    .line 169
    :goto_9
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->listItemContainer:Landroid/view/View;

    invoke-virtual {v1, v5}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->setContentDescription(Landroid/view/View;)V

    .line 171
    return-object p2

    .line 72
    .end local v3    # "holder":Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;
    .end local v4    # "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    :cond_4
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;

    .restart local v3    # "holder":Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;
    goto/16 :goto_0

    .line 75
    :cond_5
    const/4 v6, 0x0

    goto/16 :goto_1

    .line 89
    .restart local v4    # "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    :cond_6
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->newIndicator:Landroid/widget/ImageView;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 103
    .restart local v2    # "episodeDescriptor":Ljava/lang/String;
    :cond_7
    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v5

    goto/16 :goto_3

    .line 106
    :cond_8
    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v5

    goto/16 :goto_4

    .line 109
    .end local v2    # "episodeDescriptor":Ljava/lang/String;
    :cond_9
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->episodeNumText:Landroid/widget/TextView;

    const/4 v6, 0x4

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_5

    .line 128
    .restart local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    :cond_a
    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->nonEpisodeBookmarks:Ljava/util/Map;

    if-eqz v5, :cond_2

    .line 129
    iget-object v6, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->nonEpisodeBookmarks:Ljava/util/Map;

    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getVideos()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-interface {v6, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    check-cast v0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .restart local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    goto/16 :goto_6

    .line 146
    :cond_b
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->progressIndicator:Landroid/widget/TextView;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_7

    .line 154
    :cond_c
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->watchingIndicator:Landroid/widget/ImageView;

    const/4 v6, 0x4

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_8

    .line 157
    :cond_d
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->watchingIndicator:Landroid/widget/ImageView;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_8

    .line 166
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    :cond_e
    iget-object v5, v3, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->downloadableIndicator:Landroid/view/View;

    const/4 v6, 0x4

    invoke-virtual {v5, v6}, Landroid/view/View;->setVisibility(I)V

    goto :goto_9
.end method

.method public setCheckedPos(I)V
    .locals 0
    .param p1, "checkedPos"    # I

    .prologue
    .line 49
    iput p1, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->checkedPos:I

    .line 50
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->notifyDataSetChanged()V

    .line 51
    return-void
.end method

.method public setOnInfoClickListener(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;

    .prologue
    .line 258
    iput-object p1, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->onInfoClickListener:Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;

    .line 259
    return-void
.end method
