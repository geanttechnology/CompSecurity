.class public Lcom/amazon/retailsearch/data/EmptySearchTask;
.super Ljava/lang/Object;
.source "EmptySearchTask.java"

# interfaces
.implements Lcom/amazon/retailsearch/data/SearchTask;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public addListener(Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;

    .prologue
    .line 30
    return-void
.end method

.method public close()V
    .locals 0

    .prologue
    .line 53
    return-void
.end method

.method public getStatus()Lcom/amazon/retailsearch/data/search/ResultStream$Status;
    .locals 1

    .prologue
    .line 41
    sget-object v0, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->None:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    return-object v0
.end method

.method public isLoading()Z
    .locals 1

    .prologue
    .line 47
    const/4 v0, 0x0

    return v0
.end method

.method public loadNext()V
    .locals 0

    .prologue
    .line 15
    return-void
.end method

.method public loadNext(I)V
    .locals 0
    .param p1, "count"    # I

    .prologue
    .line 20
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;)Z
    .locals 1
    .param p1, "observer"    # Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;

    .prologue
    .line 35
    const/4 v0, 0x1

    return v0
.end method

.method public retry()V
    .locals 0

    .prologue
    .line 25
    return-void
.end method
