.class Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser$2;
.super Lcom/fasterxml/jackson/core/type/TypeReference;
.source "SearchSuggestionsParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser;->parseInfo(Lcom/fasterxml/jackson/core/JsonParser;Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/fasterxml/jackson/core/type/TypeReference",
        "<",
        "Ljava/util/List",
        "<",
        "Ljava/lang/String;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser;


# direct methods
.method constructor <init>(Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser;)V
    .locals 0

    .prologue
    .line 127
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser$2;->this$0:Lcom/amazon/searchapp/retailsearch/client/suggestions/jackson/SearchSuggestionsParser;

    invoke-direct {p0}, Lcom/fasterxml/jackson/core/type/TypeReference;-><init>()V

    return-void
.end method
