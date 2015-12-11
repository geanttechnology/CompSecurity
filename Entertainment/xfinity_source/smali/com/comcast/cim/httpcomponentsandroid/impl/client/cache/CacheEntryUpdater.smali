.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;
.super Ljava/lang/Object;
.source "CacheEntryUpdater.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final resourceFactory:Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 61
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HeapResourceFactory;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/HeapResourceFactory;-><init>()V

    invoke-direct {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;)V

    .line 62
    return-void
.end method

.method constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;)V
    .locals 0
    .param p1, "resourceFactory"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;->resourceFactory:Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;

    .line 67
    return-void
.end method

.method private entryAndResponseHaveDateHeader(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z
    .locals 1
    .param p1, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 165
    const-string v0, "Date"

    invoke-virtual {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    if-eqz v0, :cond_0

    const-string v0, "Date"

    invoke-interface {p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 167
    const/4 v0, 0x1

    .line 170
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private entryDateHeaderNewerThenResponse(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z
    .locals 5
    .param p1, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    const/4 v3, 0x0

    .line 149
    :try_start_0
    const-string v4, "Date"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->parseDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 151
    .local v1, "entryDate":Ljava/util/Date;
    const-string v4, "Date"

    invoke-interface {p2, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateUtils;->parseDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    .line 154
    .local v2, "responseDate":Ljava/util/Date;
    invoke-virtual {v1, v2}, Ljava/util/Date;->after(Ljava/util/Date;)Z
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    if-nez v4, :cond_0

    .line 161
    .end local v1    # "entryDate":Ljava/util/Date;
    .end local v2    # "responseDate":Ljava/util/Date;
    :goto_0
    return v3

    .line 157
    :catch_0
    move-exception v0

    .line 158
    .local v0, "e":Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException;
    goto :goto_0

    .line 161
    .end local v0    # "e":Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/DateParseException;
    .restart local v1    # "entryDate":Ljava/util/Date;
    .restart local v2    # "responseDate":Ljava/util/Date;
    :cond_0
    const/4 v3, 0x1

    goto :goto_0
.end method

.method private removeCacheEntry1xxWarnings(Ljava/util/List;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V
    .locals 8
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/Header;",
            ">;",
            "Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;",
            ")V"
        }
    .end annotation

    .prologue
    .line 132
    .local p1, "cacheEntryHeaderList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    invoke-interface {p1}, Ljava/util/List;->listIterator()Ljava/util/ListIterator;

    move-result-object v1

    .line 134
    .local v1, "cacheEntryHeaderListIter":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/ListIterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 135
    invoke-interface {v1}, Ljava/util/ListIterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/comcast/cim/httpcomponentsandroid/Header;

    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v2

    .line 137
    .local v2, "cacheEntryHeaderName":Ljava/lang/String;
    const-string v6, "Warning"

    invoke-virtual {v6, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 138
    const-string v6, "Warning"

    invoke-virtual {p2, v6}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_0

    aget-object v3, v0, v4

    .line 139
    .local v3, "cacheEntryWarning":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v6

    const-string v7, "1"

    invoke-virtual {v6, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 140
    invoke-interface {v1}, Ljava/util/ListIterator;->remove()V

    .line 138
    :cond_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 145
    .end local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v2    # "cacheEntryHeaderName":Ljava/lang/String;
    .end local v3    # "cacheEntryWarning":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    :cond_2
    return-void
.end method

.method private removeCacheHeadersThatMatchResponse(Ljava/util/List;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 7
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/Header;",
            ">;",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;",
            ")V"
        }
    .end annotation

    .prologue
    .line 118
    .local p1, "cacheEntryHeaderList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_2

    aget-object v5, v0, v3

    .line 119
    .local v5, "responseHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {p1}, Ljava/util/List;->listIterator()Ljava/util/ListIterator;

    move-result-object v1

    .line 121
    .local v1, "cacheEntryHeaderListIter":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    :cond_0
    :goto_1
    invoke-interface {v1}, Ljava/util/ListIterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 122
    invoke-interface {v1}, Ljava/util/ListIterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/comcast/cim/httpcomponentsandroid/Header;

    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v2

    .line 124
    .local v2, "cacheEntryHeaderName":Ljava/lang/String;
    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 125
    invoke-interface {v1}, Ljava/util/ListIterator;->remove()V

    goto :goto_1

    .line 118
    .end local v2    # "cacheEntryHeaderName":Ljava/lang/String;
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 129
    .end local v1    # "cacheEntryHeaderListIter":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    .end local v5    # "responseHeader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_2
    return-void
.end method


# virtual methods
.method protected mergeHeaders(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 2
    .param p1, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 101
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;->entryAndResponseHaveDateHeader(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;->entryDateHeaderNewerThenResponse(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 104
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 113
    :goto_0
    return-object v1

    .line 107
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 109
    .local v0, "cacheEntryHeaderList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    invoke-direct {p0, v0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;->removeCacheHeadersThatMatchResponse(Ljava/util/List;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 110
    invoke-direct {p0, v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;->removeCacheEntry1xxWarnings(Ljava/util/List;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V

    .line 111
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 113
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    new-array v1, v1, [Lcom/comcast/cim/httpcomponentsandroid/Header;

    invoke-interface {v0, v1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lcom/comcast/cim/httpcomponentsandroid/Header;

    goto :goto_0
.end method

.method public updateCacheEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/util/Date;Ljava/util/Date;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .locals 6
    .param p1, "requestId"    # Ljava/lang/String;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p3, "requestDate"    # Ljava/util/Date;
    .param p4, "responseDate"    # Ljava/util/Date;
    .param p5, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 87
    invoke-interface {p5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v0

    const/16 v1, 0x130

    if-eq v0, v1, :cond_0

    .line 88
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Response must have 304 status code"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 89
    :cond_0
    invoke-virtual {p0, p2, p5}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;->mergeHeaders(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v4

    .line 90
    .local v4, "mergedHeaders":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntryUpdater;->resourceFactory:Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;

    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getResource()Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;->copy(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v5

    .line 91
    .local v5, "resource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v3

    move-object v1, p3

    move-object v2, p4

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;-><init>(Ljava/util/Date;Ljava/util/Date;Lcom/comcast/cim/httpcomponentsandroid/StatusLine;[Lcom/comcast/cim/httpcomponentsandroid/Header;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)V

    return-object v0
.end method
