.class public Lcom/amazon/retailsearch/data/search/ResultStream;
.super Ljava/lang/Object;
.source "ResultStream.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/data/search/ResultStream$Status;
    }
.end annotation


# instance fields
.field private final content:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/search/ResultEvent;",
            ">;"
        }
    .end annotation
.end field

.field private final listeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/retailsearch/data/search/ResultStreamListener;",
            ">;"
        }
    .end annotation
.end field

.field private pageCount:I

.field private status:Lcom/amazon/retailsearch/data/search/ResultStream$Status;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    sget-object v0, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->None:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    iput-object v0, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->status:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    .line 16
    new-instance v0, Ljava/util/ArrayList;

    const/16 v1, 0x20

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->content:Ljava/util/List;

    .line 17
    new-instance v0, Ljava/util/LinkedHashSet;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Ljava/util/LinkedHashSet;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->listeners:Ljava/util/Set;

    .line 18
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->pageCount:I

    .line 81
    return-void
.end method


# virtual methods
.method public addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V
    .locals 1
    .param p1, "item"    # Lcom/amazon/retailsearch/data/search/ResultEvent;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->content:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 46
    invoke-virtual {p0}, Lcom/amazon/retailsearch/data/search/ResultStream;->getListeners()Ljava/lang/Iterable;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/amazon/retailsearch/data/search/ResultEvent;->send(Ljava/lang/Iterable;)V

    .line 47
    return-void
.end method

.method public attach(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/data/search/ResultStreamListener;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->listeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 63
    return-void
.end method

.method public close()V
    .locals 1

    .prologue
    .line 74
    sget-object v0, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->None:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    iput-object v0, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->status:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    .line 75
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->content:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 76
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->listeners:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 77
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->pageCount:I

    .line 78
    return-void
.end method

.method public detach(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/data/search/ResultStreamListener;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->listeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 67
    return-void
.end method

.method protected getContent()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/search/ResultEvent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->content:Ljava/util/List;

    return-object v0
.end method

.method protected getListeners()Ljava/lang/Iterable;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Iterable",
            "<",
            "Lcom/amazon/retailsearch/data/search/ResultStreamListener;",
            ">;"
        }
    .end annotation

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->listeners:Ljava/util/Set;

    const/4 v1, 0x0

    new-array v1, v1, [Lcom/amazon/retailsearch/data/search/ResultStreamListener;

    invoke-interface {v0, v1}, Ljava/util/Set;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getPageCount()I
    .locals 1

    .prologue
    .line 37
    iget v0, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->pageCount:I

    return v0
.end method

.method public getStatus()Lcom/amazon/retailsearch/data/search/ResultStream$Status;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->status:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    return-object v0
.end method

.method public read(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V
    .locals 3
    .param p1, "listener"    # Lcom/amazon/retailsearch/data/search/ResultStreamListener;

    .prologue
    .line 50
    iget-object v2, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->listeners:Ljava/util/Set;

    invoke-interface {v2, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 59
    :goto_0
    return-void

    .line 54
    :cond_0
    iget-object v2, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->content:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/data/search/ResultEvent;

    .line 55
    .local v1, "item":Lcom/amazon/retailsearch/data/search/ResultEvent;
    invoke-virtual {v1, p1}, Lcom/amazon/retailsearch/data/search/ResultEvent;->send(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V

    goto :goto_1

    .line 58
    .end local v1    # "item":Lcom/amazon/retailsearch/data/search/ResultEvent;
    :cond_1
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/data/search/ResultStream;->attach(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V

    goto :goto_0
.end method

.method protected setPageCount(I)V
    .locals 0
    .param p1, "pageCount"    # I

    .prologue
    .line 41
    iput p1, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->pageCount:I

    .line 42
    return-void
.end method

.method protected setStatus(Lcom/amazon/retailsearch/data/search/ResultStream$Status;)V
    .locals 0
    .param p1, "status"    # Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/amazon/retailsearch/data/search/ResultStream;->status:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    .line 26
    return-void
.end method
