.class Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;
.super Ljava/lang/Object;
.source "PlayNowConsumableEpisodeArrayAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ContentDescription"
.end annotation


# instance fields
.field protected episodeNumber:Ljava/lang/String;

.field protected episodeTitle:Ljava/lang/String;

.field protected isAvailableForDownload:Z

.field protected isNew:Z

.field protected isWatching:Z

.field protected seasonNumber:Ljava/lang/String;

.field protected seriesTitle:Ljava/lang/String;

.field final synthetic this$0:Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;

.field protected timeRemaining:Ljava/lang/String;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;)V
    .locals 1

    .prologue
    .line 195
    iput-object p1, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->this$0:Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 197
    const-string v0, ""

    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->episodeTitle:Ljava/lang/String;

    .line 198
    const-string v0, ""

    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->seriesTitle:Ljava/lang/String;

    .line 199
    const-string v0, ""

    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->seasonNumber:Ljava/lang/String;

    .line 200
    const-string v0, ""

    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->episodeNumber:Ljava/lang/String;

    .line 202
    const-string v0, ""

    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->timeRemaining:Ljava/lang/String;

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;

    .prologue
    .line 195
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;-><init>(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;)V

    return-void
.end method


# virtual methods
.method public getContentDescription(Landroid/content/Context;)Ljava/lang/String;
    .locals 8
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 228
    iget-boolean v3, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->isNew:Z

    if-eqz v3, :cond_0

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_new_episode:I

    invoke-virtual {p1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 229
    .local v1, "newText":Ljava/lang/String;
    :goto_0
    iget-boolean v3, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->isWatching:Z

    if-eqz v3, :cond_1

    sget v3, Lcom/xfinity/playerlib/R$string;->on_now:I

    invoke-virtual {p1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 230
    .local v2, "watchingText":Ljava/lang/String;
    :goto_1
    iget-boolean v3, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->isAvailableForDownload:Z

    if-eqz v3, :cond_2

    sget v3, Lcom/xfinity/playerlib/R$string;->available_for_download:I

    invoke-virtual {p1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 232
    .local v0, "downloadText":Ljava/lang/String;
    :goto_2
    iget-object v3, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->episodeNumber:Ljava/lang/String;

    invoke-static {v3}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    const-string v3, ""

    .line 233
    :goto_3
    iput-object v3, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->episodeNumber:Ljava/lang/String;

    .line 235
    iget-object v3, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->seasonNumber:Ljava/lang/String;

    invoke-static {v3}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    const-string v3, ""

    .line 236
    :goto_4
    iput-object v3, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->seasonNumber:Ljava/lang/String;

    .line 238
    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_episode_item:I

    const/16 v4, 0x8

    new-array v4, v4, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->episodeNumber:Ljava/lang/String;

    aput-object v5, v4, v6

    aput-object v1, v4, v7

    const/4 v5, 0x2

    iget-object v6, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->episodeTitle:Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x3

    iget-object v6, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->seriesTitle:Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x4

    iget-object v6, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->seasonNumber:Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x5

    aput-object v2, v4, v5

    const/4 v5, 0x6

    iget-object v6, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->timeRemaining:Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x7

    aput-object v0, v4, v5

    invoke-virtual {p1, v3, v4}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 228
    .end local v0    # "downloadText":Ljava/lang/String;
    .end local v1    # "newText":Ljava/lang/String;
    .end local v2    # "watchingText":Ljava/lang/String;
    :cond_0
    const-string v1, ""

    goto :goto_0

    .line 229
    .restart local v1    # "newText":Ljava/lang/String;
    :cond_1
    const-string v2, ""

    goto :goto_1

    .line 230
    .restart local v2    # "watchingText":Ljava/lang/String;
    :cond_2
    const-string v0, ""

    goto :goto_2

    .line 232
    .restart local v0    # "downloadText":Ljava/lang/String;
    :cond_3
    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_just_episode_number:I

    new-array v4, v7, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->episodeNumber:Ljava/lang/String;

    aput-object v5, v4, v6

    .line 233
    invoke-virtual {p1, v3, v4}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    goto :goto_3

    .line 235
    :cond_4
    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_just_season_number:I

    new-array v4, v7, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->seasonNumber:Ljava/lang/String;

    aput-object v5, v4, v6

    .line 236
    invoke-virtual {p1, v3, v4}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    goto :goto_4
.end method

.method public setContentDescription(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 223
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->getContentDescription(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 224
    return-void
.end method

.method public setupTitleText(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 3
    .param p1, "episodeFacade"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 208
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v0

    .line 210
    .local v0, "episodeTitle":Ljava/lang/String;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_2

    .line 211
    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->episodeTitle:Ljava/lang/String;

    .line 217
    :cond_0
    :goto_0
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getSeriesTitle()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 218
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getSeriesTitle()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->seriesTitle:Ljava/lang/String;

    .line 220
    :cond_1
    return-void

    .line 212
    :cond_2
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getOriginalAirdate()Ljava/util/Date;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 213
    const-string v2, "MMM d, yyyy"

    invoke-static {v2}, Lorg/apache/commons/lang3/time/FastDateFormat;->getInstance(Ljava/lang/String;)Lorg/apache/commons/lang3/time/FastDateFormat;

    move-result-object v1

    .line 214
    .local v1, "formatter":Lorg/apache/commons/lang3/time/FastDateFormat;
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getOriginalAirdate()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v1, v2}, Lorg/apache/commons/lang3/time/FastDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ContentDescription;->episodeTitle:Ljava/lang/String;

    goto :goto_0
.end method
