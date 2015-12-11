.class public Lcom/amazon/retailsearch/data/SuggestionDataProvider;
.super Ljava/lang/Object;
.source "SuggestionDataProvider.java"

# interfaces
.implements Lcom/amazon/retailsearch/data/ISuggestionDataProvider;


# static fields
.field private static final MAX_AUX_SUGGESTIONS_ON_SEARCH:I = 0x2

.field private static final MAX_SUGGESTIONS:I = 0x6


# instance fields
.field private final SPACE:Ljava/lang/String;

.field private clientID:Ljava/lang/String;

.field private context:Landroid/content/Context;

.field searchDataProvider:Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private stringIn:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    const-string/jumbo v0, "in"

    iput-object v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->stringIn:Ljava/lang/String;

    .line 59
    const-string/jumbo v0, " "

    iput-object v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->SPACE:Ljava/lang/String;

    .line 71
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 72
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    const-string/jumbo v1, "in"

    iput-object v1, p0, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->stringIn:Ljava/lang/String;

    .line 59
    const-string/jumbo v1, " "

    iput-object v1, p0, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->SPACE:Ljava/lang/String;

    .line 80
    iput-object p1, p0, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->context:Landroid/content/Context;

    .line 81
    iget-object v1, p0, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->context:Landroid/content/Context;

    if-eqz v1, :cond_0

    .line 83
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$string;->searchbox_in:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->stringIn:Ljava/lang/String;

    .line 84
    sget v1, Lcom/amazon/retailsearch/R$string;->config_rs_client_id:I

    const-string/jumbo v2, "strings"

    const-string/jumbo v3, "config_rs_client_id"

    invoke-static {v1, p1, v2, v3}, Lcom/amazon/retailsearch/android/util/ResUtils;->getResourceId(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 85
    .local v0, "resid":I
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->clientID:Ljava/lang/String;

    .line 87
    .end local v0    # "resid":I
    :cond_0
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 88
    return-void
.end method

.method private mergeSuggestions(Ljava/util/List;Ljava/util/List;)Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 143
    .local p1, "searchSuggestions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    .local p2, "pastSearches":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 145
    .local v3, "result":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    new-instance v5, Ljava/util/HashSet;

    invoke-direct {v5}, Ljava/util/HashSet;-><init>()V

    .line 148
    .local v5, "usedSuggestions":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/data/SuggestionDataItem;

    .line 150
    .local v1, "pastSearch":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    invoke-virtual {v1}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getDisplayText()Ljava/lang/String;

    move-result-object v2

    .line 151
    .local v2, "pastSearchText":Ljava/lang/String;
    invoke-interface {v5, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 155
    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 156
    invoke-interface {v5, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 157
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v6

    const/4 v7, 0x2

    if-ne v6, v7, :cond_0

    .line 164
    .end local v1    # "pastSearch":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    .end local v2    # "pastSearchText":Ljava/lang/String;
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_2
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/retailsearch/data/SuggestionDataItem;

    .line 166
    .local v4, "searchSuggestion":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    invoke-virtual {v4}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getDisplayText()Ljava/lang/String;

    move-result-object v2

    .line 167
    .restart local v2    # "pastSearchText":Ljava/lang/String;
    invoke-interface {v5, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 169
    invoke-direct {p0, v2, v3, v4}, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->updateMergedSuggestions(Ljava/lang/String;Ljava/util/List;Lcom/amazon/retailsearch/data/SuggestionDataItem;)V

    goto :goto_0

    .line 172
    :cond_3
    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 173
    invoke-interface {v5, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 174
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v6

    const/4 v7, 0x6

    if-ne v6, v7, :cond_2

    .line 180
    .end local v2    # "pastSearchText":Ljava/lang/String;
    .end local v4    # "searchSuggestion":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    :cond_4
    return-object v3
.end method

.method private updateMergedSuggestions(Ljava/lang/String;Ljava/util/List;Lcom/amazon/retailsearch/data/SuggestionDataItem;)V
    .locals 4
    .param p1, "displayText"    # Ljava/lang/String;
    .param p3, "suggestionToMerge"    # Lcom/amazon/retailsearch/data/SuggestionDataItem;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ")V"
        }
    .end annotation

    .prologue
    .line 191
    .local p2, "suggestions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    if-eqz p2, :cond_0

    if-nez p3, :cond_1

    .line 208
    :cond_0
    :goto_0
    return-void

    .line 195
    :cond_1
    const/4 v1, 0x0

    .line 196
    .local v1, "index":I
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/retailsearch/data/SuggestionDataItem;

    .line 198
    .local v2, "suggestion":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    invoke-virtual {v2}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getDisplayText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 200
    sget-object v3, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->MERGED:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual {p3, v3}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setType(Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;)V

    .line 201
    invoke-virtual {v2}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p3, v3}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setId(Ljava/lang/String;)V

    .line 202
    invoke-virtual {v2}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getDeleteURL()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p3, v3}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setDeleteURL(Ljava/lang/String;)V

    .line 203
    invoke-interface {p2, v1, p3}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 206
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1
.end method


# virtual methods
.method public deletePastSearches(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 3
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "deleteURL"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 319
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 324
    :cond_0
    :goto_0
    return v1

    .line 323
    :cond_1
    iget-object v2, p0, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->searchDataProvider:Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;

    invoke-interface {v2, p1, p2}, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;->deletePersonalizedSuggestions(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    move-result-object v0

    .line 324
    .local v0, "personalizedSuggestions":Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;->getRequestId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method

.method public getPastSearches(Ljava/lang/String;Z)Ljava/util/List;
    .locals 6
    .param p1, "query"    # Ljava/lang/String;
    .param p2, "forceUpdate"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 216
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 217
    .local v3, "result":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    iget-object v5, p0, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->searchDataProvider:Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;

    invoke-interface {v5, p1, p2}, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;->getPersonalizedSuggestions(Ljava/lang/String;Z)Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    move-result-object v2

    .line 218
    .local v2, "personalizedSuggestions":Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
    if-eqz v2, :cond_0

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;->getSearchedText()Ljava/util/List;

    move-result-object v5

    if-nez v5, :cond_1

    .line 235
    :cond_0
    return-object v3

    .line 223
    :cond_1
    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;->getSearchedText()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/searchapp/retailsearch/model/SearchedText;

    .line 225
    .local v4, "searchedText":Lcom/amazon/searchapp/retailsearch/model/SearchedText;
    new-instance v1, Lcom/amazon/retailsearch/data/SuggestionDataItem;

    invoke-direct {v1}, Lcom/amazon/retailsearch/data/SuggestionDataItem;-><init>()V

    .line 226
    .local v1, "item":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/SearchedText;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setId(Ljava/lang/String;)V

    .line 227
    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/SearchedText;->getKeywords()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setSuggestion(Ljava/lang/String;)V

    .line 228
    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/SearchedText;->getKeywords()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setDisplayText(Ljava/lang/String;)V

    .line 229
    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/SearchedText;->getAlias()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setSearchAlias(Ljava/lang/String;)V

    .line 230
    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/SearchedText;->getDisplayAlias()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setDepartmentName(Ljava/lang/String;)V

    .line 231
    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/SearchedText;->getDeleteUrl()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setDeleteURL(Ljava/lang/String;)V

    .line 232
    sget-object v5, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->PAST_SEARCHES:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual {v1, v5}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setType(Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;)V

    .line 233
    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public getSearchSuggestions(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 20
    .param p1, "searchAlias"    # Ljava/lang/String;
    .param p2, "query"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 246
    new-instance v13, Ljava/util/ArrayList;

    invoke-direct {v13}, Ljava/util/ArrayList;-><init>()V

    .line 247
    .local v13, "result":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    invoke-static/range {p2 .. p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v18

    if-eqz v18, :cond_1

    .line 313
    :cond_0
    return-object v13

    .line 251
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->searchDataProvider:Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->clientID:Ljava/lang/String;

    move-object/from16 v19, v0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    move-object/from16 v2, p1

    move-object/from16 v3, p2

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;->getSearchSuggestions(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;

    move-result-object v14

    .line 252
    .local v14, "searchSuggestions":Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;
    if-eqz v14, :cond_0

    invoke-interface {v14}, Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;->getSuggestions()Ljava/util/List;

    move-result-object v18

    if-eqz v18, :cond_0

    .line 257
    const/4 v12, 0x1

    .line 258
    .local v12, "pos":I
    invoke-interface {v14}, Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;->getSuggestions()Ljava/util/List;

    move-result-object v18

    invoke-interface/range {v18 .. v18}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v18

    if-eqz v18, :cond_0

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/amazon/searchapp/retailsearch/model/Suggestion;

    .line 260
    .local v16, "suggestion":Lcom/amazon/searchapp/retailsearch/model/Suggestion;
    invoke-interface/range {v16 .. v16}, Lcom/amazon/searchapp/retailsearch/model/Suggestion;->getSpellCorrected()I

    move-result v18

    const/16 v19, 0x1

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_4

    const/4 v10, 0x1

    .line 261
    .local v10, "isSpellCorrected":Z
    :goto_1
    const/4 v9, 0x0

    .line 262
    .local v9, "isFallback":Z
    invoke-interface/range {v16 .. v16}, Lcom/amazon/searchapp/retailsearch/model/Suggestion;->getSource()Ljava/util/List;

    move-result-object v18

    if-eqz v18, :cond_3

    .line 264
    invoke-interface/range {v16 .. v16}, Lcom/amazon/searchapp/retailsearch/model/Suggestion;->getSource()Ljava/util/List;

    move-result-object v18

    invoke-interface/range {v18 .. v18}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v18

    if-eqz v18, :cond_3

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    .line 266
    .local v15, "source":Ljava/lang/String;
    const-string/jumbo v18, "fb"

    move-object/from16 v0, v18

    invoke-virtual {v0, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_2

    .line 268
    const/4 v9, 0x1

    .line 273
    .end local v8    # "i$":Ljava/util/Iterator;
    .end local v15    # "source":Ljava/lang/String;
    :cond_3
    new-instance v4, Lcom/amazon/retailsearch/data/SuggestionDataItem;

    invoke-direct {v4}, Lcom/amazon/retailsearch/data/SuggestionDataItem;-><init>()V

    .line 274
    .local v4, "apsItem":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    invoke-interface/range {v16 .. v16}, Lcom/amazon/searchapp/retailsearch/model/Suggestion;->getSuggestion()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v4, v0}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setSuggestion(Ljava/lang/String;)V

    .line 275
    invoke-interface/range {v16 .. v16}, Lcom/amazon/searchapp/retailsearch/model/Suggestion;->getSuggestion()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v4, v0}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setDisplayText(Ljava/lang/String;)V

    .line 276
    sget-object v18, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->A9_SUGGESTION:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    move-object/from16 v0, v18

    invoke-virtual {v4, v0}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setType(Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;)V

    .line 277
    move-object/from16 v0, p2

    invoke-virtual {v4, v0}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setQuery(Ljava/lang/String;)V

    .line 278
    invoke-virtual {v4, v12}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setPos(I)V

    .line 279
    invoke-virtual {v4, v10}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setSpellCorrected(Z)V

    .line 280
    const/16 v18, 0x0

    move/from16 v0, v18

    invoke-virtual {v4, v0}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setXcat(Z)V

    .line 281
    invoke-virtual {v4, v9}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setFallback(Z)V

    .line 282
    invoke-interface {v13, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 283
    invoke-interface/range {v16 .. v16}, Lcom/amazon/searchapp/retailsearch/model/Suggestion;->getDepartments()Ljava/util/List;

    move-result-object v6

    .line 284
    .local v6, "depts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;>;"
    if-eqz v6, :cond_6

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v18

    if-lez v18, :cond_6

    .line 286
    const/16 v17, 0x1

    .line 287
    .local v17, "xcatPos":I
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .restart local v8    # "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v18

    if-eqz v18, :cond_6

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;

    .line 289
    .local v5, "dept":Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;
    const-string/jumbo v18, "aps"

    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;->getAlias()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_5

    .line 291
    move/from16 v0, v17

    invoke-virtual {v4, v0}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setXcatPos(I)V

    .line 308
    :goto_3
    add-int/lit8 v17, v17, 0x1

    goto :goto_2

    .line 260
    .end local v4    # "apsItem":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    .end local v5    # "dept":Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;
    .end local v6    # "depts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;>;"
    .end local v8    # "i$":Ljava/util/Iterator;
    .end local v9    # "isFallback":Z
    .end local v10    # "isSpellCorrected":Z
    .end local v17    # "xcatPos":I
    :cond_4
    const/4 v10, 0x0

    goto/16 :goto_1

    .line 295
    .restart local v4    # "apsItem":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    .restart local v5    # "dept":Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;
    .restart local v6    # "depts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;>;"
    .restart local v8    # "i$":Ljava/util/Iterator;
    .restart local v9    # "isFallback":Z
    .restart local v10    # "isSpellCorrected":Z
    .restart local v17    # "xcatPos":I
    :cond_5
    new-instance v11, Lcom/amazon/retailsearch/data/SuggestionDataItem;

    invoke-direct {v11}, Lcom/amazon/retailsearch/data/SuggestionDataItem;-><init>()V

    .line 296
    .local v11, "item":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    invoke-interface/range {v16 .. v16}, Lcom/amazon/searchapp/retailsearch/model/Suggestion;->getSuggestion()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setSuggestion(Ljava/lang/String;)V

    .line 297
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface/range {v16 .. v16}, Lcom/amazon/searchapp/retailsearch/model/Suggestion;->getSuggestion()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, " "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->stringIn:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, " "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;->getName()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setDisplayText(Ljava/lang/String;)V

    .line 298
    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;->getName()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setDepartmentName(Ljava/lang/String;)V

    .line 299
    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;->getAlias()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setSearchAlias(Ljava/lang/String;)V

    .line 300
    sget-object v18, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->A9_SUGGESTION:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setType(Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;)V

    .line 301
    invoke-virtual {v11, v12}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setPos(I)V

    .line 302
    move/from16 v0, v17

    invoke-virtual {v11, v0}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setXcatPos(I)V

    .line 303
    invoke-virtual {v11, v10}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setSpellCorrected(Z)V

    .line 304
    const/16 v18, 0x1

    move/from16 v0, v18

    invoke-virtual {v11, v0}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setXcat(Z)V

    .line 305
    invoke-virtual {v11, v9}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->setFallback(Z)V

    .line 306
    invoke-interface {v13, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 311
    .end local v5    # "dept":Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;
    .end local v8    # "i$":Ljava/util/Iterator;
    .end local v11    # "item":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    .end local v17    # "xcatPos":I
    :cond_6
    add-int/lit8 v12, v12, 0x1

    .line 312
    goto/16 :goto_0
.end method

.method public getSuggestions(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p1, "query"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 95
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->getSuggestions(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSuggestions(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p1, "searchAlias"    # Ljava/lang/String;
    .param p2, "query"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 103
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->getSuggestions(Ljava/lang/String;Ljava/lang/String;Z)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSuggestions(Ljava/lang/String;Ljava/lang/String;Z)Ljava/util/List;
    .locals 3
    .param p1, "searchAlias"    # Ljava/lang/String;
    .param p2, "query"    # Ljava/lang/String;
    .param p3, "forceUpdatePastSearches"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Z)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 119
    invoke-virtual {p0, p2, p3}, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->getPastSearches(Ljava/lang/String;Z)Ljava/util/List;

    move-result-object v0

    .line 121
    .local v0, "pastSearches":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 123
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->getSearchSuggestions(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 124
    .local v1, "searchSuggestions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    invoke-direct {p0, v1, v0}, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->mergeSuggestions(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 128
    .end local v0    # "pastSearches":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    .end local v1    # "searchSuggestions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    :cond_0
    return-object v0
.end method

.method public getSuggestions(Ljava/lang/String;Z)Ljava/util/List;
    .locals 2
    .param p1, "query"    # Ljava/lang/String;
    .param p2, "forceUpdatePastSearches"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 111
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p1, v1}, Lcom/amazon/retailsearch/data/SuggestionDataProvider;->getSuggestions(Ljava/lang/String;Ljava/lang/String;Z)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
