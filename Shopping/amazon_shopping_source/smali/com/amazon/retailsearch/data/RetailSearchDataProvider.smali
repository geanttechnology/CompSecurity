.class public Lcom/amazon/retailsearch/data/RetailSearchDataProvider;
.super Ljava/lang/Object;
.source "RetailSearchDataProvider.java"

# interfaces
.implements Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;


# static fields
.field private static final ALIAS_APS:Ljava/lang/String; = "aps"

.field public static final WORD_MATCHING_PATTERN:Ljava/lang/String; = "(^|(?:\\s))"


# instance fields
.field private final assetsLoader:Lcom/amazon/retailsearch/data/assets/AssetsLoader;

.field featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private personalizedSuggestions:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

.field private searchSuggestionsMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->searchSuggestionsMap:Ljava/util/Map;

    .line 56
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->personalizedSuggestions:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    .line 61
    new-instance v0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    invoke-direct {v0}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->assetsLoader:Lcom/amazon/retailsearch/data/assets/AssetsLoader;

    .line 68
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 69
    return-void
.end method

.method private isKeywordsMatchQuery(Ljava/lang/String;Ljava/lang/String;Ljava/util/regex/Pattern;)Z
    .locals 3
    .param p1, "keywords"    # Ljava/lang/String;
    .param p2, "query"    # Ljava/lang/String;
    .param p3, "pattern"    # Ljava/util/regex/Pattern;

    .prologue
    .line 176
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 178
    :cond_0
    const/4 v1, 0x0

    .line 190
    :goto_0
    return v1

    .line 180
    :cond_1
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getLocale()Ljava/lang/String;

    move-result-object v0

    .line 182
    .local v0, "locale":Ljava/lang/String;
    sget-object v1, Ljava/util/Locale;->CHINA:Ljava/util/Locale;

    invoke-virtual {v1}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    sget-object v1, Ljava/util/Locale;->JAPAN:Ljava/util/Locale;

    invoke-virtual {v1}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 185
    :cond_2
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    goto :goto_0

    .line 190
    :cond_3
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p3, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/regex/Matcher;->find()Z

    move-result v1

    goto :goto_0
.end method


# virtual methods
.method public clearAssets()V
    .locals 1

    .prologue
    .line 251
    iget-object v0, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->assetsLoader:Lcom/amazon/retailsearch/data/assets/AssetsLoader;

    invoke-interface {v0}, Lcom/amazon/retailsearch/data/assets/AssetsLoader;->clear()V

    .line 252
    return-void
.end method

.method public clearSuggestions()V
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->searchSuggestionsMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 236
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->personalizedSuggestions:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    .line 237
    return-void
.end method

.method public declared-synchronized deletePersonalizedSuggestions(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
    .locals 8
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "deleteURL"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    .line 200
    monitor-enter p0

    :try_start_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_0

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v7

    if-eqz v7, :cond_1

    .line 227
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v6

    .line 205
    :cond_1
    :try_start_1
    const-string/jumbo v7, "r"

    invoke-static {p2, v7}, Lcom/amazon/retailsearch/util/UrlUtils;->getParameterValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 206
    .local v3, "r":Ljava/lang/String;
    const-string/jumbo v7, "k"

    invoke-static {p2, v7}, Lcom/amazon/retailsearch/util/UrlUtils;->getParameterValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 207
    .local v1, "k":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_0

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_0

    .line 213
    iget-object v6, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->personalizedSuggestions:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    if-eqz v6, :cond_3

    iget-object v6, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->personalizedSuggestions:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    invoke-interface {v6}, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;->getSearchedText()Ljava/util/List;

    move-result-object v6

    if-eqz v6, :cond_3

    .line 215
    iget-object v6, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->personalizedSuggestions:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    invoke-interface {v6}, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;->getSearchedText()Ljava/util/List;

    move-result-object v5

    .line 216
    .local v5, "searchedTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/SearchedText;>;"
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/amazon/searchapp/retailsearch/model/SearchedText;>;"
    :cond_2
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 218
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/searchapp/retailsearch/model/SearchedText;

    .line 219
    .local v4, "searchedText":Lcom/amazon/searchapp/retailsearch/model/SearchedText;
    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/SearchedText;->getId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 221
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 200
    .end local v0    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/amazon/searchapp/retailsearch/model/SearchedText;>;"
    .end local v1    # "k":Ljava/lang/String;
    .end local v3    # "r":Ljava/lang/String;
    .end local v4    # "searchedText":Lcom/amazon/searchapp/retailsearch/model/SearchedText;
    .end local v5    # "searchedTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/SearchedText;>;"
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    .line 226
    .restart local v1    # "k":Ljava/lang/String;
    .restart local v3    # "r":Ljava/lang/String;
    :cond_3
    :try_start_2
    new-instance v2, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;

    invoke-direct {v2}, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;-><init>()V

    .line 227
    .local v2, "loader":Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;
    invoke-virtual {v2, v3, v1}, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;->deletePersonalizedSuggestions(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v6

    goto :goto_0
.end method

.method public fetchAssets(Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V
    .locals 1
    .param p1, "fetchType"    # Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    .prologue
    .line 245
    iget-object v0, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->assetsLoader:Lcom/amazon/retailsearch/data/assets/AssetsLoader;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/data/assets/AssetsLoader;->load(Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V

    .line 246
    return-void
.end method

.method public getBadge(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 2
    .param p1, "badgeId"    # Ljava/lang/String;

    .prologue
    .line 260
    iget-object v1, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->assetsLoader:Lcom/amazon/retailsearch/data/assets/AssetsLoader;

    invoke-interface {v1}, Lcom/amazon/retailsearch/data/assets/AssetsLoader;->getBadges()Ljava/util/Map;

    move-result-object v0

    .line 261
    .local v0, "badges":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroid/graphics/Bitmap;>;"
    if-eqz v0, :cond_0

    .line 263
    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/graphics/Bitmap;

    .line 265
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getPersonalizedSuggestions(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
    .locals 1
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 108
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->getPersonalizedSuggestions(Ljava/lang/String;Z)Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getPersonalizedSuggestions(Ljava/lang/String;Z)Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
    .locals 10
    .param p1, "query"    # Ljava/lang/String;
    .param p2, "forceUpdate"    # Z

    .prologue
    .line 117
    monitor-enter p0

    if-eqz p2, :cond_2

    .line 119
    :try_start_0
    new-instance v4, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;

    invoke-direct {v4}, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;-><init>()V

    .line 120
    .local v4, "loader":Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;
    invoke-virtual {v4}, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;->getPersonalizedSuggestions()Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    move-result-object v8

    iput-object v8, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->personalizedSuggestions:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    .line 125
    iget-object v8, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->personalizedSuggestions:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    if-eqz v8, :cond_2

    iget-object v8, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->personalizedSuggestions:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    invoke-interface {v8}, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;->getSearchedText()Ljava/util/List;

    move-result-object v8

    if-eqz v8, :cond_2

    .line 127
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 128
    .local v3, "keywordMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 129
    .local v7, "searchedTextList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/SearchedText;>;"
    iget-object v8, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->personalizedSuggestions:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    invoke-interface {v8}, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;->getSearchedText()Ljava/util/List;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/amazon/searchapp/retailsearch/model/SearchedText;

    .line 131
    .local v6, "searchedText":Lcom/amazon/searchapp/retailsearch/model/SearchedText;
    invoke-interface {v6}, Lcom/amazon/searchapp/retailsearch/model/SearchedText;->getKeywords()Ljava/lang/String;

    move-result-object v2

    .line 132
    .local v2, "keyword":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_0

    invoke-interface {v3, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 134
    const-string/jumbo v8, "aps"

    invoke-interface {v6, v8}, Lcom/amazon/searchapp/retailsearch/model/SearchedText;->setAlias(Ljava/lang/String;)V

    .line 135
    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v6, v8}, Lcom/amazon/searchapp/retailsearch/model/SearchedText;->setKeywords(Ljava/lang/String;)V

    .line 136
    invoke-interface {v7, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 137
    invoke-interface {v3, v2, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 117
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "keyword":Ljava/lang/String;
    .end local v3    # "keywordMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v4    # "loader":Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;
    .end local v6    # "searchedText":Lcom/amazon/searchapp/retailsearch/model/SearchedText;
    .end local v7    # "searchedTextList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/SearchedText;>;"
    :catchall_0
    move-exception v8

    monitor-exit p0

    throw v8

    .line 141
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v3    # "keywordMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v4    # "loader":Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;
    .restart local v7    # "searchedTextList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/SearchedText;>;"
    :cond_1
    :try_start_1
    iget-object v8, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->personalizedSuggestions:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    invoke-interface {v8, v7}, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;->setSearchedText(Ljava/util/List;)V

    .line 145
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v3    # "keywordMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v4    # "loader":Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;
    .end local v7    # "searchedTextList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/SearchedText;>;"
    :cond_2
    iget-object v8, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->personalizedSuggestions:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    if-eqz v8, :cond_3

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 147
    :cond_3
    iget-object v0, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->personalizedSuggestions:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 165
    :cond_4
    :goto_1
    monitor-exit p0

    return-object v0

    .line 151
    :cond_5
    :try_start_2
    new-instance v0, Lcom/amazon/searchapp/retailsearch/entity/PersonalizedSuggestionsEntity;

    invoke-direct {v0}, Lcom/amazon/searchapp/retailsearch/entity/PersonalizedSuggestionsEntity;-><init>()V

    .line 152
    .local v0, "filteredSuggestions":Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
    iget-object v8, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->personalizedSuggestions:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    invoke-interface {v8}, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;->getSearchedText()Ljava/util/List;

    move-result-object v8

    if-eqz v8, :cond_4

    .line 154
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "(^|(?:\\s))"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/util/regex/Pattern;->quote(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v5

    .line 155
    .local v5, "pattern":Ljava/util/regex/Pattern;
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 156
    .restart local v7    # "searchedTextList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/SearchedText;>;"
    iget-object v8, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->personalizedSuggestions:Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    invoke-interface {v8}, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;->getSearchedText()Ljava/util/List;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_6
    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_7

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/amazon/searchapp/retailsearch/model/SearchedText;

    .line 158
    .restart local v6    # "searchedText":Lcom/amazon/searchapp/retailsearch/model/SearchedText;
    invoke-interface {v6}, Lcom/amazon/searchapp/retailsearch/model/SearchedText;->getKeywords()Ljava/lang/String;

    move-result-object v8

    invoke-direct {p0, v8, p1, v5}, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->isKeywordsMatchQuery(Ljava/lang/String;Ljava/lang/String;Ljava/util/regex/Pattern;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 160
    invoke-interface {v7, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 163
    .end local v6    # "searchedText":Lcom/amazon/searchapp/retailsearch/model/SearchedText;
    :cond_7
    invoke-interface {v0, v7}, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;->setSearchedText(Ljava/util/List;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method public declared-synchronized getSearchSuggestions(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;
    .locals 6
    .param p1, "clientID"    # Ljava/lang/String;
    .param p2, "searchAlias"    # Ljava/lang/String;
    .param p3, "query"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 77
    monitor-enter p0

    :try_start_0
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v4

    if-eqz v4, :cond_1

    .line 98
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v3

    .line 81
    :cond_1
    :try_start_1
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_2

    const-string/jumbo v4, "aps"

    :goto_1
    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "-"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 82
    .local v0, "key":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->searchSuggestionsMap:Ljava/util/Map;

    invoke-interface {v4, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 84
    iget-object v3, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->searchSuggestionsMap:Ljava/util/Map;

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;

    goto :goto_0

    .end local v0    # "key":Ljava/lang/String;
    :cond_2
    move-object v4, p2

    .line 81
    goto :goto_1

    .line 88
    .restart local v0    # "key":Ljava/lang/String;
    :cond_3
    new-instance v4, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;

    invoke-direct {v4}, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;-><init>()V

    invoke-virtual {v4, p2}, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->setSearchAlias(Ljava/lang/String;)Lcom/amazon/retailsearch/data/SearchSuggestionLoader;

    move-result-object v4

    invoke-virtual {v4, p3}, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->setQuery(Ljava/lang/String;)Lcom/amazon/retailsearch/data/SearchSuggestionLoader;

    move-result-object v4

    invoke-virtual {v4, p1}, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->setClientID(Ljava/lang/String;)Lcom/amazon/retailsearch/data/SearchSuggestionLoader;

    move-result-object v1

    .line 92
    .local v1, "loader":Lcom/amazon/retailsearch/data/SearchSuggestionLoader;
    invoke-virtual {v1}, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->getSearchSuggestions()Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;

    move-result-object v2

    .line 93
    .local v2, "searchSuggestions":Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;
    if-eqz v2, :cond_0

    .line 97
    iget-object v3, p0, Lcom/amazon/retailsearch/data/RetailSearchDataProvider;->searchSuggestionsMap:Ljava/util/Map;

    invoke-interface {v3, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-object v3, v2

    .line 98
    goto :goto_0

    .line 77
    .end local v0    # "key":Ljava/lang/String;
    .end local v1    # "loader":Lcom/amazon/retailsearch/data/SearchSuggestionLoader;
    .end local v2    # "searchSuggestions":Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3
.end method
