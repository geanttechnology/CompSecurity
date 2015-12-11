.class public Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;
.super Landroid/widget/Filter;
.source "RetailSearchSuggestionFilter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter$FilterResultValue;
    }
.end annotation


# static fields
.field private static final ALIAS_APS:Ljava/lang/String; = "aps"


# instance fields
.field private filterListener:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;

.field platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private searchAlias:Ljava/lang/String;

.field private final searchBox:Landroid/widget/EditText;

.field private searchEntryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

.field private suggestionDataProvider:Lcom/amazon/retailsearch/data/ISuggestionDataProvider;

.field suggestionRows:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/data/ISuggestionDataProvider;Ljava/lang/String;Landroid/widget/EditText;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;)V
    .locals 1
    .param p1, "suggestionDataProvider"    # Lcom/amazon/retailsearch/data/ISuggestionDataProvider;
    .param p2, "searchAlias"    # Ljava/lang/String;
    .param p3, "searchBox"    # Landroid/widget/EditText;
    .param p4, "searchEntryContext"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;
    .param p5, "filterListener"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;

    .prologue
    .line 63
    invoke-direct {p0}, Landroid/widget/Filter;-><init>()V

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->suggestionRows:Ljava/util/List;

    .line 64
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 65
    iput-object p4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchEntryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    .line 66
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchBox:Landroid/widget/EditText;

    .line 67
    iput-object p5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->filterListener:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;

    .line 68
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->suggestionDataProvider:Lcom/amazon/retailsearch/data/ISuggestionDataProvider;

    .line 69
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchAlias:Ljava/lang/String;

    .line 70
    return-void
.end method

.method private addQueryParam(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "query"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 188
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 190
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "&"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p3}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 192
    .end local p1    # "query":Ljava/lang/String;
    :cond_0
    return-object p1
.end method

.method private appendBarcodeEntries(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 199
    .local p1, "rows":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;>;"
    new-instance v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;-><init>()V

    .line 200
    .local v0, "row":Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchEntryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->voiceEnabled()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setVoiceEnabled(Z)V

    .line 201
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchEntryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->hasSnapIt()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setHasSnap(Z)V

    .line 202
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchEntryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->isFlowEnabled()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setFlowEnabled(Z)V

    .line 203
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchEntryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->showVisualScan()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setShowVisualScan(Z)V

    .line 204
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchEntryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->showBarcodeEntry()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setShowBarcode(Z)V

    .line 205
    sget-object v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;->ICON:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setRowType(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;)V

    .line 206
    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 207
    return-void
.end method

.method private appendSuggestionData(Ljava/util/List;Ljava/util/List;)V
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 126
    .local p1, "rows":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;>;"
    .local p2, "suggestions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    if-nez p2, :cond_1

    .line 175
    :cond_0
    return-void

    .line 131
    :cond_1
    const/4 v0, 0x0

    .line 132
    .local v0, "a9SuggestionSize":I
    const/4 v9, 0x0

    .line 133
    .local v9, "xcatSize":I
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/retailsearch/data/SuggestionDataItem;

    .line 135
    .local v7, "s":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    invoke-virtual {v7}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getType()Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    move-result-object v8

    .line 136
    .local v8, "type":Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;
    sget-object v10, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->A9_SUGGESTION:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual {v10, v8}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_3

    sget-object v10, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->MERGED:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual {v10, v8}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_2

    .line 138
    :cond_3
    add-int/lit8 v0, v0, 0x1

    .line 139
    invoke-virtual {v7}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isXcatValue()Z

    move-result v10

    if-eqz v10, :cond_2

    .line 141
    add-int/lit8 v9, v9, 0x1

    goto :goto_0

    .line 146
    .end local v7    # "s":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    .end local v8    # "type":Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;
    :cond_4
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/retailsearch/data/SuggestionDataItem;

    .line 148
    .restart local v7    # "s":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    new-instance v6, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;

    invoke-direct {v6}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;-><init>()V

    .line 149
    .local v6, "row":Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;
    invoke-virtual {v7}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getSuggestion()Ljava/lang/String;

    move-result-object v5

    .line 150
    .local v5, "query":Ljava/lang/String;
    const-string/jumbo v10, "paramText"

    invoke-direct {p0, v10, v5}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->makeQuery(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 151
    .local v4, "intentData":Ljava/lang/String;
    invoke-virtual {v7}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getSearchAlias()Ljava/lang/String;

    move-result-object v2

    .line 152
    .local v2, "filters":Ljava/lang/String;
    const-string/jumbo v10, "aps"

    invoke-virtual {v10, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_6

    const/4 v1, 0x0

    .line 153
    .local v1, "departmentName":Ljava/lang/String;
    :goto_2
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_5

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_5

    .line 155
    const-string/jumbo v10, "paramSuggestionDepartmentName"

    invoke-direct {p0, v4, v10, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->addQueryParam(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 157
    :cond_5
    const-string/jumbo v10, "paramSuggestionDepartmentFilter"

    invoke-direct {p0, v4, v10, v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->addQueryParam(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 158
    invoke-virtual {v6, v5}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setSuggestion(Ljava/lang/String;)V

    .line 159
    invoke-virtual {v6, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setDepartment(Ljava/lang/String;)V

    .line 160
    invoke-virtual {v7}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getDeleteURL()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v10}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setDeleteUrl(Ljava/lang/String;)V

    .line 161
    invoke-virtual {v6, v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setIntentData(Ljava/lang/String;)V

    .line 162
    invoke-virtual {v7}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v10}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setPastSearchId(Ljava/lang/String;)V

    .line 163
    invoke-virtual {v7}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getQuery()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v10}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setQuery(Ljava/lang/String;)V

    .line 164
    invoke-virtual {v7}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getPos()I

    move-result v10

    invoke-virtual {v6, v10}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setPos(I)V

    .line 165
    invoke-virtual {v7}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getXcatPos()I

    move-result v10

    invoke-virtual {v6, v10}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setXcatPos(I)V

    .line 166
    invoke-virtual {v7}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isSpellCorrectedValue()Z

    move-result v10

    invoke-virtual {v6, v10}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setSpellCorrected(Z)V

    .line 167
    invoke-virtual {v7}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isXcatValue()Z

    move-result v10

    invoke-virtual {v6, v10}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setXcat(Z)V

    .line 168
    invoke-virtual {v7}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isFallbackValue()Z

    move-result v10

    invoke-virtual {v6, v10}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setFallBack(Z)V

    .line 169
    sget-object v10, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;->SUGGESTION:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    invoke-virtual {v6, v10}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setRowType(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;)V

    .line 170
    invoke-virtual {v7}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getType()Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    move-result-object v10

    invoke-virtual {v6, v10}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setSuggestionType(Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;)V

    .line 171
    invoke-virtual {v6, v9}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setXcatSize(I)V

    .line 172
    invoke-virtual {v6, v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->setA9SuggestionSize(I)V

    .line 173
    invoke-interface {p1, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 152
    .end local v1    # "departmentName":Ljava/lang/String;
    :cond_6
    invoke-virtual {v7}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getDepartmentName()Ljava/lang/String;

    move-result-object v1

    goto :goto_2
.end method

.method private makeQuery(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 179
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 181
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "?"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p2}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 183
    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "?"

    goto :goto_0
.end method


# virtual methods
.method protected performFiltering(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;
    .locals 8
    .param p1, "constraint"    # Ljava/lang/CharSequence;

    .prologue
    const/4 v7, 0x0

    .line 75
    new-instance v1, Landroid/widget/Filter$FilterResults;

    invoke-direct {v1}, Landroid/widget/Filter$FilterResults;-><init>()V

    .line 76
    .local v1, "results":Landroid/widget/Filter$FilterResults;
    if-nez p1, :cond_0

    .line 116
    .end local p1    # "constraint":Ljava/lang/CharSequence;
    :goto_0
    return-object v1

    .line 81
    .restart local p1    # "constraint":Ljava/lang/CharSequence;
    :cond_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->filterListener:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;

    if-eqz v4, :cond_1

    .line 83
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->filterListener:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;

    invoke-interface {v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;->beforePerformFiltering()V

    .line 86
    :cond_1
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 90
    .local v2, "rows":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;>;"
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchEntryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->hasScanIt()Z

    move-result v4

    if-nez v4, :cond_2

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchEntryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->hasSnapIt()Z

    move-result v4

    if-eqz v4, :cond_4

    :cond_2
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchEntryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->getCurrentDepartmentName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchEntryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->isFirstTimeEnter()Z

    move-result v4

    if-eqz v4, :cond_4

    .line 94
    :cond_3
    invoke-direct {p0, v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->appendBarcodeEntries(Ljava/util/List;)V

    .line 95
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v4

    iput v4, v1, Landroid/widget/Filter$FilterResults;->count:I

    .line 96
    new-instance v5, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter$FilterResultValue;

    move-object v4, p1

    check-cast v4, Ljava/lang/String;

    invoke-direct {v5, p0, v2, v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter$FilterResultValue;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;Ljava/util/List;Ljava/lang/String;)V

    iput-object v5, v1, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    .line 97
    invoke-virtual {p0, p1, v1, v7}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;Z)V

    .line 100
    :cond_4
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->suggestionDataProvider:Lcom/amazon/retailsearch/data/ISuggestionDataProvider;

    if-eqz v4, :cond_5

    .line 104
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchEntryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    monitor-enter v5

    .line 106
    :try_start_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchEntryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->isForceUpdatePastSearches()Z

    move-result v0

    .line 107
    .local v0, "isForceUpdatePastSearches":Z
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchEntryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    const/4 v6, 0x0

    invoke-virtual {v4, v6}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->setForceUpdatePastSearches(Z)V

    .line 108
    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 109
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->suggestionDataProvider:Lcom/amazon/retailsearch/data/ISuggestionDataProvider;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchAlias:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6, v0}, Lcom/amazon/retailsearch/data/ISuggestionDataProvider;->getSuggestions(Ljava/lang/String;Ljava/lang/String;Z)Ljava/util/List;

    move-result-object v3

    .line 110
    .local v3, "suggestionData":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    invoke-direct {p0, v2, v3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->appendSuggestionData(Ljava/util/List;Ljava/util/List;)V

    .line 112
    .end local v0    # "isForceUpdatePastSearches":Z
    .end local v3    # "suggestionData":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    :cond_5
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchEntryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    invoke-virtual {v4, v7}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->setFirstTimeEnter(Z)V

    .line 114
    new-instance v4, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter$FilterResultValue;

    check-cast p1, Ljava/lang/String;

    .end local p1    # "constraint":Ljava/lang/CharSequence;
    invoke-direct {v4, p0, v2, p1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter$FilterResultValue;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;Ljava/util/List;Ljava/lang/String;)V

    iput-object v4, v1, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    .line 115
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v4

    iput v4, v1, Landroid/widget/Filter$FilterResults;->count:I

    goto/16 :goto_0

    .line 108
    .restart local p1    # "constraint":Ljava/lang/CharSequence;
    :catchall_0
    move-exception v4

    :try_start_1
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v4
.end method

.method protected publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;)V
    .locals 1
    .param p1, "constraint"    # Ljava/lang/CharSequence;
    .param p2, "results"    # Landroid/widget/Filter$FilterResults;

    .prologue
    .line 212
    const/4 v0, 0x1

    invoke-virtual {p0, p1, p2, v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;Z)V

    .line 213
    return-void
.end method

.method protected publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;Z)V
    .locals 7
    .param p1, "constraint"    # Ljava/lang/CharSequence;
    .param p2, "results"    # Landroid/widget/Filter$FilterResults;
    .param p3, "hideSpinner"    # Z

    .prologue
    .line 223
    if-eqz p2, :cond_0

    iget-object v5, p2, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    if-nez v5, :cond_1

    .line 270
    .end local p1    # "constraint":Ljava/lang/CharSequence;
    :cond_0
    :goto_0
    return-void

    .line 231
    .restart local p1    # "constraint":Ljava/lang/CharSequence;
    :cond_1
    iget-object v0, p2, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    check-cast v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter$FilterResultValue;

    .line 232
    .local v0, "filterResultValue":Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter$FilterResultValue;
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->suggestionRows:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->clear()V

    .line 233
    iget-object v5, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter$FilterResultValue;->rows:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;

    .line 235
    .local v2, "row":Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->suggestionRows:Ljava/util/List;

    invoke-interface {v5, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 237
    .end local v2    # "row":Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;
    :cond_2
    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter$FilterResultValue;->searchTerm:Ljava/lang/String;

    .line 239
    .local v3, "searchTerm":Ljava/lang/String;
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->filterListener:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;

    if-eqz v5, :cond_3

    .line 241
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->filterListener:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;

    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->suggestionRows:Ljava/util/List;

    invoke-interface {v5, v6, p3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;->beforePublishResults(Ljava/util/List;Z)V

    .line 254
    :cond_3
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->suggestionRows:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_4

    .line 256
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->searchBox:Landroid/widget/EditText;

    invoke-virtual {v5}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 257
    .local v4, "text":Ljava/lang/String;
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_4

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_4

    .line 259
    invoke-virtual {v4, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_4

    invoke-virtual {v3, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 266
    .end local v4    # "text":Ljava/lang/String;
    :cond_4
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->filterListener:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;

    if-eqz v5, :cond_0

    .line 268
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->filterListener:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;

    check-cast p1, Ljava/lang/String;

    .end local p1    # "constraint":Ljava/lang/CharSequence;
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;->suggestionRows:Ljava/util/List;

    invoke-interface {v5, p1, v6}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;->afterPublishResults(Ljava/lang/String;Ljava/util/List;)V

    goto :goto_0
.end method
