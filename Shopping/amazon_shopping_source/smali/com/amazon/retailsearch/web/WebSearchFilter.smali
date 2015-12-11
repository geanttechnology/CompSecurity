.class public Lcom/amazon/retailsearch/web/WebSearchFilter;
.super Ljava/lang/Object;
.source "WebSearchFilter.java"


# static fields
.field private static final SEARCH_ALIAS_BIN_ID:Ljava/lang/String; = "i"

.field private static final SEARCH_FILTER_SEPARATOR:Ljava/lang/String; = "\n"

.field private static final SEARCH_NODE_BIN_ID:Ljava/lang/String; = "n"

.field private static final SEARCH_NODE_PREFIX:Ljava/lang/String; = "n:"


# instance fields
.field private mBinId:Ljava/lang/String;

.field private mCombinator:Ljava/lang/String;

.field private mFilterValue:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "bin"    # Ljava/lang/String;
    .param p2, "combinator"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 135
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 136
    iput-object p3, p0, Lcom/amazon/retailsearch/web/WebSearchFilter;->mFilterValue:Ljava/lang/String;

    .line 137
    iput-object p2, p0, Lcom/amazon/retailsearch/web/WebSearchFilter;->mCombinator:Ljava/lang/String;

    .line 138
    iput-object p1, p0, Lcom/amazon/retailsearch/web/WebSearchFilter;->mBinId:Ljava/lang/String;

    .line 139
    return-void
.end method

.method public static convertFiltersToBrowsePath(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "filters"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    .line 109
    invoke-static {p0}, Lcom/amazon/retailsearch/web/WebSearchFilter;->splitFilters(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 110
    .local v1, "filterArray":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/web/WebSearchFilter;>;"
    const-string/jumbo v0, ""

    .line 111
    .local v0, "browsePath":Ljava/lang/String;
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    .line 112
    .local v2, "filterSize":I
    if-ne v2, v4, :cond_1

    .line 114
    const/4 v4, 0x0

    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/retailsearch/web/WebSearchFilter;

    iget-object v0, v4, Lcom/amazon/retailsearch/web/WebSearchFilter;->mFilterValue:Ljava/lang/String;

    .line 124
    :cond_0
    :goto_0
    return-object v0

    .line 115
    :cond_1
    if-le v2, v4, :cond_0

    .line 117
    const/4 v3, 0x0

    .line 118
    .local v3, "i":I
    :goto_1
    add-int/lit8 v4, v2, -0x1

    if-ge v3, v4, :cond_2

    .line 120
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/retailsearch/web/WebSearchFilter;

    iget-object v4, v4, Lcom/amazon/retailsearch/web/WebSearchFilter;->mFilterValue:Ljava/lang/String;

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "::"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 118
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 122
    :cond_2
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/retailsearch/web/WebSearchFilter;

    iget-object v4, v4, Lcom/amazon/retailsearch/web/WebSearchFilter;->mFilterValue:Ljava/lang/String;

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static parse(Ljava/lang/String;)Lcom/amazon/retailsearch/web/WebSearchFilter;
    .locals 5
    .param p0, "filter"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x4

    .line 51
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 53
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Malformed filter: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 56
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, ":"

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    .line 58
    .local v0, "parts":[Ljava/lang/String;
    array-length v1, v0

    if-eq v1, v3, :cond_1

    .line 60
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Malformed filter: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 63
    :cond_1
    const/4 v1, 0x0

    aget-object v1, v0, v1

    const-string/jumbo v2, "s"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 65
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Malformed filter: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ". Filter should start with \'s\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 69
    :cond_2
    new-instance v1, Lcom/amazon/retailsearch/web/WebSearchFilter;

    const/4 v2, 0x1

    aget-object v2, v0, v2

    const/4 v3, 0x2

    aget-object v3, v0, v3

    const/4 v4, 0x3

    aget-object v4, v0, v4

    invoke-static {v4}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/amazon/retailsearch/web/WebSearchFilter;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v1
.end method

.method public static splitFilters(Ljava/lang/String;)Ljava/util/List;
    .locals 6
    .param p0, "filters"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/web/WebSearchFilter;",
            ">;"
        }
    .end annotation

    .prologue
    .line 81
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 82
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 93
    :cond_0
    return-object v4

    .line 86
    :cond_1
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 87
    .local v4, "splitFilters":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/web/WebSearchFilter;>;"
    const-string/jumbo v5, "\n"

    invoke-virtual {p0, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 89
    .local v1, "filter":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 90
    invoke-static {v1}, Lcom/amazon/retailsearch/web/WebSearchFilter;->parse(Ljava/lang/String;)Lcom/amazon/retailsearch/web/WebSearchFilter;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 87
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getCombinator()Ljava/lang/String;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/amazon/retailsearch/web/WebSearchFilter;->mCombinator:Ljava/lang/String;

    return-object v0
.end method

.method public getFilterValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/amazon/retailsearch/web/WebSearchFilter;->mFilterValue:Ljava/lang/String;

    return-object v0
.end method

.method public isAlias()Z
    .locals 2

    .prologue
    .line 162
    const-string/jumbo v0, "i"

    iget-object v1, p0, Lcom/amazon/retailsearch/web/WebSearchFilter;->mBinId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isNode()Z
    .locals 2

    .prologue
    .line 167
    const-string/jumbo v0, "n"

    iget-object v1, p0, Lcom/amazon/retailsearch/web/WebSearchFilter;->mBinId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 145
    invoke-virtual {p0}, Lcom/amazon/retailsearch/web/WebSearchFilter;->isNode()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 147
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "n:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/web/WebSearchFilter;->mFilterValue:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 151
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/web/WebSearchFilter;->mFilterValue:Ljava/lang/String;

    goto :goto_0
.end method
