.class public Lcom/poshmark/data_model/models/FeedItem;
.super Ljava/lang/Object;
.source "FeedItem.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/FeedItem$1;,
        Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;
    }
.end annotation


# instance fields
.field public action:Ljava/lang/String;

.field public actor:Lcom/poshmark/data_model/models/Actor;

.field public contentArray:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<*>;"
        }
    .end annotation
.end field

.field public contentTotalCount:I

.field public contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

.field public createdAt:Ljava/lang/String;

.field public footer:Ljava/lang/String;

.field public header:Ljava/lang/String;

.field public headerIconUrl:Ljava/lang/String;

.field public imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

.field public layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

.field public storyType:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 261
    return-void
.end method

.method public static getViewLayoutTypeCount()I
    .locals 6

    .prologue
    .line 278
    sget-object v4, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->VIEW_LAYOUT_TYPE_COUNT:Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/FeedItem$ViewLayoutType;->ordinal()I

    .line 279
    sget-object v4, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->invalid:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->ordinal()I

    move-result v1

    .line 280
    .local v1, "headerOrdinal":I
    sget-object v4, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->Invalid:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->ordinal()I

    move-result v2

    .line 281
    .local v2, "imageOrdinal":I
    sget-object v4, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->invalid:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->ordinal()I

    move-result v0

    .line 283
    .local v0, "footerOrdinal":I
    new-instance v3, Ljava/lang/String;

    const-string v4, ""

    invoke-direct {v3, v4}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    .line 284
    .local v3, "maxCountStr":Ljava/lang/String;
    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    .line 285
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 286
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 288
    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    return v4
.end method


# virtual methods
.method public computeFeedItemLayout()V
    .locals 2

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    if-eqz v0, :cond_7

    .line 59
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    .line 60
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v1, p0, Lcom/poshmark/data_model/models/FeedItem;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    iput-object v1, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    .line 62
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    iget-object v0, v0, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->SIFU_SOCIAL:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    if-ne v0, v1, :cond_1

    .line 65
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    new-instance v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;

    invoke-direct {v1}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;-><init>()V

    iput-object v1, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->headerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;

    .line 66
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->headerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->LEGACY_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    iput-object v1, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    .line 68
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    new-instance v1, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    invoke-direct {v1}, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;-><init>()V

    iput-object v1, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->footerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    .line 69
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->footerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->LEGACY_FOOTER:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    iput-object v1, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    .line 103
    :cond_0
    :goto_0
    return-void

    .line 72
    :cond_1
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->header:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 73
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    new-instance v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;

    invoke-direct {v1}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;-><init>()V

    iput-object v1, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->headerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;

    .line 74
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->storyType:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    move-result-object v0

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->LISTING_SHARE_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    if-ne v0, v1, :cond_4

    .line 75
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->headerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->DOUBLE_LEVEL_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    iput-object v1, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    .line 84
    :cond_2
    :goto_1
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    new-instance v1, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    invoke-direct {v1}, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;-><init>()V

    iput-object v1, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->footerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    .line 85
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    iget-object v0, v0, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->SIFU_SUMMARY:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    if-eq v0, v1, :cond_3

    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    iget-object v0, v0, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->SIFU_SOCIAL:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    if-ne v0, v1, :cond_6

    :cond_3
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v0, v0, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Post:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v0, v1, :cond_6

    .line 87
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    new-instance v1, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    invoke-direct {v1}, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;-><init>()V

    iput-object v1, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->footerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    .line 88
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->footerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->SOCIAL_ACTIONS_FOOTER:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    iput-object v1, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    goto :goto_0

    .line 76
    :cond_4
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->storyType:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    move-result-object v0

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->POSHPOST_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    if-ne v0, v1, :cond_5

    .line 77
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->headerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->SINGLE_LEVEL_HEADER_POSHPOST:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    iput-object v1, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    goto :goto_1

    .line 79
    :cond_5
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->headerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->SINGLE_LEVEL_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    iput-object v1, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    goto :goto_1

    .line 90
    :cond_6
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->footer:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 91
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    new-instance v1, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    invoke-direct {v1}, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;-><init>()V

    iput-object v1, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->footerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    .line 92
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->footerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->SIMPLE_LAUNCH_FOOTER:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    iput-object v1, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    goto/16 :goto_0

    .line 101
    :cond_7
    const-string v0, "Test"

    const-string v1, "Test"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0
.end method

.method public getActorId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->actor:Lcom/poshmark/data_model/models/Actor;

    if-eqz v0, :cond_0

    .line 195
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->actor:Lcom/poshmark/data_model/models/Actor;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Actor;->getId()Ljava/lang/String;

    move-result-object v0

    .line 198
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getActorImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->actor:Lcom/poshmark/data_model/models/Actor;

    if-eqz v0, :cond_0

    .line 188
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->actor:Lcom/poshmark/data_model/models/Actor;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Actor;->getAvataar()Ljava/lang/String;

    move-result-object v0

    .line 190
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getAttributionText()Ljava/lang/String;
    .locals 4

    .prologue
    .line 364
    iget-object v2, p0, Lcom/poshmark/data_model/models/FeedItem;->storyType:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    move-result-object v2

    sget-object v3, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_ADD_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    if-eq v2, v3, :cond_0

    iget-object v2, p0, Lcom/poshmark/data_model/models/FeedItem;->storyType:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    move-result-object v2

    sget-object v3, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_UPDATE_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    if-eq v2, v3, :cond_0

    iget-object v2, p0, Lcom/poshmark/data_model/models/FeedItem;->storyType:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    move-result-object v2

    sget-object v3, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->LISTING_SHARE_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    if-eq v2, v3, :cond_0

    iget-object v2, p0, Lcom/poshmark/data_model/models/FeedItem;->storyType:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    move-result-object v2

    sget-object v3, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->SELF_SHARE_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    if-ne v2, v3, :cond_1

    .line 368
    :cond_0
    iget-object v2, p0, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v2, v2, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v3, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Post:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v2, v3, :cond_1

    iget-object v2, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_1

    .line 369
    iget-object v2, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    const/4 v3, 0x0

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSocial;

    .line 370
    .local v0, "listing":Lcom/poshmark/data_model/models/ListingSocial;
    new-instance v1, Lcom/poshmark/utils/TextFormatter;

    invoke-direct {v1}, Lcom/poshmark/utils/TextFormatter;-><init>()V

    .line 371
    .local v1, "textFormatter":Lcom/poshmark/utils/TextFormatter;
    invoke-virtual {v1, v0}, Lcom/poshmark/utils/TextFormatter;->getPublishedAtMessageString(Lcom/poshmark/data_model/models/ListingSocial;)Ljava/lang/String;

    move-result-object v2

    .line 375
    .end local v0    # "listing":Lcom/poshmark/data_model/models/ListingSocial;
    .end local v1    # "textFormatter":Lcom/poshmark/utils/TextFormatter;
    :goto_0
    return-object v2

    :cond_1
    iget-object v2, p0, Lcom/poshmark/data_model/models/FeedItem;->createdAt:Ljava/lang/String;

    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/poshmark/utils/DateUtils;->formatDateForDisplay(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method public getContentFromIndex(ILjava/lang/Class;)Ljava/lang/Object;
    .locals 2
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/Class",
            "<*>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .prologue
    .line 123
    .local p2, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-le v0, p1, :cond_2

    .line 124
    const-class v0, Lcom/poshmark/data_model/models/ListingSocial;

    if-ne p2, v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v0, v0, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Post:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v0, v1, :cond_0

    .line 125
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSocial;

    .line 131
    :goto_0
    return-object v0

    .line 126
    :cond_0
    const-class v0, Lcom/poshmark/data_model/models/Brand;

    if-ne p2, v0, :cond_1

    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v0, v0, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Brand:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v0, v1, :cond_1

    .line 127
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/Brand;

    goto :goto_0

    .line 128
    :cond_1
    const-class v0, Lcom/poshmark/data_model/models/inner_models/UserReference;

    if-ne p2, v0, :cond_2

    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v0, v0, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->User:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v0, v1, :cond_2

    .line 129
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/UserReference;

    goto :goto_0

    .line 131
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getContentIdFromIndex(I)Ljava/lang/String;
    .locals 5
    .param p1, "index"    # I

    .prologue
    .line 106
    iget-object v3, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-le v3, p1, :cond_0

    .line 107
    sget-object v3, Lcom/poshmark/data_model/models/FeedItem$1;->$SwitchMap$com$poshmark$data_model$models$FeedItemContentType$ContentType:[I

    iget-object v4, p0, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v4, v4, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 119
    :cond_0
    const/4 v3, 0x0

    :goto_0
    return-object v3

    .line 109
    :pswitch_0
    iget-object v3, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/Brand;

    .line 110
    .local v0, "brand":Lcom/poshmark/data_model/models/Brand;
    iget-object v3, v0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    goto :goto_0

    .line 112
    .end local v0    # "brand":Lcom/poshmark/data_model/models/Brand;
    :pswitch_1
    iget-object v3, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/ListingSocial;

    .line 113
    .local v1, "listing":Lcom/poshmark/data_model/models/ListingSocial;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 115
    .end local v1    # "listing":Lcom/poshmark/data_model/models/ListingSocial;
    :pswitch_2
    iget-object v3, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/inner_models/UserReference;

    .line 116
    .local v2, "user":Lcom/poshmark/data_model/models/inner_models/UserReference;
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getUserId()Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 107
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public getContentImageUrlFromIndex(ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)Ljava/lang/String;
    .locals 6
    .param p1, "index"    # I
    .param p2, "size"    # Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    .prologue
    .line 135
    iget-object v4, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-le v4, p1, :cond_0

    .line 136
    sget-object v4, Lcom/poshmark/data_model/models/FeedItem$1;->$SwitchMap$com$poshmark$data_model$models$FeedItemContentType$ContentType:[I

    iget-object v5, p0, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v5, v5, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    .line 162
    :cond_0
    const/4 v4, 0x0

    :goto_0
    return-object v4

    .line 138
    :pswitch_0
    iget-object v4, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v4, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/Brand;

    .line 139
    .local v0, "brand":Lcom/poshmark/data_model/models/Brand;
    iget-object v4, v0, Lcom/poshmark/data_model/models/Brand;->logo:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    if-eqz v4, :cond_0

    .line 140
    sget-object v4, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->LARGE:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    if-ne p2, v4, :cond_1

    .line 141
    iget-object v4, v0, Lcom/poshmark/data_model/models/Brand;->logo:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v4, v4, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url:Ljava/lang/String;

    goto :goto_0

    .line 143
    :cond_1
    iget-object v4, v0, Lcom/poshmark/data_model/models/Brand;->logo:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v4, v4, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    goto :goto_0

    .line 148
    .end local v0    # "brand":Lcom/poshmark/data_model/models/Brand;
    :pswitch_1
    iget-object v4, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v4, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/ListingSocial;

    .line 149
    .local v1, "listing":Lcom/poshmark/data_model/models/ListingSocial;
    sget-object v4, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->LARGE:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    if-ne p2, v4, :cond_2

    .line 150
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSocial;->getCovershot()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 152
    :cond_2
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSocial;->getSmallCovershot()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 155
    .end local v1    # "listing":Lcom/poshmark/data_model/models/ListingSocial;
    :pswitch_2
    iget-object v4, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v4, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/inner_models/UserReference;

    .line 156
    .local v3, "user":Lcom/poshmark/data_model/models/inner_models/UserReference;
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getAvataar()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 158
    .end local v3    # "user":Lcom/poshmark/data_model/models/inner_models/UserReference;
    :pswitch_3
    iget-object v4, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v4, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/PoshmarkPost;

    .line 159
    .local v2, "post":Lcom/poshmark/data_model/models/PoshmarkPost;
    iget-object v4, v2, Lcom/poshmark/data_model/models/PoshmarkPost;->image:Lcom/poshmark/data_model/models/PoshmarkPost$PostImage;

    iget-object v4, v4, Lcom/poshmark/data_model/models/PoshmarkPost$PostImage;->url:Ljava/lang/String;

    goto :goto_0

    .line 136
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public getContentOwnerImageUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 387
    iget-object v1, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v1, v1, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v2, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Post:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v1, v2, :cond_0

    .line 388
    iget-object v1, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSocial;

    .line 389
    .local v0, "listing":Lcom/poshmark/data_model/models/ListingSocial;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getAvataar()Ljava/lang/String;

    move-result-object v1

    .line 391
    .end local v0    # "listing":Lcom/poshmark/data_model/models/ListingSocial;
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getContentOwnerName()Ljava/lang/String;
    .locals 3

    .prologue
    .line 379
    iget-object v1, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v1, v1, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v2, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Post:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v1, v2, :cond_0

    .line 380
    iget-object v1, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSocial;

    .line 381
    .local v0, "listing":Lcom/poshmark/data_model/models/ListingSocial;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getUserName()Ljava/lang/String;

    move-result-object v1

    .line 383
    .end local v0    # "listing":Lcom/poshmark/data_model/models/ListingSocial;
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getContentStringFromIndex(I)Ljava/lang/String;
    .locals 7
    .param p1, "index"    # I

    .prologue
    .line 166
    iget-object v3, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-le v3, p1, :cond_2

    .line 167
    iget-object v3, p0, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v3, v3, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v4, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Brand:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v3, v4, :cond_0

    .line 168
    iget-object v3, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/Brand;

    .line 169
    .local v0, "brand":Lcom/poshmark/data_model/models/Brand;
    iget-object v3, v0, Lcom/poshmark/data_model/models/Brand;->logo:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    if-nez v3, :cond_2

    .line 170
    iget-object v3, v0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    .line 183
    .end local v0    # "brand":Lcom/poshmark/data_model/models/Brand;
    :goto_0
    return-object v3

    .line 171
    :cond_0
    iget-object v3, p0, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v3, v3, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v4, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->User:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v3, v4, :cond_1

    .line 172
    iget-object v3, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/inner_models/UserReference;

    .line 173
    .local v2, "user":Lcom/poshmark/data_model/models/inner_models/UserReference;
    if-eqz v2, :cond_2

    .line 174
    const-string v3, "@%s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getUserName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 176
    .end local v2    # "user":Lcom/poshmark/data_model/models/inner_models/UserReference;
    :cond_1
    iget-object v3, p0, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v3, v3, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v4, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->PoshmarkPost:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v3, v4, :cond_2

    .line 177
    iget-object v3, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/PoshmarkPost;

    .line 178
    .local v1, "post":Lcom/poshmark/data_model/models/PoshmarkPost;
    if-eqz v1, :cond_2

    .line 179
    iget-object v3, v1, Lcom/poshmark/data_model/models/PoshmarkPost;->text:Lcom/poshmark/data_model/models/PoshmarkPost$PostTitle;

    iget-object v3, v3, Lcom/poshmark/data_model/models/PoshmarkPost$PostTitle;->title:Ljava/lang/String;

    goto :goto_0

    .line 183
    .end local v1    # "post":Lcom/poshmark/data_model/models/PoshmarkPost;
    :cond_2
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public getFooterString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->footer:Ljava/lang/String;

    return-object v0
.end method

.method public getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->storyType:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    return-object v0
.end method

.method public getViewLayoutTypeId()I
    .locals 7

    .prologue
    .line 294
    const/4 v1, 0x0

    .line 295
    .local v1, "headerOrdinal":I
    const/4 v2, 0x0

    .line 296
    .local v2, "imageOrdinal":I
    const/4 v0, 0x0

    .line 298
    .local v0, "footerOrdinal":I
    iget-object v5, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v5, v5, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->headerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;

    if-eqz v5, :cond_0

    .line 299
    iget-object v5, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v5, v5, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->headerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;

    iget-object v5, v5, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->ordinal()I

    move-result v1

    .line 302
    :cond_0
    iget-object v5, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v5, v5, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    if-eqz v5, :cond_1

    .line 303
    iget-object v5, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v5, v5, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    iget-object v5, v5, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->ordinal()I

    move-result v2

    .line 306
    :cond_1
    iget-object v5, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v5, v5, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->footerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    if-eqz v5, :cond_2

    .line 307
    iget-object v5, p0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v5, v5, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->footerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    iget-object v5, v5, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->ordinal()I

    move-result v0

    .line 310
    :cond_2
    new-instance v4, Ljava/lang/String;

    const-string v5, ""

    invoke-direct {v4, v5}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    .line 311
    .local v4, "viewIdStr":Ljava/lang/String;
    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    .line 312
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 313
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 315
    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    .line 316
    .local v3, "viewId":I
    return v3
.end method

.method public getViewType()Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/poshmark/data_model/models/FeedItem;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    iget-object v0, v0, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    return-object v0
.end method

.method public renderHeaderAvataar(Landroid/content/Context;Lcom/poshmark/ui/customviews/PMAvataarImageView;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "avataarView"    # Lcom/poshmark/ui/customviews/PMAvataarImageView;

    .prologue
    .line 233
    iget-object v1, p0, Lcom/poshmark/data_model/models/FeedItem;->actor:Lcom/poshmark/data_model/models/Actor;

    if-eqz v1, :cond_2

    .line 234
    iget-object v1, p0, Lcom/poshmark/data_model/models/FeedItem;->actor:Lcom/poshmark/data_model/models/Actor;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/Actor;->getAvataar()Ljava/lang/String;

    move-result-object v0

    .line 235
    .local v0, "url":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 236
    invoke-virtual {p2, v0}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->loadImage(Ljava/lang/String;)V

    .line 253
    .end local v0    # "url":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 238
    .restart local v0    # "url":Ljava/lang/String;
    :cond_1
    iget-object v1, p0, Lcom/poshmark/data_model/models/FeedItem;->actor:Lcom/poshmark/data_model/models/Actor;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/Actor;->getDefaultAvataarImageId()I

    move-result v1

    invoke-virtual {p2, v1}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->loadImage(I)V

    goto :goto_0

    .line 241
    .end local v0    # "url":Ljava/lang/String;
    :cond_2
    iget-object v1, p0, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v1, v1, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v2, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->User:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v1, v2, :cond_3

    .line 242
    const v1, 0x7f020116

    invoke-virtual {p2, v1}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->loadImage(I)V

    goto :goto_0

    .line 243
    :cond_3
    iget-object v1, p0, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v1, v1, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v2, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Brand:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v1, v2, :cond_4

    .line 244
    const v1, 0x7f02006b

    invoke-virtual {p2, v1}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->loadImage(I)V

    goto :goto_0

    .line 245
    :cond_4
    iget-object v1, p0, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v1, v1, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v2, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->PoshmarkPost:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v1, v2, :cond_0

    .line 246
    iget-object v1, p0, Lcom/poshmark/data_model/models/FeedItem;->headerIconUrl:Ljava/lang/String;

    if-eqz v1, :cond_5

    .line 247
    iget-object v1, p0, Lcom/poshmark/data_model/models/FeedItem;->headerIconUrl:Ljava/lang/String;

    invoke-virtual {p2, v1}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->loadImage(Ljava/lang/String;)V

    goto :goto_0

    .line 249
    :cond_5
    const v1, 0x7f0200f6

    invoke-virtual {p2, v1}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->loadImage(I)V

    goto :goto_0
.end method

.method public setActor(Lcom/poshmark/data_model/models/Actor;)V
    .locals 0
    .param p1, "actor"    # Lcom/poshmark/data_model/models/Actor;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/poshmark/data_model/models/FeedItem;->actor:Lcom/poshmark/data_model/models/Actor;

    .line 40
    return-void
.end method

.method public setHeaderIconUrl(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 256
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 257
    iput-object p1, p0, Lcom/poshmark/data_model/models/FeedItem;->headerIconUrl:Ljava/lang/String;

    .line 259
    :cond_0
    return-void
.end method

.method public validate()Z
    .locals 6

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 203
    iget-object v4, p0, Lcom/poshmark/data_model/models/FeedItem;->storyType:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    move-result-object v4

    sget-object v5, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_CHECKOUT_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    if-eq v4, v5, :cond_0

    iget-object v4, p0, Lcom/poshmark/data_model/models/FeedItem;->storyType:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    move-result-object v4

    sget-object v5, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_JUSTIN_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    if-eq v4, v5, :cond_0

    iget-object v4, p0, Lcom/poshmark/data_model/models/FeedItem;->storyType:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    move-result-object v4

    sget-object v5, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_RECOMMEND_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    if-eq v4, v5, :cond_0

    iget-object v4, p0, Lcom/poshmark/data_model/models/FeedItem;->storyType:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    move-result-object v4

    sget-object v5, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_RECOMMEND_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    if-eq v4, v5, :cond_0

    iget-object v4, p0, Lcom/poshmark/data_model/models/FeedItem;->storyType:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    move-result-object v4

    sget-object v5, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->POSHPOST_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    if-ne v4, v5, :cond_2

    :cond_0
    move v0, v2

    .line 209
    .local v0, "canActorBeNull":Z
    :goto_0
    if-nez v0, :cond_3

    iget-object v4, p0, Lcom/poshmark/data_model/models/FeedItem;->actor:Lcom/poshmark/data_model/models/Actor;

    if-nez v4, :cond_3

    move v2, v3

    .line 226
    :cond_1
    :goto_1
    return v2

    .end local v0    # "canActorBeNull":Z
    :cond_2
    move v0, v3

    .line 203
    goto :goto_0

    .line 213
    .restart local v0    # "canActorBeNull":Z
    :cond_3
    iget-object v4, p0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v1

    .line 214
    .local v1, "contentArraySize":I
    sget-object v4, Lcom/poshmark/data_model/models/FeedItem$1;->$SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout:[I

    iget-object v5, p0, Lcom/poshmark/data_model/models/FeedItem;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    iget-object v5, v5, Lcom/poshmark/data_model/models/FeedItemImageLayout;->currentLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    move v2, v3

    .line 226
    goto :goto_1

    .line 216
    :pswitch_0
    if-gtz v1, :cond_1

    move v2, v3

    goto :goto_1

    .line 218
    :pswitch_1
    if-gtz v1, :cond_1

    move v2, v3

    goto :goto_1

    .line 220
    :pswitch_2
    if-gtz v1, :cond_1

    move v2, v3

    goto :goto_1

    .line 222
    :pswitch_3
    const/4 v4, 0x2

    if-gt v1, v4, :cond_1

    move v2, v3

    goto :goto_1

    .line 224
    :pswitch_4
    const/4 v4, 0x3

    if-gt v1, v4, :cond_1

    move v2, v3

    goto :goto_1

    .line 214
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method
