.class Lcom/amazon/retailsearch/data/SearchSuggestionLoader$RequestListener;
.super Lcom/amazon/searchapp/retailsearch/client/suggestions/AbstractSearchSuggestionsListener;
.source "SearchSuggestionLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/data/SearchSuggestionLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RequestListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/data/SearchSuggestionLoader;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/data/SearchSuggestionLoader;)V
    .locals 0

    .prologue
    .line 123
    iput-object p1, p0, Lcom/amazon/retailsearch/data/SearchSuggestionLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/data/SearchSuggestionLoader;

    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/client/suggestions/AbstractSearchSuggestionsListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/data/SearchSuggestionLoader;Lcom/amazon/retailsearch/data/SearchSuggestionLoader$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/data/SearchSuggestionLoader;
    .param p2, "x1"    # Lcom/amazon/retailsearch/data/SearchSuggestionLoader$1;

    .prologue
    .line 123
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/data/SearchSuggestionLoader$RequestListener;-><init>(Lcom/amazon/retailsearch/data/SearchSuggestionLoader;)V

    return-void
.end method


# virtual methods
.method public error(Ljava/lang/Exception;)V
    .locals 2
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 128
    # getter for: Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;
    invoke-static {}, Lcom/amazon/retailsearch/data/SearchSuggestionLoader;->access$100()Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    const-string/jumbo v1, "Search suggestion request error"

    invoke-interface {v0, v1, p1}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 129
    return-void
.end method
