.class public Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;
.super Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;
.source "PlayerSearchTalkListHelper.java"


# instance fields
.field private final searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchQuery;",
            ">;"
        }
    .end annotation
.end field

.field private final searchResultsFragment:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 21
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;-><init>(Landroid/content/Context;)V

    .line 22
    iput-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->searchResultsFragment:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .line 23
    iput-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    .line 24
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/util/List;)V
    .locals 1
    .param p1, "searchResultsFragment"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/view/search/SearchResultsFragment;",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchQuery;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 30
    .local p2, "searchQueryProvider":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<Lcom/xfinity/playerlib/view/search/SearchQuery;>;"
    .local p3, "results":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-direct {p0, p3, v0}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;-><init>(Ljava/util/List;Landroid/content/Context;)V

    .line 32
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->searchResultsFragment:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .line 33
    iput-object p2, p0, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    .line 34
    return-void
.end method


# virtual methods
.method protected getItemTypeQuantity(I)Ljava/lang/String;
    .locals 2
    .param p1, "quantity"    # I

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$plurals;->speech_result:I

    invoke-virtual {v0, v1, p1}, Landroid/content/res/Resources;->getQuantityString(II)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getResultRowDescriptions(Ljava/lang/StringBuilder;)V
    .locals 4
    .param p1, "sb"    # Ljava/lang/StringBuilder;

    .prologue
    .line 52
    iget v2, p0, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->lastListItemIndex:I

    mul-int/lit8 v0, v2, 0x5

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->results:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 54
    iget-object v2, p0, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->results:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    .line 55
    .local v1, "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->searchResultsFragment:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->results:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {v2, v1, v0, v3}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getVideoContentDescription(Lcom/comcast/cim/cmasl/utils/container/Tuple;II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 57
    iget v2, p0, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->lastListItemIndex:I

    mul-int/lit8 v2, v2, 0x5

    add-int/lit8 v2, v2, 0x4

    if-ne v0, v2, :cond_1

    .line 61
    .end local v1    # "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_0
    return-void

    .line 52
    .restart local v1    # "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public speakResults()Ljava/lang/String;
    .locals 4

    .prologue
    .line 38
    iget-object v2, p0, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/view/search/SearchQuery;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/search/SearchQuery;->getTitleFilter()Ljava/lang/String;

    move-result-object v1

    .line 39
    .local v1, "titleFilter":Ljava/lang/String;
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 41
    .local v0, "sb":Ljava/lang/StringBuilder;
    iget-object v2, p0, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->context:Landroid/content/Context;

    sget v3, Lcom/xfinity/playerlib/R$string;->speech_search_terms:I

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 42
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 43
    const-string v2, ". "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 45
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;->buildSpeechResponse(Ljava/lang/StringBuilder;)V

    .line 47
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method
