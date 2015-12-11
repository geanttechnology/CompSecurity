.class public final enum Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;
.super Ljava/lang/Enum;
.source "SearchSuggestionsParameterName.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

.field public static final enum CLIENT_ID:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

.field public static final enum CONFIDENCE:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

.field public static final enum MARKETPLACE_ID:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

.field public static final enum METHOD:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

.field public static final enum QUERY_PREFIX:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

.field public static final enum SEARCH_ALIAS:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;


# instance fields
.field private final name:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 15
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    const-string/jumbo v1, "METHOD"

    const-string/jumbo v2, "method"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->METHOD:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    .line 16
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    const-string/jumbo v1, "QUERY_PREFIX"

    const-string/jumbo v2, "q"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->QUERY_PREFIX:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    .line 17
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    const-string/jumbo v1, "SEARCH_ALIAS"

    const-string/jumbo v2, "search-alias"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->SEARCH_ALIAS:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    .line 18
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    const-string/jumbo v1, "CLIENT_ID"

    const-string/jumbo v2, "client-id"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->CLIENT_ID:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    .line 19
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    const-string/jumbo v1, "CONFIDENCE"

    const-string/jumbo v2, "conf"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->CONFIDENCE:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    .line 20
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    const-string/jumbo v1, "MARKETPLACE_ID"

    const/4 v2, 0x5

    const-string/jumbo v3, "mkt"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->MARKETPLACE_ID:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    .line 14
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->METHOD:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->QUERY_PREFIX:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->SEARCH_ALIAS:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->CLIENT_ID:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->CONFIDENCE:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->MARKETPLACE_ID:Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 28
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 29
    iput-object p3, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->name:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 14
    const-class v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    return-object v0
.end method

.method public static values()[Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->$VALUES:[Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    invoke-virtual {v0}, [Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName;->name:Ljava/lang/String;

    return-object v0
.end method
