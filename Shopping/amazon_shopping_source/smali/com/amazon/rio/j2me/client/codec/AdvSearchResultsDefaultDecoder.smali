.class public Lcom/amazon/rio/j2me/client/codec/AdvSearchResultsDefaultDecoder;
.super Ljava/lang/Object;
.source "AdvSearchResultsDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;
    .locals 13
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 21
    new-instance v8, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-direct {v8}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;-><init>()V

    .line 26
    .local v8, "record":Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 27
    .local v7, "isAbsent":Z
    if-nez v7, :cond_0

    .line 29
    const-wide/32 v9, -0x80000000

    const-wide/32 v11, 0x7fffffff

    invoke-static {v9, v10, v11, v12}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v9

    const/4 v10, 0x0

    invoke-interface {v9, p1, v10}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 30
    .local v0, "data":Ljava/lang/Integer;
    invoke-virtual {v8, v0}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->setTotalCount(Ljava/lang/Integer;)V

    .line 33
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_0
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 34
    if-nez v7, :cond_1

    .line 36
    const-wide/32 v9, -0x80000000

    const-wide/32 v11, 0x7fffffff

    invoke-static {v9, v10, v11, v12}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v9

    const/4 v10, 0x0

    invoke-interface {v9, p1, v10}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 37
    .restart local v0    # "data":Ljava/lang/Integer;
    invoke-virtual {v8, v0}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->setAvailableCount(Ljava/lang/Integer;)V

    .line 40
    .end local v0    # "data":Ljava/lang/Integer;
    :cond_1
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 41
    if-nez v7, :cond_2

    .line 43
    new-instance v9, Lcom/amazon/rio/j2me/client/codec/SearchResultDefaultDecoder;

    invoke-direct {v9}, Lcom/amazon/rio/j2me/client/codec/SearchResultDefaultDecoder;-><init>()V

    invoke-static {v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v9

    const/4 v10, 0x0

    invoke-interface {v9, p1, v10}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    .line 44
    .local v5, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    invoke-virtual {v8, v5}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->setResults(Ljava/util/List;)V

    .line 47
    .end local v5    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    :cond_2
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 48
    if-nez v7, :cond_3

    .line 50
    new-instance v9, Lcom/amazon/rio/j2me/client/codec/MinimalItemDefaultDecoder;

    invoke-direct {v9}, Lcom/amazon/rio/j2me/client/codec/MinimalItemDefaultDecoder;-><init>()V

    invoke-static {v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v9

    const/4 v10, 0x0

    invoke-interface {v9, p1, v10}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    .line 51
    .local v3, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/MinimalItem;>;"
    invoke-virtual {v8, v3}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->setStubs(Ljava/util/List;)V

    .line 54
    .end local v3    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/MinimalItem;>;"
    :cond_3
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 55
    if-nez v7, :cond_4

    .line 57
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v9

    const/4 v10, 0x0

    invoke-interface {v9, p1, v10}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 58
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v8, v0}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->setQuery(Ljava/lang/String;)V

    .line 61
    .end local v0    # "data":Ljava/lang/String;
    :cond_4
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 62
    if-nez v7, :cond_5

    .line 64
    new-instance v9, Lcom/amazon/rio/j2me/client/codec/RefinementBinDefaultDecoder;

    invoke-direct {v9}, Lcom/amazon/rio/j2me/client/codec/RefinementBinDefaultDecoder;-><init>()V

    invoke-static {v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v9

    const/4 v10, 0x0

    invoke-interface {v9, p1, v10}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    .line 65
    .local v4, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;>;"
    invoke-virtual {v8, v4}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->setRefinements(Ljava/util/List;)V

    .line 68
    .end local v4    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;>;"
    :cond_5
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 69
    if-nez v7, :cond_6

    .line 71
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v9

    const/4 v10, 0x0

    invoke-interface {v9, p1, v10}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 72
    .restart local v0    # "data":Ljava/lang/String;
    invoke-virtual {v8, v0}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->setFilters(Ljava/lang/String;)V

    .line 75
    .end local v0    # "data":Ljava/lang/String;
    :cond_6
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 76
    if-nez v7, :cond_7

    .line 78
    new-instance v9, Lcom/amazon/rio/j2me/client/codec/BreadcrumbDefaultDecoder;

    invoke-direct {v9}, Lcom/amazon/rio/j2me/client/codec/BreadcrumbDefaultDecoder;-><init>()V

    invoke-static {v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v9

    const/4 v10, 0x0

    invoke-interface {v9, p1, v10}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 79
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Breadcrumb;>;"
    invoke-virtual {v8, v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->setBreadcrumbs(Ljava/util/List;)V

    .line 82
    .end local v1    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Breadcrumb;>;"
    :cond_7
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 83
    if-nez v7, :cond_8

    .line 85
    new-instance v9, Lcom/amazon/rio/j2me/client/codec/SortOptionDefaultDecoder;

    invoke-direct {v9}, Lcom/amazon/rio/j2me/client/codec/SortOptionDefaultDecoder;-><init>()V

    invoke-static {v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v9

    const/4 v10, 0x0

    invoke-interface {v9, p1, v10}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    .line 86
    .local v6, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SortOption;>;"
    invoke-virtual {v8, v6}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->setSortOptions(Ljava/util/List;)V

    .line 89
    .end local v6    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SortOption;>;"
    :cond_8
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v7

    .line 90
    if-nez v7, :cond_9

    .line 92
    new-instance v9, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;

    invoke-direct {v9}, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;-><init>()V

    invoke-static {v9}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v9

    const/4 v10, 0x0

    invoke-interface {v9, p1, v10}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 93
    .local v2, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    invoke-virtual {v8, v2}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->setResultsDesc(Ljava/util/List;)V

    .line 95
    .end local v2    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    :cond_9
    return-object v8
.end method

.method public bridge synthetic decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/io/DataInputStream;
    .param p2, "x1"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 17
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/AdvSearchResultsDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    move-result-object v0

    return-object v0
.end method
