.class public abstract Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;
.super Ljava/lang/Object;
.source "PlayerDefaultTalkListHelper.java"


# instance fields
.field protected final context:Landroid/content/Context;

.field protected lastListItemIndex:I

.field protected moreOrLess:Z

.field protected results:Ljava/util/List;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    const/4 v0, 0x0

    iput v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->lastListItemIndex:I

    .line 12
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->moreOrLess:Z

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->results:Ljava/util/List;

    .line 20
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->context:Landroid/content/Context;

    .line 21
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->results:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 22
    return-void
.end method

.method public constructor <init>(Ljava/util/List;Landroid/content/Context;)V
    .locals 1
    .param p1, "results"    # Ljava/util/List;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    const/4 v0, 0x0

    iput v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->lastListItemIndex:I

    .line 12
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->moreOrLess:Z

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->results:Ljava/util/List;

    .line 25
    iput-object p2, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->context:Landroid/content/Context;

    .line 26
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->results:Ljava/util/List;

    .line 27
    return-void
.end method

.method private offsetIndexValue(I)I
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 62
    iget v1, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->lastListItemIndex:I

    mul-int/lit8 v1, v1, 0x5

    add-int/2addr v1, p1

    add-int/lit8 v0, v1, -0x1

    .line 64
    .local v0, "actualItemIndex":I
    iget-object v1, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->results:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 68
    .end local v0    # "actualItemIndex":I
    :goto_0
    return v0

    .restart local v0    # "actualItemIndex":I
    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method


# virtual methods
.method public buildSpeechResponse(Ljava/lang/StringBuilder;)V
    .locals 1
    .param p1, "sb"    # Ljava/lang/StringBuilder;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->results:Ljava/util/List;

    if-nez v0, :cond_0

    .line 75
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->getResultAreNull(Ljava/lang/StringBuilder;)V

    .line 96
    :goto_0
    return-void

    .line 77
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->results:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_2

    .line 79
    iget v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->lastListItemIndex:I

    if-nez v0, :cond_1

    .line 81
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->getReturnedSomeResultsAtBeginning(Ljava/lang/StringBuilder;)V

    .line 89
    :goto_1
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->getResultRowDescriptions(Ljava/lang/StringBuilder;)V

    goto :goto_0

    .line 85
    :cond_1
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->getReturnedSomeResultsAfterBeginning(Ljava/lang/StringBuilder;)V

    goto :goto_1

    .line 93
    :cond_2
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->getReturnedNoResults(Ljava/lang/StringBuilder;)V

    goto :goto_0
.end method

.method protected abstract getItemTypeQuantity(I)Ljava/lang/String;
.end method

.method public getLessResults()Ljava/lang/String;
    .locals 2

    .prologue
    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->results:Ljava/util/List;

    if-nez v0, :cond_0

    .line 47
    const-string v0, ""

    .line 57
    :goto_0
    return-object v0

    .line 51
    :cond_0
    const/4 v0, -0x4

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->offsetIndexValue(I)I

    move-result v0

    if-gez v0, :cond_1

    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->context:Landroid/content/Context;

    sget v1, Lcom/xfinity/playerlib/R$string;->speech_list_at_beginning:I

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 55
    :cond_1
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->moreOrLess:Z

    .line 56
    iget v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->lastListItemIndex:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->lastListItemIndex:I

    .line 57
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->speakResults()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getMoreResults()Ljava/lang/String;
    .locals 2

    .prologue
    .line 31
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->results:Ljava/util/List;

    if-nez v0, :cond_0

    .line 32
    const-string v0, ""

    .line 41
    :goto_0
    return-object v0

    .line 35
    :cond_0
    const/4 v0, 0x6

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->offsetIndexValue(I)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 36
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->context:Landroid/content/Context;

    sget v1, Lcom/xfinity/playerlib/R$string;->speech_list_at_end:I

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 39
    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->moreOrLess:Z

    .line 40
    iget v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->lastListItemIndex:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->lastListItemIndex:I

    .line 41
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->speakResults()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected getResultAreNull(Ljava/lang/StringBuilder;)V
    .locals 5
    .param p1, "sb"    # Ljava/lang/StringBuilder;

    .prologue
    const/4 v4, 0x0

    .line 127
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    invoke-virtual {p1, v4, v0}, Ljava/lang/StringBuilder;->delete(II)Ljava/lang/StringBuilder;

    .line 128
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->context:Landroid/content/Context;

    sget v1, Lcom/xfinity/playerlib/R$string;->speech_list_helper_default_null_results:I

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x2

    invoke-virtual {p0, v3}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->getItemTypeQuantity(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 129
    return-void
.end method

.method protected abstract getResultRowDescriptions(Ljava/lang/StringBuilder;)V
.end method

.method protected getReturnedNoResults(Ljava/lang/StringBuilder;)V
    .locals 5
    .param p1, "sb"    # Ljava/lang/StringBuilder;

    .prologue
    .line 132
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->context:Landroid/content/Context;

    sget v1, Lcom/xfinity/playerlib/R$string;->speech_list_helper_returned_no_x:I

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    const/4 v4, 0x2

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->getItemTypeQuantity(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 133
    return-void
.end method

.method protected getReturnedSomeResultsAfterBeginning(Ljava/lang/StringBuilder;)V
    .locals 8
    .param p1, "sb"    # Ljava/lang/StringBuilder;

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    const/4 v5, 0x2

    .line 100
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->results:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget v1, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->lastListItemIndex:I

    mul-int/lit8 v1, v1, 0x5

    sub-int/2addr v0, v1

    if-ne v0, v6, :cond_0

    .line 101
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->context:Landroid/content/Context;

    sget v1, Lcom/xfinity/playerlib/R$string;->speech_list_one_item_left:I

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 114
    :goto_0
    return-void

    .line 103
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->results:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget v1, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->lastListItemIndex:I

    mul-int/lit8 v1, v1, 0x5

    add-int/lit8 v1, v1, 0x1

    sub-int/2addr v0, v1

    const/4 v1, 0x4

    if-ge v0, v1, :cond_1

    .line 104
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->context:Landroid/content/Context;

    sget v1, Lcom/xfinity/playerlib/R$string;->speech_list_last_results:I

    new-array v2, v5, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->results:Ljava/util/List;

    .line 105
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    iget v4, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->lastListItemIndex:I

    mul-int/lit8 v4, v4, 0x5

    sub-int/2addr v3, v4

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v7

    invoke-virtual {p0, v5}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->getItemTypeQuantity(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    .line 104
    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 108
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->context:Landroid/content/Context;

    sget v2, Lcom/xfinity/playerlib/R$string;->speech_list_some_results_after_beginning:I

    const/4 v0, 0x3

    new-array v3, v0, [Ljava/lang/Object;

    iget-boolean v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->moreOrLess:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->context:Landroid/content/Context;

    sget v4, Lcom/xfinity/playerlib/R$string;->speech_next:I

    .line 110
    invoke-virtual {v0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 111
    :goto_1
    aput-object v0, v3, v7

    const/4 v0, 0x5

    .line 112
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v3, v6

    invoke-virtual {p0, v5}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->getItemTypeQuantity(I)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v5

    .line 108
    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 110
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->context:Landroid/content/Context;

    sget v4, Lcom/xfinity/playerlib/R$string;->speech_previous:I

    .line 111
    invoke-virtual {v0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method protected getReturnedSomeResultsAtBeginning(Ljava/lang/StringBuilder;)V
    .locals 8
    .param p1, "sb"    # Ljava/lang/StringBuilder;

    .prologue
    const/4 v7, 0x5

    const/4 v6, 0x1

    const/4 v5, 0x0

    const/4 v4, 0x2

    .line 118
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->context:Landroid/content/Context;

    sget v1, Lcom/xfinity/playerlib/R$string;->speech_list_helper_returned_some_x:I

    new-array v2, v4, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->results:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v5

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->results:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {p0, v3}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->getItemTypeQuantity(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 120
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->results:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lt v0, v7, :cond_0

    .line 121
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->context:Landroid/content/Context;

    sget v1, Lcom/xfinity/playerlib/R$string;->speech_list_helper_start_count:I

    new-array v2, v4, [Ljava/lang/Object;

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;->getItemTypeQuantity(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 123
    :cond_0
    return-void
.end method

.method public abstract speakResults()Ljava/lang/String;
.end method
