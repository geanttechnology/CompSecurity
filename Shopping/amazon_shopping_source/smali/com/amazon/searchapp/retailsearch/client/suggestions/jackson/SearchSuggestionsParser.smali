.class public Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser;
.super Ljava/lang/Object;
.source "SearchSuggestionsParser.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall$ResponseParser;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;
    .locals 1

    .prologue
    .line 139
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/jackson/StandardParser;->getMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v0

    return-object v0
.end method

.method private parseInfo(Lcom/fasterxml/jackson/core/JsonParser;Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;)V
    .locals 7
    .param p1, "parser"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "suggestions"    # Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 96
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->START_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 97
    new-instance v5, Ljava/io/IOException;

    invoke-direct {v5}, Ljava/io/IOException;-><init>()V

    throw v5

    .line 100
    :cond_0
    invoke-virtual {p2}, Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;->getSuggestions()Ljava/util/List;

    move-result-object v2

    .line 101
    .local v2, "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Suggestion;>;"
    const/4 v0, 0x0

    .line 103
    .local v0, "index":I
    :goto_0
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_8

    .line 104
    if-eqz v2, :cond_1

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v5

    if-lt v0, v5, :cond_2

    .line 105
    :cond_1
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_0

    .line 109
    :cond_2
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "index":I
    .local v1, "index":I
    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/searchapp/retailsearch/model/Suggestion;

    .line 111
    .local v4, "suggestion":Lcom/amazon/searchapp/retailsearch/model/Suggestion;
    :cond_3
    :goto_1
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_7

    .line 112
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v3

    .line 114
    .local v3, "name":Ljava/lang/String;
    const-string/jumbo v5, "nodes"

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 115
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextValue()Lcom/fasterxml/jackson/core/JsonToken;

    .line 116
    new-instance v5, Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser$1;

    invoke-direct {v5, p0}, Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser$1;-><init>(Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser;)V

    invoke-virtual {p1, v5}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Lcom/fasterxml/jackson/core/type/TypeReference;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-interface {v4, v5}, Lcom/amazon/searchapp/retailsearch/model/Suggestion;->setDepartments(Ljava/util/List;)V

    goto :goto_1

    .line 118
    :cond_4
    const-string/jumbo v5, "conf"

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 119
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextValue()Lcom/fasterxml/jackson/core/JsonToken;

    .line 120
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getValueAsInt()I

    move-result v5

    invoke-interface {v4, v5}, Lcom/amazon/searchapp/retailsearch/model/Suggestion;->setConfidence(I)V

    goto :goto_1

    .line 121
    :cond_5
    const-string/jumbo v5, "sc"

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 122
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextValue()Lcom/fasterxml/jackson/core/JsonToken;

    .line 123
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getValueAsInt()I

    move-result v5

    invoke-interface {v4, v5}, Lcom/amazon/searchapp/retailsearch/model/Suggestion;->setSpellCorrected(I)V

    goto :goto_1

    .line 124
    :cond_6
    const-string/jumbo v5, "source"

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 125
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextValue()Lcom/fasterxml/jackson/core/JsonToken;

    .line 126
    new-instance v5, Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser$2;

    invoke-direct {v5, p0}, Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser$2;-><init>(Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser;)V

    invoke-virtual {p1, v5}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Lcom/fasterxml/jackson/core/type/TypeReference;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-interface {v4, v5}, Lcom/amazon/searchapp/retailsearch/model/Suggestion;->setSource(Ljava/util/List;)V

    goto :goto_1

    .end local v3    # "name":Ljava/lang/String;
    :cond_7
    move v0, v1

    .line 130
    .end local v1    # "index":I
    .restart local v0    # "index":I
    goto/16 :goto_0

    .line 131
    .end local v4    # "suggestion":Lcom/amazon/searchapp/retailsearch/model/Suggestion;
    :cond_8
    return-void
.end method

.method private parseSuggestions(Lcom/fasterxml/jackson/core/JsonParser;Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;)V
    .locals 4
    .param p1, "parser"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "suggestions"    # Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;
    .param p3, "listener"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 63
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->START_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 64
    new-instance v2, Ljava/io/IOException;

    invoke-direct {v2}, Ljava/io/IOException;-><init>()V

    throw v2

    .line 67
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 69
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Suggestion;>;"
    :cond_1
    :goto_0
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 70
    new-instance v1, Lcom/amazon/searchapp/retailsearch/entity/SuggestionEntity;

    invoke-direct {v1}, Lcom/amazon/searchapp/retailsearch/entity/SuggestionEntity;-><init>()V

    .line 71
    .local v1, "suggestion":Lcom/amazon/searchapp/retailsearch/model/Suggestion;
    const-class v2, Ljava/lang/String;

    invoke-virtual {p1, v2}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v1, v2}, Lcom/amazon/searchapp/retailsearch/model/Suggestion;->setSuggestion(Ljava/lang/String;)V

    .line 72
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 74
    if-eqz p3, :cond_1

    .line 75
    invoke-interface {p3, v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;->suggestion(Lcom/amazon/searchapp/retailsearch/model/Suggestion;)V

    goto :goto_0

    .line 79
    .end local v1    # "suggestion":Lcom/amazon/searchapp/retailsearch/model/Suggestion;
    :cond_2
    invoke-virtual {p2, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;->setSuggestions(Ljava/util/List;)V

    .line 81
    if-eqz p3, :cond_3

    .line 82
    invoke-interface {p3, v0}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;->suggestionList(Ljava/util/List;)V

    .line 84
    :cond_3
    return-void
.end method


# virtual methods
.method public parse(Ljava/io/InputStream;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;)Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;
    .locals 4
    .param p1, "content"    # Ljava/io/InputStream;
    .param p2, "listener"    # Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 39
    new-instance v1, Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;

    invoke-direct {v1}, Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;-><init>()V

    .line 40
    .local v1, "suggestions":Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser;->getMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v2

    invoke-virtual {v2}, Lcom/fasterxml/jackson/databind/ObjectMapper;->getFactory()Lcom/fasterxml/jackson/core/JsonFactory;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/fasterxml/jackson/core/JsonFactory;->createParser(Ljava/io/InputStream;)Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v0

    .line 44
    .local v0, "parser":Lcom/fasterxml/jackson/core/JsonParser;
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->START_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 45
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    .line 46
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/JsonParser;->getValueAsString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;->setQuery(Ljava/lang/String;)V

    .line 47
    invoke-direct {p0, v0, v1, p2}, Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser;->parseSuggestions(Lcom/fasterxml/jackson/core/JsonParser;Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsListener;)V

    .line 48
    invoke-direct {p0, v0, v1}, Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser;->parseInfo(Lcom/fasterxml/jackson/core/JsonParser;Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;)V

    .line 51
    :cond_0
    return-object v1
.end method
